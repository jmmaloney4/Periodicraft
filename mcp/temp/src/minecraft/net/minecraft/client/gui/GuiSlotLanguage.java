package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class GuiSlotLanguage extends GuiSlot {

   private ArrayList field_77251_g;
   private TreeMap field_77253_h;
   // $FF: synthetic field
   final GuiLanguage field_77252_a;


   public GuiSlotLanguage(GuiLanguage p_i3061_1_) {
      super(p_i3061_1_.field_73882_e, p_i3061_1_.field_73880_f, p_i3061_1_.field_73881_g, 32, p_i3061_1_.field_73881_g - 65 + 4, 18);
      this.field_77252_a = p_i3061_1_;
      this.field_77253_h = StringTranslate.func_74808_a().func_74806_b();
      this.field_77251_g = new ArrayList();
      Iterator var2 = this.field_77253_h.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.field_77251_g.add(var3);
      }

   }

   protected int func_77217_a() {
      return this.field_77251_g.size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      StringTranslate.func_74808_a().func_74810_a((String)this.field_77251_g.get(p_77213_1_), false);
      this.field_77252_a.field_73882_e.field_71466_p.func_78264_a(StringTranslate.func_74808_a().func_74804_d());
      GuiLanguage.func_74043_a(this.field_77252_a).field_74363_ab = (String)this.field_77251_g.get(p_77213_1_);
      this.field_77252_a.field_73886_k.func_78275_b(StringTranslate.func_74802_e(GuiLanguage.func_74043_a(this.field_77252_a).field_74363_ab));
      GuiLanguage.func_74042_b(this.field_77252_a).field_73744_e = StringTranslate.func_74808_a().func_74805_b("gui.done");
      GuiLanguage.func_74043_a(this.field_77252_a).func_74303_b();
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return ((String)this.field_77251_g.get(p_77218_1_)).equals(StringTranslate.func_74808_a().func_74811_c());
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 18;
   }

   protected void func_77221_c() {
      this.field_77252_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      this.field_77252_a.field_73886_k.func_78275_b(true);
      this.field_77252_a.func_73732_a(this.field_77252_a.field_73886_k, (String)this.field_77253_h.get(this.field_77251_g.get(p_77214_1_)), this.field_77252_a.field_73880_f / 2, p_77214_3_ + 1, 16777215);
      this.field_77252_a.field_73886_k.func_78275_b(StringTranslate.func_74802_e(GuiLanguage.func_74043_a(this.field_77252_a).field_74363_ab));
   }
}
