package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawnerLogic;

public class TileEntityMobSpawner extends TileEntity {

   private final MobSpawnerBaseLogic field_98050_a = new TileEntityMobSpawnerLogic(this);


   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_98050_a.func_98270_a(p_70307_1_);
   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      this.field_98050_a.func_98280_b(p_70310_1_);
   }

   public void func_70316_g() {
      this.field_98050_a.func_98278_g();
      super.func_70316_g();
   }

   public Packet func_70319_e() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_70310_b(var1);
      var1.func_82580_o("SpawnPotentials");
      return new Packet132TileEntityData(this.field_70329_l, this.field_70330_m, this.field_70327_n, 1, var1);
   }

   public boolean func_70315_b(int p_70315_1_, int p_70315_2_) {
      return this.field_98050_a.func_98268_b(p_70315_1_)?true:super.func_70315_b(p_70315_1_, p_70315_2_);
   }

   public MobSpawnerBaseLogic func_98049_a() {
      return this.field_98050_a;
   }
}
