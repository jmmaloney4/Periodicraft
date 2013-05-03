package net.minecraft.network.rcon;

import java.net.DatagramPacket;
import java.util.Date;
import java.util.Random;
import net.minecraft.network.rcon.RConThreadQuery;

class RConThreadQueryAuth {

   private long field_72598_b;
   private int field_72599_c;
   private byte[] field_72596_d;
   private byte[] field_72597_e;
   private String field_72595_f;
   // $FF: synthetic field
   final RConThreadQuery field_72600_a;


   public RConThreadQueryAuth(RConThreadQuery p_i3405_1_, DatagramPacket p_i3405_2_) {
      this.field_72600_a = p_i3405_1_;
      this.field_72598_b = (new Date()).getTime();
      byte[] var3 = p_i3405_2_.getData();
      this.field_72596_d = new byte[4];
      this.field_72596_d[0] = var3[3];
      this.field_72596_d[1] = var3[4];
      this.field_72596_d[2] = var3[5];
      this.field_72596_d[3] = var3[6];
      this.field_72595_f = new String(this.field_72596_d);
      this.field_72599_c = (new Random()).nextInt(16777216);
      this.field_72597_e = String.format("\t%s%d\u0000", new Object[]{this.field_72595_f, Integer.valueOf(this.field_72599_c)}).getBytes();
   }

   public Boolean func_72593_a(long p_72593_1_) {
      return Boolean.valueOf(this.field_72598_b < p_72593_1_);
   }

   public int func_72592_a() {
      return this.field_72599_c;
   }

   public byte[] func_72594_b() {
      return this.field_72597_e;
   }

   public byte[] func_72591_c() {
      return this.field_72596_d;
   }
}
