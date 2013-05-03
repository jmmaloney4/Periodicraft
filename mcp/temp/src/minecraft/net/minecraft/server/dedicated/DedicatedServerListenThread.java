package net.minecraft.server.dedicated;

import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerListenThread;
import net.minecraft.server.dedicated.DedicatedServer;

public class DedicatedServerListenThread extends NetworkListenThread {

   private final ServerListenThread field_71763_c;


   public DedicatedServerListenThread(MinecraftServer p_i3383_1_, InetAddress p_i3383_2_, int p_i3383_3_) throws IOException {
      super(p_i3383_1_);
      this.field_71763_c = new ServerListenThread(this, p_i3383_2_, p_i3383_3_);
      this.field_71763_c.start();
   }

   public void func_71744_a() {
      super.func_71744_a();
      this.field_71763_c.func_71768_b();
      this.field_71763_c.interrupt();
   }

   public void func_71747_b() {
      this.field_71763_c.func_71766_a();
      super.func_71747_b();
   }

   public DedicatedServer func_71762_c() {
      return (DedicatedServer)super.func_71746_d();
   }

   public void func_71761_a(InetAddress p_71761_1_) {
      this.field_71763_c.func_71769_a(p_71761_1_);
   }

   // $FF: synthetic method
   public MinecraftServer func_71746_d() {
      return this.func_71762_c();
   }
}
