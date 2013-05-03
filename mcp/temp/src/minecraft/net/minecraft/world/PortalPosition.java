package net.minecraft.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;

public class PortalPosition extends ChunkCoordinates {

   public long field_85087_d;
   // $FF: synthetic field
   final Teleporter field_85088_e;


   public PortalPosition(Teleporter p_i6815_1_, int p_i6815_2_, int p_i6815_3_, int p_i6815_4_, long p_i6815_5_) {
      super(p_i6815_2_, p_i6815_3_, p_i6815_4_);
      this.field_85088_e = p_i6815_1_;
      this.field_85087_d = p_i6815_5_;
   }
}
