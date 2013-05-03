package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class TileEntitySpecialRenderer
{
    /**
     * The TileEntityRenderer instance associated with this TileEntitySpecialRenderer
     */
    protected TileEntityRenderer tileEntityRenderer;

    public abstract void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f);

    /**
     * Binds a texture to the renderEngine given a filename from the JAR.
     */
    protected void bindTextureByName(String par1Str)
    {
        RenderEngine renderengine = this.tileEntityRenderer.renderEngine;

        if (renderengine != null)
        {
            renderengine.bindTexture(par1Str);
        }
    }

    /**
     * Binds a texture that Minecraft will attempt to load from the given URL.  (arguments: url, localFallback)
     */
    protected void bindTextureByURL(String par1Str, String par2Str)
    {
        RenderEngine renderengine = this.tileEntityRenderer.renderEngine;

        if (renderengine != null)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, renderengine.getTextureForDownloadableImage(par1Str, par2Str));
        }

        renderengine.resetBoundTexture();
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        this.tileEntityRenderer = par1TileEntityRenderer;
    }

    /**
     * Called when the ingame world being rendered changes (e.g. on world -> nether travel) due to using one renderer
     * per tile entity type, rather than instance
     */
    public void onWorldChange(World par1World) {}

    public FontRenderer getFontRenderer()
    {
        return this.tileEntityRenderer.getFontRenderer();
    }
}
