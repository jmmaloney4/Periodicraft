package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiControls extends GuiScreen {

   private GuiScreen field_73909_b;
   protected String field_73911_a = "Controls";
   private GameSettings field_73910_c;
   private int field_73908_d = -1;


   public GuiControls(GuiScreen p_i3032_1_, GameSettings p_i3032_2_) {
      this.field_73909_b = p_i3032_1_;
      this.field_73910_c = p_i3032_2_;
   }

   private int func_73907_g() {
      return this.field_73880_f / 2 - 155;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      int var2 = this.func_73907_g();

      for(int var3 = 0; var3 < this.field_73910_c.field_74324_K.length; ++var3) {
         this.field_73887_h.add(new GuiSmallButton(var3, var2 + var3 % 2 * 160, this.field_73881_g / 6 + 24 * (var3 >> 1), 70, 20, this.field_73910_c.func_74301_b(var3)));
      }

      this.field_73887_h.add(new GuiButton(200, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 168, var1.func_74805_b("gui.done")));
      this.field_73911_a = var1.func_74805_b("controls.title");
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      for(int var2 = 0; var2 < this.field_73910_c.field_74324_K.length; ++var2) {
         ((GuiButton)this.field_73887_h.get(var2)).field_73744_e = this.field_73910_c.func_74301_b(var2);
      }

      if(p_73875_1_.field_73741_f == 200) {
         this.field_73882_e.func_71373_a(this.field_73909_b);
      } else {
         this.field_73908_d = p_73875_1_.field_73741_f;
         p_73875_1_.field_73744_e = "> " + this.field_73910_c.func_74301_b(p_73875_1_.field_73741_f) + " <";
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      if(this.field_73908_d >= 0) {
         this.field_73910_c.func_74307_a(this.field_73908_d, -100 + p_73864_3_);
         ((GuiButton)this.field_73887_h.get(this.field_73908_d)).field_73744_e = this.field_73910_c.func_74301_b(this.field_73908_d);
         this.field_73908_d = -1;
         KeyBinding.func_74508_b();
      } else {
         super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(this.field_73908_d >= 0) {
         this.field_73910_c.func_74307_a(this.field_73908_d, p_73869_2_);
         ((GuiButton)this.field_73887_h.get(this.field_73908_d)).field_73744_e = this.field_73910_c.func_74301_b(this.field_73908_d);
         this.field_73908_d = -1;
         KeyBinding.func_74508_b();
      } else {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_73911_a, this.field_73880_f / 2, 20, 16777215);
      int var4 = this.func_73907_g();
      int var5 = 0;

      while(var5 < this.field_73910_c.field_74324_K.length) {
         boolean var6 = false;
         int var7 = 0;

         while(true) {
            if(var7 < this.field_73910_c.field_74324_K.length) {
               if(var7 == var5 || this.field_73910_c.field_74324_K[var5].field_74512_d != this.field_73910_c.field_74324_K[var7].field_74512_d) {
                  ++var7;
                  continue;
               }

               var6 = true;
            }

            if(this.field_73908_d == var5) {
               ((GuiButton)this.field_73887_h.get(var5)).field_73744_e = "" + EnumChatFormatting.WHITE + "> " + EnumChatFormatting.YELLOW + "??? " + EnumChatFormatting.WHITE + "<";
            } else if(var6) {
               ((GuiButton)this.field_73887_h.get(var5)).field_73744_e = EnumChatFormatting.RED + this.field_73910_c.func_74301_b(var5);
            } else {
               ((GuiButton)this.field_73887_h.get(var5)).field_73744_e = this.field_73910_c.func_74301_b(var5);
            }

            this.func_73731_b(this.field_73886_k, this.field_73910_c.func_74302_a(var5), var4 + var5 % 2 * 160 + 70 + 6, this.field_73881_g / 6 + 24 * (var5 >> 1) + 7, -1);
            ++var5;
            break;
         }
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
