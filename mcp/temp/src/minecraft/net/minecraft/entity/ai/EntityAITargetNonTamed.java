package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget {

   private EntityTameable field_75310_g;


   public EntityAITargetNonTamed(EntityTameable p_i3502_1_, Class p_i3502_2_, float p_i3502_3_, int p_i3502_4_, boolean p_i3502_5_) {
      super(p_i3502_1_, p_i3502_2_, p_i3502_3_, p_i3502_4_, p_i3502_5_);
      this.field_75310_g = p_i3502_1_;
   }

   public boolean func_75250_a() {
      return this.field_75310_g.func_70909_n()?false:super.func_75250_a();
   }
}
