package net.minecraft.server.management;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.server.management.BanList;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.server.management.PlayerPositionComparator;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.world.storage.IPlayerFileData;

public abstract class ServerConfigurationManager {

   private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
   private final MinecraftServer field_72400_f;
   public final List field_72404_b = new ArrayList();
   private final BanList field_72401_g = new BanList(new File("banned-players.txt"));
   private final BanList field_72413_h = new BanList(new File("banned-ips.txt"));
   private Set field_72414_i = new HashSet();
   private Set field_72411_j = new HashSet();
   private IPlayerFileData field_72412_k;
   private boolean field_72409_l;
   protected int field_72405_c;
   protected int field_72402_d;
   private EnumGameType field_72410_m;
   private boolean field_72407_n;
   private int field_72408_o = 0;


   public ServerConfigurationManager(MinecraftServer p_i3376_1_) {
      this.field_72400_f = p_i3376_1_;
      this.field_72401_g.func_73708_a(false);
      this.field_72413_h.func_73708_a(false);
      this.field_72405_c = 8;
   }

   public void func_72355_a(INetworkManager p_72355_1_, EntityPlayerMP p_72355_2_) {
      NBTTagCompound var3 = this.func_72380_a(p_72355_2_);
      p_72355_2_.func_70029_a(this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
      p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
      String var4 = "local";
      if(p_72355_1_.func_74430_c() != null) {
         var4 = p_72355_1_.func_74430_c().toString();
      }

      this.field_72400_f.func_98033_al().func_98233_a(p_72355_2_.field_71092_bJ + "[" + var4 + "] logged in with entity id " + p_72355_2_.field_70157_k + " at (" + p_72355_2_.field_70165_t + ", " + p_72355_2_.field_70163_u + ", " + p_72355_2_.field_70161_v + ")");
      WorldServer var5 = this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
      ChunkCoordinates var6 = var5.func_72861_E();
      this.func_72381_a(p_72355_2_, (EntityPlayerMP)null, var5);
      NetServerHandler var7 = new NetServerHandler(this.field_72400_f, p_72355_1_, p_72355_2_);
      var7.func_72567_b(new Packet1Login(p_72355_2_.field_70157_k, var5.func_72912_H().func_76067_t(), p_72355_2_.field_71134_c.func_73081_b(), var5.func_72912_H().func_76093_s(), var5.field_73011_w.field_76574_g, var5.field_73013_u, var5.func_72800_K(), this.func_72352_l()));
      var7.func_72567_b(new Packet6SpawnPosition(var6.field_71574_a, var6.field_71572_b, var6.field_71573_c));
      var7.func_72567_b(new Packet202PlayerAbilities(p_72355_2_.field_71075_bZ));
      var7.func_72567_b(new Packet16BlockItemSwitch(p_72355_2_.field_71071_by.field_70461_c));
      this.func_96456_a((ServerScoreboard)var5.func_96441_U(), p_72355_2_);
      this.func_72354_b(p_72355_2_, var5);
      this.func_72384_a(new Packet3Chat(EnumChatFormatting.YELLOW + p_72355_2_.func_96090_ax() + EnumChatFormatting.YELLOW + " joined the game."));
      this.func_72377_c(p_72355_2_);
      var7.func_72569_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
      this.field_72400_f.func_71212_ac().func_71745_a(var7);
      var7.func_72567_b(new Packet4UpdateTime(var5.func_82737_E(), var5.func_72820_D()));
      if(this.field_72400_f.func_71202_P().length() > 0) {
         p_72355_2_.func_71115_a(this.field_72400_f.func_71202_P(), this.field_72400_f.func_71227_R());
      }

      Iterator var8 = p_72355_2_.func_70651_bq().iterator();

      while(var8.hasNext()) {
         PotionEffect var9 = (PotionEffect)var8.next();
         var7.func_72567_b(new Packet41EntityEffect(p_72355_2_.field_70157_k, var9));
      }

      p_72355_2_.func_71116_b();
      if(var3 != null && var3.func_74764_b("Riding")) {
         Entity var10 = EntityList.func_75615_a(var3.func_74775_l("Riding"), var5);
         if(var10 != null) {
            var10.field_98038_p = true;
            var5.func_72838_d(var10);
            p_72355_2_.func_70078_a(var10);
            var10.field_98038_p = false;
         }
      }

   }

   protected void func_96456_a(ServerScoreboard p_96456_1_, EntityPlayerMP p_96456_2_) {
      HashSet var3 = new HashSet();
      Iterator var4 = p_96456_1_.func_96525_g().iterator();

      while(var4.hasNext()) {
         ScorePlayerTeam var5 = (ScorePlayerTeam)var4.next();
         p_96456_2_.field_71135_a.func_72567_b(new Packet209SetPlayerTeam(var5, 0));
      }

      for(int var9 = 0; var9 < 3; ++var9) {
         ScoreObjective var10 = p_96456_1_.func_96539_a(var9);
         if(var10 != null && !var3.contains(var10)) {
            List var6 = p_96456_1_.func_96550_d(var10);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
               Packet var8 = (Packet)var7.next();
               p_96456_2_.field_71135_a.func_72567_b(var8);
            }

            var3.add(var10);
         }
      }

   }

