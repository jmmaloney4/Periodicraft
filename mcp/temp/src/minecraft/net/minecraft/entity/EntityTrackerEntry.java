package net.minecraft.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26EntityExpOrb;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet31RelEntityMove;
import net.minecraft.network.packet.Packet32EntityLook;
import net.minecraft.network.packet.Packet33RelEntityMoveLook;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet35EntityHeadRotation;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.storage.MapData;

public class EntityTrackerEntry {

   public Entity field_73132_a;
   public int field_73130_b;
   public int field_73131_c;
   public int field_73128_d;
   public int field_73129_e;
   public int field_73126_f;
   public int field_73127_g;
   public int field_73139_h;
   public int field_73140_i;
   public double field_73137_j;
   public double field_73138_k;
   public double field_73135_l;
   public int field_73136_m = 0;
   private double field_73147_p;
   private double field_73146_q;
   private double field_73145_r;
   private boolean field_73144_s = false;
   private boolean field_73143_t;
   private int field_73142_u = 0;
   private Entity field_85178_v;
   private boolean field_73141_v = false;
   public boolean field_73133_n = false;
   public Set field_73134_o = new HashSet();


   public EntityTrackerEntry(Entity p_i3398_1_, int p_i3398_2_, int p_i3398_3_, boolean p_i3398_4_) {
      this.field_73132_a = p_i3398_1_;
      this.field_73130_b = p_i3398_2_;
      this.field_73131_c = p_i3398_3_;
      this.field_73143_t = p_i3398_4_;
      this.field_73128_d = MathHelper.func_76128_c(p_i3398_1_.field_70165_t * 32.0D);
      this.field_73129_e = MathHelper.func_76128_c(p_i3398_1_.field_70163_u * 32.0D);
      this.field_73126_f = MathHelper.func_76128_c(p_i3398_1_.field_70161_v * 32.0D);
      this.field_73127_g = MathHelper.func_76141_d(p_i3398_1_.field_70177_z * 256.0F / 360.0F);
      this.field_73139_h = MathHelper.func_76141_d(p_i3398_1_.field_70125_A * 256.0F / 360.0F);
      this.field_73140_i = MathHelper.func_76141_d(p_i3398_1_.func_70079_am() * 256.0F / 360.0F);
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof EntityTrackerEntry?((EntityTrackerEntry)p_equals_1_).field_73132_a.field_70157_k == this.field_73132_a.field_70157_k:false;
   }

   public int hashCode() {
      return this.field_73132_a.field_70157_k;
   }

