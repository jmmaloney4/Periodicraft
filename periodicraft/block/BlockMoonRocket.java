package mods.periodicraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mods.periodicraft.PeriodicraftBlock;

public class BlockMoonRocket extends PeriodicraftBlock {

	public BlockMoonRocket(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("MoonRocket").setHardness(10.5F);
	}
	
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		
		
		
	}

}
