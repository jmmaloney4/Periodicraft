package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonMerchant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiMerchant extends GuiContainer {

   private IMerchant field_74203_o;
   private GuiButtonMerchant field_74202_p;
   private GuiButtonMerchant field_74201_q;
   private int field_74200_r = 0;
   private String field_94082_v;


   public GuiMerchant(InventoryPlayer p_i9002_1_, IMerchant p_i9002_2_, World p_i9002_3_, String p_i9002_4_) {
      super(new ContainerMerchant(p_i9002_1_, p_i9002_2_, p_i9002_3_));
      this.field_74203_o = p_i9002_2_;
      this.field_94082_v = p_i9002_4_ != null && p_i9002_4_.length() >= 1?p_i9002_4_:StatCollector.func_74838_a("entity.Villager.name");
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int var1 = (this.field_73880_f - this.field_74194_b) / 2;
      int var2 = (this.field_73881_g - this.field_74195_c) / 2;
      this.field_73887_h.add(this.field_74202_p = new GuiButtonMerchant(1, var1 + 120 + 27, var2 + 24 - 1, true));
      this.field_73887_h.add(this.field_74201_q = new GuiButtonMerchant(2, var1 + 36 - 19, var2 + 24 - 1, false));
      this.field_74202_p.field_73742_g = false;
      this.field_74201_q.field_73742_g = false;
   }

   protected void func_74189_g(int p_74189_1_, int p_74189_2_) {
      this.field_73886_k.func_78276_b(this.field_94082_v, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(this.field_94082_v) / 2, 6, 4210752);
      this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
   }

   public void func_73876_c() {
      super.func_73876_c();
      MerchantRecipeList var1 = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);
      if(var1 != null) {
         this.field_74202_p.field_73742_g = this.field_74200_r < var1.size() - 1;
         this.field_74201_q.field_73742_g = this.field_74200_r > 0;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      boolean var2 = false;
      if(p_73875_1_ == this.field_74202_p) {
         ++this.field_74200_r;
         var2 = true;
      } else if(p_73875_1_ == this.field_74201_q) {
         --this.field_74200_r;
         var2 = true;
      }

      if(var2) {
         ((ContainerMerchant)this.field_74193_d).func_75175_c(this.field_74200_r);
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         DataOutputStream var4 = new DataOutputStream(var3);

         try {
            var4.writeInt(this.field_74200_r);
            this.field_73882_e.func_71391_r().func_72552_c(new Packet250CustomPayload("MC|TrSel", var3.toByteArray()));
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

   }

   protected void func_74185_a(float p_74185_1_, int p_74185_2_, int p_74185_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_73882_e.field_71446_o.func_98187_b("/gui/trading.png");
      int var4 = (this.field_73880_f - this.field_74194_b) / 2;
      int var5 = (this.field_73881_g - this.field_74195_c) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_74194_b, this.field_74195_c);
      MerchantRecipeList var6 = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);
      if(var6 != null && !var6.isEmpty()) {
         int var7 = this.field_74200_r;
         MerchantRecipe var8 = (MerchantRecipe)var6.get(var7);
         if(var8.func_82784_g()) {
            this.field_73882_e.field_71446_o.func_98187_b("/gui/trading.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(2896);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 21, 212, 0, 28, 21);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 51, 212, 0, 28, 21);
         }
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      MerchantRecipeList var4 = this.field_74203_o.func_70934_b(this.field_73882_e.field_71439_g);
      if(var4 != null && !var4.isEmpty()) {
         int var5 = (this.field_73880_f - this.field_74194_b) / 2;
         int var6 = (this.field_73881_g - this.field_74195_c) / 2;
         int var7 = this.field_74200_r;
         MerchantRecipe var8 = (MerchantRecipe)var4.get(var7);
         GL11.glPushMatrix();
         ItemStack var9 = var8.func_77394_a();
         ItemStack var10 = var8.func_77396_b();
         ItemStack var11 = var8.func_77397_d();
         RenderHelper.func_74520_c();
         GL11.glDisable(2896);
         GL11.glEnable('\u803a');
         GL11.glEnable(2903);
         GL11.glEnable(2896);
         field_74196_a.field_77023_b = 100.0F;
         field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, var9, var5 + 36, var6 + 24);
         field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var9, var5 + 36, var6 + 24);
         if(var10 != null) {
            field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, var10, var5 + 62, var6 + 24);
            field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var10, var5 + 62, var6 + 24);
         }

         field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e.field_71446_o, var11, var5 + 120, var6 + 24);
         field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var11, var5 + 120, var6 + 24);
         field_74196_a.field_77023_b = 0.0F;
         GL11.glDisable(2896);
         if(this.func_74188_c(36, 24, 16, 16, p_73863_1_, p_73863_2_)) {
            this.func_74184_a(var9, p_73863_1_, p_73863_2_);
         } else if(var10 != null && this.func_74188_c(62, 24, 16, 16, p_73863_1_, p_73863_2_)) {
            this.func_74184_a(var10, p_73863_1_, p_73863_2_);
         } else if(this.func_74188_c(120, 24, 16, 16, p_73863_1_, p_73863_2_)) {
            this.func_74184_a(var11, p_73863_1_, p_73863_2_);
         }

         GL11.glPopMatrix();
         GL11.glEnable(2896);
         GL11.glEnable(2929);
         RenderHelper.func_74519_b();
      }

   }

   public IMerchant func_74199_h() {
      return this.field_74203_o;
   }
}
