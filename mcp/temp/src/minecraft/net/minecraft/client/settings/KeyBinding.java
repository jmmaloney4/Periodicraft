package net.minecraft.client.settings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.IntHashMap;

@SideOnly(Side.CLIENT)
public class KeyBinding {

   public static List field_74516_a = new ArrayList();
   public static IntHashMap field_74514_b = new IntHashMap();
   public String field_74515_c;
   public int field_74512_d;
   public boolean field_74513_e;
   public int field_74511_f = 0;


   public static void func_74507_a(int p_74507_0_) {
      KeyBinding var1 = (KeyBinding)field_74514_b.func_76041_a(p_74507_0_);
      if(var1 != null) {
         ++var1.field_74511_f;
      }

   }

   public static void func_74510_a(int p_74510_0_, boolean p_74510_1_) {
      KeyBinding var2 = (KeyBinding)field_74514_b.func_76041_a(p_74510_0_);
      if(var2 != null) {
         var2.field_74513_e = p_74510_1_;
      }

   }

   public static void func_74506_a() {
      Iterator var0 = field_74516_a.iterator();

      while(var0.hasNext()) {
         KeyBinding var1 = (KeyBinding)var0.next();
         var1.func_74505_d();
      }

   }

   public static void func_74508_b() {
      field_74514_b.func_76046_c();
      Iterator var0 = field_74516_a.iterator();

      while(var0.hasNext()) {
         KeyBinding var1 = (KeyBinding)var0.next();
         field_74514_b.func_76038_a(var1.field_74512_d, var1);
      }

   }

   public KeyBinding(String p_i3003_1_, int p_i3003_2_) {
      this.field_74515_c = p_i3003_1_;
      this.field_74512_d = p_i3003_2_;
      field_74516_a.add(this);
      field_74514_b.func_76038_a(p_i3003_2_, this);
   }

   public boolean func_74509_c() {
      if(this.field_74511_f == 0) {
         return false;
      } else {
         --this.field_74511_f;
         return true;
      }
   }

   private void func_74505_d() {
      this.field_74511_f = 0;
      this.field_74513_e = false;
   }

}
