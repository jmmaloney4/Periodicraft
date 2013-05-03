package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet5PlayerInventory extends Packet {

   public int field_73400_a;
   public int field_73398_b;
   private ItemStack field_73399_c;


   public Packet5PlayerInventory() {}

   public Packet5PlayerInventory(int p_i3350_1_, int p_i3350_2_, ItemStack p_i3350_3_) {
      this.field_73400_a = p_i3350_1_;
      this.field_73398_b = p_i3350_2_;
      this.field_73399_c = p_i3350_3_ == null?null:p_i3350_3_.func_77946_l();
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73400_a = p_73267_1_.readInt();
      this.field_73398_b = p_73267_1_.readShort();
      this.field_73399_c = func_73276_c(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73400_a);
      p_73273_1_.writeShort(this.field_73398_b);
      func_73270_a(this.field_73399_c, p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72506_a(this);
   }

   public int func_73284_a() {
      return 8;
   }

   @SideOnly(Side.CLIENT)
   public ItemStack func_73397_d() {
      return this.field_73399_c;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet5PlayerInventory var2 = (Packet5PlayerInventory)p_73268_1_;
      return var2.field_73400_a == this.field_73400_a && var2.field_73398_b == this.field_73398_b;
   }
}
