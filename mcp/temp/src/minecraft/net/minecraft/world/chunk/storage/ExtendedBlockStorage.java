package net.minecraft.world.chunk.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.NibbleArray;

public class ExtendedBlockStorage {

   private int field_76684_a;
   private int field_76682_b;
   private int field_76683_c;
   private byte[] field_76680_d;
   private NibbleArray field_76681_e;
   private NibbleArray field_76678_f;
   private NibbleArray field_76679_g;
   private NibbleArray field_76685_h;


   public ExtendedBlockStorage(int p_i8016_1_, boolean p_i8016_2_) {
      this.field_76684_a = p_i8016_1_;
      this.field_76680_d = new byte[4096];
      this.field_76678_f = new NibbleArray(this.field_76680_d.length, 4);
      this.field_76679_g = new NibbleArray(this.field_76680_d.length, 4);
      if(p_i8016_2_) {
         this.field_76685_h = new NibbleArray(this.field_76680_d.length, 4);
      }

   }

   public int func_76656_a(int p_76656_1_, int p_76656_2_, int p_76656_3_) {
      int var4 = this.field_76680_d[p_76656_2_ << 8 | p_76656_3_ << 4 | p_76656_1_] & 255;
      return this.field_76681_e != null?this.field_76681_e.func_76582_a(p_76656_1_, p_76656_2_, p_76656_3_) << 8 | var4:var4;
   }

   public void func_76655_a(int p_76655_1_, int p_76655_2_, int p_76655_3_, int p_76655_4_) {
      int var5 = this.field_76680_d[p_76655_2_ << 8 | p_76655_3_ << 4 | p_76655_1_] & 255;
      if(this.field_76681_e != null) {
         var5 |= this.field_76681_e.func_76582_a(p_76655_1_, p_76655_2_, p_76655_3_) << 8;
      }

      if(var5 == 0 && p_76655_4_ != 0) {
         ++this.field_76682_b;
         if(Block.field_71973_m[p_76655_4_] != null && Block.field_71973_m[p_76655_4_].func_71881_r()) {
            ++this.field_76683_c;
         }
      } else if(var5 != 0 && p_76655_4_ == 0) {
         --this.field_76682_b;
         if(Block.field_71973_m[var5] != null && Block.field_71973_m[var5].func_71881_r()) {
            --this.field_76683_c;
         }
      } else if(Block.field_71973_m[var5] != null && Block.field_71973_m[var5].func_71881_r() && (Block.field_71973_m[p_76655_4_] == null || !Block.field_71973_m[p_76655_4_].func_71881_r())) {
         --this.field_76683_c;
      } else if((Block.field_71973_m[var5] == null || !Block.field_71973_m[var5].func_71881_r()) && Block.field_71973_m[p_76655_4_] != null && Block.field_71973_m[p_76655_4_].func_71881_r()) {
         ++this.field_76683_c;
      }

      this.field_76680_d[p_76655_2_ << 8 | p_76655_3_ << 4 | p_76655_1_] = (byte)(p_76655_4_ & 255);
      if(p_76655_4_ > 255) {
         if(this.field_76681_e == null) {
            this.field_76681_e = new NibbleArray(this.field_76680_d.length, 4);
         }

         this.field_76681_e.func_76581_a(p_76655_1_, p_76655_2_, p_76655_3_, (p_76655_4_ & 3840) >> 8);
      } else if(this.field_76681_e != null) {
         this.field_76681_e.func_76581_a(p_76655_1_, p_76655_2_, p_76655_3_, 0);
      }

   }

   public int func_76665_b(int p_76665_1_, int p_76665_2_, int p_76665_3_) {
      return this.field_76678_f.func_76582_a(p_76665_1_, p_76665_2_, p_76665_3_);
   }

   public void func_76654_b(int p_76654_1_, int p_76654_2_, int p_76654_3_, int p_76654_4_) {
      this.field_76678_f.func_76581_a(p_76654_1_, p_76654_2_, p_76654_3_, p_76654_4_);
   }

   public boolean func_76663_a() {
      return this.field_76682_b == 0;
   }

   public boolean func_76675_b() {
      return this.field_76683_c > 0;
   }

   public int func_76662_d() {
      return this.field_76684_a;
   }

   public void func_76657_c(int p_76657_1_, int p_76657_2_, int p_76657_3_, int p_76657_4_) {
      this.field_76685_h.func_76581_a(p_76657_1_, p_76657_2_, p_76657_3_, p_76657_4_);
   }

   public int func_76670_c(int p_76670_1_, int p_76670_2_, int p_76670_3_) {
      return this.field_76685_h.func_76582_a(p_76670_1_, p_76670_2_, p_76670_3_);
   }

   public void func_76677_d(int p_76677_1_, int p_76677_2_, int p_76677_3_, int p_76677_4_) {
      this.field_76679_g.func_76581_a(p_76677_1_, p_76677_2_, p_76677_3_, p_76677_4_);
   }

   public int func_76674_d(int p_76674_1_, int p_76674_2_, int p_76674_3_) {
      return this.field_76679_g.func_76582_a(p_76674_1_, p_76674_2_, p_76674_3_);
   }

   public void func_76672_e() {
      this.field_76682_b = 0;
      this.field_76683_c = 0;

      for(int var1 = 0; var1 < 16; ++var1) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               int var4 = this.func_76656_a(var1, var2, var3);
               if(var4 > 0) {
                  if(Block.field_71973_m[var4] == null) {
                     this.field_76680_d[var2 << 8 | var3 << 4 | var1] = 0;
                     if(this.field_76681_e != null) {
                        this.field_76681_e.func_76581_a(var1, var2, var3, 0);
                     }
                  } else {
                     ++this.field_76682_b;
                     if(Block.field_71973_m[var4].func_71881_r()) {
                        ++this.field_76683_c;
                     }
                  }
               }
            }
         }
      }

   }

   public byte[] func_76658_g() {
      return this.field_76680_d;
   }

   @SideOnly(Side.CLIENT)
   public void func_76676_h() {
      this.field_76681_e = null;
   }

   public NibbleArray func_76660_i() {
      return this.field_76681_e;
   }

   public NibbleArray func_76669_j() {
      return this.field_76678_f;
   }

   public NibbleArray func_76661_k() {
      return this.field_76679_g;
   }

   public NibbleArray func_76671_l() {
      return this.field_76685_h;
   }

   public void func_76664_a(byte[] p_76664_1_) {
      this.field_76680_d = p_76664_1_;
   }

   public void func_76673_a(NibbleArray p_76673_1_) {
      this.field_76681_e = p_76673_1_;
   }

   public void func_76668_b(NibbleArray p_76668_1_) {
      this.field_76678_f = p_76668_1_;
   }

   public void func_76659_c(NibbleArray p_76659_1_) {
      this.field_76679_g = p_76659_1_;
   }

   public void func_76666_d(NibbleArray p_76666_1_) {
      this.field_76685_h = p_76666_1_;
   }

   @SideOnly(Side.CLIENT)
   public NibbleArray func_76667_m() {
      this.field_76681_e = new NibbleArray(this.field_76680_d.length, 4);
      return this.field_76681_e;
   }
}
