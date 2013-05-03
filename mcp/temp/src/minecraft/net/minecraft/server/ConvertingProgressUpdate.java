package net.minecraft.server;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IProgressUpdate;

public class ConvertingProgressUpdate implements IProgressUpdate {

   private long field_96245_b;
   // $FF: synthetic field
   final MinecraftServer field_74267_a;


   public ConvertingProgressUpdate(MinecraftServer p_i5002_1_) {
      this.field_74267_a = p_i5002_1_;
      this.field_96245_b = System.currentTimeMillis();
   }

   public void func_73720_a(String p_73720_1_) {}

   public void func_73718_a(int p_73718_1_) {
      if(System.currentTimeMillis() - this.field_96245_b >= 1000L) {
         this.field_96245_b = System.currentTimeMillis();
         this.field_74267_a.func_98033_al().func_98233_a("Converting... " + p_73718_1_ + "%");
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_73721_b(String p_73721_1_) {}

   @SideOnly(Side.CLIENT)
   public void func_73717_a() {}

   public void func_73719_c(String p_73719_1_) {}
}
