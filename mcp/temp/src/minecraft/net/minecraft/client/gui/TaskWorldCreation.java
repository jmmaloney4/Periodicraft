package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import net.minecraft.client.gui.GuiScreenCreateOnlineWorld;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class TaskWorldCreation extends TaskLongRunning {

   private final String field_96589_c;
   private final String field_96587_d;
   private final String field_96588_e;
   // $FF: synthetic field
   final GuiScreenCreateOnlineWorld field_96590_a;


   public TaskWorldCreation(GuiScreenCreateOnlineWorld p_i10017_1_, String p_i10017_2_, String p_i10017_3_, String p_i10017_4_) {
      this.field_96590_a = p_i10017_1_;
      this.field_96589_c = p_i10017_2_;
      this.field_96587_d = p_i10017_3_;
      this.field_96588_e = p_i10017_4_;
   }

   public void run() {
      String var1 = StringTranslate.func_74808_a().func_74805_b("mco.create.world.wait");
      this.func_96576_b(var1);
      McoClient var2 = new McoClient(GuiScreenCreateOnlineWorld.func_98099_d(this.field_96590_a).field_71449_j);

      try {
         var2.func_96386_a(this.field_96589_c, this.field_96587_d, this.field_96588_e);
         GuiScreenCreateOnlineWorld.func_96246_c(this.field_96590_a).func_71373_a(GuiScreenCreateOnlineWorld.func_96247_b(this.field_96590_a));
      } catch (ExceptionMcoService var4) {
         this.func_96575_a(var4.field_96391_b);
      } catch (UnsupportedEncodingException var5) {
         ;
      } catch (IOException var6) {
         ;
      } catch (Exception var7) {
         this.func_96575_a("Failed");
      }

   }
}
