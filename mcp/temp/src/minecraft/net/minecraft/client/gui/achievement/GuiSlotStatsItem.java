package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.achievement.GuiSlotStats;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.achievement.SorterStatsItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;

@SideOnly(Side.CLIENT)
class GuiSlotStatsItem extends GuiSlotStats {

   // $FF: synthetic field
   final GuiStats field_77269_a;


   public GuiSlotStatsItem(GuiStats p_i3077_1_) {
      super(p_i3077_1_);
      this.field_77269_a = p_i3077_1_;
      this.field_77266_h = new ArrayList();
      Iterator var2 = StatList.field_75938_d.iterator();

      while(var2.hasNext()) {
         StatCrafting var3 = (StatCrafting)var2.next();
         boolean var4 = false;
         int var5 = var3.func_75982_a();
         if(GuiStats.func_74127_c(p_i3077_1_).func_77444_a(var3) > 0) {
            var4 = true;
         } else if(StatList.field_75930_F[var5] != null && GuiStats.func_74127_c(p_i3077_1_).func_77444_a(StatList.field_75930_F[var5]) > 0) {
            var4 = true;
         } else if(StatList.field_75928_D[var5] != null && GuiStats.func_74127_c(p_i3077_1_).func_77444_a(StatList.field_75928_D[var5]) > 0) {
            var4 = true;
         }

         if(var4) {
            this.field_77266_h.add(var3);
         }
      }

      this.field_77267_i = new SorterStatsItem(this, p_i3077_1_);
   }

   protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_) {
      super.func_77222_a(p_77222_1_, p_77222_2_, p_77222_3_);
      if(this.field_77262_g == 0) {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 115 - 18 + 1, p_77222_2_ + 1 + 1, 72, 18);
      } else {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 115 - 18, p_77222_2_ + 1, 72, 18);
      }

      if(this.field_77262_g == 1) {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 165 - 18 + 1, p_77222_2_ + 1 + 1, 18, 18);
      } else {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 165 - 18, p_77222_2_ + 1, 18, 18);
      }

      if(this.field_77262_g == 2) {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 215 - 18 + 1, p_77222_2_ + 1 + 1, 36, 18);
      } else {
         GuiStats.func_74134_a(this.field_77269_a, p_77222_1_ + 215 - 18, p_77222_2_ + 1, 36, 18);
      }

   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      StatCrafting var6 = this.func_77257_d(p_77214_1_);
      int var7 = var6.func_75982_a();
      GuiStats.func_74131_a(this.field_77269_a, p_77214_2_ + 40, p_77214_3_, var7);
      this.func_77260_a((StatCrafting)StatList.field_75930_F[var7], p_77214_2_ + 115, p_77214_3_, p_77214_1_ % 2 == 0);
      this.func_77260_a((StatCrafting)StatList.field_75928_D[var7], p_77214_2_ + 165, p_77214_3_, p_77214_1_ % 2 == 0);
      this.func_77260_a(var6, p_77214_2_ + 215, p_77214_3_, p_77214_1_ % 2 == 0);
   }

   protected String func_77258_c(int p_77258_1_) {
      return p_77258_1_ == 1?"stat.crafted":(p_77258_1_ == 2?"stat.used":"stat.depleted");
   }
}
