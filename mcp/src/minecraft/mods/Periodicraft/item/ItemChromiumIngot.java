package mods.Periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;

public class ItemChromiumIngot extends PeriodicraftItem {

	public ItemChromiumIngot(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabElements).setUnlocalizedName("ChromiumIngot").setMaxStackSize(64);
	}
}
