package net.minecraft.village;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;

public class VillageSiege {

   private World field_75537_a;
   private boolean field_75535_b = false;
   private int field_75536_c = -1;
   private int field_75533_d;
   private int field_75534_e;
   private Village field_75531_f;
   private int field_75532_g;
   private int field_75538_h;
   private int field_75539_i;


   public VillageSiege(World p_i3512_1_) {
      this.field_75537_a = p_i3512_1_;
   }

   public void func_75528_a() {
      boolean var1 = false;
      if(var1) {
         if(this.field_75536_c == 2) {
            this.field_75533_d = 100;
            return;
         }
      } else {
         if(this.field_75537_a.func_72935_r()) {
            this.field_75536_c = 0;
            return;
         }

         if(this.field_75536_c == 2) {
            return;
         }

         if(this.field_75536_c == 0) {
            float var2 = this.field_75537_a.func_72826_c(0.0F);
            if((double)var2 < 0.5D || (double)var2 > 0.501D) {
               return;
            }

            this.field_75536_c = this.field_75537_a.field_73012_v.nextInt(10) == 0?1:2;
            this.field_75535_b = false;
            if(this.field_75536_c == 2) {
               return;
            }
         }
      }

      if(!this.field_75535_b) {
         if(!this.func_75529_b()) {
            return;
         }

         this.field_75535_b = true;
      }

      if(this.field_75534_e > 0) {
         --this.field_75534_e;
      } else {
         this.field_75534_e = 2;
         if(this.field_75533_d > 0) {
            this.func_75530_c();
            --this.field_75533_d;
         } else {
            this.field_75536_c = 2;
         }

      }
   }

   private boolean func_75529_b() {
      List var1 = this.field_75537_a.field_73010_i;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         EntityPlayer var3 = (EntityPlayer)var2.next();
         this.field_75531_f = this.field_75537_a.field_72982_D.func_75550_a((int)var3.field_70165_t, (int)var3.field_70163_u, (int)var3.field_70161_v, 1);
         if(this.field_75531_f != null && this.field_75531_f.func_75567_c() >= 10 && this.field_75531_f.func_75561_d() >= 20 && this.field_75531_f.func_75562_e() >= 20) {
            ChunkCoordinates var4 = this.field_75531_f.func_75577_a();
            float var5 = (float)this.field_75531_f.func_75568_b();
            boolean var6 = false;
            int var7 = 0;

            while(true) {
               if(var7 < 10) {
                  this.field_75532_g = var4.field_71574_a + (int)((double)(MathHelper.func_76134_b(this.field_75537_a.field_73012_v.nextFloat() * 3.1415927F * 2.0F) * var5) * 0.9D);
                  this.field_75538_h = var4.field_71572_b;
                  this.field_75539_i = var4.field_71573_c + (int)((double)(MathHelper.func_76126_a(this.field_75537_a.field_73012_v.nextFloat() * 3.1415927F * 2.0F) * var5) * 0.9D);
                  var6 = false;
                  Iterator var8 = this.field_75537_a.field_72982_D.func_75540_b().iterator();

                  while(var8.hasNext()) {
                     Village var9 = (Village)var8.next();
                     if(var9 != this.field_75531_f && var9.func_75570_a(this.field_75532_g, this.field_75538_h, this.field_75539_i)) {
                        var6 = true;
                        break;
                     }
                  }

                  if(var6) {
                     ++var7;
                     continue;
                  }
               }

               if(var6) {
                  return false;
               }

               Vec3 var10 = this.func_75527_a(this.field_75532_g, this.field_75538_h, this.field_75539_i);
               if(var10 != null) {
                  this.field_75534_e = 0;
                  this.field_75533_d = 20;
                  return true;
               }
               break;
            }
         }
      }

      return false;
   }

   private boolean func_75530_c() {
      Vec3 var1 = this.func_75527_a(this.field_75532_g, this.field_75538_h, this.field_75539_i);
      if(var1 == null) {
         return false;
      } else {
         EntityZombie var2;
         try {
            var2 = new EntityZombie(this.field_75537_a);
            var2.func_82163_bD();
            var2.func_82229_g(false);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.func_70012_b(var1.field_72450_a, var1.field_72448_b, var1.field_72449_c, this.field_75537_a.field_73012_v.nextFloat() * 360.0F, 0.0F);
         this.field_75537_a.func_72838_d(var2);
         ChunkCoordinates var3 = this.field_75531_f.func_75577_a();
         var2.func_70598_b(var3.field_71574_a, var3.field_71572_b, var3.field_71573_c, this.field_75531_f.func_75568_b());
         return true;
      }
   }

   private Vec3 func_75527_a(int p_75527_1_, int p_75527_2_, int p_75527_3_) {
      for(int var4 = 0; var4 < 10; ++var4) {
         int var5 = p_75527_1_ + this.field_75537_a.field_73012_v.nextInt(16) - 8;
         int var6 = p_75527_2_ + this.field_75537_a.field_73012_v.nextInt(6) - 3;
         int var7 = p_75527_3_ + this.field_75537_a.field_73012_v.nextInt(16) - 8;
         if(this.field_75531_f.func_75570_a(var5, var6, var7) && SpawnerAnimals.func_77190_a(EnumCreatureType.monster, this.field_75537_a, var5, var6, var7)) {
            this.field_75537_a.func_82732_R().func_72345_a((double)var5, (double)var6, (double)var7);
         }
      }

      return null;
   }
}
