package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.WeightedRandomItem;

public class WeightedRandomMinecart extends WeightedRandomItem {

   public final NBTTagCompound field_98222_b;
   public final String field_98223_c;
   // $FF: synthetic field
   final MobSpawnerBaseLogic field_98221_d;


   public WeightedRandomMinecart(MobSpawnerBaseLogic p_i11041_1_, NBTTagCompound p_i11041_2_) {
      super(p_i11041_2_.func_74762_e("Weight"));
      this.field_98221_d = p_i11041_1_;
      NBTTagCompound var3 = p_i11041_2_.func_74775_l("Properties");
      String var4 = p_i11041_2_.func_74779_i("Type");
      if(var4.equals("Minecart")) {
         if(var3 != null) {
            switch(var3.func_74762_e("Type")) {
            case 0:
               var4 = "MinecartRideable";
               break;
            case 1:
               var4 = "MinecartChest";
               break;
            case 2:
               var4 = "MinecartFurnace";
            }
         } else {
            var4 = "MinecartRideable";
         }
      }

      this.field_98222_b = var3;
      this.field_98223_c = var4;
   }

   public WeightedRandomMinecart(MobSpawnerBaseLogic p_i11042_1_, NBTTagCompound p_i11042_2_, String p_i11042_3_) {
      super(1);
      this.field_98221_d = p_i11042_1_;
      if(p_i11042_3_.equals("Minecart")) {
         if(p_i11042_2_ != null) {
            switch(p_i11042_2_.func_74762_e("Type")) {
            case 0:
               p_i11042_3_ = "MinecartRideable";
               break;
            case 1:
               p_i11042_3_ = "MinecartChest";
               break;
            case 2:
               p_i11042_3_ = "MinecartFurnace";
            }
         } else {
            p_i11042_3_ = "MinecartRideable";
         }
      }

      this.field_98222_b = p_i11042_2_;
      this.field_98223_c = p_i11042_3_;
   }

   public NBTTagCompound func_98220_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_74766_a("Properties", this.field_98222_b);
      var1.func_74778_a("Type", this.field_98223_c);
      var1.func_74768_a("Weight", this.field_76292_a);
      return var1;
   }
}
