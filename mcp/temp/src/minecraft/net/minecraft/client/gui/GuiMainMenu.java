package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOnlineServers;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.ThreadTitleScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

@SideOnly(Side.CLIENT)
public class GuiMainMenu extends GuiScreen {

   private static final Random field_73976_a = new Random();
   private float field_73974_b = 0.0F;
   private String field_73975_c = "missingno";
   private GuiButton field_73973_d;
   private int field_73979_m = 0;
   private int field_73977_n;
   private boolean field_96141_q = true;
   private static boolean field_96140_r = false;
   private static boolean field_96139_s = false;
   private String field_92025_p;
   private static final String[] field_73978_o = new String[]{"/title/bg/panorama0.png", "/title/bg/panorama1.png", "/title/bg/panorama2.png", "/title/bg/panorama3.png", "/title/bg/panorama4.png", "/title/bg/panorama5.png"};
   public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
   private int field_92024_r;
   private int field_92023_s;
   private int field_92022_t;
   private int field_92021_u;
   private int field_92020_v;
   private int field_92019_w;


   public GuiMainMenu() {
      BufferedReader var1 = null;

      try {
         ArrayList var2 = new ArrayList();
         var1 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));

         String var3;
         while((var3 = var1.readLine()) != null) {
            var3 = var3.trim();
            if(var3.length() > 0) {
               var2.add(var3);
            }
         }

