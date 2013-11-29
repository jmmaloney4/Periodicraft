package mods.Periodicraft.item.weapon.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlare extends EntityThrowable {

public float explosionRadius = 4.5F;
	
	int j = 0;

	public void onUpdate() {
		   j++;   
	   }
	
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		this.setDead();
	}
	
	public EntityFlare(World par1World)
	   {
	       super(par1World);
	   }
	   public EntityFlare(World par1World, EntityLiving par2EntityLiving)
	   {
	       super(par1World, par2EntityLiving);
	   }
	   public EntityFlare(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	   
	   
	   
}
