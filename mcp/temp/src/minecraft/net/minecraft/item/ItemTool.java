package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTool extends Item {

   private Block[] field_77863_c;
   public float field_77864_a = 4.0F;
   public int field_77865_bY;
   protected EnumToolMaterial field_77862_b;


   protected ItemTool(int p_i3643_1_, int p_i3643_2_, EnumToolMaterial p_i3643_3_, Block[] p_i3643_4_) {
      super(p_i3643_1_);
      this.field_77862_b = p_i3643_3_;
      this.field_77863_c = p_i3643_4_;
      this.field_77777_bU = 1;
      this.func_77656_e(p_i3643_3_.func_77997_a());
      this.field_77864_a = p_i3643_3_.func_77998_b();
      this.field_77865_bY = p_i3643_2_ + p_i3643_3_.func_78000_c();
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      for(int var3 = 0; var3 < this.field_77863_c.length; ++var3) {
         if(this.field_77863_c[var3] == p_77638_2_) {
            return this.field_77864_a;
         }
      }

      return 1.0F;
   }

   public boolean func_77644_a(ItemStack p_77644_1_, EntityLiving p_77644_2_, EntityLiving p_77644_3_) {
      p_77644_1_.func_77972_a(2, p_77644_3_);
      return true;
   }

   public boolean func_77660_a(ItemStack p_77660_1_, World p_77660_2_, int p_77660_3_, int p_77660_4_, int p_77660_5_, int p_77660_6_, EntityLiving p_77660_7_) {
      if((double)Block.field_71973_m[p_77660_3_].func_71934_m(p_77660_2_, p_77660_4_, p_77660_5_, p_77660_6_) != 0.0D) {
         p_77660_1_.func_77972_a(1, p_77660_7_);
      }

      return true;
   }

   public int func_77649_a(Entity p_77649_1_) {
      return this.field_77865_bY;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77662_d() {
      return true;
   }

   public int func_77619_b() {
      return this.field_77862_b.func_77995_e();
   }

   public String func_77861_e() {
      return this.field_77862_b.toString();
   }

   public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_) {
      return this.field_77862_b.func_82844_f() == p_82789_2_.field_77993_c?true:super.func_82789_a(p_82789_1_, p_82789_2_);
   }
}
