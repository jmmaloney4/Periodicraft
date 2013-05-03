package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.storage.CallableLevelDimension;
import net.minecraft.world.storage.CallableLevelGamemode;
import net.minecraft.world.storage.CallableLevelGenerator;
import net.minecraft.world.storage.CallableLevelGeneratorOptions;
import net.minecraft.world.storage.CallableLevelSeed;
import net.minecraft.world.storage.CallableLevelSpawnLocation;
import net.minecraft.world.storage.CallableLevelStorageVersion;
import net.minecraft.world.storage.CallableLevelTime;
import net.minecraft.world.storage.CallableLevelWeather;

public class WorldInfo {

   private long field_76100_a;
   private WorldType field_76098_b;
   private String field_82576_c;
   private int field_76099_c;
   private int field_76096_d;
   private int field_76097_e;
   private long field_82575_g;
   private long field_76094_f;
   private long field_76095_g;
   private long field_76107_h;
   private NBTTagCompound field_76108_i;
   private int field_76105_j;
   private String field_76106_k;
   private int field_76103_l;
   private boolean field_76104_m;
   private int field_76101_n;
   private boolean field_76102_o;
   private int field_76114_p;
   private EnumGameType field_76113_q;
   private boolean field_76112_r;
   private boolean field_76111_s;
   private boolean field_76110_t;
   private boolean field_76109_u;
   private GameRules field_82577_x;


   protected WorldInfo() {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_82576_c = "";
      this.field_82577_x = new GameRules();
   }

   public WorldInfo(NBTTagCompound p_i3914_1_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_82576_c = "";
      this.field_82577_x = new GameRules();
      this.field_76100_a = p_i3914_1_.func_74763_f("RandomSeed");
      if(p_i3914_1_.func_74764_b("generatorName")) {
         String var2 = p_i3914_1_.func_74779_i("generatorName");
         this.field_76098_b = WorldType.func_77130_a(var2);
         if(this.field_76098_b == null) {
            this.field_76098_b = WorldType.field_77137_b;
         } else if(this.field_76098_b.func_77125_e()) {
            int var3 = 0;
            if(p_i3914_1_.func_74764_b("generatorVersion")) {
               var3 = p_i3914_1_.func_74762_e("generatorVersion");
            }

            this.field_76098_b = this.field_76098_b.func_77132_a(var3);
         }

         if(p_i3914_1_.func_74764_b("generatorOptions")) {
            this.field_82576_c = p_i3914_1_.func_74779_i("generatorOptions");
         }
      }

      this.field_76113_q = EnumGameType.func_77146_a(p_i3914_1_.func_74762_e("GameType"));
      if(p_i3914_1_.func_74764_b("MapFeatures")) {
         this.field_76112_r = p_i3914_1_.func_74767_n("MapFeatures");
      } else {
         this.field_76112_r = true;
      }

      this.field_76099_c = p_i3914_1_.func_74762_e("SpawnX");
      this.field_76096_d = p_i3914_1_.func_74762_e("SpawnY");
      this.field_76097_e = p_i3914_1_.func_74762_e("SpawnZ");
      this.field_82575_g = p_i3914_1_.func_74763_f("Time");
      if(p_i3914_1_.func_74764_b("DayTime")) {
         this.field_76094_f = p_i3914_1_.func_74763_f("DayTime");
      } else {
         this.field_76094_f = this.field_82575_g;
      }

      this.field_76095_g = p_i3914_1_.func_74763_f("LastPlayed");
      this.field_76107_h = p_i3914_1_.func_74763_f("SizeOnDisk");
      this.field_76106_k = p_i3914_1_.func_74779_i("LevelName");
      this.field_76103_l = p_i3914_1_.func_74762_e("version");
      this.field_76101_n = p_i3914_1_.func_74762_e("rainTime");
      this.field_76104_m = p_i3914_1_.func_74767_n("raining");
      this.field_76114_p = p_i3914_1_.func_74762_e("thunderTime");
      this.field_76102_o = p_i3914_1_.func_74767_n("thundering");
      this.field_76111_s = p_i3914_1_.func_74767_n("hardcore");
      if(p_i3914_1_.func_74764_b("initialized")) {
         this.field_76109_u = p_i3914_1_.func_74767_n("initialized");
      } else {
         this.field_76109_u = true;
      }

      if(p_i3914_1_.func_74764_b("allowCommands")) {
         this.field_76110_t = p_i3914_1_.func_74767_n("allowCommands");
      } else {
         this.field_76110_t = this.field_76113_q == EnumGameType.CREATIVE;
      }

      if(p_i3914_1_.func_74764_b("Player")) {
         this.field_76108_i = p_i3914_1_.func_74775_l("Player");
         this.field_76105_j = this.field_76108_i.func_74762_e("Dimension");
      }

      if(p_i3914_1_.func_74764_b("GameRules")) {
         this.field_82577_x.func_82768_a(p_i3914_1_.func_74775_l("GameRules"));
      }

   }

