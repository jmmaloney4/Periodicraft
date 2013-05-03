package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.Particle;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiParticle extends Gui {

   private List field_73776_a = new ArrayList();
   private Minecraft field_73775_b;


   public GuiParticle(Minecraft p_i3095_1_) {
      this.field_73775_b = p_i3095_1_;
   }

   public void func_73774_a() {
      for(int var1 = 0; var1 < this.field_73776_a.size(); ++var1) {
         Particle var2 = (Particle)this.field_73776_a.get(var1);
         var2.func_78062_a();
         var2.func_78063_a(this);
         if(var2.field_78078_h) {
            this.field_73776_a.remove(var1--);
         }
      }

   }

   public void func_73773_a(float p_73773_1_) {
      this.field_73775_b.field_71446_o.func_98187_b("/gui/particles.png");

      for(int var2 = 0; var2 < this.field_73776_a.size(); ++var2) {
         Particle var3 = (Particle)this.field_73776_a.get(var2);
         int var4 = (int)(var3.field_78070_c + (var3.field_78071_a - var3.field_78070_c) * (double)p_73773_1_ - 4.0D);
         int var5 = (int)(var3.field_78067_d + (var3.field_78069_b - var3.field_78067_d) * (double)p_73773_1_ - 4.0D);
         float var6 = (float)(var3.field_78081_r + (var3.field_78072_n - var3.field_78081_r) * (double)p_73773_1_);
         float var7 = (float)(var3.field_78073_o + (var3.field_78077_k - var3.field_78073_o) * (double)p_73773_1_);
         float var8 = (float)(var3.field_78083_p + (var3.field_78074_l - var3.field_78083_p) * (double)p_73773_1_);
         float var9 = (float)(var3.field_78082_q + (var3.field_78075_m - var3.field_78082_q) * (double)p_73773_1_);
         GL11.glColor4f(var7, var8, var9, var6);
         this.func_73729_b(var4, var5, 40, 0, 8, 8);
      }

   }
}
