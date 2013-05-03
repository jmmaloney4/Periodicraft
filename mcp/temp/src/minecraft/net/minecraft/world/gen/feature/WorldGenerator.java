package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.world.World;

public abstract class WorldGenerator {

   private final boolean field_76488_a;


   public WorldGenerator() {
      this.field_76488_a = false;
   }

   public WorldGenerator(boolean p_i3789_1_) {
      this.field_76488_a = p_i3789_1_;
   }

   public abstract boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5);

   public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_) {}

   protected void func_76486_a(World p_76486_1_, int p_76486_2_, int p_76486_3_, int p_76486_4_, int p_76486_5_) {
      this.func_76485_a(p_76486_1_, p_76486_2_, p_76486_3_, p_76486_4_, p_76486_5_, 0);
   }

   protected void func_76485_a(World p_76485_1_, int p_76485_2_, int p_76485_3_, int p_76485_4_, int p_76485_5_, int p_76485_6_) {
      if(this.field_76488_a) {
         p_76485_1_.func_72832_d(p_76485_2_, p_76485_3_, p_76485_4_, p_76485_5_, p_76485_6_, 3);
      } else {
         p_76485_1_.func_72832_d(p_76485_2_, p_76485_3_, p_76485_4_, p_76485_5_, p_76485_6_, 2);
      }

   }
}
