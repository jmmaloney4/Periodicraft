package org.periodicraft.periodicraft;

import org.periodicraft.periodicraft.block.PeriodicraftOre;
import org.periodicraft.periodicraft.item.PeriodicraftIngot;
import org.periodicraft.periodicraft.item.PeriodicraftPickaxe;

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
    
    public static Block BlockCopperOre;
    
    public static ToolMaterial ToolMaterialCopper;
    
    public static Item ItemCopperIngot;
    public static Item ItemCopperPickaxe;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ToolMaterialCopper = EnumHelper.addToolMaterial("Copper", 2, 175, 3.8F, 1.6F, 10);
    	
    	BlockCopperOre = new PeriodicraftOre(Material.rock, 4.0F, 2.2F, Block.soundTypeStone, "CopperOre", CreativeTabs.tabBlock, 2);
    	ItemCopperIngot = new PeriodicraftIngot("CopperIngot", CreativeTabs.tabMaterials);
    	ItemCopperPickaxe = new PeriodicraftPickaxe(ToolMaterialCopper, "CopperPickaxe", CreativeTabs.tabTools);
    	
    	GameRegistry.addSmelting(Periodicraft.BlockCopperOre, new ItemStack(Periodicraft.ItemCopperIngot), 2.6F);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemCopperPickaxe), "xxx", " i ", " i ", 'x', ItemCopperIngot, 'i', Items.stick);
    }
  
}
	


