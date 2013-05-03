package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityNote extends TileEntity {

   public byte field_70416_a = 0;
   public boolean field_70415_b = false;


   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74774_a("note", this.field_70416_a);
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_70416_a = p_70307_1_.func_74771_c("note");
      if(this.field_70416_a < 0) {
         this.field_70416_a = 0;
      }

      if(this.field_70416_a > 24) {
         this.field_70416_a = 24;
      }

   }

   public void func_70413_a() {
      this.field_70416_a = (byte)((this.field_70416_a + 1) % 25);
      this.func_70296_d();
   }

   public void func_70414_a(World p_70414_1_, int p_70414_2_, int p_70414_3_, int p_70414_4_) {
      if(p_70414_1_.func_72803_f(p_70414_2_, p_70414_3_ + 1, p_70414_4_) == Material.field_76249_a) {
         Material var5 = p_70414_1_.func_72803_f(p_70414_2_, p_70414_3_ - 1, p_70414_4_);
         byte var6 = 0;
         if(var5 == Material.field_76246_e) {
            var6 = 1;
         }

         if(var5 == Material.field_76251_o) {
            var6 = 2;
         }

         if(var5 == Material.field_76264_q) {
            var6 = 3;
         }

         if(var5 == Material.field_76245_d) {
            var6 = 4;
         }

         p_70414_1_.func_72965_b(p_70414_2_, p_70414_3_, p_70414_4_, Block.field_71960_R.field_71990_ca, var6, this.field_70416_a);
      }
   }
}
