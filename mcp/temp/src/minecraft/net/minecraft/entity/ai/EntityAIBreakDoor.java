package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class EntityAIBreakDoor extends EntityAIDoorInteract {

   private int field_75359_i;
   private int field_75358_j = -1;


   public EntityAIBreakDoor(EntityLiving p_i3460_1_) {
      super(p_i3460_1_);
   }

   public boolean func_75250_a() {
      return !super.func_75250_a()?false:(!this.field_75356_a.field_70170_p.func_82736_K().func_82766_b("mobGriefing")?false:!this.field_75353_e.func_72233_a_(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d));
   }

   public void func_75249_e() {
      super.func_75249_e();
      this.field_75359_i = 0;
   }

   public boolean func_75253_b() {
      double var1 = this.field_75356_a.func_70092_e((double)this.field_75354_b, (double)this.field_75355_c, (double)this.field_75352_d);
      return this.field_75359_i <= 240 && !this.field_75353_e.func_72233_a_(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d) && var1 < 4.0D;
   }

   public void func_75251_c() {
      super.func_75251_c();
      this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, -1);
   }

   public void func_75246_d() {
      super.func_75246_d();
      if(this.field_75356_a.func_70681_au().nextInt(20) == 0) {
         this.field_75356_a.field_70170_p.func_72926_e(1010, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
      }

      ++this.field_75359_i;
      int var1 = (int)((float)this.field_75359_i / 240.0F * 10.0F);
      if(var1 != this.field_75358_j) {
         this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, var1);
         this.field_75358_j = var1;
      }

      if(this.field_75359_i == 240 && this.field_75356_a.field_70170_p.field_73013_u == 3) {
         this.field_75356_a.field_70170_p.func_94571_i(this.field_75354_b, this.field_75355_c, this.field_75352_d);
         this.field_75356_a.field_70170_p.func_72926_e(1012, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
         this.field_75356_a.field_70170_p.func_72926_e(2001, this.field_75354_b, this.field_75355_c, this.field_75352_d, this.field_75353_e.field_71990_ca);
      }

   }
}
