package net.minecraft.block;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class BlockBaseRailLogic {

   private World field_94516_b;
   private int field_94517_c;
   private int field_94514_d;
   private int field_94515_e;
   private final boolean field_94512_f;
   private List field_94513_g;
   // $FF: synthetic field
   final BlockRailBase field_94518_a;


   public BlockBaseRailLogic(BlockRailBase p_i9010_1_, World p_i9010_2_, int p_i9010_3_, int p_i9010_4_, int p_i9010_5_) {
      this.field_94518_a = p_i9010_1_;
      this.field_94513_g = new ArrayList();
      this.field_94516_b = p_i9010_2_;
      this.field_94517_c = p_i9010_3_;
      this.field_94514_d = p_i9010_4_;
      this.field_94515_e = p_i9010_5_;
      int var6 = p_i9010_2_.func_72798_a(p_i9010_3_, p_i9010_4_, p_i9010_5_);
      int var7 = p_i9010_2_.func_72805_g(p_i9010_3_, p_i9010_4_, p_i9010_5_);
      if(((BlockRailBase)Block.field_71973_m[var6]).field_72186_a) {
         this.field_94512_f = true;
         var7 &= -9;
      } else {
         this.field_94512_f = false;
      }

      this.func_94504_a(var7);
   }

   private void func_94504_a(int p_94504_1_) {
      this.field_94513_g.clear();
      if(p_94504_1_ == 0) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
      } else if(p_94504_1_ == 1) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
      } else if(p_94504_1_ == 2) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e));
      } else if(p_94504_1_ == 3) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
      } else if(p_94504_1_ == 4) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
      } else if(p_94504_1_ == 5) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1));
      } else if(p_94504_1_ == 6) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
      } else if(p_94504_1_ == 7) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
      } else if(p_94504_1_ == 8) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
      } else if(p_94504_1_ == 9) {
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
         this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
      }

   }

   private void func_94509_b() {
      for(int var1 = 0; var1 < this.field_94513_g.size(); ++var1) {
         BlockBaseRailLogic var2 = this.func_94501_a((ChunkPosition)this.field_94513_g.get(var1));
         if(var2 != null && var2.func_94508_a(this)) {
            this.field_94513_g.set(var1, new ChunkPosition(var2.field_94517_c, var2.field_94514_d, var2.field_94515_e));
         } else {
            this.field_94513_g.remove(var1--);
         }
      }

   }

   private boolean func_94502_a(int p_94502_1_, int p_94502_2_, int p_94502_3_) {
      return BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_, p_94502_3_)?true:(BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_ + 1, p_94502_3_)?true:BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_ - 1, p_94502_3_));
   }

   private BlockBaseRailLogic func_94501_a(ChunkPosition p_94501_1_) {
      return BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b, p_94501_1_.field_76929_c)?new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b, p_94501_1_.field_76929_c):(BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b + 1, p_94501_1_.field_76929_c)?new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b + 1, p_94501_1_.field_76929_c):(BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b - 1, p_94501_1_.field_76929_c)?new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b - 1, p_94501_1_.field_76929_c):null));
   }

   private boolean func_94508_a(BlockBaseRailLogic p_94508_1_) {
      for(int var2 = 0; var2 < this.field_94513_g.size(); ++var2) {
         ChunkPosition var3 = (ChunkPosition)this.field_94513_g.get(var2);
         if(var3.field_76930_a == p_94508_1_.field_94517_c && var3.field_76929_c == p_94508_1_.field_94515_e) {
            return true;
         }
      }

      return false;
   }

   private boolean func_94510_b(int p_94510_1_, int p_94510_2_, int p_94510_3_) {
      for(int var4 = 0; var4 < this.field_94513_g.size(); ++var4) {
         ChunkPosition var5 = (ChunkPosition)this.field_94513_g.get(var4);
         if(var5.field_76930_a == p_94510_1_ && var5.field_76929_c == p_94510_3_) {
            return true;
         }
      }

      return false;
   }

   public int func_94505_a() {
      int var1 = 0;
      if(this.func_94502_a(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1)) {
         ++var1;
      }

      if(this.func_94502_a(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1)) {
         ++var1;
      }

      if(this.func_94502_a(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e)) {
         ++var1;
      }

      if(this.func_94502_a(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e)) {
         ++var1;
      }

      return var1;
   }

   private boolean func_94507_b(BlockBaseRailLogic p_94507_1_) {
      return this.func_94508_a(p_94507_1_)?true:(this.field_94513_g.size() == 2?false:(this.field_94513_g.isEmpty()?true:true));
   }

   private void func_94506_c(BlockBaseRailLogic p_94506_1_) {
      this.field_94513_g.add(new ChunkPosition(p_94506_1_.field_94517_c, p_94506_1_.field_94514_d, p_94506_1_.field_94515_e));
      boolean var2 = this.func_94510_b(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1);
      boolean var3 = this.func_94510_b(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1);
      boolean var4 = this.func_94510_b(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e);
      boolean var5 = this.func_94510_b(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e);
      byte var6 = -1;
      if(var2 || var3) {
         var6 = 0;
      }

      if(var4 || var5) {
         var6 = 1;
      }

      if(!this.field_94512_f) {
         if(var3 && var5 && !var2 && !var4) {
            var6 = 6;
         }

         if(var3 && var4 && !var2 && !var5) {
            var6 = 7;
         }

         if(var2 && var4 && !var3 && !var5) {
            var6 = 8;
         }

         if(var2 && var5 && !var3 && !var4) {
            var6 = 9;
         }
      }

      if(var6 == 0) {
         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1)) {
            var6 = 4;
         }

         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1)) {
            var6 = 5;
         }
      }

      if(var6 == 1) {
         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e)) {
            var6 = 2;
         }

         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e)) {
            var6 = 3;
         }
      }

      if(var6 < 0) {
         var6 = 0;
      }

      int var7 = var6;
      if(this.field_94512_f) {
         var7 = this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) & 8 | var6;
      }

      this.field_94516_b.func_72921_c(this.field_94517_c, this.field_94514_d, this.field_94515_e, var7, 3);
   }

   private boolean func_94503_c(int p_94503_1_, int p_94503_2_, int p_94503_3_) {
      BlockBaseRailLogic var4 = this.func_94501_a(new ChunkPosition(p_94503_1_, p_94503_2_, p_94503_3_));
      if(var4 == null) {
         return false;
      } else {
         var4.func_94509_b();
         return var4.func_94507_b(this);
      }
   }

   public void func_94511_a(boolean p_94511_1_, boolean p_94511_2_) {
      boolean var3 = this.func_94503_c(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1);
      boolean var4 = this.func_94503_c(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1);
      boolean var5 = this.func_94503_c(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e);
      boolean var6 = this.func_94503_c(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e);
      byte var7 = -1;
      if((var3 || var4) && !var5 && !var6) {
         var7 = 0;
      }

      if((var5 || var6) && !var3 && !var4) {
         var7 = 1;
      }

      if(!this.field_94512_f) {
         if(var4 && var6 && !var3 && !var5) {
            var7 = 6;
         }

         if(var4 && var5 && !var3 && !var6) {
            var7 = 7;
         }

         if(var3 && var5 && !var4 && !var6) {
            var7 = 8;
         }

         if(var3 && var6 && !var4 && !var5) {
            var7 = 9;
         }
      }

      if(var7 == -1) {
         if(var3 || var4) {
            var7 = 0;
         }

         if(var5 || var6) {
            var7 = 1;
         }

         if(!this.field_94512_f) {
            if(p_94511_1_) {
               if(var4 && var6) {
                  var7 = 6;
               }

               if(var5 && var4) {
                  var7 = 7;
               }

               if(var6 && var3) {
                  var7 = 9;
               }

               if(var3 && var5) {
                  var7 = 8;
               }
            } else {
               if(var3 && var5) {
                  var7 = 8;
               }

               if(var6 && var3) {
                  var7 = 9;
               }

               if(var5 && var4) {
                  var7 = 7;
               }

               if(var4 && var6) {
                  var7 = 6;
               }
            }
         }
      }

      if(var7 == 0) {
         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1)) {
            var7 = 4;
         }

         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1)) {
            var7 = 5;
         }
      }

      if(var7 == 1) {
         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e)) {
            var7 = 2;
         }

         if(BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e)) {
            var7 = 3;
         }
      }

      if(var7 < 0) {
         var7 = 0;
      }

      this.func_94504_a(var7);
      int var8 = var7;
      if(this.field_94512_f) {
         var8 = this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) & 8 | var7;
      }

      if(p_94511_2_ || this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) != var8) {
         this.field_94516_b.func_72921_c(this.field_94517_c, this.field_94514_d, this.field_94515_e, var8, 3);

         for(int var9 = 0; var9 < this.field_94513_g.size(); ++var9) {
            BlockBaseRailLogic var10 = this.func_94501_a((ChunkPosition)this.field_94513_g.get(var9));
            if(var10 != null) {
               var10.func_94509_b();
               if(var10.func_94507_b(this)) {
                  var10.func_94506_c(this);
               }
            }
         }
      }

   }
}
