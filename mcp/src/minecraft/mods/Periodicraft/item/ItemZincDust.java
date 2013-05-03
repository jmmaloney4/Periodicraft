package mods.Periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;

public class ItemZincDust extends PeriodicraftItem {

	public ItemZincDust(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabElements).setMaxStackSize(64).setUnlocalizedName("ZincDust");
	}
}
