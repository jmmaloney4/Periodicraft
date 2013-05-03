package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class Packet20NamedEntitySpawn extends Packet
{
    /** The entity ID, in this case it's the player ID. */
    public int entityId;

    /** The player's name. */
    public String name;

    /** The player's X position. */
    public int xPosition;

    /** The player's Y position. */
    public int yPosition;

    /** The player's Z position. */
    public int zPosition;

    /** The player's rotation. */
    public byte rotation;

    /** The player's pitch. */
    public byte pitch;

    /** The current item the player is holding. */
    public int currentItem;
    private DataWatcher metadata;
    private List metadataWatchableObjects;

    public Packet20NamedEntitySpawn() {}

    public Packet20NamedEntitySpawn(EntityPlayer par1EntityPlayer)
    {
        this.entityId = par1EntityPlayer.entityId;
        this.name = par1EntityPlayer.username;
        this.xPosition = MathHelper.floor_double(par1EntityPlayer.posX * 32.0D);
        this.yPosition = MathHelper.floor_double(par1EntityPlayer.posY * 32.0D);
        this.zPosition = MathHelper.floor_double(par1EntityPlayer.posZ * 32.0D);
        this.rotation = (byte)((int)(par1EntityPlayer.rotationYaw * 256.0F / 360.0F));
        this.pitch = (byte)((int)(par1EntityPlayer.rotationPitch * 256.0F / 360.0F));
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        this.currentItem = itemstack == null ? 0 : itemstack.itemID;
        this.metadata = par1EntityPlayer.getDataWatcher();
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.entityId = par1DataInputStream.readInt();
        this.name = readString(par1DataInputStream, 16);
        this.xPosition = par1DataInputStream.readInt();
        this.yPosition = par1DataInputStream.readInt();
        this.zPosition = par1DataInputStream.readInt();
        this.rotation = par1DataInputStream.readByte();
        this.pitch = par1DataInputStream.readByte();
        this.currentItem = par1DataInputStream.readShort();
        this.metadataWatchableObjects = DataWatcher.readWatchableObjects(par1DataInputStream);
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(this.entityId);
        writeString(this.name, par1DataOutputStream);
        par1DataOutputStream.writeInt(this.xPosition);
        par1DataOutputStream.writeInt(this.yPosition);
        par1DataOutputStream.writeInt(this.zPosition);
        par1DataOutputStream.writeByte(this.rotation);
        par1DataOutputStream.writeByte(this.pitch);
        par1DataOutputStream.writeShort(this.currentItem);
        this.metadata.writeWatchableObjects(par1DataOutputStream);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleNamedEntitySpawn(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 28;
    }

    @SideOnly(Side.CLIENT)
    public List getWatchedMetadata()
    {
        if (this.metadataWatchableObjects == null)
        {
            this.metadataWatchableObjects = this.metadata.getAllWatched();
        }

        return this.metadataWatchableObjects;
    }
}
