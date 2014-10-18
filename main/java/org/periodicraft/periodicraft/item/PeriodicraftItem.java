package org.periodicraft.periodicraft.item;

import org.periodicraft.periodicraft.Periodicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PeriodicraftItem extends Item {
	
	public PeriodicraftItem(String name, CreativeTabs tab) {
		PeriodicraftItem.InitializeItem(this, name, tab);
	}
	
	static void InitializeItem(Item i, String name, CreativeTabs tab) {
		i.setCreativeTab(tab);
		i.setUnlocalizedName(name);
		i.setTextureName(Periodicraft.MODID + ":" + name);
		GameRegistry.registerItem(i, name);
	}
	
}
