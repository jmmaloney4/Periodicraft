package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.stats.StatCrafting;
import net.minecraft.util.StatCollector;

public class StatList {

   protected static Map field_75942_a = new HashMap();
   public static List field_75940_b = new ArrayList();
   public static List field_75941_c = new ArrayList();
   public static List field_75938_d = new ArrayList();
   public static List field_75939_e = new ArrayList();
   public static StatBase field_75936_f = (new StatBasic(1000, "stat.startGame")).func_75966_h().func_75971_g();
   public static StatBase field_75937_g = (new StatBasic(1001, "stat.createWorld")).func_75966_h().func_75971_g();
   public static StatBase field_75949_h = (new StatBasic(1002, "stat.loadWorld")).func_75966_h().func_75971_g();
   public static StatBase field_75950_i = (new StatBasic(1003, "stat.joinMultiplayer")).func_75966_h().func_75971_g();
   public static StatBase field_75947_j = (new StatBasic(1004, "stat.leaveGame")).func_75966_h().func_75971_g();
   public static StatBase field_75948_k = (new StatBasic(1100, "stat.playOneMinute", StatBase.field_75981_i)).func_75966_h().func_75971_g();
   public static StatBase field_75945_l = (new StatBasic(2000, "stat.walkOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75946_m = (new StatBasic(2001, "stat.swimOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75943_n = (new StatBasic(2002, "stat.fallOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75944_o = (new StatBasic(2003, "stat.climbOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75958_p = (new StatBasic(2004, "stat.flyOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75957_q = (new StatBasic(2005, "stat.diveOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75956_r = (new StatBasic(2006, "stat.minecartOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75955_s = (new StatBasic(2007, "stat.boatOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75954_t = (new StatBasic(2008, "stat.pigOneCm", StatBase.field_75979_j)).func_75966_h().func_75971_g();
   public static StatBase field_75953_u = (new StatBasic(2010, "stat.jump")).func_75966_h().func_75971_g();
   public static StatBase field_75952_v = (new StatBasic(2011, "stat.drop")).func_75966_h().func_75971_g();
   public static StatBase field_75951_w = (new StatBasic(2020, "stat.damageDealt")).func_75971_g();
   public static StatBase field_75961_x = (new StatBasic(2021, "stat.damageTaken")).func_75971_g();
   public static StatBase field_75960_y = (new StatBasic(2022, "stat.deaths")).func_75971_g();
   public static StatBase field_75959_z = (new StatBasic(2023, "stat.mobKills")).func_75971_g();
   public static StatBase field_75932_A = (new StatBasic(2024, "stat.playerKills")).func_75971_g();
   public static StatBase field_75933_B = (new StatBasic(2025, "stat.fishCaught")).func_75971_g();
   public static StatBase[] field_75934_C = func_75921_a("stat.mineBlock", 16777216);
   public static StatBase[] field_75928_D;
   public static StatBase[] field_75929_E;
   public static StatBase[] field_75930_F;
   private static boolean field_75931_G;
   private static boolean field_75935_H;


   public static void func_75919_a() {}

   public static void func_75922_b() {
      field_75929_E = func_75920_a(field_75929_E, "stat.useItem", 16908288, 0, 256);
      field_75930_F = func_75926_b(field_75930_F, "stat.breakItem", 16973824, 0, 256);
      field_75931_G = true;
      func_75918_d();
   }

   public static void func_75925_c() {
      field_75929_E = func_75920_a(field_75929_E, "stat.useItem", 16908288, 256, 32000);
      field_75930_F = func_75926_b(field_75930_F, "stat.breakItem", 16973824, 256, 32000);
      field_75935_H = true;
      func_75918_d();
   }

   public static void func_75918_d() {
      if(field_75931_G && field_75935_H) {
         HashSet var0 = new HashSet();
         Iterator var1 = CraftingManager.func_77594_a().func_77592_b().iterator();

         while(var1.hasNext()) {
            IRecipe var2 = (IRecipe)var1.next();
            if(var2.func_77571_b() != null) {
               var0.add(Integer.valueOf(var2.func_77571_b().field_77993_c));
            }
         }

         var1 = FurnaceRecipes.func_77602_a().func_77599_b().values().iterator();

         while(var1.hasNext()) {
            ItemStack var4 = (ItemStack)var1.next();
            var0.add(Integer.valueOf(var4.field_77993_c));
         }

         field_75928_D = new StatBase[32000];
         var1 = var0.iterator();

         while(var1.hasNext()) {
            Integer var5 = (Integer)var1.next();
            if(Item.field_77698_e[var5.intValue()] != null) {
               String var3 = StatCollector.func_74837_a("stat.craftItem", new Object[]{Item.field_77698_e[var5.intValue()].func_77635_s()});
               field_75928_D[var5.intValue()] = (new StatCrafting(16842752 + var5.intValue(), var3, var5.intValue())).func_75971_g();
            }
         }

         func_75924_a(field_75928_D);
      }
   }

   private static StatBase[] func_75921_a(String p_75921_0_, int p_75921_1_) {
      StatBase[] var2 = new StatBase[256];

      for(int var3 = 0; var3 < 256; ++var3) {
         if(Block.field_71973_m[var3] != null && Block.field_71973_m[var3].func_71876_u()) {
            String var4 = StatCollector.func_74837_a(p_75921_0_, new Object[]{Block.field_71973_m[var3].func_71931_t()});
            var2[var3] = (new StatCrafting(p_75921_1_ + var3, var4, var3)).func_75971_g();
            field_75939_e.add((StatCrafting)var2[var3]);
         }
      }

      func_75924_a(var2);
      return var2;
   }

   private static StatBase[] func_75920_a(StatBase[] p_75920_0_, String p_75920_1_, int p_75920_2_, int p_75920_3_, int p_75920_4_) {
      if(p_75920_0_ == null) {
         p_75920_0_ = new StatBase[32000];
      }

      for(int var5 = p_75920_3_; var5 < p_75920_4_; ++var5) {
         if(Item.field_77698_e[var5] != null) {
            String var6 = StatCollector.func_74837_a(p_75920_1_, new Object[]{Item.field_77698_e[var5].func_77635_s()});
            p_75920_0_[var5] = (new StatCrafting(p_75920_2_ + var5, var6, var5)).func_75971_g();
            if(var5 >= 256) {
               field_75938_d.add((StatCrafting)p_75920_0_[var5]);
            }
         }
      }

      func_75924_a(p_75920_0_);
      return p_75920_0_;
   }

   private static StatBase[] func_75926_b(StatBase[] p_75926_0_, String p_75926_1_, int p_75926_2_, int p_75926_3_, int p_75926_4_) {
      if(p_75926_0_ == null) {
         p_75926_0_ = new StatBase[32000];
      }

      for(int var5 = p_75926_3_; var5 < p_75926_4_; ++var5) {
         if(Item.field_77698_e[var5] != null && Item.field_77698_e[var5].func_77645_m()) {
            String var6 = StatCollector.func_74837_a(p_75926_1_, new Object[]{Item.field_77698_e[var5].func_77635_s()});
            p_75926_0_[var5] = (new StatCrafting(p_75926_2_ + var5, var6, var5)).func_75971_g();
         }
      }

      func_75924_a(p_75926_0_);
      return p_75926_0_;
   }

   private static void func_75924_a(StatBase[] p_75924_0_) {
      func_75927_a(p_75924_0_, Block.field_71943_B.field_71990_ca, Block.field_71942_A.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_71938_D.field_71990_ca, Block.field_71938_D.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72008_bf.field_71990_ca, Block.field_72061_ba.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72052_aC.field_71990_ca, Block.field_72051_aB.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72048_aO.field_71990_ca, Block.field_72047_aN.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72011_bi.field_71990_ca, Block.field_72010_bh.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72035_aQ.field_71990_ca, Block.field_72049_aP.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72103_ag.field_71990_ca, Block.field_72109_af.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72085_aj.field_71990_ca, Block.field_72079_ak.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72090_bN.field_71990_ca, Block.field_72092_bO.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_71980_u.field_71990_ca, Block.field_71979_v.field_71990_ca);
      func_75927_a(p_75924_0_, Block.field_72050_aA.field_71990_ca, Block.field_71979_v.field_71990_ca);
   }

   private static void func_75927_a(StatBase[] p_75927_0_, int p_75927_1_, int p_75927_2_) {
      if(p_75927_0_[p_75927_1_] != null && p_75927_0_[p_75927_2_] == null) {
         p_75927_0_[p_75927_2_] = p_75927_0_[p_75927_1_];
      } else {
         field_75940_b.remove(p_75927_0_[p_75927_1_]);
         field_75939_e.remove(p_75927_0_[p_75927_1_]);
         field_75941_c.remove(p_75927_0_[p_75927_1_]);
         p_75927_0_[p_75927_1_] = p_75927_0_[p_75927_2_];
      }
   }

   @SideOnly(Side.CLIENT)
   public static StatBase func_75923_a(int p_75923_0_) {
      return (StatBase)field_75942_a.get(Integer.valueOf(p_75923_0_));
   }

   static {
      AchievementList.func_75997_a();
      field_75931_G = false;
      field_75935_H = false;
   }
}
