package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMinecartChest extends EntityMinecartContainer {

   public EntityMinecartChest(World p_i9001_1_) {
      super(p_i9001_1_);
   }

   public EntityMinecartChest(World p_i9002_1_, double p_i9002_2_, double p_i9002_4_, double p_i9002_6_) {
      super(p_i9002_1_, p_i9002_2_, p_i9002_4_, p_i9002_6_);
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      this.func_70054_a(Block.field_72077_au.field_71990_ca, 1, 0.0F);
   }

   public int func_70302_i_() {
      return 27;
   }

   public int func_94087_l() {
      return 1;
   }

   public Block func_94093_n() {
      return Block.field_72077_au;
   }

   public int func_94085_r() {
      return 8;
   }
}
