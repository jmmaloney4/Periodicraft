package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import net.minecraft.client.CanvasMinecraftApplet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftAppletImpl;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class MinecraftApplet extends Applet {

   private Canvas field_71483_a;
   private Minecraft field_71481_b;
   private Thread field_71482_c = null;


   public void init() {
      this.field_71483_a = new CanvasMinecraftApplet(this);
      boolean var1 = "true".equalsIgnoreCase(this.getParameter("fullscreen"));
      this.field_71481_b = new MinecraftAppletImpl(this, this.field_71483_a, this, this.getWidth(), this.getHeight(), var1);
      this.field_71481_b.field_71450_k = this.getDocumentBase().getHost();
      if(this.getDocumentBase().getPort() > 0) {
         this.field_71481_b.field_71450_k = this.field_71481_b.field_71450_k + ":" + this.getDocumentBase().getPort();
      }

      if(this.getParameter("username") != null && this.getParameter("sessionid") != null) {
         this.field_71481_b.field_71449_j = new Session(this.getParameter("username"), this.getParameter("sessionid"));
         this.field_71481_b.func_98033_al().func_98233_a("Setting user: " + this.field_71481_b.field_71449_j.field_74286_b);
         System.out.println("(Session ID is " + this.field_71481_b.field_71449_j.field_74287_c + ")");
      } else {
         this.field_71481_b.field_71449_j = new Session("Player", "");
      }

      this.field_71481_b.func_71390_a("true".equals(this.getParameter("demo")));
      if(this.getParameter("server") != null && this.getParameter("port") != null) {
         this.field_71481_b.func_71367_a(this.getParameter("server"), Integer.parseInt(this.getParameter("port")));
      }

      this.field_71481_b.field_71448_m = !"true".equals(this.getParameter("stand-alone"));
      this.setLayout(new BorderLayout());
      this.add(this.field_71483_a, "Center");
      this.field_71483_a.setFocusable(true);
      this.field_71483_a.setFocusTraversalKeysEnabled(false);
      this.validate();
   }

   public void func_71479_a() {
      if(this.field_71482_c == null) {
         this.field_71482_c = new Thread(this.field_71481_b, "Minecraft main thread");
         this.field_71482_c.start();
      }
   }

   public void start() {
      if(this.field_71481_b != null) {
         this.field_71481_b.field_71445_n = false;
      }

   }

   public void stop() {
      if(this.field_71481_b != null) {
         this.field_71481_b.field_71445_n = true;
      }

   }

   public void destroy() {
      this.func_71480_b();
   }

   public void func_71480_b() {
      if(this.field_71482_c != null) {
         this.field_71481_b.func_71400_g();

         try {
            this.field_71482_c.join(10000L);
         } catch (InterruptedException var4) {
            try {
               this.field_71481_b.func_71405_e();
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }

         this.field_71482_c = null;
      }
   }
}
