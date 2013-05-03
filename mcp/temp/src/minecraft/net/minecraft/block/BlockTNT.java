package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTNT extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94393_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94392_b;


   public BlockTNT(int p_i9095_1_) {
      super(p_i9095_1_, Material.field_76262_s);
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 0?this.field_94392_b:(p_71858_1_ == 1?this.field_94393_a:this.field_94336_cN);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      if(p_71861_1_.func_72864_z(p_71861_2_, p_71861_3_, p_71861_4_)) {
         this.func_71898_d(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, 1);
         p_71861_1_.func_94571_i(p_71861_2_, p_71861_3_, p_71861_4_);
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_)) {
         this.func_71898_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, 1);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   public void func_71867_k(World p_71867_1_, int p_71867_2_, int p_71867_3_, int p_71867_4_, Explosion p_71867_5_) {
      if(!p_71867_1_.field_72995_K) {
         EntityTNTPrimed var6 = new EntityTNTPrimed(p_71867_1_, (double)((float)p_71867_2_ + 0.5F), (double)((float)p_71867_3_ + 0.5F), (double)((float)p_71867_4_ + 0.5F), p_71867_5_.func_94613_c());
         var6.field_70516_a = p_71867_1_.field_73012_v.nextInt(var6.field_70516_a / 4) + var6.field_70516_a / 8;
         p_71867_1_.func_72838_d(var6);
      }
   }

   public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_) {
      this.func_94391_a(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_, (EntityLiving)null);
   }

   public void func_94391_a(World p_94391_1_, int p_94391_2_, int p_94391_3_, int p_94391_4_, int p_94391_5_, EntityLiving p_94391_6_) {
      if(!p_94391_1_.field_72995_K) {
         if((p_94391_5_ & 1) == 1) {
            EntityTNTPrimed var7 = new EntityTNTPrimed(p_94391_1_, (double)((float)p_94391_2_ + 0.5F), (double)((float)p_94391_3_ + 0.5F), (double)((float)p_94391_4_ + 0.5F), p_94391_6_);
            p_94391_1_.func_72838_d(var7);
            p_94391_1_.func_72956_a(var7, "random.fuse", 1.0F, 1.0F);
         }

      }
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_5_.func_71045_bC() != null && p_71903_5_.func_71045_bC().field_77993_c == Item.field_77709_i.field_77779_bT) {
         this.func_94391_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, 1, p_71903_5_);
         p_71903_1_.func_94571_i(p_71903_2_, p_71903_3_, p_71903_4_);
         return true;
      } else {
         return super.func_71903_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_, p_71903_6_, p_71903_7_, p_71903_8_, p_71903_9_);
      }
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      if(p_71869_5_ instanceof EntityArrow && !p_71869_1_.field_72995_K) {
         EntityArrow var6 = (EntityArrow)p_71869_5_;
         if(var6.func_70027_ad()) {
            this.func_94391_a(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_, 1, var6.field_70250_c instanceof EntityLiving?(EntityLiving)var6.field_70250_c:null);
            p_71869_1_.func_94571_i(p_71869_2_, p_71869_3_, p_71869_4_);
         }
      }

   }

   public boolean func_85103_a(Explosion p_85103_1_) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("tnt_side");
      this.field_94393_a = p_94332_1_.func_94245_a("tnt_top");
      this.field_94392_b = p_94332_1_.func_94245_a("tnt_bottom");
   }
}
