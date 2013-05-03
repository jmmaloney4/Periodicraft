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

@SideOnly(Side.CLIENT)
public class Locations
{
    public List field_96599_a;
    public Location field_96598_b;

    public static Locations func_98174_a(String par0Str)
    {
        Locations locations = new Locations();
        locations.field_96599_a = new ArrayList();

        try
        {
            JsonRootNode jsonrootnode = (new JdomParser()).parse(par0Str);

            if (jsonrootnode.isArrayNode(new Object[] {"locations"}))
            {
                Iterator iterator = jsonrootnode.getArrayNode(new Object[] {"locations"}).iterator();

                while (iterator.hasNext())
                {
                    JsonNode jsonnode = (JsonNode)iterator.next();
                    locations.field_96599_a.add(Location.func_98167_a(jsonnode));
                }
            }
            locations.field_96598_b = Location.func_98168_a(jsonrootnode, "suggestion");
        }
        catch (InvalidSyntaxException invalidsyntaxexception)
        {
            ;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            ;
        }

        return locations;
    }
}
