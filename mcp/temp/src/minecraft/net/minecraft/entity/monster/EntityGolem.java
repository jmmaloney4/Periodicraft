package net.minecraft.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.world.World;

public abstract class EntityGolem extends EntityCreature implements IAnimals {

   public EntityGolem(World p_i3517_1_) {
      super(p_i3517_1_);
   }

   protected void func_70069_a(float p_70069_1_) {}

   protected String func_70639_aQ() {
      return "none";
   }

   protected String func_70621_aR() {
      return "none";
   }

   protected String func_70673_aS() {
      return "none";
   }

   public int func_70627_aG() {
      return 120;
   }

   protected boolean func_70692_ba() {
      return false;
   }
}
