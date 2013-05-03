package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94385_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94384_b;


   protected BlockWorkbench(int p_i4024_1_) {
      super(p_i4024_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94385_a:(p_71858_1_ == 0?Block.field_71988_x.func_71851_a(p_71858_1_):(p_71858_1_ != 2 && p_71858_1_ != 4?this.field_94336_cN:this.field_94384_b));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("workbench_side");
      this.field_94385_a = p_94332_1_.func_94245_a("workbench_top");
      this.field_94384_b = p_94332_1_.func_94245_a("workbench_front");
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         p_71903_5_.func_71058_b(p_71903_2_, p_71903_3_, p_71903_4_);
         return true;
      }
   }
}
