package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class EntityDamageSource extends DamageSource
{
    protected Entity damageSourceEntity;

    public EntityDamageSource(String par1Str, Entity par2Entity)
    {
        super(par1Str);
        this.damageSourceEntity = par2Entity;
    }

    public Entity getEntity()
    {
        return this.damageSourceEntity;
    }

    /**
     * Returns the message to be displayed on player death.
     */
    public String getDeathMessage(EntityLiving par1EntityLiving)
    {
        ItemStack itemstack = this.damageSourceEntity instanceof EntityLiving ? ((EntityLiving)this.damageSourceEntity).getHeldItem() : null;
        String s = "death.attack." + this.damageType;
        String s1 = s + ".item";
        return itemstack != null && itemstack.hasDisplayName() && StatCollector.func_94522_b(s1) ? StatCollector.translateToLocalFormatted(s1, new Object[] {par1EntityLiving.func_96090_ax(), this.damageSourceEntity.func_96090_ax(), itemstack.getDisplayName()}): StatCollector.translateToLocalFormatted(s, new Object[] {par1EntityLiving.func_96090_ax(), this.damageSourceEntity.func_96090_ax()});
    }

    /**
     * Return whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    public boolean isDifficultyScaled()
    {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLiving && !(this.damageSourceEntity instanceof EntityPlayer);
    }
}
