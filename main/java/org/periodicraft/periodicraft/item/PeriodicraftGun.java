package org.periodicraft.periodicraft.item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PeriodicraftGun extends PeriodicraftItem {

	public Class projectile;
	
	public PeriodicraftGun(String name, CreativeTabs tab, Class proj) {
		super(name, tab);
		this.projectile = proj;
		// TODO Auto-generated constructor stub
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	  {
	      if (!par3EntityPlayer.capabilities.isCreativeMode)
	      {
	          --par1ItemStack.stackSize;
	      }
	      par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	      if (!par2World.isRemote)
	      {
	    	try {
				Constructor c = this.projectile.getConstructor(World.class, EntityLivingBase.class);
				par2World.spawnEntityInWorld((Entity) c.newInstance(par2World, par3EntityPlayer));
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	      }
	      return par1ItemStack;
	  }
	
}
