package mods.periodicraft.item.weapon;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftSword;

public class ItemCopperSword extends PeriodicraftSword {

	public ItemCopperSword(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("CopperSword").setCreativeTab(Periodicraft.tabWeapons);
	}

}
