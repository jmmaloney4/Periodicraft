package net.minecraft.network;

import java.util.concurrent.Callable;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;

class CallablePacketID implements Callable {

   // $FF: synthetic field
   final Packet field_98245_a;
   // $FF: synthetic field
   final NetServerHandler field_98244_b;


   CallablePacketID(NetServerHandler p_i11032_1_, Packet p_i11032_2_) {
      this.field_98244_b = p_i11032_1_;
      this.field_98245_a = p_i11032_2_;
   }

   public String func_98243_a() {
      return String.valueOf(this.field_98245_a.func_73281_k());
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_98243_a();
   }
}
