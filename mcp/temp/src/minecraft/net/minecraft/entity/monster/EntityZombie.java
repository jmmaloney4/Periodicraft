package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZombie extends EntityMob {

   private int field_82234_d = 0;


   public EntityZombie(World p_i3558_1_) {
      super(p_i3558_1_);
      this.field_70750_az = "/mob/zombie.png";
      this.field_70697_bw = 0.23F;
      this.func_70661_as().func_75498_b(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIBreakDoor(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.field_70697_bw, false));
      this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.field_70697_bw, true));
      this.field_70714_bg.func_75776_a(4, new EntityAIMoveTwardsRestriction(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, this.field_70697_bw, false));
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
   }

   protected int func_96121_ay() {
      return 40;
   }

   public float func_70616_bs() {
      return super.func_70616_bs() * (this.func_70631_g_()?1.5F:1.0F);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.func_70096_w().func_75682_a(12, Byte.valueOf((byte)0));
      this.func_70096_w().func_75682_a(13, Byte.valueOf((byte)0));
      this.func_70096_w().func_75682_a(14, Byte.valueOf((byte)0));
   }

   @SideOnly(Side.CLIENT)
   public String func_70073_O() {
      return this.func_82231_m()?"/mob/zombie_villager.png":"/mob/zombie.png";
   }

   public int func_70667_aM() {
      return 20;
   }

   public int func_70658_aO() {
      int var1 = super.func_70658_aO() + 2;
      if(var1 > 20) {
         var1 = 20;
      }

      return var1;
   }

   protected boolean func_70650_aV() {
      return true;
   }

   public boolean func_70631_g_() {
      return this.func_70096_w().func_75683_a(12) == 1;
   }

   public void func_82227_f(boolean p_82227_1_) {
      this.func_70096_w().func_75692_b(12, Byte.valueOf((byte)1));
   }

   public boolean func_82231_m() {
      return this.func_70096_w().func_75683_a(13) == 1;
   }

   public void func_82229_g(boolean p_82229_1_) {
      this.func_70096_w().func_75692_b(13, Byte.valueOf((byte)(p_82229_1_?1:0)));
   }

   public void func_70636_d() {
      if(this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && !this.func_70631_g_()) {
         float var1 = this.func_70013_c(1.0F);
         if(var1 > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) {
            boolean var2 = true;
            ItemStack var3 = this.func_71124_b(4);
            if(var3 != null) {
               if(var3.func_77984_f()) {
                  var3.func_77964_b(var3.func_77952_i() + this.field_70146_Z.nextInt(2));
                  if(var3.func_77952_i() >= var3.func_77958_k()) {
                     this.func_70669_a(var3);
                     this.func_70062_b(4, (ItemStack)null);
                  }
               }

               var2 = false;
            }

            if(var2) {
               this.func_70015_d(8);
            }
         }
      }

      super.func_70636_d();
   }

   public void func_70071_h_() {
      if(!this.field_70170_p.field_72995_K && this.func_82230_o()) {
         int var1 = this.func_82233_q();
         this.field_82234_d -= var1;
         if(this.field_82234_d <= 0) {
            this.func_82232_p();
         }
      }

      super.func_70071_h_();
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      boolean var2 = super.func_70652_k(p_70652_1_);
      if(var2 && this.func_70694_bm() == null && this.func_70027_ad() && this.field_70146_Z.nextFloat() < (float)this.field_70170_p.field_73013_u * 0.3F) {
         p_70652_1_.func_70015_d(2 * this.field_70170_p.field_73013_u);
      }

      return var2;
   }

   public int func_82193_c(Entity p_82193_1_) {
      ItemStack var2 = this.func_70694_bm();
      float var3 = (float)(this.func_70667_aM() - this.func_70630_aN()) / (float)this.func_70667_aM();
      int var4 = 3 + MathHelper.func_76141_d(var3 * 4.0F);
      if(var2 != null) {
         var4 += var2.func_77971_a(this);
      }

      return var4;
   }

   protected String func_70639_aQ() {
      return "mob.zombie.say";
   }

   protected String func_70621_aR() {
      return "mob.zombie.hurt";
   }

   protected String func_70673_aS() {
      return "mob.zombie.death";
   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.func_85030_a("mob.zombie.step", 0.15F, 1.0F);
   }

   protected int func_70633_aT() {
      return Item.field_77737_bm.field_77779_bT;
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   protected void func_70600_l(int p_70600_1_) {
      switch(this.field_70146_Z.nextInt(3)) {
      case 0:
         this.func_70025_b(Item.field_77703_o.field_77779_bT, 1);
         break;
      case 1:
         this.func_70025_b(Item.field_82797_bK.field_77779_bT, 1);
         break;
      case 2:
         this.func_70025_b(Item.field_82794_bL.field_77779_bT, 1);
      }

   }

   protected void func_82164_bB() {
      super.func_82164_bB();
      if(this.field_70146_Z.nextFloat() < (this.field_70170_p.field_73013_u == 3?0.05F:0.01F)) {
         int var1 = this.field_70146_Z.nextInt(3);
         if(var1 == 0) {
            this.func_70062_b(0, new ItemStack(Item.field_77716_q));
         } else {
            this.func_70062_b(0, new ItemStack(Item.field_77695_f));
         }
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      if(this.func_70631_g_()) {
         p_70014_1_.func_74757_a("IsBaby", true);
      }

      if(this.func_82231_m()) {
         p_70014_1_.func_74757_a("IsVillager", true);
      }

      p_70014_1_.func_74768_a("ConversionTime", this.func_82230_o()?this.field_82234_d:-1);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_74767_n("IsBaby")) {
         this.func_82227_f(true);
      }

      if(p_70037_1_.func_74767_n("IsVillager")) {
         this.func_82229_g(true);
      }

      if(p_70037_1_.func_74764_b("ConversionTime") && p_70037_1_.func_74762_e("ConversionTime") > -1) {
         this.func_82228_a(p_70037_1_.func_74762_e("ConversionTime"));
      }

   }

   public void func_70074_a(EntityLiving p_70074_1_) {
      super.func_70074_a(p_70074_1_);
      if(this.field_70170_p.field_73013_u >= 2 && p_70074_1_ instanceof EntityVillager) {
         if(this.field_70170_p.field_73013_u == 2 && this.field_70146_Z.nextBoolean()) {
            return;
         }

         EntityZombie var2 = new EntityZombie(this.field_70170_p);
         var2.func_82149_j(p_70074_1_);
         this.field_70170_p.func_72900_e(p_70074_1_);
         var2.func_82163_bD();
         var2.func_82229_g(true);
         if(p_70074_1_.func_70631_g_()) {
            var2.func_82227_f(true);
         }

         this.field_70170_p.func_72838_d(var2);
         this.field_70170_p.func_72889_a((EntityPlayer)null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
      }

   }

   public void func_82163_bD() {
      this.func_98053_h(this.field_70146_Z.nextFloat() < field_82181_as[this.field_70170_p.field_73013_u]);
      if(this.field_70170_p.field_73012_v.nextFloat() < 0.05F) {
         this.func_82229_g(true);
      }

      this.func_82164_bB();
      this.func_82162_bC();
      if(this.func_71124_b(4) == null) {
         Calendar var1 = this.field_70170_p.func_83015_S();
         if(var1.get(2) + 1 == 10 && var1.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
            this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F?Block.field_72008_bf:Block.field_72061_ba));
            this.field_82174_bp[4] = 0.0F;
         }
      }

   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.func_71045_bC();
      if(var2 != null && var2.func_77973_b() == Item.field_77778_at && var2.func_77960_j() == 0 && this.func_82231_m() && this.func_70644_a(Potion.field_76437_t)) {
         if(!p_70085_1_.field_71075_bZ.field_75098_d) {
            --var2.field_77994_a;
         }

         if(var2.field_77994_a <= 0) {
            p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
         }

         if(!this.field_70170_p.field_72995_K) {
            this.func_82228_a(this.field_70146_Z.nextInt(2401) + 3600);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void func_82228_a(int p_82228_1_) {
      this.field_82234_d = p_82228_1_;
      this.func_70096_w().func_75692_b(14, Byte.valueOf((byte)1));
      this.func_82170_o(Potion.field_76437_t.field_76415_H);
      this.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, p_82228_1_, Math.min(this.field_70170_p.field_73013_u - 1, 0)));
      this.field_70170_p.func_72960_a(this, (byte)16);
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 16) {
         this.field_70170_p.func_72980_b(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "mob.zombie.remedy", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F, false);
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public boolean func_82230_o() {
      return this.func_70096_w().func_75683_a(14) == 1;
   }

   protected void func_82232_p() {
      EntityVillager var1 = new EntityVillager(this.field_70170_p);
      var1.func_82149_j(this);
      var1.func_82163_bD();
      var1.func_82187_q();
      if(this.func_70631_g_()) {
         var1.func_70873_a(-24000);
      }

      this.field_70170_p.func_72900_e(this);
      this.field_70170_p.func_72838_d(var1);
      var1.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 200, 0));
      this.field_70170_p.func_72889_a((EntityPlayer)null, 1017, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
   }

   protected int func_82233_q() {
      int var1 = 1;
      if(this.field_70146_Z.nextFloat() < 0.01F) {
         int var2 = 0;

         for(int var3 = (int)this.field_70165_t - 4; var3 < (int)this.field_70165_t + 4 && var2 < 14; ++var3) {
            for(int var4 = (int)this.field_70163_u - 4; var4 < (int)this.field_70163_u + 4 && var2 < 14; ++var4) {
               for(int var5 = (int)this.field_70161_v - 4; var5 < (int)this.field_70161_v + 4 && var2 < 14; ++var5) {
                  int var6 = this.field_70170_p.func_72798_a(var3, var4, var5);
                  if(var6 == Block.field_72002_bp.field_71990_ca || var6 == Block.field_71959_S.field_71990_ca) {
                     if(this.field_70146_Z.nextFloat() < 0.3F) {
                        ++var1;
                     }

                     ++var2;
                  }
               }
            }
         }
      }

      return var1;
   }
}
