package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;

class SlotBrewingStandPotion extends Slot {

   private EntityPlayer field_75244_a;


   public SlotBrewingStandPotion(EntityPlayer p_i3599_1_, IInventory p_i3599_2_, int p_i3599_3_, int p_i3599_4_, int p_i3599_5_) {
      super(p_i3599_2_, p_i3599_3_, p_i3599_4_, p_i3599_5_);
      this.field_75244_a = p_i3599_1_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return func_75243_a_(p_75214_1_);
   }

   public int func_75219_a() {
      return 1;
   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      if(p_82870_2_.field_77993_c == Item.field_77726_bs.field_77779_bT && p_82870_2_.func_77960_j() > 0) {
         this.field_75244_a.func_71064_a(AchievementList.field_76001_A, 1);
      }

      super.func_82870_a(p_82870_1_, p_82870_2_);
   }

   public static boolean func_75243_a_(ItemStack p_75243_0_) {
      return p_75243_0_ != null && (p_75243_0_.field_77993_c == Item.field_77726_bs.field_77779_bT || p_75243_0_.field_77993_c == Item.field_77729_bt.field_77779_bT);
   }
}
