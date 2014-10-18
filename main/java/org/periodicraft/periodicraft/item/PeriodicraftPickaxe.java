package org.periodicraft.periodicraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class PeriodicraftPickaxe extends ItemPickaxe {

	public PeriodicraftPickaxe(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}
	
	public PeriodicraftPickaxe(ToolMaterial material, String name, CreativeTabs tab, Item ingot) {
		this(material, name, tab);
    	GameRegistry.addShapedRecipe(new ItemStack(this), "xxx", " i ", " i ", 'x', ingot, 'i', Items.stick);
	}
	
}
