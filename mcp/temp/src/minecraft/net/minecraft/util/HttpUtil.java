package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.logging.ILogAgent;
import net.minecraft.util.HttpUtilRunnable;
import net.minecraft.util.IDownloadSuccess;
import net.minecraft.util.IProgressUpdate;

public class HttpUtil {

   public static String func_76179_a(Map p_76179_0_) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = p_76179_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if(var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String func_76183_a(ILogAgent p_76183_0_, URL p_76183_1_, Map p_76183_2_, boolean p_76183_3_) {
      return func_76180_a(p_76183_0_, p_76183_1_, func_76179_a(p_76183_2_), p_76183_3_);
   }

   public static String func_76180_a(ILogAgent p_76180_0_, URL p_76180_1_, String p_76180_2_, boolean p_76180_3_) {
      try {
         HttpURLConnection var4 = (HttpURLConnection)p_76180_1_.openConnection();
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4.setRequestProperty("Content-Length", "" + p_76180_2_.getBytes().length);
         var4.setRequestProperty("Content-Language", "en-US");
         var4.setUseCaches(false);
         var4.setDoInput(true);
         var4.setDoOutput(true);
         DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
         var5.writeBytes(p_76180_2_);
         var5.flush();
         var5.close();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
         StringBuffer var8 = new StringBuffer();

         String var7;
         while((var7 = var6.readLine()) != null) {
            var8.append(var7);
            var8.append('\r');
         }

         var6.close();
         return var8.toString();
      } catch (Exception var9) {
         if(!p_76180_3_) {
            if(p_76180_0_ != null) {
               p_76180_0_.func_98234_c("Could not post to " + p_76180_1_, var9);
            } else {
               Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + p_76180_1_, var9);
            }
         }

         return "";
      }
   }

   @SideOnly(Side.CLIENT)
   public static void func_76182_a(File p_76182_0_, String p_76182_1_, IDownloadSuccess p_76182_2_, Map p_76182_3_, int p_76182_4_, IProgressUpdate p_76182_5_) {
      Thread var6 = new Thread(new HttpUtilRunnable(p_76182_5_, p_76182_1_, p_76182_3_, p_76182_0_, p_76182_2_, p_76182_4_));
      var6.setDaemon(true);
      var6.start();
   }

   @SideOnly(Side.CLIENT)
   public static int func_76181_a() throws IOException {
      ServerSocket var0 = null;
      boolean var1 = true;

      int var10;
      try {
         var0 = new ServerSocket(0);
         var10 = var0.getLocalPort();
      } finally {
         try {
            if(var0 != null) {
               var0.close();
            }
         } catch (IOException var8) {
            ;
         }

      }

      return var10;
   }

   @SideOnly(Side.CLIENT)
   public static String[] func_82718_a(ILogAgent p_82718_0_, String p_82718_1_, String p_82718_2_) {
      HashMap var3 = new HashMap();
      var3.put("user", p_82718_1_);
      var3.put("password", p_82718_2_);
      var3.put("version", Integer.valueOf(13));

      String var4;
      try {
         var4 = func_76183_a(p_82718_0_, new URL("http://login.minecraft.net/"), var3, false);
      } catch (MalformedURLException var6) {
         var6.printStackTrace();
         return null;
      }

      if(var4 != null && var4.length() != 0) {
         if(!var4.contains(":")) {
            if(p_82718_0_ == null) {
               System.out.println("Failed to authenticate: " + var4);
            } else {
               p_82718_0_.func_98236_b("Failed to authenticae: " + var4);
            }

            return null;
         } else {
            String[] var5 = var4.split(":");
            return new String[]{var5[2], var5[3]};
         }
      } else {
         if(p_82718_0_ == null) {
            System.out.println("Failed to authenticate: Can\'t connect to minecraft.net");
         } else {
            p_82718_0_.func_98236_b("Failed to authenticate: Can\'t connect to minecraft.net");
         }

         return null;
      }
   }
}
