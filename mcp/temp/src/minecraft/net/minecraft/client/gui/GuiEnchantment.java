package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

@SideOnly(Side.CLIENT)
public class GuiEnchantment extends GuiContainer {

   private static ModelBook field_74206_w = new ModelBook();
   private Random field_74216_x = new Random();
   private ContainerEnchantment field_74215_y;
   public int field_74214_o;
   public float field_74213_p;
   public float field_74212_q;
   public float field_74211_r;
   public float field_74210_s;
   public float field_74209_t;
   public float field_74208_u;
   ItemStack field_74207_v;
   private String field_94079_C;


   public GuiEnchantment(InventoryPlayer p_i9000_1_, World p_i9000_2_, int p_i9000_3_, int p_i9000_4_, int p_i9000_5_, String p_i9000_6_) {
      super(new ContainerEnchantment(p_i9000_1_, p_i9000_2_, p_i9000_3_, p_i9000_4_, p_i9000_5_));
      this.field_74215_y = (ContainerEnchantment)this.field_74193_d;
      this.field_94079_C = p_i9000_6_;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      this.field_73886_k.func_78276_b(this.field_94079_C == null?StatCollector.func_74838_a("container.enchant"):this.field_94079_C, 12, 5, 4210752);
      this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   public void func_73876_c() {
      super.func_73876_c();
      this.func_74205_h();
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;

      for(int var6 = 0; var6 < 3; ++var6) {
         int var7 = p_73864_1_ - (var4 + 60);
         int var8 = p_73864_2_ - (var5 + 14 + 19 * var6);
         if(var7 >= 0 && var8 >= 0 && var7 < 108 && var8 < 19 && this.field_74215_y.func_75140_a(this.field_73882_e.field_71439_g, var6)) {
            this.field_73882_e.field_71442_b.func_78756_a(this.field_74215_y.field_75152_c, var6);
         }
      }

   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/enchant.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
      GL11.glPushMatrix();
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      ScaledResolution var6 = new ScaledResolution(this.field_73882_e.field_71474_y, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
      GL11.glViewport((var6.func_78326_a() - 320) / 2 * var6.func_78325_e(), (var6.func_78328_b() - 240) / 2 * var6.func_78325_e(), 320 * var6.func_78325_e(), 240 * var6.func_78325_e());
      GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
      GLU.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
      float var7 = 1.0F;
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      RenderHelper.func_74519_b();
      GL11.glTranslatef(0.0F, 3.3F, -16.0F);
      GL11.glScalef(var7, var7, var7);
      float var8 = 5.0F;
      GL11.glScalef(var8, var8, var8);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/item/book.png");
      GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
      float var9 = this.field_74208_u + (this.field_74209_t - this.field_74208_u) * p_74185_1_;
      GL11.glTranslatef((1.0F - var9) * 0.2F, (1.0F - var9) * 0.1F, (1.0F - var9) * 0.25F);
      GL11.glRotatef(-(1.0F - var9) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      float var10 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * p_74185_1_ + 0.25F;
      float var11 = this.field_74212_q + (this.field_74213_p - this.field_74212_q) * p_74185_1_ + 0.75F;
      var10 = (var10 - (float)MathHelper.func_76140_b((double)var10)) * 1.6F - 0.3F;
      var11 = (var11 - (float)MathHelper.func_76140_b((double)var11)) * 1.6F - 0.3F;
      if(var10 < 0.0F) {
         var10 = 0.0F;
      }

      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var10 > 1.0F) {
         var10 = 1.0F;
      }

      if(var11 > 1.0F) {
         var11 = 1.0F;
      }

      GL11.glEnable('\u803a');
      field_74206_w.func_78088_a((Entity)null, 0.0F, var10, var11, var9, 0.0F, 0.0625F);
      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
      GL11.glMatrixMode(5889);
      GL11.glViewport(0, 0, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      RenderHelper.func_74518_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/enchant.png");
      EnchantmentNameParts.field_78061_a.func_78058_a(this.field_74215_y.field_75166_f);

      for(int var12 = 0; var12 < 3; ++var12) {
         String var13 = EnchantmentNameParts.field_78061_a.func_78057_a();
         this.field_73735_i = 0.0F;
         this.field_73882_e.field_71446_o.func_98187_b("/gui/enchant.png");
         int var14 = this.field_74215_y.field_75167_g[var12];
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         if(var14 == 0) {
            this.func_73729_b(var4 + 60, var5 + 14 + 19 * var12, 0, 185, 108, 19);
         } else {
            String var15 = "" + var14;
            FontRenderer var16 = this.field_73882_e.field_71464_q;
            int var17 = 6839882;
            if(this.field_73882_e.field_71439_g.field_71068_ca < var14 && !this.field_73882_e.field_71439_g.field_71075_bZ.field_75098_d) {
               this.func_73729_b(var4 + 60, var5 + 14 + 19 * var12, 0, 185, 108, 19);
               var16.func_78279_b(var13, var4 + 62, var5 + 16 + 19 * var12, 104, (var17 & 16711422) >> 1);
               var16 = this.field_73882_e.field_71466_p;
               var17 = 4226832;
               var16.func_78261_a(var15, var4 + 62 + 104 - var16.func_78256_a(var15), var5 + 16 + 19 * var12 + 7, var17);
            } else {
               int var18 = p_74185_2_ - (var4 + 60);
               int var19 = p_74185_3_ - (var5 + 14 + 19 * var12);
               if(var18 >= 0 && var19 >= 0 && var18 < 108 && var19 < 19) {
                  this.func_73729_b(var4 + 60, var5 + 14 + 19 * var12, 0, 204, 108, 19);
                  var17 = 16777088;
               } else {
                  this.func_73729_b(var4 + 60, var5 + 14 + 19 * var12, 0, 166, 108, 19);
               }

               var16.func_78279_b(var13, var4 + 62, var5 + 16 + 19 * var12, 104, var17);
               var16 = this.field_73882_e.field_71466_p;
               var17 = 8453920;
               var16.func_78261_a(var15, var4 + 62 + 104 - var16.func_78256_a(var15), var5 + 16 + 19 * var12 + 7, var17);
            }
         }
      }

   }

   public void func_74205_h() {
      ItemStack var1 = this.field_74193_d.func_75139_a(0).func_75211_c();
      if(!ItemStack.func_77989_b(var1, this.field_74207_v)) {
         this.field_74207_v = var1;

         do {
            this.field_74211_r += (float)(this.field_74216_x.nextInt(4) - this.field_74216_x.nextInt(4));
         } while(this.field_74213_p <= this.field_74211_r + 1.0F && this.field_74213_p >= this.field_74211_r - 1.0F);
      }

      ++this.field_74214_o;
      this.field_74212_q = this.field_74213_p;
      this.field_74208_u = this.field_74209_t;
      boolean var2 = false;

      for(int var3 = 0; var3 < 3; ++var3) {
         if(this.field_74215_y.field_75167_g[var3] != 0) {
            var2 = true;
         }
      }

      if(var2) {
         this.field_74209_t += 0.2F;
      } else {
         this.field_74209_t -= 0.2F;
      }

      if(this.field_74209_t < 0.0F) {
         this.field_74209_t = 0.0F;
      }

      if(this.field_74209_t > 1.0F) {
         this.field_74209_t = 1.0F;
      }

      float var5 = (this.field_74211_r - this.field_74213_p) * 0.4F;
      float var4 = 0.2F;
      if(var5 < -var4) {
         var5 = -var4;
      }

      if(var5 > var4) {
         var5 = var4;
      }

      this.field_74210_s += (var5 - this.field_74210_s) * 0.9F;
      this.field_74213_p += this.field_74210_s;
   }

}
