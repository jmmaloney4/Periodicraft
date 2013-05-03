package net.minecraft.item;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.stats.StatList;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.IArmorTextureProvider;

public class Item
{
    private CreativeTabs tabToDisplayOn = null;

    /** The RNG used by the Item subclasses. */
    protected static Random itemRand = new Random();

    /** A 32000 elements Item array. */
    public static Item[] itemsList = new Item[32000];
    public static Item shovelIron = (new ItemSpade(0, EnumToolMaterial.IRON)).setUnlocalizedName("shovelIron");
    public static Item pickaxeIron = (new ItemPickaxe(1, EnumToolMaterial.IRON)).setUnlocalizedName("pickaxeIron");
    public static Item axeIron = (new ItemAxe(2, EnumToolMaterial.IRON)).setUnlocalizedName("hatchetIron");
    public static Item flintAndSteel = (new ItemFlintAndSteel(3)).setUnlocalizedName("flintAndSteel");
    public static Item appleRed = (new ItemFood(4, 4, 0.3F, false)).setUnlocalizedName("apple");
    public static ItemBow bow = (ItemBow)(new ItemBow(5)).setUnlocalizedName("bow");
    public static Item arrow = (new Item(6)).setUnlocalizedName("arrow").setCreativeTab(CreativeTabs.tabCombat);
    public static Item coal = (new ItemCoal(7)).setUnlocalizedName("coal");
    public static Item diamond = (new Item(8)).setUnlocalizedName("diamond").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item ingotIron = (new Item(9)).setUnlocalizedName("ingotIron").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item ingotGold = (new Item(10)).setUnlocalizedName("ingotGold").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item swordIron = (new ItemSword(11, EnumToolMaterial.IRON)).setUnlocalizedName("swordIron");
    public static Item swordWood = (new ItemSword(12, EnumToolMaterial.WOOD)).setUnlocalizedName("swordWood");
    public static Item shovelWood = (new ItemSpade(13, EnumToolMaterial.WOOD)).setUnlocalizedName("shovelWood");
    public static Item pickaxeWood = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).setUnlocalizedName("pickaxeWood");
    public static Item axeWood = (new ItemAxe(15, EnumToolMaterial.WOOD)).setUnlocalizedName("hatchetWood");
    public static Item swordStone = (new ItemSword(16, EnumToolMaterial.STONE)).setUnlocalizedName("swordStone");
    public static Item shovelStone = (new ItemSpade(17, EnumToolMaterial.STONE)).setUnlocalizedName("shovelStone");
    public static Item pickaxeStone = (new ItemPickaxe(18, EnumToolMaterial.STONE)).setUnlocalizedName("pickaxeStone");
    public static Item axeStone = (new ItemAxe(19, EnumToolMaterial.STONE)).setUnlocalizedName("hatchetStone");
    public static Item swordDiamond = (new ItemSword(20, EnumToolMaterial.EMERALD)).setUnlocalizedName("swordDiamond");
    public static Item shovelDiamond = (new ItemSpade(21, EnumToolMaterial.EMERALD)).setUnlocalizedName("shovelDiamond");
    public static Item pickaxeDiamond = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).setUnlocalizedName("pickaxeDiamond");
    public static Item axeDiamond = (new ItemAxe(23, EnumToolMaterial.EMERALD)).setUnlocalizedName("hatchetDiamond");
    public static Item stick = (new Item(24)).setFull3D().setUnlocalizedName("stick").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item bowlEmpty = (new Item(25)).setUnlocalizedName("bowl").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item bowlSoup = (new ItemSoup(26, 6)).setUnlocalizedName("mushroomStew");
    public static Item swordGold = (new ItemSword(27, EnumToolMaterial.GOLD)).setUnlocalizedName("swordGold");
    public static Item shovelGold = (new ItemSpade(28, EnumToolMaterial.GOLD)).setUnlocalizedName("shovelGold");
    public static Item pickaxeGold = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).setUnlocalizedName("pickaxeGold");
    public static Item axeGold = (new ItemAxe(30, EnumToolMaterial.GOLD)).setUnlocalizedName("hatchetGold");
    public static Item silk = (new ItemReed(31, Block.tripWire)).setUnlocalizedName("string").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item feather = (new Item(32)).setUnlocalizedName("feather").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item gunpowder = (new Item(33)).setUnlocalizedName("sulphur").setPotionEffect(PotionHelper.gunpowderEffect).setCreativeTab(CreativeTabs.tabMaterials);
    public static Item hoeWood = (new ItemHoe(34, EnumToolMaterial.WOOD)).setUnlocalizedName("hoeWood");
    public static Item hoeStone = (new ItemHoe(35, EnumToolMaterial.STONE)).setUnlocalizedName("hoeStone");
    public static Item hoeIron = (new ItemHoe(36, EnumToolMaterial.IRON)).setUnlocalizedName("hoeIron");
    public static Item hoeDiamond = (new ItemHoe(37, EnumToolMaterial.EMERALD)).setUnlocalizedName("hoeDiamond");
    public static Item hoeGold = (new ItemHoe(38, EnumToolMaterial.GOLD)).setUnlocalizedName("hoeGold");
    public static Item seeds = (new ItemSeeds(39, Block.crops.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds");
    public static Item wheat = (new Item(40)).setUnlocalizedName("wheat").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item bread = (new ItemFood(41, 5, 0.6F, false)).setUnlocalizedName("bread");
    public static ItemArmor helmetLeather = (ItemArmor)(new ItemArmor(42, EnumArmorMaterial.CLOTH, 0, 0)).setUnlocalizedName("helmetCloth");
    public static ItemArmor plateLeather = (ItemArmor)(new ItemArmor(43, EnumArmorMaterial.CLOTH, 0, 1)).setUnlocalizedName("chestplateCloth");
    public static ItemArmor legsLeather = (ItemArmor)(new ItemArmor(44, EnumArmorMaterial.CLOTH, 0, 2)).setUnlocalizedName("leggingsCloth");
    public static ItemArmor bootsLeather = (ItemArmor)(new ItemArmor(45, EnumArmorMaterial.CLOTH, 0, 3)).setUnlocalizedName("bootsCloth");
    public static ItemArmor helmetChain = (ItemArmor)(new ItemArmor(46, EnumArmorMaterial.CHAIN, 1, 0)).setUnlocalizedName("helmetChain");
    public static ItemArmor plateChain = (ItemArmor)(new ItemArmor(47, EnumArmorMaterial.CHAIN, 1, 1)).setUnlocalizedName("chestplateChain");
    public static ItemArmor legsChain = (ItemArmor)(new ItemArmor(48, EnumArmorMaterial.CHAIN, 1, 2)).setUnlocalizedName("leggingsChain");
    public static ItemArmor bootsChain = (ItemArmor)(new ItemArmor(49, EnumArmorMaterial.CHAIN, 1, 3)).setUnlocalizedName("bootsChain");
    public static ItemArmor helmetIron = (ItemArmor)(new ItemArmor(50, EnumArmorMaterial.IRON, 2, 0)).setUnlocalizedName("helmetIron");
    public static ItemArmor plateIron = (ItemArmor)(new ItemArmor(51, EnumArmorMaterial.IRON, 2, 1)).setUnlocalizedName("chestplateIron");
    public static ItemArmor legsIron = (ItemArmor)(new ItemArmor(52, EnumArmorMaterial.IRON, 2, 2)).setUnlocalizedName("leggingsIron");
    public static ItemArmor bootsIron = (ItemArmor)(new ItemArmor(53, EnumArmorMaterial.IRON, 2, 3)).setUnlocalizedName("bootsIron");
    public static ItemArmor helmetDiamond = (ItemArmor)(new ItemArmor(54, EnumArmorMaterial.DIAMOND, 3, 0)).setUnlocalizedName("helmetDiamond");
    public static ItemArmor plateDiamond = (ItemArmor)(new ItemArmor(55, EnumArmorMaterial.DIAMOND, 3, 1)).setUnlocalizedName("chestplateDiamond");
    public static ItemArmor legsDiamond = (ItemArmor)(new ItemArmor(56, EnumArmorMaterial.DIAMOND, 3, 2)).setUnlocalizedName("leggingsDiamond");
    public static ItemArmor bootsDiamond = (ItemArmor)(new ItemArmor(57, EnumArmorMaterial.DIAMOND, 3, 3)).setUnlocalizedName("bootsDiamond");
    public static ItemArmor helmetGold = (ItemArmor)(new ItemArmor(58, EnumArmorMaterial.GOLD, 4, 0)).setUnlocalizedName("helmetGold");
    public static ItemArmor plateGold = (ItemArmor)(new ItemArmor(59, EnumArmorMaterial.GOLD, 4, 1)).setUnlocalizedName("chestplateGold");
    public static ItemArmor legsGold = (ItemArmor)(new ItemArmor(60, EnumArmorMaterial.GOLD, 4, 2)).setUnlocalizedName("leggingsGold");
    public static ItemArmor bootsGold = (ItemArmor)(new ItemArmor(61, EnumArmorMaterial.GOLD, 4, 3)).setUnlocalizedName("bootsGold");
    public static Item flint = (new Item(62)).setUnlocalizedName("flint").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item porkRaw = (new ItemFood(63, 3, 0.3F, true)).setUnlocalizedName("porkchopRaw");
    public static Item porkCooked = (new ItemFood(64, 8, 0.8F, true)).setUnlocalizedName("porkchopCooked");
    public static Item painting = (new ItemHangingEntity(65, EntityPainting.class)).setUnlocalizedName("painting");
    public static Item appleGold = (new ItemAppleGold(66, 4, 1.2F, false)).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F).setUnlocalizedName("appleGold");
    public static Item sign = (new ItemSign(67)).setUnlocalizedName("sign");
    public static Item doorWood = (new ItemDoor(68, Material.wood)).setUnlocalizedName("doorWood");
    public static Item bucketEmpty = (new ItemBucket(69, 0)).setUnlocalizedName("bucket").setMaxStackSize(16);
    public static Item bucketWater = (new ItemBucket(70, Block.waterMoving.blockID)).setUnlocalizedName("bucketWater").setContainerItem(bucketEmpty);
    public static Item bucketLava = (new ItemBucket(71, Block.lavaMoving.blockID)).setUnlocalizedName("bucketLava").setContainerItem(bucketEmpty);
    public static Item minecartEmpty = (new ItemMinecart(72, 0)).setUnlocalizedName("minecart");
    public static Item saddle = (new ItemSaddle(73)).setUnlocalizedName("saddle");
    public static Item doorIron = (new ItemDoor(74, Material.iron)).setUnlocalizedName("doorIron");
    public static Item redstone = (new ItemRedstone(75)).setUnlocalizedName("redstone").setPotionEffect(PotionHelper.redstoneEffect);
    public static Item snowball = (new ItemSnowball(76)).setUnlocalizedName("snowball");
    public static Item boat = (new ItemBoat(77)).setUnlocalizedName("boat");
    public static Item leather = (new Item(78)).setUnlocalizedName("leather").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item bucketMilk = (new ItemBucketMilk(79)).setUnlocalizedName("milk").setContainerItem(bucketEmpty);
    public static Item brick = (new Item(80)).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item clay = (new Item(81)).setUnlocalizedName("clay").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item reed = (new ItemReed(82, Block.reed)).setUnlocalizedName("reeds").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item paper = (new Item(83)).setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc);
    public static Item book = (new ItemBook(84)).setUnlocalizedName("book").setCreativeTab(CreativeTabs.tabMisc);
    public static Item slimeBall = (new Item(85)).setUnlocalizedName("slimeball").setCreativeTab(CreativeTabs.tabMisc);
    public static Item minecartCrate = (new ItemMinecart(86, 1)).setUnlocalizedName("minecartChest");
    public static Item minecartPowered = (new ItemMinecart(87, 2)).setUnlocalizedName("minecartFurnace");
    public static Item egg = (new ItemEgg(88)).setUnlocalizedName("egg");
    public static Item compass = (new Item(89)).setUnlocalizedName("compass").setCreativeTab(CreativeTabs.tabTools);
    public static ItemFishingRod fishingRod = (ItemFishingRod)(new ItemFishingRod(90)).setUnlocalizedName("fishingRod");
    public static Item pocketSundial = (new Item(91)).setUnlocalizedName("clock").setCreativeTab(CreativeTabs.tabTools);
    public static Item lightStoneDust = (new Item(92)).setUnlocalizedName("yellowDust").setPotionEffect(PotionHelper.glowstoneEffect).setCreativeTab(CreativeTabs.tabMaterials);
    public static Item fishRaw = (new ItemFood(93, 2, 0.3F, false)).setUnlocalizedName("fishRaw");
    public static Item fishCooked = (new ItemFood(94, 5, 0.6F, false)).setUnlocalizedName("fishCooked");
    public static Item dyePowder = (new ItemDye(95)).setUnlocalizedName("dyePowder");
    public static Item bone = (new Item(96)).setUnlocalizedName("bone").setFull3D().setCreativeTab(CreativeTabs.tabMisc);
    public static Item sugar = (new Item(97)).setUnlocalizedName("sugar").setPotionEffect(PotionHelper.sugarEffect).setCreativeTab(CreativeTabs.tabMaterials);
    public static Item cake = (new ItemReed(98, Block.cake)).setMaxStackSize(1).setUnlocalizedName("cake").setCreativeTab(CreativeTabs.tabFood);
    public static Item bed = (new ItemBed(99)).setMaxStackSize(1).setUnlocalizedName("bed");
    public static Item redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle)).setUnlocalizedName("diode").setCreativeTab(CreativeTabs.tabRedstone);
    public static Item cookie = (new ItemFood(101, 2, 0.1F, false)).setUnlocalizedName("cookie");
    public static ItemMap map = (ItemMap)(new ItemMap(102)).setUnlocalizedName("map");

    /**
     * Item introduced on 1.7 version, is a shear to cut leaves (you can keep the block) or get wool from sheeps.
     */
    public static ItemShears shears = (ItemShears)(new ItemShears(103)).setUnlocalizedName("shears");
    public static Item melon = (new ItemFood(104, 2, 0.3F, false)).setUnlocalizedName("melon");
    public static Item pumpkinSeeds = (new ItemSeeds(105, Block.pumpkinStem.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds_pumpkin");
    public static Item melonSeeds = (new ItemSeeds(106, Block.melonStem.blockID, Block.tilledField.blockID)).setUnlocalizedName("seeds_melon");
    public static Item beefRaw = (new ItemFood(107, 3, 0.3F, true)).setUnlocalizedName("beefRaw");
    public static Item beefCooked = (new ItemFood(108, 8, 0.8F, true)).setUnlocalizedName("beefCooked");
    public static Item chickenRaw = (new ItemFood(109, 2, 0.3F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName("chickenRaw");
    public static Item chickenCooked = (new ItemFood(110, 6, 0.6F, true)).setUnlocalizedName("chickenCooked");
    public static Item rottenFlesh = (new ItemFood(111, 4, 0.1F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setUnlocalizedName("rottenFlesh");
    public static Item enderPearl = (new ItemEnderPearl(112)).setUnlocalizedName("enderPearl");
    public static Item blazeRod = (new Item(113)).setUnlocalizedName("blazeRod").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item ghastTear = (new Item(114)).setUnlocalizedName("ghastTear").setPotionEffect(PotionHelper.ghastTearEffect).setCreativeTab(CreativeTabs.tabBrewing);
    public static Item goldNugget = (new Item(115)).setUnlocalizedName("goldNugget").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item netherStalkSeeds = (new ItemSeeds(116, Block.netherStalk.blockID, Block.slowSand.blockID)).setUnlocalizedName("netherStalkSeeds").setPotionEffect("+4");
    public static ItemPotion potion = (ItemPotion)(new ItemPotion(117)).setUnlocalizedName("potion");
    public static Item glassBottle = (new ItemGlassBottle(118)).setUnlocalizedName("glassBottle");
    public static Item spiderEye = (new ItemFood(119, 2, 0.8F, false)).setPotionEffect(Potion.poison.id, 5, 0, 1.0F).setUnlocalizedName("spiderEye").setPotionEffect(PotionHelper.spiderEyeEffect);
    public static Item fermentedSpiderEye = (new Item(120)).setUnlocalizedName("fermentedSpiderEye").setPotionEffect(PotionHelper.fermentedSpiderEyeEffect).setCreativeTab(CreativeTabs.tabBrewing);
    public static Item blazePowder = (new Item(121)).setUnlocalizedName("blazePowder").setPotionEffect(PotionHelper.blazePowderEffect).setCreativeTab(CreativeTabs.tabBrewing);
    public static Item magmaCream = (new Item(122)).setUnlocalizedName("magmaCream").setPotionEffect(PotionHelper.magmaCreamEffect).setCreativeTab(CreativeTabs.tabBrewing);
    public static Item brewingStand = (new ItemReed(123, Block.brewingStand)).setUnlocalizedName("brewingStand").setCreativeTab(CreativeTabs.tabBrewing);
    public static Item cauldron = (new ItemReed(124, Block.cauldron)).setUnlocalizedName("cauldron").setCreativeTab(CreativeTabs.tabBrewing);
    public static Item eyeOfEnder = (new ItemEnderEye(125)).setUnlocalizedName("eyeOfEnder");
    public static Item speckledMelon = (new Item(126)).setUnlocalizedName("speckledMelon").setPotionEffect(PotionHelper.speckledMelonEffect).setCreativeTab(CreativeTabs.tabBrewing);
    public static Item monsterPlacer = (new ItemMonsterPlacer(127)).setUnlocalizedName("monsterPlacer");

    /**
     * Bottle o' Enchanting. Drops between 1 and 3 experience orbs when thrown.
     */
    public static Item expBottle = (new ItemExpBottle(128)).setUnlocalizedName("expBottle");

    /**
     * Fire Charge. When used in a dispenser it fires a fireball similiar to a Ghast's.
     */
    public static Item fireballCharge = (new ItemFireball(129)).setUnlocalizedName("fireball");
    public static Item writableBook = (new ItemWritableBook(130)).setUnlocalizedName("writingBook").setCreativeTab(CreativeTabs.tabMisc);
    public static Item writtenBook = (new ItemEditableBook(131)).setUnlocalizedName("writtenBook");
    public static Item emerald = (new Item(132)).setUnlocalizedName("emerald").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item itemFrame = (new ItemHangingEntity(133, EntityItemFrame.class)).setUnlocalizedName("frame");
    public static Item flowerPot = (new ItemReed(134, Block.flowerPot)).setUnlocalizedName("flowerPot").setCreativeTab(CreativeTabs.tabDecorations);
    public static Item carrot = (new ItemSeedFood(135, 4, 0.6F, Block.carrot.blockID, Block.tilledField.blockID)).setUnlocalizedName("carrots");
    public static Item potato = (new ItemSeedFood(136, 1, 0.3F, Block.potato.blockID, Block.tilledField.blockID)).setUnlocalizedName("potato");
    public static Item bakedPotato = (new ItemFood(137, 6, 0.6F, false)).setUnlocalizedName("potatoBaked");
    public static Item poisonousPotato = (new ItemFood(138, 2, 0.3F, false)).setPotionEffect(Potion.poison.id, 5, 0, 0.6F).setUnlocalizedName("potatoPoisonous");
    public static ItemEmptyMap emptyMap = (ItemEmptyMap)(new ItemEmptyMap(139)).setUnlocalizedName("emptyMap");
    public static Item goldenCarrot = (new ItemFood(140, 6, 1.2F, false)).setUnlocalizedName("carrotGolden").setPotionEffect(PotionHelper.goldenCarrotEffect);
    public static Item skull = (new ItemSkull(141)).setUnlocalizedName("skull");
    public static Item carrotOnAStick = (new ItemCarrotOnAStick(142)).setUnlocalizedName("carrotOnAStick");
    public static Item netherStar = (new ItemSimpleFoiled(143)).setUnlocalizedName("netherStar").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item pumpkinPie = (new ItemFood(144, 8, 0.3F, false)).setUnlocalizedName("pumpkinPie").setCreativeTab(CreativeTabs.tabFood);
    public static Item firework = (new ItemFirework(145)).setUnlocalizedName("fireworks");
    public static Item fireworkCharge = (new ItemFireworkCharge(146)).setUnlocalizedName("fireworksCharge").setCreativeTab(CreativeTabs.tabMisc);
    public static ItemEnchantedBook enchantedBook = (ItemEnchantedBook)(new ItemEnchantedBook(147)).setMaxStackSize(1).setUnlocalizedName("enchantedBook");
    public static Item comparator = (new ItemReed(148, Block.redstoneComparatorIdle)).setUnlocalizedName("comparator").setCreativeTab(CreativeTabs.tabRedstone);
    public static Item netherrackBrick = (new Item(149)).setUnlocalizedName("netherbrick").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item netherQuartz = (new Item(150)).setUnlocalizedName("netherquartz").setCreativeTab(CreativeTabs.tabMaterials);
    public static Item tntMinecart = (new ItemMinecart(151, 3)).setUnlocalizedName("minecartTnt");
    public static Item hopperMinecart = (new ItemMinecart(152, 5)).setUnlocalizedName("minecartHopper");
    public static Item record13 = (new ItemRecord(2000, "13")).setUnlocalizedName("record");
    public static Item recordCat = (new ItemRecord(2001, "cat")).setUnlocalizedName("record");
    public static Item recordBlocks = (new ItemRecord(2002, "blocks")).setUnlocalizedName("record");
    public static Item recordChirp = (new ItemRecord(2003, "chirp")).setUnlocalizedName("record");
    public static Item recordFar = (new ItemRecord(2004, "far")).setUnlocalizedName("record");
    public static Item recordMall = (new ItemRecord(2005, "mall")).setUnlocalizedName("record");
    public static Item recordMellohi = (new ItemRecord(2006, "mellohi")).setUnlocalizedName("record");
    public static Item recordStal = (new ItemRecord(2007, "stal")).setUnlocalizedName("record");
    public static Item recordStrad = (new ItemRecord(2008, "strad")).setUnlocalizedName("record");
    public static Item recordWard = (new ItemRecord(2009, "ward")).setUnlocalizedName("record");
    public static Item record11 = (new ItemRecord(2010, "11")).setUnlocalizedName("record");
    public static Item recordWait = (new ItemRecord(2011, "wait")).setUnlocalizedName("record");

    /** The ID of this item. */
    public final int itemID;

    /** Maximum size of the stack. */
    protected int maxStackSize = 64;

    /** Maximum damage an item can handle. */
    private int maxDamage = 0;

    /** If true, render the object in full 3D, like weapons and tools. */
    protected boolean bFull3D = false;

    /**
     * Some items (like dyes) have multiple subtypes on same item, this is field define this behavior
     */
    protected boolean hasSubtypes = false;
    private Item containerItem = null;
    private String potionEffect = null;

    /** The unlocalized name of this item. */
    private String unlocalizedName;
    @SideOnly(Side.CLIENT)

    /** Icon index in the icons table. */
    protected Icon itemIcon;

    /** FORGE: To disable repair recipes. */
    protected boolean canRepair = true;

    public Item(int par1)
    {
        this.itemID = 256 + par1;

        if (itemsList[256 + par1] != null)
        {
            System.out.println("CONFLICT @ " + par1 + " item slot already occupied by " + itemsList[256 + par1] + " while adding " + this);
        }

        itemsList[256 + par1] = this;

        GameData.newItemAdded(this);
    }

    public Item setMaxStackSize(int par1)
    {
        this.maxStackSize = par1;
        return this;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns 0 for /terrain.png, 1 for /gui/items.png
     */
    public int getSpriteNumber()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int par1)
    {
        return this.itemIcon;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the icon index of the stack given as argument.
     */
    public final Icon getIconIndex(ItemStack par1ItemStack)
    {
        return this.getIconFromDamage(par1ItemStack.getItemDamage());
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return 1.0F;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * Returns the maximum size of the stack for a specific item. *Isn't this more a Set than a Get?*
     */
    public int getItemStackLimit()
    {
        return this.maxStackSize;
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return 0;
    }

    public boolean getHasSubtypes()
    {
        return this.hasSubtypes;
    }

    protected Item setHasSubtypes(boolean par1)
    {
        this.hasSubtypes = par1;
        return this;
    }

    /**
     * Returns the maximum damage an item can take.
     */
    public int getMaxDamage()
    {
        return this.maxDamage;
    }

    /**
     * set max damage of an Item
     */
    public Item setMaxDamage(int par1)
    {
        this.maxDamage = par1;
        return this;
    }

    public boolean isDamageable()
    {
        return this.maxDamage > 0 && !this.hasSubtypes;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        return false;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        return false;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity par1Entity)
    {
        return 1;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return false;
    }

    /**
     * Called when a player right clicks an entity with an item.
     */
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving)
    {
        return false;
    }

    /**
     * Sets bFull3D to True and return the object.
     */
    public Item setFull3D()
    {
        this.bFull3D = true;
        return this;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return this.bFull3D;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    public Item setUnlocalizedName(String par1Str)
    {
        this.unlocalizedName = par1Str;
        return this;
    }

    /**
     * Gets the localized name of the given item stack.
     */
    public String getLocalizedName(ItemStack par1ItemStack)
    {
        String s = this.getUnlocalizedName(par1ItemStack);
        return s == null ? "" : StatCollector.translateToLocal(s);
    }

    /**
     * Returns the unlocalized name of this item.
     */
    public String getUnlocalizedName()
    {
        return "item." + this.unlocalizedName;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return "item." + this.unlocalizedName;
    }

    public Item setContainerItem(Item par1Item)
    {
        this.containerItem = par1Item;
        return this;
    }

    /**
     * If this returns true, after a recipe involving this item is crafted the container item will be added to the
     * player's inventory instead of remaining in the crafting grid.
     */
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return true;
    }

    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    public boolean getShareTag()
    {
        return true;
    }

    public Item getContainerItem()
    {
        return this.containerItem;
    }

    /**
     * True if this Item has a container item (a.k.a. crafting result)
     */
    public boolean hasContainerItem()
    {
        return this.containerItem != null;
    }

    public String getStatName()
    {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
    }

    public String func_77653_i(ItemStack par1ItemStack)
    {
        return StatCollector.translateToLocal(this.getUnlocalizedName(par1ItemStack) + ".name");
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 16777215;
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {}

    /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {}

    /**
     * false for all Items except sub-classes of ItemMapBase
     */
    public boolean isMap()
    {
        return false;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 0;
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {}

    /**
     * Sets the string representing this item's effect on a potion when used as an ingredient.
     */
    public Item setPotionEffect(String par1Str)
    {
        this.potionEffect = par1Str;
        return this;
    }

    /**
     * Returns a string representing what this item does to a potion.
     */
    public String getPotionEffect()
    {
        return this.potionEffect;
    }

    /**
     * Returns true if this item serves as a potion ingredient (its ingredient information is not null).
     */
    public boolean isPotionIngredient()
    {
        return this.potionEffect != null;
    }

    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {}

    public String getItemDisplayName(ItemStack par1ItemStack)
    {
        return ("" + StringTranslate.getInstance().translateNamedKey(this.getLocalizedName(par1ItemStack))).trim();
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return par1ItemStack.isItemEnchanted();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return par1ItemStack.isItemEnchanted() ? EnumRarity.rare : EnumRarity.common;
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return this.getItemStackLimit() == 1 && this.isDamageable();
    }

    protected MovingObjectPosition getMovingObjectPositionFromPlayer(World par1World, EntityPlayer par2EntityPlayer, boolean par3)
    {
        float f = 1.0F;
        float f1 = par2EntityPlayer.prevRotationPitch + (par2EntityPlayer.rotationPitch - par2EntityPlayer.prevRotationPitch) * f;
        float f2 = par2EntityPlayer.prevRotationYaw + (par2EntityPlayer.rotationYaw - par2EntityPlayer.prevRotationYaw) * f;
        double d0 = par2EntityPlayer.prevPosX + (par2EntityPlayer.posX - par2EntityPlayer.prevPosX) * (double)f;
        double d1 = par2EntityPlayer.prevPosY + (par2EntityPlayer.posY - par2EntityPlayer.prevPosY) * (double)f + 1.62D - (double)par2EntityPlayer.yOffset;
        double d2 = par2EntityPlayer.prevPosZ + (par2EntityPlayer.posZ - par2EntityPlayer.prevPosZ) * (double)f;
        Vec3 vec3 = par1World.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = 5.0D;
        if (par2EntityPlayer instanceof EntityPlayerMP)
        {
            d3 = ((EntityPlayerMP)par2EntityPlayer).theItemInWorldManager.getBlockReachDistance();
        }
        Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        return par1World.rayTraceBlocks_do_do(vec3, vec31, par3, !par3);
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public Icon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return this.getIconFromDamage(par1);
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    /**
     * returns this;
     */
    public Item setCreativeTab(CreativeTabs par1CreativeTabs)
    {
        this.tabToDisplayOn = par1CreativeTabs;
        return this;
    }

    @SideOnly(Side.CLIENT)

    /**
     * gets the CreativeTab this item is displayed on
     */
    public CreativeTabs getCreativeTab()
    {
        return this.tabToDisplayOn;
    }

    public boolean func_82788_x()
    {
        return true;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.unlocalizedName);
    }

    static
    {
        StatList.initStats();
    }

    /* =========================================================== FORGE START ===============================================================*/
    /**
     * Called when a player drops the item into the world,
     * returning false from this will prevent the item from
     * being removed from the players inventory and spawning
     * in the world
     *
     * @param player The player that dropped the item
     * @param item The item stack, before the item is removed.
     */
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        return true;
    }

    /**
     * This is called when the item is used, before the block is activated.
     * @param stack The Item Stack
     * @param player The Player that used the item
     * @param world The Current World
     * @param x Target X Position
     * @param y Target Y Position
     * @param z Target Z Position
     * @param side The side of the target hit
     * @return Return true to prevent any further processing.
     */
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    /**
     * Metadata-sensitive version of getStrVsBlock
     * @param itemstack The Item Stack
     * @param block The block the item is trying to break
     * @param metadata The items current metadata
     * @return The damage strength
     */
    public float getStrVsBlock(ItemStack itemstack, Block block, int metadata)
    {
        return getStrVsBlock(itemstack, block);
    }

    /**
     * Called by CraftingManager to determine if an item is reparable.
     * @return True if reparable
     */
    public boolean isRepairable()
    {
        return canRepair && isDamageable();
    }

    /**
     * Call to disable repair recipes.
     * @return The current Item instance
     */
    public Item setNoRepair()
    {
        canRepair = false;
        return this;
    }

    /**
     * Called before a block is broken.  Return true to prevent default block harvesting.
     *
     * Note: In SMP, this is called on both client and server sides!
     *
     * @param itemstack The current ItemStack
     * @param X The X Position
     * @param Y The X Position
     * @param Z The X Position
     * @param player The Player that is wielding the item
     * @return True to prevent harvesting, false to continue as normal
     */
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
    {
        return false;
    }

    /**
     * Called each tick while using an item.
     * @param stack The Item being used
     * @param player The Player using the item
     * @param count The amount of time in tick the item has been used for continuously
     */
    public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
    {
    }

    /**
     * Called when the player Left Clicks (attacks) an entity.
     * Processed before damage is done, if return value is true further processing is canceled
     * and the entity is not attacked.
     *
     * @param stack The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return false;
    }

    /**
     * Player, Render pass, and item usage sensitive version of getIconIndex.
     *
     * @param stack The item stack to get the icon for. (Usually this, and usingItem will be the same if usingItem is not null)
     * @param renderPass The pass to get the icon for, 0 is default.
     * @param player The player holding the item
     * @param usingItem The item the player is actively using. Can be null if not using anything.
     * @param useRemaining The ticks remaining for the active item.
     * @return The icon index
     */
    public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        return getIcon(stack, renderPass);
    }

    /**
     * Returns the number of render passes/layers this item has.
     * Usually equates to ItemRenderer.renderItem being called for this many passes.
     * Does not get called unless requiresMultipleRenderPasses() is true;
     *
     * @param metadata The item's metadata
     * @return The number of passes to run.
     */
    public int getRenderPasses(int metadata)
    {
        return requiresMultipleRenderPasses() ? 2 : 1;
    }

    /**
     * ItemStack sensitive version of getContainerItem.
     * Returns a full ItemStack instance of the result.
     *
     * @param itemStack The current ItemStack
     * @return The resulting ItemStack
     */
    public ItemStack getContainerItemStack(ItemStack itemStack)
    {
        if (!hasContainerItem())
        {
            return null;
        }
        return new ItemStack(getContainerItem());
    }

    /**
     * Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem.
     * This is in ticks, standard result is 6000, or 5 mins.
     *
     * @param itemStack The current ItemStack
     * @param world The world the entity is in
     * @return The normal lifespan in ticks.
     */
    public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return 6000;
    }

    /**
     * Determines if this Item has a special entity for when they are in the world.
     * Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity
     * returns non null, the EntityItem will be destroyed and the new Entity will be added to the world.
     *
     * @param stack The current item stack
     * @return True of the item has a custom entity, If true, Item#createCustomEntity will be called
     */
    public boolean hasCustomEntity(ItemStack stack)
    {
        return false;
    }

    /**
     * This function should return a new entity to replace the dropped item.
     * Returning null here will not kill the EntityItem and will leave it to function normally.
     * Called when the item it placed in a world.
     *
     * @param world The world object
     * @param location The EntityItem object, useful for getting the position of the entity
     * @param itemstack The current item stack
     * @return A new Entity object to spawn or null
     */
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        return null;
    }

    /**
     * Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner 
     * control over the update of the item without having to write a subclass.
     * 
     * @param entityItem The entity Item
     * @return Return true to skip any further update code.
     */
    public boolean onEntityItemUpdate(EntityItem entityItem)
    {
        return false;
    }

    /**
     * Gets a list of tabs that items belonging to this class can display on,
     * combined properly with getSubItems allows for a single item to span
     * many sub-items across many tabs.
     *
     * @return A list of all tabs that this item could possibly be one.
     */
    public CreativeTabs[] getCreativeTabs()
    {
        return new CreativeTabs[]{ getCreativeTab() };
    }

    /**
     * Determines the base experience for a player when they remove this item from a furnace slot.
     * This number must be between 0 and 1 for it to be valid.
     * This number will be multiplied by the stack size to get the total experience.
     *
     * @param item The item stack the player is picking up.
     * @return The amount to award for each item.
     */
    public float getSmeltingExperience(ItemStack item)
    {
        return -1; //-1 will default to the old lookups.
    }

    /**
     * Return the correct icon for rendering based on the supplied ItemStack and render pass.
     *
     * Defers to {@link #getIconFromDamageForRenderPass(int, int)}
     * @param stack to render for
     * @param pass the multi-render pass
     * @return the icon
     */
    public Icon getIcon(ItemStack stack, int pass)
    {
    	return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
    }

    /**
     * Generates the base Random item for a specific instance of the chest gen,
     * Enchanted books use this to pick a random enchantment.
     *
     * @param chest The chest category to generate for
     * @param rnd World RNG
     * @param original Original result registered with the chest gen hooks.
     * @return New values to use as the random item, typically this will be original
     */
    public WeightedRandomChestContent getChestGenBase(ChestGenHooks chest, Random rnd, WeightedRandomChestContent original)
    {
        if (this instanceof ItemEnchantedBook)
        {
            return ((ItemEnchantedBook)this).func_92112_a(rnd,
                    original.theMinimumChanceToGenerateItem,
                    original.theMaximumChanceToGenerateItem, original.itemWeight);
        }
        return original;
    }

    /**
     *
     * Should this item, when held, allow sneak-clicks to pass through to the underlying block?
     *
     * @param par2World
     * @param par4
     * @param par5
     * @param par6
     * @return
     */
    public boolean shouldPassSneakingClickToBlock(World par2World, int par4, int par5, int par6)
    {
        return false;
    }


    /**
     * Called to tick armor in the armor slot. Override to do something
     *
     * @param world
     * @param player
     * @param itemStack
     */
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {

    }

    /**
     * Determines if the specific ItemStack can be placed in the specified armor slot.
     *
     * @param stack The ItemStack
     * @param armorType Armor slot ID: 0: Helmet, 1: Chest, 2: Legs, 3: Boots
     * @return True if the given ItemStack can be inserted in the slot
     */
    public boolean isValidArmor(ItemStack stack, int armorType)
    {
        if (this instanceof ItemArmor)
        {
            return ((ItemArmor)this).armorType == armorType;
        }

        if (armorType == 0)
        {
            return itemID == Block.pumpkin.blockID || itemID == Item.skull.itemID;
        }

        return false;
    }

    /**
     * ItemStack sensitive version of isPotionIngredient
     *
     * @param stack The item stack
     * @return True if this stack can be used as a potion ingredient
     */
    public boolean isPotionIngredient(ItemStack stack)
    {
        return isPotionIngredient();
    }

    /**
     * ItemStack sensitive version of getPotionEffect
     *
     * @param stack The item stack
     * @return A string containing the bit manipulation to apply the the potion.
     */
    public String getPotionEffect(ItemStack stack)
    {
        return getPotionEffect();
    }

    /**
     * Allow or forbid the specific book/item combination as an anvil enchant
     *
     * @param itemstack1 The item
     * @param itemstack2 The book
     * @return if the enchantment is allowed
     */
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return true;
    }

    /**
     * An itemstack sensitive version of getDamageVsEntity - allows items to handle damage based on
     * itemstack data, like tags. Falls back to getDamageVsEntity.
     *
     * @param par1Entity The entity being attacked (or the attacking mob, if it's a mob - vanilla bug?)
     * @param itemStack The itemstack
     * @return the damage
     */
    public int getDamageVsEntity(Entity par1Entity, ItemStack itemStack)
    {
        return getDamageVsEntity(par1Entity);
    }

    @Deprecated private final boolean isArmorProvider = this instanceof IArmorTextureProvider;
    /**
     * Called by RenderBiped and RenderPlayer to determine the armor texture that 
     * should be use for the currently equiped item.
     * This will only be called on instances of ItemArmor. 
     * 
     * Returning null from this function will use the default value.
     * 
     * @param stack ItemStack for the equpt armor
     * @param entity The entity wearing the armor
     * @param slot The slot the armor is in
     * @param layer The render layer, either 1 or 2, 2 is only used for CLOTH armor by default
     * @return Path of texture to bind, or null to use default
     */
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        return isArmorProvider ? ((IArmorTextureProvider)this).getArmorTextureFile(stack) : null;
    }

    /**
     * Returns the font renderer used to render tooltips and overlays for this item.
     * Returning null will use the standard font renderer.
     * 
     * @param stack The current item stack
     * @return A instance of FontRenderer or null to use default
     */
    @SideOnly(Side.CLIENT)
    public FontRenderer getFontRenderer(ItemStack stack)
    {
        return null;
    }

    /**
     * Override this method to have an item handle its own armor rendering.
     * 
     * @param  entityLiving  The entity wearing the armor 
     * @param  itemStack  The itemStack to render the model of 
     * @param  armorSlot  0=head, 1=torso, 2=legs, 3=feet
     * 
     * @return  A ModelBiped to render instead of the default
     */
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLiving entityLiving, ItemStack itemStack, int armorSlot)
    {
        return null;
    }

    /**
     * Called when a entity tries to play the 'swing' animation.
     *  
     * @param entityLiving The entity swinging the item.
     * @param stack The Item stack
     * @return True to cancel any further processing by EntityLiving 
     */
    public boolean onEntitySwing(EntityLiving entityLiving, ItemStack stack)
    {
        return false;
    }

    /**
     * Called when the client starts rendering the HUD, for whatever item the player currently has as a helmet. 
     * This is where pumpkins would render there overlay.
     *  
     * @param stack The ItemStack that is equipped
     * @param player Reference to the current client entity
     * @param resolution Resolution information about the current viewport and configured GUI Scale
     * @param partialTicks Partial ticks for the renderer, useful for interpolation
     * @param hasScreen If the player has a screen up, which will be rendered after this.
     * @param mouseX Mouse's X position on screen
     * @param mouseY Mouse's Y position on screen
     */
    @SideOnly(Side.CLIENT)
    public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY){}
}
