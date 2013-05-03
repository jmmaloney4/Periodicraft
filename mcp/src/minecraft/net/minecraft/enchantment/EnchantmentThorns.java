package net.minecraft.enchantment;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EnchantmentThorns extends Enchantment
{
    public EnchantmentThorns(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.armor_torso);
        this.setName("thorns");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 3;
    }

    public boolean func_92089_a(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() instanceof ItemArmor ? true : super.func_92089_a(par1ItemStack);
    }

    public static boolean func_92094_a(int par0, Random par1Random)
    {
        return par0 <= 0 ? false : par1Random.nextFloat() < 0.15F * (float)par0;
    }

    public static int func_92095_b(int par0, Random par1Random)
    {
        return par0 > 10 ? par0 - 10 : 1 + par1Random.nextInt(4);
    }

    public static void func_92096_a(Entity par0Entity, EntityLiving par1EntityLiving, Random par2Random)
    {
        int i = EnchantmentHelper.func_92098_i(par1EntityLiving);
        ItemStack itemstack = EnchantmentHelper.func_92099_a(Enchantment.thorns, par1EntityLiving);

        if (func_92094_a(i, par2Random))
        {
            par0Entity.attackEntityFrom(DamageSource.func_92087_a(par1EntityLiving), func_92095_b(i, par2Random));
            par0Entity.playSound("damage.thorns", 0.5F, 1.0F);

            if (itemstack != null)
            {
                itemstack.damageItem(3, par1EntityLiving);
            }
        }
        else if (itemstack != null)
        {
            itemstack.damageItem(1, par1EntityLiving);
        }
    }
}
