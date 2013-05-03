package net.minecraft.tileentity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEnchantmentTable extends TileEntity {

   public int field_70378_a;
   public float field_70375_b;
   public float field_70377_c;
   public float field_70373_d;
   public float field_70374_e;
   public float field_70371_f;
   public float field_70372_g;
   public float field_70380_h;
   public float field_70381_i;
   public float field_70379_j;
   private static Random field_70376_r = new Random();
   private String field_94136_s;


   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      if(this.func_94135_b()) {
         p_70310_1_.func_74778_a("CustomName", this.field_94136_s);
      }

   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      if(p_70307_1_.func_74764_b("CustomName")) {
         this.field_94136_s = p_70307_1_.func_74779_i("CustomName");
      }

   }

   public void func_70316_g() {
      super.func_70316_g();
      this.field_70372_g = this.field_70371_f;
      this.field_70381_i = this.field_70380_h;
      EntityPlayer var1 = this.field_70331_k.func_72977_a((double)((float)this.field_70329_l + 0.5F), (double)((float)this.field_70330_m + 0.5F), (double)((float)this.field_70327_n + 0.5F), 3.0D);
      if(var1 != null) {
         double var2 = var1.field_70165_t - (double)((float)this.field_70329_l + 0.5F);
         double var4 = var1.field_70161_v - (double)((float)this.field_70327_n + 0.5F);
         this.field_70379_j = (float)Math.atan2(var4, var2);
         this.field_70371_f += 0.1F;
         if(this.field_70371_f < 0.5F || field_70376_r.nextInt(40) == 0) {
            float var6 = this.field_70373_d;

            do {
               this.field_70373_d += (float)(field_70376_r.nextInt(4) - field_70376_r.nextInt(4));
            } while(var6 == this.field_70373_d);
         }
      } else {
         this.field_70379_j += 0.02F;
         this.field_70371_f -= 0.1F;
      }

      while(this.field_70380_h >= 3.1415927F) {
         this.field_70380_h -= 6.2831855F;
      }

      while(this.field_70380_h < -3.1415927F) {
         this.field_70380_h += 6.2831855F;
      }

      while(this.field_70379_j >= 3.1415927F) {
         this.field_70379_j -= 6.2831855F;
      }

      while(this.field_70379_j < -3.1415927F) {
         this.field_70379_j += 6.2831855F;
      }

      float var7;
      for(var7 = this.field_70379_j - this.field_70380_h; var7 >= 3.1415927F; var7 -= 6.2831855F) {
         ;
      }

      while(var7 < -3.1415927F) {
         var7 += 6.2831855F;
      }

      this.field_70380_h += var7 * 0.4F;
      if(this.field_70371_f < 0.0F) {
         this.field_70371_f = 0.0F;
      }

      if(this.field_70371_f > 1.0F) {
         this.field_70371_f = 1.0F;
      }

      ++this.field_70378_a;
      this.field_70377_c = this.field_70375_b;
      float var3 = (this.field_70373_d - this.field_70375_b) * 0.4F;
      float var8 = 0.2F;
      if(var3 < -var8) {
         var3 = -var8;
      }

      if(var3 > var8) {
         var3 = var8;
      }

      this.field_70374_e += (var3 - this.field_70374_e) * 0.9F;
      this.field_70375_b += this.field_70374_e;
   }

   public String func_94133_a() {
      return this.func_94135_b()?this.field_94136_s:"container.enchant";
   }

   public boolean func_94135_b() {
      return this.field_94136_s != null && this.field_94136_s.length() > 0;
   }

   public void func_94134_a(String p_94134_1_) {
      this.field_94136_s = p_94134_1_;
   }

}
