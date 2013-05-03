package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Rect2i
{
    private int rectX;
    private int rectY;
    private int rectWidth;
    private int rectHeight;

    public Rect2i(int par1, int par2, int par3, int par4)
    {
        this.rectX = par1;
        this.rectY = par2;
        this.rectWidth = par3;
        this.rectHeight = par4;
    }

    public Rect2i intersection(Rect2i par1Rect2i)
    {
        int i = this.rectX;
        int j = this.rectY;
        int k = this.rectX + this.rectWidth;
        int l = this.rectY + this.rectHeight;
        int i1 = par1Rect2i.getRectX();
        int j1 = par1Rect2i.getRectY();
        int k1 = i1 + par1Rect2i.getRectWidth();
        int l1 = j1 + par1Rect2i.getRectHeight();
        this.rectX = Math.max(i, i1);
        this.rectY = Math.max(j, j1);
        this.rectWidth = Math.max(0, Math.min(k, k1) - this.rectX);
        this.rectHeight = Math.max(0, Math.min(l, l1) - this.rectY);
        return this;
    }

    public int getRectX()
    {
        return this.rectX;
    }

    public int getRectY()
    {
        return this.rectY;
    }

    public int getRectWidth()
    {
        return this.rectWidth;
    }

    public int getRectHeight()
    {
        return this.rectHeight;
    }
}
