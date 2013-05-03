package mods.Periodicraft.item;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemLithiumShard extends PeriodicraftItem {

	public ItemLithiumShard(int par1) {
		super(par1);
		this.setUnlocalizedName("LithiumShard").setCreativeTab(Periodicraft.tabElements);
	}
}
