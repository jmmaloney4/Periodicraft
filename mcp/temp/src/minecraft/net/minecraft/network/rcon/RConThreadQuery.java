package net.minecraft.network.rcon;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConOutputStream;
import net.minecraft.network.rcon.RConThreadBase;
import net.minecraft.network.rcon.RConThreadQueryAuth;
import net.minecraft.network.rcon.RConUtils;

public class RConThreadQuery extends RConThreadBase {

   private long field_72629_g;
   private int field_72636_h;
   private int field_72637_i;
   private int field_72634_j;
   private String field_72635_k;
   private String field_72632_l;
   private DatagramSocket field_72633_m = null;
   private byte[] field_72630_n = new byte[1460];
   private DatagramPacket field_72631_o = null;
   private Map field_72644_p;
   private String field_72643_q;
   private String field_72642_r;
   private Map field_72641_s;
   private long field_72640_t;
   private RConOutputStream field_72639_u;
   private long field_72638_v;


   public RConThreadQuery(IServer p_i3406_1_) {
      super(p_i3406_1_);
      this.field_72636_h = p_i3406_1_.func_71327_a("query.port", 0);
      this.field_72642_r = p_i3406_1_.func_71277_t();
      this.field_72637_i = p_i3406_1_.func_71234_u();
      this.field_72635_k = p_i3406_1_.func_71274_v();
      this.field_72634_j = p_i3406_1_.func_71275_y();
      this.field_72632_l = p_i3406_1_.func_71270_I();
      this.field_72638_v = 0L;
      this.field_72643_q = "0.0.0.0";
      if(0 != this.field_72642_r.length() && !this.field_72643_q.equals(this.field_72642_r)) {
         this.field_72643_q = this.field_72642_r;
      } else {
         this.field_72642_r = "0.0.0.0";

         try {
            InetAddress var2 = InetAddress.getLocalHost();
            this.field_72643_q = var2.getHostAddress();
         } catch (UnknownHostException var3) {
            this.func_72606_c("Unable to determine local host IP, please set server-ip in \'" + p_i3406_1_.func_71329_c() + "\' : " + var3.getMessage());
         }
      }

      if(0 == this.field_72636_h) {
         this.field_72636_h = this.field_72637_i;
         this.func_72609_b("Setting default query port to " + this.field_72636_h);
         p_i3406_1_.func_71328_a("query.port", Integer.valueOf(this.field_72636_h));
         p_i3406_1_.func_71328_a("debug", Boolean.valueOf(false));
         p_i3406_1_.func_71326_a();
      }

      this.field_72644_p = new HashMap();
      this.field_72639_u = new RConOutputStream(1460);
      this.field_72641_s = new HashMap();
      this.field_72640_t = (new Date()).getTime();
   }

   private void func_72620_a(byte[] p_72620_1_, DatagramPacket p_72620_2_) throws IOException {
      this.field_72633_m.send(new DatagramPacket(p_72620_1_, p_72620_1_.length, p_72620_2_.getSocketAddress()));
   }

   private boolean func_72621_a(DatagramPacket p_72621_1_) throws IOException {
      byte[] var2 = p_72621_1_.getData();
      int var3 = p_72621_1_.getLength();
      SocketAddress var4 = p_72621_1_.getSocketAddress();
      this.func_72607_a("Packet len " + var3 + " [" + var4 + "]");
      if(3 <= var3 && -2 == var2[0] && -3 == var2[1]) {
         this.func_72607_a("Packet \'" + RConUtils.func_72663_a(var2[2]) + "\' [" + var4 + "]");
         switch(var2[2]) {
         case 0:
            if(!this.func_72627_c(p_72621_1_).booleanValue()) {
               this.func_72607_a("Invalid challenge [" + var4 + "]");
               return false;
            } else if(15 == var3) {
               this.func_72620_a(this.func_72624_b(p_72621_1_), p_72621_1_);
               this.func_72607_a("Rules [" + var4 + "]");
            } else {
               RConOutputStream var5 = new RConOutputStream(1460);
               var5.func_72667_a(0);
               var5.func_72670_a(this.func_72625_a(p_72621_1_.getSocketAddress()));
               var5.func_72671_a(this.field_72635_k);
               var5.func_72671_a("SMP");
               var5.func_72671_a(this.field_72632_l);
               var5.func_72671_a(Integer.toString(this.func_72603_d()));
               var5.func_72671_a(Integer.toString(this.field_72634_j));
               var5.func_72668_a((short)this.field_72637_i);
               var5.func_72671_a(this.field_72643_q);
               this.func_72620_a(var5.func_72672_a(), p_72621_1_);
               this.func_72607_a("Status [" + var4 + "]");
            }
         case 9:
            this.func_72622_d(p_72621_1_);
            this.func_72607_a("Challenge [" + var4 + "]");
            return true;
         default:
            return true;
         }
      } else {
         this.func_72607_a("Invalid packet [" + var4 + "]");
         return false;
      }
   }

