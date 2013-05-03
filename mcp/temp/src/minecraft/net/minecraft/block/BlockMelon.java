package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class BlockMelon extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94423_a;


   protected BlockMelon(int p_i3968_1_) {
      super(p_i3968_1_, Material.field_76266_z);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ != 1 && p_71858_1_ != 0?this.field_94336_cN:this.field_94423_a;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77738_bf.field_77779_bT;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 3 + p_71925_1_.nextInt(5);
   }

   public int func_71910_a(int p_71910_1_, Random p_71910_2_) {
      int var3 = this.func_71925_a(p_71910_2_) + p_71910_2_.nextInt(1 + p_71910_1_);
      if(var3 > 9) {
         var3 = 9;
      }

      return var3;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("melon_side");
      this.field_94423_a = p_94332_1_.func_94245_a("melon_top");
   }
}
