package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class ItemWritableBook extends Item {

   public ItemWritableBook(int p_i3697_1_) {
      super(p_i3697_1_);
      this.func_77625_d(1);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71048_c(p_77659_1_);
      return p_77659_1_;
   }

   public boolean func_77651_p() {
      return true;
   }

   public static boolean func_77829_a(NBTTagCompound p_77829_0_) {
      if(p_77829_0_ == null) {
         return false;
      } else if(!p_77829_0_.func_74764_b("pages")) {
         return false;
      } else {
         NBTTagList var1 = (NBTTagList)p_77829_0_.func_74781_a("pages");

         for(int var2 = 0; var2 < var1.func_74745_c(); ++var2) {
            NBTTagString var3 = (NBTTagString)var1.func_74743_b(var2);
            if(var3.field_74751_a == null) {
               return false;
            }

            if(var3.field_74751_a.length() > 256) {
               return false;
            }
         }

         return true;
      }
   }
}
