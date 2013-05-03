package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandServerList extends CommandBase {

   public String func_71517_b() {
      return "list";
   }

   public int func_82362_a() {
      return 0;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.players.list", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71233_x()), Integer.valueOf(MinecraftServer.func_71276_C().func_71275_y())}));
      p_71515_1_.func_70006_a(MinecraftServer.func_71276_C().func_71203_ab().func_72398_c());
   }
}
