package org.periodicraft.periodicraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class PeriodicraftArmor extends ItemArmor {

	public PeriodicraftArmor(ArmorMaterial material, int type, String name, CreativeTabs tab) {
		super(material, 0, type);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}

}
