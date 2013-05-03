package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeDummyContainer;

@SideOnly(Side.CLIENT)
public class TextureMap implements IconRegister
{
    /** 0 = terrain.png, 1 = items.png */
    public final int textureType;
    public final String textureName;
    public final String basePath;
    public final String textureExt;
    private final HashMap mapTexturesStiched = new HashMap();
    private BufferedImage missingImage = new BufferedImage(64, 64, 2);
    private TextureStitched missingTextureStiched;
    private Texture atlasTexture;
    private final List listTextureStiched = new ArrayList();
    private final Map textureStichedMap = new HashMap();

    public TextureMap(int par1, String par2, String par3Str, BufferedImage par4BufferedImage)
    {
        this.textureType = par1;
        this.textureName = par2;
        this.basePath = par3Str;
        this.textureExt = ".png";
        this.missingImage = par4BufferedImage;
    }

    public void refreshTextures()
    {
        this.textureStichedMap.clear();
        ForgeHooksClient.onTextureStitchedPre(this);
        int i;
        int j;

        if (this.textureType == 0)
        {
            Block[] ablock = Block.blocksList;
            i = ablock.length;

            for (j = 0; j < i; ++j)
            {
                Block block = ablock[j];

                if (block != null)
                {
                    block.registerIcons(this);
                }
            }

            Minecraft.getMinecraft().renderGlobal.registerDestroyBlockIcons(this);
            RenderManager.instance.updateIcons(this);
        }

        Item[] aitem = Item.itemsList;
        i = aitem.length;

        for (j = 0; j < i; ++j)
        {
            Item item = aitem[j];

            if (item != null && item.getSpriteNumber() == this.textureType)
            {
                item.registerIcons(this);
            }
        }

        HashMap hashmap = new HashMap();
        Stitcher stitcher = TextureManager.instance().createStitcher(this.textureName);
        this.mapTexturesStiched.clear();
        this.listTextureStiched.clear();
        Texture texture = TextureManager.instance().makeTexture("missingno", 2, this.missingImage.getWidth(), this.missingImage.getHeight(), 10496, 6408, 9728, 9728, false, this.missingImage);
        StitchHolder stitchholder = new StitchHolder(texture);
        stitcher.addStitchHolder(stitchholder);
        hashmap.put(stitchholder, Arrays.asList(new Texture[] {texture}));

        for (Map.Entry<String, TextureStitched> entry : ((Map<String, TextureStitched>)textureStichedMap).entrySet())
        {
            String name = entry.getKey();
            String path;
            if (name.indexOf(':') == -1)
            {
                path = this.basePath + name + this.textureExt;
            }
            else
            {
                String domain = name.substring(0, name.indexOf(':'));
                String file = name.substring(name.indexOf(':') + 1);
                path = "mods/" + domain +"/" + basePath + file + textureExt;
            }
            List list = TextureManager.instance().createNewTexture(name, path, entry.getValue());
            if (!list.isEmpty())
            {
                StitchHolder stitchholder1 = new StitchHolder((Texture)list.get(0));
                stitcher.addStitchHolder(stitchholder1);
                hashmap.put(stitchholder1, list);
            }
        }

        try
        {
            stitcher.doStitch();
        }
        catch (StitcherException stitcherexception)
        {
            throw stitcherexception;
        }

        this.atlasTexture = stitcher.getTexture();
        Iterator iterator = stitcher.getStichSlots().iterator();

        while (iterator.hasNext())
        {
            StitchSlot stitchslot = (StitchSlot)iterator.next();
            StitchHolder stitchholder2 = stitchslot.getStitchHolder();
            Texture texture1 = stitchholder2.func_98150_a();
            String s2 = texture1.getTextureName();
            List list1 = (List)hashmap.get(stitchholder2);
            TextureStitched texturestitched = (TextureStitched)this.textureStichedMap.get(s2);
            boolean flag = false;

            if (texturestitched == null)
            {
                flag = true;
                texturestitched = TextureStitched.makeTextureStitched(s2);

                if (!s2.equals("missingno"))
                {
                    Minecraft.getMinecraft().getLogAgent().logWarning("Couldn\'t find premade icon for " + s2 + " doing " + this.textureName);
                }
            }

            texturestitched.init(this.atlasTexture, list1, stitchslot.getOriginX(), stitchslot.getOriginY(), stitchholder2.func_98150_a().getWidth(), stitchholder2.func_98150_a().getHeight(), stitchholder2.isRotated());
            this.mapTexturesStiched.put(s2, texturestitched);

            if (!flag)
            {
                this.textureStichedMap.remove(s2);
            }

            if (list1.size() > 1)
            {
                this.listTextureStiched.add(texturestitched);
                String s3;
                if (s2.indexOf(':') == -1)
                {
                    s3 = basePath + s2 + ".txt";
                }
                else
                {
                    String domain = s2.substring(0, s2.indexOf(':'));
                    String file = s2.substring(s2.indexOf(':') + 1);
                    s3 = "mods/" + domain + "/" + basePath + file + ".txt";
                }
                ITexturePack itexturepack = Minecraft.getMinecraft().texturePackList.getSelectedTexturePack();
                boolean flag1 = !itexturepack.func_98138_b("/" + this.basePath + s2 + ".png", false);

                try
                {
                    InputStream inputstream = itexturepack.func_98137_a("/" + s3, flag1);
                    Minecraft.getMinecraft().getLogAgent().logInfo("Found animation info for: " + s3);
                    texturestitched.readAnimationInfo(new BufferedReader(new InputStreamReader(inputstream)));
                }
                catch (IOException ioexception)
                {
                    ;
                }
            }
        }

        this.missingTextureStiched = (TextureStitched)this.mapTexturesStiched.get("missingno");
        iterator = this.textureStichedMap.values().iterator();

        while (iterator.hasNext())
        {
            TextureStitched texturestitched1 = (TextureStitched)iterator.next();
            texturestitched1.copyFrom(this.missingTextureStiched);
        }

        if (!ForgeDummyContainer.disableStitchedFileSaving)
        {
            this.atlasTexture.writeImage("debug.stitched_" + this.textureName + ".png");
        }
        ForgeHooksClient.onTextureStitchedPost(this);
        this.atlasTexture.uploadTexture();
    }

