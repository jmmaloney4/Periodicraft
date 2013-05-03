package net.minecraft.entity.ai;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAINearestAttackableTarget extends EntityAITarget
{
    EntityLiving targetEntity;
    Class targetClass;
    int targetChance;
    private final IEntitySelector field_82643_g;

    /** Instance of EntityAINearestAttackableTargetSorter. */
    private EntityAINearestAttackableTargetSorter theNearestAttackableTargetSorter;

    public EntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5)
    {
        this(par1EntityLiving, par2Class, par3, par4, par5, false);
    }

    public EntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5, boolean par6)
    {
        this(par1EntityLiving, par2Class, par3, par4, par5, par6, (IEntitySelector)null);
    }

    public EntityAINearestAttackableTarget(EntityLiving par1, Class par2, float par3, int par4, boolean par5, boolean par6, IEntitySelector par7IEntitySelector)
    {
        super(par1, par3, par5, par6);
        this.targetClass = par2;
        this.targetDistance = par3;
        this.targetChance = par4;
        this.theNearestAttackableTargetSorter = new EntityAINearestAttackableTargetSorter(this, par1);
        this.field_82643_g = par7IEntitySelector;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0)
        {
            return false;
        }
        else
        {
            if (this.targetClass == EntityPlayer.class)
            {
                EntityPlayer entityplayer = this.taskOwner.worldObj.getClosestVulnerablePlayerToEntity(this.taskOwner, (double)this.targetDistance);

                if (this.isSuitableTarget(entityplayer, false))
                {
                    this.targetEntity = entityplayer;
                    return true;
                }
            }
            else
            {
                List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand((double)this.targetDistance, 4.0D, (double)this.targetDistance), this.field_82643_g);
                Collections.sort(list, this.theNearestAttackableTargetSorter);
                Iterator iterator = list.iterator();

                while (iterator.hasNext())
                {
                    Entity entity = (Entity)iterator.next();
                    EntityLiving entityliving = (EntityLiving)entity;

                    if (this.isSuitableTarget(entityliving, false))
                    {
                        this.targetEntity = entityliving;
                        return true;
                    }
                }
            }

            return false;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }
}
