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

/**
 * @author jack
 * 
 */
public enum EnumBlockRarity {

	ULTIMATE(3, 2, 8), RARE(7, 5, 15), SUBTLE(10, 7, 35), UNCOMMON(15, 5, 45), COMMON(
			20, 10, 55), EXTENSIVE(25, 15, 75);

	int VeinsPerChunck;
	int BlocksPerVein;
	int MaxHeight;

	private EnumBlockRarity(int VPC, int BPV, int MH) {
		this.BlocksPerVein = BPV;
		this.VeinsPerChunck = VPC;
		this.MaxHeight = MH;
	}
}
