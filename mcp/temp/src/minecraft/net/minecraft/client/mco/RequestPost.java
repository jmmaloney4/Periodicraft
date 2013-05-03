package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.OutputStream;
import net.minecraft.client.mco.ExceptionMcoHttp;
import net.minecraft.client.mco.Request;

@SideOnly(Side.CLIENT)
public class RequestPost extends Request {

   private byte[] field_96373_c;


   public RequestPost(String p_i10027_1_, byte[] p_i10027_2_, int p_i10027_3_, int p_i10027_4_) {
      super(p_i10027_1_, p_i10027_3_, p_i10027_4_);
      this.field_96373_c = p_i10027_2_;
   }

   public RequestPost func_96372_f() {
      try {
         this.field_96367_a.setDoInput(true);
         this.field_96367_a.setDoOutput(true);
         this.field_96367_a.setUseCaches(false);
         this.field_96367_a.setRequestMethod("POST");
         OutputStream var1 = this.field_96367_a.getOutputStream();
         var1.write(this.field_96373_c);
         var1.flush();
         return this;
      } catch (Exception var2) {
         throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, var2);
      }
   }

   // $FF: synthetic method
   public Request func_96359_e() {
      return this.func_96372_f();
   }
}
