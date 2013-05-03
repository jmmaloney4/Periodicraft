package net.minecraft.scoreboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.scoreboard.Scoreboard;

public class ScorePlayerTeam {

   private final Scoreboard field_96677_a;
   private final String field_96675_b;
   private final Set field_96676_c = new HashSet();
   private String field_96673_d;
   private String field_96674_e = "";
   private String field_96671_f = "";
   private boolean field_96672_g = true;
   private boolean field_98301_h = true;


   public ScorePlayerTeam(Scoreboard p_i10062_1_, String p_i10062_2_) {
      this.field_96677_a = p_i10062_1_;
      this.field_96675_b = p_i10062_2_;
      this.field_96673_d = p_i10062_2_;
   }

   public String func_96661_b() {
      return this.field_96675_b;
   }

   public String func_96669_c() {
      return this.field_96673_d;
   }

   public void func_96664_a(String p_96664_1_) {
      if(p_96664_1_ == null) {
         throw new IllegalArgumentException("Name cannot be null");
      } else {
         this.field_96673_d = p_96664_1_;
         this.field_96677_a.func_96538_b(this);
      }
   }

   public Collection func_96670_d() {
      return this.field_96676_c;
   }

   public String func_96668_e() {
      return this.field_96674_e;
   }

   public void func_96666_b(String p_96666_1_) {
      if(p_96666_1_ == null) {
         throw new IllegalArgumentException("Prefix cannot be null");
      } else {
         this.field_96674_e = p_96666_1_;
         this.field_96677_a.func_96538_b(this);
      }
   }

   public String func_96663_f() {
      return this.field_96671_f;
   }

   public void func_96662_c(String p_96662_1_) {
      if(p_96662_1_ == null) {
         throw new IllegalArgumentException("Suffix cannot be null");
      } else {
         this.field_96671_f = p_96662_1_;
         this.field_96677_a.func_96538_b(this);
      }
   }

   public static String func_96667_a(ScorePlayerTeam p_96667_0_, String p_96667_1_) {
      return p_96667_0_ == null?p_96667_1_:p_96667_0_.func_96668_e() + p_96667_1_ + p_96667_0_.func_96663_f();
   }

   public boolean func_96665_g() {
      return this.field_96672_g;
   }

   public void func_96660_a(boolean p_96660_1_) {
      this.field_96672_g = p_96660_1_;
      this.field_96677_a.func_96538_b(this);
   }

   public boolean func_98297_h() {
      return this.field_98301_h;
   }

   public void func_98300_b(boolean p_98300_1_) {
      this.field_98301_h = p_98300_1_;
      this.field_96677_a.func_96538_b(this);
   }

   public int func_98299_i() {
      int var1 = 0;
      int var2 = 0;
      if(this.func_96665_g()) {
         var1 |= 1 << var2++;
      }

      if(this.func_98297_h()) {
         var1 |= 1 << var2++;
      }

      return var1;
   }

   @SideOnly(Side.CLIENT)
   public void func_98298_a(int p_98298_1_) {
      byte var2 = 0;
      int var4 = var2 + 1;
      this.func_96660_a((p_98298_1_ & 1 << var2) > 0);
      this.func_98300_b((p_98298_1_ & 1 << var4++) > 0);
   }
}
