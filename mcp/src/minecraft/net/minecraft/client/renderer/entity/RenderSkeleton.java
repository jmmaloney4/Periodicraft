package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSkeleton extends RenderBiped
{
    public RenderSkeleton()
    {
        super(new ModelSkeleton(), 0.5F);
    }

    protected void func_82438_a(EntitySkeleton par1EntitySkeleton, float par2)
    {
        if (par1EntitySkeleton.getSkeletonType() == 1)
        {
            GL11.glScalef(1.2F, 1.2F, 1.2F);
        }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.func_82438_a((EntitySkeleton)par1EntityLiving, par2);
    }
}
