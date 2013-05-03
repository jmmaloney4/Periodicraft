package net.minecraft.enchantment;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public enum EnumEnchantmentType {

   all("all", 0),
   armor("armor", 1),
   armor_feet("armor_feet", 2),
   armor_legs("armor_legs", 3),
   armor_torso("armor_torso", 4),
   armor_head("armor_head", 5),
   weapon("weapon", 6),
   digger("digger", 7),
   bow("bow", 8);
   // $FF: synthetic field
   private static final EnumEnchantmentType[] $VALUES = new EnumEnchantmentType[]{all, armor, armor_feet, armor_legs, armor_torso, armor_head, weapon, digger, bow};


   private EnumEnchantmentType(String p_i3710_1_, int p_i3710_2_) {}

   public boolean func_77557_a(Item p_77557_1_) {
      if(this == all) {
         return true;
      } else if(p_77557_1_ instanceof ItemArmor) {
         if(this == armor) {
            return true;
         } else {
            ItemArmor var2 = (ItemArmor)p_77557_1_;
            return var2.field_77881_a == 0?this == armor_head:(var2.field_77881_a == 2?this == armor_legs:(var2.field_77881_a == 1?this == armor_torso:(var2.field_77881_a == 3?this == armor_feet:false)));
         }
      } else {
         return p_77557_1_ instanceof ItemSword?this == weapon:(p_77557_1_ instanceof ItemTool?this == digger:(p_77557_1_ instanceof ItemBow?this == bow:false));
      }
   }

}
