package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class ThreadTitleScreen extends Thread {

   // $FF: synthetic field
   final StringTranslate field_98135_a;
   // $FF: synthetic field
   final int field_98133_b;
   // $FF: synthetic field
   final int field_98134_c;
   // $FF: synthetic field
   final GuiMainMenu field_98132_d;


   ThreadTitleScreen(GuiMainMenu p_i11019_1_, StringTranslate p_i11019_2_, int p_i11019_3_, int p_i11019_4_) {
      this.field_98132_d = p_i11019_1_;
      this.field_98135_a = p_i11019_2_;
      this.field_98133_b = p_i11019_3_;
      this.field_98134_c = p_i11019_4_;
   }

   public void run() {
      McoClient var1 = new McoClient(GuiMainMenu.func_98058_a(this.field_98132_d).field_71449_j);
      boolean var2 = false;

      for(int var3 = 0; var3 < 3; ++var3) {
         try {
            Boolean var4 = var1.func_96375_b();
            if(var4.booleanValue()) {
               GuiMainMenu.func_98061_a(this.field_98132_d, this.field_98135_a, this.field_98133_b, this.field_98134_c);
            }

            GuiMainMenu.func_98059_a(var4.booleanValue());
         } catch (ExceptionRetryCall var6) {
            var2 = true;
         } catch (ExceptionMcoService var7) {
            ;
         } catch (IOException var8) {
            ;
         }

         if(!var2) {
            break;
         }

         try {
            Thread.sleep(10000L);
         } catch (InterruptedException var5) {
            Thread.currentThread().interrupt();
         }
      }

   }
}
