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
public class GuiScreenServerList extends GuiScreen {

   private final GuiScreen field_73992_b;
   private final ServerData field_73993_c;
   private GuiTextField field_73991_d;


   public GuiScreenServerList(GuiScreen p_i3066_1_, ServerData p_i3066_2_) {
      this.field_73992_b = p_i3066_1_;
      this.field_73993_c = p_i3066_2_;
   }

   public void func_73876_c() {
      this.field_73991_d.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("selectServer.select")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_73991_d = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 116, 200, 20);
      this.field_73991_d.func_73804_f(128);
      this.field_73991_d.func_73796_b(true);
      this.field_73991_d.func_73782_a(this.field_73882_e.field_71474_y.field_74332_R);
      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73991_d.func_73781_b().length() > 0 && this.field_73991_d.func_73781_b().split(":").length > 0;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
      this.field_73882_e.field_71474_y.field_74332_R = this.field_73991_d.func_73781_b();
      this.field_73882_e.field_71474_y.func_74303_b();
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73992_b.func_73878_a(false, 0);
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73993_c.field_78845_b = this.field_73991_d.func_73781_b();
            this.field_73992_b.func_73878_a(true, 0);
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(this.field_73991_d.func_73802_a(p_73869_1_, p_73869_2_)) {
         ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73991_d.func_73781_b().length() > 0 && this.field_73991_d.func_73781_b().split(":").length > 0;
      } else if(p_73869_2_ == 28) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_73991_d.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("selectServer.direct"), this.field_73880_f / 2, this.field_73881_g / 4 - 60 + 20, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("addServer.enterIp"), this.field_73880_f / 2 - 100, 100, 10526880);
      this.field_73991_d.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
