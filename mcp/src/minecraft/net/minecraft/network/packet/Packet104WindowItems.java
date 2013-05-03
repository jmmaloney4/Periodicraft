package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.item.ItemStack;

public class Packet104WindowItems extends Packet
{
    /**
     * The id of window which items are being sent for. 0 for player inventory.
     */
    public int windowId;

    /** Stack of items */
    public ItemStack[] itemStack;

    public Packet104WindowItems() {}

    public Packet104WindowItems(int par1, List par2List)
    {
        this.windowId = par1;
        this.itemStack = new ItemStack[par2List.size()];

        for (int j = 0; j < this.itemStack.length; ++j)
        {
            ItemStack itemstack = (ItemStack)par2List.get(j);
            this.itemStack[j] = itemstack == null ? null : itemstack.copy();
        }
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.windowId = par1DataInputStream.readByte();
        short short1 = par1DataInputStream.readShort();
        this.itemStack = new ItemStack[short1];

        for (int i = 0; i < short1; ++i)
        {
            this.itemStack[i] = readItemStack(par1DataInputStream);
        }
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte(this.windowId);
        par1DataOutputStream.writeShort(this.itemStack.length);

        for (int i = 0; i < this.itemStack.length; ++i)
        {
            writeItemStack(this.itemStack[i], par1DataOutputStream);
        }
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleWindowItems(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 3 + this.itemStack.length * 5;
    }
}
