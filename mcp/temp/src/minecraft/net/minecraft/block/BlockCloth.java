package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockCloth extends Block {

   @SideOnly(Side.CLIENT)
   private Icon[] field_94349_a;


   public BlockCloth() {
      super(35, Material.field_76253_m);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.field_94349_a[p_71858_2_ % this.field_94349_a.length];
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

   public static int func_72238_e_(int p_72238_0_) {
      return ~p_72238_0_ & 15;
   }

   public static int func_72239_d(int p_72239_0_) {
      return ~p_72239_0_ & 15;
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      for(int var4 = 0; var4 < 16; ++var4) {
         p_71879_3_.add(new ItemStack(p_71879_1_, 1, var4));
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94349_a = new Icon[16];

      for(int var2 = 0; var2 < this.field_94349_a.length; ++var2) {
         this.field_94349_a[var2] = p_94332_1_.func_94245_a("cloth_" + var2);
      }

   }
}
