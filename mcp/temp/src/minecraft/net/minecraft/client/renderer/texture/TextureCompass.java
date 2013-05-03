package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureStitched;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class TextureCompass extends TextureStitched {

   public static TextureCompass field_94243_h;
   public double field_94244_i;
   public double field_94242_j;


   public TextureCompass() {
      super("compass");
      field_94243_h = this;
   }

   public void func_94219_l() {
      Minecraft var1 = Minecraft.func_71410_x();
      if(var1.field_71441_e != null && var1.field_71439_g != null) {
         this.func_94241_a(var1.field_71441_e, var1.field_71439_g.field_70165_t, var1.field_71439_g.field_70161_v, (double)var1.field_71439_g.field_70177_z, false, false);
      } else {
         this.func_94241_a((World)null, 0.0D, 0.0D, 0.0D, true, false);
      }

   }

   public void func_94241_a(World p_94241_1_, double p_94241_2_, double p_94241_4_, double p_94241_6_, boolean p_94241_8_, boolean p_94241_9_) {
      double var10 = 0.0D;
      if(p_94241_1_ != null && !p_94241_8_) {
         ChunkCoordinates var12 = p_94241_1_.func_72861_E();
         double var13 = (double)var12.field_71574_a - p_94241_2_;
         double var15 = (double)var12.field_71573_c - p_94241_4_;
         p_94241_6_ %= 360.0D;
         var10 = -((p_94241_6_ - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var15, var13));
         if(!p_94241_1_.field_73011_w.func_76569_d()) {
            var10 = Math.random() * 3.1415927410125732D * 2.0D;
         }
      }

      if(p_94241_9_) {
         this.field_94244_i = var10;
      } else {
         double var17;
         for(var17 = var10 - this.field_94244_i; var17 < -3.141592653589793D; var17 += 6.283185307179586D) {
            ;
         }

         while(var17 >= 3.141592653589793D) {
            var17 -= 6.283185307179586D;
         }

         if(var17 < -1.0D) {
            var17 = -1.0D;
         }

         if(var17 > 1.0D) {
            var17 = 1.0D;
         }

         this.field_94242_j += var17 * 0.1D;
         this.field_94242_j *= 0.8D;
         this.field_94244_i += this.field_94242_j;
      }

      int var18;
      for(var18 = (int)((this.field_94244_i / 6.283185307179586D + 1.0D) * (double)this.field_94226_b.size()) % this.field_94226_b.size(); var18 < 0; var18 = (var18 + this.field_94226_b.size()) % this.field_94226_b.size()) {
         ;
      }

      if(var18 != this.field_94222_f) {
         this.field_94222_f = var18;
         this.field_94228_a.func_94281_a(this.field_94224_d, this.field_94225_e, (Texture)this.field_94226_b.get(this.field_94222_f), this.field_94227_c);
      }

   }
}
