package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiRenameWorld extends GuiScreen {

   private GuiScreen field_74057_a;
   private GuiTextField field_74055_b;
   private final String field_74056_c;


   public GuiRenameWorld(GuiScreen p_i3052_1_, String p_i3052_2_) {
      this.field_74057_a = p_i3052_1_;
      this.field_74056_c = p_i3052_2_;
   }

   public void func_73876_c() {
      this.field_74055_b.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("selectWorld.renameButton")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      ISaveFormat var2 = this.field_73882_e.func_71359_d();
      WorldInfo var3 = var2.func_75803_c(this.field_74056_c);
      String var4 = var3.func_76065_j();
      this.field_74055_b = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
      this.field_74055_b.func_73796_b(true);
      this.field_74055_b.func_73782_a(var4);
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a(this.field_74057_a);
         } else if(p_73875_1_.field_73741_f == 0) {
            ISaveFormat var2 = this.field_73882_e.func_71359_d();
            var2.func_75806_a(this.field_74056_c, this.field_74055_b.func_73781_b().trim());
            this.field_73882_e.func_71373_a(this.field_74057_a);
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_74055_b.func_73802_a(p_73869_1_, p_73869_2_);
      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_74055_b.func_73781_b().trim().length() > 0;
      if(p_73869_1_ == 13) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_74055_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("selectWorld.renameTitle"), this.field_73880_f / 2, this.field_73881_g / 4 - 60 + 20, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.enterName"), this.field_73880_f / 2 - 100, 47, 10526880);
      this.field_74055_b.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
