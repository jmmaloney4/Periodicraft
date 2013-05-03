package net.minecraft.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnderman extends EntityMob {

   public static boolean[] field_70827_d = new boolean[256];
   private int field_70828_e = 0;
   private int field_70826_g = 0;


   public EntityEnderman(World p_i3548_1_) {
      super(p_i3548_1_);
      this.field_70750_az = "/mob/enderman.png";
      this.field_70697_bw = 0.2F;
      this.func_70105_a(0.6F, 2.9F);
      this.field_70138_W = 1.0F;
   }

   public int func_70667_aM() {
      return 40;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
      this.field_70180_af.func_75682_a(17, new Byte((byte)0));
      this.field_70180_af.func_75682_a(18, new Byte((byte)0));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74777_a("carried", (short)this.func_70822_p());
      p_70014_1_.func_74777_a("carriedData", (short)this.func_70824_q());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70818_a(p_70037_1_.func_74765_d("carried"));
      this.func_70817_b(p_70037_1_.func_74765_d("carriedData"));
   }

   protected Entity func_70782_k() {
      EntityPlayer var1 = this.field_70170_p.func_72856_b(this, 64.0D);
      if(var1 != null) {
         if(this.func_70821_d(var1)) {
            if(this.field_70826_g == 0) {
               this.field_70170_p.func_72956_a(var1, "mob.endermen.stare", 1.0F, 1.0F);
            }

            if(this.field_70826_g++ == 5) {
               this.field_70826_g = 0;
               this.func_70819_e(true);
               return var1;
            }
         } else {
            this.field_70826_g = 0;
         }
      }

      return null;
   }

   private boolean func_70821_d(EntityPlayer p_70821_1_) {
      ItemStack var2 = p_70821_1_.field_71071_by.field_70460_b[3];
      if(var2 != null && var2.field_77993_c == Block.field_72061_ba.field_71990_ca) {
         return false;
      } else {
         Vec3 var3 = p_70821_1_.func_70676_i(1.0F).func_72432_b();
         Vec3 var4 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t - p_70821_1_.field_70165_t, this.field_70121_D.field_72338_b + (double)(this.field_70131_O / 2.0F) - (p_70821_1_.field_70163_u + (double)p_70821_1_.func_70047_e()), this.field_70161_v - p_70821_1_.field_70161_v);
         double var5 = var4.func_72433_c();
         var4 = var4.func_72432_b();
         double var7 = var3.func_72430_b(var4);
         return var7 > 1.0D - 0.025D / var5?p_70821_1_.func_70685_l(this):false;
      }
   }

   public void func_70636_d() {
      if(this.func_70026_G()) {
         this.func_70097_a(DamageSource.field_76369_e, 1);
      }

      this.field_70697_bw = this.field_70789_a != null?6.5F:0.3F;
      int var1;
      if(!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
         int var2;
         int var3;
         int var4;
         if(this.func_70822_p() == 0) {
            if(this.field_70146_Z.nextInt(20) == 0) {
               var1 = MathHelper.func_76128_c(this.field_70165_t - 2.0D + this.field_70146_Z.nextDouble() * 4.0D);
               var2 = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextDouble() * 3.0D);
               var3 = MathHelper.func_76128_c(this.field_70161_v - 2.0D + this.field_70146_Z.nextDouble() * 4.0D);
               var4 = this.field_70170_p.func_72798_a(var1, var2, var3);
               if(field_70827_d[var4]) {
                  this.func_70818_a(this.field_70170_p.func_72798_a(var1, var2, var3));
                  this.func_70817_b(this.field_70170_p.func_72805_g(var1, var2, var3));
                  this.field_70170_p.func_94575_c(var1, var2, var3, 0);
               }
            }
         } else if(this.field_70146_Z.nextInt(2000) == 0) {
            var1 = MathHelper.func_76128_c(this.field_70165_t - 1.0D + this.field_70146_Z.nextDouble() * 2.0D);
            var2 = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D);
            var3 = MathHelper.func_76128_c(this.field_70161_v - 1.0D + this.field_70146_Z.nextDouble() * 2.0D);
            var4 = this.field_70170_p.func_72798_a(var1, var2, var3);
            int var5 = this.field_70170_p.func_72798_a(var1, var2 - 1, var3);
            if(var4 == 0 && var5 > 0 && Block.field_71973_m[var5].func_71886_c()) {
               this.field_70170_p.func_72832_d(var1, var2, var3, this.func_70822_p(), this.func_70824_q(), 3);
               this.func_70818_a(0);
            }
         }
      }

      for(var1 = 0; var1 < 2; ++var1) {
         this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25D, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
      }

      if(this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
         float var6 = this.func_70013_c(1.0F);
         if(var6 > 0.5F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0F < (var6 - 0.4F) * 2.0F) {
            this.field_70789_a = null;
            this.func_70819_e(false);
            this.func_70820_n();
         }
      }

      if(this.func_70026_G() || this.func_70027_ad()) {
         this.field_70789_a = null;
         this.func_70819_e(false);
         this.func_70820_n();
      }

      this.field_70703_bu = false;
      if(this.field_70789_a != null) {
         this.func_70625_a(this.field_70789_a, 100.0F, 100.0F);
      }

      if(!this.field_70170_p.field_72995_K && this.func_70089_S()) {
         if(this.field_70789_a != null) {
            if(this.field_70789_a instanceof EntityPlayer && this.func_70821_d((EntityPlayer)this.field_70789_a)) {
               this.field_70702_br = this.field_70701_bs = 0.0F;
               this.field_70697_bw = 0.0F;
               if(this.field_70789_a.func_70068_e(this) < 16.0D) {
                  this.func_70820_n();
               }

               this.field_70828_e = 0;
            } else if(this.field_70789_a.func_70068_e(this) > 256.0D && this.field_70828_e++ >= 30 && this.func_70816_c(this.field_70789_a)) {
               this.field_70828_e = 0;
            }
         } else {
            this.func_70819_e(false);
            this.field_70828_e = 0;
         }
      }

      super.func_70636_d();
   }

   protected boolean func_70820_n() {
      double var1 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(64) - 32);
      double var5 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * 64.0D;
      return this.func_70825_j(var1, var3, var5);
   }

   protected boolean func_70816_c(Entity p_70816_1_) {
      Vec3 var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t - p_70816_1_.field_70165_t, this.field_70121_D.field_72338_b + (double)(this.field_70131_O / 2.0F) - p_70816_1_.field_70163_u + (double)p_70816_1_.func_70047_e(), this.field_70161_v - p_70816_1_.field_70161_v);
      var2 = var2.func_72432_b();
      double var3 = 16.0D;
      double var5 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * 8.0D - var2.field_72450_a * var3;
      double var7 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(16) - 8) - var2.field_72448_b * var3;
      double var9 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * 8.0D - var2.field_72449_c * var3;
      return this.func_70825_j(var5, var7, var9);
   }

   protected boolean func_70825_j(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
      double var7 = this.field_70165_t;
      double var9 = this.field_70163_u;
      double var11 = this.field_70161_v;
      this.field_70165_t = p_70825_1_;
      this.field_70163_u = p_70825_3_;
      this.field_70161_v = p_70825_5_;
      boolean var13 = false;
      int var14 = MathHelper.func_76128_c(this.field_70165_t);
      int var15 = MathHelper.func_76128_c(this.field_70163_u);
      int var16 = MathHelper.func_76128_c(this.field_70161_v);
      int var18;
      if(this.field_70170_p.func_72899_e(var14, var15, var16)) {
         boolean var17 = false;

         while(!var17 && var15 > 0) {
            var18 = this.field_70170_p.func_72798_a(var14, var15 - 1, var16);
            if(var18 != 0 && Block.field_71973_m[var18].field_72018_cp.func_76230_c()) {
               var17 = true;
            } else {
               --this.field_70163_u;
               --var15;
            }
         }

         if(var17) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if(this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
               var13 = true;
            }
         }
      }

      if(!var13) {
         this.func_70107_b(var7, var9, var11);
         return false;
      } else {
         short var30 = 128;

         for(var18 = 0; var18 < var30; ++var18) {
            double var19 = (double)var18 / ((double)var30 - 1.0D);
            float var21 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
            float var22 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
            float var23 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
            double var24 = var7 + (this.field_70165_t - var7) * var19 + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N * 2.0D;
            double var26 = var9 + (this.field_70163_u - var9) * var19 + this.field_70146_Z.nextDouble() * (double)this.field_70131_O;
            double var28 = var11 + (this.field_70161_v - var11) * var19 + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N * 2.0D;
            this.field_70170_p.func_72869_a("portal", var24, var26, var28, (double)var21, (double)var22, (double)var23);
         }

         this.field_70170_p.func_72908_a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
         this.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
         return true;
      }
   }

   protected String func_70639_aQ() {
      return this.func_70823_r()?"mob.endermen.scream":"mob.endermen.idle";
   }

   protected String func_70621_aR() {
      return "mob.endermen.hit";
   }

   protected String func_70673_aS() {
      return "mob.endermen.death";
   }

   protected int func_70633_aT() {
      return Item.field_77730_bn.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.func_70633_aT();
      if(var3 > 0) {
         int var4 = this.field_70146_Z.nextInt(2 + p_70628_2_);

         for(int var5 = 0; var5 < var4; ++var5) {
            this.func_70025_b(var3, 1);
         }
      }

   }

   public void func_70818_a(int p_70818_1_) {
      this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(p_70818_1_ & 255)));
   }

   public int func_70822_p() {
      return this.field_70180_af.func_75683_a(16);
   }

   public void func_70817_b(int p_70817_1_) {
      this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70817_1_ & 255)));
   }

   public int func_70824_q() {
      return this.field_70180_af.func_75683_a(17);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         this.func_70819_e(true);
         if(p_70097_1_ instanceof EntityDamageSourceIndirect) {
            for(int var3 = 0; var3 < 64; ++var3) {
               if(this.func_70820_n()) {
                  return true;
               }
            }

            return false;
         } else {
            return super.func_70097_a(p_70097_1_, p_70097_2_);
         }
      }
   }

   public boolean func_70823_r() {
      return this.field_70180_af.func_75683_a(18) > 0;
   }

   public void func_70819_e(boolean p_70819_1_) {
      this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)(p_70819_1_?1:0)));
   }

   public int func_82193_c(Entity p_82193_1_) {
      return 7;
   }

   static {
      field_70827_d[Block.field_71980_u.field_71990_ca] = true;
      field_70827_d[Block.field_71979_v.field_71990_ca] = true;
      field_70827_d[Block.field_71939_E.field_71990_ca] = true;
      field_70827_d[Block.field_71940_F.field_71990_ca] = true;
      field_70827_d[Block.field_72097_ad.field_71990_ca] = true;
      field_70827_d[Block.field_72107_ae.field_71990_ca] = true;
      field_70827_d[Block.field_72109_af.field_71990_ca] = true;
      field_70827_d[Block.field_72103_ag.field_71990_ca] = true;
      field_70827_d[Block.field_72091_am.field_71990_ca] = true;
      field_70827_d[Block.field_72038_aV.field_71990_ca] = true;
      field_70827_d[Block.field_72041_aW.field_71990_ca] = true;
      field_70827_d[Block.field_72061_ba.field_71990_ca] = true;
      field_70827_d[Block.field_71997_br.field_71990_ca] = true;
      field_70827_d[Block.field_71994_by.field_71990_ca] = true;
   }
}
