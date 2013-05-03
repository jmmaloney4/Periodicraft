package net.minecraft.world.gen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;

public class ChunkProviderServer implements IChunkProvider {

   private Set field_73248_b = new HashSet();
   private Chunk field_73249_c;
   private IChunkProvider field_73246_d;
   public IChunkLoader field_73247_e;
   public boolean field_73250_a = true;
   private LongHashMap field_73244_f = new LongHashMap();
   private List field_73245_g = new ArrayList();
   private WorldServer field_73251_h;


   public ChunkProviderServer(WorldServer p_i3393_1_, IChunkLoader p_i3393_2_, IChunkProvider p_i3393_3_) {
      this.field_73249_c = new EmptyChunk(p_i3393_1_, 0, 0);
      this.field_73251_h = p_i3393_1_;
      this.field_73247_e = p_i3393_2_;
      this.field_73246_d = p_i3393_3_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return this.field_73244_f.func_76161_b(ChunkCoordIntPair.func_77272_a(p_73149_1_, p_73149_2_));
   }

   public void func_73241_b(int p_73241_1_, int p_73241_2_) {
      if(this.field_73251_h.field_73011_w.func_76567_e()) {
         ChunkCoordinates var3 = this.field_73251_h.func_72861_E();
         int var4 = p_73241_1_ * 16 + 8 - var3.field_71574_a;
         int var5 = p_73241_2_ * 16 + 8 - var3.field_71573_c;
         short var6 = 128;
         if(var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
            this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
         }
      } else {
         this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
      }

   }

   public void func_73240_a() {
      Iterator var1 = this.field_73245_g.iterator();

      while(var1.hasNext()) {
         Chunk var2 = (Chunk)var1.next();
         this.func_73241_b(var2.field_76635_g, var2.field_76647_h);
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      long var3 = ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_);
      this.field_73248_b.remove(Long.valueOf(var3));
      Chunk var5 = (Chunk)this.field_73244_f.func_76164_a(var3);
      if(var5 == null) {
         var5 = this.func_73239_e(p_73158_1_, p_73158_2_);
         if(var5 == null) {
            if(this.field_73246_d == null) {
               var5 = this.field_73249_c;
            } else {
               try {
                  var5 = this.field_73246_d.func_73154_d(p_73158_1_, p_73158_2_);
               } catch (Throwable var9) {
                  CrashReport var7 = CrashReport.func_85055_a(var9, "Exception generating new chunk");
                  CrashReportCategory var8 = var7.func_85058_a("Chunk to be generated");
                  var8.func_71507_a("Location", String.format("%d,%d", new Object[]{Integer.valueOf(p_73158_1_), Integer.valueOf(p_73158_2_)}));
                  var8.func_71507_a("Position hash", Long.valueOf(var3));
                  var8.func_71507_a("Generator", this.field_73246_d.func_73148_d());
                  throw new ReportedException(var7);
               }
            }
         }

         this.field_73244_f.func_76163_a(var3, var5);
         this.field_73245_g.add(var5);
         if(var5 != null) {
            var5.func_76631_c();
         }

         var5.func_76624_a(this, this, p_73158_1_, p_73158_2_);
      }

      return var5;
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      Chunk var3 = (Chunk)this.field_73244_f.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
      return var3 == null?(!this.field_73251_h.field_72987_B && !this.field_73250_a?this.field_73249_c:this.func_73158_c(p_73154_1_, p_73154_2_)):var3;
   }

   private Chunk func_73239_e(int p_73239_1_, int p_73239_2_) {
      if(this.field_73247_e == null) {
         return null;
      } else {
         try {
            Chunk var3 = this.field_73247_e.func_75815_a(this.field_73251_h, p_73239_1_, p_73239_2_);
            if(var3 != null) {
               var3.field_76641_n = this.field_73251_h.func_82737_E();
               if(this.field_73246_d != null) {
                  this.field_73246_d.func_82695_e(p_73239_1_, p_73239_2_);
               }
            }

            return var3;
         } catch (Exception var4) {
            var4.printStackTrace();
            return null;
         }
      }
   }

   private void func_73243_a(Chunk p_73243_1_) {
      if(this.field_73247_e != null) {
         try {
            this.field_73247_e.func_75819_b(this.field_73251_h, p_73243_1_);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

      }
   }

   private void func_73242_b(Chunk p_73242_1_) {
      if(this.field_73247_e != null) {
         try {
            p_73242_1_.field_76641_n = this.field_73251_h.func_82737_E();
            this.field_73247_e.func_75816_a(this.field_73251_h, p_73242_1_);
         } catch (IOException var3) {
            var3.printStackTrace();
         } catch (MinecraftException var4) {
            var4.printStackTrace();
         }

      }
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      Chunk var4 = this.func_73154_d(p_73153_2_, p_73153_3_);
      if(!var4.field_76646_k) {
         var4.field_76646_k = true;
         if(this.field_73246_d != null) {
            this.field_73246_d.func_73153_a(p_73153_1_, p_73153_2_, p_73153_3_);
            var4.func_76630_e();
         }
      }

   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      int var3 = 0;

      for(int var4 = 0; var4 < this.field_73245_g.size(); ++var4) {
         Chunk var5 = (Chunk)this.field_73245_g.get(var4);
         if(p_73151_1_) {
            this.func_73243_a(var5);
         }

         if(var5.func_76601_a(p_73151_1_)) {
            this.func_73242_b(var5);
            var5.field_76643_l = false;
            ++var3;
            if(var3 == 24 && !p_73151_1_) {
               return false;
            }
         }
      }

      if(p_73151_1_) {
         if(this.field_73247_e == null) {
            return true;
         }

         this.field_73247_e.func_75818_b();
      }

      return true;
   }

   public boolean func_73156_b() {
      if(!this.field_73251_h.field_73058_d) {
         for(int var1 = 0; var1 < 100; ++var1) {
            if(!this.field_73248_b.isEmpty()) {
               Long var2 = (Long)this.field_73248_b.iterator().next();
               Chunk var3 = (Chunk)this.field_73244_f.func_76164_a(var2.longValue());
               var3.func_76623_d();
               this.func_73242_b(var3);
               this.func_73243_a(var3);
               this.field_73248_b.remove(var2);
               this.field_73244_f.func_76159_d(var2.longValue());
               this.field_73245_g.remove(var3);
            }
         }

         if(this.field_73247_e != null) {
            this.field_73247_e.func_75817_a();
         }
      }

      return this.field_73246_d.func_73156_b();
   }

   public boolean func_73157_c() {
      return !this.field_73251_h.field_73058_d;
   }

   public String func_73148_d() {
      return "ServerChunkCache: " + this.field_73244_f.func_76162_a() + " Drop: " + this.field_73248_b.size();
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      return this.field_73246_d.func_73155_a(p_73155_1_, p_73155_2_, p_73155_3_, p_73155_4_);
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return this.field_73246_d.func_73150_a(p_73150_1_, p_73150_2_, p_73150_3_, p_73150_4_, p_73150_5_);
   }

   public int func_73152_e() {
      return this.field_73244_f.func_76162_a();
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
}
