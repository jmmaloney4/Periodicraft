package net.minecraft.entity.passive;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityAnimal extends EntityAgeable implements IAnimals {

   public int field_70881_d;
   private int field_70882_e = 0;


   public EntityAnimal(World p_i3514_1_) {
      super(p_i3514_1_);
   }

   protected void func_70629_bd() {
      if(this.func_70874_b() != 0) {
         this.field_70881_d = 0;
      }

      super.func_70629_bd();
   }

   public void func_70636_d() {
      super.func_70636_d();
      if(this.func_70874_b() != 0) {
         this.field_70881_d = 0;
      }

      if(this.field_70881_d > 0) {
         --this.field_70881_d;
         String var1 = "heart";
         if(this.field_70881_d % 10 == 0) {
            double var2 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var4 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var6 = this.field_70146_Z.nextGaussian() * 0.02D;
            this.field_70170_p.func_72869_a(var1, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var2, var4, var6);
         }
      } else {
         this.field_70882_e = 0;
      }

   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      if(p_70785_1_ instanceof EntityPlayer) {
         if(p_70785_2_ < 3.0F) {
            double var3 = p_70785_1_.field_70165_t - this.field_70165_t;
            double var5 = p_70785_1_.field_70161_v - this.field_70161_v;
            this.field_70177_z = (float)(Math.atan2(var5, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_70787_b = true;
         }

         EntityPlayer var7 = (EntityPlayer)p_70785_1_;
         if(var7.func_71045_bC() == null || !this.func_70877_b(var7.func_71045_bC())) {
            this.field_70789_a = null;
         }
      } else if(p_70785_1_ instanceof EntityAnimal) {
         EntityAnimal var8 = (EntityAnimal)p_70785_1_;
         if(this.func_70874_b() > 0 && var8.func_70874_b() < 0) {
            if((double)p_70785_2_ < 2.5D) {
               this.field_70787_b = true;
            }
         } else if(this.field_70881_d > 0 && var8.field_70881_d > 0) {
            if(var8.field_70789_a == null) {
               var8.field_70789_a = this;
            }

            if(var8.field_70789_a == this && (double)p_70785_2_ < 3.5D) {
               ++var8.field_70881_d;
               ++this.field_70881_d;
               ++this.field_70882_e;
               if(this.field_70882_e % 4 == 0) {
                  this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, 0.0D, 0.0D, 0.0D);
               }

               if(this.field_70882_e == 60) {
                  this.func_70876_c((EntityAnimal)p_70785_1_);
               }
            } else {
               this.field_70882_e = 0;
            }
         } else {
            this.field_70882_e = 0;
            this.field_70789_a = null;
         }
      }

   }

   private void func_70876_c(EntityAnimal p_70876_1_) {
      EntityAgeable var2 = this.func_90011_a(p_70876_1_);
      if(var2 != null) {
         this.func_70873_a(6000);
         p_70876_1_.func_70873_a(6000);
         this.field_70881_d = 0;
         this.field_70882_e = 0;
         this.field_70789_a = null;
         p_70876_1_.field_70789_a = null;
         p_70876_1_.field_70882_e = 0;
         p_70876_1_.field_70881_d = 0;
         var2.func_70873_a(-24000);
         var2.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var6 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var8 = this.field_70146_Z.nextGaussian() * 0.02D;
            this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var4, var6, var8);
         }

         this.field_70170_p.func_72838_d(var2);
      }

   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         this.field_70788_c = 60;
         this.field_70789_a = null;
         this.field_70881_d = 0;
         return super.func_70097_a(p_70097_1_, p_70097_2_);
      }
   }

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return this.field_70170_p.func_72798_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Block.field_71980_u.field_71990_ca?10.0F:this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("InLove", this.field_70881_d);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_70881_d = p_70037_1_.func_74762_e("InLove");
   }

   protected Entity func_70782_k() {
      if(this.field_70788_c > 0) {
         return null;
      } else {
         float var1 = 8.0F;
         List var2;
         int var3;
         EntityAnimal var4;
         if(this.field_70881_d > 0) {
            var2 = this.field_70170_p.func_72872_a(this.getClass(), this.field_70121_D.func_72314_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = (EntityAnimal)var2.get(var3);
               if(var4 != this && var4.field_70881_d > 0) {
                  return var4;
               }
            }
         } else if(this.func_70874_b() == 0) {
            var2 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               EntityPlayer var5 = (EntityPlayer)var2.get(var3);
               if(var5.func_71045_bC() != null && this.func_70877_b(var5.func_71045_bC())) {
                  return var5;
               }
            }
         } else if(this.func_70874_b() > 0) {
            var2 = this.field_70170_p.func_72872_a(this.getClass(), this.field_70121_D.func_72314_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = (EntityAnimal)var2.get(var3);
               if(var4 != this && var4.func_70874_b() < 0) {
                  return var4;
               }
            }
         }

         return null;
      }
   }

   public boolean func_70601_bi() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      return this.field_70170_p.func_72798_a(var1, var2 - 1, var3) == Block.field_71980_u.field_71990_ca && this.field_70170_p.func_72883_k(var1, var2, var3) > 8 && super.func_70601_bi();
   }

   public int func_70627_aG() {
      return 120;
   }

   protected boolean func_70692_ba() {
      return false;
   }

   protected int func_70693_a(EntityPlayer p_70693_1_) {
      return 1 + this.field_70170_p.field_73012_v.nextInt(3);
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_.field_77993_c == Item.field_77685_T.field_77779_bT;
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && this.func_70877_b(var2) && this.func_70874_b() == 0 && this.field_70881_d <= 0) {
         if(!p_70085_1_.field_71075_bZ.field_75098_d) {
            --var2.field_77994_a;
            if(var2.field_77994_a <= 0) {
               p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
            }
         }

         this.field_70881_d = 600;
         this.field_70789_a = null;

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var6 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var8 = this.field_70146_Z.nextGaussian() * 0.02D;
            this.field_70170_p.func_72869_a("heart", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var4, var6, var8);
         }

         return true;
      } else {
         return super.func_70085_c(p_70085_1_);
      }
   }

   public boolean func_70880_s() {
      return this.field_70881_d > 0;
   }

   public void func_70875_t() {
      this.field_70881_d = 0;
   }

   public boolean func_70878_b(EntityAnimal p_70878_1_) {
      return p_70878_1_ == this?false:(p_70878_1_.getClass() != this.getClass()?false:this.func_70880_s() && p_70878_1_.func_70880_s());
   }
}
