package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

final class CreativeTabBlock extends CreativeTabs {

   CreativeTabBlock(int p_i3630_1_, String p_i3630_2_) {
      super(p_i3630_1_, p_i3630_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return Block.field_72081_al.field_71990_ca;
   }
}
