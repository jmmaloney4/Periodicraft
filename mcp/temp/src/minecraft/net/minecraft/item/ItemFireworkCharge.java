package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

public class ItemFireworkCharge extends Item {

   @SideOnly(Side.CLIENT)
   private Icon field_94596_a;


   public ItemFireworkCharge(int p_i8012_1_) {
      super(p_i8012_1_);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77618_c(int p_77618_1_, int p_77618_2_) {
      return p_77618_2_ > 0?this.field_94596_a:super.func_77618_c(p_77618_1_, p_77618_2_);
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      if(p_82790_2_ != 1) {
         return super.func_82790_a(p_82790_1_, p_82790_2_);
      } else {
         NBTBase var3 = func_92108_a(p_82790_1_, "Colors");
         if(var3 == null) {
            return 9079434;
         } else {
            NBTTagIntArray var4 = (NBTTagIntArray)var3;
            if(var4.field_74749_a.length == 1) {
               return var4.field_74749_a[0];
            } else {
               int var5 = 0;
               int var6 = 0;
               int var7 = 0;
               int[] var8 = var4.field_74749_a;
               int var9 = var8.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  int var11 = var8[var10];
                  var5 += (var11 & 16711680) >> 16;
                  var6 += (var11 & '\uff00') >> 8;
                  var7 += (var11 & 255) >> 0;
               }

               var5 /= var4.field_74749_a.length;
               var6 /= var4.field_74749_a.length;
               var7 /= var4.field_74749_a.length;
               return var5 << 16 | var6 << 8 | var7;
            }
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77623_v() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public static NBTBase func_92108_a(ItemStack p_92108_0_, String p_92108_1_) {
      if(p_92108_0_.func_77942_o()) {
         NBTTagCompound var2 = p_92108_0_.func_77978_p().func_74775_l("Explosion");
         if(var2 != null) {
            return var2.func_74781_a(p_92108_1_);
         }
      }

      return null;
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      if(p_77624_1_.func_77942_o()) {
         NBTTagCompound var5 = p_77624_1_.func_77978_p().func_74775_l("Explosion");
         if(var5 != null) {
            func_92107_a(var5, p_77624_3_);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public static void func_92107_a(NBTTagCompound p_92107_0_, List p_92107_1_) {
      byte var2 = p_92107_0_.func_74771_c("Type");
      if(var2 >= 0 && var2 <= 4) {
         p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type." + var2).trim());
      } else {
         p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.type").trim());
      }

      int[] var3 = p_92107_0_.func_74759_k("Colors");
      int var8;
      int var9;
      if(var3.length > 0) {
         boolean var4 = true;
         String var5 = "";
         int[] var6 = var3;
         int var7 = var3.length;

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var6[var8];
            if(!var4) {
               var5 = var5 + ", ";
            }

            var4 = false;
            boolean var10 = false;

            for(int var11 = 0; var11 < 16; ++var11) {
               if(var9 == ItemDye.field_77859_b[var11]) {
                  var10 = true;
                  var5 = var5 + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_77860_a[var11]);
                  break;
               }
            }

            if(!var10) {
               var5 = var5 + StatCollector.func_74838_a("item.fireworksCharge.customColor");
            }
         }

         p_92107_1_.add(var5);
      }

      int[] var13 = p_92107_0_.func_74759_k("FadeColors");
      boolean var16;
      if(var13.length > 0) {
         var16 = true;
         String var14 = StatCollector.func_74838_a("item.fireworksCharge.fadeTo") + " ";
         int[] var15 = var13;
         var8 = var13.length;

         for(var9 = 0; var9 < var8; ++var9) {
            int var18 = var15[var9];
            if(!var16) {
               var14 = var14 + ", ";
            }

            var16 = false;
            boolean var19 = false;

            for(int var12 = 0; var12 < 16; ++var12) {
               if(var18 == ItemDye.field_77859_b[var12]) {
                  var19 = true;
                  var14 = var14 + StatCollector.func_74838_a("item.fireworksCharge." + ItemDye.field_77860_a[var12]);
                  break;
               }
            }

            if(!var19) {
               var14 = var14 + StatCollector.func_74838_a("item.fireworksCharge.customColor");
            }
         }

         p_92107_1_.add(var14);
      }

      var16 = p_92107_0_.func_74767_n("Trail");
      if(var16) {
         p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.trail"));
      }

      boolean var17 = p_92107_0_.func_74767_n("Flicker");
      if(var17) {
         p_92107_1_.add(StatCollector.func_74838_a("item.fireworksCharge.flicker"));
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IconRegister p_94581_1_) {
      super.func_94581_a(p_94581_1_);
      this.field_94596_a = p_94581_1_.func_94245_a("fireworksCharge_overlay");
   }
}
