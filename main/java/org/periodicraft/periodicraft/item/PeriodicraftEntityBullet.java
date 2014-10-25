package org.periodicraft.periodicraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class PeriodicraftEntityBullet extends EntityThrowable {
	
	public PeriodicraftEntityBullet(World p_i1777_1_, EntityLivingBase p_i1777_2_) {
		super(p_i1777_1_, p_i1777_2_);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {		
		if (mop.entityHit != null)
        {
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5);
        }
		
		if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}

	
	
}
