package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemCobaltIngot extends PeriodicraftItem {

	public ItemCobaltIngot(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("CobaltIngot");
	}

}
