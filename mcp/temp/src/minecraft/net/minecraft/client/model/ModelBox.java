package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;

@SideOnly(Side.CLIENT)
public class ModelBox {

   private PositionTextureVertex[] field_78253_h;
   private TexturedQuad[] field_78254_i;
   public final float field_78252_a;
   public final float field_78250_b;
   public final float field_78251_c;
   public final float field_78248_d;
   public final float field_78249_e;
   public final float field_78246_f;
   public String field_78247_g;


   public ModelBox(ModelRenderer p_i3145_1_, int p_i3145_2_, int p_i3145_3_, float p_i3145_4_, float p_i3145_5_, float p_i3145_6_, int p_i3145_7_, int p_i3145_8_, int p_i3145_9_, float p_i3145_10_) {
      this.field_78252_a = p_i3145_4_;
      this.field_78250_b = p_i3145_5_;
      this.field_78251_c = p_i3145_6_;
      this.field_78248_d = p_i3145_4_ + (float)p_i3145_7_;
      this.field_78249_e = p_i3145_5_ + (float)p_i3145_8_;
      this.field_78246_f = p_i3145_6_ + (float)p_i3145_9_;
      this.field_78253_h = new PositionTextureVertex[8];
      this.field_78254_i = new TexturedQuad[6];
      float var11 = p_i3145_4_ + (float)p_i3145_7_;
      float var12 = p_i3145_5_ + (float)p_i3145_8_;
      float var13 = p_i3145_6_ + (float)p_i3145_9_;
      p_i3145_4_ -= p_i3145_10_;
      p_i3145_5_ -= p_i3145_10_;
      p_i3145_6_ -= p_i3145_10_;
      var11 += p_i3145_10_;
      var12 += p_i3145_10_;
      var13 += p_i3145_10_;
      if(p_i3145_1_.field_78809_i) {
         float var14 = var11;
         var11 = p_i3145_4_;
         p_i3145_4_ = var14;
      }

      PositionTextureVertex var23 = new PositionTextureVertex(p_i3145_4_, p_i3145_5_, p_i3145_6_, 0.0F, 0.0F);
      PositionTextureVertex var15 = new PositionTextureVertex(var11, p_i3145_5_, p_i3145_6_, 0.0F, 8.0F);
      PositionTextureVertex var16 = new PositionTextureVertex(var11, var12, p_i3145_6_, 8.0F, 8.0F);
      PositionTextureVertex var17 = new PositionTextureVertex(p_i3145_4_, var12, p_i3145_6_, 8.0F, 0.0F);
      PositionTextureVertex var18 = new PositionTextureVertex(p_i3145_4_, p_i3145_5_, var13, 0.0F, 0.0F);
      PositionTextureVertex var19 = new PositionTextureVertex(var11, p_i3145_5_, var13, 0.0F, 8.0F);
      PositionTextureVertex var20 = new PositionTextureVertex(var11, var12, var13, 8.0F, 8.0F);
      PositionTextureVertex var21 = new PositionTextureVertex(p_i3145_4_, var12, var13, 8.0F, 0.0F);
      this.field_78253_h[0] = var23;
      this.field_78253_h[1] = var15;
      this.field_78253_h[2] = var16;
      this.field_78253_h[3] = var17;
      this.field_78253_h[4] = var18;
      this.field_78253_h[5] = var19;
      this.field_78253_h[6] = var20;
      this.field_78253_h[7] = var21;
      this.field_78254_i[0] = new TexturedQuad(new PositionTextureVertex[]{var19, var15, var16, var20}, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      this.field_78254_i[1] = new TexturedQuad(new PositionTextureVertex[]{var23, var18, var21, var17}, p_i3145_2_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      this.field_78254_i[2] = new TexturedQuad(new PositionTextureVertex[]{var19, var18, var23, var15}, p_i3145_2_ + p_i3145_9_, p_i3145_3_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      this.field_78254_i[3] = new TexturedQuad(new PositionTextureVertex[]{var16, var17, var21, var20}, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_7_, p_i3145_3_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      this.field_78254_i[4] = new TexturedQuad(new PositionTextureVertex[]{var15, var23, var17, var16}, p_i3145_2_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      this.field_78254_i[5] = new TexturedQuad(new PositionTextureVertex[]{var18, var19, var20, var21}, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_, p_i3145_3_ + p_i3145_9_, p_i3145_2_ + p_i3145_9_ + p_i3145_7_ + p_i3145_9_ + p_i3145_7_, p_i3145_3_ + p_i3145_9_ + p_i3145_8_, p_i3145_1_.field_78801_a, p_i3145_1_.field_78799_b);
      if(p_i3145_1_.field_78809_i) {
         for(int var22 = 0; var22 < this.field_78254_i.length; ++var22) {
            this.field_78254_i[var22].func_78235_a();
         }
      }

   }

   public void func_78245_a(Tessellator p_78245_1_, float p_78245_2_) {
      for(int var3 = 0; var3 < this.field_78254_i.length; ++var3) {
         this.field_78254_i[var3].func_78236_a(p_78245_1_, p_78245_2_);
      }

   }

   public ModelBox func_78244_a(String p_78244_1_) {
      this.field_78247_g = p_78244_1_;
      return this;
   }
}
