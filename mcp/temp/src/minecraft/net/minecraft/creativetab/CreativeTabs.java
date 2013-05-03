package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.creativetab.CreativeTabBlock;
import net.minecraft.creativetab.CreativeTabBrewing;
import net.minecraft.creativetab.CreativeTabCombat;
import net.minecraft.creativetab.CreativeTabDeco;
import net.minecraft.creativetab.CreativeTabFood;
import net.minecraft.creativetab.CreativeTabInventory;
import net.minecraft.creativetab.CreativeTabMaterial;
import net.minecraft.creativetab.CreativeTabMisc;
import net.minecraft.creativetab.CreativeTabRedstone;
import net.minecraft.creativetab.CreativeTabSearch;
import net.minecraft.creativetab.CreativeTabTools;
import net.minecraft.creativetab.CreativeTabTransport;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.util.StringTranslate;

public class CreativeTabs {

   public static CreativeTabs[] field_78032_a = new CreativeTabs[12];
   public static final CreativeTabs field_78030_b = new CreativeTabBlock(0, "buildingBlocks");
   public static final CreativeTabs field_78031_c = new CreativeTabDeco(1, "decorations");
   public static final CreativeTabs field_78028_d = new CreativeTabRedstone(2, "redstone");
   public static final CreativeTabs field_78029_e = new CreativeTabTransport(3, "transportation");
   public static final CreativeTabs field_78026_f = new CreativeTabMisc(4, "misc");
   public static final CreativeTabs field_78027_g = (new CreativeTabSearch(5, "search")).func_78025_a("search.png");
   public static final CreativeTabs field_78039_h = new CreativeTabFood(6, "food");
   public static final CreativeTabs field_78040_i = new CreativeTabTools(7, "tools");
   public static final CreativeTabs field_78037_j = new CreativeTabCombat(8, "combat");
   public static final CreativeTabs field_78038_k = new CreativeTabBrewing(9, "brewing");
   public static final CreativeTabs field_78035_l = new CreativeTabMaterial(10, "materials");
   public static final CreativeTabs field_78036_m = (new CreativeTabInventory(11, "inventory")).func_78025_a("survival_inv.png").func_78022_j().func_78014_h();
   private final int field_78033_n;
   private final String field_78034_o;
   private String field_78043_p = "list_items.png";
   private boolean field_78042_q = true;
   private boolean field_78041_r = true;


   public CreativeTabs(int p_i3642_1_, String p_i3642_2_) {
      this.field_78033_n = p_i3642_1_;
      this.field_78034_o = p_i3642_2_;
      field_78032_a[p_i3642_1_] = this;
   }

   @SideOnly(Side.CLIENT)
   public int func_78021_a() {
      return this.field_78033_n;
   }

   public CreativeTabs func_78025_a(String p_78025_1_) {
      this.field_78043_p = p_78025_1_;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public String func_78013_b() {
      return this.field_78034_o;
   }

   @SideOnly(Side.CLIENT)
   public String func_78024_c() {
      return StringTranslate.func_74808_a().func_74805_b("itemGroup." + this.func_78013_b());
   }

   @SideOnly(Side.CLIENT)
   public Item func_78016_d() {
      return Item.field_77698_e[this.func_78012_e()];
   }

   @SideOnly(Side.CLIENT)
   public int func_78012_e() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public String func_78015_f() {
      return this.field_78043_p;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_78019_g() {
      return this.field_78041_r;
   }

   public CreativeTabs func_78014_h() {
      this.field_78041_r = false;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_78017_i() {
      return this.field_78042_q;
   }

   public CreativeTabs func_78022_j() {
      this.field_78042_q = false;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public int func_78020_k() {
      return this.field_78033_n % 6;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_78023_l() {
      return this.field_78033_n < 6;
   }

   @SideOnly(Side.CLIENT)
   public void func_78018_a(List p_78018_1_) {
      Item[] var2 = Item.field_77698_e;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Item var5 = var2[var4];
         if(var5 != null && var5.func_77640_w() == this) {
            var5.func_77633_a(var5.field_77779_bT, this, p_78018_1_);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_92116_a(List p_92116_1_, EnumEnchantmentType ... p_92116_2_) {
      Enchantment[] var3 = Enchantment.field_77331_b;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Enchantment var6 = var3[var5];
         if(var6 != null && var6.field_77351_y != null) {
            boolean var7 = false;

            for(int var8 = 0; var8 < p_92116_2_.length && !var7; ++var8) {
               if(var6.field_77351_y == p_92116_2_[var8]) {
                  var7 = true;
               }
            }

            if(var7) {
               p_92116_1_.add(Item.field_92105_bW.func_92111_a(new EnchantmentData(var6, var6.func_77325_b())));
            }
         }
      }

   }

}
