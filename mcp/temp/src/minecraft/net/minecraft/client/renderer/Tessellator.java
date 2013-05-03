package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

@SideOnly(Side.CLIENT)
public class Tessellator {

   private static boolean field_78396_b = false;
   private static boolean field_78397_c = false;
   private ByteBuffer field_78394_d;
   private IntBuffer field_78395_e;
   private FloatBuffer field_78392_f;
   private ShortBuffer field_78393_g;
   private int[] field_78405_h;
   private int field_78406_i = 0;
   private double field_78403_j;
   private double field_78404_k;
   private int field_78401_l;
   private int field_78402_m;
   private boolean field_78399_n = false;
   private boolean field_78400_o = false;
   private boolean field_78414_p = false;
   private boolean field_78413_q = false;
   private int field_78412_r = 0;
   private int field_78411_s = 0;
   private boolean field_78410_t = false;
   public int field_78409_u;
   public double field_78408_v;
   public double field_78407_w;
   public double field_78417_x;
   private int field_78416_y;
   public static Tessellator field_78398_a = new Tessellator(2097152);
   public boolean field_78415_z = false;
   private boolean field_78389_A = false;
   private IntBuffer field_78390_B;
   private int field_78391_C = 0;
   private int field_78387_D = 10;
   private int field_78388_E;


   private Tessellator(int p_i3191_1_) {
      this.field_78388_E = p_i3191_1_;
      this.field_78394_d = GLAllocation.func_74524_c(p_i3191_1_ * 4);
      this.field_78395_e = this.field_78394_d.asIntBuffer();
      this.field_78392_f = this.field_78394_d.asFloatBuffer();
      this.field_78393_g = this.field_78394_d.asShortBuffer();
      this.field_78405_h = new int[p_i3191_1_];
      this.field_78389_A = field_78397_c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
      if(this.field_78389_A) {
         this.field_78390_B = GLAllocation.func_74527_f(this.field_78387_D);
         ARBVertexBufferObject.glGenBuffersARB(this.field_78390_B);
      }

   }

   public int func_78381_a() {
      if(!this.field_78415_z) {
         throw new IllegalStateException("Not tesselating!");
      } else {
         this.field_78415_z = false;
         if(this.field_78406_i > 0) {
            this.field_78395_e.clear();
            this.field_78395_e.put(this.field_78405_h, 0, this.field_78412_r);
            this.field_78394_d.position(0);
            this.field_78394_d.limit(this.field_78412_r * 4);
            if(this.field_78389_A) {
               this.field_78391_C = (this.field_78391_C + 1) % this.field_78387_D;
               ARBVertexBufferObject.glBindBufferARB('\u8892', this.field_78390_B.get(this.field_78391_C));
               ARBVertexBufferObject.glBufferDataARB('\u8892', this.field_78394_d, '\u88e0');
            }

            if(this.field_78400_o) {
               if(this.field_78389_A) {
                  GL11.glTexCoordPointer(2, 5126, 32, 12L);
               } else {
                  this.field_78392_f.position(3);
                  GL11.glTexCoordPointer(2, 32, this.field_78392_f);
               }

               GL11.glEnableClientState('\u8078');
            }

            if(this.field_78414_p) {
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
               if(this.field_78389_A) {
                  GL11.glTexCoordPointer(2, 5122, 32, 28L);
               } else {
                  this.field_78393_g.position(14);
                  GL11.glTexCoordPointer(2, 32, this.field_78393_g);
               }

               GL11.glEnableClientState('\u8078');
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }

            if(this.field_78399_n) {
               if(this.field_78389_A) {
                  GL11.glColorPointer(4, 5121, 32, 20L);
               } else {
                  this.field_78394_d.position(20);
                  GL11.glColorPointer(4, true, 32, this.field_78394_d);
               }

               GL11.glEnableClientState('\u8076');
            }

            if(this.field_78413_q) {
               if(this.field_78389_A) {
                  GL11.glNormalPointer(5121, 32, 24L);
               } else {
                  this.field_78394_d.position(24);
                  GL11.glNormalPointer(32, this.field_78394_d);
               }

               GL11.glEnableClientState('\u8075');
            }

            if(this.field_78389_A) {
               GL11.glVertexPointer(3, 5126, 32, 0L);
            } else {
               this.field_78392_f.position(0);
               GL11.glVertexPointer(3, 32, this.field_78392_f);
            }

            GL11.glEnableClientState('\u8074');
            if(this.field_78409_u == 7 && field_78396_b) {
               GL11.glDrawArrays(4, 0, this.field_78406_i);
            } else {
               GL11.glDrawArrays(this.field_78409_u, 0, this.field_78406_i);
            }

            GL11.glDisableClientState('\u8074');
            if(this.field_78400_o) {
               GL11.glDisableClientState('\u8078');
            }

            if(this.field_78414_p) {
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
               GL11.glDisableClientState('\u8078');
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
            }

            if(this.field_78399_n) {
               GL11.glDisableClientState('\u8076');
            }

            if(this.field_78413_q) {
               GL11.glDisableClientState('\u8075');
            }
         }

         int var1 = this.field_78412_r * 4;
         this.func_78379_d();
         return var1;
      }
   }

