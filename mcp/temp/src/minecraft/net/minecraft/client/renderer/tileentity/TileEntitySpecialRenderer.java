package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class TileEntitySpecialRenderer {

   protected TileEntityRenderer field_76898_b;


   public abstract void func_76894_a(TileEntity var1, double var2, double var4, double var6, float var8);

   protected void func_76897_a(String p_76897_1_) {
      RenderEngine var2 = this.field_76898_b.field_76960_e;
      if(var2 != null) {
         var2.func_98187_b(p_76897_1_);
      }

   }

   protected void func_82392_a(String p_82392_1_, String p_82392_2_) {
      RenderEngine var3 = this.field_76898_b.field_76960_e;
      if(var3 != null) {
         GL11.glBindTexture(3553, var3.func_78350_a(p_82392_1_, p_82392_2_));
      }

      var3.func_98185_a();
   }

   public void func_76893_a(TileEntityRenderer p_76893_1_) {
      this.field_76898_b = p_76893_1_;
   }

   public void func_76896_a(World p_76896_1_) {}

   public FontRenderer func_76895_b() {
      return this.field_76898_b.func_76954_a();
   }
}
