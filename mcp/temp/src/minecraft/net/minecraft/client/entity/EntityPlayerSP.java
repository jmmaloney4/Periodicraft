package net.minecraft.client.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovementInput;
import net.minecraft.util.Session;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityPlayerSP extends EntityPlayer {

   public MovementInput field_71158_b;
   protected Minecraft field_71159_c;
   protected int field_71156_d = 0;
   public int field_71157_e = 0;
   public float field_71154_f;
   public float field_71155_g;
   public float field_71163_h;
   public float field_71164_i;
   private MouseFilter field_71162_ch = new MouseFilter();
   private MouseFilter field_71160_ci = new MouseFilter();
   private MouseFilter field_71161_cj = new MouseFilter();
   public float field_71086_bY;
   public float field_71080_cy;


   public EntityPlayerSP(Minecraft p_i3116_1_, World p_i3116_2_, Session p_i3116_3_, int p_i3116_4_) {
      super(p_i3116_2_);
      this.field_71159_c = p_i3116_1_;
      this.field_71093_bK = p_i3116_4_;
      if(p_i3116_3_ != null && p_i3116_3_.field_74286_b != null && p_i3116_3_.field_74286_b.length() > 0) {
         this.field_70120_cr = "http://skins.minecraft.net/MinecraftSkins/" + StringUtils.func_76338_a(p_i3116_3_.field_74286_b) + ".png";
      }

      this.field_71092_bJ = p_i3116_3_.field_74286_b;
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      super.func_70091_d(p_70091_1_, p_70091_3_, p_70091_5_);
   }

   public void func_70626_be() {
      super.func_70626_be();
      this.field_70702_br = this.field_71158_b.field_78902_a;
      this.field_70701_bs = this.field_71158_b.field_78900_b;
      this.field_70703_bu = this.field_71158_b.field_78901_c;
      this.field_71163_h = this.field_71154_f;
      this.field_71164_i = this.field_71155_g;
      this.field_71155_g = (float)((double)this.field_71155_g + (double)(this.field_70125_A - this.field_71155_g) * 0.5D);
      this.field_71154_f = (float)((double)this.field_71154_f + (double)(this.field_70177_z - this.field_71154_f) * 0.5D);
   }

   protected boolean func_70613_aW() {
      return true;
   }

   public void func_70636_d() {
      if(this.field_71157_e > 0) {
         --this.field_71157_e;
         if(this.field_71157_e == 0) {
            this.func_70031_b(false);
         }
      }

      if(this.field_71156_d > 0) {
         --this.field_71156_d;
      }

      if(this.field_71159_c.field_71442_b.func_78747_a()) {
         this.field_70165_t = this.field_70161_v = 0.5D;
         this.field_70165_t = 0.0D;
         this.field_70161_v = 0.0D;
         this.field_70177_z = (float)this.field_70173_aa / 12.0F;
         this.field_70125_A = 10.0F;
         this.field_70163_u = 68.5D;
      } else {
         if(!this.field_71159_c.field_71413_E.func_77443_a(AchievementList.field_76004_f)) {
            this.field_71159_c.field_71458_u.func_73848_b(AchievementList.field_76004_f);
         }

         this.field_71080_cy = this.field_71086_bY;
         if(this.field_71087_bX) {
            if(this.field_71159_c.field_71462_r != null) {
               this.field_71159_c.func_71373_a((GuiScreen)null);
            }

            if(this.field_71086_bY == 0.0F) {
               this.field_71159_c.field_71416_A.func_77366_a("portal.trigger", 1.0F, this.field_70146_Z.nextFloat() * 0.4F + 0.8F);
            }

            this.field_71086_bY += 0.0125F;
            if(this.field_71086_bY >= 1.0F) {
               this.field_71086_bY = 1.0F;
            }

            this.field_71087_bX = false;
         } else if(this.func_70644_a(Potion.field_76431_k) && this.func_70660_b(Potion.field_76431_k).func_76459_b() > 60) {
            this.field_71086_bY += 0.006666667F;
            if(this.field_71086_bY > 1.0F) {
               this.field_71086_bY = 1.0F;
            }
         } else {
            if(this.field_71086_bY > 0.0F) {
               this.field_71086_bY -= 0.05F;
            }

            if(this.field_71086_bY < 0.0F) {
               this.field_71086_bY = 0.0F;
            }
         }

         if(this.field_71088_bW > 0) {
            --this.field_71088_bW;
         }

         boolean var1 = this.field_71158_b.field_78901_c;
         float var2 = 0.8F;
         boolean var3 = this.field_71158_b.field_78900_b >= var2;
         this.field_71158_b.func_78898_a();
         if(this.func_71039_bw()) {
            this.field_71158_b.field_78902_a *= 0.2F;
            this.field_71158_b.field_78900_b *= 0.2F;
            this.field_71156_d = 0;
         }

         if(this.field_71158_b.field_78899_d && this.field_70139_V < 0.2F) {
            this.field_70139_V = 0.2F;
         }

         this.func_70048_i(this.field_70165_t - (double)this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v + (double)this.field_70130_N * 0.35D);
         this.func_70048_i(this.field_70165_t - (double)this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v - (double)this.field_70130_N * 0.35D);
         this.func_70048_i(this.field_70165_t + (double)this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v - (double)this.field_70130_N * 0.35D);
         this.func_70048_i(this.field_70165_t + (double)this.field_70130_N * 0.35D, this.field_70121_D.field_72338_b + 0.5D, this.field_70161_v + (double)this.field_70130_N * 0.35D);
         boolean var4 = (float)this.func_71024_bL().func_75116_a() > 6.0F || this.field_71075_bZ.field_75101_c;
         if(this.field_70122_E && !var3 && this.field_71158_b.field_78900_b >= var2 && !this.func_70051_ag() && var4 && !this.func_71039_bw() && !this.func_70644_a(Potion.field_76440_q)) {
            if(this.field_71156_d == 0) {
               this.field_71156_d = 7;
            } else {
               this.func_70031_b(true);
               this.field_71156_d = 0;
            }
         }

         if(this.func_70093_af()) {
            this.field_71156_d = 0;
         }

         if(this.func_70051_ag() && (this.field_71158_b.field_78900_b < var2 || this.field_70123_F || !var4)) {
            this.func_70031_b(false);
         }

         if(this.field_71075_bZ.field_75101_c && !var1 && this.field_71158_b.field_78901_c) {
            if(this.field_71101_bC == 0) {
               this.field_71101_bC = 7;
            } else {
               this.field_71075_bZ.field_75100_b = !this.field_71075_bZ.field_75100_b;
               this.func_71016_p();
               this.field_71101_bC = 0;
            }
         }

         if(this.field_71075_bZ.field_75100_b) {
            if(this.field_71158_b.field_78899_d) {
               this.field_70181_x -= 0.15D;
            }

            if(this.field_71158_b.field_78901_c) {
               this.field_70181_x += 0.15D;
            }
         }

         super.func_70636_d();
         if(this.field_70122_E && this.field_71075_bZ.field_75100_b) {
            this.field_71075_bZ.field_75100_b = false;
            this.func_71016_p();
         }

      }
   }

   public float func_71151_f() {
      float var1 = 1.0F;
      if(this.field_71075_bZ.field_75100_b) {
         var1 *= 1.1F;
      }

      var1 *= (this.field_70746_aG * this.func_70616_bs() / this.field_71108_cd + 1.0F) / 2.0F;
      if(this.func_71039_bw() && this.func_71011_bu().field_77993_c == Item.field_77707_k.field_77779_bT) {
         int var2 = this.func_71057_bx();
         float var3 = (float)var2 / 20.0F;
         if(var3 > 1.0F) {
            var3 = 1.0F;
         } else {
            var3 *= var3;
         }

         var1 *= 1.0F - var3 * 0.15F;
      }

      return var1;
   }

   public void func_70059_ac() {
      this.field_70119_cs = "http://skins.minecraft.net/MinecraftCloaks/" + StringUtils.func_76338_a(this.field_71092_bJ) + ".png";
   }

   public void func_71053_j() {
      super.func_71053_j();
      this.field_71159_c.func_71373_a((GuiScreen)null);
   }

   public void func_71014_a(TileEntity p_71014_1_) {
      if(p_71014_1_ instanceof TileEntitySign) {
         this.field_71159_c.func_71373_a(new GuiEditSign((TileEntitySign)p_71014_1_));
      } else if(p_71014_1_ instanceof TileEntityCommandBlock) {
         this.field_71159_c.func_71373_a(new GuiCommandBlock((TileEntityCommandBlock)p_71014_1_));
      }

   }

   public void func_71048_c(ItemStack p_71048_1_) {
      Item var2 = p_71048_1_.func_77973_b();
      if(var2 == Item.field_77823_bG) {
         this.field_71159_c.func_71373_a(new GuiScreenBook(this, p_71048_1_, false));
      } else if(var2 == Item.field_77821_bF) {
         this.field_71159_c.func_71373_a(new GuiScreenBook(this, p_71048_1_, true));
      }

   }

   public void func_71007_a(IInventory p_71007_1_) {
      this.field_71159_c.func_71373_a(new GuiChest(this.field_71071_by, p_71007_1_));
   }

   public void func_94064_a(TileEntityHopper p_94064_1_) {
      this.field_71159_c.func_71373_a(new GuiHopper(this.field_71071_by, p_94064_1_));
   }

   public void func_96125_a(EntityMinecartHopper p_96125_1_) {
      this.field_71159_c.func_71373_a(new GuiHopper(this.field_71071_by, p_96125_1_));
   }

   public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
      this.field_71159_c.func_71373_a(new GuiCrafting(this.field_71071_by, this.field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_));
   }

   public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
      this.field_71159_c.func_71373_a(new GuiEnchantment(this.field_71071_by, this.field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_));
   }

   public void func_82244_d(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
      this.field_71159_c.func_71373_a(new GuiRepair(this.field_71071_by, this.field_70170_p, p_82244_1_, p_82244_2_, p_82244_3_));
   }

   public void func_71042_a(TileEntityFurnace p_71042_1_) {
      this.field_71159_c.func_71373_a(new GuiFurnace(this.field_71071_by, p_71042_1_));
   }

   public void func_71017_a(TileEntityBrewingStand p_71017_1_) {
      this.field_71159_c.func_71373_a(new GuiBrewingStand(this.field_71071_by, p_71017_1_));
   }

   public void func_82240_a(TileEntityBeacon p_82240_1_) {
      this.field_71159_c.func_71373_a(new GuiBeacon(this.field_71071_by, p_82240_1_));
   }

   public void func_71006_a(TileEntityDispenser p_71006_1_) {
      this.field_71159_c.func_71373_a(new GuiDispenser(this.field_71071_by, p_71006_1_));
   }

   public void func_71030_a(IMerchant p_71030_1_, String p_71030_2_) {
      this.field_71159_c.func_71373_a(new GuiMerchant(this.field_71071_by, p_71030_1_, this.field_70170_p, p_71030_2_));
   }

   public void func_71009_b(Entity p_71009_1_) {
      this.field_71159_c.field_71452_i.func_78873_a(new EntityCrit2FX(this.field_71159_c.field_71441_e, p_71009_1_));
   }

   public void func_71047_c(Entity p_71047_1_) {
      EntityCrit2FX var2 = new EntityCrit2FX(this.field_71159_c.field_71441_e, p_71047_1_, "magicCrit");
      this.field_71159_c.field_71452_i.func_78873_a(var2);
   }

   public void func_71001_a(Entity p_71001_1_, int p_71001_2_) {
      this.field_71159_c.field_71452_i.func_78873_a(new EntityPickupFX(this.field_71159_c.field_71441_e, p_71001_1_, this, -0.5F));
   }

   public boolean func_70093_af() {
      return this.field_71158_b.field_78899_d && !this.field_71083_bS;
   }

   public void func_71150_b(int p_71150_1_) {
      int var2 = this.func_70630_aN() - p_71150_1_;
      if(var2 <= 0) {
         this.func_70606_j(p_71150_1_);
         if(var2 < 0) {
            this.field_70172_ad = this.field_70771_an / 2;
         }
      } else {
         this.field_70707_bp = var2;
         this.func_70606_j(this.func_70630_aN());
         this.field_70172_ad = this.field_70771_an;
         this.func_70665_d(DamageSource.field_76377_j, var2);
         this.field_70737_aN = this.field_70738_aO = 10;
      }

   }

   public void func_71035_c(String p_71035_1_) {
      this.field_71159_c.field_71456_v.func_73827_b().func_73757_a(p_71035_1_, new Object[0]);
   }

   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
      if(p_71064_1_ != null) {
         if(p_71064_1_.func_75967_d()) {
            Achievement var3 = (Achievement)p_71064_1_;
            if(var3.field_75992_c == null || this.field_71159_c.field_71413_E.func_77443_a(var3.field_75992_c)) {
               if(!this.field_71159_c.field_71413_E.func_77443_a(var3)) {
                  this.field_71159_c.field_71458_u.func_73846_a(var3);
               }

               this.field_71159_c.field_71413_E.func_77450_a(p_71064_1_, p_71064_2_);
            }
         } else {
            this.field_71159_c.field_71413_E.func_77450_a(p_71064_1_, p_71064_2_);
         }

      }
   }

   private boolean func_71153_f(int p_71153_1_, int p_71153_2_, int p_71153_3_) {
      return this.field_70170_p.func_72809_s(p_71153_1_, p_71153_2_, p_71153_3_);
   }

   protected boolean func_70048_i(double p_70048_1_, double p_70048_3_, double p_70048_5_) {
      int var7 = MathHelper.func_76128_c(p_70048_1_);
      int var8 = MathHelper.func_76128_c(p_70048_3_);
      int var9 = MathHelper.func_76128_c(p_70048_5_);
      double var10 = p_70048_1_ - (double)var7;
      double var12 = p_70048_5_ - (double)var9;
      if(this.func_71153_f(var7, var8, var9) || this.func_71153_f(var7, var8 + 1, var9)) {
         boolean var14 = !this.func_71153_f(var7 - 1, var8, var9) && !this.func_71153_f(var7 - 1, var8 + 1, var9);
         boolean var15 = !this.func_71153_f(var7 + 1, var8, var9) && !this.func_71153_f(var7 + 1, var8 + 1, var9);
         boolean var16 = !this.func_71153_f(var7, var8, var9 - 1) && !this.func_71153_f(var7, var8 + 1, var9 - 1);
         boolean var17 = !this.func_71153_f(var7, var8, var9 + 1) && !this.func_71153_f(var7, var8 + 1, var9 + 1);
         byte var18 = -1;
         double var19 = 9999.0D;
         if(var14 && var10 < var19) {
            var19 = var10;
            var18 = 0;
         }

         if(var15 && 1.0D - var10 < var19) {
            var19 = 1.0D - var10;
            var18 = 1;
         }

         if(var16 && var12 < var19) {
            var19 = var12;
            var18 = 4;
         }

         if(var17 && 1.0D - var12 < var19) {
            var19 = 1.0D - var12;
            var18 = 5;
         }

         float var21 = 0.1F;
         if(var18 == 0) {
            this.field_70159_w = (double)(-var21);
         }

         if(var18 == 1) {
            this.field_70159_w = (double)var21;
         }

         if(var18 == 4) {
            this.field_70179_y = (double)(-var21);
         }

         if(var18 == 5) {
            this.field_70179_y = (double)var21;
         }
      }

      return false;
   }

   public void func_70031_b(boolean p_70031_1_) {
      super.func_70031_b(p_70031_1_);
      this.field_71157_e = p_70031_1_?600:0;
   }

   public void func_71152_a(float p_71152_1_, int p_71152_2_, int p_71152_3_) {
      this.field_71106_cc = p_71152_1_;
      this.field_71067_cb = p_71152_2_;
      this.field_71068_ca = p_71152_3_;
   }

   public void func_70006_a(String p_70006_1_) {
      this.field_71159_c.field_71456_v.func_73827_b().func_73765_a(p_70006_1_);
   }

   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
      return p_70003_1_ <= 0;
   }

   public ChunkCoordinates func_82114_b() {
      return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t + 0.5D), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v + 0.5D));
   }

   public ItemStack func_70694_bm() {
      return this.field_71071_by.func_70448_g();
   }

   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
      this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u - (double)this.field_70129_M, this.field_70161_v, p_85030_1_, p_85030_2_, p_85030_3_, false);
   }
}
