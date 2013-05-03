package net.minecraft.stats;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.stats.StatPlaceholder;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatsSyncher;
import net.minecraft.util.MD5String;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class StatFileWriter {

   private Map field_77457_a = new HashMap();
   private Map field_77455_b = new HashMap();
   private boolean field_77456_c = false;
   private StatsSyncher field_77454_d;


   public StatFileWriter(Session p_i3218_1_, File p_i3218_2_) {
      File var3 = new File(p_i3218_2_, "stats");
      if(!var3.exists()) {
         var3.mkdir();
      }

      File[] var4 = p_i3218_2_.listFiles();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         File var7 = var4[var6];
         if(var7.getName().startsWith("stats_") && var7.getName().endsWith(".dat")) {
            File var8 = new File(var3, var7.getName());
            if(!var8.exists()) {
               System.out.println("Relocating " + var7.getName());
               var7.renameTo(var8);
            }
         }
      }

      this.field_77454_d = new StatsSyncher(p_i3218_1_, this, var3);
   }

   public void func_77450_a(StatBase p_77450_1_, int p_77450_2_) {
      this.func_77451_a(this.field_77455_b, p_77450_1_, p_77450_2_);
      this.func_77451_a(this.field_77457_a, p_77450_1_, p_77450_2_);
      this.field_77456_c = true;
   }

   private void func_77451_a(Map p_77451_1_, StatBase p_77451_2_, int p_77451_3_) {
      Integer var4 = (Integer)p_77451_1_.get(p_77451_2_);
      int var5 = var4 == null?0:var4.intValue();
      p_77451_1_.put(p_77451_2_, Integer.valueOf(var5 + p_77451_3_));
   }

   public Map func_77445_b() {
      return new HashMap(this.field_77455_b);
   }

   public void func_77447_a(Map p_77447_1_) {
      if(p_77447_1_ != null) {
         this.field_77456_c = true;
         Iterator var2 = p_77447_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            this.func_77451_a(this.field_77455_b, var3, ((Integer)p_77447_1_.get(var3)).intValue());
            this.func_77451_a(this.field_77457_a, var3, ((Integer)p_77447_1_.get(var3)).intValue());
         }

      }
   }

   public void func_77452_b(Map p_77452_1_) {
      if(p_77452_1_ != null) {
         Iterator var2 = p_77452_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            Integer var4 = (Integer)this.field_77455_b.get(var3);
            int var5 = var4 == null?0:var4.intValue();
            this.field_77457_a.put(var3, Integer.valueOf(((Integer)p_77452_1_.get(var3)).intValue() + var5));
         }

      }
   }

   public void func_77448_c(Map p_77448_1_) {
      if(p_77448_1_ != null) {
         this.field_77456_c = true;
         Iterator var2 = p_77448_1_.keySet().iterator();

         while(var2.hasNext()) {
            StatBase var3 = (StatBase)var2.next();
            this.func_77451_a(this.field_77455_b, var3, ((Integer)p_77448_1_.get(var3)).intValue());
         }

      }
   }

   public static Map func_77453_b(String p_77453_0_) {
      HashMap var1 = new HashMap();

      try {
         String var2 = "local";
         StringBuilder var3 = new StringBuilder();
         JsonRootNode var4 = (new JdomParser()).parse(p_77453_0_);
         List var5 = var4.getArrayNode(new Object[]{"stats-change"});
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            JsonNode var7 = (JsonNode)var6.next();
            Map var8 = var7.getFields();
            Entry var9 = (Entry)var8.entrySet().iterator().next();
            int var10 = Integer.parseInt(((JsonStringNode)var9.getKey()).getText());
            int var11 = Integer.parseInt(((JsonNode)var9.getValue()).getText());
            StatBase var12 = StatList.func_75923_a(var10);
            if(var12 == null) {
               System.out.println(var10 + " is not a valid stat, creating place-holder");
               var12 = (new StatPlaceholder(var10)).func_75971_g();
            }

            var3.append(StatList.func_75923_a(var10).field_75973_g).append(",");
            var3.append(var11).append(",");
            var1.put(var12, Integer.valueOf(var11));
         }

         MD5String var14 = new MD5String(var2);
         String var15 = var14.func_75899_a(var3.toString());
         if(!var15.equals(var4.getStringValue(new Object[]{"checksum"}))) {
            System.out.println("CHECKSUM MISMATCH");
            return null;
         }
      } catch (InvalidSyntaxException var13) {
         var13.printStackTrace();
      }

      return var1;
   }

   public static String func_77441_a(String p_77441_0_, String p_77441_1_, Map p_77441_2_) {
      StringBuilder var3 = new StringBuilder();
      StringBuilder var4 = new StringBuilder();
      boolean var5 = true;
      var3.append("{\r\n");
      if(p_77441_0_ != null && p_77441_1_ != null) {
         var3.append("  \"user\":{\r\n");
         var3.append("    \"name\":\"").append(p_77441_0_).append("\",\r\n");
         var3.append("    \"sessionid\":\"").append(p_77441_1_).append("\"\r\n");
         var3.append("  },\r\n");
      }

      var3.append("  \"stats-change\":[");
      Iterator var6 = p_77441_2_.keySet().iterator();

      while(var6.hasNext()) {
         StatBase var7 = (StatBase)var6.next();
         if(var5) {
            var5 = false;
         } else {
            var3.append("},");
         }

         var3.append("\r\n    {\"").append(var7.field_75975_e).append("\":").append(p_77441_2_.get(var7));
         var4.append(var7.field_75973_g).append(",");
         var4.append(p_77441_2_.get(var7)).append(",");
      }

      if(!var5) {
         var3.append("}");
      }

      MD5String var8 = new MD5String(p_77441_1_);
      var3.append("\r\n  ],\r\n");
      var3.append("  \"checksum\":\"").append(var8.func_75899_a(var4.toString())).append("\"\r\n");
      var3.append("}");
      return var3.toString();
   }

   public boolean func_77443_a(Achievement p_77443_1_) {
      return this.field_77457_a.containsKey(p_77443_1_);
   }

   public boolean func_77442_b(Achievement p_77442_1_) {
      return p_77442_1_.field_75992_c == null || this.func_77443_a(p_77442_1_.field_75992_c);
   }

   public int func_77444_a(StatBase p_77444_1_) {
      Integer var2 = (Integer)this.field_77457_a.get(p_77444_1_);
      return var2 == null?0:var2.intValue();
   }

   public void func_77446_d() {
      this.field_77454_d.func_77420_c(this.func_77445_b());
   }

   public void func_77449_e() {
      if(this.field_77456_c && this.field_77454_d.func_77425_c()) {
         this.field_77454_d.func_77418_a(this.func_77445_b());
      }

      this.field_77454_d.func_77422_e();
   }
}
