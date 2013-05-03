package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.texture.StitchHolder;
import net.minecraft.client.renderer.texture.StitchSlot;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureManager;

@SideOnly(Side.CLIENT)
public class Stitcher {

   private final Set field_94319_a;
   private final List field_94317_b;
   private int field_94318_c;
   private int field_94315_d;
   private final int field_94316_e;
   private final int field_94313_f;
   private final boolean field_94314_g;
   private final int field_94323_h;
   private Texture field_94322_k;
   private final String field_94320_l;


   public Stitcher(String p_i9009_1_, int p_i9009_2_, int p_i9009_3_, boolean p_i9009_4_) {
      this(p_i9009_1_, p_i9009_2_, p_i9009_3_, p_i9009_4_, 0);
   }

   public Stitcher(String p_i9010_1_, int p_i9010_2_, int p_i9010_3_, boolean p_i9010_4_, int p_i9010_5_) {
      this.field_94319_a = new HashSet(256);
      this.field_94317_b = new ArrayList(256);
      this.field_94318_c = 0;
      this.field_94315_d = 0;
      this.field_94320_l = p_i9010_1_;
      this.field_94316_e = p_i9010_2_;
      this.field_94313_f = p_i9010_3_;
      this.field_94314_g = p_i9010_4_;
      this.field_94323_h = p_i9010_5_;
   }

   public void func_94312_a(StitchHolder p_94312_1_) {
      if(this.field_94323_h > 0) {
         p_94312_1_.func_94196_a(this.field_94323_h);
      }

      this.field_94319_a.add(p_94312_1_);
   }

   public Texture func_94306_e() {
      if(this.field_94314_g) {
         this.field_94318_c = this.func_94308_a(this.field_94318_c);
         this.field_94315_d = this.func_94308_a(this.field_94315_d);
      }

      this.field_94322_k = TextureManager.func_94267_b().func_98145_a(this.field_94320_l, 1, this.field_94318_c, this.field_94315_d, 6408);
      this.field_94322_k.func_94272_a(this.field_94322_k.func_94274_a(), -65536);
      List var1 = this.func_94309_g();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         StitchSlot var3 = (StitchSlot)var1.get(var2);
         StitchHolder var4 = var3.func_94183_a();
         this.field_94322_k.func_94281_a(var3.func_94186_b(), var3.func_94185_c(), var4.func_98150_a(), var4.func_94195_e());
      }

      TextureManager.func_94267_b().func_94264_a(this.field_94320_l, this.field_94322_k);
      return this.field_94322_k;
   }

   public void func_94305_f() {
      StitchHolder[] var1 = (StitchHolder[])this.field_94319_a.toArray(new StitchHolder[this.field_94319_a.size()]);
      Arrays.sort(var1);
      this.field_94322_k = null;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         StitchHolder var3 = var1[var2];
         if(!this.func_94310_b(var3)) {
            throw new StitcherException(var3);
         }
      }

   }

   public List func_94309_g() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_94317_b.iterator();

      while(var2.hasNext()) {
         StitchSlot var3 = (StitchSlot)var2.next();
         var3.func_94184_a(var1);
      }

      return var1;
   }

   private int func_94308_a(int p_94308_1_) {
      int var2 = p_94308_1_ - 1;
      var2 |= var2 >> 1;
      var2 |= var2 >> 2;
      var2 |= var2 >> 4;
      var2 |= var2 >> 8;
      var2 |= var2 >> 16;
      return var2 + 1;
   }

   private boolean func_94310_b(StitchHolder p_94310_1_) {
      for(int var2 = 0; var2 < this.field_94317_b.size(); ++var2) {
         if(((StitchSlot)this.field_94317_b.get(var2)).func_94182_a(p_94310_1_)) {
            return true;
         }

         p_94310_1_.func_94194_d();
         if(((StitchSlot)this.field_94317_b.get(var2)).func_94182_a(p_94310_1_)) {
            return true;
         }

         p_94310_1_.func_94194_d();
      }

      return this.func_94311_c(p_94310_1_);
   }

   private boolean func_94311_c(StitchHolder p_94311_1_) {
      int var2 = Math.min(p_94311_1_.func_94199_b(), p_94311_1_.func_94197_a());
      boolean var3 = this.field_94318_c == 0 && this.field_94315_d == 0;
      boolean var4;
      if(this.field_94314_g) {
         int var5 = this.func_94308_a(this.field_94318_c);
         int var6 = this.func_94308_a(this.field_94315_d);
         int var7 = this.func_94308_a(this.field_94318_c + var2);
         int var8 = this.func_94308_a(this.field_94315_d + var2);
         boolean var9 = var7 <= this.field_94316_e;
         boolean var10 = var8 <= this.field_94313_f;
         if(!var9 && !var10) {
            return false;
         }

         int var11 = Math.max(p_94311_1_.func_94199_b(), p_94311_1_.func_94197_a());
         if(var3 && !var9 && this.func_94308_a(this.field_94315_d + var11) > this.field_94313_f) {
            return false;
         }

         boolean var12 = var5 != var7;
         boolean var13 = var6 != var8;
         if(var12 ^ var13) {
            var4 = var12 && var9;
         } else {
            var4 = var9 && var5 <= var6;
         }
      } else {
         boolean var14 = this.field_94318_c + var2 <= this.field_94316_e;
         boolean var16 = this.field_94315_d + var2 <= this.field_94313_f;
         if(!var14 && !var16) {
            return false;
         }

         var4 = (var3 || this.field_94318_c <= this.field_94315_d) && var14;
      }

      StitchSlot var15;
      if(var4) {
         if(p_94311_1_.func_94197_a() > p_94311_1_.func_94199_b()) {
            p_94311_1_.func_94194_d();
         }

         if(this.field_94315_d == 0) {
            this.field_94315_d = p_94311_1_.func_94199_b();
         }

         var15 = new StitchSlot(this.field_94318_c, 0, p_94311_1_.func_94197_a(), this.field_94315_d);
         this.field_94318_c += p_94311_1_.func_94197_a();
      } else {
         var15 = new StitchSlot(0, this.field_94315_d, this.field_94318_c, p_94311_1_.func_94199_b());
         this.field_94315_d += p_94311_1_.func_94199_b();
      }

      var15.func_94182_a(p_94311_1_);
      this.field_94317_b.add(var15);
      return true;
   }
}
