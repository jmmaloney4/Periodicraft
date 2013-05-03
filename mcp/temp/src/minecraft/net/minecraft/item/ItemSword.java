package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSword extends Item {

   private int field_77827_a;
   private final EnumToolMaterial field_77826_b;


   public ItemSword(int p_i3695_1_, EnumToolMaterial p_i3695_2_) {
      super(p_i3695_1_);
      this.field_77826_b = p_i3695_2_;
      this.field_77777_bU = 1;
      this.func_77656_e(p_i3695_2_.func_77997_a());
      this.func_77637_a(CreativeTabs.field_78037_j);
      this.field_77827_a = 4 + p_i3695_2_.func_78000_c();
   }

   public int func_82803_g() {
      return this.field_77826_b.func_78000_c();
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      if(p_77638_2_.field_71990_ca == Block.field_71955_W.field_71990_ca) {
         return 15.0F;
      } else {
         Material var3 = p_77638_2_.field_72018_cp;
         return var3 != Material.field_76254_j && var3 != Material.field_76255_k && var3 != Material.field_76261_t && var3 != Material.field_76257_i && var3 != Material.field_76266_z?1.0F:1.5F;
      }
   }

   public boolean func_77644_a(ItemStack p_77644_1_, EntityLiving p_77644_2_, EntityLiving p_77644_3_) {
      p_77644_1_.func_77972_a(1, p_77644_3_);
      return true;
   }

   public boolean func_77660_a(ItemStack p_77660_1_, World p_77660_2_, int p_77660_3_, int p_77660_4_, int p_77660_5_, int p_77660_6_, EntityLiving p_77660_7_) {
      if((double)Block.field_71973_m[p_77660_3_].func_71934_m(p_77660_2_, p_77660_4_, p_77660_5_, p_77660_6_) != 0.0D) {
         p_77660_1_.func_77972_a(2, p_77660_7_);
      }

      return true;
   }

   public int func_77649_a(Entity p_77649_1_) {
      return this.field_77827_a;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77662_d() {
      return true;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.block;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 72000;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
      return p_77659_1_;
   }

   public boolean func_77641_a(Block p_77641_1_) {
      return p_77641_1_.field_71990_ca == Block.field_71955_W.field_71990_ca;
   }

   public int func_77619_b() {
      return this.field_77826_b.func_77995_e();
   }

   public String func_77825_f() {
      return this.field_77826_b.toString();
   }

   public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_) {
      return this.field_77826_b.func_82844_f() == p_82789_2_.field_77993_c?true:super.func_82789_a(p_82789_1_, p_82789_2_);
   }
}
