package net.minecraft.entity.boss;

public interface IBossDisplayData
{
    int getMaxHealth();

    /**
     * Returns the health points of the dragon.
     */
    int getDragonHealth();

    /**
     * Gets the username of the entity.
     */
    String getEntityName();
}
