package net.minecraft.client.renderer.culling;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClippingHelper {

   public float[][] field_78557_a = new float[16][16];
   public float[] field_78555_b = new float[16];
   public float[] field_78556_c = new float[16];
   public float[] field_78554_d = new float[16];


   public boolean func_78553_b(double p_78553_1_, double p_78553_3_, double p_78553_5_, double p_78553_7_, double p_78553_9_, double p_78553_11_) {
      for(int var13 = 0; var13 < 6; ++var13) {
         if((double)this.field_78557_a[var13][0] * p_78553_1_ + (double)this.field_78557_a[var13][1] * p_78553_3_ + (double)this.field_78557_a[var13][2] * p_78553_5_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_7_ + (double)this.field_78557_a[var13][1] * p_78553_3_ + (double)this.field_78557_a[var13][2] * p_78553_5_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_1_ + (double)this.field_78557_a[var13][1] * p_78553_9_ + (double)this.field_78557_a[var13][2] * p_78553_5_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_7_ + (double)this.field_78557_a[var13][1] * p_78553_9_ + (double)this.field_78557_a[var13][2] * p_78553_5_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_1_ + (double)this.field_78557_a[var13][1] * p_78553_3_ + (double)this.field_78557_a[var13][2] * p_78553_11_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_7_ + (double)this.field_78557_a[var13][1] * p_78553_3_ + (double)this.field_78557_a[var13][2] * p_78553_11_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_1_ + (double)this.field_78557_a[var13][1] * p_78553_9_ + (double)this.field_78557_a[var13][2] * p_78553_11_ + (double)this.field_78557_a[var13][3] <= 0.0D && (double)this.field_78557_a[var13][0] * p_78553_7_ + (double)this.field_78557_a[var13][1] * p_78553_9_ + (double)this.field_78557_a[var13][2] * p_78553_11_ + (double)this.field_78557_a[var13][3] <= 0.0D) {
            return false;
         }
      }

      return true;
   }
}
