package net.minecraft.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class VillageCollection extends WorldSavedData {

   private World field_75556_a;
   private final List field_75554_b = new ArrayList();
   private final List field_75555_c = new ArrayList();
   private final List field_75552_d = new ArrayList();
   private int field_75553_e = 0;


   public VillageCollection(String p_i5061_1_) {
      super(p_i5061_1_);
   }

   public VillageCollection(World p_i3513_1_) {
      super("villages");
      this.field_75556_a = p_i3513_1_;
      this.func_76185_a();
   }

   public void func_82566_a(World p_82566_1_) {
      this.field_75556_a = p_82566_1_;
      Iterator var2 = this.field_75552_d.iterator();

      while(var2.hasNext()) {
         Village var3 = (Village)var2.next();
         var3.func_82691_a(p_82566_1_);
      }

   }

   public void func_75551_a(int p_75551_1_, int p_75551_2_, int p_75551_3_) {
      if(this.field_75554_b.size() <= 64) {
         if(!this.func_75548_d(p_75551_1_, p_75551_2_, p_75551_3_)) {
            this.field_75554_b.add(new ChunkCoordinates(p_75551_1_, p_75551_2_, p_75551_3_));
         }

      }
   }

   public void func_75544_a() {
      ++this.field_75553_e;
      Iterator var1 = this.field_75552_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         var2.func_75560_a(this.field_75553_e);
      }

      this.func_75549_c();
      this.func_75543_d();
      this.func_75545_e();
      if(this.field_75553_e % 400 == 0) {
         this.func_76185_a();
      }

   }

   private void func_75549_c() {
      Iterator var1 = this.field_75552_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         if(var2.func_75566_g()) {
            var1.remove();
            this.func_76185_a();
         }
      }

   }

   public List func_75540_b() {
      return this.field_75552_d;
   }

   public Village func_75550_a(int p_75550_1_, int p_75550_2_, int p_75550_3_, int p_75550_4_) {
      Village var5 = null;
      float var6 = Float.MAX_VALUE;
      Iterator var7 = this.field_75552_d.iterator();

      while(var7.hasNext()) {
         Village var8 = (Village)var7.next();
         float var9 = var8.func_75577_a().func_71569_e(p_75550_1_, p_75550_2_, p_75550_3_);
         if(var9 < var6) {
            int var10 = p_75550_4_ + var8.func_75568_b();
            if(var9 <= (float)(var10 * var10)) {
               var5 = var8;
               var6 = var9;
            }
         }
      }

      return var5;
   }

   private void func_75543_d() {
      if(!this.field_75554_b.isEmpty()) {
         this.func_75546_a((ChunkCoordinates)this.field_75554_b.remove(0));
      }
   }

   private void func_75545_e() {
      int var1 = 0;

      while(var1 < this.field_75555_c.size()) {
         VillageDoorInfo var2 = (VillageDoorInfo)this.field_75555_c.get(var1);
         boolean var3 = false;
         Iterator var4 = this.field_75552_d.iterator();

         while(true) {
            if(var4.hasNext()) {
               Village var5 = (Village)var4.next();
               int var6 = (int)var5.func_75577_a().func_71569_e(var2.field_75481_a, var2.field_75479_b, var2.field_75480_c);
               int var7 = 32 + var5.func_75568_b();
               if(var6 > var7 * var7) {
                  continue;
               }

               var5.func_75576_a(var2);
               var3 = true;
            }

            if(!var3) {
               Village var8 = new Village(this.field_75556_a);
               var8.func_75576_a(var2);
               this.field_75552_d.add(var8);
               this.func_76185_a();
            }

            ++var1;
            break;
         }
      }

      this.field_75555_c.clear();
   }

   private void func_75546_a(ChunkCoordinates p_75546_1_) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = p_75546_1_.field_71574_a - var2; var5 < p_75546_1_.field_71574_a + var2; ++var5) {
         for(int var6 = p_75546_1_.field_71572_b - var3; var6 < p_75546_1_.field_71572_b + var3; ++var6) {
            for(int var7 = p_75546_1_.field_71573_c - var4; var7 < p_75546_1_.field_71573_c + var4; ++var7) {
               if(this.func_75541_e(var5, var6, var7)) {
                  VillageDoorInfo var8 = this.func_75547_b(var5, var6, var7);
                  if(var8 == null) {
                     this.func_75542_c(var5, var6, var7);
                  } else {
                     var8.field_75475_f = this.field_75553_e;
                  }
               }
            }
         }
      }

   }

   private VillageDoorInfo func_75547_b(int p_75547_1_, int p_75547_2_, int p_75547_3_) {
      Iterator var4 = this.field_75555_c.iterator();

      VillageDoorInfo var5;
      do {
         if(!var4.hasNext()) {
            var4 = this.field_75552_d.iterator();

            VillageDoorInfo var6;
            do {
               if(!var4.hasNext()) {
                  return null;
               }

               Village var7 = (Village)var4.next();
               var6 = var7.func_75578_e(p_75547_1_, p_75547_2_, p_75547_3_);
            } while(var6 == null);

            return var6;
         }

         var5 = (VillageDoorInfo)var4.next();
      } while(var5.field_75481_a != p_75547_1_ || var5.field_75480_c != p_75547_3_ || Math.abs(var5.field_75479_b - p_75547_2_) > 1);

      return var5;
   }

   private void func_75542_c(int p_75542_1_, int p_75542_2_, int p_75542_3_) {
      int var4 = ((BlockDoor)Block.field_72054_aE).func_72235_d(this.field_75556_a, p_75542_1_, p_75542_2_, p_75542_3_);
      int var5;
      int var6;
      if(var4 != 0 && var4 != 2) {
         var5 = 0;

         for(var6 = -5; var6 < 0; ++var6) {
            if(this.field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + var6)) {
               --var5;
            }
         }

         for(var6 = 1; var6 <= 5; ++var6) {
            if(this.field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + var6)) {
               ++var5;
            }
         }

         if(var5 != 0) {
            this.field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, 0, var5 > 0?-2:2, this.field_75553_e));
         }
      } else {
         var5 = 0;

         for(var6 = -5; var6 < 0; ++var6) {
            if(this.field_75556_a.func_72937_j(p_75542_1_ + var6, p_75542_2_, p_75542_3_)) {
               --var5;
            }
         }

         for(var6 = 1; var6 <= 5; ++var6) {
            if(this.field_75556_a.func_72937_j(p_75542_1_ + var6, p_75542_2_, p_75542_3_)) {
               ++var5;
            }
         }

         if(var5 != 0) {
            this.field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, var5 > 0?-2:2, 0, this.field_75553_e));
         }
      }

   }

   private boolean func_75548_d(int p_75548_1_, int p_75548_2_, int p_75548_3_) {
      Iterator var4 = this.field_75554_b.iterator();

      ChunkCoordinates var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (ChunkCoordinates)var4.next();
      } while(var5.field_71574_a != p_75548_1_ || var5.field_71572_b != p_75548_2_ || var5.field_71573_c != p_75548_3_);

      return true;
   }

   private boolean func_75541_e(int p_75541_1_, int p_75541_2_, int p_75541_3_) {
      int var4 = this.field_75556_a.func_72798_a(p_75541_1_, p_75541_2_, p_75541_3_);
      return var4 == Block.field_72054_aE.field_71990_ca;
   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      this.field_75553_e = p_76184_1_.func_74762_e("Tick");
      NBTTagList var2 = p_76184_1_.func_74761_m("Villages");

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         Village var5 = new Village();
         var5.func_82690_a(var4);
         this.field_75552_d.add(var5);
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      p_76187_1_.func_74768_a("Tick", this.field_75553_e);
      NBTTagList var2 = new NBTTagList("Villages");
      Iterator var3 = this.field_75552_d.iterator();

      while(var3.hasNext()) {
         Village var4 = (Village)var3.next();
         NBTTagCompound var5 = new NBTTagCompound("Village");
         var4.func_82689_b(var5);
         var2.func_74742_a(var5);
      }

      p_76187_1_.func_74782_a("Villages", var2);
   }
}
