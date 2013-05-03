package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEgg extends EntityThrowable {

   public EntityEgg(World p_i3586_1_) {
      super(p_i3586_1_);
   }

   public EntityEgg(World p_i3587_1_, EntityLiving p_i3587_2_) {
      super(p_i3587_1_, p_i3587_2_);
   }

   public EntityEgg(World p_i3588_1_, double p_i3588_2_, double p_i3588_4_, double p_i3588_6_) {
      super(p_i3588_1_, p_i3588_2_, p_i3588_4_, p_i3588_6_);
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      if(p_70184_1_.field_72308_g != null) {
         p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.func_85052_h()), 0);
      }

      if(!this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(8) == 0) {
         byte var2 = 1;
         if(this.field_70146_Z.nextInt(32) == 0) {
            var2 = 4;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            EntityChicken var4 = new EntityChicken(this.field_70170_p);
            var4.func_70873_a(-24000);
            var4.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(var4);
         }
      }

      for(int var5 = 0; var5 < 8; ++var5) {
         this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70106_y();
      }

   }
}
