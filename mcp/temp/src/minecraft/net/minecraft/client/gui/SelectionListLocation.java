package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreenSelectLocation;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.mco.Location;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class SelectionListLocation extends GuiSlot {

   // $FF: synthetic field
   final GuiScreenSelectLocation field_96295_a;


   public SelectionListLocation(GuiScreenSelectLocation p_i10002_1_) {
      super(GuiScreenSelectLocation.func_96232_a(p_i10002_1_), p_i10002_1_.field_73880_f, p_i10002_1_.field_73881_g, 32, p_i10002_1_.field_73881_g - 65 + 4, 18);
      this.field_96295_a = p_i10002_1_;
   }

   protected int func_77217_a() {
      return GuiScreenSelectLocation.func_96236_b(this.field_96295_a).size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      GuiScreenSelectLocation.func_96234_a(this.field_96295_a, (Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(p_77213_1_));
      GuiScreenSelectLocation.func_96230_c(this.field_96295_a).field_73744_e = StringTranslate.func_74808_a().func_74805_b("gui.done");
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return ((Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(p_77218_1_)).field_96395_b.equals(GuiScreenSelectLocation.func_96233_d(this.field_96295_a).field_96395_b);
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 18;
   }

   protected void func_77221_c() {
      this.field_96295_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      GuiScreenSelectLocation.func_96231_e(this.field_96295_a).func_78275_b(true);
      this.field_96295_a.func_73732_a(GuiScreenSelectLocation.func_96235_f(this.field_96295_a), ((Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(p_77214_1_)).field_96395_b, this.field_96295_a.field_73880_f / 2, p_77214_3_ + 1, 16777215);
   }
}
