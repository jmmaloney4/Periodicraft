package net.minecraft.entity.passive;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityWaterMob extends EntityCreature implements IAnimals {

   public EntityWaterMob(World p_i3525_1_) {
      super(p_i3525_1_);
   }

   public boolean func_70648_aU() {
      return true;
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D);
   }

   public int func_70627_aG() {
      return 120;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   protected int func_70693_a(EntityPlayer p_70693_1_) {
      return 1 + this.field_70170_p.field_73012_v.nextInt(3);
   }

   public void func_70030_z() {
      int var1 = this.func_70086_ai();
      super.func_70030_z();
      if(this.func_70089_S() && !this.func_70055_a(Material.field_76244_g)) {
         --var1;
         this.func_70050_g(var1);
         if(this.func_70086_ai() == -20) {
            this.func_70050_g(0);
            this.func_70097_a(DamageSource.field_76369_e, 2);
         }
      } else {
         this.func_70050_g(300);
      }

   }
}
