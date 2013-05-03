package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Comparator;
import net.minecraft.entity.EntityLiving;

@SideOnly(Side.CLIENT)
public class RenderSorter implements Comparator
{
    /** The entity (usually the player) that the camera is inside. */
    private EntityLiving baseEntity;

    public RenderSorter(EntityLiving par1EntityLiving)
    {
        this.baseEntity = par1EntityLiving;
    }

    public int doCompare(WorldRenderer par1WorldRenderer, WorldRenderer par2WorldRenderer)
    {
        if (par1WorldRenderer.isInFrustum && !par2WorldRenderer.isInFrustum)
        {
            return 1;
        }
        else if (par2WorldRenderer.isInFrustum && !par1WorldRenderer.isInFrustum)
        {
            return -1;
        }
        else
        {
            double d0 = (double)par1WorldRenderer.distanceToEntitySquared(this.baseEntity);
            double d1 = (double)par2WorldRenderer.distanceToEntitySquared(this.baseEntity);
            return d0 < d1 ? 1 : (d0 > d1 ? -1 : (par1WorldRenderer.chunkIndex < par2WorldRenderer.chunkIndex ? 1 : -1));
        }
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.doCompare((WorldRenderer)par1Obj, (WorldRenderer)par2Obj);
    }
}
