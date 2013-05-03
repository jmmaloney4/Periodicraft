package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFallingSand extends Render {

   private RenderBlocks field_77004_a = new RenderBlocks();


   public RenderFallingSand() {
      this.field_76989_e = 0.5F;
   }

   public void func_77003_a(EntityFallingSand p_77003_1_, double p_77003_2_, double p_77003_4_, double p_77003_6_, float p_77003_8_, float p_77003_9_) {
      World var10 = p_77003_1_.func_70283_d();
      Block var11 = Block.field_71973_m[p_77003_1_.field_70287_a];
      if(var10.func_72798_a(MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v)) != p_77003_1_.field_70287_a) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_77003_2_, (float)p_77003_4_, (float)p_77003_6_);
         this.func_76985_a("/terrain.png");
         GL11.glDisable(2896);
         Tessellator var12;
         if(var11 instanceof BlockAnvil && var11.func_71857_b() == 35) {
            this.field_77004_a.field_78669_a = var10;
            var12 = Tessellator.field_78398_a;
            var12.func_78382_b();
            var12.func_78373_b((double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70165_t)) - 0.5F), (double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70163_u)) - 0.5F), (double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70161_v)) - 0.5F));
            this.field_77004_a.func_85096_a((BlockAnvil)var11, MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v), p_77003_1_.field_70285_b);
            var12.func_78373_b(0.0D, 0.0D, 0.0D);
            var12.func_78381_a();
         } else if(var11.func_71857_b() == 27) {
            this.field_77004_a.field_78669_a = var10;
            var12 = Tessellator.field_78398_a;
            var12.func_78382_b();
            var12.func_78373_b((double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70165_t)) - 0.5F), (double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70163_u)) - 0.5F), (double)((float)(-MathHelper.func_76128_c(p_77003_1_.field_70161_v)) - 0.5F));
            this.field_77004_a.func_78618_a((BlockDragonEgg)var11, MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v));
            var12.func_78373_b(0.0D, 0.0D, 0.0D);
            var12.func_78381_a();
         } else if(var11 != null) {
            this.field_77004_a.func_83018_a(var11);
            this.field_77004_a.func_78588_a(var11, var10, MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v), p_77003_1_.field_70285_b);
         }

         GL11.glEnable(2896);
         GL11.glPopMatrix();
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77003_a((EntityFallingSand)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
