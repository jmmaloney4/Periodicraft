package mods.periodicraft.item;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftPick;

public class ItemTungstenPickaxe extends PeriodicraftPick {

	public ItemTungstenPickaxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("TungstenPickaxe").setCreativeTab(Periodicraft.tabTools);
	}

}
