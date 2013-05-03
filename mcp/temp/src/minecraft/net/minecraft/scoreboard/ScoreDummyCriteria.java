package net.minecraft.scoreboard;

import java.util.List;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;

public class ScoreDummyCriteria implements ScoreObjectiveCriteria {

   private final String field_96644_g;


   public ScoreDummyCriteria(String p_i10065_1_) {
      this.field_96644_g = p_i10065_1_;
      ScoreObjectiveCriteria.field_96643_a.put(p_i10065_1_, this);
   }

   public String func_96636_a() {
      return this.field_96644_g;
   }

   public int func_96635_a(List p_96635_1_) {
      return 0;
   }

   public boolean func_96637_b() {
      return false;
   }
}
