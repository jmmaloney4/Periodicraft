package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;

@SideOnly(Side.CLIENT)
public class TexturedQuad {

   public PositionTextureVertex[] field_78239_a;
   public int field_78237_b;
   private boolean field_78238_c;


   public TexturedQuad(PositionTextureVertex[] p_i3136_1_) {
      this.field_78237_b = 0;
      this.field_78238_c = false;
      this.field_78239_a = p_i3136_1_;
      this.field_78237_b = p_i3136_1_.length;
   }

   public TexturedQuad(PositionTextureVertex[] p_i3137_1_, int p_i3137_2_, int p_i3137_3_, int p_i3137_4_, int p_i3137_5_, float p_i3137_6_, float p_i3137_7_) {
      this(p_i3137_1_);
      float var8 = 0.0F / p_i3137_6_;
      float var9 = 0.0F / p_i3137_7_;
      p_i3137_1_[0] = p_i3137_1_[0].func_78240_a((float)p_i3137_4_ / p_i3137_6_ - var8, (float)p_i3137_3_ / p_i3137_7_ + var9);
      p_i3137_1_[1] = p_i3137_1_[1].func_78240_a((float)p_i3137_2_ / p_i3137_6_ + var8, (float)p_i3137_3_ / p_i3137_7_ + var9);
      p_i3137_1_[2] = p_i3137_1_[2].func_78240_a((float)p_i3137_2_ / p_i3137_6_ + var8, (float)p_i3137_5_ / p_i3137_7_ - var9);
      p_i3137_1_[3] = p_i3137_1_[3].func_78240_a((float)p_i3137_4_ / p_i3137_6_ - var8, (float)p_i3137_5_ / p_i3137_7_ - var9);
   }

   public void func_78235_a() {
      PositionTextureVertex[] var1 = new PositionTextureVertex[this.field_78239_a.length];

      for(int var2 = 0; var2 < this.field_78239_a.length; ++var2) {
         var1[var2] = this.field_78239_a[this.field_78239_a.length - var2 - 1];
      }

      this.field_78239_a = var1;
   }

   public void func_78236_a(Tessellator p_78236_1_, float p_78236_2_) {
      Vec3 var3 = this.field_78239_a[1].field_78243_a.func_72444_a(this.field_78239_a[0].field_78243_a);
      Vec3 var4 = this.field_78239_a[1].field_78243_a.func_72444_a(this.field_78239_a[2].field_78243_a);
      Vec3 var5 = var4.func_72431_c(var3).func_72432_b();
      p_78236_1_.func_78382_b();
      if(this.field_78238_c) {
         p_78236_1_.func_78375_b(-((float)var5.field_72450_a), -((float)var5.field_72448_b), -((float)var5.field_72449_c));
      } else {
         p_78236_1_.func_78375_b((float)var5.field_72450_a, (float)var5.field_72448_b, (float)var5.field_72449_c);
      }

      for(int var6 = 0; var6 < 4; ++var6) {
         PositionTextureVertex var7 = this.field_78239_a[var6];
         p_78236_1_.func_78374_a((double)((float)var7.field_78243_a.field_72450_a * p_78236_2_), (double)((float)var7.field_78243_a.field_72448_b * p_78236_2_), (double)((float)var7.field_78243_a.field_72449_c * p_78236_2_), (double)var7.field_78241_b, (double)var7.field_78242_c);
      }

      p_78236_1_.func_78381_a();
   }
}
