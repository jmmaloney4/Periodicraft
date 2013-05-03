package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet20NamedEntitySpawn extends Packet {

   public int field_73516_a;
   public String field_73514_b;
   public int field_73515_c;
   public int field_73512_d;
   public int field_73513_e;
   public byte field_73510_f;
   public byte field_73511_g;
   public int field_73518_h;
   private DataWatcher field_73519_i;
   private List field_73517_j;


   public Packet20NamedEntitySpawn() {}

   public Packet20NamedEntitySpawn(EntityPlayer p_i3296_1_) {
      this.field_73516_a = p_i3296_1_.field_70157_k;
      this.field_73514_b = p_i3296_1_.field_71092_bJ;
      this.field_73515_c = MathHelper.func_76128_c(p_i3296_1_.field_70165_t * 32.0D);
      this.field_73512_d = MathHelper.func_76128_c(p_i3296_1_.field_70163_u * 32.0D);
      this.field_73513_e = MathHelper.func_76128_c(p_i3296_1_.field_70161_v * 32.0D);
      this.field_73510_f = (byte)((int)(p_i3296_1_.field_70177_z * 256.0F / 360.0F));
      this.field_73511_g = (byte)((int)(p_i3296_1_.field_70125_A * 256.0F / 360.0F));
      ItemStack var2 = p_i3296_1_.field_71071_by.func_70448_g();
      this.field_73518_h = var2 == null?0:var2.field_77993_c;
      this.field_73519_i = p_i3296_1_.func_70096_w();
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73516_a = p_73267_1_.readInt();
      this.field_73514_b = func_73282_a(p_73267_1_, 16);
      this.field_73515_c = p_73267_1_.readInt();
      this.field_73512_d = p_73267_1_.readInt();
      this.field_73513_e = p_73267_1_.readInt();
      this.field_73510_f = p_73267_1_.readByte();
      this.field_73511_g = p_73267_1_.readByte();
      this.field_73518_h = p_73267_1_.readShort();
      this.field_73517_j = DataWatcher.func_75686_a(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73516_a);
      func_73271_a(this.field_73514_b, p_73273_1_);
      p_73273_1_.writeInt(this.field_73515_c);
      p_73273_1_.writeInt(this.field_73512_d);
      p_73273_1_.writeInt(this.field_73513_e);
      p_73273_1_.writeByte(this.field_73510_f);
      p_73273_1_.writeByte(this.field_73511_g);
      p_73273_1_.writeShort(this.field_73518_h);
      this.field_73519_i.func_75689_a(p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72518_a(this);
   }

   public int func_73284_a() {
      return 28;
   }

   @SideOnly(Side.CLIENT)
   public List func_73509_c() {
      if(this.field_73517_j == null) {
         this.field_73517_j = this.field_73519_i.func_75685_c();
      }

      return this.field_73517_j;
   }
}
