package net.minecraft.client.settings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum EnumOptions {

   MUSIC("MUSIC", 0, "options.music", true, false),
   SOUND("SOUND", 1, "options.sound", true, false),
   INVERT_MOUSE("INVERT_MOUSE", 2, "options.invertMouse", false, true),
   SENSITIVITY("SENSITIVITY", 3, "options.sensitivity", true, false),
   FOV("FOV", 4, "options.fov", true, false),
   GAMMA("GAMMA", 5, "options.gamma", true, false),
   RENDER_DISTANCE("RENDER_DISTANCE", 6, "options.renderDistance", false, false),
   VIEW_BOBBING("VIEW_BOBBING", 7, "options.viewBobbing", false, true),
   ANAGLYPH("ANAGLYPH", 8, "options.anaglyph", false, true),
   ADVANCED_OPENGL("ADVANCED_OPENGL", 9, "options.advancedOpengl", false, true),
   FRAMERATE_LIMIT("FRAMERATE_LIMIT", 10, "options.framerateLimit", false, false),
   DIFFICULTY("DIFFICULTY", 11, "options.difficulty", false, false),
   GRAPHICS("GRAPHICS", 12, "options.graphics", false, false),
   AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 13, "options.ao", false, false),
   GUI_SCALE("GUI_SCALE", 14, "options.guiScale", false, false),
   RENDER_CLOUDS("RENDER_CLOUDS", 15, "options.renderClouds", false, true),
   PARTICLES("PARTICLES", 16, "options.particles", false, false),
   CHAT_VISIBILITY("CHAT_VISIBILITY", 17, "options.chat.visibility", false, false),
   CHAT_COLOR("CHAT_COLOR", 18, "options.chat.color", false, true),
   CHAT_LINKS("CHAT_LINKS", 19, "options.chat.links", false, true),
   CHAT_OPACITY("CHAT_OPACITY", 20, "options.chat.opacity", true, false),
   CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 21, "options.chat.links.prompt", false, true),
   USE_SERVER_TEXTURES("USE_SERVER_TEXTURES", 22, "options.serverTextures", false, true),
   SNOOPER_ENABLED("SNOOPER_ENABLED", 23, "options.snooper", false, true),
   USE_FULLSCREEN("USE_FULLSCREEN", 24, "options.fullscreen", false, true),
   ENABLE_VSYNC("ENABLE_VSYNC", 25, "options.vsync", false, true),
   SHOW_CAPE("SHOW_CAPE", 26, "options.showCape", false, true),
   TOUCHSCREEN("TOUCHSCREEN", 27, "options.touchscreen", false, true),
   CHAT_SCALE("CHAT_SCALE", 28, "options.chat.scale", true, false),
   CHAT_WIDTH("CHAT_WIDTH", 29, "options.chat.width", true, false),
   CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 30, "options.chat.height.focused", true, false),
   CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 31, "options.chat.height.unfocused", true, false);
   private final boolean field_74385_A;
   private final boolean field_74386_B;
   private final String field_74387_C;
   // $FF: synthetic field
   private static final EnumOptions[] $VALUES = new EnumOptions[]{MUSIC, SOUND, INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, ADVANCED_OPENGL, FRAMERATE_LIMIT, DIFFICULTY, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, RENDER_CLOUDS, PARTICLES, CHAT_VISIBILITY, CHAT_COLOR, CHAT_LINKS, CHAT_OPACITY, CHAT_LINKS_PROMPT, USE_SERVER_TEXTURES, SNOOPER_ENABLED, USE_FULLSCREEN, ENABLE_VSYNC, SHOW_CAPE, TOUCHSCREEN, CHAT_SCALE, CHAT_WIDTH, CHAT_HEIGHT_FOCUSED, CHAT_HEIGHT_UNFOCUSED};


   public static EnumOptions func_74379_a(int p_74379_0_) {
      EnumOptions[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumOptions var4 = var1[var3];
         if(var4.func_74381_c() == p_74379_0_) {
            return var4;
         }
      }

      return null;
   }

   private EnumOptions(String p_i3011_1_, int p_i3011_2_, String p_i3011_3_, boolean p_i3011_4_, boolean p_i3011_5_) {
      this.field_74387_C = p_i3011_3_;
      this.field_74385_A = p_i3011_4_;
      this.field_74386_B = p_i3011_5_;
   }

   public boolean func_74380_a() {
      return this.field_74385_A;
   }

   public boolean func_74382_b() {
      return this.field_74386_B;
   }

   public int func_74381_c() {
      return this.ordinal();
   }

   public String func_74378_d() {
      return this.field_74387_C;
   }

}
