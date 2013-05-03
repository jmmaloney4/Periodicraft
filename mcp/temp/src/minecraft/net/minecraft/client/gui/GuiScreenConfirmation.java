package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.GuiYesNo;

@SideOnly(Side.CLIENT)
public class GuiScreenConfirmation extends GuiYesNo {

   private String field_96288_n;


   public GuiScreenConfirmation(GuiScreen p_i10019_1_, String p_i10019_2_, String p_i10019_3_, String p_i10019_4_, int p_i10019_5_) {
      super(p_i10019_1_, p_i10019_2_, p_i10019_3_, p_i10019_5_);
      this.field_96288_n = p_i10019_4_;
   }

   public void func_73866_w_() {
      this.field_73887_h.add(new GuiSmallButton(0, this.field_73880_f / 2 - 155, this.field_73881_g / 6 + 112, this.field_73941_c));
      this.field_73887_h.add(new GuiSmallButton(1, this.field_73880_f / 2 - 155 + 160, this.field_73881_g / 6 + 112, this.field_73939_d));
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_96288_n, this.field_73880_f / 2, 110, 16777215);
   }
}
