package net.minecraft.scoreboard;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class ServerCommandTestFor extends CommandBase {

   public String func_71517_b() {
      return "testfor";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length != 1) {
         throw new WrongUsageException("commands.testfor.usage", new Object[0]);
      } else if(!(p_71515_1_ instanceof TileEntityCommandBlock)) {
         throw new CommandException("commands.testfor.failed", new Object[0]);
      } else {
         func_82359_c(p_71515_1_, p_71515_2_[0]);
      }
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
