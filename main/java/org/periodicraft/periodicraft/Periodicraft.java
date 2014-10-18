package org.periodicraft.periodicraft;

import org.periodicraft.periodicraft.block.PeriodicraftOre;
import org.periodicraft.periodicraft.item.PeriodicraftIngot;
import org.periodicraft.periodicraft.item.PeriodicraftPickaxe;
import org.periodicraft.periodicraft.item.PeriodicraftSpade;
import org.periodicraft.periodicraft.item.PeriodicraftSword;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Periodicraft.MODID, name = Periodicraft.NAME, version = Periodicraft.VERSION)
public class Periodicraft {
	
    public static final String MODID = "org.periodicraft.periodicraft";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "Periodicraft";
    
    public static CreativeTabs tabBlocks = new CreativeTabs("Periodicraft Blocks") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Periodicraft.BlockCopperOre);
        }
    };
    
    public static CreativeTabs tabWeapons = new CreativeTabs("Periodicraft Weapons") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperSword;
        }
    };
    
    public static CreativeTabs tabTools = new CreativeTabs("Periodicraft Tools") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperPickaxe;
        }
    };
    
    public static CreativeTabs tabMaterials = new CreativeTabs("Periodicraft Materials") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperIngot;
        }
    };
    
    public static Block BlockCopperOre;
    
    public static ToolMaterial ToolMaterialCopper;
    
    public static Item ItemCopperIngot;
    public static Item ItemCopperPickaxe;
    public static Item ItemCopperSword;
    public static Item ItemCopperSpade;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ToolMaterialCopper = EnumHelper.addToolMaterial("Copper", 2, 175, 3.8F, 1.6F, 10);
    	
    	BlockCopperOre = new PeriodicraftOre(Material.rock, 4.0F, 2.2F, Block.soundTypeStone, "CopperOre", tabBlocks, 1);
    	ItemCopperIngot = new PeriodicraftIngot("CopperIngot", tabMaterials);
    	ItemCopperPickaxe = new PeriodicraftPickaxe(ToolMaterialCopper, "CopperPickaxe", tabTools);
    	ItemCopperSword = new PeriodicraftSword(ToolMaterialCopper, "CopperSword", tabWeapons);
    	ItemCopperSpade = new PeriodicraftSpade(ToolMaterialCopper, "CopperSpade", tabTools);
    	
    	GameRegistry.addSmelting(Periodicraft.BlockCopperOre, new ItemStack(Periodicraft.ItemCopperIngot), 2.6F);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemCopperPickaxe), "xxx", " i ", " i ", 'x', ItemCopperIngot, 'i', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemCopperSword), " x ", " x ", " i ", 'x', ItemCopperIngot, 'i', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemCopperSword), " x ", " i ", " i ", 'x', ItemCopperIngot, 'i', Items.stick);
    }
  
}
	


