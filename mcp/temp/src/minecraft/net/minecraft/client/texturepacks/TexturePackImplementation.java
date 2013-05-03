package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.texturepacks.ITexturePack;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class TexturePackImplementation implements ITexturePack {

   private final String field_77545_e;
   private final String field_77542_f;
   protected final File field_77548_a;
   protected String field_77546_b;
   protected String field_77547_c;
   private final ITexturePack field_98141_g;
   protected BufferedImage field_77544_d;
   private int field_77543_g = -1;


   protected TexturePackImplementation(String p_i11000_1_, File p_i11000_2_, String p_i11000_3_, ITexturePack p_i11000_4_) {
      this.field_77545_e = p_i11000_1_;
      this.field_77542_f = p_i11000_3_;
      this.field_77548_a = p_i11000_2_;
      this.field_98141_g = p_i11000_4_;
      this.func_77539_g();
      this.func_77540_a();
   }

   private static String func_77541_b(String p_77541_0_) {
      if(p_77541_0_ != null && p_77541_0_.length() > 34) {
         p_77541_0_ = p_77541_0_.substring(0, 34);
      }

      return p_77541_0_;
   }

   private void func_77539_g() {
      InputStream var1 = null;

      try {
         var1 = this.func_98137_a("/pack.png", false);
         this.field_77544_d = ImageIO.read(var1);
      } catch (IOException var11) {
         ;
      } finally {
         try {
            if(var1 != null) {
               var1.close();
            }
         } catch (IOException var10) {
            ;
         }

      }

   }

   protected void func_77540_a() {
      InputStream var1 = null;
      BufferedReader var2 = null;

      try {
         var1 = this.func_98139_b("/pack.txt");
         var2 = new BufferedReader(new InputStreamReader(var1));
         this.field_77546_b = func_77541_b(var2.readLine());
         this.field_77547_c = func_77541_b(var2.readLine());
      } catch (IOException var12) {
         ;
      } finally {
         try {
            if(var2 != null) {
               var2.close();
            }

            if(var1 != null) {
               var1.close();
            }
         } catch (IOException var11) {
            ;
         }

      }

   }

   public InputStream func_98137_a(String p_98137_1_, boolean p_98137_2_) throws IOException {
      try {
         return this.func_98139_b(p_98137_1_);
      } catch (IOException var4) {
         if(this.field_98141_g != null && p_98137_2_) {
            return this.field_98141_g.func_98137_a(p_98137_1_, true);
         } else {
            throw var4;
         }
      }
   }

   public InputStream func_77532_a(String p_77532_1_) throws IOException {
      return this.func_98137_a(p_77532_1_, true);
   }

   protected abstract InputStream func_98139_b(String var1) throws IOException;

   public void func_77533_a(RenderEngine p_77533_1_) {
      if(this.field_77544_d != null && this.field_77543_g != -1) {
         p_77533_1_.func_78344_a(this.field_77543_g);
      }

   }

   public void func_77535_b(RenderEngine p_77535_1_) {
      if(this.field_77544_d != null) {
         if(this.field_77543_g == -1) {
            this.field_77543_g = p_77535_1_.func_78353_a(this.field_77544_d);
         }

         GL11.glBindTexture(3553, this.field_77543_g);
         p_77535_1_.func_98185_a();
      } else {
         p_77535_1_.func_98187_b("/gui/unknown_pack.png");
      }

   }

   public boolean func_98138_b(String p_98138_1_, boolean p_98138_2_) {
      boolean var3 = this.func_98140_c(p_98138_1_);
      return !var3 && p_98138_2_ && this.field_98141_g != null?this.field_98141_g.func_98138_b(p_98138_1_, p_98138_2_):var3;
   }

   public abstract boolean func_98140_c(String var1);

   public String func_77536_b() {
      return this.field_77545_e;
   }

   public String func_77538_c() {
      return this.field_77542_f;
   }

   public String func_77531_d() {
      return this.field_77546_b;
   }

   public String func_77537_e() {
      return this.field_77547_c;
   }
}
