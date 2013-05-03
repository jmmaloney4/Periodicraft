package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class ItemEmptyMap extends ItemMapBase {

   protected ItemEmptyMap(int p_i5083_1_) {
      super(p_i5083_1_);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      ItemStack var4 = new ItemStack(Item.field_77744_bd, 1, p_77659_2_.func_72841_b("map"));
      String var5 = "map_" + var4.func_77960_j();
      MapData var6 = new MapData(var5);
      p_77659_2_.func_72823_a(var5, var6);
      var6.field_76197_d = 0;
      int var7 = 128 * (1 << var6.field_76197_d);
      var6.field_76201_a = (int)(Math.round(p_77659_3_.field_70165_t / (double)var7) * (long)var7);
      var6.field_76199_b = (int)(Math.round(p_77659_3_.field_70161_v / (double)var7) * (long)var7);
      var6.field_76200_c = (byte)p_77659_2_.field_73011_w.field_76574_g;
      var6.func_76185_a();
      --p_77659_1_.field_77994_a;
      if(p_77659_1_.field_77994_a <= 0) {
         return var4;
      } else {
         if(!p_77659_3_.field_71071_by.func_70441_a(var4.func_77946_l())) {
            p_77659_3_.func_71021_b(var4);
         }

         return p_77659_1_;
      }
   }
}
