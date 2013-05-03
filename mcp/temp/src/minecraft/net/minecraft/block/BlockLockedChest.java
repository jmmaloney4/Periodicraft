package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockLockedChest extends Block {

   protected BlockLockedChest(int p_i3967_1_) {
      super(p_i3967_1_, Material.field_76245_d);
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return true;
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {}
}
