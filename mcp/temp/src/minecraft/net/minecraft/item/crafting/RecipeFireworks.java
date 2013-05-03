package net.minecraft.item.crafting;

import java.util.ArrayList;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class RecipeFireworks implements IRecipe {

   private ItemStack field_92102_a;


   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      this.field_92102_a = null;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      for(int var9 = 0; var9 < p_77569_1_.func_70302_i_(); ++var9) {
         ItemStack var10 = p_77569_1_.func_70301_a(var9);
         if(var10 != null) {
            if(var10.field_77993_c == Item.field_77677_M.field_77779_bT) {
               ++var4;
            } else if(var10.field_77993_c == Item.field_92106_bV.field_77779_bT) {
               ++var6;
            } else if(var10.field_77993_c == Item.field_77756_aW.field_77779_bT) {
               ++var5;
            } else if(var10.field_77993_c == Item.field_77759_aK.field_77779_bT) {
               ++var3;
            } else if(var10.field_77993_c == Item.field_77751_aT.field_77779_bT) {
               ++var7;
            } else if(var10.field_77993_c == Item.field_77702_n.field_77779_bT) {
               ++var7;
            } else if(var10.field_77993_c == Item.field_77811_bE.field_77779_bT) {
               ++var8;
            } else if(var10.field_77993_c == Item.field_77676_L.field_77779_bT) {
               ++var8;
            } else if(var10.field_77993_c == Item.field_77733_bq.field_77779_bT) {
               ++var8;
            } else {
               if(var10.field_77993_c != Item.field_82799_bQ.field_77779_bT) {
                  return false;
               }

               ++var8;
            }
         }
      }

      var7 += var5 + var8;
      if(var4 <= 3 && var3 <= 1) {
         NBTTagCompound var15;
         NBTTagCompound var18;
         if(var4 >= 1 && var3 == 1 && var7 == 0) {
            this.field_92102_a = new ItemStack(Item.field_92104_bU);
            if(var6 > 0) {
               var15 = new NBTTagCompound();
               var18 = new NBTTagCompound("Fireworks");
               NBTTagList var25 = new NBTTagList("Explosions");

               for(int var22 = 0; var22 < p_77569_1_.func_70302_i_(); ++var22) {
                  ItemStack var26 = p_77569_1_.func_70301_a(var22);
                  if(var26 != null && var26.field_77993_c == Item.field_92106_bV.field_77779_bT && var26.func_77942_o() && var26.func_77978_p().func_74764_b("Explosion")) {
                     var25.func_74742_a(var26.func_77978_p().func_74775_l("Explosion"));
                  }
               }

               var18.func_74782_a("Explosions", var25);
               var18.func_74774_a("Flight", (byte)var4);
               var15.func_74782_a("Fireworks", var18);
               this.field_92102_a.func_77982_d(var15);
            }

            return true;
         } else if(var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
            this.field_92102_a = new ItemStack(Item.field_92106_bV);
            var15 = new NBTTagCompound();
            var18 = new NBTTagCompound("Explosion");
            byte var21 = 0;
            ArrayList var12 = new ArrayList();

            for(int var13 = 0; var13 < p_77569_1_.func_70302_i_(); ++var13) {
               ItemStack var14 = p_77569_1_.func_70301_a(var13);
               if(var14 != null) {
                  if(var14.field_77993_c == Item.field_77756_aW.field_77779_bT) {
                     var12.add(Integer.valueOf(ItemDye.field_77859_b[var14.func_77960_j()]));
                  } else if(var14.field_77993_c == Item.field_77751_aT.field_77779_bT) {
                     var18.func_74757_a("Flicker", true);
                  } else if(var14.field_77993_c == Item.field_77702_n.field_77779_bT) {
                     var18.func_74757_a("Trail", true);
                  } else if(var14.field_77993_c == Item.field_77811_bE.field_77779_bT) {
                     var21 = 1;
                  } else if(var14.field_77993_c == Item.field_77676_L.field_77779_bT) {
                     var21 = 4;
                  } else if(var14.field_77993_c == Item.field_77733_bq.field_77779_bT) {
                     var21 = 2;
                  } else if(var14.field_77993_c == Item.field_82799_bQ.field_77779_bT) {
                     var21 = 3;
                  }
               }
            }

            int[] var24 = new int[var12.size()];

            for(int var27 = 0; var27 < var24.length; ++var27) {
               var24[var27] = ((Integer)var12.get(var27)).intValue();
            }

            var18.func_74783_a("Colors", var24);
            var18.func_74774_a("Type", var21);
            var15.func_74782_a("Explosion", var18);
            this.field_92102_a.func_77982_d(var15);
            return true;
         } else if(var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
            ArrayList var16 = new ArrayList();

            for(int var20 = 0; var20 < p_77569_1_.func_70302_i_(); ++var20) {
               ItemStack var11 = p_77569_1_.func_70301_a(var20);
               if(var11 != null) {
                  if(var11.field_77993_c == Item.field_77756_aW.field_77779_bT) {
                     var16.add(Integer.valueOf(ItemDye.field_77859_b[var11.func_77960_j()]));
                  } else if(var11.field_77993_c == Item.field_92106_bV.field_77779_bT) {
                     this.field_92102_a = var11.func_77946_l();
                     this.field_92102_a.field_77994_a = 1;
                  }
               }
            }

            int[] var17 = new int[var16.size()];

            for(int var19 = 0; var19 < var17.length; ++var19) {
               var17[var19] = ((Integer)var16.get(var19)).intValue();
            }

            if(this.field_92102_a != null && this.field_92102_a.func_77942_o()) {
               NBTTagCompound var23 = this.field_92102_a.func_77978_p().func_74775_l("Explosion");
               if(var23 == null) {
                  return false;
               } else {
                  var23.func_74783_a("FadeColors", var17);
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      return this.field_92102_a.func_77946_l();
   }

   public int func_77570_a() {
      return 10;
   }

   public ItemStack func_77571_b() {
      return this.field_92102_a;
   }
}
