package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;

@SideOnly(Side.CLIENT)
public class RenderZombie extends RenderBiped {

   private ModelBiped field_82434_o;
   private ModelZombieVillager field_82432_p;
   protected ModelBiped field_82437_k;
   protected ModelBiped field_82435_l;
   protected ModelBiped field_82436_m;
   protected ModelBiped field_82433_n;
   private int field_82431_q = 1;


   public RenderZombie() {
      super(new ModelZombie(), 0.5F, 1.0F);
      this.field_82434_o = this.field_77071_a;
      this.field_82432_p = new ModelZombieVillager();
   }

   protected void func_82421_b() {
      this.field_82423_g = new ModelZombie(1.0F, true);
      this.field_82425_h = new ModelZombie(0.5F, true);
      this.field_82437_k = this.field_82423_g;
      this.field_82435_l = this.field_82425_h;
      this.field_82436_m = new ModelZombieVillager(1.0F, 0.0F, true);
      this.field_82433_n = new ModelZombieVillager(0.5F, 0.0F, true);
   }

   protected int func_82429_a(EntityZombie p_82429_1_, int p_82429_2_, float p_82429_3_) {
      this.func_82427_a(p_82429_1_);
      return super.func_77032_a(p_82429_1_, p_82429_2_, p_82429_3_);
   }

   public void func_82426_a(EntityZombie p_82426_1_, double p_82426_2_, double p_82426_4_, double p_82426_6_, float p_82426_8_, float p_82426_9_) {
      this.func_82427_a(p_82426_1_);
      super.func_77031_a(p_82426_1_, p_82426_2_, p_82426_4_, p_82426_6_, p_82426_8_, p_82426_9_);
   }

   protected void func_82428_a(EntityZombie p_82428_1_, float p_82428_2_) {
      this.func_82427_a(p_82428_1_);
      super.func_77029_c(p_82428_1_, p_82428_2_);
   }

   private void func_82427_a(EntityZombie p_82427_1_) {
      if(p_82427_1_.func_82231_m()) {
         if(this.field_82431_q != this.field_82432_p.func_82897_a()) {
            this.field_82432_p = new ModelZombieVillager();
            this.field_82431_q = this.field_82432_p.func_82897_a();
            this.field_82436_m = new ModelZombieVillager(1.0F, 0.0F, true);
            this.field_82433_n = new ModelZombieVillager(0.5F, 0.0F, true);
         }

         this.field_77045_g = this.field_82432_p;
         this.field_82423_g = this.field_82436_m;
         this.field_82425_h = this.field_82433_n;
      } else {
         this.field_77045_g = this.field_82434_o;
         this.field_82423_g = this.field_82437_k;
         this.field_82425_h = this.field_82435_l;
      }

      this.field_77071_a = (ModelBiped)this.field_77045_g;
   }

   protected void func_82430_a(EntityZombie p_82430_1_, float p_82430_2_, float p_82430_3_, float p_82430_4_) {
      if(p_82430_1_.func_82230_o()) {
         p_82430_3_ += (float)(Math.cos((double)p_82430_1_.field_70173_aa * 3.25D) * 3.141592653589793D * 0.25D);
      }

      super.func_77043_a(p_82430_1_, p_82430_2_, p_82430_3_, p_82430_4_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_82428_a((EntityZombie)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_82426_a((EntityZombie)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_82429_a((EntityZombie)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_82430_a((EntityZombie)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82426_a((EntityZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
