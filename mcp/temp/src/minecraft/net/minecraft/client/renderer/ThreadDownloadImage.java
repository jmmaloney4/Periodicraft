package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;

@SideOnly(Side.CLIENT)
class ThreadDownloadImage extends Thread {

   // $FF: synthetic field
   final String field_78458_a;
   // $FF: synthetic field
   final IImageBuffer field_78456_b;
   // $FF: synthetic field
   final ThreadDownloadImageData field_78457_c;


   ThreadDownloadImage(ThreadDownloadImageData p_i5000_1_, String p_i5000_2_, IImageBuffer p_i5000_3_) {
      this.field_78457_c = p_i5000_1_;
      this.field_78458_a = p_i5000_2_;
      this.field_78456_b = p_i5000_3_;
   }

   public void run() {
      HttpURLConnection var1 = null;

      try {
         URL var2 = new URL(this.field_78458_a);
         var1 = (HttpURLConnection)var2.openConnection();
         var1.setDoInput(true);
         var1.setDoOutput(false);
         var1.connect();
         if(var1.getResponseCode() / 100 == 4) {
            return;
         }

         if(this.field_78456_b == null) {
            this.field_78457_c.field_78462_a = ImageIO.read(var1.getInputStream());
         } else {
            this.field_78457_c.field_78462_a = this.field_78456_b.func_78432_a(ImageIO.read(var1.getInputStream()));
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      } finally {
         var1.disconnect();
      }

   }
}
