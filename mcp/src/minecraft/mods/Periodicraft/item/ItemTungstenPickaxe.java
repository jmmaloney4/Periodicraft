package mods.Periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import mods.Periodicraft.PeriodicraftPick;

public class ItemTungstenPickaxe extends PeriodicraftPick {

	public ItemTungstenPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("TungstenPickaxe").setCreativeTab(Periodicraft.tabTools);
	}

}
