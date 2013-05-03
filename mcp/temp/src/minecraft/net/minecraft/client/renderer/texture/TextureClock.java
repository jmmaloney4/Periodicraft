package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureStitched;

@SideOnly(Side.CLIENT)
public class TextureClock extends TextureStitched {

   private double field_94239_h;
   private double field_94240_i;


   public TextureClock() {
      super("compass");
   }

   public void func_94219_l() {
      Minecraft var1 = Minecraft.func_71410_x();
      double var2 = 0.0D;
      if(var1.field_71441_e != null && var1.field_71439_g != null) {
         float var4 = var1.field_71441_e.func_72826_c(1.0F);
         var2 = (double)var4;
         if(!var1.field_71441_e.field_73011_w.func_76569_d()) {
            var2 = Math.random();
         }
      }

      double var7;
      for(var7 = var2 - this.field_94239_h; var7 < -0.5D; ++var7) {
         ;
      }

      while(var7 >= 0.5D) {
         --var7;
      }

      if(var7 < -1.0D) {
         var7 = -1.0D;
      }

      if(var7 > 1.0D) {
         var7 = 1.0D;
      }

      this.field_94240_i += var7 * 0.1D;
      this.field_94240_i *= 0.8D;
      this.field_94239_h += this.field_94240_i;

      int var6;
      for(var6 = (int)((this.field_94239_h + 1.0D) * (double)this.field_94226_b.size()) % this.field_94226_b.size(); var6 < 0; var6 = (var6 + this.field_94226_b.size()) % this.field_94226_b.size()) {
         ;
      }

      if(var6 != this.field_94222_f) {
         this.field_94222_f = var6;
         this.field_94228_a.func_94281_a(this.field_94224_d, this.field_94225_e, (Texture)this.field_94226_b.get(this.field_94222_f), this.field_94227_c);
      }

   }
}
