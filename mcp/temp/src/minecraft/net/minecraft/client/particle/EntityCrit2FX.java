package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityCrit2FX extends EntityFX {

   private Entity field_70557_a;
   private int field_70560_aq;
   private int field_70559_ar;
   private String field_70558_as;


   public EntityCrit2FX(World p_i3171_1_, Entity p_i3171_2_) {
      this(p_i3171_1_, p_i3171_2_, "crit");
   }

   public EntityCrit2FX(World p_i3172_1_, Entity p_i3172_2_, String p_i3172_3_) {
      super(p_i3172_1_, p_i3172_2_.field_70165_t, p_i3172_2_.field_70121_D.field_72338_b + (double)(p_i3172_2_.field_70131_O / 2.0F), p_i3172_2_.field_70161_v, p_i3172_2_.field_70159_w, p_i3172_2_.field_70181_x, p_i3172_2_.field_70179_y);
      this.field_70560_aq = 0;
      this.field_70559_ar = 0;
      this.field_70557_a = p_i3172_2_;
      this.field_70559_ar = 3;
      this.field_70558_as = p_i3172_3_;
      this.func_70071_h_();
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {}

   public void func_70071_h_() {
      for(int var1 = 0; var1 < 16; ++var1) {
         double var2 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
         double var4 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
         if(var2 * var2 + var4 * var4 + var6 * var6 <= 1.0D) {
            double var8 = this.field_70557_a.field_70165_t + var2 * (double)this.field_70557_a.field_70130_N / 4.0D;
            double var10 = this.field_70557_a.field_70121_D.field_72338_b + (double)(this.field_70557_a.field_70131_O / 2.0F) + var4 * (double)this.field_70557_a.field_70131_O / 4.0D;
            double var12 = this.field_70557_a.field_70161_v + var6 * (double)this.field_70557_a.field_70130_N / 4.0D;
            this.field_70170_p.func_72869_a(this.field_70558_as, var8, var10, var12, var2, var4 + 0.2D, var6);
         }
      }

      ++this.field_70560_aq;
      if(this.field_70560_aq >= this.field_70559_ar) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }
}
