package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemBlock extends Item {

   private int field_77885_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94588_b;


   public ItemBlock(int p_i3690_1_) {
      super(p_i3690_1_);
      this.field_77885_a = p_i3690_1_ + 256;
   }

   public int func_77883_f() {
      return this.field_77885_a;
   }

   @SideOnly(Side.CLIENT)
   public int func_94901_k() {
      return Block.field_71973_m[this.field_77885_a].func_94327_t_() != null?1:0;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      return this.field_94588_b != null?this.field_94588_b:Block.field_71973_m[this.field_77885_a].func_71851_a(1);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
      if(var11 == Block.field_72037_aS.field_71990_ca && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1) {
         p_77648_7_ = 1;
      } else if(var11 != Block.field_71998_bu.field_71990_ca && var11 != Block.field_71962_X.field_71990_ca && var11 != Block.field_71961_Y.field_71990_ca) {
         if(p_77648_7_ == 0) {
            --p_77648_5_;
         }

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
      }

      if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else if(p_77648_5_ == 255 && Block.field_71973_m[this.field_77885_a].field_72018_cp.func_76220_a()) {
         return false;
      } else if(p_77648_3_.func_72931_a(this.field_77885_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, p_77648_2_, p_77648_1_)) {
         Block var12 = Block.field_71973_m[this.field_77885_a];
         int var13 = this.func_77647_b(p_77648_1_.func_77960_j());
         int var14 = Block.field_71973_m[this.field_77885_a].func_85104_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, var13);
         if(p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_77885_a, var14, 3)) {
            if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_77885_a) {
               Block.field_71973_m[this.field_77885_a].func_71860_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
               Block.field_71973_m[this.field_77885_a].func_85105_g(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var14);
            }

            p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), var12.field_72020_cn.func_82593_b(), (var12.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, var12.field_72020_cn.func_72678_c() * 0.8F);
            --p_77648_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77884_a(World p_77884_1_, int p_77884_2_, int p_77884_3_, int p_77884_4_, int p_77884_5_, EntityPlayer p_77884_6_, ItemStack p_77884_7_) {
      int var8 = p_77884_1_.func_72798_a(p_77884_2_, p_77884_3_, p_77884_4_);
      if(var8 == Block.field_72037_aS.field_71990_ca) {
         p_77884_5_ = 1;
      } else if(var8 != Block.field_71998_bu.field_71990_ca && var8 != Block.field_71962_X.field_71990_ca && var8 != Block.field_71961_Y.field_71990_ca) {
         if(p_77884_5_ == 0) {
            --p_77884_3_;
         }

         if(p_77884_5_ == 1) {
            ++p_77884_3_;
         }

         if(p_77884_5_ == 2) {
            --p_77884_4_;
         }

         if(p_77884_5_ == 3) {
            ++p_77884_4_;
         }

         if(p_77884_5_ == 4) {
            --p_77884_2_;
         }

         if(p_77884_5_ == 5) {
            ++p_77884_2_;
         }
      }

      return p_77884_1_.func_72931_a(this.func_77883_f(), p_77884_2_, p_77884_3_, p_77884_4_, false, p_77884_5_, (Entity)null, p_77884_7_);
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return Block.field_71973_m[this.field_77885_a].func_71917_a();
   }

   public String func_77658_a() {
      return Block.field_71973_m[this.field_77885_a].func_71917_a();
   }

   @SideOnly(Side.CLIENT)
   public CreativeTabs func_77640_w() {
      return Block.field_71973_m[this.field_77885_a].func_71882_w();
   }

   @SideOnly(Side.CLIENT)
   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      Block.field_71973_m[this.field_77885_a].func_71879_a(p_77633_1_, p_77633_2_, p_77633_3_);
   }

   @SideOnly(Side.CLIENT)
   public void func_94581_a(IconRegister p_94581_1_) {
      String var2 = Block.field_71973_m[this.field_77885_a].func_94327_t_();
      if(var2 != null) {
         this.field_94588_b = p_94581_1_.func_94245_a(var2);
      }

   }
}
