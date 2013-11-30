package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemNeodymiumIngot extends PeriodicraftItem {

	public ItemNeodymiumIngot(int par1) {
		super(par1);
		this.setUnlocalizedName("NeodymiumIngot").setCreativeTab(Periodicraft.tabMaterials);
	}
}
