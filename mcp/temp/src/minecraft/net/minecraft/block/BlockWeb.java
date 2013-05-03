package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockWeb extends Block {

   public BlockWeb(int p_i9100_1_) {
      super(p_i9100_1_, Material.field_76232_D);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      p_71869_5_.func_70110_aj();
   }

   public boolean func_71926_d() {
      return false;
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public int func_71857_b() {
      return 1;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77683_K.field_77779_bT;
   }

   protected boolean func_71906_q_() {
      return true;
   }
}
