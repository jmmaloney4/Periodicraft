package mods.Periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftShovel;

public class ItemCopperShovel extends PeriodicraftShovel {

	public ItemCopperShovel(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setUnlocalizedName("CopperShovel");
	}

}
