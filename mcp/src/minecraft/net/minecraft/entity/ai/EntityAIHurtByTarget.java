package net.minecraft.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public class EntityAIHurtByTarget extends EntityAITarget
{
    boolean field_75312_a;

    /** The PathNavigate of our entity. */
    EntityLiving entityPathNavigate;

    public EntityAIHurtByTarget(EntityLiving par1EntityLiving, boolean par2)
    {
        super(par1EntityLiving, 16.0F, false);
        this.field_75312_a = par2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.isSuitableTarget(this.taskOwner.getAITarget(), true);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.taskOwner.getAITarget() != null && this.taskOwner.getAITarget() != this.entityPathNavigate;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this.entityPathNavigate = this.taskOwner.getAITarget();

        if (this.field_75312_a)
        {
            List list = this.taskOwner.worldObj.getEntitiesWithinAABB(this.taskOwner.getClass(), AxisAlignedBB.getAABBPool().getAABB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D).expand((double)this.targetDistance, 10.0D, (double)this.targetDistance));
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityLiving entityliving = (EntityLiving)iterator.next();

                if (this.taskOwner != entityliving && entityliving.getAttackTarget() == null)
                {
                    entityliving.setAttackTarget(this.taskOwner.getAITarget());
                }
            }
        }

        super.startExecuting();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        if (this.taskOwner.getAttackTarget() != null && this.taskOwner.getAttackTarget() instanceof EntityPlayer && ((EntityPlayer)this.taskOwner.getAttackTarget()).capabilities.disableDamage)
        {
            super.resetTask();
        }
    }
}
