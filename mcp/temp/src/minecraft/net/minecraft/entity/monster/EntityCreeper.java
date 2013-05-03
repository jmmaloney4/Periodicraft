package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCreeper extends EntityMob {

   private int field_70834_e;
   private int field_70833_d;
   private int field_82225_f = 30;
   private int field_82226_g = 3;


   public EntityCreeper(World p_i3547_1_) {
      super(p_i3547_1_);
      this.field_70750_az = "/mob/creeper.png";
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAICreeperSwell(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
      this.field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, 0.25F, false));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.2F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, false));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_82143_as() {
      return this.func_70638_az() == null?3:3 + (this.field_70734_aK - 1);
   }

   protected void func_70069_a(float p_70069_1_) {
      super.func_70069_a(p_70069_1_);
      this.field_70833_d = (int)((float)this.field_70833_d + p_70069_1_ * 1.5F);
      if(this.field_70833_d > this.field_82225_f - 5) {
         this.field_70833_d = this.field_82225_f - 5;
      }

   }

   public int func_70667_aM() {
      return 20;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)-1));
      this.field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      if(this.field_70180_af.func_75683_a(17) == 1) {
         p_70014_1_.func_74757_a("powered", true);
      }

      p_70014_1_.func_74777_a("Fuse", (short)this.field_82225_f);
      p_70014_1_.func_74774_a("ExplosionRadius", (byte)this.field_82226_g);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70037_1_.func_74767_n("powered")?1:0)));
      if(p_70037_1_.func_74764_b("Fuse")) {
         this.field_82225_f = p_70037_1_.func_74765_d("Fuse");
      }

      if(p_70037_1_.func_74764_b("ExplosionRadius")) {
         this.field_82226_g = p_70037_1_.func_74771_c("ExplosionRadius");
      }

   }

   public void func_70071_h_() {
      if(this.func_70089_S()) {
         this.field_70834_e = this.field_70833_d;
         int var1 = this.func_70832_p();
         if(var1 > 0 && this.field_70833_d == 0) {
            this.func_85030_a("random.fuse", 1.0F, 0.5F);
         }

         this.field_70833_d += var1;
         if(this.field_70833_d < 0) {
            this.field_70833_d = 0;
         }

         if(this.field_70833_d >= this.field_82225_f) {
            this.field_70833_d = this.field_82225_f;
            if(!this.field_70170_p.field_72995_K) {
               boolean var2 = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
               if(this.func_70830_n()) {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)(this.field_82226_g * 2), var2);
               } else {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_82226_g, var2);
               }

               this.func_70106_y();
            }
         }
      }

      super.func_70071_h_();
   }

   protected String func_70621_aR() {
      return "mob.creeper.say";
   }

   protected String func_70673_aS() {
      return "mob.creeper.death";
   }

   public void func_70645_a(DamageSource p_70645_1_) {
      super.func_70645_a(p_70645_1_);
      if(p_70645_1_.func_76346_g() instanceof EntitySkeleton) {
         int var2 = Item.field_77819_bI.field_77779_bT + this.field_70146_Z.nextInt(Item.field_85180_cf.field_77779_bT - Item.field_77819_bI.field_77779_bT + 1);
         this.func_70025_b(var2, 1);
      }

   }

   public boolean func_70652_k(Entity p_70652_1_) {
      return true;
   }

   public boolean func_70830_n() {
      return this.field_70180_af.func_75683_a(17) == 1;
   }

   @SideOnly(Side.CLIENT)
   public float func_70831_j(float p_70831_1_) {
      return ((float)this.field_70834_e + (float)(this.field_70833_d - this.field_70834_e) * p_70831_1_) / (float)(this.field_82225_f - 2);
   }

   protected int func_70633_aT() {
      return Item.field_77677_M.field_77779_bT;
   }

   public int func_70832_p() {
      return this.field_70180_af.func_75683_a(16);
   }

   public void func_70829_a(int p_70829_1_) {
      this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)p_70829_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      super.func_70077_a(p_70077_1_);
      this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)1));
   }
}
