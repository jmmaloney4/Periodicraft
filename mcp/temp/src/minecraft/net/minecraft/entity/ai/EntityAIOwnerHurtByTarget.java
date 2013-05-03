package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAIOwnerHurtByTarget extends EntityAITarget {

   EntityTameable field_75316_a;
   EntityLiving field_75315_b;


   public EntityAIOwnerHurtByTarget(EntityTameable p_i3503_1_) {
      super(p_i3503_1_, 32.0F, false);
      this.field_75316_a = p_i3503_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if(!this.field_75316_a.func_70909_n()) {
         return false;
      } else {
         EntityLiving var1 = this.field_75316_a.func_70902_q();
         if(var1 == null) {
            return false;
         } else {
            this.field_75315_b = var1.func_70643_av();
            return this.func_75296_a(this.field_75315_b, false);
         }
      }
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75315_b);
      super.func_75249_e();
   }
}
