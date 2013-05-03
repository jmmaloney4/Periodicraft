package net.minecraft.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum EnumChatFormatting {

   BLACK("BLACK", 0, '0'),
   DARK_BLUE("DARK_BLUE", 1, '1'),
   DARK_GREEN("DARK_GREEN", 2, '2'),
   DARK_AQUA("DARK_AQUA", 3, '3'),
   DARK_RED("DARK_RED", 4, '4'),
   DARK_PURPLE("DARK_PURPLE", 5, '5'),
   GOLD("GOLD", 6, '6'),
   GRAY("GRAY", 7, '7'),
   DARK_GRAY("DARK_GRAY", 8, '8'),
   BLUE("BLUE", 9, '9'),
   GREEN("GREEN", 10, 'a'),
   AQUA("AQUA", 11, 'b'),
   RED("RED", 12, 'c'),
   LIGHT_PURPLE("LIGHT_PURPLE", 13, 'd'),
   YELLOW("YELLOW", 14, 'e'),
   WHITE("WHITE", 15, 'f'),
   OBFUSCATED("OBFUSCATED", 16, 'k', true),
   BOLD("BOLD", 17, 'l', true),
   STRIKETHROUGH("STRIKETHROUGH", 18, 'm', true),
   UNDERLINE("UNDERLINE", 19, 'n', true),
   ITALIC("ITALIC", 20, 'o', true),
   RESET("RESET", 21, 'r');
   private static final Map field_96321_w = new HashMap();
   private static final Map field_96331_x = new HashMap();
   private static final Pattern field_96330_y = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
   private final char field_96329_z;
   private final boolean field_96303_A;
   private final String field_96304_B;
   // $FF: synthetic field
   private static final EnumChatFormatting[] field_96305_C = new EnumChatFormatting[]{BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE, OBFUSCATED, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC, RESET};


   private EnumChatFormatting(String p_i10000_1_, int p_i10000_2_, char p_i10000_3_) {
      this(p_i10000_1_, p_i10000_2_, p_i10000_3_, false);
   }

   private EnumChatFormatting(String p_i10001_1_, int p_i10001_2_, char p_i10001_3_, boolean p_i10001_4_) {
      this.field_96329_z = p_i10001_3_;
      this.field_96303_A = p_i10001_4_;
      this.field_96304_B = "\u00a7" + p_i10001_3_;
   }

   public char func_96298_a() {
      return this.field_96329_z;
   }

   public boolean func_96301_b() {
      return this.field_96303_A;
   }

   public boolean func_96302_c() {
      return !this.field_96303_A && this != RESET;
   }

   public String func_96297_d() {
      return this.name().toLowerCase();
   }

   public String toString() {
      return this.field_96304_B;
   }

   public static EnumChatFormatting func_96300_b(String p_96300_0_) {
      return p_96300_0_ == null?null:(EnumChatFormatting)field_96331_x.get(p_96300_0_.toLowerCase());
   }

   public static Collection func_96296_a(boolean p_96296_0_, boolean p_96296_1_) {
      ArrayList var2 = new ArrayList();
      EnumChatFormatting[] var3 = values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumChatFormatting var6 = var3[var5];
         if((!var6.func_96302_c() || p_96296_0_) && (!var6.func_96301_b() || p_96296_1_)) {
            var2.add(var6.func_96297_d());
         }
      }

      return var2;
   }

   static {
      EnumChatFormatting[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumChatFormatting var3 = var0[var2];
         field_96321_w.put(Character.valueOf(var3.func_96298_a()), var3);
         field_96331_x.put(var3.func_96297_d(), var3);
      }

   }
}
