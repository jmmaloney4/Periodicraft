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

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public abstract class PeriodicraftBlock extends Block {

	String UnlocalizedName;
	int dropID;

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, int Drop, float Hardness,
			float Resistance, CreativeTabs CreativeTab) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.dropID = Drop;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setCreativeTab(CreativeTab).setHardness(Hardness)
				.setUnlocalizedName(UnlocalizedName).setResistance(Resistance);
		LanguageRegistry.addName(this, this.UnlocalizedName);
		MinecraftForge.setBlockHarvestLevel(this, tool, harvestLevel);
		GameRegistry.registerBlock(this, this.UnlocalizedName);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, int Drop, float Hardness,
			float Resistance, CreativeTabs CreativeTab, float LightValue) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.dropID = Drop;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setUnlocalizedName(UnlocalizedName)
				.setCreativeTab(CreativeTab).setHardness(Hardness)
				.setResistance(Resistance).setLightValue(LightValue);
		LanguageRegistry.addName(this, this.UnlocalizedName);
		MinecraftForge.setBlockHarvestLevel(this, tool, harvestLevel);
		GameRegistry.registerBlock(this, this.UnlocalizedName);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, float Hardness,
			float Resistance, CreativeTabs CreativeTab) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.dropID = this.blockID;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setCreativeTab(CreativeTab).setHardness(Hardness)
				.setUnlocalizedName(UnlocalizedName).setResistance(Resistance);
		LanguageRegistry.addName(this, this.UnlocalizedName);
		MinecraftForge.setBlockHarvestLevel(this, tool, harvestLevel);
		GameRegistry.registerBlock(this, this.UnlocalizedName);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, float Hardness,
			float Resistance, CreativeTabs CreativeTab, float LightValue) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.dropID = this.blockID;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setUnlocalizedName(UnlocalizedName)
				.setCreativeTab(CreativeTab).setHardness(Hardness)
				.setResistance(Resistance).setLightValue(LightValue);
		LanguageRegistry.addName(this, this.UnlocalizedName);
		MinecraftForge.setBlockHarvestLevel(this, tool, harvestLevel);
		GameRegistry.registerBlock(this, this.UnlocalizedName);
	}

	@Override
	public int idDropped(int par1, Random random, int zero) {
		return this.dropID;
	}

	@Override
	public String getUnlocalizedName() {
		return this.UnlocalizedName;
	}

}
