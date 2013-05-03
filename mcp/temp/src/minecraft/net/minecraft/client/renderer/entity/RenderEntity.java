package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEntity extends Render {

   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glPushMatrix();
      func_76978_a(p_76986_1_.field_70121_D, p_76986_2_ - p_76986_1_.field_70142_S, p_76986_4_ - p_76986_1_.field_70137_T, p_76986_6_ - p_76986_1_.field_70136_U);
      GL11.glPopMatrix();
   }
}
