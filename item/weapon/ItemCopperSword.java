package mods.Periodicraft.item.weapon;

import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftSword;

public class ItemCopperSword extends PeriodicraftSword {

	public ItemCopperSword(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("CopperSword").setCreativeTab(Periodicraft.tabWeapons);
	}

}
