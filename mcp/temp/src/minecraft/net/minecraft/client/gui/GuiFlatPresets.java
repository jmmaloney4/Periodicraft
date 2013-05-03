package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorld;
import net.minecraft.client.gui.GuiFlatPresetsItem;
import net.minecraft.client.gui.GuiFlatPresetsListSlot;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiFlatPresets extends GuiScreen {

   private static RenderItem field_82305_a = new RenderItem();
   private static final List field_82301_b = new ArrayList();
   private final GuiCreateFlatWorld field_82302_c;
   private String field_82300_d;
   private String field_82308_m;
   private String field_82306_n;
   private GuiFlatPresetsListSlot field_82307_o;
   private GuiButton field_82304_p;
   private GuiTextField field_82303_q;


   public GuiFlatPresets(GuiCreateFlatWorld p_i5001_1_) {
      this.field_82302_c = p_i5001_1_;
   }

   public void func_73866_w_() {
      this.field_73887_h.clear();
      Keyboard.enableRepeatEvents(true);
      this.field_82300_d = StatCollector.func_74838_a("createWorld.customize.presets.title");
      this.field_82308_m = StatCollector.func_74838_a("createWorld.customize.presets.share");
      this.field_82306_n = StatCollector.func_74838_a("createWorld.customize.presets.list");
      this.field_82303_q = new GuiTextField(this.field_73886_k, 50, 40, this.field_73880_f - 100, 20);
      this.field_82307_o = new GuiFlatPresetsListSlot(this);
      this.field_82303_q.func_73804_f(1230);
      this.field_82303_q.func_73782_a(this.field_82302_c.func_82275_e());
      this.field_73887_h.add(this.field_82304_p = new GuiButton(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, StatCollector.func_74838_a("createWorld.customize.presets.select")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, StatCollector.func_74838_a("gui.cancel")));
      this.func_82296_g();
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      this.field_82303_q.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(!this.field_82303_q.func_73802_a(p_73869_1_, p_73869_2_)) {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 0 && this.func_82293_j()) {
         this.field_82302_c.func_82273_a(this.field_82303_q.func_73781_b());
         this.field_73882_e.func_71373_a(this.field_82302_c);
      } else if(p_73875_1_.field_73741_f == 1) {
         this.field_73882_e.func_71373_a(this.field_82302_c);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.field_82307_o.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_73886_k, this.field_82300_d, this.field_73880_f / 2, 8, 16777215);
      this.func_73731_b(this.field_73886_k, this.field_82308_m, 50, 30, 10526880);
      this.func_73731_b(this.field_73886_k, this.field_82306_n, 50, 70, 10526880);
      this.field_82303_q.func_73795_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      this.field_82303_q.func_73780_a();
      super.func_73876_c();
   }

   public void func_82296_g() {
      boolean var1 = this.func_82293_j();
      this.field_82304_p.field_73742_g = var1;
   }

   private boolean func_82293_j() {
      return this.field_82307_o.field_82459_a > -1 && this.field_82307_o.field_82459_a < field_82301_b.size() || this.field_82303_q.func_73781_b().length() > 1;
   }

   public static void func_82297_a(String p_82297_0_, int p_82297_1_, BiomeGenBase p_82297_2_, FlatLayerInfo ... p_82297_3_) {
      func_82294_a(p_82297_0_, p_82297_1_, p_82297_2_, (List)null, p_82297_3_);
   }

   public static void func_82294_a(String p_82294_0_, int p_82294_1_, BiomeGenBase p_82294_2_, List p_82294_3_, FlatLayerInfo ... p_82294_4_) {
      FlatGeneratorInfo var5 = new FlatGeneratorInfo();

      for(int var6 = p_82294_4_.length - 1; var6 >= 0; --var6) {
         var5.func_82650_c().add(p_82294_4_[var6]);
      }

      var5.func_82647_a(p_82294_2_.field_76756_M);
      var5.func_82645_d();
      if(p_82294_3_ != null) {
         Iterator var8 = p_82294_3_.iterator();

         while(var8.hasNext()) {
            String var7 = (String)var8.next();
            var5.func_82644_b().put(var7, new HashMap());
         }
      }

      field_82301_b.add(new GuiFlatPresetsItem(p_82294_1_, p_82294_0_, var5.toString()));
   }

   // $FF: synthetic method
   static RenderItem func_82299_h() {
      return field_82305_a;
   }

   // $FF: synthetic method
   static List func_82295_i() {
      return field_82301_b;
   }

   // $FF: synthetic method
   static GuiFlatPresetsListSlot func_82292_a(GuiFlatPresets p_82292_0_) {
      return p_82292_0_.field_82307_o;
   }

   // $FF: synthetic method
   static GuiTextField func_82298_b(GuiFlatPresets p_82298_0_) {
      return p_82298_0_.field_82303_q;
   }

   static {
      func_82294_a("Classic Flat", Block.field_71980_u.field_71990_ca, BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Block.field_71980_u.field_71990_ca), new FlatLayerInfo(2, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82294_a("Tunnelers\' Dream", Block.field_71981_t.field_71990_ca, BiomeGenBase.field_76770_e, Arrays.asList(new String[]{"biome_1", "dungeon", "decoration", "stronghold", "mineshaft"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Block.field_71980_u.field_71990_ca), new FlatLayerInfo(5, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(230, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82294_a("Water World", Block.field_71942_A.field_71990_ca, BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(90, Block.field_71943_B.field_71990_ca), new FlatLayerInfo(5, Block.field_71939_E.field_71990_ca), new FlatLayerInfo(5, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(5, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82294_a("Overworld", Block.field_71962_X.field_71990_ca, BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Block.field_71980_u.field_71990_ca), new FlatLayerInfo(3, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(59, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82294_a("Snowy Kingdom", Block.field_72037_aS.field_71990_ca, BiomeGenBase.field_76774_n, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Block.field_72037_aS.field_71990_ca), new FlatLayerInfo(1, Block.field_71980_u.field_71990_ca), new FlatLayerInfo(3, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(59, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82294_a("Bottomless Pit", Item.field_77676_L.field_77779_bT, BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Block.field_71980_u.field_71990_ca), new FlatLayerInfo(3, Block.field_71979_v.field_71990_ca), new FlatLayerInfo(2, Block.field_71978_w.field_71990_ca)});
      func_82294_a("Desert", Block.field_71939_E.field_71990_ca, BiomeGenBase.field_76769_d, Arrays.asList(new String[]{"village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"}), new FlatLayerInfo[]{new FlatLayerInfo(8, Block.field_71939_E.field_71990_ca), new FlatLayerInfo(52, Block.field_71957_Q.field_71990_ca), new FlatLayerInfo(3, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
      func_82297_a("Redstone Ready", Item.field_77767_aC.field_77779_bT, BiomeGenBase.field_76769_d, new FlatLayerInfo[]{new FlatLayerInfo(52, Block.field_71957_Q.field_71990_ca), new FlatLayerInfo(3, Block.field_71981_t.field_71990_ca), new FlatLayerInfo(1, Block.field_71986_z.field_71990_ca)});
   }
}
