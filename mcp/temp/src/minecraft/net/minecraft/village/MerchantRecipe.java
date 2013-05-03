package net.minecraft.village;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MerchantRecipe {

   private ItemStack field_77403_a;
   private ItemStack field_77401_b;
   private ItemStack field_77402_c;
   private int field_77400_d;
   private int field_82786_e;


   public MerchantRecipe(NBTTagCompound p_i3721_1_) {
      this.func_77390_a(p_i3721_1_);
   }

   public MerchantRecipe(ItemStack p_i3722_1_, ItemStack p_i3722_2_, ItemStack p_i3722_3_) {
      this.field_77403_a = p_i3722_1_;
      this.field_77401_b = p_i3722_2_;
      this.field_77402_c = p_i3722_3_;
      this.field_82786_e = 7;
   }

   public MerchantRecipe(ItemStack p_i3723_1_, ItemStack p_i3723_2_) {
      this(p_i3723_1_, (ItemStack)null, p_i3723_2_);
   }

   public MerchantRecipe(ItemStack p_i3724_1_, Item p_i3724_2_) {
      this(p_i3724_1_, new ItemStack(p_i3724_2_));
   }

   public ItemStack func_77394_a() {
      return this.field_77403_a;
   }

   public ItemStack func_77396_b() {
      return this.field_77401_b;
   }

   public boolean func_77398_c() {
      return this.field_77401_b != null;
   }

   public ItemStack func_77397_d() {
      return this.field_77402_c;
   }

   public boolean func_77393_a(MerchantRecipe p_77393_1_) {
      return this.field_77403_a.field_77993_c == p_77393_1_.field_77403_a.field_77993_c && this.field_77402_c.field_77993_c == p_77393_1_.field_77402_c.field_77993_c?this.field_77401_b == null && p_77393_1_.field_77401_b == null || this.field_77401_b != null && p_77393_1_.field_77401_b != null && this.field_77401_b.field_77993_c == p_77393_1_.field_77401_b.field_77993_c:false;
   }

   public boolean func_77391_b(MerchantRecipe p_77391_1_) {
      return this.func_77393_a(p_77391_1_) && (this.field_77403_a.field_77994_a < p_77391_1_.field_77403_a.field_77994_a || this.field_77401_b != null && this.field_77401_b.field_77994_a < p_77391_1_.field_77401_b.field_77994_a);
   }

   public void func_77399_f() {
      ++this.field_77400_d;
   }

   public void func_82783_a(int p_82783_1_) {
      this.field_82786_e += p_82783_1_;
   }

   public boolean func_82784_g() {
      return this.field_77400_d >= this.field_82786_e;
   }

   @SideOnly(Side.CLIENT)
   public void func_82785_h() {
      this.field_77400_d = this.field_82786_e;
   }

   public void func_77390_a(NBTTagCompound p_77390_1_) {
      NBTTagCompound var2 = p_77390_1_.func_74775_l("buy");
      this.field_77403_a = ItemStack.func_77949_a(var2);
      NBTTagCompound var3 = p_77390_1_.func_74775_l("sell");
      this.field_77402_c = ItemStack.func_77949_a(var3);
      if(p_77390_1_.func_74764_b("buyB")) {
         this.field_77401_b = ItemStack.func_77949_a(p_77390_1_.func_74775_l("buyB"));
      }

      if(p_77390_1_.func_74764_b("uses")) {
         this.field_77400_d = p_77390_1_.func_74762_e("uses");
      }

      if(p_77390_1_.func_74764_b("maxUses")) {
         this.field_82786_e = p_77390_1_.func_74762_e("maxUses");
      } else {
         this.field_82786_e = 7;
      }

   }

   public NBTTagCompound func_77395_g() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_74766_a("buy", this.field_77403_a.func_77955_b(new NBTTagCompound("buy")));
      var1.func_74766_a("sell", this.field_77402_c.func_77955_b(new NBTTagCompound("sell")));
      if(this.field_77401_b != null) {
         var1.func_74766_a("buyB", this.field_77401_b.func_77955_b(new NBTTagCompound("buyB")));
      }

      var1.func_74768_a("uses", this.field_77400_d);
      var1.func_74768_a("maxUses", this.field_82786_e);
      return var1;
   }
}
