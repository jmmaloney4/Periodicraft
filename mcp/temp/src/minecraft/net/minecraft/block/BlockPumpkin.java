package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPumpkin extends BlockDirectional {

   private boolean field_72218_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94474_b;
   @SideOnly(Side.CLIENT)
   private Icon field_94475_c;


   protected BlockPumpkin(int p_i9081_1_, boolean p_i9081_2_) {
      super(p_i9081_1_, Material.field_76266_z);
      this.func_71907_b(true);
      this.field_72218_a = p_i9081_2_;
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94474_b:(p_71858_1_ == 0?this.field_94474_b:(p_71858_2_ == 2 && p_71858_1_ == 2?this.field_94475_c:(p_71858_2_ == 3 && p_71858_1_ == 5?this.field_94475_c:(p_71858_2_ == 0 && p_71858_1_ == 3?this.field_94475_c:(p_71858_2_ == 1 && p_71858_1_ == 4?this.field_94475_c:this.field_94336_cN)))));
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) == Block.field_72039_aU.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 2, p_71861_4_) == Block.field_72039_aU.field_71990_ca) {
         if(!p_71861_1_.field_72995_K) {
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_, p_71861_4_, 0, 0, 2);
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0, 0, 2);
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0, 0, 2);
            EntitySnowman var9 = new EntitySnowman(p_71861_1_);
            var9.func_70012_b((double)p_71861_2_ + 0.5D, (double)p_71861_3_ - 1.95D, (double)p_71861_4_ + 0.5D, 0.0F, 0.0F);
            p_71861_1_.func_72838_d(var9);
            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_, p_71861_4_, 0);
            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
         }

         for(int var10 = 0; var10 < 120; ++var10) {
            p_71861_1_.func_72869_a("snowshovel", (double)p_71861_2_ + p_71861_1_.field_73012_v.nextDouble(), (double)(p_71861_3_ - 2) + p_71861_1_.field_73012_v.nextDouble() * 2.5D, (double)p_71861_4_ + p_71861_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
         }
      } else if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 2, p_71861_4_) == Block.field_72083_ai.field_71990_ca) {
         boolean var5 = p_71861_1_.func_72798_a(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_) == Block.field_72083_ai.field_71990_ca;
         boolean var6 = p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1) == Block.field_72083_ai.field_71990_ca && p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1) == Block.field_72083_ai.field_71990_ca;
         if(var5 || var6) {
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_, p_71861_4_, 0, 0, 2);
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0, 0, 2);
            p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0, 0, 2);
            if(var5) {
               p_71861_1_.func_72832_d(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_, 0, 0, 2);
               p_71861_1_.func_72832_d(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_, 0, 0, 2);
            } else {
               p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1, 0, 0, 2);
               p_71861_1_.func_72832_d(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1, 0, 0, 2);
            }

            EntityIronGolem var7 = new EntityIronGolem(p_71861_1_);
            var7.func_70849_f(true);
            var7.func_70012_b((double)p_71861_2_ + 0.5D, (double)p_71861_3_ - 1.95D, (double)p_71861_4_ + 0.5D, 0.0F, 0.0F);
            p_71861_1_.func_72838_d(var7);

            for(int var8 = 0; var8 < 120; ++var8) {
               p_71861_1_.func_72869_a("snowballpoof", (double)p_71861_2_ + p_71861_1_.field_73012_v.nextDouble(), (double)(p_71861_3_ - 2) + p_71861_1_.field_73012_v.nextDouble() * 3.9D, (double)p_71861_4_ + p_71861_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_, p_71861_4_, 0);
            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_, 0);
            p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 2, p_71861_4_, 0);
            if(var5) {
               p_71861_1_.func_72851_f(p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_, 0);
               p_71861_1_.func_72851_f(p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_, 0);
            } else {
               p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1, 0);
               p_71861_1_.func_72851_f(p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1, 0);
            }
         }
      }

   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      int var5 = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_, p_71930_4_);
      return (var5 == 0 || Block.field_71973_m[var5].field_72018_cp.func_76222_j()) && p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 2.5D) & 3;
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94475_c = p_94332_1_.func_94245_a(this.field_72218_a?"pumpkin_jack":"pumpkin_face");
      this.field_94474_b = p_94332_1_.func_94245_a("pumpkin_top");
      this.field_94336_cN = p_94332_1_.func_94245_a("pumpkin_side");
   }
}
