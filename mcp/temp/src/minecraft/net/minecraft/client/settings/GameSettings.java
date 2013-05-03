package net.minecraft.client.settings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.EnumOptionsHelper;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

@SideOnly(Side.CLIENT)
public class GameSettings {

   private static final String[] field_74360_ac = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
   private static final String[] field_74361_ad = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
   private static final String[] field_74367_ae = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   private static final String[] field_74369_af = new String[]{"options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"};
   private static final String[] field_74364_ag = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
   private static final String[] field_74365_ah = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
   private static final String[] field_98303_au = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
   public float field_74342_a = 1.0F;
   public float field_74340_b = 1.0F;
   public float field_74341_c = 0.5F;
   public boolean field_74338_d = false;
   public int field_74339_e = 0;
   public boolean field_74336_f = true;
   public boolean field_74337_g = false;
   public boolean field_74349_h = false;
   public int field_74350_i = 1;
   public boolean field_74347_j = true;
   public int field_74348_k = 2;
   public boolean field_74345_l = true;
   public String field_74346_m = "Default";
   public int field_74343_n = 0;
   public boolean field_74344_o = true;
   public boolean field_74359_p = true;
   public boolean field_74358_q = true;
   public float field_74357_r = 1.0F;
   public boolean field_74356_s = true;
   public boolean field_74355_t = true;
   public boolean field_74353_u = false;
   public boolean field_74352_v = true;
   public boolean field_80005_w = false;
   public boolean field_82882_x = false;
   public boolean field_82881_y = true;
   public boolean field_82880_z = true;
   public boolean field_85185_A = false;
   public int field_92118_B = 0;
   public int field_92119_C = 0;
   public boolean field_92117_D = true;
   public float field_96691_E = 1.0F;
   public float field_96692_F = 1.0F;
   public float field_96693_G = 0.44366196F;
   public float field_96694_H = 1.0F;
   public KeyBinding field_74351_w = new KeyBinding("key.forward", 17);
   public KeyBinding field_74370_x = new KeyBinding("key.left", 30);
   public KeyBinding field_74368_y = new KeyBinding("key.back", 31);
   public KeyBinding field_74366_z = new KeyBinding("key.right", 32);
   public KeyBinding field_74314_A = new KeyBinding("key.jump", 57);
   public KeyBinding field_74315_B = new KeyBinding("key.inventory", 18);
   public KeyBinding field_74316_C = new KeyBinding("key.drop", 16);
   public KeyBinding field_74310_D = new KeyBinding("key.chat", 20);
   public KeyBinding field_74311_E = new KeyBinding("key.sneak", 42);
   public KeyBinding field_74312_F = new KeyBinding("key.attack", -100);
   public KeyBinding field_74313_G = new KeyBinding("key.use", -99);
   public KeyBinding field_74321_H = new KeyBinding("key.playerlist", 15);
   public KeyBinding field_74322_I = new KeyBinding("key.pickItem", -98);
   public KeyBinding field_74323_J = new KeyBinding("key.command", 53);
   public KeyBinding[] field_74324_K;
   protected Minecraft field_74317_L;
   private File field_74354_ai;
   public int field_74318_M;
   public boolean field_74319_N;
   public int field_74320_O;
   public boolean field_74330_P;
   public boolean field_74329_Q;
   public String field_74332_R;
   public boolean field_74331_S;
   public boolean field_74326_T;
   public boolean field_74325_U;
   public float field_74328_V;
   public float field_74327_W;
   public float field_74334_X;
   public float field_74333_Y;
   public int field_74335_Z;
   public int field_74362_aa;
   public String field_74363_ab;


   public GameSettings(Minecraft p_i3009_1_, File p_i3009_2_) {
      this.field_74324_K = new KeyBinding[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_74315_B, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.field_74323_J};
      this.field_74318_M = 2;
      this.field_74319_N = false;
      this.field_74320_O = 0;
      this.field_74330_P = false;
      this.field_74329_Q = false;
      this.field_74332_R = "";
      this.field_74331_S = false;
      this.field_74326_T = false;
      this.field_74325_U = false;
      this.field_74328_V = 1.0F;
      this.field_74327_W = 1.0F;
      this.field_74334_X = 0.0F;
      this.field_74333_Y = 0.0F;
      this.field_74335_Z = 0;
      this.field_74362_aa = 0;
      this.field_74363_ab = "en_US";
      this.field_74317_L = p_i3009_1_;
      this.field_74354_ai = new File(p_i3009_2_, "options.txt");
      this.func_74300_a();
   }

