package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;

public class EntityAITaskEntry {

   public EntityAIBase field_75733_a;
   public int field_75731_b;
   // $FF: synthetic field
   final EntityAITasks field_75732_c;


   public EntityAITaskEntry(EntityAITasks p_i3468_1_, int p_i3468_2_, EntityAIBase p_i3468_3_) {
      this.field_75732_c = p_i3468_1_;
      this.field_75731_b = p_i3468_2_;
      this.field_75733_a = p_i3468_3_;
   }
}
