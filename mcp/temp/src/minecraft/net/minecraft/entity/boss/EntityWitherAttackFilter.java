package net.minecraft.entity.boss;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;

final class EntityWitherAttackFilter implements IEntitySelector {

   public boolean func_82704_a(Entity p_82704_1_) {
      return p_82704_1_ instanceof EntityLiving && ((EntityLiving)p_82704_1_).func_70668_bt() != EnumCreatureAttribute.UNDEAD;
   }
}
