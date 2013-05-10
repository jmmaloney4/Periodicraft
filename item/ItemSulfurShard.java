package mods.Periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;

public class ItemSulfurShard extends PeriodicraftItem {

	public ItemSulfurShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setMaxStackSize(64).setUnlocalizedName("SulfurShard");
	}	
}
