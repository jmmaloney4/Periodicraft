package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityEnderEye extends Entity {

   public int field_70226_a = 0;
   private double field_70224_b;
   private double field_70225_c;
   private double field_70222_d;
   private int field_70223_e;
   private boolean field_70221_f;


   public EntityEnderEye(World p_i3569_1_) {
      super(p_i3569_1_);
      this.func_70105_a(0.25F, 0.25F);
   }

   protected void func_70088_a() {}

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.field_70121_D.func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public EntityEnderEye(World p_i3570_1_, double p_i3570_2_, double p_i3570_4_, double p_i3570_6_) {
      super(p_i3570_1_);
      this.field_70223_e = 0;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70107_b(p_i3570_2_, p_i3570_4_, p_i3570_6_);
      this.field_70129_M = 0.0F;
   }

   public void func_70220_a(double p_70220_1_, int p_70220_3_, double p_70220_4_) {
      double var6 = p_70220_1_ - this.field_70165_t;
      double var8 = p_70220_4_ - this.field_70161_v;
      float var10 = MathHelper.func_76133_a(var6 * var6 + var8 * var8);
      if(var10 > 12.0F) {
         this.field_70224_b = this.field_70165_t + var6 / (double)var10 * 12.0D;
         this.field_70222_d = this.field_70161_v + var8 / (double)var10 * 12.0D;
         this.field_70225_c = this.field_70163_u + 8.0D;
      } else {
         this.field_70224_b = p_70220_1_;
         this.field_70225_c = (double)p_70220_3_;
         this.field_70222_d = p_70220_4_;
      }

      this.field_70223_e = 0;
      this.field_70221_f = this.field_70146_Z.nextInt(5) > 0;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70159_w = p_70016_1_;
      this.field_70181_x = p_70016_3_;
      this.field_70179_y = p_70016_5_;
      if(this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var7 = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      this.field_70165_t += this.field_70159_w;
      this.field_70163_u += this.field_70181_x;
      this.field_70161_v += this.field_70179_y;
      float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);

      for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var1) * 180.0D / 3.1415927410125732D); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
         ;
      }

      while(this.field_70125_A - this.field_70127_C >= 180.0F) {
         this.field_70127_C += 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B < -180.0F) {
         this.field_70126_B -= 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B >= 180.0F) {
         this.field_70126_B += 360.0F;
      }

      this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
      this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
      if(!this.field_70170_p.field_72995_K) {
         double var2 = this.field_70224_b - this.field_70165_t;
         double var4 = this.field_70222_d - this.field_70161_v;
         float var6 = (float)Math.sqrt(var2 * var2 + var4 * var4);
         float var7 = (float)Math.atan2(var4, var2);
         double var8 = (double)var1 + (double)(var6 - var1) * 0.0025D;
         if(var6 < 1.0F) {
            var8 *= 0.8D;
            this.field_70181_x *= 0.8D;
         }

         this.field_70159_w = Math.cos((double)var7) * var8;
         this.field_70179_y = Math.sin((double)var7) * var8;
         if(this.field_70163_u < this.field_70225_c) {
            this.field_70181_x += (1.0D - this.field_70181_x) * 0.014999999664723873D;
         } else {
            this.field_70181_x += (-1.0D - this.field_70181_x) * 0.014999999664723873D;
         }
      }

      float var10 = 0.25F;
      if(this.func_70090_H()) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)var10, this.field_70163_u - this.field_70181_x * (double)var10, this.field_70161_v - this.field_70179_y * (double)var10, this.field_70159_w, this.field_70181_x, this.field_70179_y);
         }
      } else {
         this.field_70170_p.func_72869_a("portal", this.field_70165_t - this.field_70159_w * (double)var10 + this.field_70146_Z.nextDouble() * 0.6D - 0.3D, this.field_70163_u - this.field_70181_x * (double)var10 - 0.5D, this.field_70161_v - this.field_70179_y * (double)var10 + this.field_70146_Z.nextDouble() * 0.6D - 0.3D, this.field_70159_w, this.field_70181_x, this.field_70179_y);
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         ++this.field_70223_e;
         if(this.field_70223_e > 80 && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
            if(this.field_70221_f) {
               this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77748_bA)));
            } else {
               this.field_70170_p.func_72926_e(2003, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
            }
         }
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {}

   public void func_70037_a(NBTTagCompound p_70037_1_) {}

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }

   @SideOnly(Side.CLIENT)
   public int func_70070_b(float p_70070_1_) {
      return 15728880;
   }

   public boolean func_70075_an() {
      return false;
   }
}
