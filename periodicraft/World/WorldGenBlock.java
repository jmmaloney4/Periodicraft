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

/**
 * 
 */
package mods.periodicraft.World;

import net.minecraft.block.Block;

/**
 * @author jack
 * 
 */
public class WorldGenBlock {
	Block block;
	int veinsPerChunk;
	int blocksPerVein;
	int MaxHeight;

	public WorldGenBlock(int VPC, int BPV, int MH, Block block) {
		this.block = block;
		this.blocksPerVein = BPV;
		this.MaxHeight = MH;
		this.veinsPerChunk = VPC;
	}

	public WorldGenBlock(EnumBlockRarity rarity, Block block) {
		this.block = block;
		this.blocksPerVein = rarity.BlocksPerVein;
		this.MaxHeight = rarity.MaxHeight;
		this.veinsPerChunk = rarity.VeinsPerChunck;
	}

	public Block getBlock() {
		return this.block;
	}

	public int getVPC() {
		return this.veinsPerChunk;
	}

	public int getBPV() {
		return this.blocksPerVein;
	}

	public int getMH() {
		return this.MaxHeight;
	}
}
