package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandServerSaveOff extends CommandBase {

   public String func_71517_b() {
      return "save-off";
   }

   public int func_82362_a() {
      return 4;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      MinecraftServer var3 = MinecraftServer.func_71276_C();

      for(int var4 = 0; var4 < var3.field_71305_c.length; ++var4) {
         if(var3.field_71305_c[var4] != null) {
            WorldServer var5 = var3.field_71305_c[var4];
            var5.field_73058_d = true;
         }
      }

      func_71522_a(p_71515_1_, "commands.save.disabled", new Object[0]);
   }
}
