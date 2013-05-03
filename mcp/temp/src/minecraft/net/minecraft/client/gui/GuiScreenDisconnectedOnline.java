package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiScreenDisconnectedOnline extends GuiScreen {

   private String field_98113_a;
   private String field_98111_b;
   private Object[] field_98112_c;
   private List field_98110_d;
   private final GuiScreen field_98114_n;


   public GuiScreenDisconnectedOnline(GuiScreen p_i11007_1_, String p_i11007_2_, String p_i11007_3_, Object ... p_i11007_4_) {
      StringTranslate var5 = StringTranslate.func_74808_a();
      this.field_98114_n = p_i11007_1_;
      this.field_98113_a = var5.func_74805_b(p_i11007_2_);
      this.field_98111_b = p_i11007_3_;
      this.field_98112_c = p_i11007_4_;
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.back")));
      if(this.field_98112_c != null) {
         this.field_98110_d = this.field_73886_k.func_78271_c(var1.func_74803_a(this.field_98111_b, this.field_98112_c), this.field_73880_f - 50);
      } else {
         this.field_98110_d = this.field_73886_k.func_78271_c(var1.func_74805_b(this.field_98111_b), this.field_73880_f - 50);
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0) {
         this.field_73882_e.func_71373_a(this.field_98114_n);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_98113_a, this.field_73880_f / 2, this.field_73881_g / 2 - 50, 11184810);
      int var4 = this.field_73881_g / 2 - 30;
      if(this.field_98110_d != null) {
         for(Iterator var5 = this.field_98110_d.iterator(); var5.hasNext(); var4 += this.field_73886_k.field_78288_b) {
            String var6 = (String)var5.next();
            this.func_73732_a(this.field_73886_k, var6, this.field_73880_f / 2, var4, 16777215);
         }
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
