package mods.Periodicraft.item;

import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftPick;

public class ItemTungstenPickaxe extends PeriodicraftPick {

	public ItemTungstenPickaxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("TungstenPickaxe").setCreativeTab(Periodicraft.tabTools);
	}

}
