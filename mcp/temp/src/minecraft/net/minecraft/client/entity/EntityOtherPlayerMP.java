package net.minecraft.client.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityOtherPlayerMP extends EntityPlayer {

   private boolean field_71186_a = false;
   private int field_71184_b;
   private double field_71185_c;
   private double field_71182_d;
   private double field_71183_e;
   private double field_71180_f;
   private double field_71181_g;


   public EntityOtherPlayerMP(World p_i3117_1_, String p_i3117_2_) {
      super(p_i3117_1_);
      this.field_71092_bJ = p_i3117_2_;
      this.field_70129_M = 0.0F;
      this.field_70138_W = 0.0F;
      if(p_i3117_2_ != null && p_i3117_2_.length() > 0) {
         this.field_70120_cr = "http://skins.minecraft.net/MinecraftSkins/" + StringUtils.func_76338_a(p_i3117_2_) + ".png";
      }

      this.field_70145_X = true;
      this.field_71082_cx = 0.25F;
      this.field_70155_l = 10.0D;
   }

   protected void func_71061_d_() {
      this.field_70129_M = 0.0F;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      return true;
   }

   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      this.field_71185_c = p_70056_1_;
      this.field_71182_d = p_70056_3_;
      this.field_71183_e = p_70056_5_;
      this.field_71180_f = (double)p_70056_7_;
      this.field_71181_g = (double)p_70056_8_;
      this.field_71184_b = p_70056_9_;
   }

   public void func_70059_ac() {
      this.field_70119_cs = "http://skins.minecraft.net/MinecraftCloaks/" + StringUtils.func_76338_a(this.field_71092_bJ) + ".png";
   }

   public void func_70071_h_() {
      this.field_71082_cx = 0.0F;
      super.func_70071_h_();
      this.field_70722_aY = this.field_70721_aZ;
      double var1 = this.field_70165_t - this.field_70169_q;
      double var3 = this.field_70161_v - this.field_70166_s;
      float var5 = MathHelper.func_76133_a(var1 * var1 + var3 * var3) * 4.0F;
      if(var5 > 1.0F) {
         var5 = 1.0F;
      }

      this.field_70721_aZ += (var5 - this.field_70721_aZ) * 0.4F;
      this.field_70754_ba += this.field_70721_aZ;
      if(!this.field_71186_a && this.func_70113_ah() && this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] != null) {
         ItemStack var6 = this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c];
         this.func_71008_a(this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c], Item.field_77698_e[var6.field_77993_c].func_77626_a(var6));
         this.field_71186_a = true;
      } else if(this.field_71186_a && !this.func_70113_ah()) {
         this.func_71041_bz();
         this.field_71186_a = false;
      }

   }

   public float func_70053_R() {
      return 0.0F;
   }

   public void func_70636_d() {
      super.func_70626_be();
      if(this.field_71184_b > 0) {
         double var1 = this.field_70165_t + (this.field_71185_c - this.field_70165_t) / (double)this.field_71184_b;
         double var3 = this.field_70163_u + (this.field_71182_d - this.field_70163_u) / (double)this.field_71184_b;
         double var5 = this.field_70161_v + (this.field_71183_e - this.field_70161_v) / (double)this.field_71184_b;

         double var7;
         for(var7 = this.field_71180_f - (double)this.field_70177_z; var7 < -180.0D; var7 += 360.0D) {
            ;
         }

         while(var7 >= 180.0D) {
            var7 -= 360.0D;
         }

         this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_71184_b);
         this.field_70125_A = (float)((double)this.field_70125_A + (this.field_71181_g - (double)this.field_70125_A) / (double)this.field_71184_b);
         --this.field_71184_b;
         this.func_70107_b(var1, var3, var5);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
      }

      this.field_71107_bF = this.field_71109_bG;
      float var9 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      float var2 = (float)Math.atan(-this.field_70181_x * 0.20000000298023224D) * 15.0F;
      if(var9 > 0.1F) {
         var9 = 0.1F;
      }

      if(!this.field_70122_E || this.func_70630_aN() <= 0) {
         var9 = 0.0F;
      }

      if(this.field_70122_E || this.func_70630_aN() <= 0) {
         var2 = 0.0F;
      }

      this.field_71109_bG += (var9 - this.field_71109_bG) * 0.4F;
      this.field_70726_aT += (var2 - this.field_70726_aT) * 0.8F;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
      if(p_70062_1_ == 0) {
         this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] = p_70062_2_;
      } else {
         this.field_71071_by.field_70460_b[p_70062_1_ - 1] = p_70062_2_;
      }

   }

   public float func_70047_e() {
      return 1.82F;
   }

   public void func_70006_a(String p_70006_1_) {
      Minecraft.func_71410_x().field_71456_v.func_73827_b().func_73765_a(p_70006_1_);
   }

   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
      return false;
   }

   public ChunkCoordinates func_82114_b() {
      return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t + 0.5D), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v + 0.5D));
   }
}
