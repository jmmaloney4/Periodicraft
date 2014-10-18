package org.periodicraft.periodicraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class PeriodicraftPickaxe extends ItemPickaxe {

	public PeriodicraftPickaxe(ToolMaterial mat, String name, CreativeTabs tab) {
		super(mat);
		PeriodicraftItem.InitializeItem(this, name, tab);
		// TODO Auto-generated constructor stub
	}
	
}
