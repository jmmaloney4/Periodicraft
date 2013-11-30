package mods.periodicraft;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class PeriodicraftFood extends ItemFood {

	public PeriodicraftFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setUnlocalizedName("NullFood").setCreativeTab(Periodicraft.tabFood);	
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
}
