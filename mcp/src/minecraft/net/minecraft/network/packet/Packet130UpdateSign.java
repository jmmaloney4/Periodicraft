package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet130UpdateSign extends Packet
{
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public String[] signLines;

    public Packet130UpdateSign()
    {
        this.isChunkDataPacket = true;
    }

    public Packet130UpdateSign(int par1, int par2, int par3, String[] par4ArrayOfStr)
    {
        this.isChunkDataPacket = true;
        this.xPosition = par1;
        this.yPosition = par2;
        this.zPosition = par3;
        this.signLines = new String[] {par4ArrayOfStr[0], par4ArrayOfStr[1], par4ArrayOfStr[2], par4ArrayOfStr[3]};
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.xPosition = par1DataInputStream.readInt();
        this.yPosition = par1DataInputStream.readShort();
        this.zPosition = par1DataInputStream.readInt();
        this.signLines = new String[4];

        for (int i = 0; i < 4; ++i)
        {
            this.signLines[i] = readString(par1DataInputStream, 15);
        }
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(this.xPosition);
        par1DataOutputStream.writeShort(this.yPosition);
        par1DataOutputStream.writeInt(this.zPosition);

        for (int i = 0; i < 4; ++i)
        {
            writeString(this.signLines[i], par1DataOutputStream);
        }
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleUpdateSign(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        int i = 0;

        for (int j = 0; j < 4; ++j)
        {
            i += this.signLines[j].length();
        }

        return i;
    }
}
