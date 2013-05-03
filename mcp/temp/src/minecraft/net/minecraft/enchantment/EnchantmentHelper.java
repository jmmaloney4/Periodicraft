package net.minecraft.enchantment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.enchantment.Empty3;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentModifierDamage;
import net.minecraft.enchantment.EnchantmentModifierLiving;
import net.minecraft.enchantment.IEnchantmentModifier;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandom;

public class EnchantmentHelper {

   private static final Random field_77522_a = new Random();
   private static final EnchantmentModifierDamage field_77520_b = new EnchantmentModifierDamage((Empty3)null);
   private static final EnchantmentModifierLiving field_77521_c = new EnchantmentModifierLiving((Empty3)null);


   public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_) {
      if(p_77506_1_ == null) {
         return 0;
      } else {
         NBTTagList var2 = p_77506_1_.func_77986_q();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("id");
               short var5 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("lvl");
               if(var4 == p_77506_0_) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   public static Map func_82781_a(ItemStack p_82781_0_) {
      LinkedHashMap var1 = new LinkedHashMap();
      NBTTagList var2 = p_82781_0_.field_77993_c == Item.field_92105_bW.field_77779_bT?Item.field_92105_bW.func_92110_g(p_82781_0_):p_82781_0_.func_77986_q();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            short var4 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("id");
            short var5 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("lvl");
            var1.put(Integer.valueOf(var4), Integer.valueOf(var5));
         }
      }

      return var1;
   }

   public static void func_82782_a(Map p_82782_0_, ItemStack p_82782_1_) {
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = p_82782_0_.keySet().iterator();

      while(var3.hasNext()) {
         int var4 = ((Integer)var3.next()).intValue();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74777_a("id", (short)var4);
         var5.func_74777_a("lvl", (short)((Integer)p_82782_0_.get(Integer.valueOf(var4))).intValue());
         var2.func_74742_a(var5);
         if(p_82782_1_.field_77993_c == Item.field_92105_bW.field_77779_bT) {
            Item.field_92105_bW.func_92115_a(p_82782_1_, new EnchantmentData(var4, ((Integer)p_82782_0_.get(Integer.valueOf(var4))).intValue()));
         }
      }

      if(var2.func_74745_c() > 0) {
         if(p_82782_1_.field_77993_c != Item.field_92105_bW.field_77779_bT) {
            p_82782_1_.func_77983_a("ench", var2);
         }
      } else if(p_82782_1_.func_77942_o()) {
         p_82782_1_.func_77978_p().func_82580_o("ench");
      }

   }

   public static int func_77511_a(int p_77511_0_, ItemStack[] p_77511_1_) {
      if(p_77511_1_ == null) {
         return 0;
      } else {
         int var2 = 0;
         ItemStack[] var3 = p_77511_1_;
         int var4 = p_77511_1_.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ItemStack var6 = var3[var5];
            int var7 = func_77506_a(p_77511_0_, var6);
            if(var7 > var2) {
               var2 = var7;
            }
         }

         return var2;
      }
   }

   private static void func_77518_a(IEnchantmentModifier p_77518_0_, ItemStack p_77518_1_) {
      if(p_77518_1_ != null) {
         NBTTagList var2 = p_77518_1_.func_77986_q();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("id");
               short var5 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("lvl");
               if(Enchantment.field_77331_b[var4] != null) {
                  p_77518_0_.func_77493_a(Enchantment.field_77331_b[var4], var5);
               }
            }

         }
      }
   }

   private static void func_77516_a(IEnchantmentModifier p_77516_0_, ItemStack[] p_77516_1_) {
      ItemStack[] var2 = p_77516_1_;
      int var3 = p_77516_1_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         func_77518_a(p_77516_0_, var5);
      }

   }

   public static int func_77508_a(ItemStack[] p_77508_0_, DamageSource p_77508_1_) {
      field_77520_b.field_77497_a = 0;
      field_77520_b.field_77496_b = p_77508_1_;
      func_77516_a(field_77520_b, p_77508_0_);
      if(field_77520_b.field_77497_a > 25) {
         field_77520_b.field_77497_a = 25;
      }

      return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
   }

   public static int func_77512_a(EntityLiving p_77512_0_, EntityLiving p_77512_1_) {
      field_77521_c.field_77495_a = 0;
      field_77521_c.field_77494_b = p_77512_1_;
      func_77518_a(field_77521_c, p_77512_0_.func_70694_bm());
      return field_77521_c.field_77495_a > 0?1 + field_77522_a.nextInt(field_77521_c.field_77495_a):0;
   }

   public static int func_77507_b(EntityLiving p_77507_0_, EntityLiving p_77507_1_) {
      return func_77506_a(Enchantment.field_77337_m.field_77352_x, p_77507_0_.func_70694_bm());
   }

   public static int func_90036_a(EntityLiving p_90036_0_) {
      return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_90036_0_.func_70694_bm());
   }

   public static int func_77501_a(EntityLiving p_77501_0_) {
      return func_77511_a(Enchantment.field_77340_h.field_77352_x, p_77501_0_.func_70035_c());
   }

   public static int func_77509_b(EntityLiving p_77509_0_) {
      return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70694_bm());
   }

   public static boolean func_77502_d(EntityLiving p_77502_0_) {
      return func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70694_bm()) > 0;
   }

   public static int func_77517_e(EntityLiving p_77517_0_) {
      return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70694_bm());
   }

   public static int func_77519_f(EntityLiving p_77519_0_) {
      return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70694_bm());
   }

   public static boolean func_77510_g(EntityLiving p_77510_0_) {
      return func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.func_70035_c()) > 0;
   }

   public static int func_92098_i(EntityLiving p_92098_0_) {
      return func_77511_a(Enchantment.field_92091_k.field_77352_x, p_92098_0_.func_70035_c());
   }

   public static ItemStack func_92099_a(Enchantment p_92099_0_, EntityLiving p_92099_1_) {
      ItemStack[] var2 = p_92099_1_.func_70035_c();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         if(var5 != null && func_77506_a(p_92099_0_.field_77352_x, var5) > 0) {
            return var5;
         }
      }

      return null;
   }

   public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_) {
      Item var4 = p_77514_3_.func_77973_b();
      int var5 = var4.func_77619_b();
      if(var5 <= 0) {
         return 0;
      } else {
         if(p_77514_2_ > 15) {
            p_77514_2_ = 15;
         }

         int var6 = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
         return p_77514_1_ == 0?Math.max(var6 / 3, 1):(p_77514_1_ == 1?var6 * 2 / 3 + 1:Math.max(var6, p_77514_2_ * 2));
      }
   }

   public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_) {
      List var3 = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
      boolean var4 = p_77504_1_.field_77993_c == Item.field_77760_aL.field_77779_bT;
      if(var4) {
         p_77504_1_.field_77993_c = Item.field_92105_bW.field_77779_bT;
      }

      if(var3 != null) {
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            EnchantmentData var6 = (EnchantmentData)var5.next();
            if(var4) {
               Item.field_92105_bW.func_92115_a(p_77504_1_, var6);
            } else {
               p_77504_1_.func_77966_a(var6.field_76302_b, var6.field_76303_c);
            }
         }
      }

      return p_77504_1_;
   }

   public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_) {
      Item var3 = p_77513_1_.func_77973_b();
      int var4 = var3.func_77619_b();
      if(var4 <= 0) {
         return null;
      } else {
         var4 /= 2;
         var4 = 1 + p_77513_0_.nextInt((var4 >> 1) + 1) + p_77513_0_.nextInt((var4 >> 1) + 1);
         int var5 = var4 + p_77513_2_;
         float var6 = (p_77513_0_.nextFloat() + p_77513_0_.nextFloat() - 1.0F) * 0.15F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         if(var7 < 1) {
            var7 = 1;
         }

         ArrayList var8 = null;
         Map var9 = func_77505_b(var7, p_77513_1_);
         if(var9 != null && !var9.isEmpty()) {
            EnchantmentData var10 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
            if(var10 != null) {
               var8 = new ArrayList();
               var8.add(var10);

               for(int var11 = var7; p_77513_0_.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(true) {
                        if(var15.hasNext()) {
                           EnchantmentData var16 = (EnchantmentData)var15.next();
                           if(var16.field_76302_b.func_77326_a(Enchantment.field_77331_b[var13.intValue()])) {
                              continue;
                           }

                           var14 = false;
                        }

                        if(!var14) {
                           var12.remove();
                        }
                        break;
                     }
                  }

                  if(!var9.isEmpty()) {
                     EnchantmentData var17 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_) {
      Item var2 = p_77505_1_.func_77973_b();
      HashMap var3 = null;
      boolean var4 = p_77505_1_.field_77993_c == Item.field_77760_aL.field_77779_bT;
      Enchantment[] var5 = Enchantment.field_77331_b;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Enchantment var8 = var5[var7];
         if(var8 != null && (var8.field_77351_y.func_77557_a(var2) || var4)) {
            for(int var9 = var8.func_77319_d(); var9 <= var8.func_77325_b(); ++var9) {
               if(p_77505_0_ >= var8.func_77321_a(var9) && p_77505_0_ <= var8.func_77317_b(var9)) {
                  if(var3 == null) {
                     var3 = new HashMap();
                  }

                  var3.put(Integer.valueOf(var8.field_77352_x), new EnchantmentData(var8, var9));
               }
            }
         }
      }

      return var3;
   }

}
