package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiPlayerInfo;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiIngame extends Gui {

   private static final RenderItem field_73841_b = new RenderItem();
   private final Random field_73842_c = new Random();
   private final Minecraft field_73839_d;
   private final GuiNewChat field_73840_e;
   private int field_73837_f = 0;
   private String field_73838_g = "";
   private int field_73845_h = 0;
   private boolean field_73844_j = false;
   public float field_73843_a = 1.0F;
   private int field_92017_k;
   private ItemStack field_92016_l;


   public GuiIngame(Minecraft p_i3037_1_) {
      this.field_73839_d = p_i3037_1_;
      this.field_73840_e = new GuiNewChat(p_i3037_1_);
   }

   public void func_73830_a(float p_73830_1_, boolean p_73830_2_, int p_73830_3_, int p_73830_4_) {
      ScaledResolution var5 = new ScaledResolution(this.field_73839_d.field_71474_y, this.field_73839_d.field_71443_c, this.field_73839_d.field_71440_d);
      int var6 = var5.func_78326_a();
      int var7 = var5.func_78328_b();
      FontRenderer var8 = this.field_73839_d.field_71466_p;
      this.field_73839_d.field_71460_t.func_78478_c();
      GL11.glEnable(3042);
      if(Minecraft.func_71375_t()) {
         this.func_73829_a(this.field_73839_d.field_71439_g.func_70013_c(p_73830_1_), var6, var7);
      } else {
         GL11.glBlendFunc(770, 771);
      }

      ItemStack var9 = this.field_73839_d.field_71439_g.field_71071_by.func_70440_f(3);
      if(this.field_73839_d.field_71474_y.field_74320_O == 0 && var9 != null && var9.field_77993_c == Block.field_72061_ba.field_71990_ca) {
         this.func_73836_a(var6, var7);
      }

      if(!this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76431_k)) {
         float var10 = this.field_73839_d.field_71439_g.field_71080_cy + (this.field_73839_d.field_71439_g.field_71086_bY - this.field_73839_d.field_71439_g.field_71080_cy) * p_73830_1_;
         if(var10 > 0.0F) {
            this.func_73835_b(var10, var6, var7);
         }
      }

      boolean var11;
      int var12;
      int var13;
      int var17;
      int var16;
      int var18;
      int var20;
      int var23;
      int var22;
      int var24;
      byte var27;
      int var26;
      int var47;
      int var50;
      if(!this.field_73839_d.field_71442_b.func_78747_a()) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_73839_d.field_71446_o.func_98187_b("/gui/gui.png");
         InventoryPlayer var31 = this.field_73839_d.field_71439_g.field_71071_by;
         this.field_73735_i = -90.0F;
         this.func_73729_b(var6 / 2 - 91, var7 - 22, 0, 0, 182, 22);
         this.func_73729_b(var6 / 2 - 91 - 1 + var31.field_70461_c * 20, var7 - 22 - 1, 0, 22, 24, 22);
         this.field_73839_d.field_71446_o.func_98187_b("/gui/icons.png");
         GL11.glEnable(3042);
         GL11.glBlendFunc(775, 769);
         this.func_73729_b(var6 / 2 - 7, var7 / 2 - 7, 0, 0, 16, 16);
         GL11.glDisable(3042);
         var11 = this.field_73839_d.field_71439_g.field_70172_ad / 3 % 2 == 1;
         if(this.field_73839_d.field_71439_g.field_70172_ad < 10) {
            var11 = false;
         }

         var12 = this.field_73839_d.field_71439_g.func_70630_aN();
         var13 = this.field_73839_d.field_71439_g.field_70735_aL;
         this.field_73842_c.setSeed((long)(this.field_73837_f * 312871));
         boolean var14 = false;
         FoodStats var15 = this.field_73839_d.field_71439_g.func_71024_bL();
         var16 = var15.func_75116_a();
         var17 = var15.func_75120_b();
         this.field_73839_d.field_71424_I.func_76320_a("bossHealth");
         this.func_73828_d();
         this.field_73839_d.field_71424_I.func_76319_b();
         int var19;
         if(this.field_73839_d.field_71442_b.func_78755_b()) {
            var18 = var6 / 2 - 91;
            var19 = var6 / 2 + 91;
            this.field_73839_d.field_71424_I.func_76320_a("expBar");
            var20 = this.field_73839_d.field_71439_g.func_71050_bK();
            if(var20 > 0) {
               short var21 = 182;
               var22 = (int)(this.field_73839_d.field_71439_g.field_71106_cc * (float)(var21 + 1));
               var23 = var7 - 32 + 3;
               this.func_73729_b(var18, var23, 0, 64, var21, 5);
               if(var22 > 0) {
                  this.func_73729_b(var18, var23, 0, 69, var22, 5);
               }
            }

            var47 = var7 - 39;
            var22 = var47 - 10;
            var23 = this.field_73839_d.field_71439_g.func_70658_aO();
            var24 = -1;
            if(this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76428_l)) {
               var24 = this.field_73837_f % 25;
            }

            this.field_73839_d.field_71424_I.func_76318_c("healthArmor");

            int var25;
            int var29;
            int var28;
            for(var25 = 0; var25 < 10; ++var25) {
               if(var23 > 0) {
                  var26 = var18 + var25 * 8;
                  if(var25 * 2 + 1 < var23) {
                     this.func_73729_b(var26, var22, 34, 9, 9, 9);
                  }

                  if(var25 * 2 + 1 == var23) {
                     this.func_73729_b(var26, var22, 25, 9, 9, 9);
                  }

                  if(var25 * 2 + 1 > var23) {
                     this.func_73729_b(var26, var22, 16, 9, 9, 9);
                  }
               }

               var26 = 16;
               if(this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76436_u)) {
                  var26 += 36;
               } else if(this.field_73839_d.field_71439_g.func_70644_a(Potion.field_82731_v)) {
                  var26 += 72;
               }

               var27 = 0;
               if(var11) {
                  var27 = 1;
               }

               var28 = var18 + var25 * 8;
               var29 = var47;
               if(var12 <= 4) {
                  var29 = var47 + this.field_73842_c.nextInt(2);
               }

               if(var25 == var24) {
                  var29 -= 2;
               }

               byte var30 = 0;
               if(this.field_73839_d.field_71441_e.func_72912_H().func_76093_s()) {
                  var30 = 5;
               }

               this.func_73729_b(var28, var29, 16 + var27 * 9, 9 * var30, 9, 9);
               if(var11) {
                  if(var25 * 2 + 1 < var13) {
                     this.func_73729_b(var28, var29, var26 + 54, 9 * var30, 9, 9);
                  }

                  if(var25 * 2 + 1 == var13) {
                     this.func_73729_b(var28, var29, var26 + 63, 9 * var30, 9, 9);
                  }
               }

               if(var25 * 2 + 1 < var12) {
                  this.func_73729_b(var28, var29, var26 + 36, 9 * var30, 9, 9);
               }

               if(var25 * 2 + 1 == var12) {
                  this.func_73729_b(var28, var29, var26 + 45, 9 * var30, 9, 9);
               }
            }

            this.field_73839_d.field_71424_I.func_76318_c("food");

            for(var25 = 0; var25 < 10; ++var25) {
               var26 = var47;
               var50 = 16;
               byte var51 = 0;
               if(this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76438_s)) {
                  var50 += 36;
                  var51 = 13;
               }

               if(this.field_73839_d.field_71439_g.func_71024_bL().func_75115_e() <= 0.0F && this.field_73837_f % (var16 * 3 + 1) == 0) {
                  var26 = var47 + (this.field_73842_c.nextInt(3) - 1);
               }

               if(var14) {
                  var51 = 1;
               }

               var29 = var19 - var25 * 8 - 9;
               this.func_73729_b(var29, var26, 16 + var51 * 9, 27, 9, 9);
               if(var14) {
                  if(var25 * 2 + 1 < var17) {
                     this.func_73729_b(var29, var26, var50 + 54, 27, 9, 9);
                  }

                  if(var25 * 2 + 1 == var17) {
                     this.func_73729_b(var29, var26, var50 + 63, 27, 9, 9);
                  }
               }

               if(var25 * 2 + 1 < var16) {
                  this.func_73729_b(var29, var26, var50 + 36, 27, 9, 9);
               }

               if(var25 * 2 + 1 == var16) {
                  this.func_73729_b(var29, var26, var50 + 45, 27, 9, 9);
               }
            }

            this.field_73839_d.field_71424_I.func_76318_c("air");
            if(this.field_73839_d.field_71439_g.func_70055_a(Material.field_76244_g)) {
               var25 = this.field_73839_d.field_71439_g.func_70086_ai();
               var26 = MathHelper.func_76143_f((double)(var25 - 2) * 10.0D / 300.0D);
               var50 = MathHelper.func_76143_f((double)var25 * 10.0D / 300.0D) - var26;

               for(var28 = 0; var28 < var26 + var50; ++var28) {
                  if(var28 < var26) {
                     this.func_73729_b(var19 - var28 * 8 - 9, var22, 16, 18, 9, 9);
                  } else {
                     this.func_73729_b(var19 - var28 * 8 - 9, var22, 25, 18, 9, 9);
                  }
               }
            }

            this.field_73839_d.field_71424_I.func_76319_b();
         }

         GL11.glDisable(3042);
         this.field_73839_d.field_71424_I.func_76320_a("actionBar");
         GL11.glEnable('\u803a');
         RenderHelper.func_74520_c();

         for(var18 = 0; var18 < 9; ++var18) {
            var19 = var6 / 2 - 90 + var18 * 20 + 2;
            var20 = var7 - 16 - 3;
            this.func_73832_a(var18, var19, var20, p_73830_1_);
         }

         RenderHelper.func_74518_a();
         GL11.glDisable('\u803a');
         this.field_73839_d.field_71424_I.func_76319_b();
      }

      float var33;
      if(this.field_73839_d.field_71439_g.func_71060_bI() > 0) {
         this.field_73839_d.field_71424_I.func_76320_a("sleep");
         GL11.glDisable(2929);
         GL11.glDisable(3008);
         int var32 = this.field_73839_d.field_71439_g.func_71060_bI();
         var33 = (float)var32 / 100.0F;
         if(var33 > 1.0F) {
            var33 = 1.0F - (float)(var32 - 100) / 10.0F;
         }

         var12 = (int)(220.0F * var33) << 24 | 1052704;
         func_73734_a(0, 0, var6, var7, var12);
         GL11.glEnable(3008);
         GL11.glEnable(2929);
         this.field_73839_d.field_71424_I.func_76319_b();
      }

      int var38;
      int var37;
      if(this.field_73839_d.field_71442_b.func_78763_f() && this.field_73839_d.field_71439_g.field_71068_ca > 0) {
         this.field_73839_d.field_71424_I.func_76320_a("expLevel");
         var11 = false;
         var12 = var11?16777215:8453920;
         String var34 = "" + this.field_73839_d.field_71439_g.field_71068_ca;
         var38 = (var6 - var8.func_78256_a(var34)) / 2;
         var37 = var7 - 31 - 4;
         var8.func_78276_b(var34, var38 + 1, var37, 0);
         var8.func_78276_b(var34, var38 - 1, var37, 0);
         var8.func_78276_b(var34, var38, var37 + 1, 0);
         var8.func_78276_b(var34, var38, var37 - 1, 0);
         var8.func_78276_b(var34, var38, var37, var12);
         this.field_73839_d.field_71424_I.func_76319_b();
      }

      String var35;
      if(this.field_73839_d.field_71474_y.field_92117_D) {
         this.field_73839_d.field_71424_I.func_76320_a("toolHighlight");
         if(this.field_92017_k > 0 && this.field_92016_l != null) {
            var35 = this.field_92016_l.func_82833_r();
            var12 = (var6 - var8.func_78256_a(var35)) / 2;
            var13 = var7 - 59;
            if(!this.field_73839_d.field_71442_b.func_78755_b()) {
               var13 += 14;
            }

            var38 = (int)((float)this.field_92017_k * 256.0F / 10.0F);
            if(var38 > 255) {
               var38 = 255;
            }

            if(var38 > 0) {
               GL11.glPushMatrix();
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               var8.func_78261_a(var35, var12, var13, 16777215 + (var38 << 24));
               GL11.glDisable(3042);
               GL11.glPopMatrix();
            }
         }

         this.field_73839_d.field_71424_I.func_76319_b();
      }

      if(this.field_73839_d.func_71355_q()) {
         this.field_73839_d.field_71424_I.func_76320_a("demo");
         var35 = "";
         if(this.field_73839_d.field_71441_e.func_82737_E() >= 120500L) {
            var35 = StatCollector.func_74838_a("demo.demoExpired");
         } else {
            var35 = String.format(StatCollector.func_74838_a("demo.remainingTime"), new Object[]{StringUtils.func_76337_a((int)(120500L - this.field_73839_d.field_71441_e.func_82737_E()))});
         }

         var12 = var8.func_78256_a(var35);
         var8.func_78261_a(var35, var6 - var12 - 10, 5, 16777215);
         this.field_73839_d.field_71424_I.func_76319_b();
      }

      if(this.field_73839_d.field_71474_y.field_74330_P) {
         this.field_73839_d.field_71424_I.func_76320_a("debug");
         GL11.glPushMatrix();
         var8.func_78261_a("Minecraft 1.5.1 (" + this.field_73839_d.field_71426_K + ")", 2, 2, 16777215);
         var8.func_78261_a(this.field_73839_d.func_71393_m(), 2, 12, 16777215);
         var8.func_78261_a(this.field_73839_d.func_71408_n(), 2, 22, 16777215);
         var8.func_78261_a(this.field_73839_d.func_71374_p(), 2, 32, 16777215);
         var8.func_78261_a(this.field_73839_d.func_71388_o(), 2, 42, 16777215);
         long var36 = Runtime.getRuntime().maxMemory();
         long var40 = Runtime.getRuntime().totalMemory();
         long var43 = Runtime.getRuntime().freeMemory();
         long var44 = var40 - var43;
         String var46 = "Used memory: " + var44 * 100L / var36 + "% (" + var44 / 1024L / 1024L + "MB) of " + var36 / 1024L / 1024L + "MB";
         this.func_73731_b(var8, var46, var6 - var8.func_78256_a(var46) - 2, 2, 14737632);
         var46 = "Allocated memory: " + var40 * 100L / var36 + "% (" + var40 / 1024L / 1024L + "MB)";
         this.func_73731_b(var8, var46, var6 - var8.func_78256_a(var46) - 2, 12, 14737632);
         var47 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70165_t);
         var22 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70163_u);
         var23 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70161_v);
         this.func_73731_b(var8, String.format("x: %.5f (%d) // c: %d (%d)", new Object[]{Double.valueOf(this.field_73839_d.field_71439_g.field_70165_t), Integer.valueOf(var47), Integer.valueOf(var47 >> 4), Integer.valueOf(var47 & 15)}), 2, 64, 14737632);
         this.func_73731_b(var8, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[]{Double.valueOf(this.field_73839_d.field_71439_g.field_70121_D.field_72338_b), Double.valueOf(this.field_73839_d.field_71439_g.field_70163_u)}), 2, 72, 14737632);
         this.func_73731_b(var8, String.format("z: %.5f (%d) // c: %d (%d)", new Object[]{Double.valueOf(this.field_73839_d.field_71439_g.field_70161_v), Integer.valueOf(var23), Integer.valueOf(var23 >> 4), Integer.valueOf(var23 & 15)}), 2, 80, 14737632);
         var24 = MathHelper.func_76128_c((double)(this.field_73839_d.field_71439_g.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
         this.func_73731_b(var8, "f: " + var24 + " (" + Direction.field_82373_c[var24] + ") / " + MathHelper.func_76142_g(this.field_73839_d.field_71439_g.field_70177_z), 2, 88, 14737632);
         if(this.field_73839_d.field_71441_e != null && this.field_73839_d.field_71441_e.func_72899_e(var47, var22, var23)) {
            Chunk var52 = this.field_73839_d.field_71441_e.func_72938_d(var47, var23);
            this.func_73731_b(var8, "lc: " + (var52.func_76625_h() + 15) + " b: " + var52.func_76591_a(var47 & 15, var23 & 15, this.field_73839_d.field_71441_e.func_72959_q()).field_76791_y + " bl: " + var52.func_76614_a(EnumSkyBlock.Block, var47 & 15, var22, var23 & 15) + " sl: " + var52.func_76614_a(EnumSkyBlock.Sky, var47 & 15, var22, var23 & 15) + " rl: " + var52.func_76629_c(var47 & 15, var22, var23 & 15, 0), 2, 96, 14737632);
         }

         this.func_73731_b(var8, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[]{Float.valueOf(this.field_73839_d.field_71439_g.field_71075_bZ.func_75094_b()), Float.valueOf(this.field_73839_d.field_71439_g.field_71075_bZ.func_75093_a()), Boolean.valueOf(this.field_73839_d.field_71439_g.field_70122_E), Integer.valueOf(this.field_73839_d.field_71441_e.func_72976_f(var47, var23))}), 2, 104, 14737632);
         GL11.glPopMatrix();
         this.field_73839_d.field_71424_I.func_76319_b();
      }

      if(this.field_73845_h > 0) {
         this.field_73839_d.field_71424_I.func_76320_a("overlayMessage");
         var33 = (float)this.field_73845_h - p_73830_1_;
         var12 = (int)(var33 * 256.0F / 20.0F);
         if(var12 > 255) {
            var12 = 255;
         }

         if(var12 > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(var6 / 2), (float)(var7 - 48), 0.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            var13 = 16777215;
            if(this.field_73844_j) {
               var13 = Color.HSBtoRGB(var33 / 50.0F, 0.7F, 0.6F) & 16777215;
            }

            var8.func_78276_b(this.field_73838_g, -var8.func_78256_a(this.field_73838_g) / 2, -4, var13 + (var12 << 24));
            GL11.glDisable(3042);
            GL11.glPopMatrix();
         }

         this.field_73839_d.field_71424_I.func_76319_b();
      }

      ScoreObjective var42 = this.field_73839_d.field_71441_e.func_96441_U().func_96539_a(1);
      if(var42 != null) {
         this.func_96136_a(var42, var7, var6, var8);
      }

      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, (float)(var7 - 48), 0.0F);
      this.field_73839_d.field_71424_I.func_76320_a("chat");
      this.field_73840_e.func_73762_a(this.field_73837_f);
      this.field_73839_d.field_71424_I.func_76319_b();
      GL11.glPopMatrix();
      var42 = this.field_73839_d.field_71441_e.func_96441_U().func_96539_a(0);
      if(this.field_73839_d.field_71474_y.field_74321_H.field_74513_e && (!this.field_73839_d.func_71387_A() || this.field_73839_d.field_71439_g.field_71174_a.field_72559_c.size() > 1 || var42 != null)) {
         this.field_73839_d.field_71424_I.func_76320_a("playerList");
         NetClientHandler var39 = this.field_73839_d.field_71439_g.field_71174_a;
         List var41 = var39.field_72559_c;
         var38 = var39.field_72556_d;
         var37 = var38;

         for(var16 = 1; var37 > 20; var37 = (var38 + var16 - 1) / var16) {
            ++var16;
         }

         var17 = 300 / var16;
         if(var17 > 150) {
            var17 = 150;
         }

         var18 = (var6 - var16 * var17) / 2;
         byte var45 = 10;
         func_73734_a(var18 - 1, var45 - 1, var18 + var17 * var16, var45 + 9 * var37, Integer.MIN_VALUE);

         for(var20 = 0; var20 < var38; ++var20) {
            var47 = var18 + var20 % var16 * var17;
            var22 = var45 + var20 / var16 * 9;
            func_73734_a(var47, var22, var47 + var17 - 1, var22 + 8, 553648127);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3008);
            if(var20 < var41.size()) {
               GuiPlayerInfo var49 = (GuiPlayerInfo)var41.get(var20);
               ScorePlayerTeam var48 = this.field_73839_d.field_71441_e.func_96441_U().func_96509_i(var49.field_78831_a);
               String var53 = ScorePlayerTeam.func_96667_a(var48, var49.field_78831_a);
               var8.func_78261_a(var53, var47, var22, 16777215);
               if(var42 != null) {
                  var26 = var47 + var8.func_78256_a(var53) + 5;
                  var50 = var47 + var17 - 12 - 5;
                  if(var50 - var26 > 5) {
                     Score var56 = var42.func_96682_a().func_96529_a(var49.field_78831_a, var42);
                     String var57 = EnumChatFormatting.YELLOW + "" + var56.func_96652_c();
                     var8.func_78261_a(var57, var50 - var8.func_78256_a(var57), var22, 16777215);
                  }
               }

               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               this.field_73839_d.field_71446_o.func_98187_b("/gui/icons.png");
               byte var55 = 0;
               boolean var54 = false;
               if(var49.field_78829_b < 0) {
                  var27 = 5;
               } else if(var49.field_78829_b < 150) {
                  var27 = 0;
               } else if(var49.field_78829_b < 300) {
                  var27 = 1;
               } else if(var49.field_78829_b < 600) {
                  var27 = 2;
               } else if(var49.field_78829_b < 1000) {
                  var27 = 3;
               } else {
                  var27 = 4;
               }

               this.field_73735_i += 100.0F;
               this.func_73729_b(var47 + var17 - 12, var22, 0 + var55 * 10, 176 + var27 * 8, 10, 8);
               this.field_73735_i -= 100.0F;
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
      GL11.glEnable(3008);
   }

   private void func_96136_a(ScoreObjective p_96136_1_, int p_96136_2_, int p_96136_3_, FontRenderer p_96136_4_) {
      Scoreboard var5 = p_96136_1_.func_96682_a();
      Collection var6 = var5.func_96534_i(p_96136_1_);
      if(var6.size() <= 15) {
         int var7 = p_96136_4_.func_78256_a(p_96136_1_.func_96678_d());

         String var11;
         for(Iterator var8 = var6.iterator(); var8.hasNext(); var7 = Math.max(var7, p_96136_4_.func_78256_a(var11))) {
            Score var9 = (Score)var8.next();
            ScorePlayerTeam var10 = var5.func_96509_i(var9.func_96653_e());
            var11 = ScorePlayerTeam.func_96667_a(var10, var9.func_96653_e()) + ": " + EnumChatFormatting.RED + var9.func_96652_c();
         }

         int var22 = var6.size() * p_96136_4_.field_78288_b;
         int var23 = p_96136_2_ / 2 + var22 / 3;
         byte var25 = 3;
         int var24 = p_96136_3_ - var7 - var25;
         int var12 = 0;
         Iterator var13 = var6.iterator();

         while(var13.hasNext()) {
            Score var14 = (Score)var13.next();
            ++var12;
            ScorePlayerTeam var15 = var5.func_96509_i(var14.func_96653_e());
            String var16 = ScorePlayerTeam.func_96667_a(var15, var14.func_96653_e());
            String var17 = EnumChatFormatting.RED + "" + var14.func_96652_c();
            int var19 = var23 - var12 * p_96136_4_.field_78288_b;
            int var20 = p_96136_3_ - var25 + 2;
            func_73734_a(var24 - 2, var19, var20, var19 + p_96136_4_.field_78288_b, 1342177280);
            p_96136_4_.func_78276_b(var16, var24, var19, 553648127);
            p_96136_4_.func_78276_b(var17, var20 - p_96136_4_.func_78256_a(var17), var19, 553648127);
            if(var12 == var6.size()) {
               String var21 = p_96136_1_.func_96678_d();
               func_73734_a(var24 - 2, var19 - p_96136_4_.field_78288_b - 1, var20, var19 - 1, 1610612736);
               func_73734_a(var24 - 2, var19 - 1, var20, var19, 1342177280);
               p_96136_4_.func_78276_b(var21, var24 + var7 / 2 - p_96136_4_.func_78256_a(var21) / 2, var19 - p_96136_4_.field_78288_b, 553648127);
            }
         }

      }
   }

   private void func_73828_d() {
      if(BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
         --BossStatus.field_82826_b;
         FontRenderer var1 = this.field_73839_d.field_71466_p;
         ScaledResolution var2 = new ScaledResolution(this.field_73839_d.field_71474_y, this.field_73839_d.field_71443_c, this.field_73839_d.field_71440_d);
         int var3 = var2.func_78326_a();
         short var4 = 182;
         int var5 = var3 / 2 - var4 / 2;
         int var6 = (int)(BossStatus.field_82828_a * (float)(var4 + 1));
         byte var7 = 12;
         this.func_73729_b(var5, var7, 0, 74, var4, 5);
         this.func_73729_b(var5, var7, 0, 74, var4, 5);
         if(var6 > 0) {
            this.func_73729_b(var5, var7, 0, 79, var6, 5);
         }

         String var8 = BossStatus.field_82827_c;
         var1.func_78261_a(var8, var3 / 2 - var1.func_78256_a(var8) / 2, var7 - 10, 16777215);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_73839_d.field_71446_o.func_98187_b("/gui/icons.png");
      }
   }

   private void func_73836_a(int p_73836_1_, int p_73836_2_) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      this.field_73839_d.field_71446_o.func_98187_b("%blur%/misc/pumpkinblur.png");
      Tessellator var3 = Tessellator.field_78398_a;
      var3.func_78382_b();
      var3.func_78374_a(0.0D, (double)p_73836_2_, -90.0D, 0.0D, 1.0D);
      var3.func_78374_a((double)p_73836_1_, (double)p_73836_2_, -90.0D, 1.0D, 1.0D);
      var3.func_78374_a((double)p_73836_1_, 0.0D, -90.0D, 1.0D, 0.0D);
      var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var3.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_73829_a(float p_73829_1_, int p_73829_2_, int p_73829_3_) {
      p_73829_1_ = 1.0F - p_73829_1_;
      if(p_73829_1_ < 0.0F) {
         p_73829_1_ = 0.0F;
      }

      if(p_73829_1_ > 1.0F) {
         p_73829_1_ = 1.0F;
      }

      this.field_73843_a = (float)((double)this.field_73843_a + (double)(p_73829_1_ - this.field_73843_a) * 0.01D);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(0, 769);
      GL11.glColor4f(this.field_73843_a, this.field_73843_a, this.field_73843_a, 1.0F);
      this.field_73839_d.field_71446_o.func_98187_b("%blur%/misc/vignette.png");
      Tessellator var4 = Tessellator.field_78398_a;
      var4.func_78382_b();
      var4.func_78374_a(0.0D, (double)p_73829_3_, -90.0D, 0.0D, 1.0D);
      var4.func_78374_a((double)p_73829_2_, (double)p_73829_3_, -90.0D, 1.0D, 1.0D);
      var4.func_78374_a((double)p_73829_2_, 0.0D, -90.0D, 1.0D, 0.0D);
      var4.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var4.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glBlendFunc(770, 771);
   }

   private void func_73835_b(float p_73835_1_, int p_73835_2_, int p_73835_3_) {
      if(p_73835_1_ < 1.0F) {
         p_73835_1_ *= p_73835_1_;
         p_73835_1_ *= p_73835_1_;
         p_73835_1_ = p_73835_1_ * 0.8F + 0.2F;
      }

      GL11.glDisable(3008);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, p_73835_1_);
      this.field_73839_d.field_71446_o.func_98187_b("/terrain.png");
      Icon var4 = Block.field_72015_be.func_71851_a(1);
      float var5 = var4.func_94209_e();
      float var6 = var4.func_94206_g();
      float var7 = var4.func_94212_f();
      float var8 = var4.func_94210_h();
      Tessellator var9 = Tessellator.field_78398_a;
      var9.func_78382_b();
      var9.func_78374_a(0.0D, (double)p_73835_3_, -90.0D, (double)var5, (double)var8);
      var9.func_78374_a((double)p_73835_2_, (double)p_73835_3_, -90.0D, (double)var7, (double)var8);
      var9.func_78374_a((double)p_73835_2_, 0.0D, -90.0D, (double)var7, (double)var6);
      var9.func_78374_a(0.0D, 0.0D, -90.0D, (double)var5, (double)var6);
      var9.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_73832_a(int p_73832_1_, int p_73832_2_, int p_73832_3_, float p_73832_4_) {
      ItemStack var5 = this.field_73839_d.field_71439_g.field_71071_by.field_70462_a[p_73832_1_];
      if(var5 != null) {
         float var6 = (float)var5.field_77992_b - p_73832_4_;
         if(var6 > 0.0F) {
            GL11.glPushMatrix();
            float var7 = 1.0F + var6 / 5.0F;
            GL11.glTranslatef((float)(p_73832_2_ + 8), (float)(p_73832_3_ + 12), 0.0F);
            GL11.glScalef(1.0F / var7, (var7 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef((float)(-(p_73832_2_ + 8)), (float)(-(p_73832_3_ + 12)), 0.0F);
         }

         field_73841_b.func_82406_b(this.field_73839_d.field_71466_p, this.field_73839_d.field_71446_o, var5, p_73832_2_, p_73832_3_);
         if(var6 > 0.0F) {
            GL11.glPopMatrix();
         }

         field_73841_b.func_77021_b(this.field_73839_d.field_71466_p, this.field_73839_d.field_71446_o, var5, p_73832_2_, p_73832_3_);
      }
   }

   public void func_73831_a() {
      if(this.field_73845_h > 0) {
         --this.field_73845_h;
      }

      ++this.field_73837_f;
      if(this.field_73839_d.field_71439_g != null) {
         ItemStack var1 = this.field_73839_d.field_71439_g.field_71071_by.func_70448_g();
         if(var1 == null) {
            this.field_92017_k = 0;
         } else if(this.field_92016_l != null && var1.field_77993_c == this.field_92016_l.field_77993_c && ItemStack.func_77970_a(var1, this.field_92016_l) && (var1.func_77984_f() || var1.func_77960_j() == this.field_92016_l.func_77960_j())) {
            if(this.field_92017_k > 0) {
               --this.field_92017_k;
            }
         } else {
            this.field_92017_k = 40;
         }

         this.field_92016_l = var1;
      }

   }

   public void func_73833_a(String p_73833_1_) {
      this.field_73838_g = "Now playing: " + p_73833_1_;
      this.field_73845_h = 60;
      this.field_73844_j = true;
   }

   public GuiNewChat func_73827_b() {
      return this.field_73840_e;
   }

   public int func_73834_c() {
      return this.field_73837_f;
   }

}
