package mods.Periodicraft;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public abstract class PeriodicraftThrowable extends EntityThrowable {

	public PeriodicraftThrowable(World par1World)
    {
        super(par1World);
    }

    public PeriodicraftThrowable(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public PeriodicraftThrowable(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

}
