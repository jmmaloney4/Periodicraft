package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class BlockCarrot extends BlockCrops {

   @SideOnly(Side.CLIENT)
   private Icon[] field_94364_a;


   public BlockCarrot(int p_i5101_1_) {
      super(p_i5101_1_);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_2_ < 7) {
         if(p_71858_2_ == 6) {
            p_71858_2_ = 5;
         }

         return this.field_94364_a[p_71858_2_ >> 1];
      } else {
         return this.field_94364_a[3];
      }
   }

   protected int func_82532_h() {
      return Item.field_82797_bK.field_77779_bT;
   }

   protected int func_82533_j() {
      return Item.field_82797_bK.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94364_a = new Icon[4];

      for(int var2 = 0; var2 < this.field_94364_a.length; ++var2) {
         this.field_94364_a[var2] = p_94332_1_.func_94245_a("carrots_" + var2);
      }

   }
}
