package mods.Periodicraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class PeriodicraftBattleAxe extends PeriodicraftTool {
    
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.melon};

	public PeriodicraftBattleAxe(int par1,
			EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, 2,par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setUnlocalizedName("NullBattleAxe");
	}
	
	/**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
    
    @Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
    
    public int getDamageVsEntity(Entity par1Entity)
    {
        return 4 + this.toolMaterial.getDamageVsEntity();
    }

}
