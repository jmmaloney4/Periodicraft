package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class ScreenChatOptions extends GuiScreen {

   private static final EnumOptions[] field_73891_a = new EnumOptions[]{EnumOptions.CHAT_VISIBILITY, EnumOptions.CHAT_COLOR, EnumOptions.CHAT_LINKS, EnumOptions.CHAT_OPACITY, EnumOptions.CHAT_LINKS_PROMPT, EnumOptions.CHAT_SCALE, EnumOptions.CHAT_HEIGHT_FOCUSED, EnumOptions.CHAT_HEIGHT_UNFOCUSED, EnumOptions.CHAT_WIDTH};
   private static final EnumOptions[] field_82267_b = new EnumOptions[]{EnumOptions.SHOW_CAPE};
   private final GuiScreen field_73889_b;
   private final GameSettings field_73890_c;
   private String field_73888_d;
   private String field_82268_n;
   private int field_82269_o = 0;


   public ScreenChatOptions(GuiScreen p_i3044_1_, GameSettings p_i3044_2_) {
      this.field_73889_b = p_i3044_1_;
      this.field_73890_c = p_i3044_2_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      int var2 = 0;
      this.field_73888_d = var1.func_74805_b("options.chat.title");
      this.field_82268_n = var1.func_74805_b("options.multiplayer.title");
      EnumOptions[] var3 = field_73891_a;
      int var4 = var3.length;

      int var5;
      EnumOptions var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if(var6.func_74380_a()) {
            this.field_73887_h.add(new GuiSlider(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 + 24 * (var2 >> 1), var6, this.field_73890_c.func_74297_c(var6), this.field_73890_c.func_74296_a(var6)));
         } else {
            this.field_73887_h.add(new GuiSmallButton(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 + 24 * (var2 >> 1), var6, this.field_73890_c.func_74297_c(var6)));
         }

         ++var2;
      }

      if(var2 % 2 == 1) {
         ++var2;
      }

      this.field_82269_o = this.field_73881_g / 6 + 24 * (var2 >> 1);
      var2 += 2;
      var3 = field_82267_b;
      var4 = var3.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if(var6.func_74380_a()) {
            this.field_73887_h.add(new GuiSlider(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 + 24 * (var2 >> 1), var6, this.field_73890_c.func_74297_c(var6), this.field_73890_c.func_74296_a(var6)));
         } else {
            this.field_73887_h.add(new GuiSmallButton(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 + 24 * (var2 >> 1), var6, this.field_73890_c.func_74297_c(var6)));
         }

         ++var2;
      }

      this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, var1.func_74805_b("gui.done")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f < 100 && p_73875_1_ instanceof GuiSmallButton) {
            this.field_73890_c.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = this.field_73890_c.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
         }

         if(p_73875_1_.field_73741_f == 200) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(this.field_73889_b);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_73888_d, this.field_73880_f / 2, 20, 16777215);
      this.func_73732_a(this.field_73886_k, this.field_82268_n, this.field_73880_f / 2, this.field_82269_o + 7, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
