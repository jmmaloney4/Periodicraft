package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import net.minecraft.client.renderer.RenderEngine;

@SideOnly(Side.CLIENT)
public class TexturePackCustom extends TexturePackImplementation
{
    /** ZipFile object used to access the texture pack file's contents. */
    private ZipFile texturePackZipFile;

    public TexturePackCustom(String par1Str, File par2File, ITexturePack par3ITexturePack)
    {
        super(par1Str, par2File, par2File.getName(), par3ITexturePack);
    }

    /**
     * Delete the OpenGL texture id of the pack's thumbnail image, and close the zip file in case of TexturePackCustom.
     */
    public void deleteTexturePack(RenderEngine par1RenderEngine)
    {
        super.deleteTexturePack(par1RenderEngine);

        try
        {
            if (this.texturePackZipFile != null)
            {
                this.texturePackZipFile.close();
            }
        }
        catch (IOException ioexception)
        {
            ;
        }

        this.texturePackZipFile = null;
    }

    protected InputStream func_98139_b(String par1Str) throws IOException
    {
        this.openTexturePackFile();
        ZipEntry zipentry = this.texturePackZipFile.getEntry(par1Str.substring(1));

        if (zipentry == null)
        {
            throw new FileNotFoundException(par1Str);
        }
        else
        {
            return this.texturePackZipFile.getInputStream(zipentry);
        }
    }

    public boolean func_98140_c(String par1Str)
    {
        try
        {
            this.openTexturePackFile();
            return this.texturePackZipFile.getEntry(par1Str.substring(1)) != null;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    /**
     * Open the texture pack's file and initialize texturePackZipFile
     */
    private void openTexturePackFile() throws IOException, ZipException
    {
        if (this.texturePackZipFile == null)
        {
            this.texturePackZipFile = new ZipFile(this.texturePackFile);
        }
    }

    public boolean isCompatible()
    {
        try
        {
            this.openTexturePackFile();
            Enumeration enumeration = this.texturePackZipFile.entries();

            while (enumeration.hasMoreElements())
            {
                ZipEntry zipentry = (ZipEntry)enumeration.nextElement();

                if (zipentry.getName().startsWith("textures/"))
                {
                    return true;
                }
            }
        }
        catch (Exception exception)
        {
            ;
        }

        boolean flag = this.func_98140_c("terrain.png") || this.func_98140_c("gui/items.png");
        return !flag;
    }
}
