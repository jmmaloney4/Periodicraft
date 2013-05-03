package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentMineshaftRoom;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureMineshaftStart extends StructureStart {

   public StructureMineshaftStart(World p_i3811_1_, Random p_i3811_2_, int p_i3811_3_, int p_i3811_4_) {
      ComponentMineshaftRoom var5 = new ComponentMineshaftRoom(0, p_i3811_2_, (p_i3811_3_ << 4) + 2, (p_i3811_4_ << 4) + 2);
      this.field_75075_a.add(var5);
      var5.func_74861_a(var5, this.field_75075_a, p_i3811_2_);
      this.func_75072_c();
      this.func_75067_a(p_i3811_1_, p_i3811_2_, 10);
   }
}
