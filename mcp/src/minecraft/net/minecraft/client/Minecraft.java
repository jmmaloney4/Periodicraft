package net.minecraft.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.relauncher.ArgsWrapper;
import cpw.mods.fml.relauncher.FMLRelauncher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import net.minecraft.block.Block;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSleepMP;
import net.minecraft.client.gui.LoadingScreenRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.CallableParticleScreenName;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.texturepacks.TexturePackList;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.logging.LogAgent;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.MemoryConnection;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.profiler.ProfilerResult;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.EnumOS;
import net.minecraft.util.HttpUtil;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MinecraftError;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.Session;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import net.minecraft.util.ThreadDownloadResources;
import net.minecraft.util.Timer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

import com.google.common.collect.MapDifference;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

@SideOnly(Side.CLIENT)
public abstract class Minecraft implements Runnable, IPlayerUsage
{
    /** A 10MiB preallocation to ensure the heap is reasonably sized. */
    public static byte[] memoryReserve = new byte[10485760];
    private final ILogAgent field_94139_O = new LogAgent("Minecraft-Client", " [CLIENT]", (new File(getMinecraftDir(), "output-client.log")).getAbsolutePath());
    private ServerData currentServerData;

    /**
     * Set to 'this' in Minecraft constructor; used by some settings get methods
     */
    private static Minecraft theMinecraft;
    public PlayerControllerMP playerController;
    private boolean fullscreen = false;
    private boolean hasCrashed = false;

    /** Instance of CrashReport. */
    private CrashReport crashReporter;
    public int displayWidth;
    public int displayHeight;
    private Timer timer = new Timer(20.0F);

    /** Instance of PlayerUsageSnooper. */
    private PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("client", this);
    public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    public EntityClientPlayerMP thePlayer;

    /**
     * The Entity from which the renderer determines the render viewpoint. Currently is always the parent Minecraft
     * class's 'thePlayer' instance. Modification of its location, rotation, or other settings at render time will
     * modify the camera likewise, with the caveat of triggering chunk rebuilds as it moves, making it unsuitable for
     * changing the viewpoint mid-render.
     */
    public EntityLiving renderViewEntity;
    public EntityLiving pointedEntityLiving;
    public EffectRenderer effectRenderer;
    public Session session = null;
    public String minecraftUri;
    public Canvas mcCanvas;

    /** a boolean to hide a Quit button from the main menu */
    public boolean hideQuitButton = false;
    public volatile boolean isGamePaused = false;

    /** The RenderEngine instance used by Minecraft */
    public RenderEngine renderEngine;

    /** The font renderer used for displaying and measuring text. */
    public FontRenderer fontRenderer;
    public FontRenderer standardGalacticFontRenderer;

    /** The GuiScreen that's being displayed at the moment. */
    public GuiScreen currentScreen = null;
    public LoadingScreenRenderer loadingScreen;
    public EntityRenderer entityRenderer;

    /** Reference to the download resources thread. */
    private ThreadDownloadResources downloadResourcesThread;

    /** Mouse left click counter */
    private int leftClickCounter = 0;

    /** Display width */
    private int tempDisplayWidth;

    /** Display height */
    private int tempDisplayHeight;

    /** Instance of IntegratedServer. */
    private IntegratedServer theIntegratedServer;

    /** Gui achievement */
    public GuiAchievement guiAchievement;
    public GuiIngame ingameGUI;

    /** Skip render world */
    public boolean skipRenderWorld = false;

    /** The ray trace hit that the mouse is over. */
    public MovingObjectPosition objectMouseOver = null;

    /** The game settings that currently hold effect. */
    public GameSettings gameSettings;
    protected MinecraftApplet mcApplet;
    public SoundManager sndManager = new SoundManager();

    /** Mouse helper instance. */
    public MouseHelper mouseHelper;

    /** The TexturePackLister used by this instance of Minecraft... */
    public TexturePackList texturePackList;
    public File mcDataDir;
    private ISaveFormat saveLoader;

    /**
     * This is set to fpsCounter every debug screen update, and is shown on the debug screen. It's also sent as part of
     * the usage snooping.
     */
    private static int debugFPS;

    /**
     * When you place a block, it's set to 6, decremented once per tick, when it's 0, you can place another block.
     */
    private int rightClickDelayTimer = 0;

    /**
     * Checked in Minecraft's while(running) loop, if true it's set to false and the textures refreshed.
     */
    private boolean refreshTexturePacksScheduled;

    /** Stat file writer */
    public StatFileWriter statFileWriter;
    private String serverName;
    private int serverPort;

    /**
     * Makes sure it doesn't keep taking screenshots when both buttons are down.
     */
    boolean isTakingScreenshot = false;

    /**
     * Does the actual gameplay have focus. If so then mouse and keys will effect the player instead of menus.
     */
    public boolean inGameHasFocus = false;
    long systemTime = getSystemTime();

    /** Join player counter */
    private int joinPlayerCounter = 0;
    private boolean isDemo;
    private INetworkManager myNetworkManager;
    private boolean integratedServerIsRunning;

    /** The profiler instance */
    public final Profiler mcProfiler = new Profiler();
    private long field_83002_am = -1L;

    /** The working dir (OS specific) for minecraft */
    private static File minecraftDir = null;

    /**
     * Set to true to keep the game loop running. Set to false by shutdown() to allow the game loop to exit cleanly.
     */
    public volatile boolean running = true;

    /** String that shows the debug information */
    public String debug = "";

    /** Approximate time (in ms) of last update to debug string */
    long debugUpdateTime = getSystemTime();

    /** holds the current fps */
    int fpsCounter = 0;
    long prevFrameTime = -1L;

    /** Profiler currently displayed in the debug screen pie chart */
    private String debugProfilerName = "root";

    public Minecraft(Canvas par1Canvas, MinecraftApplet par2MinecraftApplet, int par3, int par4, boolean par5)
    {
        StatList.nopInit();
        this.tempDisplayHeight = par4;
        this.fullscreen = par5;
        this.mcApplet = par2MinecraftApplet;
        Packet3Chat.maxChatLength = 32767;
        this.startTimerHackThread();
        this.mcCanvas = par1Canvas;
        this.displayWidth = par3;
        this.displayHeight = par4;
        this.fullscreen = par5;
        theMinecraft = this;
        TextureManager.init();
        this.guiAchievement = new GuiAchievement(this);
    }

    private void startTimerHackThread()
    {
        ThreadClientSleep threadclientsleep = new ThreadClientSleep(this, "Timer hack thread");
        threadclientsleep.setDaemon(true);
        threadclientsleep.start();
    }

    public void crashed(CrashReport par1CrashReport)
    {
        this.hasCrashed = true;
        this.crashReporter = par1CrashReport;
    }

    /**
     * Wrapper around displayCrashReportInternal
     */
    public void displayCrashReport(CrashReport par1CrashReport)
    {
        this.hasCrashed = true;
        this.displayCrashReportInternal(par1CrashReport);
    }

    public abstract void displayCrashReportInternal(CrashReport crashreport);

    public void setServer(String par1Str, int par2)
    {
        this.serverName = par1Str;
        this.serverPort = par2;
    }

    /**
     * Starts the game: initializes the canvas, the title, the settings, etcetera.
     */
    public void startGame() throws LWJGLException
    {
        if (this.mcCanvas != null)
        {
            Graphics graphics = this.mcCanvas.getGraphics();

            if (graphics != null)
            {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(0, 0, this.displayWidth, this.displayHeight);
                graphics.dispose();
            }

            Display.setParent(this.mcCanvas);
        }
        else if (this.fullscreen)
        {
            Display.setFullscreen(true);
            this.displayWidth = Display.getDisplayMode().getWidth();
            this.displayHeight = Display.getDisplayMode().getHeight();

            if (this.displayWidth <= 0)
            {
                this.displayWidth = 1;
            }

            if (this.displayHeight <= 0)
            {
                this.displayHeight = 1;
            }
        }
        else
        {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }

        Display.setTitle("Minecraft Minecraft 1.5.1");
        this.getLogAgent().logInfo("LWJGL Version: " + Sys.getVersion());

        try
        {
            Display.create((new PixelFormat()).withDepthBits(24));
        }
        catch (LWJGLException lwjglexception)
        {
            lwjglexception.printStackTrace();

            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception)
            {
                ;
            }

            Display.create();
        }

