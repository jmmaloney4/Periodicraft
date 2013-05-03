package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.mco.ExceptionMcoHttp;
import net.minecraft.client.mco.McoOption;
import net.minecraft.client.mco.McoPair;
import net.minecraft.client.mco.RequestDelete;
import net.minecraft.client.mco.RequestGet;
import net.minecraft.client.mco.RequestPost;
import net.minecraft.client.mco.RequestPut;

@SideOnly(Side.CLIENT)
public abstract class Request {

   protected HttpURLConnection field_96367_a;
   private boolean field_96366_c;
   protected String field_96365_b;


   public Request(String p_i10026_1_, int p_i10026_2_, int p_i10026_3_) {
      try {
         this.field_96365_b = p_i10026_1_;
         this.field_96367_a = (HttpURLConnection)(new URL(p_i10026_1_)).openConnection();
         this.field_96367_a.setConnectTimeout(p_i10026_2_);
         this.field_96367_a.setReadTimeout(p_i10026_3_);
      } catch (Exception var5) {
         throw new ExceptionMcoHttp("Failed URL: " + p_i10026_1_, var5);
      }
   }

   public void func_100006_a(String p_100006_1_, String p_100006_2_) {
      String var3 = this.field_96367_a.getRequestProperty("Cookie");
      if(var3 == null) {
         this.field_96367_a.setRequestProperty("Cookie", p_100006_1_ + "=" + p_100006_2_);
      } else {
         this.field_96367_a.setRequestProperty("Cookie", var3 + ";" + p_100006_1_ + "=" + p_100006_2_);
      }

   }

   public int func_96362_a() {
      try {
         this.func_96354_d();
         return this.field_96367_a.getResponseCode();
      } catch (Exception var2) {
         throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, var2);
      }
   }

   public McoOption func_98175_b() {
      String var1 = this.field_96367_a.getHeaderField("Set-Cookie");
      if(var1 != null) {
         String var2 = var1.substring(0, var1.indexOf("="));
         String var3 = var1.substring(var1.indexOf("=") + 1, var1.indexOf(";"));
         return McoOption.func_98153_a(McoPair.func_98157_a(var2, var3));
      } else {
         return McoOption.func_98154_b();
      }
   }

   public String func_96364_c() {
      try {
         this.func_96354_d();
         String var1 = this.func_96362_a() >= 400?this.func_96352_a(this.field_96367_a.getErrorStream()):this.func_96352_a(this.field_96367_a.getInputStream());
         this.func_96360_f();
         return var1;
      } catch (IOException var2) {
         throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, var2);
      }
   }

   private String func_96352_a(InputStream p_96352_1_) throws IOException {
      if(p_96352_1_ == null) {
         throw new IllegalArgumentException("input stream cannot be null");
      } else {
         StringBuilder var2 = new StringBuilder();

         for(int var3 = p_96352_1_.read(); var3 != -1; var3 = p_96352_1_.read()) {
            var2.append((char)var3);
         }

         return var2.toString();
      }
   }

   private void func_96360_f() {
      byte[] var1 = new byte[1024];

      InputStream var3;
      try {
         boolean var2 = false;
         var3 = this.field_96367_a.getInputStream();

         while(true) {
            if(var3.read(var1) <= 0) {
               var3.close();
               break;
            }
         }
      } catch (Exception var6) {
         try {
            var3 = this.field_96367_a.getErrorStream();
            boolean var4 = false;

            while(true) {
               if(var3.read(var1) <= 0) {
                  var3.close();
                  break;
               }
            }
         } catch (IOException var5) {
            ;
         }
      }

   }

   protected Request func_96354_d() {
      if(!this.field_96366_c) {
         Request var1 = this.func_96359_e();
         this.field_96366_c = true;
         return var1;
      } else {
         return this;
      }
   }

   protected abstract Request func_96359_e();

   public static Request func_96358_a(String p_96358_0_) {
      return new RequestGet(p_96358_0_, 5000, 5000);
   }

   public static Request func_96361_b(String p_96361_0_, String p_96361_1_) {
      return new RequestPost(p_96361_0_, p_96361_1_.getBytes(), 5000, 5000);
   }

   public static Request func_96355_b(String p_96355_0_) {
      return new RequestDelete(p_96355_0_, 5000, 5000);
   }

   public static Request func_96363_c(String p_96363_0_, String p_96363_1_) {
      return new RequestPut(p_96363_0_, p_96363_1_.getBytes(), 5000, 5000);
   }

   public static Request func_96353_a(String p_96353_0_, String p_96353_1_, int p_96353_2_, int p_96353_3_) {
      return new RequestPut(p_96353_0_, p_96353_1_.getBytes(), p_96353_2_, p_96353_3_);
   }
}
