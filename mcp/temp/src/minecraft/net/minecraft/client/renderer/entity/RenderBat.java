package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBat extends RenderLiving {

   private int field_82446_a;


   public RenderBat() {
      super(new ModelBat(), 0.25F);
      this.field_82446_a = ((ModelBat)this.field_77045_g).func_82889_a();
   }

   public void func_82443_a(EntityBat p_82443_1_, double p_82443_2_, double p_82443_4_, double p_82443_6_, float p_82443_8_, float p_82443_9_) {
      int var10 = ((ModelBat)this.field_77045_g).func_82889_a();
      if(var10 != this.field_82446_a) {
         this.field_82446_a = var10;
         this.field_77045_g = new ModelBat();
      }

      super.func_77031_a(p_82443_1_, p_82443_2_, p_82443_4_, p_82443_6_, p_82443_8_, p_82443_9_);
   }

   protected void func_82442_a(EntityBat p_82442_1_, float p_82442_2_) {
      GL11.glScalef(0.35F, 0.35F, 0.35F);
   }

   protected void func_82445_a(EntityBat p_82445_1_, double p_82445_2_, double p_82445_4_, double p_82445_6_) {
      super.func_77039_a(p_82445_1_, p_82445_2_, p_82445_4_, p_82445_6_);
   }

   protected void func_82444_a(EntityBat p_82444_1_, float p_82444_2_, float p_82444_3_, float p_82444_4_) {
      if(!p_82444_1_.func_82235_h()) {
         GL11.glTranslatef(0.0F, MathHelper.func_76134_b(p_82444_2_ * 0.3F) * 0.1F, 0.0F);
      } else {
         GL11.glTranslatef(0.0F, -0.1F, 0.0F);
      }

      super.func_77043_a(p_82444_1_, p_82444_2_, p_82444_3_, p_82444_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_82442_a((EntityBat)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_82444_a((EntityBat)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77039_a(EntityLiving p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      this.func_82445_a((EntityBat)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_82443_a((EntityBat)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82443_a((EntityBat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
