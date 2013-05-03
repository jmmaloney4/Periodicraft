package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiPlayerInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenDemo;
import net.minecraft.client.gui.GuiScreenDisconnectedOnline;
import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.multiplayer.NetClientWebTextures;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.entity.effect.EntityLightningBolt;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.MemoryConnection;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet200Statistic;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet206SetObjective;
import net.minecraft.network.packet.Packet207SetScore;
import net.minecraft.network.packet.Packet208SetDisplayObjective;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet253ServerAuthData;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26EntityExpOrb;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet35EntityHeadRotation;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet42RemoveEntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet51MapChunk;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet62LevelSound;
import net.minecraft.network.packet.Packet63WorldParticles;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CryptManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StringTranslate;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class NetClientHandler extends NetHandler {

   private boolean field_72554_f = false;
   private INetworkManager field_72555_g;
   public String field_72560_a;
   private Minecraft field_72563_h;
   private WorldClient field_72564_i;
   private boolean field_72561_j = false;
   public MapStorage field_72558_b = new MapStorage((ISaveHandler)null);
   private Map field_72562_k = new HashMap();
   public List field_72559_c = new ArrayList();
   public int field_72556_d = 20;
   private GuiScreen field_98183_l = null;
   Random field_72557_e = new Random();


   public NetClientHandler(Minecraft p_i3103_1_, String p_i3103_2_, int p_i3103_3_) throws IOException {
      this.field_72563_h = p_i3103_1_;
      Socket var4 = new Socket(InetAddress.getByName(p_i3103_2_), p_i3103_3_);
      this.field_72555_g = new TcpConnection(p_i3103_1_.func_98033_al(), var4, "Client", this);
   }

   public NetClientHandler(Minecraft p_i11012_1_, String p_i11012_2_, int p_i11012_3_, GuiScreen p_i11012_4_) throws IOException {
      this.field_72563_h = p_i11012_1_;
      this.field_98183_l = p_i11012_4_;
      Socket var5 = new Socket(InetAddress.getByName(p_i11012_2_), p_i11012_3_);
      this.field_72555_g = new TcpConnection(p_i11012_1_.func_98033_al(), var5, "Client", this);
   }

   public NetClientHandler(Minecraft p_i3104_1_, IntegratedServer p_i3104_2_) throws IOException {
      this.field_72563_h = p_i3104_1_;
      this.field_72555_g = new MemoryConnection(p_i3104_1_.func_98033_al(), this);
      p_i3104_2_.func_71343_a().func_71754_a((MemoryConnection)this.field_72555_g, p_i3104_1_.field_71449_j.field_74286_b);
   }

   public void func_72547_c() {
      if(this.field_72555_g != null) {
         this.field_72555_g.func_74427_a();
      }

      this.field_72555_g = null;
      this.field_72564_i = null;
   }

   public void func_72551_d() {
      if(!this.field_72554_f && this.field_72555_g != null) {
         this.field_72555_g.func_74428_b();
      }

      if(this.field_72555_g != null) {
         this.field_72555_g.func_74427_a();
      }

   }

   public void func_72470_a(Packet253ServerAuthData p_72470_1_) {
      String var2 = p_72470_1_.func_73377_d().trim();
      PublicKey var3 = p_72470_1_.func_73376_f();
      SecretKey var4 = CryptManager.func_75890_a();
      if(!"-".equals(var2)) {
         String var5 = (new BigInteger(CryptManager.func_75895_a(var2, var3, var4))).toString(16);
         String var6 = this.func_72550_a(this.field_72563_h.field_71449_j.field_74286_b, this.field_72563_h.field_71449_j.field_74287_c, var5);
         if(!"ok".equalsIgnoreCase(var6)) {
            this.field_72555_g.func_74424_a("disconnect.loginFailedInfo", new Object[]{var6});
            return;
         }
      }

      this.func_72552_c(new Packet252SharedKey(var4, var3, p_72470_1_.func_73378_g()));
   }

   private String func_72550_a(String p_72550_1_, String p_72550_2_, String p_72550_3_) {
      try {
         URL var4 = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + func_72549_a(p_72550_1_) + "&sessionId=" + func_72549_a(p_72550_2_) + "&serverId=" + func_72549_a(p_72550_3_));
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var4.openStream()));
         String var6 = var5.readLine();
         var5.close();
         return var6;
      } catch (IOException var7) {
         return var7.toString();
      }
   }

   private static String func_72549_a(String p_72549_0_) throws IOException {
      return URLEncoder.encode(p_72549_0_, "UTF-8");
   }

   public void func_72513_a(Packet252SharedKey p_72513_1_) {
      this.func_72552_c(new Packet205ClientCommand(0));
   }

   public void func_72455_a(Packet1Login p_72455_1_) {
      this.field_72563_h.field_71442_b = new PlayerControllerMP(this.field_72563_h, this);
      this.field_72563_h.field_71413_E.func_77450_a(StatList.field_75950_i, 1);
      this.field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72455_1_.field_73557_d, false, p_72455_1_.field_73560_c, p_72455_1_.field_73559_b), p_72455_1_.field_73558_e, p_72455_1_.field_73555_f, this.field_72563_h.field_71424_I, this.field_72563_h.func_98033_al());
      this.field_72564_i.field_72995_K = true;
      this.field_72563_h.func_71403_a(this.field_72564_i);
      this.field_72563_h.field_71439_g.field_71093_bK = p_72455_1_.field_73558_e;
      this.field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
      this.field_72563_h.field_71439_g.field_70157_k = p_72455_1_.field_73561_a;
      this.field_72556_d = p_72455_1_.field_73562_h;
      this.field_72563_h.field_71442_b.func_78746_a(p_72455_1_.field_73557_d);
      this.field_72563_h.field_71474_y.func_82879_c();
   }

   public void func_72511_a(Packet23VehicleSpawn p_72511_1_) {
      double var2 = (double)p_72511_1_.field_73524_b / 32.0D;
      double var4 = (double)p_72511_1_.field_73525_c / 32.0D;
      double var6 = (double)p_72511_1_.field_73522_d / 32.0D;
      Object var8 = null;
      if(p_72511_1_.field_73527_h == 10) {
         var8 = EntityMinecart.func_94090_a(this.field_72564_i, var2, var4, var6, p_72511_1_.field_73528_i);
      } else if(p_72511_1_.field_73527_h == 90) {
         Entity var9 = this.func_72545_a(p_72511_1_.field_73528_i);
         if(var9 instanceof EntityPlayer) {
            var8 = new EntityFishHook(this.field_72564_i, var2, var4, var6, (EntityPlayer)var9);
         }

         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 60) {
         var8 = new EntityArrow(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 61) {
         var8 = new EntitySnowball(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 71) {
         var8 = new EntityItemFrame(this.field_72564_i, (int)var2, (int)var4, (int)var6, p_72511_1_.field_73528_i);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 65) {
         var8 = new EntityEnderPearl(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 72) {
         var8 = new EntityEnderEye(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 76) {
         var8 = new EntityFireworkRocket(this.field_72564_i, var2, var4, var6, (ItemStack)null);
      } else if(p_72511_1_.field_73527_h == 63) {
         var8 = new EntityLargeFireball(this.field_72564_i, var2, var4, var6, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 64) {
         var8 = new EntitySmallFireball(this.field_72564_i, var2, var4, var6, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 66) {
         var8 = new EntityWitherSkull(this.field_72564_i, var2, var4, var6, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 62) {
         var8 = new EntityEgg(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 73) {
         var8 = new EntityPotion(this.field_72564_i, var2, var4, var6, p_72511_1_.field_73528_i);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 75) {
         var8 = new EntityExpBottle(this.field_72564_i, var2, var4, var6);
         p_72511_1_.field_73528_i = 0;
      } else if(p_72511_1_.field_73527_h == 1) {
         var8 = new EntityBoat(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 50) {
         var8 = new EntityTNTPrimed(this.field_72564_i, var2, var4, var6, (EntityLiving)null);
      } else if(p_72511_1_.field_73527_h == 51) {
         var8 = new EntityEnderCrystal(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 2) {
         var8 = new EntityItem(this.field_72564_i, var2, var4, var6);
      } else if(p_72511_1_.field_73527_h == 70) {
         var8 = new EntityFallingSand(this.field_72564_i, var2, var4, var6, p_72511_1_.field_73528_i & '\uffff', p_72511_1_.field_73528_i >> 16);
         p_72511_1_.field_73528_i = 0;
      }

      if(var8 != null) {
         ((Entity)var8).field_70118_ct = p_72511_1_.field_73524_b;
         ((Entity)var8).field_70117_cu = p_72511_1_.field_73525_c;
         ((Entity)var8).field_70116_cv = p_72511_1_.field_73522_d;
         ((Entity)var8).field_70125_A = (float)(p_72511_1_.field_92077_h * 360) / 256.0F;
         ((Entity)var8).field_70177_z = (float)(p_72511_1_.field_92078_i * 360) / 256.0F;
         Entity[] var12 = ((Entity)var8).func_70021_al();
         if(var12 != null) {
            int var10 = p_72511_1_.field_73526_a - ((Entity)var8).field_70157_k;

            for(int var11 = 0; var11 < var12.length; ++var11) {
               var12[var11].field_70157_k += var10;
            }
         }

         ((Entity)var8).field_70157_k = p_72511_1_.field_73526_a;
         this.field_72564_i.func_73027_a(p_72511_1_.field_73526_a, (Entity)var8);
         if(p_72511_1_.field_73528_i > 0) {
            if(p_72511_1_.field_73527_h == 60) {
               Entity var13 = this.func_72545_a(p_72511_1_.field_73528_i);
               if(var13 instanceof EntityLiving) {
                  EntityArrow var14 = (EntityArrow)var8;
                  var14.field_70250_c = var13;
               }
            }

            ((Entity)var8).func_70016_h((double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
         }
      }

   }

   public void func_72514_a(Packet26EntityExpOrb p_72514_1_) {
      EntityXPOrb var2 = new EntityXPOrb(this.field_72564_i, (double)p_72514_1_.field_73531_b, (double)p_72514_1_.field_73532_c, (double)p_72514_1_.field_73529_d, p_72514_1_.field_73530_e);
      var2.field_70118_ct = p_72514_1_.field_73531_b;
      var2.field_70117_cu = p_72514_1_.field_73532_c;
      var2.field_70116_cv = p_72514_1_.field_73529_d;
      var2.field_70177_z = 0.0F;
      var2.field_70125_A = 0.0F;
      var2.field_70157_k = p_72514_1_.field_73533_a;
      this.field_72564_i.func_73027_a(p_72514_1_.field_73533_a, var2);
   }

   public void func_72508_a(Packet71Weather p_72508_1_) {
      double var2 = (double)p_72508_1_.field_73536_b / 32.0D;
      double var4 = (double)p_72508_1_.field_73537_c / 32.0D;
      double var6 = (double)p_72508_1_.field_73534_d / 32.0D;
      EntityLightningBolt var8 = null;
      if(p_72508_1_.field_73535_e == 1) {
         var8 = new EntityLightningBolt(this.field_72564_i, var2, var4, var6);
      }

      if(var8 != null) {
         var8.field_70118_ct = p_72508_1_.field_73536_b;
         var8.field_70117_cu = p_72508_1_.field_73537_c;
         var8.field_70116_cv = p_72508_1_.field_73534_d;
         var8.field_70177_z = 0.0F;
         var8.field_70125_A = 0.0F;
         var8.field_70157_k = p_72508_1_.field_73538_a;
         this.field_72564_i.func_72942_c(var8);
      }

   }

   public void func_72495_a(Packet25EntityPainting p_72495_1_) {
      EntityPainting var2 = new EntityPainting(this.field_72564_i, p_72495_1_.field_73506_b, p_72495_1_.field_73507_c, p_72495_1_.field_73504_d, p_72495_1_.field_73505_e, p_72495_1_.field_73503_f);
      this.field_72564_i.func_73027_a(p_72495_1_.field_73508_a, var2);
   }

   public void func_72520_a(Packet28EntityVelocity p_72520_1_) {
      Entity var2 = this.func_72545_a(p_72520_1_.field_73390_a);
      if(var2 != null) {
         var2.func_70016_h((double)p_72520_1_.field_73388_b / 8000.0D, (double)p_72520_1_.field_73389_c / 8000.0D, (double)p_72520_1_.field_73387_d / 8000.0D);
      }
   }

   public void func_72493_a(Packet40EntityMetadata p_72493_1_) {
      Entity var2 = this.func_72545_a(p_72493_1_.field_73393_a);
      if(var2 != null && p_72493_1_.func_73391_d() != null) {
         var2.func_70096_w().func_75687_a(p_72493_1_.func_73391_d());
      }

   }

   public void func_72518_a(Packet20NamedEntitySpawn p_72518_1_) {
      double var2 = (double)p_72518_1_.field_73515_c / 32.0D;
      double var4 = (double)p_72518_1_.field_73512_d / 32.0D;
      double var6 = (double)p_72518_1_.field_73513_e / 32.0D;
      float var8 = (float)(p_72518_1_.field_73510_f * 360) / 256.0F;
      float var9 = (float)(p_72518_1_.field_73511_g * 360) / 256.0F;
      EntityOtherPlayerMP var10 = new EntityOtherPlayerMP(this.field_72563_h.field_71441_e, p_72518_1_.field_73514_b);
      var10.field_70169_q = var10.field_70142_S = (double)(var10.field_70118_ct = p_72518_1_.field_73515_c);
      var10.field_70167_r = var10.field_70137_T = (double)(var10.field_70117_cu = p_72518_1_.field_73512_d);
      var10.field_70166_s = var10.field_70136_U = (double)(var10.field_70116_cv = p_72518_1_.field_73513_e);
      int var11 = p_72518_1_.field_73518_h;
      if(var11 == 0) {
         var10.field_71071_by.field_70462_a[var10.field_71071_by.field_70461_c] = null;
      } else {
         var10.field_71071_by.field_70462_a[var10.field_71071_by.field_70461_c] = new ItemStack(var11, 1, 0);
      }

      var10.func_70080_a(var2, var4, var6, var8, var9);
      this.field_72564_i.func_73027_a(p_72518_1_.field_73516_a, var10);
      List var12 = p_72518_1_.func_73509_c();
      if(var12 != null) {
         var10.func_70096_w().func_75687_a(var12);
      }

   }

   public void func_72512_a(Packet34EntityTeleport p_72512_1_) {
      Entity var2 = this.func_72545_a(p_72512_1_.field_73319_a);
      if(var2 != null) {
         var2.field_70118_ct = p_72512_1_.field_73317_b;
         var2.field_70117_cu = p_72512_1_.field_73318_c;
         var2.field_70116_cv = p_72512_1_.field_73315_d;
         double var3 = (double)var2.field_70118_ct / 32.0D;
         double var5 = (double)var2.field_70117_cu / 32.0D + 0.015625D;
         double var7 = (double)var2.field_70116_cv / 32.0D;
         float var9 = (float)(p_72512_1_.field_73316_e * 360) / 256.0F;
         float var10 = (float)(p_72512_1_.field_73314_f * 360) / 256.0F;
         var2.func_70056_a(var3, var5, var7, var9, var10, 3);
      }
   }

   public void func_72502_a(Packet16BlockItemSwitch p_72502_1_) {
      if(p_72502_1_.field_73386_a >= 0 && p_72502_1_.field_73386_a < InventoryPlayer.func_70451_h()) {
         this.field_72563_h.field_71439_g.field_71071_by.field_70461_c = p_72502_1_.field_73386_a;
      }

   }

   public void func_72482_a(Packet30Entity p_72482_1_) {
      Entity var2 = this.func_72545_a(p_72482_1_.field_73554_a);
      if(var2 != null) {
         var2.field_70118_ct += p_72482_1_.field_73552_b;
         var2.field_70117_cu += p_72482_1_.field_73553_c;
         var2.field_70116_cv += p_72482_1_.field_73550_d;
         double var3 = (double)var2.field_70118_ct / 32.0D;
         double var5 = (double)var2.field_70117_cu / 32.0D;
         double var7 = (double)var2.field_70116_cv / 32.0D;
         float var9 = p_72482_1_.field_73549_g?(float)(p_72482_1_.field_73551_e * 360) / 256.0F:var2.field_70177_z;
         float var10 = p_72482_1_.field_73549_g?(float)(p_72482_1_.field_73548_f * 360) / 256.0F:var2.field_70125_A;
         var2.func_70056_a(var3, var5, var7, var9, var10, 3);
      }
   }

   public void func_72478_a(Packet35EntityHeadRotation p_72478_1_) {
      Entity var2 = this.func_72545_a(p_72478_1_.field_73383_a);
      if(var2 != null) {
         float var3 = (float)(p_72478_1_.field_73382_b * 360) / 256.0F;
         var2.func_70034_d(var3);
      }
   }

   public void func_72491_a(Packet29DestroyEntity p_72491_1_) {
      for(int var2 = 0; var2 < p_72491_1_.field_73368_a.length; ++var2) {
         this.field_72564_i.func_73028_b(p_72491_1_.field_73368_a[var2]);
      }

   }

   public void func_72498_a(Packet10Flying p_72498_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      double var3 = var2.field_70165_t;
      double var5 = var2.field_70163_u;
      double var7 = var2.field_70161_v;
      float var9 = var2.field_70177_z;
      float var10 = var2.field_70125_A;
      if(p_72498_1_.field_73546_h) {
         var3 = p_72498_1_.field_73545_a;
         var5 = p_72498_1_.field_73543_b;
         var7 = p_72498_1_.field_73544_c;
      }

      if(p_72498_1_.field_73547_i) {
         var9 = p_72498_1_.field_73542_e;
         var10 = p_72498_1_.field_73539_f;
      }

      var2.field_70139_V = 0.0F;
      var2.field_70159_w = var2.field_70181_x = var2.field_70179_y = 0.0D;
      var2.func_70080_a(var3, var5, var7, var9, var10);
      p_72498_1_.field_73545_a = var2.field_70165_t;
      p_72498_1_.field_73543_b = var2.field_70121_D.field_72338_b;
      p_72498_1_.field_73544_c = var2.field_70161_v;
      p_72498_1_.field_73541_d = var2.field_70163_u;
      this.field_72555_g.func_74429_a(p_72498_1_);
      if(!this.field_72561_j) {
         this.field_72563_h.field_71439_g.field_70169_q = this.field_72563_h.field_71439_g.field_70165_t;
         this.field_72563_h.field_71439_g.field_70167_r = this.field_72563_h.field_71439_g.field_70163_u;
         this.field_72563_h.field_71439_g.field_70166_s = this.field_72563_h.field_71439_g.field_70161_v;
         this.field_72561_j = true;
         this.field_72563_h.func_71373_a((GuiScreen)null);
      }

   }

   public void func_72496_a(Packet52MultiBlockChange p_72496_1_) {
      int var2 = p_72496_1_.field_73452_a * 16;
      int var3 = p_72496_1_.field_73450_b * 16;
      if(p_72496_1_.field_73451_c != null) {
         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(p_72496_1_.field_73451_c));

         try {
            for(int var5 = 0; var5 < p_72496_1_.field_73448_d; ++var5) {
               short var6 = var4.readShort();
               short var7 = var4.readShort();
               int var8 = var7 >> 4 & 4095;
               int var9 = var7 & 15;
               int var10 = var6 >> 12 & 15;
               int var11 = var6 >> 8 & 15;
               int var12 = var6 & 255;
               this.field_72564_i.func_73023_g(var10 + var2, var12, var11 + var3, var8, var9);
            }
         } catch (IOException var13) {
            ;
         }

      }
   }

   public void func_72463_a(Packet51MapChunk p_72463_1_) {
      if(p_72463_1_.field_73598_e) {
         if(p_72463_1_.field_73600_c == 0) {
            this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, false);
            return;
         }

         this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
      }

      this.field_72564_i.func_73031_a(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);
      Chunk var2 = this.field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);
      if(p_72463_1_.field_73598_e && var2 == null) {
         this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
         var2 = this.field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);
      }

      if(var2 != null) {
         var2.func_76607_a(p_72463_1_.func_73593_d(), p_72463_1_.field_73600_c, p_72463_1_.field_73597_d, p_72463_1_.field_73598_e);
         this.field_72564_i.func_72909_d(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);
         if(!p_72463_1_.field_73598_e || !(this.field_72564_i.field_73011_w instanceof WorldProviderSurface)) {
            var2.func_76613_n();
         }
      }

   }

   public void func_72456_a(Packet53BlockChange p_72456_1_) {
      this.field_72564_i.func_73023_g(p_72456_1_.field_73425_a, p_72456_1_.field_73423_b, p_72456_1_.field_73424_c, p_72456_1_.field_73421_d, p_72456_1_.field_73422_e);
   }

   public void func_72492_a(Packet255KickDisconnect p_72492_1_) {
      this.field_72555_g.func_74424_a("disconnect.kicked", new Object[0]);
      this.field_72554_f = true;
      this.field_72563_h.func_71403_a((WorldClient)null);
      if(this.field_98183_l != null) {
         this.field_72563_h.func_71373_a(new GuiScreenDisconnectedOnline(this.field_98183_l, "disconnect.disconnected", "disconnect.genericReason", new Object[]{p_72492_1_.field_73631_a}));
      } else {
         this.field_72563_h.func_71373_a(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.disconnected", "disconnect.genericReason", new Object[]{p_72492_1_.field_73631_a}));
      }

   }

   public void func_72515_a(String p_72515_1_, Object[] p_72515_2_) {
      if(!this.field_72554_f) {
         this.field_72554_f = true;
         this.field_72563_h.func_71403_a((WorldClient)null);
         if(this.field_98183_l != null) {
            this.field_72563_h.func_71373_a(new GuiScreenDisconnectedOnline(this.field_98183_l, "disconnect.lost", p_72515_1_, p_72515_2_));
         } else {
            this.field_72563_h.func_71373_a(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", p_72515_1_, p_72515_2_));
         }

      }
   }

   public void func_72546_b(Packet p_72546_1_) {
      if(!this.field_72554_f) {
         this.field_72555_g.func_74429_a(p_72546_1_);
         this.field_72555_g.func_74423_d();
      }
   }

   public void func_72552_c(Packet p_72552_1_) {
      if(!this.field_72554_f) {
         this.field_72555_g.func_74429_a(p_72552_1_);
      }
   }

   public void func_72475_a(Packet22Collect p_72475_1_) {
      Entity var2 = this.func_72545_a(p_72475_1_.field_73313_a);
      Object var3 = (EntityLiving)this.func_72545_a(p_72475_1_.field_73312_b);
      if(var3 == null) {
         var3 = this.field_72563_h.field_71439_g;
      }

      if(var2 != null) {
         if(var2 instanceof EntityXPOrb) {
            this.field_72564_i.func_72956_a(var2, "random.orb", 0.2F, ((this.field_72557_e.nextFloat() - this.field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         } else {
            this.field_72564_i.func_72956_a(var2, "random.pop", 0.2F, ((this.field_72557_e.nextFloat() - this.field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         }

         this.field_72563_h.field_71452_i.func_78873_a(new EntityPickupFX(this.field_72563_h.field_71441_e, var2, (Entity)var3, -0.5F));
         this.field_72564_i.func_73028_b(p_72475_1_.field_73313_a);
      }

   }

   public void func_72481_a(Packet3Chat p_72481_1_) {
      this.field_72563_h.field_71456_v.func_73827_b().func_73765_a(p_72481_1_.field_73476_b);
   }

   public void func_72524_a(Packet18Animation p_72524_1_) {
      Entity var2 = this.func_72545_a(p_72524_1_.field_73470_a);
      if(var2 != null) {
         if(p_72524_1_.field_73469_b == 1) {
            EntityLiving var3 = (EntityLiving)var2;
            var3.func_71038_i();
         } else if(p_72524_1_.field_73469_b == 2) {
            var2.func_70057_ab();
         } else if(p_72524_1_.field_73469_b == 3) {
            EntityPlayer var4 = (EntityPlayer)var2;
            var4.func_70999_a(false, false, false);
         } else if(p_72524_1_.field_73469_b != 4) {
            if(p_72524_1_.field_73469_b == 6) {
               this.field_72563_h.field_71452_i.func_78873_a(new EntityCrit2FX(this.field_72563_h.field_71441_e, var2));
            } else if(p_72524_1_.field_73469_b == 7) {
               EntityCrit2FX var5 = new EntityCrit2FX(this.field_72563_h.field_71441_e, var2, "magicCrit");
               this.field_72563_h.field_71452_i.func_78873_a(var5);
            } else if(p_72524_1_.field_73469_b == 5 && var2 instanceof EntityOtherPlayerMP) {
               ;
            }
         }

      }
   }

   public void func_72460_a(Packet17Sleep p_72460_1_) {
      Entity var2 = this.func_72545_a(p_72460_1_.field_73625_a);
      if(var2 != null) {
         if(p_72460_1_.field_73622_e == 0) {
            EntityPlayer var3 = (EntityPlayer)var2;
            var3.func_71018_a(p_72460_1_.field_73623_b, p_72460_1_.field_73624_c, p_72460_1_.field_73621_d);
         }

      }
   }

   public void func_72553_e() {
      this.field_72554_f = true;
      this.field_72555_g.func_74427_a();
      this.field_72555_g.func_74424_a("disconnect.closed", new Object[0]);
   }

   public void func_72519_a(Packet24MobSpawn p_72519_1_) {
      double var2 = (double)p_72519_1_.field_73495_c / 32.0D;
      double var4 = (double)p_72519_1_.field_73492_d / 32.0D;
      double var6 = (double)p_72519_1_.field_73493_e / 32.0D;
      float var8 = (float)(p_72519_1_.field_73500_i * 360) / 256.0F;
      float var9 = (float)(p_72519_1_.field_73497_j * 360) / 256.0F;
      EntityLiving var10 = (EntityLiving)EntityList.func_75616_a(p_72519_1_.field_73494_b, this.field_72563_h.field_71441_e);
      var10.field_70118_ct = p_72519_1_.field_73495_c;
      var10.field_70117_cu = p_72519_1_.field_73492_d;
      var10.field_70116_cv = p_72519_1_.field_73493_e;
      var10.field_70759_as = (float)(p_72519_1_.field_73498_k * 360) / 256.0F;
      Entity[] var11 = var10.func_70021_al();
      if(var11 != null) {
         int var12 = p_72519_1_.field_73496_a - var10.field_70157_k;

         for(int var13 = 0; var13 < var11.length; ++var13) {
            var11[var13].field_70157_k += var12;
         }
      }

      var10.field_70157_k = p_72519_1_.field_73496_a;
      var10.func_70080_a(var2, var4, var6, var8, var9);
      var10.field_70159_w = (double)((float)p_72519_1_.field_73490_f / 8000.0F);
      var10.field_70181_x = (double)((float)p_72519_1_.field_73491_g / 8000.0F);
      var10.field_70179_y = (double)((float)p_72519_1_.field_73499_h / 8000.0F);
      this.field_72564_i.func_73027_a(p_72519_1_.field_73496_a, var10);
      List var14 = p_72519_1_.func_73489_c();
      if(var14 != null) {
         var10.func_70096_w().func_75687_a(var14);
      }

   }

   public void func_72497_a(Packet4UpdateTime p_72497_1_) {
      this.field_72563_h.field_71441_e.func_82738_a(p_72497_1_.field_82562_a);
      this.field_72563_h.field_71441_e.func_72877_b(p_72497_1_.field_73301_a);
   }

   public void func_72466_a(Packet6SpawnPosition p_72466_1_) {
      this.field_72563_h.field_71439_g.func_71063_a(new ChunkCoordinates(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c), true);
      this.field_72563_h.field_71441_e.func_72912_H().func_76081_a(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c);
   }

   public void func_72484_a(Packet39AttachEntity p_72484_1_) {
      Object var2 = this.func_72545_a(p_72484_1_.field_73297_a);
      Entity var3 = this.func_72545_a(p_72484_1_.field_73296_b);
      if(p_72484_1_.field_73297_a == this.field_72563_h.field_71439_g.field_70157_k) {
         var2 = this.field_72563_h.field_71439_g;
         if(var3 instanceof EntityBoat) {
            ((EntityBoat)var3).func_70270_d(false);
         }
      } else if(var3 instanceof EntityBoat) {
         ((EntityBoat)var3).func_70270_d(true);
      }

      if(var2 != null) {
         ((Entity)var2).func_70078_a(var3);
      }
   }

   public void func_72485_a(Packet38EntityStatus p_72485_1_) {
      Entity var2 = this.func_72545_a(p_72485_1_.field_73627_a);
      if(var2 != null) {
         var2.func_70103_a(p_72485_1_.field_73626_b);
      }

   }

   private Entity func_72545_a(int p_72545_1_) {
      return (Entity)(p_72545_1_ == this.field_72563_h.field_71439_g.field_70157_k?this.field_72563_h.field_71439_g:this.field_72564_i.func_73045_a(p_72545_1_));
   }

   public void func_72521_a(Packet8UpdateHealth p_72521_1_) {
      this.field_72563_h.field_71439_g.func_71150_b(p_72521_1_.field_73640_a);
      this.field_72563_h.field_71439_g.func_71024_bL().func_75114_a(p_72521_1_.field_73638_b);
      this.field_72563_h.field_71439_g.func_71024_bL().func_75119_b(p_72521_1_.field_73639_c);
   }

   public void func_72522_a(Packet43Experience p_72522_1_) {
      this.field_72563_h.field_71439_g.func_71152_a(p_72522_1_.field_73396_a, p_72522_1_.field_73394_b, p_72522_1_.field_73395_c);
   }

   public void func_72483_a(Packet9Respawn p_72483_1_) {
      if(p_72483_1_.field_73373_a != this.field_72563_h.field_71439_g.field_71093_bK) {
         this.field_72561_j = false;
         Scoreboard var2 = this.field_72564_i.func_96441_U();
         this.field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72483_1_.field_73369_d, false, this.field_72563_h.field_71441_e.func_72912_H().func_76093_s(), p_72483_1_.field_73370_e), p_72483_1_.field_73373_a, p_72483_1_.field_73371_b, this.field_72563_h.field_71424_I, this.field_72563_h.func_98033_al());
         this.field_72564_i.func_96443_a(var2);
         this.field_72564_i.field_72995_K = true;
         this.field_72563_h.func_71403_a(this.field_72564_i);
         this.field_72563_h.field_71439_g.field_71093_bK = p_72483_1_.field_73373_a;
         this.field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
      }

      this.field_72563_h.func_71354_a(p_72483_1_.field_73373_a);
      this.field_72563_h.field_71442_b.func_78746_a(p_72483_1_.field_73369_d);
   }

   public void func_72499_a(Packet60Explosion p_72499_1_) {
      Explosion var2 = new Explosion(this.field_72563_h.field_71441_e, (Entity)null, p_72499_1_.field_73616_a, p_72499_1_.field_73614_b, p_72499_1_.field_73615_c, p_72499_1_.field_73612_d);
      var2.field_77281_g = p_72499_1_.field_73613_e;
      var2.func_77279_a(true);
      this.field_72563_h.field_71439_g.field_70159_w += (double)p_72499_1_.func_73607_d();
      this.field_72563_h.field_71439_g.field_70181_x += (double)p_72499_1_.func_73609_f();
      this.field_72563_h.field_71439_g.field_70179_y += (double)p_72499_1_.func_73608_g();
   }

   public void func_72516_a(Packet100OpenWindow p_72516_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      switch(p_72516_1_.field_73429_b) {
      case 0:
         var2.func_71007_a(new InventoryBasic(p_72516_1_.field_73430_c, p_72516_1_.field_94500_e, p_72516_1_.field_73428_d));
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 1:
         var2.func_71058_b(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70163_u), MathHelper.func_76128_c(var2.field_70161_v));
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 2:
         TileEntityFurnace var4 = new TileEntityFurnace();
         if(p_72516_1_.field_94500_e) {
            var4.func_94129_a(p_72516_1_.field_73430_c);
         }

         var2.func_71042_a(var4);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 3:
         TileEntityDispenser var7 = new TileEntityDispenser();
         if(p_72516_1_.field_94500_e) {
            var7.func_94049_a(p_72516_1_.field_73430_c);
         }

         var2.func_71006_a(var7);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 4:
         var2.func_71002_c(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70163_u), MathHelper.func_76128_c(var2.field_70161_v), p_72516_1_.field_94500_e?p_72516_1_.field_73430_c:null);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 5:
         TileEntityBrewingStand var5 = new TileEntityBrewingStand();
         if(p_72516_1_.field_94500_e) {
            var5.func_94131_a(p_72516_1_.field_73430_c);
         }

         var2.func_71017_a(var5);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 6:
         var2.func_71030_a(new NpcMerchant(var2), p_72516_1_.field_94500_e?p_72516_1_.field_73430_c:null);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 7:
         TileEntityBeacon var8 = new TileEntityBeacon();
         var2.func_82240_a(var8);
         if(p_72516_1_.field_94500_e) {
            var8.func_94047_a(p_72516_1_.field_73430_c);
         }

         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 8:
         var2.func_82244_d(MathHelper.func_76128_c(var2.field_70165_t), MathHelper.func_76128_c(var2.field_70163_u), MathHelper.func_76128_c(var2.field_70161_v));
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 9:
         TileEntityHopper var3 = new TileEntityHopper();
         if(p_72516_1_.field_94500_e) {
            var3.func_96115_a(p_72516_1_.field_73430_c);
         }

         var2.func_94064_a(var3);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
         break;
      case 10:
         TileEntityDropper var6 = new TileEntityDropper();
         if(p_72516_1_.field_94500_e) {
            var6.func_94049_a(p_72516_1_.field_73430_c);
         }

         var2.func_71006_a(var6);
         var2.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
      }

   }

   public void func_72490_a(Packet103SetSlot p_72490_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      if(p_72490_1_.field_73637_a == -1) {
         var2.field_71071_by.func_70437_b(p_72490_1_.field_73636_c);
      } else {
         boolean var3 = false;
         if(this.field_72563_h.field_71462_r instanceof GuiContainerCreative) {
            GuiContainerCreative var4 = (GuiContainerCreative)this.field_72563_h.field_71462_r;
            var3 = var4.func_74230_h() != CreativeTabs.field_78036_m.func_78021_a();
         }

         if(p_72490_1_.field_73637_a == 0 && p_72490_1_.field_73635_b >= 36 && p_72490_1_.field_73635_b < 45) {
            ItemStack var5 = var2.field_71069_bz.func_75139_a(p_72490_1_.field_73635_b).func_75211_c();
            if(p_72490_1_.field_73636_c != null && (var5 == null || var5.field_77994_a < p_72490_1_.field_73636_c.field_77994_a)) {
               p_72490_1_.field_73636_c.field_77992_b = 5;
            }

            var2.field_71069_bz.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
         } else if(p_72490_1_.field_73637_a == var2.field_71070_bA.field_75152_c && (p_72490_1_.field_73637_a != 0 || !var3)) {
            var2.field_71070_bA.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
         }
      }

   }

   public void func_72476_a(Packet106Transaction p_72476_1_) {
      Container var2 = null;
      EntityClientPlayerMP var3 = this.field_72563_h.field_71439_g;
      if(p_72476_1_.field_73435_a == 0) {
         var2 = var3.field_71069_bz;
      } else if(p_72476_1_.field_73435_a == var3.field_71070_bA.field_75152_c) {
         var2 = var3.field_71070_bA;
      }

      if(var2 != null && !p_72476_1_.field_73434_c) {
         this.func_72552_c(new Packet106Transaction(p_72476_1_.field_73435_a, p_72476_1_.field_73433_b, true));
      }

   }

   public void func_72486_a(Packet104WindowItems p_72486_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      if(p_72486_1_.field_73427_a == 0) {
         var2.field_71069_bz.func_75131_a(p_72486_1_.field_73426_b);
      } else if(p_72486_1_.field_73427_a == var2.field_71070_bA.field_75152_c) {
         var2.field_71070_bA.func_75131_a(p_72486_1_.field_73426_b);
      }

   }

   public void func_72487_a(Packet130UpdateSign p_72487_1_) {
      boolean var2 = false;
      if(this.field_72563_h.field_71441_e.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c)) {
         TileEntity var3 = this.field_72563_h.field_71441_e.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);
         if(var3 instanceof TileEntitySign) {
            TileEntitySign var4 = (TileEntitySign)var3;
            if(var4.func_70409_a()) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  var4.field_70412_a[var5] = p_72487_1_.field_73308_d[var5];
               }

               var4.func_70296_d();
            }

            var2 = true;
         }
      }

      if(!var2 && this.field_72563_h.field_71439_g != null) {
         this.field_72563_h.field_71439_g.func_70006_a("Unable to locate sign at " + p_72487_1_.field_73311_a + ", " + p_72487_1_.field_73309_b + ", " + p_72487_1_.field_73310_c);
      }

   }

   public void func_72468_a(Packet132TileEntityData p_72468_1_) {
      if(this.field_72563_h.field_71441_e.func_72899_e(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c)) {
         TileEntity var2 = this.field_72563_h.field_71441_e.func_72796_p(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c);
         if(var2 != null) {
            if(p_72468_1_.field_73330_d == 1 && var2 instanceof TileEntityMobSpawner) {
               var2.func_70307_a(p_72468_1_.field_73331_e);
            } else if(p_72468_1_.field_73330_d == 2 && var2 instanceof TileEntityCommandBlock) {
               var2.func_70307_a(p_72468_1_.field_73331_e);
            } else if(p_72468_1_.field_73330_d == 3 && var2 instanceof TileEntityBeacon) {
               var2.func_70307_a(p_72468_1_.field_73331_e);
            } else if(p_72468_1_.field_73330_d == 4 && var2 instanceof TileEntitySkull) {
               var2.func_70307_a(p_72468_1_.field_73331_e);
            }
         }
      }

   }

   public void func_72505_a(Packet105UpdateProgressbar p_72505_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      this.func_72509_a(p_72505_1_);
      if(var2.field_71070_bA != null && var2.field_71070_bA.field_75152_c == p_72505_1_.field_73634_a) {
         var2.field_71070_bA.func_75137_b(p_72505_1_.field_73632_b, p_72505_1_.field_73633_c);
      }

   }

   public void func_72506_a(Packet5PlayerInventory p_72506_1_) {
      Entity var2 = this.func_72545_a(p_72506_1_.field_73400_a);
      if(var2 != null) {
         var2.func_70062_b(p_72506_1_.field_73398_b, p_72506_1_.func_73397_d());
      }

   }

   public void func_72474_a(Packet101CloseWindow p_72474_1_) {
      this.field_72563_h.field_71439_g.func_92015_f();
   }

   public void func_72454_a(Packet54PlayNoteBlock p_72454_1_) {
      this.field_72563_h.field_71441_e.func_72965_b(p_72454_1_.field_73340_a, p_72454_1_.field_73338_b, p_72454_1_.field_73339_c, p_72454_1_.field_73335_f, p_72454_1_.field_73336_d, p_72454_1_.field_73337_e);
   }

   public void func_72465_a(Packet55BlockDestroy p_72465_1_) {
      this.field_72563_h.field_71441_e.func_72888_f(p_72465_1_.func_73322_d(), p_72465_1_.func_73321_f(), p_72465_1_.func_73324_g(), p_72465_1_.func_73320_h(), p_72465_1_.func_73323_i());
   }

   public void func_72453_a(Packet56MapChunks p_72453_1_) {
      for(int var2 = 0; var2 < p_72453_1_.func_73581_d(); ++var2) {
         int var3 = p_72453_1_.func_73582_a(var2);
         int var4 = p_72453_1_.func_73580_b(var2);
         this.field_72564_i.func_73025_a(var3, var4, true);
         this.field_72564_i.func_73031_a(var3 << 4, 0, var4 << 4, (var3 << 4) + 15, 256, (var4 << 4) + 15);
         Chunk var5 = this.field_72564_i.func_72964_e(var3, var4);
         if(var5 == null) {
            this.field_72564_i.func_73025_a(var3, var4, true);
            var5 = this.field_72564_i.func_72964_e(var3, var4);
         }

         if(var5 != null) {
            var5.func_76607_a(p_72453_1_.func_73583_c(var2), p_72453_1_.field_73590_a[var2], p_72453_1_.field_73588_b[var2], true);
            this.field_72564_i.func_72909_d(var3 << 4, 0, var4 << 4, (var3 << 4) + 15, 256, (var4 << 4) + 15);
            if(!(this.field_72564_i.field_73011_w instanceof WorldProviderSurface)) {
               var5.func_76613_n();
            }
         }
      }

   }

   public boolean func_72469_b() {
      return this.field_72563_h != null && this.field_72563_h.field_71441_e != null && this.field_72563_h.field_71439_g != null && this.field_72564_i != null;
   }

   public void func_72488_a(Packet70GameEvent p_72488_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      int var3 = p_72488_1_.field_73618_b;
      int var4 = p_72488_1_.field_73619_c;
      if(var3 >= 0 && var3 < Packet70GameEvent.field_73620_a.length && Packet70GameEvent.field_73620_a[var3] != null) {
         var2.func_71035_c(Packet70GameEvent.field_73620_a[var3]);
      }

      if(var3 == 1) {
         this.field_72564_i.func_72912_H().func_76084_b(true);
         this.field_72564_i.func_72894_k(0.0F);
      } else if(var3 == 2) {
         this.field_72564_i.func_72912_H().func_76084_b(false);
         this.field_72564_i.func_72894_k(1.0F);
      } else if(var3 == 3) {
         this.field_72563_h.field_71442_b.func_78746_a(EnumGameType.func_77146_a(var4));
      } else if(var3 == 4) {
         this.field_72563_h.func_71373_a(new GuiWinGame());
      } else if(var3 == 5) {
         GameSettings var5 = this.field_72563_h.field_71474_y;
         if(var4 == 0) {
            this.field_72563_h.func_71373_a(new GuiScreenDemo());
         } else if(var4 == 101) {
            this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.movement", new Object[]{Keyboard.getKeyName(var5.field_74351_w.field_74512_d), Keyboard.getKeyName(var5.field_74370_x.field_74512_d), Keyboard.getKeyName(var5.field_74368_y.field_74512_d), Keyboard.getKeyName(var5.field_74366_z.field_74512_d)});
         } else if(var4 == 102) {
            this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.jump", new Object[]{Keyboard.getKeyName(var5.field_74314_A.field_74512_d)});
         } else if(var4 == 103) {
            this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.inventory", new Object[]{Keyboard.getKeyName(var5.field_74315_B.field_74512_d)});
         }
      } else if(var3 == 6) {
         this.field_72564_i.func_72980_b(var2.field_70165_t, var2.field_70163_u + (double)var2.func_70047_e(), var2.field_70161_v, "random.successful_hit", 0.18F, 0.45F, false);
      }

   }

   public void func_72494_a(Packet131MapData p_72494_1_) {
      if(p_72494_1_.field_73438_a == Item.field_77744_bd.field_77779_bT) {
         ItemMap.func_77874_a(p_72494_1_.field_73436_b, this.field_72563_h.field_71441_e).func_76192_a(p_72494_1_.field_73437_c);
      } else {
         this.field_72563_h.func_98033_al().func_98236_b("Unknown itemid: " + p_72494_1_.field_73436_b);
      }

   }

   public void func_72462_a(Packet61DoorChange p_72462_1_) {
      if(p_72462_1_.func_82560_d()) {
         this.field_72563_h.field_71441_e.func_82739_e(p_72462_1_.field_73567_a, p_72462_1_.field_73566_c, p_72462_1_.field_73563_d, p_72462_1_.field_73564_e, p_72462_1_.field_73565_b);
      } else {
         this.field_72563_h.field_71441_e.func_72926_e(p_72462_1_.field_73567_a, p_72462_1_.field_73566_c, p_72462_1_.field_73563_d, p_72462_1_.field_73564_e, p_72462_1_.field_73565_b);
      }

   }

   public void func_72517_a(Packet200Statistic p_72517_1_) {
      this.field_72563_h.field_71439_g.func_71167_b(StatList.func_75923_a(p_72517_1_.field_73472_a), p_72517_1_.field_73471_b);
   }

   public void func_72503_a(Packet41EntityEffect p_72503_1_) {
      Entity var2 = this.func_72545_a(p_72503_1_.field_73420_a);
      if(var2 instanceof EntityLiving) {
         PotionEffect var3 = new PotionEffect(p_72503_1_.field_73418_b, p_72503_1_.field_73417_d, p_72503_1_.field_73419_c);
         var3.func_100012_b(p_72503_1_.func_100008_d());
         ((EntityLiving)var2).func_70690_d(var3);
      }
   }

   public void func_72452_a(Packet42RemoveEntityEffect p_72452_1_) {
      Entity var2 = this.func_72545_a(p_72452_1_.field_73375_a);
      if(var2 instanceof EntityLiving) {
         ((EntityLiving)var2).func_70618_n(p_72452_1_.field_73374_b);
      }
   }

   public boolean func_72489_a() {
      return false;
   }

   public void func_72480_a(Packet201PlayerInfo p_72480_1_) {
      GuiPlayerInfo var2 = (GuiPlayerInfo)this.field_72562_k.get(p_72480_1_.field_73365_a);
      if(var2 == null && p_72480_1_.field_73363_b) {
         var2 = new GuiPlayerInfo(p_72480_1_.field_73365_a);
         this.field_72562_k.put(p_72480_1_.field_73365_a, var2);
         this.field_72559_c.add(var2);
      }

      if(var2 != null && !p_72480_1_.field_73363_b) {
         this.field_72562_k.remove(p_72480_1_.field_73365_a);
         this.field_72559_c.remove(var2);
      }

      if(p_72480_1_.field_73363_b && var2 != null) {
         var2.field_78829_b = p_72480_1_.field_73364_c;
      }

   }

   public void func_72477_a(Packet0KeepAlive p_72477_1_) {
      this.func_72552_c(new Packet0KeepAlive(p_72477_1_.field_73592_a));
   }

   public void func_72471_a(Packet202PlayerAbilities p_72471_1_) {
      EntityClientPlayerMP var2 = this.field_72563_h.field_71439_g;
      var2.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f();
      var2.field_71075_bZ.field_75098_d = p_72471_1_.func_73346_h();
      var2.field_71075_bZ.field_75102_a = p_72471_1_.func_73352_d();
      var2.field_71075_bZ.field_75101_c = p_72471_1_.func_73348_g();
      var2.field_71075_bZ.func_75092_a(p_72471_1_.func_73347_i());
      var2.field_71075_bZ.func_82877_b(p_72471_1_.func_82558_j());
   }

   public void func_72461_a(Packet203AutoComplete p_72461_1_) {
      String[] var2 = p_72461_1_.func_73473_d().split("\u0000");
      if(this.field_72563_h.field_71462_r instanceof GuiChat) {
         GuiChat var3 = (GuiChat)this.field_72563_h.field_71462_r;
         var3.func_73894_a(var2);
      }

   }

   public void func_72457_a(Packet62LevelSound p_72457_1_) {
      this.field_72563_h.field_71441_e.func_72980_b(p_72457_1_.func_73572_f(), p_72457_1_.func_73568_g(), p_72457_1_.func_73569_h(), p_72457_1_.func_73570_d(), p_72457_1_.func_73571_i(), p_72457_1_.func_73573_j(), false);
   }

   public void func_72501_a(Packet250CustomPayload p_72501_1_) {
      if("MC|TPack".equals(p_72501_1_.field_73630_a)) {
         String[] var2 = (new String(p_72501_1_.field_73629_c)).split("\u0000");
         String var3 = var2[0];
         if(var2[1].equals("16")) {
            if(this.field_72563_h.field_71418_C.func_77298_g()) {
               this.field_72563_h.field_71418_C.func_77296_a(var3);
            } else if(this.field_72563_h.field_71418_C.func_77300_f()) {
               this.field_72563_h.func_71373_a(new GuiYesNo(new NetClientWebTextures(this, var3), StringTranslate.func_74808_a().func_74805_b("multiplayer.texturePrompt.line1"), StringTranslate.func_74808_a().func_74805_b("multiplayer.texturePrompt.line2"), 0));
            }
         }
      } else if("MC|TrList".equals(p_72501_1_.field_73630_a)) {
         DataInputStream var8 = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));

         try {
            int var9 = var8.readInt();
            GuiScreen var4 = this.field_72563_h.field_71462_r;
            if(var4 != null && var4 instanceof GuiMerchant && var9 == this.field_72563_h.field_71439_g.field_71070_bA.field_75152_c) {
               IMerchant var5 = ((GuiMerchant)var4).func_74199_h();
               MerchantRecipeList var6 = MerchantRecipeList.func_77204_a(var8);
               var5.func_70930_a(var6);
            }
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

   }

   public void func_96436_a(Packet206SetObjective p_96436_1_) {
      Scoreboard var2 = this.field_72564_i.func_96441_U();
      ScoreObjective var3;
      if(p_96436_1_.field_96483_c == 0) {
         var3 = var2.func_96535_a(p_96436_1_.field_96484_a, ScoreObjectiveCriteria.field_96641_b);
         var3.func_96681_a(p_96436_1_.field_96482_b);
      } else {
         var3 = var2.func_96518_b(p_96436_1_.field_96484_a);
         if(p_96436_1_.field_96483_c == 1) {
            var2.func_96519_k(var3);
         } else if(p_96436_1_.field_96483_c == 2) {
            var3.func_96681_a(p_96436_1_.field_96482_b);
         }
      }

   }

   public void func_96437_a(Packet207SetScore p_96437_1_) {
      Scoreboard var2 = this.field_72564_i.func_96441_U();
      ScoreObjective var3 = var2.func_96518_b(p_96437_1_.field_96486_b);
      if(p_96437_1_.field_96485_d == 0) {
         Score var4 = var2.func_96529_a(p_96437_1_.field_96488_a, var3);
         var4.func_96647_c(p_96437_1_.field_96487_c);
      } else if(p_96437_1_.field_96485_d == 1) {
         var2.func_96515_c(p_96437_1_.field_96488_a);
      }

   }

   public void func_96438_a(Packet208SetDisplayObjective p_96438_1_) {
      Scoreboard var2 = this.field_72564_i.func_96441_U();
      if(p_96438_1_.field_96480_b.length() == 0) {
         var2.func_96530_a(p_96438_1_.field_96481_a, (ScoreObjective)null);
      } else {
         ScoreObjective var3 = var2.func_96518_b(p_96438_1_.field_96480_b);
         var2.func_96530_a(p_96438_1_.field_96481_a, var3);
      }

   }

   public void func_96435_a(Packet209SetPlayerTeam p_96435_1_) {
      Scoreboard var2 = this.field_72564_i.func_96441_U();
      ScorePlayerTeam var3;
      if(p_96435_1_.field_96489_f == 0) {
         var3 = var2.func_96527_f(p_96435_1_.field_96495_a);
      } else {
         var3 = var2.func_96508_e(p_96435_1_.field_96495_a);
      }

      if(p_96435_1_.field_96489_f == 0 || p_96435_1_.field_96489_f == 2) {
         var3.func_96664_a(p_96435_1_.field_96493_b);
         var3.func_96666_b(p_96435_1_.field_96494_c);
         var3.func_96662_c(p_96435_1_.field_96491_d);
         var3.func_98298_a(p_96435_1_.field_98212_g);
      }

      Iterator var4;
      String var5;
      if(p_96435_1_.field_96489_f == 0 || p_96435_1_.field_96489_f == 3) {
         var4 = p_96435_1_.field_96492_e.iterator();

         while(var4.hasNext()) {
            var5 = (String)var4.next();
            var2.func_96521_a(var5, var3);
         }
      }

      if(p_96435_1_.field_96489_f == 4) {
         var4 = p_96435_1_.field_96492_e.iterator();

         while(var4.hasNext()) {
            var5 = (String)var4.next();
            var2.func_96512_b(var5, var3);
         }
      }

      if(p_96435_1_.field_96489_f == 1) {
         var2.func_96511_d(var3);
      }

   }

   public void func_98182_a(Packet63WorldParticles p_98182_1_) {
      for(int var2 = 0; var2 < p_98182_1_.func_98202_m(); ++var2) {
         double var3 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98196_i();
         double var5 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98201_j();
         double var7 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98199_k();
         double var9 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
         double var11 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
         double var13 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
         this.field_72564_i.func_72869_a(p_98182_1_.func_98195_d(), p_98182_1_.func_98200_f() + var3, p_98182_1_.func_98194_g() + var5, p_98182_1_.func_98198_h() + var7, var9, var11, var13);
      }

   }

   public INetworkManager func_72548_f() {
      return this.field_72555_g;
   }
}
