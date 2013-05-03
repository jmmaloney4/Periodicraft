package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Slot {

   private final int field_75225_a;
   public final IInventory field_75224_c;
   public int field_75222_d;
   public int field_75223_e;
   public int field_75221_f;


   public Slot(IInventory p_i3616_1_, int p_i3616_2_, int p_i3616_3_, int p_i3616_4_) {
      this.field_75224_c = p_i3616_1_;
      this.field_75225_a = p_i3616_2_;
      this.field_75223_e = p_i3616_3_;
      this.field_75221_f = p_i3616_4_;
   }

   public void func_75220_a(ItemStack p_75220_1_, ItemStack p_75220_2_) {
      if(p_75220_1_ != null && p_75220_2_ != null) {
         if(p_75220_1_.field_77993_c == p_75220_2_.field_77993_c) {
            int var3 = p_75220_2_.field_77994_a - p_75220_1_.field_77994_a;
            if(var3 > 0) {
               this.func_75210_a(p_75220_1_, var3);
            }

         }
      }
   }

   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {}

   protected void func_75208_c(ItemStack p_75208_1_) {}

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      this.func_75218_e();
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return true;
   }

   public ItemStack func_75211_c() {
      return this.field_75224_c.func_70301_a(this.field_75225_a);
   }

   public boolean func_75216_d() {
      return this.func_75211_c() != null;
   }

   public void func_75215_d(ItemStack p_75215_1_) {
      this.field_75224_c.func_70299_a(this.field_75225_a, p_75215_1_);
      this.func_75218_e();
   }

   public void func_75218_e() {
      this.field_75224_c.func_70296_d();
   }

   public int func_75219_a() {
      return this.field_75224_c.func_70297_j_();
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      return this.field_75224_c.func_70298_a(this.field_75225_a, p_75209_1_);
   }

   public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_) {
      return p_75217_1_ == this.field_75224_c && p_75217_2_ == this.field_75225_a;
   }

   public boolean func_82869_a(EntityPlayer p_82869_1_) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_75212_b() {
      return null;
   }
}
