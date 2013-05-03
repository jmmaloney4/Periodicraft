package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMinecartEmpty extends EntityMinecart {

   public EntityMinecartEmpty(World p_i9005_1_) {
      super(p_i9005_1_);
   }

   public EntityMinecartEmpty(World p_i9006_1_, double p_i9006_2_, double p_i9006_4_, double p_i9006_6_) {
      super(p_i9006_1_, p_i9006_2_, p_i9006_4_, p_i9006_6_);
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != p_70085_1_) {
         return true;
      } else if(this.field_70153_n != null && this.field_70153_n != p_70085_1_) {
         return false;
      } else {
         if(!this.field_70170_p.field_72995_K) {
            p_70085_1_.func_70078_a(this);
         }

         return true;
      }
   }

   public int func_94087_l() {
      return 0;
   }
}
