package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiParticle extends Gui
{
    private List particles = new ArrayList();
    private Minecraft mc;

    public GuiParticle(Minecraft par1Minecraft)
    {
        this.mc = par1Minecraft;
    }

    public void update()
    {
        for (int i = 0; i < this.particles.size(); ++i)
        {
            Particle particle = (Particle)this.particles.get(i);
            particle.preUpdate();
            particle.update(this);

            if (particle.isDead)
            {
                this.particles.remove(i--);
            }
        }
    }

    public void draw(float par1)
    {
        this.mc.renderEngine.bindTexture("/gui/particles.png");

        for (int i = 0; i < this.particles.size(); ++i)
        {
            Particle particle = (Particle)this.particles.get(i);
            int j = (int)(particle.prevPosX + (particle.posX - particle.prevPosX) * (double)par1 - 4.0D);
            int k = (int)(particle.prevPosY + (particle.posY - particle.prevPosY) * (double)par1 - 4.0D);
            float f1 = (float)(particle.prevTintAlpha + (particle.tintAlpha - particle.prevTintAlpha) * (double)par1);
            float f2 = (float)(particle.prevTintRed + (particle.tintRed - particle.prevTintRed) * (double)par1);
            float f3 = (float)(particle.prevTintGreen + (particle.tintGreen - particle.prevTintGreen) * (double)par1);
            float f4 = (float)(particle.prevTintBlue + (particle.tintBlue - particle.prevTintBlue) * (double)par1);
            GL11.glColor4f(f2, f3, f4, f1);
            this.drawTexturedModalRect(j, k, 40, 0, 8, 8);
        }
    }
}
