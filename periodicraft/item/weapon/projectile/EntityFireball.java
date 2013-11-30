package mods.periodicraft.item.weapon.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFireball extends EntityThrowable {

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		
		if(mop.entityHit != null) {
			this.worldObj.createExplosion(mop.entityHit, mop.entityHit.posX, mop.entityHit.posY, mop.entityHit.posZ, 1.5F, true);
			mop.entityHit.setFire(10);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.setDead();
		}		
		else {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1.5F, false);
			this.worldObj.destroyBlock(mop.blockX, mop.blockY, mop.blockZ, false);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ + 1, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX + 1, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX - 1, mop.blockY, mop.blockZ, Block.fire.blockID);
			this.worldObj.setBlock(mop.blockX, mop.blockY, mop.blockZ - 1, Block.fire.blockID);
			this.setDead();
		}
	}
	
	public EntityFireball(World par1World)
    {
        super(par1World);
    }

    public EntityFireball(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityFireball(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

	
	
}
