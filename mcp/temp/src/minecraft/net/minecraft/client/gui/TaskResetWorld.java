package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.gui.GuiScreenResetWorld;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class TaskResetWorld extends TaskLongRunning {

   private final long field_96591_c;
   // $FF: synthetic field
   final GuiScreenResetWorld field_96592_a;


   public TaskResetWorld(GuiScreenResetWorld p_i10011_1_, long p_i10011_2_) {
      this.field_96592_a = p_i10011_1_;
      this.field_96591_c = p_i10011_2_;
   }

   public void run() {
      McoClient var1 = new McoClient(this.func_96578_b().field_71449_j);
      String var2 = StringTranslate.func_74808_a().func_74805_b("mco.reset.world.resetting.screen.title");
      this.func_96576_b(var2);

      try {
         var1.func_96376_d(this.field_96591_c);
         GuiScreenResetWorld.func_96147_b(this.field_96592_a).func_71373_a(GuiScreenResetWorld.func_96148_a(this.field_96592_a));
      } catch (ExceptionMcoService var4) {
         this.func_96575_a(var4.field_96391_b);
      } catch (IOException var5) {
         ;
      }

   }
}
