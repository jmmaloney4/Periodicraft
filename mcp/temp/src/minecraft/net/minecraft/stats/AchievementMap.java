package net.minecraft.stats;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AchievementMap {

   public static AchievementMap field_75964_a = new AchievementMap();
   private Map field_75963_b = new HashMap();


   private AchievementMap() {
      try {
         BufferedReader var1 = new BufferedReader(new InputStreamReader(AchievementMap.class.getResourceAsStream("/achievement/map.txt")));

         String var2;
         while((var2 = var1.readLine()) != null) {
            String[] var3 = var2.split(",");
            int var4 = Integer.parseInt(var3[0]);
            this.field_75963_b.put(Integer.valueOf(var4), var3[1]);
         }

         var1.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   public static String func_75962_a(int p_75962_0_) {
      return (String)field_75964_a.field_75963_b.get(Integer.valueOf(p_75962_0_));
   }

}
