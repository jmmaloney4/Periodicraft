package net.minecraft.network.rcon;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConThreadBase;
import net.minecraft.network.rcon.RConThreadClient;

public class RConThreadMain extends RConThreadBase {

   private int field_72647_g;
   private int field_72651_h;
   private String field_72652_i;
   private ServerSocket field_72649_j = null;
   private String field_72650_k;
   private Map field_72648_l;


   public RConThreadMain(IServer p_i3408_1_) {
      super(p_i3408_1_);
      this.field_72647_g = p_i3408_1_.func_71327_a("rcon.port", 0);
      this.field_72650_k = p_i3408_1_.func_71330_a("rcon.password", "");
      this.field_72652_i = p_i3408_1_.func_71277_t();
      this.field_72651_h = p_i3408_1_.func_71234_u();
      if(0 == this.field_72647_g) {
         this.field_72647_g = this.field_72651_h + 10;
         this.func_72609_b("Setting default rcon port to " + this.field_72647_g);
         p_i3408_1_.func_71328_a("rcon.port", Integer.valueOf(this.field_72647_g));
         if(0 == this.field_72650_k.length()) {
            p_i3408_1_.func_71328_a("rcon.password", "");
         }

         p_i3408_1_.func_71326_a();
      }

      if(0 == this.field_72652_i.length()) {
         this.field_72652_i = "0.0.0.0";
      }

      this.func_72646_f();
      this.field_72649_j = null;
   }

   private void func_72646_f() {
      this.field_72648_l = new HashMap();
   }

   private void func_72645_g() {
      Iterator var1 = this.field_72648_l.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         if(!((RConThreadClient)var2.getValue()).func_72613_c()) {
            var1.remove();
         }
      }

   }

   public void run() {
      this.func_72609_b("RCON running on " + this.field_72652_i + ":" + this.field_72647_g);

      try {
         while(this.field_72619_a) {
            try {
               Socket var1 = this.field_72649_j.accept();
               var1.setSoTimeout(500);
               RConThreadClient var2 = new RConThreadClient(this.field_72617_b, var1);
               var2.func_72602_a();
               this.field_72648_l.put(var1.getRemoteSocketAddress(), var2);
               this.func_72645_g();
            } catch (SocketTimeoutException var7) {
               this.func_72645_g();
            } catch (IOException var8) {
               if(this.field_72619_a) {
                  this.func_72609_b("IO: " + var8.getMessage());
               }
            }
         }
      } finally {
         this.func_72608_b(this.field_72649_j);
      }

   }

   public void func_72602_a() {
      if(0 == this.field_72650_k.length()) {
         this.func_72606_c("No rcon password set in \'" + this.field_72617_b.func_71329_c() + "\', rcon disabled!");
      } else if(0 < this.field_72647_g && '\uffff' >= this.field_72647_g) {
         if(!this.field_72619_a) {
            try {
               this.field_72649_j = new ServerSocket(this.field_72647_g, 0, InetAddress.getByName(this.field_72652_i));
               this.field_72649_j.setSoTimeout(500);
               super.func_72602_a();
            } catch (IOException var2) {
               this.func_72606_c("Unable to initialise rcon on " + this.field_72652_i + ":" + this.field_72647_g + " : " + var2.getMessage());
            }

         }
      } else {
         this.func_72606_c("Invalid rcon port " + this.field_72647_g + " found in \'" + this.field_72617_b.func_71329_c() + "\', rcon disabled!");
      }
   }
}
