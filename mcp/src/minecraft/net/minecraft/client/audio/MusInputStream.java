package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@SideOnly(Side.CLIENT)
class MusInputStream extends InputStream
{
    private int hash;
    private InputStream inputStream;
    byte[] buffer;

    final CodecMus codec;

    public MusInputStream(CodecMus par1CodecMus, URL par2URL, InputStream par3InputStream)
    {
        this.codec = par1CodecMus;
        this.buffer = new byte[1];
        this.inputStream = par3InputStream;
        String s = par2URL.getPath();
        s = s.substring(s.lastIndexOf("/") + 1);
        this.hash = s.hashCode();
    }

    public int read() throws IOException
    {
        int i = this.read(this.buffer, 0, 1);
        return i < 0 ? i : this.buffer[0];
    }

    public int read(byte[] par1ArrayOfByte, int par2, int par3) throws IOException
    {
        par3 = this.inputStream.read(par1ArrayOfByte, par2, par3);

        for (int k = 0; k < par3; ++k)
        {
            byte b0 = par1ArrayOfByte[par2 + k] = (byte)(par1ArrayOfByte[par2 + k] ^ this.hash >> 8);
            this.hash = this.hash * 498729871 + 85731 * b0;
        }

        return par3;
    }
}
