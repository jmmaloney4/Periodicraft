package org.periodicraft.periodicraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class PeriodicraftHoe extends ItemHoe {

	public PeriodicraftHoe(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}
	
	public PeriodicraftHoe(ToolMaterial material, String name, CreativeTabs tab, Item ingot) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
		GameRegistry.addShapedRecipe(new ItemStack(this), "xx ", " i ", " i ", 'x', ingot, 'i', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(this), " xx", " i ", " i ", 'x', ingot, 'i', Items.stick);
}
	

}
