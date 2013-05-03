package net.minecraft.client.mco;

import argo.jdom.JsonNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ValueObject;

@SideOnly(Side.CLIENT)
public class Location extends ValueObject {

   public String field_96396_a;
   public String field_96395_b;


   public static Location func_98167_a(JsonNode p_98167_0_) {
      Location var1 = new Location();
      var1.field_96396_a = p_98167_0_.getStringValue(new Object[]{"locationId"});
      var1.field_96395_b = p_98167_0_.getStringValue(new Object[]{"locationName"});
      return var1;
   }

   public static Location func_98168_a(JsonNode p_98168_0_, String p_98168_1_) {
      Location var2 = new Location();
      var2.field_96396_a = p_98168_0_.getStringValue(new Object[]{p_98168_1_, "locationId"});
      var2.field_96395_b = p_98168_0_.getStringValue(new Object[]{p_98168_1_, "locationName"});
      return var2;
   }
}
