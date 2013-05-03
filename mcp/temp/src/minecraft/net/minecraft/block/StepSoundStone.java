package net.minecraft.block;

import net.minecraft.block.StepSound;

final class StepSoundStone extends StepSound {

   StepSoundStone(String p_i4006_1_, float p_i4006_2_, float p_i4006_3_) {
      super(p_i4006_1_, p_i4006_2_, p_i4006_3_);
   }

   public String func_72676_a() {
      return "random.glass";
   }

   public String func_82593_b() {
      return "step.stone";
   }
}
