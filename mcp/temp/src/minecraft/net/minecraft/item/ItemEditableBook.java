package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemEditableBook extends Item {

   public ItemEditableBook(int p_i3698_1_) {
      super(p_i3698_1_);
      this.func_77625_d(1);
   }

   public static boolean func_77828_a(NBTTagCompound p_77828_0_) {
      if(!ItemWritableBook.func_77829_a(p_77828_0_)) {
         return false;
      } else if(!p_77828_0_.func_74764_b("title")) {
         return false;
      } else {
         String var1 = p_77828_0_.func_74779_i("title");
         return var1 != null && var1.length() <= 16?p_77828_0_.func_74764_b("author"):false;
      }
   }

   public String func_77628_j(ItemStack p_77628_1_) {
      if(p_77628_1_.func_77942_o()) {
         NBTTagCompound var2 = p_77628_1_.func_77978_p();
         NBTTagString var3 = (NBTTagString)var2.func_74781_a("title");
         if(var3 != null) {
            return var3.toString();
         }
      }

      return super.func_77628_j(p_77628_1_);
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      if(p_77624_1_.func_77942_o()) {
         NBTTagCompound var5 = p_77624_1_.func_77978_p();
         NBTTagString var6 = (NBTTagString)var5.func_74781_a("author");
         if(var6 != null) {
            p_77624_3_.add(EnumChatFormatting.GRAY + String.format(StatCollector.func_74837_a("book.byAuthor", new Object[]{var6.field_74751_a}), new Object[0]));
         }
      }

   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71048_c(p_77659_1_);
      return p_77659_1_;
   }

   public boolean func_77651_p() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(ItemStack p_77636_1_) {
      return true;
   }
}
