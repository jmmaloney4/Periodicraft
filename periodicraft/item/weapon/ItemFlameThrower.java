package mods.periodicraft.item.weapon;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;
import mods.periodicraft.item.weapon.projectile.EntityFireball;

public class ItemFlameThrower extends PeriodicraftItem {

	public ItemFlameThrower(int par1) {
		super(par1);
		this.setUnlocalizedName("Flamethrower").setCreativeTab(Periodicraft.tabWeapons);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.consumeInventoryItem(Periodicraft.Fireball.itemID))
        {

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityFireball(par2World, par3EntityPlayer));
        }

        }
        return par1ItemStack;
    }
}
