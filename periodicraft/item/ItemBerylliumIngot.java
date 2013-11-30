package mods.periodicraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemBerylliumIngot extends PeriodicraftItem {

	public ItemBerylliumIngot(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("BerylliumIngot");
	}
	
}
