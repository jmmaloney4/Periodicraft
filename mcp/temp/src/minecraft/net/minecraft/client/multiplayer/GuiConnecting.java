package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ThreadConnectToServer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiConnecting extends GuiScreen {

   private NetClientHandler field_74259_a;
   private boolean field_74258_b = false;
   private final GuiScreen field_98098_c;


   public GuiConnecting(GuiScreen p_i11013_1_, Minecraft p_i11013_2_, ServerData p_i11013_3_) {
      this.field_73882_e = p_i11013_2_;
      this.field_98098_c = p_i11013_1_;
      ServerAddress var4 = ServerAddress.func_78860_a(p_i11013_3_.field_78845_b);
      p_i11013_2_.func_71403_a((WorldClient)null);
      p_i11013_2_.func_71351_a(p_i11013_3_);
      this.func_74255_a(var4.func_78861_a(), var4.func_78864_b());
   }

   public GuiConnecting(GuiScreen p_i11014_1_, Minecraft p_i11014_2_, String p_i11014_3_, int p_i11014_4_) {
      this.field_73882_e = p_i11014_2_;
      this.field_98098_c = p_i11014_1_;
      p_i11014_2_.func_71403_a((WorldClient)null);
      this.func_74255_a(p_i11014_3_, p_i11014_4_);
   }

   private void func_74255_a(String p_74255_1_, int p_74255_2_) {
      this.field_73882_e.func_98033_al().func_98233_a("Connecting to " + p_74255_1_ + ", " + p_74255_2_);
      (new ThreadConnectToServer(this, p_74255_1_, p_74255_2_)).start();
   }

   public void func_73876_c() {
      if(this.field_74259_a != null) {
         this.field_74259_a.func_72551_d();
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0) {
         this.field_74258_b = true;
         if(this.field_74259_a != null) {
            this.field_74259_a.func_72553_e();
         }

         this.field_73882_e.func_71373_a(this.field_98098_c);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      StringTranslate var4 = StringTranslate.func_74808_a();
      if(this.field_74259_a == null) {
         this.func_73732_a(this.field_73886_k, var4.func_74805_b("connect.connecting"), this.field_73880_f / 2, this.field_73881_g / 2 - 50, 16777215);
         this.func_73732_a(this.field_73886_k, "", this.field_73880_f / 2, this.field_73881_g / 2 - 10, 16777215);
      } else {
         this.func_73732_a(this.field_73886_k, var4.func_74805_b("connect.authorizing"), this.field_73880_f / 2, this.field_73881_g / 2 - 50, 16777215);
         this.func_73732_a(this.field_73886_k, this.field_74259_a.field_72560_a, this.field_73880_f / 2, this.field_73881_g / 2 - 10, 16777215);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   // $FF: synthetic method
   static NetClientHandler func_74252_a(GuiConnecting p_74252_0_, NetClientHandler p_74252_1_) {
      return p_74252_0_.field_74259_a = p_74252_1_;
   }

   // $FF: synthetic method
   static Minecraft func_74256_a(GuiConnecting p_74256_0_) {
      return p_74256_0_.field_73882_e;
   }

   // $FF: synthetic method
   static boolean func_74257_b(GuiConnecting p_74257_0_) {
      return p_74257_0_.field_74258_b;
   }

   // $FF: synthetic method
   static Minecraft func_74254_c(GuiConnecting p_74254_0_) {
      return p_74254_0_.field_73882_e;
   }

   // $FF: synthetic method
   static NetClientHandler func_74253_d(GuiConnecting p_74253_0_) {
      return p_74253_0_.field_74259_a;
   }

   // $FF: synthetic method
   static GuiScreen func_98097_e(GuiConnecting p_98097_0_) {
      return p_98097_0_.field_98098_c;
   }

   // $FF: synthetic method
   static Minecraft func_74250_f(GuiConnecting p_74250_0_) {
      return p_74250_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_74251_g(GuiConnecting p_74251_0_) {
      return p_74251_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_98096_h(GuiConnecting p_98096_0_) {
      return p_98096_0_.field_73882_e;
   }
}
