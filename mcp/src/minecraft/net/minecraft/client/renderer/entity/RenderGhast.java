package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelGhast;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityGhast;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGhast extends RenderLiving
{
    public RenderGhast()
    {
        super(new ModelGhast(), 0.5F);
    }

    /**
     * Pre-Renders the Ghast.
     */
    protected void preRenderGhast(EntityGhast par1EntityGhast, float par2)
    {
        float f1 = ((float)par1EntityGhast.prevAttackCounter + (float)(par1EntityGhast.attackCounter - par1EntityGhast.prevAttackCounter) * par2) / 20.0F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderGhast((EntityGhast)par1EntityLiving, par2);
    }
}
