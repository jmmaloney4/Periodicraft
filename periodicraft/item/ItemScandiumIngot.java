package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemScandiumIngot extends PeriodicraftItem {

	public ItemScandiumIngot(int par1) {
		super(par1);
		this.setUnlocalizedName("ScandiumIngot").setCreativeTab(Periodicraft.tabMaterials);
	}
}
