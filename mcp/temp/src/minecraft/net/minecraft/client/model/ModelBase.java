package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

@SideOnly(Side.CLIENT)
public abstract class ModelBase {

   public float field_78095_p;
   public boolean field_78093_q = false;
   public List field_78092_r = new ArrayList();
   public boolean field_78091_s = true;
   private Map field_78094_a = new HashMap();
   public int field_78090_t = 64;
   public int field_78089_u = 32;


   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {}

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {}

   public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {}

   public ModelRenderer func_85181_a(Random p_85181_1_) {
      return (ModelRenderer)this.field_78092_r.get(p_85181_1_.nextInt(this.field_78092_r.size()));
   }

   protected void func_78085_a(String p_78085_1_, int p_78085_2_, int p_78085_3_) {
      this.field_78094_a.put(p_78085_1_, new TextureOffset(p_78085_2_, p_78085_3_));
   }

   public TextureOffset func_78084_a(String p_78084_1_) {
      return (TextureOffset)this.field_78094_a.get(p_78084_1_);
   }
}
