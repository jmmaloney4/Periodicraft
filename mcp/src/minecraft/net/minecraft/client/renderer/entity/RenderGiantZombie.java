package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityGiantZombie;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGiantZombie extends RenderLiving
{
    /** Scale of the model to use */
    private float scale;

    public RenderGiantZombie(ModelBase par1ModelBase, float par2, float par3)
    {
        super(par1ModelBase, par2 * par3);
        this.scale = par3;
    }

    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(EntityGiantZombie par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderScale((EntityGiantZombie)par1EntityLiving, par2);
    }
}
