package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelRenderer {

   public float field_78801_a;
   public float field_78799_b;
   private int field_78803_o;
   private int field_78813_p;
   public float field_78800_c;
   public float field_78797_d;
   public float field_78798_e;
   public float field_78795_f;
   public float field_78796_g;
   public float field_78808_h;
   private boolean field_78812_q;
   private int field_78811_r;
   public boolean field_78809_i;
   public boolean field_78806_j;
   public boolean field_78807_k;
   public List field_78804_l;
   public List field_78805_m;
   public final String field_78802_n;
   private ModelBase field_78810_s;
   public float field_82906_o;
   public float field_82908_p;
   public float field_82907_q;


   public ModelRenderer(ModelBase p_i3147_1_, String p_i3147_2_) {
      this.field_78801_a = 64.0F;
      this.field_78799_b = 32.0F;
      this.field_78812_q = false;
      this.field_78811_r = 0;
      this.field_78809_i = false;
      this.field_78806_j = true;
      this.field_78807_k = false;
      this.field_78804_l = new ArrayList();
      this.field_78810_s = p_i3147_1_;
      p_i3147_1_.field_78092_r.add(this);
      this.field_78802_n = p_i3147_2_;
      this.func_78787_b(p_i3147_1_.field_78090_t, p_i3147_1_.field_78089_u);
   }

   public ModelRenderer(ModelBase p_i3148_1_) {
      this(p_i3148_1_, (String)null);
   }

   public ModelRenderer(ModelBase p_i3149_1_, int p_i3149_2_, int p_i3149_3_) {
      this(p_i3149_1_);
      this.func_78784_a(p_i3149_2_, p_i3149_3_);
   }

   public void func_78792_a(ModelRenderer p_78792_1_) {
      if(this.field_78805_m == null) {
         this.field_78805_m = new ArrayList();
      }

      this.field_78805_m.add(p_78792_1_);
   }

   public ModelRenderer func_78784_a(int p_78784_1_, int p_78784_2_) {
      this.field_78803_o = p_78784_1_;
      this.field_78813_p = p_78784_2_;
      return this;
   }

   public ModelRenderer func_78786_a(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_) {
      p_78786_1_ = this.field_78802_n + "." + p_78786_1_;
      TextureOffset var8 = this.field_78810_s.func_78084_a(p_78786_1_);
      this.func_78784_a(var8.field_78783_a, var8.field_78782_b);
      this.field_78804_l.add((new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_, 0.0F)).func_78244_a(p_78786_1_));
      return this;
   }

   public ModelRenderer func_78789_a(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {
      this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_, 0.0F));
      return this;
   }

   public void func_78790_a(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_) {
      this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_));
   }

   public void func_78793_a(float p_78793_1_, float p_78793_2_, float p_78793_3_) {
      this.field_78800_c = p_78793_1_;
      this.field_78797_d = p_78793_2_;
      this.field_78798_e = p_78793_3_;
   }

   public void func_78785_a(float p_78785_1_) {
      if(!this.field_78807_k) {
         if(this.field_78806_j) {
            if(!this.field_78812_q) {
               this.func_78788_d(p_78785_1_);
            }

            GL11.glTranslatef(this.field_82906_o, this.field_82908_p, this.field_82907_q);
            int var2;
            if(this.field_78795_f == 0.0F && this.field_78796_g == 0.0F && this.field_78808_h == 0.0F) {
               if(this.field_78800_c == 0.0F && this.field_78797_d == 0.0F && this.field_78798_e == 0.0F) {
                  GL11.glCallList(this.field_78811_r);
                  if(this.field_78805_m != null) {
                     for(var2 = 0; var2 < this.field_78805_m.size(); ++var2) {
                        ((ModelRenderer)this.field_78805_m.get(var2)).func_78785_a(p_78785_1_);
                     }
                  }
               } else {
                  GL11.glTranslatef(this.field_78800_c * p_78785_1_, this.field_78797_d * p_78785_1_, this.field_78798_e * p_78785_1_);
                  GL11.glCallList(this.field_78811_r);
                  if(this.field_78805_m != null) {
                     for(var2 = 0; var2 < this.field_78805_m.size(); ++var2) {
                        ((ModelRenderer)this.field_78805_m.get(var2)).func_78785_a(p_78785_1_);
                     }
                  }

                  GL11.glTranslatef(-this.field_78800_c * p_78785_1_, -this.field_78797_d * p_78785_1_, -this.field_78798_e * p_78785_1_);
               }
            } else {
               GL11.glPushMatrix();
               GL11.glTranslatef(this.field_78800_c * p_78785_1_, this.field_78797_d * p_78785_1_, this.field_78798_e * p_78785_1_);
               if(this.field_78808_h != 0.0F) {
                  GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if(this.field_78796_g != 0.0F) {
                  GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if(this.field_78795_f != 0.0F) {
                  GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
               }

               GL11.glCallList(this.field_78811_r);
               if(this.field_78805_m != null) {
                  for(var2 = 0; var2 < this.field_78805_m.size(); ++var2) {
                     ((ModelRenderer)this.field_78805_m.get(var2)).func_78785_a(p_78785_1_);
                  }
               }

               GL11.glPopMatrix();
            }

            GL11.glTranslatef(-this.field_82906_o, -this.field_82908_p, -this.field_82907_q);
         }
      }
   }

   public void func_78791_b(float p_78791_1_) {
      if(!this.field_78807_k) {
         if(this.field_78806_j) {
            if(!this.field_78812_q) {
               this.func_78788_d(p_78791_1_);
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(this.field_78800_c * p_78791_1_, this.field_78797_d * p_78791_1_, this.field_78798_e * p_78791_1_);
            if(this.field_78796_g != 0.0F) {
               GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
            }

            if(this.field_78795_f != 0.0F) {
               GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
            }

            if(this.field_78808_h != 0.0F) {
               GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glCallList(this.field_78811_r);
            GL11.glPopMatrix();
         }
      }
   }

   public void func_78794_c(float p_78794_1_) {
      if(!this.field_78807_k) {
         if(this.field_78806_j) {
            if(!this.field_78812_q) {
               this.func_78788_d(p_78794_1_);
            }

            if(this.field_78795_f == 0.0F && this.field_78796_g == 0.0F && this.field_78808_h == 0.0F) {
               if(this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F) {
                  GL11.glTranslatef(this.field_78800_c * p_78794_1_, this.field_78797_d * p_78794_1_, this.field_78798_e * p_78794_1_);
               }
            } else {
               GL11.glTranslatef(this.field_78800_c * p_78794_1_, this.field_78797_d * p_78794_1_, this.field_78798_e * p_78794_1_);
               if(this.field_78808_h != 0.0F) {
                  GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if(this.field_78796_g != 0.0F) {
                  GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if(this.field_78795_f != 0.0F) {
                  GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
               }
            }

         }
      }
   }

   private void func_78788_d(float p_78788_1_) {
      this.field_78811_r = GLAllocation.func_74526_a(1);
      GL11.glNewList(this.field_78811_r, 4864);
      Tessellator var2 = Tessellator.field_78398_a;

      for(int var3 = 0; var3 < this.field_78804_l.size(); ++var3) {
         ((ModelBox)this.field_78804_l.get(var3)).func_78245_a(var2, p_78788_1_);
      }

      GL11.glEndList();
      this.field_78812_q = true;
   }

   public ModelRenderer func_78787_b(int p_78787_1_, int p_78787_2_) {
      this.field_78801_a = (float)p_78787_1_;
      this.field_78799_b = (float)p_78787_2_;
      return this;
   }
}
