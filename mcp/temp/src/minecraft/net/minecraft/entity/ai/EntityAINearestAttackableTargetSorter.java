package net.minecraft.entity.ai;

import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class EntityAINearestAttackableTargetSorter implements Comparator {

   private Entity field_75459_b;
   // $FF: synthetic field
   final EntityAINearestAttackableTarget field_75460_a;


   public EntityAINearestAttackableTargetSorter(EntityAINearestAttackableTarget p_i3499_1_, Entity p_i3499_2_) {
      this.field_75460_a = p_i3499_1_;
      this.field_75459_b = p_i3499_2_;
   }

   public int func_75458_a(Entity p_75458_1_, Entity p_75458_2_) {
      double var3 = this.field_75459_b.func_70068_e(p_75458_1_);
      double var5 = this.field_75459_b.func_70068_e(p_75458_2_);
      return var3 < var5?-1:(var3 > var5?1:0);
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_75458_a((Entity)p_compare_1_, (Entity)p_compare_2_);
   }
}
