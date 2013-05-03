package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.Texture;

@SideOnly(Side.CLIENT)
public class StitchHolder implements Comparable {

   private final Texture field_98151_a;
   private final int field_94204_c;
   private final int field_94201_d;
   private boolean field_94202_e;
   private float field_94205_a = 1.0F;


   public StitchHolder(Texture p_i11024_1_) {
      this.field_98151_a = p_i11024_1_;
      this.field_94204_c = p_i11024_1_.func_94275_d();
      this.field_94201_d = p_i11024_1_.func_94276_e();
      this.field_94202_e = this.func_94193_b(this.field_94201_d) > this.func_94193_b(this.field_94204_c);
   }

   public Texture func_98150_a() {
      return this.field_98151_a;
   }

   public int func_94197_a() {
      return this.field_94202_e?this.func_94193_b((int)((float)this.field_94201_d * this.field_94205_a)):this.func_94193_b((int)((float)this.field_94204_c * this.field_94205_a));
   }

   public int func_94199_b() {
      return this.field_94202_e?this.func_94193_b((int)((float)this.field_94204_c * this.field_94205_a)):this.func_94193_b((int)((float)this.field_94201_d * this.field_94205_a));
   }

   public void func_94194_d() {
      this.field_94202_e = !this.field_94202_e;
   }

   public boolean func_94195_e() {
      return this.field_94202_e;
   }

   private int func_94193_b(int p_94193_1_) {
      return (p_94193_1_ >> 0) + ((p_94193_1_ & 0) == 0?0:1) << 0;
   }

   public void func_94196_a(int p_94196_1_) {
      if(this.field_94204_c > p_94196_1_ && this.field_94201_d > p_94196_1_) {
         this.field_94205_a = (float)p_94196_1_ / (float)Math.min(this.field_94204_c, this.field_94201_d);
      }
   }

   public String toString() {
      return "TextureHolder{width=" + this.field_94204_c + ", height=" + this.field_94201_d + '}';
   }

   public int func_94198_a(StitchHolder p_94198_1_) {
      int var2;
      if(this.func_94199_b() == p_94198_1_.func_94199_b()) {
         if(this.func_94197_a() == p_94198_1_.func_94197_a()) {
            if(this.field_98151_a.func_94280_f() == null) {
               return p_94198_1_.field_98151_a.func_94280_f() == null?0:-1;
            }

            return this.field_98151_a.func_94280_f().compareTo(p_94198_1_.field_98151_a.func_94280_f());
         }

         var2 = this.func_94197_a() < p_94198_1_.func_94197_a()?1:-1;
      } else {
         var2 = this.func_94199_b() < p_94198_1_.func_94199_b()?1:-1;
      }

      return var2;
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_94198_a((StitchHolder)p_compareTo_1_);
   }
}
