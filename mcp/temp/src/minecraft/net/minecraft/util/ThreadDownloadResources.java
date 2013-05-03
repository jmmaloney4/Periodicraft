package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SideOnly(Side.CLIENT)
public class ThreadDownloadResources extends Thread {

   public File field_74579_a;
   private Minecraft field_74577_b;
   private boolean field_74578_c = false;


   public ThreadDownloadResources(File p_i3000_1_, Minecraft p_i3000_2_) {
      this.field_74577_b = p_i3000_2_;
      this.setName("Resource download thread");
      this.setDaemon(true);
      this.field_74579_a = new File(p_i3000_1_, "resources/");
      if(!this.field_74579_a.exists() && !this.field_74579_a.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + this.field_74579_a);
      }
   }

   public void run() {
      try {
         URL var1 = new URL("http://s3.amazonaws.com/MinecraftResources/");
         DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
         DocumentBuilder var3 = var2.newDocumentBuilder();
         Document var4 = var3.parse(var1.openStream());
         NodeList var5 = var4.getElementsByTagName("Contents");

         for(int var6 = 0; var6 < 2; ++var6) {
            for(int var7 = 0; var7 < var5.getLength(); ++var7) {
               Node var8 = var5.item(var7);
               if(var8.getNodeType() == 1) {
                  Element var9 = (Element)var8;
                  String var10 = var9.getElementsByTagName("Key").item(0).getChildNodes().item(0).getNodeValue();
                  long var11 = Long.parseLong(var9.getElementsByTagName("Size").item(0).getChildNodes().item(0).getNodeValue());
                  if(var11 > 0L) {
                     this.func_74575_a(var1, var10, var11, var6);
                     if(this.field_74578_c) {
                        return;
                     }
                  }
               }
            }
         }
      } catch (Exception var13) {
         this.func_74576_a(this.field_74579_a, "");
         var13.printStackTrace();
      }

   }

   public void func_74573_a() {
      this.func_74576_a(this.field_74579_a, "");
   }

   private void func_74576_a(File p_74576_1_, String p_74576_2_) {
      File[] var3 = p_74576_1_.listFiles();

      for(int var4 = 0; var4 < var3.length; ++var4) {
         if(var3[var4].isDirectory()) {
            this.func_74576_a(var3[var4], p_74576_2_ + var3[var4].getName() + "/");
         } else {
            try {
               this.field_74577_b.func_71360_a(p_74576_2_ + var3[var4].getName(), var3[var4]);
            } catch (Exception var6) {
               this.field_74577_b.func_98033_al().func_98236_b("Failed to add " + p_74576_2_ + var3[var4].getName() + " in resources");
            }
         }
      }

   }

   private void func_74575_a(URL p_74575_1_, String p_74575_2_, long p_74575_3_, int p_74575_5_) {
      try {
         int var6 = p_74575_2_.indexOf("/");
         String var7 = p_74575_2_.substring(0, var6);
         if(var7.equalsIgnoreCase("sound3")) {
            if(p_74575_5_ != 0) {
               return;
            }
         } else if(p_74575_5_ != 1) {
            return;
         }

         File var8 = new File(this.field_74579_a, p_74575_2_);
         if(!var8.exists() || var8.length() != p_74575_3_) {
            var8.getParentFile().mkdirs();
            String var9 = p_74575_2_.replaceAll(" ", "%20");
            this.func_74572_a(new URL(p_74575_1_, var9), var8, p_74575_3_);
            if(this.field_74578_c) {
               return;
            }
         }

         this.field_74577_b.func_71360_a(p_74575_2_, var8);
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   private void func_74572_a(URL p_74572_1_, File p_74572_2_, long p_74572_3_) throws IOException {
      byte[] var5 = new byte[4096];
      DataInputStream var6 = new DataInputStream(p_74572_1_.openStream());
      DataOutputStream var7 = new DataOutputStream(new FileOutputStream(p_74572_2_));
      boolean var8 = false;

      do {
         int var9;
         if((var9 = var6.read(var5)) < 0) {
            var6.close();
            var7.close();
            return;
         }

         var7.write(var5, 0, var9);
      } while(!this.field_74578_c);

   }

   public void func_74574_b() {
      this.field_74578_c = true;
   }
}
