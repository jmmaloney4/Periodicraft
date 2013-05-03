package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiCreateWorld extends GuiScreen {

   private GuiScreen field_73924_a;
   private GuiTextField field_73919_b;
   private GuiTextField field_73921_c;
   private String field_73918_d;
   private String field_73927_m = "survival";
   private boolean field_73925_n = true;
   private boolean field_73926_o = false;
   private boolean field_73935_p = false;
   private boolean field_73934_q = false;
   private boolean field_73933_r = false;
   private boolean field_73932_s;
   private boolean field_73931_t;
   private GuiButton field_73930_u;
   private GuiButton field_73929_v;
   private GuiButton field_73928_w;
   private GuiButton field_73938_x;
   private GuiButton field_73937_y;
   private GuiButton field_73936_z;
   private GuiButton field_82289_B;
   private String field_73920_A;
   private String field_73922_B;
   private String field_73923_C;
   private String field_73915_D;
   private int field_73916_E = 0;
   public String field_82290_a = "";
   private static final String[] field_73917_F = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};


   public GuiCreateWorld(GuiScreen p_i3036_1_) {
      this.field_73924_a = p_i3036_1_;
      this.field_73923_C = "";
      this.field_73915_D = StatCollector.func_74838_a("selectWorld.newWorld");
   }

   public void func_73876_c() {
      this.field_73919_b.func_73780_a();
      this.field_73921_c.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, var1.func_74805_b("selectWorld.create")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, var1.func_74805_b("gui.cancel")));
      this.field_73887_h.add(this.field_73930_u = new GuiButton(2, this.field_73880_f / 2 - 75, 115, 150, 20, var1.func_74805_b("selectWorld.gameMode")));
      this.field_73887_h.add(this.field_73929_v = new GuiButton(3, this.field_73880_f / 2 - 75, 187, 150, 20, var1.func_74805_b("selectWorld.moreWorldOptions")));
      this.field_73887_h.add(this.field_73928_w = new GuiButton(4, this.field_73880_f / 2 - 155, 100, 150, 20, var1.func_74805_b("selectWorld.mapFeatures")));
      this.field_73928_w.field_73748_h = false;
      this.field_73887_h.add(this.field_73938_x = new GuiButton(7, this.field_73880_f / 2 + 5, 151, 150, 20, var1.func_74805_b("selectWorld.bonusItems")));
      this.field_73938_x.field_73748_h = false;
      this.field_73887_h.add(this.field_73937_y = new GuiButton(5, this.field_73880_f / 2 + 5, 100, 150, 20, var1.func_74805_b("selectWorld.mapType")));
      this.field_73937_y.field_73748_h = false;
      this.field_73887_h.add(this.field_73936_z = new GuiButton(6, this.field_73880_f / 2 - 155, 151, 150, 20, var1.func_74805_b("selectWorld.allowCommands")));
      this.field_73936_z.field_73748_h = false;
      this.field_73887_h.add(this.field_82289_B = new GuiButton(8, this.field_73880_f / 2 + 5, 120, 150, 20, var1.func_74805_b("selectWorld.customizeType")));
      this.field_82289_B.field_73748_h = false;
      this.field_73919_b = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
      this.field_73919_b.func_73796_b(true);
      this.field_73919_b.func_73782_a(this.field_73915_D);
      this.field_73921_c = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
      this.field_73921_c.func_73782_a(this.field_73923_C);
      this.func_82288_a(this.field_73931_t);
      this.func_73912_g();
      this.func_73914_h();
   }

   private void func_73912_g() {
      this.field_73918_d = this.field_73919_b.func_73781_b().trim();
      char[] var1 = ChatAllowedCharacters.field_71567_b;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         this.field_73918_d = this.field_73918_d.replace(var4, '_');
      }

      if(MathHelper.func_76139_a(this.field_73918_d)) {
         this.field_73918_d = "World";
      }

      this.field_73918_d = func_73913_a(this.field_73882_e.func_71359_d(), this.field_73918_d);
   }

   private void func_73914_h() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73930_u.field_73744_e = var1.func_74805_b("selectWorld.gameMode") + " " + var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m);
      this.field_73920_A = var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m + ".line1");
      this.field_73922_B = var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m + ".line2");
      this.field_73928_w.field_73744_e = var1.func_74805_b("selectWorld.mapFeatures") + " ";
      if(this.field_73925_n) {
         this.field_73928_w.field_73744_e = this.field_73928_w.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73928_w.field_73744_e = this.field_73928_w.field_73744_e + var1.func_74805_b("options.off");
      }

      this.field_73938_x.field_73744_e = var1.func_74805_b("selectWorld.bonusItems") + " ";
      if(this.field_73934_q && !this.field_73933_r) {
         this.field_73938_x.field_73744_e = this.field_73938_x.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73938_x.field_73744_e = this.field_73938_x.field_73744_e + var1.func_74805_b("options.off");
      }

      this.field_73937_y.field_73744_e = var1.func_74805_b("selectWorld.mapType") + " " + var1.func_74805_b(WorldType.field_77139_a[this.field_73916_E].func_77128_b());
      this.field_73936_z.field_73744_e = var1.func_74805_b("selectWorld.allowCommands") + " ";
      if(this.field_73926_o && !this.field_73933_r) {
         this.field_73936_z.field_73744_e = this.field_73936_z.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73936_z.field_73744_e = this.field_73936_z.field_73744_e + var1.func_74805_b("options.off");
      }

   }

   public static String func_73913_a(ISaveFormat p_73913_0_, String p_73913_1_) {
      p_73913_1_ = p_73913_1_.replaceAll("[\\./\"]", "_");
      String[] var2 = field_73917_F;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if(p_73913_1_.equalsIgnoreCase(var5)) {
            p_73913_1_ = "_" + p_73913_1_ + "_";
         }
      }

      while(p_73913_0_.func_75803_c(p_73913_1_) != null) {
         p_73913_1_ = p_73913_1_ + "-";
      }

      return p_73913_1_;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a(this.field_73924_a);
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            if(this.field_73932_s) {
               return;
            }

            this.field_73932_s = true;
            long var2 = (new Random()).nextLong();
            String var4 = this.field_73921_c.func_73781_b();
            if(!MathHelper.func_76139_a(var4)) {
               try {
                  long var5 = Long.parseLong(var4);
                  if(var5 != 0L) {
                     var2 = var5;
                  }
               } catch (NumberFormatException var7) {
                  var2 = (long)var4.hashCode();
               }
            }

            EnumGameType var8 = EnumGameType.func_77142_a(this.field_73927_m);
            WorldSettings var6 = new WorldSettings(var2, var8, this.field_73925_n, this.field_73933_r, WorldType.field_77139_a[this.field_73916_E]);
            var6.func_82750_a(this.field_82290_a);
            if(this.field_73934_q && !this.field_73933_r) {
               var6.func_77159_a();
            }

            if(this.field_73926_o && !this.field_73933_r) {
               var6.func_77166_b();
            }

            this.field_73882_e.func_71371_a(this.field_73918_d, this.field_73919_b.func_73781_b().trim(), var6);
         } else if(p_73875_1_.field_73741_f == 3) {
            this.func_82287_i();
         } else if(p_73875_1_.field_73741_f == 2) {
            if(this.field_73927_m.equals("survival")) {
               if(!this.field_73935_p) {
                  this.field_73926_o = false;
               }

               this.field_73933_r = false;
               this.field_73927_m = "hardcore";
               this.field_73933_r = true;
               this.field_73936_z.field_73742_g = false;
               this.field_73938_x.field_73742_g = false;
               this.func_73914_h();
            } else if(this.field_73927_m.equals("hardcore")) {
               if(!this.field_73935_p) {
                  this.field_73926_o = true;
               }

               this.field_73933_r = false;
               this.field_73927_m = "creative";
               this.func_73914_h();
               this.field_73933_r = false;
               this.field_73936_z.field_73742_g = true;
               this.field_73938_x.field_73742_g = true;
            } else {
               if(!this.field_73935_p) {
                  this.field_73926_o = false;
               }

               this.field_73927_m = "survival";
               this.func_73914_h();
               this.field_73936_z.field_73742_g = true;
               this.field_73938_x.field_73742_g = true;
               this.field_73933_r = false;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 4) {
            this.field_73925_n = !this.field_73925_n;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 7) {
            this.field_73934_q = !this.field_73934_q;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 5) {
            ++this.field_73916_E;
            if(this.field_73916_E >= WorldType.field_77139_a.length) {
               this.field_73916_E = 0;
            }

            while(WorldType.field_77139_a[this.field_73916_E] == null || !WorldType.field_77139_a[this.field_73916_E].func_77126_d()) {
               ++this.field_73916_E;
               if(this.field_73916_E >= WorldType.field_77139_a.length) {
                  this.field_73916_E = 0;
               }
            }

            this.field_82290_a = "";
            this.func_73914_h();
            this.func_82288_a(this.field_73931_t);
         } else if(p_73875_1_.field_73741_f == 6) {
            this.field_73935_p = true;
            this.field_73926_o = !this.field_73926_o;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 8) {
            this.field_73882_e.func_71373_a(new GuiCreateFlatWorld(this, this.field_82290_a));
         }

      }
   }

   private void func_82287_i() {
      this.func_82288_a(!this.field_73931_t);
   }

   private void func_82288_a(boolean p_82288_1_) {
      this.field_73931_t = p_82288_1_;
      this.field_73930_u.field_73748_h = !this.field_73931_t;
      this.field_73928_w.field_73748_h = this.field_73931_t;
      this.field_73938_x.field_73748_h = this.field_73931_t;
      this.field_73937_y.field_73748_h = this.field_73931_t;
      this.field_73936_z.field_73748_h = this.field_73931_t;
      this.field_82289_B.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77138_c;
      StringTranslate var2;
      if(this.field_73931_t) {
         var2 = StringTranslate.func_74808_a();
         this.field_73929_v.field_73744_e = var2.func_74805_b("gui.done");
      } else {
         var2 = StringTranslate.func_74808_a();
         this.field_73929_v.field_73744_e = var2.func_74805_b("selectWorld.moreWorldOptions");
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(this.field_73919_b.func_73806_l() && !this.field_73931_t) {
         this.field_73919_b.func_73802_a(p_73869_1_, p_73869_2_);
         this.field_73915_D = this.field_73919_b.func_73781_b();
      } else if(this.field_73921_c.func_73806_l() && this.field_73931_t) {
         this.field_73921_c.func_73802_a(p_73869_1_, p_73869_2_);
         this.field_73923_C = this.field_73921_c.func_73781_b();
      }

      if(p_73869_1_ == 13) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73919_b.func_73781_b().length() > 0;
      this.func_73912_g();
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      if(this.field_73931_t) {
         this.field_73921_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      } else {
         this.field_73919_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("selectWorld.create"), this.field_73880_f / 2, 20, 16777215);
      if(this.field_73931_t) {
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.enterSeed"), this.field_73880_f / 2 - 100, 47, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.seedInfo"), this.field_73880_f / 2 - 100, 85, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.mapFeatures.info"), this.field_73880_f / 2 - 150, 122, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.allowCommands.info"), this.field_73880_f / 2 - 150, 172, 10526880);
         this.field_73921_c.func_73795_f();
      } else {
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.enterName"), this.field_73880_f / 2 - 100, 47, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.resultFolder") + " " + this.field_73918_d, this.field_73880_f / 2 - 100, 85, 10526880);
         this.field_73919_b.func_73795_f();
         this.func_73731_b(this.field_73886_k, this.field_73920_A, this.field_73880_f / 2 - 100, 137, 10526880);
         this.func_73731_b(this.field_73886_k, this.field_73922_B, this.field_73880_f / 2 - 100, 149, 10526880);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_82286_a(WorldInfo p_82286_1_) {
      this.field_73915_D = StatCollector.func_74837_a("selectWorld.newWorld.copyOf", new Object[]{p_82286_1_.func_76065_j()});
      this.field_73923_C = p_82286_1_.func_76063_b() + "";
      this.field_73916_E = p_82286_1_.func_76067_t().func_82747_f();
      this.field_82290_a = p_82286_1_.func_82571_y();
      this.field_73925_n = p_82286_1_.func_76089_r();
      this.field_73926_o = p_82286_1_.func_76086_u();
      if(p_82286_1_.func_76093_s()) {
         this.field_73927_m = "hardcore";
      } else if(p_82286_1_.func_76077_q().func_77144_e()) {
         this.field_73927_m = "survival";
      } else if(p_82286_1_.func_76077_q().func_77145_d()) {
         this.field_73927_m = "creative";
      }

   }

}