   private void func_78379_d() {
      this.field_78406_i = 0;
      this.field_78394_d.clear();
      this.field_78412_r = 0;
      this.field_78411_s = 0;
   }

   public void func_78382_b() {
      this.func_78371_b(7);
   }

   public void func_78371_b(int p_78371_1_) {
      if(this.field_78415_z) {
         throw new IllegalStateException("Already tesselating!");
      } else {
         this.field_78415_z = true;
         this.func_78379_d();
         this.field_78409_u = p_78371_1_;
         this.field_78413_q = false;
         this.field_78399_n = false;
         this.field_78400_o = false;
         this.field_78414_p = false;
         this.field_78410_t = false;
      }
   }

   public void func_78385_a(double p_78385_1_, double p_78385_3_) {
      this.field_78400_o = true;
      this.field_78403_j = p_78385_1_;
      this.field_78404_k = p_78385_3_;
   }

   public void func_78380_c(int p_78380_1_) {
      this.field_78414_p = true;
      this.field_78401_l = p_78380_1_;
   }

   public void func_78386_a(float p_78386_1_, float p_78386_2_, float p_78386_3_) {
      this.func_78376_a((int)(p_78386_1_ * 255.0F), (int)(p_78386_2_ * 255.0F), (int)(p_78386_3_ * 255.0F));
   }

   public void func_78369_a(float p_78369_1_, float p_78369_2_, float p_78369_3_, float p_78369_4_) {
      this.func_78370_a((int)(p_78369_1_ * 255.0F), (int)(p_78369_2_ * 255.0F), (int)(p_78369_3_ * 255.0F), (int)(p_78369_4_ * 255.0F));
   }

   public void func_78376_a(int p_78376_1_, int p_78376_2_, int p_78376_3_) {
      this.func_78370_a(p_78376_1_, p_78376_2_, p_78376_3_, 255);
   }

   public void func_78370_a(int p_78370_1_, int p_78370_2_, int p_78370_3_, int p_78370_4_) {
      if(!this.field_78410_t) {
         if(p_78370_1_ > 255) {
            p_78370_1_ = 255;
         }

         if(p_78370_2_ > 255) {
            p_78370_2_ = 255;
         }

         if(p_78370_3_ > 255) {
            p_78370_3_ = 255;
         }

         if(p_78370_4_ > 255) {
            p_78370_4_ = 255;
         }

         if(p_78370_1_ < 0) {
            p_78370_1_ = 0;
         }

         if(p_78370_2_ < 0) {
            p_78370_2_ = 0;
         }

         if(p_78370_3_ < 0) {
            p_78370_3_ = 0;
         }

         if(p_78370_4_ < 0) {
            p_78370_4_ = 0;
         }

         this.field_78399_n = true;
         if(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.field_78402_m = p_78370_4_ << 24 | p_78370_3_ << 16 | p_78370_2_ << 8 | p_78370_1_;
         } else {
            this.field_78402_m = p_78370_1_ << 24 | p_78370_2_ << 16 | p_78370_3_ << 8 | p_78370_4_;
         }

      }
   }

   public void func_78374_a(double p_78374_1_, double p_78374_3_, double p_78374_5_, double p_78374_7_, double p_78374_9_) {
      this.func_78385_a(p_78374_7_, p_78374_9_);
      this.func_78377_a(p_78374_1_, p_78374_3_, p_78374_5_);
   }

