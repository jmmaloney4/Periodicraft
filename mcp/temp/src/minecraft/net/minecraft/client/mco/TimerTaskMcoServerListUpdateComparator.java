package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Comparator;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerListINNER1;
import net.minecraft.client.mco.TimerTaskMcoServerListUpdate;

@SideOnly(Side.CLIENT)
class TimerTaskMcoServerListUpdateComparator implements Comparator {

   private final String field_102024_b;
   // $FF: synthetic field
   final TimerTaskMcoServerListUpdate field_102025_a;


   private TimerTaskMcoServerListUpdateComparator(TimerTaskMcoServerListUpdate p_i22000_1_, String p_i22000_2_) {
      this.field_102025_a = p_i22000_1_;
      this.field_102024_b = p_i22000_2_;
   }

   public int func_102023_a(McoServer p_102023_1_, McoServer p_102023_2_) {
      if(p_102023_1_.field_96405_e.equals(p_102023_2_.field_96405_e)) {
         return p_102023_1_.field_96408_a < p_102023_2_.field_96408_a?1:(p_102023_1_.field_96408_a > p_102023_2_.field_96408_a?-1:0);
      } else if(p_102023_1_.field_96405_e.equals(this.field_102024_b)) {
         return -1;
      } else if(p_102023_2_.field_96405_e.equals(this.field_102024_b)) {
         return 1;
      } else {
         if(p_102023_1_.field_96404_d.equals("CLOSED") || p_102023_2_.field_96404_d.equals("CLOSED")) {
            if(p_102023_1_.field_96404_d.equals("CLOSED")) {
               return 1;
            }

            if(p_102023_2_.field_96404_d.equals("CLOSED")) {
               return 0;
            }
         }

         return p_102023_1_.field_96408_a < p_102023_2_.field_96408_a?1:(p_102023_1_.field_96408_a > p_102023_2_.field_96408_a?-1:0);
      }
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_102023_a((McoServer)p_compare_1_, (McoServer)p_compare_2_);
   }

   // $FF: synthetic method
   TimerTaskMcoServerListUpdateComparator(TimerTaskMcoServerListUpdate p_i22001_1_, String p_i22001_2_, McoServerListINNER1 p_i22001_3_) {
      this(p_i22001_1_, p_i22001_2_);
   }
}
