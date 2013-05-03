package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.IProgressUpdate;

@SideOnly(Side.CLIENT)
public class GuiProgress extends GuiScreen implements IProgressUpdate {

   private String field_74265_a = "";
   private String field_74263_b = "";
   private int field_74264_c = 0;
   private boolean field_74262_d;


   public void func_73720_a(String p_73720_1_) {
      this.func_73721_b(p_73720_1_);
   }

   public void func_73721_b(String p_73721_1_) {
      this.field_74265_a = p_73721_1_;
      this.func_73719_c("Working...");
   }

   public void func_73719_c(String p_73719_1_) {
      this.field_74263_b = p_73719_1_;
      this.func_73718_a(0);
   }

   public void func_73718_a(int p_73718_1_) {
      this.field_74264_c = p_73718_1_;
   }

   public void func_73717_a() {
      this.field_74262_d = true;
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      if(this.field_74262_d) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
      } else {
         this.func_73873_v_();
         this.func_73732_a(this.field_73886_k, this.field_74265_a, this.field_73880_f / 2, 70, 16777215);
         this.func_73732_a(this.field_73886_k, this.field_74263_b + " " + this.field_74264_c + "%", this.field_73880_f / 2, 90, 16777215);
         super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      }
   }
}
