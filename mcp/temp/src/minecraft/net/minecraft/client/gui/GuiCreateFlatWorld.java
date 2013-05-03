package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorldListSlot;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.StatCollector;
import net.minecraft.world.gen.FlatGeneratorInfo;

@SideOnly(Side.CLIENT)
public class GuiCreateFlatWorld extends GuiScreen {

   private static RenderItem field_82282_a = new RenderItem();
   private final GuiCreateWorld field_82277_b;
   private FlatGeneratorInfo field_82279_c = FlatGeneratorInfo.func_82649_e();
   private String field_82276_d;
   private String field_82285_m;
   private String field_82283_n;
   private GuiCreateFlatWorldListSlot field_82284_o;
   private GuiButton field_82281_p;
   private GuiButton field_82280_q;
   private GuiButton field_82278_r;


   public GuiCreateFlatWorld(GuiCreateWorld p_i5004_1_, String p_i5004_2_) {
      this.field_82277_b = p_i5004_1_;
      this.func_82273_a(p_i5004_2_);
   }

   public String func_82275_e() {
      return this.field_82279_c.toString();
   }

   public void func_82273_a(String p_82273_1_) {
      this.field_82279_c = FlatGeneratorInfo.func_82651_a(p_82273_1_);
   }

   public void func_73866_w_() {
      this.field_73887_h.clear();
      this.field_82276_d = StatCollector.func_74838_a("createWorld.customize.flat.title");
      this.field_82285_m = StatCollector.func_74838_a("createWorld.customize.flat.tile");
      this.field_82283_n = StatCollector.func_74838_a("createWorld.customize.flat.height");
      this.field_82284_o = new GuiCreateFlatWorldListSlot(this);
      this.field_73887_h.add(this.field_82281_p = new GuiButton(2, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, StatCollector.func_74838_a("createWorld.customize.flat.addLayer") + " (NYI)"));
      this.field_73887_h.add(this.field_82280_q = new GuiButton(3, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, StatCollector.func_74838_a("createWorld.customize.flat.editLayer") + " (NYI)"));
      this.field_73887_h.add(this.field_82278_r = new GuiButton(4, this.field_73880_f / 2 - 155, this.field_73881_g - 52, 150, 20, StatCollector.func_74838_a("createWorld.customize.flat.removeLayer")));
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, StatCollector.func_74838_a("gui.done")));
      this.field_73887_h.add(new GuiButton(5, this.field_73880_f / 2 + 5, this.field_73881_g - 52, 150, 20, StatCollector.func_74838_a("createWorld.customize.presets")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, StatCollector.func_74838_a("gui.cancel")));
      this.field_82281_p.field_73748_h = this.field_82280_q.field_73748_h = false;
      this.field_82279_c.func_82645_d();
      this.func_82270_g();
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      int var2 = this.field_82279_c.func_82650_c().size() - this.field_82284_o.field_82454_a - 1;
      if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71373_a(this.field_82277_b);
      } else if(p_73875_1_.field_73741_f == 0) {
         this.field_82277_b.field_82290_a = this.func_82275_e();
         this.field_73882_e.func_71373_a(this.field_82277_b);
      } else if(p_73875_1_.field_73741_f == 5) {
         this.field_73882_e.func_71373_a(new GuiFlatPresets(this));
      } else if(p_73875_1_.field_73741_f == 4 && this.func_82272_i()) {
         this.field_82279_c.func_82650_c().remove(var2);
         this.field_82284_o.field_82454_a = Math.min(this.field_82284_o.field_82454_a, this.field_82279_c.func_82650_c().size() - 1);
      }

      this.field_82279_c.func_82645_d();
      this.func_82270_g();
   }

   public void func_82270_g() {
      boolean var1 = this.func_82272_i();
      this.field_82278_r.field_73742_g = var1;
      this.field_82280_q.field_73742_g = var1;
      this.field_82280_q.field_73742_g = false;
      this.field_82281_p.field_73742_g = false;
   }

   private boolean func_82272_i() {
      return this.field_82284_o.field_82454_a > -1 && this.field_82284_o.field_82454_a < this.field_82279_c.func_82650_c().size();
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.field_82284_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_82276_d, this.field_73880_f / 2, 8, 16777215);
      int var4 = this.field_73880_f / 2 - 92 - 16;
      this.func_73731_b(this.field_73886_k, this.field_82285_m, var4, 32, 16777215);
      this.func_73731_b(this.field_73886_k, this.field_82283_n, var4 + 2 + 213 - this.field_73886_k.func_78256_a(this.field_82283_n), 32, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   // $FF: synthetic method
   static RenderItem func_82274_h() {
      return field_82282_a;
   }

   // $FF: synthetic method
   static FlatGeneratorInfo func_82271_a(GuiCreateFlatWorld p_82271_0_) {
      return p_82271_0_.field_82279_c;
   }

}
