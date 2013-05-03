package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

@SideOnly(Side.CLIENT)
public class ActiveRenderInfo {

   public static float field_74592_a = 0.0F;
   public static float field_74590_b = 0.0F;
   public static float field_74591_c = 0.0F;
   private static IntBuffer field_74597_i = GLAllocation.func_74527_f(16);
   private static FloatBuffer field_74594_j = GLAllocation.func_74529_h(16);
   private static FloatBuffer field_74595_k = GLAllocation.func_74529_h(16);
   private static FloatBuffer field_74593_l = GLAllocation.func_74529_h(3);
   public static float field_74588_d;
   public static float field_74589_e;
   public static float field_74586_f;
   public static float field_74587_g;
   public static float field_74596_h;


   public static void func_74583_a(EntityPlayer p_74583_0_, boolean p_74583_1_) {
      GL11.glGetFloat(2982, field_74594_j);
      GL11.glGetFloat(2983, field_74595_k);
      GL11.glGetInteger(2978, field_74597_i);
      float var2 = (float)((field_74597_i.get(0) + field_74597_i.get(2)) / 2);
      float var3 = (float)((field_74597_i.get(1) + field_74597_i.get(3)) / 2);
      GLU.gluUnProject(var2, var3, 0.0F, field_74594_j, field_74595_k, field_74597_i, field_74593_l);
      field_74592_a = field_74593_l.get(0);
      field_74590_b = field_74593_l.get(1);
      field_74591_c = field_74593_l.get(2);
      int var4 = p_74583_1_?1:0;
      float var5 = p_74583_0_.field_70125_A;
      float var6 = p_74583_0_.field_70177_z;
      field_74588_d = MathHelper.func_76134_b(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74586_f = MathHelper.func_76126_a(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74587_g = -field_74586_f * MathHelper.func_76126_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74596_h = field_74588_d * MathHelper.func_76126_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74589_e = MathHelper.func_76134_b(var5 * 3.1415927F / 180.0F);
   }

   public static Vec3 func_74585_b(EntityLiving p_74585_0_, double p_74585_1_) {
      double var3 = p_74585_0_.field_70169_q + (p_74585_0_.field_70165_t - p_74585_0_.field_70169_q) * p_74585_1_;
      double var5 = p_74585_0_.field_70167_r + (p_74585_0_.field_70163_u - p_74585_0_.field_70167_r) * p_74585_1_ + (double)p_74585_0_.func_70047_e();
      double var7 = p_74585_0_.field_70166_s + (p_74585_0_.field_70161_v - p_74585_0_.field_70166_s) * p_74585_1_;
      double var9 = var3 + (double)(field_74592_a * 1.0F);
      double var11 = var5 + (double)(field_74590_b * 1.0F);
      double var13 = var7 + (double)(field_74591_c * 1.0F);
      return p_74585_0_.field_70170_p.func_82732_R().func_72345_a(var9, var11, var13);
   }

   public static int func_74584_a(World p_74584_0_, EntityLiving p_74584_1_, float p_74584_2_) {
      Vec3 var3 = func_74585_b(p_74584_1_, (double)p_74584_2_);
      ChunkPosition var4 = new ChunkPosition(var3);
      int var5 = p_74584_0_.func_72798_a(var4.field_76930_a, var4.field_76928_b, var4.field_76929_c);
      if(var5 != 0 && Block.field_71973_m[var5].field_72018_cp.func_76224_d()) {
         float var6 = BlockFluid.func_72199_d(p_74584_0_.func_72805_g(var4.field_76930_a, var4.field_76928_b, var4.field_76929_c)) - 0.11111111F;
         float var7 = (float)(var4.field_76928_b + 1) - var6;
         if(var3.field_72448_b >= (double)var7) {
            var5 = p_74584_0_.func_72798_a(var4.field_76930_a, var4.field_76928_b + 1, var4.field_76929_c);
         }
      }

      return var5;
   }

}
