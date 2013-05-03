package net.minecraft.dispenser;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.world.World;

final class DispenserBehaviorExperience extends BehaviorProjectileDispense {

   protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
      return new EntityExpBottle(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
   }

   protected float func_82498_a() {
      return super.func_82498_a() * 0.5F;
   }

   protected float func_82500_b() {
      return super.func_82500_b() * 1.25F;
   }
}
