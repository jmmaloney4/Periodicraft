package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemExpBottle extends Item {

   public ItemExpBottle(int p_i3649_1_) {
      super(p_i3649_1_);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(ItemStack p_77636_1_) {
      return true;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(!p_77659_3_.field_71075_bZ.field_75098_d) {
         --p_77659_1_.field_77994_a;
      }

      p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
      if(!p_77659_2_.field_72995_K) {
         p_77659_2_.func_72838_d(new EntityExpBottle(p_77659_2_, p_77659_3_));
      }

      return p_77659_1_;
   }
}
