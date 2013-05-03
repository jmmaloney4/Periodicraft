package net.minecraft.entity.monster;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;

final class FilterIMob implements IEntitySelector {

   public boolean func_82704_a(Entity p_82704_1_) {
      return p_82704_1_ instanceof IMob;
   }
}
