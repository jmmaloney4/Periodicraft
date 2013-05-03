package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiEditSign extends GuiScreen {

   private static final String field_73981_b = ChatAllowedCharacters.field_71568_a;
   protected String field_73983_a = "Edit sign message:";
   private TileEntitySign field_73982_c;
   private int field_73980_d;
   private int field_73984_m = 0;
   private GuiButton field_100001_o;


   public GuiEditSign(TileEntitySign p_i3080_1_) {
      this.field_73982_c = p_i3080_1_;
   }

   public void func_73866_w_() {
      this.field_73887_h.clear();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.add(this.field_100001_o = new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120, "Done"));
      this.field_73982_c.func_70408_a(false);
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
      NetClientHandler var1 = this.field_73882_e.func_71391_r();
      if(var1 != null) {
         var1.func_72552_c(new Packet130UpdateSign(this.field_73982_c.field_70329_l, this.field_73982_c.field_70330_m, this.field_73982_c.field_70327_n, this.field_73982_c.field_70412_a));
      }

      this.field_73982_c.func_70408_a(true);
   }

   public void func_73876_c() {
      ++this.field_73980_d;
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 0) {
            this.field_73982_c.func_70296_d();
            this.field_73882_e.func_71373_a((GuiScreen)null);
         }

      }
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 200) {
         this.field_73984_m = this.field_73984_m - 1 & 3;
      }

      if(p_73869_2_ == 208 || p_73869_2_ == 28) {
         this.field_73984_m = this.field_73984_m + 1 & 3;
      }

      if(p_73869_2_ == 14 && this.field_73982_c.field_70412_a[this.field_73984_m].length() > 0) {
         this.field_73982_c.field_70412_a[this.field_73984_m] = this.field_73982_c.field_70412_a[this.field_73984_m].substring(0, this.field_73982_c.field_70412_a[this.field_73984_m].length() - 1);
      }

      if(field_73981_b.indexOf(p_73869_1_) >= 0 && this.field_73982_c.field_70412_a[this.field_73984_m].length() < 15) {
         this.field_73982_c.field_70412_a[this.field_73984_m] = this.field_73982_c.field_70412_a[this.field_73984_m] + p_73869_1_;
      }

      if(p_73869_2_ == 1) {
         this.func_73875_a(this.field_100001_o);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, this.field_73983_a, this.field_73880_f / 2, 40, 16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(this.field_73880_f / 2), 0.0F, 50.0F);
      float var4 = 93.75F;
      GL11.glScalef(-var4, -var4, -var4);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      Block var5 = this.field_73982_c.func_70311_o();
      if(var5 == Block.field_72053_aD) {
         float var6 = (float)(this.field_73982_c.func_70322_n() * 360) / 16.0F;
         GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      } else {
         int var8 = this.field_73982_c.func_70322_n();
         float var7 = 0.0F;
         if(var8 == 2) {
            var7 = 180.0F;
         }

         if(var8 == 4) {
            var7 = 90.0F;
         }

         if(var8 == 5) {
            var7 = -90.0F;
         }

         GL11.glRotatef(var7, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      }

      if(this.field_73980_d / 6 % 2 == 0) {
         this.field_73982_c.field_70410_b = this.field_73984_m;
      }

      TileEntityRenderer.field_76963_a.func_76949_a(this.field_73982_c, -0.5D, -0.75D, -0.5D, 0.0F);
      this.field_73982_c.field_70410_b = -1;
      GL11.glPopMatrix();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
