package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSnowball extends Render {

   private Item field_94151_a;
   private int field_94150_f;


   public RenderSnowball(Item p_i9007_1_, int p_i9007_2_) {
      this.field_94151_a = p_i9007_1_;
      this.field_94150_f = p_i9007_2_;
   }

   public RenderSnowball(Item p_i9008_1_) {
      this(p_i9008_1_, 0);
   }

   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      Icon var10 = this.field_94151_a.func_77617_a(this.field_94150_f);
      if(var10 != null) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
         GL11.glEnable('\u803a');
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         this.func_76985_a("/gui/items.png");
         Tessellator var11 = Tessellator.field_78398_a;
         if(var10 == ItemPotion.func_94589_d("potion_splash")) {
            int var12 = PotionHelper.func_77915_a(((EntityPotion)p_76986_1_).func_70196_i(), false);
            float var13 = (float)(var12 >> 16 & 255) / 255.0F;
            float var14 = (float)(var12 >> 8 & 255) / 255.0F;
            float var15 = (float)(var12 & 255) / 255.0F;
            GL11.glColor3f(var13, var14, var15);
            GL11.glPushMatrix();
            this.func_77026_a(var11, ItemPotion.func_94589_d("potion_contents"));
            GL11.glPopMatrix();
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
         }

         this.func_77026_a(var11, var10);
         GL11.glDisable('\u803a');
         GL11.glPopMatrix();
      }
   }

   private void func_77026_a(Tessellator p_77026_1_, Icon p_77026_2_) {
      float var3 = p_77026_2_.func_94209_e();
      float var4 = p_77026_2_.func_94212_f();
      float var5 = p_77026_2_.func_94206_g();
      float var6 = p_77026_2_.func_94210_h();
      float var7 = 1.0F;
      float var8 = 0.5F;
      float var9 = 0.25F;
      GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      p_77026_1_.func_78382_b();
      p_77026_1_.func_78375_b(0.0F, 1.0F, 0.0F);
      p_77026_1_.func_78374_a((double)(0.0F - var8), (double)(0.0F - var9), 0.0D, (double)var3, (double)var6);
      p_77026_1_.func_78374_a((double)(var7 - var8), (double)(0.0F - var9), 0.0D, (double)var4, (double)var6);
      p_77026_1_.func_78374_a((double)(var7 - var8), (double)(var7 - var9), 0.0D, (double)var4, (double)var5);
      p_77026_1_.func_78374_a((double)(0.0F - var8), (double)(var7 - var9), 0.0D, (double)var3, (double)var5);
      p_77026_1_.func_78381_a();
   }
}
