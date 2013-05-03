package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

@SideOnly(Side.CLIENT)
class SlotCreativeInventory extends Slot {

   private final Slot field_75241_b;
   // $FF: synthetic field
   final GuiContainerCreative field_75242_a;


   public SlotCreativeInventory(GuiContainerCreative p_i3088_1_, Slot p_i3088_2_, int p_i3088_3_) {
      super(p_i3088_2_.field_75224_c, p_i3088_3_, 0, 0);
      this.field_75242_a = p_i3088_1_;
      this.field_75241_b = p_i3088_2_;
   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      this.field_75241_b.func_82870_a(p_82870_1_, p_82870_2_);
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return this.field_75241_b.func_75214_a(p_75214_1_);
   }

   public ItemStack func_75211_c() {
      return this.field_75241_b.func_75211_c();
   }

   public boolean func_75216_d() {
      return this.field_75241_b.func_75216_d();
   }

   public void func_75215_d(ItemStack p_75215_1_) {
      this.field_75241_b.func_75215_d(p_75215_1_);
   }

   public void func_75218_e() {
      this.field_75241_b.func_75218_e();
   }

   public int func_75219_a() {
      return this.field_75241_b.func_75219_a();
   }

   public Icon func_75212_b() {
      return this.field_75241_b.func_75212_b();
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      return this.field_75241_b.func_75209_a(p_75209_1_);
   }

   public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_) {
      return this.field_75241_b.func_75217_a(p_75217_1_, p_75217_2_);
   }

   // $FF: synthetic method
   static Slot func_75240_a(SlotCreativeInventory p_75240_0_) {
      return p_75240_0_.field_75241_b;
   }
}
