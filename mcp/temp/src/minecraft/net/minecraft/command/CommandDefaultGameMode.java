package net.minecraft.command;

import net.minecraft.command.CommandGameMode;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumGameType;

public class CommandDefaultGameMode extends CommandGameMode {

   public String func_71517_b() {
      return "defaultgamemode";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.defaultgamemode.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         EnumGameType var3 = this.func_71539_b(p_71515_1_, p_71515_2_[0]);
         this.func_71541_a(var3);
         String var4 = StatCollector.func_74838_a("gameMode." + var3.func_77149_b());
         func_71522_a(p_71515_1_, "commands.defaultgamemode.success", new Object[]{var4});
      } else {
         throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
      }
   }

   protected void func_71541_a(EnumGameType p_71541_1_) {
      MinecraftServer.func_71276_C().func_71235_a(p_71541_1_);
   }
}
