package mods.Periodicraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import mods.Periodicraft.PeriodicraftItem;

public class BlockManganeseCrystal extends PeriodicraftBlock {

	public BlockManganeseCrystal(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("ManganeseCrystal");
	}
}
