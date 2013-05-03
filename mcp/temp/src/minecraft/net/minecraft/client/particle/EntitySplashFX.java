package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntitySplashFX extends EntityRainFX {

   public EntitySplashFX(World p_i3163_1_, double p_i3163_2_, double p_i3163_4_, double p_i3163_6_, double p_i3163_8_, double p_i3163_10_, double p_i3163_12_) {
      super(p_i3163_1_, p_i3163_2_, p_i3163_4_, p_i3163_6_);
      this.field_70545_g = 0.04F;
      this.func_94053_h();
      if(p_i3163_10_ == 0.0D && (p_i3163_8_ != 0.0D || p_i3163_12_ != 0.0D)) {
         this.field_70159_w = p_i3163_8_;
         this.field_70181_x = p_i3163_10_ + 0.1D;
         this.field_70179_y = p_i3163_12_;
      }

   }
}
