package org.periodicraft.periodicraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PeriodicraftOre extends PeriodicraftBlock {

	public PeriodicraftOre(Material m, String name, CreativeTabs ct, int hl) {
		super(m, 3.5F, 3.5F, Block.soundTypeStone, name, ct, "pickaxe", hl);
	}
	
	public PeriodicraftOre(Material m, float h, float r, Block.SoundType st, String name, CreativeTabs ct, int hl) {
		super(m, h, r, st, name, 0, ct, "pickaxe", hl);
	}
	
	public PeriodicraftOre(Material m, float h, float r, Block.SoundType st, String name, float lv, CreativeTabs ct, int hl) {
		super(m, h, r, st, name, ct, "pickaxe", hl);
	}

}
