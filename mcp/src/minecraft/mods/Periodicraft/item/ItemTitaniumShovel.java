package mods.Periodicraft.item;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftShovel;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemTitaniumShovel extends PeriodicraftShovel {

	public ItemTitaniumShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumShovel");
	}
}
