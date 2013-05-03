package net.minecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

class EntityAIAvoidEntitySelector implements IEntitySelector {

   // $FF: synthetic field
   final EntityAIAvoidEntity field_98219_c;


   EntityAIAvoidEntitySelector(EntityAIAvoidEntity p_i11037_1_) {
      this.field_98219_c = p_i11037_1_;
   }

   public boolean func_82704_a(Entity p_82704_1_) {
      return p_82704_1_.func_70089_S() && EntityAIAvoidEntity.func_98217_a(this.field_98219_c).func_70635_at().func_75522_a(p_82704_1_);
   }
}
