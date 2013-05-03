package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.LanServerList;

@SideOnly(Side.CLIENT)
public class ThreadLanServerFind extends Thread {

   private final LanServerList field_77500_a;
   private final InetAddress field_77498_b;
   private final MulticastSocket field_77499_c;


   public ThreadLanServerFind(LanServerList p_i3122_1_) throws IOException {
      super("LanServerDetector");
      this.field_77500_a = p_i3122_1_;
      this.setDaemon(true);
      this.field_77499_c = new MulticastSocket(4445);
      this.field_77498_b = InetAddress.getByName("224.0.2.60");
      this.field_77499_c.setSoTimeout(5000);
      this.field_77499_c.joinGroup(this.field_77498_b);
   }

   public void run() {
      byte[] var2 = new byte[1024];

      while(!this.isInterrupted()) {
         DatagramPacket var1 = new DatagramPacket(var2, var2.length);

         try {
            this.field_77499_c.receive(var1);
         } catch (SocketTimeoutException var5) {
            continue;
         } catch (IOException var6) {
            var6.printStackTrace();
            break;
         }

         String var3 = new String(var1.getData(), var1.getOffset(), var1.getLength());
         Minecraft.func_71410_x().func_98033_al().func_98230_d(var1.getAddress() + ": " + var3);
         this.field_77500_a.func_77551_a(var3, var1.getAddress());
      }

      try {
         this.field_77499_c.leaveGroup(this.field_77498_b);
      } catch (IOException var4) {
         ;
      }

      this.field_77499_c.close();
   }
}
