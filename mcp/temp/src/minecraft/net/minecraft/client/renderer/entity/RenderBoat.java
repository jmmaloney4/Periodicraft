package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBoat extends Render {

   protected ModelBase field_76998_a;


   public RenderBoat() {
      this.field_76989_e = 0.5F;
      this.field_76998_a = new ModelBoat();
   }

   public void func_76997_a(EntityBoat p_76997_1_, double p_76997_2_, double p_76997_4_, double p_76997_6_, float p_76997_8_, float p_76997_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76997_2_, (float)p_76997_4_, (float)p_76997_6_);
      GL11.glRotatef(180.0F - p_76997_8_, 0.0F, 1.0F, 0.0F);
      float var10 = (float)p_76997_1_.func_70268_h() - p_76997_9_;
      float var11 = (float)p_76997_1_.func_70271_g() - p_76997_9_;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var10 > 0.0F) {
         GL11.glRotatef(MathHelper.func_76126_a(var10) * var10 * var11 / 10.0F * (float)p_76997_1_.func_70267_i(), 1.0F, 0.0F, 0.0F);
      }

      this.func_76985_a("/terrain.png");
      float var12 = 0.75F;
      GL11.glScalef(var12, var12, var12);
      GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
      this.func_76985_a("/item/boat.png");
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.field_76998_a.func_78088_a(p_76997_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76997_a((EntityBoat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
