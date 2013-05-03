package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShears extends Item {

   public ItemShears(int p_i3683_1_) {
      super(p_i3683_1_);
      this.func_77625_d(1);
      this.func_77656_e(238);
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public boolean func_77660_a(ItemStack p_77660_1_, World p_77660_2_, int p_77660_3_, int p_77660_4_, int p_77660_5_, int p_77660_6_, EntityLiving p_77660_7_) {
      if(p_77660_3_ != Block.field_71952_K.field_71990_ca && p_77660_3_ != Block.field_71955_W.field_71990_ca && p_77660_3_ != Block.field_71962_X.field_71990_ca && p_77660_3_ != Block.field_71998_bu.field_71990_ca && p_77660_3_ != Block.field_72062_bU.field_71990_ca) {
         return super.func_77660_a(p_77660_1_, p_77660_2_, p_77660_3_, p_77660_4_, p_77660_5_, p_77660_6_, p_77660_7_);
      } else {
         p_77660_1_.func_77972_a(1, p_77660_7_);
         return true;
      }
   }

   public boolean func_77641_a(Block p_77641_1_) {
      return p_77641_1_.field_71990_ca == Block.field_71955_W.field_71990_ca || p_77641_1_.field_71990_ca == Block.field_72075_av.field_71990_ca || p_77641_1_.field_71990_ca == Block.field_72062_bU.field_71990_ca;
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      return p_77638_2_.field_71990_ca != Block.field_71955_W.field_71990_ca && p_77638_2_.field_71990_ca != Block.field_71952_K.field_71990_ca?(p_77638_2_.field_71990_ca == Block.field_72101_ab.field_71990_ca?5.0F:super.func_77638_a(p_77638_1_, p_77638_2_)):15.0F;
   }
}
