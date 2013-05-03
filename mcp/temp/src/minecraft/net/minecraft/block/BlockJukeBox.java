package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityRecordPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockJukeBox extends BlockContainer {

   @SideOnly(Side.CLIENT)
   private Icon field_94450_a;


   protected BlockJukeBox(int p_i9084_1_) {
      super(p_i9084_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94450_a:this.field_94336_cN;
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_) == 0) {
         return false;
      } else {
         this.func_72276_j_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
         return true;
      }
   }

   public void func_85106_a(World p_85106_1_, int p_85106_2_, int p_85106_3_, int p_85106_4_, ItemStack p_85106_5_) {
      if(!p_85106_1_.field_72995_K) {
         TileEntityRecordPlayer var6 = (TileEntityRecordPlayer)p_85106_1_.func_72796_p(p_85106_2_, p_85106_3_, p_85106_4_);
         if(var6 != null) {
            var6.func_96098_a(p_85106_5_.func_77946_l());
            p_85106_1_.func_72921_c(p_85106_2_, p_85106_3_, p_85106_4_, 1, 2);
         }
      }
   }

   public void func_72276_j_(World p_72276_1_, int p_72276_2_, int p_72276_3_, int p_72276_4_) {
      if(!p_72276_1_.field_72995_K) {
         TileEntityRecordPlayer var5 = (TileEntityRecordPlayer)p_72276_1_.func_72796_p(p_72276_2_, p_72276_3_, p_72276_4_);
         if(var5 != null) {
            ItemStack var6 = var5.func_96097_a();
            if(var6 != null) {
               p_72276_1_.func_72926_e(1005, p_72276_2_, p_72276_3_, p_72276_4_, 0);
               p_72276_1_.func_72934_a((String)null, p_72276_2_, p_72276_3_, p_72276_4_);
               var5.func_96098_a((ItemStack)null);
               p_72276_1_.func_72921_c(p_72276_2_, p_72276_3_, p_72276_4_, 0, 2);
               float var7 = 0.7F;
               double var8 = (double)(p_72276_1_.field_73012_v.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               double var10 = (double)(p_72276_1_.field_73012_v.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
               double var12 = (double)(p_72276_1_.field_73012_v.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               ItemStack var14 = var6.func_77946_l();
               EntityItem var15 = new EntityItem(p_72276_1_, (double)p_72276_2_ + var8, (double)p_72276_3_ + var10, (double)p_72276_4_ + var12, var14);
               var15.field_70293_c = 10;
               p_72276_1_.func_72838_d(var15);
            }
         }
      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      this.func_72276_j_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      if(!p_71914_1_.field_72995_K) {
         super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
      }
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityRecordPlayer();
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("musicBlock");
      this.field_94450_a = p_94332_1_.func_94245_a("jukebox_top");
   }

   public boolean func_96468_q_() {
      return true;
   }

   public int func_94328_b_(World p_94328_1_, int p_94328_2_, int p_94328_3_, int p_94328_4_, int p_94328_5_) {
      ItemStack var6 = ((TileEntityRecordPlayer)p_94328_1_.func_72796_p(p_94328_2_, p_94328_3_, p_94328_4_)).func_96097_a();
      return var6 == null?0:var6.field_77993_c + 1 - Item.field_77819_bI.field_77779_bT;
   }
}
