package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.ExceptionMcoHttp;
import net.minecraft.client.mco.Request;

@SideOnly(Side.CLIENT)
public class RequestDelete extends Request {

   public RequestDelete(String p_i10031_1_, int p_i10031_2_, int p_i10031_3_) {
      super(p_i10031_1_, p_i10031_2_, p_i10031_3_);
   }

   public RequestDelete func_96370_f() {
      try {
         this.field_96367_a.setDoOutput(true);
         this.field_96367_a.setRequestMethod("DELETE");
         this.field_96367_a.connect();
         return this;
      } catch (Exception var2) {
         throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, var2);
      }
   }

   // $FF: synthetic method
   public Request func_96359_e() {
      return this.func_96370_f();
   }
}
