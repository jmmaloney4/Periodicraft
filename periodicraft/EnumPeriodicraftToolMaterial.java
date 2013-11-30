package mods.periodicraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumPeriodicraftToolMaterial {
	
	WOOD(0, 59, 2.0F, 0, 15),
    STONE(1, 131, 4.0F, 1, 5),
    IRON(2, 250, 6.0F, 2, 14),
    EMERALD(3, 1561, 8.0F, 3, 10),
    GOLD(0, 32, 12.0F, 0, 22),
	TITANIUM(4, 2555, 9.0F, 3, 12),
    TUNGSTEN(2, 600, 6.5F, 3, 16),
    COPPER(2, 125, 4.5F, 1, 7),
    STEELSWORD(2, 1940, 7.0F, 5, 14),
    STEEL(2, 1940, 7.0F, 2, 10),
    PLATINUM(3, 1895, 8.5F, 4, 11),
    BRONZE(2, 800, 7.0F, 3, 13);

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final int damageVsEntity;

    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumPeriodicraftToolMaterial(int par3, int par4, float par5, int par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public int getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        switch (this)
        {
        	case WOOD:    return Block.planks.blockID;
        	case STONE:   return Block.cobblestone.blockID;
        	case GOLD:    return Item.ingotGold.itemID;
        	case IRON:    return Item.ingotIron.itemID;
        	case EMERALD: return Item.diamond.itemID;
        	case TITANIUM: return Periodicraft.TitaniumIngot.itemID;
        	case TUNGSTEN: return Periodicraft.TungstenIngot.itemID;
        	case COPPER: return Periodicraft.CopperIngot.itemID;
        	case STEELSWORD: return Periodicraft.PureSteelBlock.blockID;
        	case STEEL: return Periodicraft.PureSteelBlock.blockID;
        	case PLATINUM: return Periodicraft.PlatinumAlloy.itemID;
            default:      return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
