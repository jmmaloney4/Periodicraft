package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapCoord;
import net.minecraft.world.storage.MapInfo;

public class MapData extends WorldSavedData {

   public int field_76201_a;
   public int field_76199_b;
   public byte field_76200_c;
   public byte field_76197_d;
   public byte[] field_76198_e = new byte[16384];
   public List field_76196_g = new ArrayList();
   private Map field_76202_j = new HashMap();
   public Map field_76203_h = new LinkedHashMap();


   public MapData(String p_i3906_1_) {
      super(p_i3906_1_);
   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      this.field_76200_c = p_76184_1_.func_74771_c("dimension");
      this.field_76201_a = p_76184_1_.func_74762_e("xCenter");
      this.field_76199_b = p_76184_1_.func_74762_e("zCenter");
      this.field_76197_d = p_76184_1_.func_74771_c("scale");
      if(this.field_76197_d < 0) {
         this.field_76197_d = 0;
      }

      if(this.field_76197_d > 4) {
         this.field_76197_d = 4;
      }

      short var2 = p_76184_1_.func_74765_d("width");
      short var3 = p_76184_1_.func_74765_d("height");
      if(var2 == 128 && var3 == 128) {
         this.field_76198_e = p_76184_1_.func_74770_j("colors");
      } else {
         byte[] var4 = p_76184_1_.func_74770_j("colors");
         this.field_76198_e = new byte[16384];
         int var5 = (128 - var2) / 2;
         int var6 = (128 - var3) / 2;

         for(int var7 = 0; var7 < var3; ++var7) {
            int var8 = var7 + var6;
            if(var8 >= 0 || var8 < 128) {
               for(int var9 = 0; var9 < var2; ++var9) {
                  int var10 = var9 + var5;
                  if(var10 >= 0 || var10 < 128) {
                     this.field_76198_e[var10 + var8 * 128] = var4[var9 + var7 * var2];
                  }
               }
            }
         }
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      p_76187_1_.func_74774_a("dimension", this.field_76200_c);
      p_76187_1_.func_74768_a("xCenter", this.field_76201_a);
      p_76187_1_.func_74768_a("zCenter", this.field_76199_b);
      p_76187_1_.func_74774_a("scale", this.field_76197_d);
      p_76187_1_.func_74777_a("width", (short)128);
      p_76187_1_.func_74777_a("height", (short)128);
      p_76187_1_.func_74773_a("colors", this.field_76198_e);
   }

   public void func_76191_a(EntityPlayer p_76191_1_, ItemStack p_76191_2_) {
      if(!this.field_76202_j.containsKey(p_76191_1_)) {
         MapInfo var3 = new MapInfo(this, p_76191_1_);
         this.field_76202_j.put(p_76191_1_, var3);
         this.field_76196_g.add(var3);
      }

      if(!p_76191_1_.field_71071_by.func_70431_c(p_76191_2_)) {
         this.field_76203_h.remove(p_76191_1_.func_70005_c_());
      }

      for(int var5 = 0; var5 < this.field_76196_g.size(); ++var5) {
         MapInfo var4 = (MapInfo)this.field_76196_g.get(var5);
         if(!var4.field_76211_a.field_70128_L && (var4.field_76211_a.field_71071_by.func_70431_c(p_76191_2_) || p_76191_2_.func_82839_y())) {
            if(!p_76191_2_.func_82839_y() && var4.field_76211_a.field_71093_bK == this.field_76200_c) {
               this.func_82567_a(0, var4.field_76211_a.field_70170_p, var4.field_76211_a.func_70005_c_(), var4.field_76211_a.field_70165_t, var4.field_76211_a.field_70161_v, (double)var4.field_76211_a.field_70177_z);
            }
         } else {
            this.field_76202_j.remove(var4.field_76211_a);
            this.field_76196_g.remove(var4);
         }
      }

      if(p_76191_2_.func_82839_y()) {
         this.func_82567_a(1, p_76191_1_.field_70170_p, "frame-" + p_76191_2_.func_82836_z().field_70157_k, (double)p_76191_2_.func_82836_z().field_70523_b, (double)p_76191_2_.func_82836_z().field_70521_d, (double)(p_76191_2_.func_82836_z().field_82332_a * 90));
      }

   }

   private void func_82567_a(int p_82567_1_, World p_82567_2_, String p_82567_3_, double p_82567_4_, double p_82567_6_, double p_82567_8_) {
      int var10 = 1 << this.field_76197_d;
      float var11 = (float)(p_82567_4_ - (double)this.field_76201_a) / (float)var10;
      float var12 = (float)(p_82567_6_ - (double)this.field_76199_b) / (float)var10;
      byte var13 = (byte)((int)((double)(var11 * 2.0F) + 0.5D));
      byte var14 = (byte)((int)((double)(var12 * 2.0F) + 0.5D));
      byte var16 = 63;
      byte var15;
      if(var11 >= (float)(-var16) && var12 >= (float)(-var16) && var11 <= (float)var16 && var12 <= (float)var16) {
         p_82567_8_ += p_82567_8_ < 0.0D?-8.0D:8.0D;
         var15 = (byte)((int)(p_82567_8_ * 16.0D / 360.0D));
         if(this.field_76200_c < 0) {
            int var17 = (int)(p_82567_2_.func_72912_H().func_76073_f() / 10L);
            var15 = (byte)(var17 * var17 * 34187121 + var17 * 121 >> 15 & 15);
         }
      } else {
         if(Math.abs(var11) >= 320.0F || Math.abs(var12) >= 320.0F) {
            this.field_76203_h.remove(p_82567_3_);
            return;
         }

         p_82567_1_ = 6;
         var15 = 0;
         if(var11 <= (float)(-var16)) {
            var13 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if(var12 <= (float)(-var16)) {
            var14 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if(var11 >= (float)var16) {
            var13 = (byte)(var16 * 2 + 1);
         }

         if(var12 >= (float)var16) {
            var14 = (byte)(var16 * 2 + 1);
         }
      }

      this.field_76203_h.put(p_82567_3_, new MapCoord(this, (byte)p_82567_1_, var13, var14, var15));
   }

   public byte[] func_76193_a(ItemStack p_76193_1_, World p_76193_2_, EntityPlayer p_76193_3_) {
      MapInfo var4 = (MapInfo)this.field_76202_j.get(p_76193_3_);
      return var4 == null?null:var4.func_76204_a(p_76193_1_);
   }

   public void func_76194_a(int p_76194_1_, int p_76194_2_, int p_76194_3_) {
      super.func_76185_a();

      for(int var4 = 0; var4 < this.field_76196_g.size(); ++var4) {
         MapInfo var5 = (MapInfo)this.field_76196_g.get(var4);
         if(var5.field_76209_b[p_76194_1_] < 0 || var5.field_76209_b[p_76194_1_] > p_76194_2_) {
            var5.field_76209_b[p_76194_1_] = p_76194_2_;
         }

         if(var5.field_76210_c[p_76194_1_] < 0 || var5.field_76210_c[p_76194_1_] < p_76194_3_) {
            var5.field_76210_c[p_76194_1_] = p_76194_3_;
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_76192_a(byte[] p_76192_1_) {
      int var2;
      if(p_76192_1_[0] == 0) {
         var2 = p_76192_1_[1] & 255;
         int var3 = p_76192_1_[2] & 255;

         for(int var4 = 0; var4 < p_76192_1_.length - 3; ++var4) {
            this.field_76198_e[(var4 + var3) * 128 + var2] = p_76192_1_[var4 + 3];
         }

         this.func_76185_a();
      } else if(p_76192_1_[0] == 1) {
         this.field_76203_h.clear();

         for(var2 = 0; var2 < (p_76192_1_.length - 1) / 3; ++var2) {
            byte var7 = (byte)(p_76192_1_[var2 * 3 + 1] >> 4);
            byte var8 = p_76192_1_[var2 * 3 + 2];
            byte var5 = p_76192_1_[var2 * 3 + 3];
            byte var6 = (byte)(p_76192_1_[var2 * 3 + 1] & 15);
            this.field_76203_h.put("icon-" + var2, new MapCoord(this, var7, var8, var5, var6));
         }
      } else if(p_76192_1_[0] == 2) {
         this.field_76197_d = p_76192_1_[1];
      }

   }

   public MapInfo func_82568_a(EntityPlayer p_82568_1_) {
      MapInfo var2 = (MapInfo)this.field_76202_j.get(p_82568_1_);
      if(var2 == null) {
         var2 = new MapInfo(this, p_82568_1_);
         this.field_76202_j.put(p_82568_1_, var2);
         this.field_76196_g.add(var2);
      }

      return var2;
   }
}
