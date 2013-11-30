package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemZincDust extends PeriodicraftItem {

	public ItemZincDust(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setMaxStackSize(64).setUnlocalizedName("ZincDust");
	}
}
