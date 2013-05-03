package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHoe extends Item {

   protected EnumToolMaterial field_77843_a;


   public ItemHoe(int p_i3657_1_, EnumToolMaterial p_i3657_2_) {
      super(p_i3657_1_);
      this.field_77843_a = p_i3657_2_;
      this.field_77777_bU = 1;
      this.func_77656_e(p_i3657_2_.func_77997_a());
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         int var12 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
         if((p_77648_7_ == 0 || var12 != 0 || var11 != Block.field_71980_u.field_71990_ca) && var11 != Block.field_71979_v.field_71990_ca) {
            return false;
         } else {
            Block var13 = Block.field_72050_aA;
            p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), var13.field_72020_cn.func_72675_d(), (var13.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, var13.field_72020_cn.func_72678_c() * 0.8F);
            if(p_77648_3_.field_72995_K) {
               return true;
            } else {
               p_77648_3_.func_94575_c(p_77648_4_, p_77648_5_, p_77648_6_, var13.field_71990_ca);
               p_77648_1_.func_77972_a(1, p_77648_2_);
               return true;
            }
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77662_d() {
      return true;
   }

   public String func_77842_f() {
      return this.field_77843_a.toString();
   }
}
