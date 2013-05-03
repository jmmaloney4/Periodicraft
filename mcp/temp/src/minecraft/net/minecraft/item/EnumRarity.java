package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum EnumRarity {

   common("common", 0, 15, "Common"),
   uncommon("uncommon", 1, 14, "Uncommon"),
   rare("rare", 2, 11, "Rare"),
   epic("epic", 3, 13, "Epic");
   public final int field_77937_e;
   public final String field_77934_f;
   // $FF: synthetic field
   private static final EnumRarity[] $VALUES = new EnumRarity[]{common, uncommon, rare, epic};


   private EnumRarity(String p_i3676_1_, int p_i3676_2_, int p_i3676_3_, String p_i3676_4_) {
      this.field_77937_e = p_i3676_3_;
      this.field_77934_f = p_i3676_4_;
   }

}
