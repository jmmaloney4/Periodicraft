package net.minecraft.entity.passive;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public abstract class EntityAmbientCreature extends EntityLiving implements IAnimals
{
    public EntityAmbientCreature(World par1World)
    {
        super(par1World);
    }
}
