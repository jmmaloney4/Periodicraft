package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnderCrystal extends Render {

   private int field_76996_a = -1;
   private ModelBase field_76995_b;


   public RenderEnderCrystal() {
      this.field_76989_e = 0.5F;
   }

   public void func_76994_a(EntityEnderCrystal p_76994_1_, double p_76994_2_, double p_76994_4_, double p_76994_6_, float p_76994_8_, float p_76994_9_) {
      if(this.field_76996_a != 1) {
         this.field_76995_b = new ModelEnderCrystal(0.0F, true);
         this.field_76996_a = 1;
      }

      float var10 = (float)p_76994_1_.field_70261_a + p_76994_9_;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76994_2_, (float)p_76994_4_, (float)p_76994_6_);
      this.func_76985_a("/mob/enderdragon/crystal.png");
      float var11 = MathHelper.func_76126_a(var10 * 0.2F) / 2.0F + 0.5F;
      var11 += var11 * var11;
      this.field_76995_b.func_78088_a(p_76994_1_, 0.0F, var10 * 3.0F, var11 * 0.2F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76994_a((EntityEnderCrystal)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
