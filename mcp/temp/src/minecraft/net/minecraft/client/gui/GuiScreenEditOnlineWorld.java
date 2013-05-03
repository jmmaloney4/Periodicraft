package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfigureWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenEditOnlineWorld extends GuiScreen {

   private GuiScreen field_96204_a;
   private GuiScreen field_96202_b;
   private GuiTextField field_96203_c;
   private GuiTextField field_96201_d;
   private McoServer field_96205_n;
   private GuiButton field_96206_o;


   public GuiScreenEditOnlineWorld(GuiScreen p_i10013_1_, GuiScreen p_i10013_2_, McoServer p_i10013_3_) {
      this.field_96204_a = p_i10013_1_;
      this.field_96202_b = p_i10013_2_;
      this.field_96205_n = p_i10013_3_;
   }

   public void func_73876_c() {
      this.field_96201_d.func_73780_a();
      this.field_96203_c.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(this.field_96206_o = new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("mco.configure.world.buttons.done")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_96201_d = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
      this.field_96201_d.func_73796_b(true);
      this.field_96201_d.func_73804_f(32);
      this.field_96201_d.func_73782_a(this.field_96205_n.func_96398_b());
      this.field_96203_c = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 106, 200, 20);
      this.field_96203_c.func_73804_f(32);
      this.field_96203_c.func_73782_a(this.field_96205_n.func_96397_a());
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a(this.field_96204_a);
         } else if(p_73875_1_.field_73741_f == 0) {
            this.func_96200_g();
         }

      }
   }

   private void func_96200_g() {
      McoClient var1 = new McoClient(this.field_73882_e.field_71449_j);

      try {
         String var2 = this.field_96203_c.func_73781_b() != null && !this.field_96203_c.func_73781_b().trim().equals("")?this.field_96203_c.func_73781_b():"";
         var1.func_96384_a(this.field_96205_n.field_96408_a, this.field_96201_d.func_73781_b(), var2);
         this.field_96205_n.func_96399_a(this.field_96201_d.func_73781_b());
         this.field_96205_n.func_96400_b(this.field_96203_c.func_73781_b());
         this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this.field_96202_b, this.field_96205_n));
      } catch (Exception var3) {
         ;
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_96201_d.func_73802_a(p_73869_1_, p_73869_2_);
      this.field_96203_c.func_73802_a(p_73869_1_, p_73869_2_);
      if(p_73869_1_ == 9) {
         if(this.field_96201_d.func_73806_l()) {
            this.field_96201_d.func_73796_b(false);
            this.field_96203_c.func_73796_b(true);
         } else {
            this.field_96201_d.func_73796_b(true);
            this.field_96203_c.func_73796_b(false);
         }
      }

      if(p_73869_1_ == 13) {
         this.func_96200_g();
      }

      this.field_96206_o.field_73742_g = this.field_96201_d.func_73781_b() != null && !this.field_96201_d.func_73781_b().trim().equals("");
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_96203_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_96201_d.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.configure.world.edit.title"), this.field_73880_f / 2, 17, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.name"), this.field_73880_f / 2 - 100, 53, 10526880);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.description"), this.field_73880_f / 2 - 100, 94, 10526880);
      this.field_96201_d.func_73795_f();
      this.field_96203_c.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
