package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.ServerList;

@SideOnly(Side.CLIENT)
class NetClientWebTextures extends GuiScreen {

   // $FF: synthetic field
   final String field_74244_a;
   // $FF: synthetic field
   final NetClientHandler field_74243_b;


   NetClientWebTextures(NetClientHandler p_i3099_1_, String p_i3099_2_) {
      this.field_74243_b = p_i3099_1_;
      this.field_74244_a = p_i3099_2_;
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      this.field_73882_e = Minecraft.func_71410_x();
      if(this.field_73882_e.func_71362_z() != null) {
         this.field_73882_e.func_71362_z().func_78838_a(p_73878_1_);
         ServerList.func_78852_b(this.field_73882_e.func_71362_z());
      }

      if(p_73878_1_) {
         this.field_73882_e.field_71418_C.func_77296_a(this.field_74244_a);
      }

      this.field_73882_e.func_71373_a((GuiScreen)null);
   }
}
