package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiGameOver extends GuiScreen {

   private int field_73995_a;


   public void func_73866_w_() {
      this.field_73887_h.clear();
      if(this.field_73882_e.field_71441_e.func_72912_H().func_76093_s()) {
         if(this.field_73882_e.func_71387_A()) {
            this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.deleteWorld")));
         } else {
            this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.leaveServer")));
         }
      } else {
         this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 72, StatCollector.func_74838_a("deathScreen.respawn")));
         this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96, StatCollector.func_74838_a("deathScreen.titleScreen")));
         if(this.field_73882_e.field_71449_j == null) {
            ((GuiButton)this.field_73887_h.get(1)).field_73742_g = false;
         }
      }

      GuiButton var2;
      for(Iterator var1 = this.field_73887_h.iterator(); var1.hasNext(); var2.field_73742_g = false) {
         var2 = (GuiButton)var1.next();
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   protected void func_73875_a(GuiButton p_73875_1_) {
      switch(p_73875_1_.field_73741_f) {
      case 1:
         this.field_73882_e.field_71439_g.func_71004_bE();
         this.field_73882_e.func_71373_a((GuiScreen)null);
         break;
      case 2:
         this.field_73882_e.field_71441_e.func_72882_A();
         this.field_73882_e.func_71403_a((WorldClient)null);
         this.field_73882_e.func_71373_a(new GuiMainMenu());
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 1615855616, -1602211792);
      GL11.glPushMatrix();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      boolean var4 = this.field_73882_e.field_71441_e.func_72912_H().func_76093_s();
      String var5 = var4?StatCollector.func_74838_a("deathScreen.title.hardcore"):StatCollector.func_74838_a("deathScreen.title");
      this.func_73732_a(this.field_73886_k, var5, this.field_73880_f / 2 / 2, 30, 16777215);
      GL11.glPopMatrix();
      if(var4) {
         this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("deathScreen.hardcoreInfo"), this.field_73880_f / 2, 144, 16777215);
      }

      this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("deathScreen.score") + ": " + EnumChatFormatting.YELLOW + this.field_73882_e.field_71439_g.func_71037_bA(), this.field_73880_f / 2, 100, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
      super.func_73876_c();
      ++this.field_73995_a;
      GuiButton var2;
      if(this.field_73995_a == 20) {
         for(Iterator var1 = this.field_73887_h.iterator(); var1.hasNext(); var2.field_73742_g = true) {
            var2 = (GuiButton)var1.next();
         }
      }

   }
}
