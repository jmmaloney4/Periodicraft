package net.minecraft.scoreboard;

import java.util.Comparator;
import net.minecraft.scoreboard.Score;

final class ScoreComparator implements Comparator {

   public int func_96659_a(Score p_96659_1_, Score p_96659_2_) {
      return p_96659_1_.func_96652_c() > p_96659_2_.func_96652_c()?1:(p_96659_1_.func_96652_c() < p_96659_2_.func_96652_c()?-1:0);
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_96659_a((Score)p_compare_1_, (Score)p_compare_2_);
   }
}
