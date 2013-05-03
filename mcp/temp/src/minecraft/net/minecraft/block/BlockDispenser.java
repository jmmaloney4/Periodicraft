package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.IRegistry;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.dispenser.RegistryDefaulted;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDispenser extends BlockContainer {

   public static final IRegistry field_82527_a = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
   protected Random field_72284_a = new Random();
   @SideOnly(Side.CLIENT)
   protected Icon field_94463_c;
   @SideOnly(Side.CLIENT)
   protected Icon field_94462_cO;
   @SideOnly(Side.CLIENT)
   protected Icon field_96473_e;


   protected BlockDispenser(int p_i3938_1_) {
      super(p_i3938_1_, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   public int func_71859_p_(World p_71859_1_) {
      return 4;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      this.func_72280_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   private void func_72280_l(World p_72280_1_, int p_72280_2_, int p_72280_3_, int p_72280_4_) {
      if(!p_72280_1_.field_72995_K) {
         int var5 = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ - 1);
         int var6 = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ + 1);
         int var7 = p_72280_1_.func_72798_a(p_72280_2_ - 1, p_72280_3_, p_72280_4_);
         int var8 = p_72280_1_.func_72798_a(p_72280_2_ + 1, p_72280_3_, p_72280_4_);
         byte var9 = 3;
         if(Block.field_71970_n[var5] && !Block.field_71970_n[var6]) {
            var9 = 3;
         }

         if(Block.field_71970_n[var6] && !Block.field_71970_n[var5]) {
            var9 = 2;
         }

         if(Block.field_71970_n[var7] && !Block.field_71970_n[var8]) {
            var9 = 5;
         }

         if(Block.field_71970_n[var8] && !Block.field_71970_n[var7]) {
            var9 = 4;
         }

         p_72280_1_.func_72921_c(p_72280_2_, p_72280_3_, p_72280_4_, var9, 2);
      }
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      int var3 = p_71858_2_ & 7;
      return p_71858_1_ == var3?(var3 != 1 && var3 != 0?this.field_94462_cO:this.field_96473_e):(var3 != 1 && var3 != 0?(p_71858_1_ != 1 && p_71858_1_ != 0?this.field_94336_cN:this.field_94463_c):this.field_94463_c);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("furnace_side");
      this.field_94463_c = p_94332_1_.func_94245_a("furnace_top");
      this.field_94462_cO = p_94332_1_.func_94245_a("dispenser_front");
      this.field_96473_e = p_94332_1_.func_94245_a("dispenser_front_vertical");
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         TileEntityDispenser var10 = (TileEntityDispenser)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
         if(var10 != null) {
            p_71903_5_.func_71006_a(var10);
         }

         return true;
      }
   }

   protected void func_82526_n(World p_82526_1_, int p_82526_2_, int p_82526_3_, int p_82526_4_) {
      BlockSourceImpl var5 = new BlockSourceImpl(p_82526_1_, p_82526_2_, p_82526_3_, p_82526_4_);
      TileEntityDispenser var6 = (TileEntityDispenser)var5.func_82619_j();
      if(var6 != null) {
         int var7 = var6.func_70361_i();
         if(var7 < 0) {
            p_82526_1_.func_72926_e(1001, p_82526_2_, p_82526_3_, p_82526_4_, 0);
         } else {
            ItemStack var8 = var6.func_70301_a(var7);
            IBehaviorDispenseItem var9 = this.func_96472_a(var8);
            if(var9 != IBehaviorDispenseItem.field_82483_a) {
               ItemStack var10 = var9.func_82482_a(var5, var8);
               var6.func_70299_a(var7, var10.field_77994_a == 0?null:var10);
            }
         }

      }
   }

   protected IBehaviorDispenseItem func_96472_a(ItemStack p_96472_1_) {
      return (IBehaviorDispenseItem)field_82527_a.func_82594_a(p_96472_1_.func_77973_b());
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      boolean var6 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_) || p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
      int var7 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      boolean var8 = (var7 & 8) != 0;
      if(var6 && !var8) {
         p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, this.func_71859_p_(p_71863_1_));
         p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, var7 | 8, 4);
      } else if(!var6 && var8) {
         p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, var7 & -9, 4);
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         this.func_82526_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      }

   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityDispenser();
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = BlockPistonBase.func_72116_b(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, p_71860_5_);
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
      if(p_71860_6_.func_82837_s()) {
         ((TileEntityDispenser)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94049_a(p_71860_6_.func_82833_r());
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      TileEntityDispenser var7 = (TileEntityDispenser)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
            ItemStack var9 = var7.func_70301_a(var8);
            if(var9 != null) {
               float var10 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;
               float var12 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;

               while(var9.field_77994_a > 0) {
                  int var13 = this.field_72284_a.nextInt(21) + 10;
                  if(var13 > var9.field_77994_a) {
                     var13 = var9.field_77994_a;
                  }

                  var9.field_77994_a -= var13;
                  EntityItem var14 = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + var10), (double)((float)p_71852_3_ + var11), (double)((float)p_71852_4_ + var12), new ItemStack(var9.field_77993_c, var13, var9.func_77960_j()));
                  if(var9.func_77942_o()) {
                     var14.func_92059_d().func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                  }

                  float var15 = 0.05F;
                  var14.field_70159_w = (double)((float)this.field_72284_a.nextGaussian() * var15);
                  var14.field_70181_x = (double)((float)this.field_72284_a.nextGaussian() * var15 + 0.2F);
                  var14.field_70179_y = (double)((float)this.field_72284_a.nextGaussian() * var15);
                  p_71852_1_.func_72838_d(var14);
               }
            }
         }

         p_71852_1_.func_96440_m(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public static IPosition func_82525_a(IBlockSource p_82525_0_) {
      EnumFacing var1 = func_100009_j_(p_82525_0_.func_82620_h());
      double var2 = p_82525_0_.func_82615_a() + 0.7D * (double)var1.func_82601_c();
      double var4 = p_82525_0_.func_82617_b() + 0.7D * (double)var1.func_96559_d();
      double var6 = p_82525_0_.func_82616_c() + 0.7D * (double)var1.func_82599_e();
      return new PositionImpl(var2, var4, var6);
   }

   public static EnumFacing func_100009_j_(int p_100009_0_) {
      return EnumFacing.func_82600_a(p_100009_0_ & 7);
   }

   public boolean func_96468_q_() {
      return true;
   }

   public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_) {
      return Container.func_94526_b((IInventory)p_94328_1_.func_72796_p(p_94328_2_, p_94328_3_, p_94328_4_));
   }

}
