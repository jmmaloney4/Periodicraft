package mods.periodicraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import mods.periodicraft.PeriodicraftItem;

public class BlockManganeseCrystal extends PeriodicraftBlock {

	public BlockManganeseCrystal(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("ManganeseCrystal");
	}
}
