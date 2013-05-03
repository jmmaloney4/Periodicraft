package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenDemo extends GuiScreen {

   public void func_73866_w_() {
      this.field_73887_h.clear();
      byte var1 = -16;
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 116, this.field_73881_g / 2 + 62 + var1, 114, 20, StatCollector.func_74838_a("demo.help.buy")));
      this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 62 + var1, 114, 20, StatCollector.func_74838_a("demo.help.later")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      switch(p_73875_1_.field_73741_f) {
      case 1:
         p_73875_1_.field_73742_g = false;

         try {
            Class var2 = Class.forName("java.awt.Desktop");
            Object var3 = var2.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
            var2.getMethod("browse", new Class[]{URI.class}).invoke(var3, new Object[]{new URI("http://www.minecraft.net/store?source=demo")});
         } catch (Throwable var4) {
            var4.printStackTrace();
         }
         break;
      case 2:
         this.field_73882_e.func_71373_a((GuiScreen)null);
         this.field_73882_e.func_71381_h();
      }

   }

   public void func_73876_c() {
      super.func_73876_c();
   }

   public void func_73873_v_() {
      super.func_73873_v_();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/demo_bg.png");
      int var1 = (this.field_73880_f - 248) / 2;
      int var2 = (this.field_73881_g - 166) / 2;
      this.func_73729_b(var1, var2, 0, 0, 248, 166);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      int var4 = (this.field_73880_f - 248) / 2 + 10;
      int var5 = (this.field_73881_g - 166) / 2 + 8;
      this.field_73886_k.func_78276_b(StatCollector.func_74838_a("demo.help.title"), var4, var5, 2039583);
      var5 += 12;
      GameSettings var7 = this.field_73882_e.field_71474_y;
      String var6 = StatCollector.func_74838_a("demo.help.movementShort");
      var6 = String.format(var6, new Object[]{Keyboard.getKeyName(var7.field_74351_w.field_74512_d), Keyboard.getKeyName(var7.field_74370_x.field_74512_d), Keyboard.getKeyName(var7.field_74368_y.field_74512_d), Keyboard.getKeyName(var7.field_74366_z.field_74512_d)});
      this.field_73886_k.func_78276_b(var6, var4, var5, 5197647);
      var6 = StatCollector.func_74838_a("demo.help.movementMouse");
      this.field_73886_k.func_78276_b(var6, var4, var5 + 12, 5197647);
      var6 = StatCollector.func_74838_a("demo.help.jump");
      var6 = String.format(var6, new Object[]{Keyboard.getKeyName(var7.field_74314_A.field_74512_d)});
      this.field_73886_k.func_78276_b(var6, var4, var5 + 24, 5197647);
      var6 = StatCollector.func_74838_a("demo.help.inventory");
      var6 = String.format(var6, new Object[]{Keyboard.getKeyName(var7.field_74315_B.field_74512_d)});
      this.field_73886_k.func_78276_b(var6, var4, var5 + 36, 5197647);
      this.field_73886_k.func_78279_b(StatCollector.func_74838_a("demo.help.fullWrapped"), var4, var5 + 68, 218, 2039583);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
