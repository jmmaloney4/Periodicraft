package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiIngameMenu extends GuiScreen {

   private int field_74050_a = 0;
   private int field_74049_b = 0;


   public void func_73866_w_() {
      this.field_74050_a = 0;
      this.field_73887_h.clear();
      byte var1 = -16;
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + var1, StatCollector.func_74838_a("menu.returnToMenu")));
      if(!this.field_73882_e.func_71387_A()) {
         ((GuiButton)this.field_73887_h.get(0)).field_73744_e = StatCollector.func_74838_a("menu.disconnect");
      }

      this.field_73887_h.add(new GuiButton(4, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 24 + var1, StatCollector.func_74838_a("menu.returnToGame")));
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + var1, 98, 20, StatCollector.func_74838_a("menu.options")));
      GuiButton var3;
      this.field_73887_h.add(var3 = new GuiButton(7, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 96 + var1, 98, 20, StatCollector.func_74838_a("menu.shareToLan")));
      this.field_73887_h.add(new GuiButton(5, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 48 + var1, 98, 20, StatCollector.func_74838_a("gui.achievements")));
      this.field_73887_h.add(new GuiButton(6, this.field_73880_f / 2 + 2, this.field_73881_g / 4 + 48 + var1, 98, 20, StatCollector.func_74838_a("gui.stats")));
      var3.field_73742_g = this.field_73882_e.func_71356_B() && !this.field_73882_e.func_71401_C().func_71344_c();
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      switch(p_73875_1_.field_73741_f) {
      case 0:
         this.field_73882_e.func_71373_a(new GuiOptions(this, this.field_73882_e.field_71474_y));
         break;
      case 1:
         p_73875_1_.field_73742_g = false;
         this.field_73882_e.field_71413_E.func_77450_a(StatList.field_75947_j, 1);
         this.field_73882_e.field_71441_e.func_72882_A();
         this.field_73882_e.func_71403_a((WorldClient)null);
         this.field_73882_e.func_71373_a(new GuiMainMenu());
      case 2:
      case 3:
      default:
         break;
      case 4:
         this.field_73882_e.func_71373_a((GuiScreen)null);
         this.field_73882_e.func_71381_h();
         this.field_73882_e.field_71416_A.func_82461_f();
         break;
      case 5:
         this.field_73882_e.func_71373_a(new GuiAchievements(this.field_73882_e.field_71413_E));
         break;
      case 6:
         this.field_73882_e.func_71373_a(new GuiStats(this, this.field_73882_e.field_71413_E));
         break;
      case 7:
         this.field_73882_e.func_71373_a(new GuiShareToLan(this));
      }

   }

   public void func_73876_c() {
      super.func_73876_c();
      ++this.field_74049_b;
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, "Game menu", this.field_73880_f / 2, 40, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
