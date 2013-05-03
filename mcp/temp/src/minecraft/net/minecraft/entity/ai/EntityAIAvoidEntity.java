package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntitySelector;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

public class EntityAIAvoidEntity extends EntityAIBase {

   public final IEntitySelector field_98218_a = new EntityAIAvoidEntitySelector(this);
   private EntityCreature field_75380_a;
   private float field_75378_b;
   private float field_75379_c;
   private Entity field_75376_d;
   private float field_75377_e;
   private PathEntity field_75374_f;
   private PathNavigate field_75375_g;
   private Class field_75381_h;


   public EntityAIAvoidEntity(EntityCreature p_i3458_1_, Class p_i3458_2_, float p_i3458_3_, float p_i3458_4_, float p_i3458_5_) {
      this.field_75380_a = p_i3458_1_;
      this.field_75381_h = p_i3458_2_;
      this.field_75377_e = p_i3458_3_;
      this.field_75378_b = p_i3458_4_;
      this.field_75379_c = p_i3458_5_;
      this.field_75375_g = p_i3458_1_.func_70661_as();
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if(this.field_75381_h == EntityPlayer.class) {
         if(this.field_75380_a instanceof EntityTameable && ((EntityTameable)this.field_75380_a).func_70909_n()) {
            return false;
         }

         this.field_75376_d = this.field_75380_a.field_70170_p.func_72890_a(this.field_75380_a, (double)this.field_75377_e);
         if(this.field_75376_d == null) {
            return false;
         }
      } else {
         List var1 = this.field_75380_a.field_70170_p.func_82733_a(this.field_75381_h, this.field_75380_a.field_70121_D.func_72314_b((double)this.field_75377_e, 3.0D, (double)this.field_75377_e), this.field_98218_a);
         if(var1.isEmpty()) {
            return false;
         }

         this.field_75376_d = (Entity)var1.get(0);
      }

      Vec3 var2 = RandomPositionGenerator.func_75461_b(this.field_75380_a, 16, 7, this.field_75380_a.field_70170_p.func_82732_R().func_72345_a(this.field_75376_d.field_70165_t, this.field_75376_d.field_70163_u, this.field_75376_d.field_70161_v));
      if(var2 == null) {
         return false;
      } else if(this.field_75376_d.func_70092_e(var2.field_72450_a, var2.field_72448_b, var2.field_72449_c) < this.field_75376_d.func_70068_e(this.field_75380_a)) {
         return false;
      } else {
         this.field_75374_f = this.field_75375_g.func_75488_a(var2.field_72450_a, var2.field_72448_b, var2.field_72449_c);
         return this.field_75374_f == null?false:this.field_75374_f.func_75880_b(var2);
      }
   }

   public boolean func_75253_b() {
      return !this.field_75375_g.func_75500_f();
   }

   public void func_75249_e() {
      this.field_75375_g.func_75484_a(this.field_75374_f, this.field_75378_b);
   }

   public void func_75251_c() {
      this.field_75376_d = null;
   }

   public void func_75246_d() {
      if(this.field_75380_a.func_70068_e(this.field_75376_d) < 49.0D) {
         this.field_75380_a.func_70661_as().func_75489_a(this.field_75379_c);
      } else {
         this.field_75380_a.func_70661_as().func_75489_a(this.field_75378_b);
      }

   }

   // $FF: synthetic method
   static EntityCreature func_98217_a(EntityAIAvoidEntity p_98217_0_) {
      return p_98217_0_.field_75380_a;
   }
}
