package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.stats.IStatStringFormat;

@SideOnly(Side.CLIENT)
public class StatStringFormatKeyInv implements IStatStringFormat {

   // $FF: synthetic field
   final Minecraft field_74536_a;


   public StatStringFormatKeyInv(Minecraft p_i3018_1_) {
      this.field_74536_a = p_i3018_1_;
   }

   public String func_74535_a(String p_74535_1_) {
      try {
         return String.format(p_74535_1_, new Object[]{GameSettings.func_74298_c(this.field_74536_a.field_71474_y.field_74315_B.field_74512_d)});
      } catch (Exception var3) {
         return "Error: " + var3.getLocalizedMessage();
      }
   }
}
