package net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

public class EntityPig extends EntityAnimal {

   private final EntityAIControlledByPlayer field_82184_d;


   public EntityPig(World p_i3520_1_) {
      super(p_i3520_1_);
      this.field_70750_az = "/mob/pig.png";
      this.func_70105_a(0.9F, 0.9F);
      this.func_70661_as().func_75491_a(true);
      float var2 = 0.25F;
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
      this.field_70714_bg.func_75776_a(2, this.field_82184_d = new EntityAIControlledByPlayer(this, 0.34F));
      this.field_70714_bg.func_75776_a(3, new EntityAIMate(this, var2));
      this.field_70714_bg.func_75776_a(4, new EntityAITempt(this, 0.3F, Item.field_82793_bR.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(4, new EntityAITempt(this, 0.3F, Item.field_82797_bK.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(5, new EntityAIFollowParent(this, 0.28F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, var2));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 10;
   }

   protected void func_70619_bc() {
      super.func_70619_bc();
   }

   public boolean func_82171_bF() {
      ItemStack var1 = ((EntityPlayer)this.field_70153_n).func_70694_bm();
      return var1 != null && var1.field_77993_c == Item.field_82793_bR.field_77779_bT;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74757_a("Saddle", this.func_70901_n());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70900_e(p_70037_1_.func_74767_n("Saddle"));
   }

   protected String func_70639_aQ() {
      return "mob.pig.say";
   }

   protected String func_70621_aR() {
      return "mob.pig.say";
   }

   protected String func_70673_aS() {
      return "mob.pig.death";
   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.func_85030_a("mob.pig.step", 0.15F, 1.0F);
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(super.func_70085_c(p_70085_1_)) {
         return true;
      } else if(this.func_70901_n() && !this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == p_70085_1_)) {
         p_70085_1_.func_70078_a(this);
         return true;
      } else {
         return false;
      }
   }

   protected int func_70633_aT() {
      return this.func_70027_ad()?Item.field_77782_ar.field_77779_bT:Item.field_77784_aq.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + p_70628_2_);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(this.func_70027_ad()) {
            this.func_70025_b(Item.field_77782_ar.field_77779_bT, 1);
         } else {
            this.func_70025_b(Item.field_77784_aq.field_77779_bT, 1);
         }
      }

      if(this.func_70901_n()) {
         this.func_70025_b(Item.field_77765_aA.field_77779_bT, 1);
      }

   }

   public boolean func_70901_n() {
      return (this.field_70180_af.func_75683_a(16) & 1) != 0;
   }

   public void func_70900_e(boolean p_70900_1_) {
      if(p_70900_1_) {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)1));
      } else {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)0));
      }

   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      if(!this.field_70170_p.field_72995_K) {
         EntityPigZombie var2 = new EntityPigZombie(this.field_70170_p);
         var2.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
         this.field_70170_p.func_72838_d(var2);
         this.func_70106_y();
      }
   }

   protected void func_70069_a(float p_70069_1_) {
      super.func_70069_a(p_70069_1_);
      if(p_70069_1_ > 5.0F && this.field_70153_n instanceof EntityPlayer) {
         ((EntityPlayer)this.field_70153_n).func_71029_a(AchievementList.field_76021_u);
      }

   }

   public EntityPig func_70879_a(EntityAgeable p_70879_1_) {
      return new EntityPig(this.field_70170_p);
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.field_77993_c == Item.field_82797_bK.field_77779_bT;
   }

   public EntityAIControlledByPlayer func_82183_n() {
      return this.field_82184_d;
   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_70879_a(p_90011_1_);
   }
}