    public void updateAnimations()
    {
        Iterator iterator = this.listTextureStiched.iterator();

        while (iterator.hasNext())
        {
            TextureStitched texturestitched = (TextureStitched)iterator.next();
            texturestitched.updateAnimation();
        }
    }

    public Texture getTexture()
    {
        return this.atlasTexture;
    }

    public Icon registerIcon(String par1Str)
    {
        if (par1Str == null)
        {
            (new RuntimeException("Don\'t register null!")).printStackTrace();
            par1Str = "null"; //Don't allow things to actually register null..
        }

        TextureStitched texturestitched = (TextureStitched)this.textureStichedMap.get(par1Str);

        if (texturestitched == null)
        {
            texturestitched = TextureStitched.makeTextureStitched(par1Str);
            this.textureStichedMap.put(par1Str, texturestitched);
        }

        return texturestitched;
    }

    public Icon getMissingIcon()
    {
        return this.missingTextureStiched;
    }

    //===================================================================================================
    //                                           Forge Start
    //===================================================================================================
    /**
     * Grabs the registered entry for the specified name, returning null if there was not a entry.
     * Opposed to registerIcon, this will not instantiate the entry, useful to test if a maping exists.
     *
     * @param name The name of the entry to find
     * @return The registered entry, null if nothing was registered.
     */
    public TextureStitched getTextureExtry(String name)
    {
        return (TextureStitched)textureStichedMap.get(name);
    }

    /**
     * Adds a texture registry entry to this map for the specified name if one does not already exist.
     * Returns false if the map already contains a entry for the specified name.
     *
     * @param name Entry name
     * @param entry Entry instance
     * @return True if the entry was added to the map, false otherwise.
     */
    public boolean setTextureEntry(String name, TextureStitched entry)
    {
        if (!textureStichedMap.containsKey(name))
        {
            textureStichedMap.put(name, entry);
            return true;
        }
        return false;
    }
}
