package net.minecraft.world.gen.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillageStart;

public class MapGenVillage extends MapGenStructure {

   public static List field_75055_e = Arrays.asList(new BiomeGenBase[]{BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d});
   private int field_75054_f;
   private int field_82665_g;
   private int field_82666_h;


   public MapGenVillage() {
      this.field_75054_f = 0;
      this.field_82665_g = 32;
      this.field_82666_h = 8;
   }

   public MapGenVillage(Map p_i5097_1_) {
      this();
      Iterator var2 = p_i5097_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("size")) {
            this.field_75054_f = MathHelper.func_82714_a((String)var3.getValue(), this.field_75054_f, 0);
         } else if(((String)var3.getKey()).equals("distance")) {
            this.field_82665_g = MathHelper.func_82714_a((String)var3.getValue(), this.field_82665_g, this.field_82666_h + 1);
         }
      }

   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      int var3 = p_75047_1_;
      int var4 = p_75047_2_;
      if(p_75047_1_ < 0) {
         p_75047_1_ -= this.field_82665_g - 1;
      }

      if(p_75047_2_ < 0) {
         p_75047_2_ -= this.field_82665_g - 1;
      }

      int var5 = p_75047_1_ / this.field_82665_g;
      int var6 = p_75047_2_ / this.field_82665_g;
      Random var7 = this.field_75039_c.func_72843_D(var5, var6, 10387312);
      var5 *= this.field_82665_g;
      var6 *= this.field_82665_g;
      var5 += var7.nextInt(this.field_82665_g - this.field_82666_h);
      var6 += var7.nextInt(this.field_82665_g - this.field_82666_h);
      if(var3 == var5 && var4 == var6) {
         boolean var8 = this.field_75039_c.func_72959_q().func_76940_a(var3 * 16 + 8, var4 * 16 + 8, 0, field_75055_e);
         if(var8) {
            return true;
         }
      }

      return false;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new StructureVillageStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_, this.field_75054_f);
   }

}
