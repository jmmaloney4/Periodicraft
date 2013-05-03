package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemSlab extends ItemBlock {

   private final boolean field_77891_a;
   private final BlockHalfSlab field_77889_b;
   private final BlockHalfSlab field_77890_c;


   public ItemSlab(int p_i3689_1_, BlockHalfSlab p_i3689_2_, BlockHalfSlab p_i3689_3_, boolean p_i3689_4_) {
      super(p_i3689_1_);
      this.field_77889_b = p_i3689_2_;
      this.field_77890_c = p_i3689_3_;
      this.field_77891_a = p_i3689_4_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      return Block.field_71973_m[this.field_77779_bT].func_71858_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return this.field_77889_b.func_72240_d(p_77667_1_.func_77960_j());
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(this.field_77891_a) {
         return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
      } else if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         int var12 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
         int var13 = var12 & 7;
         boolean var14 = (var12 & 8) != 0;
         if((p_77648_7_ == 1 && !var14 || p_77648_7_ == 0 && var14) && var11 == this.field_77889_b.field_71990_ca && var13 == p_77648_1_.func_77960_j()) {
            if(p_77648_3_.func_72855_b(this.field_77890_c.func_71872_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_77890_c.field_71990_ca, var13, 3)) {
               p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.field_77890_c.field_72020_cn.func_82593_b(), (this.field_77890_c.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, this.field_77890_c.field_72020_cn.func_72678_c() * 0.8F);
               --p_77648_1_.field_77994_a;
            }

            return true;
         } else {
            return this.func_77888_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_)?true:super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77884_a(World p_77884_1_, int p_77884_2_, int p_77884_3_, int p_77884_4_, int p_77884_5_, EntityPlayer p_77884_6_, ItemStack p_77884_7_) {
      int var8 = p_77884_2_;
      int var9 = p_77884_3_;
      int var10 = p_77884_4_;
      int var11 = p_77884_1_.func_72798_a(p_77884_2_, p_77884_3_, p_77884_4_);
      int var12 = p_77884_1_.func_72805_g(p_77884_2_, p_77884_3_, p_77884_4_);
      int var13 = var12 & 7;
      boolean var14 = (var12 & 8) != 0;
      if((p_77884_5_ == 1 && !var14 || p_77884_5_ == 0 && var14) && var11 == this.field_77889_b.field_71990_ca && var13 == p_77884_7_.func_77960_j()) {
         return true;
      } else {
         if(p_77884_5_ == 0) {
            --p_77884_3_;
         }

         if(p_77884_5_ == 1) {
            ++p_77884_3_;
         }

         if(p_77884_5_ == 2) {
            --p_77884_4_;
         }

         if(p_77884_5_ == 3) {
            ++p_77884_4_;
         }

         if(p_77884_5_ == 4) {
            --p_77884_2_;
         }

         if(p_77884_5_ == 5) {
            ++p_77884_2_;
         }

         var11 = p_77884_1_.func_72798_a(p_77884_2_, p_77884_3_, p_77884_4_);
         var12 = p_77884_1_.func_72805_g(p_77884_2_, p_77884_3_, p_77884_4_);
         var13 = var12 & 7;
         var14 = (var12 & 8) != 0;
         return var11 == this.field_77889_b.field_71990_ca && var13 == p_77884_7_.func_77960_j()?true:super.func_77884_a(p_77884_1_, var8, var9, var10, p_77884_5_, p_77884_6_, p_77884_7_);
      }
   }

   private boolean func_77888_a(ItemStack p_77888_1_, EntityPlayer p_77888_2_, World p_77888_3_, int p_77888_4_, int p_77888_5_, int p_77888_6_, int p_77888_7_) {
      if(p_77888_7_ == 0) {
         --p_77888_5_;
      }

      if(p_77888_7_ == 1) {
         ++p_77888_5_;
      }

      if(p_77888_7_ == 2) {
         --p_77888_6_;
      }

      if(p_77888_7_ == 3) {
         ++p_77888_6_;
      }

      if(p_77888_7_ == 4) {
         --p_77888_4_;
      }

      if(p_77888_7_ == 5) {
         ++p_77888_4_;
      }

      int var8 = p_77888_3_.func_72798_a(p_77888_4_, p_77888_5_, p_77888_6_);
      int var9 = p_77888_3_.func_72805_g(p_77888_4_, p_77888_5_, p_77888_6_);
      int var10 = var9 & 7;
      if(var8 == this.field_77889_b.field_71990_ca && var10 == p_77888_1_.func_77960_j()) {
         if(p_77888_3_.func_72855_b(this.field_77890_c.func_71872_e(p_77888_3_, p_77888_4_, p_77888_5_, p_77888_6_)) && p_77888_3_.func_72832_d(p_77888_4_, p_77888_5_, p_77888_6_, this.field_77890_c.field_71990_ca, var10, 3)) {
            p_77888_3_.func_72908_a((double)((float)p_77888_4_ + 0.5F), (double)((float)p_77888_5_ + 0.5F), (double)((float)p_77888_6_ + 0.5F), this.field_77890_c.field_72020_cn.func_82593_b(), (this.field_77890_c.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, this.field_77890_c.field_72020_cn.func_72678_c() * 0.8F);
            --p_77888_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }
}
