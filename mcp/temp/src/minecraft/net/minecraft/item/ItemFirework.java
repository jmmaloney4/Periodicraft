package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFirework extends Item {

   public ItemFirework(int p_i8013_1_) {
      super(p_i8013_1_);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(!p_77648_3_.field_72995_K) {
         EntityFireworkRocket var11 = new EntityFireworkRocket(p_77648_3_, (double)((float)p_77648_4_ + p_77648_8_), (double)((float)p_77648_5_ + p_77648_9_), (double)((float)p_77648_6_ + p_77648_10_), p_77648_1_);
         p_77648_3_.func_72838_d(var11);
         if(!p_77648_2_.field_71075_bZ.field_75098_d) {
            --p_77648_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      if(p_77624_1_.func_77942_o()) {
         NBTTagCompound var5 = p_77624_1_.func_77978_p().func_74775_l("Fireworks");
         if(var5 != null) {
            if(var5.func_74764_b("Flight")) {
               p_77624_3_.add(StatCollector.func_74838_a("item.fireworks.flight") + " " + var5.func_74771_c("Flight"));
            }

            NBTTagList var6 = var5.func_74761_m("Explosions");
            if(var6 != null && var6.func_74745_c() > 0) {
               for(int var7 = 0; var7 < var6.func_74745_c(); ++var7) {
                  NBTTagCompound var8 = (NBTTagCompound)var6.func_74743_b(var7);
                  ArrayList var9 = new ArrayList();
                  ItemFireworkCharge.func_92107_a(var8, var9);
                  if(var9.size() > 0) {
                     for(int var10 = 1; var10 < var9.size(); ++var10) {
                        var9.set(var10, "  " + (String)var9.get(var10));
                     }

                     p_77624_3_.addAll(var9);
                  }
               }
            }

         }
      }
   }
}
