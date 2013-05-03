package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraftforge.common.ForgeHooks;

@SideOnly(Side.CLIENT)
public class GuiIngame extends Gui
{
    private static final RenderItem itemRenderer = new RenderItem();
    private final Random rand = new Random();
    private final Minecraft mc;

    /** ChatGUI instance that retains all previous chat data */
    private final GuiNewChat persistantChatGUI;
    private int updateCounter = 0;

    /** The string specifying which record music is playing */
    private String recordPlaying = "";

    /** How many ticks the record playing message will be displayed */
    private int recordPlayingUpFor = 0;
    private boolean recordIsPlaying = false;

    /** Previous frame vignette brightness (slowly changes by 1% each frame) */
    public float prevVignetteBrightness = 1.0F;
    private int field_92017_k;
    private ItemStack field_92016_l;

    public GuiIngame(Minecraft par1Minecraft)
    {
        this.mc = par1Minecraft;
        this.persistantChatGUI = new GuiNewChat(par1Minecraft);
    }

    /**
     * Render the ingame overlay with quick icon bar, ...
     */
    public void renderGameOverlay(float par1, boolean par2, int par3, int par4)
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int k = scaledresolution.getScaledWidth();
        int l = scaledresolution.getScaledHeight();
        FontRenderer fontrenderer = this.mc.fontRenderer;
        this.mc.entityRenderer.setupOverlayRendering();
        GL11.glEnable(GL11.GL_BLEND);

        if (Minecraft.isFancyGraphicsEnabled())
        {
            this.renderVignette(this.mc.thePlayer.getBrightness(par1), k, l);
        }
        else
        {
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }

        ItemStack itemstack = this.mc.thePlayer.inventory.armorItemInSlot(3);

        if (this.mc.gameSettings.thirdPersonView == 0 && itemstack != null && itemstack.getItem() != null)
        {
            if (itemstack.itemID == Block.pumpkin.blockID)
            {
                this.renderPumpkinBlur(k, l);
            }
            else
            {
                itemstack.getItem().renderHelmetOverlay(itemstack, mc.thePlayer, scaledresolution, par1, par2, par3, par4);
            }
        }

        if (!this.mc.thePlayer.isPotionActive(Potion.confusion))
        {
            float f1 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * par1;

            if (f1 > 0.0F)
            {
                this.renderPortalOverlay(f1, k, l);
            }
        }

        boolean flag1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        byte b0;
        int j3;
        int k3;
        int l3;

