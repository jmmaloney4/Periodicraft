package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatClickData;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringTranslate;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiNewChat extends Gui {

   private final Minecraft field_73772_a;
   private final List field_73770_b = new ArrayList();
   private final List field_73771_c = new ArrayList();
   private final List field_96134_d = new ArrayList();
   private int field_73768_d = 0;
   private boolean field_73769_e = false;


   public GuiNewChat(Minecraft p_i3043_1_) {
      this.field_73772_a = p_i3043_1_;
   }

   public void func_73762_a(int p_73762_1_) {
      if(this.field_73772_a.field_71474_y.field_74343_n != 2) {
         int var2 = this.func_96127_i();
         boolean var3 = false;
         int var4 = 0;
         int var5 = this.field_96134_d.size();
         float var6 = this.field_73772_a.field_71474_y.field_74357_r * 0.9F + 0.1F;
         if(var5 > 0) {
            if(this.func_73760_d()) {
               var3 = true;
            }

            float var7 = this.func_96131_h();
            int var8 = MathHelper.func_76123_f((float)this.func_96126_f() / var7);
            GL11.glPushMatrix();
            GL11.glTranslatef(2.0F, 20.0F, 0.0F);
            GL11.glScalef(var7, var7, 1.0F);

            int var9;
            int var11;
            int var14;
            for(var9 = 0; var9 + this.field_73768_d < this.field_96134_d.size() && var9 < var2; ++var9) {
               ChatLine var10 = (ChatLine)this.field_96134_d.get(var9 + this.field_73768_d);
               if(var10 != null) {
                  var11 = p_73762_1_ - var10.func_74540_b();
                  if(var11 < 200 || var3) {
                     double var12 = (double)var11 / 200.0D;
                     var12 = 1.0D - var12;
                     var12 *= 10.0D;
                     if(var12 < 0.0D) {
                        var12 = 0.0D;
                     }

                     if(var12 > 1.0D) {
                        var12 = 1.0D;
                     }

                     var12 *= var12;
                     var14 = (int)(255.0D * var12);
                     if(var3) {
                        var14 = 255;
                     }

                     var14 = (int)((float)var14 * var6);
                     ++var4;
                     if(var14 > 3) {
                        byte var15 = 0;
                        int var16 = -var9 * 9;
                        func_73734_a(var15, var16 - 9, var15 + var8 + 4, var16, var14 / 2 << 24);
                        GL11.glEnable(3042);
                        String var17 = var10.func_74538_a();
                        if(!this.field_73772_a.field_71474_y.field_74344_o) {
                           var17 = StringUtils.func_76338_a(var17);
                        }

                        this.field_73772_a.field_71466_p.func_78261_a(var17, var15, var16 - 8, 16777215 + (var14 << 24));
                     }
                  }
               }
            }

            if(var3) {
               var9 = this.field_73772_a.field_71466_p.field_78288_b;
               GL11.glTranslatef(-3.0F, 0.0F, 0.0F);
               int var18 = var5 * var9 + var5;
               var11 = var4 * var9 + var4;
               int var20 = this.field_73768_d * var11 / var5;
               int var13 = var11 * var11 / var18;
               if(var18 != var11) {
                  var14 = var20 > 0?170:96;
                  int var19 = this.field_73769_e?13382451:3355562;
                  func_73734_a(0, -var20, 2, -var20 - var13, var19 + (var14 << 24));
                  func_73734_a(2, -var20, 1, -var20 - var13, 13421772 + (var14 << 24));
               }
            }

            GL11.glPopMatrix();
         }
      }
   }

   public void func_73761_a() {
      this.field_96134_d.clear();
      this.field_73771_c.clear();
      this.field_73770_b.clear();
   }

   public void func_73765_a(String p_73765_1_) {
      this.func_73763_a(p_73765_1_, 0);
   }

   public void func_73763_a(String p_73763_1_, int p_73763_2_) {
      this.func_96129_a(p_73763_1_, p_73763_2_, this.field_73772_a.field_71456_v.func_73834_c(), false);
      this.field_73772_a.func_98033_al().func_98233_a("[CHAT] " + p_73763_1_);
   }

   private void func_96129_a(String p_96129_1_, int p_96129_2_, int p_96129_3_, boolean p_96129_4_) {
      boolean var5 = this.func_73760_d();
      boolean var6 = true;
      if(p_96129_2_ != 0) {
         this.func_73759_c(p_96129_2_);
      }

      Iterator var7 = this.field_73772_a.field_71466_p.func_78271_c(p_96129_1_, MathHelper.func_76141_d((float)this.func_96126_f() / this.func_96131_h())).iterator();

      while(var7.hasNext()) {
         String var8 = (String)var7.next();
         if(var5 && this.field_73768_d > 0) {
            this.field_73769_e = true;
            this.func_73758_b(1);
         }

         if(!var6) {
            var8 = " " + var8;
         }

         var6 = false;
         this.field_96134_d.add(0, new ChatLine(p_96129_3_, var8, p_96129_2_));
      }

      while(this.field_96134_d.size() > 100) {
         this.field_96134_d.remove(this.field_96134_d.size() - 1);
      }

      if(!p_96129_4_) {
         this.field_73771_c.add(0, new ChatLine(p_96129_3_, p_96129_1_.trim(), p_96129_2_));

         while(this.field_73771_c.size() > 100) {
            this.field_73771_c.remove(this.field_73771_c.size() - 1);
         }
      }

   }

   public void func_96132_b() {
      this.field_96134_d.clear();
      this.func_73764_c();

      for(int var1 = this.field_73771_c.size() - 1; var1 >= 0; --var1) {
         ChatLine var2 = (ChatLine)this.field_73771_c.get(var1);
         this.func_96129_a(var2.func_74538_a(), var2.func_74539_c(), var2.func_74540_b(), true);
      }

   }

   public List func_73756_b() {
      return this.field_73770_b;
   }

   public void func_73767_b(String p_73767_1_) {
      if(this.field_73770_b.isEmpty() || !((String)this.field_73770_b.get(this.field_73770_b.size() - 1)).equals(p_73767_1_)) {
         this.field_73770_b.add(p_73767_1_);
      }

   }

   public void func_73764_c() {
      this.field_73768_d = 0;
      this.field_73769_e = false;
   }

   public void func_73758_b(int p_73758_1_) {
      this.field_73768_d += p_73758_1_;
      int var2 = this.field_96134_d.size();
      if(this.field_73768_d > var2 - this.func_96127_i()) {
         this.field_73768_d = var2 - this.func_96127_i();
      }

      if(this.field_73768_d <= 0) {
         this.field_73768_d = 0;
         this.field_73769_e = false;
      }

   }

   public ChatClickData func_73766_a(int p_73766_1_, int p_73766_2_) {
      if(!this.func_73760_d()) {
         return null;
      } else {
         ScaledResolution var3 = new ScaledResolution(this.field_73772_a.field_71474_y, this.field_73772_a.field_71443_c, this.field_73772_a.field_71440_d);
         int var4 = var3.func_78325_e();
         float var5 = this.func_96131_h();
         int var6 = p_73766_1_ / var4 - 3;
         int var7 = p_73766_2_ / var4 - 25;
         var6 = MathHelper.func_76141_d((float)var6 / var5);
         var7 = MathHelper.func_76141_d((float)var7 / var5);
         if(var6 >= 0 && var7 >= 0) {
            int var8 = Math.min(this.func_96127_i(), this.field_96134_d.size());
            if(var6 <= MathHelper.func_76141_d((float)this.func_96126_f() / this.func_96131_h()) && var7 < this.field_73772_a.field_71466_p.field_78288_b * var8 + var8) {
               int var9 = var7 / (this.field_73772_a.field_71466_p.field_78288_b + 1) + this.field_73768_d;
               return new ChatClickData(this.field_73772_a.field_71466_p, (ChatLine)this.field_96134_d.get(var9), var6, var7 - (var9 - this.field_73768_d) * this.field_73772_a.field_71466_p.field_78288_b + var9);
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   public void func_73757_a(String p_73757_1_, Object ... p_73757_2_) {
      this.func_73765_a(StringTranslate.func_74808_a().func_74803_a(p_73757_1_, p_73757_2_));
   }

   public boolean func_73760_d() {
      return this.field_73772_a.field_71462_r instanceof GuiChat;
   }

   public void func_73759_c(int p_73759_1_) {
      Iterator var2 = this.field_96134_d.iterator();

      ChatLine var3;
      do {
         if(!var2.hasNext()) {
            var2 = this.field_73771_c.iterator();

            do {
               if(!var2.hasNext()) {
                  return;
               }

               var3 = (ChatLine)var2.next();
            } while(var3.func_74539_c() != p_73759_1_);

            var2.remove();
            return;
         }

         var3 = (ChatLine)var2.next();
      } while(var3.func_74539_c() != p_73759_1_);

      var2.remove();
   }

   public int func_96126_f() {
      return func_96128_a(this.field_73772_a.field_71474_y.field_96692_F);
   }

   public int func_96133_g() {
      return func_96130_b(this.func_73760_d()?this.field_73772_a.field_71474_y.field_96694_H:this.field_73772_a.field_71474_y.field_96693_G);
   }

   public float func_96131_h() {
      return this.field_73772_a.field_71474_y.field_96691_E;
   }

   public static final int func_96128_a(float p_96128_0_) {
      short var1 = 320;
      byte var2 = 40;
      return MathHelper.func_76141_d(p_96128_0_ * (float)(var1 - var2) + (float)var2);
   }

   public static final int func_96130_b(float p_96130_0_) {
      short var1 = 180;
      byte var2 = 20;
      return MathHelper.func_76141_d(p_96130_0_ * (float)(var1 - var2) + (float)var2);
   }

   public int func_96127_i() {
      return this.func_96133_g() / 9;
   }
}
