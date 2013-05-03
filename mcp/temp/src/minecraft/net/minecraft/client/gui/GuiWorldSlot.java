package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Date;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.storage.SaveFormatComparator;

@SideOnly(Side.CLIENT)
class GuiWorldSlot extends GuiSlot {

   // $FF: synthetic field
   final GuiSelectWorld field_77254_a;


   public GuiWorldSlot(GuiSelectWorld p_i3062_1_) {
      super(p_i3062_1_.field_73882_e, p_i3062_1_.field_73880_f, p_i3062_1_.field_73881_g, 32, p_i3062_1_.field_73881_g - 64, 36);
      this.field_77254_a = p_i3062_1_;
   }

   protected int func_77217_a() {
      return GuiSelectWorld.func_74068_a(this.field_77254_a).size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      GuiSelectWorld.func_74072_a(this.field_77254_a, p_77213_1_);
      boolean var3 = GuiSelectWorld.func_74062_b(this.field_77254_a) >= 0 && GuiSelectWorld.func_74062_b(this.field_77254_a) < this.func_77217_a();
      GuiSelectWorld.func_74070_c(this.field_77254_a).field_73742_g = var3;
      GuiSelectWorld.func_74059_d(this.field_77254_a).field_73742_g = var3;
      GuiSelectWorld.func_74071_e(this.field_77254_a).field_73742_g = var3;
      GuiSelectWorld.func_82312_f(this.field_77254_a).field_73742_g = var3;
      if(p_77213_2_ && var3) {
         this.field_77254_a.func_74064_e(p_77213_1_);
      }

   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == GuiSelectWorld.func_74062_b(this.field_77254_a);
   }

   protected int func_77212_b() {
      return GuiSelectWorld.func_74068_a(this.field_77254_a).size() * 36;
   }

   protected void func_77221_c() {
      this.field_77254_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      SaveFormatComparator var6 = (SaveFormatComparator)GuiSelectWorld.func_74068_a(this.field_77254_a).get(p_77214_1_);
      String var7 = var6.func_75788_b();
      if(var7 == null || MathHelper.func_76139_a(var7)) {
         var7 = GuiSelectWorld.func_82313_g(this.field_77254_a) + " " + (p_77214_1_ + 1);
      }

      String var8 = var6.func_75786_a();
      var8 = var8 + " (" + GuiSelectWorld.func_82315_h(this.field_77254_a).format(new Date(var6.func_75784_e()));
      var8 = var8 + ")";
      String var9 = "";
      if(var6.func_75785_d()) {
         var9 = GuiSelectWorld.func_82311_i(this.field_77254_a) + " " + var9;
      } else {
         var9 = GuiSelectWorld.func_82314_j(this.field_77254_a)[var6.func_75790_f().func_77148_a()];
         if(var6.func_75789_g()) {
            var9 = EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("gameMode.hardcore") + EnumChatFormatting.RESET;
         }

         if(var6.func_75783_h()) {
            var9 = var9 + ", " + StatCollector.func_74838_a("selectWorld.cheats");
         }
      }

      this.field_77254_a.func_73731_b(this.field_77254_a.field_73886_k, var7, p_77214_2_ + 2, p_77214_3_ + 1, 16777215);
      this.field_77254_a.func_73731_b(this.field_77254_a.field_73886_k, var8, p_77214_2_ + 2, p_77214_3_ + 12, 8421504);
      this.field_77254_a.func_73731_b(this.field_77254_a.field_73886_k, var9, p_77214_2_ + 2, p_77214_3_ + 12 + 10, 8421504);
   }
}
