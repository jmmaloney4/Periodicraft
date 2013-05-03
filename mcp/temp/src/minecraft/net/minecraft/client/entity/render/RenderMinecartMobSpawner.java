package net.minecraft.client.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecart;

@SideOnly(Side.CLIENT)
public class RenderMinecartMobSpawner extends RenderMinecart {

   protected void func_98192_a(EntityMinecartMobSpawner p_98192_1_, float p_98192_2_, Block p_98192_3_, int p_98192_4_) {
      super.func_94144_a(p_98192_1_, p_98192_2_, p_98192_3_, p_98192_4_);
      if(p_98192_3_ == Block.field_72065_as) {
         TileEntityMobSpawnerRenderer.func_98144_a(p_98192_1_.func_98039_d(), p_98192_1_.field_70165_t, p_98192_1_.field_70163_u, p_98192_1_.field_70161_v, p_98192_2_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_94144_a(EntityMinecart p_94144_1_, float p_94144_2_, Block p_94144_3_, int p_94144_4_) {
      this.func_98192_a((EntityMinecartMobSpawner)p_94144_1_, p_94144_2_, p_94144_3_, p_94144_4_);
   }
}
