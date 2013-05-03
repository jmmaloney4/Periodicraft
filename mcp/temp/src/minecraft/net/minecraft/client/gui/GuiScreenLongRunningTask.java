package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.TaskLongRunning;

@SideOnly(Side.CLIENT)
public class GuiScreenLongRunningTask extends GuiScreen {

   private final int field_96213_b = 666;
   private final GuiScreen field_96215_c;
   private final Thread field_98118_d;
   private volatile String field_96212_d = "";
   private volatile boolean field_96219_n = false;
   private volatile String field_96220_o;
   private volatile boolean field_96218_p = false;
   private int field_96216_q = 0;
   private TaskLongRunning field_96214_r;
   public static final String[] field_96217_a = new String[]{"\u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583", "_ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584", "_ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585", "_ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586", "_ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587", "_ _ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588", "_ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587", "_ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586", "_ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585", "_ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584", "\u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583", "\u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _", "\u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _", "\u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _", "\u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _", "\u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _ _", "\u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _", "\u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _", "\u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _", "\u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _"};


   public GuiScreenLongRunningTask(Minecraft p_i10008_1_, GuiScreen p_i10008_2_, TaskLongRunning p_i10008_3_) {
      super.field_73887_h = Collections.synchronizedList(new ArrayList());
      this.field_73882_e = p_i10008_1_;
      this.field_96215_c = p_i10008_2_;
      this.field_96214_r = p_i10008_3_;
      p_i10008_3_.func_96574_a(this);
      this.field_98118_d = new Thread(p_i10008_3_);
   }

   public void func_98117_g() {
      this.field_98118_d.start();
   }

   public void func_73876_c() {
      super.func_73876_c();
      ++this.field_96216_q;
      this.field_96214_r.func_96573_a();
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

   public void func_73866_w_() {
      this.field_96214_r.func_96571_d();
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 666) {
         this.field_96218_p = true;
         this.field_73882_e.func_71373_a(this.field_96215_c);
      }

      this.field_96214_r.func_96572_a(p_73875_1_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_96212_d, this.field_73880_f / 2, this.field_73881_g / 2 - 50, 16777215);
      this.func_73732_a(this.field_73886_k, "", this.field_73880_f / 2, this.field_73881_g / 2 - 10, 16777215);
      if(!this.field_96219_n) {
         this.func_73732_a(this.field_73886_k, field_96217_a[this.field_96216_q % field_96217_a.length], this.field_73880_f / 2, this.field_73881_g / 2 + 15, 8421504);
      }

      if(this.field_96219_n) {
         this.func_73732_a(this.field_73886_k, this.field_96220_o, this.field_73880_f / 2, this.field_73881_g / 2 + 15, 16711680);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_96209_a(String p_96209_1_) {
      this.field_96219_n = true;
      this.field_96220_o = p_96209_1_;
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(666, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, "Back"));
   }

   public Minecraft func_96208_g() {
      return this.field_73882_e;
   }

   public void func_96210_b(String p_96210_1_) {
      this.field_96212_d = p_96210_1_;
   }

   public boolean func_96207_h() {
      return this.field_96218_p;
   }

}
