package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.texturepacks.GuiTexturePacks;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiTexturePackSlot extends GuiSlot {

   // $FF: synthetic field
   final GuiTexturePacks field_77270_a;


   public GuiTexturePackSlot(GuiTexturePacks p_i3026_1_) {
      super(GuiTexturePacks.func_73950_a(p_i3026_1_), p_i3026_1_.field_73880_f, p_i3026_1_.field_73881_g, 32, p_i3026_1_.field_73881_g - 55 + 4, 36);
      this.field_77270_a = p_i3026_1_;
   }

   protected int func_77217_a() {
      return GuiTexturePacks.func_73955_b(this.field_77270_a).field_71418_C.func_77293_d().size();
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      List var3 = GuiTexturePacks.func_73958_c(this.field_77270_a).field_71418_C.func_77293_d();

      try {
         GuiTexturePacks.func_73951_d(this.field_77270_a).field_71418_C.func_77294_a((ITexturePack)var3.get(p_77213_1_));
         GuiTexturePacks.func_73952_e(this.field_77270_a).field_71446_o.func_78352_b();
         GuiTexturePacks.func_73962_f(this.field_77270_a).field_71438_f.func_72712_a();
      } catch (Exception var5) {
         GuiTexturePacks.func_73959_g(this.field_77270_a).field_71418_C.func_77294_a((ITexturePack)var3.get(0));
         GuiTexturePacks.func_73957_h(this.field_77270_a).field_71446_o.func_78352_b();
         GuiTexturePacks.func_73956_i(this.field_77270_a).field_71438_f.func_72712_a();
      }

   }

   protected boolean func_77218_a(int p_77218_1_) {
      List var2 = GuiTexturePacks.func_73953_j(this.field_77270_a).field_71418_C.func_77293_d();
      return GuiTexturePacks.func_73961_k(this.field_77270_a).field_71418_C.func_77292_e() == var2.get(p_77218_1_);
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 36;
   }

   protected void func_77221_c() {
      this.field_77270_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      ITexturePack var6 = (ITexturePack)GuiTexturePacks.func_96143_l(this.field_77270_a).field_71418_C.func_77293_d().get(p_77214_1_);
      var6.func_77535_b(GuiTexturePacks.func_96142_m(this.field_77270_a).field_71446_o);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      p_77214_5_.func_78382_b();
      p_77214_5_.func_78378_d(16777215);
      p_77214_5_.func_78374_a((double)p_77214_2_, (double)(p_77214_3_ + p_77214_4_), 0.0D, 0.0D, 1.0D);
      p_77214_5_.func_78374_a((double)(p_77214_2_ + 32), (double)(p_77214_3_ + p_77214_4_), 0.0D, 1.0D, 1.0D);
      p_77214_5_.func_78374_a((double)(p_77214_2_ + 32), (double)p_77214_3_, 0.0D, 1.0D, 0.0D);
      p_77214_5_.func_78374_a((double)p_77214_2_, (double)p_77214_3_, 0.0D, 0.0D, 0.0D);
      p_77214_5_.func_78381_a();
      String var7 = var6.func_77538_c();
      if(!var6.func_94179_g()) {
         var7 = EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("texturePack.incompatible") + " - " + var7;
      }

      if(var7.length() > 32) {
         var7 = var7.substring(0, 32).trim() + "...";
      }

      this.field_77270_a.func_73731_b(GuiTexturePacks.func_73954_n(this.field_77270_a), var7, p_77214_2_ + 32 + 2, p_77214_3_ + 1, 16777215);
      this.field_77270_a.func_73731_b(GuiTexturePacks.func_96145_o(this.field_77270_a), var6.func_77531_d(), p_77214_2_ + 32 + 2, p_77214_3_ + 12, 8421504);
      this.field_77270_a.func_73731_b(GuiTexturePacks.func_96144_p(this.field_77270_a), var6.func_77537_e(), p_77214_2_ + 32 + 2, p_77214_3_ + 12 + 10, 8421504);
   }
}
