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

import mods.periodicraft.World.EnumBlockRarity;
import mods.periodicraft.World.WorldGenBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public abstract class PeriodicraftBlock extends Block {

	String UnlocalizedName;
	int dropID;
	int dropCount;

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, float Hardness,
			float Resistance, CreativeTabs CreativeTab, float LightValue,
			int LightOpacity) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.setTextureName("periodicraft:" + UnlocalizedName)
				.setUnlocalizedName(UnlocalizedName)
				.setCreativeTab(CreativeTab).setHardness(Hardness)
				.setResistance(Resistance).setLightValue(LightValue)
				.setLightOpacity(LightOpacity);
		LanguageRegistry.addName(this, this.UnlocalizedName);
		MinecraftForge.setBlockHarvestLevel(this, tool, harvestLevel);
		GameRegistry.registerBlock(this, this.UnlocalizedName);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, float Hardness,
			float Resistance, CreativeTabs CreativeTab) {
		this(par1, par2Material, tool, harvestLevel, UnlocalizedName, Hardness,
				Resistance, CreativeTab, 0, 0);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, float Hardness,
			float Resistance, CreativeTabs CreativeTab, float LightValue) {
		this(par1, par2Material, tool, harvestLevel, UnlocalizedName, Hardness,
				Resistance, CreativeTab, LightValue, 0);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, int drop, int count,
			float Hardness, float Resistance, CreativeTabs CreativeTab) {
		this(par1, par2Material, tool, harvestLevel, UnlocalizedName, Hardness,
				Resistance, CreativeTab, 0, 0);
		this.setDropAndCount(drop, count);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, int drop, int count,
			float Hardness, float Resistance, CreativeTabs CreativeTab,
			float LightValue) {
		this(par1, par2Material, tool, harvestLevel, UnlocalizedName, Hardness,
				Resistance, CreativeTab, LightValue, 0);
		this.setDropAndCount(drop, count);
	}

	public PeriodicraftBlock(int par1, Material par2Material, String tool,
			int harvestLevel, String UnlocalizedName, int drop, int count,
			float Hardness, float Resistance, CreativeTabs CreativeTab,
			float LightValue, int LightOpacity) {
		this(par1, par2Material, tool, harvestLevel, UnlocalizedName, Hardness,
				Resistance, CreativeTab, LightValue, LightOpacity);
		this.setDropAndCount(drop, count);
	}

	@Override
	public int idDropped(int par1, Random random, int zero) {
		return this.dropID;
	}

	@Override
	public String getUnlocalizedName() {
		return this.UnlocalizedName;
	}

	protected void setDropAndCount(int drop, int count) {
		this.dropCount = count;
		this.dropID = drop;
	}

	public Block addSmeltingRecipe(Item item, int outnum, float xp) {
		GameRegistry.addSmelting(this.blockID, new ItemStack(item, outnum), xp);
		return this;
	}

	public Block addSmeltingRecipe(Block block, int outnum, float xp) {
		GameRegistry
				.addSmelting(this.blockID, new ItemStack(block, outnum), xp);
		return this;
	}

	public Block addSmeltingRecipe(Item item, float xp) {
		GameRegistry.addSmelting(this.blockID, new ItemStack(item, 1), xp);
		return this;
	}

	public Block addSmeltingRecipe(Block block, float xp) {
		GameRegistry.addSmelting(this.blockID, new ItemStack(block, 1), xp);
		return this;
	}

	public Block addToSurfaceGen(EnumBlockRarity rarity) {
		Periodicraft.WGen.addToSurfaceGen(new WorldGenBlock(rarity, this));
		return this;
	}

	// public Block addToSurfaceGen(int VPC, int BPV, int MH) {
	// Periodicraft.WGen
	// .addToSurfaceGen(new WorldGenBlock(VPC, BPV, MH, this));
	// return this;
	// }

}
