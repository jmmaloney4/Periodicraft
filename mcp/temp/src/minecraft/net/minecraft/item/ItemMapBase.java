package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;

public class ItemMapBase extends Item {

   protected ItemMapBase(int p_i3629_1_) {
      super(p_i3629_1_);
   }

   public boolean func_77643_m_() {
      return true;
   }

   public Packet func_77871_c(ItemStack p_77871_1_, World p_77871_2_, EntityPlayer p_77871_3_) {
      return null;
   }
}
