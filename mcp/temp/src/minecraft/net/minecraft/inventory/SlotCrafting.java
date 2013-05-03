package net.minecraft.inventory;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;

public class SlotCrafting extends Slot {

   private final IInventory field_75239_a;
   private EntityPlayer field_75238_b;
   private int field_75237_g;


   public SlotCrafting(EntityPlayer p_i3615_1_, IInventory p_i3615_2_, IInventory p_i3615_3_, int p_i3615_4_, int p_i3615_5_, int p_i3615_6_) {
      super(p_i3615_3_, p_i3615_4_, p_i3615_5_, p_i3615_6_);
      this.field_75238_b = p_i3615_1_;
      this.field_75239_a = p_i3615_2_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return false;
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      if(this.func_75216_d()) {
         this.field_75237_g += Math.min(p_75209_1_, this.func_75211_c().field_77994_a);
      }

      return super.func_75209_a(p_75209_1_);
   }

   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
      this.field_75237_g += p_75210_2_;
      this.func_75208_c(p_75210_1_);
   }

   protected void func_75208_c(ItemStack p_75208_1_) {
      p_75208_1_.func_77980_a(this.field_75238_b.field_70170_p, this.field_75238_b, this.field_75237_g);
      this.field_75237_g = 0;
      if(p_75208_1_.field_77993_c == Block.field_72060_ay.field_71990_ca) {
         this.field_75238_b.func_71064_a(AchievementList.field_76017_h, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77713_t.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76018_i, 1);
      } else if(p_75208_1_.field_77993_c == Block.field_72051_aB.field_71990_ca) {
         this.field_75238_b.func_71064_a(AchievementList.field_76015_j, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77678_N.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76013_l, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77684_U.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76014_m, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77746_aZ.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76011_n, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77720_x.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76012_o, 1);
      } else if(p_75208_1_.field_77993_c == Item.field_77715_r.field_77779_bT) {
         this.field_75238_b.func_71064_a(AchievementList.field_76024_r, 1);
      } else if(p_75208_1_.field_77993_c == Block.field_72096_bE.field_71990_ca) {
         this.field_75238_b.func_71064_a(AchievementList.field_75998_D, 1);
      } else if(p_75208_1_.field_77993_c == Block.field_72093_an.field_71990_ca) {
         this.field_75238_b.func_71064_a(AchievementList.field_76000_F, 1);
      }

   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      this.func_75208_c(p_82870_2_);

      for(int var3 = 0; var3 < this.field_75239_a.func_70302_i_(); ++var3) {
         ItemStack var4 = this.field_75239_a.func_70301_a(var3);
         if(var4 != null) {
            this.field_75239_a.func_70298_a(var3, 1);
            if(var4.func_77973_b().func_77634_r()) {
               ItemStack var5 = new ItemStack(var4.func_77973_b().func_77668_q());
               if(!var4.func_77973_b().func_77630_h(var4) || !this.field_75238_b.field_71071_by.func_70441_a(var5)) {
                  if(this.field_75239_a.func_70301_a(var3) == null) {
                     this.field_75239_a.func_70299_a(var3, var5);
                  } else {
                     this.field_75238_b.func_71021_b(var5);
                  }
               }
            }
         }
      }

   }
}
