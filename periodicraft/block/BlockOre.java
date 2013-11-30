package mods.periodicraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import mods.periodicraft.PeriodicraftBlock;

public class BlockOre extends PeriodicraftBlock {
	
	public BlockOre(int par1, Material par2Material, String UnlocalizedName, CreativeTabs CreativeTab, int drop,float Hardness, float Resistnce) {
		super(par1, par2Material, UnlocalizedName, drop);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTab).setHardness(Hardness).setUnlocalizedName(UnlocalizedName).setTextureName("periodicraft:" + UnlocalizedName).setResistance(Resistnce);
	}
	
	public BlockOre(int par1, Material par2Material, String UnlocalizedName, CreativeTabs CreativeTab, int drop, float Hardness, float Resistnce, float LightValue) {
		super(par1, par2Material, UnlocalizedName, drop);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CreativeTab).setHardness(Hardness).setUnlocalizedName(UnlocalizedName).setLightValue(LightValue).setTextureName("periodicraft:" + UnlocalizedName).setResistance(Resistnce);
	}
}
