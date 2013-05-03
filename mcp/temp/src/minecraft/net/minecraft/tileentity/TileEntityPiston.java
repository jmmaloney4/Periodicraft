package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;

public class TileEntityPiston extends TileEntity {

   private int field_70348_a;
   private int field_70346_b;
   private int field_70347_c;
   private boolean field_70344_d;
   private boolean field_70345_e;
   private float field_70342_f;
   private float field_70343_g;
   private List field_70349_h = new ArrayList();


   public TileEntityPiston() {}

   public TileEntityPiston(int p_i4028_1_, int p_i4028_2_, int p_i4028_3_, boolean p_i4028_4_, boolean p_i4028_5_) {
      this.field_70348_a = p_i4028_1_;
      this.field_70346_b = p_i4028_2_;
      this.field_70347_c = p_i4028_3_;
      this.field_70344_d = p_i4028_4_;
      this.field_70345_e = p_i4028_5_;
   }

   public int func_70340_a() {
      return this.field_70348_a;
   }

   public int func_70322_n() {
      return this.field_70346_b;
   }

   public boolean func_70341_b() {
      return this.field_70344_d;
   }

   public int func_70336_c() {
      return this.field_70347_c;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70338_f() {
      return this.field_70345_e;
   }

   public float func_70333_a(float p_70333_1_) {
      if(p_70333_1_ > 1.0F) {
         p_70333_1_ = 1.0F;
      }

      return this.field_70343_g + (this.field_70342_f - this.field_70343_g) * p_70333_1_;
   }

   private void func_70335_a(float p_70335_1_, float p_70335_2_) {
      if(this.field_70344_d) {
         p_70335_1_ = 1.0F - p_70335_1_;
      } else {
         --p_70335_1_;
      }

      AxisAlignedBB var3 = Block.field_72095_ac.func_72296_b(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70348_a, p_70335_1_, this.field_70347_c);
      if(var3 != null) {
         List var4 = this.field_70331_k.func_72839_b((Entity)null, var3);
         if(!var4.isEmpty()) {
            this.field_70349_h.addAll(var4);
            Iterator var5 = this.field_70349_h.iterator();

            while(var5.hasNext()) {
               Entity var6 = (Entity)var5.next();
               var6.func_70091_d((double)(p_70335_2_ * (float)Facing.field_71586_b[this.field_70347_c]), (double)(p_70335_2_ * (float)Facing.field_71587_c[this.field_70347_c]), (double)(p_70335_2_ * (float)Facing.field_71585_d[this.field_70347_c]));
            }

            this.field_70349_h.clear();
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public float func_70337_b(float p_70337_1_) {
      return this.field_70344_d?(this.func_70333_a(p_70337_1_) - 1.0F) * (float)Facing.field_71586_b[this.field_70347_c]:(1.0F - this.func_70333_a(p_70337_1_)) * (float)Facing.field_71586_b[this.field_70347_c];
   }

   @SideOnly(Side.CLIENT)
   public float func_70334_c(float p_70334_1_) {
      return this.field_70344_d?(this.func_70333_a(p_70334_1_) - 1.0F) * (float)Facing.field_71587_c[this.field_70347_c]:(1.0F - this.func_70333_a(p_70334_1_)) * (float)Facing.field_71587_c[this.field_70347_c];
   }

   @SideOnly(Side.CLIENT)
   public float func_70332_d(float p_70332_1_) {
      return this.field_70344_d?(this.func_70333_a(p_70332_1_) - 1.0F) * (float)Facing.field_71585_d[this.field_70347_c]:(1.0F - this.func_70333_a(p_70332_1_)) * (float)Facing.field_71585_d[this.field_70347_c];
   }

   public void func_70339_i() {
      if(this.field_70343_g < 1.0F && this.field_70331_k != null) {
         this.field_70343_g = this.field_70342_f = 1.0F;
         this.field_70331_k.func_72932_q(this.field_70329_l, this.field_70330_m, this.field_70327_n);
         this.func_70313_j();
         if(this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == Block.field_72095_ac.field_71990_ca) {
            this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70348_a, this.field_70346_b, 3);
            this.field_70331_k.func_72821_m(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70348_a);
         }
      }

   }

   public void func_70316_g() {
      this.field_70343_g = this.field_70342_f;
      if(this.field_70343_g >= 1.0F) {
         this.func_70335_a(1.0F, 0.25F);
         this.field_70331_k.func_72932_q(this.field_70329_l, this.field_70330_m, this.field_70327_n);
         this.func_70313_j();
         if(this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n) == Block.field_72095_ac.field_71990_ca) {
            this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70348_a, this.field_70346_b, 3);
            this.field_70331_k.func_72821_m(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70348_a);
         }

      } else {
         this.field_70342_f += 0.5F;
         if(this.field_70342_f >= 1.0F) {
            this.field_70342_f = 1.0F;
         }

         if(this.field_70344_d) {
            this.func_70335_a(this.field_70342_f, this.field_70342_f - this.field_70343_g + 0.0625F);
         }

      }
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_70348_a = p_70307_1_.func_74762_e("blockId");
      this.field_70346_b = p_70307_1_.func_74762_e("blockData");
      this.field_70347_c = p_70307_1_.func_74762_e("facing");
      this.field_70343_g = this.field_70342_f = p_70307_1_.func_74760_g("progress");
      this.field_70344_d = p_70307_1_.func_74767_n("extending");
   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74768_a("blockId", this.field_70348_a);
      p_70310_1_.func_74768_a("blockData", this.field_70346_b);
      p_70310_1_.func_74768_a("facing", this.field_70347_c);
      p_70310_1_.func_74776_a("progress", this.field_70343_g);
      p_70310_1_.func_74757_a("extending", this.field_70344_d);
   }
}
