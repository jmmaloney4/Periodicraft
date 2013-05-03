package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.CallableMouseLocation;
import net.minecraft.client.renderer.CallableScreenName;
import net.minecraft.client.renderer.CallableScreenSize;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.biome.BiomeGenBase;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

@SideOnly(Side.CLIENT)
public class EntityRenderer {

   public static boolean field_78517_a = false;
   public static int field_78515_b;
   private Minecraft field_78531_r;
   private float field_78530_s = 0.0F;
   public ItemRenderer field_78516_c;
   private int field_78529_t;
   private Entity field_78528_u = null;
   private MouseFilter field_78527_v = new MouseFilter();
   private MouseFilter field_78526_w = new MouseFilter();
   private MouseFilter field_78541_x = new MouseFilter();
   private MouseFilter field_78540_y = new MouseFilter();
   private MouseFilter field_78538_z = new MouseFilter();
   private MouseFilter field_78489_A = new MouseFilter();
   private float field_78490_B = 4.0F;
   private float field_78491_C = 4.0F;
   private float field_78485_D = 0.0F;
   private float field_78486_E = 0.0F;
   private float field_78487_F = 0.0F;
   private float field_78488_G = 0.0F;
   private float field_78496_H;
   private float field_78497_I;
   private float field_78498_J;
   private float field_78499_K;
   private float field_78492_L;
   private float field_78493_M = 0.0F;
   private float field_78494_N = 0.0F;
   private float field_78495_O = 0.0F;
   private float field_78505_P = 0.0F;
   public int field_78513_d;
   private int[] field_78504_Q;
   private float field_78507_R;
   private float field_78506_S;
   private float field_78501_T;
   private float field_82831_U;
   private float field_82832_V;
   private boolean field_78500_U = false;
   private double field_78503_V = 1.0D;
   private double field_78502_W = 0.0D;
   private double field_78509_X = 0.0D;
   private long field_78508_Y = Minecraft.func_71386_F();
   private long field_78510_Z = 0L;
   private boolean field_78536_aa = false;
   float field_78514_e = 0.0F;
   float field_78511_f = 0.0F;
   float field_78512_g = 0.0F;
   float field_78524_h = 0.0F;
   private Random field_78537_ab = new Random();
   private int field_78534_ac = 0;
   float[] field_78525_i;
   float[] field_78522_j;
   volatile int field_78523_k = 0;
   volatile int field_78520_l = 0;
   FloatBuffer field_78521_m = GLAllocation.func_74529_h(16);
   float field_78518_n;
   float field_78519_o;
   float field_78533_p;
   private float field_78535_ad;
   private float field_78539_ae;
   public int field_78532_q;


   public EntityRenderer(Minecraft p_i3188_1_) {
      this.field_78531_r = p_i3188_1_;
      this.field_78516_c = new ItemRenderer(p_i3188_1_);
      this.field_78513_d = p_i3188_1_.field_71446_o.func_78353_a(new BufferedImage(16, 16, 1));
      this.field_78504_Q = new int[256];
   }

