package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerInstance;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

public class PlayerManager {

   private final WorldServer field_72701_a;
   private final List field_72699_b = new ArrayList();
   private final LongHashMap field_72700_c = new LongHashMap();
   private final List field_72697_d = new ArrayList();
   private final int field_72698_e;
   private final int[][] field_72696_f = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


   public PlayerManager(WorldServer p_i3392_1_, int p_i3392_2_) {
      if(p_i3392_2_ > 15) {
         throw new IllegalArgumentException("Too big view radius!");
      } else if(p_i3392_2_ < 3) {
         throw new IllegalArgumentException("Too small view radius!");
      } else {
         this.field_72698_e = p_i3392_2_;
         this.field_72701_a = p_i3392_1_;
      }
   }

   public WorldServer func_72688_a() {
      return this.field_72701_a;
   }

   public void func_72693_b() {
      for(int var1 = 0; var1 < this.field_72697_d.size(); ++var1) {
         ((PlayerInstance)this.field_72697_d.get(var1)).func_73254_a();
      }

      this.field_72697_d.clear();
      if(this.field_72699_b.isEmpty()) {
         WorldProvider var2 = this.field_72701_a.field_73011_w;
         if(!var2.func_76567_e()) {
            this.field_72701_a.field_73059_b.func_73240_a();
         }
      }

   }

   public PlayerInstance func_72690_a(int p_72690_1_, int p_72690_2_, boolean p_72690_3_) {
      long var4 = (long)p_72690_1_ + 2147483647L | (long)p_72690_2_ + 2147483647L << 32;
      PlayerInstance var6 = (PlayerInstance)this.field_72700_c.func_76164_a(var4);
      if(var6 == null && p_72690_3_) {
         var6 = new PlayerInstance(this, p_72690_1_, p_72690_2_);
         this.field_72700_c.func_76163_a(var4, var6);
      }

      return var6;
   }

   public void func_72687_a(int p_72687_1_, int p_72687_2_, int p_72687_3_) {
      int var4 = p_72687_1_ >> 4;
      int var5 = p_72687_3_ >> 4;
      PlayerInstance var6 = this.func_72690_a(var4, var5, false);
      if(var6 != null) {
         var6.func_73259_a(p_72687_1_ & 15, p_72687_2_, p_72687_3_ & 15);
      }

   }

   public void func_72683_a(EntityPlayerMP p_72683_1_) {
      int var2 = (int)p_72683_1_.field_70165_t >> 4;
      int var3 = (int)p_72683_1_.field_70161_v >> 4;
      p_72683_1_.field_71131_d = p_72683_1_.field_70165_t;
      p_72683_1_.field_71132_e = p_72683_1_.field_70161_v;

      for(int var4 = var2 - this.field_72698_e; var4 <= var2 + this.field_72698_e; ++var4) {
         for(int var5 = var3 - this.field_72698_e; var5 <= var3 + this.field_72698_e; ++var5) {
            this.func_72690_a(var4, var5, true).func_73255_a(p_72683_1_);
         }
      }

      this.field_72699_b.add(p_72683_1_);
      this.func_72691_b(p_72683_1_);
   }

