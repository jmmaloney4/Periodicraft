package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.potion.PotionEffect;

class CallableEffectIsSplash implements Callable
{
    final PotionEffect field_102043_a;

    final EntityLiving field_102042_b;

    CallableEffectIsSplash(EntityLiving par1EntityLiving, PotionEffect par2PotionEffect)
    {
        this.field_102042_b = par1EntityLiving;
        this.field_102043_a = par2PotionEffect;
    }

    public String func_102041_a()
    {
        return this.field_102043_a.func_102028_d() + "";
    }

    public Object call()
    {
        return this.func_102041_a();
    }
}
