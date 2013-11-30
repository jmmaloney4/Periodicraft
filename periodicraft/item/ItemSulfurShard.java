package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemSulfurShard extends PeriodicraftItem {

	public ItemSulfurShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setMaxStackSize(64).setUnlocalizedName("SulfurShard");
	}	
}
