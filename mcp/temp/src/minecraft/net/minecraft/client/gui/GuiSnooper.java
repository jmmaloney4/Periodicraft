package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSnooperList;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiSnooper extends GuiScreen {

   private final GuiScreen field_74100_a;
   private final GameSettings field_74097_b;
   private final List field_74098_c = new ArrayList();
   private final List field_74096_d = new ArrayList();
   private String field_74103_m;
   private String[] field_74101_n;
   private GuiSnooperList field_74102_o;
   private GuiButton field_74099_p;


   public GuiSnooper(GuiScreen p_i3041_1_, GameSettings p_i3041_2_) {
      this.field_74100_a = p_i3041_1_;
      this.field_74097_b = p_i3041_2_;
   }

   public void func_73866_w_() {
      this.field_74103_m = StatCollector.func_74838_a("options.snooper.title");
      String var1 = StatCollector.func_74838_a("options.snooper.desc");
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_73886_k.func_78271_c(var1, this.field_73880_f - 30).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      this.field_74101_n = (String[])var2.toArray(new String[0]);
      this.field_74098_c.clear();
      this.field_74096_d.clear();
      this.field_73887_h.add(this.field_74099_p = new GuiButton(1, this.field_73880_f / 2 - 152, this.field_73881_g - 30, 150, 20, this.field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED)));
      this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 + 2, this.field_73881_g - 30, 150, 20, StatCollector.func_74838_a("gui.done")));
      boolean var6 = this.field_73882_e.func_71401_C() != null && this.field_73882_e.func_71401_C().func_80003_ah() != null;
      Iterator var7 = (new TreeMap(this.field_73882_e.func_71378_E().func_76465_c())).entrySet().iterator();

      Entry var5;
      while(var7.hasNext()) {
         var5 = (Entry)var7.next();
         this.field_74098_c.add((var6?"C ":"") + (String)var5.getKey());
         this.field_74096_d.add(this.field_73886_k.func_78269_a((String)var5.getValue(), this.field_73880_f - 220));
      }

      if(var6) {
         var7 = (new TreeMap(this.field_73882_e.func_71401_C().func_80003_ah().func_76465_c())).entrySet().iterator();

         while(var7.hasNext()) {
            var5 = (Entry)var7.next();
            this.field_74098_c.add("S " + (String)var5.getKey());
            this.field_74096_d.add(this.field_73886_k.func_78269_a((String)var5.getValue(), this.field_73880_f - 220));
         }
      }

      this.field_74102_o = new GuiSnooperList(this);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 2) {
            this.field_74097_b.func_74303_b();
            this.field_74097_b.func_74303_b();
            this.field_73882_e.func_71373_a(this.field_74100_a);
         }

         if(p_73875_1_.field_73741_f == 1) {
            this.field_74097_b.func_74306_a(EnumOptions.SNOOPER_ENABLED, 1);
            this.field_74099_p.field_73744_e = this.field_74097_b.func_74297_c(EnumOptions.SNOOPER_ENABLED);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.field_74102_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_74103_m, this.field_73880_f / 2, 8, 16777215);
      int var4 = 22;
      String[] var5 = this.field_74101_n;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String var8 = var5[var7];
         this.func_73732_a(this.field_73886_k, var8, this.field_73880_f / 2, var4, 8421504);
         var4 += this.field_73886_k.field_78288_b;
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   // $FF: synthetic method
   static List func_74095_a(GuiSnooper p_74095_0_) {
      return p_74095_0_.field_74098_c;
   }

   // $FF: synthetic method
   static List func_74094_b(GuiSnooper p_74094_0_) {
      return p_74094_0_.field_74096_d;
   }
}
