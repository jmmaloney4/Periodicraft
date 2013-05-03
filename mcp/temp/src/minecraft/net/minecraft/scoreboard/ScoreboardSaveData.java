package net.minecraft.scoreboard;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldSavedData;

public class ScoreboardSaveData extends WorldSavedData {

   private Scoreboard field_96507_a;
   private NBTTagCompound field_96506_b;


   public ScoreboardSaveData() {
      this("scoreboard");
   }

   public ScoreboardSaveData(String p_i10064_1_) {
      super(p_i10064_1_);
   }

   public void func_96499_a(Scoreboard p_96499_1_) {
      this.field_96507_a = p_96499_1_;
      if(this.field_96506_b != null) {
         this.func_76184_a(this.field_96506_b);
      }

   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      if(this.field_96507_a == null) {
         this.field_96506_b = p_76184_1_;
      } else {
         this.func_96501_b(p_76184_1_.func_74761_m("Objectives"));
         this.func_96500_c(p_76184_1_.func_74761_m("PlayerScores"));
         if(p_76184_1_.func_74764_b("DisplaySlots")) {
            this.func_96504_c(p_76184_1_.func_74775_l("DisplaySlots"));
         }

         if(p_76184_1_.func_74764_b("Teams")) {
            this.func_96498_a(p_76184_1_.func_74761_m("Teams"));
         }

      }
   }

   protected void func_96498_a(NBTTagList p_96498_1_) {
      for(int var2 = 0; var2 < p_96498_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = (NBTTagCompound)p_96498_1_.func_74743_b(var2);
         ScorePlayerTeam var4 = this.field_96507_a.func_96527_f(var3.func_74779_i("Name"));
         var4.func_96664_a(var3.func_74779_i("DisplayName"));
         var4.func_96666_b(var3.func_74779_i("Prefix"));
         var4.func_96662_c(var3.func_74779_i("Suffix"));
         if(var3.func_74764_b("AllowFriendlyFire")) {
            var4.func_96660_a(var3.func_74767_n("AllowFriendlyFire"));
         }

         if(var3.func_74764_b("SeeFriendlyInvisibles")) {
            var4.func_98300_b(var3.func_74767_n("SeeFriendlyInvisibles"));
         }

         this.func_96502_a(var4, var3.func_74761_m("Players"));
      }

   }

   protected void func_96502_a(ScorePlayerTeam p_96502_1_, NBTTagList p_96502_2_) {
      for(int var3 = 0; var3 < p_96502_2_.func_74745_c(); ++var3) {
         this.field_96507_a.func_96521_a(((NBTTagString)p_96502_2_.func_74743_b(var3)).field_74751_a, p_96502_1_);
      }

   }

   protected void func_96504_c(NBTTagCompound p_96504_1_) {
      for(int var2 = 0; var2 < 3; ++var2) {
         if(p_96504_1_.func_74764_b("slot_" + var2)) {
            String var3 = p_96504_1_.func_74779_i("slot_" + var2);
            ScoreObjective var4 = this.field_96507_a.func_96518_b(var3);
            this.field_96507_a.func_96530_a(var2, var4);
         }
      }

   }

   protected void func_96501_b(NBTTagList p_96501_1_) {
      for(int var2 = 0; var2 < p_96501_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = (NBTTagCompound)p_96501_1_.func_74743_b(var2);
         ScoreObjectiveCriteria var4 = (ScoreObjectiveCriteria)ScoreObjectiveCriteria.field_96643_a.get(var3.func_74779_i("CriteriaName"));
         ScoreObjective var5 = this.field_96507_a.func_96535_a(var3.func_74779_i("Name"), var4);
         var5.func_96681_a(var3.func_74779_i("DisplayName"));
      }

   }

   protected void func_96500_c(NBTTagList p_96500_1_) {
      for(int var2 = 0; var2 < p_96500_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = (NBTTagCompound)p_96500_1_.func_74743_b(var2);
         ScoreObjective var4 = this.field_96507_a.func_96518_b(var3.func_74779_i("Objective"));
         Score var5 = this.field_96507_a.func_96529_a(var3.func_74779_i("Name"), var4);
         var5.func_96647_c(var3.func_74762_e("Score"));
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      if(this.field_96507_a == null) {
         MinecraftServer.func_71276_C().func_98033_al().func_98236_b("Tried to save scoreboard without having a scoreboard...");
      } else {
         p_76187_1_.func_74782_a("Objectives", this.func_96505_b());
         p_76187_1_.func_74782_a("PlayerScores", this.func_96503_e());
         p_76187_1_.func_74782_a("Teams", this.func_96496_a());
         this.func_96497_d(p_76187_1_);
      }
   }

   protected NBTTagList func_96496_a() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96525_g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScorePlayerTeam var4 = (ScorePlayerTeam)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74778_a("Name", var4.func_96661_b());
         var5.func_74778_a("DisplayName", var4.func_96669_c());
         var5.func_74778_a("Prefix", var4.func_96668_e());
         var5.func_74778_a("Suffix", var4.func_96663_f());
         var5.func_74757_a("AllowFriendlyFire", var4.func_96665_g());
         var5.func_74757_a("SeeFriendlyInvisibles", var4.func_98297_h());
         NBTTagList var6 = new NBTTagList();
         Iterator var7 = var4.func_96670_d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.func_74742_a(new NBTTagString("", var8));
         }

         var5.func_74782_a("Players", var6);
         var1.func_74742_a(var5);
      }

      return var1;
   }

   protected void func_96497_d(NBTTagCompound p_96497_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      boolean var3 = false;

      for(int var4 = 0; var4 < 3; ++var4) {
         ScoreObjective var5 = this.field_96507_a.func_96539_a(var4);
         if(var5 != null) {
            var2.func_74778_a("slot_" + var4, var5.func_96679_b());
            var3 = true;
         }
      }

      if(var3) {
         p_96497_1_.func_74766_a("DisplaySlots", var2);
      }

   }

   protected NBTTagList func_96505_b() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96514_c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScoreObjective var4 = (ScoreObjective)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74778_a("Name", var4.func_96679_b());
         var5.func_74778_a("CriteriaName", var4.func_96680_c().func_96636_a());
         var5.func_74778_a("DisplayName", var4.func_96678_d());
         var1.func_74742_a(var5);
      }

      return var1;
   }

   protected NBTTagList func_96503_e() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96528_e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Score var4 = (Score)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74778_a("Name", var4.func_96653_e());
         var5.func_74778_a("Objective", var4.func_96645_d().func_96679_b());
         var5.func_74768_a("Score", var4.func_96652_c());
         var1.func_74742_a(var5);
      }

      return var1;
   }
}
