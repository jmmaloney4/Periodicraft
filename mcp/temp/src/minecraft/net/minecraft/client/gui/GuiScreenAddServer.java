package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenAddServer extends GuiScreen {

   private GuiScreen field_73999_a;
   private GuiTextField field_73997_b;
   private GuiTextField field_73998_c;
   private ServerData field_73996_d;


   public GuiScreenAddServer(GuiScreen p_i3049_1_, ServerData p_i3049_2_) {
      this.field_73999_a = p_i3049_1_;
      this.field_73996_d = p_i3049_2_;
   }

   public void func_73876_c() {
      this.field_73998_c.func_73780_a();
      this.field_73997_b.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("addServer.add")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 - 100, 142, var1.func_74805_b("addServer.hideAddress") + ": " + (this.field_73996_d.func_82820_d()?var1.func_74805_b("gui.yes"):var1.func_74805_b("gui.no"))));
      this.field_73998_c = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
      this.field_73998_c.func_73796_b(true);
      this.field_73998_c.func_73782_a(this.field_73996_d.field_78847_a);
      this.field_73997_b = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 106, 200, 20);
      this.field_73997_b.func_73804_f(128);
      this.field_73997_b.func_73782_a(this.field_73996_d.field_78845_b);
      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73997_b.func_73781_b().length() > 0 && this.field_73997_b.func_73781_b().split(":").length > 0 && this.field_73998_c.func_73781_b().length() > 0;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73999_a.func_73878_a(false, 0);
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73996_d.field_78847_a = this.field_73998_c.func_73781_b();
            this.field_73996_d.field_78845_b = this.field_73997_b.func_73781_b();
            this.field_73999_a.func_73878_a(true, 0);
         } else if(p_73875_1_.field_73741_f == 2) {
            StringTranslate var2 = StringTranslate.func_74808_a();
            this.field_73996_d.func_82819_b(!this.field_73996_d.func_82820_d());
            ((GuiButton)this.field_73887_h.get(2)).field_73744_e = var2.func_74805_b("addServer.hideAddress") + ": " + (this.field_73996_d.func_82820_d()?var2.func_74805_b("gui.yes"):var2.func_74805_b("gui.no"));
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_73998_c.func_73802_a(p_73869_1_, p_73869_2_);
      this.field_73997_b.func_73802_a(p_73869_1_, p_73869_2_);
      if(p_73869_1_ == 9) {
         if(this.field_73998_c.func_73806_l()) {
            this.field_73998_c.func_73796_b(false);
            this.field_73997_b.func_73796_b(true);
         } else {
            this.field_73998_c.func_73796_b(true);
            this.field_73997_b.func_73796_b(false);
         }
      }

      if(p_73869_1_ == 13) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73997_b.func_73781_b().length() > 0 && this.field_73997_b.func_73781_b().split(":").length > 0 && this.field_73998_c.func_73781_b().length() > 0;
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_73997_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_73998_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("addServer.title"), this.field_73880_f / 2, 17, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("addServer.enterName"), this.field_73880_f / 2 - 100, 53, 10526880);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("addServer.enterIp"), this.field_73880_f / 2 - 100, 94, 10526880);
      this.field_73998_c.func_73795_f();
      this.field_73997_b.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
