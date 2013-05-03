package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.CallableMPL1;
import net.minecraft.client.multiplayer.CallableMPL2;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.particle.EntityFireworkStarterFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.SoundUpdaterMinecart;
import net.minecraft.logging.ILogAgent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.IntHashMap;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.SaveHandlerMP;

@SideOnly(Side.CLIENT)
public class WorldClient extends World {

   private NetClientHandler field_73035_a;
   private ChunkProviderClient field_73033_b;
   private IntHashMap field_73034_c = new IntHashMap();
   private Set field_73032_d = new HashSet();
   private Set field_73036_L = new HashSet();
   private final Minecraft field_73037_M = Minecraft.func_71410_x();
   private final Set field_73038_N = new HashSet();


   public WorldClient(NetClientHandler p_i11015_1_, WorldSettings p_i11015_2_, int p_i11015_3_, int p_i11015_4_, Profiler p_i11015_5_, ILogAgent p_i11015_6_) {
      super(new SaveHandlerMP(), "MpServer", WorldProvider.func_76570_a(p_i11015_3_), p_i11015_2_, p_i11015_5_, p_i11015_6_);
      this.field_73035_a = p_i11015_1_;
      this.field_73013_u = p_i11015_4_;
      this.func_72950_A(8, 64, 8);
      this.field_72988_C = p_i11015_1_.field_72558_b;
   }

   public void func_72835_b() {
      super.func_72835_b();
      this.func_82738_a(this.func_82737_E() + 1L);
      this.func_72877_b(this.func_72820_D() + 1L);
      this.field_72984_F.func_76320_a("reEntryProcessing");

      for(int var1 = 0; var1 < 10 && !this.field_73036_L.isEmpty(); ++var1) {
         Entity var2 = (Entity)this.field_73036_L.iterator().next();
         this.field_73036_L.remove(var2);
         if(!this.field_72996_f.contains(var2)) {
            this.func_72838_d(var2);
         }
      }

      this.field_72984_F.func_76318_c("connection");
      this.field_73035_a.func_72551_d();
      this.field_72984_F.func_76318_c("chunkCache");
      this.field_73033_b.func_73156_b();
      this.field_72984_F.func_76318_c("tiles");
      this.func_72893_g();
      this.field_72984_F.func_76319_b();
   }

   public void func_73031_a(int p_73031_1_, int p_73031_2_, int p_73031_3_, int p_73031_4_, int p_73031_5_, int p_73031_6_) {}

   protected IChunkProvider func_72970_h() {
      this.field_73033_b = new ChunkProviderClient(this);
      return this.field_73033_b;
   }

   protected void func_72893_g() {
      super.func_72893_g();
      this.field_73038_N.retainAll(this.field_72993_I);
      if(this.field_73038_N.size() == this.field_72993_I.size()) {
         this.field_73038_N.clear();
      }

      int var1 = 0;
      Iterator var2 = this.field_72993_I.iterator();

      while(var2.hasNext()) {
         ChunkCoordIntPair var3 = (ChunkCoordIntPair)var2.next();
         if(!this.field_73038_N.contains(var3)) {
            int var4 = var3.field_77276_a * 16;
            int var5 = var3.field_77275_b * 16;
            this.field_72984_F.func_76320_a("getChunk");
            Chunk var6 = this.func_72964_e(var3.field_77276_a, var3.field_77275_b);
            this.func_72941_a(var4, var5, var6);
            this.field_72984_F.func_76319_b();
            this.field_73038_N.add(var3);
            ++var1;
            if(var1 >= 10) {
               return;
            }
         }
      }

   }

   public void func_73025_a(int p_73025_1_, int p_73025_2_, boolean p_73025_3_) {
      if(p_73025_3_) {
         this.field_73033_b.func_73158_c(p_73025_1_, p_73025_2_);
      } else {
         this.field_73033_b.func_73234_b(p_73025_1_, p_73025_2_);
      }

      if(!p_73025_3_) {
         this.func_72909_d(p_73025_1_ * 16, 0, p_73025_2_ * 16, p_73025_1_ * 16 + 15, 256, p_73025_2_ * 16 + 15);
      }

   }

