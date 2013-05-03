package net.minecraft.server.dedicated;

import net.minecraft.server.dedicated.DedicatedServer;

class DedicatedServerSleepThread extends Thread {

   // $FF: synthetic field
   final DedicatedServer field_72451_a;


   DedicatedServerSleepThread(DedicatedServer p_i3379_1_) {
      this.field_72451_a = p_i3379_1_;
      this.setDaemon(true);
      this.start();
   }

   public void run() {
      while(true) {
         try {
            while(true) {
               Thread.sleep(2147483647L);
            }
         } catch (InterruptedException var2) {
            ;
         }
      }
   }
}
