package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiSnooper;
import net.minecraft.client.renderer.Tessellator;

@SideOnly(Side.CLIENT)
class GuiSnooperList extends GuiSlot {

   // $FF: synthetic field
   final GuiSnooper field_77255_a;


   public GuiSnooperList(GuiSnooper p_i3068_1_) {
      super(p_i3068_1_.field_73882_e, p_i3068_1_.field_73880_f, p_i3068_1_.field_73881_g, 80, p_i3068_1_.field_73881_g - 40, p_i3068_1_.field_73886_k.field_78288_b + 1);
      this.field_77255_a = p_i3068_1_;
   }

   protected int func_77217_a() {
      return GuiSnooper.func_74095_a(this.field_77255_a).size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {}

   protected boolean func_77218_a(int p_77218_1_) {
      return false;
   }

   protected void func_77221_c() {}

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      this.field_77255_a.field_73886_k.func_78276_b((String)GuiSnooper.func_74095_a(this.field_77255_a).get(p_77214_1_), 10, p_77214_3_, 16777215);
      this.field_77255_a.field_73886_k.func_78276_b((String)GuiSnooper.func_74094_b(this.field_77255_a).get(p_77214_1_), 230, p_77214_3_, 16777215);
   }

   protected int func_77225_g() {
      return this.field_77255_a.field_73880_f - 10;
   }
}
