package net.minecraft.world.storage;

import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.MapCoord;
import net.minecraft.world.storage.MapData;

public class MapInfo {

   public final EntityPlayer field_76211_a;
   public int[] field_76209_b;
   public int[] field_76210_c;
   private int field_76208_e;
   private int field_76205_f;
   private byte[] field_76206_g;
   public int field_82569_d;
   private boolean field_82570_i;
   // $FF: synthetic field
   final MapData field_76207_d;


   public MapInfo(MapData p_i3904_1_, EntityPlayer p_i3904_2_) {
      this.field_76207_d = p_i3904_1_;
      this.field_76209_b = new int[128];
      this.field_76210_c = new int[128];
      this.field_76208_e = 0;
      this.field_76205_f = 0;
      this.field_82570_i = false;
      this.field_76211_a = p_i3904_2_;

      for(int var3 = 0; var3 < this.field_76209_b.length; ++var3) {
         this.field_76209_b[var3] = 0;
         this.field_76210_c[var3] = 127;
      }

   }

   public byte[] func_76204_a(ItemStack p_76204_1_) {
      byte[] var2;
      if(!this.field_82570_i) {
         var2 = new byte[]{(byte)2, this.field_76207_d.field_76197_d};
         this.field_82570_i = true;
         return var2;
      } else {
         int var3;
         int var10;
         if(--this.field_76205_f < 0) {
            this.field_76205_f = 4;
            var2 = new byte[this.field_76207_d.field_76203_h.size() * 3 + 1];
            var2[0] = 1;
            var3 = 0;

            for(Iterator var4 = this.field_76207_d.field_76203_h.values().iterator(); var4.hasNext(); ++var3) {
               MapCoord var5 = (MapCoord)var4.next();
               var2[var3 * 3 + 1] = (byte)(var5.field_76216_a << 4 | var5.field_76212_d & 15);
               var2[var3 * 3 + 2] = var5.field_76214_b;
               var2[var3 * 3 + 3] = var5.field_76215_c;
            }

            boolean var9 = !p_76204_1_.func_82839_y();
            if(this.field_76206_g != null && this.field_76206_g.length == var2.length) {
               for(var10 = 0; var10 < var2.length; ++var10) {
                  if(var2[var10] != this.field_76206_g[var10]) {
                     var9 = false;
                     break;
                  }
               }
            } else {
               var9 = false;
            }

            if(!var9) {
               this.field_76206_g = var2;
               return var2;
            }
         }

         for(int var8 = 0; var8 < 1; ++var8) {
            var3 = this.field_76208_e++ * 11 % 128;
            if(this.field_76209_b[var3] >= 0) {
               int var11 = this.field_76210_c[var3] - this.field_76209_b[var3] + 1;
               var10 = this.field_76209_b[var3];
               byte[] var6 = new byte[var11 + 3];
               var6[0] = 0;
               var6[1] = (byte)var3;
               var6[2] = (byte)var10;

               for(int var7 = 0; var7 < var6.length - 3; ++var7) {
                  var6[var7 + 3] = this.field_76207_d.field_76198_e[(var7 + var10) * 128 + var3];
               }

               this.field_76210_c[var3] = -1;
               this.field_76209_b[var3] = -1;
               return var6;
            }
         }

         return null;
      }
   }
}
