package mods.Periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftHoe;

public class ItemCopperHoe extends PeriodicraftHoe {

	public ItemCopperHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setUnlocalizedName("CopperHoe");
	}

}
