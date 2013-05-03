package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.CallableEntityName;
import net.minecraft.entity.CallableEntityType;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumEntitySize;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class Entity {

   private static int field_70152_a = 0;
   public int field_70157_k;
   public double field_70155_l;
   public boolean field_70156_m;
   public Entity field_70153_n;
   public Entity field_70154_o;
   public boolean field_98038_p;
   public World field_70170_p;
   public double field_70169_q;
   public double field_70167_r;
   public double field_70166_s;
   public double field_70165_t;
   public double field_70163_u;
   public double field_70161_v;
   public double field_70159_w;
   public double field_70181_x;
   public double field_70179_y;
   public float field_70177_z;
   public float field_70125_A;
   public float field_70126_B;
   public float field_70127_C;
   public final AxisAlignedBB field_70121_D;
   public boolean field_70122_E;
   public boolean field_70123_F;
   public boolean field_70124_G;
   public boolean field_70132_H;
   public boolean field_70133_I;
   protected boolean field_70134_J;
   public boolean field_70135_K;
   public boolean field_70128_L;
   public float field_70129_M;
   public float field_70130_N;
   public float field_70131_O;
   public float field_70141_P;
   public float field_70140_Q;
   public float field_82151_R;
   public float field_70143_R;
   private int field_70150_b;
   public double field_70142_S;
   public double field_70137_T;
   public double field_70136_U;
   public float field_70139_V;
   public float field_70138_W;
   public boolean field_70145_X;
   public float field_70144_Y;
   protected Random field_70146_Z;
   public int field_70173_aa;
   public int field_70174_ab;
   private int field_70151_c;
   protected boolean field_70171_ac;
   public int field_70172_ad;
   private boolean field_70148_d;
   @SideOnly(Side.CLIENT)
   public String field_70120_cr;
   @SideOnly(Side.CLIENT)
   public String field_70119_cs;
   protected boolean field_70178_ae;
   protected DataWatcher field_70180_af;
   private double field_70149_e;
   private double field_70147_f;
   public boolean field_70175_ag;
   public int field_70176_ah;
   public int field_70162_ai;
   public int field_70164_aj;
   @SideOnly(Side.CLIENT)
   public int field_70118_ct;
   @SideOnly(Side.CLIENT)
   public int field_70117_cu;
   @SideOnly(Side.CLIENT)
   public int field_70116_cv;
   public boolean field_70158_ak;
   public boolean field_70160_al;
   public int field_71088_bW;
   protected boolean field_71087_bX;
   protected int field_82153_h;
   public int field_71093_bK;
   protected int field_82152_aq;
   private boolean field_83001_bt;
   private UUID field_96093_i;
   public EnumEntitySize field_70168_am;


   public Entity(World p_i3438_1_) {
      this.field_70157_k = field_70152_a++;
      this.field_70155_l = 1.0D;
      this.field_70156_m = false;
      this.field_70121_D = AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      this.field_70122_E = false;
      this.field_70132_H = false;
      this.field_70133_I = false;
      this.field_70135_K = true;
      this.field_70128_L = false;
      this.field_70129_M = 0.0F;
      this.field_70130_N = 0.6F;
      this.field_70131_O = 1.8F;
      this.field_70141_P = 0.0F;
      this.field_70140_Q = 0.0F;
      this.field_82151_R = 0.0F;
      this.field_70143_R = 0.0F;
      this.field_70150_b = 1;
      this.field_70139_V = 0.0F;
      this.field_70138_W = 0.0F;
      this.field_70145_X = false;
      this.field_70144_Y = 0.0F;
      this.field_70146_Z = new Random();
      this.field_70173_aa = 0;
      this.field_70174_ab = 1;
      this.field_70151_c = 0;
      this.field_70171_ac = false;
      this.field_70172_ad = 0;
      this.field_70148_d = true;
      this.field_70178_ae = false;
      this.field_70180_af = new DataWatcher();
      this.field_70175_ag = false;
      this.field_82152_aq = 0;
      this.field_83001_bt = false;
      this.field_96093_i = UUID.randomUUID();
      this.field_70168_am = EnumEntitySize.SIZE_2;
      this.field_70170_p = p_i3438_1_;
      this.func_70107_b(0.0D, 0.0D, 0.0D);
      if(p_i3438_1_ != null) {
         this.field_71093_bK = p_i3438_1_.field_73011_w.field_76574_g;
      }

      this.field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
      this.field_70180_af.func_75682_a(1, Short.valueOf((short)300));
      this.func_70088_a();
   }

   protected abstract void func_70088_a();

   public DataWatcher func_70096_w() {
      return this.field_70180_af;
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof Entity?((Entity)p_equals_1_).field_70157_k == this.field_70157_k:false;
   }

   public int hashCode() {
      return this.field_70157_k;
   }

   @SideOnly(Side.CLIENT)
   protected void func_70065_x() {
      if(this.field_70170_p != null) {
         while(this.field_70163_u > 0.0D) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if(this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) {
               break;
            }

            ++this.field_70163_u;
         }

         this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
         this.field_70125_A = 0.0F;
      }
   }

   public void func_70106_y() {
      this.field_70128_L = true;
   }

   protected void func_70105_a(float p_70105_1_, float p_70105_2_) {
      if(p_70105_1_ != this.field_70130_N || p_70105_2_ != this.field_70131_O) {
         this.field_70130_N = p_70105_1_;
         this.field_70131_O = p_70105_2_;
         this.field_70121_D.field_72336_d = this.field_70121_D.field_72340_a + (double)this.field_70130_N;
         this.field_70121_D.field_72334_f = this.field_70121_D.field_72339_c + (double)this.field_70130_N;
         this.field_70121_D.field_72337_e = this.field_70121_D.field_72338_b + (double)this.field_70131_O;
      }

      float var3 = p_70105_1_ % 2.0F;
      if((double)var3 < 0.375D) {
         this.field_70168_am = EnumEntitySize.SIZE_1;
      } else if((double)var3 < 0.75D) {
         this.field_70168_am = EnumEntitySize.SIZE_2;
      } else if((double)var3 < 1.0D) {
         this.field_70168_am = EnumEntitySize.SIZE_3;
      } else if((double)var3 < 1.375D) {
         this.field_70168_am = EnumEntitySize.SIZE_4;
      } else if((double)var3 < 1.75D) {
         this.field_70168_am = EnumEntitySize.SIZE_5;
      } else {
         this.field_70168_am = EnumEntitySize.SIZE_6;
      }

   }

   protected void func_70101_b(float p_70101_1_, float p_70101_2_) {
      this.field_70177_z = p_70101_1_ % 360.0F;
      this.field_70125_A = p_70101_2_ % 360.0F;
   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      float var7 = this.field_70130_N / 2.0F;
      float var8 = this.field_70131_O;
      this.field_70121_D.func_72324_b(p_70107_1_ - (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V, p_70107_5_ - (double)var7, p_70107_1_ + (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V + (double)var8, p_70107_5_ + (double)var7);
   }

   @SideOnly(Side.CLIENT)
   public void func_70082_c(float p_70082_1_, float p_70082_2_) {
      float var3 = this.field_70125_A;
      float var4 = this.field_70177_z;
      this.field_70177_z = (float)((double)this.field_70177_z + (double)p_70082_1_ * 0.15D);
      this.field_70125_A = (float)((double)this.field_70125_A - (double)p_70082_2_ * 0.15D);
      if(this.field_70125_A < -90.0F) {
         this.field_70125_A = -90.0F;
      }

      if(this.field_70125_A > 90.0F) {
         this.field_70125_A = 90.0F;
      }

      this.field_70127_C += this.field_70125_A - var3;
      this.field_70126_B += this.field_70177_z - var4;
   }

   public void func_70071_h_() {
      this.func_70030_z();
   }

   public void func_70030_z() {
      this.field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
      if(this.field_70154_o != null && this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      }

      this.field_70141_P = this.field_70140_Q;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70127_C = this.field_70125_A;
      this.field_70126_B = this.field_70177_z;
      int var2;
      if(!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
         this.field_70170_p.field_72984_F.func_76320_a("portal");
         MinecraftServer var1 = ((WorldServer)this.field_70170_p).func_73046_m();
         var2 = this.func_82145_z();
         if(this.field_71087_bX) {
            if(var1.func_71255_r()) {
               if(this.field_70154_o == null && this.field_82153_h++ >= var2) {
                  this.field_82153_h = var2;
                  this.field_71088_bW = this.func_82147_ab();
                  byte var3;
                  if(this.field_70170_p.field_73011_w.field_76574_g == -1) {
                     var3 = 0;
                  } else {
                     var3 = -1;
                  }

                  this.func_71027_c(var3);
               }

               this.field_71087_bX = false;
            }
         } else {
            if(this.field_82153_h > 0) {
               this.field_82153_h -= 4;
            }

            if(this.field_82153_h < 0) {
               this.field_82153_h = 0;
            }
         }

         if(this.field_71088_bW > 0) {
            --this.field_71088_bW;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }

      if(this.func_70051_ag() && !this.func_70090_H()) {
         int var5 = MathHelper.func_76128_c(this.field_70165_t);
         var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
         int var6 = MathHelper.func_76128_c(this.field_70161_v);
         int var4 = this.field_70170_p.func_72798_a(var5, var2, var6);
         if(var4 > 0) {
            this.field_70170_p.func_72869_a("tilecrack_" + var4 + "_" + this.field_70170_p.func_72805_g(var5, var2, var6), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
         }
      }

      this.func_70072_I();
      if(this.field_70170_p.field_72995_K) {
         this.field_70151_c = 0;
      } else if(this.field_70151_c > 0) {
         if(this.field_70178_ae) {
            this.field_70151_c -= 4;
            if(this.field_70151_c < 0) {
               this.field_70151_c = 0;
            }
         } else {
            if(this.field_70151_c % 20 == 0) {
               this.func_70097_a(DamageSource.field_76370_b, 1);
            }

            --this.field_70151_c;
         }
      }

      if(this.func_70058_J()) {
         this.func_70044_A();
         this.field_70143_R *= 0.5F;
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70052_a(0, this.field_70151_c > 0);
         this.func_70052_a(2, this.field_70154_o != null);
      }

      this.field_70148_d = false;
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   public int func_82145_z() {
      return 0;
   }

   protected void func_70044_A() {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76371_c, 4);
         this.func_70015_d(15);
      }

   }

   public void func_70015_d(int p_70015_1_) {
      int var2 = p_70015_1_ * 20;
      var2 = EnchantmentProtection.func_92093_a(this, var2);
      if(this.field_70151_c < var2) {
         this.field_70151_c = var2;
      }

   }

   public void func_70066_B() {
      this.field_70151_c = 0;
   }

   protected void func_70076_C() {
      this.func_70106_y();
   }

   public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
      AxisAlignedBB var7 = this.field_70121_D.func_72325_c(p_70038_1_, p_70038_3_, p_70038_5_);
      List var8 = this.field_70170_p.func_72945_a(this, var7);
      return !var8.isEmpty()?false:!this.field_70170_p.func_72953_d(var7);
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(this.field_70145_X) {
         this.field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
      } else {
         this.field_70170_p.field_72984_F.func_76320_a("move");
         this.field_70139_V *= 0.4F;
         double var7 = this.field_70165_t;
         double var9 = this.field_70163_u;
         double var11 = this.field_70161_v;
         if(this.field_70134_J) {
            this.field_70134_J = false;
            p_70091_1_ *= 0.25D;
            p_70091_3_ *= 0.05000000074505806D;
            p_70091_5_ *= 0.25D;
            this.field_70159_w = 0.0D;
            this.field_70181_x = 0.0D;
            this.field_70179_y = 0.0D;
         }

         double var13 = p_70091_1_;
         double var15 = p_70091_3_;
         double var17 = p_70091_5_;
         AxisAlignedBB var19 = this.field_70121_D.func_72329_c();
         boolean var20 = this.field_70122_E && this.func_70093_af() && this instanceof EntityPlayer;
         if(var20) {
            double var21;
            for(var21 = 0.05D; p_70091_1_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, 0.0D)).isEmpty(); var13 = p_70091_1_) {
               if(p_70091_1_ < var21 && p_70091_1_ >= -var21) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var21;
               } else {
                  p_70091_1_ += var21;
               }
            }

            for(; p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(0.0D, -1.0D, p_70091_5_)).isEmpty(); var17 = p_70091_5_) {
               if(p_70091_5_ < var21 && p_70091_5_ >= -var21) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var21;
               } else {
                  p_70091_5_ += var21;
               }
            }

            while(p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, p_70091_5_)).isEmpty()) {
               if(p_70091_1_ < var21 && p_70091_1_ >= -var21) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var21;
               } else {
                  p_70091_1_ += var21;
               }

               if(p_70091_5_ < var21 && p_70091_5_ >= -var21) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var21;
               } else {
                  p_70091_5_ += var21;
               }

               var13 = p_70091_1_;
               var17 = p_70091_5_;
            }
         }

         List var35 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));

         for(int var22 = 0; var22 < var35.size(); ++var22) {
            p_70091_3_ = ((AxisAlignedBB)var35.get(var22)).func_72323_b(this.field_70121_D, p_70091_3_);
         }

         this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
         if(!this.field_70135_K && var15 != p_70091_3_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         boolean var34 = this.field_70122_E || var15 != p_70091_3_ && var15 < 0.0D;

         int var23;
         for(var23 = 0; var23 < var35.size(); ++var23) {
            p_70091_1_ = ((AxisAlignedBB)var35.get(var23)).func_72316_a(this.field_70121_D, p_70091_1_);
         }

         this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
         if(!this.field_70135_K && var13 != p_70091_1_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         for(var23 = 0; var23 < var35.size(); ++var23) {
            p_70091_5_ = ((AxisAlignedBB)var35.get(var23)).func_72322_c(this.field_70121_D, p_70091_5_);
         }

         this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
         if(!this.field_70135_K && var17 != p_70091_5_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         double var25;
         double var27;
         int var30;
         double var36;
         if(this.field_70138_W > 0.0F && var34 && (var20 || this.field_70139_V < 0.05F) && (var13 != p_70091_1_ || var17 != p_70091_5_)) {
            var36 = p_70091_1_;
            var25 = p_70091_3_;
            var27 = p_70091_5_;
            p_70091_1_ = var13;
            p_70091_3_ = (double)this.field_70138_W;
            p_70091_5_ = var17;
            AxisAlignedBB var29 = this.field_70121_D.func_72329_c();
            this.field_70121_D.func_72328_c(var19);
            var35 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(var13, p_70091_3_, var17));

            for(var30 = 0; var30 < var35.size(); ++var30) {
               p_70091_3_ = ((AxisAlignedBB)var35.get(var30)).func_72323_b(this.field_70121_D, p_70091_3_);
            }

            this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            if(!this.field_70135_K && var15 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var30 = 0; var30 < var35.size(); ++var30) {
               p_70091_1_ = ((AxisAlignedBB)var35.get(var30)).func_72316_a(this.field_70121_D, p_70091_1_);
            }

            this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
            if(!this.field_70135_K && var13 != p_70091_1_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var30 = 0; var30 < var35.size(); ++var30) {
               p_70091_5_ = ((AxisAlignedBB)var35.get(var30)).func_72322_c(this.field_70121_D, p_70091_5_);
            }

            this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
            if(!this.field_70135_K && var17 != p_70091_5_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            if(!this.field_70135_K && var15 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            } else {
               p_70091_3_ = (double)(-this.field_70138_W);

               for(var30 = 0; var30 < var35.size(); ++var30) {
                  p_70091_3_ = ((AxisAlignedBB)var35.get(var30)).func_72323_b(this.field_70121_D, p_70091_3_);
               }

               this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            }

            if(var36 * var36 + var27 * var27 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
               p_70091_1_ = var36;
               p_70091_3_ = var25;
               p_70091_5_ = var27;
               this.field_70121_D.func_72328_c(var29);
            }
         }

         this.field_70170_p.field_72984_F.func_76319_b();
         this.field_70170_p.field_72984_F.func_76320_a("rest");
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
         this.field_70123_F = var13 != p_70091_1_ || var17 != p_70091_5_;
         this.field_70124_G = var15 != p_70091_3_;
         this.field_70122_E = var15 != p_70091_3_ && var15 < 0.0D;
         this.field_70132_H = this.field_70123_F || this.field_70124_G;
         this.func_70064_a(p_70091_3_, this.field_70122_E);
         if(var13 != p_70091_1_) {
            this.field_70159_w = 0.0D;
         }

         if(var15 != p_70091_3_) {
            this.field_70181_x = 0.0D;
         }

         if(var17 != p_70091_5_) {
            this.field_70179_y = 0.0D;
         }

         var36 = this.field_70165_t - var7;
         var25 = this.field_70163_u - var9;
         var27 = this.field_70161_v - var11;
         if(this.func_70041_e_() && !var20 && this.field_70154_o == null) {
            int var37 = MathHelper.func_76128_c(this.field_70165_t);
            var30 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
            int var31 = MathHelper.func_76128_c(this.field_70161_v);
            int var32 = this.field_70170_p.func_72798_a(var37, var30, var31);
            if(var32 == 0) {
               int var33 = this.field_70170_p.func_85175_e(var37, var30 - 1, var31);
               if(var33 == 11 || var33 == 32 || var33 == 21) {
                  var32 = this.field_70170_p.func_72798_a(var37, var30 - 1, var31);
               }
            }

            if(var32 != Block.field_72055_aF.field_71990_ca) {
               var25 = 0.0D;
            }

            this.field_70140_Q = (float)((double)this.field_70140_Q + (double)MathHelper.func_76133_a(var36 * var36 + var27 * var27) * 0.6D);
            this.field_82151_R = (float)((double)this.field_82151_R + (double)MathHelper.func_76133_a(var36 * var36 + var25 * var25 + var27 * var27) * 0.6D);
            if(this.field_82151_R > (float)this.field_70150_b && var32 > 0) {
               this.field_70150_b = (int)this.field_82151_R + 1;
               if(this.func_70090_H()) {
                  float var39 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.35F;
                  if(var39 > 1.0F) {
                     var39 = 1.0F;
                  }

                  this.func_85030_a("liquid.swim", var39, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
               }

               this.func_70036_a(var37, var30, var31, var32);
               Block.field_71973_m[var32].func_71891_b(this.field_70170_p, var37, var30, var31, this);
            }
         }

         this.func_70017_D();
         boolean var38 = this.func_70026_G();
         if(this.field_70170_p.func_72978_e(this.field_70121_D.func_72331_e(0.0010D, 0.0010D, 0.0010D))) {
            this.func_70081_e(1);
            if(!var38) {
               ++this.field_70151_c;
               if(this.field_70151_c == 0) {
                  this.func_70015_d(8);
               }
            }
         } else if(this.field_70151_c <= 0) {
            this.field_70151_c = -this.field_70174_ab;
         }

         if(var38 && this.field_70151_c > 0) {
            this.func_85030_a("random.fizz", 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            this.field_70151_c = -this.field_70174_ab;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   protected void func_70017_D() {
      int var1 = MathHelper.func_76128_c(this.field_70121_D.field_72340_a + 0.0010D);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.0010D);
      int var3 = MathHelper.func_76128_c(this.field_70121_D.field_72339_c + 0.0010D);
      int var4 = MathHelper.func_76128_c(this.field_70121_D.field_72336_d - 0.0010D);
      int var5 = MathHelper.func_76128_c(this.field_70121_D.field_72337_e - 0.0010D);
      int var6 = MathHelper.func_76128_c(this.field_70121_D.field_72334_f - 0.0010D);
      if(this.field_70170_p.func_72904_c(var1, var2, var3, var4, var5, var6)) {
         for(int var7 = var1; var7 <= var4; ++var7) {
            for(int var8 = var2; var8 <= var5; ++var8) {
               for(int var9 = var3; var9 <= var6; ++var9) {
                  int var10 = this.field_70170_p.func_72798_a(var7, var8, var9);
                  if(var10 > 0) {
                     Block.field_71973_m[var10].func_71869_a(this.field_70170_p, var7, var8, var9, this);
                  }
               }
            }
         }
      }

   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      StepSound var5 = Block.field_71973_m[p_70036_4_].field_72020_cn;
      if(this.field_70170_p.func_72798_a(p_70036_1_, p_70036_2_ + 1, p_70036_3_) == Block.field_72037_aS.field_71990_ca) {
         var5 = Block.field_72037_aS.field_72020_cn;
         this.func_85030_a(var5.func_72675_d(), var5.func_72677_b() * 0.15F, var5.func_72678_c());
      } else if(!Block.field_71973_m[p_70036_4_].field_72018_cp.func_76224_d()) {
         this.func_85030_a(var5.func_72675_d(), var5.func_72677_b() * 0.15F, var5.func_72678_c());
      }

   }

   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
      this.field_70170_p.func_72956_a(this, p_85030_1_, p_85030_2_, p_85030_3_);
   }

   protected boolean func_70041_e_() {
      return true;
   }

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
      if(p_70064_3_) {
         if(this.field_70143_R > 0.0F) {
            this.func_70069_a(this.field_70143_R);
            this.field_70143_R = 0.0F;
         }
      } else if(p_70064_1_ < 0.0D) {
         this.field_70143_R = (float)((double)this.field_70143_R - p_70064_1_);
      }

   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   protected void func_70081_e(int p_70081_1_) {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76372_a, p_70081_1_);
      }

   }

   public final boolean func_70045_F() {
      return this.field_70178_ae;
   }

   protected void func_70069_a(float p_70069_1_) {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70069_a(p_70069_1_);
      }

   }

   public boolean func_70026_G() {
      return this.field_70171_ac || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + (double)this.field_70131_O), MathHelper.func_76128_c(this.field_70161_v));
   }

   public boolean func_70090_H() {
      return this.field_70171_ac;
   }

   public boolean func_70072_I() {
      if(this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_72331_e(0.0010D, 0.0010D, 0.0010D), Material.field_76244_g, this)) {
         if(!this.field_70171_ac && !this.field_70148_d) {
            float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.2F;
            if(var1 > 1.0F) {
               var1 = 1.0F;
            }

            this.func_85030_a("liquid.splash", var1, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            float var2 = (float)MathHelper.func_76128_c(this.field_70121_D.field_72338_b);

            int var3;
            float var4;
            float var5;
            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y);
            }

            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
         }

         this.field_70143_R = 0.0F;
         this.field_70171_ac = true;
         this.field_70151_c = 0;
      } else {
         this.field_70171_ac = false;
      }

      return this.field_70171_ac;
   }

   public boolean func_70055_a(Material p_70055_1_) {
      double var2 = this.field_70163_u + (double)this.func_70047_e();
      int var4 = MathHelper.func_76128_c(this.field_70165_t);
      int var5 = MathHelper.func_76141_d((float)MathHelper.func_76128_c(var2));
      int var6 = MathHelper.func_76128_c(this.field_70161_v);
      int var7 = this.field_70170_p.func_72798_a(var4, var5, var6);
      if(var7 != 0 && Block.field_71973_m[var7].field_72018_cp == p_70055_1_) {
         float var8 = BlockFluid.func_72199_d(this.field_70170_p.func_72805_g(var4, var5, var6)) - 0.11111111F;
         float var9 = (float)(var5 + 1) - var8;
         return var2 < (double)var9;
      } else {
         return false;
      }
   }

   public float func_70047_e() {
      return 0.0F;
   }

   public boolean func_70058_J() {
      return this.field_70170_p.func_72875_a(this.field_70121_D.func_72314_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_76256_h);
   }

   public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
      float var4 = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.func_76129_c(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = p_70060_3_ / var4;
         p_70060_1_ *= var4;
         p_70060_2_ *= var4;
         float var5 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
         float var6 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
         this.field_70159_w += (double)(p_70060_1_ * var6 - p_70060_2_ * var5);
         this.field_70179_y += (double)(p_70060_2_ * var6 + p_70060_1_ * var5);
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_70070_b(float p_70070_1_) {
      int var2 = MathHelper.func_76128_c(this.field_70165_t);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72899_e(var2, 0, var3)) {
         double var4 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
         int var6 = MathHelper.func_76128_c(this.field_70163_u - (double)this.field_70129_M + var4);
         return this.field_70170_p.func_72802_i(var2, var6, var3, 0);
      } else {
         return 0;
      }
   }

   public float func_70013_c(float p_70013_1_) {
      int var2 = MathHelper.func_76128_c(this.field_70165_t);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72899_e(var2, 0, var3)) {
         double var4 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
         int var6 = MathHelper.func_76128_c(this.field_70163_u - (double)this.field_70129_M + var4);
         return this.field_70170_p.func_72801_o(var2, var6, var3);
      } else {
         return 0.0F;
      }
   }

   public void func_70029_a(World p_70029_1_) {
      this.field_70170_p = p_70029_1_;
   }

   public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
      this.field_70169_q = this.field_70165_t = p_70080_1_;
      this.field_70167_r = this.field_70163_u = p_70080_3_;
      this.field_70166_s = this.field_70161_v = p_70080_5_;
      this.field_70126_B = this.field_70177_z = p_70080_7_;
      this.field_70127_C = this.field_70125_A = p_70080_8_;
      this.field_70139_V = 0.0F;
      double var9 = (double)(this.field_70126_B - p_70080_7_);
      if(var9 < -180.0D) {
         this.field_70126_B += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.field_70126_B -= 360.0F;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70101_b(p_70080_7_, p_70080_8_);
   }

   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
      this.field_70142_S = this.field_70169_q = this.field_70165_t = p_70012_1_;
      this.field_70137_T = this.field_70167_r = this.field_70163_u = p_70012_3_ + (double)this.field_70129_M;
      this.field_70136_U = this.field_70166_s = this.field_70161_v = p_70012_5_;
      this.field_70177_z = p_70012_7_;
      this.field_70125_A = p_70012_8_;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public float func_70032_d(Entity p_70032_1_) {
      float var2 = (float)(this.field_70165_t - p_70032_1_.field_70165_t);
      float var3 = (float)(this.field_70163_u - p_70032_1_.field_70163_u);
      float var4 = (float)(this.field_70161_v - p_70032_1_.field_70161_v);
      return MathHelper.func_76129_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
      double var7 = this.field_70165_t - p_70092_1_;
      double var9 = this.field_70163_u - p_70092_3_;
      double var11 = this.field_70161_v - p_70092_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
      double var7 = this.field_70165_t - p_70011_1_;
      double var9 = this.field_70163_u - p_70011_3_;
      double var11 = this.field_70161_v - p_70011_5_;
      return (double)MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double func_70068_e(Entity p_70068_1_) {
      double var2 = this.field_70165_t - p_70068_1_.field_70165_t;
      double var4 = this.field_70163_u - p_70068_1_.field_70163_u;
      double var6 = this.field_70161_v - p_70068_1_.field_70161_v;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {}

   public void func_70108_f(Entity p_70108_1_) {
      if(p_70108_1_.field_70153_n != this && p_70108_1_.field_70154_o != this) {
         double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
         double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
         double var6 = MathHelper.func_76132_a(var2, var4);
         if(var6 >= 0.009999999776482582D) {
            var6 = (double)MathHelper.func_76133_a(var6);
            var2 /= var6;
            var4 /= var6;
            double var8 = 1.0D / var6;
            if(var8 > 1.0D) {
               var8 = 1.0D;
            }

            var2 *= var8;
            var4 *= var8;
            var2 *= 0.05000000074505806D;
            var4 *= 0.05000000074505806D;
            var2 *= (double)(1.0F - this.field_70144_Y);
            var4 *= (double)(1.0F - this.field_70144_Y);
            this.func_70024_g(-var2, 0.0D, -var4);
            p_70108_1_.func_70024_g(var2, 0.0D, var4);
         }

      }
   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      this.field_70159_w += p_70024_1_;
      this.field_70181_x += p_70024_3_;
      this.field_70179_y += p_70024_5_;
      this.field_70160_al = true;
   }

   protected void func_70018_K() {
      this.field_70133_I = true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         this.func_70018_K();
         return false;
      }
   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {}

   public boolean func_98035_c(NBTTagCompound p_98035_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null) {
         p_98035_1_.func_74778_a("id", var2);
         this.func_70109_d(p_98035_1_);
         return true;
      } else {
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70102_a(Vec3 p_70102_1_) {
      double var2 = this.field_70165_t - p_70102_1_.field_72450_a;
      double var4 = this.field_70163_u - p_70102_1_.field_72448_b;
      double var6 = this.field_70161_v - p_70102_1_.field_72449_c;
      double var8 = var2 * var2 + var4 * var4 + var6 * var6;
      return this.func_70112_a(var8);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.field_70121_D.func_72320_b();
      var3 *= 64.0D * this.field_70155_l;
      return p_70112_1_ < var3 * var3;
   }

   @SideOnly(Side.CLIENT)
   public String func_70073_O() {
      return null;
   }

   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null && this.field_70153_n == null) {
         p_70039_1_.func_74778_a("id", var2);
         this.func_70109_d(p_70039_1_);
         return true;
      } else {
         return false;
      }
   }

   public void func_70109_d(NBTTagCompound p_70109_1_) {
      try {
         p_70109_1_.func_74782_a("Pos", this.func_70087_a(new double[]{this.field_70165_t, this.field_70163_u + (double)this.field_70139_V, this.field_70161_v}));
         p_70109_1_.func_74782_a("Motion", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
         p_70109_1_.func_74782_a("Rotation", this.func_70049_a(new float[]{this.field_70177_z, this.field_70125_A}));
         p_70109_1_.func_74776_a("FallDistance", this.field_70143_R);
         p_70109_1_.func_74777_a("Fire", (short)this.field_70151_c);
         p_70109_1_.func_74777_a("Air", (short)this.func_70086_ai());
         p_70109_1_.func_74757_a("OnGround", this.field_70122_E);
         p_70109_1_.func_74768_a("Dimension", this.field_71093_bK);
         p_70109_1_.func_74757_a("Invulnerable", this.field_83001_bt);
         p_70109_1_.func_74768_a("PortalCooldown", this.field_71088_bW);
         p_70109_1_.func_74772_a("UUIDMost", this.field_96093_i.getMostSignificantBits());
         p_70109_1_.func_74772_a("UUIDLeast", this.field_96093_i.getLeastSignificantBits());
         this.func_70014_b(p_70109_1_);
         if(this.field_70154_o != null) {
            NBTTagCompound var2 = new NBTTagCompound("Riding");
            if(this.field_70154_o.func_98035_c(var2)) {
               p_70109_1_.func_74782_a("Riding", var2);
            }
         }

      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Saving entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being saved");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   public void func_70020_e(NBTTagCompound p_70020_1_) {
      try {
         NBTTagList var2 = p_70020_1_.func_74761_m("Pos");
         NBTTagList var6 = p_70020_1_.func_74761_m("Motion");
         NBTTagList var7 = p_70020_1_.func_74761_m("Rotation");
         this.field_70159_w = ((NBTTagDouble)var6.func_74743_b(0)).field_74755_a;
         this.field_70181_x = ((NBTTagDouble)var6.func_74743_b(1)).field_74755_a;
         this.field_70179_y = ((NBTTagDouble)var6.func_74743_b(2)).field_74755_a;
         if(Math.abs(this.field_70159_w) > 10.0D) {
            this.field_70159_w = 0.0D;
         }

         if(Math.abs(this.field_70181_x) > 10.0D) {
            this.field_70181_x = 0.0D;
         }

         if(Math.abs(this.field_70179_y) > 10.0D) {
            this.field_70179_y = 0.0D;
         }

         this.field_70169_q = this.field_70142_S = this.field_70165_t = ((NBTTagDouble)var2.func_74743_b(0)).field_74755_a;
         this.field_70167_r = this.field_70137_T = this.field_70163_u = ((NBTTagDouble)var2.func_74743_b(1)).field_74755_a;
         this.field_70166_s = this.field_70136_U = this.field_70161_v = ((NBTTagDouble)var2.func_74743_b(2)).field_74755_a;
         this.field_70126_B = this.field_70177_z = ((NBTTagFloat)var7.func_74743_b(0)).field_74750_a;
         this.field_70127_C = this.field_70125_A = ((NBTTagFloat)var7.func_74743_b(1)).field_74750_a;
         this.field_70143_R = p_70020_1_.func_74760_g("FallDistance");
         this.field_70151_c = p_70020_1_.func_74765_d("Fire");
         this.func_70050_g(p_70020_1_.func_74765_d("Air"));
         this.field_70122_E = p_70020_1_.func_74767_n("OnGround");
         this.field_71093_bK = p_70020_1_.func_74762_e("Dimension");
         this.field_83001_bt = p_70020_1_.func_74767_n("Invulnerable");
         this.field_71088_bW = p_70020_1_.func_74762_e("PortalCooldown");
         if(p_70020_1_.func_74764_b("UUIDMost") && p_70020_1_.func_74764_b("UUIDLeast")) {
            this.field_96093_i = new UUID(p_70020_1_.func_74763_f("UUIDMost"), p_70020_1_.func_74763_f("UUIDLeast"));
         }

         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         this.func_70037_a(p_70020_1_);
      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Loading entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being loaded");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   protected final String func_70022_Q() {
      return EntityList.func_75621_b(this);
   }

   protected abstract void func_70037_a(NBTTagCompound var1);

   protected abstract void func_70014_b(NBTTagCompound var1);

   protected NBTTagList func_70087_a(double ... p_70087_1_) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = p_70087_1_;
      int var4 = p_70087_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.func_74742_a(new NBTTagDouble((String)null, var6));
      }

      return var2;
   }

   protected NBTTagList func_70049_a(float ... p_70049_1_) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = p_70049_1_;
      int var4 = p_70049_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.func_74742_a(new NBTTagFloat((String)null, var6));
      }

      return var2;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return this.field_70131_O / 2.0F;
   }

   public EntityItem func_70025_b(int p_70025_1_, int p_70025_2_) {
      return this.func_70054_a(p_70025_1_, p_70025_2_, 0.0F);
   }

   public EntityItem func_70054_a(int p_70054_1_, int p_70054_2_, float p_70054_3_) {
      return this.func_70099_a(new ItemStack(p_70054_1_, p_70054_2_, 0), p_70054_3_);
   }

   public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_) {
      EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)p_70099_2_, this.field_70161_v, p_70099_1_);
      var3.field_70293_c = 10;
      this.field_70170_p.func_72838_d(var3);
      return var3;
   }

   public boolean func_70089_S() {
      return !this.field_70128_L;
   }

   public boolean func_70094_T() {
      for(int var1 = 0; var1 < 8; ++var1) {
         float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
         float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         int var5 = MathHelper.func_76128_c(this.field_70165_t + (double)var2);
         int var6 = MathHelper.func_76128_c(this.field_70163_u + (double)this.func_70047_e() + (double)var3);
         int var7 = MathHelper.func_76128_c(this.field_70161_v + (double)var4);
         if(this.field_70170_p.func_72809_s(var5, var6, var7)) {
            return true;
         }
      }

      return false;
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      return false;
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return null;
   }

   public void func_70098_U() {
      if(this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      } else {
         this.field_70159_w = 0.0D;
         this.field_70181_x = 0.0D;
         this.field_70179_y = 0.0D;
         this.func_70071_h_();
         if(this.field_70154_o != null) {
            this.field_70154_o.func_70043_V();
            this.field_70147_f += (double)(this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);

            for(this.field_70149_e += (double)(this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C); this.field_70147_f >= 180.0D; this.field_70147_f -= 360.0D) {
               ;
            }

            while(this.field_70147_f < -180.0D) {
               this.field_70147_f += 360.0D;
            }

            while(this.field_70149_e >= 180.0D) {
               this.field_70149_e -= 360.0D;
            }

            while(this.field_70149_e < -180.0D) {
               this.field_70149_e += 360.0D;
            }

            double var1 = this.field_70147_f * 0.5D;
            double var3 = this.field_70149_e * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.field_70147_f -= var1;
            this.field_70149_e -= var3;
            this.field_70177_z = (float)((double)this.field_70177_z + var1);
            this.field_70125_A = (float)((double)this.field_70125_A + var3);
         }
      }
   }

   public void func_70043_V() {
      if(this.field_70153_n != null) {
         if(!(this.field_70153_n instanceof EntityPlayer) || !((EntityPlayer)this.field_70153_n).func_71066_bF()) {
            this.field_70153_n.field_70142_S = this.field_70142_S;
            this.field_70153_n.field_70137_T = this.field_70137_T + this.func_70042_X() + this.field_70153_n.func_70033_W();
            this.field_70153_n.field_70136_U = this.field_70136_U;
         }

         this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
      }
   }

   public double func_70033_W() {
      return (double)this.field_70129_M;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.75D;
   }

   public void func_70078_a(Entity p_70078_1_) {
      this.field_70149_e = 0.0D;
      this.field_70147_f = 0.0D;
      if(p_70078_1_ == null) {
         if(this.field_70154_o != null) {
            this.func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.field_70121_D.field_72338_b + (double)this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_70154_o.field_70153_n = null;
         }

         this.field_70154_o = null;
      } else {
         if(this.field_70154_o != null) {
            this.field_70154_o.field_70153_n = null;
         }

         this.field_70154_o = p_70078_1_;
         p_70078_1_.field_70153_n = this;
      }
   }

   public void func_70061_h(Entity p_70061_1_) {
      double var3 = this.field_70165_t;
      double var5 = this.field_70163_u;
      double var7 = this.field_70161_v;
      if(p_70061_1_ != null) {
         var3 = p_70061_1_.field_70165_t;
         var5 = p_70061_1_.field_70121_D.field_72338_b + (double)p_70061_1_.field_70131_O;
         var7 = p_70061_1_.field_70161_v;
      }

      for(double var9 = -1.5D; var9 < 2.0D; ++var9) {
         for(double var11 = -1.5D; var11 < 2.0D; ++var11) {
            if(var9 != 0.0D || var11 != 0.0D) {
               int var13 = (int)(this.field_70165_t + var9);
               int var14 = (int)(this.field_70161_v + var11);
               AxisAlignedBB var2 = this.field_70121_D.func_72325_c(var9, 1.0D, var11);
               if(this.field_70170_p.func_72840_a(var2).isEmpty()) {
                  if(this.field_70170_p.func_72797_t(var13, (int)this.field_70163_u, var14)) {
                     this.func_70012_b(this.field_70165_t + var9, this.field_70163_u + 1.0D, this.field_70161_v + var11, this.field_70177_z, this.field_70125_A);
                     return;
                  }

                  if(this.field_70170_p.func_72797_t(var13, (int)this.field_70163_u - 1, var14) || this.field_70170_p.func_72803_f(var13, (int)this.field_70163_u - 1, var14) == Material.field_76244_g) {
                     var3 = this.field_70165_t + var9;
                     var5 = this.field_70163_u + 1.0D;
                     var7 = this.field_70161_v + var11;
                  }
               }
            }
         }
      }

      this.func_70012_b(var3, var5, var7, this.field_70177_z, this.field_70125_A);
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      this.func_70107_b(p_70056_1_, p_70056_3_, p_70056_5_);
      this.func_70101_b(p_70056_7_, p_70056_8_);
      List var10 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72331_e(0.03125D, 0.0D, 0.03125D));
      if(!var10.isEmpty()) {
         double var11 = 0.0D;

         for(int var13 = 0; var13 < var10.size(); ++var13) {
            AxisAlignedBB var14 = (AxisAlignedBB)var10.get(var13);
            if(var14.field_72337_e > var11) {
               var11 = var14.field_72337_e;
            }
         }

         p_70056_3_ += var11 - this.field_70121_D.field_72338_b;
         this.func_70107_b(p_70056_1_, p_70056_3_, p_70056_5_);
      }

   }

   public float func_70111_Y() {
      return 0.1F;
   }

   public Vec3 func_70040_Z() {
      return null;
   }

   public void func_70063_aa() {
      if(this.field_71088_bW > 0) {
         this.field_71088_bW = this.func_82147_ab();
      } else {
         double var1 = this.field_70169_q - this.field_70165_t;
         double var3 = this.field_70166_s - this.field_70161_v;
         if(!this.field_70170_p.field_72995_K && !this.field_71087_bX) {
            this.field_82152_aq = Direction.func_82372_a(var1, var3);
         }

         this.field_71087_bX = true;
      }
   }

   public int func_82147_ab() {
      return 900;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70159_w = p_70016_1_;
      this.field_70181_x = p_70016_3_;
      this.field_70179_y = p_70016_5_;
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte p_70103_1_) {}

   @SideOnly(Side.CLIENT)
   public void func_70057_ab() {}

   @SideOnly(Side.CLIENT)
   public void func_70059_ac() {}

   public ItemStack[] func_70035_c() {
      return null;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}

   public boolean func_70027_ad() {
      return this.field_70151_c > 0 || this.func_70083_f(0);
   }

   public boolean func_70115_ae() {
      return this.field_70154_o != null || this.func_70083_f(2);
   }

   public boolean func_70093_af() {
      return this.func_70083_f(1);
   }

   public void func_70095_a(boolean p_70095_1_) {
      this.func_70052_a(1, p_70095_1_);
   }

   public boolean func_70051_ag() {
      return this.func_70083_f(3);
   }

   public void func_70031_b(boolean p_70031_1_) {
      this.func_70052_a(3, p_70031_1_);
   }

   public boolean func_82150_aj() {
      return this.func_70083_f(5);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_98034_c(EntityPlayer p_98034_1_) {
      return this.func_82150_aj();
   }

   public void func_82142_c(boolean p_82142_1_) {
      this.func_70052_a(5, p_82142_1_);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70113_ah() {
      return this.func_70083_f(4);
   }

   public void func_70019_c(boolean p_70019_1_) {
      this.func_70052_a(4, p_70019_1_);
   }

   protected boolean func_70083_f(int p_70083_1_) {
      return (this.field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0;
   }

   protected void func_70052_a(int p_70052_1_, boolean p_70052_2_) {
      byte var3 = this.field_70180_af.func_75683_a(0);
      if(p_70052_2_) {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 | 1 << p_70052_1_)));
      } else {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 & ~(1 << p_70052_1_))));
      }

   }

   public int func_70086_ai() {
      return this.field_70180_af.func_75693_b(1);
   }

   public void func_70050_g(int p_70050_1_) {
      this.field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      this.func_70081_e(5);
      ++this.field_70151_c;
      if(this.field_70151_c == 0) {
         this.func_70015_d(8);
      }

   }

   public void func_70074_a(EntityLiving p_70074_1_) {}

   protected boolean func_70048_i(double p_70048_1_, double p_70048_3_, double p_70048_5_) {
      int var7 = MathHelper.func_76128_c(p_70048_1_);
      int var8 = MathHelper.func_76128_c(p_70048_3_);
      int var9 = MathHelper.func_76128_c(p_70048_5_);
      double var10 = p_70048_1_ - (double)var7;
      double var12 = p_70048_3_ - (double)var8;
      double var14 = p_70048_5_ - (double)var9;
      List var16 = this.field_70170_p.func_72840_a(this.field_70121_D);
      if(var16.isEmpty() && !this.field_70170_p.func_85174_u(var7, var8, var9)) {
         return false;
      } else {
         boolean var17 = !this.field_70170_p.func_85174_u(var7 - 1, var8, var9);
         boolean var18 = !this.field_70170_p.func_85174_u(var7 + 1, var8, var9);
         boolean var19 = !this.field_70170_p.func_85174_u(var7, var8 - 1, var9);
         boolean var20 = !this.field_70170_p.func_85174_u(var7, var8 + 1, var9);
         boolean var21 = !this.field_70170_p.func_85174_u(var7, var8, var9 - 1);
         boolean var22 = !this.field_70170_p.func_85174_u(var7, var8, var9 + 1);
         byte var23 = 3;
         double var24 = 9999.0D;
         if(var17 && var10 < var24) {
            var24 = var10;
            var23 = 0;
         }

         if(var18 && 1.0D - var10 < var24) {
            var24 = 1.0D - var10;
            var23 = 1;
         }

         if(var20 && 1.0D - var12 < var24) {
            var24 = 1.0D - var12;
            var23 = 3;
         }

         if(var21 && var14 < var24) {
            var24 = var14;
            var23 = 4;
         }

         if(var22 && 1.0D - var14 < var24) {
            var24 = 1.0D - var14;
            var23 = 5;
         }

         float var26 = this.field_70146_Z.nextFloat() * 0.2F + 0.1F;
         if(var23 == 0) {
            this.field_70159_w = (double)(-var26);
         }

         if(var23 == 1) {
            this.field_70159_w = (double)var26;
         }

         if(var23 == 2) {
            this.field_70181_x = (double)(-var26);
         }

         if(var23 == 3) {
            this.field_70181_x = (double)var26;
         }

         if(var23 == 4) {
            this.field_70179_y = (double)(-var26);
         }

         if(var23 == 5) {
            this.field_70179_y = (double)var26;
         }

         return true;
      }
   }

   public void func_70110_aj() {
      this.field_70134_J = true;
      this.field_70143_R = 0.0F;
   }

   public String func_70023_ak() {
      String var1 = EntityList.func_75621_b(this);
      if(var1 == null) {
         var1 = "generic";
      }

      return StatCollector.func_74838_a("entity." + var1 + ".name");
   }

   public Entity[] func_70021_al() {
      return null;
   }

   public boolean func_70028_i(Entity p_70028_1_) {
      return this == p_70028_1_;
   }

   public float func_70079_am() {
      return 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public void func_70034_d(float p_70034_1_) {}

   public boolean func_70075_an() {
      return true;
   }

   public boolean func_85031_j(Entity p_85031_1_) {
      return false;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.func_70023_ak(), Integer.valueOf(this.field_70157_k), this.field_70170_p == null?"~NULL~":this.field_70170_p.func_72912_H().func_76065_j(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)});
   }

   public boolean func_85032_ar() {
      return this.field_83001_bt;
   }

   public void func_82149_j(Entity p_82149_1_) {
      this.func_70012_b(p_82149_1_.field_70165_t, p_82149_1_.field_70163_u, p_82149_1_.field_70161_v, p_82149_1_.field_70177_z, p_82149_1_.field_70125_A);
   }

   public void func_82141_a(Entity p_82141_1_, boolean p_82141_2_) {
      NBTTagCompound var3 = new NBTTagCompound();
      p_82141_1_.func_70109_d(var3);
      this.func_70020_e(var3);
      this.field_71088_bW = p_82141_1_.field_71088_bW;
      this.field_82152_aq = p_82141_1_.field_82152_aq;
   }

   public void func_71027_c(int p_71027_1_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.field_70170_p.field_72984_F.func_76320_a("changeDimension");
         MinecraftServer var2 = MinecraftServer.func_71276_C();
         int var3 = this.field_71093_bK;
         WorldServer var4 = var2.func_71218_a(var3);
         WorldServer var5 = var2.func_71218_a(p_71027_1_);
         this.field_71093_bK = p_71027_1_;
         this.field_70170_p.func_72900_e(this);
         this.field_70128_L = false;
         this.field_70170_p.field_72984_F.func_76320_a("reposition");
         var2.func_71203_ab().func_82448_a(this, var3, var4, var5);
         this.field_70170_p.field_72984_F.func_76318_c("reloading");
         Entity var6 = EntityList.func_75620_a(EntityList.func_75621_b(this), var5);
         if(var6 != null) {
            var6.func_82141_a(this, true);
            var5.func_72838_d(var6);
         }

         this.field_70128_L = true;
         this.field_70170_p.field_72984_F.func_76319_b();
         var4.func_82742_i();
         var5.func_82742_i();
         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   public float func_82146_a(Explosion p_82146_1_, World p_82146_2_, int p_82146_3_, int p_82146_4_, int p_82146_5_, Block p_82146_6_) {
      return p_82146_6_.func_71904_a(this);
   }

   public boolean func_96091_a(Explosion p_96091_1_, World p_96091_2_, int p_96091_3_, int p_96091_4_, int p_96091_5_, int p_96091_6_, float p_96091_7_) {
      return true;
   }

   public int func_82143_as() {
      return 3;
   }

   public int func_82148_at() {
      return this.field_82152_aq;
   }

   public boolean func_82144_au() {
      return false;
   }

   public void func_85029_a(CrashReportCategory p_85029_1_) {
      p_85029_1_.func_71500_a("Entity Type", new CallableEntityType(this));
      p_85029_1_.func_71507_a("Entity ID", Integer.valueOf(this.field_70157_k));
      p_85029_1_.func_71500_a("Entity Name", new CallableEntityName(this));
      p_85029_1_.func_71507_a("Entity\'s Exact location", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)}));
      p_85029_1_.func_71507_a("Entity\'s Block location", CrashReportCategory.func_85071_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)));
      p_85029_1_.func_71507_a("Entity\'s Momentum", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70159_w), Double.valueOf(this.field_70181_x), Double.valueOf(this.field_70179_y)}));
   }

   @SideOnly(Side.CLIENT)
   public boolean func_90999_ad() {
      return this.func_70027_ad();
   }

   public boolean func_96092_aw() {
      return true;
   }

   public String func_96090_ax() {
      return this.func_70023_ak();
   }

}
