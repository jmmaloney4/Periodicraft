package net.minecraft.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;

public enum EnumCreatureType {

   monster("monster", 0, IMob.class, 70, Material.field_76249_a, false, false),
   creature("creature", 1, EntityAnimal.class, 10, Material.field_76249_a, true, true),
   ambient("ambient", 2, EntityAmbientCreature.class, 15, Material.field_76249_a, true, false),
   waterCreature("waterCreature", 3, EntityWaterMob.class, 5, Material.field_76244_g, true, false);
   private final Class field_75605_d;
   private final int field_75606_e;
   private final Material field_75603_f;
   private final boolean field_75604_g;
   private final boolean field_82707_i;
   // $FF: synthetic field
   private static final EnumCreatureType[] $VALUES = new EnumCreatureType[]{monster, creature, ambient, waterCreature};


   private EnumCreatureType(String p_i5057_1_, int p_i5057_2_, Class p_i5057_3_, int p_i5057_4_, Material p_i5057_5_, boolean p_i5057_6_, boolean p_i5057_7_) {
      this.field_75605_d = p_i5057_3_;
      this.field_75606_e = p_i5057_4_;
      this.field_75603_f = p_i5057_5_;
      this.field_75604_g = p_i5057_6_;
      this.field_82707_i = p_i5057_7_;
   }

   public Class func_75598_a() {
      return this.field_75605_d;
   }

   public int func_75601_b() {
      return this.field_75606_e;
   }

   public Material func_75600_c() {
      return this.field_75603_f;
   }

   public boolean func_75599_d() {
      return this.field_75604_g;
   }

   public boolean func_82705_e() {
      return this.field_82707_i;
   }

}
