package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButton extends Gui {

   protected int field_73747_a;
   protected int field_73745_b;
   public int field_73746_c;
   public int field_73743_d;
   public String field_73744_e;
   public int field_73741_f;
   public boolean field_73742_g;
   public boolean field_73748_h;
   protected boolean field_82253_i;


   public GuiButton(int p_i3055_1_, int p_i3055_2_, int p_i3055_3_, String p_i3055_4_) {
      this(p_i3055_1_, p_i3055_2_, p_i3055_3_, 200, 20, p_i3055_4_);
   }

   public GuiButton(int p_i3056_1_, int p_i3056_2_, int p_i3056_3_, int p_i3056_4_, int p_i3056_5_, String p_i3056_6_) {
      this.field_73747_a = 200;
      this.field_73745_b = 20;
      this.field_73742_g = true;
      this.field_73748_h = true;
      this.field_73741_f = p_i3056_1_;
      this.field_73746_c = p_i3056_2_;
      this.field_73743_d = p_i3056_3_;
      this.field_73747_a = p_i3056_4_;
      this.field_73745_b = p_i3056_5_;
      this.field_73744_e = p_i3056_6_;
   }

   protected int func_73738_a(boolean p_73738_1_) {
      byte var2 = 1;
      if(!this.field_73742_g) {
         var2 = 0;
      } else if(p_73738_1_) {
         var2 = 2;
      }

      return var2;
   }

   public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_) {
      if(this.field_73748_h) {
         FontRenderer var4 = p_73737_1_.field_71466_p;
         p_73737_1_.field_71446_o.func_98187_b("/gui/gui.png");
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_82253_i = p_73737_2_ >= this.field_73746_c && p_73737_3_ >= this.field_73743_d && p_73737_2_ < this.field_73746_c + this.field_73747_a && p_73737_3_ < this.field_73743_d + this.field_73745_b;
         int var5 = this.func_73738_a(this.field_82253_i);
         this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, 46 + var5 * 20, this.field_73747_a / 2, this.field_73745_b);
         this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, 200 - this.field_73747_a / 2, 46 + var5 * 20, this.field_73747_a / 2, this.field_73745_b);
         this.func_73739_b(p_73737_1_, p_73737_2_, p_73737_3_);
         int var6 = 14737632;
         if(!this.field_73742_g) {
            var6 = -6250336;
         } else if(this.field_82253_i) {
            var6 = 16777120;
         }

         this.func_73732_a(var4, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, var6);
      }
   }

   protected void func_73739_b(Minecraft p_73739_1_, int p_73739_2_, int p_73739_3_) {}

   public void func_73740_a(int p_73740_1_, int p_73740_2_) {}

   public boolean func_73736_c(Minecraft p_73736_1_, int p_73736_2_, int p_73736_3_) {
      return this.field_73742_g && this.field_73748_h && p_73736_2_ >= this.field_73746_c && p_73736_3_ >= this.field_73743_d && p_73736_2_ < this.field_73746_c + this.field_73747_a && p_73736_3_ < this.field_73743_d + this.field_73745_b;
   }

   public boolean func_82252_a() {
      return this.field_82253_i;
   }

   public void func_82251_b(int p_82251_1_, int p_82251_2_) {}
}
