package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

final class CreativeTabRedstone extends CreativeTabs {

   CreativeTabRedstone(int p_i3635_1_, String p_i3635_2_) {
      super(p_i3635_1_, p_i3635_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return Item.field_77767_aC.field_77779_bT;
   }
}