   public void func_78464_a() {
      this.func_78477_e();
      this.func_78470_f();
      this.field_78535_ad = this.field_78539_ae;
      this.field_78491_C = this.field_78490_B;
      this.field_78486_E = this.field_78485_D;
      this.field_78488_G = this.field_78487_F;
      this.field_78494_N = this.field_78493_M;
      this.field_78505_P = this.field_78495_O;
      float var1;
      float var2;
      if(this.field_78531_r.field_71474_y.field_74326_T) {
         var1 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
         var2 = var1 * var1 * var1 * 8.0F;
         this.field_78498_J = this.field_78527_v.func_76333_a(this.field_78496_H, 0.05F * var2);
         this.field_78499_K = this.field_78526_w.func_76333_a(this.field_78497_I, 0.05F * var2);
         this.field_78492_L = 0.0F;
         this.field_78496_H = 0.0F;
         this.field_78497_I = 0.0F;
      }

      if(this.field_78531_r.field_71451_h == null) {
         this.field_78531_r.field_71451_h = this.field_78531_r.field_71439_g;
      }

      var1 = this.field_78531_r.field_71441_e.func_72801_o(MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70165_t), MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70163_u), MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70161_v));
      var2 = (float)(3 - this.field_78531_r.field_71474_y.field_74339_e) / 3.0F;
      float var3 = var1 * (1.0F - var2) + var2;
      this.field_78539_ae += (var3 - this.field_78539_ae) * 0.1F;
      ++this.field_78529_t;
      this.field_78516_c.func_78441_a();
      this.func_78484_h();
      this.field_82832_V = this.field_82831_U;
      if(BossStatus.field_82825_d) {
         this.field_82831_U += 0.05F;
         if(this.field_82831_U > 1.0F) {
            this.field_82831_U = 1.0F;
         }

         BossStatus.field_82825_d = false;
      } else if(this.field_82831_U > 0.0F) {
         this.field_82831_U -= 0.0125F;
      }

   }

   public void func_78473_a(float p_78473_1_) {
      if(this.field_78531_r.field_71451_h != null) {
         if(this.field_78531_r.field_71441_e != null) {
            this.field_78531_r.field_96291_i = null;
            double var2 = (double)this.field_78531_r.field_71442_b.func_78757_d();
            this.field_78531_r.field_71476_x = this.field_78531_r.field_71451_h.func_70614_a(var2, p_78473_1_);
            double var4 = var2;
            Vec3 var6 = this.field_78531_r.field_71451_h.func_70666_h(p_78473_1_);
            if(this.field_78531_r.field_71442_b.func_78749_i()) {
               var2 = 6.0D;
               var4 = 6.0D;
            } else {
               if(var2 > 3.0D) {
                  var4 = 3.0D;
               }

               var2 = var4;
            }

            if(this.field_78531_r.field_71476_x != null) {
               var4 = this.field_78531_r.field_71476_x.field_72307_f.func_72438_d(var6);
            }

            Vec3 var7 = this.field_78531_r.field_71451_h.func_70676_i(p_78473_1_);
            Vec3 var8 = var6.func_72441_c(var7.field_72450_a * var2, var7.field_72448_b * var2, var7.field_72449_c * var2);
            this.field_78528_u = null;
            float var9 = 1.0F;
            List var10 = this.field_78531_r.field_71441_e.func_72839_b(this.field_78531_r.field_71451_h, this.field_78531_r.field_71451_h.field_70121_D.func_72321_a(var7.field_72450_a * var2, var7.field_72448_b * var2, var7.field_72449_c * var2).func_72314_b((double)var9, (double)var9, (double)var9));
            double var11 = var4;

            for(int var13 = 0; var13 < var10.size(); ++var13) {
               Entity var14 = (Entity)var10.get(var13);
               if(var14.func_70067_L()) {
                  float var15 = var14.func_70111_Y();
                  AxisAlignedBB var16 = var14.field_70121_D.func_72314_b((double)var15, (double)var15, (double)var15);
                  MovingObjectPosition var17 = var16.func_72327_a(var6, var8);
                  if(var16.func_72318_a(var6)) {
                     if(0.0D < var11 || var11 == 0.0D) {
                        this.field_78528_u = var14;
                        var11 = 0.0D;
                     }
                  } else if(var17 != null) {
                     double var18 = var6.func_72438_d(var17.field_72307_f);
                     if(var18 < var11 || var11 == 0.0D) {
                        this.field_78528_u = var14;
                        var11 = var18;
                     }
                  }
               }
            }

            if(this.field_78528_u != null && (var11 < var4 || this.field_78531_r.field_71476_x == null)) {
               this.field_78531_r.field_71476_x = new MovingObjectPosition(this.field_78528_u);
               if(this.field_78528_u instanceof EntityLiving) {
                  this.field_78531_r.field_96291_i = (EntityLiving)this.field_78528_u;
               }
            }

         }
      }
   }

   private void func_78477_e() {
      EntityPlayerSP var1 = (EntityPlayerSP)this.field_78531_r.field_71451_h;
      this.field_78501_T = var1.func_71151_f();
      this.field_78506_S = this.field_78507_R;
      this.field_78507_R += (this.field_78501_T - this.field_78507_R) * 0.5F;
      if(this.field_78507_R > 1.5F) {
         this.field_78507_R = 1.5F;
      }

      if(this.field_78507_R < 0.1F) {
         this.field_78507_R = 0.1F;
      }

   }

   private float func_78481_a(float p_78481_1_, boolean p_78481_2_) {
      if(this.field_78532_q > 0) {
         return 90.0F;
      } else {
         EntityPlayer var3 = (EntityPlayer)this.field_78531_r.field_71451_h;
         float var4 = 70.0F;
         if(p_78481_2_) {
            var4 += this.field_78531_r.field_71474_y.field_74334_X * 40.0F;
            var4 *= this.field_78506_S + (this.field_78507_R - this.field_78506_S) * p_78481_1_;
         }

         if(var3.func_70630_aN() <= 0) {
            float var5 = (float)var3.field_70725_aQ + p_78481_1_;
            var4 /= (1.0F - 500.0F / (var5 + 500.0F)) * 2.0F + 1.0F;
         }

         int var6 = ActiveRenderInfo.func_74584_a(this.field_78531_r.field_71441_e, var3, p_78481_1_);
         if(var6 != 0 && Block.field_71973_m[var6].field_72018_cp == Material.field_76244_g) {
            var4 = var4 * 60.0F / 70.0F;
         }

         return var4 + this.field_78494_N + (this.field_78493_M - this.field_78494_N) * p_78481_1_;
      }
   }

   private void func_78482_e(float p_78482_1_) {
      EntityLiving var2 = this.field_78531_r.field_71451_h;
      float var3 = (float)var2.field_70737_aN - p_78482_1_;
      float var4;
      if(var2.func_70630_aN() <= 0) {
         var4 = (float)var2.field_70725_aQ + p_78482_1_;
         GL11.glRotatef(40.0F - 8000.0F / (var4 + 200.0F), 0.0F, 0.0F, 1.0F);
      }

      if(var3 >= 0.0F) {
         var3 /= (float)var2.field_70738_aO;
         var3 = MathHelper.func_76126_a(var3 * var3 * var3 * var3 * 3.1415927F);
         var4 = var2.field_70739_aP;
         GL11.glRotatef(-var4, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(var4, 0.0F, 1.0F, 0.0F);
      }
   }

   private void func_78475_f(float p_78475_1_) {
      if(this.field_78531_r.field_71451_h instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)this.field_78531_r.field_71451_h;
         float var3 = var2.field_70140_Q - var2.field_70141_P;
         float var4 = -(var2.field_70140_Q + var3 * p_78475_1_);
         float var5 = var2.field_71107_bF + (var2.field_71109_bG - var2.field_71107_bF) * p_78475_1_;
         float var6 = var2.field_70727_aS + (var2.field_70726_aT - var2.field_70727_aS) * p_78475_1_;
         GL11.glTranslatef(MathHelper.func_76126_a(var4 * 3.1415927F) * var5 * 0.5F, -Math.abs(MathHelper.func_76134_b(var4 * 3.1415927F) * var5), 0.0F);
         GL11.glRotatef(MathHelper.func_76126_a(var4 * 3.1415927F) * var5 * 3.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(Math.abs(MathHelper.func_76134_b(var4 * 3.1415927F - 0.2F) * var5) * 5.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
      }
   }

   private void func_78467_g(float p_78467_1_) {
      EntityLiving var2 = this.field_78531_r.field_71451_h;
      float var3 = var2.field_70129_M - 1.62F;
      double var4 = var2.field_70169_q + (var2.field_70165_t - var2.field_70169_q) * (double)p_78467_1_;
      double var6 = var2.field_70167_r + (var2.field_70163_u - var2.field_70167_r) * (double)p_78467_1_ - (double)var3;
      double var8 = var2.field_70166_s + (var2.field_70161_v - var2.field_70166_s) * (double)p_78467_1_;
      GL11.glRotatef(this.field_78505_P + (this.field_78495_O - this.field_78505_P) * p_78467_1_, 0.0F, 0.0F, 1.0F);
      if(var2.func_70608_bn()) {
         var3 = (float)((double)var3 + 1.0D);
         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
         if(!this.field_78531_r.field_71474_y.field_74325_U) {
            int var10 = this.field_78531_r.field_71441_e.func_72798_a(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70163_u), MathHelper.func_76128_c(var2.field_70161_v));
            if(var10 == Block.field_71959_S.field_71990_ca) {
               int var11 = this.field_78531_r.field_71441_e.func_72805_g(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70163_u), MathHelper.func_76128_c(var2.field_70161_v));
               int var12 = var11 & 3;
               GL11.glRotatef((float)(var12 * 90), 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(var2.field_70126_B + (var2.field_70177_z - var2.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, -1.0F, 0.0F);
            GL11.glRotatef(var2.field_70127_C + (var2.field_70125_A - var2.field_70127_C) * p_78467_1_, -1.0F, 0.0F, 0.0F);
         }
      } else if(this.field_78531_r.field_71474_y.field_74320_O > 0) {
         double var27 = (double)(this.field_78491_C + (this.field_78490_B - this.field_78491_C) * p_78467_1_);
         float var13;
         float var28;
         if(this.field_78531_r.field_71474_y.field_74325_U) {
            var28 = this.field_78486_E + (this.field_78485_D - this.field_78486_E) * p_78467_1_;
            var13 = this.field_78488_G + (this.field_78487_F - this.field_78488_G) * p_78467_1_;
            GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
            GL11.glRotatef(var13, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var28, 0.0F, 1.0F, 0.0F);
         } else {
            var28 = var2.field_70177_z;
            var13 = var2.field_70125_A;
            if(this.field_78531_r.field_71474_y.field_74320_O == 2) {
               var13 += 180.0F;
            }

            double var14 = (double)(-MathHelper.func_76126_a(var28 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(var13 / 180.0F * 3.1415927F)) * var27;
            double var16 = (double)(MathHelper.func_76134_b(var28 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(var13 / 180.0F * 3.1415927F)) * var27;
            double var18 = (double)(-MathHelper.func_76126_a(var13 / 180.0F * 3.1415927F)) * var27;

            for(int var20 = 0; var20 < 8; ++var20) {
               float var21 = (float)((var20 & 1) * 2 - 1);
               float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
               float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
               var21 *= 0.1F;
               var22 *= 0.1F;
               var23 *= 0.1F;
               MovingObjectPosition var24 = this.field_78531_r.field_71441_e.func_72933_a(this.field_78531_r.field_71441_e.func_82732_R().func_72345_a(var4 + (double)var21, var6 + (double)var22, var8 + (double)var23), this.field_78531_r.field_71441_e.func_82732_R().func_72345_a(var4 - var14 + (double)var21 + (double)var23, var6 - var18 + (double)var22, var8 - var16 + (double)var23));
               if(var24 != null) {
                  double var25 = var24.field_72307_f.func_72438_d(this.field_78531_r.field_71441_e.func_82732_R().func_72345_a(var4, var6, var8));
                  if(var25 < var27) {
                     var27 = var25;
                  }
               }
            }

            if(this.field_78531_r.field_71474_y.field_74320_O == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(var2.field_70125_A - var13, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var2.field_70177_z - var28, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
            GL11.glRotatef(var28 - var2.field_70177_z, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var13 - var2.field_70125_A, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GL11.glTranslatef(0.0F, 0.0F, -0.1F);
      }

      if(!this.field_78531_r.field_71474_y.field_74325_U) {
         GL11.glRotatef(var2.field_70127_C + (var2.field_70125_A - var2.field_70127_C) * p_78467_1_, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var2.field_70126_B + (var2.field_70177_z - var2.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glTranslatef(0.0F, var3, 0.0F);
      var4 = var2.field_70169_q + (var2.field_70165_t - var2.field_70169_q) * (double)p_78467_1_;
      var6 = var2.field_70167_r + (var2.field_70163_u - var2.field_70167_r) * (double)p_78467_1_ - (double)var3;
      var8 = var2.field_70166_s + (var2.field_70161_v - var2.field_70166_s) * (double)p_78467_1_;
      this.field_78500_U = this.field_78531_r.field_71438_f.func_72721_a(var4, var6, var8, p_78467_1_);
   }

   private void func_78479_a(float p_78479_1_, int p_78479_2_) {
      this.field_78530_s = (float)(256 >> this.field_78531_r.field_71474_y.field_74339_e);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      float var3 = 0.07F;
      if(this.field_78531_r.field_71474_y.field_74337_g) {
         GL11.glTranslatef((float)(-(p_78479_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
      }

      if(this.field_78503_V != 1.0D) {
         GL11.glTranslatef((float)this.field_78502_W, (float)(-this.field_78509_X), 0.0F);
         GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0D);
      }

      GLU.gluPerspective(this.func_78481_a(p_78479_1_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F);
      float var4;
      if(this.field_78531_r.field_71442_b.func_78747_a()) {
         var4 = 0.6666667F;
         GL11.glScalef(1.0F, var4, 1.0F);
      }

      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      if(this.field_78531_r.field_71474_y.field_74337_g) {
         GL11.glTranslatef((float)(p_78479_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
      }

      this.func_78482_e(p_78479_1_);
      if(this.field_78531_r.field_71474_y.field_74336_f) {
         this.func_78475_f(p_78479_1_);
      }

      var4 = this.field_78531_r.field_71439_g.field_71080_cy + (this.field_78531_r.field_71439_g.field_71086_bY - this.field_78531_r.field_71439_g.field_71080_cy) * p_78479_1_;
      if(var4 > 0.0F) {
         byte var5 = 20;
         if(this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76431_k)) {
            var5 = 7;
         }

         float var6 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F;
         var6 *= var6;
         GL11.glRotatef(((float)this.field_78529_t + p_78479_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
         GL11.glScalef(1.0F / var6, 1.0F, 1.0F);
         GL11.glRotatef(-((float)this.field_78529_t + p_78479_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
      }

      this.func_78467_g(p_78479_1_);
      if(this.field_78532_q > 0) {
         int var7 = this.field_78532_q - 1;
         if(var7 == 1) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 2) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 3) {
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 4) {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         }

         if(var7 == 5) {
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
         }
      }

   }

   private void func_78476_b(float p_78476_1_, int p_78476_2_) {
      if(this.field_78532_q <= 0) {
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         float var3 = 0.07F;
         if(this.field_78531_r.field_71474_y.field_74337_g) {
            GL11.glTranslatef((float)(-(p_78476_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
         }

         if(this.field_78503_V != 1.0D) {
            GL11.glTranslatef((float)this.field_78502_W, (float)(-this.field_78509_X), 0.0F);
            GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0D);
         }

         GLU.gluPerspective(this.func_78481_a(p_78476_1_, false), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F);
         if(this.field_78531_r.field_71442_b.func_78747_a()) {
            float var4 = 0.6666667F;
            GL11.glScalef(1.0F, var4, 1.0F);
         }

         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         if(this.field_78531_r.field_71474_y.field_74337_g) {
            GL11.glTranslatef((float)(p_78476_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
         }

         GL11.glPushMatrix();
         this.func_78482_e(p_78476_1_);
         if(this.field_78531_r.field_71474_y.field_74336_f) {
            this.func_78475_f(p_78476_1_);
         }

         if(this.field_78531_r.field_71474_y.field_74320_O == 0 && !this.field_78531_r.field_71451_h.func_70608_bn() && !this.field_78531_r.field_71474_y.field_74319_N && !this.field_78531_r.field_71442_b.func_78747_a()) {
            this.func_78463_b((double)p_78476_1_);
            this.field_78516_c.func_78440_a(p_78476_1_);
            this.func_78483_a((double)p_78476_1_);
         }

         GL11.glPopMatrix();
         if(this.field_78531_r.field_71474_y.field_74320_O == 0 && !this.field_78531_r.field_71451_h.func_70608_bn()) {
            this.field_78516_c.func_78447_b(p_78476_1_);
            this.func_78482_e(p_78476_1_);
         }

         if(this.field_78531_r.field_71474_y.field_74336_f) {
            this.func_78475_f(p_78476_1_);
         }

      }
   }

   public void func_78483_a(double p_78483_1_) {
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   public void func_78463_b(double p_78463_1_) {
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
      GL11.glMatrixMode(5890);
      GL11.glLoadIdentity();
      float var3 = 0.00390625F;
      GL11.glScalef(var3, var3, var3);
      GL11.glTranslatef(8.0F, 8.0F, 8.0F);
      GL11.glMatrixMode(5888);
      GL11.glBindTexture(3553, this.field_78513_d);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 10496);
      GL11.glTexParameteri(3553, 10243, 10496);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      this.field_78531_r.field_71446_o.func_98185_a();
      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
   }

   private void func_78470_f() {
      this.field_78511_f = (float)((double)this.field_78511_f + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.field_78524_h = (float)((double)this.field_78524_h + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.field_78511_f = (float)((double)this.field_78511_f * 0.9D);
      this.field_78524_h = (float)((double)this.field_78524_h * 0.9D);
      this.field_78514_e += (this.field_78511_f - this.field_78514_e) * 1.0F;
      this.field_78512_g += (this.field_78524_h - this.field_78512_g) * 1.0F;
      this.field_78536_aa = true;
   }

   private void func_78472_g(float p_78472_1_) {
      WorldClient var2 = this.field_78531_r.field_71441_e;
      if(var2 != null) {
         for(int var3 = 0; var3 < 256; ++var3) {
            float var4 = var2.func_72971_b(1.0F) * 0.95F + 0.05F;
            float var5 = var2.field_73011_w.field_76573_f[var3 / 16] * var4;
            float var6 = var2.field_73011_w.field_76573_f[var3 % 16] * (this.field_78514_e * 0.1F + 1.5F);
            if(var2.field_73016_r > 0) {
               var5 = var2.field_73011_w.field_76573_f[var3 / 16];
            }

            float var7 = var5 * (var2.func_72971_b(1.0F) * 0.65F + 0.35F);
            float var8 = var5 * (var2.func_72971_b(1.0F) * 0.65F + 0.35F);
            float var11 = var6 * ((var6 * 0.6F + 0.4F) * 0.6F + 0.4F);
            float var12 = var6 * (var6 * var6 * 0.6F + 0.4F);
            float var13 = var7 + var6;
            float var14 = var8 + var11;
            float var15 = var5 + var12;
            var13 = var13 * 0.96F + 0.03F;
            var14 = var14 * 0.96F + 0.03F;
            var15 = var15 * 0.96F + 0.03F;
            float var16;
            if(this.field_82831_U > 0.0F) {
               var16 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78472_1_;
               var13 = var13 * (1.0F - var16) + var13 * 0.7F * var16;
               var14 = var14 * (1.0F - var16) + var14 * 0.6F * var16;
               var15 = var15 * (1.0F - var16) + var15 * 0.6F * var16;
            }

            if(var2.field_73011_w.field_76574_g == 1) {
               var13 = 0.22F + var6 * 0.75F;
               var14 = 0.28F + var11 * 0.75F;
               var15 = 0.25F + var12 * 0.75F;
            }

            float var17;
            if(this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76439_r)) {
               var16 = this.func_82830_a(this.field_78531_r.field_71439_g, p_78472_1_);
               var17 = 1.0F / var13;
               if(var17 > 1.0F / var14) {
                  var17 = 1.0F / var14;
               }

               if(var17 > 1.0F / var15) {
                  var17 = 1.0F / var15;
               }

               var13 = var13 * (1.0F - var16) + var13 * var17 * var16;
               var14 = var14 * (1.0F - var16) + var14 * var17 * var16;
               var15 = var15 * (1.0F - var16) + var15 * var17 * var16;
            }

            if(var13 > 1.0F) {
               var13 = 1.0F;
            }

            if(var14 > 1.0F) {
               var14 = 1.0F;
            }

            if(var15 > 1.0F) {
               var15 = 1.0F;
            }

            var16 = this.field_78531_r.field_71474_y.field_74333_Y;
            var17 = 1.0F - var13;
            float var18 = 1.0F - var14;
            float var19 = 1.0F - var15;
            var17 = 1.0F - var17 * var17 * var17 * var17;
            var18 = 1.0F - var18 * var18 * var18 * var18;
            var19 = 1.0F - var19 * var19 * var19 * var19;
            var13 = var13 * (1.0F - var16) + var17 * var16;
            var14 = var14 * (1.0F - var16) + var18 * var16;
            var15 = var15 * (1.0F - var16) + var19 * var16;
            var13 = var13 * 0.96F + 0.03F;
            var14 = var14 * 0.96F + 0.03F;
            var15 = var15 * 0.96F + 0.03F;
            if(var13 > 1.0F) {
               var13 = 1.0F;
            }

            if(var14 > 1.0F) {
               var14 = 1.0F;
            }

            if(var15 > 1.0F) {
               var15 = 1.0F;
            }

            if(var13 < 0.0F) {
               var13 = 0.0F;
            }

            if(var14 < 0.0F) {
               var14 = 0.0F;
            }

            if(var15 < 0.0F) {
               var15 = 0.0F;
            }

            short var20 = 255;
            int var21 = (int)(var13 * 255.0F);
            int var22 = (int)(var14 * 255.0F);
            int var23 = (int)(var15 * 255.0F);
            this.field_78504_Q[var3] = var20 << 24 | var21 << 16 | var22 << 8 | var23;
         }

         this.field_78531_r.field_71446_o.func_78349_a(this.field_78504_Q, 16, 16, this.field_78513_d);
      }
   }

   private float func_82830_a(EntityPlayer p_82830_1_, float p_82830_2_) {
      int var3 = p_82830_1_.func_70660_b(Potion.field_76439_r).func_76459_b();
      return var3 > 200?1.0F:0.7F + MathHelper.func_76126_a(((float)var3 - p_82830_2_) * 3.1415927F * 0.2F) * 0.3F;
   }

   public void func_78480_b(float p_78480_1_) {
      this.field_78531_r.field_71424_I.func_76320_a("lightTex");
      if(this.field_78536_aa) {
         this.func_78472_g(p_78480_1_);
      }

      this.field_78531_r.field_71424_I.func_76319_b();
      boolean var2 = Display.isActive();
      if(!var2 && this.field_78531_r.field_71474_y.field_82881_y && (!this.field_78531_r.field_71474_y.field_85185_A || !Mouse.isButtonDown(1))) {
         if(Minecraft.func_71386_F() - this.field_78508_Y > 500L) {
            this.field_78531_r.func_71385_j();
         }
      } else {
         this.field_78508_Y = Minecraft.func_71386_F();
      }

      this.field_78531_r.field_71424_I.func_76320_a("mouse");
      if(this.field_78531_r.field_71415_G && var2) {
         this.field_78531_r.field_71417_B.func_74374_c();
         float var3 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
         float var4 = var3 * var3 * var3 * 8.0F;
         float var5 = (float)this.field_78531_r.field_71417_B.field_74377_a * var4;
         float var6 = (float)this.field_78531_r.field_71417_B.field_74375_b * var4;
         byte var7 = 1;
         if(this.field_78531_r.field_71474_y.field_74338_d) {
            var7 = -1;
         }

         if(this.field_78531_r.field_71474_y.field_74326_T) {
            this.field_78496_H += var5;
            this.field_78497_I += var6;
            float var8 = p_78480_1_ - this.field_78492_L;
            this.field_78492_L = p_78480_1_;
            var5 = this.field_78498_J * var8;
            var6 = this.field_78499_K * var8;
            this.field_78531_r.field_71439_g.func_70082_c(var5, var6 * (float)var7);
         } else {
            this.field_78531_r.field_71439_g.func_70082_c(var5, var6 * (float)var7);
         }
      }

      this.field_78531_r.field_71424_I.func_76319_b();
      if(!this.field_78531_r.field_71454_w) {
         field_78517_a = this.field_78531_r.field_71474_y.field_74337_g;
         ScaledResolution var13 = new ScaledResolution(this.field_78531_r.field_71474_y, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
         int var14 = var13.func_78326_a();
         int var15 = var13.func_78328_b();
         int var16 = Mouse.getX() * var14 / this.field_78531_r.field_71443_c;
         int var17 = var15 - Mouse.getY() * var15 / this.field_78531_r.field_71440_d - 1;
         int var18 = func_78465_a(this.field_78531_r.field_71474_y.field_74350_i);
         if(this.field_78531_r.field_71441_e != null) {
            this.field_78531_r.field_71424_I.func_76320_a("level");
            if(this.field_78531_r.field_71474_y.field_74350_i == 0) {
               this.func_78471_a(p_78480_1_, 0L);
            } else {
               this.func_78471_a(p_78480_1_, this.field_78510_Z + (long)(1000000000 / var18));
            }

            this.field_78510_Z = System.nanoTime();
            this.field_78531_r.field_71424_I.func_76318_c("gui");
            if(!this.field_78531_r.field_71474_y.field_74319_N || this.field_78531_r.field_71462_r != null) {
               this.field_78531_r.field_71456_v.func_73830_a(p_78480_1_, this.field_78531_r.field_71462_r != null, var16, var17);
            }

            this.field_78531_r.field_71424_I.func_76319_b();
         } else {
            GL11.glViewport(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            this.func_78478_c();
            this.field_78510_Z = System.nanoTime();
         }

         if(this.field_78531_r.field_71462_r != null) {
            GL11.glClear(256);

            try {
               this.field_78531_r.field_71462_r.func_73863_a(var16, var17, p_78480_1_);
            } catch (Throwable var12) {
               CrashReport var10 = CrashReport.func_85055_a(var12, "Rendering screen");
               CrashReportCategory var11 = var10.func_85058_a("Screen render details");
               var11.func_71500_a("Screen name", new CallableScreenName(this));
               var11.func_71500_a("Mouse location", new CallableMouseLocation(this, var16, var17));
               var11.func_71500_a("Screen size", new CallableScreenSize(this, var13));
               throw new ReportedException(var10);
            }

            if(this.field_78531_r.field_71462_r != null && this.field_78531_r.field_71462_r.field_73884_l != null) {
               this.field_78531_r.field_71462_r.field_73884_l.func_73773_a(p_78480_1_);
            }
         }

      }
   }

   public void func_78471_a(float p_78471_1_, long p_78471_2_) {
      this.field_78531_r.field_71424_I.func_76320_a("lightTex");
      if(this.field_78536_aa) {
         this.func_78472_g(p_78471_1_);
      }

      GL11.glEnable(2884);
      GL11.glEnable(2929);
      if(this.field_78531_r.field_71451_h == null) {
         this.field_78531_r.field_71451_h = this.field_78531_r.field_71439_g;
      }

      this.field_78531_r.field_71424_I.func_76318_c("pick");
      this.func_78473_a(p_78471_1_);
      EntityLiving var4 = this.field_78531_r.field_71451_h;
      RenderGlobal var5 = this.field_78531_r.field_71438_f;
      EffectRenderer var6 = this.field_78531_r.field_71452_i;
      double var7 = var4.field_70142_S + (var4.field_70165_t - var4.field_70142_S) * (double)p_78471_1_;
      double var9 = var4.field_70137_T + (var4.field_70163_u - var4.field_70137_T) * (double)p_78471_1_;
      double var11 = var4.field_70136_U + (var4.field_70161_v - var4.field_70136_U) * (double)p_78471_1_;
      this.field_78531_r.field_71424_I.func_76318_c("center");

      for(int var13 = 0; var13 < 2; ++var13) {
         if(this.field_78531_r.field_71474_y.field_74337_g) {
            field_78515_b = var13;
            if(field_78515_b == 0) {
               GL11.glColorMask(false, true, true, false);
            } else {
               GL11.glColorMask(true, false, false, false);
            }
         }

         this.field_78531_r.field_71424_I.func_76318_c("clear");
         GL11.glViewport(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
         this.func_78466_h(p_78471_1_);
         GL11.glClear(16640);
         GL11.glEnable(2884);
         this.field_78531_r.field_71424_I.func_76318_c("camera");
         this.func_78479_a(p_78471_1_, var13);
         ActiveRenderInfo.func_74583_a(this.field_78531_r.field_71439_g, this.field_78531_r.field_71474_y.field_74320_O == 2);
         this.field_78531_r.field_71424_I.func_76318_c("frustrum");
         ClippingHelperImpl.func_78558_a();
         if(this.field_78531_r.field_71474_y.field_74339_e < 2) {
            this.func_78468_a(-1, p_78471_1_);
            this.field_78531_r.field_71424_I.func_76318_c("sky");
            var5.func_72714_a(p_78471_1_);
         }

         GL11.glEnable(2912);
         this.func_78468_a(1, p_78471_1_);
         if(this.field_78531_r.field_71474_y.field_74348_k != 0) {
            GL11.glShadeModel(7425);
         }

         this.field_78531_r.field_71424_I.func_76318_c("culling");
         Frustrum var14 = new Frustrum();
         var14.func_78547_a(var7, var9, var11);
         this.field_78531_r.field_71438_f.func_72729_a(var14, p_78471_1_);
         if(var13 == 0) {
            this.field_78531_r.field_71424_I.func_76318_c("updatechunks");

            while(!this.field_78531_r.field_71438_f.func_72716_a(var4, false) && p_78471_2_ != 0L) {
               long var15 = p_78471_2_ - System.nanoTime();
               if(var15 < 0L || var15 > 1000000000L) {
                  break;
               }
            }
         }

         if(var4.field_70163_u < 128.0D) {
            this.func_82829_a(var5, p_78471_1_);
         }

         this.field_78531_r.field_71424_I.func_76318_c("prepareterrain");
         this.func_78468_a(0, p_78471_1_);
         GL11.glEnable(2912);
         this.field_78531_r.field_71446_o.func_98187_b("/terrain.png");
         RenderHelper.func_74518_a();
         this.field_78531_r.field_71424_I.func_76318_c("terrain");
         var5.func_72719_a(var4, 0, (double)p_78471_1_);
         GL11.glShadeModel(7424);
         EntityPlayer var17;
         if(this.field_78532_q == 0) {
            RenderHelper.func_74519_b();
            this.field_78531_r.field_71424_I.func_76318_c("entities");
            var5.func_72713_a(var4.func_70666_h(p_78471_1_), var14, p_78471_1_);
            this.func_78463_b((double)p_78471_1_);
            this.field_78531_r.field_71424_I.func_76318_c("litParticles");
            var6.func_78872_b(var4, p_78471_1_);
            RenderHelper.func_74518_a();
            this.func_78468_a(0, p_78471_1_);
            this.field_78531_r.field_71424_I.func_76318_c("particles");
            var6.func_78874_a(var4, p_78471_1_);
            this.func_78483_a((double)p_78471_1_);
            if(this.field_78531_r.field_71476_x != null && var4.func_70055_a(Material.field_76244_g) && var4 instanceof EntityPlayer && !this.field_78531_r.field_71474_y.field_74319_N) {
               var17 = (EntityPlayer)var4;
               GL11.glDisable(3008);
               this.field_78531_r.field_71424_I.func_76318_c("outline");
               var5.func_72727_a(var17, this.field_78531_r.field_71476_x, 0, var17.field_71071_by.func_70448_g(), p_78471_1_);
               var5.func_72731_b(var17, this.field_78531_r.field_71476_x, 0, var17.field_71071_by.func_70448_g(), p_78471_1_);
               GL11.glEnable(3008);
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(2884);
         GL11.glBlendFunc(770, 771);
         GL11.glDepthMask(true);
         this.func_78468_a(0, p_78471_1_);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         this.field_78531_r.field_71446_o.func_98187_b("/terrain.png");
         if(this.field_78531_r.field_71474_y.field_74347_j) {
            this.field_78531_r.field_71424_I.func_76318_c("water");
            if(this.field_78531_r.field_71474_y.field_74348_k != 0) {
               GL11.glShadeModel(7425);
            }

            GL11.glColorMask(false, false, false, false);
            int var18 = var5.func_72719_a(var4, 1, (double)p_78471_1_);
            if(this.field_78531_r.field_71474_y.field_74337_g) {
               if(field_78515_b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            if(var18 > 0) {
               var5.func_72733_a(1, (double)p_78471_1_);
            }

            GL11.glShadeModel(7424);
         } else {
            this.field_78531_r.field_71424_I.func_76318_c("water");
            var5.func_72719_a(var4, 1, (double)p_78471_1_);
         }

         GL11.glDepthMask(true);
         GL11.glEnable(2884);
         GL11.glDisable(3042);
         if(this.field_78503_V == 1.0D && var4 instanceof EntityPlayer && !this.field_78531_r.field_71474_y.field_74319_N && this.field_78531_r.field_71476_x != null && !var4.func_70055_a(Material.field_76244_g)) {
            var17 = (EntityPlayer)var4;
            GL11.glDisable(3008);
            this.field_78531_r.field_71424_I.func_76318_c("outline");
            var5.func_72727_a(var17, this.field_78531_r.field_71476_x, 0, var17.field_71071_by.func_70448_g(), p_78471_1_);
            var5.func_72731_b(var17, this.field_78531_r.field_71476_x, 0, var17.field_71071_by.func_70448_g(), p_78471_1_);
            GL11.glEnable(3008);
         }

         this.field_78531_r.field_71424_I.func_76318_c("destroyProgress");
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         var5.func_72717_a(Tessellator.field_78398_a, (EntityPlayer)var4, p_78471_1_);
         GL11.glDisable(3042);
         this.field_78531_r.field_71424_I.func_76318_c("weather");
         this.func_78474_d(p_78471_1_);
         GL11.glDisable(2912);
         if(var4.field_70163_u >= 128.0D) {
            this.func_82829_a(var5, p_78471_1_);
         }

         this.field_78531_r.field_71424_I.func_76318_c("hand");
         if(this.field_78503_V == 1.0D) {
            GL11.glClear(256);
            this.func_78476_b(p_78471_1_, var13);
         }

         if(!this.field_78531_r.field_71474_y.field_74337_g) {
            this.field_78531_r.field_71424_I.func_76319_b();
            return;
         }
      }

      GL11.glColorMask(true, true, true, false);
      this.field_78531_r.field_71424_I.func_76319_b();
   }

   private void func_82829_a(RenderGlobal p_82829_1_, float p_82829_2_) {
      if(this.field_78531_r.field_71474_y.func_74309_c()) {
         this.field_78531_r.field_71424_I.func_76318_c("clouds");
         GL11.glPushMatrix();
         this.func_78468_a(0, p_82829_2_);
         GL11.glEnable(2912);
         p_82829_1_.func_72718_b(p_82829_2_);
         GL11.glDisable(2912);
         this.func_78468_a(1, p_82829_2_);
         GL11.glPopMatrix();
      }

   }

   private void func_78484_h() {
      float var1 = this.field_78531_r.field_71441_e.func_72867_j(1.0F);
      if(!this.field_78531_r.field_71474_y.field_74347_j) {
         var1 /= 2.0F;
      }

      if(var1 != 0.0F) {
         this.field_78537_ab.setSeed((long)this.field_78529_t * 312987231L);
         EntityLiving var2 = this.field_78531_r.field_71451_h;
         WorldClient var3 = this.field_78531_r.field_71441_e;
         int var4 = MathHelper.func_76128_c(var2.field_70165_t);
         int var5 = MathHelper.func_76128_c(var2.field_70163_u);
         int var6 = MathHelper.func_76128_c(var2.field_70161_v);
         byte var7 = 10;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         int var14 = 0;
         int var15 = (int)(100.0F * var1 * var1);
         if(this.field_78531_r.field_71474_y.field_74362_aa == 1) {
            var15 >>= 1;
         } else if(this.field_78531_r.field_71474_y.field_74362_aa == 2) {
            var15 = 0;
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            int var17 = var4 + this.field_78537_ab.nextInt(var7) - this.field_78537_ab.nextInt(var7);
            int var18 = var6 + this.field_78537_ab.nextInt(var7) - this.field_78537_ab.nextInt(var7);
            int var19 = var3.func_72874_g(var17, var18);
            int var20 = var3.func_72798_a(var17, var19 - 1, var18);
            BiomeGenBase var21 = var3.func_72807_a(var17, var18);
            if(var19 <= var5 + var7 && var19 >= var5 - var7 && var21.func_76738_d() && var21.func_76743_j() >= 0.2F) {
               float var22 = this.field_78537_ab.nextFloat();
               float var23 = this.field_78537_ab.nextFloat();
               if(var20 > 0) {
                  if(Block.field_71973_m[var20].field_72018_cp == Material.field_76256_h) {
                     this.field_78531_r.field_71452_i.func_78873_a(new EntitySmokeFX(var3, (double)((float)var17 + var22), (double)((float)var19 + 0.1F) - Block.field_71973_m[var20].func_83008_x(), (double)((float)var18 + var23), 0.0D, 0.0D, 0.0D));
                  } else {
                     ++var14;
                     if(this.field_78537_ab.nextInt(var14) == 0) {
                        var8 = (double)((float)var17 + var22);
                        var10 = (double)((float)var19 + 0.1F) - Block.field_71973_m[var20].func_83008_x();
                        var12 = (double)((float)var18 + var23);
                     }

                     this.field_78531_r.field_71452_i.func_78873_a(new EntityRainFX(var3, (double)((float)var17 + var22), (double)((float)var19 + 0.1F) - Block.field_71973_m[var20].func_83008_x(), (double)((float)var18 + var23)));
                  }
               }
            }
         }

         if(var14 > 0 && this.field_78537_ab.nextInt(3) < this.field_78534_ac++) {
            this.field_78534_ac = 0;
            if(var10 > var2.field_70163_u + 1.0D && var3.func_72874_g(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70161_v)) > MathHelper.func_76128_c(var2.field_70163_u)) {
               this.field_78531_r.field_71441_e.func_72980_b(var8, var10, var12, "ambient.weather.rain", 0.1F, 0.5F, false);
            } else {
               this.field_78531_r.field_71441_e.func_72980_b(var8, var10, var12, "ambient.weather.rain", 0.2F, 1.0F, false);
            }
         }

      }
   }

   protected void func_78474_d(float p_78474_1_) {
      float var2 = this.field_78531_r.field_71441_e.func_72867_j(p_78474_1_);
      if(var2 > 0.0F) {
         this.func_78463_b((double)p_78474_1_);
         if(this.field_78525_i == null) {
            this.field_78525_i = new float[1024];
            this.field_78522_j = new float[1024];

            for(int var3 = 0; var3 < 32; ++var3) {
               for(int var4 = 0; var4 < 32; ++var4) {
                  float var5 = (float)(var4 - 16);
                  float var6 = (float)(var3 - 16);
                  float var7 = MathHelper.func_76129_c(var5 * var5 + var6 * var6);
                  this.field_78525_i[var3 << 5 | var4] = -var6 / var7;
                  this.field_78522_j[var3 << 5 | var4] = var5 / var7;
               }
            }
         }

         EntityLiving var41 = this.field_78531_r.field_71451_h;
         WorldClient var42 = this.field_78531_r.field_71441_e;
         int var43 = MathHelper.func_76128_c(var41.field_70165_t);
         int var44 = MathHelper.func_76128_c(var41.field_70163_u);
         int var45 = MathHelper.func_76128_c(var41.field_70161_v);
         Tessellator var8 = Tessellator.field_78398_a;
         GL11.glDisable(2884);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.01F);
         this.field_78531_r.field_71446_o.func_98187_b("/environment/snow.png");
         double var9 = var41.field_70142_S + (var41.field_70165_t - var41.field_70142_S) * (double)p_78474_1_;
         double var11 = var41.field_70137_T + (var41.field_70163_u - var41.field_70137_T) * (double)p_78474_1_;
         double var13 = var41.field_70136_U + (var41.field_70161_v - var41.field_70136_U) * (double)p_78474_1_;
         int var15 = MathHelper.func_76128_c(var11);
         byte var16 = 5;
         if(this.field_78531_r.field_71474_y.field_74347_j) {
            var16 = 10;
         }

         boolean var17 = false;
         byte var18 = -1;
         float var19 = (float)this.field_78529_t + p_78474_1_;
         if(this.field_78531_r.field_71474_y.field_74347_j) {
            var16 = 10;
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         var17 = false;

         for(int var20 = var45 - var16; var20 <= var45 + var16; ++var20) {
            for(int var21 = var43 - var16; var21 <= var43 + var16; ++var21) {
               int var22 = (var20 - var45 + 16) * 32 + var21 - var43 + 16;
               float var23 = this.field_78525_i[var22] * 0.5F;
               float var24 = this.field_78522_j[var22] * 0.5F;
               BiomeGenBase var25 = var42.func_72807_a(var21, var20);
               if(var25.func_76738_d() || var25.func_76746_c()) {
                  int var26 = var42.func_72874_g(var21, var20);
                  int var27 = var44 - var16;
                  int var28 = var44 + var16;
                  if(var27 < var26) {
                     var27 = var26;
                  }

                  if(var28 < var26) {
                     var28 = var26;
                  }

                  float var29 = 1.0F;
                  int var30 = var26;
                  if(var26 < var15) {
                     var30 = var15;
                  }

                  if(var27 != var28) {
                     this.field_78537_ab.setSeed((long)(var21 * var21 * 3121 + var21 * 45238971 ^ var20 * var20 * 418711 + var20 * 13761));
                     float var31 = var25.func_76743_j();
                     double var35;
                     float var32;
                     if(var42.func_72959_q().func_76939_a(var31, var26) >= 0.15F) {
                        if(var18 != 0) {
                           if(var18 >= 0) {
                              var8.func_78381_a();
                           }

                           var18 = 0;
                           this.field_78531_r.field_71446_o.func_98187_b("/environment/rain.png");
                           var8.func_78382_b();
                        }

                        var32 = ((float)(this.field_78529_t + var21 * var21 * 3121 + var21 * 45238971 + var20 * var20 * 418711 + var20 * 13761 & 31) + p_78474_1_) / 32.0F * (3.0F + this.field_78537_ab.nextFloat());
                        double var33 = (double)((float)var21 + 0.5F) - var41.field_70165_t;
                        var35 = (double)((float)var20 + 0.5F) - var41.field_70161_v;
                        float var37 = MathHelper.func_76133_a(var33 * var33 + var35 * var35) / (float)var16;
                        float var38 = 1.0F;
                        var8.func_78380_c(var42.func_72802_i(var21, var30, var20, 0));
                        var8.func_78369_a(var38, var38, var38, ((1.0F - var37 * var37) * 0.5F + 0.5F) * var2);
                        var8.func_78373_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                        var8.func_78374_a((double)((float)var21 - var23) + 0.5D, (double)var27, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29), (double)((float)var27 * var29 / 4.0F + var32 * var29));
                        var8.func_78374_a((double)((float)var21 + var23) + 0.5D, (double)var27, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29), (double)((float)var27 * var29 / 4.0F + var32 * var29));
                        var8.func_78374_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29), (double)((float)var28 * var29 / 4.0F + var32 * var29));
                        var8.func_78374_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29), (double)((float)var28 * var29 / 4.0F + var32 * var29));
                        var8.func_78373_b(0.0D, 0.0D, 0.0D);
                     } else {
                        if(var18 != 1) {
                           if(var18 >= 0) {
                              var8.func_78381_a();
                           }

                           var18 = 1;
                           this.field_78531_r.field_71446_o.func_98187_b("/environment/snow.png");
                           var8.func_78382_b();
                        }

                        var32 = ((float)(this.field_78529_t & 511) + p_78474_1_) / 512.0F;
                        float var46 = this.field_78537_ab.nextFloat() + var19 * 0.01F * (float)this.field_78537_ab.nextGaussian();
                        float var34 = this.field_78537_ab.nextFloat() + var19 * (float)this.field_78537_ab.nextGaussian() * 0.0010F;
                        var35 = (double)((float)var21 + 0.5F) - var41.field_70165_t;
                        double var47 = (double)((float)var20 + 0.5F) - var41.field_70161_v;
                        float var39 = MathHelper.func_76133_a(var35 * var35 + var47 * var47) / (float)var16;
                        float var40 = 1.0F;
                        var8.func_78380_c((var42.func_72802_i(var21, var30, var20, 0) * 3 + 15728880) / 4);
                        var8.func_78369_a(var40, var40, var40, ((1.0F - var39 * var39) * 0.3F + 0.5F) * var2);
                        var8.func_78373_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                        var8.func_78374_a((double)((float)var21 - var23) + 0.5D, (double)var27, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29 + var46), (double)((float)var27 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_78374_a((double)((float)var21 + var23) + 0.5D, (double)var27, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29 + var46), (double)((float)var27 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_78374_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29 + var46), (double)((float)var28 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_78374_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29 + var46), (double)((float)var28 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_78373_b(0.0D, 0.0D, 0.0D);
                     }
                  }
               }
            }
         }

         if(var18 >= 0) {
            var8.func_78381_a();
         }

         GL11.glEnable(2884);
         GL11.glDisable(3042);
         GL11.glAlphaFunc(516, 0.1F);
         this.func_78483_a((double)p_78474_1_);
      }
   }

   public void func_78478_c() {
      ScaledResolution var1 = new ScaledResolution(this.field_78531_r.field_71474_y, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, var1.func_78327_c(), var1.func_78324_d(), 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   private void func_78466_h(float p_78466_1_) {
      WorldClient var2 = this.field_78531_r.field_71441_e;
      EntityLiving var3 = this.field_78531_r.field_71451_h;
      float var4 = 1.0F / (float)(4 - this.field_78531_r.field_71474_y.field_74339_e);
      var4 = 1.0F - (float)Math.pow((double)var4, 0.25D);
      Vec3 var5 = var2.func_72833_a(this.field_78531_r.field_71451_h, p_78466_1_);
      float var6 = (float)var5.field_72450_a;
      float var7 = (float)var5.field_72448_b;
      float var8 = (float)var5.field_72449_c;
      Vec3 var9 = var2.func_72948_g(p_78466_1_);
      this.field_78518_n = (float)var9.field_72450_a;
      this.field_78519_o = (float)var9.field_72448_b;
      this.field_78533_p = (float)var9.field_72449_c;
      float var11;
      if(this.field_78531_r.field_71474_y.field_74339_e < 2) {
         Vec3 var10 = MathHelper.func_76126_a(var2.func_72929_e(p_78466_1_)) > 0.0F?var2.func_82732_R().func_72345_a(-1.0D, 0.0D, 0.0D):var2.func_82732_R().func_72345_a(1.0D, 0.0D, 0.0D);
         var11 = (float)var3.func_70676_i(p_78466_1_).func_72430_b(var10);
         if(var11 < 0.0F) {
            var11 = 0.0F;
         }

         if(var11 > 0.0F) {
            float[] var12 = var2.field_73011_w.func_76560_a(var2.func_72826_c(p_78466_1_), p_78466_1_);
            if(var12 != null) {
               var11 *= var12[3];
               this.field_78518_n = this.field_78518_n * (1.0F - var11) + var12[0] * var11;
               this.field_78519_o = this.field_78519_o * (1.0F - var11) + var12[1] * var11;
               this.field_78533_p = this.field_78533_p * (1.0F - var11) + var12[2] * var11;
            }
         }
      }

      this.field_78518_n += (var6 - this.field_78518_n) * var4;
      this.field_78519_o += (var7 - this.field_78519_o) * var4;
      this.field_78533_p += (var8 - this.field_78533_p) * var4;
      float var19 = var2.func_72867_j(p_78466_1_);
      float var20;
      if(var19 > 0.0F) {
         var11 = 1.0F - var19 * 0.5F;
         var20 = 1.0F - var19 * 0.4F;
         this.field_78518_n *= var11;
         this.field_78519_o *= var11;
         this.field_78533_p *= var20;
      }

      var11 = var2.func_72819_i(p_78466_1_);
      if(var11 > 0.0F) {
         var20 = 1.0F - var11 * 0.5F;
         this.field_78518_n *= var20;
         this.field_78519_o *= var20;
         this.field_78533_p *= var20;
      }

      int var21 = ActiveRenderInfo.func_74584_a(this.field_78531_r.field_71441_e, var3, p_78466_1_);
      if(this.field_78500_U) {
         Vec3 var13 = var2.func_72824_f(p_78466_1_);
         this.field_78518_n = (float)var13.field_72450_a;
         this.field_78519_o = (float)var13.field_72448_b;
         this.field_78533_p = (float)var13.field_72449_c;
      } else if(var21 != 0 && Block.field_71973_m[var21].field_72018_cp == Material.field_76244_g) {
         this.field_78518_n = 0.02F;
         this.field_78519_o = 0.02F;
         this.field_78533_p = 0.2F;
      } else if(var21 != 0 && Block.field_71973_m[var21].field_72018_cp == Material.field_76256_h) {
         this.field_78518_n = 0.6F;
         this.field_78519_o = 0.1F;
         this.field_78533_p = 0.0F;
      }

      float var22 = this.field_78535_ad + (this.field_78539_ae - this.field_78535_ad) * p_78466_1_;
      this.field_78518_n *= var22;
      this.field_78519_o *= var22;
      this.field_78533_p *= var22;
      double var14 = (var3.field_70137_T + (var3.field_70163_u - var3.field_70137_T) * (double)p_78466_1_) * var2.field_73011_w.func_76565_k();
      if(var3.func_70644_a(Potion.field_76440_q)) {
         int var16 = var3.func_70660_b(Potion.field_76440_q).func_76459_b();
         if(var16 < 20) {
            var14 *= (double)(1.0F - (float)var16 / 20.0F);
         } else {
            var14 = 0.0D;
         }
      }

      if(var14 < 1.0D) {
         if(var14 < 0.0D) {
            var14 = 0.0D;
         }

         var14 *= var14;
         this.field_78518_n = (float)((double)this.field_78518_n * var14);
         this.field_78519_o = (float)((double)this.field_78519_o * var14);
         this.field_78533_p = (float)((double)this.field_78533_p * var14);
      }

      float var23;
      if(this.field_82831_U > 0.0F) {
         var23 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78466_1_;
         this.field_78518_n = this.field_78518_n * (1.0F - var23) + this.field_78518_n * 0.7F * var23;
         this.field_78519_o = this.field_78519_o * (1.0F - var23) + this.field_78519_o * 0.6F * var23;
         this.field_78533_p = this.field_78533_p * (1.0F - var23) + this.field_78533_p * 0.6F * var23;
      }

      float var17;
      if(var3.func_70644_a(Potion.field_76439_r)) {
         var23 = this.func_82830_a(this.field_78531_r.field_71439_g, p_78466_1_);
         var17 = 1.0F / this.field_78518_n;
         if(var17 > 1.0F / this.field_78519_o) {
            var17 = 1.0F / this.field_78519_o;
         }

         if(var17 > 1.0F / this.field_78533_p) {
            var17 = 1.0F / this.field_78533_p;
         }

         this.field_78518_n = this.field_78518_n * (1.0F - var23) + this.field_78518_n * var17 * var23;
         this.field_78519_o = this.field_78519_o * (1.0F - var23) + this.field_78519_o * var17 * var23;
         this.field_78533_p = this.field_78533_p * (1.0F - var23) + this.field_78533_p * var17 * var23;
      }

      if(this.field_78531_r.field_71474_y.field_74337_g) {
         var23 = (this.field_78518_n * 30.0F + this.field_78519_o * 59.0F + this.field_78533_p * 11.0F) / 100.0F;
         var17 = (this.field_78518_n * 30.0F + this.field_78519_o * 70.0F) / 100.0F;
         float var18 = (this.field_78518_n * 30.0F + this.field_78533_p * 70.0F) / 100.0F;
         this.field_78518_n = var23;
         this.field_78519_o = var17;
         this.field_78533_p = var18;
      }

      GL11.glClearColor(this.field_78518_n, this.field_78519_o, this.field_78533_p, 0.0F);
   }

   private void func_78468_a(int p_78468_1_, float p_78468_2_) {
      EntityLiving var3 = this.field_78531_r.field_71451_h;
      boolean var4 = false;
      if(var3 instanceof EntityPlayer) {
         var4 = ((EntityPlayer)var3).field_71075_bZ.field_75098_d;
      }

      if(p_78468_1_ == 999) {
         GL11.glFog(2918, this.func_78469_a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glFogi(2917, 9729);
         GL11.glFogf(2915, 0.0F);
         GL11.glFogf(2916, 8.0F);
         if(GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi('\u855a', '\u855b');
         }

         GL11.glFogf(2915, 0.0F);
      } else {
         GL11.glFog(2918, this.func_78469_a(this.field_78518_n, this.field_78519_o, this.field_78533_p, 1.0F));
         GL11.glNormal3f(0.0F, -1.0F, 0.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var5 = ActiveRenderInfo.func_74584_a(this.field_78531_r.field_71441_e, var3, p_78468_2_);
         float var6;
         if(var3.func_70644_a(Potion.field_76440_q)) {
            var6 = 5.0F;
            int var7 = var3.func_70660_b(Potion.field_76440_q).func_76459_b();
            if(var7 < 20) {
               var6 = 5.0F + (this.field_78530_s - 5.0F) * (1.0F - (float)var7 / 20.0F);
            }

            GL11.glFogi(2917, 9729);
            if(p_78468_1_ < 0) {
               GL11.glFogf(2915, 0.0F);
               GL11.glFogf(2916, var6 * 0.8F);
            } else {
               GL11.glFogf(2915, var6 * 0.25F);
               GL11.glFogf(2916, var6);
            }

            if(GLContext.getCapabilities().GL_NV_fog_distance) {
               GL11.glFogi('\u855a', '\u855b');
            }
         } else {
            float var8;
            float var9;
            float var10;
            float var11;
            float var12;
            if(this.field_78500_U) {
               GL11.glFogi(2917, 2048);
               GL11.glFogf(2914, 0.1F);
               var6 = 1.0F;
               var12 = 1.0F;
               var8 = 1.0F;
               if(this.field_78531_r.field_71474_y.field_74337_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else if(var5 > 0 && Block.field_71973_m[var5].field_72018_cp == Material.field_76244_g) {
               GL11.glFogi(2917, 2048);
               if(var3.func_70644_a(Potion.field_76427_o)) {
                  GL11.glFogf(2914, 0.05F);
               } else {
                  GL11.glFogf(2914, 0.1F);
               }

               var6 = 0.4F;
               var12 = 0.4F;
               var8 = 0.9F;
               if(this.field_78531_r.field_71474_y.field_74337_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else if(var5 > 0 && Block.field_71973_m[var5].field_72018_cp == Material.field_76256_h) {
               GL11.glFogi(2917, 2048);
               GL11.glFogf(2914, 2.0F);
               var6 = 0.4F;
               var12 = 0.3F;
               var8 = 0.3F;
               if(this.field_78531_r.field_71474_y.field_74337_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else {
               var6 = this.field_78530_s;
               if(this.field_78531_r.field_71441_e.field_73011_w.func_76564_j() && !var4) {
                  double var13 = (double)((var3.func_70070_b(p_78468_2_) & 15728640) >> 20) / 16.0D + (var3.field_70137_T + (var3.field_70163_u - var3.field_70137_T) * (double)p_78468_2_ + 4.0D) / 32.0D;
                  if(var13 < 1.0D) {
                     if(var13 < 0.0D) {
                        var13 = 0.0D;
                     }

                     var13 *= var13;
                     var9 = 100.0F * (float)var13;
                     if(var9 < 5.0F) {
                        var9 = 5.0F;
                     }

                     if(var6 > var9) {
                        var6 = var9;
                     }
                  }
               }

               GL11.glFogi(2917, 9729);
               if(p_78468_1_ < 0) {
                  GL11.glFogf(2915, 0.0F);
                  GL11.glFogf(2916, var6 * 0.8F);
               } else {
                  GL11.glFogf(2915, var6 * 0.25F);
                  GL11.glFogf(2916, var6);
               }

               if(GLContext.getCapabilities().GL_NV_fog_distance) {
                  GL11.glFogi('\u855a', '\u855b');
               }

               if(this.field_78531_r.field_71441_e.field_73011_w.func_76568_b((int)var3.field_70165_t, (int)var3.field_70161_v)) {
                  GL11.glFogf(2915, var6 * 0.05F);
                  GL11.glFogf(2916, Math.min(var6, 192.0F) * 0.5F);
               }
            }
         }

         GL11.glEnable(2903);
         GL11.glColorMaterial(1028, 4608);
      }
   }

   private FloatBuffer func_78469_a(float p_78469_1_, float p_78469_2_, float p_78469_3_, float p_78469_4_) {
      this.field_78521_m.clear();
      this.field_78521_m.put(p_78469_1_).put(p_78469_2_).put(p_78469_3_).put(p_78469_4_);
      this.field_78521_m.flip();
      return this.field_78521_m;
   }

   public static int func_78465_a(int p_78465_0_) {
      short var1 = 200;
      if(p_78465_0_ == 1) {
         var1 = 120;
      }

      if(p_78465_0_ == 2) {
         var1 = 35;
      }

      return var1;
   }

   // $FF: synthetic method
   static Minecraft func_90030_a(EntityRenderer p_90030_0_) {
      return p_90030_0_.field_78531_r;
   }

}
