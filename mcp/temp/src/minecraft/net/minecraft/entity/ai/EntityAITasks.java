package net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITaskEntry;
import net.minecraft.profiler.Profiler;

public class EntityAITasks {

   public List field_75782_a = new ArrayList();
   private List field_75780_b = new ArrayList();
   private final Profiler field_75781_c;
   private int field_75778_d = 0;
   private int field_75779_e = 3;


   public EntityAITasks(Profiler p_i3469_1_) {
      this.field_75781_c = p_i3469_1_;
   }

   public void func_75776_a(int p_75776_1_, EntityAIBase p_75776_2_) {
      this.field_75782_a.add(new EntityAITaskEntry(this, p_75776_1_, p_75776_2_));
   }

   public void func_85156_a(EntityAIBase p_85156_1_) {
      Iterator var2 = this.field_75782_a.iterator();

      while(var2.hasNext()) {
         EntityAITaskEntry var3 = (EntityAITaskEntry)var2.next();
         EntityAIBase var4 = var3.field_75733_a;
         if(var4 == p_85156_1_) {
            if(this.field_75780_b.contains(var3)) {
               var4.func_75251_c();
               this.field_75780_b.remove(var3);
            }

            var2.remove();
         }
      }

   }

   public void func_75774_a() {
      ArrayList var1 = new ArrayList();
      Iterator var2;
      EntityAITaskEntry var3;
      if(this.field_75778_d++ % this.field_75779_e == 0) {
         var2 = this.field_75782_a.iterator();

         while(var2.hasNext()) {
            var3 = (EntityAITaskEntry)var2.next();
            boolean var4 = this.field_75780_b.contains(var3);
            if(var4) {
               if(this.func_75775_b(var3) && this.func_75773_a(var3)) {
                  continue;
               }

               var3.field_75733_a.func_75251_c();
               this.field_75780_b.remove(var3);
            }

            if(this.func_75775_b(var3) && var3.field_75733_a.func_75250_a()) {
               var1.add(var3);
               this.field_75780_b.add(var3);
            }
         }
      } else {
         var2 = this.field_75780_b.iterator();

         while(var2.hasNext()) {
            var3 = (EntityAITaskEntry)var2.next();
            if(!var3.field_75733_a.func_75253_b()) {
               var3.field_75733_a.func_75251_c();
               var2.remove();
            }
         }
      }

      this.field_75781_c.func_76320_a("goalStart");
      var2 = var1.iterator();

      while(var2.hasNext()) {
         var3 = (EntityAITaskEntry)var2.next();
         this.field_75781_c.func_76320_a(var3.field_75733_a.getClass().getSimpleName());
         var3.field_75733_a.func_75249_e();
         this.field_75781_c.func_76319_b();
      }

      this.field_75781_c.func_76319_b();
      this.field_75781_c.func_76320_a("goalTick");
      var2 = this.field_75780_b.iterator();

      while(var2.hasNext()) {
         var3 = (EntityAITaskEntry)var2.next();
         var3.field_75733_a.func_75246_d();
      }

      this.field_75781_c.func_76319_b();
   }

   private boolean func_75773_a(EntityAITaskEntry p_75773_1_) {
      this.field_75781_c.func_76320_a("canContinue");
      boolean var2 = p_75773_1_.field_75733_a.func_75253_b();
      this.field_75781_c.func_76319_b();
      return var2;
   }

   private boolean func_75775_b(EntityAITaskEntry p_75775_1_) {
      this.field_75781_c.func_76320_a("canUse");
      Iterator var2 = this.field_75782_a.iterator();

      while(var2.hasNext()) {
         EntityAITaskEntry var3 = (EntityAITaskEntry)var2.next();
         if(var3 != p_75775_1_) {
            if(p_75775_1_.field_75731_b >= var3.field_75731_b) {
               if(this.field_75780_b.contains(var3) && !this.func_75777_a(p_75775_1_, var3)) {
                  this.field_75781_c.func_76319_b();
                  return false;
               }
            } else if(this.field_75780_b.contains(var3) && !var3.field_75733_a.func_75252_g()) {
               this.field_75781_c.func_76319_b();
               return false;
            }
         }
      }

      this.field_75781_c.func_76319_b();
      return true;
   }

   private boolean func_75777_a(EntityAITaskEntry p_75777_1_, EntityAITaskEntry p_75777_2_) {
      return (p_75777_1_.field_75733_a.func_75247_h() & p_75777_2_.field_75733_a.func_75247_h()) == 0;
   }
}
