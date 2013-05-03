package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.EnumOptions;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiSlider extends GuiButton {

   public float field_73751_j = 1.0F;
   public boolean field_73752_k = false;
   private EnumOptions field_73750_l = null;


   public GuiSlider(int p_i3039_1_, int p_i3039_2_, int p_i3039_3_, EnumOptions p_i3039_4_, String p_i3039_5_, float p_i3039_6_) {
      super(p_i3039_1_, p_i3039_2_, p_i3039_3_, 150, 20, p_i3039_5_);
      this.field_73750_l = p_i3039_4_;
      this.field_73751_j = p_i3039_6_;
   }

   protected int func_73738_a(boolean p_73738_1_) {
      return 0;
   }

   protected void func_73739_b(Minecraft p_73739_1_, int p_73739_2_, int p_73739_3_) {
      if(this.field_73748_h) {
         if(this.field_73752_k) {
            this.field_73751_j = (float)(p_73739_2_ - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
            if(this.field_73751_j < 0.0F) {
               this.field_73751_j = 0.0F;
            }

            if(this.field_73751_j > 1.0F) {
               this.field_73751_j = 1.0F;
            }

            p_73739_1_.field_71474_y.func_74304_a(this.field_73750_l, this.field_73751_j);
            this.field_73744_e = p_73739_1_.field_71474_y.func_74297_c(this.field_73750_l);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, 20);
         this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, 20);
      }
   }

   public boolean func_73736_c(Minecraft p_73736_1_, int p_73736_2_, int p_73736_3_) {
      if(super.func_73736_c(p_73736_1_, p_73736_2_, p_73736_3_)) {
         this.field_73751_j = (float)(p_73736_2_ - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
         if(this.field_73751_j < 0.0F) {
            this.field_73751_j = 0.0F;
         }

         if(this.field_73751_j > 1.0F) {
            this.field_73751_j = 1.0F;
         }

         p_73736_1_.field_71474_y.func_74304_a(this.field_73750_l, this.field_73751_j);
         this.field_73744_e = p_73736_1_.field_71474_y.func_74297_c(this.field_73750_l);
         this.field_73752_k = true;
         return true;
      } else {
         return false;
      }
   }

   public void func_73740_a(int p_73740_1_, int p_73740_2_) {
      this.field_73752_k = false;
   }
}