   public boolean func_72838_d(Entity p_72838_1_) {
      boolean var2 = super.func_72838_d(p_72838_1_);
      this.field_73032_d.add(p_72838_1_);
      if(!var2) {
         this.field_73036_L.add(p_72838_1_);
      }

      return var2;
   }

   public void func_72900_e(Entity p_72900_1_) {
      super.func_72900_e(p_72900_1_);
      this.field_73032_d.remove(p_72900_1_);
   }

   protected void func_72923_a(Entity p_72923_1_) {
      super.func_72923_a(p_72923_1_);
      if(this.field_73036_L.contains(p_72923_1_)) {
         this.field_73036_L.remove(p_72923_1_);
      }

   }

   public void func_72847_b(Entity p_72847_1_) {
      super.func_72847_b(p_72847_1_);
      if(this.field_73032_d.contains(p_72847_1_)) {
         if(p_72847_1_.func_70089_S()) {
            this.field_73036_L.add(p_72847_1_);
         } else {
            this.field_73032_d.remove(p_72847_1_);
         }
      }

   }

   public void func_73027_a(int p_73027_1_, Entity p_73027_2_) {
      Entity var3 = this.func_73045_a(p_73027_1_);
      if(var3 != null) {
         this.func_72900_e(var3);
      }

      this.field_73032_d.add(p_73027_2_);
      p_73027_2_.field_70157_k = p_73027_1_;
      if(!this.func_72838_d(p_73027_2_)) {
         this.field_73036_L.add(p_73027_2_);
      }

      this.field_73034_c.func_76038_a(p_73027_1_, p_73027_2_);
   }

   public Entity func_73045_a(int p_73045_1_) {
      return (Entity)(p_73045_1_ == this.field_73037_M.field_71439_g.field_70157_k?this.field_73037_M.field_71439_g:(Entity)this.field_73034_c.func_76041_a(p_73045_1_));
   }

   public Entity func_73028_b(int p_73028_1_) {
      Entity var2 = (Entity)this.field_73034_c.func_76049_d(p_73028_1_);
      if(var2 != null) {
         this.field_73032_d.remove(var2);
         this.func_72900_e(var2);
      }

      return var2;
   }

   public boolean func_73023_g(int p_73023_1_, int p_73023_2_, int p_73023_3_, int p_73023_4_, int p_73023_5_) {
      this.func_73031_a(p_73023_1_, p_73023_2_, p_73023_3_, p_73023_1_, p_73023_2_, p_73023_3_);
      return super.func_72832_d(p_73023_1_, p_73023_2_, p_73023_3_, p_73023_4_, p_73023_5_, 3);
   }

   public void func_72882_A() {
      this.field_73035_a.func_72546_b(new Packet255KickDisconnect("Quitting"));
   }

   public IUpdatePlayerListBox func_82735_a(EntityMinecart p_82735_1_) {
      return new SoundUpdaterMinecart(this.field_73037_M.field_71416_A, p_82735_1_, this.field_73037_M.field_71439_g);
   }

   protected void func_72979_l() {
      if(!this.field_73011_w.field_76576_e) {
         this.field_73003_n = this.field_73004_o;
         if(this.field_72986_A.func_76059_o()) {
            this.field_73004_o = (float)((double)this.field_73004_o + 0.01D);
         } else {
            this.field_73004_o = (float)((double)this.field_73004_o - 0.01D);
         }

         if(this.field_73004_o < 0.0F) {
            this.field_73004_o = 0.0F;
         }

         if(this.field_73004_o > 1.0F) {
            this.field_73004_o = 1.0F;
         }

         this.field_73018_p = this.field_73017_q;
         if(this.field_72986_A.func_76061_m()) {
            this.field_73017_q = (float)((double)this.field_73017_q + 0.01D);
         } else {
            this.field_73017_q = (float)((double)this.field_73017_q - 0.01D);
         }

         if(this.field_73017_q < 0.0F) {
            this.field_73017_q = 0.0F;
         }

         if(this.field_73017_q > 1.0F) {
            this.field_73017_q = 1.0F;
         }

      }
   }

