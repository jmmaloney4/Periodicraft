package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnderPearl extends EntityThrowable {

   public EntityEnderPearl(World p_i3589_1_) {
      super(p_i3589_1_);
   }

   public EntityEnderPearl(World p_i3590_1_, EntityLiving p_i3590_2_) {
      super(p_i3590_1_, p_i3590_2_);
   }

   @SideOnly(Side.CLIENT)
   public EntityEnderPearl(World p_i3591_1_, double p_i3591_2_, double p_i3591_4_, double p_i3591_6_) {
      super(p_i3591_1_, p_i3591_2_, p_i3591_4_, p_i3591_6_);
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      if(p_70184_1_.field_72308_g != null) {
         p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.func_85052_h()), 0);
      }

      for(int var2 = 0; var2 < 32; ++var2) {
         this.field_70170_p.func_72869_a("portal", this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0D, this.field_70146_Z.nextGaussian());
      }

      if(!this.field_70170_p.field_72995_K) {
         if(this.func_85052_h() != null && this.func_85052_h() instanceof EntityPlayerMP) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.func_85052_h();
            if(!var3.field_71135_a.field_72576_c && var3.field_70170_p == this.field_70170_p) {
               this.func_85052_h().func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
               this.func_85052_h().field_70143_R = 0.0F;
               this.func_85052_h().func_70097_a(DamageSource.field_76379_h, 5);
            }
         }

         this.func_70106_y();
      }

   }
}
