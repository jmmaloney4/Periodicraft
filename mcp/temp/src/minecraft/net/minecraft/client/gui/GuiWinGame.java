package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiWinGame extends GuiScreen {

   private int field_73990_a = 0;
   private List field_73988_b;
   private int field_73989_c = 0;
   private float field_73987_d = 0.5F;


   public void func_73876_c() {
      ++this.field_73990_a;
      float var1 = (float)(this.field_73989_c + this.field_73881_g + this.field_73881_g + 24) / this.field_73987_d;
      if((float)this.field_73990_a > var1) {
         this.func_73985_g();
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 1) {
         this.func_73985_g();
      }

   }

   private void func_73985_g() {
      this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new Packet205ClientCommand(1));
      this.field_73882_e.func_71373_a((GuiScreen)null);
   }

   public boolean func_73868_f() {
      return true;
   }

   public void func_73866_w_() {
      if(this.field_73988_b == null) {
         this.field_73988_b = new ArrayList();

         try {
            String var1 = "";
            String var2 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + EnumChatFormatting.GREEN + EnumChatFormatting.AQUA;
            short var3 = 274;
            BufferedReader var4 = new BufferedReader(new InputStreamReader(GuiWinGame.class.getResourceAsStream("/title/win.txt"), Charset.forName("UTF-8")));
            Random var5 = new Random(8124371L);

            int var6;
            while((var1 = var4.readLine()) != null) {
               String var7;
               String var8;
               for(var1 = var1.replaceAll("PLAYERNAME", this.field_73882_e.field_71449_j.field_74286_b); var1.contains(var2); var1 = var7 + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, var5.nextInt(4) + 3) + var8) {
                  var6 = var1.indexOf(var2);
                  var7 = var1.substring(0, var6);
                  var8 = var1.substring(var6 + var2.length());
               }

               this.field_73988_b.addAll(this.field_73882_e.field_71466_p.func_78271_c(var1, var3));
               this.field_73988_b.add("");
            }

            for(var6 = 0; var6 < 8; ++var6) {
               this.field_73988_b.add("");
            }

            var4 = new BufferedReader(new InputStreamReader(GuiWinGame.class.getResourceAsStream("/title/credits.txt"), Charset.forName("UTF-8")));

            while((var1 = var4.readLine()) != null) {
               var1 = var1.replaceAll("PLAYERNAME", this.field_73882_e.field_71449_j.field_74286_b);
               var1 = var1.replaceAll("\t", "    ");
               this.field_73988_b.addAll(this.field_73882_e.field_71466_p.func_78271_c(var1, var3));
               this.field_73988_b.add("");
            }

            this.field_73989_c = this.field_73988_b.size() * 12;
         } catch (Exception var9) {
            var9.printStackTrace();
         }

      }
   }

   private void func_73986_b(int p_73986_1_, int p_73986_2_, float p_73986_3_) {
      Tessellator var4 = Tessellator.field_78398_a;
      this.field_73882_e.field_71446_o.func_98187_b("%blur%/gui/background.png");
      var4.func_78382_b();
      var4.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
      int var5 = this.field_73880_f;
      float var6 = 0.0F - ((float)this.field_73990_a + p_73986_3_) * 0.5F * this.field_73987_d;
      float var7 = (float)this.field_73881_g - ((float)this.field_73990_a + p_73986_3_) * 0.5F * this.field_73987_d;
      float var8 = 0.015625F;
      float var9 = ((float)this.field_73990_a + p_73986_3_ - 0.0F) * 0.02F;
      float var10 = (float)(this.field_73989_c + this.field_73881_g + this.field_73881_g + 24) / this.field_73987_d;
      float var11 = (var10 - 20.0F - ((float)this.field_73990_a + p_73986_3_)) * 0.0050F;
      if(var11 < var9) {
         var9 = var11;
      }

      if(var9 > 1.0F) {
         var9 = 1.0F;
      }

      var9 *= var9;
      var9 = var9 * 96.0F / 255.0F;
      var4.func_78386_a(var9, var9, var9);
      var4.func_78374_a(0.0D, (double)this.field_73881_g, (double)this.field_73735_i, 0.0D, (double)(var6 * var8));
      var4.func_78374_a((double)var5, (double)this.field_73881_g, (double)this.field_73735_i, (double)((float)var5 * var8), (double)(var6 * var8));
      var4.func_78374_a((double)var5, 0.0D, (double)this.field_73735_i, (double)((float)var5 * var8), (double)(var7 * var8));
      var4.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, (double)(var7 * var8));
      var4.func_78381_a();
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73986_b(p_73863_1_, p_73863_2_, p_73863_3_);
      Tessellator var4 = Tessellator.field_78398_a;
      short var5 = 274;
      int var6 = this.field_73880_f / 2 - var5 / 2;
      int var7 = this.field_73881_g + 50;
      float var8 = -((float)this.field_73990_a + p_73863_3_) * this.field_73987_d;
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, var8, 0.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/title/mclogo.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73729_b(var6, var7, 0, 0, 155, 44);
      this.func_73729_b(var6 + 155, var7, 0, 45, 155, 44);
      var4.func_78378_d(16777215);
      int var9 = var7 + 200;

      int var10;
      for(var10 = 0; var10 < this.field_73988_b.size(); ++var10) {
         if(var10 == this.field_73988_b.size() - 1) {
            float var11 = (float)var9 + var8 - (float)(this.field_73881_g / 2 - 6);
            if(var11 < 0.0F) {
               GL11.glTranslatef(0.0F, -var11, 0.0F);
            }
         }

         if((float)var9 + var8 + 12.0F + 8.0F > 0.0F && (float)var9 + var8 < (float)this.field_73881_g) {
            String var12 = (String)this.field_73988_b.get(var10);
            if(var12.startsWith("[C]")) {
               this.field_73886_k.func_78261_a(var12.substring(3), var6 + (var5 - this.field_73886_k.func_78256_a(var12.substring(3))) / 2, var9, 16777215);
            } else {
               this.field_73886_k.field_78289_c.setSeed((long)var10 * 4238972211L + (long)(this.field_73990_a / 4));
               this.field_73886_k.func_78261_a(var12, var6, var9, 16777215);
            }
         }

         var9 += 12;
      }

      GL11.glPopMatrix();
      this.field_73882_e.field_71446_o.func_98187_b("%blur%/misc/vignette.png");
      GL11.glEnable(3042);
      GL11.glBlendFunc(0, 769);
      var4.func_78382_b();
      var4.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
      var10 = this.field_73880_f;
      int var13 = this.field_73881_g;
      var4.func_78374_a(0.0D, (double)var13, (double)this.field_73735_i, 0.0D, 1.0D);
      var4.func_78374_a((double)var10, (double)var13, (double)this.field_73735_i, 1.0D, 1.0D);
      var4.func_78374_a((double)var10, 0.0D, (double)this.field_73735_i, 1.0D, 0.0D);
      var4.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, 0.0D);
      var4.func_78381_a();
      GL11.glDisable(3042);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }
}
