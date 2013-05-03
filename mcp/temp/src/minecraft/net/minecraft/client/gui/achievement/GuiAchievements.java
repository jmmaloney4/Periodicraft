package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiAchievements extends GuiScreen {

   private static final int field_74122_s = AchievementList.field_76010_a * 24 - 112;
   private static final int field_74121_t = AchievementList.field_76008_b * 24 - 112;
   private static final int field_74120_u = AchievementList.field_76009_c * 24 - 77;
   private static final int field_74119_v = AchievementList.field_76006_d * 24 - 77;
   protected int field_74114_a = 256;
   protected int field_74112_b = 202;
   protected int field_74113_c = 0;
   protected int field_74111_d = 0;
   protected double field_74117_m;
   protected double field_74115_n;
   protected double field_74116_o;
   protected double field_74125_p;
   protected double field_74124_q;
   protected double field_74123_r;
   private int field_74118_w = 0;
   private StatFileWriter field_74126_x;


   public GuiAchievements(StatFileWriter p_i3070_1_) {
      this.field_74126_x = p_i3070_1_;
      short var2 = 141;
      short var3 = 141;
      this.field_74117_m = this.field_74116_o = this.field_74124_q = (double)(AchievementList.field_76004_f.field_75993_a * 24 - var2 / 2 - 12);
      this.field_74115_n = this.field_74125_p = this.field_74123_r = (double)(AchievementList.field_76004_f.field_75991_b * 24 - var3 / 2);
   }

   public void func_73866_w_() {
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiSmallButton(1, this.field_73880_f / 2 + 24, this.field_73881_g / 2 + 74, 80, 20, StatCollector.func_74838_a("gui.done")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
         this.field_73882_e.func_71381_h();
      }

      super.func_73875_a(p_73875_1_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == this.field_73882_e.field_71474_y.field_74315_B.field_74512_d) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
         this.field_73882_e.func_71381_h();
      } else {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      if(Mouse.isButtonDown(0)) {
         int var4 = (this.field_73880_f - this.field_74114_a) / 2;
         int var5 = (this.field_73881_g - this.field_74112_b) / 2;
         int var6 = var4 + 8;
         int var7 = var5 + 17;
         if((this.field_74118_w == 0 || this.field_74118_w == 1) && p_73863_1_ >= var6 && p_73863_1_ < var6 + 224 && p_73863_2_ >= var7 && p_73863_2_ < var7 + 155) {
            if(this.field_74118_w == 0) {
               this.field_74118_w = 1;
            } else {
               this.field_74116_o -= (double)(p_73863_1_ - this.field_74113_c);
               this.field_74125_p -= (double)(p_73863_2_ - this.field_74111_d);
               this.field_74124_q = this.field_74117_m = this.field_74116_o;
               this.field_74123_r = this.field_74115_n = this.field_74125_p;
            }

            this.field_74113_c = p_73863_1_;
            this.field_74111_d = p_73863_2_;
         }

         if(this.field_74124_q < (double)field_74122_s) {
            this.field_74124_q = (double)field_74122_s;
         }

         if(this.field_74123_r < (double)field_74121_t) {
            this.field_74123_r = (double)field_74121_t;
         }

         if(this.field_74124_q >= (double)field_74120_u) {
            this.field_74124_q = (double)(field_74120_u - 1);
         }

         if(this.field_74123_r >= (double)field_74119_v) {
            this.field_74123_r = (double)(field_74119_v - 1);
         }
      } else {
         this.field_74118_w = 0;
      }

      this.func_73873_v_();
      this.func_74110_b(p_73863_1_, p_73863_2_, p_73863_3_);
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      this.func_74109_g();
      GL11.glEnable(2896);
      GL11.glEnable(2929);
   }

   public void func_73876_c() {
      this.field_74117_m = this.field_74116_o;
      this.field_74115_n = this.field_74125_p;
      double var1 = this.field_74124_q - this.field_74116_o;
      double var3 = this.field_74123_r - this.field_74125_p;
      if(var1 * var1 + var3 * var3 < 4.0D) {
         this.field_74116_o += var1;
         this.field_74125_p += var3;
      } else {
         this.field_74116_o += var1 * 0.85D;
         this.field_74125_p += var3 * 0.85D;
      }

   }

   protected void func_74109_g() {
      int var1 = (this.field_73880_f - this.field_74114_a) / 2;
      int var2 = (this.field_73881_g - this.field_74112_b) / 2;
      this.field_73886_k.func_78276_b("Achievements", var1 + 15, var2 + 5, 4210752);
   }

   protected void func_74110_b(int p_74110_1_, int p_74110_2_, float p_74110_3_) {
      int var4 = MathHelper.func_76128_c(this.field_74117_m + (this.field_74116_o - this.field_74117_m) * (double)p_74110_3_);
      int var5 = MathHelper.func_76128_c(this.field_74115_n + (this.field_74125_p - this.field_74115_n) * (double)p_74110_3_);
      if(var4 < field_74122_s) {
         var4 = field_74122_s;
      }

      if(var5 < field_74121_t) {
         var5 = field_74121_t;
      }

      if(var4 >= field_74120_u) {
         var4 = field_74120_u - 1;
      }

      if(var5 >= field_74119_v) {
         var5 = field_74119_v - 1;
      }

      int var6 = (this.field_73880_f - this.field_74114_a) / 2;
      int var7 = (this.field_73881_g - this.field_74112_b) / 2;
      int var8 = var6 + 16;
      int var9 = var7 + 17;
      this.field_73735_i = 0.0F;
      GL11.glDepthFunc(518);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, -200.0F);
      GL11.glEnable(3553);
      GL11.glDisable(2896);
      GL11.glEnable('\u803a');
      GL11.glEnable(2903);
      this.field_73882_e.field_71446_o.func_98187_b("/terrain.png");
      int var10 = var4 + 288 >> 4;
      int var11 = var5 + 288 >> 4;
      int var12 = (var4 + 288) % 16;
      int var13 = (var5 + 288) % 16;
      Random var19 = new Random();

      int var20;
      int var23;
      int var22;
      for(var20 = 0; var20 * 16 - var13 < 155; ++var20) {
         float var21 = 0.6F - (float)(var11 + var20) / 25.0F * 0.3F;
         GL11.glColor4f(var21, var21, var21, 1.0F);

         for(var22 = 0; var22 * 16 - var12 < 224; ++var22) {
            var19.setSeed((long)(1234 + var10 + var22));
            var19.nextInt();
            var23 = var19.nextInt(1 + var11 + var20) + (var11 + var20) / 2;
            Icon var24 = Block.field_71939_E.func_71858_a(0, 0);
            if(var23 <= 37 && var11 + var20 != 35) {
               if(var23 == 22) {
                  if(var19.nextInt(2) == 0) {
                     var24 = Block.field_72073_aw.func_71858_a(0, 0);
                  } else {
                     var24 = Block.field_72047_aN.func_71858_a(0, 0);
                  }
               } else if(var23 == 10) {
                  var24 = Block.field_71949_H.func_71858_a(0, 0);
               } else if(var23 == 8) {
                  var24 = Block.field_71950_I.func_71858_a(0, 0);
               } else if(var23 > 4) {
                  var24 = Block.field_71981_t.func_71858_a(0, 0);
               } else if(var23 > 0) {
                  var24 = Block.field_71979_v.func_71858_a(0, 0);
               }
            } else {
               var24 = Block.field_71986_z.func_71858_a(0, 0);
            }

            this.func_94065_a(var8 + var22 * 16 - var12, var9 + var20 * 16 - var13, var24, 16, 16);
         }
      }

      GL11.glEnable(2929);
      GL11.glDepthFunc(515);
      GL11.glDisable(3553);

      int var25;
      int var28;
      int var41;
      for(var20 = 0; var20 < AchievementList.field_76007_e.size(); ++var20) {
         Achievement var31 = (Achievement)AchievementList.field_76007_e.get(var20);
         if(var31.field_75992_c != null) {
            var22 = var31.field_75993_a * 24 - var4 + 11 + var8;
            var23 = var31.field_75991_b * 24 - var5 + 11 + var9;
            var41 = var31.field_75992_c.field_75993_a * 24 - var4 + 11 + var8;
            var25 = var31.field_75992_c.field_75991_b * 24 - var5 + 11 + var9;
            boolean var26 = this.field_74126_x.func_77443_a(var31);
            boolean var27 = this.field_74126_x.func_77442_b(var31);
            var28 = Math.sin((double)(Minecraft.func_71386_F() % 600L) / 600.0D * 3.141592653589793D * 2.0D) > 0.6D?255:130;
            int var29 = -16777216;
            if(var26) {
               var29 = -9408400;
            } else if(var27) {
               var29 = '\uff00' + (var28 << 24);
            }

            this.func_73730_a(var22, var41, var23, var29);
            this.func_73728_b(var41, var23, var25, var29);
         }
      }

      Achievement var30 = null;
      RenderItem var32 = new RenderItem();
      RenderHelper.func_74520_c();
      GL11.glDisable(2896);
      GL11.glEnable('\u803a');
      GL11.glEnable(2903);

      int var39;
      int var40;
      for(var22 = 0; var22 < AchievementList.field_76007_e.size(); ++var22) {
         Achievement var34 = (Achievement)AchievementList.field_76007_e.get(var22);
         var41 = var34.field_75993_a * 24 - var4;
         var25 = var34.field_75991_b * 24 - var5;
         if(var41 >= -24 && var25 >= -24 && var41 <= 224 && var25 <= 155) {
            float var38;
            if(this.field_74126_x.func_77443_a(var34)) {
               var38 = 1.0F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            } else if(this.field_74126_x.func_77442_b(var34)) {
               var38 = Math.sin((double)(Minecraft.func_71386_F() % 600L) / 600.0D * 3.141592653589793D * 2.0D) < 0.6D?0.6F:0.8F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            } else {
               var38 = 0.3F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            }

            this.field_73882_e.field_71446_o.func_98187_b("/achievement/bg.png");
            var40 = var8 + var41;
            var39 = var9 + var25;
            if(var34.func_75984_f()) {
               this.func_73729_b(var40 - 2, var39 - 2, 26, 202, 26, 26);
            } else {
               this.func_73729_b(var40 - 2, var39 - 2, 0, 202, 26, 26);
            }

            if(!this.field_74126_x.func_77442_b(var34)) {
               float var37 = 0.1F;
               GL11.glColor4f(var37, var37, var37, 1.0F);
               var32.field_77024_a = false;
            }

            GL11.glEnable(2896);
            GL11.glEnable(2884);
            var32.func_82406_b(this.field_73882_e.field_71466_p, this.field_73882_e.field_71446_o, var34.field_75990_d, var40 + 3, var39 + 3);
            GL11.glDisable(2896);
            if(!this.field_74126_x.func_77442_b(var34)) {
               var32.field_77024_a = true;
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(p_74110_1_ >= var8 && p_74110_2_ >= var9 && p_74110_1_ < var8 + 224 && p_74110_2_ < var9 + 155 && p_74110_1_ >= var40 && p_74110_1_ <= var40 + 22 && p_74110_2_ >= var39 && p_74110_2_ <= var39 + 22) {
               var30 = var34;
            }
         }
      }

      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/achievement/bg.png");
      this.func_73729_b(var6, var7, 0, 0, this.field_74114_a, this.field_74112_b);
      GL11.glPopMatrix();
      this.field_73735_i = 0.0F;
      GL11.glDepthFunc(515);
      GL11.glDisable(2929);
      GL11.glEnable(3553);
      super.func_73863_a(p_74110_1_, p_74110_2_, p_74110_3_);
      if(var30 != null) {
         String var33 = StatCollector.func_74838_a(var30.func_75970_i());
         String var35 = var30.func_75989_e();
         var41 = p_74110_1_ + 12;
         var25 = p_74110_2_ - 4;
         if(this.field_74126_x.func_77442_b(var30)) {
            var40 = Math.max(this.field_73886_k.func_78256_a(var33), 120);
            var39 = this.field_73886_k.func_78267_b(var35, var40);
            if(this.field_74126_x.func_77443_a(var30)) {
               var39 += 12;
            }

            this.func_73733_a(var41 - 3, var25 - 3, var41 + var40 + 3, var25 + var39 + 3 + 12, -1073741824, -1073741824);
            this.field_73886_k.func_78279_b(var35, var41, var25 + 12, var40, -6250336);
            if(this.field_74126_x.func_77443_a(var30)) {
               this.field_73886_k.func_78261_a(StatCollector.func_74838_a("achievement.taken"), var41, var25 + var39 + 4, -7302913);
            }
         } else {
            var40 = Math.max(this.field_73886_k.func_78256_a(var33), 120);
            String var36 = StatCollector.func_74837_a("achievement.requires", new Object[]{StatCollector.func_74838_a(var30.field_75992_c.func_75970_i())});
            var28 = this.field_73886_k.func_78267_b(var36, var40);
            this.func_73733_a(var41 - 3, var25 - 3, var41 + var40 + 3, var25 + var28 + 12 + 3, -1073741824, -1073741824);
            this.field_73886_k.func_78279_b(var36, var41, var25 + 12, var40, -9416624);
         }

         this.field_73886_k.func_78261_a(var33, var41, var25, this.field_74126_x.func_77442_b(var30)?(var30.func_75984_f()?-128:-1):(var30.func_75984_f()?-8355776:-8355712));
      }

      GL11.glEnable(2929);
      GL11.glEnable(2896);
      RenderHelper.func_74518_a();
   }

   public boolean func_73868_f() {
      return true;
   }

}
