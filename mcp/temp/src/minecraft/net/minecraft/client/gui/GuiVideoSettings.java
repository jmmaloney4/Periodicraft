package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiVideoSettings extends GuiScreen {

   private GuiScreen field_74105_b;
   protected String field_74107_a = "Video Settings";
   private GameSettings field_74106_c;
   private boolean field_74104_d = false;
   private static EnumOptions[] field_74108_m = new EnumOptions[]{EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL, EnumOptions.GAMMA, EnumOptions.RENDER_CLOUDS, EnumOptions.PARTICLES, EnumOptions.USE_SERVER_TEXTURES, EnumOptions.USE_FULLSCREEN, EnumOptions.ENABLE_VSYNC};


   public GuiVideoSettings(GuiScreen p_i3034_1_, GameSettings p_i3034_2_) {
      this.field_74105_b = p_i3034_1_;
      this.field_74106_c = p_i3034_2_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_74107_a = var1.func_74805_b("options.videoTitle");
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, var1.func_74805_b("gui.done")));
      this.field_74104_d = false;
      String[] var2 = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
      String[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         String var7 = System.getProperty(var6);
         if(var7 != null && var7.contains("64")) {
            this.field_74104_d = true;
            break;
         }
      }

      int var9 = 0;
      var4 = this.field_74104_d?0:-15;
      EnumOptions[] var10 = field_74108_m;
      int var11 = var10.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         EnumOptions var8 = var10[var12];
         if(var8.func_74380_a()) {
            this.field_73887_h.add(new GuiSlider(var8.func_74381_c(), this.field_73880_f / 2 - 155 + var9 % 2 * 160, this.field_73881_g / 7 + var4 + 24 * (var9 >> 1), var8, this.field_74106_c.func_74297_c(var8), this.field_74106_c.func_74296_a(var8)));
         } else {
            this.field_73887_h.add(new GuiSmallButton(var8.func_74381_c(), this.field_73880_f / 2 - 155 + var9 % 2 * 160, this.field_73881_g / 7 + var4 + 24 * (var9 >> 1), var8, this.field_74106_c.func_74297_c(var8)));
         }

         ++var9;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         int var2 = this.field_74106_c.field_74335_Z;
         if(p_73875_1_.field_73741_f < 100 && p_73875_1_ instanceof GuiSmallButton) {
            this.field_74106_c.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = this.field_74106_c.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
         }

         if(p_73875_1_.field_73741_f == 200) {
            this.field_73882_e.field_71474_y.func_74303_b();
            this.field_73882_e.func_71373_a(this.field_74105_b);
         }

         if(this.field_74106_c.field_74335_Z != var2) {
            ScaledResolution var3 = new ScaledResolution(this.field_73882_e.field_71474_y, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
            int var4 = var3.func_78326_a();
            int var5 = var3.func_78328_b();
            this.func_73872_a(this.field_73882_e, var4, var5);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_74107_a, this.field_73880_f / 2, this.field_74104_d?20:5, 16777215);
      if(!this.field_74104_d && this.field_74106_c.field_74339_e == 0) {
         this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("options.farWarning1"), this.field_73880_f / 2, this.field_73881_g / 6 + 144 + 1, 11468800);
         this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("options.farWarning2"), this.field_73880_f / 2, this.field_73881_g / 6 + 144 + 13, 11468800);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
