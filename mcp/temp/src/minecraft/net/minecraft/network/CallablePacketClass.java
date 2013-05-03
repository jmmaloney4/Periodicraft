package net.minecraft.network;

import java.util.concurrent.Callable;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;

class CallablePacketClass implements Callable {

   // $FF: synthetic field
   final Packet field_98227_a;
   // $FF: synthetic field
   final NetServerHandler field_98226_b;


   CallablePacketClass(NetServerHandler p_i11033_1_, Packet p_i11033_2_) {
      this.field_98226_b = p_i11033_1_;
      this.field_98227_a = p_i11033_2_;
   }

   public String func_98225_a() {
      return this.field_98227_a.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_98225_a();
   }
}
