package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Rect2i {

   private int field_94164_a;
   private int field_94162_b;
   private int field_94163_c;
   private int field_94161_d;


   public Rect2i(int p_i9006_1_, int p_i9006_2_, int p_i9006_3_, int p_i9006_4_) {
      this.field_94164_a = p_i9006_1_;
      this.field_94162_b = p_i9006_2_;
      this.field_94163_c = p_i9006_3_;
      this.field_94161_d = p_i9006_4_;
   }

   public Rect2i func_94156_a(Rect2i p_94156_1_) {
      int var2 = this.field_94164_a;
      int var3 = this.field_94162_b;
      int var4 = this.field_94164_a + this.field_94163_c;
      int var5 = this.field_94162_b + this.field_94161_d;
      int var6 = p_94156_1_.func_94158_a();
      int var7 = p_94156_1_.func_94160_b();
      int var8 = var6 + p_94156_1_.func_94159_c();
      int var9 = var7 + p_94156_1_.func_94157_d();
      this.field_94164_a = Math.max(var2, var6);
      this.field_94162_b = Math.max(var3, var7);
      this.field_94163_c = Math.max(0, Math.min(var4, var8) - this.field_94164_a);
      this.field_94161_d = Math.max(0, Math.min(var5, var9) - this.field_94162_b);
      return this;
   }

   public int func_94158_a() {
      return this.field_94164_a;
   }

   public int func_94160_b() {
      return this.field_94162_b;
   }

   public int func_94159_c() {
      return this.field_94163_c;
   }

   public int func_94157_d() {
      return this.field_94161_d;
   }
}
