package mods.periodicraft.item;

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.PeriodicraftTool;
import mods.periodicraft.item.entity.EntityMiningLaser;
import mods.periodicraft.item.weapon.projectile.EntityLaserPulse;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMiningLaser extends PeriodicraftTool {

	public ItemMiningLaser(int par1, int par2,
			EnumPeriodicraftToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		this.setUnlocalizedName("MiningLaser");
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityMiningLaser(par2World, par3EntityPlayer));
        }

        
        return par1ItemStack;
    }

}
