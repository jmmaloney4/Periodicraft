package mods.Periodicraft.item;

import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftAxe;

public class ItemCopperAxe extends PeriodicraftAxe {

	public ItemCopperAxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setUnlocalizedName("CopperAxe");
	}

}
