package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenCreateOnlineWorld;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.SelectionListLocation;
import net.minecraft.client.mco.Location;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiScreenSelectLocation extends GuiScreen {

   protected GuiScreenCreateOnlineWorld field_96242_a;
   private int field_96238_b = -1;
   private SelectionListLocation field_96239_c;
   private GuiSmallButton field_96237_d;
   private Location field_96243_n;
   private List field_96244_o;
   private String field_96241_p;
   private String field_96240_q;


   public GuiScreenSelectLocation(GuiScreenCreateOnlineWorld p_i10005_1_, List p_i10005_2_, Location p_i10005_3_, String p_i10005_4_, String p_i10005_5_) {
      this.field_96242_a = p_i10005_1_;
      this.field_96244_o = p_i10005_2_;
      this.field_96243_n = p_i10005_3_;
      this.field_96241_p = p_i10005_4_;
      this.field_96240_q = p_i10005_5_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(this.field_96237_d = new GuiSmallButton(6, this.field_73880_f / 2 - 75, this.field_73881_g - 38, var1.func_74805_b("gui.done")));
      this.field_96239_c = new SelectionListLocation(this);
      this.field_96239_c.func_77220_a(this.field_73887_h, 7, 8);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         switch(p_73875_1_.field_73741_f) {
         case 5:
            break;
         case 6:
            this.field_96242_a.func_96251_a(this.field_96243_n, this.field_96241_p, this.field_96240_q);
            this.field_73882_e.func_71373_a(this.field_96242_a);
            break;
         default:
            this.field_96239_c.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_96239_c.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_96238_b <= 0) {
         this.field_73882_e.field_71418_C.func_77305_c();
         this.field_96238_b += 20;
      }

      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.create.world.location.title"), this.field_73880_f / 2, 16, 16777215);
      this.func_73732_a(this.field_73886_k, "(" + var4.func_74805_b("mco.create.world.location.warning") + ")", this.field_73880_f / 2, this.field_73881_g - 56, 8421504);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      super.func_73876_c();
      --this.field_96238_b;
   }

   // $FF: synthetic method
   static Minecraft func_96232_a(GuiScreenSelectLocation p_96232_0_) {
      return p_96232_0_.field_73882_e;
   }

   // $FF: synthetic method
   static List func_96236_b(GuiScreenSelectLocation p_96236_0_) {
      return p_96236_0_.field_96244_o;
   }

   // $FF: synthetic method
   static Location func_96234_a(GuiScreenSelectLocation p_96234_0_, Location p_96234_1_) {
      return p_96234_0_.field_96243_n = p_96234_1_;
   }

   // $FF: synthetic method
   static GuiSmallButton func_96230_c(GuiScreenSelectLocation p_96230_0_) {
      return p_96230_0_.field_96237_d;
   }

   // $FF: synthetic method
   static Location func_96233_d(GuiScreenSelectLocation p_96233_0_) {
      return p_96233_0_.field_96243_n;
   }

   // $FF: synthetic method
   static FontRenderer func_96231_e(GuiScreenSelectLocation p_96231_0_) {
      return p_96231_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_96235_f(GuiScreenSelectLocation p_96235_0_) {
      return p_96235_0_.field_73886_k;
   }
}
