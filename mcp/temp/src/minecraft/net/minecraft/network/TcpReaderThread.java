package net.minecraft.network;

import net.minecraft.network.TcpConnection;

class TcpReaderThread extends Thread {

   // $FF: synthetic field
   final TcpConnection field_74498_a;


   TcpReaderThread(TcpConnection p_i3283_1_, String p_i3283_2_) {
      super(p_i3283_2_);
      this.field_74498_a = p_i3283_1_;
   }

   public void run() {
      TcpConnection.field_74471_a.getAndIncrement();

      try {
         while(TcpConnection.func_74462_a(this.field_74498_a) && !TcpConnection.func_74449_b(this.field_74498_a)) {
            while(true) {
               if(!TcpConnection.func_74450_c(this.field_74498_a)) {
                  try {
                     sleep(2L);
                  } catch (InterruptedException var5) {
                     ;
                  }
               }
            }
         }
      } finally {
         TcpConnection.field_74471_a.getAndDecrement();
      }

   }
}
