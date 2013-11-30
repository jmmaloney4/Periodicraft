package mods.periodicraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class PeriodicraftBlock extends Block {

	String UnlocalizedName;
	int dropID;

	public PeriodicraftBlock(int par1, Material par2Material, String UnlocalizedName, int Drop) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.UnlocalizedName = UnlocalizedName;
		this.dropID = Drop;
	}

	public int idDropped(int par1, Random random, int zero) {
		return this.dropID;
	}

}
