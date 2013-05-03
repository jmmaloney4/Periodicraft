package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.WatchableObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.ReportedException;

public class DataWatcher {

   private boolean field_92086_a = true;
   private static final HashMap field_75697_a = new HashMap();
   private final Map field_75695_b = new HashMap();
   private boolean field_75696_c;
   private ReadWriteLock field_75694_d = new ReentrantReadWriteLock();


   public void func_75682_a(int p_75682_1_, Object p_75682_2_) {
      Integer var3 = (Integer)field_75697_a.get(p_75682_2_.getClass());
      if(var3 == null) {
         throw new IllegalArgumentException("Unknown data type: " + p_75682_2_.getClass());
      } else if(p_75682_1_ > 31) {
         throw new IllegalArgumentException("Data value id is too big with " + p_75682_1_ + "! (Max is " + 31 + ")");
      } else if(this.field_75695_b.containsKey(Integer.valueOf(p_75682_1_))) {
         throw new IllegalArgumentException("Duplicate id value for " + p_75682_1_ + "!");
      } else {
         WatchableObject var4 = new WatchableObject(var3.intValue(), p_75682_1_, p_75682_2_);
         this.field_75694_d.writeLock().lock();
         this.field_75695_b.put(Integer.valueOf(p_75682_1_), var4);
         this.field_75694_d.writeLock().unlock();
         this.field_92086_a = false;
      }
   }

   public void func_82709_a(int p_82709_1_, int p_82709_2_) {
      WatchableObject var3 = new WatchableObject(p_82709_2_, p_82709_1_, (Object)null);
      this.field_75694_d.writeLock().lock();
      this.field_75695_b.put(Integer.valueOf(p_82709_1_), var3);
      this.field_75694_d.writeLock().unlock();
      this.field_92086_a = false;
   }

   public byte func_75683_a(int p_75683_1_) {
      return ((Byte)this.func_75691_i(p_75683_1_).func_75669_b()).byteValue();
   }

   public short func_75693_b(int p_75693_1_) {
      return ((Short)this.func_75691_i(p_75693_1_).func_75669_b()).shortValue();
   }

   public int func_75679_c(int p_75679_1_) {
      return ((Integer)this.func_75691_i(p_75679_1_).func_75669_b()).intValue();
   }

   public String func_75681_e(int p_75681_1_) {
      return (String)this.func_75691_i(p_75681_1_).func_75669_b();
   }

   public ItemStack func_82710_f(int p_82710_1_) {
      return (ItemStack)this.func_75691_i(p_82710_1_).func_75669_b();
   }

   private WatchableObject func_75691_i(int p_75691_1_) {
      this.field_75694_d.readLock().lock();

      WatchableObject var2;
      try {
         var2 = (WatchableObject)this.field_75695_b.get(Integer.valueOf(p_75691_1_));
      } catch (Throwable var6) {
         CrashReport var4 = CrashReport.func_85055_a(var6, "Getting synched entity data");
         CrashReportCategory var5 = var4.func_85058_a("Synched entity data");
         var5.func_71507_a("Data ID", Integer.valueOf(p_75691_1_));
         throw new ReportedException(var4);
      }

      this.field_75694_d.readLock().unlock();
      return var2;
   }

   public void func_75692_b(int p_75692_1_, Object p_75692_2_) {
      WatchableObject var3 = this.func_75691_i(p_75692_1_);
      if(!p_75692_2_.equals(var3.func_75669_b())) {
         var3.func_75673_a(p_75692_2_);
         var3.func_75671_a(true);
         this.field_75696_c = true;
      }

   }

   public void func_82708_h(int p_82708_1_) {
      WatchableObject.func_82711_a(this.func_75691_i(p_82708_1_), true);
      this.field_75696_c = true;
   }

   public boolean func_75684_a() {
      return this.field_75696_c;
   }

   public static void func_75680_a(List p_75680_0_, DataOutputStream p_75680_1_) throws IOException {
      if(p_75680_0_ != null) {
         Iterator var2 = p_75680_0_.iterator();

         while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            func_75690_a(p_75680_1_, var3);
         }
      }

