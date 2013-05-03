package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiHopper extends GuiContainer {

   private IInventory field_94081_r;
   private IInventory field_94080_s;


   public GuiHopper(InventoryPlayer p_i10020_1_, IInventory p_i10020_2_) {
      super(new ContainerHopper(p_i10020_1_, p_i10020_2_));
      this.field_94081_r = p_i10020_1_;
      this.field_94080_s = p_i10020_2_;
      this.field_73885_j = false;
      this.field_74195_c = 133;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      this.field_73886_k.func_78276_b(this.field_94080_s.func_94042_c()?this.field_94080_s.func_70303_b():StatCollector.func_74838_a(this.field_94080_s.func_70303_b()), 8, 6, 4210752);
      this.field_73886_k.func_78276_b(this.field_94081_r.func_94042_c()?this.field_94081_r.func_70303_b():StatCollector.func_74838_a(this.field_94081_r.func_70303_b()), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/hopper.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
   }
}
