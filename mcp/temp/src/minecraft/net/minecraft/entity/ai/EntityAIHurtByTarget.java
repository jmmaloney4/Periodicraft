package net.minecraft.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public class EntityAIHurtByTarget extends EntityAITarget {

   boolean field_75312_a;
   EntityLiving field_75311_b;


   public EntityAIHurtByTarget(EntityLiving p_i3498_1_, boolean p_i3498_2_) {
      super(p_i3498_1_, 16.0F, false);
      this.field_75312_a = p_i3498_2_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      return this.func_75296_a(this.field_75299_d.func_70643_av(), true);
   }

   public boolean func_75253_b() {
      return this.field_75299_d.func_70643_av() != null && this.field_75299_d.func_70643_av() != this.field_75311_b;
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75299_d.func_70643_av());
      this.field_75311_b = this.field_75299_d.func_70643_av();
      if(this.field_75312_a) {
         List var1 = this.field_75299_d.field_70170_p.func_72872_a(this.field_75299_d.getClass(), AxisAlignedBB.func_72332_a().func_72299_a(this.field_75299_d.field_70165_t, this.field_75299_d.field_70163_u, this.field_75299_d.field_70161_v, this.field_75299_d.field_70165_t + 1.0D, this.field_75299_d.field_70163_u + 1.0D, this.field_75299_d.field_70161_v + 1.0D).func_72314_b((double)this.field_75300_e, 10.0D, (double)this.field_75300_e));
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            EntityLiving var3 = (EntityLiving)var2.next();
            if(this.field_75299_d != var3 && var3.func_70638_az() == null) {
               var3.func_70624_b(this.field_75299_d.func_70643_av());
            }
         }
      }

      super.func_75249_e();
   }

   public void func_75251_c() {
      if(this.field_75299_d.func_70638_az() != null && this.field_75299_d.func_70638_az() instanceof EntityPlayer && ((EntityPlayer)this.field_75299_d.func_70638_az()).field_71075_bZ.field_75102_a) {
         super.func_75251_c();
      }

   }
}
