package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

class CallableEffectName implements Callable
{
    final PotionEffect field_102031_a;

    final EntityLiving field_102030_b;

    CallableEffectName(EntityLiving par1EntityLiving, PotionEffect par2PotionEffect)
    {
        this.field_102030_b = par1EntityLiving;
        this.field_102031_a = par2PotionEffect;
    }

    public String func_102029_a()
    {
        return Potion.potionTypes[this.field_102031_a.getPotionID()].getName();
    }

    public Object call()
    {
        return this.func_102029_a();
    }
}
