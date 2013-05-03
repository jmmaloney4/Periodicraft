package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.structure.EnumDoor;

// $FF: synthetic class
class EnumDoorHelper {

   // $FF: synthetic field
   static final int[] field_75245_a = new int[EnumDoor.values().length];


   static {
      try {
         field_75245_a[EnumDoor.OPENING.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         field_75245_a[EnumDoor.WOOD_DOOR.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         field_75245_a[EnumDoor.GRATES.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         field_75245_a[EnumDoor.IRON_DOOR.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
