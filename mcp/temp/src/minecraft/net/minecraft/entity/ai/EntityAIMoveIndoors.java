package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;

public class EntityAIMoveIndoors extends EntityAIBase {

   private EntityCreature field_75424_a;
   private VillageDoorInfo field_75422_b;
   private int field_75423_c = -1;
   private int field_75421_d = -1;


   public EntityAIMoveIndoors(EntityCreature p_i3478_1_) {
      this.field_75424_a = p_i3478_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if((!this.field_75424_a.field_70170_p.func_72935_r() || this.field_75424_a.field_70170_p.func_72896_J()) && !this.field_75424_a.field_70170_p.field_73011_w.field_76576_e) {
         if(this.field_75424_a.func_70681_au().nextInt(50) != 0) {
            return false;
         } else if(this.field_75423_c != -1 && this.field_75424_a.func_70092_e((double)this.field_75423_c, this.field_75424_a.field_70163_u, (double)this.field_75421_d) < 4.0D) {
            return false;
         } else {
            Village var1 = this.field_75424_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_75424_a.field_70165_t), MathHelper.func_76128_c(this.field_75424_a.field_70163_u), MathHelper.func_76128_c(this.field_75424_a.field_70161_v), 14);
            if(var1 == null) {
               return false;
            } else {
               this.field_75422_b = var1.func_75569_c(MathHelper.func_76128_c(this.field_75424_a.field_70165_t), MathHelper.func_76128_c(this.field_75424_a.field_70163_u), MathHelper.func_76128_c(this.field_75424_a.field_70161_v));
               return this.field_75422_b != null;
            }
         }
      } else {
         return false;
      }
   }

   public boolean func_75253_b() {
      return !this.field_75424_a.func_70661_as().func_75500_f();
   }

   public void func_75249_e() {
      this.field_75423_c = -1;
      if(this.field_75424_a.func_70092_e((double)this.field_75422_b.func_75471_a(), (double)this.field_75422_b.field_75479_b, (double)this.field_75422_b.func_75472_c()) > 256.0D) {
         Vec3 var1 = RandomPositionGenerator.func_75464_a(this.field_75424_a, 14, 3, this.field_75424_a.field_70170_p.func_82732_R().func_72345_a((double)this.field_75422_b.func_75471_a() + 0.5D, (double)this.field_75422_b.func_75473_b(), (double)this.field_75422_b.func_75472_c() + 0.5D));
         if(var1 != null) {
            this.field_75424_a.func_70661_as().func_75492_a(var1.field_72450_a, var1.field_72448_b, var1.field_72449_c, 0.3F);
         }
      } else {
         this.field_75424_a.func_70661_as().func_75492_a((double)this.field_75422_b.func_75471_a() + 0.5D, (double)this.field_75422_b.func_75473_b(), (double)this.field_75422_b.func_75472_c() + 0.5D, 0.3F);
      }

   }

   public void func_75251_c() {
      this.field_75423_c = this.field_75422_b.func_75471_a();
      this.field_75421_d = this.field_75422_b.func_75472_c();
      this.field_75422_b = null;
   }
}
