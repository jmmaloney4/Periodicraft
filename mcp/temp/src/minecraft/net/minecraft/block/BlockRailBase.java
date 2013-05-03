package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBaseRailLogic;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRailBase extends Block {

   protected final boolean field_72186_a;


   public static final boolean func_72180_d_(World p_72180_0_, int p_72180_1_, int p_72180_2_, int p_72180_3_) {
      return func_72184_d(p_72180_0_.func_72798_a(p_72180_1_, p_72180_2_, p_72180_3_));
   }

   public static final boolean func_72184_d(int p_72184_0_) {
      return p_72184_0_ == Block.field_72056_aG.field_71990_ca || p_72184_0_ == Block.field_71954_T.field_71990_ca || p_72184_0_ == Block.field_71953_U.field_71990_ca || p_72184_0_ == Block.field_94337_cv.field_71990_ca;
   }

   protected BlockRailBase(int p_i9011_1_, boolean p_i9011_2_) {
      super(p_i9011_1_, Material.field_76265_p);
      this.field_72186_a = p_i9011_2_;
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.func_71849_a(CreativeTabs.field_78029_e);
   }

   public boolean func_72183_n() {
      return this.field_72186_a;
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71926_d() {
      return false;
   }

   public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_) {
      this.func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
      return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      if(var5 >= 2 && var5 <= 5) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 9;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      if(!p_71861_1_.field_72995_K) {
         this.func_72181_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, true);
         if(this.field_72186_a) {
            this.func_71863_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, this.field_71990_ca);
         }
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K) {
         int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
         int var7 = var6;
         if(this.field_72186_a) {
            var7 = var6 & 7;
         }

         boolean var8 = false;
         if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_)) {
            var8 = true;
         }

         if(var7 == 2 && !p_71863_1_.func_72797_t(p_71863_2_ + 1, p_71863_3_, p_71863_4_)) {
            var8 = true;
         }

         if(var7 == 3 && !p_71863_1_.func_72797_t(p_71863_2_ - 1, p_71863_3_, p_71863_4_)) {
            var8 = true;
         }

         if(var7 == 4 && !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_, p_71863_4_ - 1)) {
            var8 = true;
         }

         if(var7 == 5 && !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_, p_71863_4_ + 1)) {
            var8 = true;
         }

         if(var8) {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         } else {
            this.func_94358_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, var7, p_71863_5_);
         }

      }
   }

   protected void func_94358_a(World p_94358_1_, int p_94358_2_, int p_94358_3_, int p_94358_4_, int p_94358_5_, int p_94358_6_, int p_94358_7_) {}

   protected void func_72181_a(World p_72181_1_, int p_72181_2_, int p_72181_3_, int p_72181_4_, boolean p_72181_5_) {
      if(!p_72181_1_.field_72995_K) {
         (new BlockBaseRailLogic(this, p_72181_1_, p_72181_2_, p_72181_3_, p_72181_4_)).func_94511_a(p_72181_1_.func_72864_z(p_72181_2_, p_72181_3_, p_72181_4_), p_72181_5_);
      }
   }

   public int func_71915_e() {
      return 0;
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      int var7 = p_71852_6_;
      if(this.field_72186_a) {
         var7 = p_71852_6_ & 7;
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      if(var7 == 2 || var7 == 3 || var7 == 4 || var7 == 5) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, p_71852_5_);
      }

      if(this.field_72186_a) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, p_71852_5_);
      }

   }
}
