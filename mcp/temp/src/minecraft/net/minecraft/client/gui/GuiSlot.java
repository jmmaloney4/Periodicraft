package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class GuiSlot {

   private final Minecraft field_77233_a;
   private int field_77228_g;
   private int field_77240_h;
   protected int field_77231_b;
   protected int field_77232_c;
   private int field_77241_i;
   private int field_77238_j;
   protected final int field_77229_d;
   private int field_77239_k;
   private int field_77236_l;
   protected int field_77230_e;
   protected int field_77227_f;
   private float field_77237_m = -2.0F;
   private float field_77234_n;
   private float field_77235_o;
   private int field_77246_p = -1;
   private long field_77245_q = 0L;
   private boolean field_77244_r = true;
   private boolean field_77243_s;
   private int field_77242_t;


   public GuiSlot(Minecraft p_i3060_1_, int p_i3060_2_, int p_i3060_3_, int p_i3060_4_, int p_i3060_5_, int p_i3060_6_) {
      this.field_77233_a = p_i3060_1_;
      this.field_77228_g = p_i3060_2_;
      this.field_77240_h = p_i3060_3_;
      this.field_77231_b = p_i3060_4_;
      this.field_77232_c = p_i3060_5_;
      this.field_77229_d = p_i3060_6_;
      this.field_77238_j = 0;
      this.field_77241_i = p_i3060_2_;
   }

   public void func_77207_a(int p_77207_1_, int p_77207_2_, int p_77207_3_, int p_77207_4_) {
      this.field_77228_g = p_77207_1_;
      this.field_77240_h = p_77207_2_;
      this.field_77231_b = p_77207_3_;
      this.field_77232_c = p_77207_4_;
      this.field_77238_j = 0;
      this.field_77241_i = p_77207_1_;
   }

   public void func_77216_a(boolean p_77216_1_) {
      this.field_77244_r = p_77216_1_;
   }

   protected void func_77223_a(boolean p_77223_1_, int p_77223_2_) {
      this.field_77243_s = p_77223_1_;
      this.field_77242_t = p_77223_2_;
      if(!p_77223_1_) {
         this.field_77242_t = 0;
      }

   }

   protected abstract int func_77217_a();

   protected abstract void func_77213_a(int var1, boolean var2);

   protected abstract boolean func_77218_a(int var1);

   protected int func_77212_b() {
      return this.func_77217_a() * this.field_77229_d + this.field_77242_t;
   }

   protected abstract void func_77221_c();

   protected abstract void func_77214_a(int var1, int var2, int var3, int var4, Tessellator var5);

   protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_) {}

   protected void func_77224_a(int p_77224_1_, int p_77224_2_) {}

   protected void func_77215_b(int p_77215_1_, int p_77215_2_) {}

   public int func_77210_c(int p_77210_1_, int p_77210_2_) {
      int var3 = this.field_77228_g / 2 - 110;
      int var4 = this.field_77228_g / 2 + 110;
      int var5 = p_77210_2_ - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
      int var6 = var5 / this.field_77229_d;
      return p_77210_1_ >= var3 && p_77210_1_ <= var4 && var6 >= 0 && var5 >= 0 && var6 < this.func_77217_a()?var6:-1;
   }

   public void func_77220_a(List p_77220_1_, int p_77220_2_, int p_77220_3_) {
      this.field_77239_k = p_77220_2_;
      this.field_77236_l = p_77220_3_;
   }

   private void func_77226_h() {
      int var1 = this.func_77209_d();
      if(var1 < 0) {
         var1 /= 2;
      }

      if(this.field_77235_o < 0.0F) {
         this.field_77235_o = 0.0F;
      }

      if(this.field_77235_o > (float)var1) {
         this.field_77235_o = (float)var1;
      }

   }

   public int func_77209_d() {
      return this.func_77212_b() - (this.field_77232_c - this.field_77231_b - 4);
   }

   public void func_77208_b(int p_77208_1_) {
      this.field_77235_o += (float)p_77208_1_;
      this.func_77226_h();
      this.field_77237_m = -2.0F;
   }

   public void func_77219_a(GuiButton p_77219_1_) {
      if(p_77219_1_.field_73742_g) {
         if(p_77219_1_.field_73741_f == this.field_77239_k) {
            this.field_77235_o -= (float)(this.field_77229_d * 2 / 3);
            this.field_77237_m = -2.0F;
            this.func_77226_h();
         } else if(p_77219_1_.field_73741_f == this.field_77236_l) {
            this.field_77235_o += (float)(this.field_77229_d * 2 / 3);
            this.field_77237_m = -2.0F;
            this.func_77226_h();
         }

      }
   }

   public void func_77211_a(int p_77211_1_, int p_77211_2_, float p_77211_3_) {
      this.field_77230_e = p_77211_1_;
      this.field_77227_f = p_77211_2_;
      this.func_77221_c();
      int var4 = this.func_77217_a();
      int var5 = this.func_77225_g();
      int var6 = var5 + 6;
      int var9;
      int var10;
      int var11;
      int var13;
      int var19;
      if(Mouse.isButtonDown(0)) {
         if(this.field_77237_m == -1.0F) {
            boolean var7 = true;
            if(p_77211_2_ >= this.field_77231_b && p_77211_2_ <= this.field_77232_c) {
               int var8 = this.field_77228_g / 2 - 110;
               var9 = this.field_77228_g / 2 + 110;
               var10 = p_77211_2_ - this.field_77231_b - this.field_77242_t + (int)this.field_77235_o - 4;
               var11 = var10 / this.field_77229_d;
               if(p_77211_1_ >= var8 && p_77211_1_ <= var9 && var11 >= 0 && var10 >= 0 && var11 < var4) {
                  boolean var12 = var11 == this.field_77246_p && Minecraft.func_71386_F() - this.field_77245_q < 250L;
                  this.func_77213_a(var11, var12);
                  this.field_77246_p = var11;
                  this.field_77245_q = Minecraft.func_71386_F();
               } else if(p_77211_1_ >= var8 && p_77211_1_ <= var9 && var10 < 0) {
                  this.func_77224_a(p_77211_1_ - var8, p_77211_2_ - this.field_77231_b + (int)this.field_77235_o - 4);
                  var7 = false;
               }

               if(p_77211_1_ >= var5 && p_77211_1_ <= var6) {
                  this.field_77234_n = -1.0F;
                  var19 = this.func_77209_d();
                  if(var19 < 1) {
                     var19 = 1;
                  }

                  var13 = (int)((float)((this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b)) / (float)this.func_77212_b());
                  if(var13 < 32) {
                     var13 = 32;
                  }

                  if(var13 > this.field_77232_c - this.field_77231_b - 8) {
                     var13 = this.field_77232_c - this.field_77231_b - 8;
                  }

                  this.field_77234_n /= (float)(this.field_77232_c - this.field_77231_b - var13) / (float)var19;
               } else {
                  this.field_77234_n = 1.0F;
               }

               if(var7) {
                  this.field_77237_m = (float)p_77211_2_;
               } else {
                  this.field_77237_m = -2.0F;
               }
            } else {
               this.field_77237_m = -2.0F;
            }
         } else if(this.field_77237_m >= 0.0F) {
            this.field_77235_o -= ((float)p_77211_2_ - this.field_77237_m) * this.field_77234_n;
            this.field_77237_m = (float)p_77211_2_;
         }
      } else {
         while(!this.field_77233_a.field_71474_y.field_85185_A && Mouse.next()) {
            int var16 = Mouse.getEventDWheel();
            if(var16 != 0) {
               if(var16 > 0) {
                  var16 = -1;
               } else if(var16 < 0) {
                  var16 = 1;
               }

               this.field_77235_o += (float)(var16 * this.field_77229_d / 2);
            }
         }

         this.field_77237_m = -1.0F;
      }

      this.func_77226_h();
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      Tessellator var18 = Tessellator.field_78398_a;
      this.field_77233_a.field_71446_o.func_98187_b("/gui/background.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var17 = 32.0F;
      var18.func_78382_b();
      var18.func_78378_d(2105376);
      var18.func_78374_a((double)this.field_77238_j, (double)this.field_77232_c, 0.0D, (double)((float)this.field_77238_j / var17), (double)((float)(this.field_77232_c + (int)this.field_77235_o) / var17));
      var18.func_78374_a((double)this.field_77241_i, (double)this.field_77232_c, 0.0D, (double)((float)this.field_77241_i / var17), (double)((float)(this.field_77232_c + (int)this.field_77235_o) / var17));
      var18.func_78374_a((double)this.field_77241_i, (double)this.field_77231_b, 0.0D, (double)((float)this.field_77241_i / var17), (double)((float)(this.field_77231_b + (int)this.field_77235_o) / var17));
      var18.func_78374_a((double)this.field_77238_j, (double)this.field_77231_b, 0.0D, (double)((float)this.field_77238_j / var17), (double)((float)(this.field_77231_b + (int)this.field_77235_o) / var17));
      var18.func_78381_a();
      var9 = this.field_77228_g / 2 - 92 - 16;
      var10 = this.field_77231_b + 4 - (int)this.field_77235_o;
      if(this.field_77243_s) {
         this.func_77222_a(var9, var10, var18);
      }

      int var14;
      for(var11 = 0; var11 < var4; ++var11) {
         var19 = var10 + var11 * this.field_77229_d + this.field_77242_t;
         var13 = this.field_77229_d - 4;
         if(var19 <= this.field_77232_c && var19 + var13 >= this.field_77231_b) {
            if(this.field_77244_r && this.func_77218_a(var11)) {
               var14 = this.field_77228_g / 2 - 110;
               int var15 = this.field_77228_g / 2 + 110;
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glDisable(3553);
               var18.func_78382_b();
               var18.func_78378_d(8421504);
               var18.func_78374_a((double)var14, (double)(var19 + var13 + 2), 0.0D, 0.0D, 1.0D);
               var18.func_78374_a((double)var15, (double)(var19 + var13 + 2), 0.0D, 1.0D, 1.0D);
               var18.func_78374_a((double)var15, (double)(var19 - 2), 0.0D, 1.0D, 0.0D);
               var18.func_78374_a((double)var14, (double)(var19 - 2), 0.0D, 0.0D, 0.0D);
               var18.func_78378_d(0);
               var18.func_78374_a((double)(var14 + 1), (double)(var19 + var13 + 1), 0.0D, 0.0D, 1.0D);
               var18.func_78374_a((double)(var15 - 1), (double)(var19 + var13 + 1), 0.0D, 1.0D, 1.0D);
               var18.func_78374_a((double)(var15 - 1), (double)(var19 - 1), 0.0D, 1.0D, 0.0D);
               var18.func_78374_a((double)(var14 + 1), (double)(var19 - 1), 0.0D, 0.0D, 0.0D);
               var18.func_78381_a();
               GL11.glEnable(3553);
            }

            this.func_77214_a(var11, var9, var19, var13, var18);
         }
      }

      GL11.glDisable(2929);
      byte var20 = 4;
      this.func_77206_b(0, this.field_77231_b, 255, 255);
      this.func_77206_b(this.field_77232_c, this.field_77240_h, 255, 255);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      var18.func_78382_b();
      var18.func_78384_a(0, 0);
      var18.func_78374_a((double)this.field_77238_j, (double)(this.field_77231_b + var20), 0.0D, 0.0D, 1.0D);
      var18.func_78374_a((double)this.field_77241_i, (double)(this.field_77231_b + var20), 0.0D, 1.0D, 1.0D);
      var18.func_78384_a(0, 255);
      var18.func_78374_a((double)this.field_77241_i, (double)this.field_77231_b, 0.0D, 1.0D, 0.0D);
      var18.func_78374_a((double)this.field_77238_j, (double)this.field_77231_b, 0.0D, 0.0D, 0.0D);
      var18.func_78381_a();
      var18.func_78382_b();
      var18.func_78384_a(0, 255);
      var18.func_78374_a((double)this.field_77238_j, (double)this.field_77232_c, 0.0D, 0.0D, 1.0D);
      var18.func_78374_a((double)this.field_77241_i, (double)this.field_77232_c, 0.0D, 1.0D, 1.0D);
      var18.func_78384_a(0, 0);
      var18.func_78374_a((double)this.field_77241_i, (double)(this.field_77232_c - var20), 0.0D, 1.0D, 0.0D);
      var18.func_78374_a((double)this.field_77238_j, (double)(this.field_77232_c - var20), 0.0D, 0.0D, 0.0D);
      var18.func_78381_a();
      var19 = this.func_77209_d();
      if(var19 > 0) {
         var13 = (this.field_77232_c - this.field_77231_b) * (this.field_77232_c - this.field_77231_b) / this.func_77212_b();
         if(var13 < 32) {
            var13 = 32;
         }

         if(var13 > this.field_77232_c - this.field_77231_b - 8) {
            var13 = this.field_77232_c - this.field_77231_b - 8;
         }

         var14 = (int)this.field_77235_o * (this.field_77232_c - this.field_77231_b - var13) / var19 + this.field_77231_b;
         if(var14 < this.field_77231_b) {
            var14 = this.field_77231_b;
         }

         var18.func_78382_b();
         var18.func_78384_a(0, 255);
         var18.func_78374_a((double)var5, (double)this.field_77232_c, 0.0D, 0.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)this.field_77232_c, 0.0D, 1.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)this.field_77231_b, 0.0D, 1.0D, 0.0D);
         var18.func_78374_a((double)var5, (double)this.field_77231_b, 0.0D, 0.0D, 0.0D);
         var18.func_78381_a();
         var18.func_78382_b();
         var18.func_78384_a(8421504, 255);
         var18.func_78374_a((double)var5, (double)(var14 + var13), 0.0D, 0.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)(var14 + var13), 0.0D, 1.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)var14, 0.0D, 1.0D, 0.0D);
         var18.func_78374_a((double)var5, (double)var14, 0.0D, 0.0D, 0.0D);
         var18.func_78381_a();
         var18.func_78382_b();
         var18.func_78384_a(12632256, 255);
         var18.func_78374_a((double)var5, (double)(var14 + var13 - 1), 0.0D, 0.0D, 1.0D);
         var18.func_78374_a((double)(var6 - 1), (double)(var14 + var13 - 1), 0.0D, 1.0D, 1.0D);
         var18.func_78374_a((double)(var6 - 1), (double)var14, 0.0D, 1.0D, 0.0D);
         var18.func_78374_a((double)var5, (double)var14, 0.0D, 0.0D, 0.0D);
         var18.func_78381_a();
      }

      this.func_77215_b(p_77211_1_, p_77211_2_);
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glEnable(3008);
      GL11.glDisable(3042);
   }

   protected int func_77225_g() {
      return this.field_77228_g / 2 + 124;
   }

   private void func_77206_b(int p_77206_1_, int p_77206_2_, int p_77206_3_, int p_77206_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      this.field_77233_a.field_71446_o.func_98187_b("/gui/background.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var6 = 32.0F;
      var5.func_78382_b();
      var5.func_78384_a(4210752, p_77206_4_);
      var5.func_78374_a(0.0D, (double)p_77206_2_, 0.0D, 0.0D, (double)((float)p_77206_2_ / var6));
      var5.func_78374_a((double)this.field_77228_g, (double)p_77206_2_, 0.0D, (double)((float)this.field_77228_g / var6), (double)((float)p_77206_2_ / var6));
      var5.func_78384_a(4210752, p_77206_3_);
      var5.func_78374_a((double)this.field_77228_g, (double)p_77206_1_, 0.0D, (double)((float)this.field_77228_g / var6), (double)((float)p_77206_1_ / var6));
      var5.func_78374_a(0.0D, (double)p_77206_1_, 0.0D, 0.0D, (double)((float)p_77206_1_ / var6));
      var5.func_78381_a();
   }
}
