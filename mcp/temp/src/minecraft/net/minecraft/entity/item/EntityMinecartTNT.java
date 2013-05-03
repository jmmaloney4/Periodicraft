package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityMinecartTNT extends EntityMinecart {

   private int field_94106_a = -1;


   public EntityMinecartTNT(World p_i9007_1_) {
      super(p_i9007_1_);
   }

   public EntityMinecartTNT(World p_i9008_1_, double p_i9008_2_, double p_i9008_4_, double p_i9008_6_) {
      super(p_i9008_1_, p_i9008_2_, p_i9008_4_, p_i9008_6_);
   }

   public int func_94087_l() {
      return 3;
   }

   public Block func_94093_n() {
      return Block.field_72091_am;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_94106_a > 0) {
         --this.field_94106_a;
         this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
      } else if(this.field_94106_a == 0) {
         this.func_94103_c(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      }

      if(this.field_70123_F) {
         double var1 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
         if(var1 >= 0.009999999776482582D) {
            this.func_94103_c(var1);
         }
      }

   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      double var2 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
      if(!p_94095_1_.func_94541_c()) {
         this.func_70099_a(new ItemStack(Block.field_72091_am, 1), 0.0F);
      }

      if(p_94095_1_.func_76347_k() || p_94095_1_.func_94541_c() || var2 >= 0.009999999776482582D) {
         this.func_94103_c(var2);
      }

   }

   protected void func_94103_c(double p_94103_1_) {
      if(!this.field_70170_p.field_72995_K) {
         double var3 = Math.sqrt(p_94103_1_);
         if(var3 > 5.0D) {
            var3 = 5.0D;
         }

         this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)(4.0D + this.field_70146_Z.nextDouble() * 1.5D * var3), true);
         this.func_70106_y();
      }

   }

   protected void func_70069_a(float p_70069_1_) {
      if(p_70069_1_ >= 3.0F) {
         float var2 = p_70069_1_ / 10.0F;
         this.func_94103_c((double)(var2 * var2));
      }

      super.func_70069_a(p_70069_1_);
   }

   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
      if(p_96095_4_ && this.field_94106_a < 0) {
         this.func_94105_c();
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 10) {
         this.func_94105_c();
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public void func_94105_c() {
      this.field_94106_a = 80;
      if(!this.field_70170_p.field_72995_K) {
         this.field_70170_p.func_72960_a(this, (byte)10);
         this.field_70170_p.func_72956_a(this, "random.fuse", 1.0F, 1.0F);
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_94104_d() {
      return this.field_94106_a;
   }

   public boolean func_96096_ay() {
      return this.field_94106_a > -1;
   }

   public float func_82146_a(Explosion p_82146_1_, World p_82146_2_, int p_82146_3_, int p_82146_4_, int p_82146_5_, Block p_82146_6_) {
      return this.func_96096_ay() && (BlockRailBase.func_72184_d(p_82146_6_.field_71990_ca) || BlockRailBase.func_72180_d_(p_82146_2_, p_82146_3_, p_82146_4_ + 1, p_82146_5_))?0.0F:super.func_82146_a(p_82146_1_, p_82146_2_, p_82146_3_, p_82146_4_, p_82146_5_, p_82146_6_);
   }

   public boolean func_96091_a(Explosion p_96091_1_, World p_96091_2_, int p_96091_3_, int p_96091_4_, int p_96091_5_, int p_96091_6_, float p_96091_7_) {
      return this.func_96096_ay() && (BlockRailBase.func_72184_d(p_96091_6_) || BlockRailBase.func_72180_d_(p_96091_2_, p_96091_3_, p_96091_4_ + 1, p_96091_5_))?false:super.func_96091_a(p_96091_1_, p_96091_2_, p_96091_3_, p_96091_4_, p_96091_5_, p_96091_6_, p_96091_7_);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_74764_b("TNTFuse")) {
         this.field_94106_a = p_70037_1_.func_74762_e("TNTFuse");
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("TNTFuse", this.field_94106_a);
   }
}
