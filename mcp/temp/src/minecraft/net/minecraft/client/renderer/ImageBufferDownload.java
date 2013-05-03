package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import net.minecraft.client.renderer.IImageBuffer;

@SideOnly(Side.CLIENT)
public class ImageBufferDownload implements IImageBuffer {

   private int[] field_78438_a;
   private int field_78436_b;
   private int field_78437_c;


   public BufferedImage func_78432_a(BufferedImage p_78432_1_) {
      if(p_78432_1_ == null) {
         return null;
      } else {
         this.field_78436_b = 64;
         this.field_78437_c = 32;
         BufferedImage var2 = new BufferedImage(this.field_78436_b, this.field_78437_c, 2);
         Graphics var3 = var2.getGraphics();
         var3.drawImage(p_78432_1_, 0, 0, (ImageObserver)null);
         var3.dispose();
         this.field_78438_a = ((DataBufferInt)var2.getRaster().getDataBuffer()).getData();
         this.func_78433_b(0, 0, 32, 16);
         this.func_78434_a(32, 0, 64, 32);
         this.func_78433_b(0, 16, 64, 32);
         boolean var4 = false;

         int var5;
         int var6;
         int var7;
         for(var5 = 32; var5 < 64; ++var5) {
            for(var6 = 0; var6 < 16; ++var6) {
               var7 = this.field_78438_a[var5 + var6 * 64];
               if((var7 >> 24 & 255) < 128) {
                  var4 = true;
               }
            }
         }

         if(!var4) {
            for(var5 = 32; var5 < 64; ++var5) {
               for(var6 = 0; var6 < 16; ++var6) {
                  var7 = this.field_78438_a[var5 + var6 * 64];
                  if((var7 >> 24 & 255) < 128) {
                     var4 = true;
                  }
               }
            }
         }

         return var2;
      }
   }

   private void func_78434_a(int p_78434_1_, int p_78434_2_, int p_78434_3_, int p_78434_4_) {
      if(!this.func_78435_c(p_78434_1_, p_78434_2_, p_78434_3_, p_78434_4_)) {
         for(int var5 = p_78434_1_; var5 < p_78434_3_; ++var5) {
            for(int var6 = p_78434_2_; var6 < p_78434_4_; ++var6) {
               this.field_78438_a[var5 + var6 * this.field_78436_b] &= 16777215;
            }
         }

      }
   }

   private void func_78433_b(int p_78433_1_, int p_78433_2_, int p_78433_3_, int p_78433_4_) {
      for(int var5 = p_78433_1_; var5 < p_78433_3_; ++var5) {
         for(int var6 = p_78433_2_; var6 < p_78433_4_; ++var6) {
            this.field_78438_a[var5 + var6 * this.field_78436_b] |= -16777216;
         }
      }

   }

   private boolean func_78435_c(int p_78435_1_, int p_78435_2_, int p_78435_3_, int p_78435_4_) {
      for(int var5 = p_78435_1_; var5 < p_78435_3_; ++var5) {
         for(int var6 = p_78435_2_; var6 < p_78435_4_; ++var6) {
            int var7 = this.field_78438_a[var5 + var6 * this.field_78436_b];
            if((var7 >> 24 & 255) < 128) {
               return true;
            }
         }
      }

      return false;
   }
}
