package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet104WindowItems extends Packet {

   public int field_73427_a;
   public ItemStack[] field_73426_b;


   public Packet104WindowItems() {}

   public Packet104WindowItems(int p_i3312_1_, List p_i3312_2_) {
      this.field_73427_a = p_i3312_1_;
      this.field_73426_b = new ItemStack[p_i3312_2_.size()];

      for(int var3 = 0; var3 < this.field_73426_b.length; ++var3) {
         ItemStack var4 = (ItemStack)p_i3312_2_.get(var3);
         this.field_73426_b[var3] = var4 == null?null:var4.func_77946_l();
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73427_a = p_73267_1_.readByte();
      short var2 = p_73267_1_.readShort();
      this.field_73426_b = new ItemStack[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_73426_b[var3] = func_73276_c(p_73267_1_);
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73427_a);
      p_73273_1_.writeShort(this.field_73426_b.length);

      for(int var2 = 0; var2 < this.field_73426_b.length; ++var2) {
         func_73270_a(this.field_73426_b[var2], p_73273_1_);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72486_a(this);
   }

   public int func_73284_a() {
      return 3 + this.field_73426_b.length * 5;
   }
}
