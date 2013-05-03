package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSign extends BlockContainer {

   private Class field_72279_a;
   private boolean field_72278_b;


   protected BlockSign(int p_i3993_1_, Class p_i3993_2_, boolean p_i3993_3_) {
      super(p_i3993_1_, Material.field_76245_d);
      this.field_72278_b = p_i3993_3_;
      this.field_72279_a = p_i3993_2_;
      float var4 = 0.25F;
      float var5 = 1.0F;
      this.func_71905_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var5, 0.5F + var4);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return Block.field_71988_x.func_71851_a(p_71858_1_);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      this.func_71902_a(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
      return super.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      if(!this.field_72278_b) {
         int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
         float var6 = 0.28125F;
         float var7 = 0.78125F;
         float var8 = 0.0F;
         float var9 = 1.0F;
         float var10 = 0.125F;
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         if(var5 == 2) {
            this.func_71905_a(var8, var6, 1.0F - var10, var9, var7, 1.0F);
         }

         if(var5 == 3) {
            this.func_71905_a(var8, var6, 0.0F, var9, var7, var10);
         }

         if(var5 == 4) {
            this.func_71905_a(1.0F - var10, var6, var8, 1.0F, var7, var9);
         }

         if(var5 == 5) {
            this.func_71905_a(0.0F, var6, var8, var10, var7, var9);
         }

      }
   }

   public int func_71857_b() {
      return -1;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return true;
   }

   public boolean func_71926_d() {
      return false;
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      try {
         return (TileEntity)this.field_72279_a.newInstance();
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77792_au.field_77779_bT;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      boolean var6 = false;
      if(this.field_72278_b) {
         if(!p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_ - 1, p_71863_4_).func_76220_a()) {
            var6 = true;
         }
      } else {
         int var7 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
         var6 = true;
         if(var7 == 2 && p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_, p_71863_4_ + 1).func_76220_a()) {
            var6 = false;
         }

         if(var7 == 3 && p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_, p_71863_4_ - 1).func_76220_a()) {
            var6 = false;
         }

         if(var7 == 4 && p_71863_1_.func_72803_f(p_71863_2_ + 1, p_71863_3_, p_71863_4_).func_76220_a()) {
            var6 = false;
         }

         if(var7 == 5 && p_71863_1_.func_72803_f(p_71863_2_ - 1, p_71863_3_, p_71863_4_).func_76220_a()) {
            var6 = false;
         }
      }

      if(var6) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77792_au.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {}
}
