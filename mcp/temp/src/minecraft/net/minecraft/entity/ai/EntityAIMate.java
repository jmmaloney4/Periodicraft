package net.minecraft.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityAIMate extends EntityAIBase {

   private EntityAnimal field_75390_d;
   World field_75394_a;
   private EntityAnimal field_75391_e;
   int field_75392_b = 0;
   float field_75393_c;


   public EntityAIMate(EntityAnimal p_i3461_1_, float p_i3461_2_) {
      this.field_75390_d = p_i3461_1_;
      this.field_75394_a = p_i3461_1_.field_70170_p;
      this.field_75393_c = p_i3461_2_;
      this.func_75248_a(3);
   }

   public boolean func_75250_a() {
      if(!this.field_75390_d.func_70880_s()) {
         return false;
      } else {
         this.field_75391_e = this.func_75389_f();
         return this.field_75391_e != null;
      }
   }

   public boolean func_75253_b() {
      return this.field_75391_e.func_70089_S() && this.field_75391_e.func_70880_s() && this.field_75392_b < 60;
   }

   public void func_75251_c() {
      this.field_75391_e = null;
      this.field_75392_b = 0;
   }

   public void func_75246_d() {
      this.field_75390_d.func_70671_ap().func_75651_a(this.field_75391_e, 10.0F, (float)this.field_75390_d.func_70646_bf());
      this.field_75390_d.func_70661_as().func_75497_a(this.field_75391_e, this.field_75393_c);
      ++this.field_75392_b;
      if(this.field_75392_b >= 60 && this.field_75390_d.func_70068_e(this.field_75391_e) < 9.0D) {
         this.func_75388_i();
      }

   }

   private EntityAnimal func_75389_f() {
      float var1 = 8.0F;
      List var2 = this.field_75394_a.func_72872_a(this.field_75390_d.getClass(), this.field_75390_d.field_70121_D.func_72314_b((double)var1, (double)var1, (double)var1));
      double var3 = Double.MAX_VALUE;
      EntityAnimal var5 = null;
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         EntityAnimal var7 = (EntityAnimal)var6.next();
         if(this.field_75390_d.func_70878_b(var7) && this.field_75390_d.func_70068_e(var7) < var3) {
            var5 = var7;
            var3 = this.field_75390_d.func_70068_e(var7);
         }
      }

      return var5;
   }

   private void func_75388_i() {
      EntityAgeable var1 = this.field_75390_d.func_90011_a(this.field_75391_e);
      if(var1 != null) {
         this.field_75390_d.func_70873_a(6000);
         this.field_75391_e.func_70873_a(6000);
         this.field_75390_d.func_70875_t();
         this.field_75391_e.func_70875_t();
         var1.func_70873_a(-24000);
         var1.func_70012_b(this.field_75390_d.field_70165_t, this.field_75390_d.field_70163_u, this.field_75390_d.field_70161_v, 0.0F, 0.0F);
         this.field_75394_a.func_72838_d(var1);
         Random var2 = this.field_75390_d.func_70681_au();

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = var2.nextGaussian() * 0.02D;
            double var6 = var2.nextGaussian() * 0.02D;
            double var8 = var2.nextGaussian() * 0.02D;
            this.field_75394_a.func_72869_a("heart", this.field_75390_d.field_70165_t + (double)(var2.nextFloat() * this.field_75390_d.field_70130_N * 2.0F) - (double)this.field_75390_d.field_70130_N, this.field_75390_d.field_70163_u + 0.5D + (double)(var2.nextFloat() * this.field_75390_d.field_70131_O), this.field_75390_d.field_70161_v + (double)(var2.nextFloat() * this.field_75390_d.field_70130_N * 2.0F) - (double)this.field_75390_d.field_70130_N, var4, var6, var8);
         }

         this.field_75394_a.func_72838_d(new EntityXPOrb(this.field_75394_a, this.field_75390_d.field_70165_t, this.field_75390_d.field_70163_u, this.field_75390_d.field_70161_v, var2.nextInt(7) + 1));
      }
   }
}
