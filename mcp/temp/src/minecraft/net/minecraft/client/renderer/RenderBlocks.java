package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockComparator;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ChestItemRenderHelper;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBlocks {

   public IBlockAccess field_78669_a;
   public Icon field_78664_d = null;
   public boolean field_78666_e = false;
   public boolean field_78661_f = false;
   public static boolean field_78667_b = true;
   public boolean field_78668_c = true;
   public double field_83021_g;
   public double field_83026_h;
   public double field_83027_i;
   public double field_83024_j;
   public double field_83025_k;
   public double field_83022_l;
   public boolean field_83023_m = false;
   public boolean field_98189_n = false;
   public final Minecraft field_94177_n;
   public int field_78662_g = 0;
   public int field_78683_h = 0;
   public int field_78685_i = 0;
   public int field_78679_j = 0;
   public int field_78681_k = 0;
   public int field_78675_l = 0;
   public boolean field_78677_m;
   public float field_78691_u;
   public float field_78689_v;
   public float field_78687_w;
   public float field_78712_x;
   public float field_78710_y;
   public float field_78708_z;
   public float field_78628_A;
   public float field_78629_B;
   public float field_78630_C;
   public float field_78624_D;
   public float field_78625_E;
   public float field_78626_F;
   public float field_78627_G;
   public float field_78634_H;
   public float field_78635_I;
   public float field_78636_J;
   public float field_78637_K;
   public float field_78631_L;
   public float field_78632_M;
   public float field_78633_N;
   public int field_78649_S;
   public int field_78641_T;
   public int field_78639_U;
   public int field_78645_V;
   public int field_78643_W;
   public int field_78657_X;
   public int field_78655_Y;
   public int field_78660_Z;
   public int field_78704_aa;
   public int field_78705_ab;
   public int field_78702_ac;
   public int field_78703_ad;
   public int field_78709_ae;
   public int field_78711_af;
   public int field_78706_ag;
   public int field_78707_ah;
   public int field_78690_ai;
   public int field_78692_aj;
   public int field_78686_ak;
   public int field_78688_al;
   public int field_78700_an;
   public int field_78694_ao;
   public int field_78696_ap;
   public int field_78676_aq;
   public float field_78674_ar;
   public float field_78672_as;
   public float field_78670_at;
   public float field_78684_au;
   public float field_78682_av;
   public float field_78680_aw;
   public float field_78678_ax;
   public float field_78665_ay;
   public float field_78663_az;
   public float field_78650_aA;
   public float field_78651_aB;
   public float field_78652_aC;


   public RenderBlocks(IBlockAccess p_i3187_1_) {
      this.field_78669_a = p_i3187_1_;
      this.field_94177_n = Minecraft.func_71410_x();
   }

   public RenderBlocks() {
      this.field_94177_n = Minecraft.func_71410_x();
   }

   public void func_82774_a(Icon p_82774_1_) {
      this.field_78664_d = p_82774_1_;
   }

   public void func_78595_a() {
      this.field_78664_d = null;
   }

   public boolean func_94167_b() {
      return this.field_78664_d != null;
   }

   public void func_83020_a(double p_83020_1_, double p_83020_3_, double p_83020_5_, double p_83020_7_, double p_83020_9_, double p_83020_11_) {
      if(!this.field_83023_m) {
         this.field_83021_g = p_83020_1_;
         this.field_83026_h = p_83020_7_;
         this.field_83027_i = p_83020_3_;
         this.field_83024_j = p_83020_9_;
         this.field_83025_k = p_83020_5_;
         this.field_83022_l = p_83020_11_;
         this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
      }

   }

   public void func_83018_a(Block p_83018_1_) {
      if(!this.field_83023_m) {
         this.field_83021_g = p_83018_1_.func_83009_v();
         this.field_83026_h = p_83018_1_.func_83007_w();
         this.field_83027_i = p_83018_1_.func_83008_x();
         this.field_83024_j = p_83018_1_.func_83010_y();
         this.field_83025_k = p_83018_1_.func_83005_z();
         this.field_83022_l = p_83018_1_.func_83006_A();
         this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
      }

   }

   public void func_83019_b(double p_83019_1_, double p_83019_3_, double p_83019_5_, double p_83019_7_, double p_83019_9_, double p_83019_11_) {
      this.field_83021_g = p_83019_1_;
      this.field_83026_h = p_83019_7_;
      this.field_83027_i = p_83019_3_;
      this.field_83024_j = p_83019_9_;
      this.field_83025_k = p_83019_5_;
      this.field_83022_l = p_83019_11_;
      this.field_83023_m = true;
      this.field_98189_n = this.field_94177_n.field_71474_y.field_74348_k >= 2 && (this.field_83021_g > 0.0D || this.field_83026_h < 1.0D || this.field_83027_i > 0.0D || this.field_83024_j < 1.0D || this.field_83025_k > 0.0D || this.field_83022_l < 1.0D);
   }

   public void func_83017_b() {
      this.field_83023_m = false;
   }

   public void func_78604_a(Block p_78604_1_, int p_78604_2_, int p_78604_3_, int p_78604_4_, Icon p_78604_5_) {
      this.func_82774_a(p_78604_5_);
      this.func_78612_b(p_78604_1_, p_78604_2_, p_78604_3_, p_78604_4_);
      this.func_78595_a();
   }

   public void func_78583_a(Block p_78583_1_, int p_78583_2_, int p_78583_3_, int p_78583_4_) {
      this.field_78661_f = true;
      this.func_78612_b(p_78583_1_, p_78583_2_, p_78583_3_, p_78583_4_);
      this.field_78661_f = false;
   }

   public boolean func_78612_b(Block p_78612_1_, int p_78612_2_, int p_78612_3_, int p_78612_4_) {
      int var5 = p_78612_1_.func_71857_b();
      if(var5 == -1) {
         return false;
      } else {
         p_78612_1_.func_71902_a(this.field_78669_a, p_78612_2_, p_78612_3_, p_78612_4_);
         this.func_83018_a(p_78612_1_);
         return var5 == 0?this.func_78570_q(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 4?this.func_78621_p(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 31?this.func_78581_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 1?this.func_78620_l(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 2?this.func_78572_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 20?this.func_78598_k(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 11?this.func_78582_a((BlockFence)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 39?this.func_96445_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 5?this.func_78589_i(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 13?this.func_78584_s(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 9?this.func_78586_a((BlockRailBase)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 19?this.func_78603_m(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 23?this.func_78566_o(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 6?this.func_78614_n(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 3?this.func_78590_h((BlockFire)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 8?this.func_78576_j(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 7?this.func_78601_u(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 10?this.func_78565_t((BlockStairs)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 27?this.func_78618_a((BlockDragonEgg)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 32?this.func_82779_a((BlockWall)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 12?this.func_78594_e(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 29?this.func_78577_f(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 30?this.func_78619_g(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 14?this.func_78574_w(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 15?this.func_78610_x((BlockRedstoneRepeater)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 36?this.func_94176_a((BlockRedstoneLogic)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 37?this.func_94171_a((BlockComparator)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 16?this.func_78593_b(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, false):(var5 == 17?this.func_78608_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, true):(var5 == 18?this.func_78592_a((BlockPane)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 21?this.func_78580_a((BlockFenceGate)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 24?this.func_78615_a((BlockCauldron)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 33?this.func_82780_a((BlockFlowerPot)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 35?this.func_82775_a((BlockAnvil)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 25?this.func_78585_a((BlockBrewingStand)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 26?this.func_78567_v((BlockEndPortalFrame)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 28?this.func_78616_a((BlockCocoa)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 34?this.func_82778_a((BlockBeacon)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 38?this.func_94172_a((BlockHopper)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):false))))))))))))))))))))))))))))))))))))));
      }
   }

   public boolean func_78567_v(BlockEndPortalFrame p_78567_1_, int p_78567_2_, int p_78567_3_, int p_78567_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78567_2_, p_78567_3_, p_78567_4_);
      int var6 = var5 & 3;
      if(var6 == 0) {
         this.field_78681_k = 3;
      } else if(var6 == 3) {
         this.field_78681_k = 1;
      } else if(var6 == 1) {
         this.field_78681_k = 2;
      }

      if(!BlockEndPortalFrame.func_72165_e(var5)) {
         this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         this.field_78681_k = 0;
         return true;
      } else {
         this.field_78661_f = true;
         this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         this.func_82774_a(p_78567_1_.func_94398_p());
         this.func_83020_a(0.25D, 0.8125D, 0.25D, 0.75D, 1.0D, 0.75D);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         this.field_78661_f = false;
         this.func_78595_a();
         this.field_78681_k = 0;
         return true;
      }
   }

   public boolean func_78574_w(Block p_78574_1_, int p_78574_2_, int p_78574_3_, int p_78574_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78574_2_, p_78574_3_, p_78574_4_);
      int var7 = BlockBed.func_72217_d(var6);
      boolean var8 = BlockBed.func_72229_a_(var6);
      float var9 = 0.5F;
      float var10 = 1.0F;
      float var11 = 0.8F;
      float var12 = 0.6F;
      int var25 = p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_);
      var5.func_78380_c(var25);
      var5.func_78386_a(var9, var9, var9);
      Icon var27 = this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 0);
      double var28 = (double)var27.func_94209_e();
      double var30 = (double)var27.func_94212_f();
      double var32 = (double)var27.func_94206_g();
      double var34 = (double)var27.func_94210_h();
      double var36 = (double)p_78574_2_ + this.field_83021_g;
      double var38 = (double)p_78574_2_ + this.field_83026_h;
      double var40 = (double)p_78574_3_ + this.field_83027_i + 0.1875D;
      double var42 = (double)p_78574_4_ + this.field_83025_k;
      double var44 = (double)p_78574_4_ + this.field_83022_l;
      var5.func_78374_a(var36, var40, var44, var28, var34);
      var5.func_78374_a(var36, var40, var42, var28, var32);
      var5.func_78374_a(var38, var40, var42, var30, var32);
      var5.func_78374_a(var38, var40, var44, var30, var34);
      var5.func_78380_c(p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_ + 1, p_78574_4_));
      var5.func_78386_a(var10, var10, var10);
      var27 = this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 1);
      var28 = (double)var27.func_94209_e();
      var30 = (double)var27.func_94212_f();
      var32 = (double)var27.func_94206_g();
      var34 = (double)var27.func_94210_h();
      var36 = var28;
      var38 = var30;
      var40 = var32;
      var42 = var32;
      var44 = var28;
      double var46 = var30;
      double var48 = var34;
      double var50 = var34;
      if(var7 == 0) {
         var38 = var28;
         var40 = var34;
         var44 = var30;
         var50 = var32;
      } else if(var7 == 2) {
         var36 = var30;
         var42 = var34;
         var46 = var28;
         var48 = var32;
      } else if(var7 == 3) {
         var36 = var30;
         var42 = var34;
         var46 = var28;
         var48 = var32;
         var38 = var28;
         var40 = var34;
         var44 = var30;
         var50 = var32;
      }

      double var52 = (double)p_78574_2_ + this.field_83021_g;
      double var54 = (double)p_78574_2_ + this.field_83026_h;
      double var56 = (double)p_78574_3_ + this.field_83024_j;
      double var58 = (double)p_78574_4_ + this.field_83025_k;
      double var60 = (double)p_78574_4_ + this.field_83022_l;
      var5.func_78374_a(var54, var56, var60, var44, var48);
      var5.func_78374_a(var54, var56, var58, var36, var40);
      var5.func_78374_a(var52, var56, var58, var38, var42);
      var5.func_78374_a(var52, var56, var60, var46, var50);
      int var62 = Direction.field_71582_c[var7];
      if(var8) {
         var62 = Direction.field_71582_c[Direction.field_71580_e[var7]];
      }

      byte var63 = 4;
      switch(var7) {
      case 0:
         var63 = 5;
         break;
      case 1:
         var63 = 3;
      case 2:
      default:
         break;
      case 3:
         var63 = 2;
      }

      if(var62 != 2 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1, 2))) {
         var5.func_78380_c(this.field_83025_k > 0.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_78666_e = var63 == 2;
         this.func_78611_c(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 2));
      }

      if(var62 != 3 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1, 3))) {
         var5.func_78380_c(this.field_83022_l < 1.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_78666_e = var63 == 3;
         this.func_78622_d(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 3));
      }

      if(var62 != 4 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_, 4))) {
         var5.func_78380_c(this.field_83025_k > 0.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_78666_e = var63 == 4;
         this.func_78573_e(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 4));
      }

      if(var62 != 5 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_, 5))) {
         var5.func_78380_c(this.field_83022_l < 1.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_78666_e = var63 == 5;
         this.func_78605_f(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, this.func_94170_a(p_78574_1_, this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 5));
      }

      this.field_78666_e = false;
      return true;
   }

   public boolean func_78585_a(BlockBrewingStand p_78585_1_, int p_78585_2_, int p_78585_3_, int p_78585_4_) {
      this.func_83020_a(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.875D, 0.5625D);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.func_82774_a(p_78585_1_.func_94448_e());
      this.func_83020_a(0.5625D, 0.0D, 0.3125D, 0.9375D, 0.125D, 0.6875D);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.func_83020_a(0.125D, 0.0D, 0.0625D, 0.5D, 0.125D, 0.4375D);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.func_83020_a(0.125D, 0.0D, 0.5625D, 0.5D, 0.125D, 0.9375D);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.func_78595_a();
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78585_1_.func_71874_e(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_));
      float var6 = 1.0F;
      int var7 = p_78585_1_.func_71920_b(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      Icon var32 = this.func_94165_a(p_78585_1_, 0, 0);
      if(this.func_94167_b()) {
         var32 = this.field_78664_d;
      }

      double var33 = (double)var32.func_94206_g();
      double var14 = (double)var32.func_94210_h();
      int var16 = this.field_78669_a.func_72805_g(p_78585_2_, p_78585_3_, p_78585_4_);

      for(int var17 = 0; var17 < 3; ++var17) {
         double var18 = (double)var17 * 3.141592653589793D * 2.0D / 3.0D + 1.5707963267948966D;
         double var20 = (double)var32.func_94214_a(8.0D);
         double var22 = (double)var32.func_94212_f();
         if((var16 & 1 << var17) != 0) {
            var22 = (double)var32.func_94209_e();
         }

         double var24 = (double)p_78585_2_ + 0.5D;
         double var26 = (double)p_78585_2_ + 0.5D + Math.sin(var18) * 8.0D / 16.0D;
         double var28 = (double)p_78585_4_ + 0.5D;
         double var30 = (double)p_78585_4_ + 0.5D + Math.cos(var18) * 8.0D / 16.0D;
         var5.func_78374_a(var24, (double)(p_78585_3_ + 1), var28, var20, var33);
         var5.func_78374_a(var24, (double)(p_78585_3_ + 0), var28, var20, var14);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 0), var30, var22, var14);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 1), var30, var22, var33);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 1), var30, var22, var33);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 0), var30, var22, var14);
         var5.func_78374_a(var24, (double)(p_78585_3_ + 0), var28, var20, var14);
         var5.func_78374_a(var24, (double)(p_78585_3_ + 1), var28, var20, var33);
      }

      p_78585_1_.func_71919_f();
      return true;
   }

   public boolean func_78615_a(BlockCauldron p_78615_1_, int p_78615_2_, int p_78615_3_, int p_78615_4_) {
      this.func_78570_q(p_78615_1_, p_78615_2_, p_78615_3_, p_78615_4_);
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78615_1_.func_71874_e(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_));
      float var6 = 1.0F;
      int var7 = p_78615_1_.func_71920_b(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      float var12;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      Icon var16 = p_78615_1_.func_71851_a(2);
      var12 = 0.125F;
      this.func_78605_f(p_78615_1_, (double)((float)p_78615_2_ - 1.0F + var12), (double)p_78615_3_, (double)p_78615_4_, var16);
      this.func_78573_e(p_78615_1_, (double)((float)p_78615_2_ + 1.0F - var12), (double)p_78615_3_, (double)p_78615_4_, var16);
      this.func_78622_d(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ - 1.0F + var12), var16);
      this.func_78611_c(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ + 1.0F - var12), var16);
      Icon var17 = BlockCauldron.func_94375_b("cauldron_inner");
      this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + 0.25F), (double)p_78615_4_, var17);
      this.func_78613_a(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ + 1.0F - 0.75F), (double)p_78615_4_, var17);
      int var14 = this.field_78669_a.func_72805_g(p_78615_2_, p_78615_3_, p_78615_4_);
      if(var14 > 0) {
         Icon var15 = BlockFluid.func_94424_b("water");
         if(var14 > 3) {
            var14 = 3;
         }

         this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + (6.0F + (float)var14 * 3.0F) / 16.0F), (double)p_78615_4_, var15);
      }

      return true;
   }

   public boolean func_82780_a(BlockFlowerPot p_82780_1_, int p_82780_2_, int p_82780_3_, int p_82780_4_) {
      this.func_78570_q(p_82780_1_, p_82780_2_, p_82780_3_, p_82780_4_);
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_82780_1_.func_71874_e(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_));
      float var6 = 1.0F;
      int var7 = p_82780_1_.func_71920_b(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_);
      Icon var8 = this.func_94173_a(p_82780_1_, 0);
      float var9 = (float)(var7 >> 16 & 255) / 255.0F;
      float var10 = (float)(var7 >> 8 & 255) / 255.0F;
      float var11 = (float)(var7 & 255) / 255.0F;
      float var12;
      float var14;
      if(EntityRenderer.field_78517_a) {
         var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var5.func_78386_a(var6 * var9, var6 * var10, var6 * var11);
      var12 = 0.1865F;
      this.func_78605_f(p_82780_1_, (double)((float)p_82780_2_ - 0.5F + var12), (double)p_82780_3_, (double)p_82780_4_, var8);
      this.func_78573_e(p_82780_1_, (double)((float)p_82780_2_ + 0.5F - var12), (double)p_82780_3_, (double)p_82780_4_, var8);
      this.func_78622_d(p_82780_1_, (double)p_82780_2_, (double)p_82780_3_, (double)((float)p_82780_4_ - 0.5F + var12), var8);
      this.func_78611_c(p_82780_1_, (double)p_82780_2_, (double)p_82780_3_, (double)((float)p_82780_4_ + 0.5F - var12), var8);
      this.func_78617_b(p_82780_1_, (double)p_82780_2_, (double)((float)p_82780_3_ - 0.5F + var12 + 0.1875F), (double)p_82780_4_, this.func_94175_b(Block.field_71979_v));
      int var19 = this.field_78669_a.func_72805_g(p_82780_2_, p_82780_3_, p_82780_4_);
      if(var19 != 0) {
         var14 = 0.0F;
         float var15 = 4.0F;
         float var16 = 0.0F;
         BlockFlower var17 = null;
         switch(var19) {
         case 1:
            var17 = Block.field_72107_ae;
            break;
         case 2:
            var17 = Block.field_72097_ad;
         case 3:
         case 4:
         case 5:
         case 6:
         default:
            break;
         case 7:
            var17 = Block.field_72103_ag;
            break;
         case 8:
            var17 = Block.field_72109_af;
         }

         var5.func_78372_c(var14 / 16.0F, var15 / 16.0F, var16 / 16.0F);
         if(var17 != null) {
            this.func_78612_b(var17, p_82780_2_, p_82780_3_, p_82780_4_);
         } else if(var19 == 9) {
            this.field_78661_f = true;
            float var18 = 0.125F;
            this.func_83020_a((double)(0.5F - var18), 0.0D, (double)(0.5F - var18), (double)(0.5F + var18), 0.25D, (double)(0.5F + var18));
            this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
            this.func_83020_a((double)(0.5F - var18), 0.25D, (double)(0.5F - var18), (double)(0.5F + var18), 0.5D, (double)(0.5F + var18));
            this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
            this.func_83020_a((double)(0.5F - var18), 0.5D, (double)(0.5F - var18), (double)(0.5F + var18), 0.75D, (double)(0.5F + var18));
            this.func_78570_q(Block.field_72038_aV, p_82780_2_, p_82780_3_, p_82780_4_);
            this.field_78661_f = false;
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var19 == 3) {
            this.func_78599_a(Block.field_71987_y, 0, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         } else if(var19 == 5) {
            this.func_78599_a(Block.field_71987_y, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         } else if(var19 == 4) {
            this.func_78599_a(Block.field_71987_y, 1, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         } else if(var19 == 6) {
            this.func_78599_a(Block.field_71987_y, 3, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         } else if(var19 == 11) {
            var7 = Block.field_71962_X.func_71920_b(this.field_78669_a, p_82780_2_, p_82780_3_, p_82780_4_);
            var9 = (float)(var7 >> 16 & 255) / 255.0F;
            var10 = (float)(var7 >> 8 & 255) / 255.0F;
            var11 = (float)(var7 & 255) / 255.0F;
            var5.func_78386_a(var6 * var9, var6 * var10, var6 * var11);
            this.func_78599_a(Block.field_71962_X, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         } else if(var19 == 10) {
            this.func_78599_a(Block.field_71961_Y, 2, (double)p_82780_2_, (double)p_82780_3_, (double)p_82780_4_, 0.75F);
         }

         var5.func_78372_c(-var14 / 16.0F, -var15 / 16.0F, -var16 / 16.0F);
      }

      return true;
   }

   public boolean func_82775_a(BlockAnvil p_82775_1_, int p_82775_2_, int p_82775_3_, int p_82775_4_) {
      return this.func_85096_a(p_82775_1_, p_82775_2_, p_82775_3_, p_82775_4_, this.field_78669_a.func_72805_g(p_82775_2_, p_82775_3_, p_82775_4_));
   }

   public boolean func_85096_a(BlockAnvil p_85096_1_, int p_85096_2_, int p_85096_3_, int p_85096_4_, int p_85096_5_) {
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_85096_1_.func_71874_e(this.field_78669_a, p_85096_2_, p_85096_3_, p_85096_4_));
      float var7 = 1.0F;
      int var8 = p_85096_1_.func_71920_b(this.field_78669_a, p_85096_2_, p_85096_3_, p_85096_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      return this.func_82776_a(p_85096_1_, p_85096_2_, p_85096_3_, p_85096_4_, p_85096_5_, false);
   }

   public boolean func_82776_a(BlockAnvil p_82776_1_, int p_82776_2_, int p_82776_3_, int p_82776_4_, int p_82776_5_, boolean p_82776_6_) {
      int var7 = p_82776_6_?0:p_82776_5_ & 3;
      boolean var8 = false;
      float var9 = 0.0F;
      switch(var7) {
      case 0:
         this.field_78685_i = 2;
         this.field_78679_j = 1;
         this.field_78681_k = 3;
         this.field_78675_l = 3;
         break;
      case 1:
         this.field_78662_g = 1;
         this.field_78683_h = 2;
         this.field_78681_k = 2;
         this.field_78675_l = 1;
         var8 = true;
         break;
      case 2:
         this.field_78685_i = 1;
         this.field_78679_j = 2;
         break;
      case 3:
         this.field_78662_g = 2;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 2;
         var8 = true;
      }

      var9 = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 0, var9, 0.75F, 0.25F, 0.75F, var8, p_82776_6_, p_82776_5_);
      var9 = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 1, var9, 0.5F, 0.0625F, 0.625F, var8, p_82776_6_, p_82776_5_);
      var9 = this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 2, var9, 0.25F, 0.3125F, 0.5F, var8, p_82776_6_, p_82776_5_);
      this.func_82777_a(p_82776_1_, p_82776_2_, p_82776_3_, p_82776_4_, 3, var9, 0.625F, 0.375F, 1.0F, var8, p_82776_6_, p_82776_5_);
      this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78685_i = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      return true;
   }

   public float func_82777_a(BlockAnvil p_82777_1_, int p_82777_2_, int p_82777_3_, int p_82777_4_, int p_82777_5_, float p_82777_6_, float p_82777_7_, float p_82777_8_, float p_82777_9_, boolean p_82777_10_, boolean p_82777_11_, int p_82777_12_) {
      if(p_82777_10_) {
         float var13 = p_82777_7_;
         p_82777_7_ = p_82777_9_;
         p_82777_9_ = var13;
      }

      p_82777_7_ /= 2.0F;
      p_82777_9_ /= 2.0F;
      p_82777_1_.field_82521_b = p_82777_5_;
      this.func_83020_a((double)(0.5F - p_82777_7_), (double)p_82777_6_, (double)(0.5F - p_82777_9_), (double)(0.5F + p_82777_7_), (double)(p_82777_6_ + p_82777_8_), (double)(0.5F + p_82777_9_));
      if(p_82777_11_) {
         Tessellator var14 = Tessellator.field_78398_a;
         var14.func_78382_b();
         var14.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_78613_a(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 0, p_82777_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 1, p_82777_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 2, p_82777_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 3, p_82777_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 4, p_82777_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_82777_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_82777_1_, 5, p_82777_12_));
         var14.func_78381_a();
      } else {
         this.func_78570_q(p_82777_1_, p_82777_2_, p_82777_3_, p_82777_4_);
      }

      return p_82777_6_ + p_82777_8_;
   }

   public boolean func_78572_c(Block p_78572_1_, int p_78572_2_, int p_78572_3_, int p_78572_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78572_2_, p_78572_3_, p_78572_4_);
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_78572_1_.func_71874_e(this.field_78669_a, p_78572_2_, p_78572_3_, p_78572_4_));
      var6.func_78386_a(1.0F, 1.0F, 1.0F);
      double var7 = 0.4000000059604645D;
      double var9 = 0.5D - var7;
      double var11 = 0.20000000298023224D;
      if(var5 == 1) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_ - var9, (double)p_78572_3_ + var11, (double)p_78572_4_, -var7, 0.0D, 0);
      } else if(var5 == 2) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_ + var9, (double)p_78572_3_ + var11, (double)p_78572_4_, var7, 0.0D, 0);
      } else if(var5 == 3) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + var11, (double)p_78572_4_ - var9, 0.0D, -var7, 0);
      } else if(var5 == 4) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + var11, (double)p_78572_4_ + var9, 0.0D, var7, 0);
      } else {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_, (double)p_78572_4_, 0.0D, 0.0D, 0);
      }

      return true;
   }

   public boolean func_78610_x(BlockRedstoneRepeater p_78610_1_, int p_78610_2_, int p_78610_3_, int p_78610_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78610_2_, p_78610_3_, p_78610_4_);
      int var6 = var5 & 3;
      int var7 = (var5 & 12) >> 2;
      Tessellator var8 = Tessellator.field_78398_a;
      var8.func_78380_c(p_78610_1_.func_71874_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      double var9 = -0.1875D;
      boolean var11 = p_78610_1_.func_94476_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_, var5);
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      switch(var6) {
      case 0:
         var18 = -0.3125D;
         var14 = BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 1:
         var16 = 0.3125D;
         var12 = -BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 2:
         var18 = 0.3125D;
         var14 = -BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 3:
         var16 = -0.3125D;
         var12 = BlockRedstoneRepeater.field_72223_a[var7];
      }

      if(!var11) {
         this.func_78623_a(p_78610_1_, (double)p_78610_2_ + var12, (double)p_78610_3_ + var9, (double)p_78610_4_ + var14, 0.0D, 0.0D, 0);
      } else {
         Icon var20 = this.func_94175_b(Block.field_71986_z);
         this.func_82774_a(var20);
         float var21 = 2.0F;
         float var22 = 14.0F;
         float var23 = 7.0F;
         float var24 = 9.0F;
         switch(var6) {
         case 1:
         case 3:
            var21 = 7.0F;
            var22 = 9.0F;
            var23 = 2.0F;
            var24 = 14.0F;
         case 0:
         case 2:
         default:
            this.func_83020_a((double)(var21 / 16.0F + (float)var12), 0.125D, (double)(var23 / 16.0F + (float)var14), (double)(var22 / 16.0F + (float)var12), 0.25D, (double)(var24 / 16.0F + (float)var14));
            double var25 = (double)var20.func_94214_a((double)var21);
            double var27 = (double)var20.func_94207_b((double)var23);
            double var29 = (double)var20.func_94214_a((double)var22);
            double var31 = (double)var20.func_94207_b((double)var24);
            var8.func_78374_a((double)((float)p_78610_2_ + var21 / 16.0F) + var12, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + var23 / 16.0F) + var14, var25, var27);
            var8.func_78374_a((double)((float)p_78610_2_ + var21 / 16.0F) + var12, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + var24 / 16.0F) + var14, var25, var31);
            var8.func_78374_a((double)((float)p_78610_2_ + var22 / 16.0F) + var12, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + var24 / 16.0F) + var14, var29, var31);
            var8.func_78374_a((double)((float)p_78610_2_ + var22 / 16.0F) + var12, (double)((float)p_78610_3_ + 0.25F), (double)((float)p_78610_4_ + var23 / 16.0F) + var14, var29, var27);
            this.func_78570_q(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
            this.func_78595_a();
         }
      }

      var8.func_78380_c(p_78610_1_.func_71874_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      this.func_78623_a(p_78610_1_, (double)p_78610_2_ + var16, (double)p_78610_3_ + var9, (double)p_78610_4_ + var18, 0.0D, 0.0D, 0);
      this.func_94176_a(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
      return true;
   }

   public boolean func_94171_a(BlockComparator p_94171_1_, int p_94171_2_, int p_94171_3_, int p_94171_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_94171_1_.func_71874_e(this.field_78669_a, p_94171_2_, p_94171_3_, p_94171_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var6 = this.field_78669_a.func_72805_g(p_94171_2_, p_94171_3_, p_94171_4_);
      int var7 = var6 & 3;
      double var8 = 0.0D;
      double var10 = -0.1875D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      Icon var18;
      if(p_94171_1_.func_94490_c(var6)) {
         var18 = Block.field_72035_aQ.func_71851_a(0);
      } else {
         var10 -= 0.1875D;
         var18 = Block.field_72049_aP.func_71851_a(0);
      }

      switch(var7) {
      case 0:
         var12 = -0.3125D;
         var16 = 1.0D;
         break;
      case 1:
         var8 = 0.3125D;
         var14 = -1.0D;
         break;
      case 2:
         var12 = 0.3125D;
         var16 = -1.0D;
         break;
      case 3:
         var8 = -0.3125D;
         var14 = 1.0D;
      }

      this.func_78623_a(p_94171_1_, (double)p_94171_2_ + 0.25D * var14 + 0.1875D * var16, (double)((float)p_94171_3_ - 0.1875F), (double)p_94171_4_ + 0.25D * var16 + 0.1875D * var14, 0.0D, 0.0D, var6);
      this.func_78623_a(p_94171_1_, (double)p_94171_2_ + 0.25D * var14 + -0.1875D * var16, (double)((float)p_94171_3_ - 0.1875F), (double)p_94171_4_ + 0.25D * var16 + -0.1875D * var14, 0.0D, 0.0D, var6);
      this.func_82774_a(var18);
      this.func_78623_a(p_94171_1_, (double)p_94171_2_ + var8, (double)p_94171_3_ + var10, (double)p_94171_4_ + var12, 0.0D, 0.0D, var6);
      this.func_78595_a();
      this.func_94174_a(p_94171_1_, p_94171_2_, p_94171_3_, p_94171_4_, var7);
      return true;
   }

   public boolean func_94176_a(BlockRedstoneLogic p_94176_1_, int p_94176_2_, int p_94176_3_, int p_94176_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      this.func_94174_a(p_94176_1_, p_94176_2_, p_94176_3_, p_94176_4_, this.field_78669_a.func_72805_g(p_94176_2_, p_94176_3_, p_94176_4_) & 3);
      return true;
   }

   public void func_94174_a(BlockRedstoneLogic p_94174_1_, int p_94174_2_, int p_94174_3_, int p_94174_4_, int p_94174_5_) {
      this.func_78570_q(p_94174_1_, p_94174_2_, p_94174_3_, p_94174_4_);
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_94174_1_.func_71874_e(this.field_78669_a, p_94174_2_, p_94174_3_, p_94174_4_));
      var6.func_78386_a(1.0F, 1.0F, 1.0F);
      int var7 = this.field_78669_a.func_72805_g(p_94174_2_, p_94174_3_, p_94174_4_);
      Icon var8 = this.func_94165_a(p_94174_1_, 1, var7);
      double var9 = (double)var8.func_94209_e();
      double var11 = (double)var8.func_94212_f();
      double var13 = (double)var8.func_94206_g();
      double var15 = (double)var8.func_94210_h();
      double var17 = 0.125D;
      double var19 = (double)(p_94174_2_ + 1);
      double var21 = (double)(p_94174_2_ + 1);
      double var23 = (double)(p_94174_2_ + 0);
      double var25 = (double)(p_94174_2_ + 0);
      double var27 = (double)(p_94174_4_ + 0);
      double var29 = (double)(p_94174_4_ + 1);
      double var31 = (double)(p_94174_4_ + 1);
      double var33 = (double)(p_94174_4_ + 0);
      double var35 = (double)p_94174_3_ + var17;
      if(p_94174_5_ == 2) {
         var19 = var21 = (double)(p_94174_2_ + 0);
         var23 = var25 = (double)(p_94174_2_ + 1);
         var27 = var33 = (double)(p_94174_4_ + 1);
         var29 = var31 = (double)(p_94174_4_ + 0);
      } else if(p_94174_5_ == 3) {
         var19 = var25 = (double)(p_94174_2_ + 0);
         var21 = var23 = (double)(p_94174_2_ + 1);
         var27 = var29 = (double)(p_94174_4_ + 0);
         var31 = var33 = (double)(p_94174_4_ + 1);
      } else if(p_94174_5_ == 1) {
         var19 = var25 = (double)(p_94174_2_ + 1);
         var21 = var23 = (double)(p_94174_2_ + 0);
         var27 = var29 = (double)(p_94174_4_ + 1);
         var31 = var33 = (double)(p_94174_4_ + 0);
      }

      var6.func_78374_a(var25, var35, var33, var9, var13);
      var6.func_78374_a(var23, var35, var31, var9, var15);
      var6.func_78374_a(var21, var35, var29, var11, var15);
      var6.func_78374_a(var19, var35, var27, var11, var13);
   }

   public void func_78568_d(Block p_78568_1_, int p_78568_2_, int p_78568_3_, int p_78568_4_) {
      this.field_78661_f = true;
      this.func_78593_b(p_78568_1_, p_78568_2_, p_78568_3_, p_78568_4_, true);
      this.field_78661_f = false;
   }

   public boolean func_78593_b(Block p_78593_1_, int p_78593_2_, int p_78593_3_, int p_78593_4_, boolean p_78593_5_) {
      int var6 = this.field_78669_a.func_72805_g(p_78593_2_, p_78593_3_, p_78593_4_);
      boolean var7 = p_78593_5_ || (var6 & 8) != 0;
      int var8 = BlockPistonBase.func_72117_e(var6);
      if(var7) {
         switch(var8) {
         case 0:
            this.field_78662_g = 3;
            this.field_78683_h = 3;
            this.field_78685_i = 3;
            this.field_78679_j = 3;
            this.func_83020_a(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
            break;
         case 1:
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
            break;
         case 2:
            this.field_78685_i = 1;
            this.field_78679_j = 2;
            this.func_83020_a(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
            break;
         case 3:
            this.field_78685_i = 2;
            this.field_78679_j = 1;
            this.field_78681_k = 3;
            this.field_78675_l = 3;
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
            break;
         case 4:
            this.field_78662_g = 1;
            this.field_78683_h = 2;
            this.field_78681_k = 2;
            this.field_78675_l = 1;
            this.func_83020_a(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            break;
         case 5:
            this.field_78662_g = 2;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 2;
            this.func_83020_a(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
         }

         ((BlockPistonBase)p_78593_1_).func_96479_b((float)this.field_83021_g, (float)this.field_83027_i, (float)this.field_83025_k, (float)this.field_83026_h, (float)this.field_83024_j, (float)this.field_83022_l);
         this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
         this.field_78662_g = 0;
         this.field_78683_h = 0;
         this.field_78685_i = 0;
         this.field_78679_j = 0;
         this.field_78681_k = 0;
         this.field_78675_l = 0;
         this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         ((BlockPistonBase)p_78593_1_).func_96479_b((float)this.field_83021_g, (float)this.field_83027_i, (float)this.field_83025_k, (float)this.field_83026_h, (float)this.field_83024_j, (float)this.field_83022_l);
      } else {
         switch(var8) {
         case 0:
            this.field_78662_g = 3;
            this.field_78683_h = 3;
            this.field_78685_i = 3;
            this.field_78679_j = 3;
         case 1:
         default:
            break;
         case 2:
            this.field_78685_i = 1;
            this.field_78679_j = 2;
            break;
         case 3:
            this.field_78685_i = 2;
            this.field_78679_j = 1;
            this.field_78681_k = 3;
            this.field_78675_l = 3;
            break;
         case 4:
            this.field_78662_g = 1;
            this.field_78683_h = 2;
            this.field_78681_k = 2;
            this.field_78675_l = 1;
            break;
         case 5:
            this.field_78662_g = 2;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 2;
         }

         this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
         this.field_78662_g = 0;
         this.field_78683_h = 0;
         this.field_78685_i = 0;
         this.field_78679_j = 0;
         this.field_78681_k = 0;
         this.field_78675_l = 0;
      }

      return true;
   }

   public void func_78591_a(double p_78591_1_, double p_78591_3_, double p_78591_5_, double p_78591_7_, double p_78591_9_, double p_78591_11_, float p_78591_13_, double p_78591_14_) {
      Icon var16 = BlockPistonBase.func_94496_b("piston_side");
      if(this.func_94167_b()) {
         var16 = this.field_78664_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_78591_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_78591_13_, p_78591_13_, p_78591_13_);
      var17.func_78374_a(p_78591_1_, p_78591_7_, p_78591_9_, var22, var20);
      var17.func_78374_a(p_78591_1_, p_78591_5_, p_78591_9_, var18, var20);
      var17.func_78374_a(p_78591_3_, p_78591_5_, p_78591_11_, var18, var24);
      var17.func_78374_a(p_78591_3_, p_78591_7_, p_78591_11_, var22, var24);
   }

   public void func_78607_b(double p_78607_1_, double p_78607_3_, double p_78607_5_, double p_78607_7_, double p_78607_9_, double p_78607_11_, float p_78607_13_, double p_78607_14_) {
      Icon var16 = BlockPistonBase.func_94496_b("piston_side");
      if(this.func_94167_b()) {
         var16 = this.field_78664_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_78607_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_78607_13_, p_78607_13_, p_78607_13_);
      var17.func_78374_a(p_78607_1_, p_78607_5_, p_78607_11_, var22, var20);
      var17.func_78374_a(p_78607_1_, p_78607_5_, p_78607_9_, var18, var20);
      var17.func_78374_a(p_78607_3_, p_78607_7_, p_78607_9_, var18, var24);
      var17.func_78374_a(p_78607_3_, p_78607_7_, p_78607_11_, var22, var24);
   }

   public void func_78571_c(double p_78571_1_, double p_78571_3_, double p_78571_5_, double p_78571_7_, double p_78571_9_, double p_78571_11_, float p_78571_13_, double p_78571_14_) {
      Icon var16 = BlockPistonBase.func_94496_b("piston_side");
      if(this.func_94167_b()) {
         var16 = this.field_78664_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_78571_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_78571_13_, p_78571_13_, p_78571_13_);
      var17.func_78374_a(p_78571_3_, p_78571_5_, p_78571_9_, var22, var20);
      var17.func_78374_a(p_78571_1_, p_78571_5_, p_78571_9_, var18, var20);
      var17.func_78374_a(p_78571_1_, p_78571_7_, p_78571_11_, var18, var24);
      var17.func_78374_a(p_78571_3_, p_78571_7_, p_78571_11_, var22, var24);
   }

   public void func_78587_a(Block p_78587_1_, int p_78587_2_, int p_78587_3_, int p_78587_4_, boolean p_78587_5_) {
      this.field_78661_f = true;
      this.func_78608_c(p_78587_1_, p_78587_2_, p_78587_3_, p_78587_4_, p_78587_5_);
      this.field_78661_f = false;
   }

   public boolean func_78608_c(Block p_78608_1_, int p_78608_2_, int p_78608_3_, int p_78608_4_, boolean p_78608_5_) {
      int var6 = this.field_78669_a.func_72805_g(p_78608_2_, p_78608_3_, p_78608_4_);
      int var7 = BlockPistonExtension.func_72121_f(var6);
      float var11 = p_78608_1_.func_71870_f(this.field_78669_a, p_78608_2_, p_78608_3_, p_78608_4_);
      float var12 = p_78608_5_?1.0F:0.5F;
      double var13 = p_78608_5_?16.0D:8.0D;
      switch(var7) {
      case 0:
         this.field_78662_g = 3;
         this.field_78683_h = 3;
         this.field_78685_i = 3;
         this.field_78679_j = 3;
         this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 1:
         this.func_83020_a(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 2:
         this.field_78685_i = 1;
         this.field_78679_j = 2;
         this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.25D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.5F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11, var13);
         break;
      case 3:
         this.field_78685_i = 2;
         this.field_78679_j = 1;
         this.field_78681_k = 3;
         this.field_78675_l = 3;
         this.func_83020_a(0.0D, 0.0D, 0.75D, 1.0D, 1.0D, 1.0D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.5F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11, var13);
         break;
      case 4:
         this.field_78662_g = 1;
         this.field_78683_h = 2;
         this.field_78681_k = 2;
         this.field_78675_l = 1;
         this.func_83020_a(0.0D, 0.0D, 0.0D, 0.25D, 1.0D, 1.0D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         break;
      case 5:
         this.field_78662_g = 2;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 2;
         this.func_83020_a(0.75D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
      }

      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78685_i = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return true;
   }

   public boolean func_78594_e(Block p_78594_1_, int p_78594_2_, int p_78594_3_, int p_78594_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78594_2_, p_78594_3_, p_78594_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = this.func_94167_b();
      if(!var9) {
         this.func_82774_a(this.func_94175_b(Block.field_71978_w));
      }

      float var10 = 0.25F;
      float var11 = 0.1875F;
      float var12 = 0.1875F;
      if(var6 == 5) {
         this.func_83020_a((double)(0.5F - var11), 0.0D, (double)(0.5F - var10), (double)(0.5F + var11), (double)var12, (double)(0.5F + var10));
      } else if(var6 == 6) {
         this.func_83020_a((double)(0.5F - var10), 0.0D, (double)(0.5F - var11), (double)(0.5F + var10), (double)var12, (double)(0.5F + var11));
      } else if(var6 == 4) {
         this.func_83020_a((double)(0.5F - var11), (double)(0.5F - var10), (double)(1.0F - var12), (double)(0.5F + var11), (double)(0.5F + var10), 1.0D);
      } else if(var6 == 3) {
         this.func_83020_a((double)(0.5F - var11), (double)(0.5F - var10), 0.0D, (double)(0.5F + var11), (double)(0.5F + var10), (double)var12);
      } else if(var6 == 2) {
         this.func_83020_a((double)(1.0F - var12), (double)(0.5F - var10), (double)(0.5F - var11), 1.0D, (double)(0.5F + var10), (double)(0.5F + var11));
      } else if(var6 == 1) {
         this.func_83020_a(0.0D, (double)(0.5F - var10), (double)(0.5F - var11), (double)var12, (double)(0.5F + var10), (double)(0.5F + var11));
      } else if(var6 == 0) {
         this.func_83020_a((double)(0.5F - var10), (double)(1.0F - var12), (double)(0.5F - var11), (double)(0.5F + var10), 1.0D, (double)(0.5F + var11));
      } else if(var6 == 7) {
         this.func_83020_a((double)(0.5F - var11), (double)(1.0F - var12), (double)(0.5F - var10), (double)(0.5F + var11), 1.0D, (double)(0.5F + var10));
      }

      this.func_78570_q(p_78594_1_, p_78594_2_, p_78594_3_, p_78594_4_);
      if(!var9) {
         this.func_78595_a();
      }

      var8.func_78380_c(p_78594_1_.func_71874_e(this.field_78669_a, p_78594_2_, p_78594_3_, p_78594_4_));
      float var13 = 1.0F;
      if(Block.field_71984_q[p_78594_1_.field_71990_ca] > 0) {
         var13 = 1.0F;
      }

      var8.func_78386_a(var13, var13, var13);
      Icon var14 = this.func_94173_a(p_78594_1_, 0);
      if(this.func_94167_b()) {
         var14 = this.field_78664_d;
      }

      double var15 = (double)var14.func_94209_e();
      double var17 = (double)var14.func_94206_g();
      double var19 = (double)var14.func_94212_f();
      double var21 = (double)var14.func_94210_h();
      Vec3[] var23 = new Vec3[8];
      float var24 = 0.0625F;
      float var25 = 0.0625F;
      float var26 = 0.625F;
      var23[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var24), 0.0D, (double)(-var25));
      var23[1] = this.field_78669_a.func_82732_R().func_72345_a((double)var24, 0.0D, (double)(-var25));
      var23[2] = this.field_78669_a.func_82732_R().func_72345_a((double)var24, 0.0D, (double)var25);
      var23[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var24), 0.0D, (double)var25);
      var23[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var24), (double)var26, (double)(-var25));
      var23[5] = this.field_78669_a.func_82732_R().func_72345_a((double)var24, (double)var26, (double)(-var25));
      var23[6] = this.field_78669_a.func_82732_R().func_72345_a((double)var24, (double)var26, (double)var25);
      var23[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var24), (double)var26, (double)var25);

      for(int var27 = 0; var27 < 8; ++var27) {
         if(var7) {
            var23[var27].field_72449_c -= 0.0625D;
            var23[var27].func_72440_a(0.69813174F);
         } else {
            var23[var27].field_72449_c += 0.0625D;
            var23[var27].func_72440_a(-0.69813174F);
         }

         if(var6 == 0 || var6 == 7) {
            var23[var27].func_72446_c(3.1415927F);
         }

         if(var6 == 6 || var6 == 0) {
            var23[var27].func_72442_b(1.5707964F);
         }

         if(var6 > 0 && var6 < 5) {
            var23[var27].field_72448_b -= 0.375D;
            var23[var27].func_72440_a(1.5707964F);
            if(var6 == 4) {
               var23[var27].func_72442_b(0.0F);
            }

            if(var6 == 3) {
               var23[var27].func_72442_b(3.1415927F);
            }

            if(var6 == 2) {
               var23[var27].func_72442_b(1.5707964F);
            }

            if(var6 == 1) {
               var23[var27].func_72442_b(-1.5707964F);
            }

            var23[var27].field_72450_a += (double)p_78594_2_ + 0.5D;
            var23[var27].field_72448_b += (double)((float)p_78594_3_ + 0.5F);
            var23[var27].field_72449_c += (double)p_78594_4_ + 0.5D;
         } else if(var6 != 0 && var6 != 7) {
            var23[var27].field_72450_a += (double)p_78594_2_ + 0.5D;
            var23[var27].field_72448_b += (double)((float)p_78594_3_ + 0.125F);
            var23[var27].field_72449_c += (double)p_78594_4_ + 0.5D;
         } else {
            var23[var27].field_72450_a += (double)p_78594_2_ + 0.5D;
            var23[var27].field_72448_b += (double)((float)p_78594_3_ + 0.875F);
            var23[var27].field_72449_c += (double)p_78594_4_ + 0.5D;
         }
      }

      Vec3 var32 = null;
      Vec3 var28 = null;
      Vec3 var29 = null;
      Vec3 var30 = null;

      for(int var31 = 0; var31 < 6; ++var31) {
         if(var31 == 0) {
            var15 = (double)var14.func_94214_a(7.0D);
            var17 = (double)var14.func_94207_b(6.0D);
            var19 = (double)var14.func_94214_a(9.0D);
            var21 = (double)var14.func_94207_b(8.0D);
         } else if(var31 == 2) {
            var15 = (double)var14.func_94214_a(7.0D);
            var17 = (double)var14.func_94207_b(6.0D);
            var19 = (double)var14.func_94214_a(9.0D);
            var21 = (double)var14.func_94210_h();
         }

         if(var31 == 0) {
            var32 = var23[0];
            var28 = var23[1];
            var29 = var23[2];
            var30 = var23[3];
         } else if(var31 == 1) {
            var32 = var23[7];
            var28 = var23[6];
            var29 = var23[5];
            var30 = var23[4];
         } else if(var31 == 2) {
            var32 = var23[1];
            var28 = var23[0];
            var29 = var23[4];
            var30 = var23[5];
         } else if(var31 == 3) {
            var32 = var23[2];
            var28 = var23[1];
            var29 = var23[5];
            var30 = var23[6];
         } else if(var31 == 4) {
            var32 = var23[3];
            var28 = var23[2];
            var29 = var23[6];
            var30 = var23[7];
         } else if(var31 == 5) {
            var32 = var23[0];
            var28 = var23[3];
            var29 = var23[7];
            var30 = var23[4];
         }

         var8.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, var15, var21);
         var8.func_78374_a(var28.field_72450_a, var28.field_72448_b, var28.field_72449_c, var19, var21);
         var8.func_78374_a(var29.field_72450_a, var29.field_72448_b, var29.field_72449_c, var19, var17);
         var8.func_78374_a(var30.field_72450_a, var30.field_72448_b, var30.field_72449_c, var15, var17);
      }

      return true;
   }

   public boolean func_78577_f(Block p_78577_1_, int p_78577_2_, int p_78577_3_, int p_78577_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78577_2_, p_78577_3_, p_78577_4_);
      int var7 = var6 & 3;
      boolean var8 = (var6 & 4) == 4;
      boolean var9 = (var6 & 8) == 8;
      boolean var10 = !this.field_78669_a.func_72797_t(p_78577_2_, p_78577_3_ - 1, p_78577_4_);
      boolean var11 = this.func_94167_b();
      if(!var11) {
         this.func_82774_a(this.func_94175_b(Block.field_71988_x));
      }

      float var12 = 0.25F;
      float var13 = 0.125F;
      float var14 = 0.125F;
      float var15 = 0.3F - var12;
      float var16 = 0.3F + var12;
      if(var7 == 2) {
         this.func_83020_a((double)(0.5F - var13), (double)var15, (double)(1.0F - var14), (double)(0.5F + var13), (double)var16, 1.0D);
      } else if(var7 == 0) {
         this.func_83020_a((double)(0.5F - var13), (double)var15, 0.0D, (double)(0.5F + var13), (double)var16, (double)var14);
      } else if(var7 == 1) {
         this.func_83020_a((double)(1.0F - var14), (double)var15, (double)(0.5F - var13), 1.0D, (double)var16, (double)(0.5F + var13));
      } else if(var7 == 3) {
         this.func_83020_a(0.0D, (double)var15, (double)(0.5F - var13), (double)var14, (double)var16, (double)(0.5F + var13));
      }

      this.func_78570_q(p_78577_1_, p_78577_2_, p_78577_3_, p_78577_4_);
      if(!var11) {
         this.func_78595_a();
      }

      var5.func_78380_c(p_78577_1_.func_71874_e(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_));
      float var17 = 1.0F;
      if(Block.field_71984_q[p_78577_1_.field_71990_ca] > 0) {
         var17 = 1.0F;
      }

      var5.func_78386_a(var17, var17, var17);
      Icon var18 = this.func_94173_a(p_78577_1_, 0);
      if(this.func_94167_b()) {
         var18 = this.field_78664_d;
      }

      double var19 = (double)var18.func_94209_e();
      double var21 = (double)var18.func_94206_g();
      double var23 = (double)var18.func_94212_f();
      double var25 = (double)var18.func_94210_h();
      Vec3[] var27 = new Vec3[8];
      float var28 = 0.046875F;
      float var29 = 0.046875F;
      float var30 = 0.3125F;
      var27[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var28), 0.0D, (double)(-var29));
      var27[1] = this.field_78669_a.func_82732_R().func_72345_a((double)var28, 0.0D, (double)(-var29));
      var27[2] = this.field_78669_a.func_82732_R().func_72345_a((double)var28, 0.0D, (double)var29);
      var27[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var28), 0.0D, (double)var29);
      var27[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var28), (double)var30, (double)(-var29));
      var27[5] = this.field_78669_a.func_82732_R().func_72345_a((double)var28, (double)var30, (double)(-var29));
      var27[6] = this.field_78669_a.func_82732_R().func_72345_a((double)var28, (double)var30, (double)var29);
      var27[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var28), (double)var30, (double)var29);

      for(int var31 = 0; var31 < 8; ++var31) {
         var27[var31].field_72449_c += 0.0625D;
         if(var9) {
            var27[var31].func_72440_a(0.5235988F);
            var27[var31].field_72448_b -= 0.4375D;
         } else if(var8) {
            var27[var31].func_72440_a(0.08726647F);
            var27[var31].field_72448_b -= 0.4375D;
         } else {
            var27[var31].func_72440_a(-0.69813174F);
            var27[var31].field_72448_b -= 0.375D;
         }

         var27[var31].func_72440_a(1.5707964F);
         if(var7 == 2) {
            var27[var31].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var27[var31].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var27[var31].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var27[var31].func_72442_b(-1.5707964F);
         }

         var27[var31].field_72450_a += (double)p_78577_2_ + 0.5D;
         var27[var31].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
         var27[var31].field_72449_c += (double)p_78577_4_ + 0.5D;
      }

      Vec3 var62 = null;
      Vec3 var32 = null;
      Vec3 var33 = null;
      Vec3 var34 = null;
      byte var35 = 7;
      byte var36 = 9;
      byte var37 = 9;
      byte var38 = 16;

      for(int var39 = 0; var39 < 6; ++var39) {
         if(var39 == 0) {
            var62 = var27[0];
            var32 = var27[1];
            var33 = var27[2];
            var34 = var27[3];
            var19 = (double)var18.func_94214_a((double)var35);
            var21 = (double)var18.func_94207_b((double)var37);
            var23 = (double)var18.func_94214_a((double)var36);
            var25 = (double)var18.func_94207_b((double)(var37 + 2));
         } else if(var39 == 1) {
            var62 = var27[7];
            var32 = var27[6];
            var33 = var27[5];
            var34 = var27[4];
         } else if(var39 == 2) {
            var62 = var27[1];
            var32 = var27[0];
            var33 = var27[4];
            var34 = var27[5];
            var19 = (double)var18.func_94214_a((double)var35);
            var21 = (double)var18.func_94207_b((double)var37);
            var23 = (double)var18.func_94214_a((double)var36);
            var25 = (double)var18.func_94207_b((double)var38);
         } else if(var39 == 3) {
            var62 = var27[2];
            var32 = var27[1];
            var33 = var27[5];
            var34 = var27[6];
         } else if(var39 == 4) {
            var62 = var27[3];
            var32 = var27[2];
            var33 = var27[6];
            var34 = var27[7];
         } else if(var39 == 5) {
            var62 = var27[0];
            var32 = var27[3];
            var33 = var27[7];
            var34 = var27[4];
         }

         var5.func_78374_a(var62.field_72450_a, var62.field_72448_b, var62.field_72449_c, var19, var25);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, var23, var25);
         var5.func_78374_a(var33.field_72450_a, var33.field_72448_b, var33.field_72449_c, var23, var21);
         var5.func_78374_a(var34.field_72450_a, var34.field_72448_b, var34.field_72449_c, var19, var21);
      }

      float var63 = 0.09375F;
      float var40 = 0.09375F;
      float var41 = 0.03125F;
      var27[0] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var63), 0.0D, (double)(-var40));
      var27[1] = this.field_78669_a.func_82732_R().func_72345_a((double)var63, 0.0D, (double)(-var40));
      var27[2] = this.field_78669_a.func_82732_R().func_72345_a((double)var63, 0.0D, (double)var40);
      var27[3] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var63), 0.0D, (double)var40);
      var27[4] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var63), (double)var41, (double)(-var40));
      var27[5] = this.field_78669_a.func_82732_R().func_72345_a((double)var63, (double)var41, (double)(-var40));
      var27[6] = this.field_78669_a.func_82732_R().func_72345_a((double)var63, (double)var41, (double)var40);
      var27[7] = this.field_78669_a.func_82732_R().func_72345_a((double)(-var63), (double)var41, (double)var40);

      for(int var42 = 0; var42 < 8; ++var42) {
         var27[var42].field_72449_c += 0.21875D;
         if(var9) {
            var27[var42].field_72448_b -= 0.09375D;
            var27[var42].field_72449_c -= 0.1625D;
            var27[var42].func_72440_a(0.0F);
         } else if(var8) {
            var27[var42].field_72448_b += 0.015625D;
            var27[var42].field_72449_c -= 0.171875D;
            var27[var42].func_72440_a(0.17453294F);
         } else {
            var27[var42].func_72440_a(0.87266463F);
         }

         if(var7 == 2) {
            var27[var42].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var27[var42].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var27[var42].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var27[var42].func_72442_b(-1.5707964F);
         }

         var27[var42].field_72450_a += (double)p_78577_2_ + 0.5D;
         var27[var42].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
         var27[var42].field_72449_c += (double)p_78577_4_ + 0.5D;
      }

      byte var65 = 5;
      byte var43 = 11;
      byte var44 = 3;
      byte var45 = 9;

      for(int var46 = 0; var46 < 6; ++var46) {
         if(var46 == 0) {
            var62 = var27[0];
            var32 = var27[1];
            var33 = var27[2];
            var34 = var27[3];
            var19 = (double)var18.func_94214_a((double)var65);
            var21 = (double)var18.func_94207_b((double)var44);
            var23 = (double)var18.func_94214_a((double)var43);
            var25 = (double)var18.func_94207_b((double)var45);
         } else if(var46 == 1) {
            var62 = var27[7];
            var32 = var27[6];
            var33 = var27[5];
            var34 = var27[4];
         } else if(var46 == 2) {
            var62 = var27[1];
            var32 = var27[0];
            var33 = var27[4];
            var34 = var27[5];
            var19 = (double)var18.func_94214_a((double)var65);
            var21 = (double)var18.func_94207_b((double)var44);
            var23 = (double)var18.func_94214_a((double)var43);
            var25 = (double)var18.func_94207_b((double)(var44 + 2));
         } else if(var46 == 3) {
            var62 = var27[2];
            var32 = var27[1];
            var33 = var27[5];
            var34 = var27[6];
         } else if(var46 == 4) {
            var62 = var27[3];
            var32 = var27[2];
            var33 = var27[6];
            var34 = var27[7];
         } else if(var46 == 5) {
            var62 = var27[0];
            var32 = var27[3];
            var33 = var27[7];
            var34 = var27[4];
         }

         var5.func_78374_a(var62.field_72450_a, var62.field_72448_b, var62.field_72449_c, var19, var25);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, var23, var25);
         var5.func_78374_a(var33.field_72450_a, var33.field_72448_b, var33.field_72449_c, var23, var21);
         var5.func_78374_a(var34.field_72450_a, var34.field_72448_b, var34.field_72449_c, var19, var21);
      }

      if(var8) {
         double var64 = var27[0].field_72448_b;
         float var48 = 0.03125F;
         float var49 = 0.5F - var48 / 2.0F;
         float var50 = var49 + var48;
         Icon var51 = this.func_94175_b(Block.field_72062_bU);
         double var52 = (double)var18.func_94209_e();
         double var54 = (double)var18.func_94207_b(var8?2.0D:0.0D);
         double var56 = (double)var18.func_94212_f();
         double var58 = (double)var18.func_94207_b(var8?4.0D:2.0D);
         double var60 = (double)(var10?3.5F:1.5F) / 16.0D;
         var17 = p_78577_1_.func_71870_f(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_) * 0.75F;
         var5.func_78386_a(var17, var17, var17);
         if(var7 == 2) {
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.25D, var52, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.25D, var52, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)p_78577_4_, var56, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)p_78577_4_, var56, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), var64, (double)p_78577_4_ + 0.5D, var52, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), var64, (double)p_78577_4_ + 0.5D, var52, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.25D, var56, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.25D, var56, var54);
         } else if(var7 == 0) {
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.75D, var52, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.75D, var52, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), var64, (double)p_78577_4_ + 0.5D, var56, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), var64, (double)p_78577_4_ + 0.5D, var56, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)(p_78577_4_ + 1), var52, var54);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)(p_78577_4_ + 1), var52, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var50), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.75D, var56, var58);
            var5.func_78374_a((double)((float)p_78577_2_ + var49), (double)p_78577_3_ + var60, (double)p_78577_4_ + 0.75D, var56, var54);
         } else if(var7 == 1) {
            var5.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var52, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var56, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var56, var54);
            var5.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var52, var54);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var52, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var50), var56, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var49), var56, var54);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var52, var54);
         } else {
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var50), var52, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var56, var58);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var56, var54);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var49), var52, var54);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var52, var58);
            var5.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var50), var56, var58);
            var5.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var56, var54);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var60, (double)((float)p_78577_4_ + var49), var52, var54);
         }
      }

      return true;
   }

   public boolean func_78619_g(Block p_78619_1_, int p_78619_2_, int p_78619_3_, int p_78619_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      Icon var6 = this.func_94173_a(p_78619_1_, 0);
      int var7 = this.field_78669_a.func_72805_g(p_78619_2_, p_78619_3_, p_78619_4_);
      boolean var8 = (var7 & 4) == 4;
      boolean var9 = (var7 & 2) == 2;
      if(this.func_94167_b()) {
         var6 = this.field_78664_d;
      }

      var5.func_78380_c(p_78619_1_.func_71874_e(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_));
      float var10 = p_78619_1_.func_71870_f(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_) * 0.75F;
      var5.func_78386_a(var10, var10, var10);
      double var11 = (double)var6.func_94209_e();
      double var13 = (double)var6.func_94207_b(var8?2.0D:0.0D);
      double var15 = (double)var6.func_94212_f();
      double var17 = (double)var6.func_94207_b(var8?4.0D:2.0D);
      double var19 = (double)(var9?3.5F:1.5F) / 16.0D;
      boolean var21 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 1);
      boolean var22 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 3);
      boolean var23 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 2);
      boolean var24 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 0);
      float var25 = 0.03125F;
      float var26 = 0.5F - var25 / 2.0F;
      float var27 = var26 + var25;
      if(!var23 && !var22 && !var24 && !var21) {
         var23 = true;
         var24 = true;
      }

      if(var23) {
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var11, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var11, var13);
      }

      if(var23 || var24 && !var22 && !var21) {
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var11, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.25D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var11, var13);
      }

      if(var24 || var23 && !var22 && !var21) {
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var11, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.5D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var11, var13);
      }

      if(var24) {
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)(p_78619_4_ + 1), var11, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)(p_78619_4_ + 1), var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var15, var13);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)p_78619_4_ + 0.75D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var27), (double)p_78619_3_ + var19, (double)(p_78619_4_ + 1), var11, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var26), (double)p_78619_3_ + var19, (double)(p_78619_4_ + 1), var11, var13);
      }

      if(var21) {
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
      }

      if(var21 || var22 && !var23 && !var24) {
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
      }

      if(var22 || var21 && !var23 && !var24) {
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
      }

      if(var22) {
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var11, var13);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var26), var15, var13);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var19, (double)((float)p_78619_4_ + var27), var11, var17);
      }

      return true;
   }

   public boolean func_78590_h(BlockFire p_78590_1_, int p_78590_2_, int p_78590_3_, int p_78590_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      Icon var6 = p_78590_1_.func_94438_c(0);
      Icon var7 = p_78590_1_.func_94438_c(1);
      Icon var8 = var6;
      if(this.func_94167_b()) {
         var8 = this.field_78664_d;
      }

      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      var5.func_78380_c(p_78590_1_.func_71874_e(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_));
      double var9 = (double)var8.func_94209_e();
      double var11 = (double)var8.func_94206_g();
      double var13 = (double)var8.func_94212_f();
      double var15 = (double)var8.func_94210_h();
      float var17 = 1.4F;
      double var20;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      double var32;
      if(!this.field_78669_a.func_72797_t(p_78590_2_, p_78590_3_ - 1, p_78590_4_) && !Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ - 1, p_78590_4_)) {
         float var36 = 0.2F;
         float var19 = 0.0625F;
         if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 1) {
            var9 = (double)var7.func_94209_e();
            var11 = (double)var7.func_94206_g();
            var13 = (double)var7.func_94212_f();
            var15 = (double)var7.func_94210_h();
         }

         if((p_78590_2_ / 2 + p_78590_3_ / 2 + p_78590_4_ / 2 & 1) == 1) {
            var20 = var13;
            var13 = var9;
            var9 = var20;
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ - 1, p_78590_3_, p_78590_4_)) {
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var13, var11);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var11);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var11);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var13, var15);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var13, var11);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ + 1, p_78590_3_, p_78590_4_)) {
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var11);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var13, var15);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var13, var11);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var13, var11);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var11);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ - 1)) {
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var13, var11);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var9, var11);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var9, var11);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var13, var11);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ + 1)) {
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var9, var11);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var13, var11);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var13, var11);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var13, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var9, var11);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ + 1, p_78590_4_)) {
            var20 = (double)p_78590_2_ + 0.5D + 0.5D;
            var22 = (double)p_78590_2_ + 0.5D - 0.5D;
            var24 = (double)p_78590_4_ + 0.5D + 0.5D;
            var26 = (double)p_78590_4_ + 0.5D - 0.5D;
            var28 = (double)p_78590_2_ + 0.5D - 0.5D;
            var30 = (double)p_78590_2_ + 0.5D + 0.5D;
            var32 = (double)p_78590_4_ + 0.5D - 0.5D;
            double var34 = (double)p_78590_4_ + 0.5D + 0.5D;
            var9 = (double)var6.func_94209_e();
            var11 = (double)var6.func_94206_g();
            var13 = (double)var6.func_94212_f();
            var15 = (double)var6.func_94210_h();
            ++p_78590_3_;
            var17 = -0.2F;
            if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 0) {
               var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var13, var11);
               var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var13, var15);
               var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
               var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var11);
               var9 = (double)var7.func_94209_e();
               var11 = (double)var7.func_94206_g();
               var13 = (double)var7.func_94212_f();
               var15 = (double)var7.func_94210_h();
               var5.func_78374_a(var30, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var13, var11);
               var5.func_78374_a(var22, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var13, var15);
               var5.func_78374_a(var22, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
               var5.func_78374_a(var30, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var11);
            } else {
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var34, var13, var11);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var26, var13, var15);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var26, var9, var15);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var34, var9, var11);
               var9 = (double)var7.func_94209_e();
               var11 = (double)var7.func_94206_g();
               var13 = (double)var7.func_94212_f();
               var15 = (double)var7.func_94210_h();
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var13, var11);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var13, var15);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var11);
            }
         }
      } else {
         double var18 = (double)p_78590_2_ + 0.5D + 0.2D;
         var20 = (double)p_78590_2_ + 0.5D - 0.2D;
         var22 = (double)p_78590_4_ + 0.5D + 0.2D;
         var24 = (double)p_78590_4_ + 0.5D - 0.2D;
         var26 = (double)p_78590_2_ + 0.5D - 0.3D;
         var28 = (double)p_78590_2_ + 0.5D + 0.3D;
         var30 = (double)p_78590_4_ + 0.5D - 0.3D;
         var32 = (double)p_78590_4_ + 0.5D + 0.3D;
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var13, var11);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var13, var15);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var11);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var13, var11);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var13, var15);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var11);
         var9 = (double)var7.func_94209_e();
         var11 = (double)var7.func_94206_g();
         var13 = (double)var7.func_94212_f();
         var15 = (double)var7.func_94210_h();
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var13, var11);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var13, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var11);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var30, var13, var11);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var22, var13, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var30, var9, var11);
         var18 = (double)p_78590_2_ + 0.5D - 0.5D;
         var20 = (double)p_78590_2_ + 0.5D + 0.5D;
         var22 = (double)p_78590_4_ + 0.5D - 0.5D;
         var24 = (double)p_78590_4_ + 0.5D + 0.5D;
         var26 = (double)p_78590_2_ + 0.5D - 0.4D;
         var28 = (double)p_78590_2_ + 0.5D + 0.4D;
         var30 = (double)p_78590_4_ + 0.5D - 0.4D;
         var32 = (double)p_78590_4_ + 0.5D + 0.4D;
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var11);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var13, var15);
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var13, var11);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var11);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var13, var15);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var13, var11);
         var9 = (double)var6.func_94209_e();
         var11 = (double)var6.func_94206_g();
         var13 = (double)var6.func_94212_f();
         var15 = (double)var6.func_94210_h();
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var11);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var13, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var13, var11);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var30, var9, var11);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var22, var13, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var30, var13, var11);
      }

      return true;
   }

   public boolean func_78589_i(Block p_78589_1_, int p_78589_2_, int p_78589_3_, int p_78589_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78589_2_, p_78589_3_, p_78589_4_);
      Icon var7 = BlockRedstoneWire.func_94409_b("redstoneDust_cross");
      Icon var8 = BlockRedstoneWire.func_94409_b("redstoneDust_line");
      Icon var9 = BlockRedstoneWire.func_94409_b("redstoneDust_cross_overlay");
      Icon var10 = BlockRedstoneWire.func_94409_b("redstoneDust_line_overlay");
      var5.func_78380_c(p_78589_1_.func_71874_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_));
      float var11 = 1.0F;
      float var12 = (float)var6 / 15.0F;
      float var13 = var12 * 0.6F + 0.4F;
      if(var6 == 0) {
         var13 = 0.3F;
      }

      float var14 = var12 * var12 * 0.7F - 0.5F;
      float var15 = var12 * var12 * 0.6F - 0.7F;
      if(var14 < 0.0F) {
         var14 = 0.0F;
      }

      if(var15 < 0.0F) {
         var15 = 0.0F;
      }

      var5.func_78386_a(var13, var14, var15);
      boolean var20 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_, p_78589_4_, 1) || !this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ - 1, p_78589_4_, -1);
      boolean var21 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_, p_78589_4_, 3) || !this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ - 1, p_78589_4_, -1);
      boolean var22 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ - 1, 2) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ - 1, -1);
      boolean var23 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ + 1, 0) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ + 1, -1);
      if(!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_)) {
         if(this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_, -1)) {
            var20 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_, -1)) {
            var21 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1, -1)) {
            var22 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1, -1)) {
            var23 = true;
         }
      }

      float var24 = (float)(p_78589_2_ + 0);
      float var25 = (float)(p_78589_2_ + 1);
      float var26 = (float)(p_78589_4_ + 0);
      float var27 = (float)(p_78589_4_ + 1);
      boolean var28 = false;
      if((var20 || var21) && !var22 && !var23) {
         var28 = true;
      }

      if((var22 || var23) && !var21 && !var20) {
         var28 = true;
      }

      if(!var28) {
         int var29 = 0;
         int var30 = 0;
         int var31 = 16;
         int var32 = 16;
         if(!var20) {
            var24 += 0.3125F;
         }

         if(!var20) {
            var29 += 5;
         }

         if(!var21) {
            var25 -= 0.3125F;
         }

         if(!var21) {
            var31 -= 5;
         }

         if(!var22) {
            var26 += 0.3125F;
         }

         if(!var22) {
            var30 += 5;
         }

         if(!var23) {
            var27 -= 0.3125F;
         }

         if(!var23) {
            var32 -= 5;
         }

         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var7.func_94214_a((double)var31), (double)var7.func_94207_b((double)var32));
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var7.func_94214_a((double)var31), (double)var7.func_94207_b((double)var30));
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var7.func_94214_a((double)var29), (double)var7.func_94207_b((double)var30));
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var7.func_94214_a((double)var29), (double)var7.func_94207_b((double)var32));
         var5.func_78386_a(var11, var11, var11);
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var9.func_94214_a((double)var31), (double)var9.func_94207_b((double)var32));
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var9.func_94214_a((double)var31), (double)var9.func_94207_b((double)var30));
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var9.func_94214_a((double)var29), (double)var9.func_94207_b((double)var30));
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var9.func_94214_a((double)var29), (double)var9.func_94207_b((double)var32));
      } else if(var28) {
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var8.func_94212_f(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var8.func_94212_f(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var8.func_94209_e(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var8.func_94209_e(), (double)var8.func_94210_h());
         var5.func_78386_a(var11, var11, var11);
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var10.func_94212_f(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var10.func_94209_e(), (double)var10.func_94210_h());
      } else {
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var8.func_94212_f(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var8.func_94209_e(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var8.func_94209_e(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var8.func_94212_f(), (double)var8.func_94206_g());
         var5.func_78386_a(var11, var11, var11);
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var25, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var10.func_94209_e(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var26, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var24, (double)p_78589_3_ + 0.015625D, (double)var27, (double)var10.func_94212_f(), (double)var10.func_94206_g());
      }

      if(!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_)) {
         if(this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var11 * var13, var11 * var14, var11 * var15);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78386_a(var11, var11, var11);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)var10.func_94209_e(), (double)var10.func_94206_g());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)var10.func_94212_f(), (double)var10.func_94210_h());
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var11 * var13, var11 * var14, var11 * var15);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78386_a(var11, var11, var11);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), (double)var10.func_94212_f(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), (double)var10.func_94209_e(), (double)var10.func_94206_g());
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var11 * var13, var11 * var14, var11 * var15);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78386_a(var11, var11, var11);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var11 * var13, var11 * var14, var11 * var15);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78386_a(var11, var11, var11);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         }
      }

      return true;
   }

   public boolean func_78586_a(BlockRailBase p_78586_1_, int p_78586_2_, int p_78586_3_, int p_78586_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78586_2_, p_78586_3_, p_78586_4_);
      Icon var7 = this.func_94165_a(p_78586_1_, 0, var6);
      if(this.func_94167_b()) {
         var7 = this.field_78664_d;
      }

      if(p_78586_1_.func_72183_n()) {
         var6 &= 7;
      }

      var5.func_78380_c(p_78586_1_.func_71874_e(this.field_78669_a, p_78586_2_, p_78586_3_, p_78586_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      double var8 = (double)var7.func_94209_e();
      double var10 = (double)var7.func_94206_g();
      double var12 = (double)var7.func_94212_f();
      double var14 = (double)var7.func_94210_h();
      double var16 = 0.0625D;
      double var18 = (double)(p_78586_2_ + 1);
      double var20 = (double)(p_78586_2_ + 1);
      double var22 = (double)(p_78586_2_ + 0);
      double var24 = (double)(p_78586_2_ + 0);
      double var26 = (double)(p_78586_4_ + 0);
      double var28 = (double)(p_78586_4_ + 1);
      double var30 = (double)(p_78586_4_ + 1);
      double var32 = (double)(p_78586_4_ + 0);
      double var34 = (double)p_78586_3_ + var16;
      double var36 = (double)p_78586_3_ + var16;
      double var38 = (double)p_78586_3_ + var16;
      double var40 = (double)p_78586_3_ + var16;
      if(var6 != 1 && var6 != 2 && var6 != 3 && var6 != 7) {
         if(var6 == 8) {
            var18 = var20 = (double)(p_78586_2_ + 0);
            var22 = var24 = (double)(p_78586_2_ + 1);
            var26 = var32 = (double)(p_78586_4_ + 1);
            var28 = var30 = (double)(p_78586_4_ + 0);
         } else if(var6 == 9) {
            var18 = var24 = (double)(p_78586_2_ + 0);
            var20 = var22 = (double)(p_78586_2_ + 1);
            var26 = var28 = (double)(p_78586_4_ + 0);
            var30 = var32 = (double)(p_78586_4_ + 1);
         }
      } else {
         var18 = var24 = (double)(p_78586_2_ + 1);
         var20 = var22 = (double)(p_78586_2_ + 0);
         var26 = var28 = (double)(p_78586_4_ + 1);
         var30 = var32 = (double)(p_78586_4_ + 0);
      }

      if(var6 != 2 && var6 != 4) {
         if(var6 == 3 || var6 == 5) {
            ++var36;
            ++var38;
         }
      } else {
         ++var34;
         ++var40;
      }

      var5.func_78374_a(var18, var34, var26, var12, var10);
      var5.func_78374_a(var20, var36, var28, var12, var14);
      var5.func_78374_a(var22, var38, var30, var8, var14);
      var5.func_78374_a(var24, var40, var32, var8, var10);
      var5.func_78374_a(var24, var40, var32, var8, var10);
      var5.func_78374_a(var22, var38, var30, var8, var14);
      var5.func_78374_a(var20, var36, var28, var12, var14);
      var5.func_78374_a(var18, var34, var26, var12, var10);
      return true;
   }

   public boolean func_78576_j(Block p_78576_1_, int p_78576_2_, int p_78576_3_, int p_78576_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      Icon var6 = this.func_94173_a(p_78576_1_, 0);
      if(this.func_94167_b()) {
         var6 = this.field_78664_d;
      }

      var5.func_78380_c(p_78576_1_.func_71874_e(this.field_78669_a, p_78576_2_, p_78576_3_, p_78576_4_));
      float var7 = 1.0F;
      var5.func_78386_a(var7, var7, var7);
      double var20 = (double)var6.func_94209_e();
      double var9 = (double)var6.func_94206_g();
      double var11 = (double)var6.func_94212_f();
      double var13 = (double)var6.func_94210_h();
      int var15 = this.field_78669_a.func_72805_g(p_78576_2_, p_78576_3_, p_78576_4_);
      double var16 = 0.0D;
      double var18 = 0.05000000074505806D;
      if(var15 == 5) {
         var5.func_78374_a((double)p_78576_2_ + var18, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 1) + var16, var20, var9);
         var5.func_78374_a((double)p_78576_2_ + var18, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 1) + var16, var20, var13);
         var5.func_78374_a((double)p_78576_2_ + var18, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 0) - var16, var11, var13);
         var5.func_78374_a((double)p_78576_2_ + var18, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 0) - var16, var11, var9);
      }

      if(var15 == 4) {
         var5.func_78374_a((double)(p_78576_2_ + 1) - var18, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 1) + var16, var11, var13);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var18, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 1) + var16, var11, var9);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var18, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 0) - var16, var20, var9);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var18, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 0) - var16, var20, var13);
      }

      if(var15 == 3) {
         var5.func_78374_a((double)(p_78576_2_ + 1) + var16, (double)(p_78576_3_ + 0) - var16, (double)p_78576_4_ + var18, var11, var13);
         var5.func_78374_a((double)(p_78576_2_ + 1) + var16, (double)(p_78576_3_ + 1) + var16, (double)p_78576_4_ + var18, var11, var9);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var16, (double)(p_78576_3_ + 1) + var16, (double)p_78576_4_ + var18, var20, var9);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var16, (double)(p_78576_3_ + 0) - var16, (double)p_78576_4_ + var18, var20, var13);
      }

      if(var15 == 2) {
         var5.func_78374_a((double)(p_78576_2_ + 1) + var16, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 1) - var18, var20, var9);
         var5.func_78374_a((double)(p_78576_2_ + 1) + var16, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 1) - var18, var20, var13);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var16, (double)(p_78576_3_ + 0) - var16, (double)(p_78576_4_ + 1) - var18, var11, var13);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var16, (double)(p_78576_3_ + 1) + var16, (double)(p_78576_4_ + 1) - var18, var11, var9);
      }

      return true;
   }

   public boolean func_78598_k(Block p_78598_1_, int p_78598_2_, int p_78598_3_, int p_78598_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      Icon var6 = this.func_94173_a(p_78598_1_, 0);
      if(this.func_94167_b()) {
         var6 = this.field_78664_d;
      }

      float var7 = 1.0F;
      var5.func_78380_c(p_78598_1_.func_71874_e(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_));
      int var8 = p_78598_1_.func_71920_b(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      var5.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      double var19 = (double)var6.func_94209_e();
      double var20 = (double)var6.func_94206_g();
      double var12 = (double)var6.func_94212_f();
      double var14 = (double)var6.func_94210_h();
      double var16 = 0.05000000074505806D;
      int var18 = this.field_78669_a.func_72805_g(p_78598_2_, p_78598_3_, p_78598_4_);
      if((var18 & 2) != 0) {
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var19, var20);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var19, var14);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var12, var14);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var12, var20);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var12, var20);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var12, var14);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var19, var14);
         var5.func_78374_a((double)p_78598_2_ + var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var19, var20);
      }

      if((var18 & 8) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var16, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var12, var14);
      }

      if((var18 & 4) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var16, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var16, var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var16, var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var16, var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var16, var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var16, var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var16, var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var16, var12, var14);
      }

      if((var18 & 1) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var16, var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var16, var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var16, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var16, var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var16, var12, var20);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var16, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var16, var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var16, var19, var20);
      }

      if(this.field_78669_a.func_72809_s(p_78598_2_, p_78598_3_ + 1, p_78598_4_)) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - var16, (double)(p_78598_4_ + 0), var19, var20);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - var16, (double)(p_78598_4_ + 1), var19, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - var16, (double)(p_78598_4_ + 1), var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - var16, (double)(p_78598_4_ + 0), var12, var20);
      }

      return true;
   }

   public boolean func_78592_a(BlockPane p_78592_1_, int p_78592_2_, int p_78592_3_, int p_78592_4_) {
      int var5 = this.field_78669_a.func_72800_K();
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_78592_1_.func_71874_e(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_));
      float var7 = 1.0F;
      int var8 = p_78592_1_.func_71920_b(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      Icon var64;
      Icon var65;
      int var66;
      if(this.func_94167_b()) {
         var64 = this.field_78664_d;
         var65 = this.field_78664_d;
      } else {
         var66 = this.field_78669_a.func_72805_g(p_78592_2_, p_78592_3_, p_78592_4_);
         var64 = this.func_94165_a(p_78592_1_, 0, var66);
         var65 = p_78592_1_.func_72162_n();
      }

      var66 = var64.func_94211_a();
      int var15 = var64.func_94216_b();
      double var16 = (double)var64.func_94209_e();
      double var18 = (double)var64.func_94214_a(8.0D);
      double var20 = (double)var64.func_94212_f();
      double var22 = (double)var64.func_94206_g();
      double var24 = (double)var64.func_94210_h();
      int var26 = var65.func_94211_a();
      int var27 = var65.func_94216_b();
      double var28 = (double)var65.func_94214_a(7.0D);
      double var30 = (double)var65.func_94214_a(9.0D);
      double var32 = (double)var65.func_94206_g();
      double var34 = (double)var65.func_94207_b(8.0D);
      double var36 = (double)var65.func_94210_h();
      double var38 = (double)p_78592_2_;
      double var40 = (double)p_78592_2_ + 0.5D;
      double var42 = (double)(p_78592_2_ + 1);
      double var44 = (double)p_78592_4_;
      double var46 = (double)p_78592_4_ + 0.5D;
      double var48 = (double)(p_78592_4_ + 1);
      double var50 = (double)p_78592_2_ + 0.5D - 0.0625D;
      double var52 = (double)p_78592_2_ + 0.5D + 0.0625D;
      double var54 = (double)p_78592_4_ + 0.5D - 0.0625D;
      double var56 = (double)p_78592_4_ + 0.5D + 0.0625D;
      boolean var58 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ - 1));
      boolean var59 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ + 1));
      boolean var60 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ - 1, p_78592_3_, p_78592_4_));
      boolean var61 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ + 1, p_78592_3_, p_78592_4_));
      boolean var62 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ + 1, p_78592_4_, 1);
      boolean var63 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ - 1, p_78592_4_, 0);
      if((!var60 || !var61) && (var60 || var61 || var58 || var59)) {
         if(var60 && !var61) {
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var18, var22);
            if(!var59 && !var58) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
            }
         } else if(!var60 && var61) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var20, var22);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var20, var22);
            if(!var59 && !var58) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            }
         }
      } else {
         var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var16, var22);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var16, var24);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var20, var24);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var20, var22);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var16, var22);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var16, var24);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var20, var24);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var20, var22);
         if(var62) {
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
         } else {
            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            }
         }

         if(var63) {
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var36);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var32);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var36);
         } else {
            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
            }

            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            }
         }
      }

      if((!var58 || !var59) && (var60 || var61 || var58 || var59)) {
         if(var58 && !var59) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var18, var22);
            if(!var61 && !var60) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var32);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var28, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var28, var32);
            }
         } else if(!var58 && var59) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var20, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var20, var22);
            if(!var61 && !var60) {
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var34);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var30, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var34);
            }
         }
      } else {
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var16, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var16, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var20, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var20, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var16, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var16, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var20, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var20, var22);
         if(var62) {
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var36);
         } else {
            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var44, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var44, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var32);
            }

            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var48, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1) + 0.0050D, var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1) + 0.0050D, var48, var30, var34);
            }
         }

         if(var63) {
            var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var36);
            var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var30, var32);
            var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var28, var32);
            var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var36);
            var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var30, var36);
            var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var32);
            var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var32);
            var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var28, var36);
         } else {
            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var28, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var44, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var44, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var28, var32);
            }

            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var30, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var48, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_ - 0.0050D, var46, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var46, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_ - 0.0050D, var48, var30, var34);
            }
         }
      }

      return true;
   }

   public boolean func_78620_l(Block p_78620_1_, int p_78620_2_, int p_78620_3_, int p_78620_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78620_1_.func_71874_e(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_));
      float var6 = 1.0F;
      int var7 = p_78620_1_.func_71920_b(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      double var19 = (double)p_78620_2_;
      double var20 = (double)p_78620_3_;
      double var15 = (double)p_78620_4_;
      if(p_78620_1_ == Block.field_71962_X) {
         long var17 = (long)(p_78620_2_ * 3129871) ^ (long)p_78620_4_ * 116129781L ^ (long)p_78620_3_;
         var17 = var17 * var17 * 42317861L + var17 * 11L;
         var19 += ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var20 += ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         var15 += ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
      }

      this.func_78599_a(p_78620_1_, this.field_78669_a.func_72805_g(p_78620_2_, p_78620_3_, p_78620_4_), var19, var20, var15, 1.0F);
      return true;
   }

   public boolean func_78603_m(Block p_78603_1_, int p_78603_2_, int p_78603_3_, int p_78603_4_) {
      BlockStem var5 = (BlockStem)p_78603_1_;
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(var5.func_71874_e(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_));
      float var7 = 1.0F;
      int var8 = var5.func_71920_b(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      var5.func_71902_a(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      int var15 = var5.func_72265_d(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      if(var15 < 0) {
         this.func_78575_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), this.field_83024_j, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
      } else {
         this.func_78575_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), 0.5D, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
         this.func_78606_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), var15, this.field_83024_j, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
      }

      return true;
   }

   public boolean func_78614_n(Block p_78614_1_, int p_78614_2_, int p_78614_3_, int p_78614_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78614_1_.func_71874_e(this.field_78669_a, p_78614_2_, p_78614_3_, p_78614_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      this.func_78579_b(p_78614_1_, this.field_78669_a.func_72805_g(p_78614_2_, p_78614_3_, p_78614_4_), (double)p_78614_2_, (double)((float)p_78614_3_ - 0.0625F), (double)p_78614_4_);
      return true;
   }

   public void func_78623_a(Block p_78623_1_, double p_78623_2_, double p_78623_4_, double p_78623_6_, double p_78623_8_, double p_78623_10_, int p_78623_12_) {
      Tessellator var13 = Tessellator.field_78398_a;
      Icon var14 = this.func_94165_a(p_78623_1_, 0, p_78623_12_);
      if(this.func_94167_b()) {
         var14 = this.field_78664_d;
      }

      double var15 = (double)var14.func_94209_e();
      double var17 = (double)var14.func_94206_g();
      double var19 = (double)var14.func_94212_f();
      double var21 = (double)var14.func_94210_h();
      double var23 = (double)var14.func_94214_a(7.0D);
      double var25 = (double)var14.func_94207_b(6.0D);
      double var27 = (double)var14.func_94214_a(9.0D);
      double var29 = (double)var14.func_94207_b(8.0D);
      double var31 = (double)var14.func_94214_a(7.0D);
      double var33 = (double)var14.func_94207_b(13.0D);
      double var35 = (double)var14.func_94214_a(9.0D);
      double var37 = (double)var14.func_94207_b(15.0D);
      p_78623_2_ += 0.5D;
      p_78623_6_ += 0.5D;
      double var39 = p_78623_2_ - 0.5D;
      double var41 = p_78623_2_ + 0.5D;
      double var43 = p_78623_6_ - 0.5D;
      double var45 = p_78623_6_ + 0.5D;
      double var47 = 0.0625D;
      double var49 = 0.625D;
      var13.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var49) - var47, p_78623_4_ + var49, p_78623_6_ + p_78623_10_ * (1.0D - var49) - var47, var23, var25);
      var13.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var49) - var47, p_78623_4_ + var49, p_78623_6_ + p_78623_10_ * (1.0D - var49) + var47, var23, var29);
      var13.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var49) + var47, p_78623_4_ + var49, p_78623_6_ + p_78623_10_ * (1.0D - var49) + var47, var27, var29);
      var13.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var49) + var47, p_78623_4_ + var49, p_78623_6_ + p_78623_10_ * (1.0D - var49) - var47, var27, var25);
      var13.func_78374_a(p_78623_2_ + var47 + p_78623_8_, p_78623_4_, p_78623_6_ - var47 + p_78623_10_, var35, var33);
      var13.func_78374_a(p_78623_2_ + var47 + p_78623_8_, p_78623_4_, p_78623_6_ + var47 + p_78623_10_, var35, var37);
      var13.func_78374_a(p_78623_2_ - var47 + p_78623_8_, p_78623_4_, p_78623_6_ + var47 + p_78623_10_, var31, var37);
      var13.func_78374_a(p_78623_2_ - var47 + p_78623_8_, p_78623_4_, p_78623_6_ - var47 + p_78623_10_, var31, var33);
      var13.func_78374_a(p_78623_2_ - var47, p_78623_4_ + 1.0D, var43, var15, var17);
      var13.func_78374_a(p_78623_2_ - var47 + p_78623_8_, p_78623_4_ + 0.0D, var43 + p_78623_10_, var15, var21);
      var13.func_78374_a(p_78623_2_ - var47 + p_78623_8_, p_78623_4_ + 0.0D, var45 + p_78623_10_, var19, var21);
      var13.func_78374_a(p_78623_2_ - var47, p_78623_4_ + 1.0D, var45, var19, var17);
      var13.func_78374_a(p_78623_2_ + var47, p_78623_4_ + 1.0D, var45, var15, var17);
      var13.func_78374_a(p_78623_2_ + p_78623_8_ + var47, p_78623_4_ + 0.0D, var45 + p_78623_10_, var15, var21);
      var13.func_78374_a(p_78623_2_ + p_78623_8_ + var47, p_78623_4_ + 0.0D, var43 + p_78623_10_, var19, var21);
      var13.func_78374_a(p_78623_2_ + var47, p_78623_4_ + 1.0D, var43, var19, var17);
      var13.func_78374_a(var39, p_78623_4_ + 1.0D, p_78623_6_ + var47, var15, var17);
      var13.func_78374_a(var39 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + var47 + p_78623_10_, var15, var21);
      var13.func_78374_a(var41 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + var47 + p_78623_10_, var19, var21);
      var13.func_78374_a(var41, p_78623_4_ + 1.0D, p_78623_6_ + var47, var19, var17);
      var13.func_78374_a(var41, p_78623_4_ + 1.0D, p_78623_6_ - var47, var15, var17);
      var13.func_78374_a(var41 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - var47 + p_78623_10_, var15, var21);
      var13.func_78374_a(var39 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - var47 + p_78623_10_, var19, var21);
      var13.func_78374_a(var39, p_78623_4_ + 1.0D, p_78623_6_ - var47, var19, var17);
   }

   public void func_78599_a(Block p_78599_1_, int p_78599_2_, double p_78599_3_, double p_78599_5_, double p_78599_7_, float p_78599_9_) {
      Tessellator var10 = Tessellator.field_78398_a;
      Icon var11 = this.func_94165_a(p_78599_1_, 0, p_78599_2_);
      if(this.func_94167_b()) {
         var11 = this.field_78664_d;
      }

      double var12 = (double)var11.func_94209_e();
      double var14 = (double)var11.func_94206_g();
      double var16 = (double)var11.func_94212_f();
      double var18 = (double)var11.func_94210_h();
      double var20 = 0.45D * (double)p_78599_9_;
      double var22 = p_78599_3_ + 0.5D - var20;
      double var24 = p_78599_3_ + 0.5D + var20;
      double var26 = p_78599_7_ + 0.5D - var20;
      double var28 = p_78599_7_ + 0.5D + var20;
      var10.func_78374_a(var22, p_78599_5_ + (double)p_78599_9_, var26, var12, var14);
      var10.func_78374_a(var22, p_78599_5_ + 0.0D, var26, var12, var18);
      var10.func_78374_a(var24, p_78599_5_ + 0.0D, var28, var16, var18);
      var10.func_78374_a(var24, p_78599_5_ + (double)p_78599_9_, var28, var16, var14);
      var10.func_78374_a(var24, p_78599_5_ + (double)p_78599_9_, var28, var12, var14);
      var10.func_78374_a(var24, p_78599_5_ + 0.0D, var28, var12, var18);
      var10.func_78374_a(var22, p_78599_5_ + 0.0D, var26, var16, var18);
      var10.func_78374_a(var22, p_78599_5_ + (double)p_78599_9_, var26, var16, var14);
      var10.func_78374_a(var22, p_78599_5_ + (double)p_78599_9_, var28, var12, var14);
      var10.func_78374_a(var22, p_78599_5_ + 0.0D, var28, var12, var18);
      var10.func_78374_a(var24, p_78599_5_ + 0.0D, var26, var16, var18);
      var10.func_78374_a(var24, p_78599_5_ + (double)p_78599_9_, var26, var16, var14);
      var10.func_78374_a(var24, p_78599_5_ + (double)p_78599_9_, var26, var12, var14);
      var10.func_78374_a(var24, p_78599_5_ + 0.0D, var26, var12, var18);
      var10.func_78374_a(var22, p_78599_5_ + 0.0D, var28, var16, var18);
      var10.func_78374_a(var22, p_78599_5_ + (double)p_78599_9_, var28, var16, var14);
   }

   public void func_78575_a(Block p_78575_1_, int p_78575_2_, double p_78575_3_, double p_78575_5_, double p_78575_7_, double p_78575_9_) {
      Tessellator var11 = Tessellator.field_78398_a;
      Icon var12 = this.func_94165_a(p_78575_1_, 0, p_78575_2_);
      if(this.func_94167_b()) {
         var12 = this.field_78664_d;
      }

      double var13 = (double)var12.func_94209_e();
      double var15 = (double)var12.func_94206_g();
      double var17 = (double)var12.func_94212_f();
      double var19 = (double)var12.func_94207_b(p_78575_3_ * 16.0D);
      double var21 = p_78575_5_ + 0.5D - 0.44999998807907104D;
      double var23 = p_78575_5_ + 0.5D + 0.44999998807907104D;
      double var25 = p_78575_9_ + 0.5D - 0.44999998807907104D;
      double var27 = p_78575_9_ + 0.5D + 0.44999998807907104D;
      var11.func_78374_a(var21, p_78575_7_ + p_78575_3_, var25, var13, var15);
      var11.func_78374_a(var21, p_78575_7_ + 0.0D, var25, var13, var19);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var27, var17, var19);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var27, var17, var15);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var27, var13, var15);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var27, var13, var19);
      var11.func_78374_a(var21, p_78575_7_ + 0.0D, var25, var17, var19);
      var11.func_78374_a(var21, p_78575_7_ + p_78575_3_, var25, var17, var15);
      var11.func_78374_a(var21, p_78575_7_ + p_78575_3_, var27, var13, var15);
      var11.func_78374_a(var21, p_78575_7_ + 0.0D, var27, var13, var19);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var25, var17, var19);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var25, var17, var15);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var25, var13, var15);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var25, var13, var19);
      var11.func_78374_a(var21, p_78575_7_ + 0.0D, var27, var17, var19);
      var11.func_78374_a(var21, p_78575_7_ + p_78575_3_, var27, var17, var15);
   }

   public boolean func_78566_o(Block p_78566_1_, int p_78566_2_, int p_78566_3_, int p_78566_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      Icon var6 = this.func_94173_a(p_78566_1_, 1);
      if(this.func_94167_b()) {
         var6 = this.field_78664_d;
      }

      float var7 = 0.015625F;
      double var8 = (double)var6.func_94209_e();
      double var10 = (double)var6.func_94206_g();
      double var12 = (double)var6.func_94212_f();
      double var14 = (double)var6.func_94210_h();
      long var16 = (long)(p_78566_2_ * 3129871) ^ (long)p_78566_4_ * 116129781L ^ (long)p_78566_3_;
      var16 = var16 * var16 * 42317861L + var16 * 11L;
      int var18 = (int)(var16 >> 16 & 3L);
      var5.func_78380_c(p_78566_1_.func_71874_e(this.field_78669_a, p_78566_2_, p_78566_3_, p_78566_4_));
      float var19 = (float)p_78566_2_ + 0.5F;
      float var20 = (float)p_78566_4_ + 0.5F;
      float var21 = (float)(var18 & 1) * 0.5F * (float)(1 - var18 / 2 % 2 * 2);
      float var22 = (float)(var18 + 1 & 1) * 0.5F * (float)(1 - (var18 + 1) / 2 % 2 * 2);
      var5.func_78378_d(p_78566_1_.func_71933_m());
      var5.func_78374_a((double)(var19 + var21 - var22), (double)((float)p_78566_3_ + var7), (double)(var20 + var21 + var22), var8, var10);
      var5.func_78374_a((double)(var19 + var21 + var22), (double)((float)p_78566_3_ + var7), (double)(var20 - var21 + var22), var12, var10);
      var5.func_78374_a((double)(var19 - var21 + var22), (double)((float)p_78566_3_ + var7), (double)(var20 - var21 - var22), var12, var14);
      var5.func_78374_a((double)(var19 - var21 - var22), (double)((float)p_78566_3_ + var7), (double)(var20 + var21 - var22), var8, var14);
      var5.func_78378_d((p_78566_1_.func_71933_m() & 16711422) >> 1);
      var5.func_78374_a((double)(var19 - var21 - var22), (double)((float)p_78566_3_ + var7), (double)(var20 + var21 - var22), var8, var14);
      var5.func_78374_a((double)(var19 - var21 + var22), (double)((float)p_78566_3_ + var7), (double)(var20 - var21 - var22), var12, var14);
      var5.func_78374_a((double)(var19 + var21 + var22), (double)((float)p_78566_3_ + var7), (double)(var20 - var21 + var22), var12, var10);
      var5.func_78374_a((double)(var19 + var21 - var22), (double)((float)p_78566_3_ + var7), (double)(var20 + var21 + var22), var8, var10);
      return true;
   }

   public void func_78606_a(BlockStem p_78606_1_, int p_78606_2_, int p_78606_3_, double p_78606_4_, double p_78606_6_, double p_78606_8_, double p_78606_10_) {
      Tessellator var12 = Tessellator.field_78398_a;
      Icon var13 = p_78606_1_.func_94368_p();
      if(this.func_94167_b()) {
         var13 = this.field_78664_d;
      }

      double var14 = (double)var13.func_94209_e();
      double var16 = (double)var13.func_94206_g();
      double var18 = (double)var13.func_94212_f();
      double var20 = (double)var13.func_94210_h();
      double var22 = p_78606_6_ + 0.5D - 0.5D;
      double var24 = p_78606_6_ + 0.5D + 0.5D;
      double var26 = p_78606_10_ + 0.5D - 0.5D;
      double var28 = p_78606_10_ + 0.5D + 0.5D;
      double var30 = p_78606_6_ + 0.5D;
      double var32 = p_78606_10_ + 0.5D;
      if((p_78606_3_ + 1) / 2 % 2 == 1) {
         double var34 = var18;
         var18 = var14;
         var14 = var34;
      }

      if(p_78606_3_ < 2) {
         var12.func_78374_a(var22, p_78606_8_ + p_78606_4_, var32, var14, var16);
         var12.func_78374_a(var22, p_78606_8_ + 0.0D, var32, var14, var20);
         var12.func_78374_a(var24, p_78606_8_ + 0.0D, var32, var18, var20);
         var12.func_78374_a(var24, p_78606_8_ + p_78606_4_, var32, var18, var16);
         var12.func_78374_a(var24, p_78606_8_ + p_78606_4_, var32, var18, var16);
         var12.func_78374_a(var24, p_78606_8_ + 0.0D, var32, var18, var20);
         var12.func_78374_a(var22, p_78606_8_ + 0.0D, var32, var14, var20);
         var12.func_78374_a(var22, p_78606_8_ + p_78606_4_, var32, var14, var16);
      } else {
         var12.func_78374_a(var30, p_78606_8_ + p_78606_4_, var28, var14, var16);
         var12.func_78374_a(var30, p_78606_8_ + 0.0D, var28, var14, var20);
         var12.func_78374_a(var30, p_78606_8_ + 0.0D, var26, var18, var20);
         var12.func_78374_a(var30, p_78606_8_ + p_78606_4_, var26, var18, var16);
         var12.func_78374_a(var30, p_78606_8_ + p_78606_4_, var26, var18, var16);
         var12.func_78374_a(var30, p_78606_8_ + 0.0D, var26, var18, var20);
         var12.func_78374_a(var30, p_78606_8_ + 0.0D, var28, var14, var20);
         var12.func_78374_a(var30, p_78606_8_ + p_78606_4_, var28, var14, var16);
      }

   }

   public void func_78579_b(Block p_78579_1_, int p_78579_2_, double p_78579_3_, double p_78579_5_, double p_78579_7_) {
      Tessellator var9 = Tessellator.field_78398_a;
      Icon var10 = this.func_94165_a(p_78579_1_, 0, p_78579_2_);
      if(this.func_94167_b()) {
         var10 = this.field_78664_d;
      }

      double var11 = (double)var10.func_94209_e();
      double var13 = (double)var10.func_94206_g();
      double var15 = (double)var10.func_94212_f();
      double var17 = (double)var10.func_94210_h();
      double var19 = p_78579_3_ + 0.5D - 0.25D;
      double var21 = p_78579_3_ + 0.5D + 0.25D;
      double var23 = p_78579_7_ + 0.5D - 0.5D;
      double var25 = p_78579_7_ + 0.5D + 0.5D;
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var25, var15, var13);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var15, var13);
      var19 = p_78579_3_ + 0.5D - 0.5D;
      var21 = p_78579_3_ + 0.5D + 0.5D;
      var23 = p_78579_7_ + 0.5D - 0.25D;
      var25 = p_78579_7_ + 0.5D + 0.25D;
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var25, var15, var13);
      var9.func_78374_a(var19, p_78579_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var19, p_78579_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var15, var13);
   }

   public boolean func_78621_p(Block p_78621_1_, int p_78621_2_, int p_78621_3_, int p_78621_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78621_1_.func_71920_b(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      boolean var10 = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ + 1, p_78621_4_, 1);
      boolean var11 = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_, 0);
      boolean[] var12 = new boolean[]{p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ - 1, 2), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ + 1, 3), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ - 1, p_78621_3_, p_78621_4_, 4), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ + 1, p_78621_3_, p_78621_4_, 5)};
      if(!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
         return false;
      } else {
         boolean var13 = false;
         float var14 = 0.5F;
         float var15 = 1.0F;
         float var16 = 0.8F;
         float var17 = 0.6F;
         double var18 = 0.0D;
         double var20 = 1.0D;
         Material var22 = p_78621_1_.field_72018_cp;
         int var23 = this.field_78669_a.func_72805_g(p_78621_2_, p_78621_3_, p_78621_4_);
         double var24 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_, var22);
         double var26 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_ + 1, var22);
         double var28 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_ + 1, var22);
         double var30 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_, var22);
         double var32 = 0.0010000000474974513D;
         float var53;
         float var52;
         if(this.field_78661_f || var10) {
            var13 = true;
            Icon var34 = this.func_94165_a(p_78621_1_, 1, var23);
            float var35 = (float)BlockFluid.func_72204_a(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_, var22);
            if(var35 > -999.0F) {
               var34 = this.func_94165_a(p_78621_1_, 2, var23);
            }

            var24 -= var32;
            var26 -= var32;
            var28 -= var32;
            var30 -= var32;
            double var38;
            double var36;
            double var42;
            double var40;
            double var46;
            double var44;
            double var50;
            double var48;
            if(var35 < -999.0F) {
               var36 = (double)var34.func_94214_a(0.0D);
               var44 = (double)var34.func_94207_b(0.0D);
               var38 = var36;
               var46 = (double)var34.func_94207_b(16.0D);
               var40 = (double)var34.func_94214_a(16.0D);
               var48 = var46;
               var42 = var40;
               var50 = var44;
            } else {
               var52 = MathHelper.func_76126_a(var35) * 0.25F;
               var53 = MathHelper.func_76134_b(var35) * 0.25F;
               var36 = (double)var34.func_94214_a((double)(8.0F + (-var53 - var52) * 16.0F));
               var44 = (double)var34.func_94207_b((double)(8.0F + (-var53 + var52) * 16.0F));
               var38 = (double)var34.func_94214_a((double)(8.0F + (-var53 + var52) * 16.0F));
               var46 = (double)var34.func_94207_b((double)(8.0F + (var53 + var52) * 16.0F));
               var40 = (double)var34.func_94214_a((double)(8.0F + (var53 + var52) * 16.0F));
               var48 = (double)var34.func_94207_b((double)(8.0F + (var53 - var52) * 16.0F));
               var42 = (double)var34.func_94214_a((double)(8.0F + (var53 - var52) * 16.0F));
               var50 = (double)var34.func_94207_b((double)(8.0F + (-var53 - var52) * 16.0F));
            }

            var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_));
            var52 = 1.0F;
            var5.func_78386_a(var15 * var52 * var7, var15 * var52 * var8, var15 * var52 * var9);
            var5.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + var24, (double)(p_78621_4_ + 0), var36, var44);
            var5.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + var26, (double)(p_78621_4_ + 1), var38, var46);
            var5.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + var28, (double)(p_78621_4_ + 1), var40, var48);
            var5.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + var30, (double)(p_78621_4_ + 0), var42, var50);
         }

         if(this.field_78661_f || var11) {
            var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_));
            float var58 = 1.0F;
            var5.func_78386_a(var14 * var58, var14 * var58, var14 * var58);
            this.func_78613_a(p_78621_1_, (double)p_78621_2_, (double)p_78621_3_ + var32, (double)p_78621_4_, this.func_94173_a(p_78621_1_, 0));
            var13 = true;
         }

         for(int var57 = 0; var57 < 4; ++var57) {
            int var59 = p_78621_2_;
            int var37 = p_78621_4_;
            if(var57 == 0) {
               var37 = p_78621_4_ - 1;
            }

            if(var57 == 1) {
               ++var37;
            }

            if(var57 == 2) {
               var59 = p_78621_2_ - 1;
            }

            if(var57 == 3) {
               ++var59;
            }

            Icon var60 = this.func_94165_a(p_78621_1_, var57 + 2, var23);
            if(this.field_78661_f || var12[var57]) {
               double var39;
               double var43;
               double var41;
               double var47;
               double var45;
               double var49;
               if(var57 == 0) {
                  var39 = var24;
                  var41 = var30;
                  var43 = (double)p_78621_2_;
                  var47 = (double)(p_78621_2_ + 1);
                  var45 = (double)p_78621_4_ + var32;
                  var49 = (double)p_78621_4_ + var32;
               } else if(var57 == 1) {
                  var39 = var28;
                  var41 = var26;
                  var43 = (double)(p_78621_2_ + 1);
                  var47 = (double)p_78621_2_;
                  var45 = (double)(p_78621_4_ + 1) - var32;
                  var49 = (double)(p_78621_4_ + 1) - var32;
               } else if(var57 == 2) {
                  var39 = var26;
                  var41 = var24;
                  var43 = (double)p_78621_2_ + var32;
                  var47 = (double)p_78621_2_ + var32;
                  var45 = (double)(p_78621_4_ + 1);
                  var49 = (double)p_78621_4_;
               } else {
                  var39 = var30;
                  var41 = var28;
                  var43 = (double)(p_78621_2_ + 1) - var32;
                  var47 = (double)(p_78621_2_ + 1) - var32;
                  var45 = (double)p_78621_4_;
                  var49 = (double)(p_78621_4_ + 1);
               }

               var13 = true;
               float var51 = var60.func_94214_a(0.0D);
               var52 = var60.func_94214_a(8.0D);
               var53 = var60.func_94207_b((1.0D - var39) * 16.0D * 0.5D);
               float var54 = var60.func_94207_b((1.0D - var41) * 16.0D * 0.5D);
               float var55 = var60.func_94207_b(8.0D);
               var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, var59, p_78621_3_, var37));
               float var56 = 1.0F;
               if(var57 < 2) {
                  var56 *= var16;
               } else {
                  var56 *= var17;
               }

               var5.func_78386_a(var15 * var56 * var7, var15 * var56 * var8, var15 * var56 * var9);
               var5.func_78374_a(var43, (double)p_78621_3_ + var39, var45, (double)var51, (double)var53);
               var5.func_78374_a(var47, (double)p_78621_3_ + var41, var49, (double)var52, (double)var54);
               var5.func_78374_a(var47, (double)(p_78621_3_ + 0), var49, (double)var52, (double)var55);
               var5.func_78374_a(var43, (double)(p_78621_3_ + 0), var45, (double)var51, (double)var55);
            }
         }

         this.field_83027_i = var18;
         this.field_83024_j = var20;
         return var13;
      }
   }

   public float func_78596_a(int p_78596_1_, int p_78596_2_, int p_78596_3_, Material p_78596_4_) {
      int var5 = 0;
      float var6 = 0.0F;

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_78596_1_ - (var7 & 1);
         int var10 = p_78596_3_ - (var7 >> 1 & 1);
         if(this.field_78669_a.func_72803_f(var8, p_78596_2_ + 1, var10) == p_78596_4_) {
            return 1.0F;
         }

         Material var11 = this.field_78669_a.func_72803_f(var8, p_78596_2_, var10);
         if(var11 == p_78596_4_) {
            int var12 = this.field_78669_a.func_72805_g(var8, p_78596_2_, var10);
            if(var12 >= 8 || var12 == 0) {
               var6 += BlockFluid.func_72199_d(var12) * 10.0F;
               var5 += 10;
            }

            var6 += BlockFluid.func_72199_d(var12);
            ++var5;
         } else if(!var11.func_76220_a()) {
            ++var6;
            ++var5;
         }
      }

      return 1.0F - var6 / (float)var5;
   }

   public void func_78588_a(Block p_78588_1_, World p_78588_2_, int p_78588_3_, int p_78588_4_, int p_78588_5_, int p_78588_6_) {
      float var7 = 0.5F;
      float var8 = 1.0F;
      float var9 = 0.8F;
      float var10 = 0.6F;
      Tessellator var11 = Tessellator.field_78398_a;
      var11.func_78382_b();
      var11.func_78380_c(p_78588_1_.func_71874_e(p_78588_2_, p_78588_3_, p_78588_4_, p_78588_5_));
      float var12 = 1.0F;
      float var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var7 * var13, var7 * var13, var7 * var13);
      this.func_78613_a(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 0, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var8 * var13, var8 * var13, var8 * var13);
      this.func_78617_b(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 1, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var9 * var13, var9 * var13, var9 * var13);
      this.func_78611_c(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 2, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var9 * var13, var9 * var13, var9 * var13);
      this.func_78622_d(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 3, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var10 * var13, var10 * var13, var10 * var13);
      this.func_78573_e(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 4, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var10 * var13, var10 * var13, var10 * var13);
      this.func_78605_f(p_78588_1_, -0.5D, -0.5D, -0.5D, this.func_94165_a(p_78588_1_, 5, p_78588_6_));
      var11.func_78381_a();
   }

   public boolean func_78570_q(Block p_78570_1_, int p_78570_2_, int p_78570_3_, int p_78570_4_) {
      int var5 = p_78570_1_.func_71920_b(this.field_78669_a, p_78570_2_, p_78570_3_, p_78570_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return Minecraft.func_71379_u() && Block.field_71984_q[p_78570_1_.field_71990_ca] == 0?(this.field_98189_n?this.func_102027_b(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, var6, var7, var8):this.func_78578_a(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, var6, var7, var8)):this.func_78609_c(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, var6, var7, var8);
   }

   public boolean func_78581_r(Block p_78581_1_, int p_78581_2_, int p_78581_3_, int p_78581_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78581_2_, p_78581_3_, p_78581_4_);
      int var6 = var5 & 12;
      if(var6 == 4) {
         this.field_78662_g = 1;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 1;
      } else if(var6 == 8) {
         this.field_78685_i = 1;
         this.field_78679_j = 1;
      }

      boolean var7 = this.func_78570_q(p_78581_1_, p_78581_2_, p_78581_3_, p_78581_4_);
      this.field_78685_i = 0;
      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      return var7;
   }

   public boolean func_96445_r(Block p_96445_1_, int p_96445_2_, int p_96445_3_, int p_96445_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_96445_2_, p_96445_3_, p_96445_4_);
      if(var5 == 3) {
         this.field_78662_g = 1;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 1;
      } else if(var5 == 4) {
         this.field_78685_i = 1;
         this.field_78679_j = 1;
      }

      boolean var6 = this.func_78570_q(p_96445_1_, p_96445_2_, p_96445_3_, p_96445_4_);
      this.field_78685_i = 0;
      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      return var6;
   }

   public boolean func_78578_a(Block p_78578_1_, int p_78578_2_, int p_78578_3_, int p_78578_4_, float p_78578_5_, float p_78578_6_, float p_78578_7_) {
      this.field_78677_m = true;
      boolean var8 = false;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = true;
      int var14 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
      Tessellator var15 = Tessellator.field_78398_a;
      var15.func_78380_c(983055);
      if(this.func_94175_b(p_78578_1_).func_94215_i().equals("grass_top")) {
         var13 = false;
      } else if(this.func_94167_b()) {
         var13 = false;
      }

      boolean var17;
      boolean var16;
      boolean var19;
      boolean var18;
      float var21;
      int var20;
      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_, 0)) {
         if(this.field_83027_i <= 0.0D) {
            --p_78578_3_;
         }

         this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];
         if(!var19 && !var17) {
            this.field_78691_u = this.field_78689_v;
            this.field_78649_S = this.field_78641_T;
         } else {
            this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_78687_w = this.field_78689_v;
            this.field_78639_U = this.field_78641_T;
         } else {
            this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
         }

         if(!var19 && !var16) {
            this.field_78708_z = this.field_78628_A;
            this.field_78657_X = this.field_78655_Y;
         } else {
            this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
         }

         if(!var18 && !var16) {
            this.field_78629_B = this.field_78628_A;
            this.field_78660_Z = this.field_78655_Y;
         } else {
            this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
         }

         if(this.field_83027_i <= 0.0D) {
            ++p_78578_3_;
         }

         var20 = var14;
         if(this.field_83027_i <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_ - 1, p_78578_4_)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         var9 = (this.field_78687_w + this.field_78689_v + this.field_78710_y + var21) / 4.0F;
         var12 = (this.field_78710_y + var21 + this.field_78629_B + this.field_78628_A) / 4.0F;
         var11 = (var21 + this.field_78712_x + this.field_78628_A + this.field_78708_z) / 4.0F;
         var10 = (this.field_78689_v + this.field_78691_u + var21 + this.field_78712_x) / 4.0F;
         this.field_78700_an = this.func_78602_a(this.field_78639_U, this.field_78641_T, this.field_78643_W, var20);
         this.field_78676_aq = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78655_Y, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78655_Y, this.field_78657_X, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78641_T, this.field_78649_S, this.field_78645_V, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.5F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.5F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.5F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.5F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.5F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.5F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78613_a(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 0));
         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_, 1)) {
         if(this.field_83024_j >= 1.0D) {
            ++p_78578_3_;
         }

         this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];
         if(!var19 && !var17) {
            this.field_78630_C = this.field_78624_D;
            this.field_78704_aa = this.field_78705_ab;
         } else {
            this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_78627_G = this.field_78634_H;
            this.field_78709_ae = this.field_78711_af;
         } else {
            this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_78625_E = this.field_78624_D;
            this.field_78702_ac = this.field_78705_ab;
         } else {
            this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_78636_J = this.field_78634_H;
            this.field_78707_ah = this.field_78711_af;
         } else {
            this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
         }

         if(this.field_83024_j >= 1.0D) {
            --p_78578_3_;
         }

         var20 = var14;
         if(this.field_83024_j >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_ + 1, p_78578_4_)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         var12 = (this.field_78625_E + this.field_78624_D + this.field_78635_I + var21) / 4.0F;
         var9 = (this.field_78635_I + var21 + this.field_78636_J + this.field_78634_H) / 4.0F;
         var10 = (var21 + this.field_78626_F + this.field_78634_H + this.field_78627_G) / 4.0F;
         var11 = (this.field_78624_D + this.field_78630_C + var21 + this.field_78626_F) / 4.0F;
         this.field_78676_aq = this.func_78602_a(this.field_78702_ac, this.field_78705_ab, this.field_78706_ag, var20);
         this.field_78700_an = this.func_78602_a(this.field_78706_ag, this.field_78707_ah, this.field_78711_af, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78711_af, this.field_78709_ae, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78705_ab, this.field_78704_aa, this.field_78703_ad, var20);
         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78617_b(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 1));
         var8 = true;
      }

      Icon var22;
      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1, 2)) {
         if(this.field_83025_k <= 0.0D) {
            --p_78578_4_;
         }

         this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];
         if(!var17 && !var19) {
            this.field_78691_u = this.field_78637_K;
            this.field_78649_S = this.field_78690_ai;
         } else {
            this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
         }

         if(!var17 && !var18) {
            this.field_78630_C = this.field_78637_K;
            this.field_78704_aa = this.field_78690_ai;
         } else {
            this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
         }

         if(!var16 && !var19) {
            this.field_78708_z = this.field_78631_L;
            this.field_78657_X = this.field_78692_aj;
         } else {
            this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
         }

         if(!var16 && !var18) {
            this.field_78627_G = this.field_78631_L;
            this.field_78709_ae = this.field_78692_aj;
         } else {
            this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
         }

         if(this.field_83025_k <= 0.0D) {
            ++p_78578_4_;
         }

         var20 = var14;
         if(this.field_83025_k <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_, p_78578_4_ - 1)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         var9 = (this.field_78637_K + this.field_78630_C + var21 + this.field_78626_F) / 4.0F;
         var10 = (var21 + this.field_78626_F + this.field_78631_L + this.field_78627_G) / 4.0F;
         var11 = (this.field_78712_x + var21 + this.field_78708_z + this.field_78631_L) / 4.0F;
         var12 = (this.field_78691_u + this.field_78637_K + this.field_78712_x + var21) / 4.0F;
         this.field_78700_an = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78703_ad, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78692_aj, this.field_78709_ae, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78657_X, this.field_78692_aj, var20);
         this.field_78676_aq = this.func_78602_a(this.field_78649_S, this.field_78690_ai, this.field_78645_V, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.8F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var22 = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 2);
         this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var22);
         if(field_78667_b && var22.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1, 3)) {
         if(this.field_83022_l >= 1.0D) {
            ++p_78578_4_;
         }

         this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];
         if(!var17 && !var19) {
            this.field_78687_w = this.field_78632_M;
            this.field_78639_U = this.field_78686_ak;
         } else {
            this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
         }

         if(!var17 && !var18) {
            this.field_78625_E = this.field_78632_M;
            this.field_78702_ac = this.field_78686_ak;
         } else {
            this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
         }

         if(!var16 && !var19) {
            this.field_78629_B = this.field_78633_N;
            this.field_78660_Z = this.field_78688_al;
         } else {
            this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
         }

         if(!var16 && !var18) {
            this.field_78636_J = this.field_78633_N;
            this.field_78707_ah = this.field_78688_al;
         } else {
            this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
         }

         if(this.field_83022_l >= 1.0D) {
            --p_78578_4_;
         }

         var20 = var14;
         if(this.field_83022_l >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_, p_78578_3_, p_78578_4_ + 1)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         var9 = (this.field_78632_M + this.field_78625_E + var21 + this.field_78635_I) / 4.0F;
         var12 = (var21 + this.field_78635_I + this.field_78633_N + this.field_78636_J) / 4.0F;
         var11 = (this.field_78710_y + var21 + this.field_78629_B + this.field_78633_N) / 4.0F;
         var10 = (this.field_78687_w + this.field_78632_M + this.field_78710_y + var21) / 4.0F;
         this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78702_ac, this.field_78706_ag, var20);
         this.field_78676_aq = this.func_78602_a(this.field_78706_ag, this.field_78688_al, this.field_78707_ah, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78688_al, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78639_U, this.field_78686_ak, this.field_78643_W, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.8F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var22 = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3);
         this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3));
         if(field_78667_b && var22.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_, 4)) {
         if(this.field_83021_g <= 0.0D) {
            --p_78578_2_;
         }

         this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];
         if(!var18 && !var17) {
            this.field_78691_u = this.field_78637_K;
            this.field_78649_S = this.field_78690_ai;
         } else {
            this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
         }

         if(!var19 && !var17) {
            this.field_78687_w = this.field_78632_M;
            this.field_78639_U = this.field_78686_ak;
         } else {
            this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_78630_C = this.field_78637_K;
            this.field_78704_aa = this.field_78690_ai;
         } else {
            this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_78625_E = this.field_78632_M;
            this.field_78702_ac = this.field_78686_ak;
         } else {
            this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
         }

         if(this.field_83021_g <= 0.0D) {
            ++p_78578_2_;
         }

         var20 = var14;
         if(this.field_83021_g <= 0.0D || !this.field_78669_a.func_72804_r(p_78578_2_ - 1, p_78578_3_, p_78578_4_)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
         var12 = (this.field_78689_v + this.field_78687_w + var21 + this.field_78632_M) / 4.0F;
         var9 = (var21 + this.field_78632_M + this.field_78624_D + this.field_78625_E) / 4.0F;
         var10 = (this.field_78637_K + var21 + this.field_78630_C + this.field_78624_D) / 4.0F;
         var11 = (this.field_78691_u + this.field_78689_v + this.field_78637_K + var21) / 4.0F;
         this.field_78676_aq = this.func_78602_a(this.field_78641_T, this.field_78639_U, this.field_78686_ak, var20);
         this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78705_ab, this.field_78702_ac, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78705_ab, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78649_S, this.field_78641_T, this.field_78690_ai, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.6F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var22 = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 4);
         this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var22);
         if(field_78667_b && var22.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_, 5)) {
         if(this.field_83026_h >= 1.0D) {
            ++p_78578_2_;
         }

         this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
         this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
         this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
         this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];
         if(!var17 && !var19) {
            this.field_78708_z = this.field_78631_L;
            this.field_78657_X = this.field_78692_aj;
         } else {
            this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
         }

         if(!var17 && !var18) {
            this.field_78629_B = this.field_78633_N;
            this.field_78660_Z = this.field_78688_al;
         } else {
            this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
         }

         if(!var16 && !var19) {
            this.field_78627_G = this.field_78631_L;
            this.field_78709_ae = this.field_78692_aj;
         } else {
            this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
         }

         if(!var16 && !var18) {
            this.field_78636_J = this.field_78633_N;
            this.field_78707_ah = this.field_78688_al;
         } else {
            this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
         }

         if(this.field_83026_h >= 1.0D) {
            --p_78578_2_;
         }

         var20 = var14;
         if(this.field_83026_h >= 1.0D || !this.field_78669_a.func_72804_r(p_78578_2_ + 1, p_78578_3_, p_78578_4_)) {
            var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         }

         var21 = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
         var9 = (this.field_78628_A + this.field_78629_B + var21 + this.field_78633_N) / 4.0F;
         var10 = (this.field_78708_z + this.field_78628_A + this.field_78631_L + var21) / 4.0F;
         var11 = (this.field_78631_L + var21 + this.field_78627_G + this.field_78634_H) / 4.0F;
         var12 = (var21 + this.field_78633_N + this.field_78634_H + this.field_78636_J) / 4.0F;
         this.field_78700_an = this.func_78602_a(this.field_78655_Y, this.field_78660_Z, this.field_78688_al, var20);
         this.field_78676_aq = this.func_78602_a(this.field_78688_al, this.field_78711_af, this.field_78707_ah, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78692_aj, this.field_78709_ae, this.field_78711_af, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78657_X, this.field_78655_Y, this.field_78692_aj, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_78578_5_ * 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_78578_6_ * 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_78578_7_ * 0.6F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var22 = this.func_94170_a(p_78578_1_, this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 5);
         this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var22);
         if(field_78667_b && var22.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      this.field_78677_m = false;
      return var8;
   }

   public boolean func_102027_b(Block p_102027_1_, int p_102027_2_, int p_102027_3_, int p_102027_4_, float p_102027_5_, float p_102027_6_, float p_102027_7_) {
      this.field_78677_m = true;
      boolean var8 = false;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = true;
      int var14 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_);
      Tessellator var15 = Tessellator.field_78398_a;
      var15.func_78380_c(983055);
      if(this.func_94175_b(p_102027_1_).func_94215_i().equals("grass_top")) {
         var13 = false;
      } else if(this.func_94167_b()) {
         var13 = false;
      }

      boolean var17;
      boolean var16;
      boolean var19;
      boolean var18;
      float var21;
      int var20;
      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_, 0)) {
         if(this.field_83027_i <= 0.0D) {
            --p_102027_3_;
         }

         this.field_78641_T = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78645_V = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78643_W = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78655_Y = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78689_v = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78712_x = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78710_y = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78628_A = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1)];
         if(!var19 && !var17) {
            this.field_78691_u = this.field_78689_v;
            this.field_78649_S = this.field_78641_T;
         } else {
            this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
            this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_78687_w = this.field_78689_v;
            this.field_78639_U = this.field_78641_T;
         } else {
            this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
            this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
         }

         if(!var19 && !var16) {
            this.field_78708_z = this.field_78628_A;
            this.field_78657_X = this.field_78655_Y;
         } else {
            this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
            this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
         }

         if(!var18 && !var16) {
            this.field_78629_B = this.field_78628_A;
            this.field_78660_Z = this.field_78655_Y;
         } else {
            this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
            this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
         }

         if(this.field_83027_i <= 0.0D) {
            ++p_102027_3_;
         }

         var20 = var14;
         if(this.field_83027_i <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_ - 1, p_102027_4_)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         var9 = (this.field_78687_w + this.field_78689_v + this.field_78710_y + var21) / 4.0F;
         var12 = (this.field_78710_y + var21 + this.field_78629_B + this.field_78628_A) / 4.0F;
         var11 = (var21 + this.field_78712_x + this.field_78628_A + this.field_78708_z) / 4.0F;
         var10 = (this.field_78689_v + this.field_78691_u + var21 + this.field_78712_x) / 4.0F;
         this.field_78700_an = this.func_78602_a(this.field_78639_U, this.field_78641_T, this.field_78643_W, var20);
         this.field_78676_aq = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78655_Y, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78655_Y, this.field_78657_X, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78641_T, this.field_78649_S, this.field_78645_V, var20);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.5F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.5F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.5F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.5F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.5F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.5F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78613_a(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 0));
         var8 = true;
      }

      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_, 1)) {
         if(this.field_83024_j >= 1.0D) {
            ++p_102027_3_;
         }

         this.field_78705_ab = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78711_af = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78703_ad = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78706_ag = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78624_D = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78634_H = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78626_F = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78635_I = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1)];
         if(!var19 && !var17) {
            this.field_78630_C = this.field_78624_D;
            this.field_78704_aa = this.field_78705_ab;
         } else {
            this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
            this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_78627_G = this.field_78634_H;
            this.field_78709_ae = this.field_78711_af;
         } else {
            this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
            this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_78625_E = this.field_78624_D;
            this.field_78702_ac = this.field_78705_ab;
         } else {
            this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
            this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_78636_J = this.field_78634_H;
            this.field_78707_ah = this.field_78711_af;
         } else {
            this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
            this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1);
         }

         if(this.field_83024_j >= 1.0D) {
            --p_102027_3_;
         }

         var20 = var14;
         if(this.field_83024_j >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_ + 1, p_102027_4_)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         var12 = (this.field_78625_E + this.field_78624_D + this.field_78635_I + var21) / 4.0F;
         var9 = (this.field_78635_I + var21 + this.field_78636_J + this.field_78634_H) / 4.0F;
         var10 = (var21 + this.field_78626_F + this.field_78634_H + this.field_78627_G) / 4.0F;
         var11 = (this.field_78624_D + this.field_78630_C + var21 + this.field_78626_F) / 4.0F;
         this.field_78676_aq = this.func_78602_a(this.field_78702_ac, this.field_78705_ab, this.field_78706_ag, var20);
         this.field_78700_an = this.func_78602_a(this.field_78706_ag, this.field_78707_ah, this.field_78711_af, var20);
         this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78711_af, this.field_78709_ae, var20);
         this.field_78696_ap = this.func_78602_a(this.field_78705_ab, this.field_78704_aa, this.field_78703_ad, var20);
         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78617_b(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 1));
         var8 = true;
      }

      float var23;
      float var22;
      float var25;
      float var24;
      int var27;
      int var26;
      int var29;
      int var28;
      Icon var30;
      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1, 2)) {
         if(this.field_83025_k <= 0.0D) {
            --p_102027_4_;
         }

         this.field_78637_K = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78712_x = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78626_F = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         this.field_78631_L = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78690_ai = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78645_V = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78703_ad = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         this.field_78692_aj = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1)];
         if(!var17 && !var19) {
            this.field_78691_u = this.field_78637_K;
            this.field_78649_S = this.field_78690_ai;
         } else {
            this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
            this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
         }

         if(!var17 && !var18) {
            this.field_78630_C = this.field_78637_K;
            this.field_78704_aa = this.field_78690_ai;
         } else {
            this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
            this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
         }

         if(!var16 && !var19) {
            this.field_78708_z = this.field_78631_L;
            this.field_78657_X = this.field_78692_aj;
         } else {
            this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
            this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
         }

         if(!var16 && !var18) {
            this.field_78627_G = this.field_78631_L;
            this.field_78709_ae = this.field_78692_aj;
         } else {
            this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
            this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
         }

         if(this.field_83025_k <= 0.0D) {
            ++p_102027_4_;
         }

         var20 = var14;
         if(this.field_83025_k <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_, p_102027_4_ - 1)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         var22 = (this.field_78637_K + this.field_78630_C + var21 + this.field_78626_F) / 4.0F;
         var23 = (var21 + this.field_78626_F + this.field_78631_L + this.field_78627_G) / 4.0F;
         var24 = (this.field_78712_x + var21 + this.field_78708_z + this.field_78631_L) / 4.0F;
         var25 = (this.field_78691_u + this.field_78637_K + this.field_78712_x + var21) / 4.0F;
         var9 = (float)((double)var22 * this.field_83024_j * (1.0D - this.field_83021_g) + (double)var23 * this.field_83027_i * this.field_83021_g + (double)var24 * (1.0D - this.field_83024_j) * this.field_83021_g + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
         var10 = (float)((double)var22 * this.field_83024_j * (1.0D - this.field_83026_h) + (double)var23 * this.field_83024_j * this.field_83026_h + (double)var24 * (1.0D - this.field_83024_j) * this.field_83026_h + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
         var11 = (float)((double)var22 * this.field_83027_i * (1.0D - this.field_83026_h) + (double)var23 * this.field_83027_i * this.field_83026_h + (double)var24 * (1.0D - this.field_83027_i) * this.field_83026_h + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
         var12 = (float)((double)var22 * this.field_83027_i * (1.0D - this.field_83021_g) + (double)var23 * this.field_83027_i * this.field_83021_g + (double)var24 * (1.0D - this.field_83027_i) * this.field_83021_g + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));
         var26 = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78703_ad, var20);
         var27 = this.func_78602_a(this.field_78703_ad, this.field_78692_aj, this.field_78709_ae, var20);
         var28 = this.func_78602_a(this.field_78645_V, this.field_78657_X, this.field_78692_aj, var20);
         var29 = this.func_78602_a(this.field_78649_S, this.field_78690_ai, this.field_78645_V, var20);
         this.field_78700_an = this.func_96444_a(var26, var27, var28, var29, this.field_83024_j * (1.0D - this.field_83021_g), this.field_83024_j * this.field_83021_g, (1.0D - this.field_83024_j) * this.field_83021_g, (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
         this.field_78694_ao = this.func_96444_a(var26, var27, var28, var29, this.field_83024_j * (1.0D - this.field_83026_h), this.field_83024_j * this.field_83026_h, (1.0D - this.field_83024_j) * this.field_83026_h, (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
         this.field_78696_ap = this.func_96444_a(var26, var27, var28, var29, this.field_83027_i * (1.0D - this.field_83026_h), this.field_83027_i * this.field_83026_h, (1.0D - this.field_83027_i) * this.field_83026_h, (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
         this.field_78676_aq = this.func_96444_a(var26, var27, var28, var29, this.field_83027_i * (1.0D - this.field_83021_g), this.field_83027_i * this.field_83021_g, (1.0D - this.field_83027_i) * this.field_83021_g, (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.8F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var30 = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 2);
         this.func_78611_c(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, var30);
         if(field_78667_b && var30.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_102027_5_;
            this.field_78672_as *= p_102027_5_;
            this.field_78670_at *= p_102027_5_;
            this.field_78684_au *= p_102027_5_;
            this.field_78682_av *= p_102027_6_;
            this.field_78680_aw *= p_102027_6_;
            this.field_78678_ax *= p_102027_6_;
            this.field_78665_ay *= p_102027_6_;
            this.field_78663_az *= p_102027_7_;
            this.field_78650_aA *= p_102027_7_;
            this.field_78651_aB *= p_102027_7_;
            this.field_78652_aC *= p_102027_7_;
            this.func_78611_c(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1, 3)) {
         if(this.field_83022_l >= 1.0D) {
            ++p_102027_4_;
         }

         this.field_78632_M = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78633_N = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78710_y = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78635_I = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         this.field_78686_ak = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         this.field_78688_al = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         this.field_78643_W = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78706_ag = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1)];
         if(!var17 && !var19) {
            this.field_78687_w = this.field_78632_M;
            this.field_78639_U = this.field_78686_ak;
         } else {
            this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
            this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_);
         }

         if(!var17 && !var18) {
            this.field_78625_E = this.field_78632_M;
            this.field_78702_ac = this.field_78686_ak;
         } else {
            this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
            this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_);
         }

         if(!var16 && !var19) {
            this.field_78629_B = this.field_78633_N;
            this.field_78660_Z = this.field_78688_al;
         } else {
            this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
            this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_);
         }

         if(!var16 && !var18) {
            this.field_78636_J = this.field_78633_N;
            this.field_78707_ah = this.field_78688_al;
         } else {
            this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
            this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_);
         }

         if(this.field_83022_l >= 1.0D) {
            --p_102027_4_;
         }

         var20 = var14;
         if(this.field_83022_l >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_, p_102027_3_, p_102027_4_ + 1)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         var22 = (this.field_78632_M + this.field_78625_E + var21 + this.field_78635_I) / 4.0F;
         var23 = (var21 + this.field_78635_I + this.field_78633_N + this.field_78636_J) / 4.0F;
         var24 = (this.field_78710_y + var21 + this.field_78629_B + this.field_78633_N) / 4.0F;
         var25 = (this.field_78687_w + this.field_78632_M + this.field_78710_y + var21) / 4.0F;
         var9 = (float)((double)var22 * this.field_83024_j * (1.0D - this.field_83021_g) + (double)var23 * this.field_83024_j * this.field_83021_g + (double)var24 * (1.0D - this.field_83024_j) * this.field_83021_g + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g));
         var10 = (float)((double)var22 * this.field_83027_i * (1.0D - this.field_83021_g) + (double)var23 * this.field_83027_i * this.field_83021_g + (double)var24 * (1.0D - this.field_83027_i) * this.field_83021_g + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g));
         var11 = (float)((double)var22 * this.field_83027_i * (1.0D - this.field_83026_h) + (double)var23 * this.field_83027_i * this.field_83026_h + (double)var24 * (1.0D - this.field_83027_i) * this.field_83026_h + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h));
         var12 = (float)((double)var22 * this.field_83024_j * (1.0D - this.field_83026_h) + (double)var23 * this.field_83024_j * this.field_83026_h + (double)var24 * (1.0D - this.field_83024_j) * this.field_83026_h + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h));
         var26 = this.func_78602_a(this.field_78686_ak, this.field_78702_ac, this.field_78706_ag, var20);
         var27 = this.func_78602_a(this.field_78706_ag, this.field_78688_al, this.field_78707_ah, var20);
         var28 = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78688_al, var20);
         var29 = this.func_78602_a(this.field_78639_U, this.field_78686_ak, this.field_78643_W, var20);
         this.field_78700_an = this.func_96444_a(var26, var29, var28, var27, this.field_83024_j * (1.0D - this.field_83021_g), (1.0D - this.field_83024_j) * (1.0D - this.field_83021_g), (1.0D - this.field_83024_j) * this.field_83021_g, this.field_83024_j * this.field_83021_g);
         this.field_78694_ao = this.func_96444_a(var26, var29, var28, var27, this.field_83027_i * (1.0D - this.field_83021_g), (1.0D - this.field_83027_i) * (1.0D - this.field_83021_g), (1.0D - this.field_83027_i) * this.field_83021_g, this.field_83027_i * this.field_83021_g);
         this.field_78696_ap = this.func_96444_a(var26, var29, var28, var27, this.field_83027_i * (1.0D - this.field_83026_h), (1.0D - this.field_83027_i) * (1.0D - this.field_83026_h), (1.0D - this.field_83027_i) * this.field_83026_h, this.field_83027_i * this.field_83026_h);
         this.field_78676_aq = this.func_96444_a(var26, var29, var28, var27, this.field_83024_j * (1.0D - this.field_83026_h), (1.0D - this.field_83024_j) * (1.0D - this.field_83026_h), (1.0D - this.field_83024_j) * this.field_83026_h, this.field_83024_j * this.field_83026_h);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.8F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.8F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.8F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.8F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var30 = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 3);
         this.func_78622_d(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 3));
         if(field_78667_b && var30.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_102027_5_;
            this.field_78672_as *= p_102027_5_;
            this.field_78670_at *= p_102027_5_;
            this.field_78684_au *= p_102027_5_;
            this.field_78682_av *= p_102027_6_;
            this.field_78680_aw *= p_102027_6_;
            this.field_78678_ax *= p_102027_6_;
            this.field_78665_ay *= p_102027_6_;
            this.field_78663_az *= p_102027_7_;
            this.field_78650_aA *= p_102027_7_;
            this.field_78651_aB *= p_102027_7_;
            this.field_78652_aC *= p_102027_7_;
            this.func_78622_d(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_, 4)) {
         if(this.field_83021_g <= 0.0D) {
            --p_102027_2_;
         }

         this.field_78689_v = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78637_K = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78632_M = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78624_D = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         this.field_78641_T = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78690_ai = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78686_ak = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78705_ab = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ + 1, p_102027_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_ - 1, p_102027_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ - 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ - 1, p_102027_3_, p_102027_4_ + 1)];
         if(!var18 && !var17) {
            this.field_78691_u = this.field_78637_K;
            this.field_78649_S = this.field_78690_ai;
         } else {
            this.field_78691_u = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
            this.field_78649_S = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
         }

         if(!var19 && !var17) {
            this.field_78687_w = this.field_78632_M;
            this.field_78639_U = this.field_78686_ak;
         } else {
            this.field_78687_w = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
            this.field_78639_U = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_78630_C = this.field_78637_K;
            this.field_78704_aa = this.field_78690_ai;
         } else {
            this.field_78630_C = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
            this.field_78704_aa = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_78625_E = this.field_78632_M;
            this.field_78702_ac = this.field_78686_ak;
         } else {
            this.field_78625_E = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
            this.field_78702_ac = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
         }

         if(this.field_83021_g <= 0.0D) {
            ++p_102027_2_;
         }

         var20 = var14;
         if(this.field_83021_g <= 0.0D || !this.field_78669_a.func_72804_r(p_102027_2_ - 1, p_102027_3_, p_102027_4_)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ - 1, p_102027_3_, p_102027_4_);
         var22 = (this.field_78689_v + this.field_78687_w + var21 + this.field_78632_M) / 4.0F;
         var23 = (var21 + this.field_78632_M + this.field_78624_D + this.field_78625_E) / 4.0F;
         var24 = (this.field_78637_K + var21 + this.field_78630_C + this.field_78624_D) / 4.0F;
         var25 = (this.field_78691_u + this.field_78689_v + this.field_78637_K + var21) / 4.0F;
         var9 = (float)((double)var23 * this.field_83024_j * this.field_83022_l + (double)var24 * this.field_83024_j * (1.0D - this.field_83022_l) + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l) + (double)var22 * (1.0D - this.field_83024_j) * this.field_83022_l);
         var10 = (float)((double)var23 * this.field_83024_j * this.field_83025_k + (double)var24 * this.field_83024_j * (1.0D - this.field_83025_k) + (double)var25 * (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k) + (double)var22 * (1.0D - this.field_83024_j) * this.field_83025_k);
         var11 = (float)((double)var23 * this.field_83027_i * this.field_83025_k + (double)var24 * this.field_83027_i * (1.0D - this.field_83025_k) + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k) + (double)var22 * (1.0D - this.field_83027_i) * this.field_83025_k);
         var12 = (float)((double)var23 * this.field_83027_i * this.field_83022_l + (double)var24 * this.field_83027_i * (1.0D - this.field_83022_l) + (double)var25 * (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l) + (double)var22 * (1.0D - this.field_83027_i) * this.field_83022_l);
         var26 = this.func_78602_a(this.field_78641_T, this.field_78639_U, this.field_78686_ak, var20);
         var27 = this.func_78602_a(this.field_78686_ak, this.field_78705_ab, this.field_78702_ac, var20);
         var28 = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78705_ab, var20);
         var29 = this.func_78602_a(this.field_78649_S, this.field_78641_T, this.field_78690_ai, var20);
         this.field_78700_an = this.func_96444_a(var27, var28, var29, var26, this.field_83024_j * this.field_83022_l, this.field_83024_j * (1.0D - this.field_83022_l), (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l), (1.0D - this.field_83024_j) * this.field_83022_l);
         this.field_78694_ao = this.func_96444_a(var27, var28, var29, var26, this.field_83024_j * this.field_83025_k, this.field_83024_j * (1.0D - this.field_83025_k), (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k), (1.0D - this.field_83024_j) * this.field_83025_k);
         this.field_78696_ap = this.func_96444_a(var27, var28, var29, var26, this.field_83027_i * this.field_83025_k, this.field_83027_i * (1.0D - this.field_83025_k), (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k), (1.0D - this.field_83027_i) * this.field_83025_k);
         this.field_78676_aq = this.func_96444_a(var27, var28, var29, var26, this.field_83027_i * this.field_83022_l, this.field_83027_i * (1.0D - this.field_83022_l), (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l), (1.0D - this.field_83027_i) * this.field_83022_l);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.6F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var30 = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 4);
         this.func_78573_e(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, var30);
         if(field_78667_b && var30.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_102027_5_;
            this.field_78672_as *= p_102027_5_;
            this.field_78670_at *= p_102027_5_;
            this.field_78684_au *= p_102027_5_;
            this.field_78682_av *= p_102027_6_;
            this.field_78680_aw *= p_102027_6_;
            this.field_78678_ax *= p_102027_6_;
            this.field_78665_ay *= p_102027_6_;
            this.field_78663_az *= p_102027_7_;
            this.field_78650_aA *= p_102027_7_;
            this.field_78651_aB *= p_102027_7_;
            this.field_78652_aC *= p_102027_7_;
            this.func_78573_e(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      if(this.field_78661_f || p_102027_1_.func_71877_c(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_, 5)) {
         if(this.field_83026_h >= 1.0D) {
            ++p_102027_2_;
         }

         this.field_78628_A = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78631_L = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78633_N = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78634_H = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         this.field_78655_Y = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_);
         this.field_78692_aj = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ - 1);
         this.field_78688_al = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_ + 1);
         this.field_78711_af = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_);
         var16 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ + 1, p_102027_4_)];
         var17 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_ - 1, p_102027_4_)];
         var18 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ + 1)];
         var19 = Block.field_71985_p[this.field_78669_a.func_72798_a(p_102027_2_ + 1, p_102027_3_, p_102027_4_ - 1)];
         if(!var17 && !var19) {
            this.field_78708_z = this.field_78631_L;
            this.field_78657_X = this.field_78692_aj;
         } else {
            this.field_78708_z = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
            this.field_78657_X = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ - 1);
         }

         if(!var17 && !var18) {
            this.field_78629_B = this.field_78633_N;
            this.field_78660_Z = this.field_78688_al;
         } else {
            this.field_78629_B = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
            this.field_78660_Z = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ - 1, p_102027_4_ + 1);
         }

         if(!var16 && !var19) {
            this.field_78627_G = this.field_78631_L;
            this.field_78709_ae = this.field_78692_aj;
         } else {
            this.field_78627_G = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
            this.field_78709_ae = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ - 1);
         }

         if(!var16 && !var18) {
            this.field_78636_J = this.field_78633_N;
            this.field_78707_ah = this.field_78688_al;
         } else {
            this.field_78636_J = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
            this.field_78707_ah = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_, p_102027_3_ + 1, p_102027_4_ + 1);
         }

         if(this.field_83026_h >= 1.0D) {
            --p_102027_2_;
         }

         var20 = var14;
         if(this.field_83026_h >= 1.0D || !this.field_78669_a.func_72804_r(p_102027_2_ + 1, p_102027_3_, p_102027_4_)) {
            var20 = p_102027_1_.func_71874_e(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         }

         var21 = p_102027_1_.func_71888_h(this.field_78669_a, p_102027_2_ + 1, p_102027_3_, p_102027_4_);
         var22 = (this.field_78628_A + this.field_78629_B + var21 + this.field_78633_N) / 4.0F;
         var23 = (this.field_78708_z + this.field_78628_A + this.field_78631_L + var21) / 4.0F;
         var24 = (this.field_78631_L + var21 + this.field_78627_G + this.field_78634_H) / 4.0F;
         var25 = (var21 + this.field_78633_N + this.field_78634_H + this.field_78636_J) / 4.0F;
         var9 = (float)((double)var22 * (1.0D - this.field_83027_i) * this.field_83022_l + (double)var23 * (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l) + (double)var24 * this.field_83027_i * (1.0D - this.field_83022_l) + (double)var25 * this.field_83027_i * this.field_83022_l);
         var10 = (float)((double)var22 * (1.0D - this.field_83027_i) * this.field_83025_k + (double)var23 * (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k) + (double)var24 * this.field_83027_i * (1.0D - this.field_83025_k) + (double)var25 * this.field_83027_i * this.field_83025_k);
         var11 = (float)((double)var22 * (1.0D - this.field_83024_j) * this.field_83025_k + (double)var23 * (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k) + (double)var24 * this.field_83024_j * (1.0D - this.field_83025_k) + (double)var25 * this.field_83024_j * this.field_83025_k);
         var12 = (float)((double)var22 * (1.0D - this.field_83024_j) * this.field_83022_l + (double)var23 * (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l) + (double)var24 * this.field_83024_j * (1.0D - this.field_83022_l) + (double)var25 * this.field_83024_j * this.field_83022_l);
         var26 = this.func_78602_a(this.field_78655_Y, this.field_78660_Z, this.field_78688_al, var20);
         var27 = this.func_78602_a(this.field_78688_al, this.field_78711_af, this.field_78707_ah, var20);
         var28 = this.func_78602_a(this.field_78692_aj, this.field_78709_ae, this.field_78711_af, var20);
         var29 = this.func_78602_a(this.field_78657_X, this.field_78655_Y, this.field_78692_aj, var20);
         this.field_78700_an = this.func_96444_a(var26, var29, var28, var27, (1.0D - this.field_83027_i) * this.field_83022_l, (1.0D - this.field_83027_i) * (1.0D - this.field_83022_l), this.field_83027_i * (1.0D - this.field_83022_l), this.field_83027_i * this.field_83022_l);
         this.field_78694_ao = this.func_96444_a(var26, var29, var28, var27, (1.0D - this.field_83027_i) * this.field_83025_k, (1.0D - this.field_83027_i) * (1.0D - this.field_83025_k), this.field_83027_i * (1.0D - this.field_83025_k), this.field_83027_i * this.field_83025_k);
         this.field_78696_ap = this.func_96444_a(var26, var29, var28, var27, (1.0D - this.field_83024_j) * this.field_83025_k, (1.0D - this.field_83024_j) * (1.0D - this.field_83025_k), this.field_83024_j * (1.0D - this.field_83025_k), this.field_83024_j * this.field_83025_k);
         this.field_78676_aq = this.func_96444_a(var26, var29, var28, var27, (1.0D - this.field_83024_j) * this.field_83022_l, (1.0D - this.field_83024_j) * (1.0D - this.field_83022_l), this.field_83024_j * (1.0D - this.field_83022_l), this.field_83024_j * this.field_83022_l);
         if(var13) {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = p_102027_5_ * 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = p_102027_6_ * 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = p_102027_7_ * 0.6F;
         } else {
            this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = 0.6F;
            this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = 0.6F;
            this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = 0.6F;
         }

         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var30 = this.func_94170_a(p_102027_1_, this.field_78669_a, p_102027_2_, p_102027_3_, p_102027_4_, 5);
         this.func_78605_f(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, var30);
         if(field_78667_b && var30.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            this.field_78674_ar *= p_102027_5_;
            this.field_78672_as *= p_102027_5_;
            this.field_78670_at *= p_102027_5_;
            this.field_78684_au *= p_102027_5_;
            this.field_78682_av *= p_102027_6_;
            this.field_78680_aw *= p_102027_6_;
            this.field_78678_ax *= p_102027_6_;
            this.field_78665_ay *= p_102027_6_;
            this.field_78663_az *= p_102027_7_;
            this.field_78650_aA *= p_102027_7_;
            this.field_78651_aB *= p_102027_7_;
            this.field_78652_aC *= p_102027_7_;
            this.func_78605_f(p_102027_1_, (double)p_102027_2_, (double)p_102027_3_, (double)p_102027_4_, BlockGrass.func_94434_o());
         }

         var8 = true;
      }

      this.field_78677_m = false;
      return var8;
   }

   public int func_78602_a(int p_78602_1_, int p_78602_2_, int p_78602_3_, int p_78602_4_) {
      if(p_78602_1_ == 0) {
         p_78602_1_ = p_78602_4_;
      }

      if(p_78602_2_ == 0) {
         p_78602_2_ = p_78602_4_;
      }

      if(p_78602_3_ == 0) {
         p_78602_3_ = p_78602_4_;
      }

      return p_78602_1_ + p_78602_2_ + p_78602_3_ + p_78602_4_ >> 2 & 16711935;
   }

   public int func_96444_a(int p_96444_1_, int p_96444_2_, int p_96444_3_, int p_96444_4_, double p_96444_5_, double p_96444_7_, double p_96444_9_, double p_96444_11_) {
      int var13 = (int)((double)(p_96444_1_ >> 16 & 255) * p_96444_5_ + (double)(p_96444_2_ >> 16 & 255) * p_96444_7_ + (double)(p_96444_3_ >> 16 & 255) * p_96444_9_ + (double)(p_96444_4_ >> 16 & 255) * p_96444_11_) & 255;
      int var14 = (int)((double)(p_96444_1_ & 255) * p_96444_5_ + (double)(p_96444_2_ & 255) * p_96444_7_ + (double)(p_96444_3_ & 255) * p_96444_9_ + (double)(p_96444_4_ & 255) * p_96444_11_) & 255;
      return var13 << 16 | var14;
   }

   public boolean func_78609_c(Block p_78609_1_, int p_78609_2_, int p_78609_3_, int p_78609_4_, float p_78609_5_, float p_78609_6_, float p_78609_7_) {
      this.field_78677_m = false;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var11 * p_78609_5_;
      float var15 = var11 * p_78609_6_;
      float var16 = var11 * p_78609_7_;
      float var17 = var10;
      float var18 = var12;
      float var19 = var13;
      float var20 = var10;
      float var21 = var12;
      float var22 = var13;
      float var23 = var10;
      float var24 = var12;
      float var25 = var13;
      if(p_78609_1_ != Block.field_71980_u) {
         var17 = var10 * p_78609_5_;
         var18 = var12 * p_78609_5_;
         var19 = var13 * p_78609_5_;
         var20 = var10 * p_78609_6_;
         var21 = var12 * p_78609_6_;
         var22 = var13 * p_78609_6_;
         var23 = var10 * p_78609_7_;
         var24 = var12 * p_78609_7_;
         var25 = var13 * p_78609_7_;
      }

      int var26 = p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_);
      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_, 0)) {
         var8.func_78380_c(this.field_83027_i > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_));
         var8.func_78386_a(var17, var20, var23);
         this.func_78613_a(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 0));
         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_, 1)) {
         var8.func_78380_c(this.field_83024_j < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_));
         var8.func_78386_a(var14, var15, var16);
         this.func_78617_b(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 1));
         var9 = true;
      }

      Icon var28;
      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1, 2)) {
         var8.func_78380_c(this.field_83025_k > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1));
         var8.func_78386_a(var18, var21, var24);
         var28 = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 2);
         this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            var8.func_78386_a(var18 * p_78609_5_, var21 * p_78609_6_, var24 * p_78609_7_);
            this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1, 3)) {
         var8.func_78380_c(this.field_83022_l < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1));
         var8.func_78386_a(var18, var21, var24);
         var28 = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 3);
         this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            var8.func_78386_a(var18 * p_78609_5_, var21 * p_78609_6_, var24 * p_78609_7_);
            this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_, 4)) {
         var8.func_78380_c(this.field_83021_g > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_));
         var8.func_78386_a(var19, var22, var25);
         var28 = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 4);
         this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            var8.func_78386_a(var19 * p_78609_5_, var22 * p_78609_6_, var25 * p_78609_7_);
            this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_, 5)) {
         var8.func_78380_c(this.field_83026_h < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_));
         var8.func_78386_a(var19, var22, var25);
         var28 = this.func_94170_a(p_78609_1_, this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 5);
         this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28.func_94215_i().equals("grass_side") && !this.func_94167_b()) {
            var8.func_78386_a(var19 * p_78609_5_, var22 * p_78609_6_, var25 * p_78609_7_);
            this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, BlockGrass.func_94434_o());
         }

         var9 = true;
      }

      return var9;
   }

   public boolean func_78616_a(BlockCocoa p_78616_1_, int p_78616_2_, int p_78616_3_, int p_78616_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78616_1_.func_71874_e(this.field_78669_a, p_78616_2_, p_78616_3_, p_78616_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var6 = this.field_78669_a.func_72805_g(p_78616_2_, p_78616_3_, p_78616_4_);
      int var7 = BlockDirectional.func_72217_d(var6);
      int var8 = BlockCocoa.func_72219_c(var6);
      Icon var9 = p_78616_1_.func_94468_i_(var8);
      int var10 = 4 + var8 * 2;
      int var11 = 5 + var8 * 2;
      double var12 = 15.0D - (double)var10;
      double var14 = 15.0D;
      double var16 = 4.0D;
      double var18 = 4.0D + (double)var11;
      double var20 = (double)var9.func_94214_a(var12);
      double var22 = (double)var9.func_94214_a(var14);
      double var24 = (double)var9.func_94207_b(var16);
      double var26 = (double)var9.func_94207_b(var18);
      double var28 = 0.0D;
      double var30 = 0.0D;
      switch(var7) {
      case 0:
         var28 = 8.0D - (double)(var10 / 2);
         var30 = 15.0D - (double)var10;
         break;
      case 1:
         var28 = 1.0D;
         var30 = 8.0D - (double)(var10 / 2);
         break;
      case 2:
         var28 = 8.0D - (double)(var10 / 2);
         var30 = 1.0D;
         break;
      case 3:
         var28 = 15.0D - (double)var10;
         var30 = 8.0D - (double)(var10 / 2);
      }

      double var32 = (double)p_78616_2_ + var28 / 16.0D;
      double var34 = (double)p_78616_2_ + (var28 + (double)var10) / 16.0D;
      double var36 = (double)p_78616_3_ + (12.0D - (double)var11) / 16.0D;
      double var38 = (double)p_78616_3_ + 0.75D;
      double var40 = (double)p_78616_4_ + var30 / 16.0D;
      double var42 = (double)p_78616_4_ + (var30 + (double)var10) / 16.0D;
      var5.func_78374_a(var32, var36, var40, var20, var26);
      var5.func_78374_a(var32, var36, var42, var22, var26);
      var5.func_78374_a(var32, var38, var42, var22, var24);
      var5.func_78374_a(var32, var38, var40, var20, var24);
      var5.func_78374_a(var34, var36, var42, var20, var26);
      var5.func_78374_a(var34, var36, var40, var22, var26);
      var5.func_78374_a(var34, var38, var40, var22, var24);
      var5.func_78374_a(var34, var38, var42, var20, var24);
      var5.func_78374_a(var34, var36, var40, var20, var26);
      var5.func_78374_a(var32, var36, var40, var22, var26);
      var5.func_78374_a(var32, var38, var40, var22, var24);
      var5.func_78374_a(var34, var38, var40, var20, var24);
      var5.func_78374_a(var32, var36, var42, var20, var26);
      var5.func_78374_a(var34, var36, var42, var22, var26);
      var5.func_78374_a(var34, var38, var42, var22, var24);
      var5.func_78374_a(var32, var38, var42, var20, var24);
      int var44 = var10;
      if(var8 >= 2) {
         var44 = var10 - 1;
      }

      var20 = (double)var9.func_94209_e();
      var22 = (double)var9.func_94214_a((double)var44);
      var24 = (double)var9.func_94206_g();
      var26 = (double)var9.func_94207_b((double)var44);
      var5.func_78374_a(var32, var38, var42, var20, var26);
      var5.func_78374_a(var34, var38, var42, var22, var26);
      var5.func_78374_a(var34, var38, var40, var22, var24);
      var5.func_78374_a(var32, var38, var40, var20, var24);
      var5.func_78374_a(var32, var36, var40, var20, var24);
      var5.func_78374_a(var34, var36, var40, var22, var24);
      var5.func_78374_a(var34, var36, var42, var22, var26);
      var5.func_78374_a(var32, var36, var42, var20, var26);
      var20 = (double)var9.func_94214_a(12.0D);
      var22 = (double)var9.func_94212_f();
      var24 = (double)var9.func_94206_g();
      var26 = (double)var9.func_94207_b(4.0D);
      var28 = 8.0D;
      var30 = 0.0D;
      double var45;
      switch(var7) {
      case 0:
         var28 = 8.0D;
         var30 = 12.0D;
         var45 = var20;
         var20 = var22;
         var22 = var45;
         break;
      case 1:
         var28 = 0.0D;
         var30 = 8.0D;
         break;
      case 2:
         var28 = 8.0D;
         var30 = 0.0D;
         break;
      case 3:
         var28 = 12.0D;
         var30 = 8.0D;
         var45 = var20;
         var20 = var22;
         var22 = var45;
      }

      var32 = (double)p_78616_2_ + var28 / 16.0D;
      var34 = (double)p_78616_2_ + (var28 + 4.0D) / 16.0D;
      var36 = (double)p_78616_3_ + 0.75D;
      var38 = (double)p_78616_3_ + 1.0D;
      var40 = (double)p_78616_4_ + var30 / 16.0D;
      var42 = (double)p_78616_4_ + (var30 + 4.0D) / 16.0D;
      if(var7 != 2 && var7 != 0) {
         if(var7 == 1 || var7 == 3) {
            var5.func_78374_a(var34, var36, var40, var20, var26);
            var5.func_78374_a(var32, var36, var40, var22, var26);
            var5.func_78374_a(var32, var38, var40, var22, var24);
            var5.func_78374_a(var34, var38, var40, var20, var24);
            var5.func_78374_a(var32, var36, var40, var22, var26);
            var5.func_78374_a(var34, var36, var40, var20, var26);
            var5.func_78374_a(var34, var38, var40, var20, var24);
            var5.func_78374_a(var32, var38, var40, var22, var24);
         }
      } else {
         var5.func_78374_a(var32, var36, var40, var22, var26);
         var5.func_78374_a(var32, var36, var42, var20, var26);
         var5.func_78374_a(var32, var38, var42, var20, var24);
         var5.func_78374_a(var32, var38, var40, var22, var24);
         var5.func_78374_a(var32, var36, var42, var20, var26);
         var5.func_78374_a(var32, var36, var40, var22, var26);
         var5.func_78374_a(var32, var38, var40, var22, var24);
         var5.func_78374_a(var32, var38, var42, var20, var24);
      }

      return true;
   }

   public boolean func_82778_a(BlockBeacon p_82778_1_, int p_82778_2_, int p_82778_3_, int p_82778_4_) {
      float var5 = 0.1875F;
      this.func_82774_a(this.func_94175_b(Block.field_72089_ap));
      this.func_83020_a(0.125D, 0.0062500000931322575D, 0.125D, 0.875D, (double)var5, 0.875D);
      this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
      this.func_82774_a(this.func_94175_b(Block.field_71946_M));
      this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
      this.func_82774_a(p_82778_1_.func_94446_i());
      this.func_83020_a(0.1875D, (double)var5, 0.1875D, 0.8125D, 0.875D, 0.8125D);
      this.func_78570_q(p_82778_1_, p_82778_2_, p_82778_3_, p_82778_4_);
      this.func_78595_a();
      return true;
   }

   public boolean func_78584_s(Block p_78584_1_, int p_78584_2_, int p_78584_3_, int p_78584_4_) {
      int var5 = p_78584_1_.func_71920_b(this.field_78669_a, p_78584_2_, p_78584_3_, p_78584_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return this.func_78569_d(p_78584_1_, p_78584_2_, p_78584_3_, p_78584_4_, var6, var7, var8);
   }

   public boolean func_78569_d(Block p_78569_1_, int p_78569_2_, int p_78569_3_, int p_78569_4_, float p_78569_5_, float p_78569_6_, float p_78569_7_) {
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var10 * p_78569_5_;
      float var15 = var11 * p_78569_5_;
      float var16 = var12 * p_78569_5_;
      float var17 = var13 * p_78569_5_;
      float var18 = var10 * p_78569_6_;
      float var19 = var11 * p_78569_6_;
      float var20 = var12 * p_78569_6_;
      float var21 = var13 * p_78569_6_;
      float var22 = var10 * p_78569_7_;
      float var23 = var11 * p_78569_7_;
      float var24 = var12 * p_78569_7_;
      float var25 = var13 * p_78569_7_;
      float var26 = 0.0625F;
      int var28 = p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_);
      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_, 0)) {
         var8.func_78380_c(this.field_83027_i > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_));
         var8.func_78386_a(var14, var18, var22);
         this.func_78613_a(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 0));
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_, 1)) {
         var8.func_78380_c(this.field_83024_j < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_));
         var8.func_78386_a(var15, var19, var23);
         this.func_78617_b(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 1));
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1, 2)) {
         var8.func_78380_c(this.field_83025_k > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1));
         var8.func_78386_a(var16, var20, var24);
         var8.func_78372_c(0.0F, 0.0F, var26);
         this.func_78611_c(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 2));
         var8.func_78372_c(0.0F, 0.0F, -var26);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1, 3)) {
         var8.func_78380_c(this.field_83022_l < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1));
         var8.func_78386_a(var16, var20, var24);
         var8.func_78372_c(0.0F, 0.0F, -var26);
         this.func_78622_d(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 3));
         var8.func_78372_c(0.0F, 0.0F, var26);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_, 4)) {
         var8.func_78380_c(this.field_83021_g > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_));
         var8.func_78386_a(var17, var21, var25);
         var8.func_78372_c(var26, 0.0F, 0.0F);
         this.func_78573_e(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 4));
         var8.func_78372_c(-var26, 0.0F, 0.0F);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_, 5)) {
         var8.func_78380_c(this.field_83026_h < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_));
         var8.func_78386_a(var17, var21, var25);
         var8.func_78372_c(-var26, 0.0F, 0.0F);
         this.func_78605_f(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, this.func_94170_a(p_78569_1_, this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 5));
         var8.func_78372_c(var26, 0.0F, 0.0F);
         var9 = true;
      }

      return var9;
   }

   public boolean func_78582_a(BlockFence p_78582_1_, int p_78582_2_, int p_78582_3_, int p_78582_4_) {
      boolean var5 = false;
      float var6 = 0.375F;
      float var7 = 0.625F;
      this.func_83020_a((double)var6, 0.0D, (double)var6, (double)var7, 1.0D, (double)var7);
      this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
      var5 = true;
      boolean var8 = false;
      boolean var9 = false;
      if(p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_)) {
         var8 = true;
      }

      if(p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1)) {
         var9 = true;
      }

      boolean var10 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_);
      boolean var11 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_);
      boolean var12 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1);
      boolean var13 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1);
      if(!var8 && !var9) {
         var8 = true;
      }

      var6 = 0.4375F;
      var7 = 0.5625F;
      float var14 = 0.75F;
      float var15 = 0.9375F;
      float var16 = var10?0.0F:var6;
      float var17 = var11?1.0F:var7;
      float var18 = var12?0.0F:var6;
      float var19 = var13?1.0F:var7;
      if(var8) {
         this.func_83020_a((double)var16, (double)var14, (double)var6, (double)var17, (double)var15, (double)var7);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      if(var9) {
         this.func_83020_a((double)var6, (double)var14, (double)var18, (double)var7, (double)var15, (double)var19);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      var14 = 0.375F;
      var15 = 0.5625F;
      if(var8) {
         this.func_83020_a((double)var16, (double)var14, (double)var6, (double)var17, (double)var15, (double)var7);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      if(var9) {
         this.func_83020_a((double)var6, (double)var14, (double)var18, (double)var7, (double)var15, (double)var19);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      p_78582_1_.func_71902_a(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_);
      return var5;
   }

   public boolean func_82779_a(BlockWall p_82779_1_, int p_82779_2_, int p_82779_3_, int p_82779_4_) {
      boolean var5 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_ - 1, p_82779_3_, p_82779_4_);
      boolean var6 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_ + 1, p_82779_3_, p_82779_4_);
      boolean var7 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_ - 1);
      boolean var8 = p_82779_1_.func_82538_d(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_ + 1);
      boolean var9 = var7 && var8 && !var5 && !var6;
      boolean var10 = !var7 && !var8 && var5 && var6;
      boolean var11 = this.field_78669_a.func_72799_c(p_82779_2_, p_82779_3_ + 1, p_82779_4_);
      if((var9 || var10) && var11) {
         if(var9) {
            this.func_83020_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         } else {
            this.func_83020_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         }
      } else {
         this.func_83020_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
         this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         if(var5) {
            this.func_83020_a(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         }

         if(var6) {
            this.func_83020_a(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         }

         if(var7) {
            this.func_83020_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         }

         if(var8) {
            this.func_83020_a(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
            this.func_78570_q(p_82779_1_, p_82779_2_, p_82779_3_, p_82779_4_);
         }
      }

      p_82779_1_.func_71902_a(this.field_78669_a, p_82779_2_, p_82779_3_, p_82779_4_);
      return true;
   }

   public boolean func_78618_a(BlockDragonEgg p_78618_1_, int p_78618_2_, int p_78618_3_, int p_78618_4_) {
      boolean var5 = false;
      int var6 = 0;

      for(int var7 = 0; var7 < 8; ++var7) {
         byte var8 = 0;
         byte var9 = 1;
         if(var7 == 0) {
            var8 = 2;
         }

         if(var7 == 1) {
            var8 = 3;
         }

         if(var7 == 2) {
            var8 = 4;
         }

         if(var7 == 3) {
            var8 = 5;
            var9 = 2;
         }

         if(var7 == 4) {
            var8 = 6;
            var9 = 3;
         }

         if(var7 == 5) {
            var8 = 7;
            var9 = 5;
         }

         if(var7 == 6) {
            var8 = 6;
            var9 = 2;
         }

         if(var7 == 7) {
            var8 = 3;
         }

         float var10 = (float)var8 / 16.0F;
         float var11 = 1.0F - (float)var6 / 16.0F;
         float var12 = 1.0F - (float)(var6 + var9) / 16.0F;
         var6 += var9;
         this.func_83020_a((double)(0.5F - var10), (double)var12, (double)(0.5F - var10), (double)(0.5F + var10), (double)var11, (double)(0.5F + var10));
         this.func_78570_q(p_78618_1_, p_78618_2_, p_78618_3_, p_78618_4_);
      }

      var5 = true;
      this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return var5;
   }

   public boolean func_78580_a(BlockFenceGate p_78580_1_, int p_78580_2_, int p_78580_3_, int p_78580_4_) {
      boolean var5 = true;
      int var6 = this.field_78669_a.func_72805_g(p_78580_2_, p_78580_3_, p_78580_4_);
      boolean var7 = BlockFenceGate.func_72224_c(var6);
      int var8 = BlockDirectional.func_72217_d(var6);
      float var9 = 0.375F;
      float var10 = 0.5625F;
      float var11 = 0.75F;
      float var12 = 0.9375F;
      float var13 = 0.3125F;
      float var14 = 1.0F;
      if((var8 == 2 || var8 == 0) && this.field_78669_a.func_72798_a(p_78580_2_ - 1, p_78580_3_, p_78580_4_) == Block.field_82515_ce.field_71990_ca && this.field_78669_a.func_72798_a(p_78580_2_ + 1, p_78580_3_, p_78580_4_) == Block.field_82515_ce.field_71990_ca || (var8 == 3 || var8 == 1) && this.field_78669_a.func_72798_a(p_78580_2_, p_78580_3_, p_78580_4_ - 1) == Block.field_82515_ce.field_71990_ca && this.field_78669_a.func_72798_a(p_78580_2_, p_78580_3_, p_78580_4_ + 1) == Block.field_82515_ce.field_71990_ca) {
         var9 -= 0.1875F;
         var10 -= 0.1875F;
         var11 -= 0.1875F;
         var12 -= 0.1875F;
         var13 -= 0.1875F;
         var14 -= 0.1875F;
      }

      this.field_78661_f = true;
      float var15;
      float var17;
      float var16;
      float var18;
      if(var8 != 3 && var8 != 1) {
         var15 = 0.0F;
         var16 = 0.125F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         this.func_83020_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.875F;
         var16 = 1.0F;
         this.func_83020_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      } else {
         this.field_78681_k = 1;
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.0F;
         var18 = 0.125F;
         this.func_83020_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.875F;
         var18 = 1.0F;
         this.func_83020_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         this.field_78681_k = 0;
      }

      if(var7) {
         if(var8 == 2 || var8 == 0) {
            this.field_78681_k = 1;
         }

         if(var8 == 3) {
            this.func_83020_a(0.8125D, (double)var9, 0.0D, 0.9375D, (double)var12, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.8125D, (double)var9, 0.875D, 0.9375D, (double)var12, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.5625D, (double)var9, 0.0D, 0.8125D, (double)var10, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.5625D, (double)var9, 0.875D, 0.8125D, (double)var10, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.5625D, (double)var11, 0.0D, 0.8125D, (double)var12, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.5625D, (double)var11, 0.875D, 0.8125D, (double)var12, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 1) {
            this.func_83020_a(0.0625D, (double)var9, 0.0D, 0.1875D, (double)var12, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.0625D, (double)var9, 0.875D, 0.1875D, (double)var12, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.1875D, (double)var9, 0.0D, 0.4375D, (double)var10, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.1875D, (double)var9, 0.875D, 0.4375D, (double)var10, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.1875D, (double)var11, 0.0D, 0.4375D, (double)var12, 0.125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.1875D, (double)var11, 0.875D, 0.4375D, (double)var12, 1.0D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 0) {
            this.func_83020_a(0.0D, (double)var9, 0.8125D, 0.125D, (double)var12, 0.9375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var9, 0.8125D, 1.0D, (double)var12, 0.9375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.0D, (double)var9, 0.5625D, 0.125D, (double)var10, 0.8125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var9, 0.5625D, 1.0D, (double)var10, 0.8125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.0D, (double)var11, 0.5625D, 0.125D, (double)var12, 0.8125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var11, 0.5625D, 1.0D, (double)var12, 0.8125D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 2) {
            this.func_83020_a(0.0D, (double)var9, 0.0625D, 0.125D, (double)var12, 0.1875D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var9, 0.0625D, 1.0D, (double)var12, 0.1875D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.0D, (double)var9, 0.1875D, 0.125D, (double)var10, 0.4375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var9, 0.1875D, 1.0D, (double)var10, 0.4375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.0D, (double)var11, 0.1875D, 0.125D, (double)var12, 0.4375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            this.func_83020_a(0.875D, (double)var11, 0.1875D, 1.0D, (double)var12, 0.4375D);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         }
      } else if(var8 != 3 && var8 != 1) {
         var15 = 0.375F;
         var16 = 0.5F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.5F;
         var16 = 0.625F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.625F;
         var16 = 0.875F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         this.func_83020_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.125F;
         var16 = 0.375F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         this.func_83020_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      } else {
         this.field_78681_k = 1;
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.375F;
         var18 = 0.5F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.5F;
         var18 = 0.625F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.625F;
         var18 = 0.875F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         this.func_83020_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.125F;
         var18 = 0.375F;
         this.func_83020_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         this.func_83020_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      }

      this.field_78661_f = false;
      this.field_78681_k = 0;
      this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return var5;
   }

   public boolean func_94172_a(BlockHopper p_94172_1_, int p_94172_2_, int p_94172_3_, int p_94172_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_94172_1_.func_71874_e(this.field_78669_a, p_94172_2_, p_94172_3_, p_94172_4_));
      float var6 = 1.0F;
      int var7 = p_94172_1_.func_71920_b(this.field_78669_a, p_94172_2_, p_94172_3_, p_94172_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      return this.func_96447_a(p_94172_1_, p_94172_2_, p_94172_3_, p_94172_4_, this.field_78669_a.func_72805_g(p_94172_2_, p_94172_3_, p_94172_4_), false);
   }

   public boolean func_96447_a(BlockHopper p_96447_1_, int p_96447_2_, int p_96447_3_, int p_96447_4_, int p_96447_5_, boolean p_96447_6_) {
      Tessellator var7 = Tessellator.field_78398_a;
      int var8 = BlockHopper.func_94451_c(p_96447_5_);
      double var9 = 0.625D;
      this.func_83020_a(0.0D, var9, 0.0D, 1.0D, 1.0D, 1.0D);
      if(p_96447_6_) {
         var7.func_78382_b();
         var7.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_78613_a(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 0, p_96447_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 1, p_96447_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 2, p_96447_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 3, p_96447_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 4, p_96447_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_96447_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_96447_1_, 5, p_96447_5_));
         var7.func_78381_a();
      } else {
         this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
      }

      float var13;
      if(!p_96447_6_) {
         var7.func_78380_c(p_96447_1_.func_71874_e(this.field_78669_a, p_96447_2_, p_96447_3_, p_96447_4_));
         float var11 = 1.0F;
         int var12 = p_96447_1_.func_71920_b(this.field_78669_a, p_96447_2_, p_96447_3_, p_96447_4_);
         var13 = (float)(var12 >> 16 & 255) / 255.0F;
         float var14 = (float)(var12 >> 8 & 255) / 255.0F;
         float var15 = (float)(var12 & 255) / 255.0F;
         if(EntityRenderer.field_78517_a) {
            float var16 = (var13 * 30.0F + var14 * 59.0F + var15 * 11.0F) / 100.0F;
            float var17 = (var13 * 30.0F + var14 * 70.0F) / 100.0F;
            float var18 = (var13 * 30.0F + var15 * 70.0F) / 100.0F;
            var13 = var16;
            var14 = var17;
            var15 = var18;
         }

         var7.func_78386_a(var11 * var13, var11 * var14, var11 * var15);
      }

      Icon var24 = BlockHopper.func_94453_b("hopper");
      Icon var25 = BlockHopper.func_94453_b("hopper_inside");
      var13 = 0.125F;
      if(p_96447_6_) {
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_96447_1_, (double)(-1.0F + var13), 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_96447_1_, (double)(1.0F - var13), 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_96447_1_, 0.0D, 0.0D, (double)(-1.0F + var13), var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_96447_1_, 0.0D, 0.0D, (double)(1.0F - var13), var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_96447_1_, 0.0D, -1.0D + var9, 0.0D, var25);
         var7.func_78381_a();
      } else {
         this.func_78605_f(p_96447_1_, (double)((float)p_96447_2_ - 1.0F + var13), (double)p_96447_3_, (double)p_96447_4_, var24);
         this.func_78573_e(p_96447_1_, (double)((float)p_96447_2_ + 1.0F - var13), (double)p_96447_3_, (double)p_96447_4_, var24);
         this.func_78622_d(p_96447_1_, (double)p_96447_2_, (double)p_96447_3_, (double)((float)p_96447_4_ - 1.0F + var13), var24);
         this.func_78611_c(p_96447_1_, (double)p_96447_2_, (double)p_96447_3_, (double)((float)p_96447_4_ + 1.0F - var13), var24);
         this.func_78617_b(p_96447_1_, (double)p_96447_2_, (double)((float)p_96447_3_ - 1.0F) + var9, (double)p_96447_4_, var25);
      }

      this.func_82774_a(var24);
      double var26 = 0.25D;
      double var27 = 0.25D;
      this.func_83020_a(var26, var27, var26, 1.0D - var26, var9 - 0.0020D, 1.0D - var26);
      if(p_96447_6_) {
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_78613_a(p_96447_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
      } else {
         this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
      }

      if(!p_96447_6_) {
         double var20 = 0.375D;
         double var22 = 0.25D;
         this.func_82774_a(var24);
         if(var8 == 0) {
            this.func_83020_a(var20, 0.0D, var20, 1.0D - var20, 0.25D, 1.0D - var20);
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
         }

         if(var8 == 2) {
            this.func_83020_a(var20, var27, 0.0D, 1.0D - var20, var27 + var22, var26);
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
         }

         if(var8 == 3) {
            this.func_83020_a(var20, var27, 1.0D - var26, 1.0D - var20, var27 + var22, 1.0D);
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
         }

         if(var8 == 4) {
            this.func_83020_a(0.0D, var27, var20, var26, var27 + var22, 1.0D - var20);
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
         }

         if(var8 == 5) {
            this.func_83020_a(1.0D - var26, var27, var20, 1.0D, var27 + var22, 1.0D - var20);
            this.func_78570_q(p_96447_1_, p_96447_2_, p_96447_3_, p_96447_4_);
         }
      }

      this.func_78595_a();
      return true;
   }

   public boolean func_78565_t(BlockStairs p_78565_1_, int p_78565_2_, int p_78565_3_, int p_78565_4_) {
      p_78565_1_.func_82541_d(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_);
      this.func_83018_a(p_78565_1_);
      this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      boolean var5 = p_78565_1_.func_82542_g(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_);
      this.func_83018_a(p_78565_1_);
      this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      if(var5 && p_78565_1_.func_82544_h(this.field_78669_a, p_78565_2_, p_78565_3_, p_78565_4_)) {
         this.func_83018_a(p_78565_1_);
         this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      }

      return true;
   }

   public boolean func_78601_u(Block p_78601_1_, int p_78601_2_, int p_78601_3_, int p_78601_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78601_2_, p_78601_3_, p_78601_4_);
      if((var6 & 8) != 0) {
         if(this.field_78669_a.func_72798_a(p_78601_2_, p_78601_3_ - 1, p_78601_4_) != p_78601_1_.field_71990_ca) {
            return false;
         }
      } else if(this.field_78669_a.func_72798_a(p_78601_2_, p_78601_3_ + 1, p_78601_4_) != p_78601_1_.field_71990_ca) {
         return false;
      }

      boolean var7 = false;
      float var8 = 0.5F;
      float var9 = 1.0F;
      float var10 = 0.8F;
      float var11 = 0.6F;
      int var12 = p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_);
      var5.func_78380_c(this.field_83027_i > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ - 1, p_78601_4_));
      var5.func_78386_a(var8, var8, var8);
      this.func_78613_a(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 0));
      var7 = true;
      var5.func_78380_c(this.field_83024_j < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ + 1, p_78601_4_));
      var5.func_78386_a(var9, var9, var9);
      this.func_78617_b(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 1));
      var7 = true;
      var5.func_78380_c(this.field_83025_k > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ - 1));
      var5.func_78386_a(var10, var10, var10);
      Icon var14 = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 2);
      this.func_78611_c(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(this.field_83022_l < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ + 1));
      var5.func_78386_a(var10, var10, var10);
      var14 = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 3);
      this.func_78622_d(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(this.field_83021_g > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ - 1, p_78601_3_, p_78601_4_));
      var5.func_78386_a(var11, var11, var11);
      var14 = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 4);
      this.func_78573_e(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(this.field_83026_h < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ + 1, p_78601_3_, p_78601_4_));
      var5.func_78386_a(var11, var11, var11);
      var14 = this.func_94170_a(p_78601_1_, this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 5);
      this.func_78605_f(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      return var7;
   }

   public void func_78613_a(Block p_78613_1_, double p_78613_2_, double p_78613_4_, double p_78613_6_, Icon p_78613_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78613_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78613_8_.func_94214_a(this.field_83021_g * 16.0D);
      double var12 = (double)p_78613_8_.func_94214_a(this.field_83026_h * 16.0D);
      double var14 = (double)p_78613_8_.func_94207_b(this.field_83025_k * 16.0D);
      double var16 = (double)p_78613_8_.func_94207_b(this.field_83022_l * 16.0D);
      if(this.field_83021_g < 0.0D || this.field_83026_h > 1.0D) {
         var10 = (double)p_78613_8_.func_94209_e();
         var12 = (double)p_78613_8_.func_94212_f();
      }

      if(this.field_83025_k < 0.0D || this.field_83022_l > 1.0D) {
         var14 = (double)p_78613_8_.func_94206_g();
         var16 = (double)p_78613_8_.func_94210_h();
      }

      double var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78675_l == 2) {
         var10 = (double)p_78613_8_.func_94214_a(this.field_83025_k * 16.0D);
         var14 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
         var12 = (double)p_78613_8_.func_94214_a(this.field_83022_l * 16.0D);
         var16 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78675_l == 1) {
         var10 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
         var14 = (double)p_78613_8_.func_94207_b(this.field_83021_g * 16.0D);
         var12 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
         var16 = (double)p_78613_8_.func_94207_b(this.field_83026_h * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78675_l == 3) {
         var10 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78613_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
         var14 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
         var16 = (double)p_78613_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78613_2_ + this.field_83021_g;
      double var28 = p_78613_2_ + this.field_83026_h;
      double var30 = p_78613_4_ + this.field_83027_i;
      double var32 = p_78613_6_ + this.field_83025_k;
      double var34 = p_78613_6_ + this.field_83022_l;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var30, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78374_a(var28, var30, var34, var12, var16);
      }

   }

   public void func_78617_b(Block p_78617_1_, double p_78617_2_, double p_78617_4_, double p_78617_6_, Icon p_78617_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78617_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78617_8_.func_94214_a(this.field_83021_g * 16.0D);
      double var12 = (double)p_78617_8_.func_94214_a(this.field_83026_h * 16.0D);
      double var14 = (double)p_78617_8_.func_94207_b(this.field_83025_k * 16.0D);
      double var16 = (double)p_78617_8_.func_94207_b(this.field_83022_l * 16.0D);
      if(this.field_83021_g < 0.0D || this.field_83026_h > 1.0D) {
         var10 = (double)p_78617_8_.func_94209_e();
         var12 = (double)p_78617_8_.func_94212_f();
      }

      if(this.field_83025_k < 0.0D || this.field_83022_l > 1.0D) {
         var14 = (double)p_78617_8_.func_94206_g();
         var16 = (double)p_78617_8_.func_94210_h();
      }

      double var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78681_k == 1) {
         var10 = (double)p_78617_8_.func_94214_a(this.field_83025_k * 16.0D);
         var14 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
         var12 = (double)p_78617_8_.func_94214_a(this.field_83022_l * 16.0D);
         var16 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78681_k == 2) {
         var10 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
         var14 = (double)p_78617_8_.func_94207_b(this.field_83021_g * 16.0D);
         var12 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
         var16 = (double)p_78617_8_.func_94207_b(this.field_83026_h * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78681_k == 3) {
         var10 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78617_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
         var14 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
         var16 = (double)p_78617_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78617_2_ + this.field_83021_g;
      double var28 = p_78617_2_ + this.field_83026_h;
      double var30 = p_78617_4_ + this.field_83024_j;
      double var32 = p_78617_6_ + this.field_83025_k;
      double var34 = p_78617_6_ + this.field_83022_l;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var26, var30, var34, var20, var24);
      } else {
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var26, var30, var34, var20, var24);
      }

   }

   public void func_78611_c(Block p_78611_1_, double p_78611_2_, double p_78611_4_, double p_78611_6_, Icon p_78611_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78611_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78611_8_.func_94214_a(this.field_83021_g * 16.0D);
      double var12 = (double)p_78611_8_.func_94214_a(this.field_83026_h * 16.0D);
      double var14 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
      double var16 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
      double var18;
      if(this.field_78666_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_83021_g < 0.0D || this.field_83026_h > 1.0D) {
         var10 = (double)p_78611_8_.func_94209_e();
         var12 = (double)p_78611_8_.func_94212_f();
      }

      if(this.field_83027_i < 0.0D || this.field_83024_j > 1.0D) {
         var14 = (double)p_78611_8_.func_94206_g();
         var16 = (double)p_78611_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78662_g == 2) {
         var10 = (double)p_78611_8_.func_94214_a(this.field_83027_i * 16.0D);
         var14 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78611_8_.func_94214_a(this.field_83024_j * 16.0D);
         var16 = (double)p_78611_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78662_g == 1) {
         var10 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
         var14 = (double)p_78611_8_.func_94207_b(this.field_83026_h * 16.0D);
         var12 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
         var16 = (double)p_78611_8_.func_94207_b(this.field_83021_g * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78662_g == 3) {
         var10 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78611_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
         var14 = (double)p_78611_8_.func_94207_b(this.field_83024_j * 16.0D);
         var16 = (double)p_78611_8_.func_94207_b(this.field_83027_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78611_2_ + this.field_83021_g;
      double var28 = p_78611_2_ + this.field_83026_h;
      double var30 = p_78611_4_ + this.field_83027_i;
      double var32 = p_78611_4_ + this.field_83024_j;
      double var34 = p_78611_6_ + this.field_83025_k;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var26, var32, var34, var18, var22);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var32, var34, var10, var14);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var30, var34, var20, var24);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var26, var30, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var32, var34, var18, var22);
         var9.func_78374_a(var28, var32, var34, var10, var14);
         var9.func_78374_a(var28, var30, var34, var20, var24);
         var9.func_78374_a(var26, var30, var34, var12, var16);
      }

   }

   public void func_78622_d(Block p_78622_1_, double p_78622_2_, double p_78622_4_, double p_78622_6_, Icon p_78622_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78622_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78622_8_.func_94214_a(this.field_83021_g * 16.0D);
      double var12 = (double)p_78622_8_.func_94214_a(this.field_83026_h * 16.0D);
      double var14 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
      double var16 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
      double var18;
      if(this.field_78666_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_83021_g < 0.0D || this.field_83026_h > 1.0D) {
         var10 = (double)p_78622_8_.func_94209_e();
         var12 = (double)p_78622_8_.func_94212_f();
      }

      if(this.field_83027_i < 0.0D || this.field_83024_j > 1.0D) {
         var14 = (double)p_78622_8_.func_94206_g();
         var16 = (double)p_78622_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78683_h == 1) {
         var10 = (double)p_78622_8_.func_94214_a(this.field_83027_i * 16.0D);
         var16 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78622_8_.func_94214_a(this.field_83024_j * 16.0D);
         var14 = (double)p_78622_8_.func_94207_b(16.0D - this.field_83026_h * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78683_h == 2) {
         var10 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
         var14 = (double)p_78622_8_.func_94207_b(this.field_83021_g * 16.0D);
         var12 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
         var16 = (double)p_78622_8_.func_94207_b(this.field_83026_h * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78683_h == 3) {
         var10 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83021_g * 16.0D);
         var12 = (double)p_78622_8_.func_94214_a(16.0D - this.field_83026_h * 16.0D);
         var14 = (double)p_78622_8_.func_94207_b(this.field_83024_j * 16.0D);
         var16 = (double)p_78622_8_.func_94207_b(this.field_83027_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78622_2_ + this.field_83021_g;
      double var28 = p_78622_2_ + this.field_83026_h;
      double var30 = p_78622_4_ + this.field_83027_i;
      double var32 = p_78622_4_ + this.field_83024_j;
      double var34 = p_78622_6_ + this.field_83022_l;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var26, var32, var34, var10, var14);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var32, var34, var18, var22);
      } else {
         var9.func_78374_a(var26, var32, var34, var10, var14);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78374_a(var28, var32, var34, var18, var22);
      }

   }

   public void func_78573_e(Block p_78573_1_, double p_78573_2_, double p_78573_4_, double p_78573_6_, Icon p_78573_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78573_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78573_8_.func_94214_a(this.field_83025_k * 16.0D);
      double var12 = (double)p_78573_8_.func_94214_a(this.field_83022_l * 16.0D);
      double var14 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
      double var16 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
      double var18;
      if(this.field_78666_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_83025_k < 0.0D || this.field_83022_l > 1.0D) {
         var10 = (double)p_78573_8_.func_94209_e();
         var12 = (double)p_78573_8_.func_94212_f();
      }

      if(this.field_83027_i < 0.0D || this.field_83024_j > 1.0D) {
         var14 = (double)p_78573_8_.func_94206_g();
         var16 = (double)p_78573_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78679_j == 1) {
         var10 = (double)p_78573_8_.func_94214_a(this.field_83027_i * 16.0D);
         var14 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
         var12 = (double)p_78573_8_.func_94214_a(this.field_83024_j * 16.0D);
         var16 = (double)p_78573_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78679_j == 2) {
         var10 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
         var14 = (double)p_78573_8_.func_94207_b(this.field_83025_k * 16.0D);
         var12 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
         var16 = (double)p_78573_8_.func_94207_b(this.field_83022_l * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78679_j == 3) {
         var10 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
         var12 = (double)p_78573_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
         var14 = (double)p_78573_8_.func_94207_b(this.field_83024_j * 16.0D);
         var16 = (double)p_78573_8_.func_94207_b(this.field_83027_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78573_2_ + this.field_83021_g;
      double var28 = p_78573_4_ + this.field_83027_i;
      double var30 = p_78573_4_ + this.field_83024_j;
      double var32 = p_78573_6_ + this.field_83025_k;
      double var34 = p_78573_6_ + this.field_83022_l;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var26, var30, var34, var18, var22);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var26, var28, var32, var20, var24);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var26, var28, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var30, var34, var18, var22);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var26, var28, var32, var20, var24);
         var9.func_78374_a(var26, var28, var34, var12, var16);
      }

   }

   public void func_78605_f(Block p_78605_1_, double p_78605_2_, double p_78605_4_, double p_78605_6_, Icon p_78605_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_94167_b()) {
         p_78605_8_ = this.field_78664_d;
      }

      double var10 = (double)p_78605_8_.func_94214_a(this.field_83025_k * 16.0D);
      double var12 = (double)p_78605_8_.func_94214_a(this.field_83022_l * 16.0D);
      double var14 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83024_j * 16.0D);
      double var16 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83027_i * 16.0D);
      double var18;
      if(this.field_78666_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_83025_k < 0.0D || this.field_83022_l > 1.0D) {
         var10 = (double)p_78605_8_.func_94209_e();
         var12 = (double)p_78605_8_.func_94212_f();
      }

      if(this.field_83027_i < 0.0D || this.field_83024_j > 1.0D) {
         var14 = (double)p_78605_8_.func_94206_g();
         var16 = (double)p_78605_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_78685_i == 2) {
         var10 = (double)p_78605_8_.func_94214_a(this.field_83027_i * 16.0D);
         var14 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83025_k * 16.0D);
         var12 = (double)p_78605_8_.func_94214_a(this.field_83024_j * 16.0D);
         var16 = (double)p_78605_8_.func_94207_b(16.0D - this.field_83022_l * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_78685_i == 1) {
         var10 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83024_j * 16.0D);
         var14 = (double)p_78605_8_.func_94207_b(this.field_83022_l * 16.0D);
         var12 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83027_i * 16.0D);
         var16 = (double)p_78605_8_.func_94207_b(this.field_83025_k * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_78685_i == 3) {
         var10 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83025_k * 16.0D);
         var12 = (double)p_78605_8_.func_94214_a(16.0D - this.field_83022_l * 16.0D);
         var14 = (double)p_78605_8_.func_94207_b(this.field_83024_j * 16.0D);
         var16 = (double)p_78605_8_.func_94207_b(this.field_83027_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_78605_2_ + this.field_83026_h;
      double var28 = p_78605_4_ + this.field_83027_i;
      double var30 = p_78605_4_ + this.field_83024_j;
      double var32 = p_78605_6_ + this.field_83025_k;
      double var34 = p_78605_6_ + this.field_83022_l;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var26, var28, var34, var20, var24);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var26, var28, var32, var12, var16);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var26, var30, var32, var18, var22);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var26, var30, var34, var10, var14);
      } else {
         var9.func_78374_a(var26, var28, var34, var20, var24);
         var9.func_78374_a(var26, var28, var32, var12, var16);
         var9.func_78374_a(var26, var30, var32, var18, var22);
         var9.func_78374_a(var26, var30, var34, var10, var14);
      }

   }

   public void func_78600_a(Block p_78600_1_, int p_78600_2_, float p_78600_3_) {
      Tessellator var4 = Tessellator.field_78398_a;
      boolean var5 = p_78600_1_.field_71990_ca == Block.field_71980_u.field_71990_ca;
      if(p_78600_1_ == Block.field_71958_P || p_78600_1_ == Block.field_96469_cy || p_78600_1_ == Block.field_72051_aB) {
         p_78600_2_ = 3;
      }

      int var6;
      float var7;
      float var8;
      float var9;
      if(this.field_78668_c) {
         var6 = p_78600_1_.func_71889_f_(p_78600_2_);
         if(var5) {
            var6 = 16777215;
         }

         var7 = (float)(var6 >> 16 & 255) / 255.0F;
         var8 = (float)(var6 >> 8 & 255) / 255.0F;
         var9 = (float)(var6 & 255) / 255.0F;
         GL11.glColor4f(var7 * p_78600_3_, var8 * p_78600_3_, var9 * p_78600_3_, 1.0F);
      }

      var6 = p_78600_1_.func_71857_b();
      this.func_83018_a(p_78600_1_);
      int var14;
      if(var6 != 0 && var6 != 31 && var6 != 39 && var6 != 16 && var6 != 26) {
         if(var6 == 1) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78599_a(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D, 1.0F);
            var4.func_78381_a();
         } else if(var6 == 19) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_78600_1_.func_71919_f();
            this.func_78575_a(p_78600_1_, p_78600_2_, this.field_83024_j, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 23) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_78600_1_.func_71919_f();
            var4.func_78381_a();
         } else if(var6 == 13) {
            p_78600_1_.func_71919_f();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var7 = 0.0625F;
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, -1.0F);
            var4.func_78372_c(0.0F, 0.0F, var7);
            this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
            var4.func_78372_c(0.0F, 0.0F, -var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, 1.0F);
            var4.func_78372_c(0.0F, 0.0F, -var7);
            this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
            var4.func_78372_c(0.0F, 0.0F, var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(-1.0F, 0.0F, 0.0F);
            var4.func_78372_c(var7, 0.0F, 0.0F);
            this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(1.0F, 0.0F, 0.0F);
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
            var4.func_78372_c(var7, 0.0F, 0.0F);
            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 22) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            ChestItemRenderHelper.field_78545_a.func_78542_a(p_78600_1_, p_78600_2_, p_78600_3_);
            GL11.glEnable('\u803a');
         } else if(var6 == 6) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78579_b(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 2) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78623_a(p_78600_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D, 0);
            var4.func_78381_a();
         } else if(var6 == 10) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D);
               }

               if(var14 == 1) {
                  this.func_83020_a(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 27) {
            var14 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.func_78382_b();

            for(int var15 = 0; var15 < 8; ++var15) {
               byte var16 = 0;
               byte var17 = 1;
               if(var15 == 0) {
                  var16 = 2;
               }

               if(var15 == 1) {
                  var16 = 3;
               }

               if(var15 == 2) {
                  var16 = 4;
               }

               if(var15 == 3) {
                  var16 = 5;
                  var17 = 2;
               }

               if(var15 == 4) {
                  var16 = 6;
                  var17 = 3;
               }

               if(var15 == 5) {
                  var16 = 7;
                  var17 = 5;
               }

               if(var15 == 6) {
                  var16 = 6;
                  var17 = 2;
               }

               if(var15 == 7) {
                  var16 = 3;
               }

               float var11 = (float)var16 / 16.0F;
               float var12 = 1.0F - (float)var14 / 16.0F;
               float var13 = 1.0F - (float)(var14 + var17) / 16.0F;
               var14 += var17;
               this.func_83020_a((double)(0.5F - var11), (double)var13, (double)(0.5F - var11), (double)(0.5F + var11), (double)var12, (double)(0.5F + var11));
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
            }

            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 11) {
            for(var14 = 0; var14 < 4; ++var14) {
               var8 = 0.125F;
               if(var14 == 0) {
                  this.func_83020_a((double)(0.5F - var8), 0.0D, 0.0D, (double)(0.5F + var8), 1.0D, (double)(var8 * 2.0F));
               }

               if(var14 == 1) {
                  this.func_83020_a((double)(0.5F - var8), 0.0D, (double)(1.0F - var8 * 2.0F), (double)(0.5F + var8), 1.0D, 1.0D);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  this.func_83020_a((double)(0.5F - var8), (double)(1.0F - var8 * 3.0F), (double)(-var8 * 2.0F), (double)(0.5F + var8), (double)(1.0F - var8), (double)(1.0F + var8 * 2.0F));
               }

               if(var14 == 3) {
                  this.func_83020_a((double)(0.5F - var8), (double)(0.5F - var8 * 3.0F), (double)(-var8 * 2.0F), (double)(0.5F + var8), (double)(0.5F - var8), (double)(1.0F + var8 * 2.0F));
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 21) {
            for(var14 = 0; var14 < 3; ++var14) {
               var8 = 0.0625F;
               if(var14 == 0) {
                  this.func_83020_a((double)(0.5F - var8), 0.30000001192092896D, 0.0D, (double)(0.5F + var8), 1.0D, (double)(var8 * 2.0F));
               }

               if(var14 == 1) {
                  this.func_83020_a((double)(0.5F - var8), 0.30000001192092896D, (double)(1.0F - var8 * 2.0F), (double)(0.5F + var8), 1.0D, 1.0D);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  this.func_83020_a((double)(0.5F - var8), 0.5D, 0.0D, (double)(0.5F + var8), (double)(1.0F - var8), 1.0D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94173_a(p_78600_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 32) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  this.func_83020_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
               }

               if(var14 == 1) {
                  this.func_83020_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 35) {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            this.func_82776_a((BlockAnvil)p_78600_1_, 0, 0, 0, p_78600_2_, true);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 34) {
            for(var14 = 0; var14 < 3; ++var14) {
               if(var14 == 0) {
                  this.func_83020_a(0.125D, 0.0D, 0.125D, 0.875D, 0.1875D, 0.875D);
                  this.func_82774_a(this.func_94175_b(Block.field_72089_ap));
               } else if(var14 == 1) {
                  this.func_83020_a(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
                  this.func_82774_a(Block.field_82518_cd.func_94446_i());
               } else if(var14 == 2) {
                  this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                  this.func_82774_a(this.func_94175_b(Block.field_71946_M));
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_83020_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            this.func_78595_a();
         } else if(var6 == 38) {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            this.func_96447_a((BlockHopper)p_78600_1_, 0, 0, 0, 0, true);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         }
      } else {
         if(var6 == 16) {
            p_78600_2_ = 1;
         }

         p_78600_1_.func_71919_f();
         this.func_83018_a(p_78600_1_);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         var4.func_78382_b();
         var4.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 0, p_78600_2_));
         var4.func_78381_a();
         if(var5 && this.field_78668_c) {
            var14 = p_78600_1_.func_71889_f_(p_78600_2_);
            var8 = (float)(var14 >> 16 & 255) / 255.0F;
            var9 = (float)(var14 >> 8 & 255) / 255.0F;
            float var10 = (float)(var14 & 255) / 255.0F;
            GL11.glColor4f(var8 * p_78600_3_, var9 * p_78600_3_, var10 * p_78600_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 1, p_78600_2_));
         var4.func_78381_a();
         if(var5 && this.field_78668_c) {
            GL11.glColor4f(p_78600_3_, p_78600_3_, p_78600_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 2, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 3, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 4, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, this.func_94165_a(p_78600_1_, 5, p_78600_2_));
         var4.func_78381_a();
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      }

   }

   public static boolean func_78597_b(int p_78597_0_) {
      return p_78597_0_ == 0?true:(p_78597_0_ == 31?true:(p_78597_0_ == 39?true:(p_78597_0_ == 13?true:(p_78597_0_ == 10?true:(p_78597_0_ == 11?true:(p_78597_0_ == 27?true:(p_78597_0_ == 22?true:(p_78597_0_ == 21?true:(p_78597_0_ == 16?true:(p_78597_0_ == 26?true:(p_78597_0_ == 32?true:(p_78597_0_ == 34?true:p_78597_0_ == 35))))))))))));
   }

   public Icon func_94170_a(Block p_94170_1_, IBlockAccess p_94170_2_, int p_94170_3_, int p_94170_4_, int p_94170_5_, int p_94170_6_) {
      return this.func_96446_b(p_94170_1_.func_71895_b(p_94170_2_, p_94170_3_, p_94170_4_, p_94170_5_, p_94170_6_));
   }

   public Icon func_94165_a(Block p_94165_1_, int p_94165_2_, int p_94165_3_) {
      return this.func_96446_b(p_94165_1_.func_71858_a(p_94165_2_, p_94165_3_));
   }

   public Icon func_94173_a(Block p_94173_1_, int p_94173_2_) {
      return this.func_96446_b(p_94173_1_.func_71851_a(p_94173_2_));
   }

   public Icon func_94175_b(Block p_94175_1_) {
      return this.func_96446_b(p_94175_1_.func_71851_a(1));
   }

   public Icon func_96446_b(Icon p_96446_1_) {
      return p_96446_1_ == null?this.field_94177_n.field_71446_o.func_96448_c(0):p_96446_1_;
   }

}
