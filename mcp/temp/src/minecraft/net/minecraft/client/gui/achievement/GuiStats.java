package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.achievement.GuiSlotStatsBlock;
import net.minecraft.client.gui.achievement.GuiSlotStatsGeneral;
import net.minecraft.client.gui.achievement.GuiSlotStatsItem;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiScreen {

   private static RenderItem field_74152_c = new RenderItem();
   protected GuiScreen field_74154_a;
   protected String field_74151_b = "Select world";
   private GuiSlotStatsGeneral field_74150_d;
   private GuiSlotStatsItem field_74157_m;
   private GuiSlotStatsBlock field_74155_n;
   private StatFileWriter field_74156_o;
   private GuiSlot field_74153_p = null;


   public GuiStats(GuiScreen p_i3072_1_, StatFileWriter p_i3072_2_) {
      this.field_74154_a = p_i3072_1_;
      this.field_74156_o = p_i3072_2_;
   }

   public void func_73866_w_() {
      this.field_74151_b = StatCollector.func_74838_a("gui.stats");
      this.field_74150_d = new GuiSlotStatsGeneral(this);
      this.field_74150_d.func_77220_a(this.field_73887_h, 1, 1);
      this.field_74157_m = new GuiSlotStatsItem(this);
      this.field_74157_m.func_77220_a(this.field_73887_h, 1, 1);
      this.field_74155_n = new GuiSlotStatsBlock(this);
      this.field_74155_n.func_77220_a(this.field_73887_h, 1, 1);
      this.field_74153_p = this.field_74150_d;
      this.func_74143_g();
   }

   public void func_74143_g() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 150, 20, var1.func_74805_b("gui.done")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, var1.func_74805_b("stat.generalButton")));
      GuiButton var2;
      this.field_73887_h.add(var2 = new GuiButton(2, this.field_73880_f / 2 - 46, this.field_73881_g - 52, 100, 20, var1.func_74805_b("stat.blocksButton")));
      GuiButton var3;
      this.field_73887_h.add(var3 = new GuiButton(3, this.field_73880_f / 2 + 62, this.field_73881_g - 52, 100, 20, var1.func_74805_b("stat.itemsButton")));
      if(this.field_74155_n.func_77217_a() == 0) {
         var2.field_73742_g = false;
      }

      if(this.field_74157_m.func_77217_a() == 0) {
         var3.field_73742_g = false;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a(this.field_74154_a);
         } else if(p_73875_1_.field_73741_f == 1) {
            this.field_74153_p = this.field_74150_d;
         } else if(p_73875_1_.field_73741_f == 3) {
            this.field_74153_p = this.field_74157_m;
         } else if(p_73875_1_.field_73741_f == 2) {
            this.field_74153_p = this.field_74155_n;
         } else {
            this.field_74153_p.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_74153_p.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_74151_b, this.field_73880_f / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   private void func_74137_c(int p_74137_1_, int p_74137_2_, int p_74137_3_) {
      this.func_74142_b(p_74137_1_ + 1, p_74137_2_ + 1);
      GL11.glEnable('\u803a');
      RenderHelper.func_74520_c();
      field_74152_c.func_77015_a(this.field_73886_k, this.field_73882_e.field_71446_o, new ItemStack(p_74137_3_, 1, 0), p_74137_1_ + 2, p_74137_2_ + 2);
      RenderHelper.func_74518_a();
      GL11.glDisable('\u803a');
   }

   private void func_74142_b(int p_74142_1_, int p_74142_2_) {
      this.func_74138_c(p_74142_1_, p_74142_2_, 0, 0);
   }

   private void func_74138_c(int p_74138_1_, int p_74138_2_, int p_74138_3_, int p_74138_4_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/slot.png");
      Tessellator var9 = Tessellator.field_78398_a;
      var9.func_78382_b();
      var9.func_78374_a((double)(p_74138_1_ + 0), (double)(p_74138_2_ + 18), (double)this.field_73735_i, (double)((float)(p_74138_3_ + 0) * 0.0078125F), (double)((float)(p_74138_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_74138_1_ + 18), (double)(p_74138_2_ + 18), (double)this.field_73735_i, (double)((float)(p_74138_3_ + 18) * 0.0078125F), (double)((float)(p_74138_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_74138_1_ + 18), (double)(p_74138_2_ + 0), (double)this.field_73735_i, (double)((float)(p_74138_3_ + 18) * 0.0078125F), (double)((float)(p_74138_4_ + 0) * 0.0078125F));
      var9.func_78374_a((double)(p_74138_1_ + 0), (double)(p_74138_2_ + 0), (double)this.field_73735_i, (double)((float)(p_74138_3_ + 0) * 0.0078125F), (double)((float)(p_74138_4_ + 0) * 0.0078125F));
      var9.func_78381_a();
   }

   // $FF: synthetic method
   static Minecraft func_74130_a(GuiStats p_74130_0_) {
      return p_74130_0_.field_73882_e;
   }

   // $FF: synthetic method
   static FontRenderer func_74145_b(GuiStats p_74145_0_) {
      return p_74145_0_.field_73886_k;
   }

   // $FF: synthetic method
   static StatFileWriter func_74127_c(GuiStats p_74127_0_) {
      return p_74127_0_.field_74156_o;
   }

   // $FF: synthetic method
   static FontRenderer func_74132_d(GuiStats p_74132_0_) {
      return p_74132_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74128_e(GuiStats p_74128_0_) {
      return p_74128_0_.field_73886_k;
   }

   // $FF: synthetic method
   static Minecraft func_74139_f(GuiStats p_74139_0_) {
      return p_74139_0_.field_73882_e;
   }

   // $FF: synthetic method
   static void func_74134_a(GuiStats p_74134_0_, int p_74134_1_, int p_74134_2_, int p_74134_3_, int p_74134_4_) {
      p_74134_0_.func_74138_c(p_74134_1_, p_74134_2_, p_74134_3_, p_74134_4_);
   }

   // $FF: synthetic method
   static Minecraft func_74133_g(GuiStats p_74133_0_) {
      return p_74133_0_.field_73882_e;
   }

   // $FF: synthetic method
   static FontRenderer func_74129_h(GuiStats p_74129_0_) {
      return p_74129_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74146_i(GuiStats p_74146_0_) {
      return p_74146_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74135_j(GuiStats p_74135_0_) {
      return p_74135_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74148_k(GuiStats p_74148_0_) {
      return p_74148_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74147_l(GuiStats p_74147_0_) {
      return p_74147_0_.field_73886_k;
   }

   // $FF: synthetic method
   static void func_74149_a(GuiStats p_74149_0_, int p_74149_1_, int p_74149_2_, int p_74149_3_, int p_74149_4_, int p_74149_5_, int p_74149_6_) {
      p_74149_0_.func_73733_a(p_74149_1_, p_74149_2_, p_74149_3_, p_74149_4_, p_74149_5_, p_74149_6_);
   }

   // $FF: synthetic method
   static FontRenderer func_74141_m(GuiStats p_74141_0_) {
      return p_74141_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_74140_n(GuiStats p_74140_0_) {
      return p_74140_0_.field_73886_k;
   }

   // $FF: synthetic method
   static void func_74136_b(GuiStats p_74136_0_, int p_74136_1_, int p_74136_2_, int p_74136_3_, int p_74136_4_, int p_74136_5_, int p_74136_6_) {
      p_74136_0_.func_73733_a(p_74136_1_, p_74136_2_, p_74136_3_, p_74136_4_, p_74136_5_, p_74136_6_);
   }

   // $FF: synthetic method
   static FontRenderer func_74144_o(GuiStats p_74144_0_) {
      return p_74144_0_.field_73886_k;
   }

   // $FF: synthetic method
   static void func_74131_a(GuiStats p_74131_0_, int p_74131_1_, int p_74131_2_, int p_74131_3_) {
      p_74131_0_.func_74137_c(p_74131_1_, p_74131_2_, p_74131_3_);
   }

}
