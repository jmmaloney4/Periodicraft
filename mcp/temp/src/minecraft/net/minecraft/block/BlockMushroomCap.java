package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMushroomCap extends Block {

   private static final String[] field_94429_a = new String[]{"mushroom_skin_brown", "mushroom_skin_red"};
   private final int field_72197_a;
   @SideOnly(Side.CLIENT)
   private Icon[] field_94428_c;
   @SideOnly(Side.CLIENT)
   private Icon field_94426_cO;
   @SideOnly(Side.CLIENT)
   private Icon field_94427_cP;


   public BlockMushroomCap(int p_i9065_1_, Material p_i9065_2_, int p_i9065_3_) {
      super(p_i9065_1_, p_i9065_2_);
      this.field_72197_a = p_i9065_3_;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_2_ == 10 && p_71858_1_ > 1?this.field_94426_cO:(p_71858_2_ >= 1 && p_71858_2_ <= 9 && p_71858_1_ == 1?this.field_94428_c[this.field_72197_a]:(p_71858_2_ >= 1 && p_71858_2_ <= 3 && p_71858_1_ == 2?this.field_94428_c[this.field_72197_a]:(p_71858_2_ >= 7 && p_71858_2_ <= 9 && p_71858_1_ == 3?this.field_94428_c[this.field_72197_a]:((p_71858_2_ == 1 || p_71858_2_ == 4 || p_71858_2_ == 7) && p_71858_1_ == 4?this.field_94428_c[this.field_72197_a]:((p_71858_2_ == 3 || p_71858_2_ == 6 || p_71858_2_ == 9) && p_71858_1_ == 5?this.field_94428_c[this.field_72197_a]:(p_71858_2_ == 14?this.field_94428_c[this.field_72197_a]:(p_71858_2_ == 15?this.field_94426_cO:this.field_94427_cP)))))));
   }

   public int func_71925_a(Random p_71925_1_) {
      int var2 = p_71925_1_.nextInt(10) - 7;
      if(var2 < 0) {
         var2 = 0;
      }

      return var2;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72109_af.field_71990_ca + this.field_72197_a;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Block.field_72109_af.field_71990_ca + this.field_72197_a;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94428_c = new Icon[field_94429_a.length];

      for(int var2 = 0; var2 < this.field_94428_c.length; ++var2) {
         this.field_94428_c[var2] = p_94332_1_.func_94245_a(field_94429_a[var2]);
      }

      this.field_94427_cP = p_94332_1_.func_94245_a("mushroom_inside");
      this.field_94426_cO = p_94332_1_.func_94245_a("mushroom_skin_stem");
   }

}
