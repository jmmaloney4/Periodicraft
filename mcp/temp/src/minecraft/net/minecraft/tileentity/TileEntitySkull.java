package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySkull extends TileEntity {

   private int field_82123_a;
   private int field_82121_b;
   private String field_82122_c = "";


   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74774_a("SkullType", (byte)(this.field_82123_a & 255));
      p_70310_1_.func_74774_a("Rot", (byte)(this.field_82121_b & 255));
      p_70310_1_.func_74778_a("ExtraType", this.field_82122_c);
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_82123_a = p_70307_1_.func_74771_c("SkullType");
      this.field_82121_b = p_70307_1_.func_74771_c("Rot");
      if(p_70307_1_.func_74764_b("ExtraType")) {
         this.field_82122_c = p_70307_1_.func_74779_i("ExtraType");
      }

   }

   public Packet func_70319_e() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_70310_b(var1);
      return new Packet132TileEntityData(this.field_70329_l, this.field_70330_m, this.field_70327_n, 4, var1);
   }

   public void func_82118_a(int p_82118_1_, String p_82118_2_) {
      this.field_82123_a = p_82118_1_;
      this.field_82122_c = p_82118_2_;
   }

   public int func_82117_a() {
      return this.field_82123_a;
   }

   public void func_82116_a(int p_82116_1_) {
      this.field_82121_b = p_82116_1_;
   }

   @SideOnly(Side.CLIENT)
   public int func_82119_b() {
      return this.field_82121_b;
   }

   public String func_82120_c() {
      return this.field_82122_c;
   }
}
