package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.stats.StatBase;
import net.minecraft.util.StatCollector;

public class Achievement extends StatBase {

   public final int field_75993_a;
   public final int field_75991_b;
   public final Achievement field_75992_c;
   private final String field_75996_k;
   @SideOnly(Side.CLIENT)
   private IStatStringFormat field_75994_l;
   public final ItemStack field_75990_d;
   private boolean field_75995_m;


   public Achievement(int p_i3409_1_, String p_i3409_2_, int p_i3409_3_, int p_i3409_4_, Item p_i3409_5_, Achievement p_i3409_6_) {
      this(p_i3409_1_, p_i3409_2_, p_i3409_3_, p_i3409_4_, new ItemStack(p_i3409_5_), p_i3409_6_);
   }

   public Achievement(int p_i3410_1_, String p_i3410_2_, int p_i3410_3_, int p_i3410_4_, Block p_i3410_5_, Achievement p_i3410_6_) {
      this(p_i3410_1_, p_i3410_2_, p_i3410_3_, p_i3410_4_, new ItemStack(p_i3410_5_), p_i3410_6_);
   }

   public Achievement(int p_i3411_1_, String p_i3411_2_, int p_i3411_3_, int p_i3411_4_, ItemStack p_i3411_5_, Achievement p_i3411_6_) {
      super(5242880 + p_i3411_1_, "achievement." + p_i3411_2_);
      this.field_75990_d = p_i3411_5_;
      this.field_75996_k = "achievement." + p_i3411_2_ + ".desc";
      this.field_75993_a = p_i3411_3_;
      this.field_75991_b = p_i3411_4_;
      if(p_i3411_3_ < AchievementList.field_76010_a) {
         AchievementList.field_76010_a = p_i3411_3_;
      }

      if(p_i3411_4_ < AchievementList.field_76008_b) {
         AchievementList.field_76008_b = p_i3411_4_;
      }

      if(p_i3411_3_ > AchievementList.field_76009_c) {
         AchievementList.field_76009_c = p_i3411_3_;
      }

      if(p_i3411_4_ > AchievementList.field_76006_d) {
         AchievementList.field_76006_d = p_i3411_4_;
      }

      this.field_75992_c = p_i3411_6_;
   }

   public Achievement func_75986_a() {
      this.field_75972_f = true;
      return this;
   }

   public Achievement func_75987_b() {
      this.field_75995_m = true;
      return this;
   }

   public Achievement func_75985_c() {
      super.func_75971_g();
      AchievementList.field_76007_e.add(this);
      return this;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_75967_d() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public String func_75989_e() {
      return this.field_75994_l != null?this.field_75994_l.func_74535_a(StatCollector.func_74838_a(this.field_75996_k)):StatCollector.func_74838_a(this.field_75996_k);
   }

   @SideOnly(Side.CLIENT)
   public Achievement func_75988_a(IStatStringFormat p_75988_1_) {
      this.field_75994_l = p_75988_1_;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_75984_f() {
      return this.field_75995_m;
   }

   // $FF: synthetic method
   public StatBase func_75971_g() {
      return this.func_75985_c();
   }

   // $FF: synthetic method
   public StatBase func_75966_h() {
      return this.func_75986_a();
   }
}
