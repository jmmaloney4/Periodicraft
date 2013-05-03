package net.minecraft.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityList {

   public static Map field_75625_b = new HashMap();
   public static Map field_75626_c = new HashMap();
   public static Map field_75623_d = new HashMap();
   private static Map field_75624_e = new HashMap();
   private static Map field_75622_f = new HashMap();
   public static HashMap field_75627_a = new LinkedHashMap();


   public static void func_75618_a(Class p_75618_0_, String p_75618_1_, int p_75618_2_) {
      field_75625_b.put(p_75618_1_, p_75618_0_);
      field_75626_c.put(p_75618_0_, p_75618_1_);
      field_75623_d.put(Integer.valueOf(p_75618_2_), p_75618_0_);
      field_75624_e.put(p_75618_0_, Integer.valueOf(p_75618_2_));
      field_75622_f.put(p_75618_1_, Integer.valueOf(p_75618_2_));
   }

   public static void func_75614_a(Class p_75614_0_, String p_75614_1_, int p_75614_2_, int p_75614_3_, int p_75614_4_) {
      func_75618_a(p_75614_0_, p_75614_1_, p_75614_2_);
      field_75627_a.put(Integer.valueOf(p_75614_2_), new EntityEggInfo(p_75614_2_, p_75614_3_, p_75614_4_));
   }

   public static Entity func_75620_a(String p_75620_0_, World p_75620_1_) {
      Entity var2 = null;

      try {
         Class var3 = (Class)field_75625_b.get(p_75620_0_);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_75620_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public static Entity func_75615_a(NBTTagCompound p_75615_0_, World p_75615_1_) {
      Entity var2 = null;
      if("Minecart".equals(p_75615_0_.func_74779_i("id"))) {
         switch(p_75615_0_.func_74762_e("Type")) {
         case 0:
            p_75615_0_.func_74778_a("id", "MinecartRideable");
            break;
         case 1:
            p_75615_0_.func_74778_a("id", "MinecartChest");
            break;
         case 2:
            p_75615_0_.func_74778_a("id", "MinecartFurnace");
         }

         p_75615_0_.func_82580_o("Type");
      }

      try {
         Class var3 = (Class)field_75625_b.get(p_75615_0_.func_74779_i("id"));
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_75615_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.func_70020_e(p_75615_0_);
      } else {
         p_75615_1_.func_98180_V().func_98236_b("Skipping Entity with id " + p_75615_0_.func_74779_i("id"));
      }

      return var2;
   }

   public static Entity func_75616_a(int p_75616_0_, World p_75616_1_) {
      Entity var2 = null;

      try {
         Class var3 = func_90035_a(p_75616_0_);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_75616_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 == null) {
         p_75616_1_.func_98180_V().func_98236_b("Skipping Entity with id " + p_75616_0_);
      }

      return var2;
   }

   public static int func_75619_a(Entity p_75619_0_) {
      Class var1 = p_75619_0_.getClass();
      return field_75624_e.containsKey(var1)?((Integer)field_75624_e.get(var1)).intValue():0;
   }

   public static Class func_90035_a(int p_90035_0_) {
      return (Class)field_75623_d.get(Integer.valueOf(p_90035_0_));
   }

   public static String func_75621_b(Entity p_75621_0_) {
      return (String)field_75626_c.get(p_75621_0_.getClass());
   }

   public static String func_75617_a(int p_75617_0_) {
      Class var1 = func_90035_a(p_75617_0_);
      return var1 != null?(String)field_75626_c.get(var1):null;
   }

   static {
      func_75618_a(EntityItem.class, "Item", 1);
      func_75618_a(EntityXPOrb.class, "XPOrb", 2);
      func_75618_a(EntityPainting.class, "Painting", 9);
      func_75618_a(EntityArrow.class, "Arrow", 10);
      func_75618_a(EntitySnowball.class, "Snowball", 11);
      func_75618_a(EntityLargeFireball.class, "Fireball", 12);
      func_75618_a(EntitySmallFireball.class, "SmallFireball", 13);
      func_75618_a(EntityEnderPearl.class, "ThrownEnderpearl", 14);
      func_75618_a(EntityEnderEye.class, "EyeOfEnderSignal", 15);
      func_75618_a(EntityPotion.class, "ThrownPotion", 16);
      func_75618_a(EntityExpBottle.class, "ThrownExpBottle", 17);
      func_75618_a(EntityItemFrame.class, "ItemFrame", 18);
      func_75618_a(EntityWitherSkull.class, "WitherSkull", 19);
      func_75618_a(EntityTNTPrimed.class, "PrimedTnt", 20);
      func_75618_a(EntityFallingSand.class, "FallingSand", 21);
      func_75618_a(EntityFireworkRocket.class, "FireworksRocketEntity", 22);
      func_75618_a(EntityBoat.class, "Boat", 41);
      func_75618_a(EntityMinecartEmpty.class, "MinecartRideable", 42);
      func_75618_a(EntityMinecartChest.class, "MinecartChest", 43);
      func_75618_a(EntityMinecartFurnace.class, "MinecartFurnace", 44);
      func_75618_a(EntityMinecartTNT.class, "MinecartTNT", 45);
      func_75618_a(EntityMinecartHopper.class, "MinecartHopper", 46);
      func_75618_a(EntityMinecartMobSpawner.class, "MinecartSpawner", 47);
      func_75618_a(EntityLiving.class, "Mob", 48);
      func_75618_a(EntityMob.class, "Monster", 49);
      func_75614_a(EntityCreeper.class, "Creeper", 50, 894731, 0);
      func_75614_a(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
      func_75614_a(EntitySpider.class, "Spider", 52, 3419431, 11013646);
      func_75618_a(EntityGiantZombie.class, "Giant", 53);
      func_75614_a(EntityZombie.class, "Zombie", 54, '\uafaf', 7969893);
      func_75614_a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
      func_75614_a(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
      func_75614_a(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
      func_75614_a(EntityEnderman.class, "Enderman", 58, 1447446, 0);
      func_75614_a(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
      func_75614_a(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
      func_75614_a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
      func_75614_a(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
      func_75618_a(EntityDragon.class, "EnderDragon", 63);
      func_75618_a(EntityWither.class, "WitherBoss", 64);
      func_75614_a(EntityBat.class, "Bat", 65, 4996656, 986895);
      func_75614_a(EntityWitch.class, "Witch", 66, 3407872, 5349438);
      func_75614_a(EntityPig.class, "Pig", 90, 15771042, 14377823);
      func_75614_a(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
      func_75614_a(EntityCow.class, "Cow", 92, 4470310, 10592673);
      func_75614_a(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
      func_75614_a(EntitySquid.class, "Squid", 94, 2243405, 7375001);
      func_75614_a(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
      func_75614_a(EntityMooshroom.class, "MushroomCow", 96, 10489616, 12040119);
      func_75618_a(EntitySnowman.class, "SnowMan", 97);
      func_75614_a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
      func_75618_a(EntityIronGolem.class, "VillagerGolem", 99);
      func_75614_a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
      func_75618_a(EntityEnderCrystal.class, "EnderCrystal", 200);
   }
}
