package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySign extends TileEntity {

   public String[] field_70412_a = new String[]{"", "", "", ""};
   public int field_70410_b = -1;
   private boolean field_70411_c = true;


   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74778_a("Text1", this.field_70412_a[0]);
      p_70310_1_.func_74778_a("Text2", this.field_70412_a[1]);
      p_70310_1_.func_74778_a("Text3", this.field_70412_a[2]);
      p_70310_1_.func_74778_a("Text4", this.field_70412_a[3]);
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      this.field_70411_c = false;
      super.func_70307_a(p_70307_1_);

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_70412_a[var2] = p_70307_1_.func_74779_i("Text" + (var2 + 1));
         if(this.field_70412_a[var2].length() > 15) {
            this.field_70412_a[var2] = this.field_70412_a[var2].substring(0, 15);
         }
      }

   }

   public Packet func_70319_e() {
      String[] var1 = new String[4];
      System.arraycopy(this.field_70412_a, 0, var1, 0, 4);
      return new Packet130UpdateSign(this.field_70329_l, this.field_70330_m, this.field_70327_n, var1);
   }

   public boolean func_70409_a() {
      return this.field_70411_c;
   }

   @SideOnly(Side.CLIENT)
   public void func_70408_a(boolean p_70408_1_) {
      this.field_70411_c = p_70408_1_;
   }
}
