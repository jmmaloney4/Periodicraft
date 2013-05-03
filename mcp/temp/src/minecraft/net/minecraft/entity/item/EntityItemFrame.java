package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityItemFrame extends EntityHanging {

   private float field_82337_e = 1.0F;


   public EntityItemFrame(World p_i5055_1_) {
      super(p_i5055_1_);
   }

   public EntityItemFrame(World p_i5056_1_, int p_i5056_2_, int p_i5056_3_, int p_i5056_4_, int p_i5056_5_) {
      super(p_i5056_1_, p_i5056_2_, p_i5056_3_, p_i5056_4_, p_i5056_5_);
      this.func_82328_a(p_i5056_5_);
   }

   protected void func_70088_a() {
      this.func_70096_w().func_82709_a(2, 5);
      this.func_70096_w().func_75682_a(3, Byte.valueOf((byte)0));
   }

   public int func_82329_d() {
      return 9;
   }

   public int func_82330_g() {
      return 9;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double p_70112_1_) {
      double var3 = 16.0D;
      var3 *= 64.0D * this.field_70155_l;
      return p_70112_1_ < var3 * var3;
   }

   public void func_82331_h() {
      this.func_70099_a(new ItemStack(Item.field_82802_bI), 0.0F);
      ItemStack var1 = this.func_82335_i();
      if(var1 != null && this.field_70146_Z.nextFloat() < this.field_82337_e) {
         var1 = var1.func_77946_l();
         var1.func_82842_a((EntityItemFrame)null);
         this.func_70099_a(var1, 0.0F);
      }

   }

   public ItemStack func_82335_i() {
      return this.func_70096_w().func_82710_f(2);
   }

   public void func_82334_a(ItemStack p_82334_1_) {
      p_82334_1_ = p_82334_1_.func_77946_l();
      p_82334_1_.field_77994_a = 1;
      p_82334_1_.func_82842_a(this);
      this.func_70096_w().func_75692_b(2, p_82334_1_);
      this.func_70096_w().func_82708_h(2);
   }

   public int func_82333_j() {
      return this.func_70096_w().func_75683_a(3);
   }

   public void func_82336_g(int p_82336_1_) {
      this.func_70096_w().func_75692_b(3, Byte.valueOf((byte)(p_82336_1_ % 4)));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      if(this.func_82335_i() != null) {
         p_70014_1_.func_74766_a("Item", this.func_82335_i().func_77955_b(new NBTTagCompound()));
         p_70014_1_.func_74774_a("ItemRotation", (byte)this.func_82333_j());
         p_70014_1_.func_74776_a("ItemDropChance", this.field_82337_e);
      }

      super.func_70014_b(p_70014_1_);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      NBTTagCompound var2 = p_70037_1_.func_74775_l("Item");
      if(var2 != null && !var2.func_82582_d()) {
         this.func_82334_a(ItemStack.func_77949_a(var2));
         this.func_82336_g(p_70037_1_.func_74771_c("ItemRotation"));
         if(p_70037_1_.func_74764_b("ItemDropChance")) {
            this.field_82337_e = p_70037_1_.func_74760_g("ItemDropChance");
         }
      }

      super.func_70037_a(p_70037_1_);
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(this.func_82335_i() == null) {
         ItemStack var2 = p_70085_1_.func_70694_bm();
         if(var2 != null && !this.field_70170_p.field_72995_K) {
            this.func_82334_a(var2);
            if(!p_70085_1_.field_71075_bZ.field_75098_d && --var2.field_77994_a <= 0) {
               p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
            }
         }
      } else if(!this.field_70170_p.field_72995_K) {
         this.func_82336_g(this.func_82333_j() + 1);
      }

      return true;
   }
}
