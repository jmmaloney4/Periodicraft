package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemInWorldManager {

   public World field_73092_a;
   public EntityPlayerMP field_73090_b;
   private EnumGameType field_73091_c;
   private boolean field_73088_d;
   private int field_73089_e;
   private int field_73086_f;
   private int field_73087_g;
   private int field_73099_h;
   private int field_73100_i;
   private boolean field_73097_j;
   private int field_73098_k;
   private int field_73095_l;
   private int field_73096_m;
   private int field_73093_n;
   private int field_73094_o;


   public ItemInWorldManager(World p_i3397_1_) {
      this.field_73091_c = EnumGameType.NOT_SET;
      this.field_73094_o = -1;
      this.field_73092_a = p_i3397_1_;
   }

   public void func_73076_a(EnumGameType p_73076_1_) {
      this.field_73091_c = p_73076_1_;
      p_73076_1_.func_77147_a(this.field_73090_b.field_71075_bZ);
      this.field_73090_b.func_71016_p();
   }

   public EnumGameType func_73081_b() {
      return this.field_73091_c;
   }

   public boolean func_73083_d() {
      return this.field_73091_c.func_77145_d();
   }

   public void func_73077_b(EnumGameType p_73077_1_) {
      if(this.field_73091_c == EnumGameType.NOT_SET) {
         this.field_73091_c = p_73077_1_;
      }

      this.func_73076_a(this.field_73091_c);
   }

   public void func_73075_a() {
      ++this.field_73100_i;
      int var1;
      float var4;
      int var5;
      if(this.field_73097_j) {
         var1 = this.field_73100_i - this.field_73093_n;
         int var2 = this.field_73092_a.func_72798_a(this.field_73098_k, this.field_73095_l, this.field_73096_m);
         if(var2 == 0) {
            this.field_73097_j = false;
         } else {
            Block var3 = Block.field_71973_m[var2];
            var4 = var3.func_71908_a(this.field_73090_b, this.field_73090_b.field_70170_p, this.field_73098_k, this.field_73095_l, this.field_73096_m) * (float)(var1 + 1);
            var5 = (int)(var4 * 10.0F);
            if(var5 != this.field_73094_o) {
               this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, this.field_73098_k, this.field_73095_l, this.field_73096_m, var5);
               this.field_73094_o = var5;
            }

            if(var4 >= 1.0F) {
               this.field_73097_j = false;
               this.func_73084_b(this.field_73098_k, this.field_73095_l, this.field_73096_m);
            }
         }
      } else if(this.field_73088_d) {
         var1 = this.field_73092_a.func_72798_a(this.field_73086_f, this.field_73087_g, this.field_73099_h);
         Block var6 = Block.field_71973_m[var1];
         if(var6 == null) {
            this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, this.field_73086_f, this.field_73087_g, this.field_73099_h, -1);
            this.field_73094_o = -1;
            this.field_73088_d = false;
         } else {
            int var7 = this.field_73100_i - this.field_73089_e;
            var4 = var6.func_71908_a(this.field_73090_b, this.field_73090_b.field_70170_p, this.field_73086_f, this.field_73087_g, this.field_73099_h) * (float)(var7 + 1);
            var5 = (int)(var4 * 10.0F);
            if(var5 != this.field_73094_o) {
               this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, this.field_73086_f, this.field_73087_g, this.field_73099_h, var5);
               this.field_73094_o = var5;
            }
         }
      }

   }

   public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_) {
      if(!this.field_73091_c.func_82752_c() || this.field_73090_b.func_82246_f(p_73074_1_, p_73074_2_, p_73074_3_)) {
         if(this.func_73083_d()) {
            if(!this.field_73092_a.func_72886_a((EntityPlayer)null, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_)) {
               this.func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
            }

         } else {
            this.field_73092_a.func_72886_a((EntityPlayer)null, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
            this.field_73089_e = this.field_73100_i;
            float var5 = 1.0F;
            int var6 = this.field_73092_a.func_72798_a(p_73074_1_, p_73074_2_, p_73074_3_);
            if(var6 > 0) {
               Block.field_71973_m[var6].func_71921_a(this.field_73092_a, p_73074_1_, p_73074_2_, p_73074_3_, this.field_73090_b);
               var5 = Block.field_71973_m[var6].func_71908_a(this.field_73090_b, this.field_73090_b.field_70170_p, p_73074_1_, p_73074_2_, p_73074_3_);
            }

            if(var6 > 0 && var5 >= 1.0F) {
               this.func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
            } else {
               this.field_73088_d = true;
               this.field_73086_f = p_73074_1_;
               this.field_73087_g = p_73074_2_;
               this.field_73099_h = p_73074_3_;
               int var7 = (int)(var5 * 10.0F);
               this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, p_73074_1_, p_73074_2_, p_73074_3_, var7);
               this.field_73094_o = var7;
            }

         }
      }
   }

   public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_) {
      if(p_73082_1_ == this.field_73086_f && p_73082_2_ == this.field_73087_g && p_73082_3_ == this.field_73099_h) {
         int var4 = this.field_73100_i - this.field_73089_e;
         int var5 = this.field_73092_a.func_72798_a(p_73082_1_, p_73082_2_, p_73082_3_);
         if(var5 != 0) {
            Block var6 = Block.field_71973_m[var5];
            float var7 = var6.func_71908_a(this.field_73090_b, this.field_73090_b.field_70170_p, p_73082_1_, p_73082_2_, p_73082_3_) * (float)(var4 + 1);
            if(var7 >= 0.7F) {
               this.field_73088_d = false;
               this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, p_73082_1_, p_73082_2_, p_73082_3_, -1);
               this.func_73084_b(p_73082_1_, p_73082_2_, p_73082_3_);
            } else if(!this.field_73097_j) {
               this.field_73088_d = false;
               this.field_73097_j = true;
               this.field_73098_k = p_73082_1_;
               this.field_73095_l = p_73082_2_;
               this.field_73096_m = p_73082_3_;
               this.field_73093_n = this.field_73089_e;
            }
         }
      }

   }

   public void func_73073_c(int p_73073_1_, int p_73073_2_, int p_73073_3_) {
      this.field_73088_d = false;
      this.field_73092_a.func_72888_f(this.field_73090_b.field_70157_k, this.field_73086_f, this.field_73087_g, this.field_73099_h, -1);
   }

   private boolean func_73079_d(int p_73079_1_, int p_73079_2_, int p_73079_3_) {
      Block var4 = Block.field_71973_m[this.field_73092_a.func_72798_a(p_73079_1_, p_73079_2_, p_73079_3_)];
      int var5 = this.field_73092_a.func_72805_g(p_73079_1_, p_73079_2_, p_73079_3_);
      if(var4 != null) {
         var4.func_71846_a(this.field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, var5, this.field_73090_b);
      }

      boolean var6 = this.field_73092_a.func_94571_i(p_73079_1_, p_73079_2_, p_73079_3_);
      if(var4 != null && var6) {
         var4.func_71898_d(this.field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, var5);
      }

      return var6;
   }

   public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_) {
      if(this.field_73091_c.func_82752_c() && !this.field_73090_b.func_82246_f(p_73084_1_, p_73084_2_, p_73084_3_)) {
         return false;
      } else {
         int var4 = this.field_73092_a.func_72798_a(p_73084_1_, p_73084_2_, p_73084_3_);
         int var5 = this.field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_);
         this.field_73092_a.func_72889_a(this.field_73090_b, 2001, p_73084_1_, p_73084_2_, p_73084_3_, var4 + (this.field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_) << 12));
         boolean var6 = this.func_73079_d(p_73084_1_, p_73084_2_, p_73084_3_);
         if(this.func_73083_d()) {
            this.field_73090_b.field_71135_a.func_72567_b(new Packet53BlockChange(p_73084_1_, p_73084_2_, p_73084_3_, this.field_73092_a));
         } else {
            ItemStack var7 = this.field_73090_b.func_71045_bC();
            boolean var8 = this.field_73090_b.func_71062_b(Block.field_71973_m[var4]);
            if(var7 != null) {
               var7.func_77941_a(this.field_73092_a, var4, p_73084_1_, p_73084_2_, p_73084_3_, this.field_73090_b);
               if(var7.field_77994_a == 0) {
                  this.field_73090_b.func_71028_bD();
               }
            }

            if(var6 && var8) {
               Block.field_71973_m[var4].func_71893_a(this.field_73092_a, this.field_73090_b, p_73084_1_, p_73084_2_, p_73084_3_, var5);
            }
         }

         return var6;
      }
   }

   public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_) {
      int var4 = p_73085_3_.field_77994_a;
      int var5 = p_73085_3_.func_77960_j();
      ItemStack var6 = p_73085_3_.func_77957_a(p_73085_2_, p_73085_1_);
      if(var6 == p_73085_3_ && (var6 == null || var6.field_77994_a == var4 && var6.func_77988_m() <= 0 && var6.func_77960_j() == var5)) {
         return false;
      } else {
         p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = var6;
         if(this.func_73083_d()) {
            var6.field_77994_a = var4;
            if(var6.func_77984_f()) {
               var6.func_77964_b(var5);
            }
         }

         if(var6.field_77994_a == 0) {
            p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = null;
         }

         if(!p_73085_1_.func_71039_bw()) {
            ((EntityPlayerMP)p_73085_1_).func_71120_a(p_73085_1_.field_71069_bz);
         }

         return true;
      }
   }

   public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, float p_73078_8_, float p_73078_9_, float p_73078_10_) {
      int var11;
      if(!p_73078_1_.func_70093_af() || p_73078_1_.func_70694_bm() == null) {
         var11 = p_73078_2_.func_72798_a(p_73078_4_, p_73078_5_, p_73078_6_);
         if(var11 > 0 && Block.field_71973_m[var11].func_71903_a(p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_1_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_)) {
            return true;
         }
      }

      if(p_73078_3_ == null) {
         return false;
      } else if(this.func_73083_d()) {
         var11 = p_73078_3_.func_77960_j();
         int var12 = p_73078_3_.field_77994_a;
         boolean var13 = p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
         p_73078_3_.func_77964_b(var11);
         p_73078_3_.field_77994_a = var12;
         return var13;
      } else {
         return p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
      }
   }

   public void func_73080_a(WorldServer p_73080_1_) {
      this.field_73092_a = p_73080_1_;
   }
}
