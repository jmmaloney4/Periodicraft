package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class ItemEnderEye extends Item {

   public ItemEnderEye(int p_i3647_1_) {
      super(p_i3647_1_);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
      int var12 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
      if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && var11 == Block.field_72104_bI.field_71990_ca && !BlockEndPortalFrame.func_72165_e(var12)) {
         if(p_77648_3_.field_72995_K) {
            return true;
         } else {
            p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, var12 + 4, 2);
            --p_77648_1_.field_77994_a;

            int var13;
            for(var13 = 0; var13 < 16; ++var13) {
               double var14 = (double)((float)p_77648_4_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
               double var16 = (double)((float)p_77648_5_ + 0.8125F);
               double var18 = (double)((float)p_77648_6_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
               double var20 = 0.0D;
               double var22 = 0.0D;
               double var24 = 0.0D;
               p_77648_3_.func_72869_a("smoke", var14, var16, var18, var20, var22, var24);
            }

            var13 = var12 & 3;
            int var26 = 0;
            int var15 = 0;
            boolean var27 = false;
            boolean var17 = true;
            int var28 = Direction.field_71577_f[var13];

            int var19;
            int var21;
            int var23;
            int var29;
            int var30;
            for(var19 = -2; var19 <= 2; ++var19) {
               var29 = p_77648_4_ + Direction.field_71583_a[var28] * var19;
               var21 = p_77648_6_ + Direction.field_71581_b[var28] * var19;
               var30 = p_77648_3_.func_72798_a(var29, p_77648_5_, var21);
               if(var30 == Block.field_72104_bI.field_71990_ca) {
                  var23 = p_77648_3_.func_72805_g(var29, p_77648_5_, var21);
                  if(!BlockEndPortalFrame.func_72165_e(var23)) {
                     var17 = false;
                     break;
                  }

                  var15 = var19;
                  if(!var27) {
                     var26 = var19;
                     var27 = true;
                  }
               }
            }

            if(var17 && var15 == var26 + 2) {
               for(var19 = var26; var19 <= var15; ++var19) {
                  var29 = p_77648_4_ + Direction.field_71583_a[var28] * var19;
                  var21 = p_77648_6_ + Direction.field_71581_b[var28] * var19;
                  var29 += Direction.field_71583_a[var13] * 4;
                  var21 += Direction.field_71581_b[var13] * 4;
                  var30 = p_77648_3_.func_72798_a(var29, p_77648_5_, var21);
                  var23 = p_77648_3_.func_72805_g(var29, p_77648_5_, var21);
                  if(var30 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(var23)) {
                     var17 = false;
                     break;
                  }
               }

               for(var19 = var26 - 1; var19 <= var15 + 1; var19 += 4) {
                  for(var29 = 1; var29 <= 3; ++var29) {
                     var21 = p_77648_4_ + Direction.field_71583_a[var28] * var19;
                     var30 = p_77648_6_ + Direction.field_71581_b[var28] * var19;
                     var21 += Direction.field_71583_a[var13] * var29;
                     var30 += Direction.field_71581_b[var13] * var29;
                     var23 = p_77648_3_.func_72798_a(var21, p_77648_5_, var30);
                     int var31 = p_77648_3_.func_72805_g(var21, p_77648_5_, var30);
                     if(var23 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(var31)) {
                        var17 = false;
                        break;
                     }
                  }
               }

               if(var17) {
                  for(var19 = var26; var19 <= var15; ++var19) {
                     for(var29 = 1; var29 <= 3; ++var29) {
                        var21 = p_77648_4_ + Direction.field_71583_a[var28] * var19;
                        var30 = p_77648_6_ + Direction.field_71581_b[var28] * var19;
                        var21 += Direction.field_71583_a[var13] * var29;
                        var30 += Direction.field_71581_b[var13] * var29;
                        p_77648_3_.func_72832_d(var21, p_77648_5_, var30, Block.field_72102_bH.field_71990_ca, 0, 2);
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, false);
      if(var4 != null && var4.field_72313_a == EnumMovingObjectType.TILE) {
         int var5 = p_77659_2_.func_72798_a(var4.field_72311_b, var4.field_72312_c, var4.field_72309_d);
         if(var5 == Block.field_72104_bI.field_71990_ca) {
            return p_77659_1_;
         }
      }

      if(!p_77659_2_.field_72995_K) {
         ChunkPosition var7 = p_77659_2_.func_72946_b("Stronghold", (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v);
         if(var7 != null) {
            EntityEnderEye var6 = new EntityEnderEye(p_77659_2_, p_77659_3_.field_70165_t, p_77659_3_.field_70163_u + 1.62D - (double)p_77659_3_.field_70129_M, p_77659_3_.field_70161_v);
            var6.func_70220_a((double)var7.field_76930_a, var7.field_76928_b, (double)var7.field_76929_c);
            p_77659_2_.func_72838_d(var6);
            p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
            p_77659_2_.func_72889_a((EntityPlayer)null, 1002, (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v, 0);
            if(!p_77659_3_.field_71075_bZ.field_75098_d) {
               --p_77659_1_.field_77994_a;
            }
         }
      }

      return p_77659_1_;
   }
}
