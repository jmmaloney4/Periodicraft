package mods.periodicraft.item;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftHoe;

public class ItemTitaniumHoe extends PeriodicraftHoe {

	public ItemTitaniumHoe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumHoe");
	}
}
