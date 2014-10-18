package org.periodicraft.periodicraft.block;

import java.util.Random;

import org.periodicraft.periodicraft.Periodicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.network.NetHandlerHandshakeMemory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PeriodicraftBlock extends Block {

	public PeriodicraftBlock(Material m, String name, CreativeTabs ct, String tc, int hl) {
		this(m, 3.5F, 3.5F, Block.soundTypeStone, name, ct, tc, hl);
	}
	
	public PeriodicraftBlock(Material m, float h, float r, Block.SoundType st, String name, CreativeTabs ct, String tc, int hl) {
		this(m, h, r, st, name, 0, ct, tc, hl);
	}
	
	public PeriodicraftBlock(Material m, float h, float r, Block.SoundType st, String name, float lv, CreativeTabs ct, String tc, int hl) {
		super(m);
		this.setHardness(h);
		this.setResistance(r);
		this.setStepSound(st);
		this.setLightLevel(lv);
		this.setBlockName(name);
		this.setBlockTextureName(Periodicraft.MODID + ":" + name);
		this.setCreativeTab(ct);
		this.setHarvestLevel(tc, hl);
		GameRegistry.registerBlock(this, Periodicraft.MODID + "_" + name);
		
	}
	
	@Override
	public int quantityDropped(Random r) {
        return 1;
    }
	
	@Override
	public Item getItemDropped(int i, Random r, int i1) {
        return Item.getItemFromBlock(this);
    }

	
	
}
