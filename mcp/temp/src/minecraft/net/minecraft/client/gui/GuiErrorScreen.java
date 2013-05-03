package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiErrorScreen extends GuiScreen {

   private String field_74001_a;
   private String field_74000_b;


   public GuiErrorScreen(String p_i11003_1_, String p_i11003_2_) {
      this.field_74001_a = p_i11003_1_;
      this.field_74000_b = p_i11003_2_;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, 140, StatCollector.func_74838_a("gui.cancel")));
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -12574688, -11530224);
      this.func_73732_a(this.field_73886_k, this.field_74001_a, this.field_73880_f / 2, 90, 16777215);
      this.func_73732_a(this.field_73886_k, this.field_74000_b, this.field_73880_f / 2, 110, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   protected void func_73875_a(GuiButton p_73875_1_) {
      this.field_73882_e.func_71373_a((GuiScreen)null);
   }
}
