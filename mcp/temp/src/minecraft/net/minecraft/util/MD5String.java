package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SideOnly(Side.CLIENT)
public class MD5String {

   private String field_75900_a;


   public MD5String(String p_i3417_1_) {
      this.field_75900_a = p_i3417_1_;
   }

   public String func_75899_a(String p_75899_1_) {
      try {
         String var2 = this.field_75900_a + p_75899_1_;
         MessageDigest var3 = MessageDigest.getInstance("MD5");
         var3.update(var2.getBytes(), 0, var2.length());
         return (new BigInteger(1, var3.digest())).toString(16);
      } catch (NoSuchAlgorithmException var4) {
         throw new RuntimeException(var4);
      }
   }
}
