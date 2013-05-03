package net.minecraft.network.rcon;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.rcon.IServer;

public abstract class RConThreadBase implements Runnable {

   protected boolean field_72619_a = false;
   protected IServer field_72617_b;
   protected Thread field_72618_c;
   protected int field_72615_d = 5;
   protected List field_72616_e = new ArrayList();
   protected List field_72614_f = new ArrayList();


   RConThreadBase(IServer p_i3404_1_) {
      this.field_72617_b = p_i3404_1_;
      if(this.field_72617_b.func_71239_B()) {
         this.func_72606_c("Debugging is enabled, performance maybe reduced!");
      }

   }

   public synchronized void func_72602_a() {
      this.field_72618_c = new Thread(this);
      this.field_72618_c.start();
      this.field_72619_a = true;
   }

   public boolean func_72613_c() {
      return this.field_72619_a;
   }

   protected void func_72607_a(String p_72607_1_) {
      this.field_72617_b.func_71198_k(p_72607_1_);
   }

   protected void func_72609_b(String p_72609_1_) {
      this.field_72617_b.func_71244_g(p_72609_1_);
   }

   protected void func_72606_c(String p_72606_1_) {
      this.field_72617_b.func_71236_h(p_72606_1_);
   }

   protected void func_72610_d(String p_72610_1_) {
      this.field_72617_b.func_71201_j(p_72610_1_);
   }

   protected int func_72603_d() {
      return this.field_72617_b.func_71233_x();
   }

   protected void func_72601_a(DatagramSocket p_72601_1_) {
      this.func_72607_a("registerSocket: " + p_72601_1_);
      this.field_72616_e.add(p_72601_1_);
   }

   protected boolean func_72604_a(DatagramSocket p_72604_1_, boolean p_72604_2_) {
      this.func_72607_a("closeSocket: " + p_72604_1_);
      if(null == p_72604_1_) {
         return false;
      } else {
         boolean var3 = false;
         if(!p_72604_1_.isClosed()) {
            p_72604_1_.close();
            var3 = true;
         }

         if(p_72604_2_) {
            this.field_72616_e.remove(p_72604_1_);
         }

         return var3;
      }
   }

   protected boolean func_72608_b(ServerSocket p_72608_1_) {
      return this.func_72605_a(p_72608_1_, true);
   }

   protected boolean func_72605_a(ServerSocket p_72605_1_, boolean p_72605_2_) {
      this.func_72607_a("closeSocket: " + p_72605_1_);
      if(null == p_72605_1_) {
         return false;
      } else {
         boolean var3 = false;

         try {
            if(!p_72605_1_.isClosed()) {
               p_72605_1_.close();
               var3 = true;
            }
         } catch (IOException var5) {
            this.func_72606_c("IO: " + var5.getMessage());
         }

         if(p_72605_2_) {
            this.field_72614_f.remove(p_72605_1_);
         }

         return var3;
      }
   }

   protected void func_72611_e() {
      this.func_72612_a(false);
   }

   protected void func_72612_a(boolean p_72612_1_) {
      int var2 = 0;
      Iterator var3 = this.field_72616_e.iterator();

      while(var3.hasNext()) {
         DatagramSocket var4 = (DatagramSocket)var3.next();
         if(this.func_72604_a(var4, false)) {
            ++var2;
         }
      }

      this.field_72616_e.clear();
      var3 = this.field_72614_f.iterator();

      while(var3.hasNext()) {
         ServerSocket var5 = (ServerSocket)var3.next();
         if(this.func_72605_a(var5, false)) {
            ++var2;
         }
      }

      this.field_72614_f.clear();
      if(p_72612_1_ && 0 < var2) {
         this.func_72606_c("Force closed " + var2 + " sockets");
      }

   }
}
