package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class WorldRenderer {

   public World field_78924_a;
   private int field_78942_y = -1;
   private static Tessellator field_78941_z = Tessellator.field_78398_a;
   public static int field_78922_b = 0;
   public int field_78923_c;
   public int field_78920_d;
   public int field_78921_e;
   public int field_78918_f;
   public int field_78919_g;
   public int field_78931_h;
   public int field_78932_i;
   public int field_78929_j;
   public int field_78930_k;
   public boolean field_78927_l = false;
   public boolean[] field_78928_m = new boolean[2];
   public int field_78925_n;
   public int field_78926_o;
   public int field_78940_p;
   public boolean field_78939_q;
   public AxisAlignedBB field_78938_r;
   public int field_78937_s;
   public boolean field_78936_t = true;
   public boolean field_78935_u;
   public int field_78934_v;
   public boolean field_78933_w;
   private boolean field_78915_A = false;
   public List field_78943_x = new ArrayList();
   private List field_78916_B;
   private int field_78917_C;


   public WorldRenderer(World p_i3196_1_, List p_i3196_2_, int p_i3196_3_, int p_i3196_4_, int p_i3196_5_, int p_i3196_6_) {
      this.field_78924_a = p_i3196_1_;
      this.field_78916_B = p_i3196_2_;
      this.field_78942_y = p_i3196_6_;
      this.field_78923_c = -999;
      this.func_78913_a(p_i3196_3_, p_i3196_4_, p_i3196_5_);
      this.field_78939_q = false;
   }

   public void func_78913_a(int p_78913_1_, int p_78913_2_, int p_78913_3_) {
      if(p_78913_1_ != this.field_78923_c || p_78913_2_ != this.field_78920_d || p_78913_3_ != this.field_78921_e) {
         this.func_78910_b();
         this.field_78923_c = p_78913_1_;
         this.field_78920_d = p_78913_2_;
         this.field_78921_e = p_78913_3_;
         this.field_78925_n = p_78913_1_ + 8;
         this.field_78926_o = p_78913_2_ + 8;
         this.field_78940_p = p_78913_3_ + 8;
         this.field_78932_i = p_78913_1_ & 1023;
         this.field_78929_j = p_78913_2_;
         this.field_78930_k = p_78913_3_ & 1023;
         this.field_78918_f = p_78913_1_ - this.field_78932_i;
         this.field_78919_g = p_78913_2_ - this.field_78929_j;
         this.field_78931_h = p_78913_3_ - this.field_78930_k;
         float var4 = 6.0F;
         this.field_78938_r = AxisAlignedBB.func_72330_a((double)((float)p_78913_1_ - var4), (double)((float)p_78913_2_ - var4), (double)((float)p_78913_3_ - var4), (double)((float)(p_78913_1_ + 16) + var4), (double)((float)(p_78913_2_ + 16) + var4), (double)((float)(p_78913_3_ + 16) + var4));
         GL11.glNewList(this.field_78942_y + 2, 4864);
         RenderItem.func_76980_a(AxisAlignedBB.func_72332_a().func_72299_a((double)((float)this.field_78932_i - var4), (double)((float)this.field_78929_j - var4), (double)((float)this.field_78930_k - var4), (double)((float)(this.field_78932_i + 16) + var4), (double)((float)(this.field_78929_j + 16) + var4), (double)((float)(this.field_78930_k + 16) + var4)));
         GL11.glEndList();
         this.func_78914_f();
      }
   }

   private void func_78905_g() {
      GL11.glTranslatef((float)this.field_78932_i, (float)this.field_78929_j, (float)this.field_78930_k);
   }

   public void func_78907_a() {
      if(this.field_78939_q) {
         this.field_78939_q = false;
         int var1 = this.field_78923_c;
         int var2 = this.field_78920_d;
         int var3 = this.field_78921_e;
         int var4 = this.field_78923_c + 16;
         int var5 = this.field_78920_d + 16;
         int var6 = this.field_78921_e + 16;

         for(int var7 = 0; var7 < 2; ++var7) {
            this.field_78928_m[var7] = true;
         }

         Chunk.field_76640_a = false;
         HashSet var21 = new HashSet();
         var21.addAll(this.field_78943_x);
         this.field_78943_x.clear();
         byte var8 = 1;
         ChunkCache var9 = new ChunkCache(this.field_78924_a, var1 - var8, var2 - var8, var3 - var8, var4 + var8, var5 + var8, var6 + var8, var8);
         if(!var9.func_72806_N()) {
            ++field_78922_b;
            RenderBlocks var10 = new RenderBlocks(var9);
            this.field_78917_C = 0;

            for(int var11 = 0; var11 < 2; ++var11) {
               boolean var12 = false;
               boolean var13 = false;
               boolean var14 = false;

               for(int var15 = var2; var15 < var5; ++var15) {
                  for(int var16 = var3; var16 < var6; ++var16) {
                     for(int var17 = var1; var17 < var4; ++var17) {
                        int var18 = var9.func_72798_a(var17, var15, var16);
                        if(var18 > 0) {
                           if(!var14) {
                              var14 = true;
                              GL11.glNewList(this.field_78942_y + var11, 4864);
                              GL11.glPushMatrix();
                              this.func_78905_g();
                              float var19 = 1.000001F;
                              GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
                              GL11.glScalef(var19, var19, var19);
                              GL11.glTranslatef(8.0F, 8.0F, 8.0F);
                              field_78941_z.func_78382_b();
                              field_78941_z.func_78373_b((double)(-this.field_78923_c), (double)(-this.field_78920_d), (double)(-this.field_78921_e));
                           }

                           Block var23 = Block.field_71973_m[var18];
                           if(var23 != null) {
                              if(var11 == 0 && var23.func_71887_s()) {
                                 TileEntity var20 = var9.func_72796_p(var17, var15, var16);
                                 if(TileEntityRenderer.field_76963_a.func_76952_a(var20)) {
                                    this.field_78943_x.add(var20);
                                 }
                              }

                              int var24 = var23.func_71856_s_();
                              if(var24 != var11) {
                                 var12 = true;
                              } else if(var24 == var11) {
                                 var13 |= var10.func_78612_b(var23, var17, var15, var16);
                              }
                           }
                        }
                     }
                  }
               }

               if(var14) {
                  this.field_78917_C += field_78941_z.func_78381_a();
                  GL11.glPopMatrix();
                  GL11.glEndList();
                  field_78941_z.func_78373_b(0.0D, 0.0D, 0.0D);
               } else {
                  var13 = false;
               }

               if(var13) {
                  this.field_78928_m[var11] = false;
               }

               if(!var12) {
                  break;
               }
            }
         }

         HashSet var22 = new HashSet();
         var22.addAll(this.field_78943_x);
         var22.removeAll(var21);
         this.field_78916_B.addAll(var22);
         var21.removeAll(this.field_78943_x);
         this.field_78916_B.removeAll(var21);
         this.field_78933_w = Chunk.field_76640_a;
         this.field_78915_A = true;
      }
   }

   public float func_78912_a(Entity p_78912_1_) {
      float var2 = (float)(p_78912_1_.field_70165_t - (double)this.field_78925_n);
      float var3 = (float)(p_78912_1_.field_70163_u - (double)this.field_78926_o);
      float var4 = (float)(p_78912_1_.field_70161_v - (double)this.field_78940_p);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public void func_78910_b() {
      for(int var1 = 0; var1 < 2; ++var1) {
         this.field_78928_m[var1] = true;
      }

      this.field_78927_l = false;
      this.field_78915_A = false;
   }

   public void func_78911_c() {
      this.func_78910_b();
      this.field_78924_a = null;
   }

   public int func_78909_a(int p_78909_1_) {
      return !this.field_78927_l?-1:(!this.field_78928_m[p_78909_1_]?this.field_78942_y + p_78909_1_:-1);
   }

   public void func_78908_a(ICamera p_78908_1_) {
      this.field_78927_l = p_78908_1_.func_78546_a(this.field_78938_r);
   }

   public void func_78904_d() {
      GL11.glCallList(this.field_78942_y + 2);
   }

   public boolean func_78906_e() {
      return !this.field_78915_A?false:this.field_78928_m[0] && this.field_78928_m[1];
   }

   public void func_78914_f() {
      this.field_78939_q = true;
   }

}
