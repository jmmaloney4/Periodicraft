package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIRestrictSun extends EntityAIBase {

   private EntityCreature field_75273_a;


   public EntityAIRestrictSun(EntityCreature p_i3491_1_) {
      this.field_75273_a = p_i3491_1_;
   }

   public boolean func_75250_a() {
      return this.field_75273_a.field_70170_p.func_72935_r();
   }

   public void func_75249_e() {
      this.field_75273_a.func_70661_as().func_75504_d(true);
   }

   public void func_75251_c() {
      this.field_75273_a.func_70661_as().func_75504_d(false);
   }
}
