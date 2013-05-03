package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;

public class ItemEnchantedBook extends Item {

   public ItemEnchantedBook(int p_i8011_1_) {
      super(p_i8011_1_);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(ItemStack p_77636_1_) {
      return true;
   }

   public boolean func_77616_k(ItemStack p_77616_1_) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
      return this.func_92110_g(p_77613_1_).func_74745_c() > 0?EnumRarity.uncommon:super.func_77613_e(p_77613_1_);
   }

   public NBTTagList func_92110_g(ItemStack p_92110_1_) {
      return p_92110_1_.field_77990_d != null && p_92110_1_.field_77990_d.func_74764_b("StoredEnchantments")?(NBTTagList)p_92110_1_.field_77990_d.func_74781_a("StoredEnchantments"):new NBTTagList();
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      super.func_77624_a(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
      NBTTagList var5 = this.func_92110_g(p_77624_1_);
      if(var5 != null) {
         for(int var6 = 0; var6 < var5.func_74745_c(); ++var6) {
            short var7 = ((NBTTagCompound)var5.func_74743_b(var6)).func_74765_d("id");
            short var8 = ((NBTTagCompound)var5.func_74743_b(var6)).func_74765_d("lvl");
            if(Enchantment.field_77331_b[var7] != null) {
               p_77624_3_.add(Enchantment.field_77331_b[var7].func_77316_c(var8));
            }
         }
      }

   }

   public void func_92115_a(ItemStack p_92115_1_, EnchantmentData p_92115_2_) {
      NBTTagList var3 = this.func_92110_g(p_92115_1_);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.func_74745_c(); ++var5) {
         NBTTagCompound var6 = (NBTTagCompound)var3.func_74743_b(var5);
         if(var6.func_74765_d("id") == p_92115_2_.field_76302_b.field_77352_x) {
            if(var6.func_74765_d("lvl") < p_92115_2_.field_76303_c) {
               var6.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         NBTTagCompound var7 = new NBTTagCompound();
         var7.func_74777_a("id", (short)p_92115_2_.field_76302_b.field_77352_x);
         var7.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
         var3.func_74742_a(var7);
      }

      if(!p_92115_1_.func_77942_o()) {
         p_92115_1_.func_77982_d(new NBTTagCompound());
      }

      p_92115_1_.func_77978_p().func_74782_a("StoredEnchantments", var3);
   }

   public ItemStack func_92111_a(EnchantmentData p_92111_1_) {
      ItemStack var2 = new ItemStack(this);
      this.func_92115_a(var2, p_92111_1_);
      return var2;
   }

   @SideOnly(Side.CLIENT)
   public void func_92113_a(Enchantment p_92113_1_, List p_92113_2_) {
      for(int var3 = p_92113_1_.func_77319_d(); var3 <= p_92113_1_.func_77325_b(); ++var3) {
         p_92113_2_.add(this.func_92111_a(new EnchantmentData(p_92113_1_, var3)));
      }

   }

   public ItemStack func_92109_a(Random p_92109_1_) {
      Enchantment var2 = Enchantment.field_92090_c[p_92109_1_.nextInt(Enchantment.field_92090_c.length)];
      ItemStack var3 = new ItemStack(this.field_77779_bT, 1, 0);
      int var4 = MathHelper.func_76136_a(p_92109_1_, var2.func_77319_d(), var2.func_77325_b());
      this.func_92115_a(var3, new EnchantmentData(var2, var4));
      return var3;
   }

   public WeightedRandomChestContent func_92114_b(Random p_92114_1_) {
      return this.func_92112_a(p_92114_1_, 1, 1, 1);
   }

   public WeightedRandomChestContent func_92112_a(Random p_92112_1_, int p_92112_2_, int p_92112_3_, int p_92112_4_) {
      Enchantment var5 = Enchantment.field_92090_c[p_92112_1_.nextInt(Enchantment.field_92090_c.length)];
      ItemStack var6 = new ItemStack(this.field_77779_bT, 1, 0);
      int var7 = MathHelper.func_76136_a(p_92112_1_, var5.func_77319_d(), var5.func_77325_b());
      this.func_92115_a(var6, new EnchantmentData(var5, var7));
      return new WeightedRandomChestContent(var6, p_92112_2_, p_92112_3_, p_92112_4_);
   }
}
