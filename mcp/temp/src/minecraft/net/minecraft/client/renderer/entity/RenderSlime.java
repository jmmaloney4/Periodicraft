package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSlime extends RenderLiving {

   private ModelBase field_77092_a;


   public RenderSlime(ModelBase p_i3198_1_, ModelBase p_i3198_2_, float p_i3198_3_) {
      super(p_i3198_1_, p_i3198_3_);
      this.field_77092_a = p_i3198_2_;
   }

   protected int func_77090_a(EntitySlime p_77090_1_, int p_77090_2_, float p_77090_3_) {
      if(p_77090_1_.func_82150_aj()) {
         return 0;
      } else if(p_77090_2_ == 0) {
         this.func_77042_a(this.field_77092_a);
         GL11.glEnable(2977);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         return 1;
      } else {
         if(p_77090_2_ == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         return -1;
      }
   }

   protected void func_77091_a(EntitySlime p_77091_1_, float p_77091_2_) {
      float var3 = (float)p_77091_1_.func_70809_q();
      float var4 = (p_77091_1_.field_70812_c + (p_77091_1_.field_70811_b - p_77091_1_.field_70812_c) * p_77091_2_) / (var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      GL11.glScalef(var5 * var3, 1.0F / var5 * var3, var5 * var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77091_a((EntitySlime)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77090_a((EntitySlime)p_77032_1_, p_77032_2_, p_77032_3_);
   }
}
