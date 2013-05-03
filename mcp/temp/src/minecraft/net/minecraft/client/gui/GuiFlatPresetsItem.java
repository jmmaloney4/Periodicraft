package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class GuiFlatPresetsItem {

   public int field_82911_a;
   public String field_82909_b;
   public String field_82910_c;


   public GuiFlatPresetsItem(int p_i5003_1_, String p_i5003_2_, String p_i5003_3_) {
      this.field_82911_a = p_i5003_1_;
      this.field_82909_b = p_i5003_2_;
      this.field_82910_c = p_i5003_3_;
   }
}