   public void func_73122_a(List p_73122_1_) {
      this.field_73133_n = false;
      if(!this.field_73144_s || this.field_73132_a.func_70092_e(this.field_73147_p, this.field_73146_q, this.field_73145_r) > 16.0D) {
         this.field_73147_p = this.field_73132_a.field_70165_t;
         this.field_73146_q = this.field_73132_a.field_70163_u;
         this.field_73145_r = this.field_73132_a.field_70161_v;
         this.field_73144_s = true;
         this.field_73133_n = true;
         this.func_73125_b(p_73122_1_);
      }

      if(this.field_85178_v != this.field_73132_a.field_70154_o || this.field_73132_a.field_70154_o != null && this.field_73136_m % 60 == 0) {
         this.field_85178_v = this.field_73132_a.field_70154_o;
         this.func_73120_a(new Packet39AttachEntity(this.field_73132_a, this.field_73132_a.field_70154_o));
      }

      if(this.field_73132_a instanceof EntityItemFrame && this.field_73136_m % 10 == 0) {
         EntityItemFrame var23 = (EntityItemFrame)this.field_73132_a;
         ItemStack var24 = var23.func_82335_i();
         if(var24 != null && var24.func_77973_b() instanceof ItemMap) {
            MapData var26 = Item.field_77744_bd.func_77873_a(var24, this.field_73132_a.field_70170_p);
            Iterator var29 = p_73122_1_.iterator();

            while(var29.hasNext()) {
               EntityPlayer var30 = (EntityPlayer)var29.next();
               EntityPlayerMP var31 = (EntityPlayerMP)var30;
               var26.func_76191_a(var31, var24);
               if(var31.field_71135_a.func_72568_e() <= 5) {
                  Packet var32 = Item.field_77744_bd.func_77871_c(var24, this.field_73132_a.field_70170_p, var31);
                  if(var32 != null) {
                     var31.field_71135_a.func_72567_b(var32);
                  }
               }
            }
         }

         DataWatcher var28 = this.field_73132_a.func_70096_w();
         if(var28.func_75684_a()) {
            this.func_73116_b(new Packet40EntityMetadata(this.field_73132_a.field_70157_k, var28, false));
         }
      } else if(this.field_73136_m % this.field_73131_c == 0 || this.field_73132_a.field_70160_al || this.field_73132_a.func_70096_w().func_75684_a()) {
         int var2;
         int var3;
         if(this.field_73132_a.field_70154_o == null) {
            ++this.field_73142_u;
            var2 = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70165_t);
            var3 = MathHelper.func_76128_c(this.field_73132_a.field_70163_u * 32.0D);
            int var4 = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70161_v);
            int var5 = MathHelper.func_76141_d(this.field_73132_a.field_70177_z * 256.0F / 360.0F);
            int var6 = MathHelper.func_76141_d(this.field_73132_a.field_70125_A * 256.0F / 360.0F);
            int var7 = var2 - this.field_73128_d;
            int var8 = var3 - this.field_73129_e;
            int var9 = var4 - this.field_73126_f;
            Object var10 = null;
            boolean var11 = Math.abs(var7) >= 4 || Math.abs(var8) >= 4 || Math.abs(var9) >= 4 || this.field_73136_m % 60 == 0;
            boolean var12 = Math.abs(var5 - this.field_73127_g) >= 4 || Math.abs(var6 - this.field_73139_h) >= 4;
            if(this.field_73136_m > 0) {
               if(var7 >= -128 && var7 < 128 && var8 >= -128 && var8 < 128 && var9 >= -128 && var9 < 128 && this.field_73142_u <= 400 && !this.field_73141_v) {
                  if(var11 && var12) {
                     var10 = new Packet33RelEntityMoveLook(this.field_73132_a.field_70157_k, (byte)var7, (byte)var8, (byte)var9, (byte)var5, (byte)var6);
                  } else if(var11) {
                     var10 = new Packet31RelEntityMove(this.field_73132_a.field_70157_k, (byte)var7, (byte)var8, (byte)var9);
                  } else if(var12) {
                     var10 = new Packet32EntityLook(this.field_73132_a.field_70157_k, (byte)var5, (byte)var6);
                  }
               } else {
                  this.field_73142_u = 0;
                  var10 = new Packet34EntityTeleport(this.field_73132_a.field_70157_k, var2, var3, var4, (byte)var5, (byte)var6);
               }
            }

            if(this.field_73143_t) {
               double var13 = this.field_73132_a.field_70159_w - this.field_73137_j;
               double var15 = this.field_73132_a.field_70181_x - this.field_73138_k;
               double var17 = this.field_73132_a.field_70179_y - this.field_73135_l;
               double var19 = 0.02D;
               double var21 = var13 * var13 + var15 * var15 + var17 * var17;
               if(var21 > var19 * var19 || var21 > 0.0D && this.field_73132_a.field_70159_w == 0.0D && this.field_73132_a.field_70181_x == 0.0D && this.field_73132_a.field_70179_y == 0.0D) {
                  this.field_73137_j = this.field_73132_a.field_70159_w;
                  this.field_73138_k = this.field_73132_a.field_70181_x;
                  this.field_73135_l = this.field_73132_a.field_70179_y;
                  this.func_73120_a(new Packet28EntityVelocity(this.field_73132_a.field_70157_k, this.field_73137_j, this.field_73138_k, this.field_73135_l));
               }
            }

            if(var10 != null) {
               this.func_73120_a((Packet)var10);
            }

            DataWatcher var33 = this.field_73132_a.func_70096_w();
            if(var33.func_75684_a()) {
               this.func_73116_b(new Packet40EntityMetadata(this.field_73132_a.field_70157_k, var33, false));
            }

            if(var11) {
               this.field_73128_d = var2;
               this.field_73129_e = var3;
               this.field_73126_f = var4;
            }

            if(var12) {
               this.field_73127_g = var5;
               this.field_73139_h = var6;
            }

            this.field_73141_v = false;
         } else {
            var2 = MathHelper.func_76141_d(this.field_73132_a.field_70177_z * 256.0F / 360.0F);
            var3 = MathHelper.func_76141_d(this.field_73132_a.field_70125_A * 256.0F / 360.0F);
            boolean var25 = Math.abs(var2 - this.field_73127_g) >= 4 || Math.abs(var3 - this.field_73139_h) >= 4;
            if(var25) {
               this.func_73120_a(new Packet32EntityLook(this.field_73132_a.field_70157_k, (byte)var2, (byte)var3));
               this.field_73127_g = var2;
               this.field_73139_h = var3;
            }

            this.field_73128_d = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70165_t);
            this.field_73129_e = MathHelper.func_76128_c(this.field_73132_a.field_70163_u * 32.0D);
            this.field_73126_f = this.field_73132_a.field_70168_am.func_75630_a(this.field_73132_a.field_70161_v);
            DataWatcher var27 = this.field_73132_a.func_70096_w();
            if(var27.func_75684_a()) {
               this.func_73116_b(new Packet40EntityMetadata(this.field_73132_a.field_70157_k, var27, false));
            }

