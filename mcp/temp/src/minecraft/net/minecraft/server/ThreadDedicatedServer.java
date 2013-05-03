package net.minecraft.server;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.dedicated.DedicatedServer;

@SideOnly(Side.SERVER)
public final class ThreadDedicatedServer extends Thread {

   // $FF: synthetic field
   final DedicatedServer field_96244_a;


   public ThreadDedicatedServer(DedicatedServer p_i11000_1_) {
      this.field_96244_a = p_i11000_1_;
   }

   public void run() {
      this.field_96244_a.func_71260_j();
   }
}
