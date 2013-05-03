package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.ContainerCreative;
import net.minecraft.client.gui.inventory.CreativeCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.SlotCreativeInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiContainerCreative extends InventoryEffectRenderer {

   private static InventoryBasic field_74242_o = new InventoryBasic("tmp", true, 45);
   private static int field_74241_p = CreativeTabs.field_78030_b.func_78021_a();
   private float field_74240_q = 0.0F;
   private boolean field_74239_r = false;
   private boolean field_74238_s;
   private GuiTextField field_74237_t;
   private List field_74236_u;
   private Slot field_74235_v = null;
   private boolean field_74234_w = false;
   private CreativeCrafting field_82324_x;


   public GuiContainerCreative(EntityPlayer p_i3083_1_) {
      super(new ContainerCreative(p_i3083_1_));
      p_i3083_1_.field_71070_bA = this.field_74193_d;
      this.field_73885_j = true;
      p_i3083_1_.func_71064_a(AchievementList.field_76004_f, 1);
      this.field_74195_c = 136;
      this.field_74194_b = 195;
   }

   public void func_73876_c() {
      if(!this.field_73882_e.field_71442_b.func_78758_h()) {
         this.field_73882_e.func_71373_a(new GuiInventory(this.field_73882_e.field_71439_g));
      }

   }

   protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, int p_74191_4_) {
      this.field_74234_w = true;
      boolean var5 = p_74191_4_ == 1;
      p_74191_4_ = p_74191_2_ == -999 && p_74191_4_ == 0?4:p_74191_4_;
      ItemStack var7;
      InventoryPlayer var11;
      if(p_74191_1_ == null && field_74241_p != CreativeTabs.field_78036_m.func_78021_a() && p_74191_4_ != 5) {
         var11 = this.field_73882_e.field_71439_g.field_71071_by;
         if(var11.func_70445_o() != null) {
            if(p_74191_3_ == 0) {
               this.field_73882_e.field_71439_g.func_71021_b(var11.func_70445_o());
               this.field_73882_e.field_71442_b.func_78752_a(var11.func_70445_o());
               var11.func_70437_b((ItemStack)null);
            }

            if(p_74191_3_ == 1) {
               var7 = var11.func_70445_o().func_77979_a(1);
               this.field_73882_e.field_71439_g.func_71021_b(var7);
               this.field_73882_e.field_71442_b.func_78752_a(var7);
               if(var11.func_70445_o().field_77994_a == 0) {
                  var11.func_70437_b((ItemStack)null);
               }
            }
         }
      } else {
         int var10;
         if(p_74191_1_ == this.field_74235_v && var5) {
            for(var10 = 0; var10 < this.field_73882_e.field_71439_g.field_71069_bz.func_75138_a().size(); ++var10) {
               this.field_73882_e.field_71442_b.func_78761_a((ItemStack)null, var10);
            }
         } else {
            ItemStack var6;
            if(field_74241_p == CreativeTabs.field_78036_m.func_78021_a()) {
               if(p_74191_1_ == this.field_74235_v) {
                  this.field_73882_e.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
               } else if(p_74191_4_ == 4 && p_74191_1_ != null && p_74191_1_.func_75216_d()) {
                  var6 = p_74191_1_.func_75209_a(p_74191_3_ == 0?1:p_74191_1_.func_75211_c().func_77976_d());
                  this.field_73882_e.field_71439_g.func_71021_b(var6);
                  this.field_73882_e.field_71442_b.func_78752_a(var6);
               } else if(p_74191_4_ == 4 && this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null) {
                  this.field_73882_e.field_71439_g.func_71021_b(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o());
                  this.field_73882_e.field_71442_b.func_78752_a(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o());
                  this.field_73882_e.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
               } else {
                  this.field_73882_e.field_71439_g.field_71069_bz.func_75144_a(p_74191_1_ == null?p_74191_2_:SlotCreativeInventory.func_75240_a((SlotCreativeInventory)p_74191_1_).field_75222_d, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
                  this.field_73882_e.field_71439_g.field_71069_bz.func_75142_b();
               }
            } else if(p_74191_4_ != 5 && p_74191_1_.field_75224_c == field_74242_o) {
               var11 = this.field_73882_e.field_71439_g.field_71071_by;
               var7 = var11.func_70445_o();
               ItemStack var8 = p_74191_1_.func_75211_c();
               ItemStack var9;
               if(p_74191_4_ == 2) {
                  if(var8 != null && p_74191_3_ >= 0 && p_74191_3_ < 9) {
                     var9 = var8.func_77946_l();
                     var9.field_77994_a = var9.func_77976_d();
                     this.field_73882_e.field_71439_g.field_71071_by.func_70299_a(p_74191_3_, var9);
                     this.field_73882_e.field_71439_g.field_71069_bz.func_75142_b();
                  }

                  return;
               }

               if(p_74191_4_ == 3) {
                  if(var11.func_70445_o() == null && p_74191_1_.func_75216_d()) {
                     var9 = p_74191_1_.func_75211_c().func_77946_l();
                     var9.field_77994_a = var9.func_77976_d();
                     var11.func_70437_b(var9);
                  }

                  return;
               }

               if(p_74191_4_ == 4) {
                  if(var8 != null) {
                     var9 = var8.func_77946_l();
                     var9.field_77994_a = p_74191_3_ == 0?1:var9.func_77976_d();
                     this.field_73882_e.field_71439_g.func_71021_b(var9);
                     this.field_73882_e.field_71442_b.func_78752_a(var9);
                  }

                  return;
               }

               if(var7 != null && var8 != null && var7.func_77969_a(var8)) {
                  if(p_74191_3_ == 0) {
                     if(var5) {
                        var7.field_77994_a = var7.func_77976_d();
                     } else if(var7.field_77994_a < var7.func_77976_d()) {
                        ++var7.field_77994_a;
                     }
                  } else if(var7.field_77994_a <= 1) {
                     var11.func_70437_b((ItemStack)null);
                  } else {
                     --var7.field_77994_a;
                  }
               } else if(var8 != null && var7 == null) {
                  var11.func_70437_b(ItemStack.func_77944_b(var8));
                  var7 = var11.func_70445_o();
                  if(var5) {
                     var7.field_77994_a = var7.func_77976_d();
                  }
               } else {
                  var11.func_70437_b((ItemStack)null);
               }
            } else {
               this.field_74193_d.func_75144_a(p_74191_1_ == null?p_74191_2_:p_74191_1_.field_75222_d, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
               if(Container.func_94532_c(p_74191_3_) == 2) {
                  for(var10 = 0; var10 < 9; ++var10) {
                     this.field_73882_e.field_71442_b.func_78761_a(this.field_74193_d.func_75139_a(45 + var10).func_75211_c(), 36 + var10);
                  }
               } else if(p_74191_1_ != null) {
                  var6 = this.field_74193_d.func_75139_a(p_74191_1_.field_75222_d).func_75211_c();
                  this.field_73882_e.field_71442_b.func_78761_a(var6, p_74191_1_.field_75222_d - this.field_74193_d.field_75151_b.size() + 9 + 36);
               }
            }
         }
      }

   }

   public void func_73866_w_() {
      if(this.field_73882_e.field_71442_b.func_78758_h()) {
         super.func_73866_w_();
         this.field_73887_h.clear();
         Keyboard.enableRepeatEvents(true);
         this.field_74237_t = new GuiTextField(this.field_73886_k, this.field_74198_m + 82, this.field_74197_n + 6, 89, this.field_73886_k.field_78288_b);
         this.field_74237_t.func_73804_f(15);
         this.field_74237_t.func_73786_a(false);
         this.field_74237_t.func_73790_e(false);
         this.field_74237_t.func_73794_g(16777215);
         int var1 = field_74241_p;
         field_74241_p = -1;
         this.func_74227_b(CreativeTabs.field_78032_a[var1]);
         this.field_82324_x = new CreativeCrafting(this.field_73882_e);
         this.field_73882_e.field_71439_g.field_71069_bz.func_75132_a(this.field_82324_x);
      } else {
         this.field_73882_e.func_71373_a(new GuiInventory(this.field_73882_e.field_71439_g));
      }

   }

   public void func_73874_b() {
      super.func_73874_b();
      if(this.field_73882_e.field_71439_g != null && this.field_73882_e.field_71439_g.field_71071_by != null) {
         this.field_73882_e.field_71439_g.field_71069_bz.func_82847_b(this.field_82324_x);
      }

      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(field_74241_p != CreativeTabs.field_78027_g.func_78021_a()) {
         if(GameSettings.func_100015_a(this.field_73882_e.field_71474_y.field_74310_D)) {
            this.func_74227_b(CreativeTabs.field_78027_g);
         } else {
            super.func_73869_a(p_73869_1_, p_73869_2_);
         }

      } else {
         if(this.field_74234_w) {
            this.field_74234_w = false;
            this.field_74237_t.func_73782_a("");
         }

         if(!this.func_82319_a(p_73869_2_)) {
            if(this.field_74237_t.func_73802_a(p_73869_1_, p_73869_2_)) {
               this.func_74228_j();
            } else {
               super.func_73869_a(p_73869_1_, p_73869_2_);
            }

         }
      }
   }

   private void func_74228_j() {
      ContainerCreative var1 = (ContainerCreative)this.field_74193_d;
      var1.field_75185_e.clear();
      Item[] var2 = Item.field_77698_e;
      int var3 = var2.length;

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         Item var5 = var2[var4];
         if(var5 != null && var5.func_77640_w() != null) {
            var5.func_77633_a(var5.field_77779_bT, (CreativeTabs)null, var1.field_75185_e);
         }
      }

      Enchantment[] var8 = Enchantment.field_77331_b;
      var3 = var8.length;

      for(var4 = 0; var4 < var3; ++var4) {
         Enchantment var12 = var8[var4];
         if(var12 != null && var12.field_77351_y != null) {
            Item.field_92105_bW.func_92113_a(var12, var1.field_75185_e);
         }
      }

      Iterator var9 = var1.field_75185_e.iterator();
      String var10 = this.field_74237_t.func_73781_b().toLowerCase();

      while(var9.hasNext()) {
         ItemStack var11 = (ItemStack)var9.next();
         boolean var13 = false;
         Iterator var6 = var11.func_82840_a(this.field_73882_e.field_71439_g, this.field_73882_e.field_71474_y.field_82882_x).iterator();

         while(true) {
            if(var6.hasNext()) {
               String var7 = (String)var6.next();
               if(!var7.toLowerCase().contains(var10)) {
                  continue;
               }

               var13 = true;
            }

            if(!var13) {
               var9.remove();
            }
            break;
         }
      }

      this.field_74240_q = 0.0F;
      var1.func_75183_a(0.0F);
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      CreativeTabs var3 = CreativeTabs.field_78032_a[field_74241_p];
      if(var3.func_78019_g()) {
         this.field_73886_k.func_78276_b(var3.func_78024_c(), 8, 6, 4210752);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      if(p_73864_3_ == 0) {
         int var4 = p_73864_1_ - this.field_74198_m;
         int var5 = p_73864_2_ - this.field_74197_n;
         CreativeTabs[] var6 = CreativeTabs.field_78032_a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            CreativeTabs var9 = var6[var8];
            if(this.func_74232_a(var9, var4, var5)) {
               return;
            }
         }
      }

      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_) {
      if(p_73879_3_ == 0) {
         int var4 = p_73879_1_ - this.field_74198_m;
         int var5 = p_73879_2_ - this.field_74197_n;
         CreativeTabs[] var6 = CreativeTabs.field_78032_a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            CreativeTabs var9 = var6[var8];
            if(this.func_74232_a(var9, var4, var5)) {
               this.func_74227_b(var9);
               return;
            }
         }
      }

      super.func_73879_b(p_73879_1_, p_73879_2_, p_73879_3_);
   }

   private boolean func_74226_k() {
      return field_74241_p != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[field_74241_p].func_78017_i() && ((ContainerCreative)this.field_74193_d).func_75184_d();
   }

   private void func_74227_b(CreativeTabs p_74227_1_) {
      int var2 = field_74241_p;
      field_74241_p = p_74227_1_.func_78021_a();
      ContainerCreative var3 = (ContainerCreative)this.field_74193_d;
      this.field_94077_p.clear();
      var3.field_75185_e.clear();
      p_74227_1_.func_78018_a(var3.field_75185_e);
      if(p_74227_1_ == CreativeTabs.field_78036_m) {
         Container var4 = this.field_73882_e.field_71439_g.field_71069_bz;
         if(this.field_74236_u == null) {
            this.field_74236_u = var3.field_75151_b;
         }

         var3.field_75151_b = new ArrayList();

         for(int var5 = 0; var5 < var4.field_75151_b.size(); ++var5) {
            SlotCreativeInventory var6 = new SlotCreativeInventory(this, (Slot)var4.field_75151_b.get(var5), var5);
            var3.field_75151_b.add(var6);
            int var7;
            int var8;
            int var9;
            if(var5 >= 5 && var5 < 9) {
               var7 = var5 - 5;
               var8 = var7 / 2;
               var9 = var7 % 2;
               var6.field_75223_e = 9 + var8 * 54;
               var6.field_75221_f = 6 + var9 * 27;
            } else if(var5 >= 0 && var5 < 5) {
               var6.field_75221_f = -2000;
               var6.field_75223_e = -2000;
            } else if(var5 < var4.field_75151_b.size()) {
               var7 = var5 - 9;
               var8 = var7 % 9;
               var9 = var7 / 9;
               var6.field_75223_e = 9 + var8 * 18;
               if(var5 >= 36) {
                  var6.field_75221_f = 112;
               } else {
                  var6.field_75221_f = 54 + var9 * 18;
               }
            }
         }

         this.field_74235_v = new Slot(field_74242_o, 0, 173, 112);
         var3.field_75151_b.add(this.field_74235_v);
      } else if(var2 == CreativeTabs.field_78036_m.func_78021_a()) {
         var3.field_75151_b = this.field_74236_u;
         this.field_74236_u = null;
      }

      if(this.field_74237_t != null) {
         if(p_74227_1_ == CreativeTabs.field_78027_g) {
            this.field_74237_t.func_73790_e(true);
            this.field_74237_t.func_73805_d(false);
            this.field_74237_t.func_73796_b(true);
            this.field_74237_t.func_73782_a("");
            this.func_74228_j();
         } else {
            this.field_74237_t.func_73790_e(false);
            this.field_74237_t.func_73805_d(true);
            this.field_74237_t.func_73796_b(false);
         }
      }

      this.field_74240_q = 0.0F;
      var3.func_75183_a(0.0F);
   }

   public void func_73867_d() {
      super.func_73867_d();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0 && this.func_74226_k()) {
         int var2 = ((ContainerCreative)this.field_74193_d).field_75185_e.size() / 9 - 5 + 1;
         if(var1 > 0) {
            var1 = 1;
         }

         if(var1 < 0) {
            var1 = -1;
         }

         this.field_74240_q = (float)((double)this.field_74240_q - (double)var1 / (double)var2);
         if(this.field_74240_q < 0.0F) {
            this.field_74240_q = 0.0F;
         }

         if(this.field_74240_q > 1.0F) {
            this.field_74240_q = 1.0F;
         }

         ((ContainerCreative)this.field_74193_d).func_75183_a(this.field_74240_q);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      boolean var4 = Mouse.isButtonDown(0);
      int var5 = this.field_74198_m;
      int var6 = this.field_74197_n;
      int var7 = var5 + 175;
      int var8 = var6 + 18;
      int var9 = var7 + 14;
      int var10 = var8 + 112;
      if(!this.field_74238_s && var4 && p_73863_1_ >= var7 && p_73863_2_ >= var8 && p_73863_1_ < var9 && p_73863_2_ < var10) {
         this.field_74239_r = this.func_74226_k();
      }

      if(!var4) {
         this.field_74239_r = false;
      }

      this.field_74238_s = var4;
      if(this.field_74239_r) {
         this.field_74240_q = ((float)(p_73863_2_ - var8) - 7.5F) / ((float)(var10 - var8) - 15.0F);
         if(this.field_74240_q < 0.0F) {
            this.field_74240_q = 0.0F;
         }

         if(this.field_74240_q > 1.0F) {
            this.field_74240_q = 1.0F;
         }

         ((ContainerCreative)this.field_74193_d).func_75183_a(this.field_74240_q);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      CreativeTabs[] var11 = CreativeTabs.field_78032_a;
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         CreativeTabs var14 = var11[var13];
         if(this.func_74231_b(var14, p_73863_1_, p_73863_2_)) {
            break;
         }
      }

      if(this.field_74235_v != null && field_74241_p == CreativeTabs.field_78036_m.func_78021_a() && this.func_74188_c(this.field_74235_v.field_75223_e, this.field_74235_v.field_75221_f, 16, 16, p_73863_1_, p_73863_2_)) {
         this.func_74190_a(StringTranslate.func_74808_a().func_74805_b("inventory.binSlot"), p_73863_1_, p_73863_2_);
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      RenderHelper.func_74520_c();
      CreativeTabs var4 = CreativeTabs.field_78032_a[field_74241_p];
      CreativeTabs[] var5 = CreativeTabs.field_78032_a;
      int var6 = var5.length;

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         CreativeTabs var8 = var5[var7];
         this.field_73882_e.field_71446_o.func_98187_b("/gui/allitems.png");
         if(var8.func_78021_a() != field_74241_p) {
            this.func_74233_a(var8);
         }
      }

      this.field_73882_e.field_71446_o.func_98187_b("/gui/creative_inv/" + var4.func_78015_f());
      this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
      this.field_74237_t.func_73795_f();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int var9 = this.field_74198_m + 175;
      var6 = this.field_74197_n + 18;
      var7 = var6 + 112;
      this.field_73882_e.field_71446_o.func_98187_b("/gui/allitems.png");
      if(var4.func_78017_i()) {
         this.func_73729_b(var9, var6 + (int)((float)(var7 - var6 - 17) * this.field_74240_q), 232 + (this.func_74226_k()?0:12), 0, 12, 15);
      }

      this.func_74233_a(var4);
      if(var4 == CreativeTabs.field_78036_m) {
         GuiInventory.func_74223_a(this.field_73882_e, this.field_74198_m + 43, this.field_74197_n + 45, 20, (float)(this.field_74198_m + 43 - p_74185_2_), (float)(this.field_74197_n + 45 - 30 - p_74185_3_));
      }

   }

   protected boolean func_74232_a(CreativeTabs p_74232_1_, int p_74232_2_, int p_74232_3_) {
      int var4 = p_74232_1_.func_78020_k();
      int var5 = 28 * var4;
      byte var6 = 0;
      if(var4 == 5) {
         var5 = this.field_74194_b - 28 + 2;
      } else if(var4 > 0) {
         var5 += var4;
      }

      int var7;
      if(p_74232_1_.func_78023_l()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.field_74195_c;
      }

      return p_74232_2_ >= var5 && p_74232_2_ <= var5 + 28 && p_74232_3_ >= var7 && p_74232_3_ <= var7 + 32;
   }

   protected boolean func_74231_b(CreativeTabs p_74231_1_, int p_74231_2_, int p_74231_3_) {
      int var4 = p_74231_1_.func_78020_k();
      int var5 = 28 * var4;
      byte var6 = 0;
      if(var4 == 5) {
         var5 = this.field_74194_b - 28 + 2;
      } else if(var4 > 0) {
         var5 += var4;
      }

      int var7;
      if(p_74231_1_.func_78023_l()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.field_74195_c;
      }

      if(this.func_74188_c(var5 + 3, var7 + 3, 23, 27, p_74231_2_, p_74231_3_)) {
         this.func_74190_a(p_74231_1_.func_78024_c(), p_74231_2_, p_74231_3_);
         return true;
      } else {
         return false;
      }
   }

   protected void func_74233_a(CreativeTabs p_74233_1_) {
      boolean var2 = p_74233_1_.func_78021_a() == field_74241_p;
      boolean var3 = p_74233_1_.func_78023_l();
      int var4 = p_74233_1_.func_78020_k();
      int var5 = var4 * 28;
      int var6 = 0;
      int var7 = this.field_74198_m + 28 * var4;
      int var8 = this.field_74197_n;
      byte var9 = 32;
      if(var2) {
         var6 += 32;
      }

      if(var4 == 5) {
         var7 = this.field_74198_m + this.field_74194_b - 28;
      } else if(var4 > 0) {
         var7 += var4;
      }

      if(var3) {
         var8 -= 28;
      } else {
         var6 += 64;
         var8 += this.field_74195_c - 4;
      }

      GL11.glDisable(2896);
      this.func_73729_b(var7, var8, var5, var6, 28, var9);
      this.field_73735_i = 100.0F;
      field_74196_a.field_77023_b = 100.0F;
      var7 += 6;
      var8 += 8 + (var3?1:-1);
      GL11.glEnable(2896);
      GL11.glEnable('\u803a');
      ItemStack var10 = new ItemStack(p_74233_1_.func_78016_d());
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, var10, var7, var8);
      field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var10, var7, var8);
      GL11.glDisable(2896);
      field_74196_a.field_77023_b = 0.0F;
      this.field_73735_i = 0.0F;
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0) {
         this.field_73882_e.func_71373_a(new GuiAchievements(this.field_73882_e.field_71413_E));
      }

      if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71373_a(new GuiStats(this, this.field_73882_e.field_71413_E));
      }

   }

   public int func_74230_h() {
      return field_74241_p;
   }

   // $FF: synthetic method
   static InventoryBasic func_74229_i() {
      return field_74242_o;
   }

}
