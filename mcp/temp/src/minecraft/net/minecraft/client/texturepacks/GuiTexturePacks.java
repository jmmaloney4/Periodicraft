package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.texturepacks.GuiTexturePackSlot;
import net.minecraft.util.EnumOS;
import net.minecraft.util.StringTranslate;
import org.lwjgl.Sys;

@SideOnly(Side.CLIENT)
public class GuiTexturePacks extends GuiScreen {

   protected GuiScreen field_73967_a;
   private int field_73965_b = -1;
   private String field_73966_c = "";
   private GuiTexturePackSlot field_73964_d;
   private GameSettings field_96146_n;


   public GuiTexturePacks(GuiScreen p_i10000_1_, GameSettings p_i10000_2_) {
      this.field_73967_a = p_i10000_1_;
      this.field_96146_n = p_i10000_2_;
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(new GuiSmallButton(5, this.field_73880_f / 2 - 154, this.field_73881_g - 48, var1.func_74805_b("texturePack.openFolder")));
      this.field_73887_h.add(new GuiSmallButton(6, this.field_73880_f / 2 + 4, this.field_73881_g - 48, var1.func_74805_b("gui.done")));
      this.field_73882_e.field_71418_C.func_77305_c();
      this.field_73966_c = (new File(Minecraft.func_71380_b(), "texturepacks")).getAbsolutePath();
      this.field_73964_d = new GuiTexturePackSlot(this);
      this.field_73964_d.func_77220_a(this.field_73887_h, 7, 8);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 5) {
            if(Minecraft.func_71376_c() == EnumOS.MACOS) {
               try {
                  this.field_73882_e.func_98033_al().func_98233_a(this.field_73966_c);
                  Runtime.getRuntime().exec(new String[]{"/usr/bin/open", this.field_73966_c});
                  return;
               } catch (IOException var7) {
                  var7.printStackTrace();
               }
            } else if(Minecraft.func_71376_c() == EnumOS.WINDOWS) {
               String var2 = String.format("cmd.exe /C start \"Open file\" \"%s\"", new Object[]{this.field_73966_c});

               try {
                  Runtime.getRuntime().exec(var2);
                  return;
               } catch (IOException var6) {
                  var6.printStackTrace();
               }
            }

            boolean var8 = false;

            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
               var3.getMethod("browse", new Class[]{URI.class}).invoke(var4, new Object[]{(new File(Minecraft.func_71380_b(), "texturepacks")).toURI()});
            } catch (Throwable var5) {
               var5.printStackTrace();
               var8 = true;
            }

            if(var8) {
               this.field_73882_e.func_98033_al().func_98233_a("Opening via system class!");
               Sys.openURL("file://" + this.field_73966_c);
            }
         } else if(p_73875_1_.field_73741_f == 6) {
            this.field_73882_e.func_71373_a(this.field_73967_a);
         } else {
            this.field_73964_d.func_77219_a(p_73875_1_);
         }

      }
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_) {
      super.func_73879_b(p_73879_1_, p_73879_2_, p_73879_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.field_73964_d.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_73965_b <= 0) {
         this.field_73882_e.field_71418_C.func_77305_c();
         this.field_73965_b += 20;
      }

      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("texturePack.title"), this.field_73880_f / 2, 16, 16777215);
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("texturePack.folderInfo"), this.field_73880_f / 2 - 77, this.field_73881_g - 26, 8421504);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      super.func_73876_c();
      --this.field_73965_b;
   }

   // $FF: synthetic method
   static Minecraft func_73950_a(GuiTexturePacks p_73950_0_) {
      return p_73950_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73955_b(GuiTexturePacks p_73955_0_) {
      return p_73955_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73958_c(GuiTexturePacks p_73958_0_) {
      return p_73958_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73951_d(GuiTexturePacks p_73951_0_) {
      return p_73951_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73952_e(GuiTexturePacks p_73952_0_) {
      return p_73952_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73962_f(GuiTexturePacks p_73962_0_) {
      return p_73962_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73959_g(GuiTexturePacks p_73959_0_) {
      return p_73959_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73957_h(GuiTexturePacks p_73957_0_) {
      return p_73957_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73956_i(GuiTexturePacks p_73956_0_) {
      return p_73956_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73953_j(GuiTexturePacks p_73953_0_) {
      return p_73953_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_73961_k(GuiTexturePacks p_73961_0_) {
      return p_73961_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_96143_l(GuiTexturePacks p_96143_0_) {
      return p_96143_0_.field_73882_e;
   }

   // $FF: synthetic method
   static Minecraft func_96142_m(GuiTexturePacks p_96142_0_) {
      return p_96142_0_.field_73882_e;
   }

   // $FF: synthetic method
   static FontRenderer func_73954_n(GuiTexturePacks p_73954_0_) {
      return p_73954_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_96145_o(GuiTexturePacks p_96145_0_) {
      return p_96145_0_.field_73886_k;
   }

   // $FF: synthetic method
   static FontRenderer func_96144_p(GuiTexturePacks p_96144_0_) {
      return p_96144_0_.field_73886_k;
   }
}