   public GameSettings() {
      this.field_74324_K = new KeyBinding[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_74315_B, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.field_74323_J};
      this.field_74318_M = 2;
      this.field_74319_N = false;
      this.field_74320_O = 0;
      this.field_74330_P = false;
      this.field_74329_Q = false;
      this.field_74332_R = "";
      this.field_74331_S = false;
      this.field_74326_T = false;
      this.field_74325_U = false;
      this.field_74328_V = 1.0F;
      this.field_74327_W = 1.0F;
      this.field_74334_X = 0.0F;
      this.field_74333_Y = 0.0F;
      this.field_74335_Z = 0;
      this.field_74362_aa = 0;
      this.field_74363_ab = "en_US";
   }

   public String func_74302_a(int p_74302_1_) {
      StringTranslate var2 = StringTranslate.func_74808_a();
      return var2.func_74805_b(this.field_74324_K[p_74302_1_].field_74515_c);
   }

   public String func_74301_b(int p_74301_1_) {
      int var2 = this.field_74324_K[p_74301_1_].field_74512_d;
      return func_74298_c(var2);
   }

   public static String func_74298_c(int p_74298_0_) {
      return p_74298_0_ < 0?StatCollector.func_74837_a("key.mouseButton", new Object[]{Integer.valueOf(p_74298_0_ + 101)}):Keyboard.getKeyName(p_74298_0_);
   }

   public static boolean func_100015_a(KeyBinding p_100015_0_) {
      return p_100015_0_.field_74512_d < 0?Mouse.isButtonDown(p_100015_0_.field_74512_d + 100):Keyboard.isKeyDown(p_100015_0_.field_74512_d);
   }

   public void func_74307_a(int p_74307_1_, int p_74307_2_) {
      this.field_74324_K[p_74307_1_].field_74512_d = p_74307_2_;
      this.func_74303_b();
   }

   public void func_74304_a(EnumOptions p_74304_1_, float p_74304_2_) {
      if(p_74304_1_ == EnumOptions.MUSIC) {
         this.field_74342_a = p_74304_2_;
         this.field_74317_L.field_71416_A.func_77367_a();
      }

      if(p_74304_1_ == EnumOptions.SOUND) {
         this.field_74340_b = p_74304_2_;
         this.field_74317_L.field_71416_A.func_77367_a();
      }

      if(p_74304_1_ == EnumOptions.SENSITIVITY) {
         this.field_74341_c = p_74304_2_;
      }

      if(p_74304_1_ == EnumOptions.FOV) {
         this.field_74334_X = p_74304_2_;
      }

      if(p_74304_1_ == EnumOptions.GAMMA) {
         this.field_74333_Y = p_74304_2_;
      }

      if(p_74304_1_ == EnumOptions.CHAT_OPACITY) {
         this.field_74357_r = p_74304_2_;
         this.field_74317_L.field_71456_v.func_73827_b().func_96132_b();
      }

      if(p_74304_1_ == EnumOptions.CHAT_HEIGHT_FOCUSED) {
         this.field_96694_H = p_74304_2_;
         this.field_74317_L.field_71456_v.func_73827_b().func_96132_b();
      }

      if(p_74304_1_ == EnumOptions.CHAT_HEIGHT_UNFOCUSED) {
         this.field_96693_G = p_74304_2_;
         this.field_74317_L.field_71456_v.func_73827_b().func_96132_b();
      }

      if(p_74304_1_ == EnumOptions.CHAT_WIDTH) {
         this.field_96692_F = p_74304_2_;
         this.field_74317_L.field_71456_v.func_73827_b().func_96132_b();
      }

      if(p_74304_1_ == EnumOptions.CHAT_SCALE) {
         this.field_96691_E = p_74304_2_;
         this.field_74317_L.field_71456_v.func_73827_b().func_96132_b();
      }

   }

