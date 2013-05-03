package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.EnumGameType;

@SideOnly(Side.CLIENT)
public class SaveFormatComparator implements Comparable {

   private final String field_75797_a;
   private final String field_75795_b;
   private final long field_75796_c;
   private final long field_75793_d;
   private final boolean field_75794_e;
   private final EnumGameType field_75791_f;
   private final boolean field_75792_g;
   private final boolean field_75798_h;


   public SaveFormatComparator(String p_i3917_1_, String p_i3917_2_, long p_i3917_3_, long p_i3917_5_, EnumGameType p_i3917_7_, boolean p_i3917_8_, boolean p_i3917_9_, boolean p_i3917_10_) {
      this.field_75797_a = p_i3917_1_;
      this.field_75795_b = p_i3917_2_;
      this.field_75796_c = p_i3917_3_;
      this.field_75793_d = p_i3917_5_;
      this.field_75791_f = p_i3917_7_;
      this.field_75794_e = p_i3917_8_;
      this.field_75792_g = p_i3917_9_;
      this.field_75798_h = p_i3917_10_;
   }

   public String func_75786_a() {
      return this.field_75797_a;
   }

   public String func_75788_b() {
      return this.field_75795_b;
   }

   public boolean func_75785_d() {
      return this.field_75794_e;
   }

   public long func_75784_e() {
      return this.field_75796_c;
   }

   public int func_75787_a(SaveFormatComparator p_75787_1_) {
      return this.field_75796_c < p_75787_1_.field_75796_c?1:(this.field_75796_c > p_75787_1_.field_75796_c?-1:this.field_75797_a.compareTo(p_75787_1_.field_75797_a));
   }

   public EnumGameType func_75790_f() {
      return this.field_75791_f;
   }

   public boolean func_75789_g() {
      return this.field_75792_g;
   }

   public boolean func_75783_h() {
      return this.field_75798_h;
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_75787_a((SaveFormatComparator)p_compareTo_1_);
   }
}
