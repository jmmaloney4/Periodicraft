package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiChest extends GuiContainer {

   private IInventory field_74220_o;
   private IInventory field_74219_p;
   private int field_74218_q = 0;


   public GuiChest(IInventory p_i3078_1_, IInventory p_i3078_2_) {
      super(new ContainerChest(p_i3078_1_, p_i3078_2_));
      this.field_74220_o = p_i3078_1_;
      this.field_74219_p = p_i3078_2_;
      this.field_73885_j = false;
      short var3 = 222;
      int var4 = var3 - 108;
      this.field_74218_q = p_i3078_2_.func_70302_i_() / 9;
      this.field_74195_c = var4 + this.field_74218_q * 18;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      this.field_73886_k.func_78276_b(this.field_74219_p.func_94042_c()?this.field_74219_p.func_70303_b():StatCollector.func_74838_a(this.field_74219_p.func_70303_b()), 8, 6, 4210752);
      this.field_73886_k.func_78276_b(this.field_74220_o.func_94042_c()?this.field_74220_o.func_70303_b():StatCollector.func_74838_a(this.field_74220_o.func_70303_b()), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/container.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74218_q * 18 + 17);
      this.func_73729_b(var4, var5 + this.field_74218_q * 18 + 17, 0, 126, this.field_74194_b, 96);
   }
}
