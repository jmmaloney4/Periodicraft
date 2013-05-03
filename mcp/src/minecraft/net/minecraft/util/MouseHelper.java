package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Component;
import net.minecraft.client.settings.GameSettings;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class MouseHelper
{
    private final Component windowComponent;
    private final GameSettings field_85184_d;

    /** Mouse delta X this frame */
    public int deltaX;

    /** Mouse delta Y this frame */
    public int deltaY;

    public MouseHelper(Component par1Component, GameSettings par2GameSettings)
    {
        this.windowComponent = par1Component;
        this.field_85184_d = par2GameSettings;
    }

    /**
     * Grabs the mouse cursor it doesn't move and isn't seen.
     */
    public void grabMouseCursor()
    {
        Mouse.setGrabbed(true);
        this.deltaX = 0;
        this.deltaY = 0;
    }

    /**
     * Ungrabs the mouse cursor so it can be moved and set it to the center of the screen
     */
    public void ungrabMouseCursor()
    {
        int i = this.windowComponent.getWidth();
        int j = this.windowComponent.getHeight();

        if (this.windowComponent.getParent() != null)
        {
            i = this.windowComponent.getParent().getWidth();
            j = this.windowComponent.getParent().getHeight();
        }

        Mouse.setCursorPosition(i / 2, j / 2);
        Mouse.setGrabbed(false);
    }

    public void mouseXYChange()
    {
        this.deltaX = Mouse.getDX();
        this.deltaY = Mouse.getDY();
    }
}
