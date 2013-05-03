package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityFireworkOverlayFX extends EntityFX {

   protected EntityFireworkOverlayFX(World p_i8004_1_, double p_i8004_2_, double p_i8004_4_, double p_i8004_6_) {
      super(p_i8004_1_, p_i8004_2_, p_i8004_4_, p_i8004_6_);
      this.field_70547_e = 4;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = 0.25F;
      float var9 = var8 + 0.25F;
      float var10 = 0.125F;
      float var11 = var10 + 0.25F;
      float var12 = 7.1F * MathHelper.func_76126_a(((float)this.field_70546_d + p_70539_2_ - 1.0F) * 0.25F * 3.1415927F);
      this.field_82339_as = 0.6F - ((float)this.field_70546_d + p_70539_2_ - 1.0F) * 0.25F * 0.5F;
      float var13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70539_2_ - field_70556_an);
      float var14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70539_2_ - field_70554_ao);
      float var15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70539_2_ - field_70555_ap);
      p_70539_1_.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 - p_70539_7_ * var12), (double)var9, (double)var11);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 + p_70539_7_ * var12), (double)var9, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 + p_70539_7_ * var12), (double)var8, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 - p_70539_7_ * var12), (double)var8, (double)var11);
   }
}