   public void func_73029_E(int p_73029_1_, int p_73029_2_, int p_73029_3_) {
      byte var4 = 16;
      Random var5 = new Random();

      for(int var6 = 0; var6 < 1000; ++var6) {
         int var7 = p_73029_1_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         int var8 = p_73029_2_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         int var9 = p_73029_3_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         int var10 = this.func_72798_a(var7, var8, var9);
         if(var10 == 0 && this.field_73012_v.nextInt(8) > var8 && this.field_73011_w.func_76564_j()) {
            this.func_72869_a("depthsuspend", (double)((float)var7 + this.field_73012_v.nextFloat()), (double)((float)var8 + this.field_73012_v.nextFloat()), (double)((float)var9 + this.field_73012_v.nextFloat()), 0.0D, 0.0D, 0.0D);
         } else if(var10 > 0) {
            Block.field_71973_m[var10].func_71862_a(this, var7, var8, var9, var5);
         }
      }

   }

   public void func_73022_a() {
      this.field_72996_f.removeAll(this.field_72997_g);

      int var1;
      Entity var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         var2 = (Entity)this.field_72997_g.get(var1);
         var3 = var2.field_70176_ah;
         var4 = var2.field_70164_aj;
         if(var2.field_70175_ag && this.func_72916_c(var3, var4)) {
            this.func_72964_e(var3, var4).func_76622_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         this.func_72847_b((Entity)this.field_72997_g.get(var1));
      }

      this.field_72997_g.clear();

      for(var1 = 0; var1 < this.field_72996_f.size(); ++var1) {
         var2 = (Entity)this.field_72996_f.get(var1);
         if(var2.field_70154_o != null) {
            if(!var2.field_70154_o.field_70128_L && var2.field_70154_o.field_70153_n == var2) {
               continue;
            }

            var2.field_70154_o.field_70153_n = null;
            var2.field_70154_o = null;
         }

         if(var2.field_70128_L) {
            var3 = var2.field_70176_ah;
            var4 = var2.field_70164_aj;
            if(var2.field_70175_ag && this.func_72916_c(var3, var4)) {
               this.func_72964_e(var3, var4).func_76622_b(var2);
            }

            this.field_72996_f.remove(var1--);
            this.func_72847_b(var2);
         }
      }

   }

   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
      CrashReportCategory var2 = super.func_72914_a(p_72914_1_);
      var2.func_71500_a("Forced entities", new CallableMPL1(this));
      var2.func_71500_a("Retry entities", new CallableMPL2(this));
      return var2;
   }

   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {
      float var11 = 16.0F;
      if(p_72980_8_ > 1.0F) {
         var11 *= p_72980_8_;
      }

      double var12 = this.field_73037_M.field_71451_h.func_70092_e(p_72980_1_, p_72980_3_, p_72980_5_);
      if(var12 < (double)(var11 * var11)) {
         if(p_72980_10_ && var12 > 100.0D) {
            double var14 = Math.sqrt(var12) / 40.0D;
            this.field_73037_M.field_71416_A.func_92070_a(p_72980_7_, (float)p_72980_1_, (float)p_72980_3_, (float)p_72980_5_, p_72980_8_, p_72980_9_, (int)Math.round(var14 * 20.0D));
         } else {
            this.field_73037_M.field_71416_A.func_77364_b(p_72980_7_, (float)p_72980_1_, (float)p_72980_3_, (float)p_72980_5_, p_72980_8_, p_72980_9_);
         }
      }

   }

   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {
      this.field_73037_M.field_71452_i.func_78873_a(new EntityFireworkStarterFX(this, p_92088_1_, p_92088_3_, p_92088_5_, p_92088_7_, p_92088_9_, p_92088_11_, this.field_73037_M.field_71452_i, p_92088_13_));
   }

   public void func_96443_a(Scoreboard p_96443_1_) {
      this.field_96442_D = p_96443_1_;
   }

   // $FF: synthetic method
   static Set func_73026_a(WorldClient p_73026_0_) {
      return p_73026_0_.field_73032_d;
   }

   // $FF: synthetic method
   static Set func_73030_b(WorldClient p_73030_0_) {
      return p_73030_0_.field_73036_L;
   }
}
