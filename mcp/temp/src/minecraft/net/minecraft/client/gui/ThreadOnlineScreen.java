package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreenOnlineServers;
import net.minecraft.client.mco.McoClient;

@SideOnly(Side.CLIENT)
class ThreadOnlineScreen extends Thread {

   // $FF: synthetic field
   final GuiScreenOnlineServers field_98173_a;


   ThreadOnlineScreen(GuiScreenOnlineServers p_i11011_1_) {
      this.field_98173_a = p_i11011_1_;
   }

   public void run() {
      McoClient var1 = new McoClient(GuiScreenOnlineServers.func_96177_a(this.field_98173_a).field_71449_j);

      try {
         GuiScreenOnlineServers.func_98081_a(this.field_98173_a, var1.func_96379_c());
      } catch (Exception var3) {
         GuiScreenOnlineServers.func_98081_a(this.field_98173_a, 0);
      }

   }
}
