package net.minecraft.crash;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.minecraft.crash.CallableCrashMemoryReport;
import net.minecraft.crash.CallableIntCache;
import net.minecraft.crash.CallableJVMFlags;
import net.minecraft.crash.CallableJavaInfo;
import net.minecraft.crash.CallableJavaInfo2;
import net.minecraft.crash.CallableMemoryInfo;
import net.minecraft.crash.CallableMinecraftVersion;
import net.minecraft.crash.CallableOSInfo;
import net.minecraft.crash.CallableSuspiciousClasses;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.logging.ILogAgent;
import net.minecraft.util.ReportedException;

public class CrashReport {

   private final String field_71513_a;
   private final Throwable field_71511_b;
   private final CrashReportCategory field_85061_c = new CrashReportCategory(this, "System Details");
   private final List field_71512_c = new ArrayList();
   private File field_71510_d = null;
   private boolean field_85059_f = true;
   private StackTraceElement[] field_85060_g = new StackTraceElement[0];


   public CrashReport(String p_i3250_1_, Throwable p_i3250_2_) {
      this.field_71513_a = p_i3250_1_;
      this.field_71511_b = p_i3250_2_;
      this.func_71504_g();
   }

   private void func_71504_g() {
      this.field_85061_c.func_71500_a("Minecraft Version", new CallableMinecraftVersion(this));
      this.field_85061_c.func_71500_a("Operating System", new CallableOSInfo(this));
      this.field_85061_c.func_71500_a("Java Version", new CallableJavaInfo(this));
      this.field_85061_c.func_71500_a("Java VM Version", new CallableJavaInfo2(this));
      this.field_85061_c.func_71500_a("Memory", new CallableMemoryInfo(this));
      this.field_85061_c.func_71500_a("JVM Flags", new CallableJVMFlags(this));
      this.field_85061_c.func_71500_a("AABB Pool Size", new CallableCrashMemoryReport(this));
      this.field_85061_c.func_71500_a("Suspicious classes", new CallableSuspiciousClasses(this));
      this.field_85061_c.func_71500_a("IntCache", new CallableIntCache(this));
   }

   public String func_71501_a() {
      return this.field_71513_a;
   }

   public Throwable func_71505_b() {
      return this.field_71511_b;
   }

   @SideOnly(Side.CLIENT)
   public String func_90021_c() {
      StringBuilder var1 = new StringBuilder();
      this.func_71506_a(var1);
      return var1.toString();
   }

   public void func_71506_a(StringBuilder p_71506_1_) {
      if(this.field_85060_g != null && this.field_85060_g.length > 0) {
         p_71506_1_.append("-- Head --\n");
         p_71506_1_.append("Stacktrace:\n");
         StackTraceElement[] var2 = this.field_85060_g;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement var5 = var2[var4];
            p_71506_1_.append("\t").append("at ").append(var5.toString());
            p_71506_1_.append("\n");
         }

         p_71506_1_.append("\n");
      }

      Iterator var6 = this.field_71512_c.iterator();

      while(var6.hasNext()) {
         CrashReportCategory var7 = (CrashReportCategory)var6.next();
         var7.func_85072_a(p_71506_1_);
         p_71506_1_.append("\n\n");
      }

      this.field_85061_c.func_85072_a(p_71506_1_);
   }

   public String func_71498_d() {
      StringWriter var1 = null;
      PrintWriter var2 = null;
      String var3 = this.field_71511_b.toString();

      try {
         var1 = new StringWriter();
         var2 = new PrintWriter(var1);
         this.field_71511_b.printStackTrace(var2);
         var3 = var1.toString();
      } finally {
         try {
            if(var1 != null) {
               var1.close();
            }

            if(var2 != null) {
               var2.close();
            }
         } catch (IOException var10) {
            ;
         }

      }

      return var3;
   }

   public String func_71502_e() {
      StringBuilder var1 = new StringBuilder();
      var1.append("---- Minecraft Crash Report ----\n");
      var1.append("// ");
      var1.append(func_71503_h());
      var1.append("\n\n");
      var1.append("Time: ");
      var1.append((new SimpleDateFormat()).format(new Date()));
      var1.append("\n");
      var1.append("Description: ");
      var1.append(this.field_71513_a);
      var1.append("\n\n");
      var1.append(this.func_71498_d());
      var1.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

      for(int var2 = 0; var2 < 87; ++var2) {
         var1.append("-");
      }

      var1.append("\n\n");
      this.func_71506_a(var1);
      return var1.toString();
   }

   @SideOnly(Side.CLIENT)
   public File func_71497_f() {
      return this.field_71510_d;
   }

   public boolean func_71508_a(File p_71508_1_, ILogAgent p_71508_2_) {
      if(this.field_71510_d != null) {
         return false;
      } else {
         if(p_71508_1_.getParentFile() != null) {
            p_71508_1_.getParentFile().mkdirs();
         }

         try {
            FileWriter var3 = new FileWriter(p_71508_1_);
            var3.write(this.func_71502_e());
            var3.close();
            this.field_71510_d = p_71508_1_;
            return true;
         } catch (Throwable var4) {
            p_71508_2_.func_98234_c("Could not save crash report to " + p_71508_1_, var4);
            return false;
         }
      }
   }

   public CrashReportCategory func_85056_g() {
      return this.field_85061_c;
   }

   public CrashReportCategory func_85058_a(String p_85058_1_) {
      return this.func_85057_a(p_85058_1_, 1);
   }

   public CrashReportCategory func_85057_a(String p_85057_1_, int p_85057_2_) {
      CrashReportCategory var3 = new CrashReportCategory(this, p_85057_1_);
      if(this.field_85059_f) {
         int var4 = var3.func_85073_a(p_85057_2_);
         StackTraceElement[] var5 = this.field_71511_b.getStackTrace();
         StackTraceElement var6 = null;
         StackTraceElement var7 = null;
         if(var5 != null && var5.length - var4 < var5.length) {
            var6 = var5[var5.length - var4];
            if(var5.length + 1 - var4 < var5.length) {
               var7 = var5[var5.length + 1 - var4];
            }
         }

         this.field_85059_f = var3.func_85069_a(var6, var7);
         if(var4 > 0 && !this.field_71512_c.isEmpty()) {
            CrashReportCategory var8 = (CrashReportCategory)this.field_71512_c.get(this.field_71512_c.size() - 1);
            var8.func_85070_b(var4);
         } else if(var5 != null && var5.length >= var4) {
            this.field_85060_g = new StackTraceElement[var5.length - var4];
            System.arraycopy(var5, 0, this.field_85060_g, 0, this.field_85060_g.length);
         } else {
            this.field_85059_f = false;
         }
      }

      this.field_71512_c.add(var3);
      return var3;
   }

   private static String func_71503_h() {
      String[] var0 = new String[]{"Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :(", "Don\'t do that.", "Ouch. That hurt :(", "You\'re mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!"};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public static CrashReport func_85055_a(Throwable p_85055_0_, String p_85055_1_) {
      CrashReport var2;
      if(p_85055_0_ instanceof ReportedException) {
         var2 = ((ReportedException)p_85055_0_).func_71575_a();
      } else {
         var2 = new CrashReport(p_85055_1_, p_85055_0_);
      }

      return var2;
   }
}
