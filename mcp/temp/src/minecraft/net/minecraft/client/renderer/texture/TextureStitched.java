package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureClock;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.util.Icon;
import net.minecraft.util.Tuple;

@SideOnly(Side.CLIENT)
public class TextureStitched implements Icon {

   private final String field_94235_h;
   protected Texture field_94228_a;
   protected List field_94226_b;
   private List field_94236_i;
   protected boolean field_94227_c;
   protected int field_94224_d;
   protected int field_94225_e;
   private int field_94233_j;
   private int field_94234_k;
   private float field_94231_l;
   private float field_94232_m;
   private float field_94229_n;
   private float field_94230_o;
   private float field_94238_p;
   private float field_94237_q;
   protected int field_94222_f = 0;
   protected int field_94223_g = 0;


   public static TextureStitched func_94220_a(String p_94220_0_) {
      return (TextureStitched)("clock".equals(p_94220_0_)?new TextureClock():("compass".equals(p_94220_0_)?new TextureCompass():new TextureStitched(p_94220_0_)));
   }

   protected TextureStitched(String p_i9013_1_) {
      this.field_94235_h = p_i9013_1_;
   }

   public void func_94218_a(Texture p_94218_1_, List p_94218_2_, int p_94218_3_, int p_94218_4_, int p_94218_5_, int p_94218_6_, boolean p_94218_7_) {
      this.field_94228_a = p_94218_1_;
      this.field_94226_b = p_94218_2_;
      this.field_94224_d = p_94218_3_;
      this.field_94225_e = p_94218_4_;
      this.field_94233_j = p_94218_5_;
      this.field_94234_k = p_94218_6_;
      this.field_94227_c = p_94218_7_;
      float var8 = 0.01F / (float)p_94218_1_.func_94275_d();
      float var9 = 0.01F / (float)p_94218_1_.func_94276_e();
      this.field_94231_l = (float)p_94218_3_ / (float)p_94218_1_.func_94275_d() + var8;
      this.field_94232_m = (float)(p_94218_3_ + p_94218_5_) / (float)p_94218_1_.func_94275_d() - var8;
      this.field_94229_n = (float)p_94218_4_ / (float)p_94218_1_.func_94276_e() + var9;
      this.field_94230_o = (float)(p_94218_4_ + p_94218_6_) / (float)p_94218_1_.func_94276_e() - var9;
      this.field_94238_p = (float)p_94218_5_ / 16.0F;
      this.field_94237_q = (float)p_94218_6_ / 16.0F;
   }

   public void func_94217_a(TextureStitched p_94217_1_) {
      this.func_94218_a(p_94217_1_.field_94228_a, p_94217_1_.field_94226_b, p_94217_1_.field_94224_d, p_94217_1_.field_94225_e, p_94217_1_.field_94233_j, p_94217_1_.field_94234_k, p_94217_1_.field_94227_c);
   }

   public int func_94211_a() {
      return this.field_94224_d;
   }

   public int func_94216_b() {
      return this.field_94225_e;
   }

   public float func_94209_e() {
      return this.field_94231_l;
   }

   public float func_94212_f() {
      return this.field_94232_m;
   }

   public float func_94214_a(double p_94214_1_) {
      float var3 = this.field_94232_m - this.field_94231_l;
      return this.field_94231_l + var3 * ((float)p_94214_1_ / 16.0F);
   }

   public float func_94206_g() {
      return this.field_94229_n;
   }

   public float func_94210_h() {
      return this.field_94230_o;
   }

   public float func_94207_b(double p_94207_1_) {
      float var3 = this.field_94230_o - this.field_94229_n;
      return this.field_94229_n + var3 * ((float)p_94207_1_ / 16.0F);
   }

   public String func_94215_i() {
      return this.field_94235_h;
   }

   public int func_94213_j() {
      return this.field_94228_a.func_94275_d();
   }

   public int func_94208_k() {
      return this.field_94228_a.func_94276_e();
   }

   public void func_94219_l() {
      if(this.field_94236_i != null) {
         Tuple var1 = (Tuple)this.field_94236_i.get(this.field_94222_f);
         ++this.field_94223_g;
         if(this.field_94223_g >= ((Integer)var1.func_76340_b()).intValue()) {
            int var2 = ((Integer)var1.func_76341_a()).intValue();
            this.field_94222_f = (this.field_94222_f + 1) % this.field_94236_i.size();
            this.field_94223_g = 0;
            var1 = (Tuple)this.field_94236_i.get(this.field_94222_f);
            int var3 = ((Integer)var1.func_76341_a()).intValue();
            if(var2 != var3 && var3 >= 0 && var3 < this.field_94226_b.size()) {
               this.field_94228_a.func_94281_a(this.field_94224_d, this.field_94225_e, (Texture)this.field_94226_b.get(var3), this.field_94227_c);
            }
         }
      } else {
         int var4 = this.field_94222_f;
         this.field_94222_f = (this.field_94222_f + 1) % this.field_94226_b.size();
         if(var4 != this.field_94222_f) {
            this.field_94228_a.func_94281_a(this.field_94224_d, this.field_94225_e, (Texture)this.field_94226_b.get(this.field_94222_f), this.field_94227_c);
         }
      }

   }

   public void func_94221_a(BufferedReader p_94221_1_) {
      ArrayList var2 = new ArrayList();

      try {
         for(String var3 = p_94221_1_.readLine(); var3 != null; var3 = p_94221_1_.readLine()) {
            var3 = var3.trim();
            if(var3.length() > 0) {
               String[] var4 = var3.split(",");
               String[] var5 = var4;
               int var6 = var4.length;

               for(int var7 = 0; var7 < var6; ++var7) {
                  String var8 = var5[var7];
                  int var9 = var8.indexOf(42);
                  if(var9 > 0) {
                     Integer var10 = new Integer(var8.substring(0, var9));
                     Integer var11 = new Integer(var8.substring(var9 + 1));
                     var2.add(new Tuple(var10, var11));
                  } else {
                     var2.add(new Tuple(new Integer(var8), Integer.valueOf(1)));
                  }
               }
            }
         }
      } catch (Exception var12) {
         System.err.println("Failed to read animation info for " + this.field_94235_h + ": " + var12.getMessage());
      }

      if(!var2.isEmpty() && var2.size() < 600) {
         this.field_94236_i = var2;
      }

   }
}
