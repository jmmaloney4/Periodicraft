package net.minecraft.server.dedicated;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import net.minecraft.logging.ILogAgent;

public class PropertyManager {

   private final Properties field_73672_b = new Properties();
   private final ILogAgent field_73674_a;
   private final File field_73673_c;


   public PropertyManager(File p_i11028_1_, ILogAgent p_i11028_2_) {
      this.field_73673_c = p_i11028_1_;
      this.field_73674_a = p_i11028_2_;
      if(p_i11028_1_.exists()) {
         FileInputStream var3 = null;

         try {
            var3 = new FileInputStream(p_i11028_1_);
            this.field_73672_b.load(var3);
         } catch (Exception var13) {
            p_i11028_2_.func_98235_b("Failed to load " + p_i11028_1_, var13);
            this.func_73666_a();
         } finally {
            if(var3 != null) {
               try {
                  var3.close();
               } catch (IOException var12) {
                  ;
               }
            }

         }
      } else {
         p_i11028_2_.func_98236_b(p_i11028_1_ + " does not exist");
         this.func_73666_a();
      }

   }

   public void func_73666_a() {
      this.field_73674_a.func_98233_a("Generating new properties file");
      this.func_73668_b();
   }

   public void func_73668_b() {
      FileOutputStream var1 = null;

      try {
         var1 = new FileOutputStream(this.field_73673_c);
         this.field_73672_b.store(var1, "Minecraft server properties");
      } catch (Exception var11) {
         this.field_73674_a.func_98235_b("Failed to save " + this.field_73673_c, var11);
         this.func_73666_a();
      } finally {
         if(var1 != null) {
            try {
               var1.close();
            } catch (IOException var10) {
               ;
            }
         }

      }

   }

   public File func_73665_c() {
      return this.field_73673_c;
   }

   public String func_73671_a(String p_73671_1_, String p_73671_2_) {
      if(!this.field_73672_b.containsKey(p_73671_1_)) {
         this.field_73672_b.setProperty(p_73671_1_, p_73671_2_);
         this.func_73668_b();
      }

      return this.field_73672_b.getProperty(p_73671_1_, p_73671_2_);
   }

   public int func_73669_a(String p_73669_1_, int p_73669_2_) {
      try {
         return Integer.parseInt(this.func_73671_a(p_73669_1_, "" + p_73669_2_));
      } catch (Exception var4) {
         this.field_73672_b.setProperty(p_73669_1_, "" + p_73669_2_);
         return p_73669_2_;
      }
   }

   public boolean func_73670_a(String p_73670_1_, boolean p_73670_2_) {
      try {
         return Boolean.parseBoolean(this.func_73671_a(p_73670_1_, "" + p_73670_2_));
      } catch (Exception var4) {
         this.field_73672_b.setProperty(p_73670_1_, "" + p_73670_2_);
         return p_73670_2_;
      }
   }

   public void func_73667_a(String p_73667_1_, Object p_73667_2_) {
      this.field_73672_b.setProperty(p_73667_1_, "" + p_73667_2_);
   }
}
