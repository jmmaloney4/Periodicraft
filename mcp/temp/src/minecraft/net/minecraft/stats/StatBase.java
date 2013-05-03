package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.stats.AchievementMap;
import net.minecraft.stats.IStatType;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatTypeDistance;
import net.minecraft.stats.StatTypeSimple;
import net.minecraft.stats.StatTypeTime;
import net.minecraft.util.StatCollector;

public class StatBase {

   public final int field_75975_e;
   public final String field_75978_a;
   public boolean field_75972_f;
   public String field_75973_g;
   private final IStatType field_75976_b;
   private static NumberFormat field_75977_c = NumberFormat.getIntegerInstance(Locale.US);
   public static IStatType field_75980_h = new StatTypeSimple();
   private static DecimalFormat field_75974_d = new DecimalFormat("########0.00");
   public static IStatType field_75981_i = new StatTypeTime();
   public static IStatType field_75979_j = new StatTypeDistance();


   public StatBase(int p_i3415_1_, String p_i3415_2_, IStatType p_i3415_3_) {
      this.field_75972_f = false;
      this.field_75975_e = p_i3415_1_;
      this.field_75978_a = p_i3415_2_;
      this.field_75976_b = p_i3415_3_;
   }

   public StatBase(int p_i3416_1_, String p_i3416_2_) {
      this(p_i3416_1_, p_i3416_2_, field_75980_h);
   }

   public StatBase func_75966_h() {
      this.field_75972_f = true;
      return this;
   }

   public StatBase func_75971_g() {
      if(StatList.field_75942_a.containsKey(Integer.valueOf(this.field_75975_e))) {
         throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_75942_a.get(Integer.valueOf(this.field_75975_e))).field_75978_a + "\" and \"" + this.field_75978_a + "\" at id " + this.field_75975_e);
      } else {
         StatList.field_75940_b.add(this);
         StatList.field_75942_a.put(Integer.valueOf(this.field_75975_e), this);
         this.field_75973_g = AchievementMap.func_75962_a(this.field_75975_e);
         return this;
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_75967_d() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public String func_75968_a(int p_75968_1_) {
      return this.field_75976_b.func_75843_a(p_75968_1_);
   }

   @SideOnly(Side.CLIENT)
   public String func_75970_i() {
      return this.field_75978_a;
   }

   public String toString() {
      return StatCollector.func_74838_a(this.field_75978_a);
   }

   @SideOnly(Side.CLIENT)
   // $FF: synthetic method
   static NumberFormat func_75965_j() {
      return field_75977_c;
   }

   @SideOnly(Side.CLIENT)
   // $FF: synthetic method
   static DecimalFormat func_75969_k() {
      return field_75974_d;
   }

}
