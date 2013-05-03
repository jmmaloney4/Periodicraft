package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class MapGenBase {

   protected int field_75040_a = 8;
   protected Random field_75038_b = new Random();
   protected World field_75039_c;


   public void func_75036_a(IChunkProvider p_75036_1_, World p_75036_2_, int p_75036_3_, int p_75036_4_, byte[] p_75036_5_) {
      int var6 = this.field_75040_a;
      this.field_75039_c = p_75036_2_;
      this.field_75038_b.setSeed(p_75036_2_.func_72905_C());
      long var7 = this.field_75038_b.nextLong();
      long var9 = this.field_75038_b.nextLong();

      for(int var11 = p_75036_3_ - var6; var11 <= p_75036_3_ + var6; ++var11) {
         for(int var12 = p_75036_4_ - var6; var12 <= p_75036_4_ + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.field_75038_b.setSeed(var13 ^ var15 ^ p_75036_2_.func_72905_C());
            this.func_75037_a(p_75036_2_, var11, var12, p_75036_3_, p_75036_4_, p_75036_5_);
         }
      }

   }

   protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte[] p_75037_6_) {}
}
