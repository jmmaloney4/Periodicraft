package mods.periodicraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.EnumHelper;

public class PeriodicraftItemTool extends ItemTool {

	protected PeriodicraftItemTool(int par1, float par2,
			EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		// TODO Auto-generated constructor stub
	}

	public static EnumToolMaterial addToolType(String name, int Durabiblity,
			int Enchantability, int HarvestLevel, float Efficency, float Damage) {
		EnumToolMaterial material = EnumHelper.addToolMaterial(name,
				HarvestLevel, Durabiblity, Efficency,
				Damage, Enchantability);
		return material;
	}

}
