package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBeaconButton;
import net.minecraft.potion.Potion;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
class GuiBeaconButtonPower extends GuiBeaconButton {

   private final int field_82261_l;
   private final int field_82262_m;
   // $FF: synthetic field
   final GuiBeacon field_82263_k;


   public GuiBeaconButtonPower(GuiBeacon p_i5007_1_, int p_i5007_2_, int p_i5007_3_, int p_i5007_4_, int p_i5007_5_, int p_i5007_6_) {
      super(p_i5007_2_, p_i5007_3_, p_i5007_4_, "/gui/inventory.png", 0 + Potion.field_76425_a[p_i5007_5_].func_76392_e() % 8 * 18, 198 + Potion.field_76425_a[p_i5007_5_].func_76392_e() / 8 * 18);
      this.field_82263_k = p_i5007_1_;
      this.field_82261_l = p_i5007_5_;
      this.field_82262_m = p_i5007_6_;
   }

   public void func_82251_b(int p_82251_1_, int p_82251_2_) {
      String var3 = StatCollector.func_74838_a(Potion.field_76425_a[this.field_82261_l].func_76393_a());
      if(this.field_82262_m >= 3 && this.field_82261_l != Potion.field_76428_l.field_76415_H) {
         var3 = var3 + " II";
      }

      this.field_82263_k.func_74190_a(var3, p_82251_1_, p_82251_2_);
   }
}
