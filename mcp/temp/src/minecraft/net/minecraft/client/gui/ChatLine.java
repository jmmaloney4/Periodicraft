package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ChatLine {

   private final int field_74543_a;
   private final String field_74541_b;
   private final int field_74542_c;


   public ChatLine(int p_i3021_1_, String p_i3021_2_, int p_i3021_3_) {
      this.field_74541_b = p_i3021_2_;
      this.field_74543_a = p_i3021_1_;
      this.field_74542_c = p_i3021_3_;
   }

   public String func_74538_a() {
      return this.field_74541_b;
   }

   public int func_74540_b() {
      return this.field_74543_a;
   }

   public int func_74539_c() {
      return this.field_74542_c;
   }
}
