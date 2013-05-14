package mods.Periodicraft.block.gui;

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import mods.Periodicraft.block.tileEntity.TileEntityEinsteiniumChest;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEinsteiniumChest extends PeriodicraftBlock{

	public BlockEinsteiniumChest (int id) {
		super(id, Material.wood);
		setHardness(2.0F);
		setResistance(5.0F);
		setUnlocalizedName("EinsteiniumChest");
		setCreativeTab(Periodicraft.tabUtility);
	}
	
	public TileEntity createNewTileEntity(World world)
	{
	   return new TileEntityEinsteiniumChest();
	}

}
