package net.minecraft.util;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;

public class CombatEntry {

   private final DamageSource field_94569_a;
   private final int field_94567_b;
   private final int field_94568_c;
   private final int field_94565_d;
   private final String field_94566_e;
   private final float field_94564_f;


   public CombatEntry(DamageSource p_i9019_1_, int p_i9019_2_, int p_i9019_3_, int p_i9019_4_, String p_i9019_5_, float p_i9019_6_) {
      this.field_94569_a = p_i9019_1_;
      this.field_94567_b = p_i9019_2_;
      this.field_94568_c = p_i9019_4_;
      this.field_94565_d = p_i9019_3_;
      this.field_94566_e = p_i9019_5_;
      this.field_94564_f = p_i9019_6_;
   }

   public DamageSource func_94560_a() {
      return this.field_94569_a;
   }

   public int func_94563_c() {
      return this.field_94568_c;
   }

   public boolean func_94559_f() {
      return this.field_94569_a.func_76346_g() instanceof EntityLiving;
   }

   public String func_94562_g() {
      return this.field_94566_e;
   }

   public String func_94558_h() {
      return this.func_94560_a().func_76346_g() == null?null:this.func_94560_a().func_76346_g().func_96090_ax();
   }

   public float func_94561_i() {
      return this.field_94569_a == DamageSource.field_76380_i?Float.MAX_VALUE:this.field_94564_f;
   }
}
