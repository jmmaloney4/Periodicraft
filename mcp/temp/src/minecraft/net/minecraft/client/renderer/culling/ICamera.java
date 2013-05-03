package net.minecraft.client.renderer.culling;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

@SideOnly(Side.CLIENT)
public interface ICamera {

   boolean func_78546_a(AxisAlignedBB var1);

   void func_78547_a(double var1, double var3, double var5);
}
