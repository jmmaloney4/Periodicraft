package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.Rect2i;
import net.minecraft.client.renderer.texture.TextureManager;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class Texture {

   private int field_94293_a;
   private int field_94291_b;
   private int field_94292_c;
   private final int field_94289_d;
   private final int field_94290_e;
   private final int field_94287_f;
   private final int field_94288_g;
   private final int field_94300_h;
   private final int field_94301_i;
   private final int field_94298_j;
   private final int field_94299_k;
   private final boolean field_94296_l;
   private final String field_94297_m;
   private Rect2i field_94294_n;
   private boolean field_94295_o;
   private boolean field_94304_p;
   private boolean field_94303_q;
   private ByteBuffer field_94302_r;


   private Texture(String p_i11021_1_, int p_i11021_2_, int p_i11021_3_, int p_i11021_4_, int p_i11021_5_, int p_i11021_6_, int p_i11021_7_, int p_i11021_8_, int p_i11021_9_) {
      this.field_94297_m = p_i11021_1_;
      this.field_94292_c = p_i11021_2_;
      this.field_94289_d = p_i11021_3_;
      this.field_94290_e = p_i11021_4_;
      this.field_94287_f = p_i11021_5_;
      this.field_94288_g = p_i11021_7_;
      this.field_94301_i = p_i11021_8_;
      this.field_94298_j = p_i11021_9_;
      this.field_94299_k = p_i11021_6_;
      this.field_94294_n = new Rect2i(0, 0, p_i11021_3_, p_i11021_4_);
      if(p_i11021_4_ == 1 && p_i11021_5_ == 1) {
         this.field_94300_h = 3552;
      } else if(p_i11021_5_ == 1) {
         this.field_94300_h = 3553;
      } else {
         this.field_94300_h = '\u806f';
      }

      this.field_94296_l = p_i11021_8_ != 9728 && p_i11021_8_ != 9729 || p_i11021_9_ != 9728 && p_i11021_9_ != 9729;
      if(p_i11021_2_ != 2) {
         this.field_94293_a = GL11.glGenTextures();
         GL11.glBindTexture(this.field_94300_h, this.field_94293_a);
         GL11.glTexParameteri(this.field_94300_h, 10241, p_i11021_8_);
         GL11.glTexParameteri(this.field_94300_h, 10240, p_i11021_9_);
         GL11.glTexParameteri(this.field_94300_h, 10242, p_i11021_6_);
         GL11.glTexParameteri(this.field_94300_h, 10243, p_i11021_6_);
      } else {
         this.field_94293_a = -1;
      }

      this.field_94291_b = TextureManager.func_94267_b().func_94265_c();
   }

   public Texture(String p_i11022_1_, int p_i11022_2_, int p_i11022_3_, int p_i11022_4_, int p_i11022_5_, int p_i11022_6_, int p_i11022_7_, int p_i11022_8_, BufferedImage p_i11022_9_) {
      this(p_i11022_1_, p_i11022_2_, p_i11022_3_, p_i11022_4_, 1, p_i11022_5_, p_i11022_6_, p_i11022_7_, p_i11022_8_, p_i11022_9_);
   }

   public Texture(String p_i11023_1_, int p_i11023_2_, int p_i11023_3_, int p_i11023_4_, int p_i11023_5_, int p_i11023_6_, int p_i11023_7_, int p_i11023_8_, int p_i11023_9_, BufferedImage p_i11023_10_) {
      this(p_i11023_1_, p_i11023_2_, p_i11023_3_, p_i11023_4_, p_i11023_5_, p_i11023_6_, p_i11023_7_, p_i11023_8_, p_i11023_9_);
      if(p_i11023_10_ == null) {
         if(p_i11023_3_ != -1 && p_i11023_4_ != -1) {
            byte[] var11 = new byte[p_i11023_3_ * p_i11023_4_ * p_i11023_5_ * 4];

            for(int var12 = 0; var12 < var11.length; ++var12) {
               var11[var12] = 0;
            }

            this.field_94302_r = ByteBuffer.allocateDirect(var11.length);
            this.field_94302_r.clear();
            this.field_94302_r.put(var11);
            this.field_94302_r.position(0).limit(var11.length);
            if(this.field_94304_p) {
               this.func_94285_g();
            } else {
               this.field_94303_q = false;
            }
         } else {
            this.field_94295_o = false;
         }
      } else {
         this.field_94295_o = true;
         this.func_94278_a(p_i11023_10_);
         if(p_i11023_2_ != 2) {
            this.func_94285_g();
            this.field_94304_p = false;
         }
      }

   }

   public final Rect2i func_94274_a() {
      return this.field_94294_n;
   }

   public void func_94272_a(Rect2i p_94272_1_, int p_94272_2_) {
      if(this.field_94300_h != '\u806f') {
         Rect2i var3 = new Rect2i(0, 0, this.field_94289_d, this.field_94290_e);
         var3.func_94156_a(p_94272_1_);
         this.field_94302_r.position(0);

         for(int var4 = var3.func_94160_b(); var4 < var3.func_94160_b() + var3.func_94157_d(); ++var4) {
            int var5 = var4 * this.field_94289_d * 4;

            for(int var6 = var3.func_94158_a(); var6 < var3.func_94158_a() + var3.func_94159_c(); ++var6) {
               this.field_94302_r.put(var5 + var6 * 4 + 0, (byte)(p_94272_2_ >> 24 & 255));
               this.field_94302_r.put(var5 + var6 * 4 + 1, (byte)(p_94272_2_ >> 16 & 255));
               this.field_94302_r.put(var5 + var6 * 4 + 2, (byte)(p_94272_2_ >> 8 & 255));
               this.field_94302_r.put(var5 + var6 * 4 + 3, (byte)(p_94272_2_ >> 0 & 255));
            }
         }

         if(this.field_94304_p) {
            this.func_94285_g();
         } else {
            this.field_94303_q = false;
         }

      }
   }

   public void func_94279_c(String p_94279_1_) {
      BufferedImage var2 = new BufferedImage(this.field_94289_d, this.field_94290_e, 2);
      ByteBuffer var3 = this.func_94273_h();
      byte[] var4 = new byte[this.field_94289_d * this.field_94290_e * 4];
      var3.position(0);
      var3.get(var4);

      for(int var5 = 0; var5 < this.field_94289_d; ++var5) {
         for(int var6 = 0; var6 < this.field_94290_e; ++var6) {
            int var7 = var6 * this.field_94289_d * 4 + var5 * 4;
            byte var8 = 0;
            int var10 = var8 | (var4[var7 + 2] & 255) << 0;
            var10 |= (var4[var7 + 1] & 255) << 8;
            var10 |= (var4[var7 + 0] & 255) << 16;
            var10 |= (var4[var7 + 3] & 255) << 24;
            var2.setRGB(var5, var6, var10);
         }
      }

      this.field_94302_r.position(this.field_94289_d * this.field_94290_e * 4);

      try {
         ImageIO.write(var2, "png", new File(Minecraft.func_71380_b(), p_94279_1_));
      } catch (IOException var9) {
         var9.printStackTrace();
      }

   }

   public void func_94281_a(int p_94281_1_, int p_94281_2_, Texture p_94281_3_, boolean p_94281_4_) {
      if(this.field_94300_h != '\u806f') {
         ByteBuffer var5 = p_94281_3_.func_94273_h();
         this.field_94302_r.position(0);
         var5.position(0);

         for(int var6 = 0; var6 < p_94281_3_.func_94276_e(); ++var6) {
            int var7 = p_94281_2_ + var6;
            int var8 = var6 * p_94281_3_.func_94275_d() * 4;
            int var9 = var7 * this.field_94289_d * 4;
            if(p_94281_4_) {
               var7 = p_94281_2_ + (p_94281_3_.func_94276_e() - var6);
            }

            for(int var10 = 0; var10 < p_94281_3_.func_94275_d(); ++var10) {
               int var11 = var9 + (var10 + p_94281_1_) * 4;
               int var12 = var8 + var10 * 4;
               if(p_94281_4_) {
                  var11 = p_94281_1_ + var10 * this.field_94289_d * 4 + var7 * 4;
               }

               this.field_94302_r.put(var11 + 0, var5.get(var12 + 0));
               this.field_94302_r.put(var11 + 1, var5.get(var12 + 1));
               this.field_94302_r.put(var11 + 2, var5.get(var12 + 2));
               this.field_94302_r.put(var11 + 3, var5.get(var12 + 3));
            }
         }

         this.field_94302_r.position(this.field_94289_d * this.field_94290_e * 4);
         if(this.field_94304_p) {
            this.func_94285_g();
         } else {
            this.field_94303_q = false;
         }

      }
   }

   public void func_94278_a(BufferedImage p_94278_1_) {
      if(this.field_94300_h != '\u806f') {
         int var2 = p_94278_1_.getWidth();
         int var3 = p_94278_1_.getHeight();
         if(var2 <= this.field_94289_d && var3 <= this.field_94290_e) {
            int[] var4 = new int[]{3, 0, 1, 2};
            int[] var5 = new int[]{3, 2, 1, 0};
            int[] var6 = this.field_94288_g == '\u80e1'?var5:var4;
            int[] var7 = new int[this.field_94289_d * this.field_94290_e];
            int var8 = p_94278_1_.getTransparency();
            p_94278_1_.getRGB(0, 0, this.field_94289_d, this.field_94290_e, var7, 0, var2);
            byte[] var9 = new byte[this.field_94289_d * this.field_94290_e * 4];

            for(int var10 = 0; var10 < this.field_94290_e; ++var10) {
               for(int var11 = 0; var11 < this.field_94289_d; ++var11) {
                  int var12 = var10 * this.field_94289_d + var11;
                  int var13 = var12 * 4;
                  var9[var13 + var6[0]] = (byte)(var7[var12] >> 24 & 255);
                  var9[var13 + var6[1]] = (byte)(var7[var12] >> 16 & 255);
                  var9[var13 + var6[2]] = (byte)(var7[var12] >> 8 & 255);
                  var9[var13 + var6[3]] = (byte)(var7[var12] >> 0 & 255);
               }
            }

            this.field_94302_r = ByteBuffer.allocateDirect(var9.length);
            this.field_94302_r.clear();
            this.field_94302_r.put(var9);
            this.field_94302_r.limit(var9.length);
            if(this.field_94304_p) {
               this.func_94285_g();
            } else {
               this.field_94303_q = false;
            }

         } else {
            Minecraft.func_71410_x().func_98033_al().func_98236_b("transferFromImage called with a BufferedImage with dimensions (" + var2 + ", " + var3 + ") larger than the Texture dimensions (" + this.field_94289_d + ", " + this.field_94290_e + "). Ignoring.");
         }
      }
   }

   public int func_94284_b() {
      return this.field_94291_b;
   }

   public int func_94282_c() {
      return this.field_94293_a;
   }

   public int func_94275_d() {
      return this.field_94289_d;
   }

   public int func_94276_e() {
      return this.field_94290_e;
   }

   public String func_94280_f() {
      return this.field_94297_m;
   }

   public void func_94277_a(int p_94277_1_) {
      if(this.field_94287_f == 1) {
         GL11.glEnable(3553);
      } else {
         GL11.glEnable('\u806f');
      }

      OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a + p_94277_1_);
      GL11.glBindTexture(this.field_94300_h, this.field_94293_a);
      if(!this.field_94303_q) {
         this.func_94285_g();
      }

   }

   public void func_94285_g() {
      this.field_94302_r.flip();
      if(this.field_94290_e != 1 && this.field_94287_f != 1) {
         GL12.glTexImage3D(this.field_94300_h, 0, this.field_94288_g, this.field_94289_d, this.field_94290_e, this.field_94287_f, 0, this.field_94288_g, 5121, this.field_94302_r);
      } else if(this.field_94290_e != 1) {
         GL11.glTexImage2D(this.field_94300_h, 0, this.field_94288_g, this.field_94289_d, this.field_94290_e, 0, this.field_94288_g, 5121, this.field_94302_r);
      } else {
         GL11.glTexImage1D(this.field_94300_h, 0, this.field_94288_g, this.field_94289_d, 0, this.field_94288_g, 5121, this.field_94302_r);
      }

      this.field_94303_q = true;
   }

   public ByteBuffer func_94273_h() {
      return this.field_94302_r;
   }
}
