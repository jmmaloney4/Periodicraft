package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class GuiContainer extends GuiScreen {

   protected static RenderItem field_74196_a = new RenderItem();
   protected int field_74194_b = 176;
   protected int field_74195_c = 166;
   public Container field_74193_d;
   protected int field_74198_m;
   protected int field_74197_n;
   private Slot field_82320_o;
   private Slot field_85051_p = null;
   private boolean field_90018_r = false;
   private ItemStack field_85050_q = null;
   private int field_85049_r = 0;
   private int field_85048_s = 0;
   private Slot field_85047_t = null;
   private long field_85046_u = 0L;
   private ItemStack field_85045_v = null;
   private Slot field_92033_y = null;
   private long field_92032_z = 0L;
   protected final Set field_94077_p = new HashSet();
   protected boolean field_94076_q;
   private int field_94071_C = 0;
   private int field_94067_D = 0;
   private boolean field_94068_E = false;
   private int field_94069_F;
   private long field_94070_G = 0L;
   private Slot field_94072_H = null;
   private int field_94073_I = 0;
   private boolean field_94074_J;
   private ItemStack field_94075_K = null;


   public GuiContainer(Container p_i3079_1_) {
      this.field_74193_d = p_i3079_1_;
      this.field_94068_E = true;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      this.field_73882_e.field_71439_g.field_71070_bA = this.field_74193_d;
      this.field_74198_m = (this.field_73880_f - this.field_74194_b) / 2;
      this.field_74197_n = (this.field_73881_g - this.field_74195_c) / 2;
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      int var4 = this.field_74198_m;
      int var5 = this.field_74197_n;
      this.func_74185_a(p_73863_3_, p_73863_1_, p_73863_2_);
      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      RenderHelper.func_74520_c();
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var4, (float)var5, 0.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable('\u803a');
      this.field_82320_o = null;
      short var6 = 240;
      short var7 = 240;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

      int var9;
      for(int var13 = 0; var13 < this.field_74193_d.field_75151_b.size(); ++var13) {
         Slot var14 = (Slot)this.field_74193_d.field_75151_b.get(var13);
         this.func_74192_a(var14);
         if(this.func_74186_a(var14, p_73863_1_, p_73863_2_)) {
            this.field_82320_o = var14;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int var8 = var14.field_75223_e;
            var9 = var14.field_75221_f;
            this.func_73733_a(var8, var9, var8 + 16, var9 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }
      }

      this.func_74189_g(p_73863_1_, p_73863_2_);
      InventoryPlayer var15 = this.field_73882_e.field_71439_g.field_71071_by;
      ItemStack var16 = this.field_85050_q == null?var15.func_70445_o():this.field_85050_q;
      if(var16 != null) {
         byte var18 = 8;
         var9 = this.field_85050_q == null?8:16;
         String var10 = null;
         if(this.field_85050_q != null && this.field_90018_r) {
            var16 = var16.func_77946_l();
            var16.field_77994_a = MathHelper.func_76123_f((float)var16.field_77994_a / 2.0F);
         } else if(this.field_94076_q && this.field_94077_p.size() > 1) {
            var16 = var16.func_77946_l();
            var16.field_77994_a = this.field_94069_F;
            if(var16.field_77994_a == 0) {
               var10 = "" + EnumChatFormatting.YELLOW + "0";
            }
         }

         this.func_85044_b(var16, p_73863_1_ - var4 - var18, p_73863_2_ - var5 - var9, var10);
      }

      if(this.field_85045_v != null) {
         float var17 = (float)(Minecraft.func_71386_F() - this.field_85046_u) / 100.0F;
         if(var17 >= 1.0F) {
            var17 = 1.0F;
            this.field_85045_v = null;
         }

         var9 = this.field_85047_t.field_75223_e - this.field_85049_r;
         int var20 = this.field_85047_t.field_75221_f - this.field_85048_s;
         int var11 = this.field_85049_r + (int)((float)var9 * var17);
         int var12 = this.field_85048_s + (int)((float)var20 * var17);
         this.func_85044_b(this.field_85045_v, var11, var12, (String)null);
      }

      GL11.glPopMatrix();
      if(var15.func_70445_o() == null && this.field_82320_o != null && this.field_82320_o.func_75216_d()) {
         ItemStack var19 = this.field_82320_o.func_75211_c();
         this.func_74184_a(var19, p_73863_1_, p_73863_2_);
      }

      GL11.glEnable(2896);
      GL11.glEnable(2929);
      RenderHelper.func_74519_b();
   }

   private void func_85044_b(ItemStack p_85044_1_, int p_85044_2_, int p_85044_3_, String p_85044_4_) {
      GL11.glTranslatef(0.0F, 0.0F, 32.0F);
      this.field_73735_i = 200.0F;
      field_74196_a.field_77023_b = 200.0F;
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, p_85044_1_, p_85044_2_, p_85044_3_);
      field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e.field_71446_o, p_85044_1_, p_85044_2_, p_85044_3_ - (this.field_85050_q == null?0:8), p_85044_4_);
      this.field_73735_i = 0.0F;
      field_74196_a.field_77023_b = 0.0F;
   }

   protected void func_74184_a(ItemStack p_74184_1_, int p_74184_2_, int p_74184_3_) {
      List var4 = p_74184_1_.func_82840_a(this.field_73882_e.field_71439_g, this.field_73882_e.field_71474_y.field_82882_x);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         if(var5 == 0) {
            var4.set(var5, "\u00a7" + Integer.toHexString(p_74184_1_.func_77953_t().field_77937_e) + (String)var4.get(var5));
         } else {
            var4.set(var5, EnumChatFormatting.GRAY + (String)var4.get(var5));
         }
      }

      this.func_102021_a(var4, p_74184_2_, p_74184_3_);
   }

   protected void func_74190_a(String p_74190_1_, int p_74190_2_, int p_74190_3_) {
      this.func_102021_a(Arrays.asList(new String[]{p_74190_1_}), p_74190_2_, p_74190_3_);
   }

   protected void func_102021_a(List p_102021_1_, int p_102021_2_, int p_102021_3_) {
      if(!p_102021_1_.isEmpty()) {
         GL11.glDisable('\u803a');
         RenderHelper.func_74518_a();
         GL11.glDisable(2896);
         GL11.glDisable(2929);
         int var4 = 0;
         Iterator var5 = p_102021_1_.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            int var7 = this.field_73886_k.func_78256_a(var6);
            if(var7 > var4) {
               var4 = var7;
            }
         }

         int var14 = p_102021_2_ + 12;
         int var15 = p_102021_3_ - 12;
         int var8 = 8;
         if(p_102021_1_.size() > 1) {
            var8 += 2 + (p_102021_1_.size() - 1) * 10;
         }

         if(var14 + var4 > this.field_73880_f) {
            var14 -= 28 + var4;
         }

         if(var15 + var8 + 6 > this.field_73881_g) {
            var15 = this.field_73881_g - var8 - 6;
         }

         this.field_73735_i = 300.0F;
         field_74196_a.field_77023_b = 300.0F;
         int var9 = -267386864;
         this.func_73733_a(var14 - 3, var15 - 4, var14 + var4 + 3, var15 - 3, var9, var9);
         this.func_73733_a(var14 - 3, var15 + var8 + 3, var14 + var4 + 3, var15 + var8 + 4, var9, var9);
         this.func_73733_a(var14 - 3, var15 - 3, var14 + var4 + 3, var15 + var8 + 3, var9, var9);
         this.func_73733_a(var14 - 4, var15 - 3, var14 - 3, var15 + var8 + 3, var9, var9);
         this.func_73733_a(var14 + var4 + 3, var15 - 3, var14 + var4 + 4, var15 + var8 + 3, var9, var9);
         int var10 = 1347420415;
         int var11 = (var10 & 16711422) >> 1 | var10 & -16777216;
         this.func_73733_a(var14 - 3, var15 - 3 + 1, var14 - 3 + 1, var15 + var8 + 3 - 1, var10, var11);
         this.func_73733_a(var14 + var4 + 2, var15 - 3 + 1, var14 + var4 + 3, var15 + var8 + 3 - 1, var10, var11);
         this.func_73733_a(var14 - 3, var15 - 3, var14 + var4 + 3, var15 - 3 + 1, var10, var10);
         this.func_73733_a(var14 - 3, var15 + var8 + 2, var14 + var4 + 3, var15 + var8 + 3, var11, var11);

         for(int var12 = 0; var12 < p_102021_1_.size(); ++var12) {
            String var13 = (String)p_102021_1_.get(var12);
            this.field_73886_k.func_78261_a(var13, var14, var15, -1);
            if(var12 == 0) {
               var15 += 2;
            }

            var15 += 10;
         }

         this.field_73735_i = 0.0F;
         field_74196_a.field_77023_b = 0.0F;
         GL11.glEnable(2896);
         GL11.glEnable(2929);
         RenderHelper.func_74519_b();
         GL11.glEnable('\u803a');
      }
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {}

   protected abstract void func_74185_a(float var1, int var2, int var3);

   protected void func_74192_a(Slot p_74192_1_) {
      int var2 = p_74192_1_.field_75223_e;
      int var3 = p_74192_1_.field_75221_f;
      ItemStack var4 = p_74192_1_.func_75211_c();
      boolean var5 = false;
      boolean var6 = p_74192_1_ == this.field_85051_p && this.field_85050_q != null && !this.field_90018_r;
      ItemStack var7 = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();
      String var8 = null;
      if(p_74192_1_ == this.field_85051_p && this.field_85050_q != null && this.field_90018_r && var4 != null) {
         var4 = var4.func_77946_l();
         var4.field_77994_a /= 2;
      } else if(this.field_94076_q && this.field_94077_p.contains(p_74192_1_) && var7 != null) {
         if(this.field_94077_p.size() == 1) {
            return;
         }

         if(Container.func_94527_a(p_74192_1_, var7, true) && this.field_74193_d.func_94531_b(p_74192_1_)) {
            var4 = var7.func_77946_l();
            var5 = true;
            Container.func_94525_a(this.field_94077_p, this.field_94071_C, var4, p_74192_1_.func_75211_c() == null?0:p_74192_1_.func_75211_c().field_77994_a);
            if(var4.field_77994_a > var4.func_77976_d()) {
               var8 = EnumChatFormatting.YELLOW + "" + var4.func_77976_d();
               var4.field_77994_a = var4.func_77976_d();
            }

            if(var4.field_77994_a > p_74192_1_.func_75219_a()) {
               var8 = EnumChatFormatting.YELLOW + "" + p_74192_1_.func_75219_a();
               var4.field_77994_a = p_74192_1_.func_75219_a();
            }
         } else {
            this.field_94077_p.remove(p_74192_1_);
            this.func_94066_g();
         }
      }

      this.field_73735_i = 100.0F;
      field_74196_a.field_77023_b = 100.0F;
      if(var4 == null) {
         Icon var9 = p_74192_1_.func_75212_b();
         if(var9 != null) {
            GL11.glDisable(2896);
            this.field_73882_e.field_71446_o.func_98187_b("/gui/items.png");
            this.func_94065_a(var2, var3, var9, 16, 16);
            GL11.glEnable(2896);
            var6 = true;
         }
      }

      if(!var6) {
         if(var5) {
            func_73734_a(var2, var3, var2 + 16, var3 + 16, -2130706433);
         }

         GL11.glEnable(2929);
         field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, var4, var2, var3);
         field_74196_a.func_94148_a(this.field_73886_k, this.field_73882_e.field_71446_o, var4, var2, var3, var8);
      }

      field_74196_a.field_77023_b = 0.0F;
      this.field_73735_i = 0.0F;
   }

   private void func_94066_g() {
      ItemStack var1 = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();
      if(var1 != null && this.field_94076_q) {
         this.field_94069_F = var1.field_77994_a;

         ItemStack var4;
         int var5;
         for(Iterator var2 = this.field_94077_p.iterator(); var2.hasNext(); this.field_94069_F -= var4.field_77994_a - var5) {
            Slot var3 = (Slot)var2.next();
            var4 = var1.func_77946_l();
            var5 = var3.func_75211_c() == null?0:var3.func_75211_c().field_77994_a;
            Container.func_94525_a(this.field_94077_p, this.field_94071_C, var4, var5);
            if(var4.field_77994_a > var4.func_77976_d()) {
               var4.field_77994_a = var4.func_77976_d();
            }

            if(var4.field_77994_a > var3.func_75219_a()) {
               var4.field_77994_a = var3.func_75219_a();
            }
         }

      }
   }

   private Slot func_74187_b(int p_74187_1_, int p_74187_2_) {
      for(int var3 = 0; var3 < this.field_74193_d.field_75151_b.size(); ++var3) {
         Slot var4 = (Slot)this.field_74193_d.field_75151_b.get(var3);
         if(this.func_74186_a(var4, p_74187_1_, p_74187_2_)) {
            return var4;
         }
      }

      return null;
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      boolean var4 = p_73864_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100;
      Slot var5 = this.func_74187_b(p_73864_1_, p_73864_2_);
      long var6 = Minecraft.func_71386_F();
      this.field_94074_J = this.field_94072_H == var5 && var6 - this.field_94070_G < 250L && this.field_94073_I == p_73864_3_;
      this.field_94068_E = false;
      if(p_73864_3_ == 0 || p_73864_3_ == 1 || var4) {
         int var8 = this.field_74198_m;
         int var9 = this.field_74197_n;
         boolean var10 = p_73864_1_ < var8 || p_73864_2_ < var9 || p_73864_1_ >= var8 + this.field_74194_b || p_73864_2_ >= var9 + this.field_74195_c;
         int var11 = -1;
         if(var5 != null) {
            var11 = var5.field_75222_d;
         }

         if(var10) {
            var11 = -999;
         }

         if(this.field_73882_e.field_71474_y.field_85185_A && var10 && this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null) {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            return;
         }

         if(var11 != -1) {
            if(this.field_73882_e.field_71474_y.field_85185_A) {
               if(var5 != null && var5.func_75216_d()) {
                  this.field_85051_p = var5;
                  this.field_85050_q = null;
                  this.field_90018_r = p_73864_3_ == 1;
               } else {
                  this.field_85051_p = null;
               }
            } else if(!this.field_94076_q) {
               if(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null) {
                  if(p_73864_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100) {
                     this.func_74191_a(var5, var11, p_73864_3_, 3);
                  } else {
                     boolean var12 = var11 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                     byte var13 = 0;
                     if(var12) {
                        this.field_94075_K = var5 != null && var5.func_75216_d()?var5.func_75211_c():null;
                        var13 = 1;
                     } else if(var11 == -999) {
                        var13 = 4;
                     }

                     this.func_74191_a(var5, var11, p_73864_3_, var13);
                  }

                  this.field_94068_E = true;
               } else {
                  this.field_94076_q = true;
                  this.field_94067_D = p_73864_3_;
                  this.field_94077_p.clear();
                  if(p_73864_3_ == 0) {
                     this.field_94071_C = 0;
                  } else if(p_73864_3_ == 1) {
                     this.field_94071_C = 1;
                  }
               }
            }
         }
      }

      this.field_94072_H = var5;
      this.field_94070_G = var6;
      this.field_94073_I = p_73864_3_;
   }

   protected void func_85041_a(int p_85041_1_, int p_85041_2_, int p_85041_3_, long p_85041_4_) {
      Slot var6 = this.func_74187_b(p_85041_1_, p_85041_2_);
      ItemStack var7 = this.field_73882_e.field_71439_g.field_71071_by.func_70445_o();
      if(this.field_85051_p != null && this.field_73882_e.field_71474_y.field_85185_A) {
         if(p_85041_3_ == 0 || p_85041_3_ == 1) {
            if(this.field_85050_q == null) {
               if(var6 != this.field_85051_p) {
                  this.field_85050_q = this.field_85051_p.func_75211_c().func_77946_l();
               }
            } else if(this.field_85050_q.field_77994_a > 1 && var6 != null && Container.func_94527_a(var6, this.field_85050_q, false)) {
               long var8 = Minecraft.func_71386_F();
               if(this.field_92033_y == var6) {
                  if(var8 - this.field_92032_z > 500L) {
                     this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                     this.func_74191_a(var6, var6.field_75222_d, 1, 0);
                     this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, 0, 0);
                     this.field_92032_z = var8 + 750L;
                     --this.field_85050_q.field_77994_a;
                  }
               } else {
                  this.field_92033_y = var6;
                  this.field_92032_z = var8;
               }
            }
         }
      } else if(this.field_94076_q && var6 != null && var7 != null && var7.field_77994_a > this.field_94077_p.size() && Container.func_94527_a(var6, var7, true) && var6.func_75214_a(var7) && this.field_74193_d.func_94531_b(var6)) {
         this.field_94077_p.add(var6);
         this.func_94066_g();
      }

   }

   protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_) {
      Slot var4 = this.func_74187_b(p_73879_1_, p_73879_2_);
      int var5 = this.field_74198_m;
      int var6 = this.field_74197_n;
      boolean var7 = p_73879_1_ < var5 || p_73879_2_ < var6 || p_73879_1_ >= var5 + this.field_74194_b || p_73879_2_ >= var6 + this.field_74195_c;
      int var8 = -1;
      if(var4 != null) {
         var8 = var4.field_75222_d;
      }

      if(var7) {
         var8 = -999;
      }

      Slot var10;
      Iterator var11;
      if(this.field_94074_J && var4 != null && p_73879_3_ == 0 && this.field_74193_d.func_94530_a((ItemStack)null, var4)) {
         if(func_73877_p()) {
            if(var4 != null && var4.field_75224_c != null && this.field_94075_K != null) {
               var11 = this.field_74193_d.field_75151_b.iterator();

               while(var11.hasNext()) {
                  var10 = (Slot)var11.next();
                  if(var10 != null && var10.func_82869_a(this.field_73882_e.field_71439_g) && var10.func_75216_d() && var10.field_75224_c == var4.field_75224_c && Container.func_94527_a(var10, this.field_94075_K, true)) {
                     this.func_74191_a(var10, var10.field_75222_d, p_73879_3_, 1);
                  }
               }
            }
         } else {
            this.func_74191_a(var4, var8, p_73879_3_, 6);
         }

         this.field_94074_J = false;
         this.field_94070_G = 0L;
      } else {
         if(this.field_94076_q && this.field_94067_D != p_73879_3_) {
            this.field_94076_q = false;
            this.field_94077_p.clear();
            this.field_94068_E = true;
            return;
         }

         if(this.field_94068_E) {
            this.field_94068_E = false;
            return;
         }

         boolean var9;
         if(this.field_85051_p != null && this.field_73882_e.field_71474_y.field_85185_A) {
            if(p_73879_3_ == 0 || p_73879_3_ == 1) {
               if(this.field_85050_q == null && var4 != this.field_85051_p) {
                  this.field_85050_q = this.field_85051_p.func_75211_c();
               }

               var9 = Container.func_94527_a(var4, this.field_85050_q, false);
               if(var8 != -1 && this.field_85050_q != null && var9) {
                  this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, p_73879_3_, 0);
                  this.func_74191_a(var4, var8, 0, 0);
                  if(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null) {
                     this.func_74191_a(this.field_85051_p, this.field_85051_p.field_75222_d, p_73879_3_, 0);
                     this.field_85049_r = p_73879_1_ - var5;
                     this.field_85048_s = p_73879_2_ - var6;
                     this.field_85047_t = this.field_85051_p;
                     this.field_85045_v = this.field_85050_q;
                     this.field_85046_u = Minecraft.func_71386_F();
                  } else {
                     this.field_85045_v = null;
                  }
               } else if(this.field_85050_q != null) {
                  this.field_85049_r = p_73879_1_ - var5;
                  this.field_85048_s = p_73879_2_ - var6;
                  this.field_85047_t = this.field_85051_p;
                  this.field_85045_v = this.field_85050_q;
                  this.field_85046_u = Minecraft.func_71386_F();
               }

               this.field_85050_q = null;
               this.field_85051_p = null;
            }
         } else if(this.field_94076_q && !this.field_94077_p.isEmpty()) {
            this.func_74191_a((Slot)null, -999, Container.func_94534_d(0, this.field_94071_C), 5);
            var11 = this.field_94077_p.iterator();

            while(var11.hasNext()) {
               var10 = (Slot)var11.next();
               this.func_74191_a(var10, var10.field_75222_d, Container.func_94534_d(1, this.field_94071_C), 5);
            }

            this.func_74191_a((Slot)null, -999, Container.func_94534_d(2, this.field_94071_C), 5);
         } else if(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() != null) {
            if(p_73879_3_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d + 100) {
               this.func_74191_a(var4, var8, p_73879_3_, 3);
            } else {
               var9 = var8 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
               if(var9) {
                  this.field_94075_K = var4 != null && var4.func_75216_d()?var4.func_75211_c():null;
               }

               this.func_74191_a(var4, var8, p_73879_3_, var9?1:0);
            }
         }
      }

      if(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null) {
         this.field_94070_G = 0L;
      }

      this.field_94076_q = false;
   }

   private boolean func_74186_a(Slot p_74186_1_, int p_74186_2_, int p_74186_3_) {
      return this.func_74188_c(p_74186_1_.field_75223_e, p_74186_1_.field_75221_f, 16, 16, p_74186_2_, p_74186_3_);
   }

   protected boolean func_74188_c(int p_74188_1_, int p_74188_2_, int p_74188_3_, int p_74188_4_, int p_74188_5_, int p_74188_6_) {
      int var7 = this.field_74198_m;
      int var8 = this.field_74197_n;
      p_74188_5_ -= var7;
      p_74188_6_ -= var8;
      return p_74188_5_ >= p_74188_1_ - 1 && p_74188_5_ < p_74188_1_ + p_74188_3_ + 1 && p_74188_6_ >= p_74188_2_ - 1 && p_74188_6_ < p_74188_2_ + p_74188_4_ + 1;
   }

   protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, int p_74191_4_) {
      if(p_74191_1_ != null) {
         p_74191_2_ = p_74191_1_.field_75222_d;
      }

      this.field_73882_e.field_71442_b.func_78753_a(this.field_74193_d.field_75152_c, p_74191_2_, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 1 || p_73869_2_ == this.field_73882_e.field_71474_y.field_74315_B.field_74512_d) {
         this.field_73882_e.field_71439_g.func_71053_j();
      }

      this.func_82319_a(p_73869_2_);
      if(this.field_82320_o != null && this.field_82320_o.func_75216_d()) {
         if(p_73869_2_ == this.field_73882_e.field_71474_y.field_74322_I.field_74512_d) {
            this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, 0, 3);
         } else if(p_73869_2_ == this.field_73882_e.field_71474_y.field_74316_C.field_74512_d) {
            this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, func_73861_o()?1:0, 4);
         }
      }

   }

   protected boolean func_82319_a(int p_82319_1_) {
      if(this.field_73882_e.field_71439_g.field_71071_by.func_70445_o() == null && this.field_82320_o != null) {
         for(int var2 = 0; var2 < 9; ++var2) {
            if(p_82319_1_ == 2 + var2) {
               this.func_74191_a(this.field_82320_o, this.field_82320_o.field_75222_d, var2, 2);
               return true;
            }
         }
      }

      return false;
   }

   public void func_73874_b() {
      if(this.field_73882_e.field_71439_g != null) {
         this.field_74193_d.func_75134_a(this.field_73882_e.field_71439_g);
      }
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
      super.func_73876_c();
      if(!this.field_73882_e.field_71439_g.func_70089_S() || this.field_73882_e.field_71439_g.field_70128_L) {
         this.field_73882_e.field_71439_g.func_71053_j();
      }

   }

}
