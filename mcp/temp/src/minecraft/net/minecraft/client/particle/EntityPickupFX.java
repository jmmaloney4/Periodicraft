package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityPickupFX extends EntityFX {

   private Entity field_70591_a;
   private Entity field_70595_aq;
   private int field_70594_ar = 0;
   private int field_70593_as = 0;
   private float field_70592_at;


   public EntityPickupFX(World p_i3176_1_, Entity p_i3176_2_, Entity p_i3176_3_, float p_i3176_4_) {
      super(p_i3176_1_, p_i3176_2_.field_70165_t, p_i3176_2_.field_70163_u, p_i3176_2_.field_70161_v, p_i3176_2_.field_70159_w, p_i3176_2_.field_70181_x, p_i3176_2_.field_70179_y);
      this.field_70591_a = p_i3176_2_;
      this.field_70595_aq = p_i3176_3_;
      this.field_70593_as = 3;
      this.field_70592_at = p_i3176_4_;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70594_ar + p_70539_2_) / (float)this.field_70593_as;
      var8 *= var8;
      double var9 = this.field_70591_a.field_70165_t;
      double var11 = this.field_70591_a.field_70163_u;
      double var13 = this.field_70591_a.field_70161_v;
      double var15 = this.field_70595_aq.field_70142_S + (this.field_70595_aq.field_70165_t - this.field_70595_aq.field_70142_S) * (double)p_70539_2_;
      double var17 = this.field_70595_aq.field_70137_T + (this.field_70595_aq.field_70163_u - this.field_70595_aq.field_70137_T) * (double)p_70539_2_ + (double)this.field_70592_at;
      double var19 = this.field_70595_aq.field_70136_U + (this.field_70595_aq.field_70161_v - this.field_70595_aq.field_70136_U) * (double)p_70539_2_;
      double var21 = var9 + (var15 - var9) * (double)var8;
      double var23 = var11 + (var17 - var11) * (double)var8;
      double var25 = var13 + (var19 - var13) * (double)var8;
      int var27 = MathHelper.func_76128_c(var21);
      int var28 = MathHelper.func_76128_c(var23 + (double)(this.field_70129_M / 2.0F));
      int var29 = MathHelper.func_76128_c(var25);
      int var30 = this.func_70070_b(p_70539_2_);
      int var31 = var30 % 65536;
      int var32 = var30 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var31 / 1.0F, (float)var32 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var21 -= field_70556_an;
      var23 -= field_70554_ao;
      var25 -= field_70555_ap;
      RenderManager.field_78727_a.func_78719_a(this.field_70591_a, (double)((float)var21), (double)((float)var23), (double)((float)var25), this.field_70591_a.field_70177_z, p_70539_2_);
   }

   public void func_70071_h_() {
      ++this.field_70594_ar;
      if(this.field_70594_ar == this.field_70593_as) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }
}
