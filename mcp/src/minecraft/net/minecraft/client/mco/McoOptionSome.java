package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class McoOptionSome extends McoOption
{
    private final Object field_98156_a;

    public McoOptionSome(Object par1Obj)
    {
        this.field_98156_a = par1Obj;
    }

    public Object func_98155_a()
    {
        return this.field_98156_a;
    }
}
