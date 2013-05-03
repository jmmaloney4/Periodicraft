package net.minecraft.entity.ai;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityMinecartMobSpawnerLogic;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.world.World;

public class EntityMinecartMobSpawner extends EntityMinecart {

   private final MobSpawnerBaseLogic field_98040_a = new EntityMinecartMobSpawnerLogic(this);


   public EntityMinecartMobSpawner(World p_i11039_1_) {
      super(p_i11039_1_);
   }

   public EntityMinecartMobSpawner(World p_i11040_1_, double p_i11040_2_, double p_i11040_4_, double p_i11040_6_) {
      super(p_i11040_1_, p_i11040_2_, p_i11040_4_, p_i11040_6_);
   }

   public int func_94087_l() {
      return 4;
   }

   public Block func_94093_n() {
      return Block.field_72065_as;
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_98040_a.func_98270_a(p_70037_1_);
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      this.field_98040_a.func_98280_b(p_70014_1_);
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte p_70103_1_) {
      this.field_98040_a.func_98268_b(p_70103_1_);
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      this.field_98040_a.func_98278_g();
   }

   @SideOnly(Side.CLIENT)
   public MobSpawnerBaseLogic func_98039_d() {
      return this.field_98040_a;
   }
}
