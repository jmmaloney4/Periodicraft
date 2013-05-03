package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerStop extends CommandBase {

   public String func_71517_b() {
      return "stop";
   }

   public int func_82362_a() {
      return 4;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      func_71522_a(p_71515_1_, "commands.stop.start", new Object[0]);
      MinecraftServer.func_71276_C().func_71263_m();
   }
}