   public void func_72364_a(WorldServer[] p_72364_1_) {
      this.field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
   }

   public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_) {
      WorldServer var3 = p_72375_1_.func_71121_q();
      if(p_72375_2_ != null) {
         p_72375_2_.func_73040_p().func_72695_c(p_72375_1_);
      }

      var3.func_73040_p().func_72683_a(p_72375_1_);
      var3.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
   }

   public int func_72372_a() {
      return PlayerManager.func_72686_a(this.func_72395_o());
   }

   public NBTTagCompound func_72380_a(EntityPlayerMP p_72380_1_) {
      NBTTagCompound var2 = this.field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
      NBTTagCompound var3;
      if(p_72380_1_.func_70005_c_().equals(this.field_72400_f.func_71214_G()) && var2 != null) {
         p_72380_1_.func_70020_e(var2);
         var3 = var2;
         System.out.println("loading single player");
      } else {
         var3 = this.field_72412_k.func_75752_b(p_72380_1_);
      }

      return var3;
   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      this.field_72412_k.func_75753_a(p_72391_1_);
   }

   public void func_72377_c(EntityPlayerMP p_72377_1_) {
      this.func_72384_a(new Packet201PlayerInfo(p_72377_1_.field_71092_bJ, true, 1000));
      this.field_72404_b.add(p_72377_1_);
      WorldServer var2 = this.field_72400_f.func_71218_a(p_72377_1_.field_71093_bK);
      var2.func_72838_d(p_72377_1_);
      this.func_72375_a(p_72377_1_, (WorldServer)null);

      for(int var3 = 0; var3 < this.field_72404_b.size(); ++var3) {
         EntityPlayerMP var4 = (EntityPlayerMP)this.field_72404_b.get(var3);
         p_72377_1_.field_71135_a.func_72567_b(new Packet201PlayerInfo(var4.field_71092_bJ, true, var4.field_71138_i));
      }

   }

   public void func_72358_d(EntityPlayerMP p_72358_1_) {
      p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
   }

   public void func_72367_e(EntityPlayerMP p_72367_1_) {
      this.func_72391_b(p_72367_1_);
      WorldServer var2 = p_72367_1_.func_71121_q();
      if(p_72367_1_.field_70154_o != null) {
         var2.func_72900_e(p_72367_1_.field_70154_o);
         System.out.println("removing player mount");
      }

      var2.func_72900_e(p_72367_1_);
      var2.func_73040_p().func_72695_c(p_72367_1_);
      this.field_72404_b.remove(p_72367_1_);
      this.func_72384_a(new Packet201PlayerInfo(p_72367_1_.field_71092_bJ, false, 9999));
   }

   public String func_72399_a(SocketAddress p_72399_1_, String p_72399_2_) {
      if(this.field_72401_g.func_73704_a(p_72399_2_)) {
         BanEntry var6 = (BanEntry)this.field_72401_g.func_73712_c().get(p_72399_2_);
         String var7 = "You are banned from this server!\nReason: " + var6.func_73686_f();
         if(var6.func_73680_d() != null) {
            var7 = var7 + "\nYour ban will be removed on " + field_72403_e.format(var6.func_73680_d());
         }

         return var7;
      } else if(!this.func_72370_d(p_72399_2_)) {
         return "You are not white-listed on this server!";
      } else {
         String var3 = p_72399_1_.toString();
         var3 = var3.substring(var3.indexOf("/") + 1);
         var3 = var3.substring(0, var3.indexOf(":"));
         if(this.field_72413_h.func_73704_a(var3)) {
            BanEntry var4 = (BanEntry)this.field_72413_h.func_73712_c().get(var3);
            String var5 = "Your IP address is banned from this server!\nReason: " + var4.func_73686_f();
            if(var4.func_73680_d() != null) {
               var5 = var5 + "\nYour ban will be removed on " + field_72403_e.format(var4.func_73680_d());
            }

            return var5;
         } else {
            return this.field_72404_b.size() >= this.field_72405_c?"The server is full!":null;
         }
      }
   }

   public EntityPlayerMP func_72366_a(String p_72366_1_) {
      ArrayList var2 = new ArrayList();

      EntityPlayerMP var4;
      for(int var3 = 0; var3 < this.field_72404_b.size(); ++var3) {
         var4 = (EntityPlayerMP)this.field_72404_b.get(var3);
         if(var4.field_71092_bJ.equalsIgnoreCase(p_72366_1_)) {
            var2.add(var4);
         }
      }

      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         var4 = (EntityPlayerMP)var5.next();
         var4.field_71135_a.func_72565_c("You logged in from another location");
      }

      Object var6;
      if(this.field_72400_f.func_71242_L()) {
         var6 = new DemoWorldManager(this.field_72400_f.func_71218_a(0));
      } else {
         var6 = new ItemInWorldManager(this.field_72400_f.func_71218_a(0));
      }

      return new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(0), p_72366_1_, (ItemInWorldManager)var6);
   }

   public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_) {
      p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
      p_72368_1_.func_71121_q().func_73039_n().func_72790_b(p_72368_1_);
      p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
      this.field_72404_b.remove(p_72368_1_);
      this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f(p_72368_1_);
      ChunkCoordinates var4 = p_72368_1_.func_70997_bJ();
      boolean var5 = p_72368_1_.func_82245_bX();
      p_72368_1_.field_71093_bK = p_72368_2_;
      Object var6;
      if(this.field_72400_f.func_71242_L()) {
         var6 = new DemoWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      } else {
         var6 = new ItemInWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      }

      EntityPlayerMP var7 = new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.field_71092_bJ, (ItemInWorldManager)var6);
      var7.field_71135_a = p_72368_1_.field_71135_a;
      var7.func_71049_a(p_72368_1_, p_72368_3_);
      var7.field_70157_k = p_72368_1_.field_70157_k;
      WorldServer var8 = this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
      this.func_72381_a(var7, p_72368_1_, var8);
      ChunkCoordinates var9;
      if(var4 != null) {
         var9 = EntityPlayer.func_71056_a(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), var4, var5);
         if(var9 != null) {
            var7.func_70012_b((double)((float)var9.field_71574_a + 0.5F), (double)((float)var9.field_71572_b + 0.1F), (double)((float)var9.field_71573_c + 0.5F), 0.0F, 0.0F);
            var7.func_71063_a(var4, var5);
         } else {
            var7.field_71135_a.func_72567_b(new Packet70GameEvent(0, 0));
         }
      }

      var8.field_73059_b.func_73158_c((int)var7.field_70165_t >> 4, (int)var7.field_70161_v >> 4);

      while(!var8.func_72945_a(var7, var7.field_70121_D).isEmpty()) {
         var7.func_70107_b(var7.field_70165_t, var7.field_70163_u + 1.0D, var7.field_70161_v);
      }

      var7.field_71135_a.func_72567_b(new Packet9Respawn(var7.field_71093_bK, (byte)var7.field_70170_p.field_73013_u, var7.field_70170_p.func_72912_H().func_76067_t(), var7.field_70170_p.func_72800_K(), var7.field_71134_c.func_73081_b()));
      var9 = var8.func_72861_E();
      var7.field_71135_a.func_72569_a(var7.field_70165_t, var7.field_70163_u, var7.field_70161_v, var7.field_70177_z, var7.field_70125_A);
      var7.field_71135_a.func_72567_b(new Packet6SpawnPosition(var9.field_71574_a, var9.field_71572_b, var9.field_71573_c));
      var7.field_71135_a.func_72567_b(new Packet43Experience(var7.field_71106_cc, var7.field_71067_cb, var7.field_71068_ca));
      this.func_72354_b(var7, var8);
      var8.func_73040_p().func_72683_a(var7);
      var8.func_72838_d(var7);
      this.field_72404_b.add(var7);
      var7.func_71116_b();
      var7.func_70606_j(var7.func_70630_aN());
      return var7;
   }

   public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_) {
      int var3 = p_72356_1_.field_71093_bK;
      WorldServer var4 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71093_bK = p_72356_2_;
      WorldServer var5 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71135_a.func_72567_b(new Packet9Respawn(p_72356_1_.field_71093_bK, (byte)p_72356_1_.field_70170_p.field_73013_u, var5.func_72912_H().func_76067_t(), var5.func_72800_K(), p_72356_1_.field_71134_c.func_73081_b()));
      var4.func_72973_f(p_72356_1_);
      p_72356_1_.field_70128_L = false;
      this.func_82448_a(p_72356_1_, var3, var4, var5);
      this.func_72375_a(p_72356_1_, var4);
      p_72356_1_.field_71135_a.func_72569_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
      p_72356_1_.field_71134_c.func_73080_a(var5);
      this.func_72354_b(p_72356_1_, var5);
      this.func_72385_f(p_72356_1_);
      Iterator var6 = p_72356_1_.func_70651_bq().iterator();

      while(var6.hasNext()) {
         PotionEffect var7 = (PotionEffect)var6.next();
         p_72356_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(p_72356_1_.field_70157_k, var7));
      }

   }

   public void func_82448_a(Entity p_82448_1_, int p_82448_2_, WorldServer p_82448_3_, WorldServer p_82448_4_) {
      double var5 = p_82448_1_.field_70165_t;
      double var7 = p_82448_1_.field_70161_v;
      double var9 = 8.0D;
      double var11 = p_82448_1_.field_70165_t;
      double var13 = p_82448_1_.field_70163_u;
      double var15 = p_82448_1_.field_70161_v;
      float var17 = p_82448_1_.field_70177_z;
      p_82448_3_.field_72984_F.func_76320_a("moving");
      if(p_82448_1_.field_71093_bK == -1) {
         var5 /= var9;
         var7 /= var9;
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      } else if(p_82448_1_.field_71093_bK == 0) {
         var5 *= var9;
         var7 *= var9;
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      } else {
         ChunkCoordinates var18;
         if(p_82448_2_ == 1) {
            var18 = p_82448_4_.func_72861_E();
         } else {
            var18 = p_82448_4_.func_73054_j();
         }

         var5 = (double)var18.field_71574_a;
         p_82448_1_.field_70163_u = (double)var18.field_71572_b;
         var7 = (double)var18.field_71573_c;
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, 90.0F, 0.0F);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      }

      p_82448_3_.field_72984_F.func_76319_b();
      if(p_82448_2_ != 1) {
         p_82448_3_.field_72984_F.func_76320_a("placing");
         var5 = (double)MathHelper.func_76125_a((int)var5, -29999872, 29999872);
         var7 = (double)MathHelper.func_76125_a((int)var7, -29999872, 29999872);
         if(p_82448_1_.func_70089_S()) {
            p_82448_4_.func_72838_d(p_82448_1_);
            p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
            p_82448_4_.func_72866_a(p_82448_1_, false);
            p_82448_4_.func_85176_s().func_77185_a(p_82448_1_, var11, var13, var15, var17);
         }

         p_82448_3_.field_72984_F.func_76319_b();
      }

      p_82448_1_.func_70029_a(p_82448_4_);
   }

   public void func_72374_b() {
      if(++this.field_72408_o > 600) {
         this.field_72408_o = 0;
      }

      if(this.field_72408_o < this.field_72404_b.size()) {
         EntityPlayerMP var1 = (EntityPlayerMP)this.field_72404_b.get(this.field_72408_o);
         this.func_72384_a(new Packet201PlayerInfo(var1.field_71092_bJ, true, var1.field_71138_i));
      }

   }

   public void func_72384_a(Packet p_72384_1_) {
      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71135_a.func_72567_b(p_72384_1_);
      }

   }

   public void func_72396_a(Packet p_72396_1_, int p_72396_2_) {
      for(int var3 = 0; var3 < this.field_72404_b.size(); ++var3) {
         EntityPlayerMP var4 = (EntityPlayerMP)this.field_72404_b.get(var3);
         if(var4.field_71093_bK == p_72396_2_) {
            var4.field_71135_a.func_72567_b(p_72396_1_);
         }
      }

   }

   public String func_72398_c() {
      String var1 = "";

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         if(var2 > 0) {
            var1 = var1 + ", ";
         }

         var1 = var1 + ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71092_bJ;
      }

      return var1;
   }

   public String[] func_72369_d() {
      String[] var1 = new String[this.field_72404_b.size()];

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         var1[var2] = ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71092_bJ;
      }

      return var1;
   }

   public BanList func_72390_e() {
      return this.field_72401_g;
   }

   public BanList func_72363_f() {
      return this.field_72413_h;
   }

   public void func_72386_b(String p_72386_1_) {
      this.field_72414_i.add(p_72386_1_.toLowerCase());
   }

   public void func_72360_c(String p_72360_1_) {
      this.field_72414_i.remove(p_72360_1_.toLowerCase());
   }

   public boolean func_72370_d(String p_72370_1_) {
      p_72370_1_ = p_72370_1_.trim().toLowerCase();
      return !this.field_72409_l || this.field_72414_i.contains(p_72370_1_) || this.field_72411_j.contains(p_72370_1_);
   }

   public boolean func_72353_e(String p_72353_1_) {
      return this.field_72414_i.contains(p_72353_1_.trim().toLowerCase()) || this.field_72400_f.func_71264_H() && this.field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && this.field_72400_f.func_71214_G().equalsIgnoreCase(p_72353_1_) || this.field_72407_n;
   }

   public EntityPlayerMP func_72361_f(String p_72361_1_) {
      Iterator var2 = this.field_72404_b.iterator();

      EntityPlayerMP var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (EntityPlayerMP)var2.next();
      } while(!var3.field_71092_bJ.equalsIgnoreCase(p_72361_1_));

      return var3;
   }

   public List func_82449_a(ChunkCoordinates p_82449_1_, int p_82449_2_, int p_82449_3_, int p_82449_4_, int p_82449_5_, int p_82449_6_, int p_82449_7_, Map p_82449_8_, String p_82449_9_, String p_82449_10_) {
      if(this.field_72404_b.isEmpty()) {
         return null;
      } else {
         Object var11 = new ArrayList();
         boolean var12 = p_82449_4_ < 0;
         int var13 = p_82449_2_ * p_82449_2_;
         int var14 = p_82449_3_ * p_82449_3_;
         p_82449_4_ = MathHelper.func_76130_a(p_82449_4_);

         for(int var15 = 0; var15 < this.field_72404_b.size(); ++var15) {
            EntityPlayerMP var16 = (EntityPlayerMP)this.field_72404_b.get(var15);
            boolean var17;
            if(p_82449_9_ != null) {
               var17 = p_82449_9_.startsWith("!");
               if(var17) {
                  p_82449_9_ = p_82449_9_.substring(1);
               }

               if(var17 == p_82449_9_.equalsIgnoreCase(var16.func_70023_ak())) {
                  continue;
               }
            }

            if(p_82449_10_ != null) {
               var17 = p_82449_10_.startsWith("!");
               if(var17) {
                  p_82449_10_ = p_82449_10_.substring(1);
               }

               ScorePlayerTeam var18 = var16.func_96124_cp();
               String var19 = var18 == null?"":var18.func_96661_b();
               if(var17 == p_82449_10_.equalsIgnoreCase(var19)) {
                  continue;
               }
            }

            if(p_82449_1_ != null && (p_82449_2_ > 0 || p_82449_3_ > 0)) {
               float var20 = p_82449_1_.func_82371_e(var16.func_82114_b());
               if(p_82449_2_ > 0 && var20 < (float)var13 || p_82449_3_ > 0 && var20 > (float)var14) {
                  continue;
               }
            }

            if(this.func_96457_a(var16, p_82449_8_) && (p_82449_5_ == EnumGameType.NOT_SET.func_77148_a() || p_82449_5_ == var16.field_71134_c.func_73081_b().func_77148_a()) && (p_82449_6_ <= 0 || var16.field_71068_ca >= p_82449_6_) && var16.field_71068_ca <= p_82449_7_) {
               ((List)var11).add(var16);
            }
         }

         if(p_82449_1_ != null) {
            Collections.sort((List)var11, new PlayerPositionComparator(p_82449_1_));
         }

         if(var12) {
            Collections.reverse((List)var11);
         }

         if(p_82449_4_ > 0) {
            var11 = ((List)var11).subList(0, Math.min(p_82449_4_, ((List)var11).size()));
         }

         return (List)var11;
      }
   }

   private boolean func_96457_a(EntityPlayer p_96457_1_, Map p_96457_2_) {
      if(p_96457_2_ != null && p_96457_2_.size() != 0) {
         Iterator var3 = p_96457_2_.entrySet().iterator();

         Entry var4;
         boolean var6;
         int var10;
         do {
            if(!var3.hasNext()) {
               return true;
            }

            var4 = (Entry)var3.next();
            String var5 = (String)var4.getKey();
            var6 = false;
            if(var5.endsWith("_min") && var5.length() > 4) {
               var6 = true;
               var5 = var5.substring(0, var5.length() - 4);
            }

            Scoreboard var7 = p_96457_1_.func_96123_co();
            ScoreObjective var8 = var7.func_96518_b(var5);
            if(var8 == null) {
               return false;
            }

            Score var9 = p_96457_1_.func_96123_co().func_96529_a(p_96457_1_.func_70023_ak(), var8);
            var10 = var9.func_96652_c();
            if(var10 < ((Integer)var4.getValue()).intValue() && var6) {
               return false;
            }
         } while(var10 <= ((Integer)var4.getValue()).intValue() || var6);

         return false;
      } else {
         return true;
      }
   }

   public void func_72393_a(double p_72393_1_, double p_72393_3_, double p_72393_5_, double p_72393_7_, int p_72393_9_, Packet p_72393_10_) {
      this.func_72397_a((EntityPlayer)null, p_72393_1_, p_72393_3_, p_72393_5_, p_72393_7_, p_72393_9_, p_72393_10_);
   }

   public void func_72397_a(EntityPlayer p_72397_1_, double p_72397_2_, double p_72397_4_, double p_72397_6_, double p_72397_8_, int p_72397_10_, Packet p_72397_11_) {
      for(int var12 = 0; var12 < this.field_72404_b.size(); ++var12) {
         EntityPlayerMP var13 = (EntityPlayerMP)this.field_72404_b.get(var12);
         if(var13 != p_72397_1_ && var13.field_71093_bK == p_72397_10_) {
            double var14 = p_72397_2_ - var13.field_70165_t;
            double var16 = p_72397_4_ - var13.field_70163_u;
            double var18 = p_72397_6_ - var13.field_70161_v;
            if(var14 * var14 + var16 * var16 + var18 * var18 < p_72397_8_ * p_72397_8_) {
               var13.field_71135_a.func_72567_b(p_72397_11_);
            }
         }
      }

   }

   public void func_72389_g() {
      for(int var1 = 0; var1 < this.field_72404_b.size(); ++var1) {
         this.func_72391_b((EntityPlayerMP)this.field_72404_b.get(var1));
      }

   }

   public void func_72359_h(String p_72359_1_) {
      this.field_72411_j.add(p_72359_1_);
   }

   public void func_72379_i(String p_72379_1_) {
      this.field_72411_j.remove(p_72379_1_);
   }

   public Set func_72388_h() {
      return this.field_72411_j;
   }

   public Set func_72376_i() {
      return this.field_72414_i;
   }

   public void func_72362_j() {}

   public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_) {
      p_72354_1_.field_71135_a.func_72567_b(new Packet4UpdateTime(p_72354_2_.func_82737_E(), p_72354_2_.func_72820_D()));
      if(p_72354_2_.func_72896_J()) {
         p_72354_1_.field_71135_a.func_72567_b(new Packet70GameEvent(1, 0));
      }

   }

   public void func_72385_f(EntityPlayerMP p_72385_1_) {
      p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
      p_72385_1_.func_71118_n();
      p_72385_1_.field_71135_a.func_72567_b(new Packet16BlockItemSwitch(p_72385_1_.field_71071_by.field_70461_c));
   }

   public int func_72394_k() {
      return this.field_72404_b.size();
   }

   public int func_72352_l() {
      return this.field_72405_c;
   }

   public String[] func_72373_m() {
      return this.field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
   }

   public boolean func_72383_n() {
      return this.field_72409_l;
   }

   public void func_72371_a(boolean p_72371_1_) {
      this.field_72409_l = p_72371_1_;
   }

   public List func_72382_j(String p_72382_1_) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_72404_b.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         if(var4.func_71114_r().equals(p_72382_1_)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public int func_72395_o() {
      return this.field_72402_d;
   }

   public MinecraftServer func_72365_p() {
      return this.field_72400_f;
   }

   public NBTTagCompound func_72378_q() {
      return null;
   }

   @SideOnly(Side.CLIENT)
   public void func_72357_a(EnumGameType p_72357_1_) {
      this.field_72410_m = p_72357_1_;
   }

   private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_) {
      if(p_72381_2_ != null) {
         p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
      } else if(this.field_72410_m != null) {
         p_72381_1_.field_71134_c.func_73076_a(this.field_72410_m);
      }

      p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
   }

   @SideOnly(Side.CLIENT)
   public void func_72387_b(boolean p_72387_1_) {
      this.field_72407_n = p_72387_1_;
   }

   public void func_72392_r() {
      while(!this.field_72404_b.isEmpty()) {
         ((EntityPlayerMP)this.field_72404_b.get(0)).field_71135_a.func_72565_c("Server closed");
      }

   }

   public void func_92062_k(String p_92062_1_) {
      this.field_72400_f.func_71244_g(p_92062_1_);
      this.func_72384_a(new Packet3Chat(p_92062_1_));
   }

}
