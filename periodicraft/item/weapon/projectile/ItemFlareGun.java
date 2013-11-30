package mods.periodicraft.item.weapon.projectile;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;

public class ItemFlareGun extends PeriodicraftItem {

	public ItemFlareGun(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabWeapons).setUnlocalizedName("FlareGun");
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
		
		if (flag || par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID)) {
		
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
        	if (!par2World.isRemote)
        	{
        		par2World.spawnEntityInWorld(new EntityFlare(par2World, par3EntityPlayer));
        	}
		}
		return par1ItemStack;
    }

}
