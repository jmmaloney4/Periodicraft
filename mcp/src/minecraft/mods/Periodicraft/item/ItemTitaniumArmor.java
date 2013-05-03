package mods.Periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/17/2013
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;	
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemTitaniumArmor extends ItemArmor {
	
	private final int[] maxDamageArray = new int[] {11, 16, 15, 13};

    /**
     * Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
     */
    public final int armorType;

    /** Holds the amount of damage that the armor reduces at full durability. */
    public int damageReduceAmount;

    /**
     * Used on RenderPlayer to select the correspondent armor to be rendered on the player: 0 is cloth, 1 is chain, 2 is
     * iron, 3 is diamond and 4 is gold.
     */
    public int renderIndex;

    /** The EnumArmorMaterial used for this ItemArmor */
    private final EnumArmorMaterial material;
    
	public ItemTitaniumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String par5) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
        this.armorType = par4;
        this.renderIndex = par3;
        this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
        this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
        this.maxStackSize = 1;
        this.setUnlocalizedName(par5).setCreativeTab(Periodicraft.tabArmor);
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getArmorCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
}
	
	


