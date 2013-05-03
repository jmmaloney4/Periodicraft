package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockHalfSlab extends Block {

   protected final boolean field_72242_a;


   public BlockHalfSlab(int p_i3954_1_, boolean p_i3954_2_, Material p_i3954_3_) {
      super(p_i3954_1_, p_i3954_3_);
      this.field_72242_a = p_i3954_2_;
      if(p_i3954_2_) {
         field_71970_n[p_i3954_1_] = true;
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.func_71868_h(255);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      if(this.field_72242_a) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         boolean var5 = (p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 8) != 0;
         if(var5) {
            this.func_71905_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
         }
      }

   }

   public void func_71919_f() {
      if(this.field_72242_a) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      this.func_71902_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
   }

   public boolean func_71926_d() {
      return this.field_72242_a;
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      return this.field_72242_a?p_85104_9_:(p_85104_5_ != 0 && (p_85104_5_ == 1 || (double)p_85104_7_ <= 0.5D)?p_85104_9_:p_85104_9_ | 8);
   }

   public int func_71925_a(Random p_71925_1_) {
      return this.field_72242_a?2:1;
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_ & 7;
   }

   public boolean func_71886_c() {
      return this.field_72242_a;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      if(this.field_72242_a) {
         return super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
      } else if(p_71877_5_ != 1 && p_71877_5_ != 0 && !super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_)) {
         return false;
      } else {
         int var6 = p_71877_2_ + Facing.field_71586_b[Facing.field_71588_a[p_71877_5_]];
         int var7 = p_71877_3_ + Facing.field_71587_c[Facing.field_71588_a[p_71877_5_]];
         int var8 = p_71877_4_ + Facing.field_71585_d[Facing.field_71588_a[p_71877_5_]];
         boolean var9 = (p_71877_1_.func_72805_g(var6, var7, var8) & 8) != 0;
         return var9?(p_71877_5_ == 0?true:(p_71877_5_ == 1 && super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_)?true:!func_72241_e(p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_)) || (p_71877_1_.func_72805_g(p_71877_2_, p_71877_3_, p_71877_4_) & 8) == 0)):(p_71877_5_ == 1?true:(p_71877_5_ == 0 && super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_)?true:!func_72241_e(p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_)) || (p_71877_1_.func_72805_g(p_71877_2_, p_71877_3_, p_71877_4_) & 8) != 0));
      }
   }

   @SideOnly(Side.CLIENT)
   private static boolean func_72241_e(int p_72241_0_) {
      return p_72241_0_ == Block.field_72079_ak.field_71990_ca || p_72241_0_ == Block.field_72092_bO.field_71990_ca;
   }

   public abstract String func_72240_d(int var1);

   public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_) {
      return super.func_71873_h(p_71873_1_, p_71873_2_, p_71873_3_, p_71873_4_) & 7;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return func_72241_e(this.field_71990_ca)?this.field_71990_ca:(this.field_71990_ca == Block.field_72085_aj.field_71990_ca?Block.field_72079_ak.field_71990_ca:(this.field_71990_ca == Block.field_72090_bN.field_71990_ca?Block.field_72092_bO.field_71990_ca:Block.field_72079_ak.field_71990_ca));
   }
}
