package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySpider;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSpider extends RenderLiving
{
    public RenderSpider()
    {
        super(new ModelSpider(), 1.0F);
        this.setRenderPassModel(new ModelSpider());
    }

    protected float setSpiderDeathMaxRotation(EntitySpider par1EntitySpider)
    {
        return 180.0F;
    }

    /**
     * Sets the spider's glowing eyes
     */
    protected int setSpiderEyeBrightness(EntitySpider par1EntitySpider, int par2, float par3)
    {
        if (par2 != 0)
        {
            return -1;
        }
        else
        {
            this.loadTexture("/mob/spider_eyes.png");
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (par1EntitySpider.getHasActivePotion())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    protected void scaleSpider(EntitySpider par1EntitySpider, float par2)
    {
        float f1 = par1EntitySpider.spiderScaleAmount();
        GL11.glScalef(f1, f1, f1);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.scaleSpider((EntitySpider)par1EntityLiving, par2);
    }

    protected float getDeathMaxRotation(EntityLiving par1EntityLiving)
    {
        return this.setSpiderDeathMaxRotation((EntitySpider)par1EntityLiving);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.setSpiderEyeBrightness((EntitySpider)par1EntityLiving, par2, par3);
    }
}
