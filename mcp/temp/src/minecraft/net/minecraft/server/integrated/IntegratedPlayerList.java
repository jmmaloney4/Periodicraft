package net.minecraft.server.integrated;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.SocketAddress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.management.ServerConfigurationManager;

@SideOnly(Side.CLIENT)
public class IntegratedPlayerList extends ServerConfigurationManager {

   private NBTTagCompound field_72416_e = null;


   public IntegratedPlayerList(IntegratedServer p_i3125_1_) {
      super(p_i3125_1_);
      this.field_72402_d = 10;
   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      if(p_72391_1_.func_70005_c_().equals(this.func_72415_s().func_71214_G())) {
         this.field_72416_e = new NBTTagCompound();
         p_72391_1_.func_70109_d(this.field_72416_e);
      }

      super.func_72391_b(p_72391_1_);
   }

   public String func_72399_a(SocketAddress p_72399_1_, String p_72399_2_) {
      return p_72399_2_.equalsIgnoreCase(this.func_72415_s().func_71214_G())?"That name is already taken.":super.func_72399_a(p_72399_1_, p_72399_2_);
   }

   public IntegratedServer func_72415_s() {
      return (IntegratedServer)super.func_72365_p();
   }

   public NBTTagCompound func_72378_q() {
      return this.field_72416_e;
   }

   // $FF: synthetic method
   public MinecraftServer func_72365_p() {
      return this.func_72415_s();
   }
}
