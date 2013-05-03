package net.minecraft.command;

import net.minecraft.command.EntitySelectorAlive;
import net.minecraft.command.EntitySelectorInventory;
import net.minecraft.entity.Entity;

public interface IEntitySelector {

   IEntitySelector field_94557_a = new EntitySelectorAlive();
   IEntitySelector field_96566_b = new EntitySelectorInventory();


   boolean func_82704_a(Entity var1);

}
