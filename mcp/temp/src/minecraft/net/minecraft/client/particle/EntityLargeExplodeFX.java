package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityLargeExplodeFX extends EntityFX {

   private int field_70581_a = 0;
   private int field_70584_aq = 0;
   private RenderEngine field_70583_ar;
   private float field_70582_as;


   public EntityLargeExplodeFX(RenderEngine p_i3181_1_, World p_i3181_2_, double p_i3181_3_, double p_i3181_5_, double p_i3181_7_, double p_i3181_9_, double p_i3181_11_, double p_i3181_13_) {
      super(p_i3181_2_, p_i3181_3_, p_i3181_5_, p_i3181_7_, 0.0D, 0.0D, 0.0D);
      this.field_70583_ar = p_i3181_1_;
      this.field_70584_aq = 6 + this.field_70146_Z.nextInt(4);
      this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
      this.field_70582_as = 1.0F - (float)p_i3181_9_ * 0.5F;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      int var8 = (int)(((float)this.field_70581_a + p_70539_2_) * 15.0F / (float)this.field_70584_aq);
      if(var8 <= 15) {
         this.field_70583_ar.func_98187_b("/misc/explosion.png");
         float var9 = (float)(var8 % 4) / 4.0F;
         float var10 = var9 + 0.24975F;
         float var11 = (float)(var8 / 4) / 4.0F;
         float var12 = var11 + 0.24975F;
         float var13 = 2.0F * this.field_70582_as;
         float var14 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70539_2_ - field_70556_an);
         float var15 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70539_2_ - field_70554_ao);
         float var16 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70539_2_ - field_70555_ap);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(2896);
         RenderHelper.func_74518_a();
         p_70539_1_.func_78382_b();
         p_70539_1_.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 1.0F);
         p_70539_1_.func_78375_b(0.0F, 1.0F, 0.0F);
         p_70539_1_.func_78380_c(240);
         p_70539_1_.func_78374_a((double)(var14 - p_70539_3_ * var13 - p_70539_6_ * var13), (double)(var15 - p_70539_4_ * var13), (double)(var16 - p_70539_5_ * var13 - p_70539_7_ * var13), (double)var10, (double)var12);
         p_70539_1_.func_78374_a((double)(var14 - p_70539_3_ * var13 + p_70539_6_ * var13), (double)(var15 + p_70539_4_ * var13), (double)(var16 - p_70539_5_ * var13 + p_70539_7_ * var13), (double)var10, (double)var11);
         p_70539_1_.func_78374_a((double)(var14 + p_70539_3_ * var13 + p_70539_6_ * var13), (double)(var15 + p_70539_4_ * var13), (double)(var16 + p_70539_5_ * var13 + p_70539_7_ * var13), (double)var9, (double)var11);
         p_70539_1_.func_78374_a((double)(var14 + p_70539_3_ * var13 - p_70539_6_ * var13), (double)(var15 - p_70539_4_ * var13), (double)(var16 + p_70539_5_ * var13 - p_70539_7_ * var13), (double)var9, (double)var12);
         p_70539_1_.func_78381_a();
         GL11.glPolygonOffset(0.0F, 0.0F);
         GL11.glEnable(2896);
      }
   }

   public int func_70070_b(float p_70070_1_) {
      return '\uf0f0';
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      ++this.field_70581_a;
      if(this.field_70581_a == this.field_70584_aq) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }
}
