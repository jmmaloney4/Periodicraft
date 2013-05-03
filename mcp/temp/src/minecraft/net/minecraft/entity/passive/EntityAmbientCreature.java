package net.minecraft.entity.passive;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.world.World;

public abstract class EntityAmbientCreature extends EntityLiving implements IAnimals {

   public EntityAmbientCreature(World p_i5062_1_) {
      super(p_i5062_1_);
   }
}