   public void func_72691_b(EntityPlayerMP p_72691_1_) {
      ArrayList var2 = new ArrayList(p_72691_1_.field_71129_f);
      int var3 = 0;
      int var4 = this.field_72698_e;
      int var5 = (int)p_72691_1_.field_70165_t >> 4;
      int var6 = (int)p_72691_1_.field_70161_v >> 4;
      int var7 = 0;
      int var8 = 0;
      ChunkCoordIntPair var9 = PlayerInstance.func_73253_a(this.func_72690_a(var5, var6, true));
      p_72691_1_.field_71129_f.clear();
      if(var2.contains(var9)) {
         p_72691_1_.field_71129_f.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.field_72696_f[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = PlayerInstance.func_73253_a(this.func_72690_a(var5 + var7, var6 + var8, true));
               if(var2.contains(var9)) {
                  p_72691_1_.field_71129_f.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.field_72696_f[var3][0];
         var8 += this.field_72696_f[var3][1];
         var9 = PlayerInstance.func_73253_a(this.func_72690_a(var5 + var7, var6 + var8, true));
         if(var2.contains(var9)) {
            p_72691_1_.field_71129_f.add(var9);
         }
      }

   }

   public void func_72695_c(EntityPlayerMP p_72695_1_) {
      int var2 = (int)p_72695_1_.field_71131_d >> 4;
      int var3 = (int)p_72695_1_.field_71132_e >> 4;

      for(int var4 = var2 - this.field_72698_e; var4 <= var2 + this.field_72698_e; ++var4) {
         for(int var5 = var3 - this.field_72698_e; var5 <= var3 + this.field_72698_e; ++var5) {
            PlayerInstance var6 = this.func_72690_a(var4, var5, false);
            if(var6 != null) {
               var6.func_73252_b(p_72695_1_);
            }
         }
      }

      this.field_72699_b.remove(p_72695_1_);
   }

   private boolean func_72684_a(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_) {
      int var6 = p_72684_1_ - p_72684_3_;
      int var7 = p_72684_2_ - p_72684_4_;
      return var6 >= -p_72684_5_ && var6 <= p_72684_5_?var7 >= -p_72684_5_ && var7 <= p_72684_5_:false;
   }

   public void func_72685_d(EntityPlayerMP p_72685_1_) {
      int var2 = (int)p_72685_1_.field_70165_t >> 4;
      int var3 = (int)p_72685_1_.field_70161_v >> 4;
      double var4 = p_72685_1_.field_71131_d - p_72685_1_.field_70165_t;
      double var6 = p_72685_1_.field_71132_e - p_72685_1_.field_70161_v;
      double var8 = var4 * var4 + var6 * var6;
      if(var8 >= 64.0D) {
         int var10 = (int)p_72685_1_.field_71131_d >> 4;
         int var11 = (int)p_72685_1_.field_71132_e >> 4;
         int var12 = this.field_72698_e;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if(var13 != 0 || var14 != 0) {
            for(int var15 = var2 - var12; var15 <= var2 + var12; ++var15) {
               for(int var16 = var3 - var12; var16 <= var3 + var12; ++var16) {
                  if(!this.func_72684_a(var15, var16, var10, var11, var12)) {
                     this.func_72690_a(var15, var16, true).func_73255_a(p_72685_1_);
                  }

                  if(!this.func_72684_a(var15 - var13, var16 - var14, var2, var3, var12)) {
                     PlayerInstance var17 = this.func_72690_a(var15 - var13, var16 - var14, false);
                     if(var17 != null) {
                        var17.func_73252_b(p_72685_1_);
                     }
                  }
               }
            }

            this.func_72691_b(p_72685_1_);
            p_72685_1_.field_71131_d = p_72685_1_.field_70165_t;
            p_72685_1_.field_71132_e = p_72685_1_.field_70161_v;
         }
      }
   }

   public boolean func_72694_a(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_) {
      PlayerInstance var4 = this.func_72690_a(p_72694_2_, p_72694_3_, false);
      return var4 == null?false:PlayerInstance.func_73258_b(var4).contains(p_72694_1_) && !p_72694_1_.field_71129_f.contains(PlayerInstance.func_73253_a(var4));
   }

   public static int func_72686_a(int p_72686_0_) {
      return p_72686_0_ * 16 - 16;
   }

   // $FF: synthetic method
   static WorldServer func_72692_a(PlayerManager p_72692_0_) {
      return p_72692_0_.field_72701_a;
   }

   // $FF: synthetic method
   static LongHashMap func_72689_b(PlayerManager p_72689_0_) {
      return p_72689_0_.field_72700_c;
   }

   // $FF: synthetic method
   static List func_72682_c(PlayerManager p_72682_0_) {
      return p_72682_0_.field_72697_d;
   }
}
