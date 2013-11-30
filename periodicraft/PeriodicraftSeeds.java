package mods.periodicraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeeds;

public class PeriodicraftSeeds extends ItemSeeds {

	public PeriodicraftSeeds(int par1, int par2, int par3) {
		super(par1, par2, par3);
		this.setUnlocalizedName("NullSeeds").setCreativeTab(Periodicraft.tabMaterials).setMaxStackSize(64);
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
}
