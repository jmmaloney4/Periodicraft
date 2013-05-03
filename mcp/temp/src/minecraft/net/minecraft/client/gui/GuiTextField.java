package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiTextField extends Gui {

   private final FontRenderer field_73815_a;
   private final int field_73813_b;
   private final int field_73814_c;
   private final int field_73811_d;
   private final int field_73812_e;
   private String field_73809_f = "";
   private int field_73810_g = 32;
   private int field_73822_h;
   private boolean field_73820_j = true;
   private boolean field_73821_k = true;
   private boolean field_73818_l = false;
   private boolean field_73819_m = true;
   private int field_73816_n = 0;
   private int field_73817_o = 0;
   private int field_73826_p = 0;
   private int field_73825_q = 14737632;
   private int field_73824_r = 7368816;
   private boolean field_73823_s = true;


   public GuiTextField(FontRenderer p_i3050_1_, int p_i3050_2_, int p_i3050_3_, int p_i3050_4_, int p_i3050_5_) {
      this.field_73815_a = p_i3050_1_;
      this.field_73813_b = p_i3050_2_;
      this.field_73814_c = p_i3050_3_;
      this.field_73811_d = p_i3050_4_;
      this.field_73812_e = p_i3050_5_;
   }

   public void func_73780_a() {
      ++this.field_73822_h;
   }

   public void func_73782_a(String p_73782_1_) {
      if(p_73782_1_.length() > this.field_73810_g) {
         this.field_73809_f = p_73782_1_.substring(0, this.field_73810_g);
      } else {
         this.field_73809_f = p_73782_1_;
      }

      this.func_73803_e();
   }

   public String func_73781_b() {
      return this.field_73809_f;
   }

   public String func_73807_c() {
      int var1 = this.field_73817_o < this.field_73826_p?this.field_73817_o:this.field_73826_p;
      int var2 = this.field_73817_o < this.field_73826_p?this.field_73826_p:this.field_73817_o;
      return this.field_73809_f.substring(var1, var2);
   }

   public void func_73792_b(String p_73792_1_) {
      String var2 = "";
      String var3 = ChatAllowedCharacters.func_71565_a(p_73792_1_);
      int var4 = this.field_73817_o < this.field_73826_p?this.field_73817_o:this.field_73826_p;
      int var5 = this.field_73817_o < this.field_73826_p?this.field_73826_p:this.field_73817_o;
      int var6 = this.field_73810_g - this.field_73809_f.length() - (var4 - this.field_73826_p);
      boolean var7 = false;
      if(this.field_73809_f.length() > 0) {
         var2 = var2 + this.field_73809_f.substring(0, var4);
      }

      int var8;
      if(var6 < var3.length()) {
         var2 = var2 + var3.substring(0, var6);
         var8 = var6;
      } else {
         var2 = var2 + var3;
         var8 = var3.length();
      }

      if(this.field_73809_f.length() > 0 && var5 < this.field_73809_f.length()) {
         var2 = var2 + this.field_73809_f.substring(var5);
      }

      this.field_73809_f = var2;
      this.func_73784_d(var4 - this.field_73826_p + var8);
   }

   public void func_73779_a(int p_73779_1_) {
      if(this.field_73809_f.length() != 0) {
         if(this.field_73826_p != this.field_73817_o) {
            this.func_73792_b("");
         } else {
            this.func_73777_b(this.func_73788_c(p_73779_1_) - this.field_73817_o);
         }
      }
   }

   public void func_73777_b(int p_73777_1_) {
      if(this.field_73809_f.length() != 0) {
         if(this.field_73826_p != this.field_73817_o) {
            this.func_73792_b("");
         } else {
            boolean var2 = p_73777_1_ < 0;
            int var3 = var2?this.field_73817_o + p_73777_1_:this.field_73817_o;
            int var4 = var2?this.field_73817_o:this.field_73817_o + p_73777_1_;
            String var5 = "";
            if(var3 >= 0) {
               var5 = this.field_73809_f.substring(0, var3);
            }

            if(var4 < this.field_73809_f.length()) {
               var5 = var5 + this.field_73809_f.substring(var4);
            }

            this.field_73809_f = var5;
            if(var2) {
               this.func_73784_d(p_73777_1_);
            }

         }
      }
   }

   public int func_73788_c(int p_73788_1_) {
      return this.func_73785_a(p_73788_1_, this.func_73799_h());
   }

   public int func_73785_a(int p_73785_1_, int p_73785_2_) {
      return this.func_73798_a(p_73785_1_, this.func_73799_h(), true);
   }

   public int func_73798_a(int p_73798_1_, int p_73798_2_, boolean p_73798_3_) {
      int var4 = p_73798_2_;
      boolean var5 = p_73798_1_ < 0;
      int var6 = Math.abs(p_73798_1_);

      for(int var7 = 0; var7 < var6; ++var7) {
         if(var5) {
            while(p_73798_3_ && var4 > 0 && this.field_73809_f.charAt(var4 - 1) == 32) {
               --var4;
            }

            while(var4 > 0 && this.field_73809_f.charAt(var4 - 1) != 32) {
               --var4;
            }
         } else {
            int var8 = this.field_73809_f.length();
            var4 = this.field_73809_f.indexOf(32, var4);
            if(var4 == -1) {
               var4 = var8;
            } else {
               while(p_73798_3_ && var4 < var8 && this.field_73809_f.charAt(var4) == 32) {
                  ++var4;
               }
            }
         }
      }

      return var4;
   }

   public void func_73784_d(int p_73784_1_) {
      this.func_73791_e(this.field_73826_p + p_73784_1_);
   }

   public void func_73791_e(int p_73791_1_) {
      this.field_73817_o = p_73791_1_;
      int var2 = this.field_73809_f.length();
      if(this.field_73817_o < 0) {
         this.field_73817_o = 0;
      }

      if(this.field_73817_o > var2) {
         this.field_73817_o = var2;
      }

      this.func_73800_i(this.field_73817_o);
   }

   public void func_73797_d() {
      this.func_73791_e(0);
   }

   public void func_73803_e() {
      this.func_73791_e(this.field_73809_f.length());
   }

   public boolean func_73802_a(char p_73802_1_, int p_73802_2_) {
      if(this.field_73819_m && this.field_73818_l) {
         switch(p_73802_1_) {
         case 1:
            this.func_73803_e();
            this.func_73800_i(0);
            return true;
         case 3:
            GuiScreen.func_73865_d(this.func_73807_c());
            return true;
         case 22:
            this.func_73792_b(GuiScreen.func_73870_l());
            return true;
         case 24:
            GuiScreen.func_73865_d(this.func_73807_c());
            this.func_73792_b("");
            return true;
         default:
            switch(p_73802_2_) {
            case 14:
               if(GuiScreen.func_73861_o()) {
                  this.func_73779_a(-1);
               } else {
                  this.func_73777_b(-1);
               }

               return true;
            case 199:
               if(GuiScreen.func_73877_p()) {
                  this.func_73800_i(0);
               } else {
                  this.func_73797_d();
               }

               return true;
            case 203:
               if(GuiScreen.func_73877_p()) {
                  if(GuiScreen.func_73861_o()) {
                     this.func_73800_i(this.func_73785_a(-1, this.func_73787_n()));
                  } else {
                     this.func_73800_i(this.func_73787_n() - 1);
                  }
               } else if(GuiScreen.func_73861_o()) {
                  this.func_73791_e(this.func_73788_c(-1));
               } else {
                  this.func_73784_d(-1);
               }

               return true;
            case 205:
               if(GuiScreen.func_73877_p()) {
                  if(GuiScreen.func_73861_o()) {
                     this.func_73800_i(this.func_73785_a(1, this.func_73787_n()));
                  } else {
                     this.func_73800_i(this.func_73787_n() + 1);
                  }
               } else if(GuiScreen.func_73861_o()) {
                  this.func_73791_e(this.func_73788_c(1));
               } else {
                  this.func_73784_d(1);
               }

               return true;
            case 207:
               if(GuiScreen.func_73877_p()) {
                  this.func_73800_i(this.field_73809_f.length());
               } else {
                  this.func_73803_e();
               }

               return true;
            case 211:
               if(GuiScreen.func_73861_o()) {
                  this.func_73779_a(1);
               } else {
                  this.func_73777_b(1);
               }

               return true;
            default:
               if(ChatAllowedCharacters.func_71566_a(p_73802_1_)) {
                  this.func_73792_b(Character.toString(p_73802_1_));
                  return true;
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   public void func_73793_a(int p_73793_1_, int p_73793_2_, int p_73793_3_) {
      boolean var4 = p_73793_1_ >= this.field_73813_b && p_73793_1_ < this.field_73813_b + this.field_73811_d && p_73793_2_ >= this.field_73814_c && p_73793_2_ < this.field_73814_c + this.field_73812_e;
      if(this.field_73821_k) {
         this.func_73796_b(this.field_73819_m && var4);
      }

      if(this.field_73818_l && p_73793_3_ == 0) {
         int var5 = p_73793_1_ - this.field_73813_b;
         if(this.field_73820_j) {
            var5 -= 4;
         }

         String var6 = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
         this.func_73791_e(this.field_73815_a.func_78269_a(var6, var5).length() + this.field_73816_n);
      }

   }

   public void func_73795_f() {
      if(this.func_73778_q()) {
         if(this.func_73783_i()) {
            func_73734_a(this.field_73813_b - 1, this.field_73814_c - 1, this.field_73813_b + this.field_73811_d + 1, this.field_73814_c + this.field_73812_e + 1, -6250336);
            func_73734_a(this.field_73813_b, this.field_73814_c, this.field_73813_b + this.field_73811_d, this.field_73814_c + this.field_73812_e, -16777216);
         }

         int var1 = this.field_73819_m?this.field_73825_q:this.field_73824_r;
         int var2 = this.field_73817_o - this.field_73816_n;
         int var3 = this.field_73826_p - this.field_73816_n;
         String var4 = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), this.func_73801_o());
         boolean var5 = var2 >= 0 && var2 <= var4.length();
         boolean var6 = this.field_73818_l && this.field_73822_h / 6 % 2 == 0 && var5;
         int var7 = this.field_73820_j?this.field_73813_b + 4:this.field_73813_b;
         int var8 = this.field_73820_j?this.field_73814_c + (this.field_73812_e - 8) / 2:this.field_73814_c;
         int var9 = var7;
         if(var3 > var4.length()) {
            var3 = var4.length();
         }

         if(var4.length() > 0) {
            String var10 = var5?var4.substring(0, var2):var4;
            var9 = this.field_73815_a.func_78261_a(var10, var7, var8, var1);
         }

         boolean var13 = this.field_73817_o < this.field_73809_f.length() || this.field_73809_f.length() >= this.func_73808_g();
         int var11 = var9;
         if(!var5) {
            var11 = var2 > 0?var7 + this.field_73811_d:var7;
         } else if(var13) {
            var11 = var9 - 1;
            --var9;
         }

         if(var4.length() > 0 && var5 && var2 < var4.length()) {
            this.field_73815_a.func_78261_a(var4.substring(var2), var9, var8, var1);
         }

         if(var6) {
            if(var13) {
               Gui.func_73734_a(var11, var8 - 1, var11 + 1, var8 + 1 + this.field_73815_a.field_78288_b, -3092272);
            } else {
               this.field_73815_a.func_78261_a("_", var11, var8, var1);
            }
         }

         if(var3 != var2) {
            int var12 = var7 + this.field_73815_a.func_78256_a(var4.substring(0, var3));
            this.func_73789_c(var11, var8 - 1, var12 - 1, var8 + 1 + this.field_73815_a.field_78288_b);
         }

      }
   }

   private void func_73789_c(int p_73789_1_, int p_73789_2_, int p_73789_3_, int p_73789_4_) {
      int var5;
      if(p_73789_1_ < p_73789_3_) {
         var5 = p_73789_1_;
         p_73789_1_ = p_73789_3_;
         p_73789_3_ = var5;
      }

      if(p_73789_2_ < p_73789_4_) {
         var5 = p_73789_2_;
         p_73789_2_ = p_73789_4_;
         p_73789_4_ = var5;
      }

      Tessellator var6 = Tessellator.field_78398_a;
      GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
      GL11.glDisable(3553);
      GL11.glEnable(3058);
      GL11.glLogicOp(5387);
      var6.func_78382_b();
      var6.func_78377_a((double)p_73789_1_, (double)p_73789_4_, 0.0D);
      var6.func_78377_a((double)p_73789_3_, (double)p_73789_4_, 0.0D);
      var6.func_78377_a((double)p_73789_3_, (double)p_73789_2_, 0.0D);
      var6.func_78377_a((double)p_73789_1_, (double)p_73789_2_, 0.0D);
      var6.func_78381_a();
      GL11.glDisable(3058);
      GL11.glEnable(3553);
   }

   public void func_73804_f(int p_73804_1_) {
      this.field_73810_g = p_73804_1_;
      if(this.field_73809_f.length() > p_73804_1_) {
         this.field_73809_f = this.field_73809_f.substring(0, p_73804_1_);
      }

   }

   public int func_73808_g() {
      return this.field_73810_g;
   }

   public int func_73799_h() {
      return this.field_73817_o;
   }

   public boolean func_73783_i() {
      return this.field_73820_j;
   }

   public void func_73786_a(boolean p_73786_1_) {
      this.field_73820_j = p_73786_1_;
   }

   public void func_73794_g(int p_73794_1_) {
      this.field_73825_q = p_73794_1_;
   }

   public void func_82266_h(int p_82266_1_) {
      this.field_73824_r = p_82266_1_;
   }

   public void func_73796_b(boolean p_73796_1_) {
      if(p_73796_1_ && !this.field_73818_l) {
         this.field_73822_h = 0;
      }

      this.field_73818_l = p_73796_1_;
   }

   public boolean func_73806_l() {
      return this.field_73818_l;
   }

   public void func_82265_c(boolean p_82265_1_) {
      this.field_73819_m = p_82265_1_;
   }

   public int func_73787_n() {
      return this.field_73826_p;
   }

   public int func_73801_o() {
      return this.func_73783_i()?this.field_73811_d - 8:this.field_73811_d;
   }

   public void func_73800_i(int p_73800_1_) {
      int var2 = this.field_73809_f.length();
      if(p_73800_1_ > var2) {
         p_73800_1_ = var2;
      }

      if(p_73800_1_ < 0) {
         p_73800_1_ = 0;
      }

      this.field_73826_p = p_73800_1_;
      if(this.field_73815_a != null) {
         if(this.field_73816_n > var2) {
            this.field_73816_n = var2;
         }

         int var3 = this.func_73801_o();
         String var4 = this.field_73815_a.func_78269_a(this.field_73809_f.substring(this.field_73816_n), var3);
         int var5 = var4.length() + this.field_73816_n;
         if(p_73800_1_ == this.field_73816_n) {
            this.field_73816_n -= this.field_73815_a.func_78262_a(this.field_73809_f, var3, true).length();
         }

         if(p_73800_1_ > var5) {
            this.field_73816_n += p_73800_1_ - var5;
         } else if(p_73800_1_ <= this.field_73816_n) {
            this.field_73816_n -= this.field_73816_n - p_73800_1_;
         }

         if(this.field_73816_n < 0) {
            this.field_73816_n = 0;
         }

         if(this.field_73816_n > var2) {
            this.field_73816_n = var2;
         }
      }

   }

   public void func_73805_d(boolean p_73805_1_) {
      this.field_73821_k = p_73805_1_;
   }

   public boolean func_73778_q() {
      return this.field_73823_s;
   }

   public void func_73790_e(boolean p_73790_1_) {
      this.field_73823_s = p_73790_1_;
   }
}
