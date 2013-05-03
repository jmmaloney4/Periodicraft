package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderItemFrame extends Render {

   private final RenderBlocks field_82405_a = new RenderBlocks();
   private Icon field_94147_f;


   public void func_94143_a(IconRegister p_94143_1_) {
      this.field_94147_f = p_94143_1_.func_94245_a("itemframe_back");
   }

   public void func_82404_a(EntityItemFrame p_82404_1_, double p_82404_2_, double p_82404_4_, double p_82404_6_, float p_82404_8_, float p_82404_9_) {
      GL11.glPushMatrix();
      float var10 = (float)(p_82404_1_.field_70165_t - p_82404_2_) - 0.5F;
      float var11 = (float)(p_82404_1_.field_70163_u - p_82404_4_) - 0.5F;
      float var12 = (float)(p_82404_1_.field_70161_v - p_82404_6_) - 0.5F;
      int var13 = p_82404_1_.field_70523_b + Direction.field_71583_a[p_82404_1_.field_82332_a];
      int var14 = p_82404_1_.field_70524_c;
      int var15 = p_82404_1_.field_70521_d + Direction.field_71581_b[p_82404_1_.field_82332_a];
      GL11.glTranslatef((float)var13 - var10, (float)var14 - var11, (float)var15 - var12);
      this.func_82403_a(p_82404_1_);
      this.func_82402_b(p_82404_1_);
      GL11.glPopMatrix();
   }

   private void func_82403_a(EntityItemFrame p_82403_1_) {
      GL11.glPushMatrix();
      this.field_76990_c.field_78724_e.func_98187_b("/terrain.png");
      GL11.glRotatef(p_82403_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
      Block var2 = Block.field_71988_x;
      float var3 = 0.0625F;
      float var4 = 0.75F;
      float var5 = var4 / 2.0F;
      GL11.glPushMatrix();
      this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - var5 + 0.0625F), (double)(0.5F - var5 + 0.0625F), (double)(var3 * 0.5F), (double)(0.5F + var5 - 0.0625F), (double)(0.5F + var5 - 0.0625F));
      this.field_82405_a.func_82774_a(this.field_94147_f);
      this.field_82405_a.func_78600_a(var2, 0, 1.0F);
      this.field_82405_a.func_78595_a();
      this.field_82405_a.func_83017_b();
      GL11.glPopMatrix();
      this.field_82405_a.func_82774_a(Block.field_71988_x.func_71858_a(1, 2));
      GL11.glPushMatrix();
      this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(var3 + 0.5F - var5), (double)(0.5F + var5));
      this.field_82405_a.func_78600_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_82405_a.func_83019_b(0.0D, (double)(0.5F + var5 - var3), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_82405_a.func_78600_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)var3, (double)(0.5F + var5), (double)(var3 + 0.5F - var5));
      this.field_82405_a.func_78600_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - var5), (double)(0.5F + var5 - var3), (double)var3, (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_82405_a.func_78600_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      this.field_82405_a.func_83017_b();
      this.field_82405_a.func_78595_a();
      GL11.glPopMatrix();
   }

   private void func_82402_b(EntityItemFrame p_82402_1_) {
      ItemStack var2 = p_82402_1_.func_82335_i();
      if(var2 != null) {
         EntityItem var3 = new EntityItem(p_82402_1_.field_70170_p, 0.0D, 0.0D, 0.0D, var2);
         var3.func_92059_d().field_77994_a = 1;
         var3.field_70290_d = 0.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(-0.453125F * (float)Direction.field_71583_a[p_82402_1_.field_82332_a], -0.18F, -0.453125F * (float)Direction.field_71581_b[p_82402_1_.field_82332_a]);
         GL11.glRotatef(180.0F + p_82402_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(-90 * p_82402_1_.func_82333_j()), 0.0F, 0.0F, 1.0F);
         switch(p_82402_1_.func_82333_j()) {
         case 1:
            GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
            break;
         case 2:
            GL11.glTranslatef(0.0F, -0.32F, 0.0F);
            break;
         case 3:
            GL11.glTranslatef(0.16F, -0.16F, 0.0F);
         }

         if(var3.func_92059_d().func_77973_b() == Item.field_77744_bd) {
            this.field_76990_c.field_78724_e.func_98187_b("/misc/mapbg.png");
            Tessellator var4 = Tessellator.field_78398_a;
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glScalef(0.00390625F, 0.00390625F, 0.00390625F);
            GL11.glTranslatef(-65.0F, -107.0F, -3.0F);
            GL11.glNormal3f(0.0F, 0.0F, -1.0F);
            var4.func_78382_b();
            byte var5 = 7;
            var4.func_78374_a((double)(0 - var5), (double)(128 + var5), 0.0D, 0.0D, 1.0D);
            var4.func_78374_a((double)(128 + var5), (double)(128 + var5), 0.0D, 1.0D, 1.0D);
            var4.func_78374_a((double)(128 + var5), (double)(0 - var5), 0.0D, 1.0D, 0.0D);
            var4.func_78374_a((double)(0 - var5), (double)(0 - var5), 0.0D, 0.0D, 0.0D);
            var4.func_78381_a();
            MapData var6 = Item.field_77744_bd.func_77873_a(var3.func_92059_d(), p_82402_1_.field_70170_p);
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            if(var6 != null) {
               this.field_76990_c.field_78721_f.field_78449_f.func_78319_a((EntityPlayer)null, this.field_76990_c.field_78724_e, var6);
            }
         } else {
            TextureCompass var9;
            if(var3.func_92059_d().func_77973_b() == Item.field_77750_aQ) {
               var9 = TextureCompass.field_94243_h;
               double var10 = var9.field_94244_i;
               double var7 = var9.field_94242_j;
               var9.field_94244_i = 0.0D;
               var9.field_94242_j = 0.0D;
               var9.func_94241_a(p_82402_1_.field_70170_p, p_82402_1_.field_70165_t, p_82402_1_.field_70161_v, (double)MathHelper.func_76142_g((float)(180 + p_82402_1_.field_82332_a * 90)), false, true);
               var9.field_94244_i = var10;
               var9.field_94242_j = var7;
            }

            RenderItem.field_82407_g = true;
            RenderManager.field_78727_a.func_78719_a(var3, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.field_82407_g = false;
            if(var3.func_92059_d().func_77973_b() == Item.field_77750_aQ) {
               var9 = TextureCompass.field_94243_h;
               var9.func_94219_l();
            }
         }

         GL11.glPopMatrix();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82404_a((EntityItemFrame)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
