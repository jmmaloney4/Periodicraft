package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class LanServer {

   private String field_77492_a;
   private String field_77490_b;
   private long field_77491_c;


   public LanServer(String p_i3119_1_, String p_i3119_2_) {
      this.field_77492_a = p_i3119_1_;
      this.field_77490_b = p_i3119_2_;
      this.field_77491_c = Minecraft.func_71386_F();
   }

   public String func_77487_a() {
      return this.field_77492_a;
   }

   public String func_77488_b() {
      return this.field_77490_b;
   }

   public void func_77489_c() {
      this.field_77491_c = Minecraft.func_71386_F();
   }
}
