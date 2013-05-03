package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.gui.GuiScreenDisconnectedOnline;
import net.minecraft.client.gui.TaskOnlineConnect;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.network.packet.Packet2ClientProtocol;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class ThreadOnlineConnect extends Thread {

   // $FF: synthetic field
   final String field_96595_a;
   // $FF: synthetic field
   final int field_96593_b;
   // $FF: synthetic field
   final TaskOnlineConnect field_96594_c;


   ThreadOnlineConnect(TaskOnlineConnect p_i10018_1_, String p_i10018_2_, int p_i10018_3_) {
      this.field_96594_c = p_i10018_1_;
      this.field_96595_a = p_i10018_2_;
      this.field_96593_b = p_i10018_3_;
   }

   public void run() {
      try {
         TaskOnlineConnect.func_96583_a(this.field_96594_c, new NetClientHandler(this.field_96594_c.func_96578_b(), this.field_96595_a, this.field_96593_b, TaskOnlineConnect.func_98172_a(this.field_96594_c)));
         if(this.field_96594_c.func_96577_c()) {
            return;
         }

         this.field_96594_c.func_96576_b(StringTranslate.func_74808_a().func_74805_b("mco.connect.authorizing"));
         TaskOnlineConnect.func_96580_a(this.field_96594_c).func_72552_c(new Packet2ClientProtocol(60, this.field_96594_c.func_96578_b().field_71449_j.field_74286_b, this.field_96595_a, this.field_96593_b));
      } catch (UnknownHostException var2) {
         if(this.field_96594_c.func_96577_c()) {
            return;
         }

         this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[]{"Unknown host \'" + this.field_96595_a + "\'"}));
      } catch (ConnectException var3) {
         if(this.field_96594_c.func_96577_c()) {
            return;
         }

         this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[]{var3.getMessage()}));
      } catch (Exception var4) {
         if(this.field_96594_c.func_96577_c()) {
            return;
         }

         var4.printStackTrace();
         this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[]{var4.toString()}));
      }

   }
}
