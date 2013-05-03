package net.minecraft.dispenser;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

final class DispenserBehaviorArrow extends BehaviorProjectileDispense {

   protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
      EntityArrow var3 = new EntityArrow(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
      var3.field_70251_a = 1;
      return var3;
   }
}
