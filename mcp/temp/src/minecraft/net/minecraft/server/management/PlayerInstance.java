package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet51MapChunk;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;

public class PlayerInstance {

   private final List field_73263_b;
   private final ChunkCoordIntPair field_73264_c;
   private short[] field_73261_d;
   private int field_73262_e;
   private int field_73260_f;
   // $FF: synthetic field
   final PlayerManager field_73265_a;


   public PlayerInstance(PlayerManager p_i3391_1_, int p_i3391_2_, int p_i3391_3_) {
      this.field_73265_a = p_i3391_1_;
      this.field_73263_b = new ArrayList();
      this.field_73261_d = new short[64];
      this.field_73262_e = 0;
      this.field_73264_c = new ChunkCoordIntPair(p_i3391_2_, p_i3391_3_);
      p_i3391_1_.func_72688_a().field_73059_b.func_73158_c(p_i3391_2_, p_i3391_3_);
   }

   public void func_73255_a(EntityPlayerMP p_73255_1_) {
      if(this.field_73263_b.contains(p_73255_1_)) {
         throw new IllegalStateException("Failed to add player. " + p_73255_1_ + " already is in chunk " + this.field_73264_c.field_77276_a + ", " + this.field_73264_c.field_77275_b);
      } else {
         this.field_73263_b.add(p_73255_1_);
         p_73255_1_.field_71129_f.add(this.field_73264_c);
      }
   }

   public void func_73252_b(EntityPlayerMP p_73252_1_) {
      if(this.field_73263_b.contains(p_73252_1_)) {
         p_73252_1_.field_71135_a.func_72567_b(new Packet51MapChunk(PlayerManager.func_72692_a(this.field_73265_a).func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b), true, 0));
         this.field_73263_b.remove(p_73252_1_);
         p_73252_1_.field_71129_f.remove(this.field_73264_c);
         if(this.field_73263_b.isEmpty()) {
            long var2 = (long)this.field_73264_c.field_77276_a + 2147483647L | (long)this.field_73264_c.field_77275_b + 2147483647L << 32;
            PlayerManager.func_72689_b(this.field_73265_a).func_76159_d(var2);
            if(this.field_73262_e > 0) {
               PlayerManager.func_72682_c(this.field_73265_a).remove(this);
            }

            this.field_73265_a.func_72688_a().field_73059_b.func_73241_b(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b);
         }

      }
   }

   public void func_73259_a(int p_73259_1_, int p_73259_2_, int p_73259_3_) {
      if(this.field_73262_e == 0) {
         PlayerManager.func_72682_c(this.field_73265_a).add(this);
      }

      this.field_73260_f |= 1 << (p_73259_2_ >> 4);
      if(this.field_73262_e < 64) {
         short var4 = (short)(p_73259_1_ << 12 | p_73259_3_ << 8 | p_73259_2_);

         for(int var5 = 0; var5 < this.field_73262_e; ++var5) {
            if(this.field_73261_d[var5] == var4) {
               return;
            }
         }

         this.field_73261_d[this.field_73262_e++] = var4;
      }

   }

   public void func_73256_a(Packet p_73256_1_) {
      for(int var2 = 0; var2 < this.field_73263_b.size(); ++var2) {
         EntityPlayerMP var3 = (EntityPlayerMP)this.field_73263_b.get(var2);
         if(!var3.field_71129_f.contains(this.field_73264_c)) {
            var3.field_71135_a.func_72567_b(p_73256_1_);
         }
      }

   }

   public void func_73254_a() {
      if(this.field_73262_e != 0) {
         int var1;
         int var2;
         int var3;
         if(this.field_73262_e == 1) {
            var1 = this.field_73264_c.field_77276_a * 16 + (this.field_73261_d[0] >> 12 & 15);
            var2 = this.field_73261_d[0] & 255;
            var3 = this.field_73264_c.field_77275_b * 16 + (this.field_73261_d[0] >> 8 & 15);
            this.func_73256_a(new Packet53BlockChange(var1, var2, var3, PlayerManager.func_72692_a(this.field_73265_a)));
            if(PlayerManager.func_72692_a(this.field_73265_a).func_72927_d(var1, var2, var3)) {
               this.func_73257_a(PlayerManager.func_72692_a(this.field_73265_a).func_72796_p(var1, var2, var3));
            }
         } else {
            int var4;
            if(this.field_73262_e == 64) {
               var1 = this.field_73264_c.field_77276_a * 16;
               var2 = this.field_73264_c.field_77275_b * 16;
               this.func_73256_a(new Packet51MapChunk(PlayerManager.func_72692_a(this.field_73265_a).func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b), false, this.field_73260_f));

               for(var3 = 0; var3 < 16; ++var3) {
                  if((this.field_73260_f & 1 << var3) != 0) {
                     var4 = var3 << 4;
                     List var5 = PlayerManager.func_72692_a(this.field_73265_a).func_73049_a(var1, var4, var2, var1 + 16, var4 + 16, var2 + 16);

                     for(int var6 = 0; var6 < var5.size(); ++var6) {
                        this.func_73257_a((TileEntity)var5.get(var6));
                     }
                  }
               }
            } else {
               this.func_73256_a(new Packet52MultiBlockChange(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b, this.field_73261_d, this.field_73262_e, PlayerManager.func_72692_a(this.field_73265_a)));

               for(var1 = 0; var1 < this.field_73262_e; ++var1) {
                  var2 = this.field_73264_c.field_77276_a * 16 + (this.field_73261_d[var1] >> 12 & 15);
                  var3 = this.field_73261_d[var1] & 255;
                  var4 = this.field_73264_c.field_77275_b * 16 + (this.field_73261_d[var1] >> 8 & 15);
                  if(PlayerManager.func_72692_a(this.field_73265_a).func_72927_d(var2, var3, var4)) {
                     this.func_73257_a(PlayerManager.func_72692_a(this.field_73265_a).func_72796_p(var2, var3, var4));
                  }
               }
            }
         }

         this.field_73262_e = 0;
         this.field_73260_f = 0;
      }
   }

   private void func_73257_a(TileEntity p_73257_1_) {
      if(p_73257_1_ != null) {
         Packet var2 = p_73257_1_.func_70319_e();
         if(var2 != null) {
            this.func_73256_a(var2);
         }
      }

   }

   // $FF: synthetic method
   static ChunkCoordIntPair func_73253_a(PlayerInstance p_73253_0_) {
      return p_73253_0_.field_73264_c;
   }

   // $FF: synthetic method
   static List func_73258_b(PlayerInstance p_73258_0_) {
      return p_73258_0_.field_73263_b;
   }
}
