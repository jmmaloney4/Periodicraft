package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public final class ThreadShutdown extends Thread {

   public void run() {
      Minecraft.func_71363_D();
   }
}
