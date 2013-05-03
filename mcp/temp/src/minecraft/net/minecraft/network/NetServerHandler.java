package net.minecraft.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.CallablePacketClass;
import net.minecraft.network.CallablePacketID;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet13PlayerLookMove;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldServer;

public class NetServerHandler extends NetHandler {

   public final INetworkManager field_72575_b;
   private final MinecraftServer field_72573_d;
   public boolean field_72576_c = false;
   public EntityPlayerMP field_72574_e;
   private int field_72571_f;
   public int field_72572_g;
   private boolean field_72584_h;
   private int field_72585_i;
   private long field_72582_j;
   private static Random field_72583_k = new Random();
   private long field_72580_l;
   private int field_72581_m = 0;
   private int field_72578_n = 0;
   private double field_72579_o;
   private double field_72589_p;
   private double field_72588_q;
   private boolean field_72587_r = true;
   private IntHashMap field_72586_s = new IntHashMap();


   public NetServerHandler(MinecraftServer p_i5010_1_, INetworkManager p_i5010_2_, EntityPlayerMP p_i5010_3_) {
      this.field_72573_d = p_i5010_1_;
      this.field_72575_b = p_i5010_2_;
      p_i5010_2_.func_74425_a(this);
      this.field_72574_e = p_i5010_3_;
      p_i5010_3_.field_71135_a = this;
   }

   public void func_72570_d() {
      this.field_72584_h = false;
      ++this.field_72571_f;
      this.field_72573_d.field_71304_b.func_76320_a("packetflow");
      this.field_72575_b.func_74428_b();
      this.field_72573_d.field_71304_b.func_76318_c("keepAlive");
      if((long)this.field_72571_f - this.field_72580_l > 20L) {
         this.field_72580_l = (long)this.field_72571_f;
         this.field_72582_j = System.nanoTime() / 1000000L;
         this.field_72585_i = field_72583_k.nextInt();
         this.func_72567_b(new Packet0KeepAlive(this.field_72585_i));
      }

      if(this.field_72581_m > 0) {
         --this.field_72581_m;
      }

      if(this.field_72578_n > 0) {
         --this.field_72578_n;
      }

      this.field_72573_d.field_71304_b.func_76318_c("playerTick");
      this.field_72573_d.field_71304_b.func_76319_b();
   }

