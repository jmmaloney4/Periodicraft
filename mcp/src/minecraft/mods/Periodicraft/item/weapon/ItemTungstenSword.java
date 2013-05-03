package mods.Periodicraft.item.weapon;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftSword;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemTungstenSword extends PeriodicraftSword {

	public ItemTungstenSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabWeapons).setUnlocalizedName("TungstenSword");
	}
}
