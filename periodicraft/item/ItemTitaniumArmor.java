package mods.periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/17/2013
//Copyright (C)2013 Jack Maloney

import mods.periodicraft.EnumPeriodicraftArmorMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftArmor;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;	
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemTitaniumArmor extends PeriodicraftArmor {
    
	public ItemTitaniumArmor(int par1, EnumPeriodicraftArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String par5) {
		super(par1, par2EnumArmorMaterial, par3, par4, par5);
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
	
	


