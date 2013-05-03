package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemFishingRod extends Item {

   @SideOnly(Side.CLIENT)
   private Icon field_94598_a;


   public ItemFishingRod(int p_i3651_1_) {
      super(p_i3651_1_);
      this.func_77656_e(64);
      this.func_77625_d(1);
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77662_d() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77629_n_() {
      return true;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(p_77659_3_.field_71104_cf != null) {
         int var4 = p_77659_3_.field_71104_cf.func_70198_d();
         p_77659_1_.func_77972_a(var4, p_77659_3_);
         p_77659_3_.func_71038_i();
      } else {
         p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         if(!p_77659_2_.field_72995_K) {
            p_77659_2_.func_72838_d(new EntityFishHook(p_77659_2_, p_77659_3_));
         }

         p_77659_3_.func_71038_i();
      }

      return p_77659_1_;
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IconRegister p_94581_1_) {
      super.func_94581_a(p_94581_1_);
      this.field_94598_a = p_94581_1_.func_94245_a("fishingRod_empty");
   }

   @SideOnly(Side.CLIENT)
   public Icon func_94597_g() {
      return this.field_94598_a;
   }
}