   public void func_74306_a(EnumOptions p_74306_1_, int p_74306_2_) {
      if(p_74306_1_ == EnumOptions.INVERT_MOUSE) {
         this.field_74338_d = !this.field_74338_d;
      }

      if(p_74306_1_ == EnumOptions.RENDER_DISTANCE) {
         this.field_74339_e = this.field_74339_e + p_74306_2_ & 3;
      }

      if(p_74306_1_ == EnumOptions.GUI_SCALE) {
         this.field_74335_Z = this.field_74335_Z + p_74306_2_ & 3;
      }

      if(p_74306_1_ == EnumOptions.PARTICLES) {
         this.field_74362_aa = (this.field_74362_aa + p_74306_2_) % 3;
      }

      if(p_74306_1_ == EnumOptions.VIEW_BOBBING) {
         this.field_74336_f = !this.field_74336_f;
      }

      if(p_74306_1_ == EnumOptions.RENDER_CLOUDS) {
         this.field_74345_l = !this.field_74345_l;
      }

      if(p_74306_1_ == EnumOptions.ADVANCED_OPENGL) {
         this.field_74349_h = !this.field_74349_h;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == EnumOptions.ANAGLYPH) {
         this.field_74337_g = !this.field_74337_g;
         this.field_74317_L.field_71446_o.func_78352_b();
      }

      if(p_74306_1_ == EnumOptions.FRAMERATE_LIMIT) {
         this.field_74350_i = (this.field_74350_i + p_74306_2_ + 3) % 3;
      }

      if(p_74306_1_ == EnumOptions.DIFFICULTY) {
         this.field_74318_M = this.field_74318_M + p_74306_2_ & 3;
      }

      if(p_74306_1_ == EnumOptions.GRAPHICS) {
         this.field_74347_j = !this.field_74347_j;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == EnumOptions.AMBIENT_OCCLUSION) {
         this.field_74348_k = (this.field_74348_k + p_74306_2_) % 3;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == EnumOptions.CHAT_VISIBILITY) {
         this.field_74343_n = (this.field_74343_n + p_74306_2_) % 3;
      }

      if(p_74306_1_ == EnumOptions.CHAT_COLOR) {
         this.field_74344_o = !this.field_74344_o;
      }

      if(p_74306_1_ == EnumOptions.CHAT_LINKS) {
         this.field_74359_p = !this.field_74359_p;
      }

      if(p_74306_1_ == EnumOptions.CHAT_LINKS_PROMPT) {
         this.field_74358_q = !this.field_74358_q;
      }

      if(p_74306_1_ == EnumOptions.USE_SERVER_TEXTURES) {
         this.field_74356_s = !this.field_74356_s;
      }

      if(p_74306_1_ == EnumOptions.SNOOPER_ENABLED) {
         this.field_74355_t = !this.field_74355_t;
      }

      if(p_74306_1_ == EnumOptions.SHOW_CAPE) {
         this.field_82880_z = !this.field_82880_z;
      }

      if(p_74306_1_ == EnumOptions.TOUCHSCREEN) {
         this.field_85185_A = !this.field_85185_A;
      }

      if(p_74306_1_ == EnumOptions.USE_FULLSCREEN) {
         this.field_74353_u = !this.field_74353_u;
         if(this.field_74317_L.func_71372_G() != this.field_74353_u) {
            this.field_74317_L.func_71352_k();
         }
      }

      if(p_74306_1_ == EnumOptions.ENABLE_VSYNC) {
         this.field_74352_v = !this.field_74352_v;
         Display.setVSyncEnabled(this.field_74352_v);
      }

      this.func_74303_b();
   }

   public float func_74296_a(EnumOptions p_74296_1_) {
      return p_74296_1_ == EnumOptions.FOV?this.field_74334_X:(p_74296_1_ == EnumOptions.GAMMA?this.field_74333_Y:(p_74296_1_ == EnumOptions.MUSIC?this.field_74342_a:(p_74296_1_ == EnumOptions.SOUND?this.field_74340_b:(p_74296_1_ == EnumOptions.SENSITIVITY?this.field_74341_c:(p_74296_1_ == EnumOptions.CHAT_OPACITY?this.field_74357_r:(p_74296_1_ == EnumOptions.CHAT_HEIGHT_FOCUSED?this.field_96694_H:(p_74296_1_ == EnumOptions.CHAT_HEIGHT_UNFOCUSED?this.field_96693_G:(p_74296_1_ == EnumOptions.CHAT_SCALE?this.field_96691_E:(p_74296_1_ == EnumOptions.CHAT_WIDTH?this.field_96692_F:0.0F)))))))));
   }

