package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButtonLanguage extends GuiButton {

   public GuiButtonLanguage(int p_i3038_1_, int p_i3038_2_, int p_i3038_3_) {
      super(p_i3038_1_, p_i3038_2_, p_i3038_3_, 20, 20, "");
   }

   public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_) {
      if(this.field_73748_h) {
         p_73737_1_.field_71446_o.func_98187_b("/gui/gui.png");
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var4 = p_73737_2_ >= this.field_73746_c && p_73737_3_ >= this.field_73743_d && p_73737_2_ < this.field_73746_c + this.field_73747_a && p_73737_3_ < this.field_73743_d + this.field_73745_b;
         int var5 = 106;
         if(var4) {
            var5 += this.field_73745_b;
         }

         this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, var5, this.field_73747_a, this.field_73745_b);
      }
   }
}
