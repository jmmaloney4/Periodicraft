package net.minecraft.util;

import net.minecraft.util.LongHashMapEntry;

public class LongHashMap {

   private transient LongHashMapEntry[] field_76169_a = new LongHashMapEntry[16];
   private transient int field_76167_b;
   private int field_76168_c = 12;
   private final float field_76165_d = 0.75F;
   private transient volatile int field_76166_e;


   private static int func_76155_g(long p_76155_0_) {
      return func_76157_a((int)(p_76155_0_ ^ p_76155_0_ >>> 32));
   }

   private static int func_76157_a(int p_76157_0_) {
      p_76157_0_ ^= p_76157_0_ >>> 20 ^ p_76157_0_ >>> 12;
      return p_76157_0_ ^ p_76157_0_ >>> 7 ^ p_76157_0_ >>> 4;
   }

   private static int func_76158_a(int p_76158_0_, int p_76158_1_) {
      return p_76158_0_ & p_76158_1_ - 1;
   }

   public int func_76162_a() {
      return this.field_76167_b;
   }

   public Object func_76164_a(long p_76164_1_) {
      int var3 = func_76155_g(p_76164_1_);

      for(LongHashMapEntry var4 = this.field_76169_a[func_76158_a(var3, this.field_76169_a.length)]; var4 != null; var4 = var4.field_76149_c) {
         if(var4.field_76150_a == p_76164_1_) {
            return var4.field_76148_b;
         }
      }

      return null;
   }

   public boolean func_76161_b(long p_76161_1_) {
      return this.func_76160_c(p_76161_1_) != null;
   }

   final LongHashMapEntry func_76160_c(long p_76160_1_) {
      int var3 = func_76155_g(p_76160_1_);

      for(LongHashMapEntry var4 = this.field_76169_a[func_76158_a(var3, this.field_76169_a.length)]; var4 != null; var4 = var4.field_76149_c) {
         if(var4.field_76150_a == p_76160_1_) {
            return var4;
         }
      }

      return null;
   }

   public void func_76163_a(long p_76163_1_, Object p_76163_3_) {
      int var4 = func_76155_g(p_76163_1_);
      int var5 = func_76158_a(var4, this.field_76169_a.length);

      for(LongHashMapEntry var6 = this.field_76169_a[var5]; var6 != null; var6 = var6.field_76149_c) {
         if(var6.field_76150_a == p_76163_1_) {
            var6.field_76148_b = p_76163_3_;
            return;
         }
      }

      ++this.field_76166_e;
      this.func_76156_a(var4, p_76163_1_, p_76163_3_, var5);
   }

   private void func_76153_b(int p_76153_1_) {
      LongHashMapEntry[] var2 = this.field_76169_a;
      int var3 = var2.length;
      if(var3 == 1073741824) {
         this.field_76168_c = Integer.MAX_VALUE;
      } else {
         LongHashMapEntry[] var4 = new LongHashMapEntry[p_76153_1_];
         this.func_76154_a(var4);
         this.field_76169_a = var4;
         this.field_76168_c = (int)((float)p_76153_1_ * this.field_76165_d);
      }
   }

   private void func_76154_a(LongHashMapEntry[] p_76154_1_) {
      LongHashMapEntry[] var2 = this.field_76169_a;
      int var3 = p_76154_1_.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         LongHashMapEntry var5 = var2[var4];
         if(var5 != null) {
            var2[var4] = null;

            LongHashMapEntry var6;
            do {
               var6 = var5.field_76149_c;
               int var7 = func_76158_a(var5.field_76147_d, var3);
               var5.field_76149_c = p_76154_1_[var7];
               p_76154_1_[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public Object func_76159_d(long p_76159_1_) {
      LongHashMapEntry var3 = this.func_76152_e(p_76159_1_);
      return var3 == null?null:var3.field_76148_b;
   }

   final LongHashMapEntry func_76152_e(long p_76152_1_) {
      int var3 = func_76155_g(p_76152_1_);
      int var4 = func_76158_a(var3, this.field_76169_a.length);
      LongHashMapEntry var5 = this.field_76169_a[var4];

      LongHashMapEntry var6;
      LongHashMapEntry var7;
      for(var6 = var5; var6 != null; var6 = var7) {
         var7 = var6.field_76149_c;
         if(var6.field_76150_a == p_76152_1_) {
            ++this.field_76166_e;
            --this.field_76167_b;
            if(var5 == var6) {
               this.field_76169_a[var4] = var7;
            } else {
               var5.field_76149_c = var7;
            }

            return var6;
         }

         var5 = var6;
      }

      return var6;
   }

   private void func_76156_a(int p_76156_1_, long p_76156_2_, Object p_76156_4_, int p_76156_5_) {
      LongHashMapEntry var6 = this.field_76169_a[p_76156_5_];
      this.field_76169_a[p_76156_5_] = new LongHashMapEntry(p_76156_1_, p_76156_2_, p_76156_4_, var6);
      if(this.field_76167_b++ >= this.field_76168_c) {
         this.func_76153_b(2 * this.field_76169_a.length);
      }

   }

   // $FF: synthetic method
   static int func_76151_f(long p_76151_0_) {
      return func_76155_g(p_76151_0_);
   }
}
