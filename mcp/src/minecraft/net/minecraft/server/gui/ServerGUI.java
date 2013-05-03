package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.minecraft.server.dedicated.DedicatedServer;

@SideOnly(Side.SERVER)
public class ServerGUI extends JComponent
{
    /** This is set to true after server GUI window has been initialized. */
    private static boolean serverGuiInitialized = false;
    private DedicatedServer serverInstance;

    /**
     * Sets up the server GUI
     */
    public static void initGUI(DedicatedServer par0DedicatedServer)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception)
        {
            ;
        }

        ServerGUI servergui = new ServerGUI(par0DedicatedServer);
        serverGuiInitialized = true;
        JFrame jframe = new JFrame("Minecraft server");
        jframe.add(servergui);
        jframe.pack();
        jframe.setLocationRelativeTo((Component)null);
        jframe.setVisible(true);
        jframe.addWindowListener(new ServerWindowAdapter(par0DedicatedServer));
    }

    public ServerGUI(DedicatedServer par1DedicatedServer)
    {
        this.serverInstance = par1DedicatedServer;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());

        try
        {
            this.add(this.getLogComponent(), "Center");
            this.add(this.getStatsComponent(), "West");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Returns a new JPanel with a new GuiStatsComponent inside.
     */
    private JComponent getStatsComponent()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        jpanel.add(new GuiStatsComponent(this.serverInstance), "North");
        jpanel.add(this.getPlayerListComponent(), "Center");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return jpanel;
    }

    /**
     * Returns a new JScrollPane with a new PlayerListBox inside.
     */
    private JComponent getPlayerListComponent()
    {
        PlayerListBox playerlistbox = new PlayerListBox(this.serverInstance);
        JScrollPane jscrollpane = new JScrollPane(playerlistbox, 22, 30);
        jscrollpane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return jscrollpane;
    }

    /**
     * Returns a new JPanel with a new GuiStatsComponent inside.
     */
    private JComponent getLogComponent()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        JTextArea jtextarea = new JTextArea();
        this.serverInstance.getLogAgent().getServerLogger().addHandler(new GuiLogOutputHandler(jtextarea));
        JScrollPane jscrollpane = new JScrollPane(jtextarea, 22, 30);
        jtextarea.setEditable(false);
        JTextField jtextfield = new JTextField();
        jtextfield.addActionListener(new ServerGuiCommandListener(this, jtextfield));
        jtextarea.addFocusListener(new ServerGuiFocusAdapter(this));
        jpanel.add(jscrollpane, "Center");
        jpanel.add(jtextfield, "South");
        jpanel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        return jpanel;
    }

    static DedicatedServer getDedicatedServer(ServerGUI par0ServerGUI)
    {
        return par0ServerGUI.serverInstance;
    }
}
