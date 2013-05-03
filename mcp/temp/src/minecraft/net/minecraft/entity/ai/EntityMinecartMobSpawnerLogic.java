package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

class EntityMinecartMobSpawnerLogic extends MobSpawnerBaseLogic {

   // $FF: synthetic field
   final EntityMinecartMobSpawner field_98296_a;


   EntityMinecartMobSpawnerLogic(EntityMinecartMobSpawner p_i11038_1_) {
      this.field_98296_a = p_i11038_1_;
   }

   public void func_98267_a(int p_98267_1_) {
      this.field_98296_a.field_70170_p.func_72960_a(this.field_98296_a, (byte)p_98267_1_);
   }

   public World func_98271_a() {
      return this.field_98296_a.field_70170_p;
   }

   public int func_98275_b() {
      return MathHelper.func_76128_c(this.field_98296_a.field_70165_t);
   }

   public int func_98274_c() {
      return MathHelper.func_76128_c(this.field_98296_a.field_70163_u);
   }

   public int func_98266_d() {
      return MathHelper.func_76128_c(this.field_98296_a.field_70161_v);
   }
}
