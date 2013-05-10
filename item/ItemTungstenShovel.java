package mods.Periodicraft.item;

import net.minecraft.item.EnumToolMaterial;
import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftShovel;

public class ItemTungstenShovel extends PeriodicraftShovel {

	public ItemTungstenShovel(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("TungstenShovel").setCreativeTab(Periodicraft.tabTools);
	}

}
