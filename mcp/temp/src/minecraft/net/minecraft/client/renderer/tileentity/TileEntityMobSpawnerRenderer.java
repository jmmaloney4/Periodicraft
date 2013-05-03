package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer {

   public void func_76905_a(TileEntityMobSpawner p_76905_1_, double p_76905_2_, double p_76905_4_, double p_76905_6_, float p_76905_8_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76905_2_ + 0.5F, (float)p_76905_4_, (float)p_76905_6_ + 0.5F);
      func_98144_a(p_76905_1_.func_98049_a(), p_76905_2_, p_76905_4_, p_76905_6_, p_76905_8_);
      GL11.glPopMatrix();
   }

   public static void func_98144_a(MobSpawnerBaseLogic p_98144_0_, double p_98144_1_, double p_98144_3_, double p_98144_5_, float p_98144_7_) {
      Entity var8 = p_98144_0_.func_98281_h();
      if(var8 != null) {
         var8.func_70029_a(p_98144_0_.func_98271_a());
         float var9 = 0.4375F;
         GL11.glTranslatef(0.0F, 0.4F, 0.0F);
         GL11.glRotatef((float)(p_98144_0_.field_98284_d + (p_98144_0_.field_98287_c - p_98144_0_.field_98284_d) * (double)p_98144_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.4F, 0.0F);
         GL11.glScalef(var9, var9, var9);
         var8.func_70012_b(p_98144_1_, p_98144_3_, p_98144_5_, 0.0F, 0.0F);
         RenderManager.field_78727_a.func_78719_a(var8, 0.0D, 0.0D, 0.0D, 0.0F, p_98144_7_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76905_a((TileEntityMobSpawner)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