        if (!this.mc.playerController.enableEverythingIsScrewedUpMode())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture("/gui/gui.png");
            InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
            this.zLevel = -90.0F;
            this.drawTexturedModalRect(k / 2 - 91, l - 22, 0, 0, 182, 22);
            this.drawTexturedModalRect(k / 2 - 91 - 1 + inventoryplayer.currentItem * 20, l - 22 - 1, 0, 22, 24, 22);
            this.mc.renderEngine.bindTexture("/gui/icons.png");
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_COLOR);
            this.drawTexturedModalRect(k / 2 - 7, l / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(GL11.GL_BLEND);
            flag1 = this.mc.thePlayer.hurtResistantTime / 3 % 2 == 1;

            if (this.mc.thePlayer.hurtResistantTime < 10)
            {
                flag1 = false;
            }

            i1 = this.mc.thePlayer.getHealth();
            j1 = this.mc.thePlayer.prevHealth;
            this.rand.setSeed((long)(this.updateCounter * 312871));
            boolean flag2 = false;
            FoodStats foodstats = this.mc.thePlayer.getFoodStats();
            l1 = foodstats.getFoodLevel();
            k1 = foodstats.getPrevFoodLevel();
            this.mc.mcProfiler.startSection("bossHealth");
            this.renderBossHealth();
            this.mc.mcProfiler.endSection();
            int i4;

            if (this.mc.playerController.shouldDrawHUD())
            {
                i2 = k / 2 - 91;
                i4 = k / 2 + 91;
                this.mc.mcProfiler.startSection("expBar");
                j2 = this.mc.thePlayer.xpBarCap();

                if (j2 > 0)
                {
                    short short1 = 182;
                    l2 = (int)(this.mc.thePlayer.experience * (float)(short1 + 1));
                    k2 = l - 32 + 3;
                    this.drawTexturedModalRect(i2, k2, 0, 64, short1, 5);

                    if (l2 > 0)
                    {
                        this.drawTexturedModalRect(i2, k2, 0, 69, l2, 5);
                    }
                }

                k3 = l - 39;
                l2 = k3 - 10;
                k2 = ForgeHooks.getTotalArmorValue(mc.thePlayer);
                i3 = -1;

                if (this.mc.thePlayer.isPotionActive(Potion.regeneration))
                {
                    i3 = this.updateCounter % 25;
                }

                this.mc.mcProfiler.endStartSection("healthArmor");
                int j4;
                int k4;
                int l4;

                for (j4 = 0; j4 < 10; ++j4)
                {
                    if (k2 > 0)
                    {
                        j3 = i2 + j4 * 8;

                        if (j4 * 2 + 1 < k2)
                        {
                            this.drawTexturedModalRect(j3, l2, 34, 9, 9, 9);
                        }

                        if (j4 * 2 + 1 == k2)
                        {
                            this.drawTexturedModalRect(j3, l2, 25, 9, 9, 9);
                        }

                        if (j4 * 2 + 1 > k2)
                        {
                            this.drawTexturedModalRect(j3, l2, 16, 9, 9, 9);
                        }
                    }

                    j3 = 16;

                    if (this.mc.thePlayer.isPotionActive(Potion.poison))
                    {
                        j3 += 36;
                    }
                    else if (this.mc.thePlayer.isPotionActive(Potion.wither))
                    {
                        j3 += 72;
                    }

                    b0 = 0;

                    if (flag1)
                    {
                        b0 = 1;
                    }

                    l4 = i2 + j4 * 8;
                    k4 = k3;

                    if (i1 <= 4)
                    {
                        k4 = k3 + this.rand.nextInt(2);
                    }

                    if (j4 == i3)
                    {
                        k4 -= 2;
                    }

                    byte b1 = 0;

                    if (this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
                    {
                        b1 = 5;
                    }

                    this.drawTexturedModalRect(l4, k4, 16 + b0 * 9, 9 * b1, 9, 9);

                    if (flag1)
                    {
                        if (j4 * 2 + 1 < j1)
                        {
                            this.drawTexturedModalRect(l4, k4, j3 + 54, 9 * b1, 9, 9);
                        }

                        if (j4 * 2 + 1 == j1)
                        {
                            this.drawTexturedModalRect(l4, k4, j3 + 63, 9 * b1, 9, 9);
                        }
                    }

                    if (j4 * 2 + 1 < i1)
                    {
                        this.drawTexturedModalRect(l4, k4, j3 + 36, 9 * b1, 9, 9);
                    }

                    if (j4 * 2 + 1 == i1)
                    {
                        this.drawTexturedModalRect(l4, k4, j3 + 45, 9 * b1, 9, 9);
                    }
                }

                this.mc.mcProfiler.endStartSection("food");

                for (j4 = 0; j4 < 10; ++j4)
                {
                    j3 = k3;
                    l3 = 16;
                    byte b2 = 0;

                    if (this.mc.thePlayer.isPotionActive(Potion.hunger))
                    {
                        l3 += 36;
                        b2 = 13;
                    }

                    if (this.mc.thePlayer.getFoodStats().getSaturationLevel() <= 0.0F && this.updateCounter % (l1 * 3 + 1) == 0)
                    {
                        j3 = k3 + (this.rand.nextInt(3) - 1);
                    }

                    if (flag2)
                    {
                        b2 = 1;
                    }

                    k4 = i4 - j4 * 8 - 9;
                    this.drawTexturedModalRect(k4, j3, 16 + b2 * 9, 27, 9, 9);

                    if (flag2)
                    {
                        if (j4 * 2 + 1 < k1)
                        {
                            this.drawTexturedModalRect(k4, j3, l3 + 54, 27, 9, 9);
                        }

                        if (j4 * 2 + 1 == k1)
                        {
                            this.drawTexturedModalRect(k4, j3, l3 + 63, 27, 9, 9);
                        }
                    }

                    if (j4 * 2 + 1 < l1)
                    {
                        this.drawTexturedModalRect(k4, j3, l3 + 36, 27, 9, 9);
                    }

                    if (j4 * 2 + 1 == l1)
                    {
                        this.drawTexturedModalRect(k4, j3, l3 + 45, 27, 9, 9);
                    }
                }

                this.mc.mcProfiler.endStartSection("air");

                if (this.mc.thePlayer.isInsideOfMaterial(Material.water))
                {
                    j4 = this.mc.thePlayer.getAir();
                    j3 = MathHelper.ceiling_double_int((double)(j4 - 2) * 10.0D / 300.0D);
                    l3 = MathHelper.ceiling_double_int((double)j4 * 10.0D / 300.0D) - j3;

                    for (l4 = 0; l4 < j3 + l3; ++l4)
                    {
                        if (l4 < j3)
                        {
                            this.drawTexturedModalRect(i4 - l4 * 8 - 9, l2, 16, 18, 9, 9);
                        }
                        else
                        {
                            this.drawTexturedModalRect(i4 - l4 * 8 - 9, l2, 25, 18, 9, 9);
                        }
                    }
                }

                this.mc.mcProfiler.endSection();
            }

            GL11.glDisable(GL11.GL_BLEND);
            this.mc.mcProfiler.startSection("actionBar");
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            RenderHelper.enableGUIStandardItemLighting();

            for (i2 = 0; i2 < 9; ++i2)
            {
                i4 = k / 2 - 90 + i2 * 20 + 2;
                j2 = l - 16 - 3;
                this.renderInventorySlot(i2, i4, j2, par1);
            }

            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            this.mc.mcProfiler.endSection();
        }

        float f2;

        if (this.mc.thePlayer.getSleepTimer() > 0)
        {
            this.mc.mcProfiler.startSection("sleep");
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            int i5 = this.mc.thePlayer.getSleepTimer();
            f2 = (float)i5 / 100.0F;

            if (f2 > 1.0F)
            {
                f2 = 1.0F - (float)(i5 - 100) / 10.0F;
            }

            i1 = (int)(220.0F * f2) << 24 | 1052704;
            drawRect(0, 0, k, l, i1);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            this.mc.mcProfiler.endSection();
        }

        int j5;
        int k5;

        if (this.mc.playerController.func_78763_f() && this.mc.thePlayer.experienceLevel > 0)
        {
            this.mc.mcProfiler.startSection("expLevel");
            flag1 = false;
            i1 = flag1 ? 16777215 : 8453920;
            String s = "" + this.mc.thePlayer.experienceLevel;
            j5 = (k - fontrenderer.getStringWidth(s)) / 2;
            k5 = l - 31 - 4;
            fontrenderer.drawString(s, j5 + 1, k5, 0);
            fontrenderer.drawString(s, j5 - 1, k5, 0);
            fontrenderer.drawString(s, j5, k5 + 1, 0);
            fontrenderer.drawString(s, j5, k5 - 1, 0);
            fontrenderer.drawString(s, j5, k5, i1);
            this.mc.mcProfiler.endSection();
        }

        String s1;

        if (this.mc.gameSettings.heldItemTooltips)
        {
            this.mc.mcProfiler.startSection("toolHighlight");

            if (this.field_92017_k > 0 && this.field_92016_l != null)
            {
                s1 = this.field_92016_l.getDisplayName();
                i1 = (k - fontrenderer.getStringWidth(s1)) / 2;
                j1 = l - 59;

                if (!this.mc.playerController.shouldDrawHUD())
                {
                    j1 += 14;
                }

                j5 = (int)((float)this.field_92017_k * 256.0F / 10.0F);

                if (j5 > 255)
                {
                    j5 = 255;
                }

                if (j5 > 0)
                {
                    GL11.glPushMatrix();
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                    FontRenderer font = field_92016_l.getItem().getFontRenderer(field_92016_l);
                    if (font != null)
                    {
                        i1 = (k - font.getStringWidth(s1)) / 2;
                        font.drawStringWithShadow(s1, i1, j1, 16777215 + (j5 << 24));
                    }
                    else
                    {
                        fontrenderer.drawStringWithShadow(s1, i1, j1, 16777215 + (j5 << 24));
                    }
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glPopMatrix();
                }
            }

            this.mc.mcProfiler.endSection();
        }

        if (this.mc.isDemo())
        {
            this.mc.mcProfiler.startSection("demo");
            s1 = "";

            if (this.mc.theWorld.getTotalWorldTime() >= 120500L)
            {
                s1 = StatCollector.translateToLocal("demo.demoExpired");
            }
            else
            {
                s1 = String.format(StatCollector.translateToLocal("demo.remainingTime"), new Object[] {StringUtils.ticksToElapsedTime((int)(120500L - this.mc.theWorld.getTotalWorldTime()))});
            }

            i1 = fontrenderer.getStringWidth(s1);
            fontrenderer.drawStringWithShadow(s1, k - i1 - 10, 5, 16777215);
            this.mc.mcProfiler.endSection();
        }

        if (this.mc.gameSettings.showDebugInfo)
        {
            this.mc.mcProfiler.startSection("debug");
            GL11.glPushMatrix();
            fontrenderer.drawStringWithShadow("Minecraft 1.5.1 (" + this.mc.debug + ")", 2, 2, 16777215);
            fontrenderer.drawStringWithShadow(this.mc.debugInfoRenders(), 2, 12, 16777215);
            fontrenderer.drawStringWithShadow(this.mc.getEntityDebug(), 2, 22, 16777215);
            fontrenderer.drawStringWithShadow(this.mc.debugInfoEntities(), 2, 32, 16777215);
            fontrenderer.drawStringWithShadow(this.mc.getWorldProviderName(), 2, 42, 16777215);
            long l5 = Runtime.getRuntime().maxMemory();
            long i6 = Runtime.getRuntime().totalMemory();
            long j6 = Runtime.getRuntime().freeMemory();
            long k6 = i6 - j6;
            String s2 = "Used memory: " + k6 * 100L / l5 + "% (" + k6 / 1024L / 1024L + "MB) of " + l5 / 1024L / 1024L + "MB";
            this.drawString(fontrenderer, s2, k - fontrenderer.getStringWidth(s2) - 2, 2, 14737632);
            s2 = "Allocated memory: " + i6 * 100L / l5 + "% (" + i6 / 1024L / 1024L + "MB)";
            this.drawString(fontrenderer, s2, k - fontrenderer.getStringWidth(s2) - 2, 12, 14737632);
            k3 = MathHelper.floor_double(this.mc.thePlayer.posX);
            l2 = MathHelper.floor_double(this.mc.thePlayer.posY);
            k2 = MathHelper.floor_double(this.mc.thePlayer.posZ);
            this.drawString(fontrenderer, String.format("x: %.5f (%d) // c: %d (%d)", new Object[] {Double.valueOf(this.mc.thePlayer.posX), Integer.valueOf(k3), Integer.valueOf(k3 >> 4), Integer.valueOf(k3 & 15)}), 2, 64, 14737632);
            this.drawString(fontrenderer, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] {Double.valueOf(this.mc.thePlayer.boundingBox.minY), Double.valueOf(this.mc.thePlayer.posY)}), 2, 72, 14737632);
            this.drawString(fontrenderer, String.format("z: %.5f (%d) // c: %d (%d)", new Object[] {Double.valueOf(this.mc.thePlayer.posZ), Integer.valueOf(k2), Integer.valueOf(k2 >> 4), Integer.valueOf(k2 & 15)}), 2, 80, 14737632);
            i3 = MathHelper.floor_double((double)(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            this.drawString(fontrenderer, "f: " + i3 + " (" + Direction.directions[i3] + ") / " + MathHelper.wrapAngleTo180_float(this.mc.thePlayer.rotationYaw), 2, 88, 14737632);

            if (this.mc.theWorld != null && this.mc.theWorld.blockExists(k3, l2, k2))
            {
                Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(k3, k2);
                this.drawString(fontrenderer, "lc: " + (chunk.getTopFilledSegment() + 15) + " b: " + chunk.getBiomeGenForWorldCoords(k3 & 15, k2 & 15, this.mc.theWorld.getWorldChunkManager()).biomeName + " bl: " + chunk.getSavedLightValue(EnumSkyBlock.Block, k3 & 15, l2, k2 & 15) + " sl: " + chunk.getSavedLightValue(EnumSkyBlock.Sky, k3 & 15, l2, k2 & 15) + " rl: " + chunk.getBlockLightValue(k3 & 15, l2, k2 & 15, 0), 2, 96, 14737632);
            }

            this.drawString(fontrenderer, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[] {Float.valueOf(this.mc.thePlayer.capabilities.getWalkSpeed()), Float.valueOf(this.mc.thePlayer.capabilities.getFlySpeed()), Boolean.valueOf(this.mc.thePlayer.onGround), Integer.valueOf(this.mc.theWorld.getHeightValue(k3, k2))}), 2, 104, 14737632);
            GL11.glPopMatrix();
            this.mc.mcProfiler.endSection();
        }

        if (this.recordPlayingUpFor > 0)
        {
            this.mc.mcProfiler.startSection("overlayMessage");
            f2 = (float)this.recordPlayingUpFor - par1;
            i1 = (int)(f2 * 256.0F / 20.0F);

            if (i1 > 255)
            {
                i1 = 255;
            }

            if (i1 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(k / 2), (float)(l - 48), 0.0F);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                j1 = 16777215;

                if (this.recordIsPlaying)
                {
                    j1 = Color.HSBtoRGB(f2 / 50.0F, 0.7F, 0.6F) & 16777215;
                }

                fontrenderer.drawString(this.recordPlaying, -fontrenderer.getStringWidth(this.recordPlaying) / 2, -4, j1 + (i1 << 24));
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glPopMatrix();
            }

            this.mc.mcProfiler.endSection();
        }

        ScoreObjective scoreobjective = this.mc.theWorld.getScoreboard().func_96539_a(1);

        if (scoreobjective != null)
        {
            this.func_96136_a(scoreobjective, l, k, fontrenderer);
        }

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, (float)(l - 48), 0.0F);
        this.mc.mcProfiler.startSection("chat");
        this.persistantChatGUI.drawChat(this.updateCounter);
        this.mc.mcProfiler.endSection();
        GL11.glPopMatrix();
        scoreobjective = this.mc.theWorld.getScoreboard().func_96539_a(0);

        if (this.mc.gameSettings.keyBindPlayerList.pressed && (!this.mc.isIntegratedServerRunning() || this.mc.thePlayer.sendQueue.playerInfoList.size() > 1 || scoreobjective != null))
        {
            this.mc.mcProfiler.startSection("playerList");
            NetClientHandler netclienthandler = this.mc.thePlayer.sendQueue;
            List list = netclienthandler.playerInfoList;
            j5 = netclienthandler.currentServerMaxPlayers;
            k5 = j5;

            for (l1 = 1; k5 > 20; k5 = (j5 + l1 - 1) / l1)
            {
                ++l1;
            }

            k1 = 300 / l1;

            if (k1 > 150)
            {
                k1 = 150;
            }

            i2 = (k - l1 * k1) / 2;
            byte b3 = 10;
            drawRect(i2 - 1, b3 - 1, i2 + k1 * l1, b3 + 9 * k5, Integer.MIN_VALUE);

            for (j2 = 0; j2 < j5; ++j2)
            {
                k3 = i2 + j2 % l1 * k1;
                l2 = b3 + j2 / l1 * 9;
                drawRect(k3, l2, k3 + k1 - 1, l2 + 8, 553648127);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(GL11.GL_ALPHA_TEST);

                if (j2 < list.size())
                {
                    GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)list.get(j2);
                    ScorePlayerTeam scoreplayerteam = this.mc.theWorld.getScoreboard().func_96509_i(guiplayerinfo.name);
                    String s3 = ScorePlayerTeam.func_96667_a(scoreplayerteam, guiplayerinfo.name);
                    fontrenderer.drawStringWithShadow(s3, k3, l2, 16777215);

                    if (scoreobjective != null)
                    {
                        j3 = k3 + fontrenderer.getStringWidth(s3) + 5;
                        l3 = k3 + k1 - 12 - 5;

                        if (l3 - j3 > 5)
                        {
                            Score score = scoreobjective.getScoreboard().func_96529_a(guiplayerinfo.name, scoreobjective);
                            String s4 = EnumChatFormatting.YELLOW + "" + score.func_96652_c();
                            fontrenderer.drawStringWithShadow(s4, l3 - fontrenderer.getStringWidth(s4), l2, 16777215);
                        }
                    }

                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.mc.renderEngine.bindTexture("/gui/icons.png");
                    byte b4 = 0;
                    boolean flag3 = false;

                    if (guiplayerinfo.responseTime < 0)
                    {
                        b0 = 5;
                    }
                    else if (guiplayerinfo.responseTime < 150)
                    {
                        b0 = 0;
                    }
                    else if (guiplayerinfo.responseTime < 300)
                    {
                        b0 = 1;
                    }
                    else if (guiplayerinfo.responseTime < 600)
                    {
                        b0 = 2;
                    }
                    else if (guiplayerinfo.responseTime < 1000)
                    {
                        b0 = 3;
                    }
                    else
                    {
                        b0 = 4;
                    }

                    this.zLevel += 100.0F;
                    this.drawTexturedModalRect(k3 + k1 - 12, l2, 0 + b4 * 10, 176 + b0 * 8, 10, 8);
                    this.zLevel -= 100.0F;
                }
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
    }

    private void func_96136_a(ScoreObjective par1ScoreObjective, int par2, int par3, FontRenderer par4FontRenderer)
    {
        Scoreboard scoreboard = par1ScoreObjective.getScoreboard();
        Collection collection = scoreboard.func_96534_i(par1ScoreObjective);

        if (collection.size() <= 15)
        {
            int k = par4FontRenderer.getStringWidth(par1ScoreObjective.getDisplayName());
            String s;

            for (Iterator iterator = collection.iterator(); iterator.hasNext(); k = Math.max(k, par4FontRenderer.getStringWidth(s)))
            {
                Score score = (Score)iterator.next();
                ScorePlayerTeam scoreplayerteam = scoreboard.func_96509_i(score.func_96653_e());
                s = ScorePlayerTeam.func_96667_a(scoreplayerteam, score.func_96653_e()) + ": " + EnumChatFormatting.RED + score.func_96652_c();
            }

            int l = collection.size() * par4FontRenderer.FONT_HEIGHT;
            int i1 = par2 / 2 + l / 3;
            byte b0 = 3;
            int j1 = par3 - k - b0;
            int k1 = 0;
            Iterator iterator1 = collection.iterator();

            while (iterator1.hasNext())
            {
                Score score1 = (Score)iterator1.next();
                ++k1;
                ScorePlayerTeam scoreplayerteam1 = scoreboard.func_96509_i(score1.func_96653_e());
                String s1 = ScorePlayerTeam.func_96667_a(scoreplayerteam1, score1.func_96653_e());
                String s2 = EnumChatFormatting.RED + "" + score1.func_96652_c();
                int l1 = i1 - k1 * par4FontRenderer.FONT_HEIGHT;
                int i2 = par3 - b0 + 2;
                drawRect(j1 - 2, l1, i2, l1 + par4FontRenderer.FONT_HEIGHT, 1342177280);
                par4FontRenderer.drawString(s1, j1, l1, 553648127);
                par4FontRenderer.drawString(s2, i2 - par4FontRenderer.getStringWidth(s2), l1, 553648127);

                if (k1 == collection.size())
                {
                    String s3 = par1ScoreObjective.getDisplayName();
                    drawRect(j1 - 2, l1 - par4FontRenderer.FONT_HEIGHT - 1, i2, l1 - 1, 1610612736);
                    drawRect(j1 - 2, l1 - 1, i2, l1, 1342177280);
                    par4FontRenderer.drawString(s3, j1 + k / 2 - par4FontRenderer.getStringWidth(s3) / 2, l1 - par4FontRenderer.FONT_HEIGHT, 553648127);
                }
            }
        }
    }

    /**
     * Renders dragon's (boss) health on the HUD
     */
    private void renderBossHealth()
    {
        if (BossStatus.bossName != null && BossStatus.statusBarLength > 0)
        {
            --BossStatus.statusBarLength;
            FontRenderer fontrenderer = this.mc.fontRenderer;
            ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            int i = scaledresolution.getScaledWidth();
            short short1 = 182;
            int j = i / 2 - short1 / 2;
            int k = (int)(BossStatus.healthScale * (float)(short1 + 1));
            byte b0 = 12;
            this.drawTexturedModalRect(j, b0, 0, 74, short1, 5);
            this.drawTexturedModalRect(j, b0, 0, 74, short1, 5);

            if (k > 0)
            {
                this.drawTexturedModalRect(j, b0, 0, 79, k, 5);
            }

            String s = BossStatus.bossName;
            fontrenderer.drawStringWithShadow(s, i / 2 - fontrenderer.getStringWidth(s) / 2, b0 - 10, 16777215);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture("/gui/icons.png");
        }
    }

    private void renderPumpkinBlur(int par1, int par2)
    {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        this.mc.renderEngine.bindTexture("%blur%/misc/pumpkinblur.png");
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Renders the vignette. Args: vignetteBrightness, width, height
     */
    private void renderVignette(float par1, int par2, int par3)
    {
        par1 = 1.0F - par1;

        if (par1 < 0.0F)
        {
            par1 = 0.0F;
        }

        if (par1 > 1.0F)
        {
            par1 = 1.0F;
        }

        this.prevVignetteBrightness = (float)((double)this.prevVignetteBrightness + (double)(par1 - this.prevVignetteBrightness) * 0.01D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
        GL11.glColor4f(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0F);
        this.mc.renderEngine.bindTexture("%blur%/misc/vignette.png");
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)par3, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)par2, (double)par3, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)par2, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    /**
     * Renders the portal overlay. Args: portalStrength, width, height
     */
    private void renderPortalOverlay(float par1, int par2, int par3)
    {
        if (par1 < 1.0F)
        {
            par1 *= par1;
            par1 *= par1;
            par1 = par1 * 0.8F + 0.2F;
        }

        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, par1);
        this.mc.renderEngine.bindTexture("/terrain.png");
        Icon icon = Block.portal.getBlockTextureFromSide(1);
        float f1 = icon.getMinU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxU();
        float f4 = icon.getMaxV();
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)par3, -90.0D, (double)f1, (double)f4);
        tessellator.addVertexWithUV((double)par2, (double)par3, -90.0D, (double)f3, (double)f4);
        tessellator.addVertexWithUV((double)par2, 0.0D, -90.0D, (double)f3, (double)f2);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, (double)f1, (double)f2);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Renders the specified item of the inventory slot at the specified location. Args: slot, x, y, partialTick
     */
    private void renderInventorySlot(int par1, int par2, int par3, float par4)
    {
        ItemStack itemstack = this.mc.thePlayer.inventory.mainInventory[par1];

        if (itemstack != null)
        {
            float f1 = (float)itemstack.animationsToGo - par4;

            if (f1 > 0.0F)
            {
                GL11.glPushMatrix();
                float f2 = 1.0F + f1 / 5.0F;
                GL11.glTranslatef((float)(par2 + 8), (float)(par3 + 12), 0.0F);
                GL11.glScalef(1.0F / f2, (f2 + 1.0F) / 2.0F, 1.0F);
                GL11.glTranslatef((float)(-(par2 + 8)), (float)(-(par3 + 12)), 0.0F);
            }

            itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, par2, par3);

            if (f1 > 0.0F)
            {
                GL11.glPopMatrix();
            }

            itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, par2, par3);
        }
    }

    /**
     * The update tick for the ingame UI
     */
    public void updateTick()
    {
        if (this.recordPlayingUpFor > 0)
        {
            --this.recordPlayingUpFor;
        }

        ++this.updateCounter;

        if (this.mc.thePlayer != null)
        {
            ItemStack itemstack = this.mc.thePlayer.inventory.getCurrentItem();

            if (itemstack == null)
            {
                this.field_92017_k = 0;
            }
            else if (this.field_92016_l != null && itemstack.itemID == this.field_92016_l.itemID && ItemStack.areItemStackTagsEqual(itemstack, this.field_92016_l) && (itemstack.isItemStackDamageable() || itemstack.getItemDamage() == this.field_92016_l.getItemDamage()))
            {
                if (this.field_92017_k > 0)
                {
                    --this.field_92017_k;
                }
            }
            else
            {
                this.field_92017_k = 40;
            }

            this.field_92016_l = itemstack;
        }
    }

    public void setRecordPlayingMessage(String par1Str)
    {
        this.recordPlaying = "Now playing: " + par1Str;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = true;
    }

    /**
     * returns a pointer to the persistant Chat GUI, containing all previous chat messages and such
     */
    public GuiNewChat getChatGUI()
    {
        return this.persistantChatGUI;
    }

    public int getUpdateCounter()
    {
        return this.updateCounter;
    }
}
