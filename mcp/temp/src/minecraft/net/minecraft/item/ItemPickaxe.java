package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemPickaxe extends ItemTool {

   public static final Block[] field_77867_c = new Block[]{Block.field_71978_w, Block.field_72085_aj, Block.field_72079_ak, Block.field_71981_t, Block.field_71957_Q, Block.field_72087_ao, Block.field_71949_H, Block.field_72083_ai, Block.field_71950_I, Block.field_72105_ah, Block.field_71941_G, Block.field_72073_aw, Block.field_72071_ax, Block.field_72036_aT, Block.field_72012_bb, Block.field_71947_N, Block.field_71948_O, Block.field_72047_aN, Block.field_72048_aO, Block.field_72056_aG, Block.field_71953_U, Block.field_71954_T, Block.field_94337_cv};


   public ItemPickaxe(int p_i3673_1_, EnumToolMaterial p_i3673_2_) {
      super(p_i3673_1_, 2, p_i3673_2_, field_77867_c);
   }

   public boolean func_77641_a(Block p_77641_1_) {
      return p_77641_1_ == Block.field_72089_ap?this.field_77862_b.func_77996_d() == 3:(p_77641_1_ != Block.field_72071_ax && p_77641_1_ != Block.field_72073_aw?(p_77641_1_ != Block.field_72068_bR && p_77641_1_ != Block.field_72076_bV?(p_77641_1_ != Block.field_72105_ah && p_77641_1_ != Block.field_71941_G?(p_77641_1_ != Block.field_72083_ai && p_77641_1_ != Block.field_71949_H?(p_77641_1_ != Block.field_71948_O && p_77641_1_ != Block.field_71947_N?(p_77641_1_ != Block.field_72047_aN && p_77641_1_ != Block.field_72048_aO?(p_77641_1_.field_72018_cp == Material.field_76246_e?true:(p_77641_1_.field_72018_cp == Material.field_76243_f?true:p_77641_1_.field_72018_cp == Material.field_82717_g)):this.field_77862_b.func_77996_d() >= 2):this.field_77862_b.func_77996_d() >= 1):this.field_77862_b.func_77996_d() >= 1):this.field_77862_b.func_77996_d() >= 2):this.field_77862_b.func_77996_d() >= 2):this.field_77862_b.func_77996_d() >= 2);
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      return p_77638_2_ != null && (p_77638_2_.field_72018_cp == Material.field_76243_f || p_77638_2_.field_72018_cp == Material.field_82717_g || p_77638_2_.field_72018_cp == Material.field_76246_e)?this.field_77864_a:super.func_77638_a(p_77638_1_, p_77638_2_);
   }

}
