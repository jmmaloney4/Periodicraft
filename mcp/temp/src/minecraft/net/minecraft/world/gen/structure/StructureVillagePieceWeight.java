package net.minecraft.world.gen.structure;


public class StructureVillagePieceWeight {

   public Class field_75090_a;
   public final int field_75088_b;
   public int field_75089_c;
   public int field_75087_d;


   public StructureVillagePieceWeight(Class p_i3864_1_, int p_i3864_2_, int p_i3864_3_) {
      this.field_75090_a = p_i3864_1_;
      this.field_75088_b = p_i3864_2_;
      this.field_75087_d = p_i3864_3_;
   }

   public boolean func_75085_a(int p_75085_1_) {
      return this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d;
   }

   public boolean func_75086_a() {
      return this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d;
   }
}
