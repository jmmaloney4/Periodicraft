package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.ValueObjectSubscription;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenSubscription extends GuiScreen {

   private final GuiScreen field_98067_a;
   private final McoServer field_98065_b;
   private final int field_98066_c = 0;
   private final int field_98064_d = 1;
   private int field_98068_n;
   private String field_98069_o;


   public GuiScreenSubscription(GuiScreen p_i11004_1_, McoServer p_i11004_2_) {
      this.field_98067_a = p_i11004_1_;
      this.field_98065_b = p_i11004_2_;
   }

   public void func_73876_c() {}

   public void func_73866_w_() {
      this.func_98063_a(this.field_98065_b.field_96408_a);
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
   }

   private void func_98063_a(long p_98063_1_) {
      McoClient var3 = new McoClient(this.field_73882_e.field_71449_j);

      try {
         ValueObjectSubscription var4 = var3.func_98177_f(p_98063_1_);
         this.field_98068_n = var4.field_98170_b;
         this.field_98069_o = this.func_98062_b(var4.field_98171_a);
      } catch (ExceptionMcoService var5) {
         ;
      } catch (IOException var6) {
         ;
      }

   }

   private String func_98062_b(long p_98062_1_) {
      GregorianCalendar var3 = new GregorianCalendar(TimeZone.getDefault());
      var3.setTimeInMillis(p_98062_1_);
      return SimpleDateFormat.getDateTimeInstance().format(var3.getTime());
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a(this.field_98067_a);
         } else if(p_73875_1_.field_73741_f == 1) {
            ;
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("mco.configure.world.subscription.title"), this.field_73880_f / 2, 17, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.subscription.start"), this.field_73880_f / 2 - 100, 53, 10526880);
      this.func_73731_b(this.field_73886_k, this.field_98069_o, this.field_73880_f / 2 - 100, 66, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("mco.configure.world.subscription.daysleft"), this.field_73880_f / 2 - 100, 85, 10526880);
      this.func_73731_b(this.field_73886_k, String.valueOf(this.field_98068_n), this.field_73880_f / 2 - 100, 98, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
