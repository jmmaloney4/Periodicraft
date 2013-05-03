package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.PlayerCapabilities;

public enum EnumGameType {

   NOT_SET("NOT_SET", 0, -1, ""),
   SURVIVAL("SURVIVAL", 1, 0, "survival"),
   CREATIVE("CREATIVE", 2, 1, "creative"),
   ADVENTURE("ADVENTURE", 3, 2, "adventure");
   int field_77154_e;
   String field_77151_f;
   // $FF: synthetic field
   private static final EnumGameType[] $VALUES = new EnumGameType[]{NOT_SET, SURVIVAL, CREATIVE, ADVENTURE};


   private EnumGameType(String p_i3734_1_, int p_i3734_2_, int p_i3734_3_, String p_i3734_4_) {
      this.field_77154_e = p_i3734_3_;
      this.field_77151_f = p_i3734_4_;
   }

   public int func_77148_a() {
      return this.field_77154_e;
   }

   public String func_77149_b() {
      return this.field_77151_f;
   }

   public void func_77147_a(PlayerCapabilities p_77147_1_) {
      if(this == CREATIVE) {
         p_77147_1_.field_75101_c = true;
         p_77147_1_.field_75098_d = true;
         p_77147_1_.field_75102_a = true;
      } else {
         p_77147_1_.field_75101_c = false;
         p_77147_1_.field_75098_d = false;
         p_77147_1_.field_75102_a = false;
         p_77147_1_.field_75100_b = false;
      }

      p_77147_1_.field_75099_e = !this.func_82752_c();
   }

   public boolean func_82752_c() {
      return this == ADVENTURE;
   }

   public boolean func_77145_d() {
      return this == CREATIVE;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77144_e() {
      return this == SURVIVAL || this == ADVENTURE;
   }

   public static EnumGameType func_77146_a(int p_77146_0_) {
      EnumGameType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumGameType var4 = var1[var3];
         if(var4.field_77154_e == p_77146_0_) {
            return var4;
         }
      }

      return SURVIVAL;
   }

   @SideOnly(Side.CLIENT)
   public static EnumGameType func_77142_a(String p_77142_0_) {
      EnumGameType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumGameType var4 = var1[var3];
         if(var4.field_77151_f.equals(p_77142_0_)) {
            return var4;
         }
      }

      return SURVIVAL;
   }

}
