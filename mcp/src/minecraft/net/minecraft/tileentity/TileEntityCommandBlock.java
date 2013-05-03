package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class TileEntityCommandBlock extends TileEntity implements ICommandSender
{
    private int field_96106_a = 0;

    /** The command this block will execute when powered. */
    private String command = "";
    private String field_96105_c = "@";

    /**
     * Sets the command this block will execute when powered.
     */
    public void setCommand(String par1Str)
    {
        this.command = par1Str;
        this.onInventoryChanged();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return the command this command block is set to execute.
     */
    public String getCommand()
    {
        return this.command;
    }

    /**
     * Execute the command, called when the command block is powered.
     */
    public int executeCommandOnPowered(World par1World)
    {
        if (par1World.isRemote)
        {
            return 0;
        }
        else
        {
            MinecraftServer minecraftserver = MinecraftServer.getServer();

            if (minecraftserver != null && minecraftserver.isCommandBlockEnabled())
            {
                ICommandManager icommandmanager = minecraftserver.getCommandManager();
                return icommandmanager.executeCommand(this, this.command);
            }
            else
            {
                return 0;
            }
        }
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return this.field_96105_c;
    }

    public void func_96104_c(String par1Str)
    {
        this.field_96105_c = par1Str;
    }

    public void sendChatToPlayer(String par1Str) {}

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public boolean canCommandSenderUseCommand(int par1, String par2Str)
    {
        return par1 <= 2;
    }

    /**
     * Translates and formats the given string key with the given arguments.
     */
    public String translateString(String par1Str, Object ... par2ArrayOfObj)
    {
        return par1Str;
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("Command", this.command);
        par1NBTTagCompound.setInteger("SuccessCount", this.field_96106_a);
        par1NBTTagCompound.setString("CustomName", this.field_96105_c);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.command = par1NBTTagCompound.getString("Command");
        this.field_96106_a = par1NBTTagCompound.getInteger("SuccessCount");

        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.field_96105_c = par1NBTTagCompound.getString("CustomName");
        }
    }

    /**
     * Return the position for this command sender.
     */
    public ChunkCoordinates getPlayerCoordinates()
    {
        return new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
    }

    /**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 2, nbttagcompound);
    }

    public int func_96103_d()
    {
        return this.field_96106_a;
    }

    public void func_96102_a(int par1)
    {
        this.field_96106_a = par1;
    }
}
