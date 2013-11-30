package mods.periodicraft.item;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftAxe;

public class ItemCopperAxe extends PeriodicraftAxe {

	public ItemCopperAxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setUnlocalizedName("CopperAxe");
	}

}
