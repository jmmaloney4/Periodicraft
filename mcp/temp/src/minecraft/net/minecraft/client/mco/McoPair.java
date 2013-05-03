package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class McoPair {

   private final Object field_98160_a;
   private final Object field_98159_b;


   protected McoPair(Object p_i11018_1_, Object p_i11018_2_) {
      this.field_98160_a = p_i11018_1_;
      this.field_98159_b = p_i11018_2_;
   }

   public static McoPair func_98157_a(Object p_98157_0_, Object p_98157_1_) {
      return new McoPair(p_98157_0_, p_98157_1_);
   }

   public Object func_100005_a() {
      return this.field_98160_a;
   }

   public Object func_100004_b() {
      return this.field_98159_b;
   }
}
