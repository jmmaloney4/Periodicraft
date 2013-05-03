package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.TaskResetWorld;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenResetWorld extends GuiScreen {

   private GuiScreen field_96152_a;
   private McoServer field_96150_b;
   private GuiTextField field_96151_c;
   private final int field_96149_d = 1;
   private final int field_96153_n = 2;
   private GuiButton field_96154_o;


   public GuiScreenResetWorld(GuiScreen p_i10003_1_, McoServer p_i10003_2_) {
      this.field_96152_a = p_i10003_1_;
      this.field_96150_b = p_i10003_2_;
   }

   public void func_73876_c() {
      this.field_96151_c.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(this.field_96154_o = new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("mco.configure.world.buttons.reset")));
      this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_96151_c = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 109, 200, 20);
      this.field_96151_c.func_73796_b(true);
      this.field_96151_c.func_73804_f(32);
      this.field_96151_c.func_73782_a("");
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_96151_c.func_73802_a(p_73869_1_, p_73869_2_);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 2) {
            this.field_73882_e.func_71373_a(this.field_96152_a);
         } else if(p_73875_1_.field_73741_f == 1) {
            TaskResetWorld var2 = new TaskResetWorld(this, this.field_96150_b.field_96408_a);
            GuiScreenLongRunningTask var3 = new GuiScreenLongRunningTask(this.field_73882_e, this.field_96152_a, var2);
            var3.func_98117_g();
            this.field_73882_e.func_71373_a(var3);
         }

      }
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_96151_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.reset.world.title"), this.field_73880_f / 2, 17, 16777215);
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.reset.world.warning"), this.field_73880_f / 2, 66, 16711680);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.reset.world.seed"), this.field_73880_f / 2 - 100, 96, 10526880);
      this.field_96151_c.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   // $FF: synthetic method
   static GuiScreen func_96148_a(GuiScreenResetWorld p_96148_0_) {
      return p_96148_0_.field_96152_a;
   }

   // $FF: synthetic method
   static Minecraft func_96147_b(GuiScreenResetWorld p_96147_0_) {
      return p_96147_0_.field_73882_e;
   }
}
