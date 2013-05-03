package mods.Periodicraft;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class PeriodicraftCrop extends BlockCrops {

	protected PeriodicraftCrop(int par1) {
		super(par1);
		this.setCreativeTab(null).setUnlocalizedName("NullCrop");
	}

	@Override
	public int idPicked (World world, int x, int y, int z) {
	    return (Integer) null;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
	
}
