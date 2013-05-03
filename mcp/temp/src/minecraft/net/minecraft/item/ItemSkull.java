package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSkull extends Item {

   private static final String[] field_82807_a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};
   public static final String[] field_94587_a = new String[]{"skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper"};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94586_c;


   public ItemSkull(int p_i5088_1_) {
      super(p_i5088_1_);
      this.func_77637_a(CreativeTabs.field_78031_c);
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ == 0) {
         return false;
      } else if(!p_77648_3_.func_72803_f(p_77648_4_, p_77648_5_, p_77648_6_).func_76220_a()) {
         return false;
      } else {
         if(p_77648_7_ == 1) {
            ++p_77648_5_;
         }

         if(p_77648_7_ == 2) {
            --p_77648_6_;
         }

         if(p_77648_7_ == 3) {
            ++p_77648_6_;
         }

         if(p_77648_7_ == 4) {
            --p_77648_4_;
         }

         if(p_77648_7_ == 5) {
            ++p_77648_4_;
         }

         if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
         } else if(!Block.field_82512_cj.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
         } else {
            p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_82512_cj.field_71990_ca, p_77648_7_, 2);
            int var11 = 0;
            if(p_77648_7_ == 1) {
               var11 = MathHelper.func_76128_c((double)(p_77648_2_.field_70177_z * 16.0F / 360.0F) + 0.5D) & 15;
            }

            TileEntity var12 = p_77648_3_.func_72796_p(p_77648_4_, p_77648_5_, p_77648_6_);
            if(var12 != null && var12 instanceof TileEntitySkull) {
               String var13 = "";
               if(p_77648_1_.func_77942_o() && p_77648_1_.func_77978_p().func_74764_b("SkullOwner")) {
                  var13 = p_77648_1_.func_77978_p().func_74779_i("SkullOwner");
               }

               ((TileEntitySkull)var12).func_82118_a(p_77648_1_.func_77960_j(), var13);
               ((TileEntitySkull)var12).func_82116_a(var11);
               ((BlockSkull)Block.field_82512_cj).func_82529_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (TileEntitySkull)var12);
            }

            --p_77648_1_.field_77994_a;
            return true;
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      for(int var4 = 0; var4 < field_82807_a.length; ++var4) {
         p_77633_3_.add(new ItemStack(p_77633_1_, 1, var4));
      }

   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      if(p_77617_1_ < 0 || p_77617_1_ >= field_82807_a.length) {
         p_77617_1_ = 0;
      }

      return this.field_94586_c[p_77617_1_];
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= field_82807_a.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + field_82807_a[var2];
   }

   public String func_77628_j(ItemStack p_77628_1_) {
      return p_77628_1_.func_77960_j() == 3 && p_77628_1_.func_77942_o() && p_77628_1_.func_77978_p().func_74764_b("SkullOwner")?StatCollector.func_74837_a("item.skull.player.name", new Object[]{p_77628_1_.func_77978_p().func_74779_i("SkullOwner")}):super.func_77628_j(p_77628_1_);
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IconRegister p_94581_1_) {
      this.field_94586_c = new Icon[field_94587_a.length];

      for(int var2 = 0; var2 < field_94587_a.length; ++var2) {
         this.field_94586_c[var2] = p_94581_1_.func_94245_a(field_94587_a[var2]);
      }

   }

}
