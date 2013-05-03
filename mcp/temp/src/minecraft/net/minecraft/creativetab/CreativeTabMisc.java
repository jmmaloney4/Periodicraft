package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;

final class CreativeTabMisc extends CreativeTabs {

   CreativeTabMisc(int p_i3637_1_, String p_i3637_2_) {
      super(p_i3637_1_, p_i3637_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return Item.field_77775_ay.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_78018_a(List p_78018_1_) {
      super.func_78018_a(p_78018_1_);
      this.func_92116_a(p_78018_1_, new EnumEnchantmentType[]{EnumEnchantmentType.all});
   }
}
