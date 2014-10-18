package org.periodicraft.periodicraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class PeriodicraftAxe extends ItemAxe {

	public PeriodicraftAxe(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}
	
	public PeriodicraftAxe(ToolMaterial material, String name, CreativeTabs tab, Item ingot) {
		this(material, name, tab);
		GameRegistry.addShapedRecipe(new ItemStack(this), "xx ", "xi ", " i ", 'x', ingot, 'i', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(this), " xx", " ix", " i ", 'x', ingot, 'i', Items.stick);
	}

}
