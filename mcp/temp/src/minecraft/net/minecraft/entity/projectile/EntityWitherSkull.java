package net.minecraft.entity.projectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityWitherSkull extends EntityFireball {

   public EntityWitherSkull(World p_i5072_1_) {
      super(p_i5072_1_);
      this.func_70105_a(0.3125F, 0.3125F);
   }

   public EntityWitherSkull(World p_i5073_1_, EntityLiving p_i5073_2_, double p_i5073_3_, double p_i5073_5_, double p_i5073_7_) {
      super(p_i5073_1_, p_i5073_2_, p_i5073_3_, p_i5073_5_, p_i5073_7_);
      this.func_70105_a(0.3125F, 0.3125F);
   }

   protected float func_82341_c() {
      return this.func_82342_d()?0.73F:super.func_82341_c();
   }

   @SideOnly(Side.CLIENT)
   public EntityWitherSkull(World p_i5074_1_, double p_i5074_2_, double p_i5074_4_, double p_i5074_6_, double p_i5074_8_, double p_i5074_10_, double p_i5074_12_) {
      super(p_i5074_1_, p_i5074_2_, p_i5074_4_, p_i5074_6_, p_i5074_8_, p_i5074_10_, p_i5074_12_);
      this.func_70105_a(0.3125F, 0.3125F);
   }

   public boolean func_70027_ad() {
      return false;
   }

   public float func_82146_a(Explosion p_82146_1_, World p_82146_2_, int p_82146_3_, int p_82146_4_, int p_82146_5_, Block p_82146_6_) {
      float var7 = super.func_82146_a(p_82146_1_, p_82146_2_, p_82146_3_, p_82146_4_, p_82146_5_, p_82146_6_);
      if(this.func_82342_d() && p_82146_6_ != Block.field_71986_z && p_82146_6_ != Block.field_72102_bH && p_82146_6_ != Block.field_72104_bI) {
         var7 = Math.min(0.8F, var7);
      }

      return var7;
   }

   protected void func_70227_a(MovingObjectPosition p_70227_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(p_70227_1_.field_72308_g != null) {
            if(this.field_70235_a != null) {
               if(p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.field_70235_a), 8) && !p_70227_1_.field_72308_g.func_70089_S()) {
                  this.field_70235_a.func_70691_i(5);
               }
            } else {
               p_70227_1_.field_72308_g.func_70097_a(DamageSource.field_76376_m, 5);
            }

            if(p_70227_1_.field_72308_g instanceof EntityLiving) {
               byte var2 = 0;
               if(this.field_70170_p.field_73013_u > 1) {
                  if(this.field_70170_p.field_73013_u == 2) {
                     var2 = 10;
                  } else if(this.field_70170_p.field_73013_u == 3) {
                     var2 = 40;
                  }
               }

               if(var2 > 0) {
                  ((EntityLiving)p_70227_1_.field_72308_g).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 20 * var2, 1));
               }
            }
         }

         this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
         this.func_70106_y();
      }

   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(10, Byte.valueOf((byte)0));
   }

   public boolean func_82342_d() {
      return this.field_70180_af.func_75683_a(10) == 1;
   }

   public void func_82343_e(boolean p_82343_1_) {
      this.field_70180_af.func_75692_b(10, Byte.valueOf((byte)(p_82343_1_?1:0)));
   }
}
