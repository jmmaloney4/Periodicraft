package net.minecraft.entity.monster;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public abstract class EntityMob extends EntityCreature implements IMob {

   public EntityMob(World p_i3552_1_) {
      super(p_i3552_1_);
      this.field_70728_aV = 5;
   }

   public void func_70636_d() {
      this.func_82168_bl();
      float var1 = this.func_70013_c(1.0F);
      if(var1 > 0.5F) {
         this.field_70708_bq += 2;
      }

      super.func_70636_d();
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
         this.func_70106_y();
      }

   }

   protected Entity func_70782_k() {
      EntityPlayer var1 = this.field_70170_p.func_72856_b(this, 16.0D);
      return var1 != null && this.func_70685_l(var1)?var1:null;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else if(super.func_70097_a(p_70097_1_, p_70097_2_)) {
         Entity var3 = p_70097_1_.func_76346_g();
         if(this.field_70153_n != var3 && this.field_70154_o != var3) {
            if(var3 != this) {
               this.field_70789_a = var3;
            }

            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      int var2 = this.func_82193_c(p_70652_1_);
      if(this.func_70644_a(Potion.field_76420_g)) {
         var2 += 3 << this.func_70660_b(Potion.field_76420_g).func_76458_c();
      }

      if(this.func_70644_a(Potion.field_76437_t)) {
         var2 -= 2 << this.func_70660_b(Potion.field_76437_t).func_76458_c();
      }

      int var3 = 0;
      if(p_70652_1_ instanceof EntityLiving) {
         var2 += EnchantmentHelper.func_77512_a(this, (EntityLiving)p_70652_1_);
         var3 += EnchantmentHelper.func_77507_b(this, (EntityLiving)p_70652_1_);
      }

      boolean var4 = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), var2);
      if(var4) {
         if(var3 > 0) {
            p_70652_1_.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
            this.field_70159_w *= 0.6D;
            this.field_70179_y *= 0.6D;
         }

         int var5 = EnchantmentHelper.func_90036_a(this);
         if(var5 > 0) {
            p_70652_1_.func_70015_d(var5 * 4);
         }

         if(p_70652_1_ instanceof EntityLiving) {
            EnchantmentThorns.func_92096_a(this, (EntityLiving)p_70652_1_, this.field_70146_Z);
         }
      }

      return var4;
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      if(this.field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(p_70785_1_);
      }

   }

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return 0.5F - this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_);
   }

   protected boolean func_70814_o() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, var1, var2, var3) > this.field_70146_Z.nextInt(32)) {
         return false;
      } else {
         int var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
         if(this.field_70170_p.func_72911_I()) {
            int var5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
            this.field_70170_p.field_73008_k = var5;
         }

         return var4 <= this.field_70146_Z.nextInt(8);
      }
   }

   public boolean func_70601_bi() {
      return this.func_70814_o() && super.func_70601_bi();
   }

   public int func_82193_c(Entity p_82193_1_) {
      return 2;
   }
}
