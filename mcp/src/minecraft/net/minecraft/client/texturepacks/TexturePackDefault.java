package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SideOnly(Side.CLIENT)
public class TexturePackDefault extends TexturePackImplementation
{
    public TexturePackDefault()
    {
        super("default", (File)null, "Default", (ITexturePack)null);
    }

    /**
     * Load texture pack description from /pack.txt file in the texture pack
     */
    protected void loadDescription()
    {
        this.firstDescriptionLine = "The default look of Minecraft";
    }

    public boolean func_98140_c(String par1Str)
    {
        return TexturePackDefault.class.getResourceAsStream(par1Str) != null;
    }

    public boolean isCompatible()
    {
        return true;
    }

    protected InputStream func_98139_b(String par1Str) throws IOException
    {
        InputStream inputstream = TexturePackDefault.class.getResourceAsStream(par1Str);

        if (inputstream == null)
        {
            throw new FileNotFoundException(par1Str);
        }
        else
        {
            return inputstream;
        }
    }
}
