package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Vec3;

public class MovingObjectPosition {

   public EnumMovingObjectType field_72313_a;
   public int field_72311_b;
   public int field_72312_c;
   public int field_72309_d;
   public int field_72310_e;
   public Vec3 field_72307_f;
   public Entity field_72308_g;


   public MovingObjectPosition(int p_i4032_1_, int p_i4032_2_, int p_i4032_3_, int p_i4032_4_, Vec3 p_i4032_5_) {
      this.field_72313_a = EnumMovingObjectType.TILE;
      this.field_72311_b = p_i4032_1_;
      this.field_72312_c = p_i4032_2_;
      this.field_72309_d = p_i4032_3_;
      this.field_72310_e = p_i4032_4_;
      this.field_72307_f = p_i4032_5_.field_72447_d.func_72345_a(p_i4032_5_.field_72450_a, p_i4032_5_.field_72448_b, p_i4032_5_.field_72449_c);
   }

   public MovingObjectPosition(Entity p_i4033_1_) {
      this.field_72313_a = EnumMovingObjectType.ENTITY;
      this.field_72308_g = p_i4033_1_;
      this.field_72307_f = p_i4033_1_.field_70170_p.func_82732_R().func_72345_a(p_i4033_1_.field_70165_t, p_i4033_1_.field_70163_u, p_i4033_1_.field_70161_v);
   }
}
