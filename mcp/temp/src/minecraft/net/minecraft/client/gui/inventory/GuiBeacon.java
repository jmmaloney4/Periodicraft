package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeaconButtonCancel;
import net.minecraft.client.gui.inventory.GuiBeaconButtonConfirm;
import net.minecraft.client.gui.inventory.GuiBeaconButtonPower;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiBeacon extends GuiContainer {

   private TileEntityBeacon field_82323_o;
   private GuiBeaconButtonConfirm field_82322_p;
   private boolean field_82321_q;


   public GuiBeacon(InventoryPlayer p_i5012_1_, TileEntityBeacon p_i5012_2_) {
      super(new ContainerBeacon(p_i5012_1_, p_i5012_2_));
      this.field_82323_o = p_i5012_2_;
      this.field_74194_b = 230;
      this.field_74195_c = 219;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      this.field_73887_h.add(this.field_82322_p = new GuiBeaconButtonConfirm(this, -1, this.field_74198_m + 164, this.field_74197_n + 107));
      this.field_73887_h.add(new GuiBeaconButtonCancel(this, -2, this.field_74198_m + 190, this.field_74197_n + 107));
      this.field_82321_q = true;
      this.field_82322_p.field_73742_g = false;
   }

   public void func_73876_c() {
      super.func_73876_c();
      if(this.field_82321_q && this.field_82323_o.func_82130_k() >= 0) {
         this.field_82321_q = false;

         int var2;
         int var3;
         int var4;
         int var5;
         GuiBeaconButtonPower var6;
         for(int var1 = 0; var1 <= 2; ++var1) {
            var2 = TileEntityBeacon.field_82139_a[var1].length;
            var3 = var2 * 22 + (var2 - 1) * 2;

            for(var4 = 0; var4 < var2; ++var4) {
               var5 = TileEntityBeacon.field_82139_a[var1][var4].field_76415_H;
               var6 = new GuiBeaconButtonPower(this, var1 << 8 | var5, this.field_74198_m + 76 + var4 * 24 - var3 / 2, this.field_74197_n + 22 + var1 * 25, var5, var1);
               this.field_73887_h.add(var6);
               if(var1 >= this.field_82323_o.func_82130_k()) {
                  var6.field_73742_g = false;
               } else if(var5 == this.field_82323_o.func_82126_i()) {
                  var6.func_82254_b(true);
               }
            }
         }

         byte var7 = 3;
         var2 = TileEntityBeacon.field_82139_a[var7].length + 1;
         var3 = var2 * 22 + (var2 - 1) * 2;

         for(var4 = 0; var4 < var2 - 1; ++var4) {
            var5 = TileEntityBeacon.field_82139_a[var7][var4].field_76415_H;
            var6 = new GuiBeaconButtonPower(this, var7 << 8 | var5, this.field_74198_m + 167 + var4 * 24 - var3 / 2, this.field_74197_n + 47, var5, var7);
            this.field_73887_h.add(var6);
            if(var7 >= this.field_82323_o.func_82130_k()) {
               var6.field_73742_g = false;
            } else if(var5 == this.field_82323_o.func_82132_j()) {
               var6.func_82254_b(true);
            }
         }

         if(this.field_82323_o.func_82126_i() > 0) {
            GuiBeaconButtonPower var8 = new GuiBeaconButtonPower(this, var7 << 8 | this.field_82323_o.func_82126_i(), this.field_74198_m + 167 + (var2 - 1) * 24 - var3 / 2, this.field_74197_n + 47, this.field_82323_o.func_82126_i(), var7);
            this.field_73887_h.add(var8);
            if(var7 >= this.field_82323_o.func_82130_k()) {
               var8.field_73742_g = false;
            } else if(this.field_82323_o.func_82126_i() == this.field_82323_o.func_82132_j()) {
               var8.func_82254_b(true);
            }
         }
      }

      this.field_82322_p.field_73742_g = this.field_82323_o.func_70301_a(0) != null && this.field_82323_o.func_82126_i() > 0;
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == -2) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
      } else if(p_73875_1_.field_73741_f == -1) {
         String var2 = "MC|Beacon";
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         DataOutputStream var4 = new DataOutputStream(var3);

         try {
            var4.writeInt(this.field_82323_o.func_82126_i());
            var4.writeInt(this.field_82323_o.func_82132_j());
            this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload(var2, var3.toByteArray()));
         } catch (Exception var6) {
            var6.printStackTrace();
         }

         this.field_73882_e.func_71373_a((GuiScreen)null);
      } else if(p_73875_1_ instanceof GuiBeaconButtonPower) {
         if(((GuiBeaconButtonPower)p_73875_1_).func_82255_b()) {
            return;
         }

         int var7 = p_73875_1_.field_73741_f;
         int var8 = var7 & 255;
         int var9 = var7 >> 8;
         if(var9 < 3) {
            this.field_82323_o.func_82128_d(var8);
         } else {
            this.field_82323_o.func_82127_e(var8);
         }

         this.field_73887_h.clear();
         this.func_73866_w_();
         this.func_73876_c();
      }

   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      RenderHelper.func_74518_a();
      this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("tile.beacon.primary"), 62, 10, 14737632);
      this.func_73732_a(this.field_73886_k, StatCollector.func_74838_a("tile.beacon.secondary"), 169, 10, 14737632);
      Iterator var3 = this.field_73887_h.iterator();

      while(var3.hasNext()) {
         GuiButton var4 = (GuiButton)var3.next();
         if(var4.func_82252_a()) {
            var4.func_82251_b(p_74189_1_ - this.field_74198_m, p_74189_2_ - this.field_74197_n);
            break;
         }
      }

      RenderHelper.func_74520_c();
   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/beacon.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
      field_74196_a.field_77023_b = 100.0F;
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, new ItemStack(Item.field_77817_bH), var4 + 42, var5 + 109);
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, new ItemStack(Item.field_77702_n), var4 + 42 + 22, var5 + 109);
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, new ItemStack(Item.field_77717_p), var4 + 42 + 44, var5 + 109);
      field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, new ItemStack(Item.field_77703_o), var4 + 42 + 66, var5 + 109);
      field_74196_a.field_77023_b = 0.0F;
   }
}
