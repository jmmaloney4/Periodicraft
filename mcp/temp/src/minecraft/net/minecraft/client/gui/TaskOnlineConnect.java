package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.gui.ThreadOnlineConnect;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerAddress;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class TaskOnlineConnect extends TaskLongRunning {

   private NetClientHandler field_96586_a;
   private final McoServer field_96585_c;
   private final GuiScreen field_96584_d;


   public TaskOnlineConnect(GuiScreen p_i10014_1_, McoServer p_i10014_2_) {
      this.field_96584_d = p_i10014_1_;
      this.field_96585_c = p_i10014_2_;
   }

   public void run() {
      this.func_96576_b(StringTranslate.func_74808_a().func_74805_b("mco.connect.connecting"));
      McoClient var1 = new McoClient(this.func_96578_b().field_71449_j);
      boolean var2 = false;
      boolean var3 = false;
      McoServerAddress var4 = null;

      for(int var5 = 0; var5 < 10 && !this.func_96577_c(); ++var5) {
         try {
            var4 = var1.func_96374_a(this.field_96585_c.field_96408_a);
            var2 = true;
         } catch (ExceptionRetryCall var7) {
            ;
         } catch (ExceptionMcoService var8) {
            var3 = true;
            this.func_96575_a(var8.getLocalizedMessage());
            break;
         } catch (IOException var9) {
            ;
         } catch (Exception var10) {
            var3 = true;
            this.func_96575_a(var10.getLocalizedMessage());
         }

         if(var2) {
            break;
         }

         this.func_96581_e();
      }

      if(!this.func_96577_c() && !var3) {
         if(var2) {
            ServerAddress var11 = ServerAddress.func_78860_a(var4.field_96417_a);
            this.func_96582_a(var11.func_78861_a(), var11.func_78864_b());
         } else {
            this.func_96578_b().func_71373_a(this.field_96584_d);
         }
      }

   }

   private void func_96581_e() {
      try {
         Thread.sleep(5000L);
      } catch (InterruptedException var2) {
         System.err.println(var2);
      }

   }

   private void func_96582_a(String p_96582_1_, int p_96582_2_) {
      (new ThreadOnlineConnect(this, p_96582_1_, p_96582_2_)).start();
   }

   public void func_96573_a() {
      if(this.field_96586_a != null) {
         this.field_96586_a.func_72551_d();
      }

   }

   // $FF: synthetic method
   static NetClientHandler func_96583_a(TaskOnlineConnect p_96583_0_, NetClientHandler p_96583_1_) {
      return p_96583_0_.field_96586_a = p_96583_1_;
   }

   // $FF: synthetic method
   static GuiScreen func_98172_a(TaskOnlineConnect p_98172_0_) {
      return p_98172_0_.field_96584_d;
   }

   // $FF: synthetic method
   static NetClientHandler func_96580_a(TaskOnlineConnect p_96580_0_) {
      return p_96580_0_.field_96586_a;
   }
}
