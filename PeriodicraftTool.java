package mods.Periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class PeriodicraftTool extends ItemTool {

	public EnumPeriodicraftToolMaterial toolMaterial;
	
	public PeriodicraftTool(int par1, int par2,
			EnumPeriodicraftToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(par1, par2, EnumToolMaterial.STONE, par4ArrayOfBlock);
		this.setMaxStackSize(1).setUnlocalizedName("NullTool").setCreativeTab(Periodicraft.tabTools);
		this.toolMaterial = par3EnumToolMaterial;
		this.damageVsEntity = par2 + toolMaterial.getDamageVsEntity();
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
	@Override
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
	@Override
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

}
