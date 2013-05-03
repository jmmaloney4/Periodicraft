package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

@SideOnly(Side.CLIENT)
public class ServerList
{
    /** The Minecraft instance. */
    private final Minecraft mc;

    /** List of ServerData instances. */
    private final List servers = new ArrayList();

    public ServerList(Minecraft par1Minecraft)
    {
        this.mc = par1Minecraft;
        this.loadServerList();
    }

    /**
     * Loads a list of servers from servers.dat, by running ServerData.getServerDataFromNBTCompound on each NBT compound
     * found in the "servers" tag list.
     */
    public void loadServerList()
    {
        try
        {
            NBTTagCompound nbttagcompound = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            NBTTagList nbttaglist = nbttagcompound.getTagList("servers");
            this.servers.clear();

            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                this.servers.add(ServerData.getServerDataFromNBTCompound((NBTTagCompound)nbttaglist.tagAt(i)));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Runs getNBTCompound on each ServerData instance, puts everything into a "servers" NBT list and writes it to
     * servers.dat.
     */
    public void saveServerList()
    {
        try
        {
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.servers.iterator();

            while (iterator.hasNext())
            {
                ServerData serverdata = (ServerData)iterator.next();
                nbttaglist.appendTag(serverdata.getNBTCompound());
            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setTag("servers", nbttaglist);
            CompressedStreamTools.safeWrite(nbttagcompound, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the ServerData instance stored for the given index in the list.
     */
    public ServerData getServerData(int par1)
    {
        return (ServerData)this.servers.get(par1);
    }

    /**
     * Removes the ServerData instance stored for the given index in the list.
     */
    public void removeServerData(int par1)
    {
        this.servers.remove(par1);
    }

    /**
     * Adds the given ServerData instance to the list.
     */
    public void addServerData(ServerData par1ServerData)
    {
        this.servers.add(par1ServerData);
    }

    /**
     * Counts the number of ServerData instances in the list.
     */
    public int countServers()
    {
        return this.servers.size();
    }

    /**
     * Takes two list indexes, and swaps their order around.
     */
    public void swapServers(int par1, int par2)
    {
        ServerData serverdata = this.getServerData(par1);
        this.servers.set(par1, this.getServerData(par2));
        this.servers.set(par2, serverdata);
        this.saveServerList();
    }

    /**
     * Sets the given index in the list to the given ServerData instance.
     */
    public void setServer(int par1, ServerData par2ServerData)
    {
        this.servers.set(par1, par2ServerData);
    }

    public static void func_78852_b(ServerData par0ServerData)
    {
        ServerList serverlist = new ServerList(Minecraft.getMinecraft());
        serverlist.loadServerList();

        for (int i = 0; i < serverlist.countServers(); ++i)
        {
            ServerData serverdata1 = serverlist.getServerData(i);

            if (serverdata1.serverName.equals(par0ServerData.serverName) && serverdata1.serverIP.equals(par0ServerData.serverIP))
            {
                serverlist.setServer(i, par0ServerData);
                break;
            }
        }

        serverlist.saveServerList();
    }
}
