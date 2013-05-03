package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.WeightedRandomMinecart;
import net.minecraft.world.World;

class TileEntityMobSpawnerLogic extends MobSpawnerBaseLogic {

   // $FF: synthetic field
   final TileEntityMobSpawner field_98295_a;


   TileEntityMobSpawnerLogic(TileEntityMobSpawner p_i11046_1_) {
      this.field_98295_a = p_i11046_1_;
   }

   public void func_98267_a(int p_98267_1_) {
      this.field_98295_a.field_70331_k.func_72965_b(this.field_98295_a.field_70329_l, this.field_98295_a.field_70330_m, this.field_98295_a.field_70327_n, Block.field_72065_as.field_71990_ca, p_98267_1_, 0);
   }

   public World func_98271_a() {
      return this.field_98295_a.field_70331_k;
   }

   public int func_98275_b() {
      return this.field_98295_a.field_70329_l;
   }

   public int func_98274_c() {
      return this.field_98295_a.field_70330_m;
   }

   public int func_98266_d() {
      return this.field_98295_a.field_70327_n;
   }

   public void func_98277_a(WeightedRandomMinecart p_98277_1_) {
      super.func_98277_a(p_98277_1_);
      if(this.func_98271_a() != null) {
         this.func_98271_a().func_72845_h(this.field_98295_a.field_70329_l, this.field_98295_a.field_70330_m, this.field_98295_a.field_70327_n);
      }

   }
}
