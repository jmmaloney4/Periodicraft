package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.EnumOptions;

@SideOnly(Side.CLIENT)
public class GuiSmallButton extends GuiButton {

   private final EnumOptions field_73754_j;


   public GuiSmallButton(int p_i3057_1_, int p_i3057_2_, int p_i3057_3_, String p_i3057_4_) {
      this(p_i3057_1_, p_i3057_2_, p_i3057_3_, (EnumOptions)null, p_i3057_4_);
   }

   public GuiSmallButton(int p_i3058_1_, int p_i3058_2_, int p_i3058_3_, int p_i3058_4_, int p_i3058_5_, String p_i3058_6_) {
      super(p_i3058_1_, p_i3058_2_, p_i3058_3_, p_i3058_4_, p_i3058_5_, p_i3058_6_);
      this.field_73754_j = null;
   }

   public GuiSmallButton(int p_i3059_1_, int p_i3059_2_, int p_i3059_3_, EnumOptions p_i3059_4_, String p_i3059_5_) {
      super(p_i3059_1_, p_i3059_2_, p_i3059_3_, 150, 20, p_i3059_5_);
      this.field_73754_j = p_i3059_4_;
   }

   public EnumOptions func_73753_a() {
      return this.field_73754_j;
   }
}
