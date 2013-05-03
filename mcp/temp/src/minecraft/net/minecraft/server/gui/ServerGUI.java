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
import net.minecraft.server.gui.GuiLogOutputHandler;
import net.minecraft.server.gui.GuiStatsComponent;
import net.minecraft.server.gui.PlayerListBox;
import net.minecraft.server.gui.ServerGuiCommandListener;
import net.minecraft.server.gui.ServerGuiFocusAdapter;
import net.minecraft.server.gui.ServerWindowAdapter;

@SideOnly(Side.SERVER)
public class ServerGUI extends JComponent {

   private static boolean field_79008_b = false;
   private DedicatedServer field_79009_c;


   public static void func_79003_a(DedicatedServer p_79003_0_) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var3) {
         ;
      }

      ServerGUI var1 = new ServerGUI(p_79003_0_);
      field_79008_b = true;
      JFrame var2 = new JFrame("Minecraft server");
      var2.add(var1);
      var2.pack();
      var2.setLocationRelativeTo((Component)null);
      var2.setVisible(true);
      var2.addWindowListener(new ServerWindowAdapter(p_79003_0_));
   }

   public ServerGUI(DedicatedServer p_i4106_1_) {
      this.field_79009_c = p_i4106_1_;
      this.setPreferredSize(new Dimension(854, 480));
      this.setLayout(new BorderLayout());

      try {
         this.add(this.func_79005_d(), "Center");
         this.add(this.func_79006_b(), "West");
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   private JComponent func_79006_b() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(new GuiStatsComponent(this.field_79009_c), "North");
      var1.add(this.func_79007_c(), "Center");
      var1.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
      return var1;
   }

   private JComponent func_79007_c() {
      PlayerListBox var1 = new PlayerListBox(this.field_79009_c);
      JScrollPane var2 = new JScrollPane(var1, 22, 30);
      var2.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
      return var2;
   }

   private JComponent func_79005_d() {
      JPanel var1 = new JPanel(new BorderLayout());
      JTextArea var2 = new JTextArea();
      this.field_79009_c.func_98033_al().func_98076_a().addHandler(new GuiLogOutputHandler(var2));
      JScrollPane var3 = new JScrollPane(var2, 22, 30);
      var2.setEditable(false);
      JTextField var4 = new JTextField();
      var4.addActionListener(new ServerGuiCommandListener(this, var4));
      var2.addFocusListener(new ServerGuiFocusAdapter(this));
      var1.add(var3, "Center");
      var1.add(var4, "South");
      var1.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
      return var1;
   }

   // $FF: synthetic method
   static DedicatedServer func_79004_a(ServerGUI p_79004_0_) {
      return p_79004_0_.field_79009_c;
   }

}
