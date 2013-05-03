package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

final class CreativeTabDeco extends CreativeTabs {

   CreativeTabDeco(int p_i3634_1_, String p_i3634_2_) {
      super(p_i3634_1_, p_i3634_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return Block.field_72107_ae.field_71990_ca;
   }
}
