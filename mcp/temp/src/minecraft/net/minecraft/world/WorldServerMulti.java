package net.minecraft.world;

import net.minecraft.logging.ILogAgent;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServerMulti extends WorldServer {

   public WorldServerMulti(MinecraftServer p_i11030_1_, ISaveHandler p_i11030_2_, String p_i11030_3_, int p_i11030_4_, WorldSettings p_i11030_5_, WorldServer p_i11030_6_, Profiler p_i11030_7_, ILogAgent p_i11030_8_) {
      super(p_i11030_1_, p_i11030_2_, p_i11030_3_, p_i11030_4_, p_i11030_5_, p_i11030_7_, p_i11030_8_);
      this.field_72988_C = p_i11030_6_.field_72988_C;
      this.field_96442_D = p_i11030_6_.func_96441_U();
      this.field_72986_A = new DerivedWorldInfo(p_i11030_6_.func_72912_H());
   }

   protected void func_73042_a() throws MinecraftException {}
}
