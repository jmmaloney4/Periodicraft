package net.minecraft.potion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHealth;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StringUtils;

public class Potion {

   public static final Potion[] field_76425_a = new Potion[32];
   public static final Potion field_76423_b = null;
   public static final Potion field_76424_c = (new Potion(1, false, 8171462)).func_76390_b("potion.moveSpeed").func_76399_b(0, 0);
   public static final Potion field_76421_d = (new Potion(2, true, 5926017)).func_76390_b("potion.moveSlowdown").func_76399_b(1, 0);
   public static final Potion field_76422_e = (new Potion(3, false, 14270531)).func_76390_b("potion.digSpeed").func_76399_b(2, 0).func_76404_a(1.5D);
   public static final Potion field_76419_f = (new Potion(4, true, 4866583)).func_76390_b("potion.digSlowDown").func_76399_b(3, 0);
   public static final Potion field_76420_g = (new Potion(5, false, 9643043)).func_76390_b("potion.damageBoost").func_76399_b(4, 0);
   public static final Potion field_76432_h = (new PotionHealth(6, false, 16262179)).func_76390_b("potion.heal");
   public static final Potion field_76433_i = (new PotionHealth(7, true, 4393481)).func_76390_b("potion.harm");
   public static final Potion field_76430_j = (new Potion(8, false, 7889559)).func_76390_b("potion.jump").func_76399_b(2, 1);
   public static final Potion field_76431_k = (new Potion(9, true, 5578058)).func_76390_b("potion.confusion").func_76399_b(3, 1).func_76404_a(0.25D);
   public static final Potion field_76428_l = (new Potion(10, false, 13458603)).func_76390_b("potion.regeneration").func_76399_b(7, 0).func_76404_a(0.25D);
   public static final Potion field_76429_m = (new Potion(11, false, 10044730)).func_76390_b("potion.resistance").func_76399_b(6, 1);
   public static final Potion field_76426_n = (new Potion(12, false, 14981690)).func_76390_b("potion.fireResistance").func_76399_b(7, 1);
   public static final Potion field_76427_o = (new Potion(13, false, 3035801)).func_76390_b("potion.waterBreathing").func_76399_b(0, 2);
   public static final Potion field_76441_p = (new Potion(14, false, 8356754)).func_76390_b("potion.invisibility").func_76399_b(0, 1);
   public static final Potion field_76440_q = (new Potion(15, true, 2039587)).func_76390_b("potion.blindness").func_76399_b(5, 1).func_76404_a(0.25D);
   public static final Potion field_76439_r = (new Potion(16, false, 2039713)).func_76390_b("potion.nightVision").func_76399_b(4, 1);
   public static final Potion field_76438_s = (new Potion(17, true, 5797459)).func_76390_b("potion.hunger").func_76399_b(1, 1);
   public static final Potion field_76437_t = (new Potion(18, true, 4738376)).func_76390_b("potion.weakness").func_76399_b(5, 0);
   public static final Potion field_76436_u = (new Potion(19, true, 5149489)).func_76390_b("potion.poison").func_76399_b(6, 0).func_76404_a(0.25D);
   public static final Potion field_82731_v = (new Potion(20, true, 3484199)).func_76390_b("potion.wither").func_76399_b(1, 2).func_76404_a(0.25D);
   public static final Potion field_76434_w = null;
   public static final Potion field_76444_x = null;
   public static final Potion field_76443_y = null;
   public static final Potion field_76442_z = null;
   public static final Potion field_76409_A = null;
   public static final Potion field_76410_B = null;
   public static final Potion field_76411_C = null;
   public static final Potion field_76405_D = null;
   public static final Potion field_76406_E = null;
   public static final Potion field_76407_F = null;
   public static final Potion field_76408_G = null;
   public final int field_76415_H;
   private String field_76416_I = "";
   private int field_76417_J = -1;
   private final boolean field_76418_K;
   private double field_76412_L;
   private boolean field_76413_M;
   private final int field_76414_N;


   protected Potion(int p_i3433_1_, boolean p_i3433_2_, int p_i3433_3_) {
      this.field_76415_H = p_i3433_1_;
      field_76425_a[p_i3433_1_] = this;
      this.field_76418_K = p_i3433_2_;
      if(p_i3433_2_) {
         this.field_76412_L = 0.5D;
      } else {
         this.field_76412_L = 1.0D;
      }

      this.field_76414_N = p_i3433_3_;
   }

   public Potion func_76399_b(int p_76399_1_, int p_76399_2_) {
      this.field_76417_J = p_76399_1_ + p_76399_2_ * 8;
      return this;
   }

