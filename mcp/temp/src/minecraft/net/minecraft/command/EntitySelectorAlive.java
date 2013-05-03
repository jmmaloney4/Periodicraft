package net.minecraft.command;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;

final class EntitySelectorAlive implements IEntitySelector {

   public boolean func_82704_a(Entity p_82704_1_) {
      return p_82704_1_.func_70089_S();
   }
}
