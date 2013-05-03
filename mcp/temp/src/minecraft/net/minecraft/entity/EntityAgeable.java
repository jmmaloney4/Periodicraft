package net.minecraft.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntityAgeable extends EntityCreature {

   private float field_98056_d = -1.0F;
   private float field_98057_e;


   public EntityAgeable(World p_i3436_1_) {
      super(p_i3436_1_);
   }

   public abstract EntityAgeable func_90011_a(EntityAgeable var1);

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.field_77993_c == Item.field_77815_bC.field_77779_bT && !this.field_70170_p.field_72995_K) {
         Class var3 = EntityList.func_90035_a(var2.func_77960_j());
         if(var3 != null && var3.isAssignableFrom(this.getClass())) {
            EntityAgeable var4 = this.func_90011_a(this);
            if(var4 != null) {
               var4.func_70873_a(-24000);
               var4.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
               this.field_70170_p.func_72838_d(var4);
               if(var2.func_82837_s()) {
                  var4.func_94058_c(var2.func_82833_r());
               }

               if(!p_70085_1_.field_71075_bZ.field_75098_d) {
                  --var2.field_77994_a;
                  if(var2.field_77994_a <= 0) {
                     p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
                  }
               }
            }
         }
      }

      return super.func_70085_c(p_70085_1_);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(12, new Integer(0));
   }

   public int func_70874_b() {
      return this.field_70180_af.func_75679_c(12);
   }

   public void func_70873_a(int p_70873_1_) {
      this.field_70180_af.func_75692_b(12, Integer.valueOf(p_70873_1_));
      this.func_98054_a(this.func_70631_g_());
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("Age", this.func_70874_b());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70873_a(p_70037_1_.func_74762_e("Age"));
   }

   public void func_70636_d() {
      super.func_70636_d();
      if(this.field_70170_p.field_72995_K) {
         this.func_98054_a(this.func_70631_g_());
      } else {
         int var1 = this.func_70874_b();
         if(var1 < 0) {
            ++var1;
            this.func_70873_a(var1);
         } else if(var1 > 0) {
            --var1;
            this.func_70873_a(var1);
         }
      }

   }

   public boolean func_70631_g_() {
      return this.func_70874_b() < 0;
   }

   public void func_98054_a(boolean p_98054_1_) {
      this.func_98055_j(p_98054_1_?0.5F:1.0F);
   }

   protected final void func_70105_a(float p_70105_1_, float p_70105_2_) {
      boolean var3 = this.field_98056_d > 0.0F;
      this.field_98056_d = p_70105_1_;
      this.field_98057_e = p_70105_2_;
      if(!var3) {
         this.func_98055_j(1.0F);
      }

   }

   private void func_98055_j(float p_98055_1_) {
      super.func_70105_a(this.field_98056_d * p_98055_1_, this.field_98057_e * p_98055_1_);
   }
}
