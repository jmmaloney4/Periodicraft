package mods.Periodicraft.dimension.moon;

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftPortal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class BlockMoonPortal extends PeriodicraftPortal {

	public BlockMoonPortal(int par1) {
		super(par1);
		this.setUnlocalizedName("MoonPortal").setCreativeTab(Periodicraft.tabBlocks);
	}
	
	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		 super.updateTick(par1World, par2, par3, par4, par5Random);
	    }
	 
	 public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	    {
	        if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
	        {
	            if(par5Entity instanceof EntityPlayerMP) {
	            	EntityPlayerMP Player = (EntityPlayerMP) par5Entity;
	            	if(par5Entity.dimension != Periodicraft.MoonID) {
	            		Player.mcServer.getConfigurationManager().transferPlayerToDimension(Player, Periodicraft.MoonID, new TeleporterPeriodicraft(Player.mcServer.worldServerForDimension(Periodicraft.MoonID)));
	            	}
	            	else {
	            		Player.mcServer.getConfigurationManager().transferPlayerToDimension(Player, 0, new TeleporterPeriodicraft(Player.mcServer.worldServerForDimension(0)));
	            	}
	            }
	            
	        }
	    }
	 
	    

}
