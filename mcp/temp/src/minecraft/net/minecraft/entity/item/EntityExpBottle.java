package net.minecraft.entity.item;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExpBottle extends EntityThrowable {

   public EntityExpBottle(World p_i3592_1_) {
      super(p_i3592_1_);
   }

   public EntityExpBottle(World p_i3593_1_, EntityLiving p_i3593_2_) {
      super(p_i3593_1_, p_i3593_2_);
   }

   public EntityExpBottle(World p_i3594_1_, double p_i3594_2_, double p_i3594_4_, double p_i3594_6_) {
      super(p_i3594_1_, p_i3594_2_, p_i3594_4_, p_i3594_6_);
   }

   protected float func_70185_h() {
      return 0.07F;
   }

   protected float func_70182_d() {
      return 0.7F;
   }

   protected float func_70183_g() {
      return -20.0F;
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      if(!this.field_70170_p.field_72995_K) {
         this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
         int var2 = 3 + this.field_70170_p.field_73012_v.nextInt(5) + this.field_70170_p.field_73012_v.nextInt(5);

         while(var2 > 0) {
            int var3 = EntityXPOrb.func_70527_a(var2);
            var2 -= var3;
            this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, var3));
         }

         this.func_70106_y();
      }

   }
}
