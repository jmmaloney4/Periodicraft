package net.minecraft.client.mco;

import argo.jdom.JsonNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ValueObject;

@SideOnly(Side.CLIENT)
public class Location extends ValueObject
{
    public String field_96396_a;
    public String field_96395_b;

    public static Location func_98167_a(JsonNode par0JsonNode)
    {
        Location location = new Location();
        location.field_96396_a = par0JsonNode.getStringValue(new Object[] {"locationId"});
        location.field_96395_b = par0JsonNode.getStringValue(new Object[] {"locationName"});
        return location;
    }

    public static Location func_98168_a(JsonNode par0JsonNode, String par1Str)
    {
        Location location = new Location();
        location.field_96396_a = par0JsonNode.getStringValue(new Object[] {par1Str, "locationId"});
        location.field_96395_b = par0JsonNode.getStringValue(new Object[] {par1Str, "locationName"});
        return location;
    }
}
