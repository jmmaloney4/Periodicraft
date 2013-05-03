package net.minecraft.client.mco;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.mco.Location;

@SideOnly(Side.CLIENT)
public class Locations {

   public List field_96599_a;
   public Location field_96598_b;


   public static Locations func_98174_a(String p_98174_0_) {
      Locations var1 = new Locations();
      var1.field_96599_a = new ArrayList();

      try {
         JsonRootNode var2 = (new JdomParser()).parse(p_98174_0_);
         if(var2.isArrayNode(new Object[]{"locations"})) {
            Iterator var3 = var2.getArrayNode(new Object[]{"locations"}).iterator();

            while(var3.hasNext()) {
               JsonNode var4 = (JsonNode)var3.next();
               var1.field_96599_a.add(Location.func_98167_a(var4));
            }
         }

         var1.field_96598_b = Location.func_98168_a(var2, "suggestion");
      } catch (InvalidSyntaxException var5) {
         ;
      } catch (IllegalArgumentException var6) {
         ;
      }

      return var1;
   }
}
