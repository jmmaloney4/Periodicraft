package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfigureWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenInvite extends GuiScreen {

   private GuiTextField field_96227_a;
   private McoServer field_96223_b;
   private final GuiScreen field_96224_c;
   private final GuiScreenConfigureWorld field_96222_d;
   private final int field_96228_n = 0;
   private final int field_96229_o = 1;
   private String field_101016_p = "Could not invite the provided name";
   private String field_96226_p;
   private boolean field_96225_q = false;


   public GuiScreenInvite(GuiScreen p_i22002_1_, GuiScreenConfigureWorld p_i22002_2_, McoServer p_i22002_3_) {
      this.field_96224_c = p_i22002_1_;
      this.field_96222_d = p_i22002_2_;
      this.field_96223_b = p_i22002_3_;
   }

   public void func_73876_c() {
      this.field_96227_a.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("mco.configure.world.buttons.invite")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_96227_a = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
      this.field_96227_a.func_73796_b(true);
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a(this.field_96222_d);
         } else if(p_73875_1_.field_73741_f == 0) {
            McoClient var2 = new McoClient(this.field_73882_e.field_71449_j);

            try {
               McoServer var3 = var2.func_96387_b(this.field_96223_b.field_96408_a, this.field_96227_a.func_73781_b());
               if(var3 != null) {
                  this.field_96223_b.field_96402_f = var3.field_96402_f;
                  this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this.field_96224_c, this.field_96223_b));
               } else {
                  this.func_101015_a(this.field_101016_p);
               }
            } catch (ExceptionMcoService var4) {
               this.func_101015_a(var4.field_96391_b);
            } catch (IOException var5) {
               this.func_101015_a(this.field_101016_p);
            }
         }

      }
   }

   private void func_101015_a(String p_101015_1_) {
      this.field_96225_q = true;
      this.field_96226_p = p_101015_1_;
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_96227_a.func_73802_a(p_73869_1_, p_73869_2_);
      if(p_73869_1_ == 9) {
         if(this.field_96227_a.func_73806_l()) {
            this.field_96227_a.func_73796_b(false);
         } else {
            this.field_96227_a.func_73796_b(true);
         }
      }

      if(p_73869_1_ == 13) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_96227_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b(""), this.field_73880_f / 2, 17, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.invite.profile.name"), this.field_73880_f / 2 - 100, 53, 10526880);
      if(this.field_96225_q) {
         this.func_73732_a(this.field_73886_k, this.field_96226_p, this.field_73880_f / 2, 100, 16711680);
      }

      this.field_96227_a.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