      p_75680_1_.writeByte(127);
   }

   public List func_75688_b() {
      ArrayList var1 = null;
      if(this.field_75696_c) {
         this.field_75694_d.readLock().lock();
         Iterator var2 = this.field_75695_b.values().iterator();

         while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            if(var3.func_75670_d()) {
               var3.func_75671_a(false);
               if(var1 == null) {
                  var1 = new ArrayList();
               }

               var1.add(var3);
            }
         }

         this.field_75694_d.readLock().unlock();
      }

      this.field_75696_c = false;
      return var1;
   }

   public void func_75689_a(DataOutputStream p_75689_1_) throws IOException {
      this.field_75694_d.readLock().lock();
      Iterator var2 = this.field_75695_b.values().iterator();

      while(var2.hasNext()) {
         WatchableObject var3 = (WatchableObject)var2.next();
         func_75690_a(p_75689_1_, var3);
      }

      this.field_75694_d.readLock().unlock();
      p_75689_1_.writeByte(127);
   }

   public List func_75685_c() {
      ArrayList var1 = null;
      this.field_75694_d.readLock().lock();

      WatchableObject var3;
      for(Iterator var2 = this.field_75695_b.values().iterator(); var2.hasNext(); var1.add(var3)) {
         var3 = (WatchableObject)var2.next();
         if(var1 == null) {
            var1 = new ArrayList();
         }
      }

      this.field_75694_d.readLock().unlock();
      return var1;
   }

   private static void func_75690_a(DataOutputStream p_75690_0_, WatchableObject p_75690_1_) throws IOException {
      int var2 = (p_75690_1_.func_75674_c() << 5 | p_75690_1_.func_75672_a() & 31) & 255;
      p_75690_0_.writeByte(var2);
      switch(p_75690_1_.func_75674_c()) {
      case 0:
         p_75690_0_.writeByte(((Byte)p_75690_1_.func_75669_b()).byteValue());
         break;
      case 1:
         p_75690_0_.writeShort(((Short)p_75690_1_.func_75669_b()).shortValue());
         break;
      case 2:
         p_75690_0_.writeInt(((Integer)p_75690_1_.func_75669_b()).intValue());
         break;
      case 3:
         p_75690_0_.writeFloat(((Float)p_75690_1_.func_75669_b()).floatValue());
         break;
      case 4:
         Packet.func_73271_a((String)p_75690_1_.func_75669_b(), p_75690_0_);
         break;
      case 5:
         ItemStack var4 = (ItemStack)p_75690_1_.func_75669_b();
         Packet.func_73270_a(var4, p_75690_0_);
         break;
      case 6:
         ChunkCoordinates var3 = (ChunkCoordinates)p_75690_1_.func_75669_b();
         p_75690_0_.writeInt(var3.field_71574_a);
         p_75690_0_.writeInt(var3.field_71572_b);
         p_75690_0_.writeInt(var3.field_71573_c);
      }

   }

   public static List func_75686_a(DataInputStream p_75686_0_) throws IOException {
      ArrayList var1 = null;

      for(byte var2 = p_75686_0_.readByte(); var2 != 127; var2 = p_75686_0_.readByte()) {
         if(var1 == null) {
            var1 = new ArrayList();
         }

         int var3 = (var2 & 224) >> 5;
         int var4 = var2 & 31;
         WatchableObject var5 = null;
         switch(var3) {
         case 0:
            var5 = new WatchableObject(var3, var4, Byte.valueOf(p_75686_0_.readByte()));
            break;
         case 1:
            var5 = new WatchableObject(var3, var4, Short.valueOf(p_75686_0_.readShort()));
            break;
         case 2:
            var5 = new WatchableObject(var3, var4, Integer.valueOf(p_75686_0_.readInt()));
            break;
         case 3:
            var5 = new WatchableObject(var3, var4, Float.valueOf(p_75686_0_.readFloat()));
            break;
         case 4:
            var5 = new WatchableObject(var3, var4, Packet.func_73282_a(p_75686_0_, 64));
            break;
         case 5:
            var5 = new WatchableObject(var3, var4, Packet.func_73276_c(p_75686_0_));
            break;
         case 6:
            int var6 = p_75686_0_.readInt();
            int var7 = p_75686_0_.readInt();
            int var8 = p_75686_0_.readInt();
            var5 = new WatchableObject(var3, var4, new ChunkCoordinates(var6, var7, var8));
         }

         var1.add(var5);
      }

      return var1;
   }

   @SideOnly(Side.CLIENT)
   public void func_75687_a(List p_75687_1_) {
      this.field_75694_d.writeLock().lock();
      Iterator var2 = p_75687_1_.iterator();

      while(var2.hasNext()) {
         WatchableObject var3 = (WatchableObject)var2.next();
         WatchableObject var4 = (WatchableObject)this.field_75695_b.get(Integer.valueOf(var3.func_75672_a()));
         if(var4 != null) {
            var4.func_75673_a(var3.func_75669_b());
         }
      }

      this.field_75694_d.writeLock().unlock();
   }

   public boolean func_92085_d() {
      return this.field_92086_a;
   }

   static {
      field_75697_a.put(Byte.class, Integer.valueOf(0));
      field_75697_a.put(Short.class, Integer.valueOf(1));
      field_75697_a.put(Integer.class, Integer.valueOf(2));
      field_75697_a.put(Float.class, Integer.valueOf(3));
      field_75697_a.put(String.class, Integer.valueOf(4));
      field_75697_a.put(ItemStack.class, Integer.valueOf(5));
      field_75697_a.put(ChunkCoordinates.class, Integer.valueOf(6));
   }
}
