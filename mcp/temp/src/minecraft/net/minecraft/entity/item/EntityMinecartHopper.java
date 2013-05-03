package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.Hopper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMinecartHopper extends EntityMinecartContainer implements Hopper {

   private boolean field_96113_a = true;
   private int field_98044_b = -1;


   public EntityMinecartHopper(World p_i10053_1_) {
      super(p_i10053_1_);
   }

   public EntityMinecartHopper(World p_i10054_1_, double p_i10054_2_, double p_i10054_4_, double p_i10054_6_) {
      super(p_i10054_1_, p_i10054_2_, p_i10054_4_, p_i10054_6_);
   }

   public int func_94087_l() {
      return 5;
   }

   public Block func_94093_n() {
      return Block.field_94340_cs;
   }

   public int func_94085_r() {
      return 1;
   }

   public int func_70302_i_() {
      return 5;
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(!this.field_70170_p.field_72995_K) {
         p_70085_1_.func_96125_a(this);
      }

      return true;
   }

   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
      boolean var5 = !p_96095_4_;
      if(var5 != this.func_96111_ay()) {
         this.func_96110_f(var5);
      }

   }

   public boolean func_96111_ay() {
      return this.field_96113_a;
   }

   public void func_96110_f(boolean p_96110_1_) {
      this.field_96113_a = p_96110_1_;
   }

   public World func_70314_l() {
      return this.field_70170_p;
   }

   public double func_96107_aA() {
      return this.field_70165_t;
   }

   public double func_96109_aB() {
      return this.field_70163_u;
   }

   public double func_96108_aC() {
      return this.field_70161_v;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(!this.field_70170_p.field_72995_K && this.func_70089_S() && this.func_96111_ay()) {
         --this.field_98044_b;
         if(!this.func_98043_aE()) {
            this.func_98042_n(0);
            if(this.func_96112_aD()) {
               this.func_98042_n(4);
               this.func_70296_d();
            }
         }
      }

   }

   public boolean func_96112_aD() {
      if(TileEntityHopper.func_96116_a(this)) {
         return true;
      } else {
         List var1 = this.field_70170_p.func_82733_a(EntityItem.class, this.field_70121_D.func_72314_b(0.25D, 0.0D, 0.25D), IEntitySelector.field_94557_a);
         if(var1.size() > 0) {
            TileEntityHopper.func_96114_a(this, (EntityItem)var1.get(0));
         }

         return false;
      }
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      this.func_70054_a(Block.field_94340_cs.field_71990_ca, 1, 0.0F);
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("TransferCooldown", this.field_98044_b);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_98044_b = p_70037_1_.func_74762_e("TransferCooldown");
   }

   public void func_98042_n(int p_98042_1_) {
      this.field_98044_b = p_98042_1_;
   }

   public boolean func_98043_aE() {
      return this.field_98044_b > 0;
   }
}
