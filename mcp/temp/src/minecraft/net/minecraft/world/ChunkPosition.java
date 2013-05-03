package net.minecraft.world;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class ChunkPosition {

   public final int field_76930_a;
   public final int field_76928_b;
   public final int field_76929_c;


   public ChunkPosition(int p_i3743_1_, int p_i3743_2_, int p_i3743_3_) {
      this.field_76930_a = p_i3743_1_;
      this.field_76928_b = p_i3743_2_;
      this.field_76929_c = p_i3743_3_;
   }

   public ChunkPosition(Vec3 p_i3744_1_) {
      this(MathHelper.func_76128_c(p_i3744_1_.field_72450_a), MathHelper.func_76128_c(p_i3744_1_.field_72448_b), MathHelper.func_76128_c(p_i3744_1_.field_72449_c));
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof ChunkPosition)) {
         return false;
      } else {
         ChunkPosition var2 = (ChunkPosition)p_equals_1_;
         return var2.field_76930_a == this.field_76930_a && var2.field_76928_b == this.field_76928_b && var2.field_76929_c == this.field_76929_c;
      }
   }

   public int hashCode() {
      return this.field_76930_a * 8976890 + this.field_76928_b * 981131 + this.field_76929_c;
   }
}
