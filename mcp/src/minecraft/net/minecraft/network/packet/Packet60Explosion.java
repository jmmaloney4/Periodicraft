package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;

public class Packet60Explosion extends Packet
{
    public double explosionX;
    public double explosionY;
    public double explosionZ;
    public float explosionSize;
    public List chunkPositionRecords;

    /** X velocity of the player being pushed by the explosion */
    private float playerVelocityX;

    /** Y velocity of the player being pushed by the explosion */
    private float playerVelocityY;

    /** Z velocity of the player being pushed by the explosion */
    private float playerVelocityZ;

    public Packet60Explosion() {}

    public Packet60Explosion(double par1, double par3, double par5, float par7, List par8List, Vec3 par9Vec3)
    {
        this.explosionX = par1;
        this.explosionY = par3;
        this.explosionZ = par5;
        this.explosionSize = par7;
        this.chunkPositionRecords = new ArrayList(par8List);

        if (par9Vec3 != null)
        {
            this.playerVelocityX = (float)par9Vec3.xCoord;
            this.playerVelocityY = (float)par9Vec3.yCoord;
            this.playerVelocityZ = (float)par9Vec3.zCoord;
        }
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.explosionX = par1DataInputStream.readDouble();
        this.explosionY = par1DataInputStream.readDouble();
        this.explosionZ = par1DataInputStream.readDouble();
        this.explosionSize = par1DataInputStream.readFloat();
        int i = par1DataInputStream.readInt();
        this.chunkPositionRecords = new ArrayList(i);
        int j = (int)this.explosionX;
        int k = (int)this.explosionY;
        int l = (int)this.explosionZ;

        for (int i1 = 0; i1 < i; ++i1)
        {
            int j1 = par1DataInputStream.readByte() + j;
            int k1 = par1DataInputStream.readByte() + k;
            int l1 = par1DataInputStream.readByte() + l;
            this.chunkPositionRecords.add(new ChunkPosition(j1, k1, l1));
        }

        this.playerVelocityX = par1DataInputStream.readFloat();
        this.playerVelocityY = par1DataInputStream.readFloat();
        this.playerVelocityZ = par1DataInputStream.readFloat();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeDouble(this.explosionX);
        par1DataOutputStream.writeDouble(this.explosionY);
        par1DataOutputStream.writeDouble(this.explosionZ);
        par1DataOutputStream.writeFloat(this.explosionSize);
        par1DataOutputStream.writeInt(this.chunkPositionRecords.size());
        int i = (int)this.explosionX;
        int j = (int)this.explosionY;
        int k = (int)this.explosionZ;
        Iterator iterator = this.chunkPositionRecords.iterator();

        while (iterator.hasNext())
        {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int l = chunkposition.x - i;
            int i1 = chunkposition.y - j;
            int j1 = chunkposition.z - k;
            par1DataOutputStream.writeByte(l);
            par1DataOutputStream.writeByte(i1);
            par1DataOutputStream.writeByte(j1);
        }

        par1DataOutputStream.writeFloat(this.playerVelocityX);
        par1DataOutputStream.writeFloat(this.playerVelocityY);
        par1DataOutputStream.writeFloat(this.playerVelocityZ);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleExplosion(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 32 + this.chunkPositionRecords.size() * 3 + 3;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets the X velocity of the player being pushed by the explosion.
     */
    public float getPlayerVelocityX()
    {
        return this.playerVelocityX;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets the Y velocity of the player being pushed by the explosion.
     */
    public float getPlayerVelocityY()
    {
        return this.playerVelocityY;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets the Z velocity of the player being pushed by the explosion.
     */
    public float getPlayerVelocityZ()
    {
        return this.playerVelocityZ;
    }
}
