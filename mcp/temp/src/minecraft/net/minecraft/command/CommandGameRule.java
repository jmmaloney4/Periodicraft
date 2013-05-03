package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;

public class CommandGameRule extends CommandBase {

   public String func_71517_b() {
      return "gamerule";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.gamerule.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      String var6;
      if(p_71515_2_.length == 2) {
         var6 = p_71515_2_[0];
         String var7 = p_71515_2_[1];
         GameRules var8 = this.func_82366_d();
         if(var8.func_82765_e(var6)) {
            var8.func_82764_b(var6, var7);
            func_71522_a(p_71515_1_, "commands.gamerule.success", new Object[0]);
         } else {
            func_71522_a(p_71515_1_, "commands.gamerule.norule", new Object[]{var6});
         }

      } else if(p_71515_2_.length == 1) {
         var6 = p_71515_2_[0];
         GameRules var4 = this.func_82366_d();
         if(var4.func_82765_e(var6)) {
            String var5 = var4.func_82767_a(var6);
            p_71515_1_.func_70006_a(var6 + " = " + var5);
         } else {
            func_71522_a(p_71515_1_, "commands.gamerule.norule", new Object[]{var6});
         }

      } else if(p_71515_2_.length == 0) {
         GameRules var3 = this.func_82366_d();
         p_71515_1_.func_70006_a(func_71527_a(var3.func_82763_b()));
      } else {
         throw new WrongUsageException("commands.gamerule.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_82366_d().func_82763_b()):(p_71516_2_.length == 2?func_71530_a(p_71516_2_, new String[]{"true", "false"}):null);
   }

   private GameRules func_82366_d() {
      return MinecraftServer.func_71276_C().func_71218_a(0).func_82736_K();
   }
}
