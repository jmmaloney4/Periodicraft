package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiRenameWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSlot;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.WorldInfo;

@SideOnly(Side.CLIENT)
public class GuiSelectWorld extends GuiScreen {

   private final DateFormat field_74076_c = new SimpleDateFormat();
   protected GuiScreen field_74077_a;
   protected String field_74075_b = "Select world";
   private boolean field_74074_d = false;
   private int field_74080_m;
   private List field_74078_n;
   private GuiWorldSlot field_74079_o;
   private String field_74087_p;
   private String field_74086_q;
   private String[] field_74085_r = new String[3];
   private boolean field_74084_s;
   private GuiButton field_74083_t;
   private GuiButton field_74082_u;
   private GuiButton field_74081_v;
   private GuiButton field_82316_w;


   public GuiSelectWorld(GuiScreen p_i3046_1_) {
      this.field_74077_a = p_i3046_1_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_74075_b = var1.func_74805_b("selectWorld.title");

      try {
         this.func_74073_h();
      } catch (AnvilConverterException var3) {
         var3.printStackTrace();
         this.field_73882_e.func_71373_a(new GuiErrorScreen("Unable to load words", var3.getMessage()));
         return;
      }

      this.field_74087_p = var1.func_74805_b("selectWorld.world");
      this.field_74086_q = var1.func_74805_b("selectWorld.conversion");
      this.field_74085_r[EnumGameType.SURVIVAL.func_77148_a()] = var1.func_74805_b("gameMode.survival");
      this.field_74085_r[EnumGameType.CREATIVE.func_77148_a()] = var1.func_74805_b("gameMode.creative");
      this.field_74085_r[EnumGameType.ADVENTURE.func_77148_a()] = var1.func_74805_b("gameMode.adventure");
      this.field_74079_o = new GuiWorldSlot(this);
      this.field_74079_o.func_77220_a(this.field_73887_h, 4, 5);
      this.func_74065_g();
   }

   private void func_74073_h() throws AnvilConverterException {
      ISaveFormat var1 = this.field_73882_e.func_71359_d();
      this.field_74078_n = var1.func_75799_b();
      Collections.sort(this.field_74078_n);
      this.field_74080_m = -1;
   }

   protected String func_74069_a(int p_74069_1_) {
      return ((SaveFormatComparator)this.field_74078_n.get(p_74069_1_)).func_75786_a();
   }

   protected String func_74063_d(int p_74063_1_) {
      String var2 = ((SaveFormatComparator)this.field_74078_n.get(p_74063_1_)).func_75788_b();
      if(var2 == null || MathHelper.func_76139_a(var2)) {
         StringTranslate var3 = StringTranslate.func_74808_a();
         var2 = var3.func_74805_b("selectWorld.world") + " " + (p_74063_1_ + 1);
      }

      return var2;
   }

