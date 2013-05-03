package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityFootStepFX extends EntityFX {

   private int field_70576_a = 0;
   private int field_70578_aq = 0;
   private RenderEngine field_70577_ar;


   public EntityFootStepFX(RenderEngine p_i3168_1_, World p_i3168_2_, double p_i3168_3_, double p_i3168_5_, double p_i3168_7_) {
      super(p_i3168_2_, p_i3168_3_, p_i3168_5_, p_i3168_7_, 0.0D, 0.0D, 0.0D);
      this.field_70577_ar = p_i3168_1_;
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      this.field_70578_aq = 200;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70576_a + p_70539_2_) / (float)this.field_70578_aq;
      var8 *= var8;
      float var9 = 2.0F - var8 * 2.0F;
      if(var9 > 1.0F) {
         var9 = 1.0F;
      }

      var9 *= 0.2F;
      GL11.glDisable(2896);
      float var10 = 0.125F;
      float var11 = (float)(this.field_70165_t - field_70556_an);
      float var12 = (float)(this.field_70163_u - field_70554_ao);
      float var13 = (float)(this.field_70161_v - field_70555_ap);
      float var14 = this.field_70170_p.func_72801_o(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
      this.field_70577_ar.func_98187_b("/misc/footprint.png");
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      p_70539_1_.func_78382_b();
      p_70539_1_.func_78369_a(var14, var14, var14, var9);
      p_70539_1_.func_78374_a((double)(var11 - var10), (double)var12, (double)(var13 + var10), 0.0D, 1.0D);
      p_70539_1_.func_78374_a((double)(var11 + var10), (double)var12, (double)(var13 + var10), 1.0D, 1.0D);
      p_70539_1_.func_78374_a((double)(var11 + var10), (double)var12, (double)(var13 - var10), 1.0D, 0.0D);
      p_70539_1_.func_78374_a((double)(var11 - var10), (double)var12, (double)(var13 - var10), 0.0D, 0.0D);
      p_70539_1_.func_78381_a();
      GL11.glDisable(3042);
      GL11.glEnable(2896);
   }

   public void func_70071_h_() {
      ++this.field_70576_a;
      if(this.field_70576_a == this.field_70578_aq) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }
}
