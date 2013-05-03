package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.ThreadPollServers;
import net.minecraft.client.multiplayer.LanServer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiSlotServer extends GuiSlot {

   // $FF: synthetic field
   final GuiMultiplayer field_77250_a;


   public GuiSlotServer(GuiMultiplayer p_i3051_1_) {
      super(p_i3051_1_.field_73882_e, p_i3051_1_.field_73880_f, p_i3051_1_.field_73881_g, 32, p_i3051_1_.field_73881_g - 64, 36);
      this.field_77250_a = p_i3051_1_;
   }

   protected int func_77217_a() {
      return GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size() + 1;
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      if(p_77213_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size()) {
         int var3 = GuiMultiplayer.func_74020_c(this.field_77250_a);
         GuiMultiplayer.func_74015_a(this.field_77250_a, p_77213_1_);
         ServerData var4 = GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() > p_77213_1_?GuiMultiplayer.func_74006_a(this.field_77250_a).func_78850_a(p_77213_1_):null;
         boolean var5 = GuiMultiplayer.func_74020_c(this.field_77250_a) >= 0 && GuiMultiplayer.func_74020_c(this.field_77250_a) < this.func_77217_a() && (var4 == null || var4.field_82821_f == 60);
         boolean var6 = GuiMultiplayer.func_74020_c(this.field_77250_a) < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c();
         GuiMultiplayer.func_74014_d(this.field_77250_a).field_73742_g = var5;
         GuiMultiplayer.func_74005_e(this.field_77250_a).field_73742_g = var6;
         GuiMultiplayer.func_74019_f(this.field_77250_a).field_73742_g = var6;
         if(p_77213_2_ && var5) {
            GuiMultiplayer.func_74008_b(this.field_77250_a, p_77213_1_);
         } else if(var6 && GuiScreen.func_73877_p() && var3 >= 0 && var3 < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c()) {
            GuiMultiplayer.func_74006_a(this.field_77250_a).func_78857_a(var3, GuiMultiplayer.func_74020_c(this.field_77250_a));
         }

      }
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == GuiMultiplayer.func_74020_c(this.field_77250_a);
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 36;
   }

   protected void func_77221_c() {
      this.field_77250_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      if(p_77214_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c()) {
         this.func_77247_d(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
      } else if(p_77214_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size()) {
         this.func_77248_b(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
      } else {
         this.func_77249_c(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
      }

   }

   private void func_77248_b(int p_77248_1_, int p_77248_2_, int p_77248_3_, int p_77248_4_, Tessellator p_77248_5_) {
      LanServer var6 = (LanServer)GuiMultiplayer.func_74003_b(this.field_77250_a).get(p_77248_1_ - GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c());
      this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, StatCollector.func_74838_a("lanServer.title"), p_77248_2_ + 2, p_77248_3_ + 1, 16777215);
      this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.func_77487_a(), p_77248_2_ + 2, p_77248_3_ + 12, 8421504);
      if(this.field_77250_a.field_73882_e.field_71474_y.field_80005_w) {
         this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, StatCollector.func_74838_a("selectServer.hiddenAddress"), p_77248_2_ + 2, p_77248_3_ + 12 + 11, 3158064);
      } else {
         this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.func_77488_b(), p_77248_2_ + 2, p_77248_3_ + 12 + 11, 3158064);
      }

   }

   private void func_77249_c(int p_77249_1_, int p_77249_2_, int p_77249_3_, int p_77249_4_, Tessellator p_77249_5_) {
      this.field_77250_a.func_73732_a(this.field_77250_a.field_73886_k, StatCollector.func_74838_a("lanServer.scanning"), this.field_77250_a.field_73880_f / 2, p_77249_3_ + 1, 16777215);
      String var6;
      switch(GuiMultiplayer.func_74010_g(this.field_77250_a) / 3 % 4) {
      case 0:
      default:
         var6 = "O o o";
         break;
      case 1:
      case 3:
         var6 = "o O o";
         break;
      case 2:
         var6 = "o o O";
      }

      this.field_77250_a.func_73732_a(this.field_77250_a.field_73886_k, var6, this.field_77250_a.field_73880_f / 2, p_77249_3_ + 12, 8421504);
   }

   private void func_77247_d(int p_77247_1_, int p_77247_2_, int p_77247_3_, int p_77247_4_, Tessellator p_77247_5_) {
      ServerData var6 = GuiMultiplayer.func_74006_a(this.field_77250_a).func_78850_a(p_77247_1_);
      synchronized(GuiMultiplayer.func_74011_h()) {
         if(GuiMultiplayer.func_74012_i() < 5 && !var6.field_78841_f) {
            var6.field_78841_f = true;
            var6.field_78844_e = -2L;
            var6.field_78843_d = "";
            var6.field_78846_c = "";
            GuiMultiplayer.func_74021_j();
            (new ThreadPollServers(this, var6)).start();
         }
      }

      boolean var7 = var6.field_82821_f > 60;
      boolean var8 = var6.field_82821_f < 60;
      boolean var9 = var7 || var8;
      this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.field_78847_a, p_77247_2_ + 2, p_77247_3_ + 1, 16777215);
      this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.field_78843_d, p_77247_2_ + 2, p_77247_3_ + 12, 8421504);
      this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.field_78846_c, p_77247_2_ + 215 - this.field_77250_a.field_73886_k.func_78256_a(var6.field_78846_c), p_77247_3_ + 12, 8421504);
      if(var9) {
         String var10 = EnumChatFormatting.DARK_RED + var6.field_82822_g;
         this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var10, p_77247_2_ + 200 - this.field_77250_a.field_73886_k.func_78256_a(var10), p_77247_3_ + 1, 8421504);
      }

      if(!this.field_77250_a.field_73882_e.field_71474_y.field_80005_w && !var6.func_82820_d()) {
         this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, var6.field_78845_b, p_77247_2_ + 2, p_77247_3_ + 12 + 11, 3158064);
      } else {
         this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, StatCollector.func_74838_a("selectServer.hiddenAddress"), p_77247_2_ + 2, p_77247_3_ + 12 + 11, 3158064);
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_77250_a.field_73882_e.field_71446_o.func_98187_b("/gui/icons.png");
      byte var16 = 0;
      boolean var11 = false;
      String var12 = "";
      int var15;
      if(var9) {
         var12 = var7?"Client out of date!":"Server out of date!";
         var15 = 5;
      } else if(var6.field_78841_f && var6.field_78844_e != -2L) {
         if(var6.field_78844_e < 0L) {
            var15 = 5;
         } else if(var6.field_78844_e < 150L) {
            var15 = 0;
         } else if(var6.field_78844_e < 300L) {
            var15 = 1;
         } else if(var6.field_78844_e < 600L) {
            var15 = 2;
         } else if(var6.field_78844_e < 1000L) {
            var15 = 3;
         } else {
            var15 = 4;
         }

         if(var6.field_78844_e < 0L) {
            var12 = "(no connection)";
         } else {
            var12 = var6.field_78844_e + "ms";
         }
      } else {
         var16 = 1;
         var15 = (int)(Minecraft.func_71386_F() / 100L + (long)(p_77247_1_ * 2) & 7L);
         if(var15 > 4) {
            var15 = 8 - var15;
         }

         var12 = "Polling..";
      }

      this.field_77250_a.func_73729_b(p_77247_2_ + 205, p_77247_3_, 0 + var16 * 10, 176 + var15 * 8, 10, 8);
      byte var13 = 4;
      if(this.field_77230_e >= p_77247_2_ + 205 - var13 && this.field_77227_f >= p_77247_3_ - var13 && this.field_77230_e <= p_77247_2_ + 205 + 10 + var13 && this.field_77227_f <= p_77247_3_ + 8 + var13) {
         GuiMultiplayer.func_74009_a(this.field_77250_a, var12);
      }

   }
}
