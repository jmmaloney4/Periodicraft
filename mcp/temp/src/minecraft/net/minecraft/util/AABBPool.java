package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.AxisAlignedBB;

public class AABBPool {

   private final int field_72306_a;
   private final int field_72304_b;
   private final List field_72305_c = new ArrayList();
   private int field_72302_d = 0;
   private int field_72303_e = 0;
   private int field_72301_f = 0;


   public AABBPool(int p_i4030_1_, int p_i4030_2_) {
      this.field_72306_a = p_i4030_1_;
      this.field_72304_b = p_i4030_2_;
   }

   public AxisAlignedBB func_72299_a(double p_72299_1_, double p_72299_3_, double p_72299_5_, double p_72299_7_, double p_72299_9_, double p_72299_11_) {
      AxisAlignedBB var13;
      if(this.field_72302_d >= this.field_72305_c.size()) {
         var13 = new AxisAlignedBB(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
         this.field_72305_c.add(var13);
      } else {
         var13 = (AxisAlignedBB)this.field_72305_c.get(this.field_72302_d);
         var13.func_72324_b(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
      }

      ++this.field_72302_d;
      return var13;
   }

   public void func_72298_a() {
      if(this.field_72302_d > this.field_72303_e) {
         this.field_72303_e = this.field_72302_d;
      }

      if(this.field_72301_f++ == this.field_72306_a) {
         int var1 = Math.max(this.field_72303_e, this.field_72305_c.size() - this.field_72304_b);

         while(this.field_72305_c.size() > var1) {
            this.field_72305_c.remove(var1);
         }

         this.field_72303_e = 0;
         this.field_72301_f = 0;
      }

      this.field_72302_d = 0;
   }

   @SideOnly(Side.CLIENT)
   public void func_72300_b() {
      this.field_72302_d = 0;
      this.field_72305_c.clear();
   }

   public int func_83013_c() {
      return this.field_72305_c.size();
   }

   public int func_83012_d() {
      return this.field_72302_d;
   }
}
