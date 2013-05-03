package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class CommandServerPardon extends CommandBase {

   public String func_71517_b() {
      return "pardon";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.unban.usage", new Object[0]);
   }

   public boolean func_71519_b(ICommandSender p_71519_1_) {
      return MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73710_b() && super.func_71519_b(p_71519_1_);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
         MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73709_b(p_71515_2_[0]);
         func_71522_a(p_71515_1_, "commands.unban.success", new Object[]{p_71515_2_[0]});
      } else {
         throw new WrongUsageException("commands.unban.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71531_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73712_c().keySet()):null;
   }
}
