package net.minecraft.server;

import net.minecraft.server.MinecraftServer;

public class ThreadMinecraftServer extends Thread {

   // $FF: synthetic field
   final MinecraftServer field_73716_a;


   public ThreadMinecraftServer(MinecraftServer p_i10043_1_, String p_i10043_2_) {
      super(p_i10043_2_);
      this.field_73716_a = p_i10043_1_;
   }

   public void run() {
      this.field_73716_a.run();
   }
}