   private byte[] func_72624_b(DatagramPacket p_72624_1_) throws IOException {
      long var2 = System.currentTimeMillis();
      if(var2 < this.field_72638_v + 5000L) {
         byte[] var7 = this.field_72639_u.func_72672_a();
         byte[] var8 = this.func_72625_a(p_72624_1_.getSocketAddress());
         var7[1] = var8[0];
         var7[2] = var8[1];
         var7[3] = var8[2];
         var7[4] = var8[3];
         return var7;
      } else {
         this.field_72638_v = var2;
         this.field_72639_u.func_72669_b();
         this.field_72639_u.func_72667_a(0);
         this.field_72639_u.func_72670_a(this.func_72625_a(p_72624_1_.getSocketAddress()));
         this.field_72639_u.func_72671_a("splitnum");
         this.field_72639_u.func_72667_a(128);
         this.field_72639_u.func_72667_a(0);
         this.field_72639_u.func_72671_a("hostname");
         this.field_72639_u.func_72671_a(this.field_72635_k);
         this.field_72639_u.func_72671_a("gametype");
         this.field_72639_u.func_72671_a("SMP");
         this.field_72639_u.func_72671_a("game_id");
         this.field_72639_u.func_72671_a("MINECRAFT");
         this.field_72639_u.func_72671_a("version");
         this.field_72639_u.func_72671_a(this.field_72617_b.func_71249_w());
         this.field_72639_u.func_72671_a("plugins");
         this.field_72639_u.func_72671_a(this.field_72617_b.func_71258_A());
         this.field_72639_u.func_72671_a("map");
         this.field_72639_u.func_72671_a(this.field_72632_l);
         this.field_72639_u.func_72671_a("numplayers");
         this.field_72639_u.func_72671_a("" + this.func_72603_d());
         this.field_72639_u.func_72671_a("maxplayers");
         this.field_72639_u.func_72671_a("" + this.field_72634_j);
         this.field_72639_u.func_72671_a("hostport");
         this.field_72639_u.func_72671_a("" + this.field_72637_i);
         this.field_72639_u.func_72671_a("hostip");
         this.field_72639_u.func_72671_a(this.field_72643_q);
         this.field_72639_u.func_72667_a(0);
         this.field_72639_u.func_72667_a(1);
         this.field_72639_u.func_72671_a("player_");
         this.field_72639_u.func_72667_a(0);
         String[] var4 = this.field_72617_b.func_71213_z();
         byte var5 = (byte)var4.length;

         for(byte var6 = (byte)(var5 - 1); var6 >= 0; --var6) {
            this.field_72639_u.func_72671_a(var4[var6]);
         }

         this.field_72639_u.func_72667_a(0);
         return this.field_72639_u.func_72672_a();
      }
   }

   private byte[] func_72625_a(SocketAddress p_72625_1_) {
      return ((RConThreadQueryAuth)this.field_72641_s.get(p_72625_1_)).func_72591_c();
   }

   private Boolean func_72627_c(DatagramPacket p_72627_1_) {
      SocketAddress var2 = p_72627_1_.getSocketAddress();
      if(!this.field_72641_s.containsKey(var2)) {
         return Boolean.valueOf(false);
      } else {
         byte[] var3 = p_72627_1_.getData();
         return ((RConThreadQueryAuth)this.field_72641_s.get(var2)).func_72592_a() != RConUtils.func_72664_c(var3, 7, p_72627_1_.getLength())?Boolean.valueOf(false):Boolean.valueOf(true);
      }
   }

   private void func_72622_d(DatagramPacket p_72622_1_) throws IOException {
      RConThreadQueryAuth var2 = new RConThreadQueryAuth(this, p_72622_1_);
      this.field_72641_s.put(p_72622_1_.getSocketAddress(), var2);
      this.func_72620_a(var2.func_72594_b(), p_72622_1_);
   }

   private void func_72628_f() {
      if(this.field_72619_a) {
         long var1 = System.currentTimeMillis();
         if(var1 >= this.field_72629_g + 30000L) {
            this.field_72629_g = var1;
            Iterator var3 = this.field_72641_s.entrySet().iterator();

            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               if(((RConThreadQueryAuth)var4.getValue()).func_72593_a(var1).booleanValue()) {
                  var3.remove();
               }
            }

         }
      }
   }

   public void run() {
      this.func_72609_b("Query running on " + this.field_72642_r + ":" + this.field_72636_h);
      this.field_72629_g = System.currentTimeMillis();
      this.field_72631_o = new DatagramPacket(this.field_72630_n, this.field_72630_n.length);

      try {
         while(this.field_72619_a) {
            try {
               this.field_72633_m.receive(this.field_72631_o);
               this.func_72628_f();
               this.func_72621_a(this.field_72631_o);
            } catch (SocketTimeoutException var7) {
               this.func_72628_f();
            } catch (PortUnreachableException var8) {
               ;
            } catch (IOException var9) {
               this.func_72623_a(var9);
            }
         }
      } finally {
         this.func_72611_e();
      }

   }

   public void func_72602_a() {
      if(!this.field_72619_a) {
         if(0 < this.field_72636_h && '\uffff' >= this.field_72636_h) {
            if(this.func_72626_g()) {
               super.func_72602_a();
            }

         } else {
            this.func_72606_c("Invalid query port " + this.field_72636_h + " found in \'" + this.field_72617_b.func_71329_c() + "\' (queries disabled)");
         }
      }
   }

   private void func_72623_a(Exception p_72623_1_) {
      if(this.field_72619_a) {
         this.func_72606_c("Unexpected exception, buggy JRE? (" + p_72623_1_.toString() + ")");
         if(!this.func_72626_g()) {
            this.func_72610_d("Failed to recover from buggy JRE, shutting down!");
            this.field_72619_a = false;
         }

      }
   }

   private boolean func_72626_g() {
      try {
         this.field_72633_m = new DatagramSocket(this.field_72636_h, InetAddress.getByName(this.field_72642_r));
         this.func_72601_a(this.field_72633_m);
         this.field_72633_m.setSoTimeout(500);
         return true;
      } catch (SocketException var2) {
         this.func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (Socket): " + var2.getMessage());
      } catch (UnknownHostException var3) {
         this.func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (Unknown Host): " + var3.getMessage());
      } catch (Exception var4) {
         this.func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (E): " + var4.getMessage());
      }

      return false;
   }
}
