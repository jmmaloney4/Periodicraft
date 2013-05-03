package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.Vec3;

public class Vec3Pool {

   private final int field_72351_a;
   private final int field_72349_b;
   private final List field_72350_c = new ArrayList();
   private int field_72347_d = 0;
   private int field_72348_e = 0;
   private int field_72346_f = 0;


   public Vec3Pool(int p_i4035_1_, int p_i4035_2_) {
      this.field_72351_a = p_i4035_1_;
      this.field_72349_b = p_i4035_2_;
   }

   public Vec3 func_72345_a(double p_72345_1_, double p_72345_3_, double p_72345_5_) {
      if(this.func_82589_e()) {
         return new Vec3(this, p_72345_1_, p_72345_3_, p_72345_5_);
      } else {
         Vec3 var7;
         if(this.field_72347_d >= this.field_72350_c.size()) {
            var7 = new Vec3(this, p_72345_1_, p_72345_3_, p_72345_5_);
            this.field_72350_c.add(var7);
         } else {
            var7 = (Vec3)this.field_72350_c.get(this.field_72347_d);
            var7.func_72439_b(p_72345_1_, p_72345_3_, p_72345_5_);
         }

         ++this.field_72347_d;
         return var7;
      }
   }

   public void func_72343_a() {
      if(!this.func_82589_e()) {
         if(this.field_72347_d > this.field_72348_e) {
            this.field_72348_e = this.field_72347_d;
         }

         if(this.field_72346_f++ == this.field_72351_a) {
            int var1 = Math.max(this.field_72348_e, this.field_72350_c.size() - this.field_72349_b);

            while(this.field_72350_c.size() > var1) {
               this.field_72350_c.remove(var1);
            }

            this.field_72348_e = 0;
            this.field_72346_f = 0;
         }

         this.field_72347_d = 0;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_72344_b() {
      if(!this.func_82589_e()) {
         this.field_72347_d = 0;
         this.field_72350_c.clear();
      }
   }

   public int func_82591_c() {
      return this.field_72350_c.size();
   }

   public int func_82590_d() {
      return this.field_72347_d;
   }

   private boolean func_82589_e() {
      return this.field_72349_b < 0 || this.field_72351_a < 0;
   }
}
