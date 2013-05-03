package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiFurnace extends GuiContainer {

   private TileEntityFurnace field_74204_o;


   public GuiFurnace(InventoryPlayer p_i3094_1_, TileEntityFurnace p_i3094_2_) {
      super(new ContainerFurnace(p_i3094_1_, p_i3094_2_));
      this.field_74204_o = p_i3094_2_;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      String var3 = this.field_74204_o.func_94042_c()?this.field_74204_o.func_70303_b():StatCollector.func_74838_a(this.field_74204_o.func_70303_b());
      this.field_73886_k.func_78276_b(var3, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(var3) / 2, 6, 4210752);
      this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/furnace.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
      int var6;
      if(this.field_74204_o.func_70400_i()) {
         var6 = this.field_74204_o.func_70403_d(12);
         this.func_73729_b(var4 + 56, var5 + 36 + 12 - var6, 176, 12 - var6, 14, var6 + 2);
      }

      var6 = this.field_74204_o.func_70397_c(24);
      this.func_73729_b(var4 + 79, var5 + 34, 176, 14, var6 + 1, 16);
   }
}
