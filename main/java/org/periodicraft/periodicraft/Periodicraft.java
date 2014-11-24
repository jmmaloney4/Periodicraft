package org.periodicraft.periodicraft;

import org.periodicraft.periodicraft.block.PeriodicraftOre;
import org.periodicraft.periodicraft.item.PeriodicraftArmor;
import org.periodicraft.periodicraft.item.PeriodicraftAxe;
import org.periodicraft.periodicraft.item.PeriodicraftEntityBullet;
import org.periodicraft.periodicraft.item.PeriodicraftGun;
import org.periodicraft.periodicraft.item.PeriodicraftHoe;
import org.periodicraft.periodicraft.item.PeriodicraftIngot;
import org.periodicraft.periodicraft.item.PeriodicraftItem;
import org.periodicraft.periodicraft.item.PeriodicraftPickaxe;
import org.periodicraft.periodicraft.item.PeriodicraftSpade;
import org.periodicraft.periodicraft.item.PeriodicraftSword;
import org.periodicraft.periodicraft.world.PeriodicraftGenerator;

import scala.tools.nsc.doc.model.Public;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
    
    public static CreativeTabs tabBlocks = new CreativeTabs("PeriodicraftBlocks") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Periodicraft.BlockCopperOre);
        }
    };
    
    public static CreativeTabs tabWeapons = new CreativeTabs("PeriodicraftWeapons") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperSword;
        }
    };
    
    public static CreativeTabs tabTools = new CreativeTabs("PeriodicraftTools") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperPickaxe;
        }
    };
    
    public static CreativeTabs tabMaterials = new CreativeTabs("PeriodicraftMaterials") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperIngot;
        }
    };
    
    public static CreativeTabs tabArmor = new CreativeTabs("PeriodicraftArmor") {
        @Override
        public Item getTabIconItem() {
            return Periodicraft.ItemCopperHelmet;
        }
    };
    
    // World Gen
    public static PeriodicraftGenerator Generator;
    
    //=========================================================================================================================================
    //COPPER
    public static Block BlockCopperOre;
    public static ToolMaterial ToolMaterialCopper;
    public static Item ItemCopperIngot;
    public static Item ItemCopperPickaxe;
    public static Item ItemCopperSword;
    public static Item ItemCopperSpade;
    public static Item ItemCopperAxe;
    public static Item ItemCopperHoe;
    public static ArmorMaterial ArmorMaterialCopper;
    public static Item ItemCopperHelmet;
    public static Item ItemCopperChestplate;
    public static Item ItemCopperLeggings;
    public static Item ItemCopperBoots;
    
    //BONE
    public static ToolMaterial ToolMaterialBone;
    public static Item ItemBoneSword;
    public static Item ItemBoneAxe;
    
    
    //Blazing BONE
    public static ToolMaterial ToolMaterialBlazingBone;
    public static Item ItemBlazingBoneShard;
    public static Item ItemBlazingBoneSword;
    
    //BLAZING
    public static ToolMaterial ToolMaterialBlazing;
    public static ArmorMaterial ArmorMaterialBlazing;
    public static Item ItemBlazingIngot;
    public static Block BlockBlazingOre;
    public static Item ItemBlazingHelmet;
    public static Item ItemBlazingChestplate;
    public static Item ItemBlazingLeggings;
    public static Item ItemBlazingBoots;
    public static Item ItemBlazingSword;
    public static Item ItemBlazingAxe;
    public static Item ItemBlazingPickaxe;
    
    
    //EMERALD
    public static ToolMaterial ToolMaterialEmerald;
    public static ArmorMaterial ArmorMaterialEmerald; 
    public static Item ItemEmeraldSword;
    public static Item ItemEmeraldPickaxe;
    public static Item ItemEmeraldSpade;
    public static Item ItemEmeraldAxe;
    public static Item ItemEmeraldHoe;
    public static Item ItemEmeraldHelmet;
    public static Item ItemEmeraldChestplate;
    public static Item ItemEmeraldLeggings;
    public static Item ItemEmeraldBoots;
    public static Item ItemEmeraldChunk;
    public static Item ItemEmeraldShard;
    
    //OBSIDIAN
    public static ToolMaterial ToolMaterialObsidian;
    public static ArmorMaterial ArmorMaterialObsidian;
    public static Item ItemObsidianSword;
    public static Item ItemObsidianChunk;
    public static Item ItemObsidianPickaxe;
    public static Item ItemObsidianSpade;
    public static Item ItemObsidianAxe;
    public static Item ItemObsidianHoe;
    public static Item ItemObsidianHelmet;
    public static Item ItemObsidianChestplate;
    public static Item ItemObsidianleggings;
    public static Item ItemObsidianBoots;
    public static Item ItemObsidianShard;
    
    //TITIANUM
    public static ToolMaterial ToolMaterialTitianum;
    public static ArmorMaterial ArmorMaterialTitianum;
    public static Block BlockTitianumOre;
    public static Item ItemTitanumIngot;
    public static Item ItemTitianumPickaxe;
    public static Item ItemTitianumHelmet; 
    
    //GUNS
    public static Item ItemAKGun;
    public static Item ItemM4A1Gun;
    public static Item ItemUZIGun;
    public static Item ItemHunterRifelGun;
    
    
    
    
    //=========================================================================================================================================
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	Periodicraft.Generator = new PeriodicraftGenerator();
    	
    	//OBSIDIAN
    	ToolMaterialObsidian = EnumHelper.addToolMaterial("Obsidian", 2, 200, 14.0F, 4.7F, 25);
    	ArmorMaterialObsidian = EnumHelper.addArmorMaterial("Obsidian", 15, new int[] {2, 5, 4, 2}, 25);
    	ItemObsidianShard = new PeriodicraftItem("ObsidianShard", tabMaterials);
    	ItemObsidianChunk = new PeriodicraftItem("ObsidianChunk", tabMaterials);
    	ItemObsidianSword = new PeriodicraftSword(ToolMaterialObsidian, "ObsidianSword", tabWeapons, ItemObsidianChunk);
        ItemObsidianPickaxe = new PeriodicraftPickaxe(ToolMaterialObsidian, "ObsidainPickaxe", tabTools, ItemObsidianChunk);
        
        //BONE
        ToolMaterialBone = EnumHelper.addToolMaterial("Bone", 1, 100, 14.0F, 3.0F, 35);
        ItemBoneSword = new PeriodicraftSword(ToolMaterialBone, "BoneSword", tabWeapons);
        
        //Blazing
        ToolMaterialBlazing = EnumHelper.addToolMaterial("Blazing", 2, 300, 5.3F, 3.0F, 27);
        ArmorMaterialBlazing = EnumHelper.addArmorMaterial("Blazing", 15, new int[] {3, 6, 5, 3}, 27);
        BlockBlazingOre = new PeriodicraftOre(Material.rock, 4.0F, 2.9F, Block.soundTypeStone, "BlazeingOre", tabBlocks, 1, ItemBlazingIngot, 2.6F);
        Generator.addBlockNether(BlockBlazingOre, 100, 5, 10);
        ItemBlazingIngot = new PeriodicraftIngot("BlazingIngot", tabMaterials);
        ItemBlazingSword = new PeriodicraftSword(ToolMaterialBlazing, "BlazingSword", tabArmor);
        ItemBlazingHelmet = new PeriodicraftArmor(ArmorMaterialBlazing, 0, "BlazingHelmet", tabArmor);
        ItemBlazingChestplate = new PeriodicraftArmor(ArmorMaterialBlazing, 1, "BlazingChestplate", tabArmor);
        ItemBlazingLeggings = new PeriodicraftArmor(ArmorMaterialBlazing, 2, "BlazingLeggings", tabArmor);
        ItemBlazingBoots = new PeriodicraftArmor(ArmorMaterialBlazing, 3, "BlazingBoots", tabArmor);
        ItemBlazingPickaxe = new PeriodicraftPickaxe(ToolMaterialBlazing, "BlazingPickaxe", tabTools, ItemBlazingIngot);
        
        
        
        
        //Blazing BONE
        ToolMaterialBlazingBone = EnumHelper.addToolMaterial("BlazingBone", 2, 125, 14.0F, 4.9F, 35);
        ItemBlazingBoneSword = new PeriodicraftSword(ToolMaterialBlazingBone, "BlazingBoneSword", tabWeapons);
        
    	//EMERALD
    	ToolMaterialEmerald = EnumHelper.addToolMaterial("Emerald", 4, 2000, 10.0F, 4.4F, 15);
    	ArmorMaterialEmerald = EnumHelper.addArmorMaterial("Emerald", 37, new int[] {7, 10, 7, 4}, 15);
    	ItemEmeraldShard = new PeriodicraftItem("EmeraldShard", tabMaterials);
    	ItemEmeraldChunk = new PeriodicraftItem("EmeraldChunk", tabMaterials);
        ItemEmeraldSword = new PeriodicraftSword(ToolMaterialEmerald, "EmeraldSword", tabWeapons, ItemEmeraldChunk);
        ItemEmeraldSpade = new PeriodicraftSpade(ToolMaterialEmerald, "EmeraldSpade", tabTools, ItemEmeraldChunk);
        //ItemEmerald
        ItemEmeraldHelmet = new PeriodicraftArmor(ArmorMaterialEmerald, 0, "EmeraldHelmet", tabArmor);
        ItemEmeraldChestplate = new PeriodicraftArmor(ArmorMaterialEmerald, 1, "EmeraldChestplate", tabArmor);
        ItemEmeraldLeggings = new PeriodicraftArmor(ArmorMaterialEmerald, 2, "EmeraldLeggings", tabArmor);
        ItemEmeraldBoots = new PeriodicraftArmor(ArmorMaterialEmerald, 3, "EmeraldBoots", tabArmor);
        
    	// COPPER
    	ToolMaterialCopper = EnumHelper.addToolMaterial("Copper", 2, 175, 5.2F, 1.6F, 10);
    	ArmorMaterialCopper = EnumHelper.addArmorMaterial("Copper", 13, new int[] {2, 5, 5, 2}, 10);
    	ItemCopperIngot = new PeriodicraftIngot("CopperIngot", tabMaterials);
    	BlockCopperOre = new PeriodicraftOre(Material.rock, 4.0F, 2.2F, Block.soundTypeStone, "CopperOre", tabBlocks, 1, ItemCopperIngot, 2.6F);
    	Generator.addBlockSurface(BlockCopperOre, 60, 7, 27);
    	ItemCopperPickaxe = new PeriodicraftPickaxe(ToolMaterialCopper, "CopperPickaxe", tabTools, ItemCopperIngot);
    	ItemCopperSword = new PeriodicraftSword(ToolMaterialCopper, "CopperSword", tabWeapons, ItemCopperIngot);
    	ItemCopperSpade = new PeriodicraftSpade(ToolMaterialCopper, "CopperSpade", tabTools, ItemCopperIngot);
    	ItemCopperAxe = new PeriodicraftAxe(ToolMaterialCopper, "CopperAxe", tabTools, ItemCopperIngot);
    	ItemCopperHoe = new PeriodicraftHoe(ToolMaterialCopper, "CopperHoe", tabTools, ItemCopperIngot);
    	ItemCopperHelmet = new PeriodicraftArmor(ArmorMaterialCopper, 0, "CopperHelmet", tabArmor);
    	ItemCopperChestplate = new PeriodicraftArmor(ArmorMaterialCopper, 1, "CopperChestplate", tabArmor);
    	ItemCopperLeggings = new PeriodicraftArmor(ArmorMaterialCopper, 2, "CopperLeggings", tabArmor);
    	ItemCopperBoots = new PeriodicraftArmor(ArmorMaterialCopper, 3, "CopperBoots", tabArmor);
    	
    	GameRegistry.addShapedRecipe(new ItemStack(ItemEmeraldShard), "xxx", "xxx", "xxx", 'x', Items.emerald);
    	GameRegistry.addSmelting(ItemEmeraldShard, new ItemStack(ItemEmeraldChunk), 4.0F);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemObsidianShard), "xxx", "xxx", "xxx", 'x', Blocks.obsidian);
    	GameRegistry.addSmelting(ItemObsidianShard, new ItemStack(ItemObsidianChunk),  3.0F);
    	GameRegistry.addShapedRecipe(new ItemStack(ItemBlazingBoneSword), "xix", "xix", " y ", 'x', ItemBlazingIngot, 'i', Items.bone, 'y', Items.blaze_rod);
    	
    	ItemAKGun = new PeriodicraftGun("AK-47", tabWeapons, PeriodicraftEntityBullet.class);
    	ItemM4A1Gun = new PeriodicraftGun("M4A1", tabWeapons, PeriodicraftEntityBullet.class);
    	ItemUZIGun = new PeriodicraftGun("UZI", tabWeapons, PeriodicraftEntityBullet.class);
    	ItemHunterRifelGun = new PeriodicraftGun("HunterRifel", tabWeapons, PeriodicraftEntityBullet.class);
    	
    	
    	
    	
    	
    	
    }
  
}
	


