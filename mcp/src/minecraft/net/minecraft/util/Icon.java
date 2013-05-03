package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface Icon
{
    @SideOnly(Side.CLIENT)

    /**
     * Returns the X position of this icon on its texture sheet, in pixels.
     */
    int getOriginX();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the Y position of this icon on its texture sheet, in pixels.
     */
    int getOriginY();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the minimum U coordinate to use when rendering with this icon.
     */
    float getMinU();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the maximum U coordinate to use when rendering with this icon.
     */
    float getMaxU();

    @SideOnly(Side.CLIENT)

    /**
     * Gets a U coordinate on the icon. 0 returns uMin and 16 returns uMax. Other arguments return in-between values.
     */
    float getInterpolatedU(double d0);

    @SideOnly(Side.CLIENT)

    /**
     * Returns the minimum V coordinate to use when rendering with this icon.
     */
    float getMinV();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the maximum V coordinate to use when rendering with this icon.
     */
    float getMaxV();

    @SideOnly(Side.CLIENT)

    /**
     * Gets a V coordinate on the icon. 0 returns vMin and 16 returns vMax. Other arguments return in-between values.
     */
    float getInterpolatedV(double d0);

    @SideOnly(Side.CLIENT)
    String getIconName();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the width of the texture sheet this icon is on, in pixels.
     */
    int getSheetWidth();

    @SideOnly(Side.CLIENT)

    /**
     * Returns the height of the texture sheet this icon is on, in pixels.
     */
    int getSheetHeight();
}
