package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EffectRenderer {

   protected World field_78878_a;
   private List[] field_78876_b = new List[4];
   private RenderEngine field_78877_c;
   private Random field_78875_d = new Random();


   public EffectRenderer(World p_i3170_1_, RenderEngine p_i3170_2_) {
      if(p_i3170_1_ != null) {
         this.field_78878_a = p_i3170_1_;
      }

      this.field_78877_c = p_i3170_2_;

      for(int var3 = 0; var3 < 4; ++var3) {
         this.field_78876_b[var3] = new ArrayList();
      }

   }

   public void func_78873_a(EntityFX p_78873_1_) {
      int var2 = p_78873_1_.func_70537_b();
      if(this.field_78876_b[var2].size() >= 4000) {
         this.field_78876_b[var2].remove(0);
      }

      this.field_78876_b[var2].add(p_78873_1_);
   }

   public void func_78868_a() {
      for(int var1 = 0; var1 < 4; ++var1) {
         for(int var2 = 0; var2 < this.field_78876_b[var1].size(); ++var2) {
            EntityFX var3 = (EntityFX)this.field_78876_b[var1].get(var2);
            var3.func_70071_h_();
            if(var3.field_70128_L) {
               this.field_78876_b[var1].remove(var2--);
            }
         }
      }

   }

   public void func_78874_a(Entity p_78874_1_, float p_78874_2_) {
      float var3 = ActiveRenderInfo.field_74588_d;
      float var4 = ActiveRenderInfo.field_74586_f;
      float var5 = ActiveRenderInfo.field_74587_g;
      float var6 = ActiveRenderInfo.field_74596_h;
      float var7 = ActiveRenderInfo.field_74589_e;
      EntityFX.field_70556_an = p_78874_1_.field_70142_S + (p_78874_1_.field_70165_t - p_78874_1_.field_70142_S) * (double)p_78874_2_;
      EntityFX.field_70554_ao = p_78874_1_.field_70137_T + (p_78874_1_.field_70163_u - p_78874_1_.field_70137_T) * (double)p_78874_2_;
      EntityFX.field_70555_ap = p_78874_1_.field_70136_U + (p_78874_1_.field_70161_v - p_78874_1_.field_70136_U) * (double)p_78874_2_;

      for(int var8 = 0; var8 < 3; ++var8) {
         if(!this.field_78876_b[var8].isEmpty()) {
            switch(var8) {
            case 0:
            default:
               this.field_78877_c.func_98187_b("/particles.png");
               break;
            case 1:
               this.field_78877_c.func_98187_b("/terrain.png");
               break;
            case 2:
               this.field_78877_c.func_98187_b("/gui/items.png");
            }

            Tessellator var9 = Tessellator.field_78398_a;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569F);
            var9.func_78382_b();

            for(int var10 = 0; var10 < this.field_78876_b[var8].size(); ++var10) {
               EntityFX var11 = (EntityFX)this.field_78876_b[var8].get(var10);
               var9.func_78380_c(var11.func_70070_b(p_78874_2_));
               var11.func_70539_a(var9, p_78874_2_, var3, var7, var4, var5, var6);
            }

            var9.func_78381_a();
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glAlphaFunc(516, 0.1F);
         }
      }

   }

   public void func_78872_b(Entity p_78872_1_, float p_78872_2_) {
      float var4 = MathHelper.func_76134_b(p_78872_1_.field_70177_z * 0.017453292F);
      float var5 = MathHelper.func_76126_a(p_78872_1_.field_70177_z * 0.017453292F);
      float var6 = -var5 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
      float var7 = var4 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
      float var8 = MathHelper.func_76134_b(p_78872_1_.field_70125_A * 0.017453292F);
      byte var9 = 3;
      if(!this.field_78876_b[var9].isEmpty()) {
         Tessellator var10 = Tessellator.field_78398_a;

         for(int var11 = 0; var11 < this.field_78876_b[var9].size(); ++var11) {
            EntityFX var12 = (EntityFX)this.field_78876_b[var9].get(var11);
            var10.func_78380_c(var12.func_70070_b(p_78872_2_));
            var12.func_70539_a(var10, p_78872_2_, var4, var8, var5, var6, var7);
         }

      }
   }

   public void func_78870_a(World p_78870_1_) {
      this.field_78878_a = p_78870_1_;

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_78876_b[var2].clear();
      }

   }

   public void func_78871_a(int p_78871_1_, int p_78871_2_, int p_78871_3_, int p_78871_4_, int p_78871_5_) {
      if(p_78871_4_ != 0) {
         Block var6 = Block.field_71973_m[p_78871_4_];
         byte var7 = 4;

         for(int var8 = 0; var8 < var7; ++var8) {
            for(int var9 = 0; var9 < var7; ++var9) {
               for(int var10 = 0; var10 < var7; ++var10) {
                  double var11 = (double)p_78871_1_ + ((double)var8 + 0.5D) / (double)var7;
                  double var13 = (double)p_78871_2_ + ((double)var9 + 0.5D) / (double)var7;
                  double var15 = (double)p_78871_3_ + ((double)var10 + 0.5D) / (double)var7;
                  int var17 = this.field_78875_d.nextInt(6);
                  this.func_78873_a((new EntityDiggingFX(this.field_78878_a, var11, var13, var15, var11 - (double)p_78871_1_ - 0.5D, var13 - (double)p_78871_2_ - 0.5D, var15 - (double)p_78871_3_ - 0.5D, var6, var17, p_78871_5_, this.field_78877_c)).func_70596_a(p_78871_1_, p_78871_2_, p_78871_3_));
               }
            }
         }

      }
   }

   public void func_78867_a(int p_78867_1_, int p_78867_2_, int p_78867_3_, int p_78867_4_) {
      int var5 = this.field_78878_a.func_72798_a(p_78867_1_, p_78867_2_, p_78867_3_);
      if(var5 != 0) {
         Block var6 = Block.field_71973_m[var5];
         float var7 = 0.1F;
         double var8 = (double)p_78867_1_ + this.field_78875_d.nextDouble() * (var6.func_83007_w() - var6.func_83009_v() - (double)(var7 * 2.0F)) + (double)var7 + var6.func_83009_v();
         double var10 = (double)p_78867_2_ + this.field_78875_d.nextDouble() * (var6.func_83010_y() - var6.func_83008_x() - (double)(var7 * 2.0F)) + (double)var7 + var6.func_83008_x();
         double var12 = (double)p_78867_3_ + this.field_78875_d.nextDouble() * (var6.func_83006_A() - var6.func_83005_z() - (double)(var7 * 2.0F)) + (double)var7 + var6.func_83005_z();
         if(p_78867_4_ == 0) {
            var10 = (double)p_78867_2_ + var6.func_83008_x() - (double)var7;
         }

         if(p_78867_4_ == 1) {
            var10 = (double)p_78867_2_ + var6.func_83010_y() + (double)var7;
         }

         if(p_78867_4_ == 2) {
            var12 = (double)p_78867_3_ + var6.func_83005_z() - (double)var7;
         }

         if(p_78867_4_ == 3) {
            var12 = (double)p_78867_3_ + var6.func_83006_A() + (double)var7;
         }

         if(p_78867_4_ == 4) {
            var8 = (double)p_78867_1_ + var6.func_83009_v() - (double)var7;
         }

         if(p_78867_4_ == 5) {
            var8 = (double)p_78867_1_ + var6.func_83007_w() + (double)var7;
         }

         this.func_78873_a((new EntityDiggingFX(this.field_78878_a, var8, var10, var12, 0.0D, 0.0D, 0.0D, var6, p_78867_4_, this.field_78878_a.func_72805_g(p_78867_1_, p_78867_2_, p_78867_3_), this.field_78877_c)).func_70596_a(p_78867_1_, p_78867_2_, p_78867_3_).func_70543_e(0.2F).func_70541_f(0.6F));
      }
   }

   public String func_78869_b() {
      return "" + (this.field_78876_b[0].size() + this.field_78876_b[1].size() + this.field_78876_b[2].size());
   }
}
