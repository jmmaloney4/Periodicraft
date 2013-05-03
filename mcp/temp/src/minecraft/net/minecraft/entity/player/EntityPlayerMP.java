package net.minecraft.entity.player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet200Statistic;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet42RemoveEntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StringTranslate;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class EntityPlayerMP extends EntityPlayer implements ICrafting {

   private StringTranslate field_71148_cg = new StringTranslate("en_US");
   public NetServerHandler field_71135_a;
   public MinecraftServer field_71133_b;
   public ItemInWorldManager field_71134_c;
   public double field_71131_d;
   public double field_71132_e;
   public final List field_71129_f = new LinkedList();
   public final List field_71130_g = new LinkedList();
   private int field_71149_ch = -99999999;
   private int field_71146_ci = -99999999;
   private boolean field_71147_cj = true;
   private int field_71144_ck = -99999999;
   private int field_71145_cl = 60;
   private int field_71142_cm = 0;
   private int field_71143_cn = 0;
   private boolean field_71140_co = true;
   public int field_71139_cq = 0;
   public boolean field_71137_h;
   public int field_71138_i;
   public boolean field_71136_j = false;


   public EntityPlayerMP(MinecraftServer p_i3396_1_, World p_i3396_2_, String p_i3396_3_, ItemInWorldManager p_i3396_4_) {
      super(p_i3396_2_);
      p_i3396_4_.field_73090_b = this;
      this.field_71134_c = p_i3396_4_;
      this.field_71142_cm = p_i3396_1_.func_71203_ab().func_72395_o();
      ChunkCoordinates var5 = p_i3396_2_.func_72861_E();
      int var6 = var5.field_71574_a;
      int var7 = var5.field_71573_c;
      int var8 = var5.field_71572_b;
      if(!p_i3396_2_.field_73011_w.field_76576_e && p_i3396_2_.func_72912_H().func_76077_q() != EnumGameType.ADVENTURE) {
         int var9 = Math.max(5, p_i3396_1_.func_82357_ak() - 6);
         var6 += this.field_70146_Z.nextInt(var9 * 2) - var9;
         var7 += this.field_70146_Z.nextInt(var9 * 2) - var9;
         var8 = p_i3396_2_.func_72825_h(var6, var7);
      }

      this.field_71133_b = p_i3396_1_;
      this.field_70138_W = 0.0F;
      this.field_71092_bJ = p_i3396_3_;
      this.field_70129_M = 0.0F;
      this.func_70012_b((double)var6 + 0.5D, (double)var8, (double)var7 + 0.5D, 0.0F, 0.0F);

      while(!p_i3396_2_.func_72945_a(this, this.field_70121_D).isEmpty()) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_74764_b("playerGameType")) {
         this.field_71134_c.func_73076_a(EnumGameType.func_77146_a(p_70037_1_.func_74762_e("playerGameType")));
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("playerGameType", this.field_71134_c.func_73081_b().func_77148_a());
   }

   public void func_82242_a(int p_82242_1_) {
      super.func_82242_a(p_82242_1_);
      this.field_71144_ck = -1;
   }

   public void func_71116_b() {
      this.field_71070_bA.func_75132_a(this);
   }

   protected void func_71061_d_() {
      this.field_70129_M = 0.0F;
   }

   public float func_70047_e() {
      return 1.62F;
   }

   public void func_70071_h_() {
      this.field_71134_c.func_73075_a();
      --this.field_71145_cl;
      this.field_71070_bA.func_75142_b();

      while(!this.field_71130_g.isEmpty()) {
         int var1 = Math.min(this.field_71130_g.size(), 127);
         int[] var2 = new int[var1];
         Iterator var3 = this.field_71130_g.iterator();
         int var4 = 0;

         while(var3.hasNext() && var4 < var1) {
            var2[var4++] = ((Integer)var3.next()).intValue();
            var3.remove();
         }

         this.field_71135_a.func_72567_b(new Packet29DestroyEntity(var2));
      }

      if(!this.field_71129_f.isEmpty()) {
         ArrayList var6 = new ArrayList();
         Iterator var7 = this.field_71129_f.iterator();
         ArrayList var8 = new ArrayList();

         while(var7.hasNext() && var6.size() < 5) {
            ChunkCoordIntPair var9 = (ChunkCoordIntPair)var7.next();
            var7.remove();
            if(var9 != null && this.field_70170_p.func_72899_e(var9.field_77276_a << 4, 0, var9.field_77275_b << 4)) {
               var6.add(this.field_70170_p.func_72964_e(var9.field_77276_a, var9.field_77275_b));
               var8.addAll(((WorldServer)this.field_70170_p).func_73049_a(var9.field_77276_a * 16, 0, var9.field_77275_b * 16, var9.field_77276_a * 16 + 16, 256, var9.field_77275_b * 16 + 16));
            }
         }

         if(!var6.isEmpty()) {
            this.field_71135_a.func_72567_b(new Packet56MapChunks(var6));
            Iterator var11 = var8.iterator();

            while(var11.hasNext()) {
               TileEntity var5 = (TileEntity)var11.next();
               this.func_71119_a(var5);
            }

            var11 = var6.iterator();

            while(var11.hasNext()) {
               Chunk var10 = (Chunk)var11.next();
               this.func_71121_q().func_73039_n().func_85172_a(this, var10);
            }
         }
      }

   }

   public void func_70606_j(int p_70606_1_) {
      super.func_70606_j(p_70606_1_);
      Collection var2 = this.func_96123_co().func_96520_a(ScoreObjectiveCriteria.field_96638_f);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScoreObjective var4 = (ScoreObjective)var3.next();
         this.func_96123_co().func_96529_a(this.func_70023_ak(), var4).func_96651_a(Arrays.asList(new EntityPlayer[]{this}));
      }

   }

   public void func_71127_g() {
      try {
         super.func_70071_h_();

         for(int var1 = 0; var1 < this.field_71071_by.func_70302_i_(); ++var1) {
            ItemStack var5 = this.field_71071_by.func_70301_a(var1);
            if(var5 != null && Item.field_77698_e[var5.field_77993_c].func_77643_m_() && this.field_71135_a.func_72568_e() <= 5) {
               Packet var6 = ((ItemMapBase)Item.field_77698_e[var5.field_77993_c]).func_77871_c(var5, this.field_70170_p, this);
               if(var6 != null) {
                  this.field_71135_a.func_72567_b(var6);
               }
            }
         }

         if(this.func_70630_aN() != this.field_71149_ch || this.field_71146_ci != this.field_71100_bB.func_75116_a() || this.field_71100_bB.func_75115_e() == 0.0F != this.field_71147_cj) {
            this.field_71135_a.func_72567_b(new Packet8UpdateHealth(this.func_70630_aN(), this.field_71100_bB.func_75116_a(), this.field_71100_bB.func_75115_e()));
            this.field_71149_ch = this.func_70630_aN();
            this.field_71146_ci = this.field_71100_bB.func_75116_a();
            this.field_71147_cj = this.field_71100_bB.func_75115_e() == 0.0F;
         }

         if(this.field_71067_cb != this.field_71144_ck) {
            this.field_71144_ck = this.field_71067_cb;
            this.field_71135_a.func_72567_b(new Packet43Experience(this.field_71106_cc, this.field_71067_cb, this.field_71068_ca));
         }

      } catch (Throwable var4) {
         CrashReport var2 = CrashReport.func_85055_a(var4, "Ticking player");
         CrashReportCategory var3 = var2.func_85058_a("Player being ticked");
         this.func_85029_a(var3);
         throw new ReportedException(var2);
      }
   }

   public void func_70645_a(DamageSource p_70645_1_) {
      this.field_71133_b.func_71203_ab().func_92062_k(this.field_94063_bt.func_94546_b());
      if(!this.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
         this.field_71071_by.func_70436_m();
      }

      Collection var2 = this.field_70170_p.func_96441_U().func_96520_a(ScoreObjectiveCriteria.field_96642_c);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScoreObjective var4 = (ScoreObjective)var3.next();
         Score var5 = this.func_96123_co().func_96529_a(this.func_70023_ak(), var4);
         var5.func_96648_a();
      }

      EntityLiving var6 = this.func_94060_bK();
      if(var6 != null) {
         var6.func_70084_c(this, this.field_70744_aE);
      }

   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         boolean var3 = this.field_71133_b.func_71262_S() && this.field_71133_b.func_71219_W() && "fall".equals(p_70097_1_.field_76373_n);
         if(!var3 && this.field_71145_cl > 0 && p_70097_1_ != DamageSource.field_76380_i) {
            return false;
         } else {
            if(p_70097_1_ instanceof EntityDamageSource) {
               Entity var4 = p_70097_1_.func_76346_g();
               if(var4 instanceof EntityPlayer && !this.func_96122_a((EntityPlayer)var4)) {
                  return false;
               }

               if(var4 instanceof EntityArrow) {
                  EntityArrow var5 = (EntityArrow)var4;
                  if(var5.field_70250_c instanceof EntityPlayer && !this.func_96122_a((EntityPlayer)var5.field_70250_c)) {
                     return false;
                  }
               }
            }

            return super.func_70097_a(p_70097_1_, p_70097_2_);
         }
      }
   }

   public boolean func_96122_a(EntityPlayer p_96122_1_) {
      return !this.field_71133_b.func_71219_W()?false:super.func_96122_a(p_96122_1_);
   }

   public void func_71027_c(int p_71027_1_) {
      if(this.field_71093_bK == 1 && p_71027_1_ == 1) {
         this.func_71029_a(AchievementList.field_76003_C);
         this.field_70170_p.func_72900_e(this);
         this.field_71136_j = true;
         this.field_71135_a.func_72567_b(new Packet70GameEvent(4, 0));
      } else {
         if(this.field_71093_bK == 1 && p_71027_1_ == 0) {
            this.func_71029_a(AchievementList.field_76002_B);
            ChunkCoordinates var2 = this.field_71133_b.func_71218_a(p_71027_1_).func_73054_j();
            if(var2 != null) {
               this.field_71135_a.func_72569_a((double)var2.field_71574_a, (double)var2.field_71572_b, (double)var2.field_71573_c, 0.0F, 0.0F);
            }

            p_71027_1_ = 1;
         } else {
            this.func_71029_a(AchievementList.field_76029_x);
         }

         this.field_71133_b.func_71203_ab().func_72356_a(this, p_71027_1_);
         this.field_71144_ck = -1;
         this.field_71149_ch = -1;
         this.field_71146_ci = -1;
      }

   }

   private void func_71119_a(TileEntity p_71119_1_) {
      if(p_71119_1_ != null) {
         Packet var2 = p_71119_1_.func_70319_e();
         if(var2 != null) {
            this.field_71135_a.func_72567_b(var2);
         }
      }

   }

   public void func_71001_a(Entity p_71001_1_, int p_71001_2_) {
      super.func_71001_a(p_71001_1_, p_71001_2_);
      this.field_71070_bA.func_75142_b();
   }

   public EnumStatus func_71018_a(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
      EnumStatus var4 = super.func_71018_a(p_71018_1_, p_71018_2_, p_71018_3_);
      if(var4 == EnumStatus.OK) {
         Packet17Sleep var5 = new Packet17Sleep(this, 0, p_71018_1_, p_71018_2_, p_71018_3_);
         this.func_71121_q().func_73039_n().func_72784_a(this, var5);
         this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
         this.field_71135_a.func_72567_b(var5);
      }

      return var4;
   }

   public void func_70999_a(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
      if(this.func_70608_bn()) {
         this.func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(this, 3));
      }

      super.func_70999_a(p_70999_1_, p_70999_2_, p_70999_3_);
      if(this.field_71135_a != null) {
         this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
      }

   }

   public void func_70078_a(Entity p_70078_1_) {
      super.func_70078_a(p_70078_1_);
      this.field_71135_a.func_72567_b(new Packet39AttachEntity(this, this.field_70154_o));
      this.field_71135_a.func_72569_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
   }

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {}

   public void func_71122_b(double p_71122_1_, boolean p_71122_3_) {
      super.func_70064_a(p_71122_1_, p_71122_3_);
   }

   public void func_71117_bO() {
      this.field_71139_cq = this.field_71139_cq % 100 + 1;
   }

   public void func_71058_b(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 1, "Crafting", 9, true));
      this.field_71070_bA = new ContainerWorkbench(this.field_71071_by, this.field_70170_p, p_71058_1_, p_71058_2_, p_71058_3_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71002_c(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 4, p_71002_4_ == null?"":p_71002_4_, 9, p_71002_4_ != null));
      this.field_71070_bA = new ContainerEnchantment(this.field_71071_by, this.field_70170_p, p_71002_1_, p_71002_2_, p_71002_3_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_82244_d(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 8, "Repairing", 9, true));
      this.field_71070_bA = new ContainerRepair(this.field_71071_by, this.field_70170_p, p_82244_1_, p_82244_2_, p_82244_3_, this);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71007_a(IInventory p_71007_1_) {
      if(this.field_71070_bA != this.field_71069_bz) {
         this.func_71053_j();
      }

      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 0, p_71007_1_.func_70303_b(), p_71007_1_.func_70302_i_(), p_71007_1_.func_94042_c()));
      this.field_71070_bA = new ContainerChest(this.field_71071_by, p_71007_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_94064_a(TileEntityHopper p_94064_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 9, p_94064_1_.func_70303_b(), p_94064_1_.func_70302_i_(), p_94064_1_.func_94042_c()));
      this.field_71070_bA = new ContainerHopper(this.field_71071_by, p_94064_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_96125_a(EntityMinecartHopper p_96125_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 9, p_96125_1_.func_70303_b(), p_96125_1_.func_70302_i_(), p_96125_1_.func_94042_c()));
      this.field_71070_bA = new ContainerHopper(this.field_71071_by, p_96125_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71042_a(TileEntityFurnace p_71042_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 2, p_71042_1_.func_70303_b(), p_71042_1_.func_70302_i_(), p_71042_1_.func_94042_c()));
      this.field_71070_bA = new ContainerFurnace(this.field_71071_by, p_71042_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71006_a(TileEntityDispenser p_71006_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, p_71006_1_ instanceof TileEntityDropper?10:3, p_71006_1_.func_70303_b(), p_71006_1_.func_70302_i_(), p_71006_1_.func_94042_c()));
      this.field_71070_bA = new ContainerDispenser(this.field_71071_by, p_71006_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71017_a(TileEntityBrewingStand p_71017_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 5, p_71017_1_.func_70303_b(), p_71017_1_.func_70302_i_(), p_71017_1_.func_94042_c()));
      this.field_71070_bA = new ContainerBrewingStand(this.field_71071_by, p_71017_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_82240_a(TileEntityBeacon p_82240_1_) {
      this.func_71117_bO();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 7, p_82240_1_.func_70303_b(), p_82240_1_.func_70302_i_(), p_82240_1_.func_94042_c()));
      this.field_71070_bA = new ContainerBeacon(this.field_71071_by, p_82240_1_);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
   }

   public void func_71030_a(IMerchant p_71030_1_, String p_71030_2_) {
      this.func_71117_bO();
      this.field_71070_bA = new ContainerMerchant(this.field_71071_by, p_71030_1_, this.field_70170_p);
      this.field_71070_bA.field_75152_c = this.field_71139_cq;
      this.field_71070_bA.func_75132_a(this);
      InventoryMerchant var3 = ((ContainerMerchant)this.field_71070_bA).func_75174_d();
      this.field_71135_a.func_72567_b(new Packet100OpenWindow(this.field_71139_cq, 6, p_71030_2_ == null?"":p_71030_2_, var3.func_70302_i_(), p_71030_2_ != null));
      MerchantRecipeList var4 = p_71030_1_.func_70934_b(this);
      if(var4 != null) {
         try {
            ByteArrayOutputStream var5 = new ByteArrayOutputStream();
            DataOutputStream var6 = new DataOutputStream(var5);
            var6.writeInt(this.field_71139_cq);
            var4.func_77200_a(var6);
            this.field_71135_a.func_72567_b(new Packet250CustomPayload("MC|TrList", var5.toByteArray()));
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

   }

   public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
      if(!(p_71111_1_.func_75139_a(p_71111_2_) instanceof SlotCrafting)) {
         if(!this.field_71137_h) {
            this.field_71135_a.func_72567_b(new Packet103SetSlot(p_71111_1_.field_75152_c, p_71111_2_, p_71111_3_));
         }
      }
   }

   public void func_71120_a(Container p_71120_1_) {
      this.func_71110_a(p_71120_1_, p_71120_1_.func_75138_a());
   }

   public void func_71110_a(Container p_71110_1_, List p_71110_2_) {
      this.field_71135_a.func_72567_b(new Packet104WindowItems(p_71110_1_.field_75152_c, p_71110_2_));
      this.field_71135_a.func_72567_b(new Packet103SetSlot(-1, -1, this.field_71071_by.func_70445_o()));
   }

   public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {
      this.field_71135_a.func_72567_b(new Packet105UpdateProgressbar(p_71112_1_.field_75152_c, p_71112_2_, p_71112_3_));
   }

   public void func_71053_j() {
      this.field_71135_a.func_72567_b(new Packet101CloseWindow(this.field_71070_bA.field_75152_c));
      this.func_71128_l();
   }

   public void func_71113_k() {
      if(!this.field_71137_h) {
         this.field_71135_a.func_72567_b(new Packet103SetSlot(-1, -1, this.field_71071_by.func_70445_o()));
      }
   }

   public void func_71128_l() {
      this.field_71070_bA.func_75134_a(this);
      this.field_71070_bA = this.field_71069_bz;
   }

   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
      if(p_71064_1_ != null) {
         if(!p_71064_1_.field_75972_f) {
            while(p_71064_2_ > 100) {
               this.field_71135_a.func_72567_b(new Packet200Statistic(p_71064_1_.field_75975_e, 100));
               p_71064_2_ -= 100;
            }

            this.field_71135_a.func_72567_b(new Packet200Statistic(p_71064_1_.field_75975_e, p_71064_2_));
         }

      }
   }

   public void func_71123_m() {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70078_a(this);
      }

      if(this.field_71083_bS) {
         this.func_70999_a(true, false, false);
      }

   }

   public void func_71118_n() {
      this.field_71149_ch = -99999999;
   }

   public void func_71035_c(String p_71035_1_) {
      StringTranslate var2 = StringTranslate.func_74808_a();
      String var3 = var2.func_74805_b(p_71035_1_);
      this.field_71135_a.func_72567_b(new Packet3Chat(var3));
   }

   protected void func_71036_o() {
      this.field_71135_a.func_72567_b(new Packet38EntityStatus(this.field_70157_k, (byte)9));
      super.func_71036_o();
   }

   public void func_71008_a(ItemStack p_71008_1_, int p_71008_2_) {
      super.func_71008_a(p_71008_1_, p_71008_2_);
      if(p_71008_1_ != null && p_71008_1_.func_77973_b() != null && p_71008_1_.func_77973_b().func_77661_b(p_71008_1_) == EnumAction.eat) {
         this.func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(this, 5));
      }

   }

   public void func_71049_a(EntityPlayer p_71049_1_, boolean p_71049_2_) {
      super.func_71049_a(p_71049_1_, p_71049_2_);
      this.field_71144_ck = -1;
      this.field_71149_ch = -1;
      this.field_71146_ci = -1;
      this.field_71130_g.addAll(((EntityPlayerMP)p_71049_1_).field_71130_g);
   }

   protected void func_70670_a(PotionEffect p_70670_1_) {
      super.func_70670_a(p_70670_1_);
      this.field_71135_a.func_72567_b(new Packet41EntityEffect(this.field_70157_k, p_70670_1_));
   }

   protected void func_70695_b(PotionEffect p_70695_1_) {
      super.func_70695_b(p_70695_1_);
      this.field_71135_a.func_72567_b(new Packet41EntityEffect(this.field_70157_k, p_70695_1_));
   }

   protected void func_70688_c(PotionEffect p_70688_1_) {
      super.func_70688_c(p_70688_1_);
      this.field_71135_a.func_72567_b(new Packet42RemoveEntityEffect(this.field_70157_k, p_70688_1_));
   }

   public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
      this.field_71135_a.func_72569_a(p_70634_1_, p_70634_3_, p_70634_5_, this.field_70177_z, this.field_70125_A);
   }

   public void func_71009_b(Entity p_71009_1_) {
      this.func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(p_71009_1_, 6));
   }

   public void func_71047_c(Entity p_71047_1_) {
      this.func_71121_q().func_73039_n().func_72789_b(this, new Packet18Animation(p_71047_1_, 7));
   }

   public void func_71016_p() {
      if(this.field_71135_a != null) {
         this.field_71135_a.func_72567_b(new Packet202PlayerAbilities(this.field_71075_bZ));
      }
   }

   public WorldServer func_71121_q() {
      return (WorldServer)this.field_70170_p;
   }

   public void func_71033_a(EnumGameType p_71033_1_) {
      this.field_71134_c.func_73076_a(p_71033_1_);
      this.field_71135_a.func_72567_b(new Packet70GameEvent(3, p_71033_1_.func_77148_a()));
   }

   public void func_70006_a(String p_70006_1_) {
      this.field_71135_a.func_72567_b(new Packet3Chat(p_70006_1_));
   }

   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
      return "seed".equals(p_70003_2_) && !this.field_71133_b.func_71262_S()?true:(!"tell".equals(p_70003_2_) && !"help".equals(p_70003_2_) && !"me".equals(p_70003_2_)?this.field_71133_b.func_71203_ab().func_72353_e(this.field_71092_bJ):true);
   }

   public String func_71114_r() {
      String var1 = this.field_71135_a.field_72575_b.func_74430_c().toString();
      var1 = var1.substring(var1.indexOf("/") + 1);
      var1 = var1.substring(0, var1.indexOf(":"));
      return var1;
   }

   public void func_71125_a(Packet204ClientInfo p_71125_1_) {
      if(this.field_71148_cg.func_74806_b().containsKey(p_71125_1_.func_73459_d())) {
         this.field_71148_cg.func_74810_a(p_71125_1_.func_73459_d(), false);
      }

      int var2 = 256 >> p_71125_1_.func_73461_f();
      if(var2 > 3 && var2 < 15) {
         this.field_71142_cm = var2;
      }

      this.field_71143_cn = p_71125_1_.func_73463_g();
      this.field_71140_co = p_71125_1_.func_73460_h();
      if(this.field_71133_b.func_71264_H() && this.field_71133_b.func_71214_G().equals(this.field_71092_bJ)) {
         this.field_71133_b.func_71226_c(p_71125_1_.func_73462_i());
      }

      this.func_82239_b(1, !p_71125_1_.func_82563_j());
   }

   public StringTranslate func_71025_t() {
      return this.field_71148_cg;
   }

   public int func_71126_v() {
      return this.field_71143_cn;
   }

   public void func_71115_a(String p_71115_1_, int p_71115_2_) {
      String var3 = p_71115_1_ + "\u0000" + p_71115_2_;
      this.field_71135_a.func_72567_b(new Packet250CustomPayload("MC|TPack", var3.getBytes()));
   }

   public ChunkCoordinates func_82114_b() {
      return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v));
   }
}
