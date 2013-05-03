package net.minecraft.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.material.MaterialLogic;
import net.minecraft.block.material.MaterialPortal;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraft.block.material.MaterialWeb;

public class Material {

   public static final Material field_76249_a = new MaterialTransparent(MapColor.field_76279_b);
   public static final Material field_76247_b = new Material(MapColor.field_76280_c);
   public static final Material field_76248_c = new Material(MapColor.field_76284_l);
   public static final Material field_76245_d = (new Material(MapColor.field_76283_o)).func_76226_g();
   public static final Material field_76246_e = (new Material(MapColor.field_76285_m)).func_76221_f();
   public static final Material field_76243_f = (new Material(MapColor.field_76288_h)).func_76221_f();
   public static final Material field_82717_g = (new Material(MapColor.field_76288_h)).func_76221_f().func_76225_o();
   public static final Material field_76244_g = (new MaterialLiquid(MapColor.field_76282_n)).func_76219_n();
   public static final Material field_76256_h = (new MaterialLiquid(MapColor.field_76275_f)).func_76219_n();
   public static final Material field_76257_i = (new Material(MapColor.field_76289_i)).func_76226_g().func_76223_p().func_76219_n();
   public static final Material field_76254_j = (new MaterialLogic(MapColor.field_76289_i)).func_76219_n();
   public static final Material field_76255_k = (new MaterialLogic(MapColor.field_76289_i)).func_76226_g().func_76219_n().func_76231_i();
   public static final Material field_76252_l = new Material(MapColor.field_76278_e);
   public static final Material field_76253_m = (new Material(MapColor.field_76278_e)).func_76226_g();
   public static final Material field_76250_n = (new MaterialTransparent(MapColor.field_76279_b)).func_76219_n();
   public static final Material field_76251_o = new Material(MapColor.field_76277_d);
   public static final Material field_76265_p = (new MaterialLogic(MapColor.field_76279_b)).func_76219_n();
   public static final Material field_76264_q = (new Material(MapColor.field_76279_b)).func_76223_p().func_85158_p();
   public static final Material field_76263_r = (new Material(MapColor.field_76279_b)).func_85158_p();
   public static final Material field_76262_s = (new Material(MapColor.field_76275_f)).func_76226_g().func_76223_p();
   public static final Material field_76261_t = (new Material(MapColor.field_76289_i)).func_76219_n();
   public static final Material field_76260_u = (new Material(MapColor.field_76276_g)).func_76223_p().func_85158_p();
   public static final Material field_76259_v = (new MaterialLogic(MapColor.field_76286_j)).func_76231_i().func_76223_p().func_76221_f().func_76219_n();
   public static final Material field_76258_w = (new Material(MapColor.field_76286_j)).func_76221_f();
   public static final Material field_76268_x = (new Material(MapColor.field_76289_i)).func_76223_p().func_76219_n();
   public static final Material field_76267_y = new Material(MapColor.field_76287_k);
   public static final Material field_76266_z = (new Material(MapColor.field_76289_i)).func_76219_n();
   public static final Material field_76236_A = (new Material(MapColor.field_76289_i)).func_76219_n();
   public static final Material field_76237_B = (new MaterialPortal(MapColor.field_76279_b)).func_76225_o();
   public static final Material field_76238_C = (new Material(MapColor.field_76279_b)).func_76219_n();
   public static final Material field_76232_D = (new MaterialWeb(MapColor.field_76278_e)).func_76221_f().func_76219_n();
   public static final Material field_76233_E = (new Material(MapColor.field_76285_m)).func_76225_o();
   private boolean field_76235_G;
   private boolean field_76239_H;
   private boolean field_76240_I;
   public final MapColor field_76234_F;
   private boolean field_76241_J = true;
   private int field_76242_K;
   private boolean field_85159_M;


   public Material(MapColor p_i3882_1_) {
      this.field_76234_F = p_i3882_1_;
   }

   public boolean func_76224_d() {
      return false;
   }

   public boolean func_76220_a() {
      return true;
   }

   public boolean func_76228_b() {
      return true;
   }

   public boolean func_76230_c() {
      return true;
   }

   private Material func_76223_p() {
      this.field_76240_I = true;
      return this;
   }

   protected Material func_76221_f() {
      this.field_76241_J = false;
      return this;
   }

   protected Material func_76226_g() {
      this.field_76235_G = true;
      return this;
   }

   public boolean func_76217_h() {
      return this.field_76235_G;
   }

   public Material func_76231_i() {
      this.field_76239_H = true;
      return this;
   }

   public boolean func_76222_j() {
      return this.field_76239_H;
   }

   public boolean func_76218_k() {
      return this.field_76240_I?false:this.func_76230_c();
   }

   public boolean func_76229_l() {
      return this.field_76241_J;
   }

   public int func_76227_m() {
      return this.field_76242_K;
   }

   protected Material func_76219_n() {
      this.field_76242_K = 1;
      return this;
   }

   protected Material func_76225_o() {
      this.field_76242_K = 2;
      return this;
   }

   protected Material func_85158_p() {
      this.field_85159_M = true;
      return this;
   }

   public boolean func_85157_q() {
      return this.field_85159_M;
   }

}