   public boolean func_74308_b(EnumOptions p_74308_1_) {
      switch(EnumOptionsHelper.field_74414_a[p_74308_1_.ordinal()]) {
      case 1:
         return this.field_74338_d;
      case 2:
         return this.field_74336_f;
      case 3:
         return this.field_74337_g;
      case 4:
         return this.field_74349_h;
      case 5:
         return this.field_74345_l;
      case 6:
         return this.field_74344_o;
      case 7:
         return this.field_74359_p;
      case 8:
         return this.field_74358_q;
      case 9:
         return this.field_74356_s;
      case 10:
         return this.field_74355_t;
      case 11:
         return this.field_74353_u;
      case 12:
         return this.field_74352_v;
      case 13:
         return this.field_82880_z;
      case 14:
         return this.field_85185_A;
      default:
         return false;
      }
   }

   private static String func_74299_a(String[] p_74299_0_, int p_74299_1_) {
      if(p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_.length) {
         p_74299_1_ = 0;
      }

      StringTranslate var2 = StringTranslate.func_74808_a();
      return var2.func_74805_b(p_74299_0_[p_74299_1_]);
   }

   public String func_74297_c(EnumOptions p_74297_1_) {
      StringTranslate var2 = StringTranslate.func_74808_a();
      String var3 = var2.func_74805_b(p_74297_1_.func_74378_d()) + ": ";
      if(p_74297_1_.func_74380_a()) {
         float var5 = this.func_74296_a(p_74297_1_);
         return p_74297_1_ == EnumOptions.SENSITIVITY?(var5 == 0.0F?var3 + var2.func_74805_b("options.sensitivity.min"):(var5 == 1.0F?var3 + var2.func_74805_b("options.sensitivity.max"):var3 + (int)(var5 * 200.0F) + "%")):(p_74297_1_ == EnumOptions.FOV?(var5 == 0.0F?var3 + var2.func_74805_b("options.fov.min"):(var5 == 1.0F?var3 + var2.func_74805_b("options.fov.max"):var3 + (int)(70.0F + var5 * 40.0F))):(p_74297_1_ == EnumOptions.GAMMA?(var5 == 0.0F?var3 + var2.func_74805_b("options.gamma.min"):(var5 == 1.0F?var3 + var2.func_74805_b("options.gamma.max"):var3 + "+" + (int)(var5 * 100.0F) + "%")):(p_74297_1_ == EnumOptions.CHAT_OPACITY?var3 + (int)(var5 * 90.0F + 10.0F) + "%":(p_74297_1_ == EnumOptions.CHAT_HEIGHT_UNFOCUSED?var3 + GuiNewChat.func_96130_b(var5) + "px":(p_74297_1_ == EnumOptions.CHAT_HEIGHT_FOCUSED?var3 + GuiNewChat.func_96130_b(var5) + "px":(p_74297_1_ == EnumOptions.CHAT_WIDTH?var3 + GuiNewChat.func_96128_a(var5) + "px":(var5 == 0.0F?var3 + var2.func_74805_b("options.off"):var3 + (int)(var5 * 100.0F) + "%")))))));
      } else if(p_74297_1_.func_74382_b()) {
         boolean var4 = this.func_74308_b(p_74297_1_);
         return var4?var3 + var2.func_74805_b("options.on"):var3 + var2.func_74805_b("options.off");
      } else {
         return p_74297_1_ == EnumOptions.RENDER_DISTANCE?var3 + func_74299_a(field_74360_ac, this.field_74339_e):(p_74297_1_ == EnumOptions.DIFFICULTY?var3 + func_74299_a(field_74361_ad, this.field_74318_M):(p_74297_1_ == EnumOptions.GUI_SCALE?var3 + func_74299_a(field_74367_ae, this.field_74335_Z):(p_74297_1_ == EnumOptions.CHAT_VISIBILITY?var3 + func_74299_a(field_74369_af, this.field_74343_n):(p_74297_1_ == EnumOptions.PARTICLES?var3 + func_74299_a(field_74364_ag, this.field_74362_aa):(p_74297_1_ == EnumOptions.FRAMERATE_LIMIT?var3 + func_74299_a(field_74365_ah, this.field_74350_i):(p_74297_1_ == EnumOptions.AMBIENT_OCCLUSION?var3 + func_74299_a(field_98303_au, this.field_74348_k):(p_74297_1_ == EnumOptions.GRAPHICS?(this.field_74347_j?var3 + var2.func_74805_b("options.graphics.fancy"):var3 + var2.func_74805_b("options.graphics.fast")):var3)))))));
      }
   }

