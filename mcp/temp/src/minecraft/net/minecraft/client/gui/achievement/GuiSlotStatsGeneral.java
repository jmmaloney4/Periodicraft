package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
class GuiSlotStatsGeneral extends GuiSlot {

   // $FF: synthetic field
   final GuiStats field_77256_a;


   public GuiSlotStatsGeneral(GuiStats p_i3076_1_) {
      super(GuiStats.func_74130_a(p_i3076_1_), p_i3076_1_.field_73880_f, p_i3076_1_.field_73881_g, 32, p_i3076_1_.field_73881_g - 64, 10);
      this.field_77256_a = p_i3076_1_;
      this.func_77216_a(false);
   }

   protected int func_77217_a() {
      return StatList.field_75941_c.size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {}

   protected boolean func_77218_a(int p_77218_1_) {
      return false;
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 10;
   }

   protected void func_77221_c() {
      this.field_77256_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      StatBase var6 = (StatBase)StatList.field_75941_c.get(p_77214_1_);
      this.field_77256_a.func_73731_b(GuiStats.func_74145_b(this.field_77256_a), StatCollector.func_74838_a(var6.func_75970_i()), p_77214_2_ + 2, p_77214_3_ + 1, p_77214_1_ % 2 == 0?16777215:9474192);
      String var7 = var6.func_75968_a(GuiStats.func_74127_c(this.field_77256_a).func_77444_a(var6));
      this.field_77256_a.func_73731_b(GuiStats.func_74132_d(this.field_77256_a), var7, p_77214_2_ + 2 + 213 - GuiStats.func_74128_e(this.field_77256_a).func_78256_a(var7), p_77214_3_ + 1, p_77214_1_ % 2 == 0?16777215:9474192);
   }
}
