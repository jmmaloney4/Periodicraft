package org.periodicraft.periodicraft;

import org.periodicraft.periodicraft.item.PeriodicraftItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class PeriodicraftSword extends ItemSword {

	public PeriodicraftSword(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}

}
