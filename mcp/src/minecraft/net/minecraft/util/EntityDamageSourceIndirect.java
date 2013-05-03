package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;

public class EntityDamageSourceIndirect extends EntityDamageSource
{
    private Entity indirectEntity;

    public EntityDamageSourceIndirect(String par1Str, Entity par2Entity, Entity par3Entity)
    {
        super(par1Str, par2Entity);
        this.indirectEntity = par3Entity;
    }

    public Entity getSourceOfDamage()
    {
        return this.damageSourceEntity;
    }

    public Entity getEntity()
    {
        return this.indirectEntity;
    }

    /**
     * Returns the message to be displayed on player death.
     */
    public String getDeathMessage(EntityLiving par1EntityLiving)
    {
        String s = this.indirectEntity == null ? this.damageSourceEntity.func_96090_ax() : this.indirectEntity.func_96090_ax();
        ItemStack itemstack = this.indirectEntity instanceof EntityLiving ? ((EntityLiving)this.indirectEntity).getHeldItem() : null;
        String s1 = "death.attack." + this.damageType;
        String s2 = s1 + ".item";
        return itemstack != null && itemstack.hasDisplayName() && StatCollector.func_94522_b(s2) ? StatCollector.translateToLocalFormatted(s2, new Object[] {par1EntityLiving.func_96090_ax(), s, itemstack.getDisplayName()}): StatCollector.translateToLocalFormatted(s1, new Object[] {par1EntityLiving.func_96090_ax(), s});
    }
}
