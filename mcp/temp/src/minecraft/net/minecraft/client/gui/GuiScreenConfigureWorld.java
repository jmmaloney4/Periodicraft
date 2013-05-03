package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfirmation;
import net.minecraft.client.gui.GuiScreenEditOnlineWorld;
import net.minecraft.client.gui.GuiScreenInvite;
import net.minecraft.client.gui.GuiScreenOnlineServers;
import net.minecraft.client.gui.GuiScreenResetWorld;
import net.minecraft.client.gui.GuiScreenSubscription;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.SelectionListInvited;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenConfigureWorld extends GuiScreen {

   private final GuiScreen field_96285_a;
   private McoServer field_96280_b;
   private SelectionListInvited field_96282_c;
   private int field_96277_d;
   private int field_96286_n;
   private int field_96287_o;
   private int field_96284_p = -1;
   private String field_96283_q;
   private GuiButton field_96281_r;
   private GuiButton field_96279_s;
   private GuiButton field_96278_t;
   private GuiButton field_96276_u;
   private GuiButton field_98128_v;
   private GuiButton field_98127_w;
   private GuiButton field_98129_x;
   private boolean field_102020_y;


   public GuiScreenConfigureWorld(GuiScreen p_i10006_1_, McoServer p_i10006_2_) {
      this.field_96285_a = p_i10006_1_;
      this.field_96280_b = p_i10006_2_;
   }

   public void func_73876_c() {}

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_96277_d = this.field_73880_f / 2 - 200;
      this.field_96286_n = 180;
      this.field_96287_o = this.field_73880_f / 2;
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      if(this.field_96280_b.field_96404_d.equals("CLOSED")) {
         this.field_73887_h.add(this.field_96281_r = new GuiButton(0, this.field_96277_d, this.func_96264_a(12), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.open")));
         this.field_96281_r.field_73742_g = !this.field_96280_b.field_98166_h;
      } else {
         this.field_73887_h.add(this.field_96279_s = new GuiButton(1, this.field_96277_d, this.func_96264_a(12), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.close")));
         this.field_96279_s.field_73742_g = !this.field_96280_b.field_98166_h;
      }

      this.field_73887_h.add(this.field_98129_x = new GuiButton(7, this.field_96277_d + this.field_96286_n / 2 + 2, this.func_96264_a(12), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.subscription")));
      this.field_73887_h.add(this.field_96278_t = new GuiButton(5, this.field_96277_d, this.func_96264_a(10), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.edit")));
      this.field_73887_h.add(this.field_96276_u = new GuiButton(6, this.field_96277_d + this.field_96286_n / 2 + 2, this.func_96264_a(10), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.reset")));
      this.field_73887_h.add(this.field_98128_v = new GuiButton(4, this.field_96287_o, this.func_96264_a(10), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.invite")));
      this.field_73887_h.add(this.field_98127_w = new GuiButton(3, this.field_96287_o + this.field_96286_n / 2 + 2, this.func_96264_a(10), this.field_96286_n / 2 - 2, 20, var1.func_74805_b("mco.configure.world.buttons.uninvite")));
      this.field_73887_h.add(new GuiButton(10, this.field_96287_o, this.func_96264_a(12), this.field_96286_n, 20, var1.func_74805_b("gui.back")));
      this.field_96282_c = new SelectionListInvited(this);
      this.field_96278_t.field_73742_g = !this.field_96280_b.field_98166_h;
      this.field_96276_u.field_73742_g = !this.field_96280_b.field_98166_h;
      this.field_98128_v.field_73742_g = !this.field_96280_b.field_98166_h;
      this.field_98127_w.field_73742_g = !this.field_96280_b.field_98166_h;
   }

   private int func_96264_a(int p_96264_1_) {
      return 40 + p_96264_1_ * 13;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 10) {
            if(this.field_102020_y) {
               ((GuiScreenOnlineServers)this.field_96285_a).func_102018_a(this.field_96280_b.field_96408_a);
            }

            this.field_73882_e.func_71373_a(this.field_96285_a);
         } else if(p_73875_1_.field_73741_f == 5) {
            this.field_73882_e.func_71373_a(new GuiScreenEditOnlineWorld(this, this.field_96285_a, this.field_96280_b));
         } else if(p_73875_1_.field_73741_f == 1) {
            StringTranslate var2 = StringTranslate.func_74808_a();
            String var3 = var2.func_74805_b("mco.configure.world.close.question.line1");
            String var4 = var2.func_74805_b("mco.configure.world.close.question.line2");
            this.field_73882_e.func_71373_a(new GuiScreenConfirmation(this, "Warning!", var3, var4, 1));
         } else if(p_73875_1_.field_73741_f == 0) {
            this.func_96268_g();
         } else if(p_73875_1_.field_73741_f == 4) {
            this.field_73882_e.func_71373_a(new GuiScreenInvite(this.field_96285_a, this, this.field_96280_b));
         } else if(p_73875_1_.field_73741_f == 3) {
            this.func_96272_i();
         } else if(p_73875_1_.field_73741_f == 6) {
            this.field_73882_e.func_71373_a(new GuiScreenResetWorld(this, this.field_96280_b));
         } else if(p_73875_1_.field_73741_f == 7) {
            this.field_73882_e.func_71373_a(new GuiScreenSubscription(this, this.field_96280_b));
         }

      }
   }

   private void func_96268_g() {
      McoClient var1 = new McoClient(this.field_73882_e.field_71449_j);

      try {
         Boolean var2 = var1.func_96383_b(this.field_96280_b.field_96408_a);
         if(var2.booleanValue()) {
            this.field_102020_y = true;
            this.field_96280_b.field_96404_d = "OPEN";
            this.func_73866_w_();
         }
      } catch (ExceptionMcoService var3) {
         ;
      } catch (IOException var4) {
         ;
      }

   }

   private void func_96275_h() {
      McoClient var1 = new McoClient(this.field_73882_e.field_71449_j);

      try {
         boolean var2 = var1.func_96378_c(this.field_96280_b.field_96408_a).booleanValue();
         if(var2) {
            this.field_102020_y = true;
            this.field_96280_b.field_96404_d = "CLOSED";
            this.func_73866_w_();
         }
      } catch (ExceptionMcoService var3) {
         ;
      } catch (IOException var4) {
         ;
      }

   }

   private void func_96272_i() {
      if(this.field_96284_p >= 0 && this.field_96284_p < this.field_96280_b.field_96402_f.size()) {
         this.field_96283_q = (String)this.field_96280_b.field_96402_f.get(this.field_96284_p);
         StringTranslate var1 = StringTranslate.func_74808_a();
         GuiYesNo var2 = new GuiYesNo(this, "Warning!", var1.func_74805_b("mco.configure.world.uninvite.question") + " \'" + this.field_96283_q + "\'", 3);
         this.field_73882_e.func_71373_a(var2);
      }

   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(p_73878_2_ == 3) {
         if(p_73878_1_) {
            McoClient var3 = new McoClient(this.field_73882_e.field_71449_j);

            try {
               var3.func_96381_a(this.field_96280_b.field_96408_a, this.field_96283_q);
            } catch (ExceptionMcoService var5) {
               System.err.println("Could not uninvite the selected user");
            }

            this.func_96267_d(this.field_96284_p);
         }

         this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this.field_96285_a, this.field_96280_b));
      }

      if(p_73878_2_ == 1) {
         if(p_73878_1_) {
            this.func_96275_h();
         }

         this.field_73882_e.func_71373_a(this);
      }

   }

   private void func_96267_d(int p_96267_1_) {
      this.field_96280_b.field_96402_f.remove(p_96267_1_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.field_96282_c.func_96612_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.configure.world.title"), this.field_73880_f / 2, 17, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.name"), this.field_96277_d, this.func_96264_a(1), 10526880);
      this.func_73731_b(this.field_73886_k, this.field_96280_b.func_96398_b(), this.field_96277_d, this.func_96264_a(2), 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.description"), this.field_96277_d, this.func_96264_a(4), 10526880);
      this.func_73731_b(this.field_73886_k, this.field_96280_b.func_96397_a(), this.field_96277_d, this.func_96264_a(5), 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.owner"), this.field_96277_d, this.func_96264_a(7), 10526880);
      this.func_73731_b(this.field_73886_k, this.field_96280_b.field_96405_e, this.field_96277_d, this.func_96264_a(8), 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.invited"), this.field_96287_o, this.func_96264_a(1), 10526880);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   // $FF: synthetic method
   static Minecraft func_96265_a(GuiScreenConfigureWorld p_96265_0_) {
      return p_96265_0_.field_73882_e;
   }

   // $FF: synthetic method
   static int func_96271_b(GuiScreenConfigureWorld p_96271_0_) {
      return p_96271_0_.field_96287_o;
   }

   // $FF: synthetic method
   static int func_96274_a(GuiScreenConfigureWorld p_96274_0_, int p_96274_1_) {
      return p_96274_0_.func_96264_a(p_96274_1_);
   }

   // $FF: synthetic method
   static int func_96269_c(GuiScreenConfigureWorld p_96269_0_) {
      return p_96269_0_.field_96286_n;
   }

   // $FF: synthetic method
   static McoServer func_96266_d(GuiScreenConfigureWorld p_96266_0_) {
      return p_96266_0_.field_96280_b;
   }

   // $FF: synthetic method
   static int func_96270_b(GuiScreenConfigureWorld p_96270_0_, int p_96270_1_) {
      return p_96270_0_.field_96284_p = p_96270_1_;
   }

   // $FF: synthetic method
   static int func_96263_e(GuiScreenConfigureWorld p_96263_0_) {
      return p_96263_0_.field_96284_p;
   }

   // $FF: synthetic method
   static FontRenderer func_96273_f(GuiScreenConfigureWorld p_96273_0_) {
      return p_96273_0_.field_73886_k;
   }
}
