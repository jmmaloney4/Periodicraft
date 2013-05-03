package net.minecraft.network;

import java.io.IOException;
import net.minecraft.network.TcpConnection;

class TcpWriterThread extends Thread {

   // $FF: synthetic field
   final TcpConnection field_74501_a;


   TcpWriterThread(TcpConnection p_i3284_1_, String p_i3284_2_) {
      super(p_i3284_2_);
      this.field_74501_a = p_i3284_1_;
   }

   public void run() {
      TcpConnection.field_74469_b.getAndIncrement();

      try {
         while(TcpConnection.func_74462_a(this.field_74501_a)) {
            boolean var1;
            for(var1 = false; TcpConnection.func_74451_d(this.field_74501_a); var1 = true) {
               ;
            }

            try {
               if(var1 && TcpConnection.func_74453_e(this.field_74501_a) != null) {
                  TcpConnection.func_74453_e(this.field_74501_a).flush();
               }
            } catch (IOException var8) {
               if(!TcpConnection.func_74456_f(this.field_74501_a)) {
                  TcpConnection.func_74458_a(this.field_74501_a, var8);
               }

               var8.printStackTrace();
            }

            try {
               sleep(2L);
            } catch (InterruptedException var7) {
               ;
            }
         }
      } finally {
         TcpConnection.field_74469_b.getAndDecrement();
      }

   }
}
