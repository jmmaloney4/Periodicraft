package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet200Statistic;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet206SetObjective;
import net.minecraft.network.packet.Packet207SetScore;
import net.minecraft.network.packet.Packet208SetDisplayObjective;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet253ServerAuthData;
import net.minecraft.network.packet.Packet254ServerPing;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26EntityExpOrb;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet2ClientProtocol;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet31RelEntityMove;
import net.minecraft.network.packet.Packet32EntityLook;
import net.minecraft.network.packet.Packet33RelEntityMoveLook;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet35EntityHeadRotation;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet42RemoveEntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet51MapChunk;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet62LevelSound;
import net.minecraft.network.packet.Packet63WorldParticles;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.network.packet.PacketCount;
import net.minecraft.util.IntHashMap;

public abstract class Packet {

   public static IntHashMap field_73294_l = new IntHashMap();
   private static Map field_73291_a = new HashMap();
   private static Set field_73286_b = new HashSet();
   private static Set field_73288_c = new HashSet();
   protected ILogAgent field_98193_m;
   public final long field_73295_m = System.currentTimeMillis();
   public static long field_73292_n;
   public static long field_73293_o;
   public static long field_73290_p;
   public static long field_73289_q;
   public boolean field_73287_r = false;


   public static void func_73285_a(int p_73285_0_, boolean p_73285_1_, boolean p_73285_2_, Class p_73285_3_) {
      if(field_73294_l.func_76037_b(p_73285_0_)) {
         throw new IllegalArgumentException("Duplicate packet id:" + p_73285_0_);
      } else if(field_73291_a.containsKey(p_73285_3_)) {
         throw new IllegalArgumentException("Duplicate packet class:" + p_73285_3_);
      } else {
         field_73294_l.func_76038_a(p_73285_0_, p_73285_3_);
         field_73291_a.put(p_73285_3_, Integer.valueOf(p_73285_0_));
         if(p_73285_1_) {
            field_73286_b.add(Integer.valueOf(p_73285_0_));
         }

         if(p_73285_2_) {
            field_73288_c.add(Integer.valueOf(p_73285_0_));
         }

      }
   }

   public static Packet func_73269_d(ILogAgent p_73269_0_, int p_73269_1_) {
      try {
         Class var2 = (Class)field_73294_l.func_76041_a(p_73269_1_);
         return var2 == null?null:(Packet)var2.newInstance();
      } catch (Exception var3) {
         var3.printStackTrace();
         p_73269_0_.func_98232_c("Skipping packet with id " + p_73269_1_);
         return null;
      }
   }

   public static void func_73274_a(DataOutputStream p_73274_0_, byte[] p_73274_1_) throws IOException {
      p_73274_0_.writeShort(p_73274_1_.length);
      p_73274_0_.write(p_73274_1_);
   }

   public static byte[] func_73280_b(DataInputStream p_73280_0_) throws IOException {
      short var1 = p_73280_0_.readShort();
      if(var1 < 0) {
         throw new IOException("Key was smaller than nothing!  Weird key!");
      } else {
         byte[] var2 = new byte[var1];
         p_73280_0_.readFully(var2);
         return var2;
      }
   }

   public final int func_73281_k() {
      return ((Integer)field_73291_a.get(this.getClass())).intValue();
   }

   public static Packet func_73272_a(ILogAgent p_73272_0_, DataInputStream p_73272_1_, boolean p_73272_2_, Socket p_73272_3_) throws IOException {
      boolean var4 = false;
      Packet var5 = null;
      int var6 = p_73272_3_.getSoTimeout();

      int var9;
      try {
         var9 = p_73272_1_.read();
         if(var9 == -1) {
            return null;
         }

         if(p_73272_2_ && !field_73288_c.contains(Integer.valueOf(var9)) || !p_73272_2_ && !field_73286_b.contains(Integer.valueOf(var9))) {
            throw new IOException("Bad packet id " + var9);
         }

         var5 = func_73269_d(p_73272_0_, var9);
         if(var5 == null) {
            throw new IOException("Bad packet id " + var9);
         }

         var5.field_98193_m = p_73272_0_;
         if(var5 instanceof Packet254ServerPing) {
            p_73272_3_.setSoTimeout(1500);
         }

         var5.func_73267_a(p_73272_1_);
         ++field_73292_n;
         field_73293_o += (long)var5.func_73284_a();
      } catch (EOFException var8) {
         p_73272_0_.func_98232_c("Reached end of stream");
         return null;
      }

      PacketCount.func_76118_a(var9, (long)var5.func_73284_a());
      ++field_73292_n;
      field_73293_o += (long)var5.func_73284_a();
      p_73272_3_.setSoTimeout(var6);
      return var5;
   }

