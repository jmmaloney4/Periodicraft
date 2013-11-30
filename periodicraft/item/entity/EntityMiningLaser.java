package mods.periodicraft.item.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftThrowable;

import java.util.Arrays;

public class EntityMiningLaser extends PeriodicraftThrowable {

	public static final int[] UNBREAKABLEBLOCKS = {Block.bedrock.blockID};
	
	static {
		Arrays.sort(UNBREAKABLEBLOCKS);
	}
	
	

	
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		int i1 = this.worldObj.getBlockId((int)this.posX, (int)this.posY, (int)this.posZ);
		boolean breaks = 0 > (Arrays.binarySearch(UNBREAKABLEBLOCKS, i1));
		if(breaks) {
			this.worldObj.destroyBlock((int)this.posX, (int)this.posY, (int)this.posZ, true);
			this.setDead();
		}
		else {
			this.setDead();
		}
	}
	
	public EntityMiningLaser(World par1World)
    {
        super(par1World);
    }

    public EntityMiningLaser(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityMiningLaser(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

}
