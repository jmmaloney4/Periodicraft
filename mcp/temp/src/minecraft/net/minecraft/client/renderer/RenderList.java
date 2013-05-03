package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.IntBuffer;
import net.minecraft.client.renderer.GLAllocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderList {

   private int field_78429_a;
   private int field_78427_b;
   private int field_78428_c;
   private double field_78425_d;
   private double field_78426_e;
   private double field_78423_f;
   private IntBuffer field_78424_g = GLAllocation.func_74527_f(65536);
   private boolean field_78430_h = false;
   private boolean field_78431_i = false;


   public void func_78422_a(int p_78422_1_, int p_78422_2_, int p_78422_3_, double p_78422_4_, double p_78422_6_, double p_78422_8_) {
      this.field_78430_h = true;
      this.field_78424_g.clear();
      this.field_78429_a = p_78422_1_;
      this.field_78427_b = p_78422_2_;
      this.field_78428_c = p_78422_3_;
      this.field_78425_d = p_78422_4_;
      this.field_78426_e = p_78422_6_;
      this.field_78423_f = p_78422_8_;
   }

   public boolean func_78418_a(int p_78418_1_, int p_78418_2_, int p_78418_3_) {
      return !this.field_78430_h?false:p_78418_1_ == this.field_78429_a && p_78418_2_ == this.field_78427_b && p_78418_3_ == this.field_78428_c;
   }

   public void func_78420_a(int p_78420_1_) {
      this.field_78424_g.put(p_78420_1_);
      if(this.field_78424_g.remaining() == 0) {
         this.func_78419_a();
      }

   }

   public void func_78419_a() {
      if(this.field_78430_h) {
         if(!this.field_78431_i) {
            this.field_78424_g.flip();
            this.field_78431_i = true;
         }

         if(this.field_78424_g.remaining() > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((double)this.field_78429_a - this.field_78425_d), (float)((double)this.field_78427_b - this.field_78426_e), (float)((double)this.field_78428_c - this.field_78423_f));
            GL11.glCallLists(this.field_78424_g);
            GL11.glPopMatrix();
         }

      }
   }

   public void func_78421_b() {
      this.field_78430_h = false;
      this.field_78431_i = false;
   }
}
