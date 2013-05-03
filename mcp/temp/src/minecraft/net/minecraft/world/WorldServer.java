package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.INpc;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.ServerBlockEvent;
import net.minecraft.world.ServerBlockEventList;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServer extends World {

   private final MinecraftServer field_73061_a;
   private final EntityTracker field_73062_L;
   private final PlayerManager field_73063_M;
   private Set field_73064_N;
   private TreeSet field_73065_O;
   public ChunkProviderServer field_73059_b;
   public boolean field_73058_d;
   public boolean field_73068_P;
   private int field_80004_Q = 0;
   private final Teleporter field_85177_Q;
   private ServerBlockEventList[] field_73067_Q = new ServerBlockEventList[]{new ServerBlockEventList((ServerBlockEvent)null), new ServerBlockEventList((ServerBlockEvent)null)};
   private int field_73070_R = 0;
   public static final WeightedRandomChestContent[] field_73069_S = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77669_D.field_77779_bT, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71988_x.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71951_J.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Item.field_77719_y.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77712_u.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77720_x.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77713_t.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 2, 3, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 2, 3, 3)};
   private ArrayList field_94579_S = new ArrayList();
   private IntHashMap field_73066_T;


   public WorldServer(MinecraftServer p_i11031_1_, ISaveHandler p_i11031_2_, String p_i11031_3_, int p_i11031_4_, WorldSettings p_i11031_5_, Profiler p_i11031_6_, ILogAgent p_i11031_7_) {
      super(p_i11031_2_, p_i11031_3_, p_i11031_5_, WorldProvider.func_76570_a(p_i11031_4_), p_i11031_6_, p_i11031_7_);
      this.field_73061_a = p_i11031_1_;
      this.field_73062_L = new EntityTracker(this);
      this.field_73063_M = new PlayerManager(this, p_i11031_1_.func_71203_ab().func_72395_o());
      if(this.field_73066_T == null) {
         this.field_73066_T = new IntHashMap();
      }

      if(this.field_73064_N == null) {
         this.field_73064_N = new HashSet();
      }

      if(this.field_73065_O == null) {
         this.field_73065_O = new TreeSet();
      }

      this.field_85177_Q = new Teleporter(this);
      this.field_96442_D = new ServerScoreboard(p_i11031_1_);
      ScoreboardSaveData var8 = (ScoreboardSaveData)this.field_72988_C.func_75742_a(ScoreboardSaveData.class, "scoreboard");
      if(var8 == null) {
         var8 = new ScoreboardSaveData();
         this.field_72988_C.func_75745_a("scoreboard", var8);
      }

      var8.func_96499_a(this.field_96442_D);
      ((ServerScoreboard)this.field_96442_D).func_96547_a(var8);
   }

   public void func_72835_b() {
      super.func_72835_b();
      if(this.func_72912_H().func_76093_s() && this.field_73013_u < 3) {
         this.field_73013_u = 3;
      }

      this.field_73011_w.field_76578_c.func_76938_b();
      if(this.func_73056_e()) {
         boolean var1 = false;
         if(this.field_72985_G && this.field_73013_u >= 1) {
            ;
         }

         if(!var1) {
            long var2 = this.field_72986_A.func_76073_f() + 24000L;
            this.field_72986_A.func_76068_b(var2 - var2 % 24000L);
            this.func_73053_d();
         }
      }

      this.field_72984_F.func_76320_a("mobSpawner");
      if(this.func_82736_K().func_82766_b("doMobSpawning")) {
         SpawnerAnimals.func_77192_a(this, this.field_72985_G, this.field_72992_H, this.field_72986_A.func_82573_f() % 400L == 0L);
      }

      this.field_72984_F.func_76318_c("chunkSource");
      this.field_73020_y.func_73156_b();
      int var4 = this.func_72967_a(1.0F);
      if(var4 != this.field_73008_k) {
         this.field_73008_k = var4;
      }

      this.field_72986_A.func_82572_b(this.field_72986_A.func_82573_f() + 1L);
      this.field_72986_A.func_76068_b(this.field_72986_A.func_76073_f() + 1L);
      this.field_72984_F.func_76318_c("tickPending");
      this.func_72955_a(false);
      this.field_72984_F.func_76318_c("tickTiles");
      this.func_72893_g();
      this.field_72984_F.func_76318_c("chunkMap");
      this.field_73063_M.func_72693_b();
      this.field_72984_F.func_76318_c("village");
      this.field_72982_D.func_75544_a();
      this.field_72983_E.func_75528_a();
      this.field_72984_F.func_76318_c("portalForcer");
      this.field_85177_Q.func_85189_a(this.func_82737_E());
      this.field_72984_F.func_76319_b();
      this.func_73055_Q();
   }

   public SpawnListEntry func_73057_a(EnumCreatureType p_73057_1_, int p_73057_2_, int p_73057_3_, int p_73057_4_) {
      List var5 = this.func_72863_F().func_73155_a(p_73057_1_, p_73057_2_, p_73057_3_, p_73057_4_);
      return var5 != null && !var5.isEmpty()?(SpawnListEntry)WeightedRandom.func_76271_a(this.field_73012_v, var5):null;
   }

   public void func_72854_c() {
      this.field_73068_P = !this.field_73010_i.isEmpty();
      Iterator var1 = this.field_73010_i.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         if(!var2.func_70608_bn()) {
            this.field_73068_P = false;
            break;
         }
      }

   }

   protected void func_73053_d() {
      this.field_73068_P = false;
      Iterator var1 = this.field_73010_i.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         if(var2.func_70608_bn()) {
            var2.func_70999_a(false, false, true);
         }
      }

      this.func_73051_P();
   }

   private void func_73051_P() {
      this.field_72986_A.func_76080_g(0);
      this.field_72986_A.func_76084_b(false);
      this.field_72986_A.func_76090_f(0);
      this.field_72986_A.func_76069_a(false);
   }

   public boolean func_73056_e() {
      if(this.field_73068_P && !this.field_72995_K) {
         Iterator var1 = this.field_73010_i.iterator();

         EntityPlayer var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (EntityPlayer)var1.next();
         } while(var2.func_71026_bH());

         return false;
      } else {
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_72974_f() {
      if(this.field_72986_A.func_76075_d() <= 0) {
         this.field_72986_A.func_76056_b(64);
      }

      int var1 = this.field_72986_A.func_76079_c();
      int var2 = this.field_72986_A.func_76074_e();
      int var3 = 0;

      while(this.func_72922_b(var1, var2) == 0) {
         var1 += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
         var2 += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
         ++var3;
         if(var3 == 10000) {
            break;
         }
      }

      this.field_72986_A.func_76058_a(var1);
      this.field_72986_A.func_76087_c(var2);
   }

   protected void func_72893_g() {
      super.func_72893_g();
      int var1 = 0;
      int var2 = 0;
      Iterator var3 = this.field_72993_I.iterator();

      while(var3.hasNext()) {
         ChunkCoordIntPair var4 = (ChunkCoordIntPair)var3.next();
         int var5 = var4.field_77276_a * 16;
         int var6 = var4.field_77275_b * 16;
         this.field_72984_F.func_76320_a("getChunk");
         Chunk var7 = this.func_72964_e(var4.field_77276_a, var4.field_77275_b);
         this.func_72941_a(var5, var6, var7);
         this.field_72984_F.func_76318_c("tickChunk");
         var7.func_76586_k();
         this.field_72984_F.func_76318_c("thunder");
         int var8;
         int var9;
         int var10;
         int var11;
         if(this.field_73012_v.nextInt(100000) == 0 && this.func_72896_J() && this.func_72911_I()) {
            this.field_73005_l = this.field_73005_l * 3 + 1013904223;
            var8 = this.field_73005_l >> 2;
            var9 = var5 + (var8 & 15);
            var10 = var6 + (var8 >> 8 & 15);
            var11 = this.func_72874_g(var9, var10);
            if(this.func_72951_B(var9, var11, var10)) {
               this.func_72942_c(new EntityLightningBolt(this, (double)var9, (double)var11, (double)var10));
            }
         }

         this.field_72984_F.func_76318_c("iceandsnow");
         int var13;
         if(this.field_73012_v.nextInt(16) == 0) {
            this.field_73005_l = this.field_73005_l * 3 + 1013904223;
            var8 = this.field_73005_l >> 2;
            var9 = var8 & 15;
            var10 = var8 >> 8 & 15;
            var11 = this.func_72874_g(var9 + var5, var10 + var6);
            if(this.func_72850_v(var9 + var5, var11 - 1, var10 + var6)) {
               this.func_94575_c(var9 + var5, var11 - 1, var10 + var6, Block.field_72036_aT.field_71990_ca);
            }

            if(this.func_72896_J() && this.func_72858_w(var9 + var5, var11, var10 + var6)) {
               this.func_94575_c(var9 + var5, var11, var10 + var6, Block.field_72037_aS.field_71990_ca);
            }

            if(this.func_72896_J()) {
               BiomeGenBase var12 = this.func_72807_a(var9 + var5, var10 + var6);
               if(var12.func_76738_d()) {
                  var13 = this.func_72798_a(var9 + var5, var11 - 1, var10 + var6);
                  if(var13 != 0) {
                     Block.field_71973_m[var13].func_71892_f(this, var9 + var5, var11 - 1, var10 + var6);
                  }
               }
            }
         }

         this.field_72984_F.func_76318_c("tickTiles");
         ExtendedBlockStorage[] var19 = var7.func_76587_i();
         var9 = var19.length;

         for(var10 = 0; var10 < var9; ++var10) {
            ExtendedBlockStorage var21 = var19[var10];
            if(var21 != null && var21.func_76675_b()) {
               for(int var20 = 0; var20 < 3; ++var20) {
                  this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                  var13 = this.field_73005_l >> 2;
                  int var14 = var13 & 15;
                  int var15 = var13 >> 8 & 15;
                  int var16 = var13 >> 16 & 15;
                  int var17 = var21.func_76656_a(var14, var16, var15);
                  ++var2;
                  Block var18 = Block.field_71973_m[var17];
                  if(var18 != null && var18.func_71881_r()) {
                     ++var1;
                     var18.func_71847_b(this, var14 + var5, var16 + var21.func_76662_d(), var15 + var6, this.field_73012_v);
                  }
               }
            }
         }

         this.field_72984_F.func_76319_b();
      }

   }

   public boolean func_94573_a(int p_94573_1_, int p_94573_2_, int p_94573_3_, int p_94573_4_) {
      NextTickListEntry var5 = new NextTickListEntry(p_94573_1_, p_94573_2_, p_94573_3_, p_94573_4_);
      return this.field_94579_S.contains(var5);
   }

   public void func_72836_a(int p_72836_1_, int p_72836_2_, int p_72836_3_, int p_72836_4_, int p_72836_5_) {
      this.func_82740_a(p_72836_1_, p_72836_2_, p_72836_3_, p_72836_4_, p_72836_5_, 0);
   }

   public void func_82740_a(int p_82740_1_, int p_82740_2_, int p_82740_3_, int p_82740_4_, int p_82740_5_, int p_82740_6_) {
      NextTickListEntry var7 = new NextTickListEntry(p_82740_1_, p_82740_2_, p_82740_3_, p_82740_4_);
      byte var8 = 0;
      if(this.field_72999_e && p_82740_4_ > 0) {
         if(Block.field_71973_m[p_82740_4_].func_82506_l()) {
            if(this.func_72904_c(var7.field_77183_a - var8, var7.field_77181_b - var8, var7.field_77182_c - var8, var7.field_77183_a + var8, var7.field_77181_b + var8, var7.field_77182_c + var8)) {
               int var9 = this.func_72798_a(var7.field_77183_a, var7.field_77181_b, var7.field_77182_c);
               if(var9 == var7.field_77179_d && var9 > 0) {
                  Block.field_71973_m[var9].func_71847_b(this, var7.field_77183_a, var7.field_77181_b, var7.field_77182_c, this.field_73012_v);
               }
            }

            return;
         }

         p_82740_5_ = 1;
      }

      if(this.func_72904_c(p_82740_1_ - var8, p_82740_2_ - var8, p_82740_3_ - var8, p_82740_1_ + var8, p_82740_2_ + var8, p_82740_3_ + var8)) {
         if(p_82740_4_ > 0) {
            var7.func_77176_a((long)p_82740_5_ + this.field_72986_A.func_82573_f());
            var7.func_82753_a(p_82740_6_);
         }

         if(!this.field_73064_N.contains(var7)) {
            this.field_73064_N.add(var7);
            this.field_73065_O.add(var7);
         }
      }

   }

   public void func_72892_b(int p_72892_1_, int p_72892_2_, int p_72892_3_, int p_72892_4_, int p_72892_5_, int p_72892_6_) {
      NextTickListEntry var7 = new NextTickListEntry(p_72892_1_, p_72892_2_, p_72892_3_, p_72892_4_);
      var7.func_82753_a(p_72892_6_);
      if(p_72892_4_ > 0) {
         var7.func_77176_a((long)p_72892_5_ + this.field_72986_A.func_82573_f());
      }

      if(!this.field_73064_N.contains(var7)) {
         this.field_73064_N.add(var7);
         this.field_73065_O.add(var7);
      }

   }

   public void func_72939_s() {
      if(this.field_73010_i.isEmpty()) {
         if(this.field_80004_Q++ >= 1200) {
            return;
         }
      } else {
         this.func_82742_i();
      }

      super.func_72939_s();
   }

   public void func_82742_i() {
      this.field_80004_Q = 0;
   }

   public boolean func_72955_a(boolean p_72955_1_) {
      int var2 = this.field_73065_O.size();
      if(var2 != this.field_73064_N.size()) {
         throw new IllegalStateException("TickNextTick list out of synch");
      } else {
         if(var2 > 1000) {
            var2 = 1000;
         }

         this.field_72984_F.func_76320_a("cleaning");

         NextTickListEntry var4;
         for(int var3 = 0; var3 < var2; ++var3) {
            var4 = (NextTickListEntry)this.field_73065_O.first();
            if(!p_72955_1_ && var4.field_77180_e > this.field_72986_A.func_82573_f()) {
               break;
            }

            this.field_73065_O.remove(var4);
            this.field_73064_N.remove(var4);
            this.field_94579_S.add(var4);
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("ticking");
         Iterator var14 = this.field_94579_S.iterator();

         while(var14.hasNext()) {
            var4 = (NextTickListEntry)var14.next();
            var14.remove();
            byte var5 = 0;
            if(this.func_72904_c(var4.field_77183_a - var5, var4.field_77181_b - var5, var4.field_77182_c - var5, var4.field_77183_a + var5, var4.field_77181_b + var5, var4.field_77182_c + var5)) {
               int var6 = this.func_72798_a(var4.field_77183_a, var4.field_77181_b, var4.field_77182_c);
               if(var6 > 0 && Block.func_94329_b(var6, var4.field_77179_d)) {
                  try {
                     Block.field_71973_m[var6].func_71847_b(this, var4.field_77183_a, var4.field_77181_b, var4.field_77182_c, this.field_73012_v);
                  } catch (Throwable var13) {
                     CrashReport var8 = CrashReport.func_85055_a(var13, "Exception while ticking a block");
                     CrashReportCategory var9 = var8.func_85058_a("Block being ticked");

                     int var10;
                     try {
                        var10 = this.func_72805_g(var4.field_77183_a, var4.field_77181_b, var4.field_77182_c);
                     } catch (Throwable var12) {
                        var10 = -1;
                     }

                     CrashReportCategory.func_85068_a(var9, var4.field_77183_a, var4.field_77181_b, var4.field_77182_c, var6, var10);
                     throw new ReportedException(var8);
                  }
               }
            } else {
               this.func_72836_a(var4.field_77183_a, var4.field_77181_b, var4.field_77182_c, var4.field_77179_d, 0);
            }
         }

         this.field_72984_F.func_76319_b();
         this.field_94579_S.clear();
         return !this.field_73065_O.isEmpty();
      }
   }

   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
      ArrayList var3 = null;
      ChunkCoordIntPair var4 = p_72920_1_.func_76632_l();
      int var5 = (var4.field_77276_a << 4) - 2;
      int var6 = var5 + 16 + 2;
      int var7 = (var4.field_77275_b << 4) - 2;
      int var8 = var7 + 16 + 2;

      for(int var9 = 0; var9 < 2; ++var9) {
         Iterator var10;
         if(var9 == 0) {
            var10 = this.field_73065_O.iterator();
         } else {
            var10 = this.field_94579_S.iterator();
            if(!this.field_94579_S.isEmpty()) {
               System.out.println(this.field_94579_S.size());
            }
         }

         while(var10.hasNext()) {
            NextTickListEntry var11 = (NextTickListEntry)var10.next();
            if(var11.field_77183_a >= var5 && var11.field_77183_a < var6 && var11.field_77182_c >= var7 && var11.field_77182_c < var8) {
               if(p_72920_2_) {
                  this.field_73064_N.remove(var11);
                  var10.remove();
               }

               if(var3 == null) {
                  var3 = new ArrayList();
               }

               var3.add(var11);
            }
         }
      }

      return var3;
   }

   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
      if(!this.field_73061_a.func_71268_U() && (p_72866_1_ instanceof EntityAnimal || p_72866_1_ instanceof EntityWaterMob)) {
         p_72866_1_.func_70106_y();
      }

      if(!this.field_73061_a.func_71220_V() && p_72866_1_ instanceof INpc) {
         p_72866_1_.func_70106_y();
      }

      if(!(p_72866_1_.field_70153_n instanceof EntityPlayer)) {
         super.func_72866_a(p_72866_1_, p_72866_2_);
      }

   }

   public void func_73050_b(Entity p_73050_1_, boolean p_73050_2_) {
      super.func_72866_a(p_73050_1_, p_73050_2_);
   }

   protected IChunkProvider func_72970_h() {
      IChunkLoader var1 = this.field_73019_z.func_75763_a(this.field_73011_w);
      this.field_73059_b = new ChunkProviderServer(this, var1, this.field_73011_w.func_76555_c());
      return this.field_73059_b;
   }

   public List func_73049_a(int p_73049_1_, int p_73049_2_, int p_73049_3_, int p_73049_4_, int p_73049_5_, int p_73049_6_) {
      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < this.field_73009_h.size(); ++var8) {
         TileEntity var9 = (TileEntity)this.field_73009_h.get(var8);
         if(var9.field_70329_l >= p_73049_1_ && var9.field_70330_m >= p_73049_2_ && var9.field_70327_n >= p_73049_3_ && var9.field_70329_l < p_73049_4_ && var9.field_70330_m < p_73049_5_ && var9.field_70327_n < p_73049_6_) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_) {
      return !this.field_73061_a.func_96290_a(this, p_72962_2_, p_72962_3_, p_72962_4_, p_72962_1_);
   }

   protected void func_72963_a(WorldSettings p_72963_1_) {
      if(this.field_73066_T == null) {
         this.field_73066_T = new IntHashMap();
      }

      if(this.field_73064_N == null) {
         this.field_73064_N = new HashSet();
      }

      if(this.field_73065_O == null) {
         this.field_73065_O = new TreeSet();
      }

      this.func_73052_b(p_72963_1_);
      super.func_72963_a(p_72963_1_);
   }

   protected void func_73052_b(WorldSettings p_73052_1_) {
      if(!this.field_73011_w.func_76567_e()) {
         this.field_72986_A.func_76081_a(0, this.field_73011_w.func_76557_i(), 0);
      } else {
         this.field_72987_B = true;
         WorldChunkManager var2 = this.field_73011_w.field_76578_c;
         List var3 = var2.func_76932_a();
         Random var4 = new Random(this.func_72905_C());
         ChunkPosition var5 = var2.func_76941_a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.field_73011_w.func_76557_i();
         int var8 = 0;
         if(var5 != null) {
            var6 = var5.field_76930_a;
            var8 = var5.field_76929_c;
         } else {
            this.func_98180_V().func_98236_b("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.field_73011_w.func_76566_a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if(var9 == 1000) {
               break;
            }
         }

         this.field_72986_A.func_76081_a(var6, var7, var8);
         this.field_72987_B = false;
         if(p_73052_1_.func_77167_c()) {
            this.func_73047_i();
         }

      }
   }

   protected void func_73047_i() {
      WorldGeneratorBonusChest var1 = new WorldGeneratorBonusChest(field_73069_S, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.field_72986_A.func_76079_c() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
         int var4 = this.field_72986_A.func_76074_e() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
         int var5 = this.func_72825_h(var3, var4) + 1;
         if(var1.func_76484_a(this, this.field_73012_v, var3, var5, var4)) {
            break;
         }
      }

   }

   public ChunkCoordinates func_73054_j() {
      return this.field_73011_w.func_76554_h();
   }

   public void func_73044_a(boolean p_73044_1_, IProgressUpdate p_73044_2_) throws MinecraftException {
      if(this.field_73020_y.func_73157_c()) {
         if(p_73044_2_ != null) {
            p_73044_2_.func_73720_a("Saving level");
         }

         this.func_73042_a();
         if(p_73044_2_ != null) {
            p_73044_2_.func_73719_c("Saving chunks");
         }

         this.field_73020_y.func_73151_a(p_73044_1_, p_73044_2_);
      }
   }

   protected void func_73042_a() throws MinecraftException {
      this.func_72906_B();
      this.field_73019_z.func_75755_a(this.field_72986_A, this.field_73061_a.func_71203_ab().func_72378_q());
      this.field_72988_C.func_75744_a();
   }

   protected void func_72923_a(Entity p_72923_1_) {
      super.func_72923_a(p_72923_1_);
      this.field_73066_T.func_76038_a(p_72923_1_.field_70157_k, p_72923_1_);
      Entity[] var2 = p_72923_1_.func_70021_al();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.field_73066_T.func_76038_a(var2[var3].field_70157_k, var2[var3]);
         }
      }

   }

   public void func_72847_b(Entity p_72847_1_) {
      super.func_72847_b(p_72847_1_);
      this.field_73066_T.func_76049_d(p_72847_1_.field_70157_k);
      Entity[] var2 = p_72847_1_.func_70021_al();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.field_73066_T.func_76049_d(var2[var3].field_70157_k);
         }
      }

   }

   public Entity func_73045_a(int p_73045_1_) {
      return (Entity)this.field_73066_T.func_76041_a(p_73045_1_);
   }

   public boolean func_72942_c(Entity p_72942_1_) {
      if(super.func_72942_c(p_72942_1_)) {
         this.field_73061_a.func_71203_ab().func_72393_a(p_72942_1_.field_70165_t, p_72942_1_.field_70163_u, p_72942_1_.field_70161_v, 512.0D, this.field_73011_w.field_76574_g, new Packet71Weather(p_72942_1_));
         return true;
      } else {
         return false;
      }
   }

   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {
      Packet38EntityStatus var3 = new Packet38EntityStatus(p_72960_1_.field_70157_k, p_72960_2_);
      this.func_73039_n().func_72789_b(p_72960_1_, var3);
   }

   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
      Explosion var11 = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
      var11.field_77286_a = p_72885_9_;
      var11.field_82755_b = p_72885_10_;
      var11.func_77278_a();
      var11.func_77279_a(false);
      if(!p_72885_10_) {
         var11.field_77281_g.clear();
      }

      Iterator var12 = this.field_73010_i.iterator();

      while(var12.hasNext()) {
         EntityPlayer var13 = (EntityPlayer)var12.next();
         if(var13.func_70092_e(p_72885_2_, p_72885_4_, p_72885_6_) < 4096.0D) {
            ((EntityPlayerMP)var13).field_71135_a.func_72567_b(new Packet60Explosion(p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, var11.field_77281_g, (Vec3)var11.func_77277_b().get(var13)));
         }
      }

      return var11;
   }

   public void func_72965_b(int p_72965_1_, int p_72965_2_, int p_72965_3_, int p_72965_4_, int p_72965_5_, int p_72965_6_) {
      BlockEventData var7 = new BlockEventData(p_72965_1_, p_72965_2_, p_72965_3_, p_72965_4_, p_72965_5_, p_72965_6_);
      Iterator var8 = this.field_73067_Q[this.field_73070_R].iterator();

      BlockEventData var9;
      do {
         if(!var8.hasNext()) {
            this.field_73067_Q[this.field_73070_R].add(var7);
            return;
         }

         var9 = (BlockEventData)var8.next();
      } while(!var9.equals(var7));

   }

   private void func_73055_Q() {
      while(!this.field_73067_Q[this.field_73070_R].isEmpty()) {
         int var1 = this.field_73070_R;
         this.field_73070_R ^= 1;
         Iterator var2 = this.field_73067_Q[var1].iterator();

         while(var2.hasNext()) {
            BlockEventData var3 = (BlockEventData)var2.next();
            if(this.func_73043_a(var3)) {
               this.field_73061_a.func_71203_ab().func_72393_a((double)var3.func_76919_a(), (double)var3.func_76921_b(), (double)var3.func_76920_c(), 64.0D, this.field_73011_w.field_76574_g, new Packet54PlayNoteBlock(var3.func_76919_a(), var3.func_76921_b(), var3.func_76920_c(), var3.func_76916_f(), var3.func_76918_d(), var3.func_76917_e()));
            }
         }

         this.field_73067_Q[var1].clear();
      }

   }

   private boolean func_73043_a(BlockEventData p_73043_1_) {
      int var2 = this.func_72798_a(p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c());
      return var2 == p_73043_1_.func_76916_f()?Block.field_71973_m[var2].func_71883_b(this, p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c(), p_73043_1_.func_76918_d(), p_73043_1_.func_76917_e()):false;
   }

   public void func_73041_k() {
      this.field_73019_z.func_75759_a();
   }

   protected void func_72979_l() {
      boolean var1 = this.func_72896_J();
      super.func_72979_l();
      if(var1 != this.func_72896_J()) {
         if(var1) {
            this.field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(2, 0));
         } else {
            this.field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(1, 0));
         }
      }

   }

   public MinecraftServer func_73046_m() {
      return this.field_73061_a;
   }

   public EntityTracker func_73039_n() {
      return this.field_73062_L;
   }

   public PlayerManager func_73040_p() {
      return this.field_73063_M;
   }

   public Teleporter func_85176_s() {
      return this.field_85177_Q;
   }

}
