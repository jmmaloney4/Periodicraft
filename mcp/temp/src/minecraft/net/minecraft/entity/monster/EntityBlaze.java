package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBlaze extends EntityMob {

   private float field_70847_d = 0.5F;
   private int field_70848_e;
   private int field_70846_g;


   public EntityBlaze(World p_i3545_1_) {
      super(p_i3545_1_);
      this.field_70750_az = "/mob/fire.png";
      this.field_70178_ae = true;
      this.field_70728_aV = 10;
   }

   public int func_70667_aM() {
      return 20;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
   }

   protected String func_70639_aQ() {
      return "mob.blaze.breathe";
   }

   protected String func_70621_aR() {
      return "mob.blaze.hit";
   }

   protected String func_70673_aS() {
      return "mob.blaze.death";
   }

   @SideOnly(Side.CLIENT)
   public int func_70070_b(float p_70070_1_) {
      return 15728880;
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }

   public void func_70636_d() {
      if(!this.field_70170_p.field_72995_K) {
         if(this.func_70026_G()) {
            this.func_70097_a(DamageSource.field_76369_e, 1);
         }

         --this.field_70848_e;
         if(this.field_70848_e <= 0) {
            this.field_70848_e = 100;
            this.field_70847_d = 0.5F + (float)this.field_70146_Z.nextGaussian() * 3.0F;
         }

         if(this.func_70777_m() != null && this.func_70777_m().field_70163_u + (double)this.func_70777_m().func_70047_e() > this.field_70163_u + (double)this.func_70047_e() + (double)this.field_70847_d) {
            this.field_70181_x += (0.30000001192092896D - this.field_70181_x) * 0.30000001192092896D;
         }
      }

      if(this.field_70146_Z.nextInt(24) == 0) {
         this.field_70170_p.func_72908_a(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "fire.fire", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F);
      }

      if(!this.field_70122_E && this.field_70181_x < 0.0D) {
         this.field_70181_x *= 0.6D;
      }

      for(int var1 = 0; var1 < 2; ++var1) {
         this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, 0.0D, 0.0D, 0.0D);
      }

      super.func_70636_d();
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      if(this.field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(p_70785_1_);
      } else if(p_70785_2_ < 30.0F) {
         double var3 = p_70785_1_.field_70165_t - this.field_70165_t;
         double var5 = p_70785_1_.field_70121_D.field_72338_b + (double)(p_70785_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(this.field_70131_O / 2.0F));
         double var7 = p_70785_1_.field_70161_v - this.field_70161_v;
         if(this.field_70724_aR == 0) {
            ++this.field_70846_g;
            if(this.field_70846_g == 1) {
               this.field_70724_aR = 60;
               this.func_70844_e(true);
            } else if(this.field_70846_g <= 4) {
               this.field_70724_aR = 6;
            } else {
               this.field_70724_aR = 100;
               this.field_70846_g = 0;
               this.func_70844_e(false);
            }

            if(this.field_70846_g > 1) {
               float var9 = MathHelper.func_76129_c(p_70785_2_) * 0.5F;
               this.field_70170_p.func_72889_a((EntityPlayer)null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);

               for(int var10 = 0; var10 < 1; ++var10) {
                  EntitySmallFireball var11 = new EntitySmallFireball(this.field_70170_p, this, var3 + this.field_70146_Z.nextGaussian() * (double)var9, var5, var7 + this.field_70146_Z.nextGaussian() * (double)var9);
                  var11.field_70163_u = this.field_70163_u + (double)(this.field_70131_O / 2.0F) + 0.5D;
                  this.field_70170_p.func_72838_d(var11);
               }
            }
         }

         this.field_70177_z = (float)(Math.atan2(var7, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
         this.field_70787_b = true;
      }

   }

   protected void func_70069_a(float p_70069_1_) {}

   protected int func_70633_aT() {
      return Item.field_77731_bo.field_77779_bT;
   }

   public boolean func_70027_ad() {
      return this.func_70845_n();
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      if(p_70628_1_) {
         int var3 = this.field_70146_Z.nextInt(2 + p_70628_2_);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.func_70025_b(Item.field_77731_bo.field_77779_bT, 1);
         }
      }

   }

   public boolean func_70845_n() {
      return (this.field_70180_af.func_75683_a(16) & 1) != 0;
   }

   public void func_70844_e(boolean p_70844_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if(p_70844_1_) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.field_70180_af.func_75692_b(16, Byte.valueOf(var2));
   }

   protected boolean func_70814_o() {
      return true;
   }

   public int func_82193_c(Entity p_82193_1_) {
      return 6;
   }
}
