package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockFlower extends Block {

   protected BlockFlower(int p_i9040_1_, Material p_i9040_2_) {
      super(p_i9040_1_, p_i9040_2_);
      this.func_71907_b(true);
      float var3 = 0.2F;
      this.func_71905_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   protected BlockFlower(int p_i9041_1_) {
      this(p_i9041_1_, Material.field_76254_j);
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && this.func_72263_d_(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_));
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return p_72263_1_ == Block.field_71980_u.field_71990_ca || p_72263_1_ == Block.field_71979_v.field_71990_ca || p_72263_1_ == Block.field_72050_aA.field_71990_ca;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      this.func_72262_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      this.func_72262_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
   }

   protected final void func_72262_c(World p_72262_1_, int p_72262_2_, int p_72262_3_, int p_72262_4_) {
      if(!this.func_71854_d(p_72262_1_, p_72262_2_, p_72262_3_, p_72262_4_)) {
         this.func_71897_c(p_72262_1_, p_72262_2_, p_72262_3_, p_72262_4_, p_72262_1_.func_72805_g(p_72262_2_, p_72262_3_, p_72262_4_), 0);
         p_72262_1_.func_94571_i(p_72262_2_, p_72262_3_, p_72262_4_);
      }

   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return (p_71854_1_.func_72883_k(p_71854_2_, p_71854_3_, p_71854_4_) >= 8 || p_71854_1_.func_72937_j(p_71854_2_, p_71854_3_, p_71854_4_)) && this.func_72263_d_(p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_));
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 1;
   }
}
