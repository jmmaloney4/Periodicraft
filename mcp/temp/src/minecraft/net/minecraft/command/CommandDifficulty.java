package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;

public class CommandDifficulty extends CommandBase {

   private static final String[] field_82365_a = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};


   public String func_71517_b() {
      return "difficulty";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.difficulty.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         int var3 = this.func_82364_d(p_71515_1_, p_71515_2_[0]);
         MinecraftServer.func_71276_C().func_71226_c(var3);
         String var4 = StatCollector.func_74838_a(field_82365_a[var3]);
         func_71522_a(p_71515_1_, "commands.difficulty.success", new Object[]{var4});
      } else {
         throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
      }
   }

   protected int func_82364_d(ICommandSender p_82364_1_, String p_82364_2_) {
      return !p_82364_2_.equalsIgnoreCase("peaceful") && !p_82364_2_.equalsIgnoreCase("p")?(!p_82364_2_.equalsIgnoreCase("easy") && !p_82364_2_.equalsIgnoreCase("e")?(!p_82364_2_.equalsIgnoreCase("normal") && !p_82364_2_.equalsIgnoreCase("n")?(!p_82364_2_.equalsIgnoreCase("hard") && !p_82364_2_.equalsIgnoreCase("h")?func_71532_a(p_82364_1_, p_82364_2_, 0, 3):3):2):1):0;
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }

}
