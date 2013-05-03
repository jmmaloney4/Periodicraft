package net.minecraft.entity;

public interface IRangedAttackMob
{
    /**
     * Attack the specified entity using a ranged attack.
     */
    void attackEntityWithRangedAttack(EntityLiving entityliving, float f);
}
