package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Comparator;
import net.minecraft.client.gui.achievement.GuiSlotStatsBlock;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

@SideOnly(Side.CLIENT)
class SorterStatsBlock implements Comparator {

   // $FF: synthetic field
   final GuiStats field_78336_a;
   // $FF: synthetic field
   final GuiSlotStatsBlock field_78335_b;


   SorterStatsBlock(GuiSlotStatsBlock p_i3075_1_, GuiStats p_i3075_2_) {
      this.field_78335_b = p_i3075_1_;
      this.field_78336_a = p_i3075_2_;
   }

   public int func_78334_a(StatCrafting p_78334_1_, StatCrafting p_78334_2_) {
      int var3 = p_78334_1_.func_75982_a();
      int var4 = p_78334_2_.func_75982_a();
      StatBase var5 = null;
      StatBase var6 = null;
      if(this.field_78335_b.field_77264_j == 2) {
         var5 = StatList.field_75934_C[var3];
         var6 = StatList.field_75934_C[var4];
      } else if(this.field_78335_b.field_77264_j == 0) {
         var5 = StatList.field_75928_D[var3];
         var6 = StatList.field_75928_D[var4];
      } else if(this.field_78335_b.field_77264_j == 1) {
         var5 = StatList.field_75929_E[var3];
         var6 = StatList.field_75929_E[var4];
      }

      if(var5 != null || var6 != null) {
         if(var5 == null) {
            return 1;
         }

         if(var6 == null) {
            return -1;
         }

         int var7 = GuiStats.func_74127_c(this.field_78335_b.field_77268_a).func_77444_a(var5);
         int var8 = GuiStats.func_74127_c(this.field_78335_b.field_77268_a).func_77444_a(var6);
         if(var7 != var8) {
            return (var7 - var8) * this.field_78335_b.field_77265_k;
         }
      }

      return var3 - var4;
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_78334_a((StatCrafting)p_compare_1_, (StatCrafting)p_compare_2_);
   }
}
