package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;

public class WorldProviderEnd extends WorldProvider {

   public void func_76572_b() {
      this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.5F, 0.0F);
      this.field_76574_g = 1;
      this.field_76576_e = true;
   }

   public IChunkProvider func_76555_c() {
      return new ChunkProviderEnd(this.field_76579_a, this.field_76579_a.func_72905_C());
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      return 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
      return null;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
      int var3 = 10518688;
      float var4 = MathHelper.func_76134_b(p_76562_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      float var5 = (float)(var3 >> 16 & 255) / 255.0F;
      float var6 = (float)(var3 >> 8 & 255) / 255.0F;
      float var7 = (float)(var3 & 255) / 255.0F;
      var5 *= var4 * 0.0F + 0.15F;
      var6 *= var4 * 0.0F + 0.15F;
      var7 *= var4 * 0.0F + 0.15F;
      return this.field_76579_a.func_82732_R().func_72345_a((double)var5, (double)var6, (double)var7);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76561_g() {
      return false;
   }

   public boolean func_76567_e() {
      return false;
   }

   public boolean func_76569_d() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float func_76571_f() {
      return 8.0F;
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      int var3 = this.field_76579_a.func_72922_b(p_76566_1_, p_76566_2_);
      return var3 == 0?false:Block.field_71973_m[var3].field_72018_cp.func_76230_c();
   }

   public ChunkCoordinates func_76554_h() {
      return new ChunkCoordinates(100, 50, 0);
   }

   public int func_76557_i() {
      return 50;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
      return true;
   }

   public String func_80007_l() {
      return "The End";
   }
}
