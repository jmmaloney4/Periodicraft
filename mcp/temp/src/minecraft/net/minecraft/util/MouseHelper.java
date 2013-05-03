package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Component;
import net.minecraft.client.settings.GameSettings;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
public class MouseHelper {

   private final Component field_74376_c;
   private final GameSettings field_85184_d;
   public int field_74377_a;
   public int field_74375_b;


   public MouseHelper(Component p_i6800_1_, GameSettings p_i6800_2_) {
      this.field_74376_c = p_i6800_1_;
      this.field_85184_d = p_i6800_2_;
   }

   public void func_74372_a() {
      Mouse.setGrabbed(true);
      this.field_74377_a = 0;
      this.field_74375_b = 0;
   }

   public void func_74373_b() {
      int var1 = this.field_74376_c.getWidth();
      int var2 = this.field_74376_c.getHeight();
      if(this.field_74376_c.getParent() != null) {
         var1 = this.field_74376_c.getParent().getWidth();
         var2 = this.field_74376_c.getParent().getHeight();
      }

      Mouse.setCursorPosition(var1 / 2, var2 / 2);
      Mouse.setGrabbed(false);
   }

   public void func_74374_c() {
      this.field_74377_a = Mouse.getDX();
      this.field_74375_b = Mouse.getDY();
   }
}
