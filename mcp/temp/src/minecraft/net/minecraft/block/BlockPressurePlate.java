package net.minecraft.block;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockPressurePlate extends BlockBasePressurePlate {

   private EnumMobType field_72194_a;


   protected BlockPressurePlate(int p_i9080_1_, String p_i9080_2_, Material p_i9080_3_, EnumMobType p_i9080_4_) {
      super(p_i9080_1_, p_i9080_2_, p_i9080_3_);
      this.field_72194_a = p_i9080_4_;
   }

   protected int func_94355_d(int p_94355_1_) {
      return p_94355_1_ > 0?1:0;
   }

   protected int func_94350_c(int p_94350_1_) {
      return p_94350_1_ == 1?15:0;
   }

   protected int func_94351_d(World p_94351_1_, int p_94351_2_, int p_94351_3_, int p_94351_4_) {
      List var5 = null;
      if(this.field_72194_a == EnumMobType.everything) {
         var5 = p_94351_1_.func_72839_b((Entity)null, this.func_94352_a(p_94351_2_, p_94351_3_, p_94351_4_));
      }

      if(this.field_72194_a == EnumMobType.mobs) {
         var5 = p_94351_1_.func_72872_a(EntityLiving.class, this.func_94352_a(p_94351_2_, p_94351_3_, p_94351_4_));
      }

      if(this.field_72194_a == EnumMobType.players) {
         var5 = p_94351_1_.func_72872_a(EntityPlayer.class, this.func_94352_a(p_94351_2_, p_94351_3_, p_94351_4_));
      }

      if(!var5.isEmpty()) {
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            Entity var7 = (Entity)var6.next();
            if(!var7.func_82144_au()) {
               return 15;
            }
         }
      }

      return 0;
   }
}
