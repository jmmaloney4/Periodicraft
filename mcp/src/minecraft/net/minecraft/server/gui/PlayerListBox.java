package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Vector;
import javax.swing.JList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

@SideOnly(Side.SERVER)
public class PlayerListBox extends JList implements IUpdatePlayerListBox
{
    /** Reference to the MinecraftServer object. */
    private MinecraftServer mcServer;

    /** Counts the number of updates. */
    private int updateCounter = 0;

    public PlayerListBox(MinecraftServer par1MinecraftServer)
    {
        this.mcServer = par1MinecraftServer;
        par1MinecraftServer.func_82010_a(this);
    }

    /**
     * Updates the JList with a new model.
     */
    public void update()
    {
        if (this.updateCounter++ % 20 == 0)
        {
            Vector vector = new Vector();

            for (int i = 0; i < this.mcServer.getConfigurationManager().playerEntityList.size(); ++i)
            {
                vector.add(((EntityPlayerMP)this.mcServer.getConfigurationManager().playerEntityList.get(i)).username);
            }

            this.setListData(vector);
        }
    }
}
