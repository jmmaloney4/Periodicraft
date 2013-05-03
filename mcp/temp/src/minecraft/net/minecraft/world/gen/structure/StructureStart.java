package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructureStart {

   protected LinkedList field_75075_a = new LinkedList();
   protected StructureBoundingBox field_75074_b;


   public StructureBoundingBox func_75071_a() {
      return this.field_75074_b;
   }

   public LinkedList func_75073_b() {
      return this.field_75075_a;
   }

   public void func_75068_a(World p_75068_1_, Random p_75068_2_, StructureBoundingBox p_75068_3_) {
      Iterator var4 = this.field_75075_a.iterator();

      while(var4.hasNext()) {
         StructureComponent var5 = (StructureComponent)var4.next();
         if(var5.func_74874_b().func_78884_a(p_75068_3_) && !var5.func_74875_a(p_75068_1_, p_75068_2_, p_75068_3_)) {
            var4.remove();
         }
      }

   }

   protected void func_75072_c() {
      this.field_75074_b = StructureBoundingBox.func_78887_a();
      Iterator var1 = this.field_75075_a.iterator();

      while(var1.hasNext()) {
         StructureComponent var2 = (StructureComponent)var1.next();
         this.field_75074_b.func_78888_b(var2.func_74874_b());
      }

   }

   protected void func_75067_a(World p_75067_1_, Random p_75067_2_, int p_75067_3_) {
      int var4 = 63 - p_75067_3_;
      int var5 = this.field_75074_b.func_78882_c() + 1;
      if(var5 < var4) {
         var5 += p_75067_2_.nextInt(var4 - var5);
      }

      int var6 = var5 - this.field_75074_b.field_78894_e;
      this.field_75074_b.func_78886_a(0, var6, 0);
      Iterator var7 = this.field_75075_a.iterator();

      while(var7.hasNext()) {
         StructureComponent var8 = (StructureComponent)var7.next();
         var8.func_74874_b().func_78886_a(0, var6, 0);
      }

   }

   protected void func_75070_a(World p_75070_1_, Random p_75070_2_, int p_75070_3_, int p_75070_4_) {
      int var5 = p_75070_4_ - p_75070_3_ + 1 - this.field_75074_b.func_78882_c();
      boolean var6 = true;
      int var10;
      if(var5 > 1) {
         var10 = p_75070_3_ + p_75070_2_.nextInt(var5);
      } else {
         var10 = p_75070_3_;
      }

      int var7 = var10 - this.field_75074_b.field_78895_b;
      this.field_75074_b.func_78886_a(0, var7, 0);
      Iterator var8 = this.field_75075_a.iterator();

      while(var8.hasNext()) {
         StructureComponent var9 = (StructureComponent)var8.next();
         var9.func_74874_b().func_78886_a(0, var7, 0);
      }

   }

   public boolean func_75069_d() {
      return true;
   }
}
