package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImage;

@SideOnly(Side.CLIENT)
public class ThreadDownloadImageData {

   public BufferedImage field_78462_a;
   public int field_78460_b = 1;
   public int field_78461_c = -1;
   public boolean field_78459_d = false;


   public ThreadDownloadImageData(String p_i5001_1_, IImageBuffer p_i5001_2_) {
      (new ThreadDownloadImage(this, p_i5001_1_, p_i5001_2_)).start();
   }
}