   public int func_76396_c() {
      return this.field_76415_H;
   }

   public void func_76394_a(EntityLiving p_76394_1_, int p_76394_2_) {
      if(this.field_76415_H == field_76428_l.field_76415_H) {
         if(p_76394_1_.func_70630_aN() < p_76394_1_.func_70667_aM()) {
            p_76394_1_.func_70691_i(1);
         }
      } else if(this.field_76415_H == field_76436_u.field_76415_H) {
         if(p_76394_1_.func_70630_aN() > 1) {
            p_76394_1_.func_70097_a(DamageSource.field_76376_m, 1);
         }
      } else if(this.field_76415_H == field_82731_v.field_76415_H) {
         p_76394_1_.func_70097_a(DamageSource.field_82727_n, 1);
      } else if(this.field_76415_H == field_76438_s.field_76415_H && p_76394_1_ instanceof EntityPlayer) {
         ((EntityPlayer)p_76394_1_).func_71020_j(0.025F * (float)(p_76394_2_ + 1));
      } else if((this.field_76415_H != field_76432_h.field_76415_H || p_76394_1_.func_70662_br()) && (this.field_76415_H != field_76433_i.field_76415_H || !p_76394_1_.func_70662_br())) {
         if(this.field_76415_H == field_76433_i.field_76415_H && !p_76394_1_.func_70662_br() || this.field_76415_H == field_76432_h.field_76415_H && p_76394_1_.func_70662_br()) {
            p_76394_1_.func_70097_a(DamageSource.field_76376_m, 6 << p_76394_2_);
         }
      } else {
         p_76394_1_.func_70691_i(6 << p_76394_2_);
      }

   }

   public void func_76402_a(EntityLiving p_76402_1_, EntityLiving p_76402_2_, int p_76402_3_, double p_76402_4_) {
      int var6;
      if((this.field_76415_H != field_76432_h.field_76415_H || p_76402_2_.func_70662_br()) && (this.field_76415_H != field_76433_i.field_76415_H || !p_76402_2_.func_70662_br())) {
         if(this.field_76415_H == field_76433_i.field_76415_H && !p_76402_2_.func_70662_br() || this.field_76415_H == field_76432_h.field_76415_H && p_76402_2_.func_70662_br()) {
            var6 = (int)(p_76402_4_ * (double)(6 << p_76402_3_) + 0.5D);
            if(p_76402_1_ == null) {
               p_76402_2_.func_70097_a(DamageSource.field_76376_m, var6);
            } else {
               p_76402_2_.func_70097_a(DamageSource.func_76354_b(p_76402_2_, p_76402_1_), var6);
            }
         }
      } else {
         var6 = (int)(p_76402_4_ * (double)(6 << p_76402_3_) + 0.5D);
         p_76402_2_.func_70691_i(var6);
      }

   }

   public boolean func_76403_b() {
      return false;
   }

   public boolean func_76397_a(int p_76397_1_, int p_76397_2_) {
      int var3;
      if(this.field_76415_H != field_76428_l.field_76415_H && this.field_76415_H != field_76436_u.field_76415_H) {
         if(this.field_76415_H == field_82731_v.field_76415_H) {
            var3 = 40 >> p_76397_2_;
            return var3 > 0?p_76397_1_ % var3 == 0:true;
         } else {
            return this.field_76415_H == field_76438_s.field_76415_H;
         }
      } else {
         var3 = 25 >> p_76397_2_;
         return var3 > 0?p_76397_1_ % var3 == 0:true;
      }
   }

   public Potion func_76390_b(String p_76390_1_) {
      this.field_76416_I = p_76390_1_;
      return this;
   }

   public String func_76393_a() {
      return this.field_76416_I;
   }

   protected Potion func_76404_a(double p_76404_1_) {
      this.field_76412_L = p_76404_1_;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76400_d() {
      return this.field_76417_J >= 0;
   }

   @SideOnly(Side.CLIENT)
   public int func_76392_e() {
      return this.field_76417_J;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76398_f() {
      return this.field_76418_K;
   }

   @SideOnly(Side.CLIENT)
   public static String func_76389_a(PotionEffect p_76389_0_) {
      if(p_76389_0_.func_100011_g()) {
         return "**:**";
      } else {
         int var1 = p_76389_0_.func_76459_b();
         return StringUtils.func_76337_a(var1);
      }
   }

   public double func_76388_g() {
      return this.field_76412_L;
   }

   public boolean func_76395_i() {
      return this.field_76413_M;
   }

   public int func_76401_j() {
      return this.field_76414_N;
   }

}
