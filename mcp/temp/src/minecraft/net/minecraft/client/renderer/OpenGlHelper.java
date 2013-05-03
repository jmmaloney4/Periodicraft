package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.ARBMultitexture;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GLContext;

@SideOnly(Side.CLIENT)
public class OpenGlHelper {

   public static int field_77478_a;
   public static int field_77476_b;
   private static boolean field_77477_c = false;


   public static void func_77474_a() {
      field_77477_c = GLContext.getCapabilities().GL_ARB_multitexture && !GLContext.getCapabilities().OpenGL13;
      if(field_77477_c) {
         field_77478_a = '\u84c0';
         field_77476_b = '\u84c1';
      } else {
         field_77478_a = '\u84c0';
         field_77476_b = '\u84c1';
      }

   }

   public static void func_77473_a(int p_77473_0_) {
      if(field_77477_c) {
         ARBMultitexture.glActiveTextureARB(p_77473_0_);
      } else {
         GL13.glActiveTexture(p_77473_0_);
      }

   }

   public static void func_77472_b(int p_77472_0_) {
      if(field_77477_c) {
         ARBMultitexture.glClientActiveTextureARB(p_77472_0_);
      } else {
         GL13.glClientActiveTexture(p_77472_0_);
      }

   }

   public static void func_77475_a(int p_77475_0_, float p_77475_1_, float p_77475_2_) {
      if(field_77477_c) {
         ARBMultitexture.glMultiTexCoord2fARB(p_77475_0_, p_77475_1_, p_77475_2_);
      } else {
         GL13.glMultiTexCoord2f(p_77475_0_, p_77475_1_, p_77475_2_);
      }

   }

}
