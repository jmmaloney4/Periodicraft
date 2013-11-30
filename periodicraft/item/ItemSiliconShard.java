package mods.periodicraft.item;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemSiliconShard extends PeriodicraftItem {

	public ItemSiliconShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("SiliconShard");
	}
}
