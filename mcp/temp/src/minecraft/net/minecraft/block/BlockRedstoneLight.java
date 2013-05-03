package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockRedstoneLight extends Block {

   private final boolean field_72166_a;


   public BlockRedstoneLight(int p_i3988_1_, boolean p_i3988_2_) {
      super(p_i3988_1_, Material.field_76263_r);
      this.field_72166_a = p_i3988_2_;
      if(p_i3988_2_) {
         this.func_71900_a(1.0F);
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      if(this.field_72166_a) {
         this.field_94336_cN = p_94332_1_.func_94245_a("redstoneLight_lit");
      } else {
         this.field_94336_cN = p_94332_1_.func_94245_a("redstoneLight");
      }

   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      if(!p_71861_1_.field_72995_K) {
         if(this.field_72166_a && !p_71861_1_.func_72864_z(p_71861_2_, p_71861_3_, p_71861_4_)) {
            p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, this.field_71990_ca, 4);
         } else if(!this.field_72166_a && p_71861_1_.func_72864_z(p_71861_2_, p_71861_3_, p_71861_4_)) {
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_, p_71861_4_, Block.field_72080_bM.field_71990_ca, 0, 2);
         }
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K) {
         if(this.field_72166_a && !p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_)) {
            p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, 4);
         } else if(!this.field_72166_a && p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_)) {
            p_71863_1_.func_72832_d(p_71863_2_, p_71863_3_, p_71863_4_, Block.field_72080_bM.field_71990_ca, 0, 2);
         }
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K && this.field_72166_a && !p_71847_1_.func_72864_z(p_71847_2_, p_71847_3_, p_71847_4_)) {
         p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72078_bL.field_71990_ca, 0, 2);
      }

   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72078_bL.field_71990_ca;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Block.field_72078_bL.field_71990_ca;
   }
}
