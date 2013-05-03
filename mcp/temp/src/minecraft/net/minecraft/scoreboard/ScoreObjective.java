package net.minecraft.scoreboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.Scoreboard;

public class ScoreObjective {

   private final Scoreboard field_96686_a;
   private final String field_96684_b;
   private final ScoreObjectiveCriteria field_96685_c;
   private String field_96683_d;


   public ScoreObjective(Scoreboard p_i10061_1_, String p_i10061_2_, ScoreObjectiveCriteria p_i10061_3_) {
      this.field_96686_a = p_i10061_1_;
      this.field_96684_b = p_i10061_2_;
      this.field_96685_c = p_i10061_3_;
      this.field_96683_d = p_i10061_2_;
   }

   @SideOnly(Side.CLIENT)
   public Scoreboard func_96682_a() {
      return this.field_96686_a;
   }

   public String func_96679_b() {
      return this.field_96684_b;
   }

   public ScoreObjectiveCriteria func_96680_c() {
      return this.field_96685_c;
   }

   public String func_96678_d() {
      return this.field_96683_d;
   }

   public void func_96681_a(String p_96681_1_) {
      this.field_96683_d = p_96681_1_;
      this.field_96686_a.func_96532_b(this);
   }
}
