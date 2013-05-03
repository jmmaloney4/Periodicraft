package net.minecraft.client.mco;

import argo.jdom.JdomParser;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ValueObject;

@SideOnly(Side.CLIENT)
public class McoServerAddress extends ValueObject {

   public String field_96417_a;


   public static McoServerAddress func_98162_a(String p_98162_0_) {
      McoServerAddress var1 = new McoServerAddress();

      try {
         JsonRootNode var2 = (new JdomParser()).parse(p_98162_0_);
         var1.field_96417_a = var2.getStringValue(new Object[]{"address"});
      } catch (InvalidSyntaxException var3) {
         ;
      } catch (IllegalArgumentException var4) {
         ;
      }

      return var1;
   }
}
