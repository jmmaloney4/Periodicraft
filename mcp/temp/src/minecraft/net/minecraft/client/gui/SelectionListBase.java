package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class SelectionListBase {

   private final Minecraft field_96622_a;
   private final int field_96619_e;
   private final int field_96616_f;
   private final int field_96617_g;
   private final int field_96627_h;
   protected final int field_96620_b;
   protected int field_96621_c;
   protected int field_96618_d;
   private float field_96628_i = -2.0F;
   private float field_96625_j;
   private float field_96626_k;
   private int field_96623_l = -1;
   private long field_96624_m = 0L;


   public SelectionListBase(Minecraft p_i10012_1_, int p_i10012_2_, int p_i10012_3_, int p_i10012_4_, int p_i10012_5_, int p_i10012_6_) {
      this.field_96622_a = p_i10012_1_;
      this.field_96616_f = p_i10012_3_;
      this.field_96627_h = p_i10012_3_ + p_i10012_5_;
      this.field_96620_b = p_i10012_6_;
      this.field_96619_e = p_i10012_2_;
      this.field_96617_g = p_i10012_2_ + p_i10012_4_;
   }

   protected abstract int func_96608_a();

   protected abstract void func_96615_a(int var1, boolean var2);

   protected abstract boolean func_96609_a(int var1);

   protected int func_96613_b() {
      return this.func_96608_a() * this.field_96620_b;
   }

   protected abstract void func_96611_c();

   protected abstract void func_96610_a(int var1, int var2, int var3, int var4, Tessellator var5);

   private void func_96614_f() {
      int var1 = this.func_96607_d();
      if(var1 < 0) {
         var1 = 0;
      }

      if(this.field_96626_k < 0.0F) {
         this.field_96626_k = 0.0F;
      }

      if(this.field_96626_k > (float)var1) {
         this.field_96626_k = (float)var1;
      }

   }

   public int func_96607_d() {
      return this.func_96613_b() - (this.field_96627_h - this.field_96616_f - 4);
   }

   public void func_96612_a(int p_96612_1_, int p_96612_2_, float p_96612_3_) {
      this.field_96621_c = p_96612_1_;
      this.field_96618_d = p_96612_2_;
      this.func_96611_c();
      int var4 = this.func_96608_a();
      int var5 = this.func_96606_e();
      int var6 = var5 + 6;
      int var9;
      int var10;
      int var11;
      int var13;
      int var19;
      if(Mouse.isButtonDown(0)) {
         if(this.field_96628_i == -1.0F) {
            boolean var7 = true;
            if(p_96612_2_ >= this.field_96616_f && p_96612_2_ <= this.field_96627_h) {
               int var8 = this.field_96619_e + 2;
               var9 = this.field_96617_g - 2;
               var10 = p_96612_2_ - this.field_96616_f + (int)this.field_96626_k - 4;
               var11 = var10 / this.field_96620_b;
               if(p_96612_1_ >= var8 && p_96612_1_ <= var9 && var11 >= 0 && var10 >= 0 && var11 < var4) {
                  boolean var12 = var11 == this.field_96623_l && Minecraft.func_71386_F() - this.field_96624_m < 250L;
                  this.func_96615_a(var11, var12);
                  this.field_96623_l = var11;
                  this.field_96624_m = Minecraft.func_71386_F();
               } else if(p_96612_1_ >= var8 && p_96612_1_ <= var9 && var10 < 0) {
                  var7 = false;
               }

               if(p_96612_1_ >= var5 && p_96612_1_ <= var6) {
                  this.field_96625_j = -1.0F;
                  var19 = this.func_96607_d();
                  if(var19 < 1) {
                     var19 = 1;
                  }

                  var13 = (int)((float)((this.field_96627_h - this.field_96616_f) * (this.field_96627_h - this.field_96616_f)) / (float)this.func_96613_b());
                  if(var13 < 32) {
                     var13 = 32;
                  }

                  if(var13 > this.field_96627_h - this.field_96616_f - 8) {
                     var13 = this.field_96627_h - this.field_96616_f - 8;
                  }

                  this.field_96625_j /= (float)(this.field_96627_h - this.field_96616_f - var13) / (float)var19;
               } else {
                  this.field_96625_j = 1.0F;
               }

               if(var7) {
                  this.field_96628_i = (float)p_96612_2_;
               } else {
                  this.field_96628_i = -2.0F;
               }
            } else {
               this.field_96628_i = -2.0F;
            }
         } else if(this.field_96628_i >= 0.0F) {
            this.field_96626_k -= ((float)p_96612_2_ - this.field_96628_i) * this.field_96625_j;
            this.field_96628_i = (float)p_96612_2_;
         }
      } else {
         while(!this.field_96622_a.field_71474_y.field_85185_A && Mouse.next()) {
            int var16 = Mouse.getEventDWheel();
            if(var16 != 0) {
               if(var16 > 0) {
                  var16 = -1;
               } else if(var16 < 0) {
                  var16 = 1;
               }

               this.field_96626_k += (float)(var16 * this.field_96620_b / 2);
            }
         }

         this.field_96628_i = -1.0F;
      }

      this.func_96614_f();
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      Tessellator var18 = Tessellator.field_78398_a;
      this.field_96622_a.field_71446_o.func_98187_b("/gui/background.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var17 = 32.0F;
      var18.func_78382_b();
      var18.func_78378_d(2105376);
      var18.func_78374_a((double)this.field_96619_e, (double)this.field_96627_h, 0.0D, (double)((float)this.field_96619_e / var17), (double)((float)(this.field_96627_h + (int)this.field_96626_k) / var17));
      var18.func_78374_a((double)this.field_96617_g, (double)this.field_96627_h, 0.0D, (double)((float)this.field_96617_g / var17), (double)((float)(this.field_96627_h + (int)this.field_96626_k) / var17));
      var18.func_78374_a((double)this.field_96617_g, (double)this.field_96616_f, 0.0D, (double)((float)this.field_96617_g / var17), (double)((float)(this.field_96616_f + (int)this.field_96626_k) / var17));
      var18.func_78374_a((double)this.field_96619_e, (double)this.field_96616_f, 0.0D, (double)((float)this.field_96619_e / var17), (double)((float)(this.field_96616_f + (int)this.field_96626_k) / var17));
      var18.func_78381_a();
      var9 = this.field_96619_e + 2;
      var10 = this.field_96616_f + 4 - (int)this.field_96626_k;

      int var14;
      for(var11 = 0; var11 < var4; ++var11) {
         var19 = var10 + var11 * this.field_96620_b;
         var13 = this.field_96620_b - 4;
         if(var19 + this.field_96620_b <= this.field_96627_h && var19 - 4 >= this.field_96616_f) {
            if(this.func_96609_a(var11)) {
               var14 = this.field_96619_e + 2;
               int var15 = this.field_96617_g - 2;
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

            this.func_96610_a(var11, var9, var19, var13, var18);
         }
      }

      GL11.glDisable(2929);
      byte var20 = 4;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      var18.func_78382_b();
      var18.func_78384_a(0, 0);
      var18.func_78374_a((double)this.field_96619_e, (double)(this.field_96616_f + var20), 0.0D, 0.0D, 1.0D);
      var18.func_78374_a((double)this.field_96617_g, (double)(this.field_96616_f + var20), 0.0D, 1.0D, 1.0D);
      var18.func_78384_a(0, 255);
      var18.func_78374_a((double)this.field_96617_g, (double)this.field_96616_f, 0.0D, 1.0D, 0.0D);
      var18.func_78374_a((double)this.field_96619_e, (double)this.field_96616_f, 0.0D, 0.0D, 0.0D);
      var18.func_78381_a();
      var18.func_78382_b();
      var18.func_78384_a(0, 255);
      var18.func_78374_a((double)this.field_96619_e, (double)this.field_96627_h, 0.0D, 0.0D, 1.0D);
      var18.func_78374_a((double)this.field_96617_g, (double)this.field_96627_h, 0.0D, 1.0D, 1.0D);
      var18.func_78384_a(0, 0);
      var18.func_78374_a((double)this.field_96617_g, (double)(this.field_96627_h - var20), 0.0D, 1.0D, 0.0D);
      var18.func_78374_a((double)this.field_96619_e, (double)(this.field_96627_h - var20), 0.0D, 0.0D, 0.0D);
      var18.func_78381_a();
      var19 = this.func_96607_d();
      if(var19 > 0) {
         var13 = (this.field_96627_h - this.field_96616_f) * (this.field_96627_h - this.field_96616_f) / this.func_96613_b();
         if(var13 < 32) {
            var13 = 32;
         }

         if(var13 > this.field_96627_h - this.field_96616_f - 8) {
            var13 = this.field_96627_h - this.field_96616_f - 8;
         }

         var14 = (int)this.field_96626_k * (this.field_96627_h - this.field_96616_f - var13) / var19 + this.field_96616_f;
         if(var14 < this.field_96616_f) {
            var14 = this.field_96616_f;
         }

         var18.func_78382_b();
         var18.func_78384_a(0, 255);
         var18.func_78374_a((double)var5, (double)this.field_96627_h, 0.0D, 0.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)this.field_96627_h, 0.0D, 1.0D, 1.0D);
         var18.func_78374_a((double)var6, (double)this.field_96616_f, 0.0D, 1.0D, 0.0D);
         var18.func_78374_a((double)var5, (double)this.field_96616_f, 0.0D, 0.0D, 0.0D);
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

      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glEnable(3008);
      GL11.glDisable(3042);
   }

   protected int func_96606_e() {
      return this.field_96617_g - 8;
   }
}
