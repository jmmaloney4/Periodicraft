package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.applet.Applet;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class MinecraftFakeLauncher extends Applet implements AppletStub {

   // $FF: synthetic field
   final Map field_74534_a;


   public MinecraftFakeLauncher(Map p_i3001_1_) {
      this.field_74534_a = p_i3001_1_;
   }

   public void appletResize(int p_appletResize_1_, int p_appletResize_2_) {}

   public boolean isActive() {
      return true;
   }

   public URL getDocumentBase() {
      try {
         return new URL("http://www.minecraft.net/game/");
      } catch (MalformedURLException var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public String getParameter(String p_getParameter_1_) {
      if(this.field_74534_a.containsKey(p_getParameter_1_)) {
         return (String)this.field_74534_a.get(p_getParameter_1_);
      } else {
         System.err.println("Client asked for parameter: " + p_getParameter_1_);
         return null;
      }
   }
}
