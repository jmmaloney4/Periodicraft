package mods.Periodicraft.item;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftHoe;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemTitaniumHoe extends PeriodicraftHoe {

	public ItemTitaniumHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumHoe");
	}
}
