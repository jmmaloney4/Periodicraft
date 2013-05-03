package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityBreakingFX extends EntityFX {

   public EntityBreakingFX(World p_i9003_1_, double p_i9003_2_, double p_i9003_4_, double p_i9003_6_, Item p_i9003_8_, RenderEngine p_i9003_9_) {
      super(p_i9003_1_, p_i9003_2_, p_i9003_4_, p_i9003_6_, 0.0D, 0.0D, 0.0D);
      this.func_94052_a(p_i9003_9_, p_i9003_8_.func_77617_a(0));
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70545_g = Block.field_72039_aU.field_72017_co;
      this.field_70544_f /= 2.0F;
   }

   public EntityBreakingFX(World p_i9004_1_, double p_i9004_2_, double p_i9004_4_, double p_i9004_6_, double p_i9004_8_, double p_i9004_10_, double p_i9004_12_, Item p_i9004_14_, RenderEngine p_i9004_15_) {
      this(p_i9004_1_, p_i9004_2_, p_i9004_4_, p_i9004_6_, p_i9004_14_, p_i9004_15_);
      this.field_70159_w *= 0.10000000149011612D;
      this.field_70181_x *= 0.10000000149011612D;
      this.field_70179_y *= 0.10000000149011612D;
      this.field_70159_w += p_i9004_8_;
      this.field_70181_x += p_i9004_10_;
      this.field_70179_y += p_i9004_12_;
   }

   public int func_70537_b() {
      return 2;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_94054_b + this.field_70548_b / 4.0F) / 16.0F;
      float var9 = var8 + 0.015609375F;
      float var10 = ((float)this.field_94055_c + this.field_70549_c / 4.0F) / 16.0F;
      float var11 = var10 + 0.015609375F;
      float var12 = 0.1F * this.field_70544_f;
      if(this.field_70550_a != null) {
         var8 = this.field_70550_a.func_94214_a((double)(this.field_70548_b / 4.0F * 16.0F));
         var9 = this.field_70550_a.func_94214_a((double)((this.field_70548_b + 1.0F) / 4.0F * 16.0F));
         var10 = this.field_70550_a.func_94207_b((double)(this.field_70549_c / 4.0F * 16.0F));
         var11 = this.field_70550_a.func_94207_b((double)((this.field_70549_c + 1.0F) / 4.0F * 16.0F));
      }

      float var13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70539_2_ - field_70556_an);
      float var14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70539_2_ - field_70554_ao);
      float var15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70539_2_ - field_70555_ap);
      float var16 = 1.0F;
      p_70539_1_.func_78386_a(var16 * this.field_70552_h, var16 * this.field_70553_i, var16 * this.field_70551_j);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 - p_70539_7_ * var12), (double)var8, (double)var11);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 + p_70539_7_ * var12), (double)var8, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 + p_70539_7_ * var12), (double)var9, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 - p_70539_7_ * var12), (double)var9, (double)var11);
   }
}
