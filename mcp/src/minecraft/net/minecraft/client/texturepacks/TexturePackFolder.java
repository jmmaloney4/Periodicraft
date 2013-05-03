package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SideOnly(Side.CLIENT)
public class TexturePackFolder extends TexturePackImplementation
{
    public TexturePackFolder(String par1, File par2, ITexturePack par3ITexturePack)
    {
        super(par1, par2, par2.getName(), par3ITexturePack);
    }

    protected InputStream func_98139_b(String par1Str) throws IOException
    {
        File file1 = new File(this.texturePackFile, par1Str.substring(1));

        if (!file1.exists())
        {
            throw new FileNotFoundException(par1Str);
        }
        else
        {
            return new BufferedInputStream(new FileInputStream(file1));
        }
    }

    public boolean func_98140_c(String par1Str)
    {
        File file1 = new File(this.texturePackFile, par1Str);
        return file1.exists() && file1.isFile();
    }

    public boolean isCompatible()
    {
        File file1 = new File(this.texturePackFile, "textures/");
        boolean flag = file1.exists() && file1.isDirectory();
        boolean flag1 = this.func_98140_c("terrain.png") || this.func_98140_c("gui/items.png");
        return flag || !flag1;
    }
}
