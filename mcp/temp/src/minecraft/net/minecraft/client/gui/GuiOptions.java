package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.GuiSnooper;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.texturepacks.GuiTexturePacks;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiOptions extends GuiScreen {

   private static final EnumOptions[] field_74052_b = new EnumOptions[]{EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.INVERT_MOUSE, EnumOptions.SENSITIVITY, EnumOptions.FOV, EnumOptions.DIFFICULTY, EnumOptions.TOUCHSCREEN};
   private final GuiScreen field_74053_c;
   private final GameSettings field_74051_d;
   protected String field_74054_a = "Options";


   public GuiOptions(GuiScreen p_i3042_1_, GameSettings p_i3042_2_) {
      this.field_74053_c = p_i3042_1_;
      this.field_74051_d = p_i3042_2_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      int var2 = 0;
      this.field_74054_a = var1.func_74805_b("options.title");
      EnumOptions[] var3 = field_74052_b;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumOptions var6 = var3[var5];
         if(var6.func_74380_a()) {
            this.field_73887_h.add(new GuiSlider(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 - 12 + 24 * (var2 >> 1), var6, this.field_74051_d.func_74297_c(var6), this.field_74051_d.func_74296_a(var6)));
         } else {
            GuiSmallButton var7 = new GuiSmallButton(var6.func_74381_c(), this.field_73880_f / 2 - 155 + var2 % 2 * 160, this.field_73881_g / 6 - 12 + 24 * (var2 >> 1), var6, this.field_74051_d.func_74297_c(var6));
            if(var6 == EnumOptions.DIFFICULTY && this.field_73882_e.field_71441_e != null && this.field_73882_e.field_71441_e.func_72912_H().func_76093_s()) {
               var7.field_73742_g = false;
               var7.field_73744_e = StatCollector.func_74838_a("options.difficulty") + ": " + StatCollector.func_74838_a("options.difficulty.hardcore");
            }

            this.field_73887_h.add(var7);
         }

         ++var2;
      }

      this.field_73887_h.add(new GuiButton(101, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 96 - 6, 150, 20, var1.func_74805_b("options.video")));
      this.field_73887_h.add(new GuiButton(100, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 96 - 6, 150, 20, var1.func_74805_b("options.controls")));
      this.field_73887_h.add(new GuiButton(102, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 120 - 6, 150, 20, var1.func_74805_b("options.language")));
      this.field_73887_h.add(new GuiButton(103, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 120 - 6, 150, 20, var1.func_74805_b("options.multiplayer.title")));
      this.field_73887_h.add(new GuiButton(105, this.field_73880_f / 2 - 152, this.field_73881_g / 6 + 144 - 6, 150, 20, var1.func_74805_b("options.texture.pack")));
      this.field_73887_h.add(new GuiButton(104, this.field_73880_f / 2 + 2, this.field_73881_g / 6 + 144 - 6, 150, 20, var1.func_74805_b("options.snooper.view")));
      this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, var1.func_74805_b("gui.done")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f < 100 && p_73875_1_ instanceof GuiSmallButton) {
            this.field_74051_d.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = this.field_74051_d.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
         }

         if(p_73875_1_.field_73741_f == 101) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new GuiVideoSettings(this, this.field_74051_d));
         }

         if(p_73875_1_.field_73741_f == 100) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new GuiControls(this, this.field_74051_d));
         }

         if(p_73875_1_.field_73741_f == 102) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new GuiLanguage(this, this.field_74051_d));
         }

         if(p_73875_1_.field_73741_f == 103) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new ScreenChatOptions(this, this.field_74051_d));
         }

         if(p_73875_1_.field_73741_f == 104) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new GuiSnooper(this, this.field_74051_d));
         }

         if(p_73875_1_.field_73741_f == 200) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(this.field_74053_c);
         }

         if(p_73875_1_.field_73741_f == 105) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(new GuiTexturePacks(this, this.field_74051_d));
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_74054_a, this.field_73880_f / 2, 15, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
