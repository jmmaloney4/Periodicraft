package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockBeacon extends BlockContainer {

   @SideOnly(Side.CLIENT)
   private Icon field_94447_a;


   public BlockBeacon(int p_i5099_1_) {
      super(p_i5099_1_, Material.field_76264_q);
      this.func_71848_c(3.0F);
      this.func_71849_a(CreativeTabs.field_78026_f);
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityBeacon();
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         TileEntityBeacon var10 = (TileEntityBeacon)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
         if(var10 != null) {
            p_71903_5_.func_82240_a(var10);
         }

         return true;
      }
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 34;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      super.func_94332_a(p_94332_1_);
      this.field_94447_a = p_94332_1_.func_94245_a("beacon");
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      super.func_71860_a(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, p_71860_5_, p_71860_6_);
      if(p_71860_6_.func_82837_s()) {
         ((TileEntityBeacon)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94047_a(p_71860_6_.func_82833_r());
      }

   }

   @SideOnly(Side.CLIENT)
   public Icon func_94446_i() {
      return this.field_94447_a;
   }
}
