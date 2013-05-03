package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

public class EntityAIMoveTwardsRestriction extends EntityAIBase {

   private EntityCreature field_75436_a;
   private double field_75434_b;
   private double field_75435_c;
   private double field_75432_d;
   private float field_75433_e;


   public EntityAIMoveTwardsRestriction(EntityCreature p_i3480_1_, float p_i3480_2_) {
      this.field_75436_a = p_i3480_1_;
      this.field_75433_e = p_i3480_2_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if(this.field_75436_a.func_70611_aB()) {
         return false;
      } else {
         ChunkCoordinates var1 = this.field_75436_a.func_70602_aC();
         Vec3 var2 = RandomPositionGenerator.func_75464_a(this.field_75436_a, 16, 7, this.field_75436_a.field_70170_p.func_82732_R().func_72345_a((double)var1.field_71574_a, (double)var1.field_71572_b, (double)var1.field_71573_c));
         if(var2 == null) {
            return false;
         } else {
            this.field_75434_b = var2.field_72450_a;
            this.field_75435_c = var2.field_72448_b;
            this.field_75432_d = var2.field_72449_c;
            return true;
         }
      }
   }

   public boolean func_75253_b() {
      return !this.field_75436_a.func_70661_as().func_75500_f();
   }

   public void func_75249_e() {
      this.field_75436_a.func_70661_as().func_75492_a(this.field_75434_b, this.field_75435_c, this.field_75432_d, this.field_75433_e);
   }
}
