package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityFX extends Entity {

   protected int field_94054_b;
   protected int field_94055_c;
   protected float field_70548_b;
   protected float field_70549_c;
   protected int field_70546_d;
   protected int field_70547_e;
   protected float field_70544_f;
   protected float field_70545_g;
   protected float field_70552_h;
   protected float field_70553_i;
   protected float field_70551_j;
   protected float field_82339_as;
   protected Icon field_70550_a;
   public static double field_70556_an;
   public static double field_70554_ao;
   public static double field_70555_ap;


   protected EntityFX(World p_i8001_1_, double p_i8001_2_, double p_i8001_4_, double p_i8001_6_) {
      super(p_i8001_1_);
      this.field_70546_d = 0;
      this.field_70547_e = 0;
      this.field_82339_as = 1.0F;
      this.field_70550_a = null;
      this.func_70105_a(0.2F, 0.2F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.func_70107_b(p_i8001_2_, p_i8001_4_, p_i8001_6_);
      this.field_70142_S = p_i8001_2_;
      this.field_70137_T = p_i8001_4_;
      this.field_70136_U = p_i8001_6_;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70548_b = this.field_70146_Z.nextFloat() * 3.0F;
      this.field_70549_c = this.field_70146_Z.nextFloat() * 3.0F;
      this.field_70544_f = (this.field_70146_Z.nextFloat() * 0.5F + 0.5F) * 2.0F;
      this.field_70547_e = (int)(4.0F / (this.field_70146_Z.nextFloat() * 0.9F + 0.1F));
      this.field_70546_d = 0;
   }

   public EntityFX(World p_i3154_1_, double p_i3154_2_, double p_i3154_4_, double p_i3154_6_, double p_i3154_8_, double p_i3154_10_, double p_i3154_12_) {
      this(p_i3154_1_, p_i3154_2_, p_i3154_4_, p_i3154_6_);
      this.field_70159_w = p_i3154_8_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      this.field_70181_x = p_i3154_10_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      this.field_70179_y = p_i3154_12_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
      float var15 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
      this.field_70159_w = this.field_70159_w / (double)var15 * (double)var14 * 0.4000000059604645D;
      this.field_70181_x = this.field_70181_x / (double)var15 * (double)var14 * 0.4000000059604645D + 0.10000000149011612D;
      this.field_70179_y = this.field_70179_y / (double)var15 * (double)var14 * 0.4000000059604645D;
   }

   public EntityFX func_70543_e(float p_70543_1_) {
      this.field_70159_w *= (double)p_70543_1_;
      this.field_70181_x = (this.field_70181_x - 0.10000000149011612D) * (double)p_70543_1_ + 0.10000000149011612D;
      this.field_70179_y *= (double)p_70543_1_;
      return this;
   }

   public EntityFX func_70541_f(float p_70541_1_) {
      this.func_70105_a(0.2F * p_70541_1_, 0.2F * p_70541_1_);
      this.field_70544_f *= p_70541_1_;
      return this;
   }

   public void func_70538_b(float p_70538_1_, float p_70538_2_, float p_70538_3_) {
      this.field_70552_h = p_70538_1_;
      this.field_70553_i = p_70538_2_;
      this.field_70551_j = p_70538_3_;
   }

   public void func_82338_g(float p_82338_1_) {
      this.field_82339_as = p_82338_1_;
   }

   public float func_70534_d() {
      return this.field_70552_h;
   }

   public float func_70542_f() {
      return this.field_70553_i;
   }

   public float func_70535_g() {
      return this.field_70551_j;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {}

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.field_70181_x -= 0.04D * (double)this.field_70545_g;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9800000190734863D;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= 0.9800000190734863D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = (float)this.field_94054_b / 16.0F;
      float var9 = var8 + 0.0624375F;
      float var10 = (float)this.field_94055_c / 16.0F;
      float var11 = var10 + 0.0624375F;
      float var12 = 0.1F * this.field_70544_f;
      if(this.field_70550_a != null) {
         var8 = this.field_70550_a.func_94209_e();
         var9 = this.field_70550_a.func_94212_f();
         var10 = this.field_70550_a.func_94206_g();
         var11 = this.field_70550_a.func_94210_h();
      }

      float var13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70539_2_ - field_70556_an);
      float var14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70539_2_ - field_70554_ao);
      float var15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70539_2_ - field_70555_ap);
      float var16 = 1.0F;
      p_70539_1_.func_78369_a(this.field_70552_h * var16, this.field_70553_i * var16, this.field_70551_j * var16, this.field_82339_as);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 - p_70539_7_ * var12), (double)var9, (double)var11);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 + p_70539_7_ * var12), (double)var9, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 + p_70539_7_ * var12), (double)var8, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 - p_70539_7_ * var12), (double)var8, (double)var11);
   }

   public int func_70537_b() {
      return 0;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {}

   public void func_70037_a(NBTTagCompound p_70037_1_) {}

   public void func_94052_a(RenderEngine p_94052_1_, Icon p_94052_2_) {
      if(this.func_70537_b() == 1) {
         this.field_70550_a = p_94052_2_;
      } else {
         if(this.func_70537_b() != 2) {
            throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
         }

         this.field_70550_a = p_94052_2_;
      }

   }

   public void func_70536_a(int p_70536_1_) {
      if(this.func_70537_b() != 0) {
         throw new RuntimeException("Invalid call to Particle.setMiscTex");
      } else {
         this.field_94054_b = p_70536_1_ % 16;
         this.field_94055_c = p_70536_1_ / 16;
      }
   }

   public void func_94053_h() {
      ++this.field_94054_b;
   }

   public boolean func_70075_an() {
      return false;
   }

   public String toString() {
      return this.getClass().getSimpleName() + ", Pos (" + this.field_70165_t + "," + this.field_70163_u + "," + this.field_70161_v + "), RGBA (" + this.field_70552_h + "," + this.field_70553_i + "," + this.field_70551_j + "," + this.field_82339_as + "), Age " + this.field_70546_d;
   }
}
