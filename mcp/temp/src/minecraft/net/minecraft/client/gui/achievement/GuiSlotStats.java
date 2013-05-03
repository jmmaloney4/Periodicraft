package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.stats.StatCrafting;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
abstract class GuiSlotStats extends GuiSlot {

   protected int field_77262_g;
   protected List field_77266_h;
   protected Comparator field_77267_i;
   protected int field_77264_j;
   protected int field_77265_k;
   // $FF: synthetic field
   final GuiStats field_77263_l;


   protected GuiSlotStats(GuiStats p_i3071_1_) {
      super(GuiStats.func_74139_f(p_i3071_1_), p_i3071_1_.field_73880_f, p_i3071_1_.field_73881_g, 32, p_i3071_1_.field_73881_g - 64, 20);
      this.field_77263_l = p_i3071_1_;
      this.field_77262_g = -1;
      this.field_77264_j = -1;
      this.field_77265_k = 0;
      this.func_77216_a(false);
      this.func_77223_a(true, 20);
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {}

   protected boolean func_77218_a(int p_77218_1_) {
      return false;
   }

   protected void func_77221_c() {
      this.field_77263_l.func_73873_v_();
   }

   protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_) {
      if(!Mouse.isButtonDown(0)) {
         this.field_77262_g = -1;
      }

      if(this.field_77262_g == 0) {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 115 - 18, p_77222_2_ + 1, 0, 0);
      } else {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 115 - 18, p_77222_2_ + 1, 0, 18);
      }

      if(this.field_77262_g == 1) {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 165 - 18, p_77222_2_ + 1, 0, 0);
      } else {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 165 - 18, p_77222_2_ + 1, 0, 18);
      }

      if(this.field_77262_g == 2) {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 215 - 18, p_77222_2_ + 1, 0, 0);
      } else {
         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + 215 - 18, p_77222_2_ + 1, 0, 18);
      }

      if(this.field_77264_j != -1) {
         short var4 = 79;
         byte var5 = 18;
         if(this.field_77264_j == 1) {
            var4 = 129;
         } else if(this.field_77264_j == 2) {
            var4 = 179;
         }

         if(this.field_77265_k == 1) {
            var5 = 36;
         }

         GuiStats.func_74134_a(this.field_77263_l, p_77222_1_ + var4, p_77222_2_ + 1, var5, 0);
      }

   }

   protected void func_77224_a(int p_77224_1_, int p_77224_2_) {
      this.field_77262_g = -1;
      if(p_77224_1_ >= 79 && p_77224_1_ < 115) {
         this.field_77262_g = 0;
      } else if(p_77224_1_ >= 129 && p_77224_1_ < 165) {
         this.field_77262_g = 1;
      } else if(p_77224_1_ >= 179 && p_77224_1_ < 215) {
         this.field_77262_g = 2;
      }

      if(this.field_77262_g >= 0) {
         this.func_77261_e(this.field_77262_g);
         GuiStats.func_74133_g(this.field_77263_l).field_71416_A.func_77366_a("random.click", 1.0F, 1.0F);
      }

   }

   protected final int func_77217_a() {
      return this.field_77266_h.size();
   }

   protected final StatCrafting func_77257_d(int p_77257_1_) {
      return (StatCrafting)this.field_77266_h.get(p_77257_1_);
   }

   protected abstract String func_77258_c(int var1);

   protected void func_77260_a(StatCrafting p_77260_1_, int p_77260_2_, int p_77260_3_, boolean p_77260_4_) {
      String var5;
      if(p_77260_1_ != null) {
         var5 = p_77260_1_.func_75968_a(GuiStats.func_74127_c(this.field_77263_l).func_77444_a(p_77260_1_));
         this.field_77263_l.func_73731_b(GuiStats.func_74129_h(this.field_77263_l), var5, p_77260_2_ - GuiStats.func_74146_i(this.field_77263_l).func_78256_a(var5), p_77260_3_ + 5, p_77260_4_?16777215:9474192);
      } else {
         var5 = "-";
         this.field_77263_l.func_73731_b(GuiStats.func_74135_j(this.field_77263_l), var5, p_77260_2_ - GuiStats.func_74148_k(this.field_77263_l).func_78256_a(var5), p_77260_3_ + 5, p_77260_4_?16777215:9474192);
      }

   }

   protected void func_77215_b(int p_77215_1_, int p_77215_2_) {
      if(p_77215_2_ >= this.field_77231_b && p_77215_2_ <= this.field_77232_c) {
         int var3 = this.func_77210_c(p_77215_1_, p_77215_2_);
         int var4 = this.field_77263_l.field_73880_f / 2 - 92 - 16;
         if(var3 >= 0) {
            if(p_77215_1_ < var4 + 40 || p_77215_1_ > var4 + 40 + 20) {
               return;
            }

            StatCrafting var5 = this.func_77257_d(var3);
            this.func_77259_a(var5, p_77215_1_, p_77215_2_);
         } else {
            String var9 = "";
            if(p_77215_1_ >= var4 + 115 - 18 && p_77215_1_ <= var4 + 115) {
               var9 = this.func_77258_c(0);
            } else if(p_77215_1_ >= var4 + 165 - 18 && p_77215_1_ <= var4 + 165) {
               var9 = this.func_77258_c(1);
            } else {
               if(p_77215_1_ < var4 + 215 - 18 || p_77215_1_ > var4 + 215) {
                  return;
               }

               var9 = this.func_77258_c(2);
            }

            var9 = ("" + StringTranslate.func_74808_a().func_74805_b(var9)).trim();
            if(var9.length() > 0) {
               int var6 = p_77215_1_ + 12;
               int var7 = p_77215_2_ - 12;
               int var8 = GuiStats.func_74147_l(this.field_77263_l).func_78256_a(var9);
               GuiStats.func_74149_a(this.field_77263_l, var6 - 3, var7 - 3, var6 + var8 + 3, var7 + 8 + 3, -1073741824, -1073741824);
               GuiStats.func_74141_m(this.field_77263_l).func_78261_a(var9, var6, var7, -1);
            }
         }

      }
   }

   protected void func_77259_a(StatCrafting p_77259_1_, int p_77259_2_, int p_77259_3_) {
      if(p_77259_1_ != null) {
         Item var4 = Item.field_77698_e[p_77259_1_.func_75982_a()];
         String var5 = ("" + StringTranslate.func_74808_a().func_74809_c(var4.func_77658_a())).trim();
         if(var5.length() > 0) {
            int var6 = p_77259_2_ + 12;
            int var7 = p_77259_3_ - 12;
            int var8 = GuiStats.func_74140_n(this.field_77263_l).func_78256_a(var5);
            GuiStats.func_74136_b(this.field_77263_l, var6 - 3, var7 - 3, var6 + var8 + 3, var7 + 8 + 3, -1073741824, -1073741824);
            GuiStats.func_74144_o(this.field_77263_l).func_78261_a(var5, var6, var7, -1);
         }

      }
   }

   protected void func_77261_e(int p_77261_1_) {
      if(p_77261_1_ != this.field_77264_j) {
         this.field_77264_j = p_77261_1_;
         this.field_77265_k = -1;
      } else if(this.field_77265_k == -1) {
         this.field_77265_k = 1;
      } else {
         this.field_77264_j = -1;
         this.field_77265_k = 0;
      }

      Collections.sort(this.field_77266_h, this.field_77267_i);
   }
}
