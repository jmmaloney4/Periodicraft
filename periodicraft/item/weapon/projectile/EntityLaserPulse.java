package mods.periodicraft.item.weapon.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaserPulse extends EntityThrowable {

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(mop.entityHit != null) {
			mop.entityHit.setFire(10);
			mop.entityHit.setInWeb();
			mop.entityHit.setPosition(mop.entityHit.posX, mop.entityHit.posY + 100, mop.entityHit.posZ);
		}
		else {
			this.worldObj.destroyBlock(mop.blockX, mop.blockY, mop.blockZ, false);
		}
	}

	public EntityLaserPulse(World par1World)
    {
        super(par1World);
    }

    public EntityLaserPulse(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityLaserPulse(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
	
}