   public void func_74300_a() {
      try {
         if(!this.field_74354_ai.exists()) {
            return;
         }

         BufferedReader var1 = new BufferedReader(new FileReader(this.field_74354_ai));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            try {
               String[] var3 = var2.split(":");
               if(var3[0].equals("music")) {
                  this.field_74342_a = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("sound")) {
                  this.field_74340_b = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("mouseSensitivity")) {
                  this.field_74341_c = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("fov")) {
                  this.field_74334_X = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("gamma")) {
                  this.field_74333_Y = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("invertYMouse")) {
                  this.field_74338_d = var3[1].equals("true");
               }

               if(var3[0].equals("viewDistance")) {
                  this.field_74339_e = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("guiScale")) {
                  this.field_74335_Z = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("particles")) {
                  this.field_74362_aa = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("bobView")) {
                  this.field_74336_f = var3[1].equals("true");
               }

               if(var3[0].equals("anaglyph3d")) {
                  this.field_74337_g = var3[1].equals("true");
               }

               if(var3[0].equals("advancedOpengl")) {
                  this.field_74349_h = var3[1].equals("true");
               }

               if(var3[0].equals("fpsLimit")) {
                  this.field_74350_i = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("difficulty")) {
                  this.field_74318_M = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("fancyGraphics")) {
                  this.field_74347_j = var3[1].equals("true");
               }

               if(var3[0].equals("ao")) {
                  if(var3[1].equals("true")) {
                     this.field_74348_k = 2;
                  } else if(var3[1].equals("false")) {
                     this.field_74348_k = 0;
                  } else {
                     this.field_74348_k = Integer.parseInt(var3[1]);
                  }
               }

               if(var3[0].equals("clouds")) {
                  this.field_74345_l = var3[1].equals("true");
               }

               if(var3[0].equals("skin")) {
                  this.field_74346_m = var3[1];
               }

               if(var3[0].equals("lastServer") && var3.length >= 2) {
                  this.field_74332_R = var3[1];
               }

               if(var3[0].equals("lang") && var3.length >= 2) {
                  this.field_74363_ab = var3[1];
               }

               if(var3[0].equals("chatVisibility")) {
                  this.field_74343_n = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("chatColors")) {
                  this.field_74344_o = var3[1].equals("true");
               }

               if(var3[0].equals("chatLinks")) {
                  this.field_74359_p = var3[1].equals("true");
               }

               if(var3[0].equals("chatLinksPrompt")) {
                  this.field_74358_q = var3[1].equals("true");
               }

               if(var3[0].equals("chatOpacity")) {
                  this.field_74357_r = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("serverTextures")) {
                  this.field_74356_s = var3[1].equals("true");
               }

               if(var3[0].equals("snooperEnabled")) {
                  this.field_74355_t = var3[1].equals("true");
               }

               if(var3[0].equals("fullscreen")) {
                  this.field_74353_u = var3[1].equals("true");
               }

               if(var3[0].equals("enableVsync")) {
                  this.field_74352_v = var3[1].equals("true");
               }

               if(var3[0].equals("hideServerAddress")) {
                  this.field_80005_w = var3[1].equals("true");
               }

               if(var3[0].equals("advancedItemTooltips")) {
                  this.field_82882_x = var3[1].equals("true");
               }

               if(var3[0].equals("pauseOnLostFocus")) {
                  this.field_82881_y = var3[1].equals("true");
               }

               if(var3[0].equals("showCape")) {
                  this.field_82880_z = var3[1].equals("true");
               }

               if(var3[0].equals("touchscreen")) {
                  this.field_85185_A = var3[1].equals("true");
               }

               if(var3[0].equals("overrideHeight")) {
                  this.field_92119_C = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("overrideWidth")) {
                  this.field_92118_B = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("heldItemTooltips")) {
                  this.field_92117_D = var3[1].equals("true");
               }

               if(var3[0].equals("chatHeightFocused")) {
                  this.field_96694_H = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatHeightUnfocused")) {
                  this.field_96693_G = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatScale")) {
                  this.field_96691_E = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatWidth")) {
                  this.field_96692_F = this.func_74305_a(var3[1]);
               }

               for(int var4 = 0; var4 < this.field_74324_K.length; ++var4) {
                  if(var3[0].equals("key_" + this.field_74324_K[var4].field_74515_c)) {
                     this.field_74324_K[var4].field_74512_d = Integer.parseInt(var3[1]);
                  }
               }
            } catch (Exception var5) {
               this.field_74317_L.func_98033_al().func_98236_b("Skipping bad option: " + var2);
            }
         }

         KeyBinding.func_74508_b();
         var1.close();
      } catch (Exception var6) {
         this.field_74317_L.func_98033_al().func_98236_b("Failed to load options");
         var6.printStackTrace();
      }

   }

   private float func_74305_a(String p_74305_1_) {
      return p_74305_1_.equals("true")?1.0F:(p_74305_1_.equals("false")?0.0F:Float.parseFloat(p_74305_1_));
   }

   public void func_74303_b() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.field_74354_ai));
         var1.println("music:" + this.field_74342_a);
         var1.println("sound:" + this.field_74340_b);
         var1.println("invertYMouse:" + this.field_74338_d);
         var1.println("mouseSensitivity:" + this.field_74341_c);
         var1.println("fov:" + this.field_74334_X);
         var1.println("gamma:" + this.field_74333_Y);
         var1.println("viewDistance:" + this.field_74339_e);
         var1.println("guiScale:" + this.field_74335_Z);
         var1.println("particles:" + this.field_74362_aa);
         var1.println("bobView:" + this.field_74336_f);
         var1.println("anaglyph3d:" + this.field_74337_g);
         var1.println("advancedOpengl:" + this.field_74349_h);
         var1.println("fpsLimit:" + this.field_74350_i);
         var1.println("difficulty:" + this.field_74318_M);
         var1.println("fancyGraphics:" + this.field_74347_j);
         var1.println("ao:" + this.field_74348_k);
         var1.println("clouds:" + this.field_74345_l);
         var1.println("skin:" + this.field_74346_m);
         var1.println("lastServer:" + this.field_74332_R);
         var1.println("lang:" + this.field_74363_ab);
         var1.println("chatVisibility:" + this.field_74343_n);
         var1.println("chatColors:" + this.field_74344_o);
         var1.println("chatLinks:" + this.field_74359_p);
         var1.println("chatLinksPrompt:" + this.field_74358_q);
         var1.println("chatOpacity:" + this.field_74357_r);
         var1.println("serverTextures:" + this.field_74356_s);
         var1.println("snooperEnabled:" + this.field_74355_t);
         var1.println("fullscreen:" + this.field_74353_u);
         var1.println("enableVsync:" + this.field_74352_v);
         var1.println("hideServerAddress:" + this.field_80005_w);
         var1.println("advancedItemTooltips:" + this.field_82882_x);
         var1.println("pauseOnLostFocus:" + this.field_82881_y);
         var1.println("showCape:" + this.field_82880_z);
         var1.println("touchscreen:" + this.field_85185_A);
         var1.println("overrideWidth:" + this.field_92118_B);
         var1.println("overrideHeight:" + this.field_92119_C);
         var1.println("heldItemTooltips:" + this.field_92117_D);
         var1.println("chatHeightFocused:" + this.field_96694_H);
         var1.println("chatHeightUnfocused:" + this.field_96693_G);
         var1.println("chatScale:" + this.field_96691_E);
         var1.println("chatWidth:" + this.field_96692_F);

         for(int var2 = 0; var2 < this.field_74324_K.length; ++var2) {
            var1.println("key_" + this.field_74324_K[var2].field_74515_c + ":" + this.field_74324_K[var2].field_74512_d);
         }

         var1.close();
      } catch (Exception var3) {
         this.field_74317_L.func_98033_al().func_98236_b("Failed to save options");
         var3.printStackTrace();
      }

      this.func_82879_c();
   }

   public void func_82879_c() {
      if(this.field_74317_L.field_71439_g != null) {
         this.field_74317_L.field_71439_g.field_71174_a.func_72552_c(new Packet204ClientInfo(this.field_74363_ab, this.field_74339_e, this.field_74343_n, this.field_74344_o, this.field_74318_M, this.field_82880_z));
      }

   }

   public boolean func_74309_c() {
      return this.field_74339_e < 2 && this.field_74345_l;
   }

}
