package mods.periodicraft.item.weapon.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {

	public float explosionRadius = 0.1F;
	
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		this.setDead();
	}
	
	public EntityBullet(World par1World)
	   {
	       super(par1World);
	   }
	   public EntityBullet(World par1World, EntityLiving par2EntityLiving)
	   {
	       super(par1World, par2EntityLiving);
	   }
	   public EntityBullet(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }

}
