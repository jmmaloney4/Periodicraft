package net.minecraft.scoreboard;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScoreDummyCriteria;
import net.minecraft.util.MathHelper;

public class ScoreHealthCriteria extends ScoreDummyCriteria {

   public ScoreHealthCriteria(String p_i10066_1_) {
      super(p_i10066_1_);
   }

   public int func_96635_a(List p_96635_1_) {
      float var2 = 0.0F;

      int var5;
      float var6;
      for(Iterator var3 = p_96635_1_.iterator(); var3.hasNext(); var2 += (float)var5 / var6) {
         EntityPlayer var4 = (EntityPlayer)var3.next();
         var5 = var4.func_70630_aN();
         var6 = (float)var4.func_70667_aM();
         if(var5 < 0) {
            var5 = 0;
         }

         if((float)var5 > var6) {
            var5 = var4.func_70667_aM();
         }
      }

      if(p_96635_1_.size() > 0) {
         var2 /= (float)p_96635_1_.size();
      }

      return MathHelper.func_76141_d(var2 * 19.0F) + (var2 > 0.0F?1:0);
   }

   public boolean func_96637_b() {
      return true;
   }
}
