package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMinecartFurnace extends EntityMinecart {

   private int field_94110_c = 0;
   public double field_94111_a;
   public double field_94109_b;


   public EntityMinecartFurnace(World p_i9003_1_) {
      super(p_i9003_1_);
   }

   public EntityMinecartFurnace(World p_i9004_1_, double p_i9004_2_, double p_i9004_4_, double p_i9004_6_) {
      super(p_i9004_1_, p_i9004_2_, p_i9004_4_, p_i9004_6_);
   }

   public int func_94087_l() {
      return 2;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_94110_c > 0) {
         --this.field_94110_c;
      }

      if(this.field_94110_c <= 0) {
         this.field_94111_a = this.field_94109_b = 0.0D;
      }

      this.func_94107_f(this.field_94110_c > 0);
      if(this.func_94108_c() && this.field_70146_Z.nextInt(4) == 0) {
         this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u + 0.8D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
      }

   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      if(!p_94095_1_.func_94541_c()) {
         this.func_70099_a(new ItemStack(Block.field_72051_aB, 1), 0.0F);
      }

   }

   protected void func_94091_a(int p_94091_1_, int p_94091_2_, int p_94091_3_, double p_94091_4_, double p_94091_6_, int p_94091_8_, int p_94091_9_) {
      super.func_94091_a(p_94091_1_, p_94091_2_, p_94091_3_, p_94091_4_, p_94091_6_, p_94091_8_, p_94091_9_);
      double var10 = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
      if(var10 > 1.0E-4D && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.0010D) {
         var10 = (double)MathHelper.func_76133_a(var10);
         this.field_94111_a /= var10;
         this.field_94109_b /= var10;
         if(this.field_94111_a * this.field_70159_w + this.field_94109_b * this.field_70179_y < 0.0D) {
            this.field_94111_a = 0.0D;
            this.field_94109_b = 0.0D;
         } else {
            this.field_94111_a = this.field_70159_w;
            this.field_94109_b = this.field_70179_y;
         }
      }

   }

   protected void func_94101_h() {
      double var1 = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
      if(var1 > 1.0E-4D) {
         var1 = (double)MathHelper.func_76133_a(var1);
         this.field_94111_a /= var1;
         this.field_94109_b /= var1;
         double var3 = 0.05D;
         this.field_70159_w *= 0.800000011920929D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.800000011920929D;
         this.field_70159_w += this.field_94111_a * var3;
         this.field_70179_y += this.field_94109_b * var3;
      } else {
         this.field_70159_w *= 0.9800000190734863D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.9800000190734863D;
      }

      super.func_94101_h();
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.field_77993_c == Item.field_77705_m.field_77779_bT) {
         if(--var2.field_77994_a == 0) {
            p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
         }

         this.field_94110_c += 3600;
      }

      this.field_94111_a = this.field_70165_t - p_70085_1_.field_70165_t;
      this.field_94109_b = this.field_70161_v - p_70085_1_.field_70161_v;
      return true;
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74780_a("PushX", this.field_94111_a);
      p_70014_1_.func_74780_a("PushZ", this.field_94109_b);
      p_70014_1_.func_74777_a("Fuel", (short)this.field_94110_c);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_94111_a = p_70037_1_.func_74769_h("PushX");
      this.field_94109_b = p_70037_1_.func_74769_h("PushZ");
      this.field_94110_c = p_70037_1_.func_74765_d("Fuel");
   }

   protected boolean func_94108_c() {
      return (this.field_70180_af.func_75683_a(16) & 1) != 0;
   }

   protected void func_94107_f(boolean p_94107_1_) {
      if(p_94107_1_) {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(this.field_70180_af.func_75683_a(16) | 1)));
      } else {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(this.field_70180_af.func_75683_a(16) & -2)));
      }

   }

   public Block func_94093_n() {
      return Block.field_72052_aC;
   }

   public int func_94097_p() {
      return 2;
   }
}
