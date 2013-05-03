package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet71Weather extends Packet {

   public int field_73538_a;
   public int field_73536_b;
   public int field_73537_c;
   public int field_73534_d;
   public int field_73535_e;


   public Packet71Weather() {}

   public Packet71Weather(Entity p_i3292_1_) {
      this.field_73538_a = p_i3292_1_.field_70157_k;
      this.field_73536_b = MathHelper.func_76128_c(p_i3292_1_.field_70165_t * 32.0D);
      this.field_73537_c = MathHelper.func_76128_c(p_i3292_1_.field_70163_u * 32.0D);
      this.field_73534_d = MathHelper.func_76128_c(p_i3292_1_.field_70161_v * 32.0D);
      if(p_i3292_1_ instanceof EntityLightningBolt) {
         this.field_73535_e = 1;
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73538_a = p_73267_1_.readInt();
      this.field_73535_e = p_73267_1_.readByte();
      this.field_73536_b = p_73267_1_.readInt();
      this.field_73537_c = p_73267_1_.readInt();
      this.field_73534_d = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73538_a);
      p_73273_1_.writeByte(this.field_73535_e);
      p_73273_1_.writeInt(this.field_73536_b);
      p_73273_1_.writeInt(this.field_73537_c);
      p_73273_1_.writeInt(this.field_73534_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72508_a(this);
   }

   public int func_73284_a() {
      return 17;
   }
}
