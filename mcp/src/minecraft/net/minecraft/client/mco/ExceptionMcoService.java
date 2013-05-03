package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ExceptionMcoService extends Exception
{
    public final int field_96392_a;
    public final String field_96391_b;

    public ExceptionMcoService(int par1, String par2Str)
    {
        super(par2Str);
        this.field_96392_a = par1;
        this.field_96391_b = par2Str;
    }
}
