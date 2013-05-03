package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChest extends BlockContainer {

   private final Random field_72293_a = new Random();
   public final int field_94443_a;


   protected BlockChest(int p_i9045_1_, int p_i9045_2_) {
      super(p_i9045_1_, Material.field_76245_d);
      this.field_94443_a = p_i9045_2_;
      this.func_71849_a(CreativeTabs.field_78031_c);
      this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 22;
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      if(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ - 1) == this.field_71990_ca) {
         this.func_71905_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ + 1) == this.field_71990_ca) {
         this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_) == this.field_71990_ca) {
         this.func_71905_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_) == this.field_71990_ca) {
         this.func_71905_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      int var5 = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ - 1);
      int var6 = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_ + 1);
      int var7 = p_71861_1_.func_72798_a(p_71861_2_ - 1, p_71861_3_, p_71861_4_);
      int var8 = p_71861_1_.func_72798_a(p_71861_2_ + 1, p_71861_3_, p_71861_4_);
      if(var5 == this.field_71990_ca) {
         this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ - 1);
      }

      if(var6 == this.field_71990_ca) {
         this.func_72290_b_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ + 1);
      }

      if(var7 == this.field_71990_ca) {
         this.func_72290_b_(p_71861_1_, p_71861_2_ - 1, p_71861_3_, p_71861_4_);
      }

      if(var8 == this.field_71990_ca) {
         this.func_72290_b_(p_71861_1_, p_71861_2_ + 1, p_71861_3_, p_71861_4_);
      }

   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ - 1);
      int var8 = p_71860_1_.func_72798_a(p_71860_2_, p_71860_3_, p_71860_4_ + 1);
      int var9 = p_71860_1_.func_72798_a(p_71860_2_ - 1, p_71860_3_, p_71860_4_);
      int var10 = p_71860_1_.func_72798_a(p_71860_2_ + 1, p_71860_3_, p_71860_4_);
      byte var11 = 0;
      int var12 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var12 == 0) {
         var11 = 2;
      }

      if(var12 == 1) {
         var11 = 5;
      }

      if(var12 == 2) {
         var11 = 3;
      }

      if(var12 == 3) {
         var11 = 4;
      }

      if(var7 != this.field_71990_ca && var8 != this.field_71990_ca && var9 != this.field_71990_ca && var10 != this.field_71990_ca) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var11, 3);
      } else {
         if((var7 == this.field_71990_ca || var8 == this.field_71990_ca) && (var11 == 4 || var11 == 5)) {
            if(var7 == this.field_71990_ca) {
               p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ - 1, var11, 3);
            } else {
               p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_ + 1, var11, 3);
            }

            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var11, 3);
         }

         if((var9 == this.field_71990_ca || var10 == this.field_71990_ca) && (var11 == 2 || var11 == 3)) {
            if(var9 == this.field_71990_ca) {
               p_71860_1_.func_72921_c(p_71860_2_ - 1, p_71860_3_, p_71860_4_, var11, 3);
            } else {
               p_71860_1_.func_72921_c(p_71860_2_ + 1, p_71860_3_, p_71860_4_, var11, 3);
            }

            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var11, 3);
         }
      }

      if(p_71860_6_.func_82837_s()) {
         ((TileEntityChest)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94043_a(p_71860_6_.func_82833_r());
      }

   }

   public void func_72290_b_(World p_72290_1_, int p_72290_2_, int p_72290_3_, int p_72290_4_) {
      if(!p_72290_1_.field_72995_K) {
         int var5 = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
         int var6 = p_72290_1_.func_72798_a(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
         int var7 = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
         int var8 = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
         boolean var9 = true;
         int var10;
         int var11;
         boolean var12;
         byte var13;
         int var14;
         if(var5 != this.field_71990_ca && var6 != this.field_71990_ca) {
            if(var7 != this.field_71990_ca && var8 != this.field_71990_ca) {
               var13 = 3;
               if(Block.field_71970_n[var5] && !Block.field_71970_n[var6]) {
                  var13 = 3;
               }

               if(Block.field_71970_n[var6] && !Block.field_71970_n[var5]) {
                  var13 = 2;
               }

               if(Block.field_71970_n[var7] && !Block.field_71970_n[var8]) {
                  var13 = 5;
               }

               if(Block.field_71970_n[var8] && !Block.field_71970_n[var7]) {
                  var13 = 4;
               }
            } else {
               var10 = p_72290_1_.func_72798_a(var7 == this.field_71990_ca?p_72290_2_ - 1:p_72290_2_ + 1, p_72290_3_, p_72290_4_ - 1);
               var11 = p_72290_1_.func_72798_a(var7 == this.field_71990_ca?p_72290_2_ - 1:p_72290_2_ + 1, p_72290_3_, p_72290_4_ + 1);
               var13 = 3;
               var12 = true;
               if(var7 == this.field_71990_ca) {
                  var14 = p_72290_1_.func_72805_g(p_72290_2_ - 1, p_72290_3_, p_72290_4_);
               } else {
                  var14 = p_72290_1_.func_72805_g(p_72290_2_ + 1, p_72290_3_, p_72290_4_);
               }

               if(var14 == 2) {
                  var13 = 2;
               }

               if((Block.field_71970_n[var5] || Block.field_71970_n[var10]) && !Block.field_71970_n[var6] && !Block.field_71970_n[var11]) {
                  var13 = 3;
               }

               if((Block.field_71970_n[var6] || Block.field_71970_n[var11]) && !Block.field_71970_n[var5] && !Block.field_71970_n[var10]) {
                  var13 = 2;
               }
            }
         } else {
            var10 = p_72290_1_.func_72798_a(p_72290_2_ - 1, p_72290_3_, var5 == this.field_71990_ca?p_72290_4_ - 1:p_72290_4_ + 1);
            var11 = p_72290_1_.func_72798_a(p_72290_2_ + 1, p_72290_3_, var5 == this.field_71990_ca?p_72290_4_ - 1:p_72290_4_ + 1);
            var13 = 5;
            var12 = true;
            if(var5 == this.field_71990_ca) {
               var14 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ - 1);
            } else {
               var14 = p_72290_1_.func_72805_g(p_72290_2_, p_72290_3_, p_72290_4_ + 1);
            }

            if(var14 == 4) {
               var13 = 4;
            }

            if((Block.field_71970_n[var7] || Block.field_71970_n[var10]) && !Block.field_71970_n[var8] && !Block.field_71970_n[var11]) {
               var13 = 5;
            }

            if((Block.field_71970_n[var8] || Block.field_71970_n[var11]) && !Block.field_71970_n[var7] && !Block.field_71970_n[var10]) {
               var13 = 4;
            }
         }

         p_72290_1_.func_72921_c(p_72290_2_, p_72290_3_, p_72290_4_, var13, 3);
      }
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      int var5 = 0;
      if(p_71930_1_.func_72798_a(p_71930_2_ - 1, p_71930_3_, p_71930_4_) == this.field_71990_ca) {
         ++var5;
      }

      if(p_71930_1_.func_72798_a(p_71930_2_ + 1, p_71930_3_, p_71930_4_) == this.field_71990_ca) {
         ++var5;
      }

      if(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ - 1) == this.field_71990_ca) {
         ++var5;
      }

      if(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_ + 1) == this.field_71990_ca) {
         ++var5;
      }

      return var5 > 1?false:(this.func_72291_l(p_71930_1_, p_71930_2_ - 1, p_71930_3_, p_71930_4_)?false:(this.func_72291_l(p_71930_1_, p_71930_2_ + 1, p_71930_3_, p_71930_4_)?false:(this.func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ - 1)?false:!this.func_72291_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_ + 1))));
   }

   private boolean func_72291_l(World p_72291_1_, int p_72291_2_, int p_72291_3_, int p_72291_4_) {
      return p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_) != this.field_71990_ca?false:(p_72291_1_.func_72798_a(p_72291_2_ - 1, p_72291_3_, p_72291_4_) == this.field_71990_ca?true:(p_72291_1_.func_72798_a(p_72291_2_ + 1, p_72291_3_, p_72291_4_) == this.field_71990_ca?true:(p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ - 1) == this.field_71990_ca?true:p_72291_1_.func_72798_a(p_72291_2_, p_72291_3_, p_72291_4_ + 1) == this.field_71990_ca)));
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      TileEntityChest var6 = (TileEntityChest)p_71863_1_.func_72796_p(p_71863_2_, p_71863_3_, p_71863_4_);
      if(var6 != null) {
         var6.func_70321_h();
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      TileEntityChest var7 = (TileEntityChest)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
            ItemStack var9 = var7.func_70301_a(var8);
            if(var9 != null) {
               float var10 = this.field_72293_a.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_72293_a.nextFloat() * 0.8F + 0.1F;

               EntityItem var14;
               for(float var12 = this.field_72293_a.nextFloat() * 0.8F + 0.1F; var9.field_77994_a > 0; p_71852_1_.func_72838_d(var14)) {
                  int var13 = this.field_72293_a.nextInt(21) + 10;
                  if(var13 > var9.field_77994_a) {
                     var13 = var9.field_77994_a;
                  }

                  var9.field_77994_a -= var13;
                  var14 = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + var10), (double)((float)p_71852_3_ + var11), (double)((float)p_71852_4_ + var12), new ItemStack(var9.field_77993_c, var13, var9.func_77960_j()));
                  float var15 = 0.05F;
                  var14.field_70159_w = (double)((float)this.field_72293_a.nextGaussian() * var15);
                  var14.field_70181_x = (double)((float)this.field_72293_a.nextGaussian() * var15 + 0.2F);
                  var14.field_70179_y = (double)((float)this.field_72293_a.nextGaussian() * var15);
                  if(var9.func_77942_o()) {
                     var14.func_92059_d().func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                  }
               }
            }
         }

         p_71852_1_.func_96440_m(p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_);
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         IInventory var10 = this.func_94442_h_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
         if(var10 != null) {
            p_71903_5_.func_71007_a(var10);
         }

         return true;
      }
   }

   public IInventory func_94442_h_(World p_94442_1_, int p_94442_2_, int p_94442_3_, int p_94442_4_) {
      Object var5 = (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_);
      if(var5 == null) {
         return null;
      } else if(p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_)) {
         return null;
      } else if(func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_)) {
         return null;
      } else if(p_94442_1_.func_72798_a(p_94442_2_ - 1, p_94442_3_, p_94442_4_) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_ - 1, p_94442_3_ + 1, p_94442_4_) || func_72292_n(p_94442_1_, p_94442_2_ - 1, p_94442_3_, p_94442_4_))) {
         return null;
      } else if(p_94442_1_.func_72798_a(p_94442_2_ + 1, p_94442_3_, p_94442_4_) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_ + 1, p_94442_3_ + 1, p_94442_4_) || func_72292_n(p_94442_1_, p_94442_2_ + 1, p_94442_3_, p_94442_4_))) {
         return null;
      } else if(p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ - 1) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_ - 1) || func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_ - 1))) {
         return null;
      } else if(p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ + 1) == this.field_71990_ca && (p_94442_1_.func_72809_s(p_94442_2_, p_94442_3_ + 1, p_94442_4_ + 1) || func_72292_n(p_94442_1_, p_94442_2_, p_94442_3_, p_94442_4_ + 1))) {
         return null;
      } else {
         if(p_94442_1_.func_72798_a(p_94442_2_ - 1, p_94442_3_, p_94442_4_) == this.field_71990_ca) {
            var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_ - 1, p_94442_3_, p_94442_4_), (IInventory)var5);
         }

         if(p_94442_1_.func_72798_a(p_94442_2_ + 1, p_94442_3_, p_94442_4_) == this.field_71990_ca) {
            var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_ + 1, p_94442_3_, p_94442_4_));
         }

         if(p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ - 1) == this.field_71990_ca) {
            var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_ - 1), (IInventory)var5);
         }

         if(p_94442_1_.func_72798_a(p_94442_2_, p_94442_3_, p_94442_4_ + 1) == this.field_71990_ca) {
            var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)p_94442_1_.func_72796_p(p_94442_2_, p_94442_3_, p_94442_4_ + 1));
         }

         return (IInventory)var5;
      }
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      TileEntityChest var2 = new TileEntityChest();
      return var2;
   }

   public boolean func_71853_i() {
      return this.field_94443_a == 1;
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      if(!this.func_71853_i()) {
         return 0;
      } else {
         int var6 = ((TileEntityChest)p_71865_1_.func_72796_p(p_71865_2_, p_71865_3_, p_71865_4_)).field_70427_h;
         return MathHelper.func_76125_a(var6, 0, 15);
      }
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return p_71855_5_ == 1?this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_):0;
   }

   public static boolean func_72292_n(World p_72292_0_, int p_72292_1_, int p_72292_2_, int p_72292_3_) {
      Iterator var4 = p_72292_0_.func_72872_a(EntityOcelot.class, AxisAlignedBB.func_72332_a().func_72299_a((double)p_72292_1_, (double)(p_72292_2_ + 1), (double)p_72292_3_, (double)(p_72292_1_ + 1), (double)(p_72292_2_ + 2), (double)(p_72292_3_ + 1))).iterator();

      EntityOcelot var6;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         EntityOcelot var5 = (EntityOcelot)var4.next();
         var6 = (EntityOcelot)var5;
      } while(!var6.func_70906_o());

      return true;
   }

   public boolean func_96468_q_() {
      return true;
   }

   public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_) {
      return Container.func_94526_b(this.func_94442_h_(p_94328_1_, p_94328_2_, p_94328_3_, p_94328_4_));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("wood");
   }
}
