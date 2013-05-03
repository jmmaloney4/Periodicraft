package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ScreenShotHelper {

   private static final DateFormat field_74295_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
   private static IntBuffer field_74293_b;
   private static int[] field_74294_c;


   public static String func_74291_a(File p_74291_0_, int p_74291_1_, int p_74291_2_) {
      return func_74292_a(p_74291_0_, (String)null, p_74291_1_, p_74291_2_);
   }

   public static String func_74292_a(File p_74292_0_, String p_74292_1_, int p_74292_2_, int p_74292_3_) {
      try {
         File var4 = new File(p_74292_0_, "screenshots");
         var4.mkdir();
         int var5 = p_74292_2_ * p_74292_3_;
         if(field_74293_b == null || field_74293_b.capacity() < var5) {
            field_74293_b = BufferUtils.createIntBuffer(var5);
            field_74294_c = new int[var5];
         }

         GL11.glPixelStorei(3333, 1);
         GL11.glPixelStorei(3317, 1);
         field_74293_b.clear();
         GL11.glReadPixels(0, 0, p_74292_2_, p_74292_3_, '\u80e1', '\u8367', field_74293_b);
         field_74293_b.get(field_74294_c);
         func_74289_a(field_74294_c, p_74292_2_, p_74292_3_);
         BufferedImage var6 = new BufferedImage(p_74292_2_, p_74292_3_, 1);
         var6.setRGB(0, 0, p_74292_2_, p_74292_3_, field_74294_c, 0, p_74292_2_);
         File var7;
         if(p_74292_1_ == null) {
            var7 = func_74290_a(var4);
         } else {
            var7 = new File(var4, p_74292_1_);
         }

         ImageIO.write(var6, "png", var7);
         return "Saved screenshot as " + var7.getName();
      } catch (Exception var8) {
         var8.printStackTrace();
         return "Failed to save: " + var8;
      }
   }

   private static File func_74290_a(File p_74290_0_) {
      String var2 = field_74295_a.format(new Date()).toString();
      int var3 = 1;

      while(true) {
         File var1 = new File(p_74290_0_, var2 + (var3 == 1?"":"_" + var3) + ".png");
         if(!var1.exists()) {
            return var1;
         }

         ++var3;
      }
   }

   private static void func_74289_a(int[] p_74289_0_, int p_74289_1_, int p_74289_2_) {
      int[] var3 = new int[p_74289_1_];
      int var4 = p_74289_2_ / 2;

      for(int var5 = 0; var5 < var4; ++var5) {
         System.arraycopy(p_74289_0_, var5 * p_74289_1_, var3, 0, p_74289_1_);
         System.arraycopy(p_74289_0_, (p_74289_2_ - 1 - var5) * p_74289_1_, p_74289_0_, var5 * p_74289_1_, p_74289_1_);
         System.arraycopy(var3, 0, p_74289_0_, (p_74289_2_ - 1 - var5) * p_74289_1_, p_74289_1_);
      }

   }

}
