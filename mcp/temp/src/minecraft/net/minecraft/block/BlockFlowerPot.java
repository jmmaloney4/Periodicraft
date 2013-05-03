package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockFlowerPot extends Block {

   public BlockFlowerPot(int p_i5103_1_) {
      super(p_i5103_1_, Material.field_76265_p);
      this.func_71919_f();
   }

   public void func_71919_f() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public boolean func_71926_d() {
      return false;
   }

   public int func_71857_b() {
      return 33;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      ItemStack var10 = p_71903_5_.field_71071_by.func_70448_g();
      if(var10 == null) {
         return false;
      } else if(p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_) != 0) {
         return false;
      } else {
         int var11 = func_82530_a(var10);
         if(var11 > 0) {
            p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var11, 2);
            if(!p_71903_5_.field_71075_bZ.field_75098_d && --var10.field_77994_a <= 0) {
               p_71903_5_.field_71071_by.func_70299_a(p_71903_5_.field_71071_by.field_70461_c, (ItemStack)null);
            }

            return true;
         } else {
            return false;
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      ItemStack var5 = func_82531_c(p_71922_1_.func_72805_g(p_71922_2_, p_71922_3_, p_71922_4_));
      return var5 == null?Item.field_82796_bJ.field_77779_bT:var5.field_77993_c;
   }

   public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_) {
      ItemStack var5 = func_82531_c(p_71873_1_.func_72805_g(p_71873_2_, p_71873_3_, p_71873_4_));
      return var5 == null?Item.field_82796_bJ.field_77779_bT:var5.func_77960_j();
   }

   @SideOnly(Side.CLIENT)
   public boolean func_82505_u_() {
      return true;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_)) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
      if(p_71914_5_ > 0) {
         ItemStack var8 = func_82531_c(p_71914_5_);
         if(var8 != null) {
            this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, var8);
         }
      }

   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_82796_bJ.field_77779_bT;
   }

   public static ItemStack func_82531_c(int p_82531_0_) {
      switch(p_82531_0_) {
      case 1:
         return new ItemStack(Block.field_72107_ae);
      case 2:
         return new ItemStack(Block.field_72097_ad);
      case 3:
         return new ItemStack(Block.field_71987_y, 1, 0);
      case 4:
         return new ItemStack(Block.field_71987_y, 1, 1);
      case 5:
         return new ItemStack(Block.field_71987_y, 1, 2);
      case 6:
         return new ItemStack(Block.field_71987_y, 1, 3);
      case 7:
         return new ItemStack(Block.field_72103_ag);
      case 8:
         return new ItemStack(Block.field_72109_af);
      case 9:
         return new ItemStack(Block.field_72038_aV);
      case 10:
         return new ItemStack(Block.field_71961_Y);
      case 11:
         return new ItemStack(Block.field_71962_X, 1, 2);
      default:
         return null;
      }
   }

   public static int func_82530_a(ItemStack p_82530_0_) {
      int var1 = p_82530_0_.func_77973_b().field_77779_bT;
      if(var1 == Block.field_72107_ae.field_71990_ca) {
         return 1;
      } else if(var1 == Block.field_72097_ad.field_71990_ca) {
         return 2;
      } else if(var1 == Block.field_72038_aV.field_71990_ca) {
         return 9;
      } else if(var1 == Block.field_72109_af.field_71990_ca) {
         return 8;
      } else if(var1 == Block.field_72103_ag.field_71990_ca) {
         return 7;
      } else if(var1 == Block.field_71961_Y.field_71990_ca) {
         return 10;
      } else {
         if(var1 == Block.field_71987_y.field_71990_ca) {
            switch(p_82530_0_.func_77960_j()) {
            case 0:
               return 3;
            case 1:
               return 4;
            case 2:
               return 5;
            case 3:
               return 6;
            }
         }

         if(var1 == Block.field_71962_X.field_71990_ca) {
            switch(p_82530_0_.func_77960_j()) {
            case 2:
               return 11;
            }
         }

         return 0;
      }
   }
}
