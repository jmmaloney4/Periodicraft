package net.minecraft.entity.monster;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntitySlime extends EntityLiving implements IMob {

   private static final float[] field_100000_e = new float[]{1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
   public float field_70813_a;
   public float field_70811_b;
   public float field_70812_c;
   private int field_70810_d = 0;


   public EntitySlime(World p_i3556_1_) {
      super(p_i3556_1_);
      this.field_70750_az = "/mob/slime.png";
      int var2 = 1 << this.field_70146_Z.nextInt(3);
      this.field_70129_M = 0.0F;
      this.field_70810_d = this.field_70146_Z.nextInt(20) + 10;
      this.func_70799_a(var2);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)1));
   }

   protected void func_70799_a(int p_70799_1_) {
      this.field_70180_af.func_75692_b(16, new Byte((byte)p_70799_1_));
      this.func_70105_a(0.6F * (float)p_70799_1_, 0.6F * (float)p_70799_1_);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70606_j(this.func_70667_aM());
      this.field_70728_aV = p_70799_1_;
   }

   public int func_70667_aM() {
      int var1 = this.func_70809_q();
      return var1 * var1;
   }

   public int func_70809_q() {
      return this.field_70180_af.func_75683_a(16);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("Size", this.func_70809_q() - 1);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70799_a(p_70037_1_.func_74762_e("Size") + 1);
   }

   protected String func_70801_i() {
      return "slime";
   }

   protected String func_70803_o() {
      return "mob.slime." + (this.func_70809_q() > 1?"big":"small");
   }

   public void func_70071_h_() {
      if(!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0 && this.func_70809_q() > 0) {
         this.field_70128_L = true;
      }

      this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
      this.field_70812_c = this.field_70811_b;
      boolean var1 = this.field_70122_E;
      super.func_70071_h_();
      int var2;
      if(this.field_70122_E && !var1) {
         var2 = this.func_70809_q();

         for(int var3 = 0; var3 < var2 * 8; ++var3) {
            float var4 = this.field_70146_Z.nextFloat() * 3.1415927F * 2.0F;
            float var5 = this.field_70146_Z.nextFloat() * 0.5F + 0.5F;
            float var6 = MathHelper.func_76126_a(var4) * (float)var2 * 0.5F * var5;
            float var7 = MathHelper.func_76134_b(var4) * (float)var2 * 0.5F * var5;
            this.field_70170_p.func_72869_a(this.func_70801_i(), this.field_70165_t + (double)var6, this.field_70121_D.field_72338_b, this.field_70161_v + (double)var7, 0.0D, 0.0D, 0.0D);
         }

         if(this.func_70804_p()) {
            this.func_85030_a(this.func_70803_o(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.field_70813_a = -0.5F;
      } else if(!this.field_70122_E && var1) {
         this.field_70813_a = 1.0F;
      }

      this.func_70808_l();
      if(this.field_70170_p.field_72995_K) {
         var2 = this.func_70809_q();
         this.func_70105_a(0.6F * (float)var2, 0.6F * (float)var2);
      }

   }

   protected void func_70626_be() {
      this.func_70623_bb();
      EntityPlayer var1 = this.field_70170_p.func_72856_b(this, 16.0D);
      if(var1 != null) {
         this.func_70625_a(var1, 10.0F, 20.0F);
      }

      if(this.field_70122_E && this.field_70810_d-- <= 0) {
         this.field_70810_d = this.func_70806_k();
         if(var1 != null) {
            this.field_70810_d /= 3;
         }

         this.field_70703_bu = true;
         if(this.func_70807_r()) {
            this.func_85030_a(this.func_70803_o(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 0.8F);
         }

         this.field_70702_br = 1.0F - this.field_70146_Z.nextFloat() * 2.0F;
         this.field_70701_bs = (float)(1 * this.func_70809_q());
      } else {
         this.field_70703_bu = false;
         if(this.field_70122_E) {
            this.field_70702_br = this.field_70701_bs = 0.0F;
         }
      }

   }

   protected void func_70808_l() {
      this.field_70813_a *= 0.6F;
   }

   protected int func_70806_k() {
      return this.field_70146_Z.nextInt(20) + 10;
   }

   protected EntitySlime func_70802_j() {
      return new EntitySlime(this.field_70170_p);
   }

   public void func_70106_y() {
      int var1 = this.func_70809_q();
      if(!this.field_70170_p.field_72995_K && var1 > 1 && this.func_70630_aN() <= 0) {
         int var2 = 2 + this.field_70146_Z.nextInt(3);

         for(int var3 = 0; var3 < var2; ++var3) {
            float var4 = ((float)(var3 % 2) - 0.5F) * (float)var1 / 4.0F;
            float var5 = ((float)(var3 / 2) - 0.5F) * (float)var1 / 4.0F;
            EntitySlime var6 = this.func_70802_j();
            var6.func_70799_a(var1 / 2);
            var6.func_70012_b(this.field_70165_t + (double)var4, this.field_70163_u + 0.5D, this.field_70161_v + (double)var5, this.field_70146_Z.nextFloat() * 360.0F, 0.0F);
            this.field_70170_p.func_72838_d(var6);
         }
      }

      super.func_70106_y();
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {
      if(this.func_70800_m()) {
         int var2 = this.func_70809_q();
         if(this.func_70685_l(p_70100_1_) && this.func_70068_e(p_70100_1_) < 0.6D * (double)var2 * 0.6D * (double)var2 && p_70100_1_.func_70097_a(DamageSource.func_76358_a(this), this.func_70805_n())) {
            this.func_85030_a("mob.attack", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         }
      }

   }

   protected boolean func_70800_m() {
      return this.func_70809_q() > 1;
   }

   protected int func_70805_n() {
      return this.func_70809_q();
   }

   protected String func_70621_aR() {
      return "mob.slime." + (this.func_70809_q() > 1?"big":"small");
   }

   protected String func_70673_aS() {
      return "mob.slime." + (this.func_70809_q() > 1?"big":"small");
   }

   protected int func_70633_aT() {
      return this.func_70809_q() == 1?Item.field_77761_aM.field_77779_bT:0;
   }

   public boolean func_70601_bi() {
      Chunk var1 = this.field_70170_p.func_72938_d(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
      if(this.field_70170_p.func_72912_H().func_76067_t() == WorldType.field_77138_c && this.field_70146_Z.nextInt(4) != 1) {
         return false;
      } else {
         if(this.func_70809_q() == 1 || this.field_70170_p.field_73013_u > 0) {
            BiomeGenBase var2 = this.field_70170_p.func_72807_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
            if(var2 == BiomeGenBase.field_76780_h && this.field_70163_u > 50.0D && this.field_70163_u < 70.0D && this.field_70146_Z.nextFloat() < 0.5F && this.field_70146_Z.nextFloat() < field_100000_e[this.field_70170_p.func_72853_d()] && this.field_70170_p.func_72957_l(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) <= this.field_70146_Z.nextInt(8)) {
               return super.func_70601_bi();
            }

            if(this.field_70146_Z.nextInt(10) == 0 && var1.func_76617_a(987234911L).nextInt(10) == 0 && this.field_70163_u < 40.0D) {
               return super.func_70601_bi();
            }
         }

         return false;
      }
   }

   protected float func_70599_aP() {
      return 0.4F * (float)this.func_70809_q();
   }

   public int func_70646_bf() {
      return 0;
   }

   protected boolean func_70807_r() {
      return this.func_70809_q() > 0;
   }

   protected boolean func_70804_p() {
      return this.func_70809_q() > 2;
   }

}
