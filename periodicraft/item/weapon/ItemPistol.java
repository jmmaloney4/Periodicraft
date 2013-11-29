package mods.Periodicraft.item.weapon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import mods.Periodicraft.ID;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import mods.Periodicraft.item.weapon.projectile.EntityBullet;

public class ItemPistol extends PeriodicraftItem {

	public ItemPistol(int par1) {
		super(par1);
		this.setUnlocalizedName("Pistol").setMaxStackSize(1).setCreativeTab(Periodicraft.tabWeapons);
	}
	
	
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
		
		if (flag || par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID)) {
		
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
        	if (!par2World.isRemote)
        	{
        		par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer));
        	}
		}
		return par1ItemStack;
    }
	
}
