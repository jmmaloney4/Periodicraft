package net.minecraft.server.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class BanEntry {

   public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
   private final String field_73697_c;
   private Date field_73694_d = new Date();
   private String field_73695_e = "(Unknown)";
   private Date field_73692_f = null;
   private String field_73693_g = "Banned by an operator.";


   public BanEntry(String p_i3367_1_) {
      this.field_73697_c = p_i3367_1_;
   }

   public String func_73684_a() {
      return this.field_73697_c;
   }

   public Date func_73683_b() {
      return this.field_73694_d;
   }

   public void func_73681_a(Date p_73681_1_) {
      this.field_73694_d = p_73681_1_ != null?p_73681_1_:new Date();
   }

   public String func_73690_c() {
      return this.field_73695_e;
   }

   public void func_73687_a(String p_73687_1_) {
      this.field_73695_e = p_73687_1_;
   }

   public Date func_73680_d() {
      return this.field_73692_f;
   }

   public void func_73691_b(Date p_73691_1_) {
      this.field_73692_f = p_73691_1_;
   }

   public boolean func_73682_e() {
      return this.field_73692_f == null?false:this.field_73692_f.before(new Date());
   }

   public String func_73686_f() {
      return this.field_73693_g;
   }

   public void func_73689_b(String p_73689_1_) {
      this.field_73693_g = p_73689_1_;
   }

   public String func_73685_g() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.func_73684_a());
      var1.append("|");
      var1.append(field_73698_a.format(this.func_73683_b()));
      var1.append("|");
      var1.append(this.func_73690_c());
      var1.append("|");
      var1.append(this.func_73680_d() == null?"Forever":field_73698_a.format(this.func_73680_d()));
      var1.append("|");
      var1.append(this.func_73686_f());
      return var1.toString();
   }

   public static BanEntry func_73688_c(String p_73688_0_) {
      if(p_73688_0_.trim().length() < 2) {
         return null;
      } else {
         String[] var1 = p_73688_0_.trim().split(Pattern.quote("|"), 5);
         BanEntry var2 = new BanEntry(var1[0].trim());
         byte var3 = 0;
         int var10000 = var1.length;
         int var7 = var3 + 1;
         if(var10000 <= var7) {
            return var2;
         } else {
            try {
               var2.func_73681_a(field_73698_a.parse(var1[var7].trim()));
            } catch (ParseException var6) {
               MinecraftServer.func_71276_C().func_98033_al().func_98235_b("Could not read creation date format for ban entry \'" + var2.func_73684_a() + "\' (was: \'" + var1[var7] + "\')", var6);
            }

            var10000 = var1.length;
            ++var7;
            if(var10000 <= var7) {
               return var2;
            } else {
               var2.func_73687_a(var1[var7].trim());
               var10000 = var1.length;
               ++var7;
               if(var10000 <= var7) {
                  return var2;
               } else {
                  try {
                     String var4 = var1[var7].trim();
                     if(!var4.equalsIgnoreCase("Forever") && var4.length() > 0) {
                        var2.func_73691_b(field_73698_a.parse(var4));
                     }
                  } catch (ParseException var5) {
                     MinecraftServer.func_71276_C().func_98033_al().func_98235_b("Could not read expiry date format for ban entry \'" + var2.func_73684_a() + "\' (was: \'" + var1[var7] + "\')", var5);
                  }

                  var10000 = var1.length;
                  ++var7;
                  if(var10000 <= var7) {
                     return var2;
                  } else {
                     var2.func_73689_b(var1[var7].trim());
                     return var2;
                  }
               }
            }
         }
      }
   }

}