            this.field_73141_v = true;
         }

         var2 = MathHelper.func_76141_d(this.field_73132_a.func_70079_am() * 256.0F / 360.0F);
         if(Math.abs(var2 - this.field_73140_i) >= 4) {
            this.func_73120_a(new Packet35EntityHeadRotation(this.field_73132_a.field_70157_k, (byte)var2));
            this.field_73140_i = var2;
         }

         this.field_73132_a.field_70160_al = false;
      }

      ++this.field_73136_m;
      if(this.field_73132_a.field_70133_I) {
         this.func_73116_b(new Packet28EntityVelocity(this.field_73132_a));
         this.field_73132_a.field_70133_I = false;
      }

   }

   public void func_73120_a(Packet p_73120_1_) {
      Iterator var2 = this.field_73134_o.iterator();

      while(var2.hasNext()) {
         EntityPlayerMP var3 = (EntityPlayerMP)var2.next();
         var3.field_71135_a.func_72567_b(p_73120_1_);
      }

   }

   public void func_73116_b(Packet p_73116_1_) {
      this.func_73120_a(p_73116_1_);
      if(this.field_73132_a instanceof EntityPlayerMP) {
         ((EntityPlayerMP)this.field_73132_a).field_71135_a.func_72567_b(p_73116_1_);
      }

   }

   public void func_73119_a() {
      Iterator var1 = this.field_73134_o.iterator();

      while(var1.hasNext()) {
         EntityPlayerMP var2 = (EntityPlayerMP)var1.next();
         var2.field_71130_g.add(Integer.valueOf(this.field_73132_a.field_70157_k));
      }

   }

   public void func_73118_a(EntityPlayerMP p_73118_1_) {
      if(this.field_73134_o.contains(p_73118_1_)) {
         p_73118_1_.field_71130_g.add(Integer.valueOf(this.field_73132_a.field_70157_k));
         this.field_73134_o.remove(p_73118_1_);
      }

   }

   public void func_73117_b(EntityPlayerMP p_73117_1_) {
      if(p_73117_1_ != this.field_73132_a) {
         double var2 = p_73117_1_.field_70165_t - (double)(this.field_73128_d / 32);
         double var4 = p_73117_1_.field_70161_v - (double)(this.field_73126_f / 32);
         if(var2 >= (double)(-this.field_73130_b) && var2 <= (double)this.field_73130_b && var4 >= (double)(-this.field_73130_b) && var4 <= (double)this.field_73130_b) {
            if(!this.field_73134_o.contains(p_73117_1_) && (this.func_73121_d(p_73117_1_) || this.field_73132_a.field_98038_p)) {
               this.field_73134_o.add(p_73117_1_);
               Packet var6 = this.func_73124_b();
               p_73117_1_.field_71135_a.func_72567_b(var6);
               if(!this.field_73132_a.func_70096_w().func_92085_d()) {
                  p_73117_1_.field_71135_a.func_72567_b(new Packet40EntityMetadata(this.field_73132_a.field_70157_k, this.field_73132_a.func_70096_w(), true));
               }

               this.field_73137_j = this.field_73132_a.field_70159_w;
               this.field_73138_k = this.field_73132_a.field_70181_x;
               this.field_73135_l = this.field_73132_a.field_70179_y;
               if(this.field_73143_t && !(var6 instanceof Packet24MobSpawn)) {
                  p_73117_1_.field_71135_a.func_72567_b(new Packet28EntityVelocity(this.field_73132_a.field_70157_k, this.field_73132_a.field_70159_w, this.field_73132_a.field_70181_x, this.field_73132_a.field_70179_y));
               }

               if(this.field_73132_a.field_70154_o != null) {
                  p_73117_1_.field_71135_a.func_72567_b(new Packet39AttachEntity(this.field_73132_a, this.field_73132_a.field_70154_o));
               }

               if(this.field_73132_a instanceof EntityLiving) {
                  for(int var7 = 0; var7 < 5; ++var7) {
                     ItemStack var8 = ((EntityLiving)this.field_73132_a).func_71124_b(var7);
                     if(var8 != null) {
                        p_73117_1_.field_71135_a.func_72567_b(new Packet5PlayerInventory(this.field_73132_a.field_70157_k, var7, var8));
                     }
                  }
               }

               if(this.field_73132_a instanceof EntityPlayer) {
                  EntityPlayer var11 = (EntityPlayer)this.field_73132_a;
                  if(var11.func_70608_bn()) {
                     p_73117_1_.field_71135_a.func_72567_b(new Packet17Sleep(this.field_73132_a, 0, MathHelper.func_76128_c(this.field_73132_a.field_70165_t), MathHelper.func_76128_c(this.field_73132_a.field_70163_u), MathHelper.func_76128_c(this.field_73132_a.field_70161_v)));
                  }
               }

               if(this.field_73132_a instanceof EntityLiving) {
                  EntityLiving var10 = (EntityLiving)this.field_73132_a;
                  Iterator var12 = var10.func_70651_bq().iterator();

                  while(var12.hasNext()) {
                     PotionEffect var9 = (PotionEffect)var12.next();
                     p_73117_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(this.field_73132_a.field_70157_k, var9));
                  }
               }
            }
         } else if(this.field_73134_o.contains(p_73117_1_)) {
            this.field_73134_o.remove(p_73117_1_);
            p_73117_1_.field_71130_g.add(Integer.valueOf(this.field_73132_a.field_70157_k));
         }

      }
   }

   private boolean func_73121_d(EntityPlayerMP p_73121_1_) {
      return p_73121_1_.func_71121_q().func_73040_p().func_72694_a(p_73121_1_, this.field_73132_a.field_70176_ah, this.field_73132_a.field_70164_aj);
   }

   public void func_73125_b(List p_73125_1_) {
      for(int var2 = 0; var2 < p_73125_1_.size(); ++var2) {
         this.func_73117_b((EntityPlayerMP)p_73125_1_.get(var2));
      }

   }

   private Packet func_73124_b() {
      if(this.field_73132_a.field_70128_L) {
         this.field_73132_a.field_70170_p.func_98180_V().func_98236_b("Fetching addPacket for removed entity");
      }

      if(this.field_73132_a instanceof EntityItem) {
         return new Packet23VehicleSpawn(this.field_73132_a, 2, 1);
      } else if(this.field_73132_a instanceof EntityPlayerMP) {
         return new Packet20NamedEntitySpawn((EntityPlayer)this.field_73132_a);
      } else if(this.field_73132_a instanceof EntityMinecart) {
         EntityMinecart var8 = (EntityMinecart)this.field_73132_a;
         return new Packet23VehicleSpawn(this.field_73132_a, 10, var8.func_94087_l());
      } else if(this.field_73132_a instanceof EntityBoat) {
         return new Packet23VehicleSpawn(this.field_73132_a, 1);
      } else if(!(this.field_73132_a instanceof IAnimals) && !(this.field_73132_a instanceof EntityDragon)) {
         if(this.field_73132_a instanceof EntityFishHook) {
            EntityPlayer var7 = ((EntityFishHook)this.field_73132_a).field_70204_b;
            return new Packet23VehicleSpawn(this.field_73132_a, 90, var7 != null?var7.field_70157_k:this.field_73132_a.field_70157_k);
         } else if(this.field_73132_a instanceof EntityArrow) {
            Entity var6 = ((EntityArrow)this.field_73132_a).field_70250_c;
            return new Packet23VehicleSpawn(this.field_73132_a, 60, var6 != null?var6.field_70157_k:this.field_73132_a.field_70157_k);
         } else if(this.field_73132_a instanceof EntitySnowball) {
            return new Packet23VehicleSpawn(this.field_73132_a, 61);
         } else if(this.field_73132_a instanceof EntityPotion) {
            return new Packet23VehicleSpawn(this.field_73132_a, 73, ((EntityPotion)this.field_73132_a).func_70196_i());
         } else if(this.field_73132_a instanceof EntityExpBottle) {
            return new Packet23VehicleSpawn(this.field_73132_a, 75);
         } else if(this.field_73132_a instanceof EntityEnderPearl) {
            return new Packet23VehicleSpawn(this.field_73132_a, 65);
         } else if(this.field_73132_a instanceof EntityEnderEye) {
            return new Packet23VehicleSpawn(this.field_73132_a, 72);
         } else if(this.field_73132_a instanceof EntityFireworkRocket) {
            return new Packet23VehicleSpawn(this.field_73132_a, 76);
         } else {
            Packet23VehicleSpawn var2;
            if(this.field_73132_a instanceof EntityFireball) {
               EntityFireball var5 = (EntityFireball)this.field_73132_a;
               var2 = null;
               byte var3 = 63;
               if(this.field_73132_a instanceof EntitySmallFireball) {
                  var3 = 64;
               } else if(this.field_73132_a instanceof EntityWitherSkull) {
                  var3 = 66;
               }

               if(var5.field_70235_a != null) {
                  var2 = new Packet23VehicleSpawn(this.field_73132_a, var3, ((EntityFireball)this.field_73132_a).field_70235_a.field_70157_k);
               } else {
                  var2 = new Packet23VehicleSpawn(this.field_73132_a, var3, 0);
               }

               var2.field_73523_e = (int)(var5.field_70232_b * 8000.0D);
               var2.field_73520_f = (int)(var5.field_70233_c * 8000.0D);
               var2.field_73521_g = (int)(var5.field_70230_d * 8000.0D);
               return var2;
            } else if(this.field_73132_a instanceof EntityEgg) {
               return new Packet23VehicleSpawn(this.field_73132_a, 62);
            } else if(this.field_73132_a instanceof EntityTNTPrimed) {
               return new Packet23VehicleSpawn(this.field_73132_a, 50);
            } else if(this.field_73132_a instanceof EntityEnderCrystal) {
               return new Packet23VehicleSpawn(this.field_73132_a, 51);
            } else if(this.field_73132_a instanceof EntityFallingSand) {
               EntityFallingSand var4 = (EntityFallingSand)this.field_73132_a;
               return new Packet23VehicleSpawn(this.field_73132_a, 70, var4.field_70287_a | var4.field_70285_b << 16);
            } else if(this.field_73132_a instanceof EntityPainting) {
               return new Packet25EntityPainting((EntityPainting)this.field_73132_a);
            } else if(this.field_73132_a instanceof EntityItemFrame) {
               EntityItemFrame var1 = (EntityItemFrame)this.field_73132_a;
               var2 = new Packet23VehicleSpawn(this.field_73132_a, 71, var1.field_82332_a);
               var2.field_73524_b = MathHelper.func_76141_d((float)(var1.field_70523_b * 32));
               var2.field_73525_c = MathHelper.func_76141_d((float)(var1.field_70524_c * 32));
               var2.field_73522_d = MathHelper.func_76141_d((float)(var1.field_70521_d * 32));
               return var2;
            } else if(this.field_73132_a instanceof EntityXPOrb) {
               return new Packet26EntityExpOrb((EntityXPOrb)this.field_73132_a);
            } else {
               throw new IllegalArgumentException("Don\'t know how to add " + this.field_73132_a.getClass() + "!");
            }
         }
      } else {
         this.field_73140_i = MathHelper.func_76141_d(this.field_73132_a.func_70079_am() * 256.0F / 360.0F);
         return new Packet24MobSpawn((EntityLiving)this.field_73132_a);
      }
   }

   public void func_73123_c(EntityPlayerMP p_73123_1_) {
      if(this.field_73134_o.contains(p_73123_1_)) {
         this.field_73134_o.remove(p_73123_1_);
         p_73123_1_.field_71130_g.add(Integer.valueOf(this.field_73132_a.field_70157_k));
      }

   }
}
