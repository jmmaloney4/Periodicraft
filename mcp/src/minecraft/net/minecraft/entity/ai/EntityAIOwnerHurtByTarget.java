package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAIOwnerHurtByTarget extends EntityAITarget
{
    EntityTameable theDefendingTameable;
    EntityLiving theOwnerAttacker;

    public EntityAIOwnerHurtByTarget(EntityTameable par1EntityTameable)
    {
        super(par1EntityTameable, 32.0F, false);
        this.theDefendingTameable = par1EntityTameable;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.theDefendingTameable.isTamed())
        {
            return false;
        }
        else
        {
            EntityLiving entityliving = this.theDefendingTameable.getOwner();

            if (entityliving == null)
            {
                return false;
            }
            else
            {
                this.theOwnerAttacker = entityliving.getAITarget();
                return this.isSuitableTarget(this.theOwnerAttacker, false);
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        super.startExecuting();
    }
}
