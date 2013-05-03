package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfigureWorld;
import net.minecraft.client.gui.GuiScreenCreateOnlineWorld;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.GuiSlotOnlineServerList;
import net.minecraft.client.gui.TaskOnlineConnect;
import net.minecraft.client.gui.ThreadOnlineScreen;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerList;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenOnlineServers extends GuiScreen {

   private GuiScreen field_96188_a;
   private GuiSlotOnlineServerList field_96186_b;
   private static int field_96187_c = 0;
   private static final Object field_96185_d = new Object();
   private int field_96189_n = -1;
   private GuiButton field_96190_o;
   private GuiButton field_96198_p;
   private GuiButtonLink field_96197_q;
   private GuiButton field_96196_r;
   private String field_96195_s = null;
   private McoServerList field_96194_t;
   private boolean field_96193_u;
   private List field_96192_v = Collections.emptyList();
   private String field_96191_w = "http://realms.minecraft.net/";
   private volatile int field_96199_x;
   private Long field_102019_y;


   public GuiScreenOnlineServers(GuiScreen p_i10007_1_) {
      this.field_96188_a = p_i10007_1_;
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_96194_t = new McoServerList(this.field_73882_e.field_71449_j);
      if(!this.field_96193_u) {
         this.field_96193_u = true;
         this.field_96186_b = new GuiSlotOnlineServerList(this);
      } else {
         this.field_96186_b.func_77207_a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
      }

      (new ThreadOnlineScreen(this)).start();
      this.func_96178_g();
   }

   public void func_96178_g() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(this.field_96196_r = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, var1.func_74805_b("mco.selectServer.select")));
      this.field_73887_h.add(this.field_96198_p = new GuiButton(2, this.field_73880_f / 2 - 48, this.field_73881_g - 52, 100, 20, var1.func_74805_b("mco.selectServer.create")));
      this.field_73887_h.add(this.field_96190_o = new GuiButton(3, this.field_73880_f / 2 + 58, this.field_73881_g - 52, 100, 20, var1.func_74805_b("mco.selectServer.configure")));
      this.field_73887_h.add(this.field_96197_q = new GuiButtonLink(4, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 154, 20, var1.func_74805_b("mco.selectServer.moreinfo")));
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 6, this.field_73881_g - 28, 153, 20, var1.func_74805_b("gui.cancel")));
      boolean var2 = this.field_96189_n >= 0 && this.field_96189_n < this.field_96186_b.func_77217_a();
      this.field_96196_r.field_73742_g = var2 && ((McoServer)this.field_96192_v.get(this.field_96189_n)).field_96404_d.equals("OPEN") && !((McoServer)this.field_96192_v.get(this.field_96189_n)).field_98166_h;
      this.field_96190_o.field_73742_g = var2 && this.field_73882_e.field_71449_j.field_74286_b.equals(((McoServer)this.field_96192_v.get(this.field_96189_n)).field_96405_e);
      this.field_96198_p.field_73742_g = this.field_96199_x > 0;
   }

   public void func_73876_c() {
      super.func_73876_c();
      if(this.field_96194_t.func_98251_a()) {
         List var1 = this.field_96194_t.func_98252_c();
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            McoServer var3 = (McoServer)var2.next();
            Iterator var4 = this.field_96192_v.iterator();

            while(var4.hasNext()) {
               McoServer var5 = (McoServer)var4.next();
               if(var3.field_96408_a == var5.field_96408_a) {
                  var3.func_96401_a(var5);
                  if(this.field_102019_y != null && this.field_102019_y.longValue() == var3.field_96408_a) {
                     this.field_102019_y = null;
                     var3.field_96411_l = false;
                  }
                  break;
               }
            }
         }

         this.field_96192_v = var1;
         this.field_96194_t.func_98250_b();
      }

      this.field_96198_p.field_73742_g = this.field_96199_x > 0;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.func_96159_a(this.field_96189_n);
         } else if(p_73875_1_.field_73741_f == 3) {
            McoServer var2 = (McoServer)this.field_96194_t.func_98252_c().get(this.field_96189_n);
            McoServer var3 = this.func_98086_a(var2.field_96408_a);
            if(var3 != null) {
               this.field_96194_t.func_98248_d();
               this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this, var3));
            }
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_96194_t.func_98248_d();
            this.field_73882_e.func_71373_a(this.field_96188_a);
         } else if(p_73875_1_.field_73741_f == 2) {
            this.field_96194_t.func_98248_d();
            this.field_73882_e.func_71373_a(new GuiScreenCreateOnlineWorld(this));
         } else if(p_73875_1_.field_73741_f == 4) {
            this.field_96197_q.func_96135_a(this.field_96191_w);
         } else {
            this.field_96186_b.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_102018_a(long p_102018_1_) {
      this.field_96189_n = -1;
      this.field_102019_y = Long.valueOf(p_102018_1_);
   }

   private McoServer func_98086_a(long p_98086_1_) {
      McoClient var3 = new McoClient(this.field_73882_e.field_71449_j);

      try {
         return var3.func_98176_a(p_98086_1_);
      } catch (ExceptionMcoService var5) {
         ;
      } catch (IOException var6) {
         ;
      }

      return null;
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 59) {
         this.field_73882_e.field_71474_y.field_80005_w = !this.field_73882_e.field_71474_y.field_80005_w;
         this.field_73882_e.field_71474_y.func_74303_b();
      } else {
         if(p_73869_1_ == 13) {
            this.func_73875_a((GuiButton)this.field_73887_h.get(2));
         } else {
            super.func_73869_a(p_73869_1_, p_73869_2_);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_96195_s = null;
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.field_96186_b.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.title"), this.field_73880_f / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_96195_s != null) {
         this.func_96165_a(this.field_96195_s, p_73863_1_, p_73863_2_);
      }

   }

   private void func_96159_a(int p_96159_1_) {
      if(p_96159_1_ >= 0 && p_96159_1_ < this.field_96192_v.size()) {
         McoServer var2 = (McoServer)this.field_96192_v.get(p_96159_1_);
         this.field_96194_t.func_98248_d();
         GuiScreenLongRunningTask var3 = new GuiScreenLongRunningTask(this.field_73882_e, this, new TaskOnlineConnect(this, var2));
         var3.func_98117_g();
         this.field_73882_e.func_71373_a(var3);
      }

   }

   private void func_101008_c(int p_101008_1_, int p_101008_2_, int p_101008_3_, int p_101008_4_) {
      this.field_73882_e.field_71446_o.func_98187_b("/gui/gui.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.func_73729_b(p_101008_1_ * 2, p_101008_2_ * 2, 191, 0, 16, 15);
      GL11.glPopMatrix();
      if(p_101008_3_ >= p_101008_1_ && p_101008_3_ <= p_101008_1_ + 9 && p_101008_4_ >= p_101008_2_ && p_101008_4_ <= p_101008_2_ + 9) {
         this.field_96195_s = "Expired World";
      }

   }

   private void func_101006_d(int p_101006_1_, int p_101006_2_, int p_101006_3_, int p_101006_4_) {
      this.field_73882_e.field_71446_o.func_98187_b("/gui/gui.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.func_73729_b(p_101006_1_ * 2, p_101006_2_ * 2, 207, 0, 16, 15);
      GL11.glPopMatrix();
      if(p_101006_3_ >= p_101006_1_ && p_101006_3_ <= p_101006_1_ + 9 && p_101006_4_ >= p_101006_2_ && p_101006_4_ <= p_101006_2_ + 9) {
         this.field_96195_s = "Open World";
      }

   }

   private void func_101001_e(int p_101001_1_, int p_101001_2_, int p_101001_3_, int p_101001_4_) {
      this.field_73882_e.field_71446_o.func_98187_b("/gui/gui.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.func_73729_b(p_101001_1_ * 2, p_101001_2_ * 2, 223, 0, 16, 15);
      GL11.glPopMatrix();
      if(p_101001_3_ >= p_101001_1_ && p_101001_3_ <= p_101001_1_ + 9 && p_101001_4_ >= p_101001_2_ && p_101001_4_ <= p_101001_2_ + 9) {
         this.field_96195_s = "Closed World";
      }

   }

   protected void func_96165_a(String p_96165_1_, int p_96165_2_, int p_96165_3_) {
      if(p_96165_1_ != null) {
         int var4 = p_96165_2_ + 12;
         int var5 = p_96165_3_ - 12;
         int var6 = this.field_73886_k.func_78256_a(p_96165_1_);
         this.func_73733_a(var4 - 3, var5 - 3, var4 + var6 + 3, var5 + 8 + 3, -1073741824, -1073741824);
         this.field_73886_k.func_78261_a(p_96165_1_, var4, var5, -1);
      }
   }

   private void func_96174_a(McoServer p_96174_1_) throws IOException {
      ServerAddress var2 = ServerAddress.func_78860_a(p_96174_1_.field_96403_g);
      Socket var3 = null;
      DataInputStream var4 = null;
      DataOutputStream var5 = null;

      try {
         var3 = new Socket();
         var3.setSoTimeout(3000);
         var3.setTcpNoDelay(true);
         var3.setTrafficClass(18);
         var3.connect(new InetSocketAddress(var2.func_78861_a(), var2.func_78864_b()), 3000);
         var4 = new DataInputStream(var3.getInputStream());
         var5 = new DataOutputStream(var3.getOutputStream());
         var5.write(254);
         var5.write(1);
         if(var4.read() != 255) {
            throw new IOException("Bad message");
         }

         String var6 = Packet.func_73282_a(var4, 256);
         char[] var7 = var6.toCharArray();

         for(int var8 = 0; var8 < var7.length; ++var8) {
            if(var7[var8] != 167 && var7[var8] != 0 && ChatAllowedCharacters.field_71568_a.indexOf(var7[var8]) < 0) {
               var7[var8] = 63;
            }
         }

         var6 = new String(var7);
         int var9;
         int var10;
         String[] var27;
         if(var6.startsWith("\u00a7") && var6.length() > 1) {
            var27 = var6.substring(1).split("\u0000");
            if(MathHelper.func_82715_a(var27[0], 0) == 1) {
               p_96174_1_.field_96415_h = MathHelper.func_82715_a(var27[1], p_96174_1_.field_96415_h);
               p_96174_1_.field_96413_j = var27[2];
               var9 = MathHelper.func_82715_a(var27[4], 0);
               var10 = MathHelper.func_82715_a(var27[5], 0);
               if(var9 >= 0 && var10 >= 0) {
                  p_96174_1_.field_96414_k = EnumChatFormatting.GRAY + "" + var9;
               } else {
                  p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
               }
            } else {
               p_96174_1_.field_96413_j = "???";
               p_96174_1_.field_96415_h = 61;
               p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
            }
         } else {
            var27 = var6.split("\u00a7");
            var6 = var27[0];
            var9 = -1;
            var10 = -1;

            try {
               var9 = Integer.parseInt(var27[1]);
               var10 = Integer.parseInt(var27[2]);
            } catch (Exception var25) {
               ;
            }

            p_96174_1_.field_96407_c = EnumChatFormatting.GRAY + var6;
            if(var9 >= 0 && var10 > 0) {
               p_96174_1_.field_96414_k = EnumChatFormatting.GRAY + "" + var9;
            } else {
               p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
            }

            p_96174_1_.field_96413_j = "1.3";
            p_96174_1_.field_96415_h = 59;
         }
      } finally {
         try {
            if(var4 != null) {
               var4.close();
            }
         } catch (Throwable var24) {
            ;
         }

         try {
            if(var5 != null) {
               var5.close();
            }
         } catch (Throwable var23) {
            ;
         }

         try {
            if(var3 != null) {
               var3.close();
            }
         } catch (Throwable var22) {
            ;
         }

      }

   }

   // $FF: synthetic method
   static Minecraft func_96177_a(GuiScreenOnlineServers p_96177_0_) {
      return p_96177_0_.field_73882_e;
   }

   // $FF: synthetic method
   static int func_98081_a(GuiScreenOnlineServers p_98081_0_, int p_98081_1_) {
      return p_98081_0_.field_96199_x = p_98081_1_;
   }

   // $FF: synthetic method
   static Minecraft func_98075_b(GuiScreenOnlineServers p_98075_0_) {
      return p_98075_0_.field_73882_e;
   }

   // $FF: synthetic method
   static List func_98094_c(GuiScreenOnlineServers p_98094_0_) {
      return p_98094_0_.field_96192_v;
   }

   // $FF: synthetic method
   static int func_98089_b(GuiScreenOnlineServers p_98089_0_, int p_98089_1_) {
      return p_98089_0_.field_96189_n = p_98089_1_;
   }

   // $FF: synthetic method
   static int func_98072_d(GuiScreenOnlineServers p_98072_0_) {
      return p_98072_0_.field_96189_n;
   }

   // $FF: synthetic method
   static GuiButton func_96161_f(GuiScreenOnlineServers p_96161_0_) {
      return p_96161_0_.field_96190_o;
   }

   // $FF: synthetic method
   static Minecraft func_98076_f(GuiScreenOnlineServers p_98076_0_) {
      return p_98076_0_.field_73882_e;
   }

   // $FF: synthetic method
   static GuiButton func_98092_g(GuiScreenOnlineServers p_98092_0_) {
      return p_98092_0_.field_96196_r;
   }

   // $FF: synthetic method
   static void func_98078_c(GuiScreenOnlineServers p_98078_0_, int p_98078_1_) {
      p_98078_0_.func_96159_a(p_98078_1_);
   }

   // $FF: synthetic method
   static FontRenderer func_98091_h(GuiScreenOnlineServers p_98091_0_) {
      return p_98091_0_.field_73886_k;
   }

   // $FF: synthetic method
   static void func_101003_a(GuiScreenOnlineServers p_101003_0_, int p_101003_1_, int p_101003_2_, int p_101003_3_, int p_101003_4_) {
      p_101003_0_.func_101008_c(p_101003_1_, p_101003_2_, p_101003_3_, p_101003_4_);
   }

   // $FF: synthetic method
   static void func_101012_b(GuiScreenOnlineServers p_101012_0_, int p_101012_1_, int p_101012_2_, int p_101012_3_, int p_101012_4_) {
      p_101012_0_.func_101001_e(p_101012_1_, p_101012_2_, p_101012_3_, p_101012_4_);
   }

   // $FF: synthetic method
   static void func_101009_c(GuiScreenOnlineServers p_101009_0_, int p_101009_1_, int p_101009_2_, int p_101009_3_, int p_101009_4_) {
      p_101009_0_.func_101006_d(p_101009_1_, p_101009_2_, p_101009_3_, p_101009_4_);
   }

   // $FF: synthetic method
   static FontRenderer func_98084_i(GuiScreenOnlineServers p_98084_0_) {
      return p_98084_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_101005_j(GuiScreenOnlineServers p_101005_0_) {
      return p_101005_0_.field_73886_k;
   }

   // $FF: synthetic method
   static Object func_101007_h() {
      return field_96185_d;
   }

   // $FF: synthetic method
   static int func_101010_i() {
      return field_96187_c;
   }

   // $FF: synthetic method
   static int func_101014_j() {
      return field_96187_c++;
   }

   // $FF: synthetic method
   static void func_101002_a(GuiScreenOnlineServers p_101002_0_, McoServer p_101002_1_) throws IOException {
      p_101002_0_.func_96174_a(p_101002_1_);
   }

   // $FF: synthetic method
   static int func_101013_k() {
      return field_96187_c--;
   }

   // $FF: synthetic method
   static FontRenderer func_98079_k(GuiScreenOnlineServers p_98079_0_) {
      return p_98079_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_98087_l(GuiScreenOnlineServers p_98087_0_) {
      return p_98087_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_98074_m(GuiScreenOnlineServers p_98074_0_) {
      return p_98074_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_101000_n(GuiScreenOnlineServers p_101000_0_) {
      return p_101000_0_.field_73886_k;
   }

   // $FF: synthetic method
   static Minecraft func_101004_o(GuiScreenOnlineServers p_101004_0_) {
      return p_101004_0_.field_73882_e;
   }

   // $FF: synthetic method
   static String func_101011_a(GuiScreenOnlineServers p_101011_0_, String p_101011_1_) {
      return p_101011_0_.field_96195_s = p_101011_1_;
   }

}