   public void func_72565_c(String p_72565_1_) {
      if(!this.field_72576_c) {
         this.field_72574_e.func_71123_m();
         this.func_72567_b(new Packet255KickDisconnect(p_72565_1_));
         this.field_72575_b.func_74423_d();
         this.field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat(EnumChatFormatting.YELLOW + this.field_72574_e.field_71092_bJ + " left the game."));
         this.field_72573_d.func_71203_ab().func_72367_e(this.field_72574_e);
         this.field_72576_c = true;
      }
   }

   public void func_72498_a(Packet10Flying p_72498_1_) {
      WorldServer var2 = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
      this.field_72584_h = true;
      if(!this.field_72574_e.field_71136_j) {
         double var3;
         if(!this.field_72587_r) {
            var3 = p_72498_1_.field_73543_b - this.field_72589_p;
            if(p_72498_1_.field_73545_a == this.field_72579_o && var3 * var3 < 0.01D && p_72498_1_.field_73544_c == this.field_72588_q) {
               this.field_72587_r = true;
            }
         }

         if(this.field_72587_r) {
            double var5;
            double var7;
            double var9;
            double var13;
            if(this.field_72574_e.field_70154_o != null) {
               float var34 = this.field_72574_e.field_70177_z;
               float var4 = this.field_72574_e.field_70125_A;
               this.field_72574_e.field_70154_o.func_70043_V();
               var5 = this.field_72574_e.field_70165_t;
               var7 = this.field_72574_e.field_70163_u;
               var9 = this.field_72574_e.field_70161_v;
               double var35 = 0.0D;
               var13 = 0.0D;
               if(p_72498_1_.field_73547_i) {
                  var34 = p_72498_1_.field_73542_e;
                  var4 = p_72498_1_.field_73539_f;
               }

               if(p_72498_1_.field_73546_h && p_72498_1_.field_73543_b == -999.0D && p_72498_1_.field_73541_d == -999.0D) {
                  if(Math.abs(p_72498_1_.field_73545_a) > 1.0D || Math.abs(p_72498_1_.field_73544_c) > 1.0D) {
                     System.err.println(this.field_72574_e.field_71092_bJ + " was caught trying to crash the server with an invalid position.");
                     this.func_72565_c("Nope!");
                     return;
                  }

                  var35 = p_72498_1_.field_73545_a;
                  var13 = p_72498_1_.field_73544_c;
               }

               this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
               this.field_72574_e.func_71127_g();
               this.field_72574_e.func_70091_d(var35, 0.0D, var13);
               this.field_72574_e.func_70080_a(var5, var7, var9, var34, var4);
               this.field_72574_e.field_70159_w = var35;
               this.field_72574_e.field_70179_y = var13;
               if(this.field_72574_e.field_70154_o != null) {
                  var2.func_73050_b(this.field_72574_e.field_70154_o, true);
               }

               if(this.field_72574_e.field_70154_o != null) {
                  this.field_72574_e.field_70154_o.func_70043_V();
               }

               this.field_72573_d.func_71203_ab().func_72358_d(this.field_72574_e);
               this.field_72579_o = this.field_72574_e.field_70165_t;
               this.field_72589_p = this.field_72574_e.field_70163_u;
               this.field_72588_q = this.field_72574_e.field_70161_v;
               var2.func_72870_g(this.field_72574_e);
               return;
            }

            if(this.field_72574_e.func_70608_bn()) {
               this.field_72574_e.func_71127_g();
               this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
               var2.func_72870_g(this.field_72574_e);
               return;
            }

            var3 = this.field_72574_e.field_70163_u;
            this.field_72579_o = this.field_72574_e.field_70165_t;
            this.field_72589_p = this.field_72574_e.field_70163_u;
            this.field_72588_q = this.field_72574_e.field_70161_v;
            var5 = this.field_72574_e.field_70165_t;
            var7 = this.field_72574_e.field_70163_u;
            var9 = this.field_72574_e.field_70161_v;
            float var11 = this.field_72574_e.field_70177_z;
            float var12 = this.field_72574_e.field_70125_A;
            if(p_72498_1_.field_73546_h && p_72498_1_.field_73543_b == -999.0D && p_72498_1_.field_73541_d == -999.0D) {
               p_72498_1_.field_73546_h = false;
            }

            if(p_72498_1_.field_73546_h) {
               var5 = p_72498_1_.field_73545_a;
               var7 = p_72498_1_.field_73543_b;
               var9 = p_72498_1_.field_73544_c;
               var13 = p_72498_1_.field_73541_d - p_72498_1_.field_73543_b;
               if(!this.field_72574_e.func_70608_bn() && (var13 > 1.65D || var13 < 0.1D)) {
                  this.func_72565_c("Illegal stance");
                  this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.field_71092_bJ + " had an illegal stance: " + var13);
                  return;
               }

               if(Math.abs(p_72498_1_.field_73545_a) > 3.2E7D || Math.abs(p_72498_1_.field_73544_c) > 3.2E7D) {
                  this.func_72565_c("Illegal position");
                  return;
               }
            }

            if(p_72498_1_.field_73547_i) {
               var11 = p_72498_1_.field_73542_e;
               var12 = p_72498_1_.field_73539_f;
            }

            this.field_72574_e.func_71127_g();
            this.field_72574_e.field_70139_V = 0.0F;
            this.field_72574_e.func_70080_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, var11, var12);
            if(!this.field_72587_r) {
               return;
            }

            var13 = var5 - this.field_72574_e.field_70165_t;
            double var15 = var7 - this.field_72574_e.field_70163_u;
            double var17 = var9 - this.field_72574_e.field_70161_v;
            double var19 = Math.min(Math.abs(var13), Math.abs(this.field_72574_e.field_70159_w));
            double var21 = Math.min(Math.abs(var15), Math.abs(this.field_72574_e.field_70181_x));
            double var23 = Math.min(Math.abs(var17), Math.abs(this.field_72574_e.field_70179_y));
            double var25 = var19 * var19 + var21 * var21 + var23 * var23;
            if(var25 > 100.0D && (!this.field_72573_d.func_71264_H() || !this.field_72573_d.func_71214_G().equals(this.field_72574_e.field_71092_bJ))) {
               this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.field_71092_bJ + " moved too quickly! " + var13 + "," + var15 + "," + var17 + " (" + var19 + ", " + var21 + ", " + var23 + ")");
               this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, this.field_72574_e.field_70177_z, this.field_72574_e.field_70125_A);
               return;
            }

            float var27 = 0.0625F;
            boolean var28 = var2.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D.func_72329_c().func_72331_e((double)var27, (double)var27, (double)var27)).isEmpty();
            if(this.field_72574_e.field_70122_E && !p_72498_1_.field_73540_g && var15 > 0.0D) {
               this.field_72574_e.func_71020_j(0.2F);
            }

            this.field_72574_e.func_70091_d(var13, var15, var17);
            this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
            this.field_72574_e.func_71000_j(var13, var15, var17);
            double var29 = var15;
            var13 = var5 - this.field_72574_e.field_70165_t;
            var15 = var7 - this.field_72574_e.field_70163_u;
            if(var15 > -0.5D || var15 < 0.5D) {
               var15 = 0.0D;
            }

            var17 = var9 - this.field_72574_e.field_70161_v;
            var25 = var13 * var13 + var15 * var15 + var17 * var17;
            boolean var31 = false;
            if(var25 > 0.0625D && !this.field_72574_e.func_70608_bn() && !this.field_72574_e.field_71134_c.func_73083_d()) {
               var31 = true;
               this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.field_71092_bJ + " moved wrongly!");
            }

            this.field_72574_e.func_70080_a(var5, var7, var9, var11, var12);
            boolean var32 = var2.func_72945_a(this.field_72574_e, this.field_72574_e.field_70121_D.func_72329_c().func_72331_e((double)var27, (double)var27, (double)var27)).isEmpty();
            if(var28 && (var31 || !var32) && !this.field_72574_e.func_70608_bn()) {
               this.func_72569_a(this.field_72579_o, this.field_72589_p, this.field_72588_q, var11, var12);
               return;
            }

            AxisAlignedBB var33 = this.field_72574_e.field_70121_D.func_72329_c().func_72314_b((double)var27, (double)var27, (double)var27).func_72321_a(0.0D, -0.55D, 0.0D);
            if(!this.field_72573_d.func_71231_X() && !this.field_72574_e.field_71134_c.func_73083_d() && !var2.func_72829_c(var33)) {
               if(var29 >= -0.03125D) {
                  ++this.field_72572_g;
                  if(this.field_72572_g > 80) {
                     this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.field_71092_bJ + " was kicked for floating too long!");
                     this.func_72565_c("Flying is not enabled on this server");
                     return;
                  }
               }
            } else {
               this.field_72572_g = 0;
            }

            this.field_72574_e.field_70122_E = p_72498_1_.field_73540_g;
            this.field_72573_d.func_71203_ab().func_72358_d(this.field_72574_e);
            this.field_72574_e.func_71122_b(this.field_72574_e.field_70163_u - var3, p_72498_1_.field_73540_g);
         }

      }
   }

   public void func_72569_a(double p_72569_1_, double p_72569_3_, double p_72569_5_, float p_72569_7_, float p_72569_8_) {
      this.field_72587_r = false;
      this.field_72579_o = p_72569_1_;
      this.field_72589_p = p_72569_3_;
      this.field_72588_q = p_72569_5_;
      this.field_72574_e.func_70080_a(p_72569_1_, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_);
      this.field_72574_e.field_71135_a.func_72567_b(new Packet13PlayerLookMove(p_72569_1_, p_72569_3_ + 1.6200000047683716D, p_72569_3_, p_72569_5_, p_72569_7_, p_72569_8_, false));
   }

   public void func_72510_a(Packet14BlockDig p_72510_1_) {
      WorldServer var2 = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
      if(p_72510_1_.field_73342_e == 4) {
         this.field_72574_e.func_71040_bB(false);
      } else if(p_72510_1_.field_73342_e == 3) {
         this.field_72574_e.func_71040_bB(true);
      } else if(p_72510_1_.field_73342_e == 5) {
         this.field_72574_e.func_71034_by();
      } else {
         boolean var3 = false;
         if(p_72510_1_.field_73342_e == 0) {
            var3 = true;
         }

         if(p_72510_1_.field_73342_e == 1) {
            var3 = true;
         }

         if(p_72510_1_.field_73342_e == 2) {
            var3 = true;
         }

         int var4 = p_72510_1_.field_73345_a;
         int var5 = p_72510_1_.field_73343_b;
         int var6 = p_72510_1_.field_73344_c;
         if(var3) {
            double var7 = this.field_72574_e.field_70165_t - ((double)var4 + 0.5D);
            double var9 = this.field_72574_e.field_70163_u - ((double)var5 + 0.5D) + 1.5D;
            double var11 = this.field_72574_e.field_70161_v - ((double)var6 + 0.5D);
            double var13 = var7 * var7 + var9 * var9 + var11 * var11;
            if(var13 > 36.0D) {
               return;
            }

            if(var5 >= this.field_72573_d.func_71207_Z()) {
               return;
            }
         }

         if(p_72510_1_.field_73342_e == 0) {
            if(!this.field_72573_d.func_96290_a(var2, var4, var5, var6, this.field_72574_e)) {
               this.field_72574_e.field_71134_c.func_73074_a(var4, var5, var6, p_72510_1_.field_73341_d);
            } else {
               this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(var4, var5, var6, var2));
            }
         } else if(p_72510_1_.field_73342_e == 2) {
            this.field_72574_e.field_71134_c.func_73082_a(var4, var5, var6);
            if(var2.func_72798_a(var4, var5, var6) != 0) {
               this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(var4, var5, var6, var2));
            }
         } else if(p_72510_1_.field_73342_e == 1) {
            this.field_72574_e.field_71134_c.func_73073_c(var4, var5, var6);
            if(var2.func_72798_a(var4, var5, var6) != 0) {
               this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(var4, var5, var6, var2));
            }
         }

      }
   }

   public void func_72472_a(Packet15Place p_72472_1_) {
      WorldServer var2 = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
      ItemStack var3 = this.field_72574_e.field_71071_by.func_70448_g();
      boolean var4 = false;
      int var5 = p_72472_1_.func_73403_d();
      int var6 = p_72472_1_.func_73402_f();
      int var7 = p_72472_1_.func_73407_g();
      int var8 = p_72472_1_.func_73401_h();
      if(p_72472_1_.func_73401_h() == 255) {
         if(var3 == null) {
            return;
         }

         this.field_72574_e.field_71134_c.func_73085_a(this.field_72574_e, var2, var3);
      } else if(p_72472_1_.func_73402_f() >= this.field_72573_d.func_71207_Z() - 1 && (p_72472_1_.func_73401_h() == 1 || p_72472_1_.func_73402_f() >= this.field_72573_d.func_71207_Z())) {
         this.field_72574_e.field_71135_a.func_72567_b(new Packet3Chat("" + EnumChatFormatting.GRAY + "Height limit for building is " + this.field_72573_d.func_71207_Z()));
         var4 = true;
      } else {
         if(this.field_72587_r && this.field_72574_e.func_70092_e((double)var5 + 0.5D, (double)var6 + 0.5D, (double)var7 + 0.5D) < 64.0D && !this.field_72573_d.func_96290_a(var2, var5, var6, var7, this.field_72574_e)) {
            this.field_72574_e.field_71134_c.func_73078_a(this.field_72574_e, var2, var3, var5, var6, var7, var8, p_72472_1_.func_73406_j(), p_72472_1_.func_73404_l(), p_72472_1_.func_73408_m());
         }

         var4 = true;
      }

      if(var4) {
         this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(var5, var6, var7, var2));
         if(var8 == 0) {
            --var6;
         }

         if(var8 == 1) {
            ++var6;
         }

         if(var8 == 2) {
            --var7;
         }

         if(var8 == 3) {
            ++var7;
         }

         if(var8 == 4) {
            --var5;
         }

         if(var8 == 5) {
            ++var5;
         }

         this.field_72574_e.field_71135_a.func_72567_b(new Packet53BlockChange(var5, var6, var7, var2));
      }

      var3 = this.field_72574_e.field_71071_by.func_70448_g();
      if(var3 != null && var3.field_77994_a == 0) {
         this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c] = null;
         var3 = null;
      }

      if(var3 == null || var3.func_77988_m() == 0) {
         this.field_72574_e.field_71137_h = true;
         this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c] = ItemStack.func_77944_b(this.field_72574_e.field_71071_by.field_70462_a[this.field_72574_e.field_71071_by.field_70461_c]);
         Slot var9 = this.field_72574_e.field_71070_bA.func_75147_a(this.field_72574_e.field_71071_by, this.field_72574_e.field_71071_by.field_70461_c);
         this.field_72574_e.field_71070_bA.func_75142_b();
         this.field_72574_e.field_71137_h = false;
         if(!ItemStack.func_77989_b(this.field_72574_e.field_71071_by.func_70448_g(), p_72472_1_.func_73405_i())) {
            this.func_72567_b(new Packet103SetSlot(this.field_72574_e.field_71070_bA.field_75152_c, var9.field_75222_d, this.field_72574_e.field_71071_by.func_70448_g()));
         }
      }

   }

   public void func_72515_a(String p_72515_1_, Object[] p_72515_2_) {
      this.field_72573_d.func_98033_al().func_98233_a(this.field_72574_e.field_71092_bJ + " lost connection: " + p_72515_1_);
      this.field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat(EnumChatFormatting.YELLOW + this.field_72574_e.func_96090_ax() + " left the game."));
      this.field_72573_d.func_71203_ab().func_72367_e(this.field_72574_e);
      this.field_72576_c = true;
      if(this.field_72573_d.func_71264_H() && this.field_72574_e.field_71092_bJ.equals(this.field_72573_d.func_71214_G())) {
         this.field_72573_d.func_98033_al().func_98233_a("Stopping singleplayer server as player logged out");
         this.field_72573_d.func_71263_m();
      }

   }

   public void func_72509_a(Packet p_72509_1_) {
      this.field_72573_d.func_98033_al().func_98236_b(this.getClass() + " wasn\'t prepared to deal with a " + p_72509_1_.getClass());
      this.func_72565_c("Protocol error, unexpected packet");
   }

   public void func_72567_b(Packet p_72567_1_) {
      if(p_72567_1_ instanceof Packet3Chat) {
         Packet3Chat var2 = (Packet3Chat)p_72567_1_;
         int var3 = this.field_72574_e.func_71126_v();
         if(var3 == 2) {
            return;
         }

         if(var3 == 1 && !var2.func_73475_d()) {
            return;
         }
      }

      try {
         this.field_72575_b.func_74429_a(p_72567_1_);
      } catch (Throwable var5) {
         CrashReport var6 = CrashReport.func_85055_a(var5, "Sending packet");
         CrashReportCategory var4 = var6.func_85058_a("Packet being sent");
         var4.func_71500_a("Packet ID", new CallablePacketID(this, p_72567_1_));
         var4.func_71500_a("Packet class", new CallablePacketClass(this, p_72567_1_));
         throw new ReportedException(var6);
      }
   }

   public void func_72502_a(Packet16BlockItemSwitch p_72502_1_) {
      if(p_72502_1_.field_73386_a >= 0 && p_72502_1_.field_73386_a < InventoryPlayer.func_70451_h()) {
         this.field_72574_e.field_71071_by.field_70461_c = p_72502_1_.field_73386_a;
      } else {
         this.field_72573_d.func_98033_al().func_98236_b(this.field_72574_e.field_71092_bJ + " tried to set an invalid carried item");
      }
   }

   public void func_72481_a(Packet3Chat p_72481_1_) {
      if(this.field_72574_e.func_71126_v() == 2) {
         this.func_72567_b(new Packet3Chat("Cannot send chat message."));
      } else {
         String var2 = p_72481_1_.field_73476_b;
         if(var2.length() > 100) {
            this.func_72565_c("Chat message too long");
         } else {
            var2 = var2.trim();

            for(int var3 = 0; var3 < var2.length(); ++var3) {
               if(!ChatAllowedCharacters.func_71566_a(var2.charAt(var3))) {
                  this.func_72565_c("Illegal characters in chat");
                  return;
               }
            }

            if(var2.startsWith("/")) {
               this.func_72566_d(var2);
            } else {
               if(this.field_72574_e.func_71126_v() == 1) {
                  this.func_72567_b(new Packet3Chat("Cannot send chat message."));
                  return;
               }

               var2 = "<" + this.field_72574_e.func_96090_ax() + "> " + var2;
               this.field_72573_d.func_98033_al().func_98233_a(var2);
               this.field_72573_d.func_71203_ab().func_72384_a(new Packet3Chat(var2, false));
            }

            this.field_72581_m += 20;
            if(this.field_72581_m > 200 && !this.field_72573_d.func_71203_ab().func_72353_e(this.field_72574_e.field_71092_bJ)) {
               this.func_72565_c("disconnect.spam");
            }

         }
      }
   }

   private void func_72566_d(String p_72566_1_) {
      this.field_72573_d.func_71187_D().func_71556_a(this.field_72574_e, p_72566_1_);
   }

   public void func_72524_a(Packet18Animation p_72524_1_) {
      if(p_72524_1_.field_73469_b == 1) {
         this.field_72574_e.func_71038_i();
      }

   }

   public void func_72473_a(Packet19EntityAction p_72473_1_) {
      if(p_72473_1_.field_73366_b == 1) {
         this.field_72574_e.func_70095_a(true);
      } else if(p_72473_1_.field_73366_b == 2) {
         this.field_72574_e.func_70095_a(false);
      } else if(p_72473_1_.field_73366_b == 4) {
         this.field_72574_e.func_70031_b(true);
      } else if(p_72473_1_.field_73366_b == 5) {
         this.field_72574_e.func_70031_b(false);
      } else if(p_72473_1_.field_73366_b == 3) {
         this.field_72574_e.func_70999_a(false, true, true);
         this.field_72587_r = false;
      }

   }

   public void func_72492_a(Packet255KickDisconnect p_72492_1_) {
      this.field_72575_b.func_74424_a("disconnect.quitting", new Object[0]);
   }

   public int func_72568_e() {
      return this.field_72575_b.func_74426_e();
   }

   public void func_72507_a(Packet7UseEntity p_72507_1_) {
      WorldServer var2 = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
      Entity var3 = var2.func_73045_a(p_72507_1_.field_73604_b);
      if(var3 != null) {
         boolean var4 = this.field_72574_e.func_70685_l(var3);
         double var5 = 36.0D;
         if(!var4) {
            var5 = 9.0D;
         }

         if(this.field_72574_e.func_70068_e(var3) < var5) {
            if(p_72507_1_.field_73605_c == 0) {
               this.field_72574_e.func_70998_m(var3);
            } else if(p_72507_1_.field_73605_c == 1) {
               this.field_72574_e.func_71059_n(var3);
            }
         }
      }

   }

   public void func_72458_a(Packet205ClientCommand p_72458_1_) {
      if(p_72458_1_.field_73447_a == 1) {
         if(this.field_72574_e.field_71136_j) {
            this.field_72574_e = this.field_72573_d.func_71203_ab().func_72368_a(this.field_72574_e, 0, true);
         } else if(this.field_72574_e.func_71121_q().func_72912_H().func_76093_s()) {
            if(this.field_72573_d.func_71264_H() && this.field_72574_e.field_71092_bJ.equals(this.field_72573_d.func_71214_G())) {
               this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it\'s game over!");
               this.field_72573_d.func_71272_O();
            } else {
               BanEntry var2 = new BanEntry(this.field_72574_e.field_71092_bJ);
               var2.func_73689_b("Death in Hardcore");
               this.field_72573_d.func_71203_ab().func_72390_e().func_73706_a(var2);
               this.field_72574_e.field_71135_a.func_72565_c("You have died. Game over, man, it\'s game over!");
            }
         } else {
            if(this.field_72574_e.func_70630_aN() > 0) {
               return;
            }

            this.field_72574_e = this.field_72573_d.func_71203_ab().func_72368_a(this.field_72574_e, 0, false);
         }
      }

   }

   public boolean func_72469_b() {
      return true;
   }

   public void func_72483_a(Packet9Respawn p_72483_1_) {}

   public void func_72474_a(Packet101CloseWindow p_72474_1_) {
      this.field_72574_e.func_71128_l();
   }

   public void func_72523_a(Packet102WindowClick p_72523_1_) {
      if(this.field_72574_e.field_71070_bA.field_75152_c == p_72523_1_.field_73444_a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
         ItemStack var2 = this.field_72574_e.field_71070_bA.func_75144_a(p_72523_1_.field_73442_b, p_72523_1_.field_73443_c, p_72523_1_.field_73439_f, this.field_72574_e);
         if(ItemStack.func_77989_b(p_72523_1_.field_73441_e, var2)) {
            this.field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, true));
            this.field_72574_e.field_71137_h = true;
            this.field_72574_e.field_71070_bA.func_75142_b();
            this.field_72574_e.func_71113_k();
            this.field_72574_e.field_71137_h = false;
         } else {
            this.field_72586_s.func_76038_a(this.field_72574_e.field_71070_bA.field_75152_c, Short.valueOf(p_72523_1_.field_73440_d));
            this.field_72574_e.field_71135_a.func_72567_b(new Packet106Transaction(p_72523_1_.field_73444_a, p_72523_1_.field_73440_d, false));
            this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, false);
            ArrayList var3 = new ArrayList();

            for(int var4 = 0; var4 < this.field_72574_e.field_71070_bA.field_75151_b.size(); ++var4) {
               var3.add(((Slot)this.field_72574_e.field_71070_bA.field_75151_b.get(var4)).func_75211_c());
            }

            this.field_72574_e.func_71110_a(this.field_72574_e.field_71070_bA, var3);
         }
      }

   }

   public void func_72479_a(Packet108EnchantItem p_72479_1_) {
      if(this.field_72574_e.field_71070_bA.field_75152_c == p_72479_1_.field_73446_a && this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
         this.field_72574_e.field_71070_bA.func_75140_a(this.field_72574_e, p_72479_1_.field_73445_b);
         this.field_72574_e.field_71070_bA.func_75142_b();
      }

   }

   public void func_72464_a(Packet107CreativeSetSlot p_72464_1_) {
      if(this.field_72574_e.field_71134_c.func_73083_d()) {
         boolean var2 = p_72464_1_.field_73385_a < 0;
         ItemStack var3 = p_72464_1_.field_73384_b;
         boolean var4 = p_72464_1_.field_73385_a >= 1 && p_72464_1_.field_73385_a < 36 + InventoryPlayer.func_70451_h();
         boolean var5 = var3 == null || var3.field_77993_c < Item.field_77698_e.length && var3.field_77993_c >= 0 && Item.field_77698_e[var3.field_77993_c] != null;
         boolean var6 = var3 == null || var3.func_77960_j() >= 0 && var3.func_77960_j() >= 0 && var3.field_77994_a <= 64 && var3.field_77994_a > 0;
         if(var4 && var5 && var6) {
            if(var3 == null) {
               this.field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, (ItemStack)null);
            } else {
               this.field_72574_e.field_71069_bz.func_75141_a(p_72464_1_.field_73385_a, var3);
            }

            this.field_72574_e.field_71069_bz.func_75128_a(this.field_72574_e, true);
         } else if(var2 && var5 && var6 && this.field_72578_n < 200) {
            this.field_72578_n += 20;
            EntityItem var7 = this.field_72574_e.func_71021_b(var3);
            if(var7 != null) {
               var7.func_70288_d();
            }
         }
      }

   }

   public void func_72476_a(Packet106Transaction p_72476_1_) {
      Short var2 = (Short)this.field_72586_s.func_76041_a(this.field_72574_e.field_71070_bA.field_75152_c);
      if(var2 != null && p_72476_1_.field_73433_b == var2.shortValue() && this.field_72574_e.field_71070_bA.field_75152_c == p_72476_1_.field_73435_a && !this.field_72574_e.field_71070_bA.func_75129_b(this.field_72574_e)) {
         this.field_72574_e.field_71070_bA.func_75128_a(this.field_72574_e, true);
      }

   }

   public void func_72487_a(Packet130UpdateSign p_72487_1_) {
      WorldServer var2 = this.field_72573_d.func_71218_a(this.field_72574_e.field_71093_bK);
      if(var2.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c)) {
         TileEntity var3 = var2.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);
         if(var3 instanceof TileEntitySign) {
            TileEntitySign var4 = (TileEntitySign)var3;
            if(!var4.func_70409_a()) {
               this.field_72573_d.func_71236_h("Player " + this.field_72574_e.field_71092_bJ + " just tried to change non-editable sign");
               return;
            }
         }

         int var6;
         int var8;
         for(var8 = 0; var8 < 4; ++var8) {
            boolean var5 = true;
            if(p_72487_1_.field_73308_d[var8].length() > 15) {
               var5 = false;
            } else {
               for(var6 = 0; var6 < p_72487_1_.field_73308_d[var8].length(); ++var6) {
                  if(ChatAllowedCharacters.field_71568_a.indexOf(p_72487_1_.field_73308_d[var8].charAt(var6)) < 0) {
                     var5 = false;
                  }
               }
            }

            if(!var5) {
               p_72487_1_.field_73308_d[var8] = "!?";
            }
         }

         if(var3 instanceof TileEntitySign) {
            var8 = p_72487_1_.field_73311_a;
            int var9 = p_72487_1_.field_73309_b;
            var6 = p_72487_1_.field_73310_c;
            TileEntitySign var7 = (TileEntitySign)var3;
            System.arraycopy(p_72487_1_.field_73308_d, 0, var7.field_70412_a, 0, 4);
            var7.func_70296_d();
            var2.func_72845_h(var8, var9, var6);
         }
      }

   }

   public void func_72477_a(Packet0KeepAlive p_72477_1_) {
      if(p_72477_1_.field_73592_a == this.field_72585_i) {
         int var2 = (int)(System.nanoTime() / 1000000L - this.field_72582_j);
         this.field_72574_e.field_71138_i = (this.field_72574_e.field_71138_i * 3 + var2) / 4;
      }

   }

   public boolean func_72489_a() {
      return true;
   }

   public void func_72471_a(Packet202PlayerAbilities p_72471_1_) {
      this.field_72574_e.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f() && this.field_72574_e.field_71075_bZ.field_75101_c;
   }

   public void func_72461_a(Packet203AutoComplete p_72461_1_) {
      StringBuilder var2 = new StringBuilder();

      String var4;
      for(Iterator var3 = this.field_72573_d.func_71248_a(this.field_72574_e, p_72461_1_.func_73473_d()).iterator(); var3.hasNext(); var2.append(var4)) {
         var4 = (String)var3.next();
         if(var2.length() > 0) {
            var2.append("\u0000");
         }
      }

      this.field_72574_e.field_71135_a.func_72567_b(new Packet203AutoComplete(var2.toString()));
   }

   public void func_72504_a(Packet204ClientInfo p_72504_1_) {
      this.field_72574_e.func_71125_a(p_72504_1_);
   }

   public void func_72501_a(Packet250CustomPayload p_72501_1_) {
      DataInputStream var2;
      ItemStack var3;
      ItemStack var4;
      if("MC|BEdit".equals(p_72501_1_.field_73630_a)) {
         try {
            var2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
            var3 = Packet.func_73276_c(var2);
            if(!ItemWritableBook.func_77829_a(var3.func_77978_p())) {
               throw new IOException("Invalid book tag!");
            }

            var4 = this.field_72574_e.field_71071_by.func_70448_g();
            if(var3 != null && var3.field_77993_c == Item.field_77821_bF.field_77779_bT && var3.field_77993_c == var4.field_77993_c) {
               var4.func_77983_a("pages", var3.func_77978_p().func_74761_m("pages"));
            }
         } catch (Exception var12) {
            var12.printStackTrace();
         }
      } else if("MC|BSign".equals(p_72501_1_.field_73630_a)) {
         try {
            var2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
            var3 = Packet.func_73276_c(var2);
            if(!ItemEditableBook.func_77828_a(var3.func_77978_p())) {
               throw new IOException("Invalid book tag!");
            }

            var4 = this.field_72574_e.field_71071_by.func_70448_g();
            if(var3 != null && var3.field_77993_c == Item.field_77823_bG.field_77779_bT && var4.field_77993_c == Item.field_77821_bF.field_77779_bT) {
               var4.func_77983_a("author", new NBTTagString("author", this.field_72574_e.field_71092_bJ));
               var4.func_77983_a("title", new NBTTagString("title", var3.func_77978_p().func_74779_i("title")));
               var4.func_77983_a("pages", var3.func_77978_p().func_74761_m("pages"));
               var4.field_77993_c = Item.field_77823_bG.field_77779_bT;
            }
         } catch (Exception var11) {
            var11.printStackTrace();
         }
      } else {
         int var14;
         if("MC|TrSel".equals(p_72501_1_.field_73630_a)) {
            try {
               var2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
               var14 = var2.readInt();
               Container var16 = this.field_72574_e.field_71070_bA;
               if(var16 instanceof ContainerMerchant) {
                  ((ContainerMerchant)var16).func_75175_c(var14);
               }
            } catch (Exception var10) {
               var10.printStackTrace();
            }
         } else {
            int var18;
            if("MC|AdvCdm".equals(p_72501_1_.field_73630_a)) {
               if(!this.field_72573_d.func_82356_Z()) {
                  this.field_72574_e.func_70006_a(this.field_72574_e.func_70004_a("advMode.notEnabled", new Object[0]));
               } else if(this.field_72574_e.func_70003_b(2, "") && this.field_72574_e.field_71075_bZ.field_75098_d) {
                  try {
                     var2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                     var14 = var2.readInt();
                     var18 = var2.readInt();
                     int var5 = var2.readInt();
                     String var6 = Packet.func_73282_a(var2, 256);
                     TileEntity var7 = this.field_72574_e.field_70170_p.func_72796_p(var14, var18, var5);
                     if(var7 != null && var7 instanceof TileEntityCommandBlock) {
                        ((TileEntityCommandBlock)var7).func_82352_b(var6);
                        this.field_72574_e.field_70170_p.func_72845_h(var14, var18, var5);
                        this.field_72574_e.func_70006_a("Command set: " + var6);
                     }
                  } catch (Exception var9) {
                     var9.printStackTrace();
                  }
               } else {
                  this.field_72574_e.func_70006_a(this.field_72574_e.func_70004_a("advMode.notAllowed", new Object[0]));
               }
            } else if("MC|Beacon".equals(p_72501_1_.field_73630_a)) {
               if(this.field_72574_e.field_71070_bA instanceof ContainerBeacon) {
                  try {
                     var2 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));
                     var14 = var2.readInt();
                     var18 = var2.readInt();
                     ContainerBeacon var17 = (ContainerBeacon)this.field_72574_e.field_71070_bA;
                     Slot var19 = var17.func_75139_a(0);
                     if(var19.func_75216_d()) {
                        var19.func_75209_a(1);
                        TileEntityBeacon var20 = var17.func_82863_d();
                        var20.func_82128_d(var14);
                        var20.func_82127_e(var18);
                        var20.func_70296_d();
                     }
                  } catch (Exception var8) {
                     var8.printStackTrace();
                  }
               }
            } else if("MC|ItemName".equals(p_72501_1_.field_73630_a) && this.field_72574_e.field_71070_bA instanceof ContainerRepair) {
               ContainerRepair var13 = (ContainerRepair)this.field_72574_e.field_71070_bA;
               if(p_72501_1_.field_73629_c != null && p_72501_1_.field_73629_c.length >= 1) {
                  String var15 = ChatAllowedCharacters.func_71565_a(new String(p_72501_1_.field_73629_c));
                  if(var15.length() <= 30) {
                     var13.func_82850_a(var15);
                  }
               } else {
                  var13.func_82850_a("");
               }
            }
         }
      }

   }

}
