package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemLilyPad extends ItemColored {

   public ItemLilyPad(int p_i3694_1_) {
      super(p_i3694_1_, false);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, true);
      if(var4 == null) {
         return p_77659_1_;
      } else {
         if(var4.field_72313_a == EnumMovingObjectType.TILE) {
            int var5 = var4.field_72311_b;
            int var6 = var4.field_72312_c;
            int var7 = var4.field_72309_d;
            if(!p_77659_2_.func_72962_a(p_77659_3_, var5, var6, var7)) {
               return p_77659_1_;
            }

            if(!p_77659_3_.func_82247_a(var5, var6, var7, var4.field_72310_e, p_77659_1_)) {
               return p_77659_1_;
            }

            if(p_77659_2_.func_72803_f(var5, var6, var7) == Material.field_76244_g && p_77659_2_.func_72805_g(var5, var6, var7) == 0 && p_77659_2_.func_72799_c(var5, var6 + 1, var7)) {
               p_77659_2_.func_94575_c(var5, var6 + 1, var7, Block.field_71991_bz.field_71990_ca);
               if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                  --p_77659_1_.field_77994_a;
               }
            }
         }

         return p_77659_1_;
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return Block.field_71991_bz.func_71889_f_(p_82790_1_.func_77960_j());
   }
}
