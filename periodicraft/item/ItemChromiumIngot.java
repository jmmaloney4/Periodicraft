package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemChromiumIngot extends PeriodicraftItem {

	public ItemChromiumIngot(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("ChromiumIngot").setMaxStackSize(64);
	}
}
