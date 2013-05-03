package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInput;

@SideOnly(Side.CLIENT)
public class MovementInputFromOptions extends MovementInput {

   private GameSettings field_78903_e;


   public MovementInputFromOptions(GameSettings p_i3115_1_) {
      this.field_78903_e = p_i3115_1_;
   }

   public void func_78898_a() {
      this.field_78902_a = 0.0F;
      this.field_78900_b = 0.0F;
      if(this.field_78903_e.field_74351_w.field_74513_e) {
         ++this.field_78900_b;
      }

      if(this.field_78903_e.field_74368_y.field_74513_e) {
         --this.field_78900_b;
      }

      if(this.field_78903_e.field_74370_x.field_74513_e) {
         ++this.field_78902_a;
      }

      if(this.field_78903_e.field_74366_z.field_74513_e) {
         --this.field_78902_a;
      }

      this.field_78901_c = this.field_78903_e.field_74314_A.field_74513_e;
      this.field_78899_d = this.field_78903_e.field_74311_E.field_74513_e;
      if(this.field_78899_d) {
         this.field_78902_a = (float)((double)this.field_78902_a * 0.3D);
         this.field_78900_b = (float)((double)this.field_78900_b * 0.3D);
      }

   }
}
