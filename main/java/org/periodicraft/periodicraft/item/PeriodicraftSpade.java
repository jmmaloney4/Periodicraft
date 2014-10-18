package org.periodicraft.periodicraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class PeriodicraftSpade extends ItemSpade {

	public PeriodicraftSpade(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		// TODO Auto-generated constructor stub
		PeriodicraftItem.InitializeItem(this, name, tab);
	}

}
