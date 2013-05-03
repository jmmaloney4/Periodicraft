package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiCreateFlatWorld;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.gen.FlatLayerInfo;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiCreateFlatWorldListSlot extends GuiSlot {

   public int field_82454_a;
   // $FF: synthetic field
   final GuiCreateFlatWorld field_82453_b;


   public GuiCreateFlatWorldListSlot(GuiCreateFlatWorld p_i5005_1_) {
      super(p_i5005_1_.field_73882_e, p_i5005_1_.field_73880_f, p_i5005_1_.field_73881_g, 43, p_i5005_1_.field_73881_g - 60, 24);
      this.field_82453_b = p_i5005_1_;
      this.field_82454_a = -1;
   }

   private void func_82452_a(int p_82452_1_, int p_82452_2_, ItemStack p_82452_3_) {
      this.func_82451_d(p_82452_1_ + 1, p_82452_2_ + 1);
      GL11.glEnable('\u803a');
      if(p_82452_3_ != null) {
         RenderHelper.func_74520_c();
         GuiCreateFlatWorld.func_82274_h().func_77015_a(this.field_82453_b.field_73886_k, this.field_82453_b.field_73882_e.field_71446_o, p_82452_3_, p_82452_1_ + 2, p_82452_2_ + 2);
         RenderHelper.func_74518_a();
      }

      GL11.glDisable('\u803a');
   }

   private void func_82451_d(int p_82451_1_, int p_82451_2_) {
      this.func_82450_b(p_82451_1_, p_82451_2_, 0, 0);
   }

   private void func_82450_b(int p_82450_1_, int p_82450_2_, int p_82450_3_, int p_82450_4_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_82453_b.field_73882_e.field_71446_o.func_98187_b("/gui/slot.png");
      Tessellator var9 = Tessellator.field_78398_a;
      var9.func_78382_b();
      var9.func_78374_a((double)(p_82450_1_ + 0), (double)(p_82450_2_ + 18), (double)this.field_82453_b.field_73735_i, (double)((float)(p_82450_3_ + 0) * 0.0078125F), (double)((float)(p_82450_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_82450_1_ + 18), (double)(p_82450_2_ + 18), (double)this.field_82453_b.field_73735_i, (double)((float)(p_82450_3_ + 18) * 0.0078125F), (double)((float)(p_82450_4_ + 18) * 0.0078125F));
      var9.func_78374_a((double)(p_82450_1_ + 18), (double)(p_82450_2_ + 0), (double)this.field_82453_b.field_73735_i, (double)((float)(p_82450_3_ + 18) * 0.0078125F), (double)((float)(p_82450_4_ + 0) * 0.0078125F));
      var9.func_78374_a((double)(p_82450_1_ + 0), (double)(p_82450_2_ + 0), (double)this.field_82453_b.field_73735_i, (double)((float)(p_82450_3_ + 0) * 0.0078125F), (double)((float)(p_82450_4_ + 0) * 0.0078125F));
      var9.func_78381_a();
   }

   protected int func_77217_a() {
      return GuiCreateFlatWorld.func_82271_a(this.field_82453_b).func_82650_c().size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      this.field_82454_a = p_77213_1_;
      this.field_82453_b.func_82270_g();
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == this.field_82454_a;
   }

   protected void func_77221_c() {}

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      FlatLayerInfo var6 = (FlatLayerInfo)GuiCreateFlatWorld.func_82271_a(this.field_82453_b).func_82650_c().get(GuiCreateFlatWorld.func_82271_a(this.field_82453_b).func_82650_c().size() - p_77214_1_ - 1);
      ItemStack var7 = var6.func_82659_b() == 0?null:new ItemStack(var6.func_82659_b(), 1, var6.func_82658_c());
      String var8 = var7 == null?"Air":Item.field_77698_e[var6.func_82659_b()].func_77653_i(var7);
      this.func_82452_a(p_77214_2_, p_77214_3_, var7);
      this.field_82453_b.field_73886_k.func_78276_b(var8, p_77214_2_ + 18 + 5, p_77214_3_ + 3, 16777215);
      String var9;
      if(p_77214_1_ == 0) {
         var9 = StatCollector.func_74837_a("createWorld.customize.flat.layer.top", new Object[]{Integer.valueOf(var6.func_82657_a())});
      } else if(p_77214_1_ == GuiCreateFlatWorld.func_82271_a(this.field_82453_b).func_82650_c().size() - 1) {
         var9 = StatCollector.func_74837_a("createWorld.customize.flat.layer.bottom", new Object[]{Integer.valueOf(var6.func_82657_a())});
      } else {
         var9 = StatCollector.func_74837_a("createWorld.customize.flat.layer", new Object[]{Integer.valueOf(var6.func_82657_a())});
      }

      this.field_82453_b.field_73886_k.func_78276_b(var9, p_77214_2_ + 2 + 213 - this.field_82453_b.field_73886_k.func_78256_a(var9), p_77214_3_ + 3, 16777215);
   }

   protected int func_77225_g() {
      return this.field_82453_b.field_73880_f - 70;
   }
}
