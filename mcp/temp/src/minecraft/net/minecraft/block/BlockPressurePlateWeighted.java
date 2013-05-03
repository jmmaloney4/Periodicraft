package net.minecraft.block;

import java.util.Iterator;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPressurePlateWeighted extends BlockBasePressurePlate {

   private final int field_94357_a;


   protected BlockPressurePlateWeighted(int p_i9016_1_, String p_i9016_2_, Material p_i9016_3_, int p_i9016_4_) {
      super(p_i9016_1_, p_i9016_2_, p_i9016_3_);
      this.field_94357_a = p_i9016_4_;
   }

   protected int func_94351_d(World p_94351_1_, int p_94351_2_, int p_94351_3_, int p_94351_4_) {
      int var5 = 0;
      Iterator var6 = p_94351_1_.func_72872_a(EntityItem.class, this.func_94352_a(p_94351_2_, p_94351_3_, p_94351_4_)).iterator();

      while(var6.hasNext()) {
         EntityItem var7 = (EntityItem)var6.next();
         var5 += var7.func_92059_d().field_77994_a;
         if(var5 >= this.field_94357_a) {
            break;
         }
      }

      if(var5 <= 0) {
         return 0;
      } else {
         float var8 = (float)Math.min(this.field_94357_a, var5) / (float)this.field_94357_a;
         return MathHelper.func_76123_f(var8 * 15.0F);
      }
   }

   protected int func_94350_c(int p_94350_1_) {
      return p_94350_1_;
   }

   protected int func_94355_d(int p_94355_1_) {
      return p_94355_1_;
   }

   public int func_71859_p_(World p_71859_1_) {
      return 10;
   }
}
