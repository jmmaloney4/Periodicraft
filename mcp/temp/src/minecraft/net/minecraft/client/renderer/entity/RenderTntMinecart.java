package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTntMinecart extends RenderMinecart {

   protected void func_94146_a(EntityMinecartTNT p_94146_1_, float p_94146_2_, Block p_94146_3_, int p_94146_4_) {
      int var5 = p_94146_1_.func_94104_d();
      if(var5 > -1 && (float)var5 - p_94146_2_ + 1.0F < 10.0F) {
         float var6 = 1.0F - ((float)var5 - p_94146_2_ + 1.0F) / 10.0F;
         if(var6 < 0.0F) {
            var6 = 0.0F;
         }

         if(var6 > 1.0F) {
            var6 = 1.0F;
         }

         var6 *= var6;
         var6 *= var6;
         float var7 = 1.0F + var6 * 0.3F;
         GL11.glScalef(var7, var7, var7);
      }

      super.func_94144_a(p_94146_1_, p_94146_2_, p_94146_3_, p_94146_4_);
      if(var5 > -1 && var5 / 5 % 2 == 0) {
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 772);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, (1.0F - ((float)var5 - p_94146_2_ + 1.0F) / 100.0F) * 0.8F);
         GL11.glPushMatrix();
         this.field_94145_f.func_78600_a(Block.field_72091_am, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_94144_a(EntityMinecart p_94144_1_, float p_94144_2_, Block p_94144_3_, int p_94144_4_) {
      this.func_94146_a((EntityMinecartTNT)p_94144_1_, p_94144_2_, p_94144_3_, p_94144_4_);
   }
}
