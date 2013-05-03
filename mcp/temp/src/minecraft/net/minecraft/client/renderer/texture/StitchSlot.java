package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.texture.StitchHolder;

@SideOnly(Side.CLIENT)
public class StitchSlot {

   private final int field_94192_a;
   private final int field_94190_b;
   private final int field_94191_c;
   private final int field_94188_d;
   private List field_94189_e;
   private StitchHolder field_94187_f;


   public StitchSlot(int p_i9012_1_, int p_i9012_2_, int p_i9012_3_, int p_i9012_4_) {
      this.field_94192_a = p_i9012_1_;
      this.field_94190_b = p_i9012_2_;
      this.field_94191_c = p_i9012_3_;
      this.field_94188_d = p_i9012_4_;
   }

   public StitchHolder func_94183_a() {
      return this.field_94187_f;
   }

   public int func_94186_b() {
      return this.field_94192_a;
   }

   public int func_94185_c() {
      return this.field_94190_b;
   }

   public boolean func_94182_a(StitchHolder p_94182_1_) {
      if(this.field_94187_f != null) {
         return false;
      } else {
         int var2 = p_94182_1_.func_94197_a();
         int var3 = p_94182_1_.func_94199_b();
         if(var2 <= this.field_94191_c && var3 <= this.field_94188_d) {
            if(var2 == this.field_94191_c && var3 == this.field_94188_d) {
               this.field_94187_f = p_94182_1_;
               return true;
            } else {
               if(this.field_94189_e == null) {
                  this.field_94189_e = new ArrayList(1);
                  this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b, var2, var3));
                  int var4 = this.field_94191_c - var2;
                  int var5 = this.field_94188_d - var3;
                  if(var5 > 0 && var4 > 0) {
                     int var6 = Math.max(this.field_94188_d, var4);
                     int var7 = Math.max(this.field_94191_c, var5);
                     if(var6 >= var7) {
                        this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + var3, var2, var5));
                        this.field_94189_e.add(new StitchSlot(this.field_94192_a + var2, this.field_94190_b, var4, this.field_94188_d));
                     } else {
                        this.field_94189_e.add(new StitchSlot(this.field_94192_a + var2, this.field_94190_b, var4, var3));
                        this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + var3, this.field_94191_c, var5));
                     }
                  } else if(var4 == 0) {
                     this.field_94189_e.add(new StitchSlot(this.field_94192_a, this.field_94190_b + var3, var2, var5));
                  } else if(var5 == 0) {
                     this.field_94189_e.add(new StitchSlot(this.field_94192_a + var2, this.field_94190_b, var4, var3));
                  }
               }

               Iterator var8 = this.field_94189_e.iterator();

               StitchSlot var9;
               do {
                  if(!var8.hasNext()) {
                     return false;
                  }

                  var9 = (StitchSlot)var8.next();
               } while(!var9.func_94182_a(p_94182_1_));

               return true;
            }
         } else {
            return false;
         }
      }
   }

   public void func_94184_a(List p_94184_1_) {
      if(this.field_94187_f != null) {
         p_94184_1_.add(this);
      } else if(this.field_94189_e != null) {
         Iterator var2 = this.field_94189_e.iterator();

         while(var2.hasNext()) {
            StitchSlot var3 = (StitchSlot)var2.next();
            var3.func_94184_a(p_94184_1_);
         }
      }

   }

   public String toString() {
      return "Slot{originX=" + this.field_94192_a + ", originY=" + this.field_94190_b + ", width=" + this.field_94191_c + ", height=" + this.field_94188_d + ", texture=" + this.field_94187_f + ", subSlots=" + this.field_94189_e + '}';
   }
}