   public static void func_73266_a(Packet p_73266_0_, DataOutputStream p_73266_1_) throws IOException {
      p_73266_1_.write(p_73266_0_.func_73281_k());
      p_73266_0_.func_73273_a(p_73266_1_);
      ++field_73290_p;
      field_73289_q += (long)p_73266_0_.func_73284_a();
   }

   public static void func_73271_a(String p_73271_0_, DataOutputStream p_73271_1_) throws IOException {
      if(p_73271_0_.length() > 32767) {
         throw new IOException("String too big");
      } else {
         p_73271_1_.writeShort(p_73271_0_.length());
         p_73271_1_.writeChars(p_73271_0_);
      }
   }

   public static String func_73282_a(DataInputStream p_73282_0_, int p_73282_1_) throws IOException {
      short var2 = p_73282_0_.readShort();
      if(var2 > p_73282_1_) {
         throw new IOException("Received string length longer than maximum allowed (" + var2 + " > " + p_73282_1_ + ")");
      } else if(var2 < 0) {
         throw new IOException("Received string length is less than zero! Weird string!");
      } else {
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var2; ++var4) {
            var3.append(p_73282_0_.readChar());
         }

         return var3.toString();
      }
   }

   public abstract void func_73267_a(DataInputStream var1) throws IOException;

   public abstract void func_73273_a(DataOutputStream var1) throws IOException;

   public abstract void func_73279_a(NetHandler var1);

   public abstract int func_73284_a();

   public boolean func_73278_e() {
      return false;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return false;
   }

   public boolean func_73277_a_() {
      return false;
   }

   public String toString() {
      String var1 = this.getClass().getSimpleName();
      return var1;
   }

   public static ItemStack func_73276_c(DataInputStream p_73276_0_) throws IOException {
      ItemStack var1 = null;
      short var2 = p_73276_0_.readShort();
      if(var2 >= 0) {
         byte var3 = p_73276_0_.readByte();
         short var4 = p_73276_0_.readShort();
         var1 = new ItemStack(var2, var3, var4);
         var1.field_77990_d = func_73283_d(p_73276_0_);
      }

      return var1;
   }

   public static void func_73270_a(ItemStack p_73270_0_, DataOutputStream p_73270_1_) throws IOException {
      if(p_73270_0_ == null) {
         p_73270_1_.writeShort(-1);
      } else {
         p_73270_1_.writeShort(p_73270_0_.field_77993_c);
         p_73270_1_.writeByte(p_73270_0_.field_77994_a);
         p_73270_1_.writeShort(p_73270_0_.func_77960_j());
         NBTTagCompound var2 = null;
         if(p_73270_0_.func_77973_b().func_77645_m() || p_73270_0_.func_77973_b().func_77651_p()) {
            var2 = p_73270_0_.field_77990_d;
         }

         func_73275_a(var2, p_73270_1_);
      }

   }

   public static NBTTagCompound func_73283_d(DataInputStream p_73283_0_) throws IOException {
      short var1 = p_73283_0_.readShort();
      if(var1 < 0) {
         return null;
      } else {
         byte[] var2 = new byte[var1];
         p_73283_0_.readFully(var2);
         return CompressedStreamTools.func_74792_a(var2);
      }
   }

   protected static void func_73275_a(NBTTagCompound p_73275_0_, DataOutputStream p_73275_1_) throws IOException {
      if(p_73275_0_ == null) {
         p_73275_1_.writeShort(-1);
      } else {
         byte[] var2 = CompressedStreamTools.func_74798_a(p_73275_0_);
         p_73275_1_.writeShort((short)var2.length);
         p_73275_1_.write(var2);
      }

   }

   static {
      func_73285_a(0, true, true, Packet0KeepAlive.class);
      func_73285_a(1, true, true, Packet1Login.class);
      func_73285_a(2, false, true, Packet2ClientProtocol.class);
      func_73285_a(3, true, true, Packet3Chat.class);
      func_73285_a(4, true, false, Packet4UpdateTime.class);
      func_73285_a(5, true, false, Packet5PlayerInventory.class);
      func_73285_a(6, true, false, Packet6SpawnPosition.class);
      func_73285_a(7, false, true, Packet7UseEntity.class);
      func_73285_a(8, true, false, Packet8UpdateHealth.class);
      func_73285_a(9, true, true, Packet9Respawn.class);
      func_73285_a(10, true, true, Packet10Flying.class);
      func_73285_a(11, true, true, Packet11PlayerPosition.class);
      func_73285_a(12, true, true, Packet12PlayerLook.class);
      func_73285_a(13, true, true, Packet13PlayerLookMove.class);
      func_73285_a(14, false, true, Packet14BlockDig.class);
      func_73285_a(15, false, true, Packet15Place.class);
      func_73285_a(16, true, true, Packet16BlockItemSwitch.class);
      func_73285_a(17, true, false, Packet17Sleep.class);
      func_73285_a(18, true, true, Packet18Animation.class);
      func_73285_a(19, false, true, Packet19EntityAction.class);
      func_73285_a(20, true, false, Packet20NamedEntitySpawn.class);
      func_73285_a(22, true, false, Packet22Collect.class);
      func_73285_a(23, true, false, Packet23VehicleSpawn.class);
      func_73285_a(24, true, false, Packet24MobSpawn.class);
      func_73285_a(25, true, false, Packet25EntityPainting.class);
      func_73285_a(26, true, false, Packet26EntityExpOrb.class);
      func_73285_a(28, true, false, Packet28EntityVelocity.class);
      func_73285_a(29, true, false, Packet29DestroyEntity.class);
      func_73285_a(30, true, false, Packet30Entity.class);
      func_73285_a(31, true, false, Packet31RelEntityMove.class);
      func_73285_a(32, true, false, Packet32EntityLook.class);
      func_73285_a(33, true, false, Packet33RelEntityMoveLook.class);
      func_73285_a(34, true, false, Packet34EntityTeleport.class);
      func_73285_a(35, true, false, Packet35EntityHeadRotation.class);
      func_73285_a(38, true, false, Packet38EntityStatus.class);
      func_73285_a(39, true, false, Packet39AttachEntity.class);
      func_73285_a(40, true, false, Packet40EntityMetadata.class);
      func_73285_a(41, true, false, Packet41EntityEffect.class);
      func_73285_a(42, true, false, Packet42RemoveEntityEffect.class);
      func_73285_a(43, true, false, Packet43Experience.class);
      func_73285_a(51, true, false, Packet51MapChunk.class);
      func_73285_a(52, true, false, Packet52MultiBlockChange.class);
      func_73285_a(53, true, false, Packet53BlockChange.class);
      func_73285_a(54, true, false, Packet54PlayNoteBlock.class);
      func_73285_a(55, true, false, Packet55BlockDestroy.class);
      func_73285_a(56, true, false, Packet56MapChunks.class);
      func_73285_a(60, true, false, Packet60Explosion.class);
      func_73285_a(61, true, false, Packet61DoorChange.class);
      func_73285_a(62, true, false, Packet62LevelSound.class);
      func_73285_a(63, true, false, Packet63WorldParticles.class);
      func_73285_a(70, true, false, Packet70GameEvent.class);
      func_73285_a(71, true, false, Packet71Weather.class);
      func_73285_a(100, true, false, Packet100OpenWindow.class);
      func_73285_a(101, true, true, Packet101CloseWindow.class);
      func_73285_a(102, false, true, Packet102WindowClick.class);
      func_73285_a(103, true, false, Packet103SetSlot.class);
      func_73285_a(104, true, false, Packet104WindowItems.class);
      func_73285_a(105, true, false, Packet105UpdateProgressbar.class);
      func_73285_a(106, true, true, Packet106Transaction.class);
      func_73285_a(107, true, true, Packet107CreativeSetSlot.class);
      func_73285_a(108, false, true, Packet108EnchantItem.class);
      func_73285_a(130, true, true, Packet130UpdateSign.class);
      func_73285_a(131, true, false, Packet131MapData.class);
      func_73285_a(132, true, false, Packet132TileEntityData.class);
      func_73285_a(200, true, false, Packet200Statistic.class);
      func_73285_a(201, true, false, Packet201PlayerInfo.class);
      func_73285_a(202, true, true, Packet202PlayerAbilities.class);
      func_73285_a(203, true, true, Packet203AutoComplete.class);
      func_73285_a(204, false, true, Packet204ClientInfo.class);
      func_73285_a(205, false, true, Packet205ClientCommand.class);
      func_73285_a(206, true, false, Packet206SetObjective.class);
      func_73285_a(207, true, false, Packet207SetScore.class);
      func_73285_a(208, true, false, Packet208SetDisplayObjective.class);
      func_73285_a(209, true, false, Packet209SetPlayerTeam.class);
      func_73285_a(250, true, true, Packet250CustomPayload.class);
      func_73285_a(252, true, true, Packet252SharedKey.class);
      func_73285_a(253, true, false, Packet253ServerAuthData.class);
      func_73285_a(254, false, true, Packet254ServerPing.class);
      func_73285_a(255, true, true, Packet255KickDisconnect.class);
   }
}
