package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.ExceptionMcoHttp;
import net.minecraft.client.mco.Request;

@SideOnly(Side.CLIENT)
public class RequestGet extends Request {

   public RequestGet(String p_i10030_1_, int p_i10030_2_, int p_i10030_3_) {
      super(p_i10030_1_, p_i10030_2_, p_i10030_3_);
   }

   public RequestGet func_96371_f() {
      try {
         this.field_96367_a.setDoInput(true);
         this.field_96367_a.setDoOutput(true);
         this.field_96367_a.setUseCaches(false);
         this.field_96367_a.setRequestMethod("GET");
         return this;
      } catch (Exception var2) {
         throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, var2);
      }
   }

   // $FF: synthetic method
   public Request func_96359_e() {
      return this.func_96371_f();
   }
}
