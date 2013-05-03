package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class ThreadLanServerPing extends Thread {

   private final String field_77528_b;
   private final DatagramSocket field_77529_c;
   private boolean field_77526_d = true;
   private final String field_77527_e;


   public ThreadLanServerPing(String p_i3124_1_, String p_i3124_2_) throws IOException {
      super("LanServerPinger");
      this.field_77528_b = p_i3124_1_;
      this.field_77527_e = p_i3124_2_;
      this.setDaemon(true);
      this.field_77529_c = new DatagramSocket();
   }

   public void run() {
      String var1 = func_77525_a(this.field_77528_b, this.field_77527_e);
      byte[] var2 = var1.getBytes();

      while(!this.isInterrupted() && this.field_77526_d) {
         try {
            InetAddress var3 = InetAddress.getByName("224.0.2.60");
            DatagramPacket var4 = new DatagramPacket(var2, var2.length, var3, 4445);
            this.field_77529_c.send(var4);
         } catch (IOException var6) {
            Minecraft.func_71410_x().func_98033_al().func_98236_b("LanServerPinger: " + var6.getMessage());
            break;
         }

         try {
            sleep(1500L);
         } catch (InterruptedException var5) {
            ;
         }
      }

   }

   public void interrupt() {
      super.interrupt();
      this.field_77526_d = false;
   }

   public static String func_77525_a(String p_77525_0_, String p_77525_1_) {
      return "[MOTD]" + p_77525_0_ + "[/MOTD][AD]" + p_77525_1_ + "[/AD]";
   }

   public static String func_77524_a(String p_77524_0_) {
      int var1 = p_77524_0_.indexOf("[MOTD]");
      if(var1 < 0) {
         return "missing no";
      } else {
         int var2 = p_77524_0_.indexOf("[/MOTD]", var1 + "[MOTD]".length());
         return var2 < var1?"missing no":p_77524_0_.substring(var1 + "[MOTD]".length(), var2);
      }
   }

   public static String func_77523_b(String p_77523_0_) {
      int var1 = p_77523_0_.indexOf("[/MOTD]");
      if(var1 < 0) {
         return null;
      } else {
         int var2 = p_77523_0_.indexOf("[/MOTD]", var1 + "[/MOTD]".length());
         if(var2 >= 0) {
            return null;
         } else {
            int var3 = p_77523_0_.indexOf("[AD]", var1 + "[/MOTD]".length());
            if(var3 < 0) {
               return null;
            } else {
               int var4 = p_77523_0_.indexOf("[/AD]", var3 + "[AD]".length());
               return var4 < var3?null:p_77523_0_.substring(var3 + "[AD]".length(), var4);
            }
         }
      }
   }
}
