package mods.Periodicraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class PeriodicraftArmor extends PeriodicraftItem {

	/** Holds the 'base' maxDamage that each armorType have. */
    private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};
    private static final String[] field_94606_cu = new String[] {"helmetCloth_overlay", "chestplateCloth_overlay", "leggingsCloth_overlay", "bootsCloth_overlay"};
    public static final String[] field_94603_a = new String[] {"slot_empty_helmet", "slot_empty_chestplate", "slot_empty_leggings", "slot_empty_boots"};
    private static final IBehaviorDispenseItem field_96605_cw = new BehaivorDispenseArmor();
    /**
     * Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
     */
    public int armorType;

    /** Holds the amount of damage that the armor reduces at full durability. */
    public final int damageReduceAmount;

    /**
     * Used on RenderPlayer to select the correspondent armor to be rendered on the player: 0 is cloth, 1 is chain, 2 is
     * iron, 3 is diamond and 4 is gold.
     */
    public int renderIndex;
    
    /** The EnumArmorMaterial used for this ItemArmor */
    protected EnumPeriodicraftArmorMaterial material;
    
    @SideOnly(Side.CLIENT)
    private Icon field_94605_cw;
    @SideOnly(Side.CLIENT)
    private Icon field_94604_cx;
	
	public PeriodicraftArmor(int par1, EnumPeriodicraftArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String par5) {
		super(par1);
        this.material = par2EnumArmorMaterial;
        this.armorType = par4;
        this.renderIndex = par3;
        this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
        this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
        this.maxStackSize = 1;
        BlockDispenser.dispenseBehaviorRegistry.putObject(this, field_96605_cw);
        this.setUnlocalizedName(par5).setCreativeTab(Periodicraft.tabArmor);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        if (par2 > 0)
        {
            return 16777215;
        }
        else
        {
            int j = this.getColor(par1ItemStack);

            if (j < 0)
            {
                j = 16777215;
            }

            return j;
        }
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public EnumPeriodicraftArmorMaterial getArmorMaterial()
    {
        return this.material;
    }

    /**
     * Return whether the specified armor ItemStack has a color.
     */
    public boolean hasColor(ItemStack par1ItemStack)
    {
        return this.material != EnumPeriodicraftArmorMaterial.CLOTH ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
    }

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        if (this.material != EnumPeriodicraftArmorMaterial.CLOTH)
        {
            return -1;
        }
        else
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                return 10511680;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                return nbttagcompound1 == null ? 10511680 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 10511680);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public Icon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return par2 == 1 ? this.field_94605_cw : super.getIconFromDamageForRenderPass(par1, par2);
    }

    /**
     * Remove the color from the specified armor ItemStack.
     */
    public void removeColor(ItemStack par1ItemStack)
    {
        if (this.material == EnumPeriodicraftArmorMaterial.CLOTH)
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound != null)
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

                if (nbttagcompound1.hasKey("color"))
                {
                    nbttagcompound1.removeTag("color");
                }
            }
        }
    }

    public void func_82813_b(ItemStack par1ItemStack, int par2)
    {
        if (this.material != EnumPeriodicraftArmorMaterial.CLOTH)
        {
            throw new UnsupportedOperationException("Can\'t dye non-leather!");
        }
        else
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                nbttagcompound = new NBTTagCompound();
                par1ItemStack.setTagCompound(nbttagcompound);
            }

            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (!nbttagcompound.hasKey("display"))
            {
                nbttagcompound.setCompoundTag("display", nbttagcompound1);
            }

            nbttagcompound1.setInteger("color", par2);
        }
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getArmorCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        int i = EntityLiving.getArmorPosition(par1ItemStack) - 1;
        ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor(i);

        if (itemstack1 == null)
        {
            par3EntityPlayer.setCurrentItemOrArmor(i + 1, par1ItemStack.copy()); //Forge: Vanilla bug fix associated with fixed setCurrentItemOrArmor indexs for players.
            par1ItemStack.stackSize = 0;
        }

        return par1ItemStack;
    }


    /**
     * Returns the 'max damage' factor array for the armor, each piece of armor have a durability factor (that gets
     * multiplied by armor material factor)
     */
    static int[] getMaxDamageArray()
    {
        return maxDamageArray;
    }

}
