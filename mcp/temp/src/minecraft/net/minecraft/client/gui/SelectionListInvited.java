package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreenConfigureWorld;
import net.minecraft.client.gui.SelectionListBase;
import net.minecraft.client.renderer.Tessellator;

@SideOnly(Side.CLIENT)
class SelectionListInvited extends SelectionListBase {

   // $FF: synthetic field
   final GuiScreenConfigureWorld field_98264_a;


   public SelectionListInvited(GuiScreenConfigureWorld p_i11005_1_) {
      super(GuiScreenConfigureWorld.func_96265_a(p_i11005_1_), GuiScreenConfigureWorld.func_96271_b(p_i11005_1_), GuiScreenConfigureWorld.func_96274_a(p_i11005_1_, 2), GuiScreenConfigureWorld.func_96269_c(p_i11005_1_), GuiScreenConfigureWorld.func_96274_a(p_i11005_1_, 9) - GuiScreenConfigureWorld.func_96274_a(p_i11005_1_, 2), 12);
      this.field_98264_a = p_i11005_1_;
   }

   protected int func_96608_a() {
      return GuiScreenConfigureWorld.func_96266_d(this.field_98264_a).field_96402_f.size() + 1;
   }

   protected void func_96615_a(int p_96615_1_, boolean p_96615_2_) {
      if(p_96615_1_ < GuiScreenConfigureWorld.func_96266_d(this.field_98264_a).field_96402_f.size()) {
         GuiScreenConfigureWorld.func_96270_b(this.field_98264_a, p_96615_1_);
      }
   }

   protected boolean func_96609_a(int p_96609_1_) {
      return p_96609_1_ == GuiScreenConfigureWorld.func_96263_e(this.field_98264_a);
   }

   protected int func_96613_b() {
      return this.func_96608_a() * 12;
   }

   protected void func_96611_c() {}

   protected void func_96610_a(int p_96610_1_, int p_96610_2_, int p_96610_3_, int p_96610_4_, Tessellator p_96610_5_) {
      if(p_96610_1_ < GuiScreenConfigureWorld.func_96266_d(this.field_98264_a).field_96402_f.size()) {
         this.func_98263_b(p_96610_1_, p_96610_2_, p_96610_3_, p_96610_4_, p_96610_5_);
      }

   }

   private void func_98263_b(int p_98263_1_, int p_98263_2_, int p_98263_3_, int p_98263_4_, Tessellator p_98263_5_) {
      String var6 = (String)GuiScreenConfigureWorld.func_96266_d(this.field_98264_a).field_96402_f.get(p_98263_1_);
      this.field_98264_a.func_73731_b(GuiScreenConfigureWorld.func_96273_f(this.field_98264_a), var6, p_98263_2_ + 2, p_98263_3_ + 1, 16777215);
   }
}
