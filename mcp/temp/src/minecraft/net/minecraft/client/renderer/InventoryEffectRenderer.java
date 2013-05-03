package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class InventoryEffectRenderer extends GuiContainer {

   private boolean field_74222_o;


   public InventoryEffectRenderer(Container p_i3084_1_) {
      super(p_i3084_1_);
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      if(!this.field_73882_e.field_71439_g.func_70651_bq().isEmpty()) {
         this.field_74198_m = 160 + (this.field_73880_f - this.field_74194_b - 200) / 2;
         this.field_74222_o = true;
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      if(this.field_74222_o) {
         this.func_74221_h();
      }

   }

   private void func_74221_h() {
      int var1 = this.field_74198_m - 124;
      int var2 = this.field_74197_n;
      Collection var4 = this.field_73882_e.field_71439_g.func_70651_bq();
      if(!var4.isEmpty()) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(2896);
         int var5 = 33;
         if(var4.size() > 5) {
            var5 = 132 / (var4.size() - 1);
         }

         for(Iterator var6 = this.field_73882_e.field_71439_g.func_70651_bq().iterator(); var6.hasNext(); var2 += var5) {
            PotionEffect var7 = (PotionEffect)var6.next();
            Potion var8 = Potion.field_76425_a[var7.func_76456_a()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_73882_e.field_71446_o.func_98187_b("/gui/inventory.png");
            this.func_73729_b(var1, var2, 0, 166, 140, 32);
            if(var8.func_76400_d()) {
               int var9 = var8.func_76392_e();
               this.func_73729_b(var1 + 6, var2 + 7, 0 + var9 % 8 * 18, 198 + var9 / 8 * 18, 18, 18);
            }

            String var11 = StatCollector.func_74838_a(var8.func_76393_a());
            if(var7.func_76458_c() == 1) {
               var11 = var11 + " II";
            } else if(var7.func_76458_c() == 2) {
               var11 = var11 + " III";
            } else if(var7.func_76458_c() == 3) {
               var11 = var11 + " IV";
            }

            this.field_73886_k.func_78261_a(var11, var1 + 10 + 18, var2 + 6, 16777215);
            String var10 = Potion.func_76389_a(var7);
            this.field_73886_k.func_78261_a(var10, var1 + 10 + 18, var2 + 6 + 10, 8355711);
         }

      }
   }
}
