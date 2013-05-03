package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenOnlineServers;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.ThreadConnectToOnlineServer;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiSlotOnlineServerList extends GuiSlot {

   // $FF: synthetic field
   final GuiScreenOnlineServers field_96294_a;


   public GuiSlotOnlineServerList(GuiScreenOnlineServers p_i10004_1_) {
      super(GuiScreenOnlineServers.func_98075_b(p_i10004_1_), p_i10004_1_.field_73880_f, p_i10004_1_.field_73881_g, 32, p_i10004_1_.field_73881_g - 64, 36);
      this.field_96294_a = p_i10004_1_;
   }

   protected int func_77217_a() {
      return GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size() + 1;
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      if(p_77213_1_ < GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size()) {
         GuiScreenOnlineServers.func_98089_b(this.field_96294_a, p_77213_1_);
         McoServer var3 = (McoServer)GuiScreenOnlineServers.func_98094_c(this.field_96294_a).get(GuiScreenOnlineServers.func_98072_d(this.field_96294_a));
         GuiScreenOnlineServers.func_96161_f(this.field_96294_a).field_73742_g = GuiScreenOnlineServers.func_98076_f(this.field_96294_a).field_71449_j.field_74286_b.equals(var3.field_96405_e);
         GuiScreenOnlineServers.func_98092_g(this.field_96294_a).field_73742_g = var3.field_96404_d.equals("OPEN") && !var3.field_98166_h;
         if(p_77213_2_ && GuiScreenOnlineServers.func_98092_g(this.field_96294_a).field_73742_g) {
            GuiScreenOnlineServers.func_98078_c(this.field_96294_a, GuiScreenOnlineServers.func_98072_d(this.field_96294_a));
         }

      }
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == GuiScreenOnlineServers.func_98072_d(this.field_96294_a);
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 36;
   }

   protected void func_77221_c() {
      this.field_96294_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      if(p_77214_1_ < GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size()) {
         this.func_96292_b(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
      }

   }

   private void func_96292_b(int p_96292_1_, int p_96292_2_, int p_96292_3_, int p_96292_4_, Tessellator p_96292_5_) {
      McoServer var6 = (McoServer)GuiScreenOnlineServers.func_98094_c(this.field_96294_a).get(p_96292_1_);
      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98091_h(this.field_96294_a), var6.func_96398_b(), p_96292_2_ + 2, p_96292_3_ + 1, 16777215);
      short var7 = 207;
      byte var8 = 1;
      if(var6.field_98166_h) {
         GuiScreenOnlineServers.func_101003_a(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_77230_e, this.field_77227_f);
      } else if(var6.field_96404_d.equals("CLOSED")) {
         GuiScreenOnlineServers.func_101012_b(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_77230_e, this.field_77227_f);
      } else {
         GuiScreenOnlineServers.func_101009_c(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_77230_e, this.field_77227_f);
         this.func_96293_a(p_96292_1_, p_96292_2_ - 14, p_96292_3_, var6);
      }

      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98084_i(this.field_96294_a), var6.func_96397_a(), p_96292_2_ + 2, p_96292_3_ + 12, 7105644);
      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_101005_j(this.field_96294_a), var6.field_96405_e, p_96292_2_ + 2, p_96292_3_ + 12 + 11, 5000268);
   }

   private void func_96293_a(int p_96293_1_, int p_96293_2_, int p_96293_3_, McoServer p_96293_4_) {
      if(p_96293_4_.field_96403_g != null) {
         synchronized(GuiScreenOnlineServers.func_101007_h()) {
            if(GuiScreenOnlineServers.func_101010_i() < 5 && (!p_96293_4_.field_96411_l || p_96293_4_.field_102022_m)) {
               (new ThreadConnectToOnlineServer(this, p_96293_4_)).start();
            }
         }

         boolean var5 = p_96293_4_.field_96415_h > 60;
         boolean var6 = p_96293_4_.field_96415_h < 60;
         boolean var7 = var5 || var6;
         if(p_96293_4_.field_96414_k != null) {
            this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98079_k(this.field_96294_a), p_96293_4_.field_96414_k, p_96293_2_ + 215 - GuiScreenOnlineServers.func_98087_l(this.field_96294_a).func_78256_a(p_96293_4_.field_96414_k), p_96293_3_ + 12, 8421504);
         }

         if(var7) {
            String var8 = EnumChatFormatting.DARK_RED + p_96293_4_.field_96413_j;
            this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98074_m(this.field_96294_a), var8, p_96293_2_ + 200 - GuiScreenOnlineServers.func_101000_n(this.field_96294_a).func_78256_a(var8), p_96293_3_ + 1, 8421504);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GuiScreenOnlineServers.func_101004_o(this.field_96294_a).field_71446_o.func_98187_b("/gui/icons.png");
         byte var13 = 0;
         boolean var9 = false;
         String var10 = "";
         int var14;
         if(var7) {
            var10 = var5?"Client out of date!":"Server out of date!";
            var14 = 5;
         } else if(p_96293_4_.field_96411_l && p_96293_4_.field_96412_m != -2L) {
            if(p_96293_4_.field_96412_m < 0L) {
               var14 = 5;
            } else if(p_96293_4_.field_96412_m < 150L) {
               var14 = 0;
            } else if(p_96293_4_.field_96412_m < 300L) {
               var14 = 1;
            } else if(p_96293_4_.field_96412_m < 600L) {
               var14 = 2;
            } else if(p_96293_4_.field_96412_m < 1000L) {
               var14 = 3;
            } else {
               var14 = 4;
            }

            if(p_96293_4_.field_96412_m < 0L) {
               var10 = "(no connection)";
               p_96293_4_.field_96411_l = false;
            } else {
               var10 = p_96293_4_.field_96412_m + "ms";
            }
         } else {
            var13 = 1;
            var14 = (int)(Minecraft.func_71386_F() / 100L + (long)(p_96293_1_ * 2) & 7L);
            if(var14 > 4) {
               var14 = 8 - var14;
            }

            var10 = "Polling..";
         }

         this.field_96294_a.func_73729_b(p_96293_2_ + 205, p_96293_3_, var13 * 10, 176 + var14 * 8, 10, 8);
         byte var11 = 4;
         if(this.field_77230_e >= p_96293_2_ + 205 - var11 && this.field_77227_f >= p_96293_3_ - var11 && this.field_77230_e <= p_96293_2_ + 205 + 10 + var11 && this.field_77227_f <= p_96293_3_ + 8 + var11) {
            GuiScreenOnlineServers.func_101011_a(this.field_96294_a, var10);
         }

      }
   }
}
