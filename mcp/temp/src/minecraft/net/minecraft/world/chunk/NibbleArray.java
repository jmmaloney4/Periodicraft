package net.minecraft.world.chunk;


public class NibbleArray {

   public final byte[] field_76585_a;
   private final int field_76583_b;
   private final int field_76584_c;


   public NibbleArray(int p_i3768_1_, int p_i3768_2_) {
      this.field_76585_a = new byte[p_i3768_1_ >> 1];
      this.field_76583_b = p_i3768_2_;
      this.field_76584_c = p_i3768_2_ + 4;
   }

   public NibbleArray(byte[] p_i3769_1_, int p_i3769_2_) {
      this.field_76585_a = p_i3769_1_;
      this.field_76583_b = p_i3769_2_;
      this.field_76584_c = p_i3769_2_ + 4;
   }

   public int func_76582_a(int p_76582_1_, int p_76582_2_, int p_76582_3_) {
      int var4 = p_76582_2_ << this.field_76584_c | p_76582_3_ << this.field_76583_b | p_76582_1_;
      int var5 = var4 >> 1;
      int var6 = var4 & 1;
      return var6 == 0?this.field_76585_a[var5] & 15:this.field_76585_a[var5] >> 4 & 15;
   }

   public void func_76581_a(int p_76581_1_, int p_76581_2_, int p_76581_3_, int p_76581_4_) {
      int var5 = p_76581_2_ << this.field_76584_c | p_76581_3_ << this.field_76583_b | p_76581_1_;
      int var6 = var5 >> 1;
      int var7 = var5 & 1;
      if(var7 == 0) {
         this.field_76585_a[var6] = (byte)(this.field_76585_a[var6] & 240 | p_76581_4_ & 15);
      } else {
         this.field_76585_a[var6] = (byte)(this.field_76585_a[var6] & 15 | (p_76581_4_ & 15) << 4);
      }

   }
}
