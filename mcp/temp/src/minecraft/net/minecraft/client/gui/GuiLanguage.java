package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlotLanguage;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiLanguage extends GuiScreen {

   protected GuiScreen field_74047_a;
   private int field_74045_b = -1;
   private GuiSlotLanguage field_74046_c;
   private final GameSettings field_74044_d;
   private GuiSmallButton field_74048_m;


   public GuiLanguage(GuiScreen p_i3033_1_, GameSettings p_i3033_2_) {
      this.field_74047_a = p_i3033_1_;
      this.field_74044_d = p_i3033_2_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(this.field_74048_m = new GuiSmallButton(6, this.field_73880_f / 2 - 75, this.field_73881_g - 38, var1.func_74805_b("gui.done")));
      this.field_74046_c = new GuiSlotLanguage(this);
      this.field_74046_c.func_77220_a(this.field_73887_h, 7, 8);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         switch(p_73875_1_.field_73741_f) {
         case 5:
            break;
         case 6:
            this.field_73882_e.func_71373_a(this.field_74047_a);
            break;
         default:
            this.field_74046_c.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_74046_c.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_74045_b <= 0) {
         this.field_73882_e.field_71418_C.func_77305_c();
         this.field_74045_b += 20;
      }

      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("options.language"), this.field_73880_f / 2, 16, 16777215);
      this.func_73732_a(this.field_73886_k, "(" + var4.func_74805_b("options.languageWarning") + ")", this.field_73880_f / 2, this.field_73881_g - 56, 8421504);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      super.func_73876_c();
      --this.field_74045_b;
   }

   // $FF: synthetic method
   static GameSettings func_74043_a(GuiLanguage p_74043_0_) {
      return p_74043_0_.field_74044_d;
   }

   // $FF: synthetic method
   static GuiSmallButton func_74042_b(GuiLanguage p_74042_0_) {
      return p_74042_0_.field_74048_m;
   }
}
