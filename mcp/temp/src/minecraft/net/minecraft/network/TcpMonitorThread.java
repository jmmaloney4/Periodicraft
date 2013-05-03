package net.minecraft.network;

import net.minecraft.network.TcpConnection;

class TcpMonitorThread extends Thread {

   // $FF: synthetic field
   final TcpConnection field_74417_a;


   TcpMonitorThread(TcpConnection p_i3286_1_) {
      this.field_74417_a = p_i3286_1_;
   }

   public void run() {
      try {
         Thread.sleep(2000L);
         if(TcpConnection.func_74462_a(this.field_74417_a)) {
            TcpConnection.func_74461_h(this.field_74417_a).interrupt();
            this.field_74417_a.func_74424_a("disconnect.closed", new Object[0]);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }
}
