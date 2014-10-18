package org.periodicraft.periodicraft.item;

import java.util.Set;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;

public class PeriodicraftTool extends ItemTool {

	protected PeriodicraftTool(float p_i45333_1_, ToolMaterial material,
			Set p_i45333_3_, String name, CreativeTabs tab) {
		super(p_i45333_1_, material, p_i45333_3_);
		PeriodicraftItem.InitializeItem(this, name, tab);
	}

}
