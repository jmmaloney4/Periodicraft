package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.client.gui.GuiFlatPresetsItem;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiFlatPresetsListSlot extends GuiSlot {

   public int field_82459_a;
   // $FF: synthetic field
   final GuiFlatPresets field_82458_b;


   public GuiFlatPresetsListSlot(GuiFlatPresets p_i5002_1_) {
      super(p_i5002_1_.field_73882_e, p_i5002_1_.field_73880_f, p_i5002_1_.field_73881_g, 80, p_i5002_1_.field_73881_g - 37, 24);
      this.field_82458_b = p_i5002_1_;
      this.field_82459_a = -1;
   }

   private void func_82457_a(int p_82457_1_, int p_82457_2_, int p_82457_3_) {
      this.func_82456_d(p_82457_1_ + 1, p_82457_2_ + 1);
      GL11.glEnable('\u803a');
      RenderHelper.func_74520_c();
      GuiFlatPresets.func_82299_h().func_77015_a(this.field_82458_b.field_73886_k, this.field_82458_b.field_73882_e.field_71446_o, new ItemStack(p_82457_3_, 1, 0), p_82457_1_ + 2, p_82457_2_ + 2);
      RenderHelper.func_74518_a();
      GL11.glDisable('\u803a');
   }

   private void func_82456_d(int p_82456_1_, int p_82456_2_) {
      this.func_82455_b(p_82456_1_, p_82456_2_, 0, 0);
   }

   private void func_82455_b(int p_82455_1_, int p_82455_2_, int p_82455_3_, int p_82455_4_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_82458_b.field_73882_e.field_71446_o.func_98187_b("/gui/slot.png");
      Tessellator var9 = Tessellator.field_78398_a;
      var9.func_78382_b();
      var9.func_78374_a((double)(p_82455_1_ + 0), (double)(p_82455_2_ + 18), (double)this.field_82458_b.field_73735_i, (double)((float)(p_82455_3_ + 0) * 0.0078125F), (double)((float)(p_82455_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_82455_1_ + 18), (double)(p_82455_2_ + 18), (double)this.field_82458_b.field_73735_i, (double)((float)(p_82455_3_ + 18) * 0.0078125F), (double)((float)(p_82455_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_82455_1_ + 18), (double)(p_82455_2_ + 0), (double)this.field_82458_b.field_73735_i, (double)((float)(p_82455_3_ + 18) * 0.0078125F), (double)((float)(p_82455_4_ + 0) * 0.0078125F));
      var9.func_78374_a((double)(p_82455_1_ + 0), (double)(p_82455_2_ + 0), (double)this.field_82458_b.field_73735_i, (double)((float)(p_82455_3_ + 0) * 0.0078125F), (double)((float)(p_82455_4_ + 0) * 0.0078125F));
      var9.func_78381_a();
   }

   protected int func_77217_a() {
      return GuiFlatPresets.func_82295_i().size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      this.field_82459_a = p_77213_1_;
      this.field_82458_b.func_82296_g();
      GuiFlatPresets.func_82298_b(this.field_82458_b).func_73782_a(((GuiFlatPresetsItem)GuiFlatPresets.func_82295_i().get(GuiFlatPresets.func_82292_a(this.field_82458_b).field_82459_a)).field_82910_c);
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == this.field_82459_a;
   }

   protected void func_77221_c() {}

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      GuiFlatPresetsItem var6 = (GuiFlatPresetsItem)GuiFlatPresets.func_82295_i().get(p_77214_1_);
      this.func_82457_a(p_77214_2_, p_77214_3_, var6.field_82911_a);
      this.field_82458_b.field_73886_k.func_78276_b(var6.field_82909_b, p_77214_2_ + 18 + 5, p_77214_3_ + 6, 16777215);
   }
}
