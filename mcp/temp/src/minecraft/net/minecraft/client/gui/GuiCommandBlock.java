package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiCommandBlock extends GuiScreen {

   private GuiTextField field_82318_a;
   private final TileEntityCommandBlock field_82317_b;
   private GuiButton field_100003_c;
   private GuiButton field_100002_d;


   public GuiCommandBlock(TileEntityCommandBlock p_i5009_1_) {
      this.field_82317_b = p_i5009_1_;
   }

   public void func_73876_c() {
      this.field_82318_a.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(this.field_100003_c = new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, var1.func_74805_b("gui.done")));
      this.field_73887_h.add(this.field_100002_d = new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, var1.func_74805_b("gui.cancel")));
      this.field_82318_a = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 150, 60, 300, 20);
      this.field_82318_a.func_73804_f(32767);
      this.field_82318_a.func_73796_b(true);
      this.field_82318_a.func_73782_a(this.field_82317_b.func_82353_c());
      this.field_100003_c.field_73742_g = this.field_82318_a.func_73781_b().trim().length() > 0;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a((GuiScreen)null);
         } else if(p_73875_1_.field_73741_f == 0) {
            String var2 = "MC|AdvCdm";
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            DataOutputStream var4 = new DataOutputStream(var3);

            try {
               var4.writeInt(this.field_82317_b.field_70329_l);
               var4.writeInt(this.field_82317_b.field_70330_m);
               var4.writeInt(this.field_82317_b.field_70327_n);
               Packet.func_73271_a(this.field_82318_a.func_73781_b(), var4);
               this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload(var2, var3.toByteArray()));
            } catch (Exception var6) {
               var6.printStackTrace();
            }

            this.field_73882_e.func_71373_a((GuiScreen)null);
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_82318_a.func_73802_a(p_73869_1_, p_73869_2_);
      this.field_100003_c.field_73742_g = this.field_82318_a.func_73781_b().trim().length() > 0;
      if(p_73869_2_ != 28 && p_73869_1_ != 13) {
         if(p_73869_2_ == 1) {
            this.func_73875_a(this.field_100002_d);
         }
      } else {
         this.func_73875_a(this.field_100003_c);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_82318_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("advMode.setCommand"), this.field_73880_f / 2, this.field_73881_g / 4 - 60 + 20, 16777215);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("advMode.command"), this.field_73880_f / 2 - 150, 47, 10526880);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("advMode.nearestPlayer"), this.field_73880_f / 2 - 150, 97, 10526880);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("advMode.randomPlayer"), this.field_73880_f / 2 - 150, 108, 10526880);
      this.func_73731_b(this.field_73886_k, var4.func_74805_b("advMode.allPlayers"), this.field_73880_f / 2 - 150, 119, 10526880);
      this.field_82318_a.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
