package mods.Periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;

public class ItemPoloniumShard extends PeriodicraftItem {

	public ItemPoloniumShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("PoloniumShards");
	}
}
