package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiMemoryErrorScreen extends GuiScreen {

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiSmallButton(0, this.field_73880_f / 2 - 155, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.toMenu")));
      this.field_73887_h.add(new GuiSmallButton(1, this.field_73880_f / 2 - 155 + 160, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("menu.quit")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0) {
         this.field_73882_e.func_71373_a(new GuiMainMenu());
      } else if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71400_g();
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, "Out of memory!", this.field_73880_f / 2, this.field_73881_g / 4 - 60 + 20, 16777215);
      this.func_73731_b(this.field_73886_k, "Minecraft has run out of memory.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 0, 10526880);
      this.func_73731_b(this.field_73886_k, "This could be caused by a bug in the game or by the", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 18, 10526880);
      this.func_73731_b(this.field_73886_k, "Java Virtual Machine not being allocated enough", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 27, 10526880);
      this.func_73731_b(this.field_73886_k, "memory. If you are playing in a web browser, try", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 36, 10526880);
      this.func_73731_b(this.field_73886_k, "downloading the game and playing it offline.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 45, 10526880);
      this.func_73731_b(this.field_73886_k, "To prevent level corruption, the current game has quit.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 63, 10526880);
      this.func_73731_b(this.field_73886_k, "We\'ve tried to free up enough memory to let you go back to", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 81, 10526880);
      this.func_73731_b(this.field_73886_k, "the main menu and back to playing, but this may not have worked.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 90, 10526880);
      this.func_73731_b(this.field_73886_k, "Please restart the game if you see this message again.", this.field_73880_f / 2 - 140, this.field_73881_g / 4 - 60 + 60 + 99, 10526880);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
