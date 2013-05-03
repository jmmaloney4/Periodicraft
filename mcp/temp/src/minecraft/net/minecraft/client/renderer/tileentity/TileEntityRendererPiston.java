package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererPiston extends TileEntitySpecialRenderer {

   private RenderBlocks field_76904_a;


   public void func_76903_a(TileEntityPiston p_76903_1_, double p_76903_2_, double p_76903_4_, double p_76903_6_, float p_76903_8_) {
      Block var9 = Block.field_71973_m[p_76903_1_.func_70340_a()];
      if(var9 != null && p_76903_1_.func_70333_a(p_76903_8_) < 1.0F) {
         Tessellator var10 = Tessellator.field_78398_a;
         this.func_76897_a("/terrain.png");
         RenderHelper.func_74518_a();
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         if(Minecraft.func_71379_u()) {
            GL11.glShadeModel(7425);
         } else {
            GL11.glShadeModel(7424);
         }

         var10.func_78382_b();
         var10.func_78373_b((double)((float)p_76903_2_ - (float)p_76903_1_.field_70329_l + p_76903_1_.func_70337_b(p_76903_8_)), (double)((float)p_76903_4_ - (float)p_76903_1_.field_70330_m + p_76903_1_.func_70334_c(p_76903_8_)), (double)((float)p_76903_6_ - (float)p_76903_1_.field_70327_n + p_76903_1_.func_70332_d(p_76903_8_)));
         var10.func_78376_a(1, 1, 1);
         if(var9 == Block.field_72099_aa && p_76903_1_.func_70333_a(p_76903_8_) < 0.5F) {
            this.field_76904_a.func_78587_a(var9, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n, false);
         } else if(p_76903_1_.func_70338_f() && !p_76903_1_.func_70341_b()) {
            Block.field_72099_aa.func_72122_e(((BlockPistonBase)var9).func_72118_n());
            this.field_76904_a.func_78587_a(Block.field_72099_aa, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n, p_76903_1_.func_70333_a(p_76903_8_) < 0.5F);
            Block.field_72099_aa.func_72120_n();
            var10.func_78373_b((double)((float)p_76903_2_ - (float)p_76903_1_.field_70329_l), (double)((float)p_76903_4_ - (float)p_76903_1_.field_70330_m), (double)((float)p_76903_6_ - (float)p_76903_1_.field_70327_n));
            this.field_76904_a.func_78568_d(var9, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n);
         } else {
            this.field_76904_a.func_78583_a(var9, p_76903_1_.field_70329_l, p_76903_1_.field_70330_m, p_76903_1_.field_70327_n);
         }

         var10.func_78373_b(0.0D, 0.0D, 0.0D);
         var10.func_78381_a();
         RenderHelper.func_74519_b();
      }

   }

   public void func_76896_a(World p_76896_1_) {
      this.field_76904_a = new RenderBlocks(p_76896_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76903_a((TileEntityPiston)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
