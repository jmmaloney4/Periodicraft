package mods.periodicraft.item;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftAxe;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemTitaniumAxe extends PeriodicraftAxe {

	public ItemTitaniumAxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumAxe");
	}
}