        OpenGlHelper.initializeTextures();
        this.mcDataDir = getMinecraftDir();
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"));
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.texturePackList = new TexturePackList(this.mcDataDir, this);
        this.renderEngine = new RenderEngine(this.texturePackList, this.gameSettings);
        this.loadScreen();
        this.fontRenderer = new FontRenderer(this.gameSettings, "/font/default.png", this.renderEngine, false);
        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, "/font/alternate.png", this.renderEngine, false);

        FMLClientHandler.instance().beginMinecraftLoading(this);

        if (this.gameSettings.language != null)
        {
            StringTranslate.getInstance().setLanguage(this.gameSettings.language, false);
            this.fontRenderer.setUnicodeFlag(StringTranslate.getInstance().isUnicode());
            this.fontRenderer.setBidiFlag(StringTranslate.isBidirectional(this.gameSettings.language));
        }

        ColorizerGrass.setGrassBiomeColorizer(this.renderEngine.getTextureContents("/misc/grasscolor.png"));
        ColorizerFoliage.setFoliageBiomeColorizer(this.renderEngine.getTextureContents("/misc/foliagecolor.png"));
        this.entityRenderer = new EntityRenderer(this);
        RenderManager.instance.itemRenderer = new ItemRenderer(this);
        this.statFileWriter = new StatFileWriter(this.session, this.mcDataDir);
        AchievementList.openInventory.setStatStringFormatter(new StatStringFormatKeyInv(this));
        this.loadScreen();
        Mouse.create();
        this.mouseHelper = new MouseHelper(this.mcCanvas, this.gameSettings);
        this.checkGLError("Pre startup");
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.checkGLError("Startup");
        this.sndManager.loadSoundSettings(this.gameSettings);
        this.renderGlobal = new RenderGlobal(this, this.renderEngine);
        this.renderEngine.refreshTextureMaps();
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new EffectRenderer(this.theWorld, this.renderEngine);

        FMLClientHandler.instance().finishMinecraftLoading();

        try
        {
            this.downloadResourcesThread = new ThreadDownloadResources(this.mcDataDir, this);
            this.downloadResourcesThread.start();
        }
        catch (Exception exception)
        {
            ;
        }

        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);

        if (this.serverName != null)
        {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        }
        else
        {
            this.displayGuiScreen(new GuiMainMenu());
        }

        this.loadingScreen = new LoadingScreenRenderer(this);

        if (this.gameSettings.fullScreen && !this.fullscreen)
        {
            this.toggleFullscreen();
        }

        FMLClientHandler.instance().onInitializationComplete();
    }

    /**
     * Displays a new screen.
     */
    private void loadScreen() throws LWJGLException
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.gameSettings, this.displayWidth, this.displayHeight);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.instance;
        this.renderEngine.bindTexture("/title/mojang.png");
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(16777215);
        tessellator.addVertexWithUV(0.0D, (double)this.displayHeight, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV((double)this.displayWidth, (double)this.displayHeight, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV((double)this.displayWidth, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.setColorOpaque_I(16777215);
        short short1 = 256;
        short short2 = 256;
        this.scaledTessellator((scaledresolution.getScaledWidth() - short1) / 2, (scaledresolution.getScaledHeight() - short2) / 2, 0, 0, short1, short2);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        Display.swapBuffers();
    }

    /**
     * Loads Tessellator with a scaled resolution
     */
    public void scaledTessellator(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), 0.0D, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), 0.0D, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), 0.0D, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), 0.0D, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }

    /**
     * gets the working dir (OS specific) for minecraft
     */
    public static File getMinecraftDir()
    {
        if (minecraftDir == null)
        {
            minecraftDir = getAppDir("minecraft");
        }

        return minecraftDir;
    }

    /**
     * gets the working dir (OS specific) for the specific application (which is always minecraft)
     */
    public static File getAppDir(String par0Str)
    {
        String s1 = System.getProperty("user.home", ".");
        File file1;

        switch (EnumOSHelper.field_90049_a[getOs().ordinal()])
        {
            case 1:
            case 2:
                file1 = new File(s1, '.' + par0Str + '/');
                break;
            case 3:
                String s2 = System.getenv("APPDATA");

                if (s2 != null)
                {
                    file1 = new File(s2, "." + par0Str + '/');
                }
                else
                {
                    file1 = new File(s1, '.' + par0Str + '/');
                }

                break;
            case 4:
                file1 = new File(s1, "Library/Application Support/" + par0Str);
                break;
            default:
                file1 = new File(s1, par0Str + '/');
        }

        if (!file1.exists() && !file1.mkdirs())
        {
            throw new RuntimeException("The working directory could not be created: " + file1);
        }
        else
        {
            return file1;
        }
    }

    public static EnumOS getOs()
    {
        String s = System.getProperty("os.name").toLowerCase();
        return s.contains("win") ? EnumOS.WINDOWS : (s.contains("mac") ? EnumOS.MACOS : (s.contains("solaris") ? EnumOS.SOLARIS : (s.contains("sunos") ? EnumOS.SOLARIS : (s.contains("linux") ? EnumOS.LINUX : (s.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
    }

    /**
     * Returns the save loader that is currently being used
     */
    public ISaveFormat getSaveLoader()
    {
        return this.saveLoader;
    }

    /**
     * Sets the argument GuiScreen as the main (topmost visible) screen.
     */
    public void displayGuiScreen(GuiScreen par1GuiScreen)
    {
        if (this.currentScreen != null)
        {
            this.currentScreen.onGuiClosed();
        }

        this.statFileWriter.syncStats();

        if (par1GuiScreen == null && this.theWorld == null)
        {
            par1GuiScreen = new GuiMainMenu();
        }
        else if (par1GuiScreen == null && this.thePlayer.getHealth() <= 0)
        {
            par1GuiScreen = new GuiGameOver();
        }

        if (par1GuiScreen instanceof GuiMainMenu)
        {
            this.gameSettings.showDebugInfo = false;
            this.ingameGUI.getChatGUI().clearChatMessages();
        }

        this.currentScreen = (GuiScreen)par1GuiScreen;

        if (par1GuiScreen != null)
        {
            this.setIngameNotInFocus();
            ScaledResolution scaledresolution = new ScaledResolution(this.gameSettings, this.displayWidth, this.displayHeight);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            ((GuiScreen)par1GuiScreen).setWorldAndResolution(this, i, j);
            this.skipRenderWorld = false;
        }
        else
        {
            this.setIngameFocus();
        }
    }

    /**
     * Checks for an OpenGL error. If there is one, prints the error ID and error string.
     */
    private void checkGLError(String par1Str)
    {
        int i = GL11.glGetError();

        if (i != 0)
        {
            String s1 = GLU.gluErrorString(i);
            this.getLogAgent().logSevere("########## GL ERROR ##########");
            this.getLogAgent().logSevere("@ " + par1Str);
            this.getLogAgent().logSevere(i + ": " + s1);
        }
    }

    /**
     * Shuts down the minecraft applet by stopping the resource downloads, and clearing up GL stuff; called when the
     * application (or web page) is exited.
     */
    public void shutdownMinecraftApplet()
    {
        try
        {
            this.statFileWriter.syncStats();

            try
            {
                if (this.downloadResourcesThread != null)
                {
                    this.downloadResourcesThread.closeMinecraft();
                }
            }
            catch (Exception exception)
            {
                ;
            }

            this.getLogAgent().logInfo("Stopping!");

            try
            {
                this.loadWorld((WorldClient)null);
            }
            catch (Throwable throwable)
            {
                ;
            }

            try
            {
                GLAllocation.deleteTexturesAndDisplayLists();
            }
            catch (Throwable throwable1)
            {
                ;
            }

            this.sndManager.closeMinecraft();
            Mouse.destroy();
            Keyboard.destroy();
        }
        finally
        {
            Display.destroy();

            if (!this.hasCrashed)
            {
                System.exit(0);
            }
        }

        System.gc();
    }

    public void run()
    {
        this.running = true;

        try
        {
            this.startGame();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(new CrashReport("Failed to start game", exception)));
            return;
        }

        try
        {
            while (this.running)
            {
                if (this.hasCrashed && this.crashReporter != null)
                {
                    this.displayCrashReport(this.crashReporter);
                    return;
                }

                if (this.refreshTexturePacksScheduled)
                {
                    this.refreshTexturePacksScheduled = false;
                    this.renderEngine.refreshTextures();
                }

                try
                {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            }
        }
        catch (MinecraftError minecrafterror)
        {
            ;
        }
        catch (ReportedException reportedexception)
        {
            this.addGraphicsAndWorldToCrashReport(reportedexception.getCrashReport());
            this.freeMemory();
            reportedexception.printStackTrace();
            this.displayCrashReport(reportedexception.getCrashReport());
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", throwable));
            this.freeMemory();
            throwable.printStackTrace();
            this.displayCrashReport(crashreport);
        }
        finally
        {
            this.shutdownMinecraftApplet();
        }
    }

    /**
     * Called repeatedly from run()
     */
    private void runGameLoop()
    {
        if (this.mcApplet != null && !this.mcApplet.isActive())
        {
            this.running = false;
        }
        else
        {
            AxisAlignedBB.getAABBPool().cleanPool();

            if (this.theWorld != null)
            {
                this.theWorld.getWorldVec3Pool().clear();
            }

            this.mcProfiler.startSection("root");

            if (this.mcCanvas == null && Display.isCloseRequested())
            {
                this.shutdown();
            }

            if (this.isGamePaused && this.theWorld != null)
            {
                float f = this.timer.renderPartialTicks;
                this.timer.updateTimer();
                this.timer.renderPartialTicks = f;
            }
            else
            {
                this.timer.updateTimer();
            }

            long i = System.nanoTime();
            this.mcProfiler.startSection("tick");

            for (int j = 0; j < this.timer.elapsedTicks; ++j)
            {
                this.runTick();
            }

            this.mcProfiler.endStartSection("preRenderErrors");
            long k = System.nanoTime() - i;
            this.checkGLError("Pre render");
            RenderBlocks.fancyGrass = this.gameSettings.fancyGraphics;
            this.mcProfiler.endStartSection("sound");
            this.sndManager.setListener(this.thePlayer, this.timer.renderPartialTicks);

            if (!this.isGamePaused)
            {
                this.sndManager.func_92071_g();
            }

            this.mcProfiler.endSection();
            this.mcProfiler.startSection("render");
            this.mcProfiler.startSection("display");
            GL11.glEnable(GL11.GL_TEXTURE_2D);

            if (!Keyboard.isKeyDown(65))
            {
                Display.update();
            }

            if (this.thePlayer != null && this.thePlayer.isEntityInsideOpaqueBlock())
            {
                this.gameSettings.thirdPersonView = 0;
            }

            this.mcProfiler.endSection();

            if (!this.skipRenderWorld)
            {
                FMLCommonHandler.instance().onRenderTickStart(this.timer.renderPartialTicks);
                this.mcProfiler.endStartSection("gameRenderer");
                this.entityRenderer.updateCameraAndRender(this.timer.renderPartialTicks);
                this.mcProfiler.endSection();
                FMLCommonHandler.instance().onRenderTickEnd(this.timer.renderPartialTicks);
            }

            GL11.glFlush();
            this.mcProfiler.endSection();

            if (!Display.isActive() && this.fullscreen)
            {
                this.toggleFullscreen();
            }

            if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart)
            {
                if (!this.mcProfiler.profilingEnabled)
                {
                    this.mcProfiler.clearProfiling();
                }

                this.mcProfiler.profilingEnabled = true;
                this.displayDebugInfo(k);
            }
            else
            {
                this.mcProfiler.profilingEnabled = false;
                this.prevFrameTime = System.nanoTime();
            }

            this.guiAchievement.updateAchievementWindow();
            this.mcProfiler.startSection("root");
            Thread.yield();

            if (Keyboard.isKeyDown(65))
            {
                Display.update();
            }

            this.screenshotListener();

            if (this.mcCanvas != null && !this.fullscreen && (this.mcCanvas.getWidth() != this.displayWidth || this.mcCanvas.getHeight() != this.displayHeight))
            {
                this.displayWidth = this.mcCanvas.getWidth();
                this.displayHeight = this.mcCanvas.getHeight();

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }

                this.resize(this.displayWidth, this.displayHeight);
            }

            this.checkGLError("Post render");
            ++this.fpsCounter;
            boolean flag = this.isGamePaused;
            this.isGamePaused = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic();

            if (this.isIntegratedServerRunning() && this.thePlayer != null && this.thePlayer.sendQueue != null && this.isGamePaused != flag)
            {
                ((MemoryConnection)this.thePlayer.sendQueue.getNetManager()).setGamePaused(this.isGamePaused);
            }

            while (getSystemTime() >= this.debugUpdateTime + 1000L)
            {
                debugFPS = this.fpsCounter;
                this.debug = debugFPS + " fps, " + WorldRenderer.chunksUpdated + " chunk updates";
                WorldRenderer.chunksUpdated = 0;
                this.debugUpdateTime += 1000L;
                this.fpsCounter = 0;
                this.usageSnooper.addMemoryStatsToSnooper();

                if (!this.usageSnooper.isSnooperRunning())
                {
                    this.usageSnooper.startSnooper();
                }
            }

            this.mcProfiler.endSection();

            if (this.func_90020_K() > 0)
            {
                Display.sync(EntityRenderer.performanceToFps(this.func_90020_K()));
            }
        }
    }

    private int func_90020_K()
    {
        return this.currentScreen != null && this.currentScreen instanceof GuiMainMenu ? 2 : this.gameSettings.limitFramerate;
    }

    public void freeMemory()
    {
        try
        {
            memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable throwable)
        {
            ;
        }

        try
        {
            System.gc();
            AxisAlignedBB.getAABBPool().clearPool();
            this.theWorld.getWorldVec3Pool().clearAndFreeCache();
        }
        catch (Throwable throwable1)
        {
            ;
        }

        try
        {
            System.gc();
            this.loadWorld((WorldClient)null);
        }
        catch (Throwable throwable2)
        {
            ;
        }

        System.gc();
    }

    /**
     * checks if keys are down
     */
    private void screenshotListener()
    {
        if (Keyboard.isKeyDown(60))
        {
            if (!this.isTakingScreenshot)
            {
                this.isTakingScreenshot = true;
                this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(minecraftDir, this.displayWidth, this.displayHeight));
            }
        }
        else
        {
            this.isTakingScreenshot = false;
        }
    }

    /**
     * Update debugProfilerName in response to number keys in debug screen
     */
    private void updateDebugProfilerName(int par1)
    {
        List list = this.mcProfiler.getProfilingData(this.debugProfilerName);

        if (list != null && !list.isEmpty())
        {
            ProfilerResult profilerresult = (ProfilerResult)list.remove(0);

            if (par1 == 0)
            {
                if (profilerresult.field_76331_c.length() > 0)
                {
                    int j = this.debugProfilerName.lastIndexOf(".");

                    if (j >= 0)
                    {
                        this.debugProfilerName = this.debugProfilerName.substring(0, j);
                    }
                }
            }
            else
            {
                --par1;

                if (par1 < list.size() && !((ProfilerResult)list.get(par1)).field_76331_c.equals("unspecified"))
                {
                    if (this.debugProfilerName.length() > 0)
                    {
                        this.debugProfilerName = this.debugProfilerName + ".";
                    }

                    this.debugProfilerName = this.debugProfilerName + ((ProfilerResult)list.get(par1)).field_76331_c;
                }
            }
        }
    }

    private void displayDebugInfo(long par1)
    {
        if (this.mcProfiler.profilingEnabled)
        {
            List list = this.mcProfiler.getProfilingData(this.debugProfilerName);
            ProfilerResult profilerresult = (ProfilerResult)list.remove(0);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, (double)this.displayWidth, (double)this.displayHeight, 0.0D, 1000.0D, 3000.0D);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
            GL11.glLineWidth(1.0F);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            Tessellator tessellator = Tessellator.instance;
            short short1 = 160;
            int j = this.displayWidth - short1 - 10;
            int k = this.displayHeight - short1 * 2;
            GL11.glEnable(GL11.GL_BLEND);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0, 200);
            tessellator.addVertex((double)((float)j - (float)short1 * 1.1F), (double)((float)k - (float)short1 * 0.6F - 16.0F), 0.0D);
            tessellator.addVertex((double)((float)j - (float)short1 * 1.1F), (double)(k + short1 * 2), 0.0D);
            tessellator.addVertex((double)((float)j + (float)short1 * 1.1F), (double)(k + short1 * 2), 0.0D);
            tessellator.addVertex((double)((float)j + (float)short1 * 1.1F), (double)((float)k - (float)short1 * 0.6F - 16.0F), 0.0D);
            tessellator.draw();
            GL11.glDisable(GL11.GL_BLEND);
            double d0 = 0.0D;
            int l;

            for (int i1 = 0; i1 < list.size(); ++i1)
            {
                ProfilerResult profilerresult1 = (ProfilerResult)list.get(i1);
                l = MathHelper.floor_double(profilerresult1.field_76332_a / 4.0D) + 1;
                tessellator.startDrawing(6);
                tessellator.setColorOpaque_I(profilerresult1.func_76329_a());
                tessellator.addVertex((double)j, (double)k, 0.0D);
                int j1;
                float f;
                float f1;
                float f2;

                for (j1 = l; j1 >= 0; --j1)
                {
                    f = (float)((d0 + profilerresult1.field_76332_a * (double)j1 / (double)l) * Math.PI * 2.0D / 100.0D);
                    f2 = MathHelper.sin(f) * (float)short1;
                    f1 = MathHelper.cos(f) * (float)short1 * 0.5F;
                    tessellator.addVertex((double)((float)j + f2), (double)((float)k - f1), 0.0D);
                }

                tessellator.draw();
                tessellator.startDrawing(5);
                tessellator.setColorOpaque_I((profilerresult1.func_76329_a() & 16711422) >> 1);

                for (j1 = l; j1 >= 0; --j1)
                {
                    f = (float)((d0 + profilerresult1.field_76332_a * (double)j1 / (double)l) * Math.PI * 2.0D / 100.0D);
                    f2 = MathHelper.sin(f) * (float)short1;
                    f1 = MathHelper.cos(f) * (float)short1 * 0.5F;
                    tessellator.addVertex((double)((float)j + f2), (double)((float)k - f1), 0.0D);
                    tessellator.addVertex((double)((float)j + f2), (double)((float)k - f1 + 10.0F), 0.0D);
                }

                tessellator.draw();
                d0 += profilerresult1.field_76332_a;
            }

            DecimalFormat decimalformat = new DecimalFormat("##0.00");
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            String s = "";

            if (!profilerresult.field_76331_c.equals("unspecified"))
            {
                s = s + "[0] ";
            }

            if (profilerresult.field_76331_c.length() == 0)
            {
                s = s + "ROOT ";
            }
            else
            {
                s = s + profilerresult.field_76331_c + " ";
            }

            l = 16777215;
            this.fontRenderer.drawStringWithShadow(s, j - short1, k - short1 / 2 - 16, l);
            this.fontRenderer.drawStringWithShadow(s = decimalformat.format(profilerresult.field_76330_b) + "%", j + short1 - this.fontRenderer.getStringWidth(s), k - short1 / 2 - 16, l);

            for (int k1 = 0; k1 < list.size(); ++k1)
            {
                ProfilerResult profilerresult2 = (ProfilerResult)list.get(k1);
                String s1 = "";

                if (profilerresult2.field_76331_c.equals("unspecified"))
                {
                    s1 = s1 + "[?] ";
                }
                else
                {
                    s1 = s1 + "[" + (k1 + 1) + "] ";
                }

                s1 = s1 + profilerresult2.field_76331_c;
                this.fontRenderer.drawStringWithShadow(s1, j - short1, k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
                this.fontRenderer.drawStringWithShadow(s1 = decimalformat.format(profilerresult2.field_76332_a) + "%", j + short1 - 50 - this.fontRenderer.getStringWidth(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
                this.fontRenderer.drawStringWithShadow(s1 = decimalformat.format(profilerresult2.field_76330_b) + "%", j + short1 - this.fontRenderer.getStringWidth(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
            }
        }
    }

    /**
     * Called when the window is closing. Sets 'running' to false which allows the game loop to exit cleanly.
     */
    public void shutdown()
    {
        this.running = false;
    }

    /**
     * Will set the focus to ingame if the Minecraft window is the active with focus. Also clears any GUI screen
     * currently displayed
     */
    public void setIngameFocus()
    {
        if (Display.isActive())
        {
            if (!this.inGameHasFocus)
            {
                this.inGameHasFocus = true;
                this.mouseHelper.grabMouseCursor();
                this.displayGuiScreen((GuiScreen)null);
                this.leftClickCounter = 10000;
            }
        }
    }

    /**
     * Resets the player keystate, disables the ingame focus, and ungrabs the mouse cursor.
     */
    public void setIngameNotInFocus()
    {
        if (this.inGameHasFocus)
        {
            KeyBinding.unPressAllKeys();
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }

    /**
     * Displays the ingame menu
     */
    public void displayInGameMenu()
    {
        if (this.currentScreen == null)
        {
            this.displayGuiScreen(new GuiIngameMenu());

            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic())
            {
                this.sndManager.pauseAllSounds();
            }
        }
    }

    private void sendClickBlockToController(int par1, boolean par2)
    {
        if (!par2)
        {
            this.leftClickCounter = 0;
        }

        if (par1 != 0 || this.leftClickCounter <= 0)
        {
            if (par2 && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == EnumMovingObjectType.TILE && par1 == 0)
            {
                int j = this.objectMouseOver.blockX;
                int k = this.objectMouseOver.blockY;
                int l = this.objectMouseOver.blockZ;
                this.playerController.onPlayerDamageBlock(j, k, l, this.objectMouseOver.sideHit);

                if (this.thePlayer.canCurrentToolHarvestBlock(j, k, l))
                {
                    this.effectRenderer.addBlockHitEffects(j, k, l, this.objectMouseOver);
                    this.thePlayer.swingItem();
                }
            }
            else
            {
                this.playerController.resetBlockRemoving();
            }
        }
    }

    /**
     * Called whenever the mouse is clicked. Button clicked is 0 for left clicking and 1 for right clicking. Args:
     * buttonClicked
     */
    private void clickMouse(int par1)
    {
        if (par1 != 0 || this.leftClickCounter <= 0)
        {
            if (par1 == 0)
            {
                this.thePlayer.swingItem();
            }

            if (par1 == 1)
            {
                this.rightClickDelayTimer = 4;
            }

            boolean flag = true;
            ItemStack itemstack = this.thePlayer.inventory.getCurrentItem();

            if (this.objectMouseOver == null)
            {
                if (par1 == 0 && this.playerController.isNotCreative())
                {
                    this.leftClickCounter = 10;
                }
            }
            else if (this.objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
            {
                if (par1 == 0)
                {
                    this.playerController.attackEntity(this.thePlayer, this.objectMouseOver.entityHit);
                }

                if (par1 == 1 && this.playerController.func_78768_b(this.thePlayer, this.objectMouseOver.entityHit))
                {
                    flag = false;
                }
            }
            else if (this.objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
            {
                int j = this.objectMouseOver.blockX;
                int k = this.objectMouseOver.blockY;
                int l = this.objectMouseOver.blockZ;
                int i1 = this.objectMouseOver.sideHit;

                if (par1 == 0)
                {
                    this.playerController.clickBlock(j, k, l, this.objectMouseOver.sideHit);
                }
                else
                {
                    int j1 = itemstack != null ? itemstack.stackSize : 0;

                    boolean result = !ForgeEventFactory.onPlayerInteract(thePlayer, Action.RIGHT_CLICK_BLOCK, j, k, l, i1).isCanceled();
                    if (result && this.playerController.onPlayerRightClick(this.thePlayer, this.theWorld, itemstack, j, k, l, i1, this.objectMouseOver.hitVec))
                    {
                        flag = false;
                        this.thePlayer.swingItem();
                    }

                    if (itemstack == null)
                    {
                        return;
                    }

                    if (itemstack.stackSize == 0)
                    {
                        this.thePlayer.inventory.mainInventory[this.thePlayer.inventory.currentItem] = null;
                    }
                    else if (itemstack.stackSize != j1 || this.playerController.isInCreativeMode())
                    {
                        this.entityRenderer.itemRenderer.resetEquippedProgress();
                    }
                }
            }

            if (flag && par1 == 1)
            {
                ItemStack itemstack1 = this.thePlayer.inventory.getCurrentItem();

                boolean result = !ForgeEventFactory.onPlayerInteract(thePlayer, Action.RIGHT_CLICK_AIR, 0, 0, 0, -1).isCanceled();
                if (result && itemstack1 != null && this.playerController.sendUseItem(this.thePlayer, this.theWorld, itemstack1))
                {
                    this.entityRenderer.itemRenderer.resetEquippedProgress2();
                }
            }
        }
    }

    /**
     * Toggles fullscreen mode.
     */
    public void toggleFullscreen()
    {
        try
        {
            this.fullscreen = !this.fullscreen;

            if (this.fullscreen)
            {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }
            else
            {
                if (this.mcCanvas != null)
                {
                    this.displayWidth = this.mcCanvas.getWidth();
                    this.displayHeight = this.mcCanvas.getHeight();
                }
                else
                {
                    this.displayWidth = this.tempDisplayWidth;
                    this.displayHeight = this.tempDisplayHeight;
                }

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }

            if (this.currentScreen != null)
            {
                this.resize(this.displayWidth, this.displayHeight);
            }

            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            Display.update();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Called to resize the current screen.
     */
    private void resize(int par1, int par2)
    {
        this.displayWidth = par1 <= 0 ? 1 : par1;
        this.displayHeight = par2 <= 0 ? 1 : par2;

        if (this.currentScreen != null)
        {
            ScaledResolution scaledresolution = new ScaledResolution(this.gameSettings, par1, par2);
            int k = scaledresolution.getScaledWidth();
            int l = scaledresolution.getScaledHeight();
            this.currentScreen.setWorldAndResolution(this, k, l);
        }
    }

    /**
     * Runs the current tick.
     */
    public void runTick()
    {
        FMLCommonHandler.instance().rescheduleTicks(Side.CLIENT);

        if (this.rightClickDelayTimer > 0)
        {
            --this.rightClickDelayTimer;
        }

        FMLCommonHandler.instance().onPreClientTick();

        this.mcProfiler.startSection("stats");
        this.statFileWriter.func_77449_e();
        this.mcProfiler.endStartSection("gui");

        if (!this.isGamePaused)
        {
            this.ingameGUI.updateTick();
        }

        this.mcProfiler.endStartSection("pick");
        this.entityRenderer.getMouseOver(1.0F);
        this.mcProfiler.endStartSection("gameMode");

        if (!this.isGamePaused && this.theWorld != null)
        {
            this.playerController.updateController();
        }

        this.renderEngine.bindTexture("/terrain.png");
        this.mcProfiler.endStartSection("textures");

        if (!this.isGamePaused)
        {
            this.renderEngine.updateDynamicTextures();
        }

        if (this.currentScreen == null && this.thePlayer != null)
        {
            if (this.thePlayer.getHealth() <= 0)
            {
                this.displayGuiScreen((GuiScreen)null);
            }
            else if (this.thePlayer.isPlayerSleeping() && this.theWorld != null)
            {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.thePlayer.isPlayerSleeping())
        {
            this.displayGuiScreen((GuiScreen)null);
        }

        if (this.currentScreen != null)
        {
            this.leftClickCounter = 10000;
        }

        CrashReport crashreport;
        CrashReportCategory crashreportcategory;

        if (this.currentScreen != null)
        {
            try
            {
                this.currentScreen.handleInput();
            }
            catch (Throwable throwable)
            {
                crashreport = CrashReport.makeCrashReport(throwable, "Updating screen events");
                crashreportcategory = crashreport.makeCategory("Affected screen");
                crashreportcategory.addCrashSectionCallable("Screen name", new CallableUpdatingScreenName(this));
                throw new ReportedException(crashreport);
            }

            if (this.currentScreen != null)
            {
                try
                {
                    this.currentScreen.guiParticles.update();
                }
                catch (Throwable throwable1)
                {
                    crashreport = CrashReport.makeCrashReport(throwable1, "Ticking screen particles");
                    crashreportcategory = crashreport.makeCategory("Affected screen");
                    crashreportcategory.addCrashSectionCallable("Screen name", new CallableParticleScreenName(this));
                    throw new ReportedException(crashreport);
                }

                try
                {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable throwable2)
                {
                    crashreport = CrashReport.makeCrashReport(throwable2, "Ticking screen");
                    crashreportcategory = crashreport.makeCategory("Affected screen");
                    crashreportcategory.addCrashSectionCallable("Screen name", new CallableTickingScreenName(this));
                    throw new ReportedException(crashreport);
                }
            }
        }

        if (this.currentScreen == null || this.currentScreen.allowUserInput)
        {
            this.mcProfiler.endStartSection("mouse");

            while (Mouse.next())
            {
                KeyBinding.setKeyBindState(Mouse.getEventButton() - 100, Mouse.getEventButtonState());

                if (Mouse.getEventButtonState())
                {
                    KeyBinding.onTick(Mouse.getEventButton() - 100);
                }

                long i = getSystemTime() - this.systemTime;

                if (i <= 200L)
                {
                    int j = Mouse.getEventDWheel();

                    if (j != 0)
                    {
                        this.thePlayer.inventory.changeCurrentItem(j);

                        if (this.gameSettings.noclip)
                        {
                            if (j > 0)
                            {
                                j = 1;
                            }

                            if (j < 0)
                            {
                                j = -1;
                            }

                            this.gameSettings.noclipRate += (float)j * 0.25F;
                        }
                    }

                    if (this.currentScreen == null)
                    {
                        if (!this.inGameHasFocus && Mouse.getEventButtonState())
                        {
                            this.setIngameFocus();
                        }
                    }
                    else if (this.currentScreen != null)
                    {
                        this.currentScreen.handleMouseInput();
                    }
                }
            }

            if (this.leftClickCounter > 0)
            {
                --this.leftClickCounter;
            }

            this.mcProfiler.endStartSection("keyboard");
            boolean flag;

            while (Keyboard.next())
            {
                KeyBinding.setKeyBindState(Keyboard.getEventKey(), Keyboard.getEventKeyState());

                if (Keyboard.getEventKeyState())
                {
                    KeyBinding.onTick(Keyboard.getEventKey());
                }

                if (this.field_83002_am > 0L)
                {
                    if (getSystemTime() - this.field_83002_am >= 6000L)
                    {
                        throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                    }

                    if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61))
                    {
                        this.field_83002_am = -1L;
                    }
                }
                else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61))
                {
                    this.field_83002_am = getSystemTime();
                }

                if (Keyboard.getEventKeyState())
                {
                    if (Keyboard.getEventKey() == 87)
                    {
                        this.toggleFullscreen();
                    }
                    else
                    {
                        if (this.currentScreen != null)
                        {
                            this.currentScreen.handleKeyboardInput();
                        }
                        else
                        {
                            if (Keyboard.getEventKey() == 1)
                            {
                                this.displayInGameMenu();
                            }

                            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61))
                            {
                                this.forceReload();
                            }

                            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61))
                            {
                                this.renderEngine.refreshTextures();
                                this.renderGlobal.loadRenderers();
                            }

                            if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61))
                            {
                                flag = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                                this.gameSettings.setOptionValue(EnumOptions.RENDER_DISTANCE, flag ? -1 : 1);
                            }

                            if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61))
                            {
                                this.renderGlobal.loadRenderers();
                            }

                            if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61))
                            {
                                this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
                                this.gameSettings.saveOptions();
                            }

                            if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61))
                            {
                                RenderManager.field_85095_o = !RenderManager.field_85095_o;
                            }

                            if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61))
                            {
                                this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
                                this.gameSettings.saveOptions();
                            }

                            if (Keyboard.getEventKey() == 59)
                            {
                                this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                            }

                            if (Keyboard.getEventKey() == 61)
                            {
                                this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                                this.gameSettings.showDebugProfilerChart = GuiScreen.isShiftKeyDown();
                            }

                            if (Keyboard.getEventKey() == 63)
                            {
                                ++this.gameSettings.thirdPersonView;

                                if (this.gameSettings.thirdPersonView > 2)
                                {
                                    this.gameSettings.thirdPersonView = 0;
                                }
                            }

                            if (Keyboard.getEventKey() == 66)
                            {
                                this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
                            }
                        }

                        int k;

                        for (k = 0; k < 9; ++k)
                        {
                            if (Keyboard.getEventKey() == 2 + k)
                            {
                                this.thePlayer.inventory.currentItem = k;
                            }
                        }

                        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart)
                        {
                            if (Keyboard.getEventKey() == 11)
                            {
                                this.updateDebugProfilerName(0);
                            }

                            for (k = 0; k < 9; ++k)
                            {
                                if (Keyboard.getEventKey() == 2 + k)
                                {
                                    this.updateDebugProfilerName(k + 1);
                                }
                            }
                        }
                    }
                }
            }

            flag = this.gameSettings.chatVisibility != 2;

            while (this.gameSettings.keyBindInventory.isPressed())
            {
                this.displayGuiScreen(new GuiInventory(this.thePlayer));
            }

            while (this.gameSettings.keyBindDrop.isPressed())
            {
                this.thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
            }

            while (this.gameSettings.keyBindChat.isPressed() && flag)
            {
                this.displayGuiScreen(new GuiChat());
            }

            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed() && flag)
            {
                this.displayGuiScreen(new GuiChat("/"));
            }

            if (this.thePlayer.isUsingItem())
            {
                if (!this.gameSettings.keyBindUseItem.pressed)
                {
                    this.playerController.onStoppedUsingItem(this.thePlayer);
                }

                label379:

                while (true)
                {
                    if (!this.gameSettings.keyBindAttack.isPressed())
                    {
                        while (this.gameSettings.keyBindUseItem.isPressed())
                        {
                            ;
                        }

                        while (true)
                        {
                            if (this.gameSettings.keyBindPickBlock.isPressed())
                            {
                                continue;
                            }

                            break label379;
                        }
                    }
                }
            }
            else
            {
                while (this.gameSettings.keyBindAttack.isPressed())
                {
                    this.clickMouse(0);
                }

                while (this.gameSettings.keyBindUseItem.isPressed())
                {
                    this.clickMouse(1);
                }

                while (this.gameSettings.keyBindPickBlock.isPressed())
                {
                    this.clickMiddleMouseButton();
                }
            }

            if (this.gameSettings.keyBindUseItem.pressed && this.rightClickDelayTimer == 0 && !this.thePlayer.isUsingItem())
            {
                this.clickMouse(1);
            }

            this.sendClickBlockToController(0, this.currentScreen == null && this.gameSettings.keyBindAttack.pressed && this.inGameHasFocus);
        }

        if (this.theWorld != null)
        {
            if (this.thePlayer != null)
            {
                ++this.joinPlayerCounter;

                if (this.joinPlayerCounter == 30)
                {
                    this.joinPlayerCounter = 0;
                    this.theWorld.joinEntityInSurroundings(this.thePlayer);
                }
            }

            this.mcProfiler.endStartSection("gameRenderer");

            if (!this.isGamePaused)
            {
                this.entityRenderer.updateRenderer();
            }

            this.mcProfiler.endStartSection("levelRenderer");

            if (!this.isGamePaused)
            {
                this.renderGlobal.updateClouds();
            }

            this.mcProfiler.endStartSection("level");

            if (!this.isGamePaused)
            {
                if (this.theWorld.lastLightningBolt > 0)
                {
                    --this.theWorld.lastLightningBolt;
                }

                this.theWorld.updateEntities();
            }

            if (!this.isGamePaused)
            {
                this.theWorld.setAllowedSpawnTypes(this.theWorld.difficultySetting > 0, true);

                try
                {
                    this.theWorld.tick();
                }
                catch (Throwable throwable3)
                {
                    crashreport = CrashReport.makeCrashReport(throwable3, "Exception in world tick");

                    if (this.theWorld == null)
                    {
                        crashreportcategory = crashreport.makeCategory("Affected level");
                        crashreportcategory.addCrashSection("Problem", "Level is null!");
                    }
                    else
                    {
                        this.theWorld.addWorldInfoToCrashReport(crashreport);
                    }

                    throw new ReportedException(crashreport);
                }
            }

            this.mcProfiler.endStartSection("animateTick");

            if (!this.isGamePaused && this.theWorld != null)
            {
                this.theWorld.func_73029_E(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }

            this.mcProfiler.endStartSection("particles");

            if (!this.isGamePaused)
            {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null)
        {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReadPackets();
        }

        FMLCommonHandler.instance().onPostClientTick();

        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }

    /**
     * Forces a reload of the sound manager and all the resources. Called in game by holding 'F3' and pressing 'S'.
     */
    private void forceReload()
    {
        this.getLogAgent().logInfo("FORCING RELOAD!");

        if (this.sndManager != null)
        {
            this.sndManager.stopAllSounds();
        }

        this.sndManager = new SoundManager();
        this.sndManager.loadSoundSettings(this.gameSettings);
        this.downloadResourcesThread.reloadResources();
    }

    /**
     * Arguments: World foldername,  World ingame name, WorldSettings
     */
    public void launchIntegratedServer(String par1Str, String par2Str, WorldSettings par3WorldSettings)
    {
        this.loadWorld((WorldClient)null);
        System.gc();
        ISaveHandler isavehandler = this.saveLoader.getSaveLoader(par1Str, false);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();

        if (worldinfo == null && par3WorldSettings != null)
        {
            this.statFileWriter.readStat(StatList.createWorldStat, 1);
            worldinfo = new WorldInfo(par3WorldSettings, par1Str);
            isavehandler.saveWorldInfo(worldinfo);
        }

        if (par3WorldSettings == null)
        {
            par3WorldSettings = new WorldSettings(worldinfo);
        }

        this.statFileWriter.readStat(StatList.startGameStat, 1);

        GameData.initializeServerGate(2);

        this.theIntegratedServer = new IntegratedServer(this, par1Str, par2Str, par3WorldSettings);
        this.theIntegratedServer.startServerThread();

        MapDifference<Integer, ItemData> idDifferences = GameData.gateWorldLoadingForValidation();
        if (idDifferences!=null)
        {
            FMLClientHandler.instance().warnIDMismatch(idDifferences, true);
        }
        else
        {
            GameData.releaseGate(true);
            continueWorldLoading();
        }

    }

    public void continueWorldLoading()
    {
        this.integratedServerIsRunning = true;
        this.loadingScreen.displayProgressMessage(StatCollector.translateToLocal("menu.loadingLevel"));

        while (!this.theIntegratedServer.serverIsInRunLoop())
        {
            String s2 = this.theIntegratedServer.getUserMessage();

            if (s2 != null)
            {
                this.loadingScreen.resetProgresAndWorkingMessage(StatCollector.translateToLocal(s2));
            }
            else
            {
                this.loadingScreen.resetProgresAndWorkingMessage("");
            }

            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception)
            {
                ;
            }
        }

        this.displayGuiScreen((GuiScreen)null);

        try
        {
            NetClientHandler netclienthandler = new NetClientHandler(this, this.theIntegratedServer);
            this.myNetworkManager = netclienthandler.getNetManager();
        }
        catch (IOException ioexception)
        {
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(new CrashReport("Connecting to integrated server", ioexception)));
        }
    }

    /**
     * unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient)
    {
        this.loadWorld(par1WorldClient, "");
    }

    /**
     * par2Str is displayed on the loading screen to the user unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient, String par2Str)
    {
        this.statFileWriter.syncStats();

        if (par1WorldClient == null)
        {
            NetClientHandler netclienthandler = this.getNetHandler();

            if (netclienthandler != null)
            {
                netclienthandler.cleanup();
            }

            if (this.myNetworkManager != null)
            {
                this.myNetworkManager.closeConnections();
            }

            if (this.theIntegratedServer != null)
            {
                this.theIntegratedServer.initiateShutdown();
                if (loadingScreen!=null)
                {
                    this.loadingScreen.resetProgresAndWorkingMessage("Shutting down internal server...");
                }
                while (!theIntegratedServer.isServerStopped())
                {
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ie) {}
                }
            }

            this.theIntegratedServer = null;
        }

        this.renderViewEntity = null;
        this.myNetworkManager = null;

        if (this.loadingScreen != null)
        {
            this.loadingScreen.resetProgressAndMessage(par2Str);
            this.loadingScreen.resetProgresAndWorkingMessage("");
        }

        if (par1WorldClient == null && this.theWorld != null)
        {
            if (this.texturePackList.getIsDownloading())
            {
                this.texturePackList.onDownloadFinished();
            }

            this.setServerData((ServerData)null);
            this.integratedServerIsRunning = false;
        }

        this.sndManager.playStreaming((String)null, 0.0F, 0.0F, 0.0F);
        this.sndManager.stopAllSounds();
        this.theWorld = par1WorldClient;

        if (par1WorldClient != null)
        {
            if (this.renderGlobal != null)
            {
                this.renderGlobal.setWorldAndLoadRenderers(par1WorldClient);
            }

            if (this.effectRenderer != null)
            {
                this.effectRenderer.clearEffects(par1WorldClient);
            }

            if (this.thePlayer == null)
            {
                this.thePlayer = this.playerController.func_78754_a(par1WorldClient);
                this.playerController.flipPlayer(this.thePlayer);
            }

            this.thePlayer.preparePlayerToSpawn();
            par1WorldClient.spawnEntityInWorld(this.thePlayer);
            this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.thePlayer);
            this.renderViewEntity = this.thePlayer;
        }
        else
        {
            this.saveLoader.flushCache();
            this.thePlayer = null;
        }

        System.gc();
        this.systemTime = 0L;
    }

    /**
     * Installs a resource. Currently only sounds are download so this method just adds them to the SoundManager.
     */
    public void installResource(String par1Str, File par2File)
    {
        int i = par1Str.indexOf("/");
        String s1 = par1Str.substring(0, i);
        par1Str = par1Str.substring(i + 1);

        if (s1.equalsIgnoreCase("sound3"))
        {
            this.sndManager.addSound(par1Str, par2File);
        }
        else if (s1.equalsIgnoreCase("streaming"))
        {
            this.sndManager.addStreaming(par1Str, par2File);
        }
        else if (!s1.equalsIgnoreCase("music") && !s1.equalsIgnoreCase("newmusic"))
        {
            if (s1.equalsIgnoreCase("lang"))
            {
                StringTranslate.getInstance().func_94519_a(par1Str, par2File);
            }
        }
        else
        {
            this.sndManager.addMusic(par1Str, par2File);
        }
    }

    /**
     * A String of renderGlobal.getDebugInfoRenders
     */
    public String debugInfoRenders()
    {
        return this.renderGlobal.getDebugInfoRenders();
    }

    /**
     * Gets the information in the F3 menu about how many entities are infront/around you
     */
    public String getEntityDebug()
    {
        return this.renderGlobal.getDebugInfoEntities();
    }

    /**
     * Gets the name of the world's current chunk provider
     */
    public String getWorldProviderName()
    {
        return this.theWorld.getProviderName();
    }

    /**
     * A String of how many entities are in the world
     */
    public String debugInfoEntities()
    {
        return "P: " + this.effectRenderer.getStatistics() + ". T: " + this.theWorld.getDebugLoadedEntities();
    }

    public void setDimensionAndSpawnPlayer(int par1)
    {
        this.theWorld.setSpawnLocation();
        this.theWorld.removeAllEntities();
        int j = 0;

        if (this.thePlayer != null)
        {
            j = this.thePlayer.entityId;
            this.theWorld.removeEntity(this.thePlayer);
        }

        this.renderViewEntity = null;
        this.thePlayer = this.playerController.func_78754_a(this.theWorld);
        this.thePlayer.dimension = par1;
        this.renderViewEntity = this.thePlayer;
        this.thePlayer.preparePlayerToSpawn();
        this.theWorld.spawnEntityInWorld(this.thePlayer);
        this.playerController.flipPlayer(this.thePlayer);
        this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.entityId = j;
        this.playerController.setPlayerCapabilities(this.thePlayer);

        if (this.currentScreen instanceof GuiGameOver)
        {
            this.displayGuiScreen((GuiScreen)null);
        }
    }

    /**
     * Sets whether this is a demo or not.
     */
    void setDemo(boolean par1)
    {
        this.isDemo = par1;
    }

    /**
     * Gets whether this is a demo or not.
     */
    public final boolean isDemo()
    {
        return this.isDemo;
    }

    /**
     * Returns the NetClientHandler.
     */
    public NetClientHandler getNetHandler()
    {
        return this.thePlayer != null ? this.thePlayer.sendQueue : null;
    }

    public static void main(String[] par0ArrayOfStr)
    {
        FMLRelauncher.handleClientRelaunch(new ArgsWrapper(par0ArrayOfStr));
    }

    public static void fmlReentry(ArgsWrapper wrapper)
    {
        String[] par0ArrayOfStr = wrapper.args;
        HashMap hashmap = new HashMap();
        boolean flag = false;
        boolean flag1 = true;
        boolean flag2 = false;
        String s = "Player" + getSystemTime() % 1000L;
        String s1 = s;

        if (par0ArrayOfStr.length > 0)
        {
            s1 = par0ArrayOfStr[0];
        }

        String s2 = "-";

        if (par0ArrayOfStr.length > 1)
        {
            s2 = par0ArrayOfStr[1];
        }

        ArrayList arraylist = new ArrayList();

        for (int i = 2; i < par0ArrayOfStr.length; ++i)
        {
            String s3 = par0ArrayOfStr[i];
            String s4 = i == par0ArrayOfStr.length - 1 ? null : par0ArrayOfStr[i + 1];
            boolean flag3 = false;

            if (!s3.equals("-demo") && !s3.equals("--demo"))
            {
                if (s3.equals("--applet"))
                {
                    flag1 = false;
                }
                else if (s3.equals("--password") && s4 != null)
                {
                    String[] astring1 = HttpUtil.loginToMinecraft((ILogAgent)null, s1, s4);

                    if (astring1 != null)
                    {
                        s1 = astring1[0];
                        s2 = astring1[1];
                        arraylist.add("Logged in insecurely as " + s1);
                    }
                    else
                    {
                        arraylist.add("Could not log in as " + s1 + " with given password");
                    }

                    flag3 = true;
                }
            }
            else
            {
                flag = true;
            }

            if (flag3)
            {
                ++i;
            }
        }

        if (s1.contains("@") && s2.length() <= 1)
        {
            s1 = s;
        }

        hashmap.put("demo", "" + flag);
        hashmap.put("stand-alone", "" + flag1);
        hashmap.put("username", s1);
        hashmap.put("fullscreen", "" + flag2);
        hashmap.put("sessionid", s2);
        Frame frame = new Frame();
        frame.setTitle("Minecraft");
        frame.setBackground(Color.BLACK);
        JPanel jpanel = new JPanel();
        frame.setLayout(new BorderLayout());
        jpanel.setPreferredSize(new Dimension(854, 480));
        frame.add(jpanel, "Center");
        frame.pack();
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
        frame.addWindowListener(new GameWindowListener());
        MinecraftFakeLauncher minecraftfakelauncher = new MinecraftFakeLauncher(hashmap);
        MinecraftApplet minecraftapplet = new MinecraftApplet();
        minecraftapplet.setStub(minecraftfakelauncher);
        minecraftfakelauncher.setLayout(new BorderLayout());
        minecraftfakelauncher.add(minecraftapplet, "Center");
        minecraftfakelauncher.validate();
        frame.removeAll();
        frame.setLayout(new BorderLayout());
        frame.add(minecraftfakelauncher, "Center");
        frame.validate();
        minecraftapplet.init();
        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            String s5 = (String)iterator.next();
            getMinecraft().getLogAgent().logInfo(s5);
        }

        minecraftapplet.start();
        Runtime.getRuntime().addShutdownHook(new ThreadShutdown());
    }

    public static boolean isGuiEnabled()
    {
        return theMinecraft == null || !theMinecraft.gameSettings.hideGUI;
    }

    public static boolean isFancyGraphicsEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.fancyGraphics;
    }

    /**
     * Returns if ambient occlusion is enabled
     */
    public static boolean isAmbientOcclusionEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.ambientOcclusion != 0;
    }

    /**
     * Returns true if the message is a client command and should not be sent to the server. However there are no such
     * commands at this point in time.
     */
    public boolean handleClientCommand(String par1Str)
    {
        return !par1Str.startsWith("/") ? false : false;
    }

    /**
     * Called when the middle mouse button gets clicked
     */
    private void clickMiddleMouseButton()
    {
        if (this.objectMouseOver != null)
        {
            boolean flag = this.thePlayer.capabilities.isCreativeMode;
            int k;

            if (!ForgeHooks.onPickBlock(this.objectMouseOver, this.thePlayer, this.theWorld))
            {
                return;
            }

            if (flag)
            {
                k = this.thePlayer.inventoryContainer.inventorySlots.size() - 9 + this.thePlayer.inventory.currentItem;
                this.playerController.sendSlotPacket(this.thePlayer.inventory.getStackInSlot(this.thePlayer.inventory.currentItem), k);
            }
        }
    }

    /**
     * adds core server Info (GL version , Texture pack, isModded, type), and the worldInfo to the crash report
     */
    public CrashReport addGraphicsAndWorldToCrashReport(CrashReport par1CrashReport)
    {
        par1CrashReport.func_85056_g().addCrashSectionCallable("LWJGL", new CallableLWJGLVersion(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("OpenGL", new CallableGLInfo(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("Is Modded", new CallableModded(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("Type", new CallableType2(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("Texture Pack", new CallableTexturePack(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("Profiler Position", new CallableClientProfiler(this));
        par1CrashReport.func_85056_g().addCrashSectionCallable("Vec3 Pool Size", new CallableClientMemoryStats(this));

        if (this.theWorld != null)
        {
            this.theWorld.addWorldInfoToCrashReport(par1CrashReport);
        }

        return par1CrashReport;
    }

    /**
     * Return the singleton Minecraft instance for the game
     */
    public static Minecraft getMinecraft()
    {
        return theMinecraft;
    }

    /**
     * Sets refreshTexturePacksScheduled to true, triggering a texture pack refresh next time the while(running) loop is
     * run
     */
    public void scheduleTexturePackRefresh()
    {
        this.refreshTexturePacksScheduled = true;
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("fps", Integer.valueOf(debugFPS));
        par1PlayerUsageSnooper.addData("texpack_name", this.texturePackList.getSelectedTexturePack().getTexturePackFileName());
        par1PlayerUsageSnooper.addData("vsync_enabled", Boolean.valueOf(this.gameSettings.enableVsync));
        par1PlayerUsageSnooper.addData("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        par1PlayerUsageSnooper.addData("display_type", this.fullscreen ? "fullscreen" : "windowed");

        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null)
        {
            par1PlayerUsageSnooper.addData("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("opengl_version", GL11.glGetString(GL11.GL_VERSION));
        par1PlayerUsageSnooper.addData("opengl_vendor", GL11.glGetString(GL11.GL_VENDOR));
        par1PlayerUsageSnooper.addData("client_brand", ClientBrandRetriever.getClientModName());
        par1PlayerUsageSnooper.addData("applet", Boolean.valueOf(this.hideQuitButton));
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multitexture]", Boolean.valueOf(contextcapabilities.GL_ARB_multitexture));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multisample]", Boolean.valueOf(contextcapabilities.GL_ARB_multisample));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_blend));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_matrix_palette]", Boolean.valueOf(contextcapabilities.GL_ARB_matrix_palette));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_objects));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_pixel_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_uniform_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_non_power_of_two));
        par1PlayerUsageSnooper.addData("gl_caps[gl_max_vertex_uniforms]", Integer.valueOf(GL11.glGetInteger(GL20.GL_MAX_VERTEX_UNIFORM_COMPONENTS)));
        par1PlayerUsageSnooper.addData("gl_caps[gl_max_fragment_uniforms]", Integer.valueOf(GL11.glGetInteger(GL20.GL_MAX_FRAGMENT_UNIFORM_COMPONENTS)));
        par1PlayerUsageSnooper.addData("gl_max_texture_size", Integer.valueOf(getGLMaximumTextureSize()));
    }

    //Forge: Adds a optimization to the getGLMaximumTextureSize, only calculate it once.
    private static int max_texture_size = -1;
    /**
     * Used in the usage snooper.
     */
    public static int getGLMaximumTextureSize()
    {
        if (max_texture_size != -1)
        {
            return max_texture_size;
        }

        for (int i = 16384; i > 0; i >>= 1)
        {
            GL11.glTexImage2D(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_RGBA, i, i, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);
            int j = GL11.glGetTexLevelParameteri(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);

            if (j != 0)
            {
                max_texture_size = i;
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return this.gameSettings.snooperEnabled;
    }

    /**
     * Set the current ServerData instance.
     */
    public void setServerData(ServerData par1ServerData)
    {
        this.currentServerData = par1ServerData;
    }

    /**
     * Get the current ServerData instance.
     */
    public ServerData getServerData()
    {
        return this.currentServerData;
    }

    public boolean isIntegratedServerRunning()
    {
        return this.integratedServerIsRunning;
    }

    /**
     * Returns true if there is only one player playing, and the current server is the integrated one.
     */
    public boolean isSingleplayer()
    {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }

    /**
     * Returns the currently running integrated server
     */
    public IntegratedServer getIntegratedServer()
    {
        return this.theIntegratedServer;
    }

    public static void stopIntegratedServer()
    {
        if (theMinecraft != null)
        {
            IntegratedServer integratedserver = theMinecraft.getIntegratedServer();

            if (integratedserver != null)
            {
                integratedserver.stopServer();
            }
        }
    }

    /**
     * Returns the PlayerUsageSnooper instance.
     */
    public PlayerUsageSnooper getPlayerUsageSnooper()
    {
        return this.usageSnooper;
    }

    /**
     * Gets the system time in milliseconds.
     */
    public static long getSystemTime()
    {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    /**
     * Returns whether we're in full screen or not.
     */
    public boolean isFullScreen()
    {
        return this.fullscreen;
    }

    public ILogAgent getLogAgent()
    {
        return this.field_94139_O;
    }
}
