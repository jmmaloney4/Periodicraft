package mods.Periodicraft.item;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftFood;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemBanana extends PeriodicraftFood {

	public ItemBanana(int par1) {
		super(par1, 6, 3.5F, true);
		this.setCreativeTab(Periodicraft.tabFood);
		this.setMaxStackSize(64).setPotionEffect("Potion.Regeneration").setUnlocalizedName("Banana");
	}

}
