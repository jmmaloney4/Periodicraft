package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class EntityAIOpenDoor extends EntityAIDoorInteract {

   boolean field_75361_i;
   int field_75360_j;


   public EntityAIOpenDoor(EntityLiving p_i3484_1_, boolean p_i3484_2_) {
      super(p_i3484_1_);
      this.field_75356_a = p_i3484_1_;
      this.field_75361_i = p_i3484_2_;
   }

   public boolean func_75253_b() {
      return this.field_75361_i && this.field_75360_j > 0 && super.func_75253_b();
   }

   public void func_75249_e() {
      this.field_75360_j = 20;
      this.field_75353_e.func_72231_a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, true);
   }

   public void func_75251_c() {
      if(this.field_75361_i) {
         this.field_75353_e.func_72231_a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, false);
      }

   }

   public void func_75246_d() {
      --this.field_75360_j;
      super.func_75246_d();
   }
}
