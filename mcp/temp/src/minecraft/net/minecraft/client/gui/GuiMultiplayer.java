package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenAddServer;
import net.minecraft.client.gui.GuiScreenServerList;
import net.minecraft.client.gui.GuiSlotServer;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.LanServer;
import net.minecraft.client.multiplayer.LanServerList;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.multiplayer.ThreadLanServerFind;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiMultiplayer extends GuiScreen {

   private static int field_74027_a = 0;
   private static Object field_74023_b = new Object();
   private GuiScreen field_74025_c;
   private GuiSlotServer field_74022_d;
   private ServerList field_74030_m;
   private int field_74028_n = -1;
   private GuiButton field_96289_p;
   private GuiButton field_74038_p;
   private GuiButton field_74037_q;
   private boolean field_74036_r = false;
   private boolean field_74035_s = false;
   private boolean field_74034_t = false;
   private boolean field_74033_u = false;
   private String field_74032_v = null;
   private ServerData field_74031_w = null;
   private LanServerList field_74041_x;
   private ThreadLanServerFind field_74040_y;
   private int field_74039_z;
   private boolean field_74024_A;
   private List field_74026_B = Collections.emptyList();


   public GuiMultiplayer(GuiScreen p_i3064_1_) {
      this.field_74025_c = p_i3064_1_;
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      if(!this.field_74024_A) {
         this.field_74024_A = true;
         this.field_74030_m = new ServerList(this.field_73882_e);
         this.field_74030_m.func_78853_a();
         this.field_74041_x = new LanServerList();

         try {
            this.field_74040_y = new ThreadLanServerFind(this.field_74041_x);
            this.field_74040_y.start();
         } catch (Exception var2) {
            this.field_73882_e.func_98033_al().func_98236_b("Unable to start LAN server detection: " + var2.getMessage());
         }

         this.field_74022_d = new GuiSlotServer(this);
      } else {
         this.field_74022_d.func_77207_a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
      }

      this.func_74016_g();
   }

   public void func_74016_g() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(this.field_96289_p = new GuiButton(7, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 70, 20, var1.func_74805_b("selectServer.edit")));
      this.field_73887_h.add(this.field_74037_q = new GuiButton(2, this.field_73880_f / 2 - 74, this.field_73881_g - 28, 70, 20, var1.func_74805_b("selectServer.delete")));
      this.field_73887_h.add(this.field_74038_p = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, var1.func_74805_b("selectServer.select")));
      this.field_73887_h.add(new GuiButton(4, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, var1.func_74805_b("selectServer.direct")));
      this.field_73887_h.add(new GuiButton(3, this.field_73880_f / 2 + 4 + 50, this.field_73881_g - 52, 100, 20, var1.func_74805_b("selectServer.add")));
      this.field_73887_h.add(new GuiButton(8, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 70, 20, var1.func_74805_b("selectServer.refresh")));
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 4 + 76, this.field_73881_g - 28, 75, 20, var1.func_74805_b("gui.cancel")));
      boolean var2 = this.field_74028_n >= 0 && this.field_74028_n < this.field_74022_d.func_77217_a();
      this.field_74038_p.field_73742_g = var2;
      this.field_96289_p.field_73742_g = var2;
      this.field_74037_q.field_73742_g = var2;
   }

   public void func_73876_c() {
      super.func_73876_c();
      ++this.field_74039_z;
      if(this.field_74041_x.func_77553_a()) {
         this.field_74026_B = this.field_74041_x.func_77554_c();
         this.field_74041_x.func_77552_b();
      }

   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
      if(this.field_74040_y != null) {
         this.field_74040_y.interrupt();
         this.field_74040_y = null;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 2) {
            String var2 = this.field_74030_m.func_78850_a(this.field_74028_n).field_78847_a;
            if(var2 != null) {
               this.field_74036_r = true;
               StringTranslate var3 = StringTranslate.func_74808_a();
               String var4 = var3.func_74805_b("selectServer.deleteQuestion");
               String var5 = "\'" + var2 + "\' " + var3.func_74805_b("selectServer.deleteWarning");
               String var6 = var3.func_74805_b("selectServer.deleteButton");
               String var7 = var3.func_74805_b("gui.cancel");
               GuiYesNo var8 = new GuiYesNo(this, var4, var5, var6, var7, this.field_74028_n);
               this.field_73882_e.func_71373_a(var8);
            }
         } else if(p_73875_1_.field_73741_f == 1) {
            this.func_74004_a(this.field_74028_n);
         } else if(p_73875_1_.field_73741_f == 4) {
            this.field_74033_u = true;
            this.field_73882_e.func_71373_a(new GuiScreenServerList(this, this.field_74031_w = new ServerData(StatCollector.func_74838_a("selectServer.defaultName"), "")));
         } else if(p_73875_1_.field_73741_f == 3) {
            this.field_74035_s = true;
            this.field_73882_e.func_71373_a(new GuiScreenAddServer(this, this.field_74031_w = new ServerData(StatCollector.func_74838_a("selectServer.defaultName"), "")));
         } else if(p_73875_1_.field_73741_f == 7) {
            this.field_74034_t = true;
            ServerData var9 = this.field_74030_m.func_78850_a(this.field_74028_n);
            this.field_74031_w = new ServerData(var9.field_78847_a, var9.field_78845_b);
            this.field_74031_w.func_82819_b(var9.func_82820_d());
            this.field_73882_e.func_71373_a(new GuiScreenAddServer(this, this.field_74031_w));
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a(this.field_74025_c);
         } else if(p_73875_1_.field_73741_f == 8) {
            this.field_73882_e.func_71373_a(new GuiMultiplayer(this.field_74025_c));
         } else {
            this.field_74022_d.func_77219_a(p_73875_1_);
         }

      }
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(this.field_74036_r) {
         this.field_74036_r = false;
         if(p_73878_1_) {
            this.field_74030_m.func_78851_b(p_73878_2_);
            this.field_74030_m.func_78855_b();
            this.field_74028_n = -1;
         }

         this.field_73882_e.func_71373_a(this);
      } else if(this.field_74033_u) {
         this.field_74033_u = false;
         if(p_73878_1_) {
            this.func_74002_a(this.field_74031_w);
         } else {
            this.field_73882_e.func_71373_a(this);
         }
      } else if(this.field_74035_s) {
         this.field_74035_s = false;
         if(p_73878_1_) {
            this.field_74030_m.func_78849_a(this.field_74031_w);
            this.field_74030_m.func_78855_b();
            this.field_74028_n = -1;
         }

         this.field_73882_e.func_71373_a(this);
      } else if(this.field_74034_t) {
         this.field_74034_t = false;
         if(p_73878_1_) {
            ServerData var3 = this.field_74030_m.func_78850_a(this.field_74028_n);
            var3.field_78847_a = this.field_74031_w.field_78847_a;
            var3.field_78845_b = this.field_74031_w.field_78845_b;
            var3.func_82819_b(this.field_74031_w.func_82820_d());
            this.field_74030_m.func_78855_b();
         }

         this.field_73882_e.func_71373_a(this);
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      int var3 = this.field_74028_n;
      if(p_73869_2_ == 59) {
         this.field_73882_e.field_71474_y.field_80005_w = !this.field_73882_e.field_71474_y.field_80005_w;
         this.field_73882_e.field_71474_y.func_74303_b();
      } else {
         if(func_73877_p() && p_73869_2_ == 200) {
            if(var3 > 0 && var3 < this.field_74030_m.func_78856_c()) {
               this.field_74030_m.func_78857_a(var3, var3 - 1);
               --this.field_74028_n;
               if(var3 < this.field_74030_m.func_78856_c() - 1) {
                  this.field_74022_d.func_77208_b(-this.field_74022_d.field_77229_d);
               }
            }
         } else if(func_73877_p() && p_73869_2_ == 208) {
            if(var3 < this.field_74030_m.func_78856_c() - 1) {
               this.field_74030_m.func_78857_a(var3, var3 + 1);
               ++this.field_74028_n;
               if(var3 > 0) {
                  this.field_74022_d.func_77208_b(this.field_74022_d.field_77229_d);
               }
            }
         } else if(p_73869_1_ == 13) {
            this.func_73875_a((GuiButton)this.field_73887_h.get(2));
         } else {
            super.func_73869_a(p_73869_1_, p_73869_2_);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_74032_v = null;
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.field_74022_d.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("multiplayer.title"), this.field_73880_f / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_74032_v != null) {
         this.func_74007_a(this.field_74032_v, p_73863_1_, p_73863_2_);
      }

   }

   private void func_74004_a(int p_74004_1_) {
      if(p_74004_1_ < this.field_74030_m.func_78856_c()) {
         this.func_74002_a(this.field_74030_m.func_78850_a(p_74004_1_));
      } else {
         p_74004_1_ -= this.field_74030_m.func_78856_c();
         if(p_74004_1_ < this.field_74026_B.size()) {
            LanServer var2 = (LanServer)this.field_74026_B.get(p_74004_1_);
            this.func_74002_a(new ServerData(var2.func_77487_a(), var2.func_77488_b()));
         }

      }
   }

   private void func_74002_a(ServerData p_74002_1_) {
      this.field_73882_e.func_71373_a(new GuiConnecting(this, this.field_73882_e, p_74002_1_));
   }

   private static void func_74017_b(ServerData p_74017_1_) throws IOException {
      ServerAddress var1 = ServerAddress.func_78860_a(p_74017_1_.field_78845_b);
      Socket var2 = null;
      DataInputStream var3 = null;
      DataOutputStream var4 = null;

      try {
         var2 = new Socket();
         var2.setSoTimeout(3000);
         var2.setTcpNoDelay(true);
         var2.setTrafficClass(18);
         var2.connect(new InetSocketAddress(var1.func_78861_a(), var1.func_78864_b()), 3000);
         var3 = new DataInputStream(var2.getInputStream());
         var4 = new DataOutputStream(var2.getOutputStream());
         var4.write(254);
         var4.write(1);
         if(var3.read() != 255) {
            throw new IOException("Bad message");
         }

         String var5 = Packet.func_73282_a(var3, 256);
         char[] var6 = var5.toCharArray();

         for(int var7 = 0; var7 < var6.length; ++var7) {
            if(var6[var7] != 167 && var6[var7] != 0 && ChatAllowedCharacters.field_71568_a.indexOf(var6[var7]) < 0) {
               var6[var7] = 63;
            }
         }

         var5 = new String(var6);
         int var8;
         int var9;
         String[] var26;
         if(var5.startsWith("\u00a7") && var5.length() > 1) {
            var26 = var5.substring(1).split("\u0000");
            if(MathHelper.func_82715_a(var26[0], 0) == 1) {
               p_74017_1_.field_78843_d = var26[3];
               p_74017_1_.field_82821_f = MathHelper.func_82715_a(var26[1], p_74017_1_.field_82821_f);
               p_74017_1_.field_82822_g = var26[2];
               var8 = MathHelper.func_82715_a(var26[4], 0);
               var9 = MathHelper.func_82715_a(var26[5], 0);
               if(var8 >= 0 && var9 >= 0) {
                  p_74017_1_.field_78846_c = EnumChatFormatting.GRAY + "" + var8 + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + var9;
               } else {
                  p_74017_1_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
               }
            } else {
               p_74017_1_.field_82822_g = "???";
               p_74017_1_.field_78843_d = "" + EnumChatFormatting.DARK_GRAY + "???";
               p_74017_1_.field_82821_f = 61;
               p_74017_1_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
            }
         } else {
            var26 = var5.split("\u00a7");
            var5 = var26[0];
            var8 = -1;
            var9 = -1;

            try {
               var8 = Integer.parseInt(var26[1]);
               var9 = Integer.parseInt(var26[2]);
            } catch (Exception var24) {
               ;
            }

            p_74017_1_.field_78843_d = EnumChatFormatting.GRAY + var5;
            if(var8 >= 0 && var9 > 0) {
               p_74017_1_.field_78846_c = EnumChatFormatting.GRAY + "" + var8 + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + var9;
            } else {
               p_74017_1_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
            }

            p_74017_1_.field_82822_g = "1.3";
            p_74017_1_.field_82821_f = 59;
         }
      } finally {
         try {
            if(var3 != null) {
               var3.close();
            }
         } catch (Throwable var23) {
            ;
         }

         try {
            if(var4 != null) {
               var4.close();
            }
         } catch (Throwable var22) {
            ;
         }

         try {
            if(var2 != null) {
               var2.close();
            }
         } catch (Throwable var21) {
            ;
         }

      }

   }

   protected void func_74007_a(String p_74007_1_, int p_74007_2_, int p_74007_3_) {
      if(p_74007_1_ != null) {
         int var4 = p_74007_2_ + 12;
         int var5 = p_74007_3_ - 12;
         int var6 = this.field_73886_k.func_78256_a(p_74007_1_);
         this.func_73733_a(var4 - 3, var5 - 3, var4 + var6 + 3, var5 + 8 + 3, -1073741824, -1073741824);
         this.field_73886_k.func_78261_a(p_74007_1_, var4, var5, -1);
      }
   }

   // $FF: synthetic method
   static ServerList func_74006_a(GuiMultiplayer p_74006_0_) {
      return p_74006_0_.field_74030_m;
   }

   // $FF: synthetic method
   static List func_74003_b(GuiMultiplayer p_74003_0_) {
      return p_74003_0_.field_74026_B;
   }

   // $FF: synthetic method
   static int func_74020_c(GuiMultiplayer p_74020_0_) {
      return p_74020_0_.field_74028_n;
   }

   // $FF: synthetic method
   static int func_74015_a(GuiMultiplayer p_74015_0_, int p_74015_1_) {
      return p_74015_0_.field_74028_n = p_74015_1_;
   }

   // $FF: synthetic method
   static GuiButton func_74014_d(GuiMultiplayer p_74014_0_) {
      return p_74014_0_.field_74038_p;
   }

   // $FF: synthetic method
   static GuiButton func_74005_e(GuiMultiplayer p_74005_0_) {
      return p_74005_0_.field_96289_p;
   }

   // $FF: synthetic method
   static GuiButton func_74019_f(GuiMultiplayer p_74019_0_) {
      return p_74019_0_.field_74037_q;
   }

   // $FF: synthetic method
   static void func_74008_b(GuiMultiplayer p_74008_0_, int p_74008_1_) {
      p_74008_0_.func_74004_a(p_74008_1_);
   }

   // $FF: synthetic method
   static int func_74010_g(GuiMultiplayer p_74010_0_) {
      return p_74010_0_.field_74039_z;
   }

   // $FF: synthetic method
   static Object func_74011_h() {
      return field_74023_b;
   }

   // $FF: synthetic method
   static int func_74012_i() {
      return field_74027_a;
   }

   // $FF: synthetic method
   static int func_74021_j() {
      return field_74027_a++;
   }

   // $FF: synthetic method
   static void func_82291_a(ServerData p_82291_0_) throws IOException {
      func_74017_b(p_82291_0_);
   }

   // $FF: synthetic method
   static int func_74018_k() {
      return field_74027_a--;
   }

   // $FF: synthetic method
   static String func_74009_a(GuiMultiplayer p_74009_0_, String p_74009_1_) {
      return p_74009_0_.field_74032_v = p_74009_1_;
   }

}