   public WorldInfo(WorldSettings p_i3915_1_, String p_i3915_2_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_82576_c = "";
      this.field_82577_x = new GameRules();
      this.field_76100_a = p_i3915_1_.func_77160_d();
      this.field_76113_q = p_i3915_1_.func_77162_e();
      this.field_76112_r = p_i3915_1_.func_77164_g();
      this.field_76106_k = p_i3915_2_;
      this.field_76111_s = p_i3915_1_.func_77158_f();
      this.field_76098_b = p_i3915_1_.func_77165_h();
      this.field_82576_c = p_i3915_1_.func_82749_j();
      this.field_76110_t = p_i3915_1_.func_77163_i();
      this.field_76109_u = false;
   }

   public WorldInfo(WorldInfo p_i3916_1_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_82576_c = "";
      this.field_82577_x = new GameRules();
      this.field_76100_a = p_i3916_1_.field_76100_a;
      this.field_76098_b = p_i3916_1_.field_76098_b;
      this.field_82576_c = p_i3916_1_.field_82576_c;
      this.field_76113_q = p_i3916_1_.field_76113_q;
      this.field_76112_r = p_i3916_1_.field_76112_r;
      this.field_76099_c = p_i3916_1_.field_76099_c;
      this.field_76096_d = p_i3916_1_.field_76096_d;
      this.field_76097_e = p_i3916_1_.field_76097_e;
      this.field_82575_g = p_i3916_1_.field_82575_g;
      this.field_76094_f = p_i3916_1_.field_76094_f;
      this.field_76095_g = p_i3916_1_.field_76095_g;
      this.field_76107_h = p_i3916_1_.field_76107_h;
      this.field_76108_i = p_i3916_1_.field_76108_i;
      this.field_76105_j = p_i3916_1_.field_76105_j;
      this.field_76106_k = p_i3916_1_.field_76106_k;
      this.field_76103_l = p_i3916_1_.field_76103_l;
      this.field_76101_n = p_i3916_1_.field_76101_n;
      this.field_76104_m = p_i3916_1_.field_76104_m;
      this.field_76114_p = p_i3916_1_.field_76114_p;
      this.field_76102_o = p_i3916_1_.field_76102_o;
      this.field_76111_s = p_i3916_1_.field_76111_s;
      this.field_76110_t = p_i3916_1_.field_76110_t;
      this.field_76109_u = p_i3916_1_.field_76109_u;
      this.field_82577_x = p_i3916_1_.field_82577_x;
   }

