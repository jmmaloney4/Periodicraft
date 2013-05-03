package mods.Periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;

public class ItemPhosphorusShard extends PeriodicraftItem {

	public ItemPhosphorusShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabElements).setUnlocalizedName("PhosphorusShard").setMaxStackSize(64);
	}
}