   public void func_78377_a(double p_78377_1_, double p_78377_3_, double p_78377_5_) {
      ++this.field_78411_s;
      if(this.field_78409_u == 7 && field_78396_b && this.field_78411_s % 4 == 0) {
         for(int var7 = 0; var7 < 2; ++var7) {
            int var8 = 8 * (3 - var7);
            if(this.field_78400_o) {
               this.field_78405_h[this.field_78412_r + 3] = this.field_78405_h[this.field_78412_r - var8 + 3];
               this.field_78405_h[this.field_78412_r + 4] = this.field_78405_h[this.field_78412_r - var8 + 4];
            }

            if(this.field_78414_p) {
               this.field_78405_h[this.field_78412_r + 7] = this.field_78405_h[this.field_78412_r - var8 + 7];
            }

            if(this.field_78399_n) {
               this.field_78405_h[this.field_78412_r + 5] = this.field_78405_h[this.field_78412_r - var8 + 5];
            }

            this.field_78405_h[this.field_78412_r + 0] = this.field_78405_h[this.field_78412_r - var8 + 0];
            this.field_78405_h[this.field_78412_r + 1] = this.field_78405_h[this.field_78412_r - var8 + 1];
            this.field_78405_h[this.field_78412_r + 2] = this.field_78405_h[this.field_78412_r - var8 + 2];
            ++this.field_78406_i;
            this.field_78412_r += 8;
         }
      }

      if(this.field_78400_o) {
         this.field_78405_h[this.field_78412_r + 3] = Float.floatToRawIntBits((float)this.field_78403_j);
         this.field_78405_h[this.field_78412_r + 4] = Float.floatToRawIntBits((float)this.field_78404_k);
      }

      if(this.field_78414_p) {
         this.field_78405_h[this.field_78412_r + 7] = this.field_78401_l;
      }

      if(this.field_78399_n) {
         this.field_78405_h[this.field_78412_r + 5] = this.field_78402_m;
      }

      if(this.field_78413_q) {
         this.field_78405_h[this.field_78412_r + 6] = this.field_78416_y;
      }

      this.field_78405_h[this.field_78412_r + 0] = Float.floatToRawIntBits((float)(p_78377_1_ + this.field_78408_v));
      this.field_78405_h[this.field_78412_r + 1] = Float.floatToRawIntBits((float)(p_78377_3_ + this.field_78407_w));
      this.field_78405_h[this.field_78412_r + 2] = Float.floatToRawIntBits((float)(p_78377_5_ + this.field_78417_x));
      this.field_78412_r += 8;
      ++this.field_78406_i;
      if(this.field_78406_i % 4 == 0 && this.field_78412_r >= this.field_78388_E - 32) {
         this.func_78381_a();
         this.field_78415_z = true;
      }

   }

   public void func_78378_d(int p_78378_1_) {
      int var2 = p_78378_1_ >> 16 & 255;
      int var3 = p_78378_1_ >> 8 & 255;
      int var4 = p_78378_1_ & 255;
      this.func_78376_a(var2, var3, var4);
   }

   public void func_78384_a(int p_78384_1_, int p_78384_2_) {
      int var3 = p_78384_1_ >> 16 & 255;
      int var4 = p_78384_1_ >> 8 & 255;
      int var5 = p_78384_1_ & 255;
      this.func_78370_a(var3, var4, var5, p_78384_2_);
   }

   public void func_78383_c() {
      this.field_78410_t = true;
   }

   public void func_78375_b(float p_78375_1_, float p_78375_2_, float p_78375_3_) {
      this.field_78413_q = true;
      byte var4 = (byte)((int)(p_78375_1_ * 127.0F));
      byte var5 = (byte)((int)(p_78375_2_ * 127.0F));
      byte var6 = (byte)((int)(p_78375_3_ * 127.0F));
      this.field_78416_y = var4 & 255 | (var5 & 255) << 8 | (var6 & 255) << 16;
   }

   public void func_78373_b(double p_78373_1_, double p_78373_3_, double p_78373_5_) {
      this.field_78408_v = p_78373_1_;
      this.field_78407_w = p_78373_3_;
      this.field_78417_x = p_78373_5_;
   }

   public void func_78372_c(float p_78372_1_, float p_78372_2_, float p_78372_3_) {
      this.field_78408_v += (double)p_78372_1_;
      this.field_78407_w += (double)p_78372_2_;
      this.field_78417_x += (double)p_78372_3_;
   }

}
