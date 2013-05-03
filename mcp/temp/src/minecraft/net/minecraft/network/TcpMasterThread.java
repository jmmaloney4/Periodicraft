package net.minecraft.network;

import net.minecraft.network.TcpConnection;

class TcpMasterThread extends Thread {

   // $FF: synthetic field
   final TcpConnection field_74504_a;


   TcpMasterThread(TcpConnection p_i3285_1_) {
      this.field_74504_a = p_i3285_1_;
   }

   public void run() {
      try {
         Thread.sleep(5000L);
         if(TcpConnection.func_74457_g(this.field_74504_a).isAlive()) {
            try {
               TcpConnection.func_74457_g(this.field_74504_a).stop();
            } catch (Throwable var3) {
               ;
            }
         }

         if(TcpConnection.func_74461_h(this.field_74504_a).isAlive()) {
            try {
               TcpConnection.func_74461_h(this.field_74504_a).stop();
            } catch (Throwable var2) {
               ;
            }
         }
      } catch (InterruptedException var4) {
         var4.printStackTrace();
      }

   }
}
