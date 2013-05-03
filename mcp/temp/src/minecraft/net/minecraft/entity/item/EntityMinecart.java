package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class EntityMinecart extends Entity {

   protected boolean field_70499_f;
   protected final IUpdatePlayerListBox field_82344_g;
   protected String field_94102_c;
   protected static final int[][][] field_70500_g = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
   protected int field_70510_h;
   protected double field_70511_i;
   protected double field_70509_j;
   protected double field_70514_an;
   protected double field_70512_ao;
   protected double field_70513_ap;
   @SideOnly(Side.CLIENT)
   protected double field_70508_aq;
   @SideOnly(Side.CLIENT)
   protected double field_70507_ar;
   @SideOnly(Side.CLIENT)
   protected double field_70506_as;


   public EntityMinecart(World p_i3541_1_) {
      super(p_i3541_1_);
      this.field_70499_f = false;
      this.field_70156_m = true;
      this.func_70105_a(0.98F, 0.7F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.field_82344_g = p_i3541_1_ != null?p_i3541_1_.func_82735_a(this):null;
   }

   public static EntityMinecart func_94090_a(World p_94090_0_, double p_94090_1_, double p_94090_3_, double p_94090_5_, int p_94090_7_) {
      switch(p_94090_7_) {
      case 1:
         return new EntityMinecartChest(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      case 2:
         return new EntityMinecartFurnace(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      case 3:
         return new EntityMinecartTNT(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      case 4:
         return new EntityMinecartMobSpawner(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      case 5:
         return new EntityMinecartHopper(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      default:
         return new EntityMinecartEmpty(p_94090_0_, p_94090_1_, p_94090_3_, p_94090_5_);
      }
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(1));
      this.field_70180_af.func_75682_a(19, new Integer(0));
      this.field_70180_af.func_75682_a(20, new Integer(0));
      this.field_70180_af.func_75682_a(21, new Integer(6));
      this.field_70180_af.func_75682_a(22, Byte.valueOf((byte)0));
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return p_70114_1_.func_70104_M()?p_70114_1_.field_70121_D:null;
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public boolean func_70104_M() {
      return true;
   }

   public EntityMinecart(World p_i9021_1_, double p_i9021_2_, double p_i9021_4_, double p_i9021_6_) {
      this(p_i9021_1_);
      this.func_70107_b(p_i9021_2_, p_i9021_4_ + (double)this.field_70129_M, p_i9021_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i9021_2_;
      this.field_70167_r = p_i9021_4_;
      this.field_70166_s = p_i9021_6_;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.0D - 0.30000001192092896D;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         if(this.func_85032_ar()) {
            return false;
         } else {
            this.func_70494_i(-this.func_70493_k());
            this.func_70497_h(10);
            this.func_70018_K();
            this.func_70492_c(this.func_70491_i() + p_70097_2_ * 10);
            boolean var3 = p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d;
            if(var3 || this.func_70491_i() > 40) {
               if(this.field_70153_n != null) {
                  this.field_70153_n.func_70078_a(this);
               }

               if(var3 && !this.func_94042_c()) {
                  this.func_70106_y();
               } else {
                  this.func_94095_a(p_70097_1_);
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      this.func_70106_y();
      ItemStack var2 = new ItemStack(Item.field_77773_az, 1);
      if(this.field_94102_c != null) {
         var2.func_82834_c(this.field_94102_c);
      }

      this.func_70099_a(var2, 0.0F);
   }

   @SideOnly(Side.CLIENT)
   public void func_70057_ab() {
      this.func_70494_i(-this.func_70493_k());
      this.func_70497_h(10);
      this.func_70492_c(this.func_70491_i() + this.func_70491_i() * 10);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70106_y() {
      super.func_70106_y();
      if(this.field_82344_g != null) {
         this.field_82344_g.func_73660_a();
      }

   }

   public void func_70071_h_() {
      if(this.field_82344_g != null) {
         this.field_82344_g.func_73660_a();
      }

      if(this.func_70496_j() > 0) {
         this.func_70497_h(this.func_70496_j() - 1);
      }

      if(this.func_70491_i() > 0) {
         this.func_70492_c(this.func_70491_i() - 1);
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

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

      if(this.field_70170_p.field_72995_K) {
         if(this.field_70510_h > 0) {
            double var19 = this.field_70165_t + (this.field_70511_i - this.field_70165_t) / (double)this.field_70510_h;
            double var21 = this.field_70163_u + (this.field_70509_j - this.field_70163_u) / (double)this.field_70510_h;
            double var5 = this.field_70161_v + (this.field_70514_an - this.field_70161_v) / (double)this.field_70510_h;
            double var7 = MathHelper.func_76138_g(this.field_70512_ao - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_70510_h);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70513_ap - (double)this.field_70125_A) / (double)this.field_70510_h);
            --this.field_70510_h;
            this.func_70107_b(var19, var21, var5);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         } else {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         }

      } else {
         this.field_70169_q = this.field_70165_t;
         this.field_70167_r = this.field_70163_u;
         this.field_70166_s = this.field_70161_v;
         this.field_70181_x -= 0.03999999910593033D;
         int var18 = MathHelper.func_76128_c(this.field_70165_t);
         var2 = MathHelper.func_76128_c(this.field_70163_u);
         int var20 = MathHelper.func_76128_c(this.field_70161_v);
         if(BlockRailBase.func_72180_d_(this.field_70170_p, var18, var2 - 1, var20)) {
            --var2;
         }

         double var4 = 0.4D;
         double var6 = 0.0078125D;
         int var8 = this.field_70170_p.func_72798_a(var18, var2, var20);
         if(BlockRailBase.func_72184_d(var8)) {
            int var9 = this.field_70170_p.func_72805_g(var18, var2, var20);
            this.func_94091_a(var18, var2, var20, var4, var6, var8, var9);
            if(var8 == Block.field_94337_cv.field_71990_ca) {
               this.func_96095_a(var18, var2, var20, (var9 & 8) != 0);
            }
         } else {
            this.func_94088_b(var4);
         }

         this.func_70017_D();
         this.field_70125_A = 0.0F;
         double var22 = this.field_70169_q - this.field_70165_t;
         double var11 = this.field_70166_s - this.field_70161_v;
         if(var22 * var22 + var11 * var11 > 0.0010D) {
            this.field_70177_z = (float)(Math.atan2(var11, var22) * 180.0D / 3.141592653589793D);
            if(this.field_70499_f) {
               this.field_70177_z += 180.0F;
            }
         }

         double var13 = (double)MathHelper.func_76142_g(this.field_70177_z - this.field_70126_B);
         if(var13 < -170.0D || var13 >= 170.0D) {
            this.field_70177_z += 180.0F;
            this.field_70499_f = !this.field_70499_f;
         }

         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         List var15 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
         if(var15 != null && !var15.isEmpty()) {
            for(int var16 = 0; var16 < var15.size(); ++var16) {
               Entity var17 = (Entity)var15.get(var16);
               if(var17 != this.field_70153_n && var17.func_70104_M() && var17 instanceof EntityMinecart) {
                  var17.func_70108_f(this);
               }
            }
         }

         if(this.field_70153_n != null && this.field_70153_n.field_70128_L) {
            if(this.field_70153_n.field_70154_o == this) {
               this.field_70153_n.field_70154_o = null;
            }

            this.field_70153_n = null;
         }

      }
   }

   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {}

   protected void func_94088_b(double p_94088_1_) {
      if(this.field_70159_w < -p_94088_1_) {
         this.field_70159_w = -p_94088_1_;
      }

      if(this.field_70159_w > p_94088_1_) {
         this.field_70159_w = p_94088_1_;
      }

      if(this.field_70179_y < -p_94088_1_) {
         this.field_70179_y = -p_94088_1_;
      }

      if(this.field_70179_y > p_94088_1_) {
         this.field_70179_y = p_94088_1_;
      }

      if(this.field_70122_E) {
         this.field_70159_w *= 0.5D;
         this.field_70181_x *= 0.5D;
         this.field_70179_y *= 0.5D;
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      if(!this.field_70122_E) {
         this.field_70159_w *= 0.949999988079071D;
         this.field_70181_x *= 0.949999988079071D;
         this.field_70179_y *= 0.949999988079071D;
      }

   }

   protected void func_94091_a(int p_94091_1_, int p_94091_2_, int p_94091_3_, double p_94091_4_, double p_94091_6_, int p_94091_8_, int p_94091_9_) {
      this.field_70143_R = 0.0F;
      Vec3 var10 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70163_u = (double)p_94091_2_;
      boolean var11 = false;
      boolean var12 = false;
      if(p_94091_8_ == Block.field_71954_T.field_71990_ca) {
         var11 = (p_94091_9_ & 8) != 0;
         var12 = !var11;
      }

      if(((BlockRailBase)Block.field_71973_m[p_94091_8_]).func_72183_n()) {
         p_94091_9_ &= 7;
      }

      if(p_94091_9_ >= 2 && p_94091_9_ <= 5) {
         this.field_70163_u = (double)(p_94091_2_ + 1);
      }

      if(p_94091_9_ == 2) {
         this.field_70159_w -= p_94091_6_;
      }

      if(p_94091_9_ == 3) {
         this.field_70159_w += p_94091_6_;
      }

      if(p_94091_9_ == 4) {
         this.field_70179_y += p_94091_6_;
      }

      if(p_94091_9_ == 5) {
         this.field_70179_y -= p_94091_6_;
      }

      int[][] var13 = field_70500_g[p_94091_9_];
      double var14 = (double)(var13[1][0] - var13[0][0]);
      double var16 = (double)(var13[1][2] - var13[0][2]);
      double var18 = Math.sqrt(var14 * var14 + var16 * var16);
      double var20 = this.field_70159_w * var14 + this.field_70179_y * var16;
      if(var20 < 0.0D) {
         var14 = -var14;
         var16 = -var16;
      }

      double var22 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      if(var22 > 2.0D) {
         var22 = 2.0D;
      }

      this.field_70159_w = var22 * var14 / var18;
      this.field_70179_y = var22 * var16 / var18;
      double var24;
      double var26;
      if(this.field_70153_n != null) {
         var24 = this.field_70153_n.field_70159_w * this.field_70153_n.field_70159_w + this.field_70153_n.field_70179_y * this.field_70153_n.field_70179_y;
         var26 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
         if(var24 > 1.0E-4D && var26 < 0.01D) {
            this.field_70159_w += this.field_70153_n.field_70159_w * 0.1D;
            this.field_70179_y += this.field_70153_n.field_70179_y * 0.1D;
            var12 = false;
         }
      }

      if(var12) {
         var24 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var24 < 0.03D) {
            this.field_70159_w *= 0.0D;
            this.field_70181_x *= 0.0D;
            this.field_70179_y *= 0.0D;
         } else {
            this.field_70159_w *= 0.5D;
            this.field_70181_x *= 0.0D;
            this.field_70179_y *= 0.5D;
         }
      }

      var24 = 0.0D;
      var26 = (double)p_94091_1_ + 0.5D + (double)var13[0][0] * 0.5D;
      double var28 = (double)p_94091_3_ + 0.5D + (double)var13[0][2] * 0.5D;
      double var30 = (double)p_94091_1_ + 0.5D + (double)var13[1][0] * 0.5D;
      double var32 = (double)p_94091_3_ + 0.5D + (double)var13[1][2] * 0.5D;
      var14 = var30 - var26;
      var16 = var32 - var28;
      double var34;
      double var36;
      if(var14 == 0.0D) {
         this.field_70165_t = (double)p_94091_1_ + 0.5D;
         var24 = this.field_70161_v - (double)p_94091_3_;
      } else if(var16 == 0.0D) {
         this.field_70161_v = (double)p_94091_3_ + 0.5D;
         var24 = this.field_70165_t - (double)p_94091_1_;
      } else {
         var34 = this.field_70165_t - var26;
         var36 = this.field_70161_v - var28;
         var24 = (var34 * var14 + var36 * var16) * 2.0D;
      }

      this.field_70165_t = var26 + var14 * var24;
      this.field_70161_v = var28 + var16 * var24;
      this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)this.field_70129_M, this.field_70161_v);
      var34 = this.field_70159_w;
      var36 = this.field_70179_y;
      if(this.field_70153_n != null) {
         var34 *= 0.75D;
         var36 *= 0.75D;
      }

      if(var34 < -p_94091_4_) {
         var34 = -p_94091_4_;
      }

      if(var34 > p_94091_4_) {
         var34 = p_94091_4_;
      }

      if(var36 < -p_94091_4_) {
         var36 = -p_94091_4_;
      }

      if(var36 > p_94091_4_) {
         var36 = p_94091_4_;
      }

      this.func_70091_d(var34, 0.0D, var36);
      if(var13[0][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_94091_1_ == var13[0][0] && MathHelper.func_76128_c(this.field_70161_v) - p_94091_3_ == var13[0][2]) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)var13[0][1], this.field_70161_v);
      } else if(var13[1][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_94091_1_ == var13[1][0] && MathHelper.func_76128_c(this.field_70161_v) - p_94091_3_ == var13[1][2]) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)var13[1][1], this.field_70161_v);
      }

      this.func_94101_h();
      Vec3 var38 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      if(var38 != null && var10 != null) {
         double var39 = (var10.field_72448_b - var38.field_72448_b) * 0.05D;
         var22 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var22 > 0.0D) {
            this.field_70159_w = this.field_70159_w / var22 * (var22 + var39);
            this.field_70179_y = this.field_70179_y / var22 * (var22 + var39);
         }

         this.func_70107_b(this.field_70165_t, var38.field_72448_b, this.field_70161_v);
      }

      int var45 = MathHelper.func_76128_c(this.field_70165_t);
      int var40 = MathHelper.func_76128_c(this.field_70161_v);
      if(var45 != p_94091_1_ || var40 != p_94091_3_) {
         var22 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70159_w = var22 * (double)(var45 - p_94091_1_);
         this.field_70179_y = var22 * (double)(var40 - p_94091_3_);
      }

      if(var11) {
         double var41 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var41 > 0.01D) {
            double var43 = 0.06D;
            this.field_70159_w += this.field_70159_w / var41 * var43;
            this.field_70179_y += this.field_70179_y / var41 * var43;
         } else if(p_94091_9_ == 1) {
            if(this.field_70170_p.func_72809_s(p_94091_1_ - 1, p_94091_2_, p_94091_3_)) {
               this.field_70159_w = 0.02D;
            } else if(this.field_70170_p.func_72809_s(p_94091_1_ + 1, p_94091_2_, p_94091_3_)) {
               this.field_70159_w = -0.02D;
            }
         } else if(p_94091_9_ == 0) {
            if(this.field_70170_p.func_72809_s(p_94091_1_, p_94091_2_, p_94091_3_ - 1)) {
               this.field_70179_y = 0.02D;
            } else if(this.field_70170_p.func_72809_s(p_94091_1_, p_94091_2_, p_94091_3_ + 1)) {
               this.field_70179_y = -0.02D;
            }
         }
      }

   }

   protected void func_94101_h() {
      if(this.field_70153_n != null) {
         this.field_70159_w *= 0.996999979019165D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.996999979019165D;
      } else {
         this.field_70159_w *= 0.9599999785423279D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.9599999785423279D;
      }

   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_70495_a(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_) {
      int var9 = MathHelper.func_76128_c(p_70495_1_);
      int var10 = MathHelper.func_76128_c(p_70495_3_);
      int var11 = MathHelper.func_76128_c(p_70495_5_);
      if(BlockRailBase.func_72180_d_(this.field_70170_p, var9, var10 - 1, var11)) {
         --var10;
      }

      int var12 = this.field_70170_p.func_72798_a(var9, var10, var11);
      if(!BlockRailBase.func_72184_d(var12)) {
         return null;
      } else {
         int var13 = this.field_70170_p.func_72805_g(var9, var10, var11);
         if(((BlockRailBase)Block.field_71973_m[var12]).func_72183_n()) {
            var13 &= 7;
         }

         p_70495_3_ = (double)var10;
         if(var13 >= 2 && var13 <= 5) {
            p_70495_3_ = (double)(var10 + 1);
         }

         int[][] var14 = field_70500_g[var13];
         double var15 = (double)(var14[1][0] - var14[0][0]);
         double var17 = (double)(var14[1][2] - var14[0][2]);
         double var19 = Math.sqrt(var15 * var15 + var17 * var17);
         var15 /= var19;
         var17 /= var19;
         p_70495_1_ += var15 * p_70495_7_;
         p_70495_5_ += var17 * p_70495_7_;
         if(var14[0][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - var9 == var14[0][0] && MathHelper.func_76128_c(p_70495_5_) - var11 == var14[0][2]) {
            p_70495_3_ += (double)var14[0][1];
         } else if(var14[1][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - var9 == var14[1][0] && MathHelper.func_76128_c(p_70495_5_) - var11 == var14[1][2]) {
            p_70495_3_ += (double)var14[1][1];
         }

         return this.func_70489_a(p_70495_1_, p_70495_3_, p_70495_5_);
      }
   }

   public Vec3 func_70489_a(double p_70489_1_, double p_70489_3_, double p_70489_5_) {
      int var7 = MathHelper.func_76128_c(p_70489_1_);
      int var8 = MathHelper.func_76128_c(p_70489_3_);
      int var9 = MathHelper.func_76128_c(p_70489_5_);
      if(BlockRailBase.func_72180_d_(this.field_70170_p, var7, var8 - 1, var9)) {
         --var8;
      }

      int var10 = this.field_70170_p.func_72798_a(var7, var8, var9);
      if(BlockRailBase.func_72184_d(var10)) {
         int var11 = this.field_70170_p.func_72805_g(var7, var8, var9);
         p_70489_3_ = (double)var8;
         if(((BlockRailBase)Block.field_71973_m[var10]).func_72183_n()) {
            var11 &= 7;
         }

         if(var11 >= 2 && var11 <= 5) {
            p_70489_3_ = (double)(var8 + 1);
         }

         int[][] var12 = field_70500_g[var11];
         double var13 = 0.0D;
         double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
         double var17 = (double)var8 + 0.5D + (double)var12[0][1] * 0.5D;
         double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
         double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
         double var23 = (double)var8 + 0.5D + (double)var12[1][1] * 0.5D;
         double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
         double var27 = var21 - var15;
         double var29 = (var23 - var17) * 2.0D;
         double var31 = var25 - var19;
         if(var27 == 0.0D) {
            p_70489_1_ = (double)var7 + 0.5D;
            var13 = p_70489_5_ - (double)var9;
         } else if(var31 == 0.0D) {
            p_70489_5_ = (double)var9 + 0.5D;
            var13 = p_70489_1_ - (double)var7;
         } else {
            double var33 = p_70489_1_ - var15;
            double var35 = p_70489_5_ - var19;
            var13 = (var33 * var27 + var35 * var31) * 2.0D;
         }

         p_70489_1_ = var15 + var27 * var13;
         p_70489_3_ = var17 + var29 * var13;
         p_70489_5_ = var19 + var31 * var13;
         if(var29 < 0.0D) {
            ++p_70489_3_;
         }

         if(var29 > 0.0D) {
            p_70489_3_ += 0.5D;
         }

         return this.field_70170_p.func_82732_R().func_72345_a(p_70489_1_, p_70489_3_, p_70489_5_);
      } else {
         return null;
      }
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      if(p_70037_1_.func_74767_n("CustomDisplayTile")) {
         this.func_94094_j(p_70037_1_.func_74762_e("DisplayTile"));
         this.func_94092_k(p_70037_1_.func_74762_e("DisplayData"));
         this.func_94086_l(p_70037_1_.func_74762_e("DisplayOffset"));
      }

      if(p_70037_1_.func_74764_b("CustomName") && p_70037_1_.func_74779_i("CustomName").length() > 0) {
         this.field_94102_c = p_70037_1_.func_74779_i("CustomName");
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      if(this.func_94100_s()) {
         p_70014_1_.func_74757_a("CustomDisplayTile", true);
         p_70014_1_.func_74768_a("DisplayTile", this.func_94089_m() == null?0:this.func_94089_m().field_71990_ca);
         p_70014_1_.func_74768_a("DisplayData", this.func_94098_o());
         p_70014_1_.func_74768_a("DisplayOffset", this.func_94099_q());
      }

      if(this.field_94102_c != null && this.field_94102_c.length() > 0) {
         p_70014_1_.func_74778_a("CustomName", this.field_94102_c);
      }

   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public void func_70108_f(Entity p_70108_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(p_70108_1_ != this.field_70153_n) {
            if(p_70108_1_ instanceof EntityLiving && !(p_70108_1_ instanceof EntityPlayer) && !(p_70108_1_ instanceof EntityIronGolem) && this.func_94087_l() == 0 && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.01D && this.field_70153_n == null && p_70108_1_.field_70154_o == null) {
               p_70108_1_.func_70078_a(this);
            }

            double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
            double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
            double var6 = var2 * var2 + var4 * var4;
            if(var6 >= 9.999999747378752E-5D) {
               var6 = (double)MathHelper.func_76133_a(var6);
               var2 /= var6;
               var4 /= var6;
               double var8 = 1.0D / var6;
               if(var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var2 *= var8;
               var4 *= var8;
               var2 *= 0.10000000149011612D;
               var4 *= 0.10000000149011612D;
               var2 *= (double)(1.0F - this.field_70144_Y);
               var4 *= (double)(1.0F - this.field_70144_Y);
               var2 *= 0.5D;
               var4 *= 0.5D;
               if(p_70108_1_ instanceof EntityMinecart) {
                  double var10 = p_70108_1_.field_70165_t - this.field_70165_t;
                  double var12 = p_70108_1_.field_70161_v - this.field_70161_v;
                  Vec3 var14 = this.field_70170_p.func_82732_R().func_72345_a(var10, 0.0D, var12).func_72432_b();
                  Vec3 var15 = this.field_70170_p.func_82732_R().func_72345_a((double)MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F), 0.0D, (double)MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F)).func_72432_b();
                  double var16 = Math.abs(var14.func_72430_b(var15));
                  if(var16 < 0.800000011920929D) {
                     return;
                  }

                  double var18 = p_70108_1_.field_70159_w + this.field_70159_w;
                  double var20 = p_70108_1_.field_70179_y + this.field_70179_y;
                  if(((EntityMinecart)p_70108_1_).func_94087_l() == 2 && this.func_94087_l() != 2) {
                     this.field_70159_w *= 0.20000000298023224D;
                     this.field_70179_y *= 0.20000000298023224D;
                     this.func_70024_g(p_70108_1_.field_70159_w - var2, 0.0D, p_70108_1_.field_70179_y - var4);
                     p_70108_1_.field_70159_w *= 0.949999988079071D;
                     p_70108_1_.field_70179_y *= 0.949999988079071D;
                  } else if(((EntityMinecart)p_70108_1_).func_94087_l() != 2 && this.func_94087_l() == 2) {
                     p_70108_1_.field_70159_w *= 0.20000000298023224D;
                     p_70108_1_.field_70179_y *= 0.20000000298023224D;
                     p_70108_1_.func_70024_g(this.field_70159_w + var2, 0.0D, this.field_70179_y + var4);
                     this.field_70159_w *= 0.949999988079071D;
                     this.field_70179_y *= 0.949999988079071D;
                  } else {
                     var18 /= 2.0D;
                     var20 /= 2.0D;
                     this.field_70159_w *= 0.20000000298023224D;
                     this.field_70179_y *= 0.20000000298023224D;
                     this.func_70024_g(var18 - var2, 0.0D, var20 - var4);
                     p_70108_1_.field_70159_w *= 0.20000000298023224D;
                     p_70108_1_.field_70179_y *= 0.20000000298023224D;
                     p_70108_1_.func_70024_g(var18 + var2, 0.0D, var20 + var4);
                  }
               } else {
                  this.func_70024_g(-var2, 0.0D, -var4);
                  p_70108_1_.func_70024_g(var2 / 4.0D, 0.0D, var4 / 4.0D);
               }
            }

         }
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      this.field_70511_i = p_70056_1_;
      this.field_70509_j = p_70056_3_;
      this.field_70514_an = p_70056_5_;
      this.field_70512_ao = (double)p_70056_7_;
      this.field_70513_ap = (double)p_70056_8_;
      this.field_70510_h = p_70056_9_ + 2;
      this.field_70159_w = this.field_70508_aq;
      this.field_70181_x = this.field_70507_ar;
      this.field_70179_y = this.field_70506_as;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70508_aq = this.field_70159_w = p_70016_1_;
      this.field_70507_ar = this.field_70181_x = p_70016_3_;
      this.field_70506_as = this.field_70179_y = p_70016_5_;
   }

   public void func_70492_c(int p_70492_1_) {
      this.field_70180_af.func_75692_b(19, Integer.valueOf(p_70492_1_));
   }

   public int func_70491_i() {
      return this.field_70180_af.func_75679_c(19);
   }

   public void func_70497_h(int p_70497_1_) {
      this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70497_1_));
   }

   public int func_70496_j() {
      return this.field_70180_af.func_75679_c(17);
   }

   public void func_70494_i(int p_70494_1_) {
      this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70494_1_));
   }

   public int func_70493_k() {
      return this.field_70180_af.func_75679_c(18);
   }

   public abstract int func_94087_l();

   public Block func_94089_m() {
      if(!this.func_94100_s()) {
         return this.func_94093_n();
      } else {
         int var1 = this.func_70096_w().func_75679_c(20) & '\uffff';
         return var1 > 0 && var1 < Block.field_71973_m.length?Block.field_71973_m[var1]:null;
      }
   }

   public Block func_94093_n() {
      return null;
   }

   public int func_94098_o() {
      return !this.func_94100_s()?this.func_94097_p():this.func_70096_w().func_75679_c(20) >> 16;
   }

   public int func_94097_p() {
      return 0;
   }

   public int func_94099_q() {
      return !this.func_94100_s()?this.func_94085_r():this.func_70096_w().func_75679_c(21);
   }

   public int func_94085_r() {
      return 6;
   }

   public void func_94094_j(int p_94094_1_) {
      this.func_70096_w().func_75692_b(20, Integer.valueOf(p_94094_1_ & '\uffff' | this.func_94098_o() << 16));
      this.func_94096_e(true);
   }

   public void func_94092_k(int p_94092_1_) {
      Block var2 = this.func_94089_m();
      int var3 = var2 == null?0:var2.field_71990_ca;
      this.func_70096_w().func_75692_b(20, Integer.valueOf(var3 & '\uffff' | p_94092_1_ << 16));
      this.func_94096_e(true);
   }

   public void func_94086_l(int p_94086_1_) {
      this.func_70096_w().func_75692_b(21, Integer.valueOf(p_94086_1_));
      this.func_94096_e(true);
   }

   public boolean func_94100_s() {
      return this.func_70096_w().func_75683_a(22) == 1;
   }

   public void func_94096_e(boolean p_94096_1_) {
      this.func_70096_w().func_75692_b(22, Byte.valueOf((byte)(p_94096_1_?1:0)));
   }

   public void func_96094_a(String p_96094_1_) {
      this.field_94102_c = p_96094_1_;
   }

   public String func_70023_ak() {
      return this.field_94102_c != null?this.field_94102_c:super.func_70023_ak();
   }

   public boolean func_94042_c() {
      return this.field_94102_c != null;
   }

   public String func_95999_t() {
      return this.field_94102_c;
   }

}
