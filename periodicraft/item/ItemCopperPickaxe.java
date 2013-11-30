package mods.periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftPick;

public class ItemCopperPickaxe extends PeriodicraftPick {

	public ItemCopperPickaxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setUnlocalizedName("CopperPickaxe");
	}

}
