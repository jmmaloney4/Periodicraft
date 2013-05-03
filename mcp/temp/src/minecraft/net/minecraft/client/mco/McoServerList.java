package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import net.minecraft.client.mco.McoServerListINNER1;
import net.minecraft.client.mco.TimerTaskMcoServerListUpdate;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class McoServerList {

   private volatile boolean field_98259_a = false;
   private TimerTaskMcoServerListUpdate field_98257_b;
   private Timer field_98258_c = new Timer();
   private List field_98255_d = new ArrayList();
   private boolean field_98256_e = false;
   private Session field_98254_f;


   public McoServerList(Session p_i20000_1_) {
      this.field_98254_f = p_i20000_1_;
      this.field_98257_b = new TimerTaskMcoServerListUpdate(this, (McoServerListINNER1)null);
      this.field_98258_c.schedule(this.field_98257_b, 0L, 10000L);
   }

   public synchronized boolean func_98251_a() {
      return this.field_98256_e;
   }

   public synchronized void func_98250_b() {
      this.field_98256_e = false;
   }

   public synchronized List func_98252_c() {
      return Collections.unmodifiableList(this.field_98255_d);
   }

   private synchronized void func_96426_a(List p_96426_1_) {
      if(!p_96426_1_.equals(this.field_98255_d)) {
         this.field_98255_d = p_96426_1_;
         this.field_98256_e = true;
      }

   }

   public synchronized void func_98248_d() {
      this.field_98259_a = true;
      this.field_98257_b.cancel();
      this.field_98258_c.cancel();
   }

   // $FF: synthetic method
   static Session func_100014_a(McoServerList p_100014_0_) {
      return p_100014_0_.field_98254_f;
   }

   // $FF: synthetic method
   static boolean func_98249_b(McoServerList p_98249_0_) {
      return p_98249_0_.field_98259_a;
   }

   // $FF: synthetic method
   static void func_98247_a(McoServerList p_98247_0_, List p_98247_1_) throws IOException {
      p_98247_0_.func_96426_a(p_98247_1_);
   }
}
