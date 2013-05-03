package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class WorldProviderHell extends WorldProvider {

   public void func_76572_b() {
      this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 1.0F, 0.0F);
      this.field_76575_d = true;
      this.field_76576_e = true;
      this.field_76574_g = -1;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
      return this.field_76579_a.func_82732_R().func_72345_a(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
   }

   protected void func_76556_a() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_76573_f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public IChunkProvider func_76555_c() {
      return new ChunkProviderHell(this.field_76579_a, this.field_76579_a.func_72905_C());
   }

   public boolean func_76569_d() {
      return false;
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      return false;
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      return 0.5F;
   }

   public boolean func_76567_e() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
      return true;
   }

   public String func_80007_l() {
      return "Nether";
   }
}
