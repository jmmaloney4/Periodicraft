package net.minecraft.server.integrated;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.MemoryConnection;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerListenThread;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.HttpUtil;

@SideOnly(Side.CLIENT)
public class IntegratedServerListenThread extends NetworkListenThread {

   private final MemoryConnection field_71760_c;
   private MemoryConnection field_71758_d;
   private String field_71759_e;
   private boolean field_71756_f = false;
   private ServerListenThread field_71757_g;


   public IntegratedServerListenThread(IntegratedServer p_i3121_1_) throws IOException {
      super(p_i3121_1_);
      this.field_71760_c = new MemoryConnection(p_i3121_1_.func_98033_al(), (NetHandler)null);
   }

   public void func_71754_a(MemoryConnection p_71754_1_, String p_71754_2_) {
      this.field_71758_d = p_71754_1_;
      this.field_71759_e = p_71754_2_;
   }

   public String func_71755_c() throws IOException {
      if(this.field_71757_g == null) {
         int var1 = -1;

         try {
            var1 = HttpUtil.func_76181_a();
         } catch (IOException var4) {
            ;
         }

         if(var1 <= 0) {
            var1 = 25564;
         }

         try {
            this.field_71757_g = new ServerListenThread(this, (InetAddress)null, var1);
            this.field_71757_g.start();
         } catch (IOException var3) {
            throw var3;
         }
      }

      return this.field_71757_g.func_71767_c().getHostAddress() + ":" + this.field_71757_g.func_71765_d();
   }

   public void func_71744_a() {
      super.func_71744_a();
      if(this.field_71757_g != null) {
         this.func_71753_e().func_98033_al().func_98233_a("Stopping server connection");
         this.field_71757_g.func_71768_b();
         this.field_71757_g.interrupt();
         this.field_71757_g = null;
      }

   }

   public void func_71747_b() {
      if(this.field_71758_d != null) {
         EntityPlayerMP var1 = this.func_71753_e().func_71203_ab().func_72366_a(this.field_71759_e);
         if(var1 != null) {
            this.field_71760_c.func_74434_a(this.field_71758_d);
            this.field_71756_f = true;
            this.func_71753_e().func_71203_ab().func_72355_a(this.field_71760_c, var1);
         }

         this.field_71758_d = null;
         this.field_71759_e = null;
      }

      if(this.field_71757_g != null) {
         this.field_71757_g.func_71766_a();
      }

      super.func_71747_b();
   }

   public IntegratedServer func_71753_e() {
      return (IntegratedServer)super.func_71746_d();
   }

   public boolean func_71752_f() {
      return this.field_71756_f && this.field_71760_c.func_74432_i().func_74435_g() && this.field_71760_c.func_74432_i().func_74433_h();
   }

   // $FF: synthetic method
   public MinecraftServer func_71746_d() {
      return this.func_71753_e();
   }
}
