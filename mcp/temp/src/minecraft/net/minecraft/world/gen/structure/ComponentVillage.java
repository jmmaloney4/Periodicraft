package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public abstract class ComponentVillage extends StructureComponent {

   private int field_74896_a;
   protected ComponentVillageStartPiece field_74897_k;


   protected ComponentVillage(ComponentVillageStartPiece p_i3873_1_, int p_i3873_2_) {
      super(p_i3873_2_);
      this.field_74897_k = p_i3873_1_;
   }

   protected StructureComponent func_74891_a(ComponentVillageStartPiece p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_) {
      switch(this.field_74885_f) {
      case 0:
         return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
      case 1:
         return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
      case 2:
         return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
      case 3:
         return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
      default:
         return null;
      }
   }

   protected StructureComponent func_74894_b(ComponentVillageStartPiece p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_) {
      switch(this.field_74885_f) {
      case 0:
         return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
      case 1:
         return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
      case 2:
         return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
      case 3:
         return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
      default:
         return null;
      }
   }

   protected int func_74889_b(World p_74889_1_, StructureBoundingBox p_74889_2_) {
      int var3 = 0;
      int var4 = 0;

      for(int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
         for(int var6 = this.field_74887_e.field_78897_a; var6 <= this.field_74887_e.field_78893_d; ++var6) {
            if(p_74889_2_.func_78890_b(var6, 64, var5)) {
               var3 += Math.max(p_74889_1_.func_72825_h(var6, var5), p_74889_1_.field_73011_w.func_76557_i());
               ++var4;
            }
         }
      }

      if(var4 == 0) {
         return -1;
      } else {
         return var3 / var4;
      }
   }

   protected static boolean func_74895_a(StructureBoundingBox p_74895_0_) {
      return p_74895_0_ != null && p_74895_0_.field_78895_b > 10;
   }

   protected void func_74893_a(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_) {
      if(this.field_74896_a < p_74893_6_) {
         for(int var7 = this.field_74896_a; var7 < p_74893_6_; ++var7) {
            int var8 = this.func_74865_a(p_74893_3_ + var7, p_74893_5_);
            int var9 = this.func_74862_a(p_74893_4_);
            int var10 = this.func_74873_b(p_74893_3_ + var7, p_74893_5_);
            if(!p_74893_2_.func_78890_b(var8, var9, var10)) {
               break;
            }

            ++this.field_74896_a;
            EntityVillager var11 = new EntityVillager(p_74893_1_, this.func_74888_b(var7));
            var11.func_70012_b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
            p_74893_1_.func_72838_d(var11);
         }

      }
   }

   protected int func_74888_b(int p_74888_1_) {
      return 0;
   }

   protected int func_74890_d(int p_74890_1_, int p_74890_2_) {
      if(this.field_74897_k.field_74927_b) {
         if(p_74890_1_ == Block.field_71951_J.field_71990_ca) {
            return Block.field_71957_Q.field_71990_ca;
         }

         if(p_74890_1_ == Block.field_71978_w.field_71990_ca) {
            return Block.field_71957_Q.field_71990_ca;
         }

         if(p_74890_1_ == Block.field_71988_x.field_71990_ca) {
            return Block.field_71957_Q.field_71990_ca;
         }

         if(p_74890_1_ == Block.field_72063_at.field_71990_ca) {
            return Block.field_72088_bQ.field_71990_ca;
         }

         if(p_74890_1_ == Block.field_72057_aH.field_71990_ca) {
            return Block.field_72088_bQ.field_71990_ca;
         }

         if(p_74890_1_ == Block.field_71940_F.field_71990_ca) {
            return Block.field_71957_Q.field_71990_ca;
         }
      }

      return p_74890_1_;
   }

   protected int func_74892_e(int p_74892_1_, int p_74892_2_) {
      if(this.field_74897_k.field_74927_b) {
         if(p_74892_1_ == Block.field_71951_J.field_71990_ca) {
            return 0;
         }

         if(p_74892_1_ == Block.field_71978_w.field_71990_ca) {
            return 0;
         }

         if(p_74892_1_ == Block.field_71988_x.field_71990_ca) {
            return 2;
         }
      }

      return p_74892_2_;
   }

   protected void func_74864_a(World p_74864_1_, int p_74864_2_, int p_74864_3_, int p_74864_4_, int p_74864_5_, int p_74864_6_, StructureBoundingBox p_74864_7_) {
      int var8 = this.func_74890_d(p_74864_2_, p_74864_3_);
      int var9 = this.func_74892_e(p_74864_2_, p_74864_3_);
      super.func_74864_a(p_74864_1_, var8, var9, p_74864_4_, p_74864_5_, p_74864_6_, p_74864_7_);
   }

   protected void func_74884_a(World p_74884_1_, StructureBoundingBox p_74884_2_, int p_74884_3_, int p_74884_4_, int p_74884_5_, int p_74884_6_, int p_74884_7_, int p_74884_8_, int p_74884_9_, int p_74884_10_, boolean p_74884_11_) {
      int var12 = this.func_74890_d(p_74884_9_, 0);
      int var13 = this.func_74892_e(p_74884_9_, 0);
      int var14 = this.func_74890_d(p_74884_10_, 0);
      int var15 = this.func_74892_e(p_74884_10_, 0);
      super.func_74872_a(p_74884_1_, p_74884_2_, p_74884_3_, p_74884_4_, p_74884_5_, p_74884_6_, p_74884_7_, p_74884_8_, var12, var13, var14, var15, p_74884_11_);
   }

   protected void func_74870_b(World p_74870_1_, int p_74870_2_, int p_74870_3_, int p_74870_4_, int p_74870_5_, int p_74870_6_, StructureBoundingBox p_74870_7_) {
      int var8 = this.func_74890_d(p_74870_2_, p_74870_3_);
      int var9 = this.func_74892_e(p_74870_2_, p_74870_3_);
      super.func_74870_b(p_74870_1_, var8, var9, p_74870_4_, p_74870_5_, p_74870_6_, p_74870_7_);
   }
}
