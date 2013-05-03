package net.minecraft.crash;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.crash.CallableBlockDataValue;
import net.minecraft.crash.CallableBlockLocation;
import net.minecraft.crash.CallableBlockType;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategoryEntry;
import net.minecraft.util.MathHelper;

public class CrashReportCategory {

   private final CrashReport field_85078_a;
   private final String field_85076_b;
   private final List field_85077_c = new ArrayList();
   private StackTraceElement[] field_85075_d = new StackTraceElement[0];


   public CrashReportCategory(CrashReport p_i6809_1_, String p_i6809_2_) {
      this.field_85078_a = p_i6809_1_;
      this.field_85076_b = p_i6809_2_;
   }

   @SideOnly(Side.CLIENT)
   public static String func_85074_a(double p_85074_0_, double p_85074_2_, double p_85074_4_) {
      return String.format("%.2f,%.2f,%.2f - %s", new Object[]{Double.valueOf(p_85074_0_), Double.valueOf(p_85074_2_), Double.valueOf(p_85074_4_), func_85071_a(MathHelper.func_76128_c(p_85074_0_), MathHelper.func_76128_c(p_85074_2_), MathHelper.func_76128_c(p_85074_4_))});
   }

   public static String func_85071_a(int p_85071_0_, int p_85071_1_, int p_85071_2_) {
      StringBuilder var3 = new StringBuilder();

      try {
         var3.append(String.format("World: (%d,%d,%d)", new Object[]{Integer.valueOf(p_85071_0_), Integer.valueOf(p_85071_1_), Integer.valueOf(p_85071_2_)}));
      } catch (Throwable var16) {
         var3.append("(Error finding world loc)");
      }

      var3.append(", ");

      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      try {
         var4 = p_85071_0_ >> 4;
         var5 = p_85071_2_ >> 4;
         var6 = p_85071_0_ & 15;
         var7 = p_85071_1_ >> 4;
         var8 = p_85071_2_ & 15;
         var9 = var4 << 4;
         var10 = var5 << 4;
         var11 = (var4 + 1 << 4) - 1;
         var12 = (var5 + 1 << 4) - 1;
         var3.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[]{Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var4), Integer.valueOf(var5), Integer.valueOf(var9), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12)}));
      } catch (Throwable var15) {
         var3.append("(Error finding chunk loc)");
      }

      var3.append(", ");

      try {
         var4 = p_85071_0_ >> 9;
         var5 = p_85071_2_ >> 9;
         var6 = var4 << 5;
         var7 = var5 << 5;
         var8 = (var4 + 1 << 5) - 1;
         var9 = (var5 + 1 << 5) - 1;
         var10 = var4 << 9;
         var11 = var5 << 9;
         var12 = (var4 + 1 << 9) - 1;
         int var13 = (var5 + 1 << 9) - 1;
         var3.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[]{Integer.valueOf(var4), Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13)}));
      } catch (Throwable var14) {
         var3.append("(Error finding world loc)");
      }

      return var3.toString();
   }

   public void func_71500_a(String p_71500_1_, Callable p_71500_2_) {
      try {
         this.func_71507_a(p_71500_1_, p_71500_2_.call());
      } catch (Throwable var4) {
         this.func_71499_a(p_71500_1_, var4);
      }

   }

   public void func_71507_a(String p_71507_1_, Object p_71507_2_) {
      this.field_85077_c.add(new CrashReportCategoryEntry(p_71507_1_, p_71507_2_));
   }

   public void func_71499_a(String p_71499_1_, Throwable p_71499_2_) {
      this.func_71507_a(p_71499_1_, p_71499_2_);
   }

   public int func_85073_a(int p_85073_1_) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      this.field_85075_d = new StackTraceElement[var2.length - 3 - p_85073_1_];
      System.arraycopy(var2, 3 + p_85073_1_, this.field_85075_d, 0, this.field_85075_d.length);
      return this.field_85075_d.length;
   }

   public boolean func_85069_a(StackTraceElement p_85069_1_, StackTraceElement p_85069_2_) {
      if(this.field_85075_d.length != 0 && p_85069_1_ != null) {
         StackTraceElement var3 = this.field_85075_d[0];
         if(var3.isNativeMethod() == p_85069_1_.isNativeMethod() && var3.getClassName().equals(p_85069_1_.getClassName()) && var3.getFileName().equals(p_85069_1_.getFileName()) && var3.getMethodName().equals(p_85069_1_.getMethodName())) {
            if(p_85069_2_ != null != this.field_85075_d.length > 1) {
               return false;
            } else if(p_85069_2_ != null && !this.field_85075_d[1].equals(p_85069_2_)) {
               return false;
            } else {
               this.field_85075_d[0] = p_85069_1_;
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void func_85070_b(int p_85070_1_) {
      StackTraceElement[] var2 = new StackTraceElement[this.field_85075_d.length - p_85070_1_];
      System.arraycopy(this.field_85075_d, 0, var2, 0, var2.length);
      this.field_85075_d = var2;
   }

   public void func_85072_a(StringBuilder p_85072_1_) {
      p_85072_1_.append("-- ").append(this.field_85076_b).append(" --\n");
      p_85072_1_.append("Details:");
      Iterator var2 = this.field_85077_c.iterator();

      while(var2.hasNext()) {
         CrashReportCategoryEntry var3 = (CrashReportCategoryEntry)var2.next();
         p_85072_1_.append("\n\t");
         p_85072_1_.append(var3.func_85089_a());
         p_85072_1_.append(": ");
         p_85072_1_.append(var3.func_85090_b());
      }

      if(this.field_85075_d != null && this.field_85075_d.length > 0) {
         p_85072_1_.append("\nStacktrace:");
         StackTraceElement[] var6 = this.field_85075_d;
         int var7 = var6.length;

         for(int var4 = 0; var4 < var7; ++var4) {
            StackTraceElement var5 = var6[var4];
            p_85072_1_.append("\n\tat ");
            p_85072_1_.append(var5.toString());
         }
      }

   }

   public static void func_85068_a(CrashReportCategory p_85068_0_, int p_85068_1_, int p_85068_2_, int p_85068_3_, int p_85068_4_, int p_85068_5_) {
      p_85068_0_.func_71500_a("Block type", new CallableBlockType(p_85068_4_));
      p_85068_0_.func_71500_a("Block data value", new CallableBlockDataValue(p_85068_5_));
      p_85068_0_.func_71500_a("Block location", new CallableBlockLocation(p_85068_1_, p_85068_2_, p_85068_3_));
   }
}
