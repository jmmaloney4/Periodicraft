package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockComparator extends BlockRedstoneLogic implements ITileEntityProvider {

   public BlockComparator(int p_i9047_1_, boolean p_i9047_2_) {
      super(p_i9047_1_, p_i9047_2_);
      this.field_72025_cg = true;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_94585_bY.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_94585_bY.field_77779_bT;
   }

   protected int func_94481_j_(int p_94481_1_) {
      return 2;
   }

   protected BlockRedstoneLogic func_94485_e() {
      return Block.field_94343_co;
   }

   protected BlockRedstoneLogic func_94484_i() {
      return Block.field_94346_cn;
   }

   public int func_71857_b() {
      return 37;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      boolean var3 = this.field_72222_c || (p_71858_2_ & 8) != 0;
      return p_71858_1_ == 0?(var3?Block.field_72035_aQ.func_71851_a(p_71858_1_):Block.field_72049_aP.func_71851_a(p_71858_1_)):(p_71858_1_ == 1?(var3?Block.field_94343_co.field_94336_cN:this.field_94336_cN):Block.field_72085_aj.func_71851_a(1));
   }

   protected boolean func_96470_c(int p_96470_1_) {
      return this.field_72222_c || (p_96470_1_ & 8) != 0;
   }

   protected int func_94480_d(IBlockAccess p_94480_1_, int p_94480_2_, int p_94480_3_, int p_94480_4_, int p_94480_5_) {
      return this.func_96475_a_(p_94480_1_, p_94480_2_, p_94480_3_, p_94480_4_).func_96100_a();
   }

   private int func_94491_m(World p_94491_1_, int p_94491_2_, int p_94491_3_, int p_94491_4_, int p_94491_5_) {
      return !this.func_94490_c(p_94491_5_)?this.func_72220_e(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_):Math.max(this.func_72220_e(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_) - this.func_94482_f(p_94491_1_, p_94491_2_, p_94491_3_, p_94491_4_, p_94491_5_), 0);
   }

   public boolean func_94490_c(int p_94490_1_) {
      return (p_94490_1_ & 4) == 4;
   }

   protected boolean func_94478_d(World p_94478_1_, int p_94478_2_, int p_94478_3_, int p_94478_4_, int p_94478_5_) {
      int var6 = this.func_72220_e(p_94478_1_, p_94478_2_, p_94478_3_, p_94478_4_, p_94478_5_);
      if(var6 >= 15) {
         return true;
      } else if(var6 == 0) {
         return false;
      } else {
         int var7 = this.func_94482_f(p_94478_1_, p_94478_2_, p_94478_3_, p_94478_4_, p_94478_5_);
         return var7 == 0?true:var6 >= var7;
      }
   }

   protected int func_72220_e(World p_72220_1_, int p_72220_2_, int p_72220_3_, int p_72220_4_, int p_72220_5_) {
      int var6 = super.func_72220_e(p_72220_1_, p_72220_2_, p_72220_3_, p_72220_4_, p_72220_5_);
      int var7 = func_72217_d(p_72220_5_);
      int var8 = p_72220_2_ + Direction.field_71583_a[var7];
      int var9 = p_72220_4_ + Direction.field_71581_b[var7];
      int var10 = p_72220_1_.func_72798_a(var8, p_72220_3_, var9);
      if(var10 > 0) {
         if(Block.field_71973_m[var10].func_96468_q_()) {
            var6 = Block.field_71973_m[var10].func_94328_b_(p_72220_1_, var8, p_72220_3_, var9, Direction.field_71580_e[var7]);
         } else if(var6 < 15 && Block.func_71932_i(var10)) {
            var8 += Direction.field_71583_a[var7];
            var9 += Direction.field_71581_b[var7];
            var10 = p_72220_1_.func_72798_a(var8, p_72220_3_, var9);
            if(var10 > 0 && Block.field_71973_m[var10].func_96468_q_()) {
               var6 = Block.field_71973_m[var10].func_94328_b_(p_72220_1_, var8, p_72220_3_, var9, Direction.field_71580_e[var7]);
            }
         }
      }

      return var6;
   }

   public TileEntityComparator func_96475_a_(IBlockAccess p_96475_1_, int p_96475_2_, int p_96475_3_, int p_96475_4_) {
      return (TileEntityComparator)p_96475_1_.func_72796_p(p_96475_2_, p_96475_3_, p_96475_4_);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
      boolean var11 = this.field_72222_c | (var10 & 8) != 0;
      boolean var12 = !this.func_94490_c(var10);
      int var13 = var12?4:0;
      var13 |= var11?8:0;
      p_71903_1_.func_72908_a((double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 0.5D, (double)p_71903_4_ + 0.5D, "random.click", 0.3F, var12?0.55F:0.5F);
      p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var13 | var10 & 3, 2);
      this.func_96476_c(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_1_.field_73012_v);
      return true;
   }

   protected void func_94479_f(World p_94479_1_, int p_94479_2_, int p_94479_3_, int p_94479_4_, int p_94479_5_) {
      if(!p_94479_1_.func_94573_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca)) {
         int var6 = p_94479_1_.func_72805_g(p_94479_2_, p_94479_3_, p_94479_4_);
         int var7 = this.func_94491_m(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6);
         int var8 = this.func_96475_a_(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_).func_96100_a();
         if(var7 != var8 || this.func_96470_c(var6) != this.func_94478_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6)) {
            if(this.func_83011_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6)) {
               p_94479_1_.func_82740_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca, this.func_94481_j_(0), -1);
            } else {
               p_94479_1_.func_82740_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca, this.func_94481_j_(0), 0);
            }
         }
      }

   }

   private void func_96476_c(World p_96476_1_, int p_96476_2_, int p_96476_3_, int p_96476_4_, Random p_96476_5_) {
      int var6 = p_96476_1_.func_72805_g(p_96476_2_, p_96476_3_, p_96476_4_);
      int var7 = this.func_94491_m(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_, var6);
      int var8 = this.func_96475_a_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_).func_96100_a();
      this.func_96475_a_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_).func_96099_a(var7);
      if(var8 != var7 || !this.func_94490_c(var6)) {
         boolean var9 = this.func_94478_d(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_, var6);
         boolean var10 = this.field_72222_c || (var6 & 8) != 0;
         if(var10 && !var9) {
            p_96476_1_.func_72921_c(p_96476_2_, p_96476_3_, p_96476_4_, var6 & -9, 2);
         } else if(!var10 && var9) {
            p_96476_1_.func_72921_c(p_96476_2_, p_96476_3_, p_96476_4_, var6 | 8, 2);
         }

         this.func_94483_i_(p_96476_1_, p_96476_2_, p_96476_3_, p_96476_4_);
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(this.field_72222_c) {
         int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, this.func_94484_i().field_71990_ca, var6 | 8, 4);
      }

      this.func_96476_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      p_71861_1_.func_72837_a(p_71861_2_, p_71861_3_, p_71861_4_, this.func_72274_a(p_71861_1_));
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      p_71852_1_.func_72932_q(p_71852_2_, p_71852_3_, p_71852_4_);
      this.func_94483_i_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
   }

   public boolean func_71883_b(World p_71883_1_, int p_71883_2_, int p_71883_3_, int p_71883_4_, int p_71883_5_, int p_71883_6_) {
      super.func_71883_b(p_71883_1_, p_71883_2_, p_71883_3_, p_71883_4_, p_71883_5_, p_71883_6_);
      TileEntity var7 = p_71883_1_.func_72796_p(p_71883_2_, p_71883_3_, p_71883_4_);
      return var7 != null?var7.func_70315_b(p_71883_5_, p_71883_6_):false;
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityComparator();
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_72222_c?"comparator_lit":"comparator");
   }
}
