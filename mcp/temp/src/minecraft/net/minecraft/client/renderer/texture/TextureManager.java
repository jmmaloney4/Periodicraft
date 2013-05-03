package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.texturepacks.ITexturePack;

@SideOnly(Side.CLIENT)
public class TextureManager {

   private static TextureManager field_94271_a;
   private int field_94269_b = 0;
   private final HashMap field_94270_c = new HashMap();
   private final HashMap field_94268_d = new HashMap();


   public static void func_94263_a() {
      field_94271_a = new TextureManager();
   }

   public static TextureManager func_94267_b() {
      return field_94271_a;
   }

   public int func_94265_c() {
      return this.field_94269_b++;
   }

   public void func_94264_a(String p_94264_1_, Texture p_94264_2_) {
      this.field_94268_d.put(p_94264_1_, Integer.valueOf(p_94264_2_.func_94284_b()));
      if(!this.field_94270_c.containsKey(Integer.valueOf(p_94264_2_.func_94284_b()))) {
         this.field_94270_c.put(Integer.valueOf(p_94264_2_.func_94284_b()), p_94264_2_);
      }

   }

   public void func_94259_a(Texture p_94259_1_) {
      if(this.field_94270_c.containsValue(p_94259_1_)) {
         Minecraft.func_71410_x().func_98033_al().func_98236_b("TextureManager.registerTexture called, but this texture has already been registered. ignoring.");
      } else {
         this.field_94270_c.put(Integer.valueOf(p_94259_1_.func_94284_b()), p_94259_1_);
      }
   }

   public Stitcher func_94262_d(String p_94262_1_) {
      int var2 = Minecraft.func_71369_N();
      return new Stitcher(p_94262_1_, var2, var2, true);
   }

   public List func_94266_e(String p_94266_1_) {
      ArrayList var2 = new ArrayList();
      ITexturePack var3 = Minecraft.func_71410_x().field_71418_C.func_77292_e();

      try {
         BufferedImage var9 = ImageIO.read(var3.func_77532_a("/" + p_94266_1_));
         int var10 = var9.getHeight();
         int var11 = var9.getWidth();
         String var12 = this.func_98146_d(p_94266_1_);
         if(this.func_98147_a(p_94266_1_, var3)) {
            int var13 = var11;
            int var14 = var11;
            int var15 = var10 / var11;

            for(int var16 = 0; var16 < var15; ++var16) {
               Texture var17 = this.func_94261_a(var12, 2, var13, var14, 10496, 6408, 9728, 9728, false, var9.getSubimage(0, var14 * var16, var13, var14));
               var2.add(var17);
            }
         } else if(var11 == var10) {
            var2.add(this.func_94261_a(var12, 2, var11, var10, 10496, 6408, 9728, 9728, false, var9));
         } else {
            Minecraft.func_71410_x().func_98033_al().func_98236_b("TextureManager.createTexture: Skipping " + p_94266_1_ + " because of broken aspect ratio and not animation");
         }

         return var2;
      } catch (FileNotFoundException var18) {
         Minecraft.func_71410_x().func_98033_al().func_98236_b("TextureManager.createTexture called for file " + p_94266_1_ + ", but that file does not exist. Ignoring.");
      } catch (IOException var19) {
         Minecraft.func_71410_x().func_98033_al().func_98236_b("TextureManager.createTexture encountered an IOException when trying to read file " + p_94266_1_ + ". Ignoring.");
      }

      return var2;
   }

   private String func_98146_d(String p_98146_1_) {
      File var2 = new File(p_98146_1_);
      return var2.getName().substring(0, var2.getName().lastIndexOf(46));
   }

   private boolean func_98147_a(String p_98147_1_, ITexturePack p_98147_2_) {
      String var3 = "/" + p_98147_1_.substring(0, p_98147_1_.lastIndexOf(46)) + ".txt";
      boolean var4 = p_98147_2_.func_98138_b("/" + p_98147_1_, false);
      return Minecraft.func_71410_x().field_71418_C.func_77292_e().func_98138_b(var3, !var4);
   }

   public Texture func_94261_a(String p_94261_1_, int p_94261_2_, int p_94261_3_, int p_94261_4_, int p_94261_5_, int p_94261_6_, int p_94261_7_, int p_94261_8_, boolean p_94261_9_, BufferedImage p_94261_10_) {
      Texture var11 = new Texture(p_94261_1_, p_94261_2_, p_94261_3_, p_94261_4_, p_94261_5_, p_94261_6_, p_94261_7_, p_94261_8_, p_94261_10_);
      this.func_94259_a(var11);
      return var11;
   }

   public Texture func_98145_a(String p_98145_1_, int p_98145_2_, int p_98145_3_, int p_98145_4_, int p_98145_5_) {
      return this.func_94261_a(p_98145_1_, p_98145_2_, p_98145_3_, p_98145_4_, 10496, p_98145_5_, 9728, 9728, false, (BufferedImage)null);
   }
}
