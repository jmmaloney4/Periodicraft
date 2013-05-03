package net.minecraft.entity.projectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPotion extends EntityThrowable {

   private ItemStack field_70197_d;


   public EntityPotion(World p_i3595_1_) {
      super(p_i3595_1_);
   }

   public EntityPotion(World p_i3596_1_, EntityLiving p_i3596_2_, int p_i3596_3_) {
      this(p_i3596_1_, p_i3596_2_, new ItemStack(Item.field_77726_bs, 1, p_i3596_3_));
   }

   public EntityPotion(World p_i5070_1_, EntityLiving p_i5070_2_, ItemStack p_i5070_3_) {
      super(p_i5070_1_, p_i5070_2_);
      this.field_70197_d = p_i5070_3_;
   }

   @SideOnly(Side.CLIENT)
   public EntityPotion(World p_i3597_1_, double p_i3597_2_, double p_i3597_4_, double p_i3597_6_, int p_i3597_8_) {
      this(p_i3597_1_, p_i3597_2_, p_i3597_4_, p_i3597_6_, new ItemStack(Item.field_77726_bs, 1, p_i3597_8_));
   }

   public EntityPotion(World p_i5071_1_, double p_i5071_2_, double p_i5071_4_, double p_i5071_6_, ItemStack p_i5071_8_) {
      super(p_i5071_1_, p_i5071_2_, p_i5071_4_, p_i5071_6_);
      this.field_70197_d = p_i5071_8_;
   }

   protected float func_70185_h() {
      return 0.05F;
   }

   protected float func_70182_d() {
      return 0.5F;
   }

   protected float func_70183_g() {
      return -20.0F;
   }

   public void func_82340_a(int p_82340_1_) {
      if(this.field_70197_d == null) {
         this.field_70197_d = new ItemStack(Item.field_77726_bs, 1, 0);
      }

      this.field_70197_d.func_77964_b(p_82340_1_);
   }

   public int func_70196_i() {
      if(this.field_70197_d == null) {
         this.field_70197_d = new ItemStack(Item.field_77726_bs, 1, 0);
      }

      return this.field_70197_d.func_77960_j();
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      if(!this.field_70170_p.field_72995_K) {
         List var2 = Item.field_77726_bs.func_77832_l(this.field_70197_d);
         if(var2 != null && !var2.isEmpty()) {
            AxisAlignedBB var3 = this.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D);
            List var4 = this.field_70170_p.func_72872_a(EntityLiving.class, var3);
            if(var4 != null && !var4.isEmpty()) {
               Iterator var5 = var4.iterator();

               while(var5.hasNext()) {
                  EntityLiving var6 = (EntityLiving)var5.next();
                  double var7 = this.func_70068_e(var6);
                  if(var7 < 16.0D) {
                     double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
                     if(var6 == p_70184_1_.field_72308_g) {
                        var9 = 1.0D;
                     }

                     Iterator var11 = var2.iterator();

                     while(var11.hasNext()) {
                        PotionEffect var12 = (PotionEffect)var11.next();
                        int var13 = var12.func_76456_a();
                        if(Potion.field_76425_a[var13].func_76403_b()) {
                           Potion.field_76425_a[var13].func_76402_a(this.func_85052_h(), var6, var12.func_76458_c(), var9);
                        } else {
                           int var14 = (int)(var9 * (double)var12.func_76459_b() + 0.5D);
                           if(var14 > 20) {
                              var6.func_70690_d(new PotionEffect(var13, var14, var12.func_76458_c()));
                           }
                        }
                     }
                  }
               }
            }
         }

         this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), this.func_70196_i());
         this.func_70106_y();
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_74764_b("Potion")) {
         this.field_70197_d = ItemStack.func_77949_a(p_70037_1_.func_74775_l("Potion"));
      } else {
         this.func_82340_a(p_70037_1_.func_74762_e("potionValue"));
      }

      if(this.field_70197_d == null) {
         this.func_70106_y();
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      if(this.field_70197_d != null) {
         p_70014_1_.func_74766_a("Potion", this.field_70197_d.func_77955_b(new NBTTagCompound()));
      }

   }
}
