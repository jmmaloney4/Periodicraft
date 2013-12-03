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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class PeriodicraftBlock extends Block {

	String UnlocalizedName;
	int dropID;
	int dropCount;

	public PeriodicraftBlock(int par1, Material par2Material) {
		super(par1, par2Material);
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

	public Block addToSurfaceGen(EnumBlockRarity rarity,Block block) {
		Periodicraft.WGen.addToSurfaceGen(new WorldGenBlock(rarity, block));
		return block;
	}

	public Block addToNetherGen(EnumBlockRarity rarity) {
		Periodicraft.WGen.addToNetherGen(new WorldGenBlock(rarity, this));
		return this;
	}

	public Block addToEndGen(EnumBlockRarity rarity) {
		Periodicraft.WGen.addToEndGen(new WorldGenBlock(rarity, this));
		return this;
	}

	// public Block addToSurfaceGen(int VPC, int BPV, int MH) {
	// Periodicraft.WGen
	// .addToSurfaceGen(new WorldGenBlock(VPC, BPV, MH, this));
	// return this;
	// }

}
