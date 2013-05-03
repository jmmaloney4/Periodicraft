package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.renderer.RenderEngine;

@SideOnly(Side.CLIENT)
public interface ITexturePack
{
    /**
     * Delete the OpenGL texture id of the pack's thumbnail image, and close the zip file in case of TexturePackCustom.
     */
    void deleteTexturePack(RenderEngine renderengine);

    /**
     * Bind the texture id of the pack's thumbnail image, loading it if necessary.
     */
    void bindThumbnailTexture(RenderEngine renderengine);

    InputStream func_98137_a(String s, boolean flag) throws IOException;

    /**
     * Gives a texture resource as InputStream.
     */
    InputStream getResourceAsStream(String s) throws IOException;

    /**
     * Get the texture pack ID
     */
    String getTexturePackID();

    /**
     * Get the file name of the texture pack, or Default if not from a custom texture pack
     */
    String getTexturePackFileName();

    /**
     * Get the first line of the texture pack description (read from the pack.txt file)
     */
    String getFirstDescriptionLine();

    /**
     * Get the second line of the texture pack description (read from the pack.txt file)
     */
    String getSecondDescriptionLine();

    boolean func_98138_b(String s, boolean flag);

    boolean isCompatible();
}
