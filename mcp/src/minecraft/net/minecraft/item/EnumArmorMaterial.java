package net.minecraft.item;

import mods.Periodicraft.Periodicraft;

public enum EnumArmorMaterial
{
    CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    IRON(15, new int[]{2, 6, 5, 2}, 9),
    GOLD(7, new int[]{2, 5, 3, 1}, 25),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 10),
    TITANIUM(36, new int[]{4, 9, 7, 4}, 13),
    TUNGSTEN(18, new int[]{2, 7, 4, 2}, 11);

    /**
     * Holds the maximum damage factor (each piece multiply this by it's own value) of the material, this is the item
     * damage (how much can absorb before breaks)
     */
    private int maxDamageFactor;

    /**
     * Holds the damage reduction (each 1 points is half a shield on gui) of each piece of armor (helmet, plate, legs
     * and boots)
     */
    private int[] damageReductionAmountArray;

    /** Return the enchantability factor of the material */
    private int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumArmorMaterial(int par3, int[] par4ArrayOfInteger, int par5)
    {
        this.maxDamageFactor = par3;
        this.damageReductionAmountArray = par4ArrayOfInteger;
        this.enchantability = par5;
    }

    /**
     * Returns the durability for a armor slot of for this type.
     */
    public int getDurability(int par1)
    {
        return ItemArmor.getMaxDamageArray()[par1] * this.maxDamageFactor;
    }

    /**
     * Return the damage reduction (each 1 point is a half a shield on gui) of the piece index passed (0 = helmet, 1 =
     * plate, 2 = legs and 3 = boots)
     */
    public int getDamageReductionAmount(int par1)
    {
        return this.damageReductionAmountArray[par1];
    }

    /**
     * Return the enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this armor material, used to determine the item that can be used to repair an
     * armor piece with an anvil
     */
    public int getArmorCraftingMaterial()
    {
        switch (this)
        {
            case CLOTH:   return Item.leather.itemID;
            case CHAIN:   return Item.ingotIron.itemID;
            case GOLD:    return Item.ingotGold.itemID;
            case IRON:    return Item.ingotIron.itemID;
            case DIAMOND: return Item.diamond.itemID;
            case TITANIUM: 	return Periodicraft.TitaniumIngot.itemID;
            case TUNGSTEN: 	return Periodicraft.TungstenIngot.itemID;
            default:      return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
