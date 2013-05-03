package net.minecraft.world.chunk.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.AnvilChunkLoaderPending;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.storage.RegionFileCache;
import net.minecraft.world.storage.IThreadedFileIO;
import net.minecraft.world.storage.ThreadedFileIOBase;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO {

   private List field_75828_a = new ArrayList();
   private Set field_75826_b = new HashSet();
   private Object field_75827_c = new Object();
   public final File field_75825_d;


   public AnvilChunkLoader(File p_i3779_1_) {
      this.field_75825_d = p_i3779_1_;
   }

   public Chunk func_75815_a(World p_75815_1_, int p_75815_2_, int p_75815_3_) throws IOException {
      NBTTagCompound var4 = null;
      ChunkCoordIntPair var5 = new ChunkCoordIntPair(p_75815_2_, p_75815_3_);
      Object var6 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75826_b.contains(var5)) {
            for(int var7 = 0; var7 < this.field_75828_a.size(); ++var7) {
               if(((AnvilChunkLoaderPending)this.field_75828_a.get(var7)).field_76548_a.equals(var5)) {
                  var4 = ((AnvilChunkLoaderPending)this.field_75828_a.get(var7)).field_76547_b;
                  break;
               }
            }
         }
      }

      if(var4 == null) {
         DataInputStream var10 = RegionFileCache.func_76549_c(this.field_75825_d, p_75815_2_, p_75815_3_);
         if(var10 == null) {
            return null;
         }

         var4 = CompressedStreamTools.func_74794_a(var10);
      }

      return this.func_75822_a(p_75815_1_, p_75815_2_, p_75815_3_, var4);
   }

   protected Chunk func_75822_a(World p_75822_1_, int p_75822_2_, int p_75822_3_, NBTTagCompound p_75822_4_) {
      if(!p_75822_4_.func_74764_b("Level")) {
         p_75822_1_.func_98180_V().func_98232_c("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing level data, skipping");
         return null;
      } else if(!p_75822_4_.func_74775_l("Level").func_74764_b("Sections")) {
         p_75822_1_.func_98180_V().func_98232_c("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing block data, skipping");
         return null;
      } else {
         Chunk var5 = this.func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
         if(!var5.func_76600_a(p_75822_2_, p_75822_3_)) {
            p_75822_1_.func_98180_V().func_98232_c("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is in the wrong location; relocating. (Expected " + p_75822_2_ + ", " + p_75822_3_ + ", got " + var5.field_76635_g + ", " + var5.field_76647_h + ")");
            p_75822_4_.func_74768_a("xPos", p_75822_2_);
            p_75822_4_.func_74768_a("zPos", p_75822_3_);
            var5 = this.func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
         }

         return var5;
      }
   }

   public void func_75816_a(World p_75816_1_, Chunk p_75816_2_) throws MinecraftException, IOException {
      p_75816_1_.func_72906_B();

      try {
         NBTTagCompound var3 = new NBTTagCompound();
         NBTTagCompound var4 = new NBTTagCompound();
         var3.func_74782_a("Level", var4);
         this.func_75820_a(p_75816_2_, p_75816_1_, var4);
         this.func_75824_a(p_75816_2_.func_76632_l(), var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected void func_75824_a(ChunkCoordIntPair p_75824_1_, NBTTagCompound p_75824_2_) {
      Object var3 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75826_b.contains(p_75824_1_)) {
            for(int var4 = 0; var4 < this.field_75828_a.size(); ++var4) {
               if(((AnvilChunkLoaderPending)this.field_75828_a.get(var4)).field_76548_a.equals(p_75824_1_)) {
                  this.field_75828_a.set(var4, new AnvilChunkLoaderPending(p_75824_1_, p_75824_2_));
                  return;
               }
            }
         }

         this.field_75828_a.add(new AnvilChunkLoaderPending(p_75824_1_, p_75824_2_));
         this.field_75826_b.add(p_75824_1_);
         ThreadedFileIOBase.field_75741_a.func_75735_a(this);
      }
   }

   public boolean func_75814_c() {
      AnvilChunkLoaderPending var1 = null;
      Object var2 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75828_a.isEmpty()) {
            return false;
         }

         var1 = (AnvilChunkLoaderPending)this.field_75828_a.remove(0);
         this.field_75826_b.remove(var1.field_76548_a);
      }

      if(var1 != null) {
         try {
            this.func_75821_a(var1);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return true;
   }

   private void func_75821_a(AnvilChunkLoaderPending p_75821_1_) throws IOException {
      DataOutputStream var2 = RegionFileCache.func_76552_d(this.field_75825_d, p_75821_1_.field_76548_a.field_77276_a, p_75821_1_.field_76548_a.field_77275_b);
      CompressedStreamTools.func_74800_a(p_75821_1_.field_76547_b, var2);
      var2.close();
   }

   public void func_75819_b(World p_75819_1_, Chunk p_75819_2_) {}

   public void func_75817_a() {}

   public void func_75818_b() {}

   private void func_75820_a(Chunk p_75820_1_, World p_75820_2_, NBTTagCompound p_75820_3_) {
      p_75820_3_.func_74768_a("xPos", p_75820_1_.field_76635_g);
      p_75820_3_.func_74768_a("zPos", p_75820_1_.field_76647_h);
      p_75820_3_.func_74772_a("LastUpdate", p_75820_2_.func_82737_E());
      p_75820_3_.func_74783_a("HeightMap", p_75820_1_.field_76634_f);
      p_75820_3_.func_74757_a("TerrainPopulated", p_75820_1_.field_76646_k);
      ExtendedBlockStorage[] var4 = p_75820_1_.func_76587_i();
      NBTTagList var5 = new NBTTagList("Sections");
      boolean var6 = !p_75820_2_.field_73011_w.field_76576_e;
      ExtendedBlockStorage[] var7 = var4;
      int var8 = var4.length;

      NBTTagCompound var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         ExtendedBlockStorage var10 = var7[var9];
         if(var10 != null) {
            var11 = new NBTTagCompound();
            var11.func_74774_a("Y", (byte)(var10.func_76662_d() >> 4 & 255));
            var11.func_74773_a("Blocks", var10.func_76658_g());
            if(var10.func_76660_i() != null) {
               var11.func_74773_a("Add", var10.func_76660_i().field_76585_a);
            }

            var11.func_74773_a("Data", var10.func_76669_j().field_76585_a);
            var11.func_74773_a("BlockLight", var10.func_76661_k().field_76585_a);
            if(var6) {
               var11.func_74773_a("SkyLight", var10.func_76671_l().field_76585_a);
            } else {
               var11.func_74773_a("SkyLight", new byte[var10.func_76661_k().field_76585_a.length]);
            }

            var5.func_74742_a(var11);
         }
      }

      p_75820_3_.func_74782_a("Sections", var5);
      p_75820_3_.func_74773_a("Biomes", p_75820_1_.func_76605_m());
      p_75820_1_.field_76644_m = false;
      NBTTagList var16 = new NBTTagList();

      Iterator var18;
      for(var8 = 0; var8 < p_75820_1_.field_76645_j.length; ++var8) {
         var18 = p_75820_1_.field_76645_j[var8].iterator();

         while(var18.hasNext()) {
            Entity var21 = (Entity)var18.next();
            var11 = new NBTTagCompound();
            if(var21.func_70039_c(var11)) {
               p_75820_1_.field_76644_m = true;
               var16.func_74742_a(var11);
            }
         }
      }

      p_75820_3_.func_74782_a("Entities", var16);
      NBTTagList var17 = new NBTTagList();
      var18 = p_75820_1_.field_76648_i.values().iterator();

      while(var18.hasNext()) {
         TileEntity var22 = (TileEntity)var18.next();
         var11 = new NBTTagCompound();
         var22.func_70310_b(var11);
         var17.func_74742_a(var11);
      }

      p_75820_3_.func_74782_a("TileEntities", var17);
      List var20 = p_75820_2_.func_72920_a(p_75820_1_, false);
      if(var20 != null) {
         long var19 = p_75820_2_.func_82737_E();
         NBTTagList var12 = new NBTTagList();
         Iterator var13 = var20.iterator();

         while(var13.hasNext()) {
            NextTickListEntry var14 = (NextTickListEntry)var13.next();
            NBTTagCompound var15 = new NBTTagCompound();
            var15.func_74768_a("i", var14.field_77179_d);
            var15.func_74768_a("x", var14.field_77183_a);
            var15.func_74768_a("y", var14.field_77181_b);
            var15.func_74768_a("z", var14.field_77182_c);
            var15.func_74768_a("t", (int)(var14.field_77180_e - var19));
            var15.func_74768_a("p", var14.field_82754_f);
            var12.func_74742_a(var15);
         }

         p_75820_3_.func_74782_a("TileTicks", var12);
      }

   }

   private Chunk func_75823_a(World p_75823_1_, NBTTagCompound p_75823_2_) {
      int var3 = p_75823_2_.func_74762_e("xPos");
      int var4 = p_75823_2_.func_74762_e("zPos");
      Chunk var5 = new Chunk(p_75823_1_, var3, var4);
      var5.field_76634_f = p_75823_2_.func_74759_k("HeightMap");
      var5.field_76646_k = p_75823_2_.func_74767_n("TerrainPopulated");
      NBTTagList var6 = p_75823_2_.func_74761_m("Sections");
      byte var7 = 16;
      ExtendedBlockStorage[] var8 = new ExtendedBlockStorage[var7];
      boolean var9 = !p_75823_1_.field_73011_w.field_76576_e;

      for(int var10 = 0; var10 < var6.func_74745_c(); ++var10) {
         NBTTagCompound var11 = (NBTTagCompound)var6.func_74743_b(var10);
         byte var12 = var11.func_74771_c("Y");
         ExtendedBlockStorage var13 = new ExtendedBlockStorage(var12 << 4, var9);
         var13.func_76664_a(var11.func_74770_j("Blocks"));
         if(var11.func_74764_b("Add")) {
            var13.func_76673_a(new NibbleArray(var11.func_74770_j("Add"), 4));
         }

         var13.func_76668_b(new NibbleArray(var11.func_74770_j("Data"), 4));
         var13.func_76659_c(new NibbleArray(var11.func_74770_j("BlockLight"), 4));
         if(var9) {
            var13.func_76666_d(new NibbleArray(var11.func_74770_j("SkyLight"), 4));
         }

         var13.func_76672_e();
         var8[var12] = var13;
      }

      var5.func_76602_a(var8);
      if(p_75823_2_.func_74764_b("Biomes")) {
         var5.func_76616_a(p_75823_2_.func_74770_j("Biomes"));
      }

      NBTTagList var18 = p_75823_2_.func_74761_m("Entities");
      if(var18 != null) {
         for(int var17 = 0; var17 < var18.func_74745_c(); ++var17) {
            NBTTagCompound var19 = (NBTTagCompound)var18.func_74743_b(var17);
            Entity var25 = EntityList.func_75615_a(var19, p_75823_1_);
            var5.field_76644_m = true;
            if(var25 != null) {
               var5.func_76612_a(var25);
               Entity var14 = var25;

               for(NBTTagCompound var15 = var19; var15.func_74764_b("Riding"); var15 = var15.func_74775_l("Riding")) {
                  Entity var16 = EntityList.func_75615_a(var15.func_74775_l("Riding"), p_75823_1_);
                  if(var16 != null) {
                     var5.func_76612_a(var16);
                     var14.func_70078_a(var16);
                  }

                  var14 = var16;
               }
            }
         }
      }

      NBTTagList var21 = p_75823_2_.func_74761_m("TileEntities");
      if(var21 != null) {
         for(int var20 = 0; var20 < var21.func_74745_c(); ++var20) {
            NBTTagCompound var22 = (NBTTagCompound)var21.func_74743_b(var20);
            TileEntity var27 = TileEntity.func_70317_c(var22);
            if(var27 != null) {
               var5.func_76620_a(var27);
            }
         }
      }

      if(p_75823_2_.func_74764_b("TileTicks")) {
         NBTTagList var24 = p_75823_2_.func_74761_m("TileTicks");
         if(var24 != null) {
            for(int var23 = 0; var23 < var24.func_74745_c(); ++var23) {
               NBTTagCompound var26 = (NBTTagCompound)var24.func_74743_b(var23);
               p_75823_1_.func_72892_b(var26.func_74762_e("x"), var26.func_74762_e("y"), var26.func_74762_e("z"), var26.func_74762_e("i"), var26.func_74762_e("t"), var26.func_74762_e("p"));
            }
         }
      }

      return var5;
   }
}
