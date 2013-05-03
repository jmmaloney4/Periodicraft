package net.minecraft.server.dedicated;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.management.ServerConfigurationManager;

public class DedicatedPlayerList extends ServerConfigurationManager {

   private File field_72423_e;
   private File field_72422_f;


   public DedicatedPlayerList(DedicatedServer p_i3378_1_) {
      super(p_i3378_1_);
      this.field_72423_e = p_i3378_1_.func_71209_f("ops.txt");
      this.field_72422_f = p_i3378_1_.func_71209_f("white-list.txt");
      this.field_72402_d = p_i3378_1_.func_71327_a("view-distance", 10);
      this.field_72405_c = p_i3378_1_.func_71327_a("max-players", 20);
      this.func_72371_a(p_i3378_1_.func_71332_a("white-list", false));
      if(!p_i3378_1_.func_71264_H()) {
         this.func_72390_e().func_73708_a(true);
         this.func_72363_f().func_73708_a(true);
      }

      this.func_72390_e().func_73707_e();
      this.func_72390_e().func_73711_f();
      this.func_72363_f().func_73707_e();
      this.func_72363_f().func_73711_f();
      this.func_72417_t();
      this.func_72418_v();
      this.func_72419_u();
      if(!this.field_72422_f.exists()) {
         this.func_72421_w();
      }

   }

   public void func_72371_a(boolean p_72371_1_) {
      super.func_72371_a(p_72371_1_);
      this.func_72420_s().func_71328_a("white-list", Boolean.valueOf(p_72371_1_));
      this.func_72420_s().func_71326_a();
   }

   public void func_72386_b(String p_72386_1_) {
      super.func_72386_b(p_72386_1_);
      this.func_72419_u();
   }

   public void func_72360_c(String p_72360_1_) {
      super.func_72360_c(p_72360_1_);
      this.func_72419_u();
   }

   public void func_72379_i(String p_72379_1_) {
      super.func_72379_i(p_72379_1_);
      this.func_72421_w();
   }

   public void func_72359_h(String p_72359_1_) {
      super.func_72359_h(p_72359_1_);
      this.func_72421_w();
   }

   public void func_72362_j() {
      this.func_72418_v();
   }

   private void func_72417_t() {
      try {
         this.func_72376_i().clear();
         BufferedReader var1 = new BufferedReader(new FileReader(this.field_72423_e));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            this.func_72376_i().add(var2.trim().toLowerCase());
         }

         var1.close();
      } catch (Exception var3) {
         this.func_72420_s().func_98033_al().func_98236_b("Failed to load operators list: " + var3);
      }

   }

   private void func_72419_u() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.field_72423_e, false));
         Iterator var2 = this.func_72376_i().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.println(var3);
         }

         var1.close();
      } catch (Exception var4) {
         this.func_72420_s().func_98033_al().func_98236_b("Failed to save operators list: " + var4);
      }

   }

   private void func_72418_v() {
      try {
         this.func_72388_h().clear();
         BufferedReader var1 = new BufferedReader(new FileReader(this.field_72422_f));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            this.func_72388_h().add(var2.trim().toLowerCase());
         }

         var1.close();
      } catch (Exception var3) {
         this.func_72420_s().func_98033_al().func_98236_b("Failed to load white-list: " + var3);
      }

   }

   private void func_72421_w() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.field_72422_f, false));
         Iterator var2 = this.func_72388_h().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.println(var3);
         }

         var1.close();
      } catch (Exception var4) {
         this.func_72420_s().func_98033_al().func_98236_b("Failed to save white-list: " + var4);
      }

   }

   public boolean func_72370_d(String p_72370_1_) {
      p_72370_1_ = p_72370_1_.trim().toLowerCase();
      return !this.func_72383_n() || this.func_72353_e(p_72370_1_) || this.func_72388_h().contains(p_72370_1_);
   }

   public DedicatedServer func_72420_s() {
      return (DedicatedServer)super.func_72365_p();
   }

   // $FF: synthetic method
   public MinecraftServer func_72365_p() {
      return this.func_72420_s();
   }
}
