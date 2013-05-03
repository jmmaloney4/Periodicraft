package net.minecraft.profiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.profiler.ProfilerResult;

public class Profiler {

   private final List field_76325_b = new ArrayList();
   private final List field_76326_c = new ArrayList();
   public boolean field_76327_a = false;
   private String field_76323_d = "";
   private final Map field_76324_e = new HashMap();


   public void func_76317_a() {
      this.field_76324_e.clear();
      this.field_76323_d = "";
      this.field_76325_b.clear();
   }

   public void func_76320_a(String p_76320_1_) {
      if(this.field_76327_a) {
         if(this.field_76323_d.length() > 0) {
            this.field_76323_d = this.field_76323_d + ".";
         }

         this.field_76323_d = this.field_76323_d + p_76320_1_;
         this.field_76325_b.add(this.field_76323_d);
         this.field_76326_c.add(Long.valueOf(System.nanoTime()));
      }
   }

   public void func_76319_b() {
      if(this.field_76327_a) {
         long var1 = System.nanoTime();
         long var3 = ((Long)this.field_76326_c.remove(this.field_76326_c.size() - 1)).longValue();
         this.field_76325_b.remove(this.field_76325_b.size() - 1);
         long var5 = var1 - var3;
         if(this.field_76324_e.containsKey(this.field_76323_d)) {
            this.field_76324_e.put(this.field_76323_d, Long.valueOf(((Long)this.field_76324_e.get(this.field_76323_d)).longValue() + var5));
         } else {
            this.field_76324_e.put(this.field_76323_d, Long.valueOf(var5));
         }

         if(var5 > 100000000L) {
            System.out.println("Something\'s taking too long! \'" + this.field_76323_d + "\' took aprox " + (double)var5 / 1000000.0D + " ms");
         }

         this.field_76323_d = !this.field_76325_b.isEmpty()?(String)this.field_76325_b.get(this.field_76325_b.size() - 1):"";
      }
   }

   public List func_76321_b(String p_76321_1_) {
      if(!this.field_76327_a) {
         return null;
      } else {
         long var3 = this.field_76324_e.containsKey("root")?((Long)this.field_76324_e.get("root")).longValue():0L;
         long var5 = this.field_76324_e.containsKey(p_76321_1_)?((Long)this.field_76324_e.get(p_76321_1_)).longValue():-1L;
         ArrayList var7 = new ArrayList();
         if(p_76321_1_.length() > 0) {
            p_76321_1_ = p_76321_1_ + ".";
         }

         long var8 = 0L;
         Iterator var10 = this.field_76324_e.keySet().iterator();

         while(var10.hasNext()) {
            String var11 = (String)var10.next();
            if(var11.length() > p_76321_1_.length() && var11.startsWith(p_76321_1_) && var11.indexOf(".", p_76321_1_.length() + 1) < 0) {
               var8 += ((Long)this.field_76324_e.get(var11)).longValue();
            }
         }

         float var21 = (float)var8;
         if(var8 < var5) {
            var8 = var5;
         }

         if(var3 < var8) {
            var3 = var8;
         }

         Iterator var20 = this.field_76324_e.keySet().iterator();

         String var12;
         while(var20.hasNext()) {
            var12 = (String)var20.next();
            if(var12.length() > p_76321_1_.length() && var12.startsWith(p_76321_1_) && var12.indexOf(".", p_76321_1_.length() + 1) < 0) {
               long var13 = ((Long)this.field_76324_e.get(var12)).longValue();
               double var15 = (double)var13 * 100.0D / (double)var8;
               double var17 = (double)var13 * 100.0D / (double)var3;
               String var19 = var12.substring(p_76321_1_.length());
               var7.add(new ProfilerResult(var19, var15, var17));
            }
         }

         var20 = this.field_76324_e.keySet().iterator();

         while(var20.hasNext()) {
            var12 = (String)var20.next();
            this.field_76324_e.put(var12, Long.valueOf(((Long)this.field_76324_e.get(var12)).longValue() * 999L / 1000L));
         }

         if((float)var8 > var21) {
            var7.add(new ProfilerResult("unspecified", (double)((float)var8 - var21) * 100.0D / (double)var8, (double)((float)var8 - var21) * 100.0D / (double)var3));
         }

         Collections.sort(var7);
         var7.add(0, new ProfilerResult(p_76321_1_, 100.0D, (double)var8 * 100.0D / (double)var3));
         return var7;
      }
   }

   public void func_76318_c(String p_76318_1_) {
      this.func_76319_b();
      this.func_76320_a(p_76318_1_);
   }

   public String func_76322_c() {
      return this.field_76325_b.size() == 0?"[UNKNOWN]":(String)this.field_76325_b.get(this.field_76325_b.size() - 1);
   }
}
