package org.periodicraft.periodicraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class PeriodicraftSpade extends ItemSpade {

	public PeriodicraftSpade(ToolMaterial material, String name, CreativeTabs tab) {
		super(material);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}

	public PeriodicraftSpade(ToolMaterial material, String name, CreativeTabs tab, Item ingot) {
		this(material, name, tab);
    	GameRegistry.addShapedRecipe(new ItemStack(this), " x ", " i ", " i ", 'x', ingot, 'i', Items.stick);
	}
}
