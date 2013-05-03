package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public class EntityAIControlledByPlayer extends EntityAIBase {

   private final EntityLiving field_82640_a;
   private final float field_82638_b;
   private float field_82639_c = 0.0F;
   private boolean field_82636_d = false;
   private int field_82637_e = 0;
   private int field_82635_f = 0;


   public EntityAIControlledByPlayer(EntityLiving p_i5058_1_, float p_i5058_2_) {
      this.field_82640_a = p_i5058_1_;
      this.field_82638_b = p_i5058_2_;
      this.func_75248_a(7);
   }

   public void func_75249_e() {
      this.field_82639_c = 0.0F;
   }

   public void func_75251_c() {
      this.field_82636_d = false;
      this.field_82639_c = 0.0F;
   }

   public boolean func_75250_a() {
      return this.field_82640_a.func_70089_S() && this.field_82640_a.field_70153_n != null && this.field_82640_a.field_70153_n instanceof EntityPlayer && (this.field_82636_d || this.field_82640_a.func_82171_bF());
   }

   public void func_75246_d() {
      EntityPlayer var1 = (EntityPlayer)this.field_82640_a.field_70153_n;
      EntityCreature var2 = (EntityCreature)this.field_82640_a;
      float var3 = MathHelper.func_76142_g(var1.field_70177_z - this.field_82640_a.field_70177_z) * 0.5F;
      if(var3 > 5.0F) {
         var3 = 5.0F;
      }

      if(var3 < -5.0F) {
         var3 = -5.0F;
      }

      this.field_82640_a.field_70177_z = MathHelper.func_76142_g(this.field_82640_a.field_70177_z + var3);
      if(this.field_82639_c < this.field_82638_b) {
         this.field_82639_c += (this.field_82638_b - this.field_82639_c) * 0.01F;
      }

      if(this.field_82639_c > this.field_82638_b) {
         this.field_82639_c = this.field_82638_b;
      }

      int var4 = MathHelper.func_76128_c(this.field_82640_a.field_70165_t);
      int var5 = MathHelper.func_76128_c(this.field_82640_a.field_70163_u);
      int var6 = MathHelper.func_76128_c(this.field_82640_a.field_70161_v);
      float var7 = this.field_82639_c;
      if(this.field_82636_d) {
         if(this.field_82637_e++ > this.field_82635_f) {
            this.field_82636_d = false;
         }

         var7 += var7 * 1.15F * MathHelper.func_76126_a((float)this.field_82637_e / (float)this.field_82635_f * 3.1415927F);
      }

      float var8 = 0.91F;
      if(this.field_82640_a.field_70122_E) {
         var8 = 0.54600006F;
         int var9 = this.field_82640_a.field_70170_p.func_72798_a(MathHelper.func_76141_d((float)var4), MathHelper.func_76141_d((float)var5) - 1, MathHelper.func_76141_d((float)var6));
         if(var9 > 0) {
            var8 = Block.field_71973_m[var9].field_72016_cq * 0.91F;
         }
      }

      float var23 = 0.16277136F / (var8 * var8 * var8);
      float var10 = MathHelper.func_76126_a(var2.field_70177_z * 3.1415927F / 180.0F);
      float var11 = MathHelper.func_76134_b(var2.field_70177_z * 3.1415927F / 180.0F);
      float var12 = var2.func_70689_ay() * var23;
      float var13 = Math.max(var7, 1.0F);
      var13 = var12 / var13;
      float var14 = var7 * var13;
      float var15 = -(var14 * var10);
      float var16 = var14 * var11;
      if(MathHelper.func_76135_e(var15) > MathHelper.func_76135_e(var16)) {
         if(var15 < 0.0F) {
            var15 -= this.field_82640_a.field_70130_N / 2.0F;
         }

         if(var15 > 0.0F) {
            var15 += this.field_82640_a.field_70130_N / 2.0F;
         }

         var16 = 0.0F;
      } else {
         var15 = 0.0F;
         if(var16 < 0.0F) {
            var16 -= this.field_82640_a.field_70130_N / 2.0F;
         }

         if(var16 > 0.0F) {
            var16 += this.field_82640_a.field_70130_N / 2.0F;
         }
      }

      int var17 = MathHelper.func_76128_c(this.field_82640_a.field_70165_t + (double)var15);
      int var18 = MathHelper.func_76128_c(this.field_82640_a.field_70161_v + (double)var16);
      PathPoint var19 = new PathPoint(MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70131_O + var1.field_70131_O + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F));
      if(var4 != var17 || var6 != var18) {
         int var20 = this.field_82640_a.field_70170_p.func_72798_a(var4, var5, var6);
         int var21 = this.field_82640_a.field_70170_p.func_72798_a(var4, var5 - 1, var6);
         boolean var22 = this.func_98216_b(var20) || Block.field_71973_m[var20] == null && this.func_98216_b(var21);
         if(!var22 && PathFinder.func_82565_a(this.field_82640_a, var17, var5, var18, var19, false, false, true) == 0 && PathFinder.func_82565_a(this.field_82640_a, var4, var5 + 1, var6, var19, false, false, true) == 1 && PathFinder.func_82565_a(this.field_82640_a, var17, var5 + 1, var18, var19, false, false, true) == 1) {
            var2.func_70683_ar().func_75660_a();
         }
      }

      if(!var1.field_71075_bZ.field_75098_d && this.field_82639_c >= this.field_82638_b * 0.5F && this.field_82640_a.func_70681_au().nextFloat() < 0.0060F && !this.field_82636_d) {
         ItemStack var24 = var1.func_70694_bm();
         if(var24 != null && var24.field_77993_c == Item.field_82793_bR.field_77779_bT) {
            var24.func_77972_a(1, var1);
            if(var24.field_77994_a == 0) {
               ItemStack var25 = new ItemStack(Item.field_77749_aR);
               var25.func_77982_d(var24.field_77990_d);
               var1.field_71071_by.field_70462_a[var1.field_71071_by.field_70461_c] = var25;
            }
         }
      }

      this.field_82640_a.func_70612_e(0.0F, var7);
   }

   private boolean func_98216_b(int p_98216_1_) {
      return Block.field_71973_m[p_98216_1_] != null && (Block.field_71973_m[p_98216_1_].func_71857_b() == 10 || Block.field_71973_m[p_98216_1_] instanceof BlockHalfSlab);
   }

   public boolean func_82634_f() {
      return this.field_82636_d;
   }

   public void func_82632_g() {
      this.field_82636_d = true;
      this.field_82637_e = 0;
      this.field_82635_f = this.field_82640_a.func_70681_au().nextInt(841) + 140;
   }

   public boolean func_82633_h() {
      return !this.func_82634_f() && this.field_82639_c > this.field_82638_b * 0.3F;
   }
}