   public NBTTagCompound func_76066_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_76064_a(var1, this.field_76108_i);
      return var1;
   }

   public NBTTagCompound func_76082_a(NBTTagCompound p_76082_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      this.func_76064_a(var2, p_76082_1_);
      return var2;
   }

   private void func_76064_a(NBTTagCompound p_76064_1_, NBTTagCompound p_76064_2_) {
      p_76064_1_.func_74772_a("RandomSeed", this.field_76100_a);
      p_76064_1_.func_74778_a("generatorName", this.field_76098_b.func_77127_a());
      p_76064_1_.func_74768_a("generatorVersion", this.field_76098_b.func_77131_c());
      p_76064_1_.func_74778_a("generatorOptions", this.field_82576_c);
      p_76064_1_.func_74768_a("GameType", this.field_76113_q.func_77148_a());
      p_76064_1_.func_74757_a("MapFeatures", this.field_76112_r);
      p_76064_1_.func_74768_a("SpawnX", this.field_76099_c);
      p_76064_1_.func_74768_a("SpawnY", this.field_76096_d);
      p_76064_1_.func_74768_a("SpawnZ", this.field_76097_e);
      p_76064_1_.func_74772_a("Time", this.field_82575_g);
      p_76064_1_.func_74772_a("DayTime", this.field_76094_f);
      p_76064_1_.func_74772_a("SizeOnDisk", this.field_76107_h);
      p_76064_1_.func_74772_a("LastPlayed", System.currentTimeMillis());
      p_76064_1_.func_74778_a("LevelName", this.field_76106_k);
      p_76064_1_.func_74768_a("version", this.field_76103_l);
      p_76064_1_.func_74768_a("rainTime", this.field_76101_n);
      p_76064_1_.func_74757_a("raining", this.field_76104_m);
      p_76064_1_.func_74768_a("thunderTime", this.field_76114_p);
      p_76064_1_.func_74757_a("thundering", this.field_76102_o);
      p_76064_1_.func_74757_a("hardcore", this.field_76111_s);
      p_76064_1_.func_74757_a("allowCommands", this.field_76110_t);
      p_76064_1_.func_74757_a("initialized", this.field_76109_u);
      p_76064_1_.func_74766_a("GameRules", this.field_82577_x.func_82770_a());
      if(p_76064_2_ != null) {
         p_76064_1_.func_74766_a("Player", p_76064_2_);
      }

   }

   public long func_76063_b() {
      return this.field_76100_a;
   }

   public int func_76079_c() {
      return this.field_76099_c;
   }

   public int func_76075_d() {
      return this.field_76096_d;
   }

   public int func_76074_e() {
      return this.field_76097_e;
   }

   public long func_82573_f() {
      return this.field_82575_g;
   }

   public long func_76073_f() {
      return this.field_76094_f;
   }

   @SideOnly(Side.CLIENT)
   public long func_76092_g() {
      return this.field_76107_h;
   }

   public NBTTagCompound func_76072_h() {
      return this.field_76108_i;
   }

   public int func_76076_i() {
      return this.field_76105_j;
   }

   @SideOnly(Side.CLIENT)
   public void func_76058_a(int p_76058_1_) {
      this.field_76099_c = p_76058_1_;
   }

   @SideOnly(Side.CLIENT)
   public void func_76056_b(int p_76056_1_) {
      this.field_76096_d = p_76056_1_;
   }

   public void func_82572_b(long p_82572_1_) {
      this.field_82575_g = p_82572_1_;
   }

   @SideOnly(Side.CLIENT)
   public void func_76087_c(int p_76087_1_) {
      this.field_76097_e = p_76087_1_;
   }

   public void func_76068_b(long p_76068_1_) {
      this.field_76094_f = p_76068_1_;
   }

   public void func_76081_a(int p_76081_1_, int p_76081_2_, int p_76081_3_) {
      this.field_76099_c = p_76081_1_;
      this.field_76096_d = p_76081_2_;
      this.field_76097_e = p_76081_3_;
   }

   public String func_76065_j() {
      return this.field_76106_k;
   }

   public void func_76062_a(String p_76062_1_) {
      this.field_76106_k = p_76062_1_;
   }

   public int func_76088_k() {
      return this.field_76103_l;
   }

   public void func_76078_e(int p_76078_1_) {
      this.field_76103_l = p_76078_1_;
   }

   @SideOnly(Side.CLIENT)
   public long func_76057_l() {
      return this.field_76095_g;
   }

   public boolean func_76061_m() {
      return this.field_76102_o;
   }

   public void func_76069_a(boolean p_76069_1_) {
      this.field_76102_o = p_76069_1_;
   }

   public int func_76071_n() {
      return this.field_76114_p;
   }

   public void func_76090_f(int p_76090_1_) {
      this.field_76114_p = p_76090_1_;
   }

   public boolean func_76059_o() {
      return this.field_76104_m;
   }

   public void func_76084_b(boolean p_76084_1_) {
      this.field_76104_m = p_76084_1_;
   }

   public int func_76083_p() {
      return this.field_76101_n;
   }

   public void func_76080_g(int p_76080_1_) {
      this.field_76101_n = p_76080_1_;
   }

   public EnumGameType func_76077_q() {
      return this.field_76113_q;
   }

   public boolean func_76089_r() {
      return this.field_76112_r;
   }

   public void func_76060_a(EnumGameType p_76060_1_) {
      this.field_76113_q = p_76060_1_;
   }

   public boolean func_76093_s() {
      return this.field_76111_s;
   }

   public WorldType func_76067_t() {
      return this.field_76098_b;
   }

   public void func_76085_a(WorldType p_76085_1_) {
      this.field_76098_b = p_76085_1_;
   }

   public String func_82571_y() {
      return this.field_82576_c;
   }

   public boolean func_76086_u() {
      return this.field_76110_t;
   }

   public boolean func_76070_v() {
      return this.field_76109_u;
   }

   public void func_76091_d(boolean p_76091_1_) {
      this.field_76109_u = p_76091_1_;
   }

   public GameRules func_82574_x() {
      return this.field_82577_x;
   }

   public void func_85118_a(CrashReportCategory p_85118_1_) {
      p_85118_1_.func_71500_a("Level seed", new CallableLevelSeed(this));
      p_85118_1_.func_71500_a("Level generator", new CallableLevelGenerator(this));
      p_85118_1_.func_71500_a("Level generator options", new CallableLevelGeneratorOptions(this));
      p_85118_1_.func_71500_a("Level spawn location", new CallableLevelSpawnLocation(this));
      p_85118_1_.func_71500_a("Level time", new CallableLevelTime(this));
      p_85118_1_.func_71500_a("Level dimension", new CallableLevelDimension(this));
      p_85118_1_.func_71500_a("Level storage version", new CallableLevelStorageVersion(this));
      p_85118_1_.func_71500_a("Level weather", new CallableLevelWeather(this));
      p_85118_1_.func_71500_a("Level game mode", new CallableLevelGamemode(this));
   }

   // $FF: synthetic method
   static WorldType func_85132_a(WorldInfo p_85132_0_) {
      return p_85132_0_.field_76098_b;
   }

   // $FF: synthetic method
   static boolean func_85128_b(WorldInfo p_85128_0_) {
      return p_85128_0_.field_76112_r;
   }

   // $FF: synthetic method
   static String func_85130_c(WorldInfo p_85130_0_) {
      return p_85130_0_.field_82576_c;
   }

   // $FF: synthetic method
   static int func_85125_d(WorldInfo p_85125_0_) {
      return p_85125_0_.field_76099_c;
   }

   // $FF: synthetic method
   static int func_85124_e(WorldInfo p_85124_0_) {
      return p_85124_0_.field_76096_d;
   }

   // $FF: synthetic method
   static int func_85123_f(WorldInfo p_85123_0_) {
      return p_85123_0_.field_76097_e;
   }

   // $FF: synthetic method
   static long func_85126_g(WorldInfo p_85126_0_) {
      return p_85126_0_.field_82575_g;
   }

   // $FF: synthetic method
   static long func_85129_h(WorldInfo p_85129_0_) {
      return p_85129_0_.field_76094_f;
   }

   // $FF: synthetic method
   static int func_85122_i(WorldInfo p_85122_0_) {
      return p_85122_0_.field_76105_j;
   }

   // $FF: synthetic method
   static int func_85121_j(WorldInfo p_85121_0_) {
      return p_85121_0_.field_76103_l;
   }

   // $FF: synthetic method
   static int func_85119_k(WorldInfo p_85119_0_) {
      return p_85119_0_.field_76101_n;
   }

   // $FF: synthetic method
   static boolean func_85127_l(WorldInfo p_85127_0_) {
      return p_85127_0_.field_76104_m;
   }

   // $FF: synthetic method
   static int func_85133_m(WorldInfo p_85133_0_) {
      return p_85133_0_.field_76114_p;
   }

   // $FF: synthetic method
   static boolean func_85116_n(WorldInfo p_85116_0_) {
      return p_85116_0_.field_76102_o;
   }

   // $FF: synthetic method
   static EnumGameType func_85120_o(WorldInfo p_85120_0_) {
      return p_85120_0_.field_76113_q;
   }

   // $FF: synthetic method
   static boolean func_85117_p(WorldInfo p_85117_0_) {
      return p_85117_0_.field_76111_s;
   }

   // $FF: synthetic method
   static boolean func_85131_q(WorldInfo p_85131_0_) {
      return p_85131_0_.field_76110_t;
   }
}
