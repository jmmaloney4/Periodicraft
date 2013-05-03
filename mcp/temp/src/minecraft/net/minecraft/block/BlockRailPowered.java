package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockRailPowered extends BlockRailBase {

   @SideOnly(Side.CLIENT)
   protected Icon field_94362_b;


   protected BlockRailPowered(int p_i9014_1_) {
      super(p_i9014_1_, true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return (p_71858_2_ & 8) == 0?this.field_94336_cN:this.field_94362_b;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      super.func_94332_a(p_94332_1_);
      this.field_94362_b = p_94332_1_.func_94245_a(this.func_94330_A() + "_powered");
   }

   protected boolean func_94360_a(World p_94360_1_, int p_94360_2_, int p_94360_3_, int p_94360_4_, int p_94360_5_, boolean p_94360_6_, int p_94360_7_) {
      if(p_94360_7_ >= 8) {
         return false;
      } else {
         int var8 = p_94360_5_ & 7;
         boolean var9 = true;
         switch(var8) {
         case 0:
            if(p_94360_6_) {
               ++p_94360_4_;
            } else {
               --p_94360_4_;
            }
            break;
         case 1:
            if(p_94360_6_) {
               --p_94360_2_;
            } else {
               ++p_94360_2_;
            }
            break;
         case 2:
            if(p_94360_6_) {
               --p_94360_2_;
            } else {
               ++p_94360_2_;
               ++p_94360_3_;
               var9 = false;
            }

            var8 = 1;
            break;
         case 3:
            if(p_94360_6_) {
               --p_94360_2_;
               ++p_94360_3_;
               var9 = false;
            } else {
               ++p_94360_2_;
            }

            var8 = 1;
            break;
         case 4:
            if(p_94360_6_) {
               ++p_94360_4_;
            } else {
               --p_94360_4_;
               ++p_94360_3_;
               var9 = false;
            }

            var8 = 0;
            break;
         case 5:
            if(p_94360_6_) {
               ++p_94360_4_;
               ++p_94360_3_;
               var9 = false;
            } else {
               --p_94360_4_;
            }

            var8 = 0;
         }

         return this.func_94361_a(p_94360_1_, p_94360_2_, p_94360_3_, p_94360_4_, p_94360_6_, p_94360_7_, var8)?true:var9 && this.func_94361_a(p_94360_1_, p_94360_2_, p_94360_3_ - 1, p_94360_4_, p_94360_6_, p_94360_7_, var8);
      }
   }

   protected boolean func_94361_a(World p_94361_1_, int p_94361_2_, int p_94361_3_, int p_94361_4_, boolean p_94361_5_, int p_94361_6_, int p_94361_7_) {
      int var8 = p_94361_1_.func_72798_a(p_94361_2_, p_94361_3_, p_94361_4_);
      if(var8 == this.field_71990_ca) {
         int var9 = p_94361_1_.func_72805_g(p_94361_2_, p_94361_3_, p_94361_4_);
         int var10 = var9 & 7;
         if(p_94361_7_ == 1 && (var10 == 0 || var10 == 4 || var10 == 5)) {
            return false;
         }

         if(p_94361_7_ == 0 && (var10 == 1 || var10 == 2 || var10 == 3)) {
            return false;
         }

         if((var9 & 8) != 0) {
            if(p_94361_1_.func_72864_z(p_94361_2_, p_94361_3_, p_94361_4_)) {
               return true;
            }

            return this.func_94360_a(p_94361_1_, p_94361_2_, p_94361_3_, p_94361_4_, var9, p_94361_5_, p_94361_6_ + 1);
         }
      }

      return false;
   }

   protected void func_94358_a(World p_94358_1_, int p_94358_2_, int p_94358_3_, int p_94358_4_, int p_94358_5_, int p_94358_6_, int p_94358_7_) {
      boolean var8 = p_94358_1_.func_72864_z(p_94358_2_, p_94358_3_, p_94358_4_);
      var8 = var8 || this.func_94360_a(p_94358_1_, p_94358_2_, p_94358_3_, p_94358_4_, p_94358_5_, true, 0) || this.func_94360_a(p_94358_1_, p_94358_2_, p_94358_3_, p_94358_4_, p_94358_5_, false, 0);
      boolean var9 = false;
      if(var8 && (p_94358_5_ & 8) == 0) {
         p_94358_1_.func_72921_c(p_94358_2_, p_94358_3_, p_94358_4_, p_94358_6_ | 8, 3);
         var9 = true;
      } else if(!var8 && (p_94358_5_ & 8) != 0) {
         p_94358_1_.func_72921_c(p_94358_2_, p_94358_3_, p_94358_4_, p_94358_6_, 3);
         var9 = true;
      }

      if(var9) {
         p_94358_1_.func_72898_h(p_94358_2_, p_94358_3_ - 1, p_94358_4_, this.field_71990_ca);
         if(p_94358_6_ == 2 || p_94358_6_ == 3 || p_94358_6_ == 4 || p_94358_6_ == 5) {
            p_94358_1_.func_72898_h(p_94358_2_, p_94358_3_ + 1, p_94358_4_, this.field_71990_ca);
         }
      }

   }
}
