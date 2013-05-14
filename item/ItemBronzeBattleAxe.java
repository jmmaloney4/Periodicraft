package mods.Periodicraft.item;

import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.PeriodicraftBattleAxe;
import mods.Periodicraft.PeriodicraftSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBronzeBattleAxe extends PeriodicraftBattleAxe {

	public ItemBronzeBattleAxe(int par1) {
		super(par1, EnumPeriodicraftToolMaterial.BRONZE);
		this.setUnlocalizedName("BronzeBattleAxe");
	}
	
}
