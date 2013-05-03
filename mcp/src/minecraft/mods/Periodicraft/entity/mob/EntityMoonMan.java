package mods.Periodicraft.entity.mob;

import mods.Periodicraft.Periodicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMoonMan extends EntityMob {

	public EntityMoonMan(World par1World) {
		super(par1World);
		this.texture = "/mods/Periodicraft/textures/entity/mob/MoonMan.png";
		this.moveSpeed = 0.3F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 20.0F, 0, true));
	}

	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 35;
	}

	public int getAttackStrength(Entity par1Entity) {
		return 10;
	}
	
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	public int getTotalArmorValue() {
		return 6;
	}

	protected int getDropItemID() {
		return Periodicraft.AluiminumIngot.itemID;
	}
	
	
}
