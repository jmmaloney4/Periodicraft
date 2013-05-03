package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.FlatGeneratorInfo;

public abstract class WorldProvider {

   public World field_76579_a;
   public WorldType field_76577_b;
   public String field_82913_c;
   public WorldChunkManager field_76578_c;
   public boolean field_76575_d = false;
   public boolean field_76576_e = false;
   public float[] field_76573_f = new float[16];
   public int field_76574_g = 0;
   private float[] field_76580_h = new float[4];


   public final void func_76558_a(World p_76558_1_) {
      this.field_76579_a = p_76558_1_;
      this.field_76577_b = p_76558_1_.func_72912_H().func_76067_t();
      this.field_82913_c = p_76558_1_.func_72912_H().func_82571_y();
      this.func_76572_b();
      this.func_76556_a();
   }

   protected void func_76556_a() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_76573_f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   protected void func_76572_b() {
      if(this.field_76579_a.func_72912_H().func_76067_t() == WorldType.field_77138_c) {
         FlatGeneratorInfo var1 = FlatGeneratorInfo.func_82651_a(this.field_76579_a.func_72912_H().func_82571_y());
         this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76773_a[var1.func_82648_a()], 0.5F, 0.5F);
      } else {
         this.field_76578_c = new WorldChunkManager(this.field_76579_a);
      }

   }

   public IChunkProvider func_76555_c() {
      return (IChunkProvider)(this.field_76577_b == WorldType.field_77138_c?new ChunkProviderFlat(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r(), this.field_82913_c):new ChunkProviderGenerate(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r()));
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      int var3 = this.field_76579_a.func_72922_b(p_76566_1_, p_76566_2_);
      return var3 == Block.field_71980_u.field_71990_ca;
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      int var4 = (int)(p_76563_1_ % 24000L);
      float var5 = ((float)var4 + p_76563_3_) / 24000.0F - 0.25F;
      if(var5 < 0.0F) {
         ++var5;
      }

      if(var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }

   public int func_76559_b(long p_76559_1_) {
      return (int)(p_76559_1_ / 24000L) % 8;
   }

   public boolean func_76569_d() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
      float var3 = 0.4F;
      float var4 = MathHelper.func_76134_b(p_76560_1_ * 3.1415927F * 2.0F) - 0.0F;
      float var5 = -0.0F;
      if(var4 >= var5 - var3 && var4 <= var5 + var3) {
         float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
         float var7 = 1.0F - (1.0F - MathHelper.func_76126_a(var6 * 3.1415927F)) * 0.99F;
         var7 *= var7;
         this.field_76580_h[0] = var6 * 0.3F + 0.7F;
         this.field_76580_h[1] = var6 * var6 * 0.7F + 0.2F;
         this.field_76580_h[2] = var6 * var6 * 0.0F + 0.2F;
         this.field_76580_h[3] = var7;
         return this.field_76580_h;
      } else {
         return null;
      }
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
      float var3 = MathHelper.func_76134_b(p_76562_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = 0.7529412F;
      float var5 = 0.84705883F;
      float var6 = 1.0F;
      var4 *= var3 * 0.94F + 0.06F;
      var5 *= var3 * 0.94F + 0.06F;
      var6 *= var3 * 0.91F + 0.09F;
      return this.field_76579_a.func_82732_R().func_72345_a((double)var4, (double)var5, (double)var6);
   }

   public boolean func_76567_e() {
      return true;
   }

   public static WorldProvider func_76570_a(int p_76570_0_) {
      return (WorldProvider)(p_76570_0_ == -1?new WorldProviderHell():(p_76570_0_ == 0?new WorldProviderSurface():(p_76570_0_ == 1?new WorldProviderEnd():null)));
   }

   @SideOnly(Side.CLIENT)
   public float func_76571_f() {
      return 128.0F;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76561_g() {
      return true;
   }

   public ChunkCoordinates func_76554_h() {
      return null;
   }

   public int func_76557_i() {
      return this.field_76577_b == WorldType.field_77138_c?4:64;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76564_j() {
      return this.field_76577_b != WorldType.field_77138_c && !this.field_76576_e;
   }

   @SideOnly(Side.CLIENT)
   public double func_76565_k() {
      return this.field_76577_b == WorldType.field_77138_c?1.0D:0.03125D;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
      return false;
   }

   public abstract String func_80007_l();
}
