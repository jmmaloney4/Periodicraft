package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiBrewingStand extends GuiContainer {

   private TileEntityBrewingStand field_74217_o;


   public GuiBrewingStand(InventoryPlayer p_i3092_1_, TileEntityBrewingStand p_i3092_2_) {
      super(new ContainerBrewingStand(p_i3092_1_, p_i3092_2_));
      this.field_74217_o = p_i3092_2_;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      String var3 = this.field_74217_o.func_94042_c()?this.field_74217_o.func_70303_b():StatCollector.func_74838_a(this.field_74217_o.func_70303_b());
      this.field_73886_k.func_78276_b(var3, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(var3) / 2, 6, 4210752);
      this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/alchemy.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
      int var6 = this.field_74217_o.func_70355_t_();
      if(var6 > 0) {
         int var7 = (int)(28.0F * (1.0F - (float)var6 / 400.0F));
         if(var7 > 0) {
            this.func_73729_b(var4 + 97, var5 + 16, 176, 0, 9, var7);
         }

         int var8 = var6 / 2 % 7;
         switch(var8) {
         case 0:
            var7 = 29;
            break;
         case 1:
            var7 = 24;
            break;
         case 2:
            var7 = 20;
            break;
         case 3:
            var7 = 16;
            break;
         case 4:
            var7 = 11;
            break;
         case 5:
            var7 = 6;
            break;
         case 6:
            var7 = 0;
         }

         if(var7 > 0) {
            this.func_73729_b(var4 + 65, var5 + 14 + 29 - var7, 185, 29 - var7, 12, var7);
         }
      }

   }
}
