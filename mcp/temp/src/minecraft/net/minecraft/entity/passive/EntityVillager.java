package net.minecraft.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityVillager extends EntityAgeable implements INpc, IMerchant {

   private int field_70955_e;
   private boolean field_70952_f;
   private boolean field_70953_g;
   Village field_70954_d;
   private EntityPlayer field_70962_h;
   private MerchantRecipeList field_70963_i;
   private int field_70961_j;
   private boolean field_70959_by;
   private int field_70956_bz;
   private String field_82189_bL;
   private boolean field_82190_bM;
   private float field_82191_bN;
   public static final Map field_70958_bB = new HashMap();
   public static final Map field_70960_bC = new HashMap();


   public EntityVillager(World p_i3560_1_) {
      this(p_i3560_1_, 0);
   }

   public EntityVillager(World p_i3561_1_, int p_i3561_2_) {
      super(p_i3561_1_);
      this.field_70955_e = 0;
      this.field_70952_f = false;
      this.field_70953_g = false;
      this.field_70954_d = null;
      this.func_70938_b(p_i3561_2_);
      this.field_70750_az = "/mob/villager/villager.png";
      this.field_70697_bw = 0.5F;
      this.func_70105_a(0.6F, 1.8F);
      this.func_70661_as().func_75498_b(true);
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
      this.field_70714_bg.func_75776_a(1, new EntityAITradePlayer(this));
      this.field_70714_bg.func_75776_a(1, new EntityAILookAtTradePlayer(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIMoveIndoors(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIRestrictOpenDoor(this));
      this.field_70714_bg.func_75776_a(4, new EntityAIOpenDoor(this, true));
      this.field_70714_bg.func_75776_a(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
      this.field_70714_bg.func_75776_a(6, new EntityAIVillagerMate(this));
      this.field_70714_bg.func_75776_a(7, new EntityAIFollowGolem(this));
      this.field_70714_bg.func_75776_a(8, new EntityAIPlay(this, 0.32F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
      this.field_70714_bg.func_75776_a(9, new EntityAIWander(this, 0.3F));
      this.field_70714_bg.func_75776_a(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
   }

   public boolean func_70650_aV() {
      return true;
   }

   protected void func_70629_bd() {
      if(--this.field_70955_e <= 0) {
         this.field_70170_p.field_72982_D.func_75551_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
         this.field_70955_e = 70 + this.field_70146_Z.nextInt(50);
         this.field_70954_d = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
         if(this.field_70954_d == null) {
            this.func_70677_aE();
         } else {
            ChunkCoordinates var1 = this.field_70954_d.func_75577_a();
            this.func_70598_b(var1.field_71574_a, var1.field_71572_b, var1.field_71573_c, (int)((float)this.field_70954_d.func_75568_b() * 0.6F));
            if(this.field_82190_bM) {
               this.field_82190_bM = false;
               this.field_70954_d.func_82683_b(5);
            }
         }
      }

      if(!this.func_70940_q() && this.field_70961_j > 0) {
         --this.field_70961_j;
         if(this.field_70961_j <= 0) {
            if(this.field_70959_by) {
               if(this.field_70963_i.size() > 1) {
                  Iterator var3 = this.field_70963_i.iterator();

                  while(var3.hasNext()) {
                     MerchantRecipe var2 = (MerchantRecipe)var3.next();
                     if(var2.func_82784_g()) {
                        var2.func_82783_a(this.field_70146_Z.nextInt(6) + this.field_70146_Z.nextInt(6) + 2);
                     }
                  }
               }

               this.func_70950_c(1);
               this.field_70959_by = false;
               if(this.field_70954_d != null && this.field_82189_bL != null) {
                  this.field_70170_p.func_72960_a(this, (byte)14);
                  this.field_70954_d.func_82688_a(this.field_82189_bL, 1);
               }
            }

            this.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
         }
      }

      super.func_70629_bd();
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      boolean var3 = var2 != null && var2.field_77993_c == Item.field_77815_bC.field_77779_bT;
      if(!var3 && this.func_70089_S() && !this.func_70940_q() && !this.func_70631_g_()) {
         if(!this.field_70170_p.field_72995_K) {
            this.func_70932_a_(p_70085_1_);
            p_70085_1_.func_71030_a(this, this.func_94057_bL());
         }

         return true;
      } else {
         return super.func_70085_c(p_70085_1_);
      }
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, Integer.valueOf(0));
   }

   public int func_70667_aM() {
      return 20;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("Profession", this.func_70946_n());
      p_70014_1_.func_74768_a("Riches", this.field_70956_bz);
      if(this.field_70963_i != null) {
         p_70014_1_.func_74766_a("Offers", this.field_70963_i.func_77202_a());
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70938_b(p_70037_1_.func_74762_e("Profession"));
      this.field_70956_bz = p_70037_1_.func_74762_e("Riches");
      if(p_70037_1_.func_74764_b("Offers")) {
         NBTTagCompound var2 = p_70037_1_.func_74775_l("Offers");
         this.field_70963_i = new MerchantRecipeList(var2);
      }

   }

   @SideOnly(Side.CLIENT)
   public String func_70073_O() {
      switch(this.func_70946_n()) {
      case 0:
         return "/mob/villager/farmer.png";
      case 1:
         return "/mob/villager/librarian.png";
      case 2:
         return "/mob/villager/priest.png";
      case 3:
         return "/mob/villager/smith.png";
      case 4:
         return "/mob/villager/butcher.png";
      default:
         return super.func_70073_O();
      }
   }

   protected boolean func_70692_ba() {
      return false;
   }

   protected String func_70639_aQ() {
      return "mob.villager.default";
   }

   protected String func_70621_aR() {
      return "mob.villager.defaulthurt";
   }

   protected String func_70673_aS() {
      return "mob.villager.defaultdeath";
   }

   public void func_70938_b(int p_70938_1_) {
      this.field_70180_af.func_75692_b(16, Integer.valueOf(p_70938_1_));
   }

   public int func_70946_n() {
      return this.field_70180_af.func_75679_c(16);
   }

   public boolean func_70941_o() {
      return this.field_70952_f;
   }

   public void func_70947_e(boolean p_70947_1_) {
      this.field_70952_f = p_70947_1_;
   }

   public void func_70939_f(boolean p_70939_1_) {
      this.field_70953_g = p_70939_1_;
   }

   public boolean func_70945_p() {
      return this.field_70953_g;
   }

   public void func_70604_c(EntityLiving p_70604_1_) {
      super.func_70604_c(p_70604_1_);
      if(this.field_70954_d != null && p_70604_1_ != null) {
         this.field_70954_d.func_75575_a(p_70604_1_);
         if(p_70604_1_ instanceof EntityPlayer) {
            byte var2 = -1;
            if(this.func_70631_g_()) {
               var2 = -3;
            }

            this.field_70954_d.func_82688_a(((EntityPlayer)p_70604_1_).func_70005_c_(), var2);
            if(this.func_70089_S()) {
               this.field_70170_p.func_72960_a(this, (byte)13);
            }
         }
      }

   }

   public void func_70645_a(DamageSource p_70645_1_) {
      if(this.field_70954_d != null) {
         Entity var2 = p_70645_1_.func_76346_g();
         if(var2 != null) {
            if(var2 instanceof EntityPlayer) {
               this.field_70954_d.func_82688_a(((EntityPlayer)var2).func_70005_c_(), -2);
            } else if(var2 instanceof IMob) {
               this.field_70954_d.func_82692_h();
            }
         } else if(var2 == null) {
            EntityPlayer var3 = this.field_70170_p.func_72890_a(this, 16.0D);
            if(var3 != null) {
               this.field_70954_d.func_82692_h();
            }
         }
      }

      super.func_70645_a(p_70645_1_);
   }

   public void func_70932_a_(EntityPlayer p_70932_1_) {
      this.field_70962_h = p_70932_1_;
   }

   public EntityPlayer func_70931_l_() {
      return this.field_70962_h;
   }

   public boolean func_70940_q() {
      return this.field_70962_h != null;
   }

   public void func_70933_a(MerchantRecipe p_70933_1_) {
      p_70933_1_.func_77399_f();
      if(p_70933_1_.func_77393_a((MerchantRecipe)this.field_70963_i.get(this.field_70963_i.size() - 1))) {
         this.field_70961_j = 40;
         this.field_70959_by = true;
         if(this.field_70962_h != null) {
            this.field_82189_bL = this.field_70962_h.func_70005_c_();
         } else {
            this.field_82189_bL = null;
         }
      }

      if(p_70933_1_.func_77394_a().field_77993_c == Item.field_77817_bH.field_77779_bT) {
         this.field_70956_bz += p_70933_1_.func_77394_a().field_77994_a;
      }

   }

   public MerchantRecipeList func_70934_b(EntityPlayer p_70934_1_) {
      if(this.field_70963_i == null) {
         this.func_70950_c(1);
      }

      return this.field_70963_i;
   }

   private float func_82188_j(float p_82188_1_) {
      float var2 = p_82188_1_ + this.field_82191_bN;
      return var2 > 0.9F?0.9F - (var2 - 0.9F):var2;
   }

   private void func_70950_c(int p_70950_1_) {
      if(this.field_70963_i != null) {
         this.field_82191_bN = MathHelper.func_76129_c((float)this.field_70963_i.size()) * 0.2F;
      } else {
         this.field_82191_bN = 0.0F;
      }

      MerchantRecipeList var2;
      var2 = new MerchantRecipeList();
      int var6;
      label50:
      switch(this.func_70946_n()) {
      case 0:
         func_70948_a(var2, Item.field_77685_T.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.9F));
         func_70948_a(var2, Block.field_72101_ab.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70948_a(var2, Item.field_77735_bk.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70948_a(var2, Item.field_77753_aV.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.4F));
         func_70949_b(var2, Item.field_77684_U.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.9F));
         func_70949_b(var2, Item.field_77738_bf.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77706_j.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77743_bc.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77745_be.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77709_i.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77736_bl.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77704_l.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         if(this.field_70146_Z.nextFloat() < this.func_82188_j(0.5F)) {
            var2.add(new MerchantRecipe(new ItemStack(Block.field_71940_F, 10), new ItemStack(Item.field_77817_bH), new ItemStack(Item.field_77804_ap.field_77779_bT, 4 + this.field_70146_Z.nextInt(2), 0)));
         }
         break;
      case 1:
         func_70948_a(var2, Item.field_77759_aK.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.8F));
         func_70948_a(var2, Item.field_77760_aL.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.8F));
         func_70948_a(var2, Item.field_77823_bG.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Block.field_72093_an.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.8F));
         func_70949_b(var2, Block.field_71946_M.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77750_aQ.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77752_aS.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         if(this.field_70146_Z.nextFloat() < this.func_82188_j(0.07F)) {
            Enchantment var8 = Enchantment.field_92090_c[this.field_70146_Z.nextInt(Enchantment.field_92090_c.length)];
            int var10 = MathHelper.func_76136_a(this.field_70146_Z, var8.func_77319_d(), var8.func_77325_b());
            ItemStack var11 = Item.field_92105_bW.func_92111_a(new EnchantmentData(var8, var10));
            var6 = 2 + this.field_70146_Z.nextInt(5 + var10 * 10) + 3 * var10;
            var2.add(new MerchantRecipe(new ItemStack(Item.field_77760_aL), new ItemStack(Item.field_77817_bH, var6), var11));
         }
         break;
      case 2:
         func_70949_b(var2, Item.field_77748_bA.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77809_bD.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77767_aC.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.4F));
         func_70949_b(var2, Block.field_72014_bd.field_71990_ca, this.field_70146_Z, this.func_82188_j(0.3F));
         int[] var3 = new int[]{Item.field_77716_q.field_77779_bT, Item.field_77718_z.field_77779_bT, Item.field_77822_ae.field_77779_bT, Item.field_77798_ai.field_77779_bT, Item.field_77708_h.field_77779_bT, Item.field_77675_C.field_77779_bT, Item.field_77696_g.field_77779_bT, Item.field_77674_B.field_77779_bT};
         int[] var4 = var3;
         int var5 = var3.length;
         var6 = 0;

         while(true) {
            if(var6 >= var5) {
               break label50;
            }

            int var7 = var4[var6];
            if(this.field_70146_Z.nextFloat() < this.func_82188_j(0.05F)) {
               var2.add(new MerchantRecipe(new ItemStack(var7, 1, 0), new ItemStack(Item.field_77817_bH, 2 + this.field_70146_Z.nextInt(3), 0), EnchantmentHelper.func_77504_a(this.field_70146_Z, new ItemStack(var7, 1, 0), 5 + this.field_70146_Z.nextInt(15))));
            }

            ++var6;
         }
      case 3:
         func_70948_a(var2, Item.field_77705_m.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.7F));
         func_70948_a(var2, Item.field_77703_o.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70948_a(var2, Item.field_77717_p.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70948_a(var2, Item.field_77702_n.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77716_q.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77718_z.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77708_h.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77675_C.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77696_g.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77674_B.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77695_f.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77673_A.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77689_P.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77688_Q.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77818_ag.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77794_ak.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77812_ad.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77820_ah.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77822_ae.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77798_ai.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77824_af.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77800_aj.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.2F));
         func_70949_b(var2, Item.field_77810_ac.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1F));
         func_70949_b(var2, Item.field_77694_Z.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1F));
         func_70949_b(var2, Item.field_77814_aa.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1F));
         func_70949_b(var2, Item.field_77816_ab.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1F));
         break;
      case 4:
         func_70948_a(var2, Item.field_77705_m.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.7F));
         func_70948_a(var2, Item.field_77784_aq.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70948_a(var2, Item.field_77741_bi.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.5F));
         func_70949_b(var2, Item.field_77765_aA.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.1F));
         func_70949_b(var2, Item.field_77686_W.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77692_Y.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77687_V.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77693_X.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77782_ar.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
         func_70949_b(var2, Item.field_77734_bj.field_77779_bT, this.field_70146_Z, this.func_82188_j(0.3F));
      }

      if(var2.isEmpty()) {
         func_70948_a(var2, Item.field_77717_p.field_77779_bT, this.field_70146_Z, 1.0F);
      }

      Collections.shuffle(var2);
      if(this.field_70963_i == null) {
         this.field_70963_i = new MerchantRecipeList();
      }

      for(int var9 = 0; var9 < p_70950_1_ && var9 < var2.size(); ++var9) {
         this.field_70963_i.func_77205_a((MerchantRecipe)var2.get(var9));
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_70930_a(MerchantRecipeList p_70930_1_) {}

   public static void func_70948_a(MerchantRecipeList p_70948_0_, int p_70948_1_, Random p_70948_2_, float p_70948_3_) {
      if(p_70948_2_.nextFloat() < p_70948_3_) {
         p_70948_0_.add(new MerchantRecipe(func_70951_a(p_70948_1_, p_70948_2_), Item.field_77817_bH));
      }

   }

   private static ItemStack func_70951_a(int p_70951_0_, Random p_70951_1_) {
      return new ItemStack(p_70951_0_, func_70944_b(p_70951_0_, p_70951_1_), 0);
   }

   private static int func_70944_b(int p_70944_0_, Random p_70944_1_) {
      Tuple var2 = (Tuple)field_70958_bB.get(Integer.valueOf(p_70944_0_));
      return var2 == null?1:(((Integer)var2.func_76341_a()).intValue() >= ((Integer)var2.func_76340_b()).intValue()?((Integer)var2.func_76341_a()).intValue():((Integer)var2.func_76341_a()).intValue() + p_70944_1_.nextInt(((Integer)var2.func_76340_b()).intValue() - ((Integer)var2.func_76341_a()).intValue()));
   }

   public static void func_70949_b(MerchantRecipeList p_70949_0_, int p_70949_1_, Random p_70949_2_, float p_70949_3_) {
      if(p_70949_2_.nextFloat() < p_70949_3_) {
         int var4 = func_70943_c(p_70949_1_, p_70949_2_);
         ItemStack var5;
         ItemStack var6;
         if(var4 < 0) {
            var5 = new ItemStack(Item.field_77817_bH.field_77779_bT, 1, 0);
            var6 = new ItemStack(p_70949_1_, -var4, 0);
         } else {
            var5 = new ItemStack(Item.field_77817_bH.field_77779_bT, var4, 0);
            var6 = new ItemStack(p_70949_1_, 1, 0);
         }

         p_70949_0_.add(new MerchantRecipe(var5, var6));
      }

   }

   private static int func_70943_c(int p_70943_0_, Random p_70943_1_) {
      Tuple var2 = (Tuple)field_70960_bC.get(Integer.valueOf(p_70943_0_));
      return var2 == null?1:(((Integer)var2.func_76341_a()).intValue() >= ((Integer)var2.func_76340_b()).intValue()?((Integer)var2.func_76341_a()).intValue():((Integer)var2.func_76341_a()).intValue() + p_70943_1_.nextInt(((Integer)var2.func_76340_b()).intValue() - ((Integer)var2.func_76341_a()).intValue()));
   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 12) {
         this.func_70942_a("heart");
      } else if(p_70103_1_ == 13) {
         this.func_70942_a("angryVillager");
      } else if(p_70103_1_ == 14) {
         this.func_70942_a("happyVillager");
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   @SideOnly(Side.CLIENT)
   private void func_70942_a(String p_70942_1_) {
      for(int var2 = 0; var2 < 5; ++var2) {
         double var3 = this.field_70146_Z.nextGaussian() * 0.02D;
         double var5 = this.field_70146_Z.nextGaussian() * 0.02D;
         double var7 = this.field_70146_Z.nextGaussian() * 0.02D;
         this.field_70170_p.func_72869_a(p_70942_1_, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 1.0D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var3, var5, var7);
      }

   }

   public void func_82163_bD() {
      this.func_70938_b(this.field_70170_p.field_73012_v.nextInt(5));
   }

   public void func_82187_q() {
      this.field_82190_bM = true;
   }

   public EntityVillager func_90012_b(EntityAgeable p_90012_1_) {
      EntityVillager var2 = new EntityVillager(this.field_70170_p);
      var2.func_82163_bD();
      return var2;
   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_90012_b(p_90011_1_);
   }

   static {
      field_70958_bB.put(Integer.valueOf(Item.field_77705_m.field_77779_bT), new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
      field_70958_bB.put(Integer.valueOf(Item.field_77703_o.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
      field_70958_bB.put(Integer.valueOf(Item.field_77717_p.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
      field_70958_bB.put(Integer.valueOf(Item.field_77702_n.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
      field_70958_bB.put(Integer.valueOf(Item.field_77759_aK.field_77779_bT), new Tuple(Integer.valueOf(24), Integer.valueOf(36)));
      field_70958_bB.put(Integer.valueOf(Item.field_77760_aL.field_77779_bT), new Tuple(Integer.valueOf(11), Integer.valueOf(13)));
      field_70958_bB.put(Integer.valueOf(Item.field_77823_bG.field_77779_bT), new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
      field_70958_bB.put(Integer.valueOf(Item.field_77730_bn.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
      field_70958_bB.put(Integer.valueOf(Item.field_77748_bA.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
      field_70958_bB.put(Integer.valueOf(Item.field_77784_aq.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
      field_70958_bB.put(Integer.valueOf(Item.field_77741_bi.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
      field_70958_bB.put(Integer.valueOf(Item.field_77735_bk.field_77779_bT), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
      field_70958_bB.put(Integer.valueOf(Item.field_77753_aV.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
      field_70958_bB.put(Integer.valueOf(Item.field_77690_S.field_77779_bT), new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
      field_70958_bB.put(Integer.valueOf(Item.field_77740_bh.field_77779_bT), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
      field_70958_bB.put(Integer.valueOf(Item.field_77739_bg.field_77779_bT), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
      field_70958_bB.put(Integer.valueOf(Item.field_77685_T.field_77779_bT), new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
      field_70958_bB.put(Integer.valueOf(Block.field_72101_ab.field_71990_ca), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
      field_70958_bB.put(Integer.valueOf(Item.field_77737_bm.field_77779_bT), new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
      field_70960_bC.put(Integer.valueOf(Item.field_77709_i.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77745_be.field_77779_bT), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77716_q.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
      field_70960_bC.put(Integer.valueOf(Item.field_77718_z.field_77779_bT), new Tuple(Integer.valueOf(12), Integer.valueOf(14)));
      field_70960_bC.put(Integer.valueOf(Item.field_77708_h.field_77779_bT), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77675_C.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(12)));
      field_70960_bC.put(Integer.valueOf(Item.field_77696_g.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(9)));
      field_70960_bC.put(Integer.valueOf(Item.field_77674_B.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
      field_70960_bC.put(Integer.valueOf(Item.field_77695_f.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
      field_70960_bC.put(Integer.valueOf(Item.field_77673_A.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77689_P.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
      field_70960_bC.put(Integer.valueOf(Item.field_77688_Q.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77818_ag.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
      field_70960_bC.put(Integer.valueOf(Item.field_77794_ak.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77812_ad.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
      field_70960_bC.put(Integer.valueOf(Item.field_77820_ah.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77822_ae.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(14)));
      field_70960_bC.put(Integer.valueOf(Item.field_77798_ai.field_77779_bT), new Tuple(Integer.valueOf(16), Integer.valueOf(19)));
      field_70960_bC.put(Integer.valueOf(Item.field_77824_af.field_77779_bT), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
      field_70960_bC.put(Integer.valueOf(Item.field_77800_aj.field_77779_bT), new Tuple(Integer.valueOf(11), Integer.valueOf(14)));
      field_70960_bC.put(Integer.valueOf(Item.field_77810_ac.field_77779_bT), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
      field_70960_bC.put(Integer.valueOf(Item.field_77694_Z.field_77779_bT), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
      field_70960_bC.put(Integer.valueOf(Item.field_77814_aa.field_77779_bT), new Tuple(Integer.valueOf(11), Integer.valueOf(15)));
      field_70960_bC.put(Integer.valueOf(Item.field_77816_ab.field_77779_bT), new Tuple(Integer.valueOf(9), Integer.valueOf(11)));
      field_70960_bC.put(Integer.valueOf(Item.field_77684_U.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-2)));
      field_70960_bC.put(Integer.valueOf(Item.field_77738_bf.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77706_j.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77743_bc.field_77779_bT), new Tuple(Integer.valueOf(-10), Integer.valueOf(-7)));
      field_70960_bC.put(Integer.valueOf(Block.field_71946_M.field_71990_ca), new Tuple(Integer.valueOf(-5), Integer.valueOf(-3)));
      field_70960_bC.put(Integer.valueOf(Block.field_72093_an.field_71990_ca), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77686_W.field_77779_bT), new Tuple(Integer.valueOf(4), Integer.valueOf(5)));
      field_70960_bC.put(Integer.valueOf(Item.field_77692_Y.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77687_V.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77693_X.field_77779_bT), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
      field_70960_bC.put(Integer.valueOf(Item.field_77765_aA.field_77779_bT), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
      field_70960_bC.put(Integer.valueOf(Item.field_77809_bD.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
      field_70960_bC.put(Integer.valueOf(Item.field_77767_aC.field_77779_bT), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
      field_70960_bC.put(Integer.valueOf(Item.field_77750_aQ.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
      field_70960_bC.put(Integer.valueOf(Item.field_77752_aS.field_77779_bT), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
      field_70960_bC.put(Integer.valueOf(Block.field_72014_bd.field_71990_ca), new Tuple(Integer.valueOf(-3), Integer.valueOf(-1)));
      field_70960_bC.put(Integer.valueOf(Item.field_77782_ar.field_77779_bT), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
      field_70960_bC.put(Integer.valueOf(Item.field_77734_bj.field_77779_bT), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
      field_70960_bC.put(Integer.valueOf(Item.field_77736_bl.field_77779_bT), new Tuple(Integer.valueOf(-8), Integer.valueOf(-6)));
      field_70960_bC.put(Integer.valueOf(Item.field_77748_bA.field_77779_bT), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
      field_70960_bC.put(Integer.valueOf(Item.field_77704_l.field_77779_bT), new Tuple(Integer.valueOf(-12), Integer.valueOf(-8)));
   }
}
