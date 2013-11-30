package mods.periodicraft.block;

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

import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOre extends PeriodicraftBlock {

	public BlockOre(int par1, Material par2Material, String UnlocalizedName,
			CreativeTabs CreativeTab, int drop, float Hardness,
			float Resistance, int HarvestLevel) {
		super(par1, par2Material, "pickaxe", HarvestLevel, UnlocalizedName,
				drop, Hardness, Resistance, CreativeTab);
	}

	public BlockOre(int par1, Material par2Material, String UnlocalizedName,
			CreativeTabs CreativeTab, int drop, float Hardness,
			float Resistance, float LightValue, int HarvestLevel) {
		super(par1, par2Material, "pickaxe", HarvestLevel, UnlocalizedName,
				drop, Hardness, Resistance, CreativeTab, LightValue);
	}

	public BlockOre(int par1, Material par2Material, String UnlocalizedName,
			CreativeTabs CreativeTab, float Hardness, float Resistance,
			int HarvestLevel) {
		super(par1, par2Material, "pickaxe", HarvestLevel, UnlocalizedName,
				Hardness, Resistance, CreativeTab);
	}

	public BlockOre(int par1, Material par2Material, String UnlocalizedName,
			CreativeTabs CreativeTab, float Hardness, float Resistance,
			float LightValue, int HarvestLevel) {
		super(par1, par2Material, "pickaxe", HarvestLevel, UnlocalizedName,
				Hardness, Resistance, CreativeTab, LightValue);
	}
}
