package mods.periodicraft;

/*
 Copyright (C) 2013  Jack Maloney

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public abstract class PeriodicraftItem extends Item {

	String UnlocalizedName;

	public PeriodicraftItem(int par1, String UnlocalizedName,
			CreativeTabs CreativeTab) {
		super(par1);
		this.UnlocalizedName = UnlocalizedName;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setCreativeTab(CreativeTab).setMaxStackSize(64)
				.setTextureName("periodicraft:" + this.UnlocalizedName);
		LanguageRegistry.addName(this, this.UnlocalizedName);
	}

	public PeriodicraftItem(int par1, String UnlocalizedName, int MaxStack,
			CreativeTabs CreativeTab) {
		super(par1);
		this.UnlocalizedName = UnlocalizedName;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setMaxStackSize(MaxStack).setCreativeTab(CreativeTab)
				.setTextureName("periodicraft:" + this.UnlocalizedName);
		LanguageRegistry.addName(this, this.UnlocalizedName);
	}

	@Override
	public String getUnlocalizedName() {
		return this.UnlocalizedName;
	}

	public void addSmeltingRecipe(Item item, int outnum, float xp) {
		GameRegistry.addSmelting(this.itemID, new ItemStack(item, outnum), xp);
	}

	public void addSmeltingRecipe(Block block, int outnum, float xp) {
		GameRegistry.addSmelting(this.itemID, new ItemStack(block, outnum), xp);
	}

	public void addSmeltingRecipe(Item item, float xp) {
		GameRegistry.addSmelting(this.itemID, new ItemStack(item, 1), xp);
	}

	public void addSmeltingRecipe(Block block, float xp) {
		GameRegistry.addSmelting(this.itemID, new ItemStack(block, 1), xp);
	}

}
