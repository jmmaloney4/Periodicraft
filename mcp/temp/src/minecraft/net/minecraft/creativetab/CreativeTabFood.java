package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

final class CreativeTabFood extends CreativeTabs {

   CreativeTabFood(int p_i3639_1_, String p_i3639_2_) {
      super(p_i3639_1_, p_i3639_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return Item.field_77706_j.field_77779_bT;
   }
}
