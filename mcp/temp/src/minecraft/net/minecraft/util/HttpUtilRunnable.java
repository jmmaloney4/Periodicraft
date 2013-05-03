package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.util.IDownloadSuccess;
import net.minecraft.util.IProgressUpdate;

@SideOnly(Side.CLIENT)
final class HttpUtilRunnable implements Runnable {

   // $FF: synthetic field
   final IProgressUpdate field_76178_a;
   // $FF: synthetic field
   final String field_76176_b;
   // $FF: synthetic field
   final Map field_76177_c;
   // $FF: synthetic field
   final File field_76174_d;
   // $FF: synthetic field
   final IDownloadSuccess field_76175_e;
   // $FF: synthetic field
   final int field_76173_f;


   HttpUtilRunnable(IProgressUpdate p_i3418_1_, String p_i3418_2_, Map p_i3418_3_, File p_i3418_4_, IDownloadSuccess p_i3418_5_, int p_i3418_6_) {
      this.field_76178_a = p_i3418_1_;
      this.field_76176_b = p_i3418_2_;
      this.field_76177_c = p_i3418_3_;
      this.field_76174_d = p_i3418_4_;
      this.field_76175_e = p_i3418_5_;
      this.field_76173_f = p_i3418_6_;
   }

   public void run() {
      URLConnection var1 = null;
      InputStream var2 = null;
      DataOutputStream var3 = null;
      if(this.field_76178_a != null) {
         this.field_76178_a.func_73721_b("Downloading Texture Pack");
         this.field_76178_a.func_73719_c("Making Request...");
      }

      try {
         try {
            byte[] var4 = new byte[4096];
            URL var5 = new URL(this.field_76176_b);
            var1 = var5.openConnection();
            float var6 = 0.0F;
            float var7 = (float)this.field_76177_c.entrySet().size();
            Iterator var8 = this.field_76177_c.entrySet().iterator();

            while(var8.hasNext()) {
               Entry var9 = (Entry)var8.next();
               var1.setRequestProperty((String)var9.getKey(), (String)var9.getValue());
               if(this.field_76178_a != null) {
                  this.field_76178_a.func_73718_a((int)(++var6 / var7 * 100.0F));
               }
            }

            var2 = var1.getInputStream();
            var7 = (float)var1.getContentLength();
            int var28 = var1.getContentLength();
            if(this.field_76178_a != null) {
               this.field_76178_a.func_73719_c(String.format("Downloading file (%.2f MB)...", new Object[]{Float.valueOf(var7 / 1000.0F / 1000.0F)}));
            }

            if(this.field_76174_d.exists()) {
               long var29 = this.field_76174_d.length();
               if(var29 == (long)var28) {
                  this.field_76175_e.func_76170_a(this.field_76174_d);
                  if(this.field_76178_a != null) {
                     this.field_76178_a.func_73717_a();
                  }

                  return;
               }

               System.out.println("Deleting " + this.field_76174_d + " as it does not match what we currently have (" + var28 + " vs our " + var29 + ").");
               this.field_76174_d.delete();
            }

            var3 = new DataOutputStream(new FileOutputStream(this.field_76174_d));
            if(this.field_76173_f > 0 && var7 > (float)this.field_76173_f) {
               if(this.field_76178_a != null) {
                  this.field_76178_a.func_73717_a();
               }

               throw new IOException("Filesize is bigger than maximum allowed (file is " + var6 + ", limit is " + this.field_76173_f + ")");
            }

            boolean var31 = false;

            int var30;
            while((var30 = var2.read(var4)) >= 0) {
               var6 += (float)var30;
               if(this.field_76178_a != null) {
                  this.field_76178_a.func_73718_a((int)(var6 / var7 * 100.0F));
               }

               if(this.field_76173_f > 0 && var6 > (float)this.field_76173_f) {
                  if(this.field_76178_a != null) {
                     this.field_76178_a.func_73717_a();
                  }

                  throw new IOException("Filesize was bigger than maximum allowed (got >= " + var6 + ", limit was " + this.field_76173_f + ")");
               }

               var3.write(var4, 0, var30);
            }

            this.field_76175_e.func_76170_a(this.field_76174_d);
            if(this.field_76178_a != null) {
               this.field_76178_a.func_73717_a();
               return;
            }
         } catch (Throwable var26) {
            var26.printStackTrace();
         }

      } finally {
         try {
            if(var2 != null) {
               var2.close();
            }
         } catch (IOException var25) {
            ;
         }

         try {
            if(var3 != null) {
               var3.close();
            }
         } catch (IOException var24) {
            ;
         }

      }
   }
}
