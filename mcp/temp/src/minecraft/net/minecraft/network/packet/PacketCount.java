package net.minecraft.network.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketCount {

   public static boolean field_76122_a = true;
   private static final Map field_76120_b = new HashMap();
   private static final Map field_76121_c = new HashMap();
   private static final Object field_76119_d = new Object();


   public static void func_76118_a(int p_76118_0_, long p_76118_1_) {
      if(field_76122_a) {
         Object var3 = field_76119_d;
         synchronized(field_76119_d) {
            if(field_76120_b.containsKey(Integer.valueOf(p_76118_0_))) {
               field_76120_b.put(Integer.valueOf(p_76118_0_), Long.valueOf(((Long)field_76120_b.get(Integer.valueOf(p_76118_0_))).longValue() + 1L));
               field_76121_c.put(Integer.valueOf(p_76118_0_), Long.valueOf(((Long)field_76121_c.get(Integer.valueOf(p_76118_0_))).longValue() + p_76118_1_));
            } else {
               field_76120_b.put(Integer.valueOf(p_76118_0_), Long.valueOf(1L));
               field_76121_c.put(Integer.valueOf(p_76118_0_), Long.valueOf(p_76118_1_));
            }

         }
      }
   }

}
