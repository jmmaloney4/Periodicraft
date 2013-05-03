package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.minecraft.client.mco.ExceptionMcoHttp;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.Locations;
import net.minecraft.client.mco.McoOption;
import net.minecraft.client.mco.McoOptionSome;
import net.minecraft.client.mco.McoPair;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerAddress;
import net.minecraft.client.mco.Request;
import net.minecraft.client.mco.ValueObjectList;
import net.minecraft.client.mco.ValueObjectSubscription;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class McoClient {

   private static McoOption field_98178_a = McoOption.func_98154_b();
   private final String field_96390_a;
   private final String field_100007_c;
   private static String field_96388_b = "https://mcoapi.minecraft.net/";


   public McoClient(Session p_i20001_1_) {
      this.field_96390_a = p_i20001_1_.field_74287_c;
      this.field_100007_c = p_i20001_1_.field_74286_b;
   }

   public ValueObjectList func_96382_a() throws ExceptionMcoService {
      String var1 = this.func_96377_a(Request.func_96358_a(field_96388_b + "worlds"));
      return ValueObjectList.func_98161_a(var1);
   }

   public McoServer func_98176_a(long p_98176_1_) throws ExceptionMcoService, IOException {
      String var3 = this.func_96377_a(Request.func_96358_a(field_96388_b + "worlds" + "/$ID".replace("$ID", String.valueOf(p_98176_1_))));
      return McoServer.func_98165_c(var3);
   }

   public McoServerAddress func_96374_a(long p_96374_1_) throws ExceptionMcoService, IOException {
      String var3 = field_96388_b + "worlds" + "/$ID/join".replace("$ID", "" + p_96374_1_);
      String var4 = this.func_96377_a(Request.func_96358_a(var3));
      return McoServerAddress.func_98162_a(var4);
   }

   public void func_96386_a(String p_96386_1_, String p_96386_2_, String p_96386_3_) throws IOException, ExceptionMcoService, UnsupportedEncodingException {
      String var4 = field_96388_b + "worlds" + "/$NAME/$LOCATION_ID".replace("$NAME", this.func_96380_a(p_96386_1_)).replace("$LOCATION_ID", p_96386_3_);
      if(p_96386_2_ != null && !p_96386_2_.trim().equals("")) {
         var4 = var4 + "?motd=" + this.func_96380_a(p_96386_2_);
      }

      this.func_96377_a(Request.func_96361_b(var4, ""));
   }

   public Boolean func_96375_b() throws ExceptionMcoService, IOException {
      String var1 = field_96388_b + "mco" + "/available";
      String var2 = this.func_96377_a(Request.func_96358_a(var1));
      return Boolean.valueOf(var2);
   }

   public int func_96379_c() throws ExceptionMcoService {
      String var1 = field_96388_b + "payments" + "/unused";
      String var2 = this.func_96377_a(Request.func_96358_a(var1));
      return Integer.valueOf(var2).intValue();
   }

   public void func_96381_a(long p_96381_1_, String p_96381_3_) throws ExceptionMcoService {
      String var4 = field_96388_b + "worlds" + "/$WORLD_ID/invites/$USER_NAME".replace("$WORLD_ID", String.valueOf(p_96381_1_)).replace("$USER_NAME", p_96381_3_);
      this.func_96377_a(Request.func_96355_b(var4));
   }

   public McoServer func_96387_b(long p_96387_1_, String p_96387_3_) throws ExceptionMcoService, IOException {
      String var4 = field_96388_b + "worlds" + "/$WORLD_ID/invites/$USER_NAME".replace("$WORLD_ID", String.valueOf(p_96387_1_)).replace("$USER_NAME", p_96387_3_);
      String var5 = this.func_96377_a(Request.func_96361_b(var4, ""));
      return McoServer.func_98165_c(var5);
   }

   public void func_96384_a(long p_96384_1_, String p_96384_3_, String p_96384_4_) throws ExceptionMcoService, UnsupportedEncodingException {
      String var5 = field_96388_b + "worlds" + "/$WORLD_ID/$NAME".replace("$WORLD_ID", String.valueOf(p_96384_1_)).replace("$NAME", this.func_96380_a(p_96384_3_));
      if(p_96384_4_ != null && !p_96384_4_.trim().equals("")) {
         var5 = var5 + "?motd=" + this.func_96380_a(p_96384_4_);
      }

      this.func_96377_a(Request.func_96363_c(var5, ""));
   }

   public Boolean func_96383_b(long p_96383_1_) throws ExceptionMcoService, IOException {
      String var3 = field_96388_b + "worlds" + "/$WORLD_ID/open".replace("$WORLD_ID", String.valueOf(p_96383_1_));
      String var4 = this.func_96377_a(Request.func_96363_c(var3, ""));
      return Boolean.valueOf(var4);
   }

   public Boolean func_96378_c(long p_96378_1_) throws ExceptionMcoService, IOException {
      String var3 = field_96388_b + "worlds" + "/$WORLD_ID/close".replace("$WORLD_ID", String.valueOf(p_96378_1_));
      String var4 = this.func_96377_a(Request.func_96363_c(var3, ""));
      return Boolean.valueOf(var4);
   }

   public Boolean func_96376_d(long p_96376_1_) throws ExceptionMcoService, IOException {
      String var3 = field_96388_b + "worlds" + "/$WORLD_ID/reset".replace("$WORLD_ID", String.valueOf(p_96376_1_));
      String var4 = this.func_96377_a(Request.func_96353_a(var3, "", 30000, 80000));
      return Boolean.valueOf(var4);
   }

   public Locations func_96385_d() throws ExceptionMcoService, IOException {
      String var1 = this.func_96377_a(Request.func_96358_a(field_96388_b + "worlds" + "/locations"));
      return Locations.func_98174_a(var1);
   }

   public ValueObjectSubscription func_98177_f(long p_98177_1_) throws ExceptionMcoService, IOException {
      String var3 = this.func_96377_a(Request.func_96358_a(field_96388_b + "subscriptions" + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(p_98177_1_))));
      return ValueObjectSubscription.func_98169_a(var3);
   }

   private String func_96380_a(String p_96380_1_) throws UnsupportedEncodingException {
      return URLEncoder.encode(p_96380_1_, "UTF-8");
   }

   private String func_96377_a(Request p_96377_1_) throws ExceptionMcoService {
      p_96377_1_.func_100006_a("sid", this.field_96390_a);
      p_96377_1_.func_100006_a("user", this.field_100007_c);
      if(field_98178_a instanceof McoOptionSome) {
         McoPair var2 = (McoPair)field_98178_a.func_98155_a();
         p_96377_1_.func_100006_a((String)var2.func_100005_a(), (String)var2.func_100004_b());
      }

      try {
         int var5 = p_96377_1_.func_96362_a();
         if(var5 == 503) {
            throw new ExceptionRetryCall(10);
         } else if(var5 >= 200 && var5 < 300) {
            McoOption var3 = p_96377_1_.func_98175_b();
            if(var3 instanceof McoOptionSome) {
               field_98178_a = var3;
            }

            return p_96377_1_.func_96364_c();
         } else {
            throw new ExceptionMcoService(p_96377_1_.func_96362_a(), p_96377_1_.func_96364_c());
         }
      } catch (ExceptionMcoHttp var4) {
         throw new ExceptionMcoService(500, "Server not available!");
      }
   }

}
