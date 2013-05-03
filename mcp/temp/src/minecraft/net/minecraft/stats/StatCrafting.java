package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.stats.StatBase;

public class StatCrafting extends StatBase {

   private final int field_75983_a;


   public StatCrafting(int p_i3414_1_, String p_i3414_2_, int p_i3414_3_) {
      super(p_i3414_1_, p_i3414_2_);
      this.field_75983_a = p_i3414_3_;
   }

   @SideOnly(Side.CLIENT)
   public int func_75982_a() {
      return this.field_75983_a;
   }
}