   public void func_74065_g() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(this.field_74082_u = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 150, 20, var1.func_74805_b("selectWorld.select")));
      this.field_73887_h.add(new GuiButton(3, this.field_73880_f / 2 + 4, this.field_73881_g - 52, 150, 20, var1.func_74805_b("selectWorld.create")));
      this.field_73887_h.add(this.field_74081_v = new GuiButton(6, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 72, 20, var1.func_74805_b("selectWorld.rename")));
      this.field_73887_h.add(this.field_74083_t = new GuiButton(2, this.field_73880_f / 2 - 76, this.field_73881_g - 28, 72, 20, var1.func_74805_b("selectWorld.delete")));
      this.field_73887_h.add(this.field_82316_w = new GuiButton(7, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 72, 20, var1.func_74805_b("selectWorld.recreate")));
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 82, this.field_73881_g - 28, 72, 20, var1.func_74805_b("gui.cancel")));
      this.field_74082_u.field_73742_g = false;
      this.field_74083_t.field_73742_g = false;
      this.field_74081_v.field_73742_g = false;
      this.field_82316_w.field_73742_g = false;
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 2) {
            String var2 = this.func_74063_d(this.field_74080_m);
            if(var2 != null) {
               this.field_74084_s = true;
               GuiYesNo var3 = func_74061_a(this, var2, this.field_74080_m);
               this.field_73882_e.func_71373_a(var3);
            }
         } else if(p_73875_1_.field_73741_f == 1) {
            this.func_74064_e(this.field_74080_m);
         } else if(p_73875_1_.field_73741_f == 3) {
            this.field_73882_e.func_71373_a(new GuiCreateWorld(this));
         } else if(p_73875_1_.field_73741_f == 6) {
            this.field_73882_e.func_71373_a(new GuiRenameWorld(this, this.func_74069_a(this.field_74080_m)));
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a(this.field_74077_a);
         } else if(p_73875_1_.field_73741_f == 7) {
            GuiCreateWorld var5 = new GuiCreateWorld(this);
            ISaveHandler var6 = this.field_73882_e.func_71359_d().func_75804_a(this.func_74069_a(this.field_74080_m), false);
            WorldInfo var4 = var6.func_75757_d();
            var6.func_75759_a();
            var5.func_82286_a(var4);
            this.field_73882_e.func_71373_a(var5);
         } else {
            this.field_74079_o.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_74064_e(int p_74064_1_) {
      this.field_73882_e.func_71373_a((GuiScreen)null);
      if(!this.field_74074_d) {
         this.field_74074_d = true;
         String var2 = this.func_74069_a(p_74064_1_);
         if(var2 == null) {
            var2 = "World" + p_74064_1_;
         }

         String var3 = this.func_74063_d(p_74064_1_);
         if(var3 == null) {
            var3 = "World" + p_74064_1_;
         }

         if(this.field_73882_e.func_71359_d().func_90033_f(var2)) {
            this.field_73882_e.func_71371_a(var2, var3, (WorldSettings)null);
         }

      }
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(this.field_74084_s) {
         this.field_74084_s = false;
         if(p_73878_1_) {
            ISaveFormat var3 = this.field_73882_e.func_71359_d();
            var3.func_75800_d();
            var3.func_75802_e(this.func_74069_a(p_73878_2_));

            try {
               this.func_74073_h();
            } catch (AnvilConverterException var5) {
               var5.printStackTrace();
            }
         }

         this.field_73882_e.func_71373_a(this);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_74079_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_74075_b, this.field_73880_f / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public static GuiYesNo func_74061_a(GuiScreen p_74061_0_, String p_74061_1_, int p_74061_2_) {
      StringTranslate var3 = StringTranslate.func_74808_a();
      String var4 = var3.func_74805_b("selectWorld.deleteQuestion");
      String var5 = "\'" + p_74061_1_ + "\' " + var3.func_74805_b("selectWorld.deleteWarning");
      String var6 = var3.func_74805_b("selectWorld.deleteButton");
      String var7 = var3.func_74805_b("gui.cancel");
      GuiYesNo var8 = new GuiYesNo(p_74061_0_, var4, var5, var6, var7, p_74061_2_);
      return var8;
   }

   // $FF: synthetic method
   static List func_74068_a(GuiSelectWorld p_74068_0_) {
      return p_74068_0_.field_74078_n;
   }

   // $FF: synthetic method
   static int func_74072_a(GuiSelectWorld p_74072_0_, int p_74072_1_) {
      return p_74072_0_.field_74080_m = p_74072_1_;
   }

   // $FF: synthetic method
   static int func_74062_b(GuiSelectWorld p_74062_0_) {
      return p_74062_0_.field_74080_m;
   }

   // $FF: synthetic method
   static GuiButton func_74070_c(GuiSelectWorld p_74070_0_) {
      return p_74070_0_.field_74082_u;
   }

   // $FF: synthetic method
   static GuiButton func_74059_d(GuiSelectWorld p_74059_0_) {
      return p_74059_0_.field_74083_t;
   }

   // $FF: synthetic method
   static GuiButton func_74071_e(GuiSelectWorld p_74071_0_) {
      return p_74071_0_.field_74081_v;
   }

   // $FF: synthetic method
   static GuiButton func_82312_f(GuiSelectWorld p_82312_0_) {
      return p_82312_0_.field_82316_w;
   }

   // $FF: synthetic method
   static String func_82313_g(GuiSelectWorld p_82313_0_) {
      return p_82313_0_.field_74087_p;
   }

   // $FF: synthetic method
   static DateFormat func_82315_h(GuiSelectWorld p_82315_0_) {
      return p_82315_0_.field_74076_c;
   }

   // $FF: synthetic method
   static String func_82311_i(GuiSelectWorld p_82311_0_) {
      return p_82311_0_.field_74086_q;
   }

   // $FF: synthetic method
   static String[] func_82314_j(GuiSelectWorld p_82314_0_) {
      return p_82314_0_.field_74085_r;
   }
}
