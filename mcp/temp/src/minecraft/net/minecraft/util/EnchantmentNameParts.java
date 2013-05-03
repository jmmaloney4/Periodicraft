package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class EnchantmentNameParts {

   public static final EnchantmentNameParts field_78061_a = new EnchantmentNameParts();
   private Random field_78059_b = new Random();
   private String[] field_78060_c = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");


   public String func_78057_a() {
      int var1 = this.field_78059_b.nextInt(2) + 3;
      String var2 = "";

      for(int var3 = 0; var3 < var1; ++var3) {
         if(var3 > 0) {
            var2 = var2 + " ";
         }

         var2 = var2 + this.field_78060_c[this.field_78059_b.nextInt(this.field_78060_c.length)];
      }

      return var2;
   }

   public void func_78058_a(long p_78058_1_) {
      this.field_78059_b.setSeed(p_78058_1_);
   }

}
