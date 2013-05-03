package net.minecraft.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySilverfish extends EntityMob {

   private int field_70843_d;


   public EntitySilverfish(World p_i3554_1_) {
      super(p_i3554_1_);
      this.field_70750_az = "/mob/silverfish.png";
      this.func_70105_a(0.3F, 0.7F);
      this.field_70697_bw = 0.6F;
   }

   public int func_70667_aM() {
      return 8;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected Entity func_70782_k() {
      double var1 = 8.0D;
      return this.field_70170_p.func_72856_b(this, var1);
   }

   protected String func_70639_aQ() {
      return "mob.silverfish.say";
   }

   protected String func_70621_aR() {
      return "mob.silverfish.hit";
   }

   protected String func_70673_aS() {
      return "mob.silverfish.kill";
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         if(this.field_70843_d <= 0 && (p_70097_1_ instanceof EntityDamageSource || p_70097_1_ == DamageSource.field_76376_m)) {
            this.field_70843_d = 20;
         }

         return super.func_70097_a(p_70097_1_, p_70097_2_);
      }
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      if(this.field_70724_aR <= 0 && p_70785_2_ < 1.2F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(p_70785_1_);
      }

   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.func_85030_a("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected int func_70633_aT() {
      return 0;
   }

   public void func_70071_h_() {
      this.field_70761_aq = this.field_70177_z;
      super.func_70071_h_();
   }

   protected void func_70626_be() {
      super.func_70626_be();
      if(!this.field_70170_p.field_72995_K) {
         int var1;
         int var2;
         int var3;
         int var5;
         if(this.field_70843_d > 0) {
            --this.field_70843_d;
            if(this.field_70843_d == 0) {
               var1 = MathHelper.func_76128_c(this.field_70165_t);
               var2 = MathHelper.func_76128_c(this.field_70163_u);
               var3 = MathHelper.func_76128_c(this.field_70161_v);
               boolean var4 = false;

               for(var5 = 0; !var4 && var5 <= 5 && var5 >= -5; var5 = var5 <= 0?1 - var5:0 - var5) {
                  for(int var6 = 0; !var4 && var6 <= 10 && var6 >= -10; var6 = var6 <= 0?1 - var6:0 - var6) {
                     for(int var7 = 0; !var4 && var7 <= 10 && var7 >= -10; var7 = var7 <= 0?1 - var7:0 - var7) {
                        int var8 = this.field_70170_p.func_72798_a(var1 + var6, var2 + var5, var3 + var7);
                        if(var8 == Block.field_72006_bl.field_71990_ca) {
                           this.field_70170_p.func_94578_a(var1 + var6, var2 + var5, var3 + var7, false);
                           Block.field_72006_bl.func_71898_d(this.field_70170_p, var1 + var6, var2 + var5, var3 + var7, 0);
                           if(this.field_70146_Z.nextBoolean()) {
                              var4 = true;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         if(this.field_70789_a == null && !this.func_70781_l()) {
            var1 = MathHelper.func_76128_c(this.field_70165_t);
            var2 = MathHelper.func_76128_c(this.field_70163_u + 0.5D);
            var3 = MathHelper.func_76128_c(this.field_70161_v);
            int var9 = this.field_70146_Z.nextInt(6);
            var5 = this.field_70170_p.func_72798_a(var1 + Facing.field_71586_b[var9], var2 + Facing.field_71587_c[var9], var3 + Facing.field_71585_d[var9]);
            if(BlockSilverfish.func_72154_e(var5)) {
               this.field_70170_p.func_72832_d(var1 + Facing.field_71586_b[var9], var2 + Facing.field_71587_c[var9], var3 + Facing.field_71585_d[var9], Block.field_72006_bl.field_71990_ca, BlockSilverfish.func_72153_f(var5), 3);
               this.func_70656_aK();
               this.func_70106_y();
            } else {
               this.func_70779_j();
            }
         } else if(this.field_70789_a != null && !this.func_70781_l()) {
            this.field_70789_a = null;
         }

      }
   }

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return this.field_70170_p.func_72798_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Block.field_71981_t.field_71990_ca?10.0F:super.func_70783_a(p_70783_1_, p_70783_2_, p_70783_3_);
   }

   protected boolean func_70814_o() {
      return true;
   }

   public boolean func_70601_bi() {
      if(super.func_70601_bi()) {
         EntityPlayer var1 = this.field_70170_p.func_72890_a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public int func_82193_c(Entity p_82193_1_) {
      return 1;
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.ARTHROPOD;
   }
}
