package net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityChicken extends EntityAnimal {

   public boolean field_70885_d = false;
   public float field_70886_e = 0.0F;
   public float field_70883_f = 0.0F;
   public float field_70884_g;
   public float field_70888_h;
   public float field_70889_i = 1.0F;
   public int field_70887_j;


   public EntityChicken(World p_i3515_1_) {
      super(p_i3515_1_);
      this.field_70750_az = "/mob/chicken.png";
      this.func_70105_a(0.3F, 0.7F);
      this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
      float var2 = 0.25F;
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
      this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, var2));
      this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77690_S.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.28F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, var2));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 4;
   }

   public void func_70636_d() {
      super.func_70636_d();
      this.field_70888_h = this.field_70886_e;
      this.field_70884_g = this.field_70883_f;
      this.field_70883_f = (float)((double)this.field_70883_f + (double)(this.field_70122_E?-1:4) * 0.3D);
      if(this.field_70883_f < 0.0F) {
         this.field_70883_f = 0.0F;
      }

      if(this.field_70883_f > 1.0F) {
         this.field_70883_f = 1.0F;
      }

      if(!this.field_70122_E && this.field_70889_i < 1.0F) {
         this.field_70889_i = 1.0F;
      }

      this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);
      if(!this.field_70122_E && this.field_70181_x < 0.0D) {
         this.field_70181_x *= 0.6D;
      }

      this.field_70886_e += this.field_70889_i * 2.0F;
      if(!this.func_70631_g_() && !this.field_70170_p.field_72995_K && --this.field_70887_j <= 0) {
         this.func_85030_a("mob.chicken.plop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         this.func_70025_b(Item.field_77764_aP.field_77779_bT, 1);
         this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
      }

   }

   protected void func_70069_a(float p_70069_1_) {}

   protected String func_70639_aQ() {
      return "mob.chicken.say";
   }

   protected String func_70621_aR() {
      return "mob.chicken.hurt";
   }

   protected String func_70673_aS() {
      return "mob.chicken.hurt";
   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.func_85030_a("mob.chicken.step", 0.15F, 1.0F);
   }

   protected int func_70633_aT() {
      return Item.field_77676_L.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77676_L.field_77779_bT, 1);
      }

      if(this.func_70027_ad()) {
         this.func_70025_b(Item.field_77736_bl.field_77779_bT, 1);
      } else {
         this.func_70025_b(Item.field_77735_bk.field_77779_bT, 1);
      }

   }

   public EntityChicken func_70879_a(EntityAgeable p_70879_1_) {
      return new EntityChicken(this.field_70170_p);
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.func_77973_b() instanceof ItemSeeds;
   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_70879_a(p_90011_1_);
   }
}
