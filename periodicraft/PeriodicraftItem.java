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

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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

}
