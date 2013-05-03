package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFallingSand extends Entity {

   public int field_70287_a;
   public int field_70285_b;
   public int field_70286_c;
   public boolean field_70284_d;
   private boolean field_82157_e;
   private boolean field_82155_f;
   private int field_82156_g;
   private float field_82158_h;
   public NBTTagCompound field_98051_e;


   public EntityFallingSand(World p_i3536_1_) {
      super(p_i3536_1_);
      this.field_70286_c = 0;
      this.field_70284_d = true;
      this.field_82157_e = false;
      this.field_82155_f = false;
      this.field_82156_g = 40;
      this.field_82158_h = 2.0F;
      this.field_98051_e = null;
   }

   public EntityFallingSand(World p_i3537_1_, double p_i3537_2_, double p_i3537_4_, double p_i3537_6_, int p_i3537_8_) {
      this(p_i3537_1_, p_i3537_2_, p_i3537_4_, p_i3537_6_, p_i3537_8_, 0);
   }

   public EntityFallingSand(World p_i3538_1_, double p_i3538_2_, double p_i3538_4_, double p_i3538_6_, int p_i3538_8_, int p_i3538_9_) {
      super(p_i3538_1_);
      this.field_70286_c = 0;
      this.field_70284_d = true;
      this.field_82157_e = false;
      this.field_82155_f = false;
      this.field_82156_g = 40;
      this.field_82158_h = 2.0F;
      this.field_98051_e = null;
      this.field_70287_a = p_i3538_8_;
      this.field_70285_b = p_i3538_9_;
      this.field_70156_m = true;
      this.func_70105_a(0.98F, 0.98F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.func_70107_b(p_i3538_2_, p_i3538_4_, p_i3538_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i3538_2_;
      this.field_70167_r = p_i3538_4_;
      this.field_70166_s = p_i3538_6_;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {}

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      if(this.field_70287_a == 0) {
         this.func_70106_y();
      } else {
         this.field_70169_q = this.field_70165_t;
         this.field_70167_r = this.field_70163_u;
         this.field_70166_s = this.field_70161_v;
         ++this.field_70286_c;
         this.field_70181_x -= 0.03999999910593033D;
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.9800000190734863D;
         this.field_70181_x *= 0.9800000190734863D;
         this.field_70179_y *= 0.9800000190734863D;
         if(!this.field_70170_p.field_72995_K) {
            int var1 = MathHelper.func_76128_c(this.field_70165_t);
            int var2 = MathHelper.func_76128_c(this.field_70163_u);
            int var3 = MathHelper.func_76128_c(this.field_70161_v);
            if(this.field_70286_c == 1) {
               if(this.field_70170_p.func_72798_a(var1, var2, var3) != this.field_70287_a) {
                  this.func_70106_y();
                  return;
               }

               this.field_70170_p.func_94571_i(var1, var2, var3);
            }

            if(this.field_70122_E) {
               this.field_70159_w *= 0.699999988079071D;
               this.field_70179_y *= 0.699999988079071D;
               this.field_70181_x *= -0.5D;
               if(this.field_70170_p.func_72798_a(var1, var2, var3) != Block.field_72095_ac.field_71990_ca) {
                  this.func_70106_y();
                  if(!this.field_82157_e && this.field_70170_p.func_72931_a(this.field_70287_a, var1, var2, var3, true, 1, (Entity)null, (ItemStack)null) && !BlockSand.func_72191_e_(this.field_70170_p, var1, var2 - 1, var3) && this.field_70170_p.func_72832_d(var1, var2, var3, this.field_70287_a, this.field_70285_b, 3)) {
                     if(Block.field_71973_m[this.field_70287_a] instanceof BlockSand) {
                        ((BlockSand)Block.field_71973_m[this.field_70287_a]).func_82519_a_(this.field_70170_p, var1, var2, var3, this.field_70285_b);
                     }

                     if(this.field_98051_e != null && Block.field_71973_m[this.field_70287_a] instanceof ITileEntityProvider) {
                        TileEntity var4 = this.field_70170_p.func_72796_p(var1, var2, var3);
                        if(var4 != null) {
                           NBTTagCompound var5 = new NBTTagCompound();
                           var4.func_70310_b(var5);
                           Iterator var6 = this.field_98051_e.func_74758_c().iterator();

                           while(var6.hasNext()) {
                              NBTBase var7 = (NBTBase)var6.next();
                              if(!var7.func_74740_e().equals("x") && !var7.func_74740_e().equals("y") && !var7.func_74740_e().equals("z")) {
                                 var5.func_74782_a(var7.func_74740_e(), var7.func_74737_b());
                              }
                           }

                           var4.func_70307_a(var5);
                           var4.func_70296_d();
                        }
                     }
                  } else if(this.field_70284_d && !this.field_82157_e) {
                     this.func_70099_a(new ItemStack(this.field_70287_a, 1, Block.field_71973_m[this.field_70287_a].func_71899_b(this.field_70285_b)), 0.0F);
                  }
               }
            } else if(this.field_70286_c > 100 && !this.field_70170_p.field_72995_K && (var2 < 1 || var2 > 256) || this.field_70286_c > 600) {
               if(this.field_70284_d) {
                  this.func_70099_a(new ItemStack(this.field_70287_a, 1, Block.field_71973_m[this.field_70287_a].func_71899_b(this.field_70285_b)), 0.0F);
               }

               this.func_70106_y();
            }
         }

      }
   }

   protected void func_70069_a(float p_70069_1_) {
      if(this.field_82155_f) {
         int var2 = MathHelper.func_76123_f(p_70069_1_ - 1.0F);
         if(var2 > 0) {
            ArrayList var3 = new ArrayList(this.field_70170_p.func_72839_b(this, this.field_70121_D));
            DamageSource var4 = this.field_70287_a == Block.field_82510_ck.field_71990_ca?DamageSource.field_82728_o:DamageSource.field_82729_p;
            Iterator var5 = var3.iterator();

            while(var5.hasNext()) {
               Entity var6 = (Entity)var5.next();
               var6.func_70097_a(var4, Math.min(MathHelper.func_76141_d((float)var2 * this.field_82158_h), this.field_82156_g));
            }

            if(this.field_70287_a == Block.field_82510_ck.field_71990_ca && (double)this.field_70146_Z.nextFloat() < 0.05000000074505806D + (double)var2 * 0.05D) {
               int var7 = this.field_70285_b >> 2;
               int var8 = this.field_70285_b & 3;
               ++var7;
               if(var7 > 2) {
                  this.field_82157_e = true;
               } else {
                  this.field_70285_b = var8 | var7 << 2;
               }
            }
         }
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74774_a("Tile", (byte)this.field_70287_a);
      p_70014_1_.func_74768_a("TileID", this.field_70287_a);
      p_70014_1_.func_74774_a("Data", (byte)this.field_70285_b);
      p_70014_1_.func_74774_a("Time", (byte)this.field_70286_c);
      p_70014_1_.func_74757_a("DropItem", this.field_70284_d);
      p_70014_1_.func_74757_a("HurtEntities", this.field_82155_f);
      p_70014_1_.func_74776_a("FallHurtAmount", this.field_82158_h);
      p_70014_1_.func_74768_a("FallHurtMax", this.field_82156_g);
      if(this.field_98051_e != null) {
         p_70014_1_.func_74766_a("TileEntityData", this.field_98051_e);
      }

   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      if(p_70037_1_.func_74764_b("TileID")) {
         this.field_70287_a = p_70037_1_.func_74762_e("TileID");
      } else {
         this.field_70287_a = p_70037_1_.func_74771_c("Tile") & 255;
      }

      this.field_70285_b = p_70037_1_.func_74771_c("Data") & 255;
      this.field_70286_c = p_70037_1_.func_74771_c("Time") & 255;
      if(p_70037_1_.func_74764_b("HurtEntities")) {
         this.field_82155_f = p_70037_1_.func_74767_n("HurtEntities");
         this.field_82158_h = p_70037_1_.func_74760_g("FallHurtAmount");
         this.field_82156_g = p_70037_1_.func_74762_e("FallHurtMax");
      } else if(this.field_70287_a == Block.field_82510_ck.field_71990_ca) {
         this.field_82155_f = true;
      }

      if(p_70037_1_.func_74764_b("DropItem")) {
         this.field_70284_d = p_70037_1_.func_74767_n("DropItem");
      }

      if(p_70037_1_.func_74764_b("TileEntityData")) {
         this.field_98051_e = p_70037_1_.func_74775_l("TileEntityData");
      }

      if(this.field_70287_a == 0) {
         this.field_70287_a = Block.field_71939_E.field_71990_ca;
      }

   }

   public void func_82154_e(boolean p_82154_1_) {
      this.field_82155_f = p_82154_1_;
   }

   public void func_85029_a(CrashReportCategory p_85029_1_) {
      super.func_85029_a(p_85029_1_);
      p_85029_1_.func_71507_a("Immitating block ID", Integer.valueOf(this.field_70287_a));
      p_85029_1_.func_71507_a("Immitating block data", Integer.valueOf(this.field_70285_b));
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public World func_70283_d() {
      return this.field_70170_p;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_90999_ad() {
      return false;
   }
}
