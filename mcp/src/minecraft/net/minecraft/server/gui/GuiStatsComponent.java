package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.network.TcpConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

@SideOnly(Side.SERVER)
public class GuiStatsComponent extends JComponent
{
    private static final DecimalFormat field_79020_a = new DecimalFormat("########0.000");

    /** An array containing the columns that make up the memory use graph. */
    private int[] memoryUse = new int[256];

    /**
     * Counts the number of updates. Used as the index into the memoryUse array to display the latest value.
     */
    private int updateCounter = 0;

    /** An array containing the strings displayed in this stats component. */
    private String[] displayStrings = new String[11];
    private final MinecraftServer field_79017_e;

    public GuiStatsComponent(MinecraftServer par1MinecraftServer)
    {
        this.field_79017_e = par1MinecraftServer;
        this.setPreferredSize(new Dimension(456, 246));
        this.setMinimumSize(new Dimension(456, 246));
        this.setMaximumSize(new Dimension(456, 246));
        (new Timer(500, new GuiStatsListener(this))).start();
        this.setBackground(Color.BLACK);
    }

    /**
     * Updates the stat values and calls paint to redraw the component.
     */
    private void updateStats()
    {
        this.displayStrings = new String[5 + DimensionManager.getIDs().length];
        long i = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.displayStrings[0] = "Memory use: " + i / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.displayStrings[1] = "Threads: " + TcpConnection.field_74471_a.get() + " + " + TcpConnection.field_74469_b.get();
        this.displayStrings[2] = "Avg tick: " + field_79020_a.format(this.calcArrayAverage(this.field_79017_e.tickTimeArray) * 1.0E-6D) + " ms";
        this.displayStrings[3] = "Avg sent: " + (int)this.calcArrayAverage(this.field_79017_e.sentPacketCountArray) + ", Avg size: " + (int)this.calcArrayAverage(this.field_79017_e.sentPacketSizeArray);
        this.displayStrings[4] = "Avg rec: " + (int)this.calcArrayAverage(this.field_79017_e.receivedPacketCountArray) + ", Avg size: " + (int)this.calcArrayAverage(this.field_79017_e.receivedPacketSizeArray);

        if (this.field_79017_e.worldServers != null)
        {
            int j = 0;
            for (Integer id : DimensionManager.getIDs())
            {
                this.displayStrings[5 + j] = "Lvl " + id + " tick: " + field_79020_a.format(this.calcArrayAverage(this.field_79017_e.worldTickTimes.get(id)) * 1.0E-6D) + " ms";

                WorldServer world = DimensionManager.getWorld(id);
                if (world != null && world.theChunkProviderServer != null)
                {
                    this.displayStrings[5 + j] = this.displayStrings[5 + j] + ", " + world.theChunkProviderServer.makeString();
                    this.displayStrings[5 + j] = this.displayStrings[5 + j] + ", Vec3: " + world.getWorldVec3Pool().func_82590_d() + " / " + world.getWorldVec3Pool().getPoolSize();
                }
                j++;
            }
        }

        this.memoryUse[this.updateCounter++ & 255] = (int)(this.calcArrayAverage(this.field_79017_e.sentPacketSizeArray) * 100.0D / 12500.0D);
        this.repaint();
    }

    /**
     * Calculates the avarage value of the given long array.
     */
    private double calcArrayAverage(long[] par1ArrayOfLong)
    {
        long i = 0L;

        for (int j = 0; j < par1ArrayOfLong.length; ++j)
        {
            i += par1ArrayOfLong[j];
        }

        return (double)i / (double)par1ArrayOfLong.length;
    }

    public void paint(Graphics par1Graphics)
    {
        par1Graphics.setColor(new Color(16777215));
        par1Graphics.fillRect(0, 0, 456, 246);
        int i;

        for (i = 0; i < 256; ++i)
        {
            int j = this.memoryUse[i + this.updateCounter & 255];
            par1Graphics.setColor(new Color(j + 28 << 16));
            par1Graphics.fillRect(i, 100 - j, 1, j);
        }

        par1Graphics.setColor(Color.BLACK);

        for (i = 0; i < this.displayStrings.length; ++i)
        {
            String s = this.displayStrings[i];

            if (s != null)
            {
                par1Graphics.drawString(s, 32, 116 + i * 16);
            }
        }
    }

    /**
     * Public static accessor to call updateStats.
     */
    static void update(GuiStatsComponent par0GuiStatsComponent)
    {
        par0GuiStatsComponent.updateStats();
    }
}
