package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemMonsterPlacer extends Item {

   @SideOnly(Side.CLIENT)
   private Icon field_94593_a;


   public ItemMonsterPlacer(int p_i3671_1_) {
      super(p_i3671_1_);
      this.func_77627_a(true);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public String func_77628_j(ItemStack p_77628_1_) {
      String var2 = ("" + StatCollector.func_74838_a(this.func_77658_a() + ".name")).trim();
      String var3 = EntityList.func_75617_a(p_77628_1_.func_77960_j());
      if(var3 != null) {
         var2 = var2 + " " + StatCollector.func_74838_a("entity." + var3 + ".name");
      }

      return var2;
   }

   @SideOnly(Side.CLIENT)
   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      EntityEggInfo var3 = (EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(p_82790_1_.func_77960_j()));
      return var3 != null?(p_82790_2_ == 0?var3.field_75611_b:var3.field_75612_c):16777215;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.field_72995_K) {
         return true;
      } else {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         p_77648_4_ += Facing.field_71586_b[p_77648_7_];
         p_77648_5_ += Facing.field_71587_c[p_77648_7_];
         p_77648_6_ += Facing.field_71585_d[p_77648_7_];
         double var12 = 0.0D;
         if(p_77648_7_ == 1 && Block.field_71973_m[var11] != null && Block.field_71973_m[var11].func_71857_b() == 11) {
            var12 = 0.5D;
         }

         Entity var14 = func_77840_a(p_77648_3_, p_77648_1_.func_77960_j(), (double)p_77648_4_ + 0.5D, (double)p_77648_5_ + var12, (double)p_77648_6_ + 0.5D);
         if(var14 != null) {
            if(var14 instanceof EntityLiving && p_77648_1_.func_82837_s()) {
               ((EntityLiving)var14).func_94058_c(p_77648_1_.func_82833_r());
            }

            if(!p_77648_2_.field_71075_bZ.field_75098_d) {
               --p_77648_1_.field_77994_a;
            }
         }

         return true;
      }
   }

   public static Entity func_77840_a(World p_77840_0_, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_) {
      if(!EntityList.field_75627_a.containsKey(Integer.valueOf(p_77840_1_))) {
         return null;
      } else {
         Entity var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = EntityList.func_75616_a(p_77840_1_, p_77840_0_);
            if(var8 != null && var8 instanceof EntityLiving) {
               EntityLiving var10 = (EntityLiving)var8;
               var8.func_70012_b(p_77840_2_, p_77840_4_, p_77840_6_, MathHelper.func_76142_g(p_77840_0_.field_73012_v.nextFloat() * 360.0F), 0.0F);
               var10.field_70759_as = var10.field_70177_z;
               var10.field_70761_aq = var10.field_70177_z;
               var10.func_82163_bD();
               p_77840_0_.func_72838_d(var8);
               var10.func_70642_aH();
            }
         }

         return var8;
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77623_v() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77618_c(int p_77618_1_, int p_77618_2_) {
      return p_77618_2_ > 0?this.field_94593_a:super.func_77618_c(p_77618_1_, p_77618_2_);
   }

   @SideOnly(Side.CLIENT)
   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      Iterator var4 = EntityList.field_75627_a.values().iterator();

      while(var4.hasNext()) {
         EntityEggInfo var5 = (EntityEggInfo)var4.next();
         p_77633_3_.add(new ItemStack(p_77633_1_, 1, var5.field_75613_a));
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IconRegister p_94581_1_) {
      super.func_94581_a(p_94581_1_);
      this.field_94593_a = p_94581_1_.func_94245_a("monsterPlacer_overlay");
   }
}