         do {
            this.field_73975_c = (String)var2.get(field_73976_a.nextInt(var2.size()));
         } while(this.field_73975_c.hashCode() == 125780783);
      } catch (IOException var12) {
         ;
      } finally {
         if(var1 != null) {
            try {
               var1.close();
            } catch (IOException var11) {
               ;
            }
         }

      }

      this.field_73974_b = field_73976_a.nextFloat();
   }

   public void func_73876_c() {
      ++this.field_73979_m;
   }

   public boolean func_73868_f() {
      return false;
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   public void func_73866_w_() {
      this.field_73977_n = this.field_73882_e.field_71446_o.func_78353_a(new BufferedImage(256, 256, 2));
      Calendar var1 = Calendar.getInstance();
      var1.setTime(new Date());
      if(var1.get(2) + 1 == 11 && var1.get(5) == 9) {
         this.field_73975_c = "Happy birthday, ez!";
      } else if(var1.get(2) + 1 == 6 && var1.get(5) == 1) {
         this.field_73975_c = "Happy birthday, Notch!";
      } else if(var1.get(2) + 1 == 12 && var1.get(5) == 24) {
         this.field_73975_c = "Merry X-mas!";
      } else if(var1.get(2) + 1 == 1 && var1.get(5) == 1) {
         this.field_73975_c = "Happy new year!";
      } else if(var1.get(2) + 1 == 10 && var1.get(5) == 31) {
         this.field_73975_c = "OOoooOOOoooo! Spooky!";
      }

      StringTranslate var2 = StringTranslate.func_74808_a();
      int var4 = this.field_73881_g / 4 + 48;
      if(this.field_73882_e.func_71355_q()) {
         this.func_73972_b(var4, 24, var2);
      } else {
         this.func_73969_a(var4, 24, var2);
      }

      this.func_96137_a(var2, var4, 24);
      if(this.field_73882_e.field_71448_m) {
         this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, var4 + 72, var2.func_74805_b("menu.options")));
      } else {
         this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, var4 + 72 + 12, 98, 20, var2.func_74805_b("menu.options")));
         this.field_73887_h.add(new GuiButton(4, this.field_73880_f / 2 + 2, var4 + 72 + 12, 98, 20, var2.func_74805_b("menu.quit")));
      }

      this.field_73887_h.add(new GuiButtonLanguage(5, this.field_73880_f / 2 - 124, var4 + 72 + 12));
      this.field_92025_p = "";
      String var5 = System.getProperty("os_architecture");
      String var6 = System.getProperty("java_version");
      if("ppc".equalsIgnoreCase(var5)) {
         this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " PowerPC compatibility will be dropped in Minecraft 1.6";
      } else if(var6 != null && var6.startsWith("1.5")) {
         this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
      }

      this.field_92023_s = this.field_73886_k.func_78256_a(this.field_92025_p);
      this.field_92024_r = this.field_73886_k.func_78256_a(field_96138_a);
      int var7 = Math.max(this.field_92023_s, this.field_92024_r);
      this.field_92022_t = (this.field_73880_f - var7) / 2;
      this.field_92021_u = ((GuiButton)this.field_73887_h.get(0)).field_73743_d - 24;
      this.field_92020_v = this.field_92022_t + var7;
      this.field_92019_w = this.field_92021_u + 24;
   }

   private void func_96137_a(StringTranslate p_96137_1_, int p_96137_2_, int p_96137_3_) {
      if(this.field_96141_q) {
         if(!field_96140_r) {
            field_96140_r = true;
            (new ThreadTitleScreen(this, p_96137_1_, p_96137_2_, p_96137_3_)).start();
         } else if(field_96139_s) {
            this.func_98060_b(p_96137_1_, p_96137_2_, p_96137_3_);
         }
      }

   }

   private void func_98060_b(StringTranslate p_98060_1_, int p_98060_2_, int p_98060_3_) {
      this.field_73887_h.add(new GuiButton(3, this.field_73880_f / 2 - 100, p_98060_2_ + p_98060_3_ * 2, p_98060_1_.func_74805_b("menu.online")));
   }

   private void func_73969_a(int p_73969_1_, int p_73969_2_, StringTranslate p_73969_3_) {
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, p_73969_1_, p_73969_3_.func_74805_b("menu.singleplayer")));
      this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 - 100, p_73969_1_ + p_73969_2_ * 1, p_73969_3_.func_74805_b("menu.multiplayer")));
   }

   private void func_73972_b(int p_73972_1_, int p_73972_2_, StringTranslate p_73972_3_) {
      this.field_73887_h.add(new GuiButton(11, this.field_73880_f / 2 - 100, p_73972_1_, p_73972_3_.func_74805_b("menu.playdemo")));
      this.field_73887_h.add(this.field_73973_d = new GuiButton(12, this.field_73880_f / 2 - 100, p_73972_1_ + p_73972_2_ * 1, p_73972_3_.func_74805_b("menu.resetdemo")));
      ISaveFormat var4 = this.field_73882_e.func_71359_d();
      WorldInfo var5 = var4.func_75803_c("Demo_World");
      if(var5 == null) {
         this.field_73973_d.field_73742_g = false;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0) {
         this.field_73882_e.func_71373_a(new GuiOptions(this, this.field_73882_e.field_71474_y));
      }

      if(p_73875_1_.field_73741_f == 5) {
         this.field_73882_e.func_71373_a(new GuiLanguage(this, this.field_73882_e.field_71474_y));
      }

      if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71373_a(new GuiSelectWorld(this));
      }

      if(p_73875_1_.field_73741_f == 2) {
         this.field_73882_e.func_71373_a(new GuiMultiplayer(this));
      }

      if(p_73875_1_.field_73741_f == 3) {
         this.field_73882_e.func_71373_a(new GuiScreenOnlineServers(this));
      }

      if(p_73875_1_.field_73741_f == 4) {
         this.field_73882_e.func_71400_g();
      }

      if(p_73875_1_.field_73741_f == 11) {
         this.field_73882_e.func_71371_a("Demo_World", "Demo_World", DemoWorldServer.field_73071_a);
      }

      if(p_73875_1_.field_73741_f == 12) {
         ISaveFormat var2 = this.field_73882_e.func_71359_d();
         WorldInfo var3 = var2.func_75803_c("Demo_World");
         if(var3 != null) {
            GuiYesNo var4 = GuiSelectWorld.func_74061_a(this, var3.func_76065_j(), 12);
            this.field_73882_e.func_71373_a(var4);
         }
      }

   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(p_73878_1_ && p_73878_2_ == 12) {
         ISaveFormat var6 = this.field_73882_e.func_71359_d();
         var6.func_75800_d();
         var6.func_75802_e("Demo_World");
         this.field_73882_e.func_71373_a(this);
      } else if(p_73878_2_ == 13) {
         if(p_73878_1_) {
            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
               var3.getMethod("browse", new Class[]{URI.class}).invoke(var4, new Object[]{new URI("http://tinyurl.com/javappc")});
            } catch (Throwable var5) {
               var5.printStackTrace();
            }
         }

         this.field_73882_e.func_71373_a(this);
      }

   }

   private void func_73970_b(int p_73970_1_, int p_73970_2_, float p_73970_3_) {
      Tessellator var4 = Tessellator.field_78398_a;
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GLU.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GL11.glMatrixMode(5888);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      GL11.glEnable(3042);
      GL11.glDisable(3008);
      GL11.glDisable(2884);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      byte var5 = 8;

      for(int var6 = 0; var6 < var5 * var5; ++var6) {
         GL11.glPushMatrix();
         float var7 = ((float)(var6 % var5) / (float)var5 - 0.5F) / 64.0F;
         float var8 = ((float)(var6 / var5) / (float)var5 - 0.5F) / 64.0F;
         float var9 = 0.0F;
         GL11.glTranslatef(var7, var8, var9);
         GL11.glRotatef(MathHelper.func_76126_a(((float)this.field_73979_m + p_73970_3_) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-((float)this.field_73979_m + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int var10 = 0; var10 < 6; ++var10) {
            GL11.glPushMatrix();
            if(var10 == 1) {
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 3) {
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 4) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var10 == 5) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            this.field_73882_e.field_71446_o.func_98187_b(field_73978_o[var10]);
            var4.func_78382_b();
            var4.func_78384_a(16777215, 255 / (var6 + 1));
            float var11 = 0.0F;
            var4.func_78374_a(-1.0D, -1.0D, 1.0D, (double)(0.0F + var11), (double)(0.0F + var11));
            var4.func_78374_a(1.0D, -1.0D, 1.0D, (double)(1.0F - var11), (double)(0.0F + var11));
            var4.func_78374_a(1.0D, 1.0D, 1.0D, (double)(1.0F - var11), (double)(1.0F - var11));
            var4.func_78374_a(-1.0D, 1.0D, 1.0D, (double)(0.0F + var11), (double)(1.0F - var11));
            var4.func_78381_a();
            GL11.glPopMatrix();
         }

         GL11.glPopMatrix();
         GL11.glColorMask(true, true, true, false);
      }

      var4.func_78373_b(0.0D, 0.0D, 0.0D);
      GL11.glColorMask(true, true, true, true);
      GL11.glMatrixMode(5889);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glEnable(2884);
      GL11.glEnable(3008);
      GL11.glEnable(2929);
   }

   private void func_73968_a(float p_73968_1_) {
      GL11.glBindTexture(3553, this.field_73977_n);
      this.field_73882_e.field_71446_o.func_98185_a();
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColorMask(true, true, true, false);
      Tessellator var2 = Tessellator.field_78398_a;
      var2.func_78382_b();
      byte var3 = 3;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F / (float)(var4 + 1));
         int var5 = this.field_73880_f;
         int var6 = this.field_73881_g;
         float var7 = (float)(var4 - var3 / 2) / 256.0F;
         var2.func_78374_a((double)var5, (double)var6, (double)this.field_73735_i, (double)(0.0F + var7), 0.0D);
         var2.func_78374_a((double)var5, 0.0D, (double)this.field_73735_i, (double)(1.0F + var7), 0.0D);
         var2.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, (double)(1.0F + var7), 1.0D);
         var2.func_78374_a(0.0D, (double)var6, (double)this.field_73735_i, (double)(0.0F + var7), 1.0D);
      }

      var2.func_78381_a();
      GL11.glColorMask(true, true, true, true);
      this.field_73882_e.field_71446_o.func_98185_a();
   }

   private void func_73971_c(int p_73971_1_, int p_73971_2_, float p_73971_3_) {
      GL11.glViewport(0, 0, 256, 256);
      this.func_73970_b(p_73971_1_, p_73971_2_, p_73971_3_);
      GL11.glDisable(3553);
      GL11.glEnable(3553);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      this.func_73968_a(p_73971_3_);
      GL11.glViewport(0, 0, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
      Tessellator var4 = Tessellator.field_78398_a;
      var4.func_78382_b();
      float var5 = this.field_73880_f > this.field_73881_g?120.0F / (float)this.field_73880_f:120.0F / (float)this.field_73881_g;
      float var6 = (float)this.field_73881_g * var5 / 256.0F;
      float var7 = (float)this.field_73880_f * var5 / 256.0F;
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      var4.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
      int var8 = this.field_73880_f;
      int var9 = this.field_73881_g;
      var4.func_78374_a(0.0D, (double)var9, (double)this.field_73735_i, (double)(0.5F - var6), (double)(0.5F + var7));
      var4.func_78374_a((double)var8, (double)var9, (double)this.field_73735_i, (double)(0.5F - var6), (double)(0.5F - var7));
      var4.func_78374_a((double)var8, 0.0D, (double)this.field_73735_i, (double)(0.5F + var6), (double)(0.5F - var7));
      var4.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, (double)(0.5F + var6), (double)(0.5F + var7));
      var4.func_78381_a();
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73971_c(p_73863_1_, p_73863_2_, p_73863_3_);
      Tessellator var4 = Tessellator.field_78398_a;
      short var5 = 274;
      int var6 = this.field_73880_f / 2 - var5 / 2;
      byte var7 = 30;
      this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -2130706433, 16777215);
      this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 0, Integer.MIN_VALUE);
      this.field_73882_e.field_71446_o.func_98187_b("/title/mclogo.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if((double)this.field_73974_b < 1.0E-4D) {
         this.func_73729_b(var6 + 0, var7 + 0, 0, 0, 99, 44);
         this.func_73729_b(var6 + 99, var7 + 0, 129, 0, 27, 44);
         this.func_73729_b(var6 + 99 + 26, var7 + 0, 126, 0, 3, 44);
         this.func_73729_b(var6 + 99 + 26 + 3, var7 + 0, 99, 0, 26, 44);
         this.func_73729_b(var6 + 155, var7 + 0, 0, 45, 155, 44);
      } else {
         this.func_73729_b(var6 + 0, var7 + 0, 0, 0, 155, 44);
         this.func_73729_b(var6 + 155, var7 + 0, 0, 45, 155, 44);
      }

      var4.func_78378_d(16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(this.field_73880_f / 2 + 90), 70.0F, 0.0F);
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      float var8 = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a((float)(Minecraft.func_71386_F() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
      var8 = var8 * 100.0F / (float)(this.field_73886_k.func_78256_a(this.field_73975_c) + 32);
      GL11.glScalef(var8, var8, var8);
      this.func_73732_a(this.field_73886_k, this.field_73975_c, 0, -8, 16776960);
      GL11.glPopMatrix();
      String var9 = "Minecraft 1.5.1";
      if(this.field_73882_e.func_71355_q()) {
         var9 = var9 + " Demo";
      }

      this.func_73731_b(this.field_73886_k, var9, 2, this.field_73881_g - 10, 16777215);
      String var10 = "Copyright Mojang AB. Do not distribute!";
      this.func_73731_b(this.field_73886_k, var10, this.field_73880_f - this.field_73886_k.func_78256_a(var10) - 2, this.field_73881_g - 10, 16777215);
      if(this.field_92025_p != null && this.field_92025_p.length() > 0) {
         func_73734_a(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
         this.func_73731_b(this.field_73886_k, this.field_92025_p, this.field_92022_t, this.field_92021_u, 16777215);
         this.func_73731_b(this.field_73886_k, field_96138_a, (this.field_73880_f - this.field_92024_r) / 2, ((GuiButton)this.field_73887_h.get(0)).field_73743_d - 12, 16777215);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      if(this.field_92025_p.length() > 0 && p_73864_1_ >= this.field_92022_t && p_73864_1_ <= this.field_92020_v && p_73864_2_ >= this.field_92021_u && p_73864_2_ <= this.field_92019_w) {
         GuiConfirmOpenLink var4 = new GuiConfirmOpenLink(this, "http://tinyurl.com/javappc", 13);
         var4.func_92026_h();
         this.field_73882_e.func_71373_a(var4);
      }

   }

   // $FF: synthetic method
   static Minecraft func_98058_a(GuiMainMenu p_98058_0_) {
      return p_98058_0_.field_73882_e;
   }

   // $FF: synthetic method
   static void func_98061_a(GuiMainMenu p_98061_0_, StringTranslate p_98061_1_, int p_98061_2_, int p_98061_3_) {
      p_98061_0_.func_98060_b(p_98061_1_, p_98061_2_, p_98061_3_);
   }

   // $FF: synthetic method
   static boolean func_98059_a(boolean p_98059_0_) {
      field_96139_s = p_98059_0_;
      return p_98059_0_;
   }

}
