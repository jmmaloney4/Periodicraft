package net.minecraft.client.gui.achievement;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.stats.Achievement;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiAchievement extends Gui {

   private Minecraft field_73856_a;
   private int field_73854_b;
   private int field_73855_c;
   private String field_73852_d;
   private String field_73853_e;
   private Achievement field_73850_f;
   private long field_73851_g;
   private RenderItem field_73858_h;
   private boolean field_73857_j;


   public GuiAchievement(Minecraft p_i3069_1_) {
      this.field_73856_a = p_i3069_1_;
      this.field_73858_h = new RenderItem();
   }

   public void func_73846_a(Achievement p_73846_1_) {
      this.field_73852_d = StatCollector.func_74838_a("achievement.get");
      this.field_73853_e = StatCollector.func_74838_a(p_73846_1_.func_75970_i());
      this.field_73851_g = Minecraft.func_71386_F();
      this.field_73850_f = p_73846_1_;
      this.field_73857_j = false;
   }

   public void func_73848_b(Achievement p_73848_1_) {
      this.field_73852_d = StatCollector.func_74838_a(p_73848_1_.func_75970_i());
      this.field_73853_e = p_73848_1_.func_75989_e();
      this.field_73851_g = Minecraft.func_71386_F() - 2500L;
      this.field_73850_f = p_73848_1_;
      this.field_73857_j = true;
   }

   private void func_73849_b() {
      GL11.glViewport(0, 0, this.field_73856_a.field_71443_c, this.field_73856_a.field_71440_d);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      this.field_73854_b = this.field_73856_a.field_71443_c;
      this.field_73855_c = this.field_73856_a.field_71440_d;
      ScaledResolution var1 = new ScaledResolution(this.field_73856_a.field_71474_y, this.field_73856_a.field_71443_c, this.field_73856_a.field_71440_d);
      this.field_73854_b = var1.func_78326_a();
      this.field_73855_c = var1.func_78328_b();
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, (double)this.field_73854_b, (double)this.field_73855_c, 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   public void func_73847_a() {
      if(this.field_73850_f != null && this.field_73851_g != 0L) {
         double var1 = (double)(Minecraft.func_71386_F() - this.field_73851_g) / 3000.0D;
         if(!this.field_73857_j && (var1 < 0.0D || var1 > 1.0D)) {
            this.field_73851_g = 0L;
         } else {
            this.func_73849_b();
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            double var3 = var1 * 2.0D;
            if(var3 > 1.0D) {
               var3 = 2.0D - var3;
            }

            var3 *= 4.0D;
            var3 = 1.0D - var3;
            if(var3 < 0.0D) {
               var3 = 0.0D;
            }

            var3 *= var3;
            var3 *= var3;
            int var5 = this.field_73854_b - 160;
            int var6 = 0 - (int)(var3 * 36.0D);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            this.field_73856_a.field_71446_o.func_98187_b("/achievement/bg.png");
            GL11.glDisable(2896);
            this.func_73729_b(var5, var6, 96, 202, 160, 32);
            if(this.field_73857_j) {
               this.field_73856_a.field_71466_p.func_78279_b(this.field_73853_e, var5 + 30, var6 + 7, 120, -1);
            } else {
               this.field_73856_a.field_71466_p.func_78276_b(this.field_73852_d, var5 + 30, var6 + 7, -256);
               this.field_73856_a.field_71466_p.func_78276_b(this.field_73853_e, var5 + 30, var6 + 18, -1);
            }

            RenderHelper.func_74520_c();
            GL11.glDisable(2896);
            GL11.glEnable('\u803a');
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            this.field_73858_h.func_82406_b(this.field_73856_a.field_71466_p, this.field_73856_a.field_71446_o, this.field_73850_f.field_75990_d, var5 + 8, var6 + 8);
            GL11.glDisable(2896);
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
         }
      }
   }
}
