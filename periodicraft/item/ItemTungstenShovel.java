package mods.periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftShovel;

public class ItemTungstenShovel extends PeriodicraftShovel {

	public ItemTungstenShovel(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("TungstenShovel").setCreativeTab(Periodicraft.tabTools);
	}

}
