package mods.Periodicraft;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class PeriodicraftShovel extends PeriodicraftTool {

    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	
	public PeriodicraftShovel(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, 1, par2EnumToolMaterial,blocksEffectiveAgainst);
		this.setUnlocalizedName("NullShovel");
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
	public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }


}
