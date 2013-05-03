package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.ChatClickData;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.packet.Packet203AutoComplete;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class GuiChat extends GuiScreen {

   private String field_73898_b = "";
   private int field_73899_c = -1;
   private boolean field_73897_d = false;
   private boolean field_73905_m = false;
   private int field_73903_n = 0;
   private List field_73904_o = new ArrayList();
   private URI field_73902_p = null;
   protected GuiTextField field_73901_a;
   private String field_73900_q = "";


   public GuiChat() {}

   public GuiChat(String p_i3035_1_) {
      this.field_73900_q = p_i3035_1_;
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_73899_c = this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();
      this.field_73901_a = new GuiTextField(this.field_73886_k, 4, this.field_73881_g - 12, this.field_73880_f - 4, 12);
      this.field_73901_a.func_73804_f(100);
      this.field_73901_a.func_73786_a(false);
      this.field_73901_a.func_73796_b(true);
      this.field_73901_a.func_73782_a(this.field_73900_q);
      this.field_73901_a.func_73805_d(false);
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
      this.field_73882_e.field_71456_v.func_73827_b().func_73764_c();
   }

   public void func_73876_c() {
      this.field_73901_a.func_73780_a();
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_73905_m = false;
      if(p_73869_2_ == 15) {
         this.func_73895_u_();
      } else {
         this.field_73897_d = false;
      }

      if(p_73869_2_ == 1) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
      } else if(p_73869_2_ == 28) {
         String var3 = this.field_73901_a.func_73781_b().trim();
         if(var3.length() > 0) {
            this.field_73882_e.field_71456_v.func_73827_b().func_73767_b(var3);
            if(!this.field_73882_e.func_71409_c(var3)) {
               this.field_73882_e.field_71439_g.func_71165_d(var3);
            }
         }

         this.field_73882_e.func_71373_a((GuiScreen)null);
      } else if(p_73869_2_ == 200) {
         this.func_73892_a(-1);
      } else if(p_73869_2_ == 208) {
         this.func_73892_a(1);
      } else if(p_73869_2_ == 201) {
         this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(this.field_73882_e.field_71456_v.func_73827_b().func_96127_i() - 1);
      } else if(p_73869_2_ == 209) {
         this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(-this.field_73882_e.field_71456_v.func_73827_b().func_96127_i() + 1);
      } else {
         this.field_73901_a.func_73802_a(p_73869_1_, p_73869_2_);
      }

   }

   public void func_73867_d() {
      super.func_73867_d();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0) {
         if(var1 > 1) {
            var1 = 1;
         }

         if(var1 < -1) {
            var1 = -1;
         }

         if(!func_73877_p()) {
            var1 *= 7;
         }

         this.field_73882_e.field_71456_v.func_73827_b().func_73758_b(var1);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      if(p_73864_3_ == 0 && this.field_73882_e.field_71474_y.field_74359_p) {
         ChatClickData var4 = this.field_73882_e.field_71456_v.func_73827_b().func_73766_a(Mouse.getX(), Mouse.getY());
         if(var4 != null) {
            URI var5 = var4.func_78308_g();
            if(var5 != null) {
               if(this.field_73882_e.field_71474_y.field_74358_q) {
                  this.field_73902_p = var5;
                  this.field_73882_e.func_71373_a(new GuiConfirmOpenLink(this, var4.func_78309_f(), 0));
               } else {
                  this.func_73896_a(var5);
               }

               return;
            }
         }
      }

      this.field_73901_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(p_73878_2_ == 0) {
         if(p_73878_1_) {
            this.func_73896_a(this.field_73902_p);
         }

         this.field_73902_p = null;
         this.field_73882_e.func_71373_a(this);
      }

   }

   private void func_73896_a(URI p_73896_1_) {
      try {
         Class var2 = Class.forName("java.awt.Desktop");
         Object var3 = var2.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
         var2.getMethod("browse", new Class[]{URI.class}).invoke(var3, new Object[]{p_73896_1_});
      } catch (Throwable var4) {
         var4.printStackTrace();
      }

   }

   public void func_73895_u_() {
      String var3;
      if(this.field_73897_d) {
         this.field_73901_a.func_73777_b(this.field_73901_a.func_73798_a(-1, this.field_73901_a.func_73799_h(), false) - this.field_73901_a.func_73799_h());
         if(this.field_73903_n >= this.field_73904_o.size()) {
            this.field_73903_n = 0;
         }
      } else {
         int var1 = this.field_73901_a.func_73798_a(-1, this.field_73901_a.func_73799_h(), false);
         this.field_73904_o.clear();
         this.field_73903_n = 0;
         String var2 = this.field_73901_a.func_73781_b().substring(var1).toLowerCase();
         var3 = this.field_73901_a.func_73781_b().substring(0, this.field_73901_a.func_73799_h());
         this.func_73893_a(var3, var2);
         if(this.field_73904_o.isEmpty()) {
            return;
         }

         this.field_73897_d = true;
         this.field_73901_a.func_73777_b(var1 - this.field_73901_a.func_73799_h());
      }

      if(this.field_73904_o.size() > 1) {
         StringBuilder var4 = new StringBuilder();

         for(Iterator var5 = this.field_73904_o.iterator(); var5.hasNext(); var4.append(var3)) {
            var3 = (String)var5.next();
            if(var4.length() > 0) {
               var4.append(", ");
            }
         }

         this.field_73882_e.field_71456_v.func_73827_b().func_73763_a(var4.toString(), 1);
      }

      this.field_73901_a.func_73792_b((String)this.field_73904_o.get(this.field_73903_n++));
   }

   private void func_73893_a(String p_73893_1_, String p_73893_2_) {
      if(p_73893_1_.length() >= 1) {
         this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet203AutoComplete(p_73893_1_));
         this.field_73905_m = true;
      }
   }

   public void func_73892_a(int p_73892_1_) {
      int var2 = this.field_73899_c + p_73892_1_;
      int var3 = this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().size();
      if(var2 < 0) {
         var2 = 0;
      }

      if(var2 > var3) {
         var2 = var3;
      }

      if(var2 != this.field_73899_c) {
         if(var2 == var3) {
            this.field_73899_c = var3;
            this.field_73901_a.func_73782_a(this.field_73898_b);
         } else {
            if(this.field_73899_c == var3) {
               this.field_73898_b = this.field_73901_a.func_73781_b();
            }

            this.field_73901_a.func_73782_a((String)this.field_73882_e.field_71456_v.func_73827_b().func_73756_b().get(var2));
            this.field_73899_c = var2;
         }
      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      func_73734_a(2, this.field_73881_g - 14, this.field_73880_f - 2, this.field_73881_g - 2, Integer.MIN_VALUE);
      this.field_73901_a.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73894_a(String[] p_73894_1_) {
      if(this.field_73905_m) {
         this.field_73904_o.clear();
         String[] var2 = p_73894_1_;
         int var3 = p_73894_1_.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            if(var5.length() > 0) {
               this.field_73904_o.add(var5);
            }
         }

         if(this.field_73904_o.size() > 0) {
            this.field_73897_d = true;
            this.func_73895_u_();
         }
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
